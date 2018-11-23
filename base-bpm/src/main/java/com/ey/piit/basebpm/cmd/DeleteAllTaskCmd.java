package com.ey.piit.basebpm.cmd;

import java.util.List;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityManager;
import org.activiti.engine.task.Comment;

public class DeleteAllTaskCmd implements Command<Comment> {

	private String processInstanceId;

	public DeleteAllTaskCmd(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		ExecutionEntityManager executionEntityManager = commandContext.getExecutionEntityManager();
		TaskEntityManager taskEntityManager = commandContext.getTaskEntityManager();
		
		ExecutionEntity executionEntity = executionEntityManager.findExecutionById(processInstanceId);
		List<TaskEntity> tasks = executionEntity.getTasks();
		for (int i = 0; i < tasks.size(); i++) {
			TaskEntity taskEntity = tasks.get(i);
			taskEntityManager.deleteTask(taskEntity, "del", false);
		}
		
		List<ExecutionEntity> executionEntityList = executionEntityManager.findChildExecutionsByParentExecutionId(processInstanceId);
		for (int i = 0; i < executionEntityList.size(); i++) {
			ExecutionEntity childExecutionEntity = executionEntityList.get(i);
			childExecutionEntity.deleteCascade("reject");
		}
		
		return null;
	}

}