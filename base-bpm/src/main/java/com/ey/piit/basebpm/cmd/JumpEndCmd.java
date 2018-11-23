package com.ey.piit.basebpm.cmd;

import java.util.List;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityManager;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.task.Comment;

public class JumpEndCmd implements Command<Comment> {

	private String taskId;

	public JumpEndCmd(String taskId) {
		this.taskId = taskId;
	}

	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		TaskEntityManager taskEntityManager = commandContext.getTaskEntityManager();
		TaskEntity taskEntity = taskEntityManager.findTaskById(taskId);
		
		String executionId = taskEntity.getExecutionId();
		
		taskEntityManager.deleteTask(taskEntity, "jump", false);
		
		ExecutionEntity executionEntity = commandContext.getExecutionEntityManager().findExecutionById(executionId);
		ProcessDefinitionImpl processDefinition = executionEntity.getProcessDefinition();
		
		for (ActivityImpl activityImpl : processDefinition.getActivities()) {
			List<PvmTransition> pvmTransitionList = activityImpl.getOutgoingTransitions();
			if (pvmTransitionList.isEmpty() && "endEvent".equals(activityImpl.getProperty("type"))) {
				executionEntity.executeActivity(activityImpl);
				return null;
			}
		}
		
		return null;
	}

}
