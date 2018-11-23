package com.ey.piit.sdo.fcst.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.pidbom.dto.PidBomRequest;
import com.ey.piit.interfaces.pidbom.dto.PidBomResponse;
import com.ey.piit.interfaces.pidbom.service.PidBomInterfaceService;
import com.ey.piit.sdo.fcst.repository.FcstDataDao;
import com.ey.piit.sdo.fcst.vo.FcstDataTitleVo;
import com.ey.piit.sdo.fcst.vo.FcstDataVo;
import com.ey.piit.sdo.fcst.vo.FcstNoticeVo;
import com.ey.piit.sdo.fcst.vo.FcstPidVo;
import com.ey.piit.sdo.fcst.vo.TmpApproveFcstDataVo;
import com.ey.piit.sdo.fcst.vo.TmpFcstDataVo;
import com.ey.piit.sdo.mdm.vo.PidInfoVo;

import net.sf.json.JSONArray;
/**
 * 采购FCST填报Service
 * @author 邓海
 */	
@Service
public class FcstDataService extends BaseService<FcstDataDao, FcstDataVo> {
	@Autowired
	private FcstDataDao dao;

	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private PidBomInterfaceService pidBomInterfaceService;
	@Autowired
	private FcstNoticeService fcstNoticeService;
	@SuppressWarnings("unchecked")
	public Object callSelectByPage(TmpFcstDataVo vo, PageBounds page){
		if("".equals(vo.getZc())){
			throw new ServiceException("当前周次不能为空！");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		if(StringUtils.isEmpty(vo.getXsyid())){
			vo.setXsyid(user.getLoginAcct());
		}
		param.put("sfxsy", UserUtils.isXys());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<TmpFcstDataVo> list = (List<TmpFcstDataVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public Object callSelectApproveByPage(TmpFcstDataVo vo, PageBounds page){
		if("".equals(vo.getZc())){
			throw new ServiceException("当前周次不能为空！");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectApproveFcst(param);
		List<TmpFcstDataVo> list = (List<TmpFcstDataVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	// 根据PID同步SAP生产研发BOM
	@Transactional
	public void snycPpxxBom(String pid) {
		PidBomRequest pidBomRequest = new PidBomRequest();
		//工厂，先写死，后期要调
		pidBomRequest.setGc("1107");
		pidBomRequest.setPid(pid);
		try {
			List<PidBomResponse> respList = pidBomInterfaceService.qryPpxxFromSap(pidBomRequest);
			for (PidBomResponse pidBom : respList) {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("pid", pidBom.getPid());
				param.put("ppxx", pidBom.getWlbh());
				dao.saveOrUpdate(param);
				this.callAfter(param);
				break;
			}
		} catch (Exception e) {
			throw new ServiceException("同步PID研发BOM出错");
		}
	}
	@SuppressWarnings("unchecked")
	public Object callSelectFcstByPage(TmpFcstDataVo vo, PageBounds page){
		if("".equals(vo.getKszc())){
			throw new ServiceException("走货开始周次不能为空！");
		}
		if("".equals(vo.getJszc())){
			throw new ServiceException("走货结束周次不能为空！");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		if(UserUtils.isXys()==1  && StringUtils.isEmpty(vo.getXsyid())){
			vo.setXsyid(user.getLoginAcct());
		}
		
		param.put("sfxsy", UserUtils.isXys());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectFcst(param);
		List<TmpFcstDataVo> list = (List<TmpFcstDataVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}	
	@SuppressWarnings("unchecked")
	public Object callSelectFcst(TmpFcstDataVo vo){
		if("".equals(vo.getKszc())){
			throw new ServiceException("走货开始周次不能为空！");
		}
		if("".equals(vo.getJszc())){
			throw new ServiceException("走货结束周次不能为空！");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		if(StringUtils.isEmpty(vo.getXsyid())){
			vo.setXsyid(user.getLoginAcct());
		}
		param.put("sfxsy", UserUtils.isXys());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		dao.callSelectFcst(param);
		List<TmpFcstDataVo> list = (List<TmpFcstDataVo>) param.get("list");
    	return list;
	}
	@SuppressWarnings("unchecked")
	public Object callSelectOrderFcst(String jhrq,String pid,String khbm,String xsyid){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jhrq", jhrq);
		param.put("pid", pid);
		param.put("khbm", khbm);
		param.put("xsyid", xsyid);
		dao.callSelectOrderFcst(param);
		List<TmpFcstDataVo> list = (List<TmpFcstDataVo>) param.get("list");
    	return list;
	}	
	
	
	public Object searchPid(String pid,PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pid", pid);
		param.put("page", page);
		dao.callSelectPid(param);
		List<FcstPidVo> list = (List<FcstPidVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(FcstDataVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		if(StringUtils.isEmpty(vo.getXsyid())){
			vo.setXsyid(user.getLoginAcct());
		}
		param.put("sfxsy", UserUtils.isXys());
		param.put("vo", vo);
		param.put("page", page);
		dao.callQuery(param);
		List<FcstDataVo> list = (List<FcstDataVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(TmpFcstDataVo vo){
		if("".equals(vo.getZc())){
			throw new ServiceException("当前周次不能为空！");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		if(StringUtils.isEmpty(vo.getXsyid())){
			vo.setXsyid(user.getLoginAcct());
		}
		param.put("sfxsy", UserUtils.isXys());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		dao.callSelect(param);
		List<TmpFcstDataVo> list = (List<TmpFcstDataVo>) param.get("list");
		return list;
	}
	@SuppressWarnings("unchecked")
	public Object callSelectApprove(TmpFcstDataVo vo){
		if("".equals(vo.getZc())){
			throw new ServiceException("当前周次不能为空！");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectApproveFcst(param);
		List<TmpFcstDataVo> list = (List<TmpFcstDataVo>) param.get("list");
		return list;
	}
	@SuppressWarnings("unchecked")
	public Object callQueryByApprove(TmpFcstDataVo vo){
		if("".equals(vo.getZc())){
			throw new ServiceException("当前周次不能为空！");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectApprove(param);
		List<TmpFcstDataVo> list = (List<TmpFcstDataVo>) param.get("list");
		return list;
	}
	/**
	 * 根据当前周次获取FCST公告
	 * @param zc
	 * @return
	 */
	public Object getFcstDqznr(){
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		param.put("xsyid", user.getLoginAcct());
		dao.callQueryDqznr(param);
		return param;
		
	}
	/**
	 * 查询FCST态列
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectFcstTitles(String kszc,String jszc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("kszc", kszc);
		param.put("jszc", jszc);
		dao.callSelectFcstTitles(param);
		//动态列名共用了实体对象
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		return map;
	}		
	/**
	 * 
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object  callQueryTitles(String zc){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("zc", zc);
		dao.callSelectTitles(param);
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		return map;
	}
	/**
	 * 
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object  callQueryOrderFcstTitles(String jhrq){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jhrq", jhrq);
		dao.callSelectOrderFcstTitles(param);
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		return map;
	}	
	/**
	 * 
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object  callQueryApproveTitles(String zc){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("zc", zc);
		dao.callSelectApproveTitles(param);
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		return map;
	}
	
	/**
	 * 根据当前周次获取FCST公告
	 * @param zc
	 * @return
	 */
	public String getFcstNotice(String zc){
		String notice="";
		FcstNoticeVo vo=new FcstNoticeVo();
		vo.setZc(zc);
		List<FcstNoticeVo> list=fcstNoticeService.queryByParam(vo);
		if(list.size()>0){
			vo=list.get(0);
			notice=vo.getNr();
		}
		return notice;
		
	}
	
	//保存明细
	@SuppressWarnings("unchecked")
	@Transactional
	public void editFcstData(FcstDataVo vo) {
		//保存页面数据到临时表
		JSONArray array = JSONArray.fromObject(vo.getItemListStr());
		List<TmpFcstDataVo> list = ((List<TmpFcstDataVo>) JSONArray.toCollection(array, TmpFcstDataVo.class));	
		//保存前需循环检查PID是否激活，未激活不允许保存
		String errorPid = ""; 
		//常规录入时需检查，lrfs=1，特殊录入=2不检查
		if("1".equals(vo.getLrfs())){
			PidBomRequest pidBomRequest = new PidBomRequest();
			//工厂，下单写1107，FCST写1104
			pidBomRequest.setGc("1104");
			for(int i=0;i<list.size();i++){
				boolean flag = false;
				TmpFcstDataVo tmpVo=list.get(i);
				//如果 当前详情是组件号 则跳过不检查
				if(tmpVo.getPid()==null||tmpVo.getPid().startsWith("OMC-")){
					continue;
				}
//				if("1".equals(tmpVo.getIszjh())){
//					continue;
//				}
				pidBomRequest.setPid(tmpVo.getPid());
				try {
					flag = pidBomInterfaceService.qryPidSfsxFromSap(pidBomRequest);
				} catch (Exception e) {
					throw new ServiceException("检查PID是否激活出错!");
				}
				if(flag == false){
					errorPid += tmpVo.getPid() + ",";
				}
			}
		}
		if("".equals(errorPid)){
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS"); 
			String sjc = sdFormat.format(new Date()); 
			for(int i=0;i<list.size();i++){
				TmpFcstDataVo tmpVo=list.get(i);	  
				tmpVo.setZc(vo.getZc());
				tmpVo.setSjc(sjc);
				tmpVo.setLrfs(vo.getLrfs());
		        itemCallBefore(tmpVo);
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("vo", tmpVo);
				param.put("lx", "1");
				dao.callInsert(param);
				this.callAfter(param);
			}
			//将临时表数据列转行到 正式表
			Map<String, Object> paramZs = new HashMap<String, Object>();
			paramZs.put("sjc", sjc);
			dao.callSave(paramZs);
			this.callAfter(paramZs);
		}else{
			throw new ServiceException("PID(" + errorPid + ")未激活（需在工厂1104激活），不允许提交！");
		}
	}
	//当周终稿
	@Transactional
	public void editDzzg(String zc) {
		//保存页面数据到临时表
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS"); 
		String sjc = sdFormat.format(new Date()); 
		//将临时表数据列转行到 正式表
		Map<String, Object> param = new HashMap<String, Object>();
		FcstDataVo vo=new FcstDataVo();	  
		vo.setZc(zc);
		vo.setSjc(sjc);
        this.callBefore(vo);
        param.put("vo", vo);
		dao.callSaveDzzg(param);
		this.callAfter(param);
	}
	
    //导入
	@Transactional
	public void importFcstData(List<TmpFcstDataVo> list,Integer sfzg,String lrfs) {
		//导入数据到临时表
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS"); 
		String sjc = sdFormat.format(new Date()); 
		for(int i=0;i<list.size();i++){
			TmpFcstDataVo tmpVo=list.get(i);	  
			tmpVo.setZc("W0000");//导入的 当前周次由后台取出，默认传入W0000格式到后台
			tmpVo.setSjc(sjc);
			tmpVo.setLrfs(lrfs);
	        itemCallBefore(tmpVo);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", tmpVo);
			param.put("lx", "2");
			dao.callInsert(param);
			this.callAfter(param);
		}
		//将临时表数据列转行到 正式表
		Map<String, Object> paramZs = new HashMap<String, Object>();
		paramZs.put("sjc", sjc);
		paramZs.put("sfzg", sfzg);//是否终审 0否 1是
		dao.callSave(paramZs);
		this.callAfter(paramZs);
	}
	
    //导入
	@Transactional
	public void importFcstApproveData(List<TmpApproveFcstDataVo> list) {
		//导入数据到临时表
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS"); 
		String sjc = sdFormat.format(new Date()); 
		for(int i=0;i<list.size();i++){
			TmpApproveFcstDataVo tmpVo=list.get(i);	  
			tmpVo.setZc("W0000");//导入的 当前周次由后台取出，默认传入W0000格式到后台
			tmpVo.setSjc(sjc);
	        approveItemCallBefore(tmpVo);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", tmpVo);
			dao.callInsertApprove(param);
			this.callAfter(param);
		}
		//将临时表数据列转行到 正式表
		Map<String, Object> paramZs = new HashMap<String, Object>();
		paramZs.put("sjc", sjc);
		dao.callSaveApprove(paramZs);
		this.callAfter(paramZs);
	}

	@Transactional
	public void deletesFcstData(List<FcstDataVo> list){
		for (FcstDataVo vo : list) {
			this.callBefore(vo);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", vo);
			dao.callDelete(param);
			callAfter(param);
		}
	}
	/**
	 * 移除FCST填报数据
	 * @param vo
	 */
	@Transactional
	public void removeFcstData(List<FcstDataVo> list){
		for (FcstDataVo vo : list) {
			this.callBefore(vo);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("xsyid",UserUtils.getUser().getLoginAcct());
			param.put("vo", vo);
			dao.callRemove(param);
			callAfter(param);
		}
	}	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(FcstDataVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 临时表操作全部为新增
	 * @param vo
	 */
	private void itemCallBefore(TmpFcstDataVo vo) {
		vo.preInsert();
		User user = UserUtils.getUser();
		vo.setXsyid(user.getLoginAcct());
		vo.setXsymc(user.getUserName());
		vo.setXszz(user.getDeptCode());
		vo.setYwz(user.getGroupCode());
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	/**
	 * 调用存储过程操作数据前
	 * 临时表操作全部为新增
	 * @param vo
	 */
	private void approveItemCallBefore(TmpApproveFcstDataVo vo) {
		vo.preInsert();
		User user = UserUtils.getUser();
		vo.setXsyid(user.getLoginAcct());
		vo.setXsymc(user.getUserName());
		vo.setXszz(user.getDeptCode());
		vo.setYwz(user.getGroupCode());
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	/**
	 * 调用存储过程后判断操作是否成功
	 * @param param
	 */
	private void callAfter(Map<String, Object> param){
		if(!"SDO-000000".equals(param.get("resultCode").toString())){
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
	/**
	 * 转换工具方法
	 * @param list
	 * @return
	 */
	public  List<Map<String, String>> convertList(List<FcstDataTitleVo> list)  {
		List<Map<String, String>> titleList=new ArrayList<Map<String, String>>();
		for(int i=0;i<list.size();i++){
			FcstDataTitleVo titileVo=list.get(i);
			Map<String,String> rowMap = new HashMap<String,String>();
			rowMap.put("week", titileVo.getWeek());	
			rowMap.put("month", titileVo.getMonth());	
			rowMap.put("day", titileVo.getDay());	
			rowMap.put("editable", titileVo.getEditable());	
			rowMap.put("flag", titileVo.getFlag());	
			rowMap.put("colspan", titileVo.getColspan());	
			rowMap.put("colname", titileVo.getColname());	
			titleList.add(rowMap);
		}
		return titleList;
	}

	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, TmpFcstDataVo vo){
		try {
			List<TmpFcstDataVo> list = (List<TmpFcstDataVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void exportApproveFcst(HttpServletResponse response, Map<String, Object> params, TmpFcstDataVo vo){
		try {
			List<TmpFcstDataVo> list = (List<TmpFcstDataVo>)this.callSelectApprove(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void exportFcst(HttpServletResponse response, Map<String, Object> params, TmpFcstDataVo vo){
		try {
			List<TmpFcstDataVo> list = (List<TmpFcstDataVo>)this.callSelectFcst(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void exportApprove(HttpServletResponse response, Map<String, Object> params, TmpFcstDataVo vo){
		try {
			List<TmpFcstDataVo> list = (List<TmpFcstDataVo>)this.callQueryByApprove(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
}