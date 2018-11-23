package com.ey.piit.basebpm.cmd;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.task.Comment;

public class CreateTaskCmd implements Command<Comment> {

	private String activityId;
	private String executionId;

	public CreateTaskCmd(String executionId, String activityId) {
		this.executionId = executionId;
		this.activityId = activityId;
	}

	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		ExecutionEntityManager executionEntityManager = commandContext.getExecutionEntityManager();
		
		ExecutionEntity executionEntity = executionEntityManager.findExecutionById(executionId);
		ProcessDefinitionImpl processDefinition = executionEntity.getProcessDefinition();
		
		ActivityImpl activity = processDefinition.findActivity(activityId);
		executionEntity.executeActivity(activity);
		return null;
	}

}