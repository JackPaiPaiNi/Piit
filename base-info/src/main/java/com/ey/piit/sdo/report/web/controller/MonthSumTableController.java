package com.ey.piit.sdo.report.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.report.service.ShipmentPlanReportService;
import com.ey.piit.sdo.report.vo.MonthSumTableVo;

/**
 * 月度数据汇总表Controller
 * @author 江果林
 */
@Controller
@RequestMapping(value = "report/MonthSumTable")
public class MonthSumTableController extends BaseController {

	@Autowired
	private ShipmentPlanReportService shipmentPlanReportService;
	
	@RequiresPermissions("report:MonthSumTable:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/report/MonthSumTableList";
	}
	
	/**
	 * 月度统计表页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("report:MonthSumTable:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(MonthSumTableVo vo, PageJqGrid page) {
        return shipmentPlanReportService.callQueryMonthSumByPage(vo, page);
    }	
	
	/**
	 * 月度统计表导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("report:MonthSumTable:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, MonthSumTableVo vo) {
		shipmentPlanReportService.exportMonthSum(response, params, vo);
	}
	
}