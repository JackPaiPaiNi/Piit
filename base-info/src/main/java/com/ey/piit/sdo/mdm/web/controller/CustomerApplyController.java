package com.ey.piit.sdo.mdm.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.CustomerApplyService;
import com.ey.piit.sdo.mdm.vo.CustomerApplyVo;

/**
 * 客户信息申请Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "mdm/customerApply")
public class CustomerApplyController extends BaseController {

	@Autowired
	private CustomerApplyService customerApplyService;
	
	@RequiresPermissions("mdm:customerApply:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/customerApplyList";
	}
	
	@RequiresPermissions("mdm:customerApply:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(CustomerApplyVo vo, PageJqGrid page) {
		return customerApplyService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("mdm:customerApply:view")
	@RequestMapping(value = "editPage")
	@Token (create = true)
	public String editPage() {
		return "sdo/mdm/customerApplyEdit";
	}
    
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token (verify = false)
    public Object findById(String id){
    	return customerApplyService.callQueryById(id);
    }
	
    @RequiresPermissions("mdm:customerApply:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    @Token(verify = true)
    public Object edit(CustomerApplyVo vo) {
		return customerApplyService.edit(vo);
    }
    
    @RequiresPermissions("mdm:customerApply:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(CustomerApplyVo vo) {
    	customerApplyService.submit(vo);
    }
	
	@RequiresPermissions("mdm:customerApply:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/mdm/customerApplyView");
    	view.addObject("customerApply",customerApplyService.callQueryById(id)); 
    	return view;
    }
	
    @RequiresPermissions("mdm:customerApply:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	customerApplyService.delete(id,sjc,zt,processId);
    }
	
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    @Token (create = true)
    public String approvePage(){
    	return "sdo/mdm/customerApplyApprove";
    }
	
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = true)
    public void approve(CustomerApplyVo vo) {
    	customerApplyService.approve(vo);
    }
	
	@RequiresPermissions("mdm:customerApply:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, CustomerApplyVo vo) {
		customerApplyService.export(response, params, vo);
	}

}