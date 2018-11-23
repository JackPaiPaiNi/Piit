package com.ey.piit.sdo.payment.web.controller;

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
import com.ey.piit.sdo.payment.service.PayCreditService;
import com.ey.piit.sdo.payment.vo.PayCreditVo;

/**
 * 信用额度管理Controller
 * @author 田荣
 */
@Controller
@RequestMapping(value = "payment/payCredit")
public class PayCreditController extends BaseController {

	@Autowired
	private PayCreditService payCreditService;
	
	@RequiresPermissions("payment:payCredit:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/payment/payCreditList";
	}
	
	@RequiresPermissions("payment:payCredit:view")
    @RequestMapping(value = {"search","approveSearch"})
    @ResponseBody
    public Object search(PayCreditVo vo, PageJqGrid page) {
		return payCreditService.callQueryByPage(vo, page);
    }
    
	@RequiresPermissions("payment:payCredit:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token (create = true)
    public String editPage(){
    	return "sdo/payment/payCreditEdit";
    }
	@RequiresPermissions("payment:payCredit:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id ){
		ModelAndView mv = new ModelAndView("sdo/payment/payCreditView") ;
		mv.addObject("payEdit", findById(id));
    	return mv ; 
    }
	
	@RequiresPermissions("payment:payCredit:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return payCreditService.callQueryById(id);
    }
	
	@RequiresPermissions("payment:payCredit:view")
    @RequestMapping(value = "/changeById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object changeById(String id, String sjc){
    	return payCreditService.callChangeById(id, sjc);
    }
    
    @RequiresPermissions("payment:payCredit:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(PayCreditVo vo) {
		payCreditService.submit(vo);
    }
    
    @RequiresPermissions("payment:payCredit:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc) {
		payCreditService.delete(id, sjc);
    }
	
	@RequiresPermissions("payment:payCredit:view")
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token (create = false)
    public String approvePage(){
    	return "sdo/payment/payCreditApprove";
    }
	
    @RequiresPermissions("payment:payCredit:edit")
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = false)
    public void approve(PayCreditVo vo) {
		payCreditService.approve(vo);
    }
	
	@RequiresPermissions("payment:payCredit:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PayCreditVo vo) {
		payCreditService.export(response, params, vo);
	}
	
	@RequiresPermissions("payment:payCredit:edit")
    @RequestMapping(value = "frozen")
    @ResponseBody
    public void frozen(PayCreditVo vo) {
		payCreditService.frozen(vo);
    }
	
	@RequiresPermissions("payment:payCredit:adjust")
    @RequestMapping(value = "adjust")
    @ResponseBody
    public void adjust(PayCreditVo vo) {
		payCreditService.adjust(vo);
    }

}