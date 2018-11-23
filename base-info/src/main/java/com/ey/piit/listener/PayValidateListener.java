package com.ey.piit.listener;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.interfaces.delay.dto.DelayMsgRequest;
import com.ey.piit.interfaces.delay.dto.DelayMsgResponse;
import com.ey.piit.interfaces.delay.service.DelayInterfaceService;
import com.ey.piit.sdo.order.service.OrderDiversityService;
import com.ey.piit.sdo.order.service.OrderFyService;
import com.ey.piit.sdo.order.service.OrderProductService;
import com.ey.piit.sdo.order.vo.OrderDiversityVo;
import com.ey.piit.sdo.order.vo.OrderFyVo;
import com.ey.piit.sdo.order.vo.OrderProductVo;
import com.ey.piit.sdo.payment.service.PaySpecialService;
import com.ey.piit.sdo.payment.service.PayValidateService;
import com.ey.piit.sdo.payment.vo.PayValidateVo;
import com.ey.piit.sdo.pso.service.PsoService;
import com.ey.piit.sdo.pso.vo.PsoVo;
/**
 * 付款保障监听类
 * 订单、预走货审批流中使用
 * @author Gaowh
 *
 */
public class PayValidateListener implements JavaDelegate {
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		try {
			PayValidateService payValidateService = SpringUtils.getBean(PayValidateService.class);
			PsoService psoService = SpringUtils.getBean(PsoService.class);
			PaySpecialService paySpecialService = SpringUtils.getBean(PaySpecialService.class);
			OrderProductService orderProductService = SpringUtils.getBean(OrderProductService.class);
			OrderFyService orderFyService = SpringUtils.getBean(OrderFyService.class);
			OrderDiversityService orderDiversityService = SpringUtils.getBean(OrderDiversityService.class);
			Map<String, Object> param = new HashMap<String,Object>();
			Object jclx = execution.getVariable("jclx");//操作类型分为订单(order)和预走货(pso)
			//订单审批流付款保障检查
			if("order".equals(jclx.toString())){
				Object id = execution.getVariable("id");
				Object ddlx = execution.getVariable("ddlx");
				//进行订单付款保障检查
				param = (Map<String, Object>) payValidateService.payCheckOrder(id.toString(), ddlx.toString());
			    //大货订单，取消应收风险岗，先做付款保障，再调用终审过程
			    if (param != null && "SDO-000000".equals(param.get("resultCode").toString()) && "1".equals(ddlx.toString())) {
			    	OrderProductVo vo = new OrderProductVo();
			    	vo.setId(id.toString());
			    	vo.setApproveType(3);
			    	try {
			    		orderProductService.listenerApprove(vo);
					} catch (Exception e) {
						throw new ServiceException(e.getMessage());
						//throw e;
					}
				}
			    //多元化订单，不管成功与否，先做付款保障检查，再审核
			    if (param != null  && "4".equals(ddlx.toString())) {
			    	OrderDiversityVo vo = new OrderDiversityVo();
			    	vo.setId(id.toString());
			    	if("SDO-000000".equals(param.get("resultCode").toString())){
			    		vo.setApproveType(3);
			    	}else{
			    		vo.setApproveType(1);
			    	}
			    	try {
			    		orderDiversityService.listenerApprove(vo);
					} catch (Exception e) {
						throw new ServiceException(e.getMessage());
						//throw e;
					}
				}
			    //副营订单，不管成功与否，先做付款保障检查，再审核
			    if (param != null  && "5".equals(ddlx.toString())) {
			    	OrderFyVo vo = new OrderFyVo();
			    	vo.setId(id.toString());
			    	if("SDO-000000".equals(param.get("resultCode").toString())){
			    		vo.setApproveType(3);
			    	}else{
			    		vo.setApproveType(1);
			    	}
			    	try {
			    		orderFyService.listenerApprove(vo);
					} catch (Exception e) {
						throw new ServiceException(e.getMessage());
						//throw e;
					}
				}
			}else if("pso".equals(jclx.toString())){	//预走货审批流付款保障检查
				Object id = execution.getVariable("id");
				Object khbm = execution.getVariable("khbm");//客户编码
				Object yzhdh = execution.getVariable("yzhdh");//与走货单号
				Object khlx = execution.getVariable("khlx");//客户类型
				Map<String, String> result=new HashMap<String, String>();
				Map<String, Object> psoResult=new HashMap<String, Object>();
				String yscqResult = "";//应收超期结果初始化
				if( khbm != null){
					//记录日志 并回写预走货应收超期字段状态
					PayValidateVo payValidateVo = new PayValidateVo();
					if("D001".equals(khlx.toString())){
						//若为品牌分公司客户则不进行应收超期检查，默认无应收超期
						payValidateVo.setZy("该客户为品牌分公司客户，默认没有应收超期！");
					}else{
						//查询预走货是否含有收费订单
						psoResult = psoService.callQueryPsoFree(id.toString());
						if("0".equals(psoResult.get("resultCode").toString())){
							//客户应收超期检查
							result = checkYscq(khbm.toString());
							payValidateVo.setZy(result.get("message"));
						}else{
							payValidateVo.setZy("预走货中不含收费订单，默认没有应收超期！");
						}
					}
					payValidateVo.setId(id.toString());
					payValidateVo.setJd("预走货");
					payValidateVo.setYzhdh(yzhdh.toString());
					payValidateVo.setDdid(null);
					//记录付款保障日志
					payValidateService.paySaveLog(payValidateVo);
					//回写预走货主表应收超期字段
					PsoVo psoVo = new PsoVo();
					psoVo.setId(id.toString());
					if("D001".equals(khlx.toString())){
						//若为品牌分公司客户则不进行应收超期检查，默认无应收超期
						psoVo.setYssfcq(0);
						psoVo.setNr("该客户为品牌分公司客户，默认没有应收超期！");
						//将应收超期结果设为应收不超期
						yscqResult = "0";
					}else{
						if(!"0".equals(psoResult.get("resultCode").toString())){
							//若不含收费订单则默认无应收超期
							psoVo.setYssfcq(0);
							psoVo.setNr("预走货不含收费订单，默认没有应收超期！");
							//将应收超期结果设为应收不超期
							yscqResult = "0";
						}else{
							psoVo.setYssfcq(Integer.parseInt(result.get("result").toString()));
							psoVo.setNr(result.get("message"));
							yscqResult = result.get("result");
						}
					}
					psoService.callPsoYscqSave(psoVo);
					//超期
					if("1".equals(yscqResult)){
						//检查是否应收超期特批  T_PAY_SPECIAL 判断是否存在应收超期特批  调用特批的服务层
						param = (Map<String, Object>) paySpecialService.queryYscqtp(yzhdh.toString());
						if(param != null && "SDO-000000".equals(param.get("resultCode").toString())){
							//如果存在应收超期特批，则继续进行付款保障检查
							param = (Map<String, Object>) payValidateService.payCheckPso(id.toString());
						}
					}else{
						//不超期 继续检查付款保障
						param = (Map<String, Object>) payValidateService.payCheckPso(id.toString());
					}
				}else {
					throw new ServiceException("客户应收超期检查，客户编码不能为空！");
				}		
			}else{
				throw new ServiceException("启动审批流时，未传入检查类型！");
			}
			if (param != null && "SDO-000000".equals(param.get("resultCode").toString())) {
				execution.setVariable("fkbz", "1");// 付款保障通过为1
				
			}else{
				execution.setVariable("fkbz", "0");// 不通过为0
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// 检查应收超期，返回值： 0 ：没有应收超期 1：有应收超期
	private Map<String, String> checkYscq(String khbm) {
		DelayMsgRequest delayMsgRequest = new DelayMsgRequest();
		DelayMsgResponse delayMsgResponse = new DelayMsgResponse();
		Map<String, String> map = new HashMap<String, String>();
		String result = "0";
		delayMsgRequest.setKhbm(khbm);
		DelayInterfaceService elayInterfaceService = SpringUtils.getBean(DelayInterfaceService.class);
		try {
			delayMsgResponse = elayInterfaceService.qryKhYscqFromSap(delayMsgRequest);
		} catch (Exception e) {
			throw new ServiceException("调用SAP应收超期查询接口出错!");
		}
		if(delayMsgResponse == null){
			//throw new ServiceException("根据客户编码未在SAP取到数据!");
			map.put("result",result.toString());
			map.put("message", "客户是否应收超期：否");
			return map;
		}
		if(delayMsgResponse.getCqts() >= 5){
			result = "1";
		}
		map.put("result",result.toString());
		if("1".equals(result)){
			map.put("message", "客户是否应收超期：是"+delayMsgResponse.toString());
		}else {
			map.put("message", "客户是否应收超期：否"+delayMsgResponse.toString());
		}
		return map;
	}
}
