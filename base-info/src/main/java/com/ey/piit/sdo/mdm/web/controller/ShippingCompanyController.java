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
import com.ey.piit.sdo.mdm.service.ShippingCompanyService;
import com.ey.piit.sdo.mdm.vo.ShippingCompanyVo;

/**
 * 船代公司信息维护Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "mdm/shippingCompany")
public class ShippingCompanyController extends BaseController {

	@Autowired
	private ShippingCompanyService shippingCompanyService;
	
	/*@RequiresPermissions("mdm:shippingCompany:view")*/
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ShippingCompanyVo vo, PageJqGrid page) {
        List<ShippingCompanyVo> list = shippingCompanyService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:shippingCompany:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(ShippingCompanyVo vo) {
		shippingCompanyService.edit(vo);
    }
	
	@RequiresPermissions("mdm:shippingCompany:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/shippingCompanyList";
	}
	
	@RequiresPermissions("mdm:shippingCompany:view")
	@RequestMapping(value = "form")
	public String form(ShippingCompanyVo vo, Model model) {
		ShippingCompanyVo record = shippingCompanyService.findById(vo.getId());
		model.addAttribute("shippingCompany", record == null ? new ShippingCompanyVo() : record);
		return "sdo/mdm/shippingCompanyForm";
	}
	
	@RequiresPermissions("mdm:shippingCompany:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ShippingCompanyVo vo) {
		shippingCompanyService.export(response, params, vo);
	}

}