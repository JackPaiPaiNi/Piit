package com.ey.piit.sdo.mdm.web.controller;

import java.util.List;
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
import com.ey.piit.sdo.mdm.service.CustomerTypeService;
import com.ey.piit.sdo.mdm.vo.CustomerTypeVo;

/**
 * 客户分类管理Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "mdm/customerType")
public class CustomerTypeController extends BaseController {

	@Autowired
	private CustomerTypeService customerTypeService;
	
	@RequiresPermissions("mdm:customerType:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/customerTypeList";
	}
	
	@RequiresPermissions("mdm:customerType:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(CustomerTypeVo vo, PageJqGrid page) {
        List<CustomerTypeVo> list = customerTypeService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:customerType:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(CustomerTypeVo vo) {
		customerTypeService.edit(vo);
    }
	
	@RequiresPermissions("mdm:customerType:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, CustomerTypeVo vo) {
		customerTypeService.export(response, params, vo);
	}

}