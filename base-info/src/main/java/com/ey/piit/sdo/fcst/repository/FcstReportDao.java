package com.ey.piit.sdo.fcst.repository;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.fcst.vo.FcstDataVo;
import com.ey.piit.sdo.fcst.vo.FcstReportExactRateVo;

/**
 * 采购FCST报表DAO接口
 * @author 邓海
 */
@BatisRepository
public interface FcstReportDao extends IBaseDao<FcstReportExactRateVo>{
	/**
	 * 根据销售组织查准确率
	 * @param param
	 */
	void callSelectExactRateByXszz(Map<String, Object> param);
	/**
	 * 根据销售组织查准确率
	 * @param param
	 */
	void callSelectExactRateByXszzDetail(Map<String, Object> param);	
	/**
	 * 根据业务组查准确率
	 * @param param
	 */
	void callSelectExactRateByYwz(Map<String, Object> param);
	/**
	 * 根据业务组查准确率明细
	 * @param param
	 */
	void callSelectExactRateByYwzDetail(Map<String, Object> param);	
	/**
	 * 根据销售员查询准确率
	 * @param param
	 */
	void callSelectExactRateByXsyid(Map<String, Object> param);
	/**
	 * 根据销售员查询准确率
	 * @param param
	 */
	void callSelectExactRateByXsyidDetail(Map<String, Object> param);	
	/**
	 * 根据客户编码查询准确率
	 * @param param
	 */
	void callSelectExactRateByKhbm(Map<String, Object> param);
	/**
	 * 查询准确率明细
	 * @param param
	 */
	void callSelectExactRateDetail(Map<String, Object> param);
	/**
	 * 查询达成率
	 * @param param
	 */
	void callSelectReachRate(Map<String, Object> param);	
	/**
	 * 查询达成率明细
	 * @param param
	 */
	void callSelectReachRateDetail(Map<String, Object> param);	
	/**
	 * 查询准确率动态列名
	 * @param param
	 */
	void callSelectExactRateTitles(Map<String, Object> param);
	/**
	 * 查询评审历史
	 * @param param
	 */
	void callSelectApvHistory(Map<String, Object> param);
	/**
	 * 查询评审历史动态列名
	 * @param param
	 */
	void callSelectApvHistoryTitles(Map<String, Object> param);
	/**
	 * 查询三月滚动FCST需求汇总动态列名
	 * @param param
	 */
	void callSelectDemandSummaryTitles(Map<String, Object> param);	
	/**
	 * 查询三月滚动FCST需求汇总1
	 * @param param
	 */
	void callSearchDemandSummaryOne(Map<String, Object> param);	
	/**
	 * 查询三月滚动FCST需求汇总2
	 * @param param
	 */
	void callSearchDemandSummaryTwo(Map<String, Object> param);		
	/**
	 * 查询机芯分析
	 * @param param
	 */
	void callSelectMovementAnalysis(Map<String, Object> param);	
	/**
	 * 查询机型分析
	 * @param param
	 */
	void callSelectModalAnalysis(Map<String, Object> param);	
	/**
	 * 查询客户分析
	 * @param param
	 */
	void callSelectCustomeAnalysis(Map<String, Object> param);	
	/**
	 * 查询达成率动态表头
	 * @param param
	 */
	void callSelectReachRateTitles(Map<String, Object> param);		
}