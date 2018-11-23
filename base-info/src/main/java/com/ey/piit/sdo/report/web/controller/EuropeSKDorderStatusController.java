package com.ey.piit.sdo.report.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.report.service.EuropeSKDorderStatusService;
import com.ey.piit.sdo.report.vo.EuropeSKDorderStatusVo;
import com.ey.piit.sdo.report.vo.ReportSkdOrderStatusVo;

/**
 * 欧洲供应链SKD订单状态表Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "report/skdOrderStatus")
public class EuropeSKDorderStatusController extends BaseController {

	@Autowired
	private EuropeSKDorderStatusService reportService;
	
	@Autowired
    private ExcelImporter excelImporter;
	
	@RequiresPermissions("report:skdOrderStatus:view")
	@RequestMapping(value = "")
	public String list() {
		return "sdo/report/EuropeSKDorderStatusList";
	}
	/**
	 * 欧洲供应链SKD订单状态表页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("report:skdOrderStatus:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(EuropeSKDorderStatusVo vo, PageJqGrid page) {
        return reportService.callSelectEuropeSKDorderStatusByPage(vo, page);
    }	
	/**
	 * 欧洲供应链SKD订单状态表导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("report:skdOrderStatus:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, EuropeSKDorderStatusVo vo) {
		reportService.export(response, params, vo);
	}
	
    @RequestMapping(value = "import")
    @ResponseBody
	public Object importFile(MultipartFile file){
    	return excelImporter.importFile(ReportSkdOrderStatusVo.class, file, null);
	}
}