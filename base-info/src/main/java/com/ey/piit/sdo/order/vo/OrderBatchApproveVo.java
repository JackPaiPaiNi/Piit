package com.ey.piit.sdo.order.vo;


/**
 * 批量审批订单Vo
 * @author 魏诚
 */
public class OrderBatchApproveVo {
	
	private String id;
	private String processId;
	private String taskId;
	private String formKey;
	
	
	public String getId() {
		return id;
	}
	public String getProcessId() {
		return processId;
	}
	public String getTaskId() {
		return taskId;
	}
	public String getFormKey() {
		return formKey;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	
}