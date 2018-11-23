package com.ey.piit.basebpm.cmd;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;
import org.activiti.engine.task.Comment;

public class CreateExecutionCmd implements Command<Comment> {

	private String processInstanceId;
	private String executionId;
	
	public CreateExecutionCmd(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	
	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		ExecutionEntityManager executionEntityManager = commandContext.getExecutionEntityManager();
		ExecutionEntity executionEntity = executionEntityManager.findExecutionById(processInstanceId);
		ExecutionEntity childExecutionEntity = executionEntity.createExecution();
		childExecutionEntity.setConcurrent(true);
		childExecutionEntity.setScope(false);
		executionId = childExecutionEntity.getId();
		
		return null;
	}

	public String getExecutionId() {
		return executionId;
	}
}
