package com.ey.piit.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.sdo.pso.service.PsoService;
import com.ey.piit.sdo.pso.vo.PsoVo;
/**
 * 提交审核监听类
 * 预走货流程使用
 * @author Gaowh
 *
 */
public class PsoEndApproveListener implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		try {
			PsoService psoService = SpringUtils.getBean(PsoService.class);
			Object id = execution.getVariable("id");
			PsoVo psoVo = new PsoVo();
			psoVo.setId((String) id);
			psoVo.setApproveType(3);
			psoService.listenerApprove(psoVo);
			System.out.println("ok");
		} catch (Exception e) {
			throw e;
		}
	}

}