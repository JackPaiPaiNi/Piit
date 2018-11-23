package com.ey.piit.basedemo.user.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basedemo.user.service.UserDemoService;
import com.ey.piit.basedemo.user.vo.UserDemoVo;
import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.report.service.ReportService;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * 用户Controller
 * 
 * @author kevin
 */
@Controller
@RequestMapping(value = "user/userDemo")
public class UserDemoController extends BaseController {

	@Autowired
	private UserDemoService userDemoService;

	@Autowired
	private ExcelImporter excelImporter;

	@Autowired
	private ReportService reportService;

	@RequiresPermissions("user:userDemo:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(UserDemoVo vo, PageJqGrid page) {
		List<UserDemoVo> list = userDemoService.queryByPage(vo, page);
		return list;
	}

	// 附件上传
	@RequiresPermissions("user:userDemo:edit")
	@RequestMapping(value = "edit")
	@Token(verify = true)
	@ResponseBody
	public Object edit(UserDemoVo vo) {
		userDemoService.edit(vo);
		return vo;
	}

	// vo中直接注入list对象
	/*
	 * @RequiresPermissions("user:userDemo:edit")
	 * 
	 * @RequestMapping(value = "edit")
	 * 
	 * @ResponseBody public void edit(@RequestBody UserDemoVo vo) {
	 * userDemoService.edit(vo); }
	 */

	@RequiresPermissions("user:userDemo:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "basedemo/user/userDemoList";
	}

	@RequiresPermissions("user:userDemo:view")
	@RequestMapping(value = "form")
	@Token(create = true)
	public String form(UserDemoVo vo, Model model) {
		UserDemoVo record = userDemoService.findById(vo.getId());
		model.addAttribute("userDemo", record == null ? new UserDemoVo() : record);
		
		List<String> dataList = new ArrayList<String>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 17; i++) {
			int week = calendar.get(Calendar.WEEK_OF_YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR) - 2000;
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

			String strWeek = week >= 10 ? week+"" : "0"+week;
			
			Calendar cFirstDayOfWeek = Calendar.getInstance();
			cFirstDayOfWeek.setTime(calendar.getTime());
			cFirstDayOfWeek.add(Calendar.DAY_OF_MONTH, -dayOfWeek+1);
			int firstDayOfWeek = cFirstDayOfWeek.get(Calendar.DAY_OF_MONTH);
			int firstMonth = cFirstDayOfWeek.get(Calendar.MONTH) + 1;
			
			Calendar cLastDayOfWeek = Calendar.getInstance();
			cLastDayOfWeek.setTime(calendar.getTime());
			cLastDayOfWeek.add(Calendar.DAY_OF_MONTH, 7 - dayOfWeek);
			int lastDayOfWeek = cLastDayOfWeek.get(Calendar.DAY_OF_MONTH);
			int lastMonth = cLastDayOfWeek.get(Calendar.MONTH) + 1;
			
			String strFirstDayOfWeek = firstDayOfWeek >= 10 ? firstDayOfWeek+"" : "0"+firstDayOfWeek;
			String strLastDayOfWeek = lastDayOfWeek >= 10 ? lastDayOfWeek+"" : "0"+lastDayOfWeek;
			String strFirstMonth = firstMonth >= 10 ? firstMonth+"" : "0"+firstMonth;
			String strLastMonth = lastMonth >= 10 ? lastMonth+"" : "0"+lastMonth;
			
			Map<String, String> map = new HashMap<String, String>();
			if (i == 0) {
				map.put("weekNum", "当前周");
			} else {
				map.put("weekNum", "第"+(i+1)+"周");
			}
			map.put("week", year+strWeek);
			map.put("day", strFirstMonth+strFirstDayOfWeek+"~"+strLastMonth+strLastDayOfWeek);
			map.put("month", month+"月");
			
//			String twoTitle = "";
//			map.put("twoTitle",);
			list.add(map);
			calendar.add(Calendar.WEEK_OF_YEAR, 1);
			
			dataList.add("\""+year+strWeek+"ycs\":100,\""+year+strWeek+"dds\":50");
		}
		model.addAttribute("titles", list);
		
		String datas = "[";
		for (int j = 0; j < 2; j++) {
			if (j != 0) {
				datas += ",";
			}
			datas += "{\"id\":\""+j+"\",\"ddlx\":\"1\",\"khbm\":\"C001\",\"khmc\":\"东芝\",\"xwgj\":\"美国\",\"pid\":\"P001\"";
			for (int i = 0; i < dataList.size(); i++) {
				datas += ","+dataList.get(i);
			}
			datas += "}";
		}
		datas += "]";
		model.addAttribute("datas", datas);
		
		return "basedemo/user/userDemoForm";
	}

	@RequiresPermissions("user:userDemo:view")
	@RequestMapping(value = "/download")
	public void downloadFile(String id, HttpServletResponse response) {
		userDemoService.downloadFile(id, response);
	}

	@RequiresPermissions("user:userDemo:edit")
	@RequestMapping(value = "import")
	@ResponseBody
	public Object importFile(MultipartFile file) {
		List<UserDemoVo> list = excelImporter.importFileReturn(UserDemoVo.class, file, null);
		Paginator paginator = new Paginator(1, 10, list.size());
		return new PageList<UserDemoVo>(list, paginator);
	}

	@RequiresPermissions("user:userDemo:view")
	@RequestMapping(value = "searchAll")
	@ResponseBody
	public Object searchAll(UserDemoVo vo) {
		// List<UserDemoVo> list = userDemoService.queryByParam(vo);
		int count = 15;
		List<UserDemoVo> list = new ArrayList<UserDemoVo>(count);
		for (int i = 0; i < count; i++) {
			UserDemoVo user = new UserDemoVo();
			user.setId(i + "");
			user.setLoginAcct("test" + i);
			user.setUserName("测试用户" + i);
			user.setEmpCode("TEST-" + i);
			user.setCompCode("010104");
			user.setEmail("test@skyworth.com.cn");
			user.setCreateTime(new Date());
			user.setCreator(findCurUser());
			user.setDefautRole("test");
			user.setDelFlag("1");
			user.setDescription("test");
			user.setStatus("1");
			user.setType("测试用户");
			user.setLastUpdater(findCurUser());
			user.setLastUpdateTime(new Date());
			list.add(user);
		}
		return list;
	}

	@RequiresPermissions("user:userDemo:view")
	@RequestMapping(value = "/report")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("invoiceNo", "D14/06/0204/EE/VW");

		//html
		reportService.exportHtml(request, response, "sample.jasper", parameters);
	}
	
	@RequiresPermissions("user:userDemo:view")
	@RequestMapping(value = "/reportDown")
	public void reportDown(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("invoiceNo", "D14/06/0204/EE/VW");

		// excel
		reportService.exportExcel(request, response, "sample.jasper", "sample.xlsx", parameters);

//		SimpleXlsReportConfiguration reportConfiguration = new SimpleXlsReportConfiguration();
//		reportConfiguration.setSheetNames(new String[] { "sheet1" });
//		reportConfiguration.setOnePagePerSheet(true);
//		reportConfiguration.setRemoveEmptySpaceBetweenRows(false);
//		reportConfiguration.setDetectCellType(true);
//		reportConfiguration.setWhitePageBackground(false);
//		reportService.exportExcel(request, response, "sample.jasper", "sample.xls", parameters, reportConfiguration);
	}
	
	@RequiresPermissions("user:userDemo:view")
	@RequestMapping(value = "/excelMerge")
	public void excelMerge(HttpServletResponse response, @RequestParam Map<String, Object> params, UserDemoVo vo) throws Exception {
		userDemoService.export(response, params, vo);
	}

}