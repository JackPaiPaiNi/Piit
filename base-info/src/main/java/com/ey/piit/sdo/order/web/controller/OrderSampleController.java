package com.ey.piit.sdo.order.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

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
import com.ey.piit.sdo.order.service.OrderSampleService;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;
import com.ey.piit.sdo.order.vo.OrderSampleVo;

/**
 * 样机订单管理Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "order/orderSample")
public class OrderSampleController extends BaseController {

	@Autowired
	private OrderSampleService orderSampleService;
	
	@RequiresPermissions("order:orderSample:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/order/orderSampleList";
	}
	
	@RequiresPermissions("order:orderSample:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(OrderSampleVo vo, PageJqGrid page) {
		return orderSampleService.callQueryByPage(vo, page);
    }
    
	@RequiresPermissions("order:orderSample:view")
	@Token(create = true)
    @RequestMapping(value = "changeEditPage", method = RequestMethod.GET)
    public String changeEditPage(){
    	return "sdo/order/orderSampleJexxEdit";
    }
	
	@RequiresPermissions("order:orderSample:view")
	@Token(create = true)
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public String editPage(){
    	return "sdo/order/orderSampleEdit";
    }
	
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return orderSampleService.callQueryById(id);
    }
	
    @RequiresPermissions("order:orderSample:edit")
    @RequestMapping(value = "edit")
    @Token(verify = true)
    @ResponseBody
    public Object edit(OrderSampleVo vo, @RequestParam(value = "piList")String piList) {
    	JSONArray array = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) JSONArray.toCollection(array, OrderReferPiVo.class);
    	vo.setOrderReferPiList(list);
		return orderSampleService.edit(vo);
    }
    
    @RequiresPermissions("order:orderSample:edit")
    @RequestMapping(value = "submit")
    @Token(verify = true)
    @ResponseBody
    public void submit(OrderSampleVo vo, @RequestParam(value = "piList")String piList) {
    	JSONArray array = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) JSONArray.toCollection(array, OrderReferPiVo.class);
    	vo.setOrderReferPiList(list);
		orderSampleService.submit(vo);
    }
    
    @RequiresPermissions("order:orderSample:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc, int zt, String processId) {
		orderSampleService.delete(id, sjc, zt, processId);
    }
	
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/order/orderSampleView");
    	view.addObject("orderSample",orderSampleService.callQueryById(id)); 
    	return view;
    }
    
    @RequestMapping(value = "viewPageByDh", method = RequestMethod.GET)
    public ModelAndView viewPageByDh(String ddid){
		ModelAndView view = new ModelAndView("sdo/order/orderSampleView");
    	view.addObject("orderSample",orderSampleService.callQueryByDh(ddid)); 
    	return view;
    }
	
	@RequiresPermissions("order:orderSample:view")
    @RequestMapping(value = "printPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/order/orderSamplePrint");
    	view.addObject("orderSample",orderSampleService.callQueryById(id)); 
    	return view;
    }
    
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    @Token(create = true)
    public String approvePage(){
    	return "sdo/order/orderSampleApprove";
    }
	
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = true)
    public Object approve(OrderSampleVo vo) {
		return orderSampleService.approve(vo);
    }
	
	@RequiresPermissions("order:orderSample:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderSampleVo vo) {
		orderSampleService.export(response, params, vo);
	}

	/**
	 * 推送SAP
	 * @param vo
	 */
	@RequiresPermissions("order:orderSample:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public OrderSampleVo pushSAP(String id) {
		 return  orderSampleService.tsSapAndWriteLog(id);
	}
	
	/**
     * @function 样机订单撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("order:orderSample:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(OrderSampleVo vo) {
    	orderSampleService.cancel(vo);
    }
	
	/**
     * function 样机订单变更
     * @param vo
     */
    @RequiresPermissions("order:orderSample:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderSampleVo vo) {
    	orderSampleService.change(vo);
    }
    
    /**
     * function 样机订单取回
     * @param vo
     */
    @RequiresPermissions("order:orderSample:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderSampleVo vo) {
    	orderSampleService.getback(vo);
    }
}