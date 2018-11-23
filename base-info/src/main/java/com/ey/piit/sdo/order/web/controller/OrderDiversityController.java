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
import com.ey.piit.sdo.order.service.OrderDiversityService;
import com.ey.piit.sdo.order.vo.OrderDiversityItemVo;
import com.ey.piit.sdo.order.vo.OrderDiversityVo;

/**
 * 多元化订单管理Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "order/orderDiversity")
public class OrderDiversityController extends BaseController {

	@Autowired
	private OrderDiversityService orderDiversityService;
	
	@RequiresPermissions("order:orderDiversity:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/order/orderDiversityList";
	}
	
	/**
	 * 多元化屏List页面
	 * @return
	 */
	@RequiresPermissions("order:orderDiversity:view")
	@RequestMapping(value = {"screenList"})
	public String screenList() {
		return "sdo/order/orderDiversityScreenList";
	}
	/**
	 * 多元化屏查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("order:orderDiversity:view")
    @RequestMapping(value = "screenSearch")
    @ResponseBody
    public Object screenSearch(OrderDiversityVo vo, PageJqGrid page) {
		return orderDiversityService.callQueryScreenByPage(vo, page);
    }
	
	@RequiresPermissions("order:orderDiversity:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(OrderDiversityVo vo, PageJqGrid page) {
		return orderDiversityService.callQueryByPage(vo, page);
    }
	
    @RequiresPermissions("order:orderDiversity:edit")
    @RequestMapping(value = "edit")
    @Token(verify = true)
    @ResponseBody
    public Object edit(OrderDiversityVo vo, @RequestParam(value = "cpList")String cpList) {
    	JSONArray cpArray = JSONArray.fromObject(cpList);
		@SuppressWarnings("unchecked")
		List<OrderDiversityItemVo> cplist = (List<OrderDiversityItemVo>) JSONArray.toCollection(cpArray, OrderDiversityItemVo.class);
    	vo.setOrderDiversityItemList(cplist);
		return orderDiversityService.edit(vo);
    }
    
    @RequiresPermissions("order:orderDiversity:edit")
    @RequestMapping(value = "submit")
    @Token(verify = true)
    @ResponseBody
    public void submit(OrderDiversityVo vo, @RequestParam(value = "cpList")String cpList) {
    	JSONArray cpArray = JSONArray.fromObject(cpList);
		@SuppressWarnings("unchecked")
		List<OrderDiversityItemVo> cplist = (List<OrderDiversityItemVo>) JSONArray.toCollection(cpArray, OrderDiversityItemVo.class);
    	vo.setOrderDiversityItemList(cplist);
		orderDiversityService.submit(vo);
    }
    
    @RequiresPermissions("order:orderDiversity:view")
    @Token(create = true)
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public String editPage(){
    	return "sdo/order/orderDiversityEdit";
    }
	
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return orderDiversityService.callQueryById(id);
    }
    
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/order/orderDiversityView");
    	view.addObject("orderDiversity",orderDiversityService.callQueryById(id)); 
    	return view;
    }
    @RequestMapping(value = "viewPageByDh", method = RequestMethod.GET)
    public ModelAndView viewPageByDh(String ddid){
		ModelAndView view = new ModelAndView("sdo/order/orderDiversityView");
    	view.addObject("orderDiversity",orderDiversityService.callQueryByDh(ddid)); 
    	return view;
    }
	
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    public String approvePage(){
    	return "sdo/order/orderDiversityApprove";
    }
    
    @RequestMapping(value = "approve")
    @ResponseBody
    public Object approve(OrderDiversityVo vo) {
    	return orderDiversityService.approve(vo);
    }
	
    @RequiresPermissions("order:orderDiversity:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc, int zt, String processId) {
    	orderDiversityService.delete(id, sjc, zt, processId);
    }
    
    @RequestMapping(value = "printPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/order/orderDiversityPrint");
    	view.addObject("orderDiversity",orderDiversityService.callQueryById(id)); 
    	return view;
    }
	
	@RequiresPermissions("order:orderDiversity:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderDiversityVo vo) {
		orderDiversityService.export(response, params, vo);
	}
	
	@RequiresPermissions("order:orderDiversity:view")
    @RequestMapping(value = "screenExport")
	public void screenExport(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderDiversityVo vo) {
		orderDiversityService.screenExport(response, params, vo);
	}

	/**
	 * 推送SAP
	 * @param vo
	 */
	@RequiresPermissions("order:orderDiversity:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public OrderDiversityVo pushSAP(String id) {
		return orderDiversityService.tsSapAndWriteLog(id);
	}
	
	/**
     * @function 多元化订单撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("order:orderDiversity:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(OrderDiversityVo vo) {
    	orderDiversityService.cancel(vo);
    }
    
    @RequestMapping(value = "cancelApprovePage", method = RequestMethod.GET)
	public String cancelApprovePage() {
		return "sdo/order/orderDiversityCancelApprove";
	}
    
    @RequestMapping(value = "cancelApprove")
	@ResponseBody
	public void cancelApprove(OrderDiversityVo vo) {
    	orderDiversityService.cancelApprove(vo);
	}
	
	/**
     * function 多元化订单变更
     * @param vo
     */
    @RequiresPermissions("order:orderDiversity:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderDiversityVo vo) {
    	orderDiversityService.change(vo);
    }
    
    /**
     * function 多元化订单取回
     * @param vo
     */
    @RequiresPermissions("order:orderDiversity:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderDiversityVo vo) {
    	orderDiversityService.getback(vo);
    }
}