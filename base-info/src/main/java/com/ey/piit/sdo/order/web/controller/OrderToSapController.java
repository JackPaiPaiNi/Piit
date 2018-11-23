package com.ey.piit.sdo.order.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.order.entity.OrderToSap;
import com.ey.piit.sdo.order.service.OrderToSapService;
import com.ey.piit.sdo.order.vo.OrderToSapVo;

/**
 * 订单变更推送SAP管理Controller
 * 
 * @author 赵明
 */
@Controller
@RequestMapping(value = "order/orderToSap")
public class OrderToSapController extends BaseController {
	@SuppressWarnings("rawtypes")
	@Autowired
	private OrderToSapService orderToSapService;
	
	@RequiresPermissions("order:orderToSap:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/order/orderToSapList";
	}
	
	@RequiresPermissions("order:orderToSap:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(OrderToSapVo vo, PageJqGrid page) {
		return orderToSapService.callQueryByPage(vo, page);
	}
	@RequiresPermissions("order:orderToSap:view")
	@RequestMapping(value = "closeOrder")
	@ResponseBody
	public Object closeOrder(OrderToSapVo vo) {		
		return orderToSapService.closeOrder(vo);
	}	
	/**
	 * 推送海外SAP,第三个参数：0标识正常推，1表示以新增方式推
	 * @param vo
	 * @throws Exception 
	 */
	@RequiresPermissions("order:orderToSap:view")
	@RequestMapping(value = "pushToHwSAP")
	@ResponseBody
	public Object pushToHwSAP(OrderToSap vo) throws Exception {
		return orderToSapService.tsHwSapAndWriteLog(vo,"1",0);
	}
	/**
	 * 推送制造SAP,第三个参数：0标识正常推，1表示以新增方式推
	 * @param vo
	 * @throws Exception 
	 */
	@RequiresPermissions("order:orderToSap:view")
	@RequestMapping(value = "pushToZzSAP")
	@ResponseBody
	public Object pushToZzSAP(OrderToSap vo) throws Exception {
		return orderToSapService.tsHwSapAndWriteLog(vo,"0",0);
	}
	/**
	 * 以新增推送海外SAP,第三个参数：0标识正常推，1表示以新增方式推
	 * @param vo
	 * @throws Exception 
	 */
	@RequiresPermissions("order:orderToSap:view")
	@RequestMapping(value = "addpushToHwSAP")
	@ResponseBody
	public Object addpushToHwSAP(OrderToSap vo) throws Exception {
		return orderToSapService.tsHwSapAndWriteLog(vo,"1",1);
	}
	/**
	 * 以新增推送制造SAP,第三个参数：0标识正常推，1表示以新增方式推
	 * @param vo
	 * @throws Exception 
	 */
	@RequiresPermissions("order:orderToSap:view")
	@RequestMapping(value = "addpushToZzSAP")
	@ResponseBody
	public Object addpushToZzSAP(OrderToSap vo) throws Exception {
		return orderToSapService.tsHwSapAndWriteLog(vo,"0",1);
	}
}