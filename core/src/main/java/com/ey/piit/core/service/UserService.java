/*
 * UserService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.entity.CoreEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.UserDao;
import com.ey.piit.core.utils.SelectUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.EmpVo;
import com.ey.piit.core.vo.UserVo;

/**
 * T_USER
 * 用户
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@Service
public class UserService extends CoreService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserRoleService userRoleService;
    
    //@Autowired
    //private UserOrgService userOrgService;
    
    //@Autowired
    //private OrganizationService organizationService;
    
    @Autowired
    private SequenceService sequenceService;
    
    @Autowired
    private PasswordHelper passwordHelper;
    
    @Autowired
	private IdentityService identityService;
    
	@Autowired
	private WsAdService wsAdService;//域账号处理服务类
	
	@Value("${ad.onoff}")
	private String onoff;//AD域开关
    
    private static Map<String, String> userNameMap = new HashMap<String, String>();
    
    @Override
    protected int save(CoreEntity record) {
    	UserVo user = (UserVo)record;
    	
    	if (Constants.USER_TYPE_EXTERNAL.equals(user.getType())) {
    		
    		//外部员工号
    		String empCode = sequenceService.findNextSequence("E", Constants.SEQUENCE_NAME_EXTERNAL_USER_EMP_CODE);
    		user.setEmpCode(empCode);
		}
    	if("on".equals(onoff)){
    		//重置AD域密码
    		if (StringUtils.isNotBlank(user.getPassword())) {
	    		if(!changPwd(user)){
	    			throw new ServiceException("AD域重置密码失败！");
	    		}
    		}
    	}	
    	saveActivitiUser(user.getEmpCode(),user.getUserName(),user.getPassword());
    	
    	
    	passwordHelper.encryptPassword(user);
    	
    	int result = super.save(user);
    	
    	Map<String, String> roleMap = SelectUtils.filterRepeat(user.getRoles());
		userRoleService.editUser(user.getId(),roleMap);
		
		//List<UserOrgVo> userOrgList = userOrgService.filterRepeat(user.getOrgs());
		//userOrgService.editUser(user.getId(),userOrgList);
		
    	return result;
    }
    
    @Override
    protected int update(CoreEntity record) {
    	UserVo user = (UserVo)record;
    	
    	if (StringUtils.isNotBlank(user.getPassword())) {
    		if("on".equals(onoff)){
	    		//重置AD域密码
	    		if(!changPwd(user)){
	    			throw new ServiceException("AD域重置密码失败！");
	    		}
    		}
    		passwordHelper.encryptPassword(user);
		}
    	
    	int result = super.update(user);
    	
    	Map<String, String> roleMap = SelectUtils.filterRepeat(user.getRoles());
		userRoleService.editUser(user.getId(),roleMap);
		
		//List<UserOrgVo> userOrgList = userOrgService.filterRepeat(user.getOrgs());
		//userOrgService.editUser(user.getId(),userOrgList);
    	return result;
    }
    
    @Override
    protected int delete(CoreEntity record) {
    	int result = super.delete(record);
    	String[] ids = record.getId().split(",");
		for (int i = 0; i < ids.length; i++) {
			userRoleService.deleteByUserId(ids[i]);
		}
    	return result;
    }
    
    public UserVo findById(String id) {
    	UserVo userVo = userDao.selectById(id);
    	//List<OrganizationVo> orgList = organizationService.queryByUserId(id);
    	//userVo.setOrgShow(orgList);
        return userVo;
    }
    
    /**
     * 重置AD域账号密码
     * @param params
     * @param page
     * @return
     */
	public boolean changPwd(UserVo vo){
		boolean result = false;
		try {
			String msg = wsAdService.changePwd(vo.getLoginAcct(), vo.getPassword());
			if("true".equals(msg)){
				result = true;
			}
		} catch (Exception e) {
			throw new ServiceException("调用AD域重置密码接口失败!");
		}	
		return result;
	}

    public List<UserVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return userDao.selectByPage(params, page);
    }
    
    public UserVo findByLoginAcct(String loginAcct){
    	return userDao.selectByLoginAcct(loginAcct);
    }
    
    public List<UserVo> queryByRoleId(String id){
    	return userDao.selectByRoleId(id);
    }
    
    public List<UserVo> queryByRoleCode(String roleCode){
    	return userDao.selectByRoleCode(roleCode);
    }
    
    public String userListToHtml(List<UserVo> userList){
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < userList.size(); i++) {
			UserVo user = userList.get(i);
			sb.append("<option value=\"");
			sb.append(user.getId());
			sb.append("\">");
			sb.append(user.getUserName());
			sb.append("</option>");
		}
    	return sb.toString();
    }
    
    @Override
    protected ICoreDao getDao() {
        return userDao;
    }

	@Override
	public void validate(CoreEntity record) {
		UserVo user = (UserVo)record;
		if (StringUtils.isBlank(user.getLoginAcct())) {
			throw new ValidateException("账号不能为空");
		}
		if (Oper.add.equals(user.getOper()) && StringUtils.isBlank(user.getPassword())) {
			throw new ValidateException("密码不能为空");
		}
		if (StringUtils.isBlank(user.getUserName())) {
			throw new ValidateException("用户名不能为空");
		}
		if (StringUtils.isBlank(user.getCompCode())) {
			throw new ValidateException("所属组织不能为空");
		}
		if (StringUtils.isBlank(user.getEmail())) {
			throw new ValidateException("邮箱不能为空");
		}
		if (StringUtils.isBlank(user.getStatus())) {
			throw new ValidateException("状态不能为空");
		}
		if (StringUtils.isBlank(user.getType())) {
			throw new ValidateException("类型不能为空");
		}
//		if (Constants.USER_TYPE_INTERNAL.equals(user.getType())) {
//		} else if (Constants.USER_TYPE_EXTERNAL.equals(user.getType())) {
//			if (!user.getLoginAcct().startsWith(Constants.EXTERNAL_USER_ACCT_PREFIX)) {
//				throw new ValidateException("外部用户账号必须以"+Constants.EXTERNAL_USER_ACCT_PREFIX+"前缀开头");
//			}
//		} else {
//			throw new ValidateException("用户类型错误");
//		}
	}
	
	public String findNameByEmpCode(String empCode) {
		String userName = userNameMap.get(empCode);
		if (userName != null) {
			return userName;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("empCode", empCode);
		List<UserVo> list = userDao.selectByPage(params);
		if (list != null && list.size() > 0) {
			userName = list.get(0).getUserName();
			userNameMap.put(empCode, userName);
			return userName;
		}
        return "";
    }
	
	/**
	 * 修改缺省角色
	 * @param roleCode
	 */
	public void changeRole(String roleCode){
		User user = findCurUser();
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setDefautRole(roleCode);
		userDao.updateById(newUser);
		
		//修改session
		user.setDefautRole(roleCode);
		Subject currentUser = SecurityUtils.getSubject();
    	Session session = currentUser.getSession();
    	session.setAttribute(Constants.CURRENT_USER, user);
	}
	
	public EmpVo findEmployeeByEmpCode(String empCode){
    	return userDao.selectEmployeeByEmpCode(empCode);
    }
	
	private void saveActivitiUser(String userId,String userName,String password){
		org.activiti.engine.identity.User user = identityService.newUser(userId);
		user.setFirstName(userName);
		user.setLastName(" ");
		user.setPassword(password);
		identityService.saveUser(user);
	}
	
	//重置密码
	public int  resetPswd(UserVo vo){
		String newPassword=vo.getPassword();
		UserVo u1 = new  UserVo() ;
		u1.setPassword(vo.getOldPassword());
		passwordHelper.encryptPassword(u1);
		UserVo u2 = userDao.selectByLoginAcct(vo.getLoginAcct());
		if(!u1.getPassword().equals(u2.getPassword())){
			throw new ServiceException("旧密码不正确!");
		}
		passwordHelper.encryptPassword(vo);
		int result = userDao.updatePswdByEmpcode(vo) ;
		if("on".equals(onoff)){
			//同步修改AD域密码
			vo.setPassword(newPassword);
			this.changPwd(vo);
		}
		return result;
	}
}