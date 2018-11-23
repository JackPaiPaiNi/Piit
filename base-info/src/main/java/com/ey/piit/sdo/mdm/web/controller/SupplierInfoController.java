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
import com.ey.piit.sdo.mdm.service.SupplierInfoService;
import com.ey.piit.sdo.mdm.vo.SupplierInfoVo;

/**
 * 供应商信息维护Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "mdm/supplierInfo")
public class SupplierInfoController extends BaseController {

	@Autowired
	private SupplierInfoService supplierInfoService;
	
	@RequiresPermissions("mdm:supplierInfo:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(SupplierInfoVo vo, PageJqGrid page) {
        List<SupplierInfoVo> list = supplierInfoService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:supplierInfo:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(SupplierInfoVo vo) {
		supplierInfoService.edit(vo);
    }
	
	@RequiresPermissions("mdm:supplierInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/supplierInfoList";
	}
	
	@RequiresPermissions("mdm:supplierInfo:view")
	@RequestMapping(value = "form")
	public String form(SupplierInfoVo vo, Model model) {
		SupplierInfoVo record = supplierInfoService.findById(vo.getId());
		model.addAttribute("supplierInfo", record == null ? new SupplierInfoVo() : record);
		return "sdo/mdm/supplierInfoForm";
	}
	
	@RequiresPermissions("mdm:supplierInfo:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, SupplierInfoVo vo) {
		supplierInfoService.export(response, params, vo);
	}
	
	/**
	 * 同步供应商信息
	 * @param vo
	 */
    @RequestMapping(value = "tbgys")
    @ResponseBody
    public void tbgys() {
		supplierInfoService.tbgys();
    }

}