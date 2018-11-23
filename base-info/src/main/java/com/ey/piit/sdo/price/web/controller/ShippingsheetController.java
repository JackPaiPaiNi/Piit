package com.ey.piit.sdo.price.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.price.service.ShippingsheetService;
import com.ey.piit.sdo.price.vo.ShippingsheetItemVo;
import com.ey.piit.sdo.price.vo.ShippingsheetVo;

/**
 * 出货资料表Controller
 * @author 魏诚
 * @version 1.0
 */
@Controller
@RequestMapping(value = "price/shippingsheet")
public class ShippingsheetController extends BaseController {

	@Autowired
	private ShippingsheetService shippingsheetService;
	
	@Autowired
	private ExcelImporter excelImporter;

	@RequiresPermissions("price:shippingsheet:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/price/shippingsheetList";
	}

    @RequiresPermissions("price:shippingsheet:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public ModelAndView editPage(String drdh){
    	ModelAndView view = new ModelAndView("sdo/price/shippingsheetEdit");
    	if(StringUtils.isBlank(drdh)){
    		ShippingsheetVo vo = shippingsheetService.saveMain(null);
    		view.addObject("drdh", vo.getDrdh());
    	} else {
    		view.addObject("drdh", drdh);
    	}
    	return view;
    }

	@RequiresPermissions("price:shippingsheet:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ShippingsheetVo vo, PageJqGrid page) {
		return shippingsheetService.callQueryByPage(vo, page);
    }

    @RequestMapping(value = "/findByDrdh", method = RequestMethod.POST)
    @ResponseBody
    public Object findByDrdh(String drdh, PageJqGrid page){
    	return shippingsheetService.callQueryMxByPage(drdh, page);
    }

    @RequiresPermissions("price:shippingsheet:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    public Object submit(ShippingsheetVo vo) {
    	return shippingsheetService.submit(vo);
    }
    
    @RequiresPermissions("price:shippingsheet:edit")
	@RequestMapping(value = "Import")
	@ResponseBody
	public void Import(ShippingsheetVo vo, MultipartFile file) {
		List<ShippingsheetItemVo> list = excelImporter.importFileReturn(ShippingsheetItemVo.class, file, null);
		vo.setMxList(list);
		shippingsheetService.saveMx(vo);
	}
    
    @RequiresPermissions("price:shippingsheet:edit")
	@RequestMapping(value = "Export")
	@ResponseBody
	public void Export(HttpServletResponse response, @RequestParam Map<String, Object> params, String drdh) {
    	shippingsheetService.exportMx(response, params, drdh);
	}
    
}