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
import com.ey.piit.sdo.report.service.OrderStatusService;
import com.ey.piit.sdo.report.vo.OrderStatusVo;
/**
 * 
 * @author zhaozhiyang
 *
 */
@Controller
@RequestMapping(value = "report/orderStatus")
public class OrderStatusController {
	@Autowired
	private OrderStatusService  orderStatusService ;
	/**
	 * 审批中订单信息导出
	 */
	@RequiresPermissions("report:orderStatus:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderStatusVo vo) {
		orderStatusService.export(response, params, vo);
	}
	@RequiresPermissions("report:orderStatus:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(OrderStatusVo vo, PageJqGrid page) {
		return orderStatusService.callQueryByPage(vo, page);
	}
	@RequiresPermissions("report:orderStatus:view")
	@RequestMapping(value = {"list",""})
	public String list() {
		return  "sdo/report/orderStatusList" ;
	}
	
	

}
