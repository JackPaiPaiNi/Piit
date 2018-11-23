package com.ey.piit.basebpm.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basebpm.common.Constants;
import com.ey.piit.basebpm.entity.ProcessBean;
import com.ey.piit.basebpm.entity.TaskBean;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.utils.StringUtils;

@Service
public class ProcessInstanceService {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private ProcessEngine processEngine;
	
	/**
	 * 启动流程实例
	 * @param processDefinitionKey 流程定义的key
	 */
//	public void startProcessInstance(String processDefinitionKey){
//		runtimeService//与正在执行的流程实例和执行对象相关的Service
//						.startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
//	}
	
	/**
	 * 启动流程实例
	 * @param processDefinitionKey 流程定义的key
	 * @param variables
	 */
//	public void startProcessInstance(String processDefinitionKey,Map<String,Object> variables){
//		runtimeService//与正在执行的流程实例和执行对象相关的Service
//						.startProcessInstanceByKey(processDefinitionKey, variables);//启动流程实例的同时，可以设置流程变量，用Map集合
//	}
	
	/**
	 * 启动流程实例
	 * @param processDefinitionKey 流程定义的key
	 * @param businessKey
	 */
//	public void startProcessInstance(String processDefinitionKey,String businessKey){
//		runtimeService//与正在执行的流程实例和执行对象相关的Service
//						.startProcessInstanceByKey(processDefinitionKey,businessKey);
//	}
	
	/**
	 * 启动流程实例
	 * @param processDefinitionKey 流程定义的key
	 * @param businessKey
	 * @param variables
	 */
//	public void startProcessInstance(String processDefinitionKey,String businessKey,Map<String,Object> variables){
//		runtimeService//与正在执行的流程实例和执行对象相关的Service
//						.startProcessInstanceByKey(processDefinitionKey,businessKey,variables);//使用流程定义的key，启动流程实例，同时设置流程变量，同时向正在执行的执行对象表中的字段BUSINESS_KEY添加业务数据，同时让流程关联业务
//	}
	
	/**
	 * 启动流程实例
	 * @param processBean
	 */
	public TaskBean startProcessInstance(ProcessBean processBean) {
		String businessId = processBean.getBusinessId();
		String userId = processBean.getUserId();
		String processKey = processBean.getProcessKey();
		String code = processBean.getCode();
		String name = processBean.getName();
		String processType = processBean.getProcessType();
		String type = processBean.getType();
		String comment = processBean.getComment();
		
		if (StringUtils.isBlank(businessId)) {
			throw new ServiceException("businessId is null");
		} else if (StringUtils.isBlank(userId)) {
			throw new ServiceException("userId is null");
		} else if (StringUtils.isBlank(processKey)) {
			throw new ServiceException("processKey is null");
		} else if (StringUtils.isBlank(code)) {
			throw new ServiceException("code is null");
		} /*else if (StringUtils.isBlank(name)) {
			throw new ServiceException("name is null");
		} else if (StringUtils.isBlank(processType)) {
			throw new ServiceException("processType is null");
		} */else if (StringUtils.isBlank(type)) {
			throw new ServiceException("type is null");
		}
		
		Date applyTime = new Date();
		Map<String, Object> variables = processBean.getVariables();
		variables.put(Constants.VAR_KEY_APPLY_USER, userId);
		variables.put(Constants.VAR_KEY_APPLY_TIME, applyTime);
		variables.put(Constants.VAR_KEY_CODE, code);//单号
		variables.put(Constants.VAR_KEY_ID, businessId);
		variables.put(Constants.VAR_KEY_NAME, name);
//		variables.put(Constants.VAR_KEY_PROCESS_TYPE, processType);
		variables.put(Constants.VAR_KEY_TYPE, type);//业务类型
		
		identityService.setAuthenticatedUserId(userId);
		ExecutionEntity pi = (ExecutionEntity)runtimeService.startProcessInstanceByKey(processKey,businessId,variables);
//		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity)pi.getProcessDefinition();
		
		List<TaskEntity> taskList = pi.getTasks();
		if (taskList != null && taskList.size() == 1) {
			TaskEntity task = taskList.get(0);
			
//			Map<String, Object> var = new HashMap<String, Object>();
//			var.put(Constants.VAR_KEY_PROCESS_NAME, processDefinition.getName());
//			variables.put(Constants.VAR_KEY_PROCESS_NAME, processDefinition.getName());
			
			if (StringUtils.isNotBlank(comment)) {
				taskService.addComment(task.getId(), pi.getProcessInstanceId(), Constants.VAR_KEY_COMMENT_TYPE_APPLY, comment);
			}
//			taskService.complete(task.getId(),var);
			taskService.complete(task.getId());
			
			TaskBean taskBean = new TaskBean();
			taskBean.setTaskId(task.getId());
			taskBean.setCreateTime(task.getCreateTime());
			taskBean.setFormKey(task.getFormKey());
			taskBean.setTaskName(task.getName());
			taskBean.setProcessId(task.getProcessInstanceId());
			
			taskBean.setBusinessId(businessId);
			taskBean.setCode(code);
			taskBean.setName(name);
			taskBean.setType(type);
			taskBean.setProcessName(pi.getProcessDefinitionName());
			taskBean.setProcessType(processType);
			taskBean.setApplyUser(userId);
			taskBean.setApplyTime(applyTime);
			return taskBean;
		}
		
		return null;
	}
	
	/**
	 * 查询流程状态（判断流程正在执行，还是结束）
	 * @param processInstanceId
	 * @return true:流程已经结束 false:流程没有结束
	 */
	public boolean isProcessEnd(String processInstanceId){
		if (StringUtils.isBlank(processInstanceId)) {
			throw new ServiceException("流程实例ID不能为空");
		}
		ProcessInstance pi = runtimeService//表示正在执行的流程实例和执行对象
						.createProcessInstanceQuery()//创建流程实例查询
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		return pi==null;
	}
	
	/**
	 * 根据流程KEY查询是否有在运行的流程
	 * @param processKey
	 * @return
	 */
	public boolean isHaveRunning(String processKey){
		long count = runtimeService//表示正在执行的流程实例和执行对象
				.createProcessInstanceQuery()//创建流程实例查询
				.processDefinitionKey(processKey)
				.count();
		return count > 0;
	}
	
	/**
	 * 根据业务主键查询是否有在运行的流程
	 * @param processKey
	 * @return
	 */
	public boolean isHaveProcessRunning(String businessKey){
		long count = runtimeService//表示正在执行的流程实例和执行对象
				.createProcessInstanceQuery()//创建流程实例查询
				.processInstanceBusinessKey(businessKey)
				.count();
		return count > 0;
	}
	
	/** 
	 * 流程跟踪图片 
	 */  
	public InputStream genBpmImage(String processInstanceId) {
		if (StringUtils.isBlank(processInstanceId)) {
			return null;
		}
		
		// 当前活动节点、活动线
		List<String> activeActivityIds = new ArrayList<String>();
		List<String> highLightedFlows = new ArrayList<String>();
		String processDefinitionId = null;
		
		//获得当前活动的节点
		if (isProcessEnd(processInstanceId)) {// 如果流程已经结束，则得到结束节点
			activeActivityIds.add(historyService.createHistoricActivityInstanceQuery().executionId(processInstanceId)
					.activityType("endEvent").singleResult().getActivityId());
			
			HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
			processDefinitionId = processInstance.getProcessDefinitionId();
		} else {// 如果流程没有结束，则取当前活动节点
			// 根据流程实例ID获得当前处于活动状态的ActivityId合集
			activeActivityIds = runtimeService.getActiveActivityIds(processInstanceId);
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
					.singleResult();
			processDefinitionId = processInstance.getProcessDefinitionId();
		}
		
		//获得活动的线
		// 获得历史活动记录实体（通过启动时间正序排序，不然有的线可以绘制不出来）
		List<HistoricActivityInstance> historicActivityInstances = historyService.createHistoricActivityInstanceQuery()
				.executionId(processInstanceId).orderByHistoricActivityInstanceStartTime().asc().list();
		// 计算活动线
		highLightedFlows = this
				.getHighLightedFlows((ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
						.getDeployedProcessDefinition(processDefinitionId), historicActivityInstances);
		
		//绘制图形
		if (null != activeActivityIds) {
			// 获得流程引擎配置
			ProcessEngineConfigurationImpl processEngineConfiguration = (ProcessEngineConfigurationImpl)processEngine.getProcessEngineConfiguration();
			// 根据流程定义ID获得BpmnModel
			BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
			// 输出资源内容到相应对象
			InputStream imageStream = new DefaultProcessDiagramGenerator().generateDiagram(bpmnModel, "png",
					activeActivityIds, highLightedFlows, processEngineConfiguration.getActivityFontName(),
					processEngineConfiguration.getLabelFontName(), processEngineConfiguration.getClassLoader(), 1.0);
			return imageStream;
		}
		
		return null;
	}
	  
	/** 
	 * 获得高亮线 
	 *  
	 * @param processDefinitionEntity 流程定义实体 
	 * @param historicActivityInstances 历史活动实体 
	 * @return 线ID集合 
	 */  
	public List<String> getHighLightedFlows(
	        ProcessDefinitionEntity processDefinitionEntity,
			List<HistoricActivityInstance> historicActivityInstances) {

		List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
		for (int i = 0; i < historicActivityInstances.size(); i++) {// 对历史流程节点进行遍历
			ActivityImpl activityImpl = processDefinitionEntity
					.findActivity(historicActivityInstances.get(i).getActivityId());// 得
																					// 到节点定义的详细信息
			List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
			if ((i + 1) >= historicActivityInstances.size()) {
				break;
			}
			ActivityImpl sameActivityImpl1 = processDefinitionEntity
					.findActivity(historicActivityInstances.get(i + 1).getActivityId());// 将后面第一个节点放在时间相同节点的集合里
			sameStartTimeNodes.add(sameActivityImpl1);
			for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
				HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);// 后续第一个节点
				HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);// 后续第二个节点
				if (activityImpl1.getStartTime().equals(activityImpl2.getStartTime())) {// 如果第一个节点和第二个节点开始时间相同保存
					ActivityImpl sameActivityImpl2 = processDefinitionEntity
							.findActivity(activityImpl2.getActivityId());
					sameStartTimeNodes.add(sameActivityImpl2);
				} else {// 有不相同跳出循环
					break;
				}
			}
			List<PvmTransition> pvmTransitions = activityImpl.getOutgoingTransitions();// 取出节点的所有出去的线
			for (PvmTransition pvmTransition : pvmTransitions) {// 对所有的线进行遍历
				ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition.getDestination();// 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
				if (sameStartTimeNodes.contains(pvmActivityImpl)) {
					highFlows.add(pvmTransition.getId());
				}
			}
		}
		return highFlows;
	}
	
	public void deleteProcessInstance(String processInstanceId) {
		runtimeService.deleteProcessInstance(processInstanceId, "delete");
	}
	
	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public IdentityService getIdentityService() {
		return identityService;
	}

	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}
	
}
