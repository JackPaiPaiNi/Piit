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
import com.ey.piit.sdo.report.service.InvoiceTableService;
import com.ey.piit.sdo.report.vo.InvoiceTableVo;

/**
 * 发票信息表Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "report/invoiceTable")
public class InvoiceTableController extends BaseController {

	@Autowired
	private InvoiceTableService reportService;
	
	@RequiresPermissions("report:invoiceTable:view")
	@RequestMapping(value = "")
	public String list() {
		return "sdo/report/invoiceTableList";
	}
	/**
	 * 发票信息表页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("report:invoiceTable:view")
    @RequestMapping(value = "searchInvoice")
    @ResponseBody
    public Object searchInvoice(InvoiceTableVo vo, PageJqGrid page) {
        return reportService.callSelectInvoiceTableByPage(vo, page);
    }	
	/**
	 * 发票信息表导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("report:invoiceTable:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, InvoiceTableVo vo) {
		reportService.export(response, params, vo);
	}
}