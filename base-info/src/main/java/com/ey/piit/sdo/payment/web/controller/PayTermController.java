package com.ey.piit.sdo.payment.web.controller;

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
import com.ey.piit.sdo.payment.service.PayTermService;
import com.ey.piit.sdo.payment.vo.PayTermVo;

/**
 * 付款条件设置（付款方式）Controller
 * @author 田荣
 */
@Controller
@RequestMapping(value = "payment/payTerm")
public class PayTermController extends BaseController {

	@Autowired
	private PayTermService payTermService;
	
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PayTermVo vo, PageJqGrid page) {
        List<PayTermVo> list = payTermService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("payment:payTerm:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(PayTermVo vo) {
		payTermService.edit(vo);
    }
	
	@RequiresPermissions("payment:payTerm:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/payment/payTermList";
	}
	
	@RequiresPermissions("payment:payTerm:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PayTermVo vo) {
		payTermService.export(response, params, vo);
	}

}