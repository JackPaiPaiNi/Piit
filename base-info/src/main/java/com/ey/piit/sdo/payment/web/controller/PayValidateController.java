package com.ey.piit.sdo.payment.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.payment.service.PayValidateService;
import com.ey.piit.sdo.payment.vo.PayValidateVo;

/**
 * 付款保障检查Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "payment/payValidate")
public class PayValidateController extends BaseController {

	@Autowired
	private PayValidateService payValidateService;
	
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PayValidateVo vo) {
		return payValidateService.payCheckSelectLog(vo.getId());
    }
    
    @RequestMapping(value = "checkOrder")
    @ResponseBody
    public Object checkOrder(@RequestParam("id")String id, @RequestParam("ddlx")String ddlx) {
    	return payValidateService.payCheckOrder(id, ddlx);
    }

    @RequestMapping(value = "checkPso")
    @ResponseBody
    public Object checkPso(@RequestParam("id")String id) {
    	return payValidateService.payCheckPso(id);
    }

}