package com.ey.piit.sdo.custinv.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.custinv.service.MatterPriceService;
import com.ey.piit.sdo.custinv.vo.MatterPriceVo;

/**
 * 客户物料价格库Controller
 * @author 魏诚
 * @version 1.0
 */
@Controller
@RequestMapping(value = "custinv/matterPrice")
public class MatterPriceController extends BaseController {

	@Autowired
	private MatterPriceService service;
	
	@Autowired
	private ExcelImporter excelImporter;

	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/custinv/matterPriceList";
	}

    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(MatterPriceVo vo, PageJqGrid page) {
		return service.callQueryByPage(vo, page);
    }
    
	@RequestMapping(value = "Import")
	@ResponseBody
	public Object Import(MatterPriceVo vo, MultipartFile file) {
		List<MatterPriceVo> list = excelImporter.importFileReturn(MatterPriceVo.class, file, null);
		return service.save(list);
	}
    
	@RequestMapping(value = "Export")
	@ResponseBody
	public void Export(HttpServletResponse response, @RequestParam Map<String, Object> params, MatterPriceVo vo) {
    	service.export(response, params, vo);
	}
    
}