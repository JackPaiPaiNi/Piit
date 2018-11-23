package com.ey.piit.sdo.mdm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.AdEntity;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.repository.UserDao;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.service.WsAdService;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.vo.UserVo;
import com.ey.piit.sdo.mdm.repository.EmployeeDao;
import com.ey.piit.sdo.mdm.vo.EmployeeVo;

/**
 * 员工维护Service
 * 
 * @author 高文浩
 */
@Service
public class EmployeeService extends BaseService<EmployeeDao, EmployeeVo> {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private WsAdService wsAdService;
	
	@Value("${ad.onoff}")
	private String onoff;//AD域开关
	
	@Value("${ad.account}")
	private String adAccount;//AD域操作账号
	
	@Value("${ad.password}")
	private String adPassword;//AD域操作密码
	
	@Value("${ad.userpwd}")
	private String userPassword;//AD域操作密码

	public EmployeeVo findByXsyid(String loginAcct) {
		// TODO 自动生成的方法存根
		return employeeDao.selectByXsyid(loginAcct);
	}

	// 更新员工表的时候同步更新用户表信息
	@Transactional
	public int edit(EmployeeVo entity) {
		int flag = 0;
		UserVo userVo ;
		if (Oper.add.equals(entity.getOper())) {
			try{
			flag = super.save(entity);
			}catch(Exception e) {
				throw new ServiceException("新增失败：["+e.getMessage()+"]");
			}
			if("on".equals(onoff)){
				//AD域添加域账号
				if(!this.addUser(entity)){
					throw new ServiceException("AD域账号生成失败！");
				}	
			}	
		} else if (Oper.edit.equals(entity.getOper())) {
			userVo = this.getUserByEmpVo(entity);
			super.update(entity);
			flag = userDao.updateByEmpCode(userVo);
			//AD域体系
			if("on".equals(onoff)){	
				//1.AD域账号启用和禁用
				if("1".equals(entity.getStatus())){
					//1.启用AD域账号
					if(!activeUser(entity)){
						//启用失败 考虑是由于AD域不存在该账号
						throw new ServiceException("AD域启用失败，请检查AD域是否存在该账号："+entity.getLoginAcct()+"！");
					}else{
						//启用成功 账号可能存在部门调整 进行修改用户
						if(!this.modifyUser(entity)){	
							throw new ServiceException("AD域调整部门失败！");
						}
					}
				
				}else if("0".equals(entity.getStatus())){
					//禁用AD域账号
					if(!this.disableUser(entity)){
						throw new ServiceException("AD域禁用账号失败!");
					}
			
				}	
			
			}
		} 
		
		return flag;
	}
	
	/**
	 * 启用或禁用
	 * @param entity
	 */
	public void activeOrDisable(EmployeeVo entity){
		UserVo userVo = this.getUserByEmpVo(entity);
		super.update(entity);
		userDao.updateByEmpCode(userVo);
		if("on".equals(onoff)){	
			//1.AD域账号启用和禁用
			if("1".equals(entity.getStatus())){
				//1.启用AD域账号
				if(!activeUser(entity)){
					throw new ServiceException("AD域启用失败！");
				}
			}else if("0".equals(entity.getStatus())){
				//禁用AD域账号
				if(!this.disableUser(entity)){
					throw new ServiceException("AD域禁用账号失败!");
				}
		
			}	
		
		}
	}
	
	/**
	 * 批量刷域账号
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void batchRefreshAd(){
		if("on".equals(onoff)){	
			Map<String,Object> param=new HashMap<String,Object>();
			employeeDao.selectAdInfo(param);
			List<EmployeeVo> list = (List<EmployeeVo>) param.get("list");
			Map<String,Object> setParam=new HashMap<String,Object>();
			for(EmployeeVo vo : list){
				setParam.put("loginAcct", vo.getLoginAcct());
				//添加域账号
				if(!this.addUser(vo)){
					setParam.put("adzt", "0");
					employeeDao.updateAdInfo(setParam);//刷AD失败
				}else{
					setParam.put("adzt", "1");
					employeeDao.updateAdInfo(setParam);//刷AD成功
				}
			}
		}
	}

	public UserVo getUserByEmpVo(EmployeeVo entity) {
		EmployeeVo employeeVo = employeeDao.selectById(entity.getId());
		UserVo userVo = new UserVo();
		userVo.setLoginAcct(entity.getLoginAcct());
		userVo.setStatus(entity.getStatus());
		userVo.setUserName(entity.getName());
		userVo.setEmpCode(entity.getEmpCode());
		userVo.setOldEmpCode(employeeVo.getEmpCode());
		userVo.setCompCode(entity.getDeptCode());
		userVo.setEmail(entity.getEmail());
		userVo.setDescription(entity.getDescription());
		userVo.setLastUpdater(UserUtils.getUser().getUserName());
		userVo.setLastUpdateTime(new Date());
		return userVo;
	}
	
	/**
	 * AD域增加域账号
	 * @return
	 */
	public boolean addUser(EmployeeVo vo){
		boolean result = false;
		EmployeeVo employeeVo = employeeDao.selectAdInfoById(vo.getLoginAcct());
		if(employeeVo!=null){
			AdEntity adentity=new AdEntity();
			adentity.setAdzh(adAccount);//AD域操作账号
			adentity.setPwd(adPassword);//AD域操作密码
			adentity.setCn(employeeVo.getName());//员工姓名
			adentity.setSn(employeeVo.getName());//员工姓名
			String name=employeeVo.getName();
			adentity.setGivenname(name.substring(1,name.length()));//名字
			String deptOu=employeeVo.getDeptName();
			adentity.setDepartment(deptOu);//当前部门格式如: "OU=test1,OU=中国区域营销总部,OU=创维集团,"
			adentity.setDisplayname(name);
			adentity.setMail(employeeVo.getEmail());
			adentity.setFrem(employeeVo.getLoginAcct());
			adentity.setUserprincipalname(employeeVo.getLoginAcct()+"@skyworth.com");
			adentity.setPassword(userPassword);
			adentity.setExtensionattribute1("SY");//邮箱存储位置 ，默认石岩  SY
			adentity.setDescribe("SDO系统员工新增同步生成");
			String _tzou=deptOu.substring(0, deptOu.length()-1).replace("OU=", "");
			String[] forgs =_tzou.split(",");
			String[] _forgs=new String[forgs.length-1];
			for(int i=0;i<forgs.length-1;i++){
				_forgs[i]=forgs[i];
			}
			adentity.setParent("OU="+forgs[forgs.length-1]+",");
			adentity.setForgs(_forgs);
			try {
				String msg = wsAdService.addUser(adentity);
				if("true".equals(msg)){
					result = true;
				}
			} catch (Exception e) {
				throw new ServiceException("调用AD域账号生成接口失败!");
			}	
		}	
		return result;
	}
	
	/**
	 * AD域调整域账号
	 * @return
	 */
	public boolean modifyUser(EmployeeVo vo){
		boolean result = false;
		EmployeeVo employeeVo = employeeDao.selectAdInfoById(vo.getLoginAcct());
		if(employeeVo!=null){
			AdEntity adentity=new AdEntity();
			adentity.setAdzh(adAccount);//AD域操作账号
			adentity.setPwd(adPassword);//AD域操作密码
			adentity.setCn(employeeVo.getName());//员工姓名
			adentity.setSn(employeeVo.getName());//员工姓名
			String name=employeeVo.getName();
			adentity.setGivenname(name.substring(1,name.length()));//名字
			String deptOu=employeeVo.getDeptName();
			adentity.setDepartment(deptOu);//当前部门格式如: "OU=test1,OU=中国区域营销总部,OU=创维集团,"
			adentity.setDisplayname(name);
			adentity.setMail(employeeVo.getEmail());
			adentity.setFrem(employeeVo.getLoginAcct());
			adentity.setUserprincipalname(employeeVo.getLoginAcct()+"@skyworth.com");
			adentity.setPassword(userPassword);
			adentity.setExtensionattribute1("SY");//邮箱存储位置 ，默认石岩  SY
			adentity.setDescribe("SDO系统员工新增同步生成");
			if("1".equals(vo.getStatus())){
				adentity.setZt("512");//启用
			}else{
				adentity.setZt("514");//禁用
			}
			String _tzou=deptOu.substring(0, deptOu.length()-1).replace("OU=", "");
			String[] forgs =_tzou.split(",");
			String[] _forgs=new String[forgs.length-1];
			for(int i=0;i<forgs.length-1;i++){
				_forgs[i]=forgs[i];
			}
			adentity.setParent("OU="+forgs[forgs.length-1]+",");
			adentity.setForgs(_forgs);
			try {
				String msg = wsAdService.modifyUser(adentity);
				if("true".equals(msg)){
					result = true;
				}
			} catch (Exception e) {
				throw new ServiceException("AD域调整部门失败!");
			}	
		}	
		return result;
	}
	
	/**
	 * 禁用域账号
	 * @return
	 */
	public boolean disableUser(EmployeeVo vo){
		boolean result = false;
		try {
			String msg = wsAdService.disableUser(vo.getLoginAcct());
			if("true".equals(msg)){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return result;
	}
	
	/**
	 * 启用域账号
	 * @return
	 */
	public boolean activeUser(EmployeeVo vo){
		boolean result = false;
		try {
			String msg = wsAdService.activeUser(vo.getLoginAcct());
			if("true".equals(msg)){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return result;
	}
	
	/**
	 * AD域增加域账号 test方法
	 * @return
	 */
	public boolean addUserTest(EmployeeVo vo){
		boolean result = false;
			AdEntity adentity=new AdEntity();
			adentity.setAdzh("hwvpn@skyworth.com");//AD域操作账号
			adentity.setPwd("YU*^Kyrtu7<");//AD域操作密码
			adentity.setCn("邓海test");//员工姓名
			adentity.setSn("邓海test");//员工姓名
			String name="邓海test";
			adentity.setGivenname("海test");//名字
			String deptOu="OU=东芝商务组,OU=东芝业务部,OU=RGB海外营销总部,OU=创维集团,";
			adentity.setDepartment(deptOu);//当前部门格式如: "OU=test1,OU=中国区域营销总部,OU=创维集团,"
			adentity.setDisplayname(name);
			adentity.setMail("SDO001@skyworth.com");
			adentity.setFrem("SDO001");
			adentity.setUserprincipalname("SDO001@skyworth.com");
			adentity.setPassword(userPassword);
			adentity.setExtensionattribute1("SY");//邮箱存储位置 ，默认石岩  SY
			adentity.setDescribe("SDO系统员工新增同步生成");
			String _tzou=deptOu.substring(0, deptOu.length()-1).replace("OU=", "");
			String[] forgs =_tzou.split(",");
			String[] _forgs=new String[forgs.length-1];
			for(int i=0;i<forgs.length-1;i++){
				_forgs[i]=forgs[i];
			}
			adentity.setParent("OU="+forgs[forgs.length-1]+",");
			adentity.setForgs(_forgs);
			try {
				String msg = wsAdService.addUser(adentity);
				if("true".equals(msg)){
					result = true;
				}
			} catch (Exception e) {
				throw new ServiceException("调用AD域账号生成接口失败!");
			}	
	
		return result;
	}

}