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
import com.ey.piit.sdo.report.service.RecevicePaymentInvoiceService;
import com.ey.piit.sdo.report.vo.RecevicePaymentInvoiceVo;
/**
 * 回款发票报表
 * @author Gaowh
 *
 */
@Controller
@RequestMapping(value = "report/receivePaymentInvoice")
public class RecevicePaymentInvoiceController extends BaseController {
	
	@Autowired
	private RecevicePaymentInvoiceService reportService;
	
	@RequiresPermissions("report:receivePaymentInvoice:view")
	@RequestMapping(value = "")
	public String list() {
		return "sdo/report/receivePaymentInvoiceList";
	}
	
	/**
	 * 回款发票报表查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("report:receivePaymentInvoice:view")
    @RequestMapping(value = "search")
    @ResponseBody
	public Object search(RecevicePaymentInvoiceVo vo, PageJqGrid page){
		return reportService.callSelectReceivePaymentInvoiceByPage(vo, page);
	}
	
	/**
	 * 回款发票报表页面导出方法
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("report:receivePaymentInvoice:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, RecevicePaymentInvoiceVo vo){
		reportService.export(response, params, vo);
	}
	
}
