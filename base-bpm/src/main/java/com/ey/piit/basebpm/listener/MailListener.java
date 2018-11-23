package com.ey.piit.basebpm.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MailListener implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Object variable = execution.getVariable("id");
		execution.setVariable("id", variable+"1");
		System.out.println("发邮件/设置状态"+variable);
	}

}
