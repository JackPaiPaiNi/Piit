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
import com.ey.piit.sdo.order.service.OrderFyService;
import com.ey.piit.sdo.order.vo.OrderFyItemVo;
import com.ey.piit.sdo.order.vo.OrderFyVo;

/**
 * 副营订单管理Controller
 * @author tianrong
 */
@Controller
@RequestMapping(value = "order/orderFy")
public class OrderFyController extends BaseController {

	@Autowired
	private OrderFyService orderFyService;
	
	@RequiresPermissions("order:orderFy:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/order/orderFyList";
	}
	
	@RequiresPermissions("order:orderFy:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(OrderFyVo vo, PageJqGrid page) {
		return orderFyService.callQueryByPage(vo, page);
    }
	
    @RequiresPermissions("order:orderFy:edit")
    @RequestMapping(value = "edit")
    @Token(verify = true)
    @ResponseBody
    public Object edit(OrderFyVo vo, @RequestParam(value = "cpList")String cpList) {
    	JSONArray cpArray = JSONArray.fromObject(cpList);
		@SuppressWarnings("unchecked")
		List<OrderFyItemVo> cplist = (List<OrderFyItemVo>) JSONArray.toCollection(cpArray, OrderFyItemVo.class);
    	vo.setOrderFyItemList(cplist);
		return orderFyService.edit(vo);
    }
    
    @RequiresPermissions("order:orderFy:edit")
    @RequestMapping(value = "submit")
    @Token(verify = true)
    @ResponseBody
    public void submit(OrderFyVo vo, @RequestParam(value = "cpList")String cpList) {
    	JSONArray cpArray = JSONArray.fromObject(cpList);
		@SuppressWarnings("unchecked")
		List<OrderFyItemVo> cplist = (List<OrderFyItemVo>) JSONArray.toCollection(cpArray, OrderFyItemVo.class);
    	vo.setOrderFyItemList(cplist);
		orderFyService.submit(vo);
    }
    
    @RequiresPermissions("order:orderFy:view")
    @Token(create = true)
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public String editPage(){
    	return "sdo/order/orderFyEdit";
    }
	
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return orderFyService.callQueryById(id);
    }
    
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/order/orderFyView");
    	view.addObject("orderFy",orderFyService.callQueryById(id)); 
    	return view;
    }
    @RequestMapping(value = "viewPageByDh", method = RequestMethod.GET)
    public ModelAndView viewPageByDh(String ddid){
		ModelAndView view = new ModelAndView("sdo/order/orderFyView");
    	view.addObject("orderFy",orderFyService.callQueryByDh(ddid)); 
    	return view;
    }
	
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    public String approvePage(){
    	return "sdo/order/orderFyApprove";
    }
    
    @RequestMapping(value = "approve")
    @ResponseBody
    public Object approve(OrderFyVo vo) {
    	return orderFyService.approve(vo);
    }
	
    @RequiresPermissions("order:orderFy:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc, int zt, String processId) {
    	orderFyService.delete(id, sjc, zt, processId);
    }
    
    @RequestMapping(value = "printPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/order/orderFyPrint");
    	view.addObject("orderFy",orderFyService.callQueryById(id)); 
    	return view;
    }
	
	@RequiresPermissions("order:orderFy:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderFyVo vo) {
		orderFyService.export(response, params, vo);
	}

	/**
	 * 推送SAP
	 * @param vo
	 */
	@RequiresPermissions("order:orderFy:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public OrderFyVo pushSAP(String id) {
		return orderFyService.tsSapAndWriteLog(id);
	}
	
	/**
     * @function 副营订单撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("order:orderFy:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(OrderFyVo vo) {
    	orderFyService.cancel(vo);
    }
    
    @RequestMapping(value = "cancelApprovePage", method = RequestMethod.GET)
	public String cancelApprovePage() {
		return "sdo/order/orderFyCancelApprove";
	}
    
    @RequestMapping(value = "cancelApprove")
	@ResponseBody
	public void cancelApprove(OrderFyVo vo) {
    	orderFyService.cancelApprove(vo);
	}
	
	/**
     * function 副营订单变更
     * @param vo
     */
    @RequiresPermissions("order:orderFy:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderFyVo vo) {
    	orderFyService.change(vo);
    }
    
    /**
     * function 副营订单取回
     * @param vo
     */
    @RequiresPermissions("order:orderFy:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderFyVo vo) {
    	orderFyService.getback(vo);
    }
}