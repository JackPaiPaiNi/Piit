package com.ey.piit.basebpm.cmd;

import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.task.Comment;

public class SaveTaskVariableLocalCmd implements Command<Comment> {

	private String executionId;
	private Map<String, Object> variables;

	public SaveTaskVariableLocalCmd(String executionId, Map<String, Object> variables) {
		this.executionId = executionId;
		this.variables = variables;
	}

	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		List<TaskEntity> taskList = commandContext.getTaskEntityManager().findTasksByExecutionId(executionId);
		if (taskList == null || taskList.size() > 1) {
			throw new RuntimeException("发现多个任务");
		}
		TaskEntity newTaskEntity = taskList.get(0);
		newTaskEntity.setVariablesLocal(variables);
		return null;
	}

}