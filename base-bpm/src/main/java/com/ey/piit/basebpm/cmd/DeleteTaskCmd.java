package com.ey.piit.basebpm.cmd;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityManager;
import org.activiti.engine.task.Comment;

public class DeleteTaskCmd implements Command<Comment> {

	private String taskId;

	public DeleteTaskCmd(String taskId) {
		this.taskId = taskId;
	}

	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		TaskEntityManager taskEntityManager = commandContext.getTaskEntityManager();
		TaskEntity taskEntity = taskEntityManager.findTaskById(taskId);
		taskEntityManager.deleteTask(taskEntity, "del", false);
		
		return null;
	}

}