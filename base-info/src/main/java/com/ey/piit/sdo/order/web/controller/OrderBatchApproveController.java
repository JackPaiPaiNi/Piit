package com.ey.piit.sdo.order.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.order.service.OrderDiversityService;
import com.ey.piit.sdo.order.service.OrderFyService;
import com.ey.piit.sdo.order.service.OrderProductFzbgService;
import com.ey.piit.sdo.order.service.OrderProductService;
import com.ey.piit.sdo.order.service.OrderSampleFzbgService;
import com.ey.piit.sdo.order.service.OrderSampleService;
import com.ey.piit.sdo.order.service.OrderSpoService;
import com.ey.piit.sdo.order.vo.OrderBatchApproveVo;
import com.ey.piit.sdo.order.vo.OrderDiversityVo;
import com.ey.piit.sdo.order.vo.OrderFyVo;
import com.ey.piit.sdo.order.vo.OrderProductVo;
import com.ey.piit.sdo.order.vo.OrderSampleVo;
import com.ey.piit.sdo.order.vo.OrderSpoVo;
import com.ey.piit.sdo.orderProduct.service.OrderProductNewFzbgService;
import com.ey.piit.sdo.orderProduct.service.OrderProductNewService;
import com.ey.piit.sdo.orderProduct.vo.OrderProductNewVo;

/**
 * 订单批量审批通过管理Controller
 * 
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "order/batchApprove")
public class OrderBatchApproveController extends BaseController {
	
	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private OrderProductFzbgService orderProductFzbgService;
	
	@Autowired
	private OrderProductNewService orderProductNewService;
	@Autowired
	private OrderProductNewFzbgService orderProductNewFzbgService;
	
	@Autowired
	private OrderSpoService orderSpoService;
	@Autowired
	private OrderSampleService orderSampleService;
	@Autowired
	private OrderSampleFzbgService orderSampleFzbgService;
	@Autowired
	private OrderDiversityService orderDiversityService;
	@Autowired
	private OrderFyService orderFyService;
	
	/**
	 * 
	 * @param id 单据业务ID
	 * @param processId 流程实例ID
	 * @param taskId 当前任务ID
	 * 批处理订单待办时，审批操作全部为通过（即approveType=1）
	 * 驳回到申请岗的待办不能批量处理
	 * 
	 * @return
	 */
	@RequiresPermissions("order:batchApprove:approve")
	@RequestMapping(value = "approve")
    @ResponseBody
    public Object approve(@RequestParam(value = "approveJson")String approveJson) {
		JSONArray jsonArray = JSONArray.fromObject(approveJson);
		@SuppressWarnings("unchecked")
		List<OrderBatchApproveVo> approveList = (List<OrderBatchApproveVo>) JSONArray.toCollection(jsonArray, 
				OrderBatchApproveVo.class);
		// 不符合批量条件的待办数
		int count = 0;
		for(OrderBatchApproveVo approveVo : approveList){
			if("order/orderProduct/approvePage".equals(approveVo.getFormKey())
					|| "order/orderProduct/cancelApprovePage".equals(approveVo.getFormKey())
					|| "orderfzbg/orderProductFzbg/approvePage".equals(approveVo.getFormKey())){
				// 大货订单（正常审批、暂停/启用、取消/撤回）
				OrderProductVo vo = (OrderProductVo) orderProductService.callQueryById(approveVo.getId());
				vo.setProcessId(approveVo.getProcessId());
				vo.setTaskId(approveVo.getTaskId());
				vo.setApproveType(1);
				if("order/orderProduct/approvePage".equals(approveVo.getFormKey())){
					// 大货订单（正常审批、暂停/启用）
					if(vo.getSfZt() != null && vo.getSfZt() == 1){
						orderProductService.pauseApprove(vo);
					} else {
						vo.setSfjp(1);
						orderProductService.approve(vo);
					}
				} else if("order/orderProduct/cancelApprovePage".equals(approveVo.getFormKey())){
					// 大货订单取消/撤回
					orderProductService.cancelApprove(vo);
				} else if("orderfzbg/orderProductFzbg/approvePage".equals(approveVo.getFormKey())){
					// 大货订单辅助变更
					vo = (OrderProductVo) orderProductFzbgService.callQueryById(approveVo.getId());
					vo.setProcessId(approveVo.getProcessId());
					vo.setTaskId(approveVo.getTaskId());
					vo.setApproveType(1);
					orderProductFzbgService.approve(vo);
				} 
			}else if("order/orderProductNew/approvePage".equals(approveVo.getFormKey())
					|| "order/orderProductNew/cancelApprovePage".equals(approveVo.getFormKey())
					|| "orderfzbg/orderProductNewFzbg/approvePage".equals(approveVo.getFormKey())){
				// 大货订单（正常审批、暂停/启用、取消/撤回）
				OrderProductNewVo vo = (OrderProductNewVo) orderProductNewService.callQueryById(approveVo.getId());
				vo.setProcessId(approveVo.getProcessId());
				vo.setTaskId(approveVo.getTaskId());
				vo.setApproveType(1);
				if("order/orderProductNew/approvePage".equals(approveVo.getFormKey())){
					// 大货订单（正常审批、暂停/启用）
					if(vo.getSfZt() != null && vo.getSfZt() == 1){
						orderProductNewService.pauseApprove(vo);
					} else {
						vo.setSfjp(1);
						orderProductNewService.approve(vo);
					}
				} else if("order/orderProductNew/cancelApprovePage".equals(approveVo.getFormKey())){
					// 大货订单取消/撤回
					orderProductNewService.cancelApprove(vo);
				} else if("order/orderProductNewFzbg/approvePage".equals(approveVo.getFormKey())){
					// 大货订单辅助变更
					vo = (OrderProductNewVo) orderProductNewFzbgService.callQueryById(approveVo.getId());
					vo.setProcessId(approveVo.getProcessId());
					vo.setTaskId(approveVo.getTaskId());
					vo.setApproveType(1);
					orderProductNewFzbgService.approve(vo);
				} 
			} else if("order/orderSpo/approvePage".equals(approveVo.getFormKey())){
				// 备损订单
				OrderSpoVo vo = orderSpoService.callQueryById(approveVo.getId());
				vo.setProcessId(approveVo.getProcessId());
				vo.setTaskId(approveVo.getTaskId());
				vo.setApproveType(1);
				orderSpoService.approve(vo);
			} else if("order/orderSample/approvePage".equals(approveVo.getFormKey())
					|| "orderfzbg/orderSampleFzbg/approvePage".equals(approveVo.getFormKey())){
				// 样机订单
				OrderSampleVo vo = (OrderSampleVo) orderSampleService.callQueryById(approveVo.getId());
				vo.setProcessId(approveVo.getProcessId());
				vo.setTaskId(approveVo.getTaskId());
				vo.setApproveType(1);
				if("order/orderSample/approvePage".equals(approveVo.getFormKey())){
					// 样机订单正常审批
					orderSampleService.approve(vo);
				} else if("orderfzbg/orderSampleFzbg/approvePage".equals(approveVo.getFormKey())){
					// 样机订单辅助变更
					vo = (OrderSampleVo) orderSampleFzbgService.callQueryById(approveVo.getId());
					vo.setProcessId(approveVo.getProcessId());
					vo.setTaskId(approveVo.getTaskId());
					vo.setApproveType(1);
					orderSampleFzbgService.approve(vo);
				} 
			} else if("order/orderDiversity/approvePage".equals(approveVo.getFormKey())
					|| "order/orderDiversity/cancelApprovePage".equals(approveVo.getFormKey())){
				// 多元化订单
				OrderDiversityVo vo = (OrderDiversityVo) orderDiversityService.callQueryById(approveVo.getId());
				vo.setProcessId(approveVo.getProcessId());
				vo.setTaskId(approveVo.getTaskId());
				vo.setApproveType(1);
				if("order/orderDiversity/approvePage".equals(approveVo.getFormKey())){
					// 多元化订单正常审批
					orderDiversityService.approve(vo);
				} else if("order/orderDiversity/cancelApprovePage".equals(approveVo.getFormKey())){
					// 多元化订单取消审批
					orderDiversityService.cancelApprove(vo);
				}
			} else if("order/orderFy/approvePage".equals(approveVo.getFormKey())
					|| "order/orderFy/cancelApprovePage".equals(approveVo.getFormKey())){
				// 外采、工装、线体订单
				OrderFyVo vo = (OrderFyVo) orderFyService.callQueryById(approveVo.getId());
				vo.setProcessId(approveVo.getProcessId());
				vo.setTaskId(approveVo.getTaskId());
				vo.setApproveType(1);
				if("order/orderFy/approvePage".equals(approveVo.getFormKey())){
					// 采、工装、线体订单正常审批
					orderFyService.approve(vo);
				} else if("order/orderFy/cancelApprovePage".equals(approveVo.getFormKey())){
					// 采、工装、线体订单取消审批
					orderFyService.cancelApprove(vo);
				}
			} else {
				count ++;
			}
		}
		String resultMsg = "成功！";
		if(count > 0){
			resultMsg += "所选待办中有" +count+ "条不符合批量通过条件。";
		}
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("result", "SDO-000000");
		resultMap.put("msg", resultMsg);
		return resultMap;
    }
	
}