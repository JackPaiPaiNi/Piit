package com.ey.piit.sdo.report.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ey.piit.core.report.service.ReportService;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * 员工报表Controller
 * 
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "report/employeeReport")
public class ReportController extends BaseController {
	@Autowired
	private ReportService reportService;
	
	@RequiresPermissions("report:employeeReport:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/report/reportEmployee";
	}
	
	@RequiresPermissions("report:employeeReport:view")
	@RequestMapping(value = "/report")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("empCode", request.getParameter("empCode"));
		parameters.put("userName", request.getParameter("name"));

		//html
		reportService.exportHtml(request, response, "employee.jasper", parameters);
	}
	
	@RequiresPermissions("report:employeeReport:view")
	@RequestMapping(value = "/reportDown")
	public void reportDown(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("empCode", "");
		parameters.put("name", "");

		// excel
		reportService.exportExcel(request, response, "employee.jasper", "employee.xlsx", parameters);

//		SimpleXlsReportConfiguration reportConfiguration = new SimpleXlsReportConfiguration();
//		reportConfiguration.setSheetNames(new String[] { "sheet1" });
//		reportConfiguration.setOnePagePerSheet(true);
//		reportConfiguration.setRemoveEmptySpaceBetweenRows(false);
//		reportConfiguration.setDetectCellType(true);
//		reportConfiguration.setWhitePageBackground(false);
//		reportService.exportExcel(request, response, "sample.jasper", "sample.xls", parameters, reportConfiguration);
	}

}