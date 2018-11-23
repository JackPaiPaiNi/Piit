package com.ey.piit.basebpm.cmd;

import java.util.Map;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.task.Comment;

public class SaveTaskVariableCmd implements Command<Comment> {

	private String executionId;
	private Map<String, Object> variables;

	public SaveTaskVariableCmd(String executionId, Map<String, Object> variables) {
		this.executionId = executionId;
		this.variables = variables;
	}

	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		ExecutionEntity executionEntity = commandContext.getExecutionEntityManager().findExecutionById(executionId);
		executionEntity.setVariables(variables);
		return null;
	}

}