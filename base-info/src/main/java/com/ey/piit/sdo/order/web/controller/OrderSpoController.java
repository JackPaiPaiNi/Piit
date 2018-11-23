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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.entity.Role;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.order.service.OrderSpoService;
import com.ey.piit.sdo.order.vo.OrderLogVo;
import com.ey.piit.sdo.order.vo.OrderSpoItemVo;
import com.ey.piit.sdo.order.vo.OrderSpoVo;
import com.ey.piit.sdo.pub.service.PubDataService;

/**
 * 备损订单管理Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "order/orderSpo")
public class OrderSpoController extends BaseController {

	@Autowired
	private OrderSpoService orderSpoService;
	@Autowired
	private PubDataService pubDataService;
	@Autowired
    private ExcelImporter excelImporter;
	
	@RequiresPermissions("order:orderSpo:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/order/orderSpoList";
	}
	
	@RequiresPermissions("order:orderSpo:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(OrderSpoVo vo, PageJqGrid page) {
		return orderSpoService.callQueryByPage(vo, page);
    }
    
	@RequiresPermissions("order:orderSpo:view")
	@Token(create = true)
    @RequestMapping(value = "changeEditPage", method = RequestMethod.GET)
    public String changeEditPage(){
    	return "sdo/order/orderSpoJexxEdit";
    }
	
	@RequiresPermissions("order:orderSpo:view")
	@Token(create = true)
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public ModelAndView editPage(){
		ModelAndView  mv = new  ModelAndView("sdo/order/orderSpoEdit");
		mv.addObject("sfKszy",this.getsfKszy());
    	return mv;
    }
	
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	OrderSpoVo vo =  orderSpoService.callQueryById(id) ;
    	vo.setSfKszy(this.getsfKszy());
    	return   vo;
    }
    

    @RequiresPermissions("order:orderSpo:edit")
    @RequestMapping(value = "edit")
    @Token(verify = true)
    @ResponseBody
    public Object edit(OrderSpoVo vo, @RequestParam(value = "wlList")String wlList) {
    	JSONArray wlArray = JSONArray.fromObject(wlList);
		@SuppressWarnings("unchecked")
		List<OrderSpoItemVo> wllist = (List<OrderSpoItemVo>) JSONArray.toCollection(wlArray, OrderSpoItemVo.class);
		vo.setOrderSpoItemList(wllist);
		return orderSpoService.edit(vo);
    }
    
    @RequiresPermissions("order:orderSpo:edit")
    @RequestMapping(value = "submit")
    @Token(verify = true)
    @ResponseBody
    public void submit(OrderSpoVo vo, @RequestParam(value = "wlList")String wlList) {
    	JSONArray wlArray = JSONArray.fromObject(wlList);
		@SuppressWarnings("unchecked")
		List<OrderSpoItemVo> wllist = (List<OrderSpoItemVo>) JSONArray.toCollection(wlArray, OrderSpoItemVo.class);
		vo.setOrderSpoItemList(wllist);
		orderSpoService.submit(vo);
    }
    
    @RequiresPermissions("order:orderSpo:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc, int zt, String processId) {
		orderSpoService.delete(id, sjc, zt, processId);
    }
	
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/order/orderSpoView");
    	view.addObject("orderSpo",orderSpoService.callQueryById(id)); 
    	return view;
    }
    @RequestMapping(value = "viewPageByDh", method = RequestMethod.GET)
    public ModelAndView viewPageByDh(String ddid){
		ModelAndView view = new ModelAndView("sdo/order/orderSpoView");
    	view.addObject("orderSpo",orderSpoService.callQueryByDh(ddid)); 
    	return view;
    }
	
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    public String approvePage(){
    	return "sdo/order/orderSpoApprove";
    }
    
    @RequestMapping(value = "approve")
    @ResponseBody
    public Object approve(OrderSpoVo vo) {
		return orderSpoService.approve(vo);
    }
    
	@RequiresPermissions("order:orderSpo:view")
    @RequestMapping(value = "printPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/order/orderSpoPrint");
    	view.addObject("orderSpo",orderSpoService.callQueryById(id)); 
    	return view;
    }
	
	@RequiresPermissions("order:orderSpo:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderSpoVo vo) {
		orderSpoService.export(response, params, vo);
	}

	@RequiresPermissions("order:orderSpo:edit")
    @RequestMapping(value = "importExcel")
    @ResponseBody
	public Object importExcel(MultipartFile file){
    	List<OrderSpoItemVo> list = excelImporter.importFileReturn(OrderSpoItemVo.class, file, null);
    	String wlbms = "";
    	for (OrderSpoItemVo orderSpoItemVo : list) {
    		wlbms = wlbms + orderSpoItemVo.getWlbh() + ",";
		}
    	Map<String, Object> param1 = pubDataService.checkwl(wlbms);
		if ("SDO-000000".equals(param1.get("resultCode").toString())) {
    		Paginator paginator = new Paginator(1, 1000, list.size());
    		return new PageList<OrderSpoItemVo>(list,paginator);
		}else{
			throw new ServiceException("物料" + param1.get("resultMsg").toString() + "不存在！");
		}
	}
	
	/**
	 * 推送SAP
	 * @param vo
	 */
	@RequiresPermissions("order:orderSpo:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public OrderSpoVo pushSAP(String id) {
		return  orderSpoService.tsSapAndWriteLog(id);
	}
	
	/**
     * @function 备损订单撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("order:orderSpo:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(OrderSpoVo vo) {
    	orderSpoService.cancel(vo);
    }
	
	/**
     * function 备损订单变更
     * @param vo
     */
    @RequiresPermissions("order:orderSpo:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderSpoVo vo) {
    	orderSpoService.change(vo);
    }
    
    /**
     * function 备损订单取回
     * @param vo
     */
    @RequiresPermissions("order:orderSpo:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderSpoVo vo) {
    	orderSpoService.getback(vo);
    }
    /**
	 * 备损订单物料明细明细导出 
	 * 修改人：赵桃军 2016-12-7
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("order:orderSpo:view")
	@RequestMapping(value = "itemExport")
	@ResponseBody
	public void exportCkdFile(HttpServletResponse response, @RequestParam Map<String, Object> params,
			OrderSpoItemVo vo) {
		orderSpoService.exportWlxx(response, params, vo);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private int getsfKszy(){
		int sfKszy = 0 ;
		List<Role> list = (List) UserUtils.getRole();
		for (Role role : list) {
			if (  "1-yx-kszy".equals(role.getCode())){
				sfKszy = 1 ;
				break ;
			}
	    }
		return   sfKszy ;
		
	}
	
	@RequestMapping(value = "/findDqclrById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findDqclrById(String id){
		OrderLogVo vo =  orderSpoService.callQueryDqclrById(id) ;
    	return   vo;
    }
}