package com.ey.piit.sdo.fcst.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.fcst.service.FcstDataService;
import com.ey.piit.sdo.fcst.service.FcstReportService;
import com.ey.piit.sdo.fcst.vo.FcstReportApproveHistoryVo;
import com.ey.piit.sdo.fcst.vo.FcstReportDemandSummaryVo;
import com.ey.piit.sdo.fcst.vo.FcstReportExactRateVo;
import com.ey.piit.sdo.fcst.vo.FcstReportMovementAnalysisVo;
import com.ey.piit.sdo.fcst.vo.FcstReportReachRateVo;

/**
 * FCST报表Controller
 * 
 * @author 邓海
 */
@Controller
@RequestMapping(value = "fcst/fcstReport")
public class FcstReportController extends BaseController {

	@Autowired
	private FcstReportService fcstReportService;

	@Autowired
	private FcstDataService fcstDataService;

	/**
	 * FCST准确率汇总页面查询方法
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchExactRate")
	@ResponseBody
	public Object searchExactRate(FcstReportExactRateVo vo, PageJqGrid page) {
		return fcstReportService.callSelectExactRateByPage(vo, page);
	}

	/**
	 * FCST准确率明细页面查询方法
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchExactRateDetail")
	@ResponseBody
	public Object searchExactRateDetail(FcstReportExactRateVo vo, PageJqGrid page) {
		return fcstReportService.callSelectExactRateDetailByPage(vo, page);
	}

	/**
	 * 达成率页面查询方法
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchReachRate")
	@ResponseBody
	public Object searchReachRate(FcstReportReachRateVo vo, PageJqGrid page) {
		return fcstReportService.callSelectReachRateByPage(vo, page);
	}

	/**
	 * 达成率明细页面查询方法
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchReachRateDetail")
	@ResponseBody
	public Object searchReachRateDetail(FcstReportReachRateVo vo, PageJqGrid page) {
		return fcstReportService.callSelectReachRateDetailByPage(vo, page);
	}

	/**
	 * 评审历史页面查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchApvHistory")
	@ResponseBody
	public Object searchApvHistory(FcstReportApproveHistoryVo vo, PageJqGrid page) {
		return fcstReportService.callSelectApvHistoryByPage(vo, page);
	}

	/**
	 * 三月滚动FCST需求汇总1页面查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchDemandSummaryOne")
	@ResponseBody
	public Object searchDemandSummaryOne(String ny, String zc) {
		return fcstReportService.callSearchDemandSummaryOne(ny, zc);
	}

	/**
	 * 三月滚动FCST需求汇总2页面查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchDemandSummaryTwo")
	@ResponseBody
	public Object searchDemandSummaryTwo(String ny, String zc) {
		return fcstReportService.callSearchDemandSummaryTwo(ny, zc);
	}

	/**
	 * 机芯页面查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchMovementAnalysis")
	@ResponseBody
	public Object searchMovementAnalysis(String ny, String zc, PageJqGrid page) {
		return fcstReportService.callSearchMovementAnalysisByPage(ny, zc, page);
	}

	/**
	 * 机型页面查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchModalAnalysis")
	@ResponseBody
	public Object searchModalAnalysis(String ny, String zc, PageJqGrid page) {
		return fcstReportService.callSearchModalAnalysisByPage(ny, zc, page);
	}

	/**
	 * 客户分析页面查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchCustomeAnalysis")
	@ResponseBody
	public Object searchCustomeAnalysis(String ny, String zc, PageJqGrid page) {
		return fcstReportService.callSearchCustomeAnalysisByPage(ny, zc, page);
	}

	/**
	 * 进入FCST准确报表页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exactRatePage")
	public String exactRatePage(Model model) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectExactRateTitles(null));
		model.addAttribute("monthtitles", map.get("hblist"));
		model.addAttribute("colname", map.get("colname").toString());
		model.addAttribute("yyyymm", map.get("yyyymm").toString());
		model.addAttribute("hide", map.get("hide").toString());
		return "sdo/fcst/fcstReportExactRate";
	}

	/**
	 * 进入业务组准确汇总报表页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exactRateYwzPage")
	public String exactRateYwzPage(Model model) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectExactRateTitles(null));
		model.addAttribute("monthtitles", map.get("hblist"));
		model.addAttribute("colname", map.get("colname").toString());
		model.addAttribute("yyyymm", map.get("yyyymm").toString());
		model.addAttribute("hide", map.get("hide").toString());
		return "sdo/fcst/fcstReportYwzExactRate";
	}

	/**
	 * 进入销售员准确汇总报表页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exactRateXsyPage")
	public String exactRateXsyPage(Model model) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectExactRateTitles(null));
		model.addAttribute("monthtitles", map.get("hblist"));
		model.addAttribute("colname", map.get("colname").toString());
		model.addAttribute("yyyymm", map.get("yyyymm").toString());
		model.addAttribute("hide", map.get("hide").toString());
		return "sdo/fcst/fcstReportXsyExactRate";
	}

	/**
	 * 进入FCST准确率明细报表页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exactRateDetailPage")
	public String exactRateDetailPage(Model model) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectExactRateTitles(null));
		model.addAttribute("monthtitles", map.get("hblist"));
		model.addAttribute("colname", map.get("colname").toString());
		model.addAttribute("yyyymm", map.get("yyyymm").toString());
		model.addAttribute("hide", map.get("hide").toString());
		return "sdo/fcst/fcstReportExactRateDetail";
	}

	/**
	 * 进入FCST达成报表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "reachRatePage")
	public String reachRatePage() {
		return "sdo/fcst/fcstReportReachRate";
	}

	/**
	 * 进入FCST达成报表明细页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "fcstReportReachRateDetail")
	public String fcstReportReachRateDetail(Model model) {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String dateNowStr = sdf.format(d);
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectReachRateTitles(dateNowStr));
		model.addAttribute("hblist", map.get("hblist"));
		model.addAttribute("yyyymm", map.get("yyyymm").toString());
		return "sdo/fcst/fcstReportReachRateDetail";
	}

	/**
	 * 进入三月滚动FCST需求汇总1报表页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "demandSummaryOnePage")
	public String demandSummaryOnePage(Model model) {
		Map<String, Object> _mapzcnr = ((Map<String, Object>) fcstDataService.getFcstDqznr());
		model.addAttribute("zc", _mapzcnr.get("zc"));
		return "sdo/fcst/fcstReportDemandSummaryOnePage";
	}

	/**
	 * 进入三月滚动FCST需求汇总2报表页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "demandSummaryTwoPage")
	public String demandSummaryTwoPage(Model model) {
		Map<String, Object> _mapzcnr = ((Map<String, Object>) fcstDataService.getFcstDqznr());
		model.addAttribute("zc", _mapzcnr.get("zc"));
		return "sdo/fcst/fcstReportDemandSummaryTwoPage";
	}

	/**
	 * 进入机芯分析报表页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "movementAnalysisPage")
	public String movementAnalysisPage(Model model) {
		Map<String, Object> _mapzcnr = ((Map<String, Object>) fcstDataService.getFcstDqznr());
		model.addAttribute("zc", _mapzcnr.get("zc"));
		return "sdo/fcst/fcstReportMovementAnalysisPage";
	}

	/**
	 * 进入机型分析报表页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "modalAnalysisPage")
	public String modalAnalysisPage(Model model) {
		Map<String, Object> _mapzcnr = ((Map<String, Object>) fcstDataService.getFcstDqznr());
		model.addAttribute("zc", _mapzcnr.get("zc"));
		return "sdo/fcst/fcstReportModalAnalysisPage";
	}

	/**
	 * 进入客户分析报表页面
	 * 
	 * @param modal
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "customeAnalysisPage")
	public String customeAnalysisPage(Model model) {
		Map<String, Object> _mapzcnr = ((Map<String, Object>) fcstDataService.getFcstDqznr());
		model.addAttribute("zc", _mapzcnr.get("zc"));
		return "sdo/fcst/fcstReportCustomeAnalysisPage";
	}

	/**
	 * 进入FCST评审历史页面
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "approveHistoryPage")
	public String approveHistoryPage(Model model) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectApvHistoryTitles(null));
		model.addAttribute("monthtitles", map.get("hblist"));
		model.addAttribute("zc", map.get("zc"));
		return "sdo/fcst/fcstReportApproveHistory";
	}

	/**
	 * 根据周次动态获取列名
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "findApvHistoryTitles", method = RequestMethod.POST)
	@ResponseBody
	public Object findApvHistoryTitles(String zc) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectApvHistoryTitles(zc));
		Map<String, Object> titlesMap = new HashMap<String, Object>();
		titlesMap.put("titles", map.get("hblist"));
		return titlesMap;
	}

	/**
	 * 根据年月动态获取列名达成率明细
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "findReachRateTitles", method = RequestMethod.POST)
	@ResponseBody
	public Object findReachRateTitles(String yyyymm) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectReachRateTitles(yyyymm));
		Map<String, Object> titlesMap = new HashMap<String, Object>();
		titlesMap.put("titles", map.get("hblist"));
		return titlesMap;
	}

	/**
	 * 根据年月动态获取列名
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "findExactRateTitles", method = RequestMethod.POST)
	@ResponseBody
	public Object findExactRateTitles(String yyyymm) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectExactRateTitles(yyyymm));
		Map<String, Object> titlesMap = new HashMap<String, Object>();
		titlesMap.put("titles", map.get("hblist"));
		titlesMap.put("colname", map.get("colname").toString());
		titlesMap.put("hide", map.get("hide").toString());
		return titlesMap;
	}

	/**
	 * 根据年月动态获取3个月滚动FCST需求汇总表头
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "searchDemandSummaryTitles", method = RequestMethod.POST)
	@ResponseBody
	public Object searchDemandSummaryTitles(String ny) {
		Map<String, Object> map = ((Map<String, Object>) fcstReportService.callSelectDemandSummaryTitles(ny));
		Map<String, Object> titlesMap = new HashMap<String, Object>();
		titlesMap.put("titles", map.get("hblist"));
		return titlesMap;
	}

	/**
	 * 导出FCST准确率报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportExactRate")
	public void exportExactRate(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportExactRateVo vo) {
		fcstReportService.exportExactRate(response, params, vo);
	}

	/**
	 * 导出FCST准确率明细报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportExactRateDetail")
	public void exportExactRateDetail(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportExactRateVo vo) {
		fcstReportService.exportExactRateDetail(response, params, vo);
	}

	/**
	 * 导出FCST达成率报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportReachRate")
	public void exportReachRate(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportReachRateVo vo) {
		fcstReportService.exportReachRate(response, params, vo);
	}

	/**
	 * 导出FCST达成率明细报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportReachRateDetail")
	public void exportReachRateDetail(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportReachRateVo vo) {
		fcstReportService.exportReachRateDetail(response, params, vo);
	}

	/**
	 * 导出机芯分析报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportMovementAnalysis")
	public void exportMovementAnalysis(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportMovementAnalysisVo vo) {
		fcstReportService.exportMovementAnalysis(response, params, vo);
	}

	/**
	 * 导出机型分析报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportModalAnalysis")
	public void exportModalAnalysis(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportMovementAnalysisVo vo) {
		fcstReportService.exportModalAnalysis(response, params, vo);
	}

	/**
	 * 导出客户分析报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportCustomeAnalysis")
	public void exportCustomeAnalysis(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportMovementAnalysisVo vo) {
		fcstReportService.exportCustomeAnalysis(response, params, vo);
	}

	/**
	 * 导出FCST评审历史报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportApvHistory")
	public void exportApvHistory(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportApproveHistoryVo vo) {
		fcstReportService.exportApvHistory(response, params, vo);
	}

	/**
	 * 导出三月滚动FCST需求汇总1报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportDemandSummaryOne")
	public void exportDemandSummaryOne(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportDemandSummaryVo vo) {
		fcstReportService.exportDemandSummaryOne(response, params, vo);
	}

	/**
	 * 导出三月滚动FCST需求汇总2报表
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstReport:view")
	@RequestMapping(value = "exportDemandSummaryTwo")
	public void exportDemandSummaryTwo(HttpServletResponse response, @RequestParam Map<String, Object> params,
			FcstReportDemandSummaryVo vo) {
		fcstReportService.exportDemandSummaryTwo(response, params, vo);
	}
}