package com.ey.piit.sdo.order.web.controller;

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
import com.ey.piit.sdo.order.service.OrderSampleFzbgService;
import com.ey.piit.sdo.order.vo.OrderSampleVo;

/**
 * 样机订单辅助变更管理Controller
 * @author tianrong
 */
@Controller
@RequestMapping(value = "orderfzbg/orderSampleFzbg")
public class OrderSampleFzbgController extends BaseController {

	@Autowired
	private OrderSampleFzbgService orderSampleFzbgService;
	
	@RequiresPermissions("orderfzbg:orderSampleFzbg:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/orderfzbg/orderSampleFzbgList";
	}
	
	@RequiresPermissions("orderfzbg:orderSampleFzbg:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(OrderSampleVo vo, PageJqGrid page) {
		return orderSampleFzbgService.callQueryByPage(vo, page);
    }
    
	@RequiresPermissions("orderfzbg:orderSampleFzbg:view")
	@Token(create = true)
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public String editPage(){
    	return "sdo/orderfzbg/orderSampleFzbgEdit";
    }
	
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return orderSampleFzbgService.callQueryById(id);
    }
	
    @RequiresPermissions("orderfzbg:orderSampleFzbg:edit")
    @RequestMapping(value = "edit")
    @Token(verify = true)
    @ResponseBody
    public Object edit(OrderSampleVo vo) {
		return orderSampleFzbgService.edit(vo);
    }
    
    @RequiresPermissions("orderfzbg:orderSampleFzbg:edit")
    @RequestMapping(value = "submit")
    @Token(verify = true)
    @ResponseBody
    public void submit(OrderSampleVo vo) {
		orderSampleFzbgService.submit(vo);
    }
    
    @RequiresPermissions("orderfzbg:orderSampleFzbg:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc, int zt, String processId) {
		orderSampleFzbgService.delete(id, sjc, zt, processId);
    }
	
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/orderfzbg/orderSampleFzbgView");
    	view.addObject("orderSample",orderSampleFzbgService.callQueryById(id)); 
    	return view;
    }
    
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    @Token(create = true)
    public String approvePage(){
    	return "sdo/orderfzbg/orderSampleFzbgApprove";
    }
    
    @RequestMapping(value = "approvePageGcsxz", method = RequestMethod.GET)
    @Token(create = true)
    public String approvePageGcsxz(){
    	return "sdo/orderfzbg/orderSampleFzbgGcsxzApprove";
    }
	
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = true)
    public Object approve(OrderSampleVo vo) {
		return orderSampleFzbgService.approve(vo);
    }
	
	@RequiresPermissions("orderfzbg:orderSampleFzbg:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderSampleVo vo) {
		orderSampleFzbgService.export(response, params, vo);
	}
	
	/**
     * function 样机订单变更
     * @param vo
     */
    @RequiresPermissions("orderfzbg:orderSampleFzbg:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderSampleVo vo) {
    	orderSampleFzbgService.change(vo);
    }
    
    /**
     * function 样机订单取回
     * @param vo
     */
    @RequiresPermissions("orderfzbg:orderSampleFzbg:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderSampleVo vo) {
    	orderSampleFzbgService.getback(vo);
    }
}