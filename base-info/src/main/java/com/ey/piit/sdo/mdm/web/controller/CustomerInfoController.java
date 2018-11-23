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
import com.ey.piit.sdo.mdm.service.CustomerInfoService;
import com.ey.piit.sdo.mdm.vo.CustomerInfoVo;

/**
 * 客户信息维护Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "mdm/customerInfo")
public class CustomerInfoController extends BaseController {

	@Autowired
	private CustomerInfoService customerInfoService;
	
	@RequiresPermissions("mdm:customerInfo:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(CustomerInfoVo vo, PageJqGrid page) {
        List<CustomerInfoVo> list = customerInfoService.queryByPage(vo, page);
        return list;
    }
	@RequiresPermissions("mdm:customerInfo:view")
    @RequestMapping(value = "searchKhXsy")
    @ResponseBody
    public Object searchKhXsy(CustomerInfoVo vo, PageJqGrid page) {
		return customerInfoService.queryCustomerXsyByPage(vo, page);
    }	
    @RequiresPermissions("mdm:customerInfo:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(CustomerInfoVo vo) {
		customerInfoService.edit(vo);
    }
    @RequiresPermissions("mdm:customerInfo:edit")
    @RequestMapping(value = "editKhXsy")
    @ResponseBody
    public void editKhXsy(CustomerInfoVo vo) {
		customerInfoService.editKhXsy(vo);
    }
    
	@RequiresPermissions("mdm:customerInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/customerInfoList";
	}
	
	@RequiresPermissions("mdm:customerInfo:view")
	@RequestMapping(value = "form")
	public String form(CustomerInfoVo vo, Model model) {
		CustomerInfoVo record = customerInfoService.findById(vo.getId());
		model.addAttribute("customerInfo", record == null ? new CustomerInfoVo() : record);
		return "sdo/mdm/customerInfoForm";
	}
	
	@RequiresPermissions("mdm:customerInfo:view")
	@RequestMapping(value = {"khxsy"})
	public String khxsy() {
		return "sdo/mdm/customerXsyList";
	}
	@RequiresPermissions("mdm:customerInfo:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, CustomerInfoVo vo) {
		customerInfoService.export(response, params, vo);
	}
   /**
    * 导出客户销售员关系
    * @param response
    * @param params
    * @param vo
    */
	@RequiresPermissions("mdm:customerInfo:view")
    @RequestMapping(value = "exportCustomerXsy")
	public void exportCustomerXsy(HttpServletResponse response, @RequestParam Map<String, Object> params, CustomerInfoVo vo) {
		customerInfoService.exportCustomerXsy(response, params, vo);
	}
	
	/**
	 * 同步供应商信息
	 * @param vo
	 */
    @RequestMapping(value = "tbkhxx")
    @ResponseBody
    public void tbkhxx() {
		customerInfoService.tbkhxx();
    }
}