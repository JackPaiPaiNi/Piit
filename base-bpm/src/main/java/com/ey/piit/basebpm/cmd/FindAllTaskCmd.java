package com.ey.piit.basebpm.cmd;

import java.util.List;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.task.Comment;

import com.google.common.collect.Lists;

public class FindAllTaskCmd implements Command<Comment> {

	private String processInstanceId;
	private List<String> taskDefKeys;

	public FindAllTaskCmd(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public Comment execute(CommandContext commandContext) {
		//Context.getCommandContext()
		ExecutionEntityManager executionEntityManager = commandContext.getExecutionEntityManager();
		List<ExecutionEntity> executionEntityList = executionEntityManager.findChildExecutionsByParentExecutionId(processInstanceId);
		
		taskDefKeys = Lists.newArrayList();
		for (int i = 0; i < executionEntityList.size(); i++) {
			ExecutionEntity executionEntity = executionEntityList.get(i);
			List<TaskEntity> taskList = executionEntity.getTasks();
			for (int j = 0; j < taskList.size(); j++) {
				TaskEntity taskEntity = taskList.get(j);
				taskDefKeys.add(taskEntity.getTaskDefinitionKey());
			}
		}
		
		return null;
	}

	public List<String> getTaskDefKeys() {
		return taskDefKeys;
	}

}