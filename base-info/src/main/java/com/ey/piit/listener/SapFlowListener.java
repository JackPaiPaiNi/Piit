package com.ey.piit.listener;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.ey.piit.basebpm.service.ProcessInstanceService;
import com.ey.piit.core.entity.Role;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.saprebate.service.RebateService;
import com.ey.piit.sdo.saprebate.vo.TitleVo;

/**
 * SAP审批流推送听类 SAP费用申请流程用
 * 
 * @author ZhaoTaoJun
 *
 */
public class SapFlowListener implements JavaDelegate {

	private RebateService rebateService;
	private ProcessInstanceService processInstanceService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		try {
			this.processInstanceService = SpringUtils.getBean(ProcessInstanceService.class);
			String id = execution.getProcessBusinessKey();
			boolean isEnd = processInstanceService.isProcessEnd(execution.getProcessInstanceId());
			this.rebateService = SpringUtils.getBean(RebateService.class);
			TitleVo vo = rebateService.callQueryExpApplyById(id);
			List<Role> list = (List) UserUtils.getRole();
			for (Role role : list) {
				// 当前审批人角色为分公司总经理，且非终审，则推送SAP做费用预提
				if ("6-fgs-fz".equals(role.getCode()) && !isEnd) {
					//推送，并保存日志
					rebateService.saveTsSapLog(vo, rebateService.listenerPushSAP(vo));
					// 根据推送SAP结果设置流程变量
					if (vo.getTssapzt() == 1) {
						execution.setVariable("tssapzt", 1);
					} else {
						execution.setVariable("tssapzt", 0);
					}
					/*//测试阶段，推送状态都为通过，正式部署，注掉掉此行，打开上面注释代码
					execution.setVariable("tssapzt", 1);*/
					break;
				}
				// 当前角色为总部财务总监,直接推送SAP做费用预提
				if ("1-yx-cwzj".equals(role.getCode())) {
					//推送，并保存日志
					rebateService.saveTsSapLog(vo, rebateService.listenerPushSAP(vo));
					// 根据推送SAP结果设置流程变量
					if (vo.getTssapzt() == 1) {
						execution.setVariable("tssapzt", 1);
					} else {
						execution.setVariable("tssapzt", 0);
					}
					/*//测试阶段，推送状态都为通过，正式部署，注掉掉此行，打开上面注释代码
					execution.setVariable("tssapzt", 1);*/
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
