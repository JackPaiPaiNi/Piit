package com.ey.piit.basebpm.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ey.piit.basebpm.common.Constants;
import com.ey.piit.basebpm.entity.ProcessBean;
import com.ey.piit.basebpm.entity.TaskBean;
import com.ey.piit.basebpm.service.ProcessInstanceService;
import com.ey.piit.basebpm.service.ProcessTaskService;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.google.common.collect.Maps;

public class ProcessInstanceServiceTest {
	
	private TaskService taskService;
	private RuntimeService runtimeService;
	private IdentityService identityService;
	
	private ProcessInstanceService processInstanceService;
	private ProcessTaskService processTaskService;
	
	private String t;
	
	@Before
	public void init(){
		// 获取流程引擎配置对象实例
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		// 数据库相关配置
		configuration.setJdbcUrl("jdbc:oracle:thin:@172.20.99.81:1521:fwb");
		configuration.setJdbcDriver("oracle.jdbc.driver.OracleDriver");
		configuration.setJdbcUsername("SDO_USER");
		configuration.setJdbcPassword("Aa123456");
		/*configuration.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		configuration.setJdbcDriver("oracle.jdbc.driver.OracleDriver");
		configuration.setJdbcUsername("cre_mdm");
		configuration.setJdbcPassword("cre_mdm");*/
		// 配置建表策略,默认情况下false
		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		// 使用配置对象实例创建ProcessEngine
		ProcessEngine processEngine = configuration.buildProcessEngine();
		runtimeService = processEngine.getRuntimeService();
		taskService = processEngine.getTaskService();
		identityService = processEngine.getIdentityService();
		
		processInstanceService = new ProcessInstanceService();
		processInstanceService.setIdentityService(identityService);
		processInstanceService.setRuntimeService(runtimeService);
		processInstanceService.setTaskService(taskService);
		
		processTaskService = new ProcessTaskService();
		processTaskService.setIdentityService(identityService);
		processTaskService.setRuntimeService(runtimeService);
		processTaskService.setTaskService(taskService);
	}

	/*@Test
	public void test001(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		variables.put("out", "commit");
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test001");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//一级审批 同意
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//二级审批 驳回
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "reject");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		//申请人 提交
		taskList = processTaskService.findTask("user", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "commit");
			processTaskService.completeTask(taskBean.getTaskId(), "user", variables);
		}
		
		//一级审批 同意
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			System.out.println(taskBean.getTaskId());
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//二级审批 同意
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}*/
	
	/*@Test
	public void test002(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		variables.put("out", "commit");
		variables.put("var", "A");//条件
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test002");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A 同意
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//B 没有待办
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//E 驳回
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "reject");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		//申请人 提交
		taskList = processTaskService.findTask("user", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "commit");
			variables.put("var", "B");//条件
			processTaskService.completeTask(taskBean.getTaskId(), "user", variables);
		}
		
		//A 没有待办
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//B 同意
		taskList = processTaskService.findTask("B", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "B", variables);
		}
		
		//E 驳回
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "reject");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		//申请人 取消
		taskList = processTaskService.findTask("user", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "close");
			processTaskService.completeTask(taskBean.getTaskId(), "user", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}*/

	/*@Test
	public void test003(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		variables.put("out", "commit");
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test003");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A 补录
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//E 没有待办
		taskList = processTaskService.findTask("E", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//A 补录
		taskList = processTaskService.findTask("B", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "B", variables);
		}
		
		//E 同意
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}*/
	
	/*@Test
	public void test004(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		variables.put("out", "commit");
		variables.put("var", "A");
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test004");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A 补录
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//B 没有待办
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//C 补录
		taskList = processTaskService.findTask("C", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "C", variables);
		}
		
		//E 同意
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}
	
	@Test
	public void test005(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		variables.put("out", "commit");
		variables.put("var", 2);
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test005");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A 补录
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//B 补录
		taskList = processTaskService.findTask("B", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "B", variables);
		}
		
		//C 没有待办
		taskList = processTaskService.findTask("C", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//E 同意
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}
	
	@Test
	public void test006(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		variables.put("out", "commit");
		variables.put("A", "Y");
		variables.put("B", "Y");
		variables.put("C", null);
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test006");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A 补录
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//B 补录
		taskList = processTaskService.findTask("B", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "B", variables);
		}
		
		//C 没有待办
		taskList = processTaskService.findTask("C", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//E 同意
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}
	
	@Test
	public void test007(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test007");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//E
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		//F
		taskList = processTaskService.findTask("F", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			System.out.println("F");
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			String businessId = taskBean.getBusinessId();
			Assert.assertEquals(businessId, "ID1");
			processTaskService.completeTask(taskBean.getTaskId(), "F", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}
	
	@Test
	public void test008(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test008");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("approveUserE", "E");
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//E
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}
	
	@Test
	public void test009(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		variables.put("out", "commit");
		
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test009");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A 同意
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//E 驳回
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "reject");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		//user 提交
		taskList = processTaskService.findTask("user", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "commit");
			processTaskService.completeTask(taskBean.getTaskId(), "user", variables);
		}
		
		//A 同意
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//E 同意
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}
	
	@Test
	public void test010(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		variables.put("out", "commit");
		variables.put("role", null);
		
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test010");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		variables = new HashMap<String, Object>();
		
		//A 同意
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//E 驳回
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "reject");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		//user 提交
		taskList = processTaskService.findTask("user", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "commit");
			processTaskService.completeTask(taskBean.getTaskId(), "user", variables);
		}
		
		//A 没有待办
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//E 同意
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}
	
	@Test
	public void test011(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		TaskBean taskBean = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		variables.put("out", "commit");
		variables.put("A", "Y");
		variables.put("B", "Y");
		variables.put("C", "N");
		
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test011");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//B
		taskList = processTaskService.findTask("B", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "B", variables);
		}
		
		//C 没有待办
		taskList = processTaskService.findTask("C", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//E 驳回
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "reject");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		//user 提交
		taskList = processTaskService.findTask("user", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "commit");
			variables.put("A", "Y");
			variables.put("B", "N");
			variables.put("C", "Y");
			processTaskService.completeTask(taskBean.getTaskId(), "user", variables);
		}
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "A", variables);
		}
		
		//B 没有待办
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertTrue(taskList == null || taskList.size() == 0);
		
		//C
		taskList = processTaskService.findTask("C", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			processTaskService.completeTask(taskBean.getTaskId(), "C", variables);
		}
		
		//E 同意
		taskList = processTaskService.findTask("E", pageJqGrid);
		if (taskList != null && taskList.size() > 0) {
			Assert.assertEquals(taskList.size(), 1);
			taskBean = taskList.get(0);
			variables.put("out", "agree");
			processTaskService.completeTask(taskBean.getTaskId(), "E", variables);
		}
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}
	
	*//**
	 * 驳回到申请节点再提交时直接提交到驳回节点
	 * （注意申请节点的ID要设置为applyNode）
	 */
	/*@Test
	public void test012(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test012");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.rejectTask(taskList.get(0).getTaskId());
		
		//user
		taskList = processTaskService.findTask("user", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "user");
		
		//B
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "B");
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "A");
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}*/
	
	/**
	 * 任意节点驳回后从申请节点重新开始，除申请节点有一个待办外，其他节点待办都会删除
	 * （注意申请节点的ID要设置为applyNode）
	 */
	/*@Test
	public void test0122(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test012");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A 驳回
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.rejectTaskRestart(processId);
		
		//user
		taskList = processTaskService.findTask("user", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "user");
		
		//B
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "B");
		
		//A 驳回
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.rejectTaskRestart(processId);
		
		//user
		taskList = processTaskService.findTask("user", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "user");
		
		//B
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "B");
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "A");
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}*/
	
	/*@Test
	public void test013(){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<TaskBean> taskList = null;
		PageJqGrid pageJqGrid = new PageJqGrid();
		pageJqGrid.setPage(1);
		pageJqGrid.setRows(10);
		
		ProcessBean processBean = new ProcessBean();
		processBean.setBusinessId("ID");
		processBean.setCode("编码");
		processBean.setComment("申请原因");
		processBean.setName("名称");
		processBean.setProcessKey("test013");
		processBean.setProcessType("add");//新增流程
		processBean.setType("pi");//流程类型
		processBean.setUserId("user");
		processBean.setVariables(variables);
		TaskBean instance = processInstanceService.startProcessInstance(processBean);
		String processId = instance.getProcessId();
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "A");
		
		//C
		taskList = processTaskService.findTask("C", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "C");
		
		//B
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.rejectTaskSelect(processId);
		
		//user
		taskList = processTaskService.findTask("user", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		Map<String,String> map = Maps.newHashMap();
		map.put("aNode,bNode", Constants.VAR_KEY_REJECT_SEL_CONTINUE);
		map.put("cNode,dNode", Constants.VAR_KEY_REJECT_SEL_RESTART);
		variables.put(Constants.VAR_KEY_SEL_ACTIVITY_IDS, map);
		processTaskService.completeTaskSelect(taskList.get(0).getTaskId(), "user", variables);
		
		//C
		taskList = processTaskService.findTask("C", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "C");
		
		//D
		taskList = processTaskService.findTask("D", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "D");
		
		//B
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.rejectTaskSelect(processId);
		
		//user
		taskList = processTaskService.findTask("user", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		map = Maps.newHashMap();
		map.put("aNode,bNode", Constants.VAR_KEY_REJECT_SEL_RESTART);
		map.put("cNode,dNode", Constants.VAR_KEY_REJECT_SEL_CONTINUE);
		variables.put(Constants.VAR_KEY_SEL_ACTIVITY_IDS, map);
		processTaskService.completeTaskSelect(taskList.get(0).getTaskId(), "user", variables);
		
		//A
		taskList = processTaskService.findTask("A", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "A");
		
		//B
		taskList = processTaskService.findTask("B", pageJqGrid);
		Assert.assertEquals(taskList.size(), 1);
		processTaskService.completeTask(taskList.get(0).getTaskId(), "B");
		
		boolean processEnd = processInstanceService.isProcessEnd(processId);
		Assert.assertTrue(processEnd);
	}*/
	
}
