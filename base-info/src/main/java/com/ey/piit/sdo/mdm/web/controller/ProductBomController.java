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

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.ProductBomService;
import com.ey.piit.sdo.mdm.vo.ProductBomVo;

/**
 * 产品研发BOM查看Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "mdm/productBom")
public class ProductBomController extends BaseController {

	@Autowired
	private ProductBomService productBomService;
	
	@RequiresPermissions("mdm:productBom:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ProductBomVo vo, PageJqGrid page) {
        List<ProductBomVo> list = productBomService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:productBom:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(ProductBomVo vo) {
		productBomService.edit(vo);
    }
	
	@RequiresPermissions("mdm:productBom:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/productBomList";
	}
	
	@RequiresPermissions("mdm:productBom:view")
	@RequestMapping(value = "form")
	public String form(ProductBomVo vo, Model model) {
		ProductBomVo record = productBomService.findById(vo.getId());
		model.addAttribute("productBom", record == null ? new ProductBomVo() : record);
		return "sdo/mdm/productBomForm";
	}
	
	@RequiresPermissions("mdm:productBom:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ProductBomVo vo) {
		productBomService.export(response, params, vo);
	}

}