package com.ey.piit.sdo.mdm.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.ExchangeRateService;
import com.ey.piit.sdo.mdm.vo.ExchangeRateVo;

/**
 * 汇率Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "mdm/exchangeRate")
public class ExchangeRateController extends BaseController {

	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@Autowired
    private ExcelImporter excelImporter;
	
	@RequiresPermissions("mdm:exchangeRate:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ExchangeRateVo vo, PageJqGrid page) {
        List<ExchangeRateVo> list = exchangeRateService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:exchangeRate:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(ExchangeRateVo vo) {
		exchangeRateService.edit(vo);
    }
	
	@RequiresPermissions("mdm:exchangeRate:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/exchangeRateList";
	}
	
	@RequiresPermissions("mdm:exchangeRate:view")
	@RequestMapping(value = "form")
	public String form(ExchangeRateVo vo, Model model) {
		ExchangeRateVo record = exchangeRateService.findById(vo.getId());
		model.addAttribute("exchangeRate", record == null ? new ExchangeRateVo() : record);
		return "sdo/mdm/exchangeRateForm";
	}
	
	@RequiresPermissions("mdm:exchangeRate:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ExchangeRateVo vo) {
		exchangeRateService.export(response, params, vo);
	}
	
	@RequiresPermissions("mdm:exchangeRate:edit")
    @RequestMapping(value = "import")
    @ResponseBody
	public Object importFile(MultipartFile file){
    	return excelImporter.importFile(ExchangeRateVo.class, file, null);   
	}

}