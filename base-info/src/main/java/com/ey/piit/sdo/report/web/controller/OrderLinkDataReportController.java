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
import com.ey.piit.sdo.report.service.OrderLinkDataReportService;
import com.ey.piit.sdo.report.vo.OrderLinkDataVo;

/**
 * 订单联动表Controller
 * @author 赵明
 */
@Controller
@RequestMapping(value = "report/orderLinkDataReport")
public class OrderLinkDataReportController extends BaseController {

	@Autowired
	private OrderLinkDataReportService reportService;
	
	@RequiresPermissions("report:orderLinkDataReport:view")
	@RequestMapping(value = "")
	public String piOrderPage() {
		return "sdo/report/OrderLinkDataList";
	}
	/**
	 * PI订单预走货出货通知书页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("report:orderLinkDataReport:view")
    @RequestMapping(value = "searchOrderLink")
    @ResponseBody
    public Object searchOrderLink(OrderLinkDataVo vo, PageJqGrid page) {
        return reportService.callSelectOrderLinkByPage(vo, page);
    }	
	/**
	 * 订单信息导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("report:orderLinkDataReport:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderLinkDataVo vo) {
		reportService.export(response, params, vo);
	}
}