package com.ey.piit.sdo.price.web.controller;

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

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.price.service.MaterialPriceService;
import com.ey.piit.sdo.price.vo.MaterialPriceVo;

/**
 * 物料价格Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "price/materialPrice")
public class MaterialPriceController extends BaseController {

	@Autowired
	private MaterialPriceService materialPriceService;
	
	@RequiresPermissions("price:materialPrice:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(MaterialPriceVo vo, PageJqGrid page) {
        List<MaterialPriceVo> list = materialPriceService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("price:materialPrice:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(MaterialPriceVo vo) {
		materialPriceService.edit(vo);
    }
	
	@RequiresPermissions("price:materialPrice:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/price/materialPriceList";
	}
	
	@RequiresPermissions("price:materialPrice:view")
	@RequestMapping(value = "form")
	public String form(MaterialPriceVo vo, Model model) {
		MaterialPriceVo record = materialPriceService.findById(vo.getId());
		model.addAttribute("materialPrice", record == null ? new MaterialPriceVo() : record);
		return "sdo/price/materialPriceForm";
	}
	
	@RequiresPermissions("price:materialPrice:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, MaterialPriceVo vo) {
		materialPriceService.export(response, params, vo);
	}
	
	/**
	 * 同步物料价格信息
	 * @param vo
	 */
    @RequestMapping(value = "tbwljg")
    @ResponseBody
    public void tbwljg() {
		materialPriceService.tbwljg();
    }

}