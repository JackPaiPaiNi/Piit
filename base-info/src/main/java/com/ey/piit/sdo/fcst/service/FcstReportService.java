package com.ey.piit.sdo.fcst.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.fcst.repository.FcstReportDao;
import com.ey.piit.sdo.fcst.vo.FcstDataTitleVo;
import com.ey.piit.sdo.fcst.vo.FcstDataVo;
import com.ey.piit.sdo.fcst.vo.FcstReportApproveHistoryVo;
import com.ey.piit.sdo.fcst.vo.FcstReportDemandSummaryVo;
import com.ey.piit.sdo.fcst.vo.FcstReportExactRateVo;
import com.ey.piit.sdo.fcst.vo.FcstReportMovementAnalysisVo;
import com.ey.piit.sdo.fcst.vo.FcstReportReachRateVo;
import com.ey.piit.sdo.mdm.service.EmployeeService;
import com.ey.piit.sdo.mdm.vo.EmployeeVo;
/**
 * 采购FCST填报Service
 * @author 邓海
 */
@Service
public class FcstReportService extends BaseService<FcstReportDao, FcstReportExactRateVo> {
	@Autowired
	private FcstReportDao dao;

	@Autowired
	private ExportUtil exportUtil;
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 查询FCST准确率汇总
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectExactRateByPage(FcstReportExactRateVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		if("0".equals(vo.getLevel())){
			//根据销售组织查准确率
			dao.callSelectExactRateByXszz(param);
		}else if("1".equals(vo.getLevel())){
			//根据销售组织查准确率
			dao.callSelectExactRateByXszzDetail(param);
		}else if("2".equals(vo.getLevel())){
			//根据销售员查询准确率
			dao.callSelectExactRateByXsyid(param);
		}else if("3".equals(vo.getLevel())){
			//根据销售员查询准确率
			dao.callSelectExactRateByXsyidDetail(param);
		}else if("4".equals(vo.getLevel())){
			//根据业务组查询准确率
			dao.callSelectExactRateByYwz(param);
		}else if("5".equals(vo.getLevel())){
			//根据业务组查询准确率
			dao.callSelectExactRateByYwzDetail(param);
		}
		List<FcstReportExactRateVo> list = (List<FcstReportExactRateVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 查询FCST准确率明细
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectExactRateDetailByPage(FcstReportExactRateVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectExactRateDetail(param);
		List<FcstReportExactRateVo> list = (List<FcstReportExactRateVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 查询FCST准确率
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectExactRate(FcstReportExactRateVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		if("0".equals(vo.getLevel())){
			//根据销售组织查准确率
			dao.callSelectExactRateByXszz(param);
		}else if("1".equals(vo.getLevel())){
			//根据销售组织查准确率
			dao.callSelectExactRateByXszzDetail(param);
		}else if("2".equals(vo.getLevel())){
			//根据销售员查询准确率
			dao.callSelectExactRateByXsyid(param);
		}else if("3".equals(vo.getLevel())){
			//根据销售员查询准确率
			dao.callSelectExactRateByXsyidDetail(param);
		}else if("4".equals(vo.getLevel())){
			//根据业务组查询准确率
			dao.callSelectExactRateByYwz(param);
		}else if("5".equals(vo.getLevel())){
			//根据业务组查询准确率
			dao.callSelectExactRateByYwzDetail(param);
		}
		List<FcstReportExactRateVo> list = (List<FcstReportExactRateVo>) param.get("list");
    	return list;
	}
	/**
	 * 查询FCST准确率明细
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectExactRateDetail(FcstReportExactRateVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectExactRateDetail(param);
		List<FcstReportExactRateVo> list = (List<FcstReportExactRateVo>) param.get("list");
    	return list;
	}
	/**
	 * 查询机芯分析
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectMovementAnalysis(FcstReportMovementAnalysisVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", vo.getNy());
		param.put("zc", vo.getZc());
		dao.callSelectMovementAnalysis(param);
		List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>) param.get("list");
    	return list;
	}	
	/**
	 * 查询机型分析
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectModalAnalysis(FcstReportMovementAnalysisVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", vo.getNy());
		param.put("zc", vo.getZc());
		dao.callSelectModalAnalysis(param);
		List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>) param.get("list");
    	return list;
	}
	/**
	 * 查询客户分析
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectCustomeAnalysis(FcstReportMovementAnalysisVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", vo.getNy());
		param.put("zc", vo.getZc());
		dao.callSelectCustomeAnalysis(param);
		List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>) param.get("list");
    	return list;
	}	
	/**
	 * 查询FCST达成率
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectReachRateByPage(FcstReportReachRateVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectReachRate(param);
		List<FcstReportReachRateVo> list = (List<FcstReportReachRateVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 查询FCST达成率明细
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectReachRateDetailByPage(FcstReportReachRateVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectReachRateDetail(param);
		List<FcstReportReachRateVo> list = (List<FcstReportReachRateVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 查询FCST达成率明细
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryReachRateDetail(FcstReportReachRateVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectReachRateDetail(param);
		List<FcstReportReachRateVo> list = (List<FcstReportReachRateVo>) param.get("list");
    	return list;
	}
	/**
	 * 查询评审历史
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectApvHistoryByPage(FcstReportApproveHistoryVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectApvHistory(param);
		List<FcstReportApproveHistoryVo> list = (List<FcstReportApproveHistoryVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 查询三月滚动FCST需求汇总1
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSearchDemandSummaryOne(String ny,String zc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", ny);
		param.put("zc", zc);
		dao.callSearchDemandSummaryOne(param);
		List<FcstReportDemandSummaryVo> list = (List<FcstReportDemandSummaryVo>) param.get("list");
    	return list;
	}
	/**
	 * 查询三月滚动FCST需求汇总2
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSearchDemandSummaryTwo(String ny,String zc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", ny);
		param.put("zc", zc);
		dao.callSearchDemandSummaryTwo(param);
		List<FcstReportDemandSummaryVo> list = (List<FcstReportDemandSummaryVo>) param.get("list");
    	return list;
	}	
	/**
	 * 查询机芯分析
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSearchMovementAnalysisByPage(String ny,String zc, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", ny);
		param.put("zc", zc);
		param.put("page", page);
		dao.callSelectMovementAnalysis(param);
		List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}	
	/**
	 * 查询机型分析
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSearchModalAnalysisByPage(String ny,String zc, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", ny);
		param.put("zc", zc);
		param.put("page", page);
		dao.callSelectModalAnalysis(param);
		List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 查询客户分析
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSearchCustomeAnalysisByPage(String ny,String zc, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", ny);
		param.put("zc", zc);
		param.put("page", page);
		dao.callSelectCustomeAnalysis(param);
		List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}	
	/**
	 * 查询FCST准确率
	 */

	@SuppressWarnings("unchecked")
	public Object callQueryExactRateByPage(FcstReportExactRateVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectReachRate(param);
		List<FcstReportExactRateVo> list = (List<FcstReportExactRateVo>) param.get("list");

    	return list;
	}
	
	/**
	 * 查询FCST达成率
	 */

	@SuppressWarnings("unchecked")
	public Object callQueryReachRate(FcstReportReachRateVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectReachRate(param);
		List<FcstReportReachRateVo> list = (List<FcstReportReachRateVo>) param.get("list");

    	return list;
	}
	@SuppressWarnings("unchecked")
	public Object callQueryApvHistory(FcstReportApproveHistoryVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectApvHistory(param);
		List<FcstReportApproveHistoryVo> list = (List<FcstReportApproveHistoryVo>) param.get("list");
    	return list;
	}
	
	/**
	 * 查询准确率报表动态列
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object  callSelectExactRateTitles(String yyyymm){
		User user = UserUtils.getUser();
		EmployeeVo record = employeeService.findByXsyid(user.getLoginAcct());
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("yyyymm", yyyymm);
		dao.callSelectExactRateTitles(param);
		//动态列名共用了实体对象
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		map.put("yyyymm", param.get("yyyymm").toString());
		map.put("colname", param.get("colname").toString());
		map.put("hide", param.get("hide").toString());
		if(record != null){
			map.put("xszz", record.getXszz());
			map.put("xszzmc", record.getXszzmc());
		}
		return map;
	}
	
	/**
	 * 查询评审历史动态列
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectApvHistoryTitles(String zc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("zc", zc);
		dao.callSelectApvHistoryTitles(param);
		//动态列名共用了实体对象
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		map.put("zc", param.get("zc").toString());
		return map;
	}
	/**
	 * 查询准确率明细动态列
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectReachRateTitles(String yyyymm) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("yyyymm", yyyymm);
		dao.callSelectReachRateTitles(param);
		//动态列名共用了实体对象
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		map.put("yyyymm", param.get("yyyymm").toString());
		return map;
	}	
	/**
	 * 查询评审历史动态列
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectMovementAnalysisTitles(String zc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("zc", zc);
		dao.callSelectApvHistoryTitles(param);
		//动态列名共用了实体对象
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		map.put("zc", param.get("zc").toString());
		return map;
	}	
	/**
	 * 查询评审历史动态列
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectDemandSummaryTitles(String ny) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ny", ny);
		dao.callSelectDemandSummaryTitles(param);
		//动态列名共用了实体对象
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		List<Map<String, String>> hbtitleList = this.convertList(hblist);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hbtitleList);
		return map;
	}		
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	@SuppressWarnings("unused")
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

	@SuppressWarnings("unchecked")
	public void exportExactRate(HttpServletResponse response, Map<String, Object> params, FcstReportExactRateVo vo){
		try {
			List<FcstReportExactRateVo> list = (List<FcstReportExactRateVo>)this.callSelectExactRate(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}

	@SuppressWarnings("unchecked")
	public void exportExactRateDetail(HttpServletResponse response, Map<String, Object> params, FcstReportExactRateVo vo){
		try {
			List<FcstReportExactRateVo> list = (List<FcstReportExactRateVo>)this.callSelectExactRateDetail(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void exportReachRate(HttpServletResponse response, Map<String, Object> params, FcstReportReachRateVo vo){
		try {
			List<FcstReportReachRateVo> list = (List<FcstReportReachRateVo>)this.callQueryReachRate(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	@SuppressWarnings("unchecked")
	public void exportReachRateDetail(HttpServletResponse response, Map<String, Object> params, FcstReportReachRateVo vo){
		try {
			List<FcstReportReachRateVo> list = (List<FcstReportReachRateVo>)this.callQueryReachRateDetail(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}

	@SuppressWarnings("unchecked")
	public void exportMovementAnalysis(HttpServletResponse response, Map<String, Object> params, FcstReportMovementAnalysisVo vo){
		try {
			List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>)this.callSelectMovementAnalysis(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}

	@SuppressWarnings("unchecked")
	public void exportCustomeAnalysis(HttpServletResponse response, Map<String, Object> params, FcstReportMovementAnalysisVo vo){
		try {
			List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>)this.callSelectCustomeAnalysis(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}

	@SuppressWarnings("unchecked")
	public void exportApvHistory(HttpServletResponse response, Map<String, Object> params, FcstReportApproveHistoryVo vo){
		try {
			List<FcstReportApproveHistoryVo> list = (List<FcstReportApproveHistoryVo>)this.callQueryApvHistory(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}

	@SuppressWarnings("unchecked")
	public void exportDemandSummaryOne(HttpServletResponse response, Map<String, Object> params, FcstReportDemandSummaryVo vo){
		try {
			List<FcstReportDemandSummaryVo> list = (List<FcstReportDemandSummaryVo>)this.callSearchDemandSummaryOne(vo.getNy(),vo.getZc());
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}

	@SuppressWarnings("unchecked")
	public void exportDemandSummaryTwo(HttpServletResponse response, Map<String, Object> params, FcstReportDemandSummaryVo vo){
		try {
			List<FcstReportDemandSummaryVo> list = (List<FcstReportDemandSummaryVo>)this.callSearchDemandSummaryTwo(vo.getNy(),vo.getZc());
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}

	@SuppressWarnings("unchecked")
	public void exportModalAnalysis(HttpServletResponse response, Map<String, Object> params, FcstReportMovementAnalysisVo vo){
		try {
			List<FcstReportMovementAnalysisVo> list = (List<FcstReportMovementAnalysisVo>)this.callSelectModalAnalysis(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
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
			rowMap.put("day", titileVo.getDay());	
			rowMap.put("month", titileVo.getMonth());	
			rowMap.put("week", titileVo.getWeek());	
			rowMap.put("editable", titileVo.getEditable());	
			rowMap.put("flag", titileVo.getFlag());	
			rowMap.put("colspan", titileVo.getColspan());	
			rowMap.put("colname", titileVo.getColname());	
			titleList.add(rowMap);
		}
		return titleList;
	}

}