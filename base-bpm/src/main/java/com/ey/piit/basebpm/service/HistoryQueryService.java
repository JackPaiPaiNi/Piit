package com.ey.piit.basebpm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.history.HistoricVariableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basebpm.common.Constants;
import com.ey.piit.basebpm.entity.TaskBean;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.UserService;
import com.ey.piit.core.utils.StringUtils;

@Service
public class HistoryQueryService {
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询历史任务
	 */
	public List<TaskBean> findHistoryTask(String userId, Map<String, String> params, PageJqGrid page){
		HistoricTaskInstanceQuery query = historyService//与历史数据（历史表）相关的Service
						.createHistoricTaskInstanceQuery();//创建历史任务实例查询
		
		//如果不是管理员
		if (StringUtils.isNotBlank(userId)) {
			query.finished();
			query.taskAssignee(userId);//指定历史任务的办理人
		} else {
			String status = params.get(Constants.HIS_SEARCH_KEY_STATUS);
			if (Constants.HIS_SEARCH_KEY_STATUS_RUN.equals(status)) {//正在运行
				query.unfinished();
			} else if (Constants.HIS_SEARCH_KEY_STATUS_FINISH.equals(status)) {//已完成
				query.finished();
			}
		}
		
		String strCode = params.get(Constants.HIS_SEARCH_KEY_CODE);
		if (StringUtils.isNotBlank(strCode)) {
			query.processVariableValueEquals(Constants.HIS_SEARCH_KEY_CODE, strCode);
		}
		
		String strType = params.get(Constants.HIS_SEARCH_KEY_TYPE);
		if (StringUtils.isNotBlank(strType)) {
			query.processVariableValueEquals(Constants.HIS_SEARCH_KEY_TYPE, strType);
		}
		
		String strName = params.get(Constants.HIS_SEARCH_KEY_NAME);
		if (StringUtils.isNotBlank(strName)) {
			query.processVariableValueLike(Constants.HIS_SEARCH_KEY_NAME, "%"+strName+"%");
		}
		
		long count = query.count();
		int maxResults = page.getRows();
		int firstResult = (page.getPage() - 1) * maxResults;
		
		List<HistoricTaskInstance> list = query
				.includeProcessVariables()
				.orderByTaskCreateTime().desc()
				.listPage(firstResult, maxResults);
		
		List<TaskBean> rtnList = new ArrayList<TaskBean>(list.size());
		for (int i = 0; i < list.size(); i++) {
			HistoricTaskInstance task = list.get(i);
			TaskBean taskBean = new TaskBean();
			taskBean.setTaskId(task.getId());
			taskBean.setCreateTime(task.getCreateTime());
			taskBean.setFormKey(task.getFormKey());
			taskBean.setTaskName(task.getName());
			taskBean.setProcessId(task.getProcessInstanceId());
			taskBean.setEndTime(task.getEndTime());
			
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
			
			if (StringUtils.isNotBlank(task.getAssignee())) {
				String userName = userService.findNameByEmpCode(task.getAssignee());
				taskBean.setAssignee(userName);
			}
			if (StringUtils.isNotBlank(taskBean.getApplyUser())) {
				String userName = userService.findNameByEmpCode(taskBean.getApplyUser());
				taskBean.setApplyUser(userName);
			}
			
			rtnList.add(taskBean);
		}
		
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int)count);
		return new PageList<TaskBean>(rtnList,paginator);
	}
	
	/**
	 * 查询历史流程
	 */
	public List<TaskBean> findHistoryProcess(String userId, Map<String, String> params, PageJqGrid page){
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery();
		
		//如果不是管理员
		if (StringUtils.isNotBlank(userId)) {
			String oper = params.get(Constants.HIS_SEARCH_KEY_OPER);
			if (Constants.HIS_SEARCH_KEY_OPER_START.equals(oper)) {//流程发起人
				query.startedBy(userId);
			} else if (Constants.HIS_SEARCH_KEY_OPER_PART.equals(oper)) {//流程参与人
				query.involvedUser(userId);
			}
		} else {
			String applyUser = params.get(Constants.HIS_SEARCH_KEY_APPLY_USER);
			if (StringUtils.isNotBlank(applyUser)) {
				query.startedBy(applyUser);
			}
			
			String partUser = params.get(Constants.HIS_SEARCH_KEY_PART_USER);
			if (StringUtils.isNotBlank(partUser)) {
				query.involvedUser(partUser);
			}
		}
		
		String status = params.get(Constants.HIS_SEARCH_KEY_STATUS);
		if (Constants.HIS_SEARCH_KEY_STATUS_RUN.equals(status)) {//正在运行
			query.unfinished();
		} else if (Constants.HIS_SEARCH_KEY_STATUS_FINISH.equals(status)) {//已完成
			query.finished();
		}
		
		String strCode = params.get(Constants.HIS_SEARCH_KEY_CODE);
		if (StringUtils.isNotBlank(strCode)) {
			query.variableValueEquals(Constants.HIS_SEARCH_KEY_CODE, strCode);
		}
		
		String strType = params.get(Constants.HIS_SEARCH_KEY_TYPE);
		if (StringUtils.isNotBlank(strType)) {
			query.variableValueEquals(Constants.HIS_SEARCH_KEY_TYPE, strType);
		}
		
		String strName = params.get(Constants.HIS_SEARCH_KEY_NAME);
		if (StringUtils.isNotBlank(strName)) {
			query.variableValueLike(Constants.HIS_SEARCH_KEY_NAME, "%"+strName+"%");
		}
		
		long count = query.count();
		int maxResults = page.getRows();
		int firstResult = (page.getPage() - 1) * maxResults;
		
		List<HistoricProcessInstance> list = query
				.includeProcessVariables()
				.orderByProcessInstanceStartTime().desc()
				.listPage(firstResult, maxResults);
		
		List<TaskBean> rtnList = new ArrayList<TaskBean>(list.size());
		for (int i = 0; i < list.size(); i++) {
			HistoricProcessInstance processInstance = list.get(i);
			TaskBean taskBean = new TaskBean();
//			taskBean.setTaskId();
			taskBean.setCreateTime(processInstance.getStartTime());
//			taskBean.setFormKey();
//			taskBean.setTaskName();
			taskBean.setProcessId(processInstance.getId());
			taskBean.setEndTime(processInstance.getEndTime());
			
			Map<String, Object> map = processInstance.getProcessVariables();
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
	
	public List<TaskBean> findHistoryProcessDetail(String processInstanceId) {
		List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
				.processInstanceId(processInstanceId).orderByTaskCreateTime().asc().list();
		
		List<TaskBean> rtnList = new ArrayList<TaskBean>(list.size());
		for (int i = 0; i < list.size(); i++) {
			HistoricTaskInstance task = list.get(i);
			TaskBean taskBean = new TaskBean();
			taskBean.setTaskId(task.getId());
			taskBean.setCreateTime(task.getCreateTime());
			taskBean.setFormKey(task.getFormKey());
			taskBean.setTaskName(task.getName());
			taskBean.setProcessId(task.getProcessInstanceId());
			taskBean.setEndTime(task.getEndTime());
			if (StringUtils.isNotBlank(task.getAssignee())) {
				String userName = userService.findNameByEmpCode(task.getAssignee());
				taskBean.setAssignee(userName);
			} else {
				String userName = "";
				List<HistoricIdentityLink> identityLinkList = historyService.getHistoricIdentityLinksForTask(task.getId());
				for (int j = 0; j < identityLinkList.size(); j++) {
					HistoricIdentityLink historicIdentityLink = identityLinkList.get(j);
					if ("candidate".equals(historicIdentityLink.getType())) {
						String tmpUserName = userService.findNameByEmpCode(historicIdentityLink.getUserId());
						userName += "," + tmpUserName;
					}
				}
				if (StringUtils.isNotBlank(userName)) {
					taskBean.setAssignee(userName.substring(1));
				}
			}

			rtnList.add(taskBean);
		}
		return rtnList;
	}
	
	/**
	 * 查询历史流程实例
	 * @param processInstanceId
	 * @return
	 */
	public HistoricProcessInstance findHistoryProcessInstance(String processInstanceId){
		HistoricProcessInstance hpi = historyService//与历史数据（历史表）相关的Service
						.createHistoricProcessInstanceQuery()//创建历史流程实例查询
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.orderByProcessInstanceStartTime().asc()
						.singleResult();
		return hpi;
	}
	
	/**
	 * 查询历史活动
	 * @param processInstanceId
	 * @return
	 */
	public List<HistoricActivityInstance> findHistoryActivity(String processInstanceId){
		List<HistoricActivityInstance> list = historyService//
						.createHistoricActivityInstanceQuery()//创建历史活动实例的查询
						.processInstanceId(processInstanceId)//
						.orderByHistoricActivityInstanceStartTime().asc()//
						.list();
		return list;
	}
	
	/**
	 * 查询历史流程变量
	 * @param processInstanceId
	 * @return
	 */
	public List<HistoricVariableInstance> findHistoryProcessVariables(String processInstanceId){
		List<HistoricVariableInstance> list = historyService//
						.createHistoricVariableInstanceQuery()//创建一个历史的流程变量查询对象
						.processInstanceId(processInstanceId)//
						.orderByVariableName().asc()
						.list();
		return list;
	}
	
	/**
	 * 查询历史任务的办理人表
	 * @param processInstanceId
	 * @return
	 */
	public List<HistoricIdentityLink> findHistoryPersonTask(String processInstanceId){
		//流程实例ID
		List<HistoricIdentityLink> list = historyService//
						.getHistoricIdentityLinksForProcessInstance(processInstanceId);
		return list;
	}

}
