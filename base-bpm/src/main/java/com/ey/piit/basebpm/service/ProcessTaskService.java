package com.ey.piit.basebpm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.impl.RuntimeServiceImpl;
import org.activiti.engine.impl.TaskServiceImpl;
import org.activiti.engine.impl.interceptor.CommandExecutor;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basebpm.cmd.CreateExecutionCmd;
import com.ey.piit.basebpm.cmd.CreateTaskCmd;
import com.ey.piit.basebpm.cmd.DeleteAllTaskCmd;
import com.ey.piit.basebpm.cmd.FindAllTaskCmd;
import com.ey.piit.basebpm.cmd.JumpEndCmd;
import com.ey.piit.basebpm.cmd.JumpTaskCmd;
import com.ey.piit.basebpm.cmd.SaveTaskVariableCmd;
import com.ey.piit.basebpm.cmd.SaveTaskVariableLocalCmd;
import com.ey.piit.basebpm.common.Constants;
import com.ey.piit.basebpm.entity.TaskBean;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.UserService;
import com.ey.piit.core.utils.StringUtils;

@Service
public class ProcessTaskService {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private FormService formService;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询当前人的组任务
	 * @param userId 当前用户
	 * @param page 分页信息
	 * @param dh 单号
	 * @param ywlx 业务类型
	 * @param fqr 发起人
	 * @param gskh 公司客户
	 * @return
	 */
	public List<TaskBean> findTask(String userId, PageJqGrid page, String dh, String ywlx,/* String fqr,*/ String gskh) {
		TaskQuery query = taskService// 与正在执行的任务管理相关的Service
				.createTaskQuery()// 创建任务查询对象
				/** 查询条件（where部分） */
				.taskCandidateOrAssigned(userId);// 个人任务或组任务查询
		
		if(StringUtils.isNotBlank(dh)){
			query.processVariableValueEquals(Constants.VAR_KEY_CODE, dh);
		}
		if(StringUtils.isNotBlank(ywlx)){
			query.processVariableValueLike(Constants.VAR_KEY_TYPE, "%"+ywlx+"%");
		}
		/*if(StringUtils.isNotBlank(fqr)){
			query.processVariableValueLike(Constants.VAR_KEY_APPLY_USER, "%"+fqr+"%");
		}*/
		if(StringUtils.isNotBlank(gskh)){
			query.processVariableValueLike(Constants.VAR_KEY_NAME, "%"+gskh+"%");
		}
		
		long count = query.count();
		int maxResults = page.getRows();
		int firstResult = (page.getPage() - 1) * maxResults;
		
		List<Task> taskList = query
				.includeProcessVariables()
				/** 排序 */
				.orderByTaskCreateTime().desc()// 使用创建时间的降序排列
				/** 返回结果集 */
				.listPage(firstResult, maxResults);// 返回列表
		
		List<TaskBean> rtnList = new ArrayList<TaskBean>(taskList.size());
		for (int i = 0; i < taskList.size(); i++) {
			Task task = taskList.get(i);
			TaskBean taskBean = new TaskBean();
			taskBean.setTaskId(task.getId());
			taskBean.setCreateTime(task.getCreateTime());
			taskBean.setFormKey(task.getFormKey());
			taskBean.setTaskName(task.getName());
			taskBean.setProcessId(task.getProcessInstanceId());
			taskBean.setTaskKey(task.getTaskDefinitionKey());
			
			Map<String, Object> map = task.getProcessVariables();
			Object businessId = map.get(Constants.VAR_KEY_ID);
			Object code = map.get(Constants.VAR_KEY_CODE);
			Object name = map.get(Constants.VAR_KEY_NAME);
			Object type = map.get(Constants.VAR_KEY_TYPE);
			Object processName = map.get(Constants.VAR_KEY_PROCESS_NAME);
			Object processType = map.get(Constants.VAR_KEY_PROCESS_TYPE);
			Object applyUser = map.get(Constants.VAR_KEY_APPLY_USER);
			Object applyTime = map.get(Constants.VAR_KEY_APPLY_TIME);
			
			taskBean.setBusinessId(businessId == null ? null : businessId.toString());
			taskBean.setCode(code == null ? null : code.toString());
			taskBean.setName(name == null ? null : name.toString());
			taskBean.setType(type == null ? null : type.toString());
			taskBean.setProcessName(processName == null ? null : processName.toString());
			taskBean.setProcessType(processType == null ? null : processType.toString());
			taskBean.setApplyUser(applyUser == null ? null : applyUser.toString());
			taskBean.setApplyTime(applyTime == null ? null : (Date)applyTime);
			
			if (StringUtils.isNotBlank(taskBean.getApplyUser())) {
				String userName = userService.findNameByEmpCode(taskBean.getApplyUser());
				taskBean.setApplyUser(userName);
			}
			
			rtnList.add(taskBean);
		}
		
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int)count);
		return new PageList<TaskBean>(rtnList,paginator);
	}
	
	public TaskBean findTaskById(String taskId) {
		Task task = taskService// 与正在执行的任务管理相关的Service
				.createTaskQuery()// 创建任务查询对象
				/** 查询条件（where部分） */
				.taskId(taskId)
				.includeProcessVariables()
				.singleResult();
		
		TaskBean taskBean = new TaskBean();
		taskBean.setTaskId(task.getId());
		taskBean.setCreateTime(task.getCreateTime());
		taskBean.setFormKey(task.getFormKey());
		taskBean.setTaskName(task.getName());
		taskBean.setProcessId(task.getProcessInstanceId());
		taskBean.setTaskKey(task.getTaskDefinitionKey());
		
		Map<String, Object> map = task.getProcessVariables();
		Object businessId = map.get(Constants.VAR_KEY_ID);
		Object code = map.get(Constants.VAR_KEY_CODE);
		Object name = map.get(Constants.VAR_KEY_NAME);
		Object type = map.get(Constants.VAR_KEY_TYPE);
		Object processName = map.get(Constants.VAR_KEY_PROCESS_NAME);
		Object processType = map.get(Constants.VAR_KEY_PROCESS_TYPE);
		Object applyUser = map.get(Constants.VAR_KEY_APPLY_USER);
		Object applyTime = map.get(Constants.VAR_KEY_APPLY_TIME);
		
		taskBean.setBusinessId(businessId == null ? null : businessId.toString());
		taskBean.setCode(code == null ? null : code.toString());
		taskBean.setName(name == null ? null : name.toString());
		taskBean.setType(type == null ? null : type.toString());
		taskBean.setProcessName(processName == null ? null : processName.toString());
		taskBean.setProcessType(processType == null ? null : processType.toString());
		taskBean.setApplyUser(applyUser == null ? null : applyUser.toString());
		taskBean.setApplyTime(applyTime == null ? null : (Date)applyTime);
		return taskBean;
	}
	
	/**
	 * 修改流程变量
	 * @param taskId
	 * @param key
	 * @param value
	 */
	public void setProcessVariables(String taskId, String key, String value){
		taskService.setVariable(taskId, key, value); 
	}
	
	/**
	 * 完成我的任务
	 */
	public void completeTask(String taskId,String userId){
		try {
			Task task = taskService.createTaskQuery().includeTaskLocalVariables().taskId(taskId).singleResult();
			if (task.getAssignee() == null) {
				claimTask(taskId, userId);
			}
			Map<String, Object> localVariables = task.getTaskLocalVariables();
			Object jumpActivityId = localVariables.get(Constants.VAR_KEY_JUMP_ACTIVITY_ID);
			if (jumpActivityId != null) {
				jumpTask(taskId, jumpActivityId.toString());
			} else {
				taskService//与正在执行的任务管理相关的Service
				.complete(taskId);
			}
		} catch (ActivitiObjectNotFoundException e) {
			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
		}
	}
	
	/**
	 * 完成我的任务
	 */
	public void completeTask(String taskId,String userId,String commentType,String comment){
		try {
			Task task = taskService.createTaskQuery().includeTaskLocalVariables().taskId(taskId).singleResult();
			if (task.getAssignee() == null) {
				claimTask(taskId, userId);
			}
			if (StringUtils.isNotBlank(comment)) {
				identityService.setAuthenticatedUserId(userId);
				taskService.addComment(taskId, task.getProcessInstanceId(), commentType, comment);
			}
			Map<String, Object> localVariables = task.getTaskLocalVariables();
			Object jumpActivityId = localVariables.get(Constants.VAR_KEY_JUMP_ACTIVITY_ID);
			if (jumpActivityId != null) {
				jumpTask(taskId, jumpActivityId.toString());
			} else {
				taskService//与正在执行的任务管理相关的Service
					.complete(taskId);
			}
		} catch (ActivitiObjectNotFoundException e) {
			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
		}
	}
	
	/**
	 * 完成我的任务
	 * @param taskId 任务ID
	 * @param variables
	 */
	public void completeTask(String taskId,String userId,Map<String,Object> variables){
		try {
			Task task = taskService.createTaskQuery().includeTaskLocalVariables().taskId(taskId).singleResult();
			if (task.getAssignee() == null) {
				claimTask(taskId, userId);
			}
			
			Object comment = variables.get(Constants.VAR_KEY_COMMENT);
			if (comment != null) {
				Object commentType = variables.get(Constants.VAR_KEY_COMMENT_TYPE);
				identityService.setAuthenticatedUserId(userId);
				taskService.addComment(taskId, task.getProcessInstanceId(), commentType == null ? null : commentType.toString(), comment.toString());
			}
			Map<String, Object> localVariables = task.getTaskLocalVariables();
			Object jumpActivityId = localVariables.get(Constants.VAR_KEY_JUMP_ACTIVITY_ID);
			if (jumpActivityId != null) {
				jumpTask(taskId, jumpActivityId.toString());
			} else {
				taskService//与正在执行的任务管理相关的Service
				.complete(taskId, variables);//完成任务的同时，设置流程变量，用Map集合
			}
		} catch (ActivitiObjectNotFoundException e) {
			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
		}
	}
	
	/**
	 * 完成我的任务
	 * @param taskId
	 * @param outcomeKey
	 * @param outcomeVal
	 */
//	public void completeTask(String taskId,String userId,String outcomeKey,String outcomeVal) {
//		try {
//			Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
//			if (task.getAssignee() == null) {
//				claimTask(taskId, userId);
//			}
//			/**
//			 * 如果连线的名称为null，那么就不需要设置，如果不是，就需要设置流程变量
//			 * 在完成任务之前，设置流程变量，按照连线的名称，去完成任务
//					 流程变量的名称：outcome
//					 流程变量的值：连线的名称
//			 */
//		
//			if(outcomeKey!=null && outcomeVal!=null){
//				Map<String, Object> variables = new HashMap<String,Object>();
//				variables.put(outcomeKey, outcomeVal);
//				//3：使用任务ID，完成当前人的个人任务，同时流程变量
//				taskService.complete(taskId, variables);
//			} else {
//				taskService.complete(taskId);
//			}
//		} catch (ActivitiObjectNotFoundException e) {
//			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
//		}
//	}
	
	/**
	 * 完成接收活动任务
	 * @param processInstanceId
	 * @param activityId
	 */
//	public void completeReceiveTask(String processInstanceId,String activityId){
//		try {
//			/**查询执行对象ID*/
//			Execution execution = runtimeService//
//							.createExecutionQuery()//创建执行对象查询
//							.processInstanceId(processInstanceId)//使用流程实例ID查询
//							.activityId(activityId)//当前活动的id，对应bpmn文件中的活动节点id的属性值
//							.singleResult();
//			
//			/**向后执行一步，如果流程处于等待状态，使得流程继续执行*/
//			runtimeService.signal(execution.getId());
//		} catch (ActivitiObjectNotFoundException e) {
//			throw new ServiceException(BpmConstants.NOT_FOUND_EXCEPTION);
//		}
//	}
	
	/**
	 * 完成接收活动任务
	 * @param processInstanceId
	 * @param activityId
	 * @param variables
	 */
//	public void completeReceiveTask(String processInstanceId,String activityId,Map<String,Object> variables){
//		try {
//			/**查询执行对象ID*/
//			Execution execution = runtimeService//
//					.createExecutionQuery()//创建执行对象查询
//					.processInstanceId(processInstanceId)//使用流程实例ID查询
//					.activityId(activityId)//当前活动的id，对应bpmn文件中的活动节点id的属性值
//					.singleResult();
//			
//			/**使用流程变量设置当日销售额，用来传递业务参数*/
//			runtimeService.setVariables(execution.getId(), variables);
//			
//			/**向后执行一步，如果流程处于等待状态，使得流程继续执行*/
//			runtimeService.signal(execution.getId());
//		} catch (ActivitiObjectNotFoundException e) {
//			throw new ServiceException(BpmConstants.NOT_FOUND_EXCEPTION);
//		}
//	}
	
	/**
	 * 移交任务
	 * @param taskId
	 * @param userId
	 */
	public void transferTask(String taskId,String userId){
		try {
			taskService.setAssignee(taskId, userId);
		} catch (ActivitiObjectNotFoundException e) {
			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
		}
	}
		
	/**
	 * 查询正在执行的任务办理人表
	 * @param taskId
	 * @return
	 */
//	public List<IdentityLink> findRunPersonTask(String taskId){
//		List<IdentityLink> list = taskService//
//					.getIdentityLinksForTask(taskId);
//		return list;
//	}
		
	/**
	 * 认领任务，将组任务分给个人任务
	 * @param taskId
	 * @param userId
	 */
	public void claimTask(String taskId,String userId){
		try {
			taskService.claim(taskId, userId);
		} catch (ActivitiObjectNotFoundException e) {
			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
		}
	}
		
	/**
	 * 使用任务ID，获取当前任务节点中对应的Form key中的连接的值
	 * @param taskId
	 * @return
	 */
//	public String findTaskFormKeyByTaskId(String taskId) {
//		TaskFormData formData = formService.getTaskFormData(taskId);
//		//获取Form key的值
//		String url = formData.getFormKey();
//		return url;
//	}
	
	/**
	 * 使用任务ID和属性ID，获取当前任务节点中对应的Form Property中的值
	 * @param taskId
	 * @param propertyId
	 * @param valuesId
	 * @return
	 */
	public String findTaskFormPropertyByTaskId(String taskId,String propertyId,String valuesId) {
		try {
			TaskFormData formData = formService.getTaskFormData(taskId);
			List<FormProperty> formProperties = formData.getFormProperties();
			for (int i = 0; i < formProperties.size(); i++) {
				FormProperty formProperty = formProperties.get(i);
				String id = formProperty.getId();
				if (id.equals(propertyId)) {
					
					//如果没有分支取默认值
					if (valuesId == null || valuesId.length() == 0) {
						return formProperty.getValue();
					} else {
						if (formProperty.getType() == null) {
							throw new ServiceException("流程图未设置枚举类型");
						}
						Object information = formProperty.getType().getInformation("values");
						if (information == null) {
							throw new ServiceException("流程图未设置枚举值");
						}
						@SuppressWarnings("unchecked")
						Map<String,String> map = (Map<String,String>) information;
						String val = map.get(valuesId);
						if (val == null) {
							throw new ServiceException("未找到对应值，请检查");
						}
						return val;
					}
				}
			}
			throw new ServiceException("未找到对应值，请检查");
		} catch (ActivitiObjectNotFoundException e) {
			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
		}
	}
	
	/**
	 * 使用任务ID和属性ID，获取当前任务节点中对应的Form Property中的值
	 * @param taskId
	 * @param propertyId
	 * @return
	 */
	public Map<String,String> findTaskFormPropertyByTaskId(String taskId,String propertyId) {
		try {
			TaskFormData formData = formService.getTaskFormData(taskId);
			List<FormProperty> formProperties = formData.getFormProperties();
			for (int i = 0; i < formProperties.size(); i++) {
				FormProperty formProperty = formProperties.get(i);
				String id = formProperty.getId();
				if (id.equals(propertyId)) {
					if (formProperty.getType() == null) {
						throw new ServiceException("流程图未设置枚举类型");
					}
					Object information = formProperty.getType().getInformation("values");
					if (information == null) {
						throw new ServiceException("流程图未设置枚举值");
					}
					@SuppressWarnings("unchecked")
					Map<String,String> map = (Map<String,String>) information;
					return map;
				}
			}
			throw new ServiceException("未找到对应值，请检查");
		} catch (ActivitiObjectNotFoundException e) {
			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
		}
	}
	
	/**
	 * 查询流程状态（判断流程正在执行，还是结束）
	 * @param processInstanceId
	 * @return true:流程已经结束 false:流程没有结束
	 */
	public boolean isProcessEnd(String processInstanceId){
		ProcessInstance pi = runtimeService//表示正在执行的流程实例和执行对象
						.createProcessInstanceQuery()//创建流程实例查询
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		return pi==null;
	}
		
	/**
	 * 使用任务ID获得业务主键
	 * @param taskId
	 * @return
	 */
//	public String findBusinessKeyByTaskId(String taskId) {
//		//1：使用任务ID，查询任务对象Task
//		Task task = taskService.createTaskQuery()//
//						.taskId(taskId)//使用任务ID查询
//						.singleResult();
//		//2：使用任务对象Task获取流程实例ID
//		String processInstanceId = task.getProcessInstanceId();
//		//3：使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
//		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
//						.processInstanceId(processInstanceId)//使用流程实例ID查询
//						.singleResult();
//		//4：使用流程实例对象获取BUSINESS_KEY
//		String buniness_key = pi.getBusinessKey();
//		return buniness_key;
//	}
	
	/**
	 * 使用流程实例ID获得业务主键
	 * @param taskId
	 * @return
	 */
//	public String findBusinessKeyByProcessInstanceId(String processInstanceId) {
//		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
//				.processInstanceId(processInstanceId)//使用流程实例ID查询
//				.singleResult();
//		String buniness_key = pi.getBusinessKey();
//		return buniness_key;
//	}
		
	/**
	 * 获取批注信息，传递的是当前任务ID，获取历史任务ID对应的批注
	 * @param taskId
	 * @return
	 */
//	public List<Comment> findCommentByTaskId(String taskId) {
//		//使用当前的任务ID，查询当前流程对应的历史任务ID
//		//使用当前任务ID，获取当前任务对象
//		Task task = taskService.createTaskQuery()//
//				.taskId(taskId)//使用任务ID查询
//				.singleResult();
//		//获取流程实例ID
//		String processInstanceId = task.getProcessInstanceId();
//		List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
//		return list;
//	}
	
//	/**二：已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中*/
//	public List<String> findOutComeListByTaskId(String taskId) {
//		//返回存放连线的名称集合
//		List<String> list = new ArrayList<String>();
//		//1:使用任务ID，查询任务对象
//		Task task = taskService.createTaskQuery()//
//					.taskId(taskId)//使用任务ID查询
//					.singleResult();
//		//2：获取流程定义ID
//		String processDefinitionId = task.getProcessDefinitionId();
//		//3：查询ProcessDefinitionEntiy对象
//		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
//		//使用任务对象Task获取流程实例ID
//		String processInstanceId = task.getProcessInstanceId();
//		//使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
//		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
//					.processInstanceId(processInstanceId)//使用流程实例ID查询
//					.singleResult();
//		//获取当前活动的id
//		String activityId = pi.getActivityId();
//		//4：获取当前的活动
//		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
//		//5：获取当前活动完成之后连线的名称
//		List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
//		if(pvmList!=null && pvmList.size()>0){
//			for(PvmTransition pvm:pvmList){
//				String name = (String) pvm.getProperty("name");
//				if(StringUtils.isNotBlank(name)){
//					list.add(name);
//				}
//			}
//		}
//		return list;
//	}
	
	/**
	 * 完成我的任务
	 * @param processBean
	 */
//	public void completeTask(ProcessBean processBean) {
//		//获取任务ID
//		String taskId = processBean.getTaskId();
//		//获取连线的信息
//		String outcomeKey = processBean.getOutcomeKey();
//		String outcomeVal = processBean.getOutcomeVal();
//		//批注信息
//		String message = processBean.getComment();
//		//用户ID
//		String userId = processBean.getUserId();
//		
//		/**
//		 * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
//		 */
//		//使用任务ID，查询任务对象，获取流程流程实例ID
//		Task task = taskService.createTaskQuery()//
//						.taskId(taskId)//使用任务ID查询
//						.singleResult();
//		/**
//		 * 注意：添加批注的时候，由于Activiti底层代码是使用：
//		 * 		String userId = Authentication.getAuthenticatedUserId();
//			    CommentEntity comment = new CommentEntity();
//			    comment.setUserId(userId);
//			  所有需要使用userId，作为该任务的办理人（审核人），对应act_hi_comment表中的User_ID的字段，不过不添加审核人，该字段为null
//			 所以要求，添加配置执行使用Authentication.setAuthenticatedUserId();添加当前任务的审核人
//		 * */
//		if (StringUtils.isNotEmpty(message)) {
//			//获取流程实例ID
//			String processInstanceId = task.getProcessInstanceId();
//			Authentication.setAuthenticatedUserId(userId);
//			taskService.addComment(taskId, processInstanceId, message);
//		}
//		/**
//		 * 2：如果连线的名称为null，那么就不需要设置，如果不是，就需要设置流程变量
//		 * 在完成任务之前，设置流程变量，按照连线的名称，去完成任务
//				 流程变量的名称：outcome
//				 流程变量的值：连线的名称
//		 */
//		if(outcomeKey!=null && outcomeVal!=null){
//			Map<String, Object> variables = new HashMap<String,Object>();
//			variables.put(outcomeKey, outcomeVal);
//			//3：使用任务ID，完成当前人的个人任务，同时流程变量
//			taskService.complete(taskId, variables);
//		}
//
//	}
	
	public String findApplyCommentByProcessId(String processId) {
		List<Comment> list = taskService.getProcessInstanceComments(processId, Constants.VAR_KEY_COMMENT_TYPE_APPLY);
		if (list != null && list.size()>0) {
			Comment lastComment = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				Comment comment = list.get(i);
				if (comment.getTime().after(lastComment.getTime())) {
					lastComment = comment;
				}
			}
			return lastComment.getFullMessage();
		}
		return "";
	}
	
	public String findApproveCommentByProcessId(String processId) {
		List<Comment> list = taskService.getProcessInstanceComments(processId, Constants.VAR_KEY_COMMENT_TYPE_APPROVE);
		if (list != null && list.size()>0) {
			Comment lastComment = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				Comment comment = list.get(i);
				if (comment.getTime().after(lastComment.getTime())) {
					lastComment = comment;
				}
			}
			return lastComment.getFullMessage();
		}
		return "";
	}
	
	public void jumpTask(String taskId,String activityId){
		TaskServiceImpl taskServiceImpl = (TaskServiceImpl)taskService;
		if ("end".equalsIgnoreCase(activityId)) {
			taskServiceImpl.getCommandExecutor().execute(new JumpEndCmd(taskId));
		} else {
			taskServiceImpl.getCommandExecutor().execute(new JumpTaskCmd(taskId, activityId));
		}
	}
	
	/**
	 * 驳回到申请节点再提交时直接提交到驳回节点
	 * （注意申请节点的ID要设置为applyNode）
	 */
	public void rejectTask(String taskId){
		TaskServiceImpl taskServiceImpl = (TaskServiceImpl)taskService;
		CommandExecutor commandExecutor = taskServiceImpl.getCommandExecutor();
		
		JumpTaskCmd jumpTaskCmd = new JumpTaskCmd(taskId, Constants.VAR_KEY_APPLY_NODE);
		commandExecutor.execute(jumpTaskCmd);
		
		String executionId = jumpTaskCmd.getExecutionId();
		String taskDefKey = jumpTaskCmd.getTaskDefKey();
		
		Map<String,Object> variable = new HashMap<String,Object>();
		variable.put(Constants.VAR_KEY_JUMP_ACTIVITY_ID, taskDefKey);
		
		commandExecutor.execute(new SaveTaskVariableLocalCmd(executionId,variable));
	}
	
	/**
	 * 任意节点驳回后从申请节点重新开始，除申请节点有一个待办外，其他节点待办都会删除
	 * （注意申请节点的ID要设置为applyNode）
	 */
	public void rejectTaskRestart(String processInstanceId){
		RuntimeServiceImpl runtimeServiceImpl = (RuntimeServiceImpl)runtimeService;
		CommandExecutor commandExecutor = runtimeServiceImpl.getCommandExecutor();
		
		DeleteAllTaskCmd deleteChildExecutionCmd = new DeleteAllTaskCmd(processInstanceId);
		commandExecutor.execute(deleteChildExecutionCmd);
		
		CreateTaskCmd createTaskCmd = new CreateTaskCmd(processInstanceId,Constants.VAR_KEY_APPLY_NODE);
		commandExecutor.execute(createTaskCmd);
	}
	
	/**
	 * 任意节点驳回后从申请节点选择是重新开始还是继续，除申请节点有一个待办外，其他节点待办都会删除
	 * （注意申请节点的ID要设置为applyNode）
	 */
	public void rejectTaskSelect(String processInstanceId){
		RuntimeServiceImpl runtimeServiceImpl = (RuntimeServiceImpl)runtimeService;
		CommandExecutor commandExecutor = runtimeServiceImpl.getCommandExecutor();
		
		FindAllTaskCmd findAllTaskCmd = new FindAllTaskCmd(processInstanceId);
		commandExecutor.execute(findAllTaskCmd);
		List<String> taskDefKeys = findAllTaskCmd.getTaskDefKeys();
		
		DeleteAllTaskCmd deleteChildExecutionCmd = new DeleteAllTaskCmd(processInstanceId);
		commandExecutor.execute(deleteChildExecutionCmd);
		
		CreateTaskCmd createTaskCmd = new CreateTaskCmd(processInstanceId,Constants.VAR_KEY_APPLY_NODE);
		commandExecutor.execute(createTaskCmd);
		
		Map<String,Object> variable = new HashMap<String,Object>();
		variable.put(Constants.VAR_KEY_DEL_ACTIVITY_IDS, taskDefKeys);
		commandExecutor.execute(new SaveTaskVariableCmd(processInstanceId,variable));
	}
	
	/**
	 * 完成我的任务
	 * @param taskId 任务ID
	 * @param variables
	 */
	@SuppressWarnings("unchecked")
	public void completeTaskSelect(String taskId,String userId,Map<String,Object> variables){
		try {
			Task task = taskService.createTaskQuery().includeProcessVariables().taskId(taskId).singleResult();
			if (task.getAssignee() == null) {
				claimTask(taskId, userId);
			}
			
			Object comment = variables.get(Constants.VAR_KEY_COMMENT);
			if (comment != null) {
				Object commentType = variables.get(Constants.VAR_KEY_COMMENT_TYPE);
				identityService.setAuthenticatedUserId(userId);
				taskService.addComment(taskId, task.getProcessInstanceId(), commentType == null ? null : commentType.toString(), comment.toString());
			}
			
			Object selActivityId = variables.get(Constants.VAR_KEY_SEL_ACTIVITY_IDS);
			if (selActivityId != null) {
				Map<String, Object> pVariables = task.getProcessVariables();
				Object delActivityId = pVariables.get(Constants.VAR_KEY_DEL_ACTIVITY_IDS);
				if (delActivityId != null) {
					Map<String,String> selMap = (Map<String,String>)selActivityId;
					List<String> delTasks = (List<String>)delActivityId;
					String processInstanceId = task.getProcessInstanceId();
					
					RuntimeServiceImpl runtimeServiceImpl = (RuntimeServiceImpl)runtimeService;
					CommandExecutor commandExecutor = runtimeServiceImpl.getCommandExecutor();
					DeleteAllTaskCmd deleteAllTaskCmd = new DeleteAllTaskCmd(processInstanceId);
					commandExecutor.execute(deleteAllTaskCmd);
					
					Iterator<String> iterator = selMap.keySet().iterator();
					while(iterator.hasNext()){
						String selKey = iterator.next();
						String[] selTasks = selKey.split(",");
						
						pTask:
						for (int i = 0; i < selTasks.length; i++) {
							String pTask = selTasks[i];
							for (int j = 0; j < delTasks.size(); j++) {
								String delTask = delTasks.get(j);
								if (pTask.equals(delTask)) {
									if (Constants.VAR_KEY_REJECT_SEL_RESTART.equals(selMap.get(selKey))) {
										CreateExecutionCmd createExecutionCmd = new CreateExecutionCmd(processInstanceId);
										commandExecutor.execute(createExecutionCmd);
										String executionId = createExecutionCmd.getExecutionId();
										CreateTaskCmd createTaskCmd = new CreateTaskCmd(executionId,selTasks[0]);
										commandExecutor.execute(createTaskCmd);
										continue pTask;
									} else if (Constants.VAR_KEY_REJECT_SEL_CONTINUE.equals(selMap.get(selKey))) {
										CreateExecutionCmd createExecutionCmd = new CreateExecutionCmd(processInstanceId);
										commandExecutor.execute(createExecutionCmd);
										String executionId = createExecutionCmd.getExecutionId();
										CreateTaskCmd createTaskCmd = new CreateTaskCmd(executionId,delTask);
										commandExecutor.execute(createTaskCmd);
										continue pTask;
									}
								}
							}
						}
					}
				}
			} else {
				taskService//与正在执行的任务管理相关的Service
				.complete(taskId, variables);//完成任务的同时，设置流程变量，用Map集合
			}
		} catch (ActivitiObjectNotFoundException e) {
			throw new ServiceException(Constants.NOT_FOUND_EXCEPTION);
		}
	}
	
	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	public FormService getFormService() {
		return formService;
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}

	public IdentityService getIdentityService() {
		return identityService;
	}

	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
