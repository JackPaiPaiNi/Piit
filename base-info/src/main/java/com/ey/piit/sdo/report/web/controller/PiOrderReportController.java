package com.ey.piit.sdo.report.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.report.service.PiOrderReportService;
import com.ey.piit.sdo.report.vo.PiOrderDataVo;

/**
 * Pi订单号Controller
 * @author 赵明
 */
@Controller
@RequestMapping(value = "report/piOrderReport")
public class PiOrderReportController extends BaseController {

	@Autowired
	private PiOrderReportService reportService;
	
	@RequiresPermissions("report:piOrderReport:view")
	@RequestMapping(value = "")
	public String piOrderPage() {
		return "sdo/report/PiOrderDataList";
	}
	/**
	 * PI订单预走货出货通知书页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("report:piOrderReport:view")
    @RequestMapping(value = "searchPiOrder")
    @ResponseBody
    public Object searchPiOrder(PiOrderDataVo vo, PageJqGrid page) {
        return reportService.callSelectPiOrderByPage(vo, page);
    }	
}