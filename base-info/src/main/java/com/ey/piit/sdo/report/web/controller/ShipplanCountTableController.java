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
import com.ey.piit.sdo.report.vo.ShipplanCountTableVo;

/**
 * 出货计划统计表Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "report/ShipplanCountTable")
public class ShipplanCountTableController extends BaseController {

	@Autowired
	private ShipmentPlanReportService shipmentPlanReportService;
	
	@RequiresPermissions("report:ShipplanCountTable:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/report/ShipplanCountTableList";
	}
	
	/**
	 * 出货计划统计表页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("report:ShipplanCountTable:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ShipplanCountTableVo vo, PageJqGrid page) {
        return shipmentPlanReportService.callQueryShipplanCountByPage(vo, page);
    }	
	
	/**
	 * 出货计划统计表导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("report:ShipplanCountTable:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ShipplanCountTableVo vo) {
		shipmentPlanReportService.exportShipplanCount(response, params, vo);
	}
	
}