package com.ey.piit.sdo.mdm.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.EmployeeService;
import com.ey.piit.sdo.mdm.vo.EmployeeVo;

/**
 * 员工维护Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "mdm/employee")
public class EmployeeController extends BaseController {

	@Autowired
	private EmployeeService employeeService;
	
//	@RequiresPermissions("mdm:employee:view")  公共方法不要加权限
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(EmployeeVo vo, PageJqGrid page) {
        List<EmployeeVo> list = employeeService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:employee:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(EmployeeVo vo) {
		employeeService.edit(vo);
    }
    
    @RequiresPermissions("mdm:employee:edit")
    @RequestMapping(value = "activeOrDisable")
    @ResponseBody
    public void activeOrDisable(EmployeeVo vo) {
		employeeService.activeOrDisable(vo);
    }
    
    /**
     * 批量刷域账号
     */
    @RequiresPermissions("mdm:employee:plad")
    @RequestMapping(value = "batchRefreshAd")
    @ResponseBody
    public void batchRefreshAd() {
		employeeService.batchRefreshAd();
    }
    
    
	
    
	@RequiresPermissions("mdm:employee:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/employeeList";
	}
	
	@RequiresPermissions("mdm:employee:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public Object findById(String id){
    	EmployeeVo record = employeeService.findById(id);
    	return record;
    }
	
	@RequiresPermissions("mdm:employee:view")
	@RequestMapping(value = "form")
	public String form(EmployeeVo vo, Model model) {
		EmployeeVo record = employeeService.findById(vo.getId());
		model.addAttribute("employee", record == null ? new EmployeeVo() : record);
		return "sdo/mdm/employeeForm";
	}
	
	@RequiresPermissions("mdm:employee:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, EmployeeVo vo) {
		employeeService.export(response, params, vo);
	}

}