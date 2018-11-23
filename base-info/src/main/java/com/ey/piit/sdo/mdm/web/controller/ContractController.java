package com.ey.piit.sdo.mdm.web.controller;

import java.util.List;
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
import com.ey.piit.sdo.mdm.service.ContractService;
import com.ey.piit.sdo.mdm.vo.ContractVo;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 合同信息维护Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "mdm/contract")
public class ContractController extends BaseController {

	@Autowired
	private ContractService contractService;
	
	@RequiresPermissions("mdm:contract:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ContractVo vo, PageJqGrid page) {
        List<ContractVo> list = contractService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:contract:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    @Token(verify = true)
    public Object edit(ContractVo vo) {
		return contractService.saveOrUpdate(vo);
    }
	
	@RequiresPermissions("mdm:contract:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/contractList";
	}
	
	@RequiresPermissions("mdm:contract:view")
	@RequestMapping(value = "editPage")
	@Token (create = true)
	public String editPage() {
		return "sdo/mdm/contractEdit";
	}
	
	@RequiresPermissions("mdm:contract:view")
	@RequestMapping(value = "findById")
	@ResponseBody
	@Token(verify = false)
	public Object findById(String id) throws JsonProcessingException {
		ContractVo vo = contractService.findById(id);
		 return vo;
	}
	
	@RequiresPermissions("mdm:contract:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(ContractVo vo) {
		contractService.delete(vo);
    }
	
	@RequiresPermissions("mdm:contract:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/mdm/contractView");
    	view.addObject("contract",contractService.findById(id)); 
    	return view;
    }
	
	
	@RequiresPermissions("mdm:contract:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ContractVo vo) {
		contractService.export(response, params, vo);
	}

}