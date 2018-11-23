package com.ey.piit.basebpm.cmd;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityManager;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.task.Comment;

public class JumpTaskCmd implements Command<Comment> {

	private String activityId;
	private String taskId;
	private String taskDefKey;
	private String executionId;

	public JumpTaskCmd(String taskId, String activityId) {
		this.taskId = taskId;
		this.activityId = activityId;
	}

	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		TaskEntityManager taskEntityManager = commandContext.getTaskEntityManager();
		TaskEntity taskEntity = taskEntityManager.findTaskById(taskId);
		
		taskDefKey = taskEntity.getTaskDefinitionKey();
		executionId = taskEntity.getExecutionId();
		
		taskEntityManager.deleteTask(taskEntity, "jump", false);
		
		ExecutionEntity executionEntity = commandContext.getExecutionEntityManager().findExecutionById(executionId);
		ProcessDefinitionImpl processDefinition = executionEntity.getProcessDefinition();
		
		ActivityImpl activity = processDefinition.findActivity(activityId);
		
		executionEntity.executeActivity(activity);
		return null;
	}

	public String getTaskDefKey() {
		return taskDefKey;
	}

	public String getExecutionId() {
		return executionId;
	}

}