package com.ey.piit.sdo.payment.web.controller;

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
import com.ey.piit.sdo.payment.service.PayCreditDetialService;
import com.ey.piit.sdo.payment.vo.PayCreditDetialVo;

/**
 * 信用额度使用明细查询Controller
 * @author zhaotaojun
 */
@Controller
@RequestMapping(value = "payment/payCreditDetial")
public class PayCreditDetialController extends BaseController {

	@Autowired
	private PayCreditDetialService payCreditDetialService;
	
	@RequiresPermissions("payment:payCreditDetial:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PayCreditDetialVo vo, PageJqGrid page) {
        List<PayCreditDetialVo> list = payCreditDetialService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("payment:payCreditDetial:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(PayCreditDetialVo vo) {
		payCreditDetialService.edit(vo);
    }
	
	@RequiresPermissions("payment:payCreditDetial:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/payment/payCreditDetialList";
	}
	
	@RequiresPermissions("payment:payCreditDetial:view")
	@RequestMapping(value = "form")
	public String form(PayCreditDetialVo vo, Model model) {
		PayCreditDetialVo record = payCreditDetialService.findById(vo.getId());
		model.addAttribute("payCreditDetial", record == null ? new PayCreditDetialVo() : record);
		return "sdo/payment/payCreditDetialForm";
	}
	
	@RequiresPermissions("payment:payCreditDetial:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PayCreditDetialVo vo) {
		payCreditDetialService.export(response, params, vo);
	}

}