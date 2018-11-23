package com.ey.piit.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.sdo.order.service.OrderDiversityService;
import com.ey.piit.sdo.order.service.OrderFyService;
import com.ey.piit.sdo.order.service.OrderSampleService;
import com.ey.piit.sdo.order.service.OrderSpoService;
import com.ey.piit.sdo.orderProduct.service.OrderProductNewService;
/**
 * 订单审批流推送SAP监听
 * @author Gaowh
 *
 */
public class OrderNewInterfaceListener implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
			
		try {
				OrderProductNewService orderProductNewService = SpringUtils.getBean(OrderProductNewService.class);
				OrderSampleService orderSampleService = SpringUtils.getBean(OrderSampleService.class);
				OrderSpoService orderSpoService = SpringUtils.getBean(OrderSpoService.class);
				OrderDiversityService orderDiversityService = SpringUtils.getBean(OrderDiversityService.class);
				OrderFyService orderFyService = SpringUtils.getBean(OrderFyService.class);
				Object ddlx = execution.getVariable("ddlx");
				String id =  execution.getVariable("id").toString();
				String sfBg = execution.getVariable("sfBg").toString();//是否变更，1是变更
				String sfCh = execution.getVariable("sfCh").toString();//是否撤回，1是撤回
				String tssapzt = execution.getVariable("tssapzt").toString();//推送SAP状态 1已推过
					//订单推送SAP接口调用
				switch (ddlx.toString()) {
				case "1":
					//大货订单
					if("1".equals(sfBg) || "1".equals(tssapzt) || "1".equals(sfCh)){
						orderProductNewService.active(id);
					}else{
						orderProductNewService.tsSapAndWriteLog(id);
					}
					break;
				case "2":
					//备损订单
					if("1".equals(sfBg) || "1".equals(tssapzt) || "1".equals(sfCh)){
						orderSpoService.active(id);
					}else{
						orderSpoService.tsSapAndWriteLog(id);
					}
					break;
				case "3":
					//样机订单
					if("1".equals(sfBg) || "1".equals(tssapzt) || "1".equals(sfCh)){
						orderSampleService.active(id);
					}else{
						orderSampleService.tsSapAndWriteLog(id);
					}
					break;
				case "4":
					//多元化订单
					if("1".equals(sfBg) || "1".equals(tssapzt) || "1".equals(sfCh)){
						orderDiversityService.active(id);
					}else {
						orderDiversityService.tsSapAndWriteLog(id);
					}
					break;
				case "5":
					//外采、工装、线体、模具订单
					if("1".equals(sfBg) || "1".equals(tssapzt) || "1".equals(sfCh)){
						orderFyService.active(id);
					}else {
						orderFyService.tsSapAndWriteLog(id);
					}
					break;
				
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				//throw e;
			}
	}

}