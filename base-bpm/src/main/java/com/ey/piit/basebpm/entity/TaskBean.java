package com.ey.piit.basebpm.entity;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ey.piit.core.format.JsonTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class TaskBean{
	/**
	 * 申请单号
	 */
	private String taskId;
	/**
	 * 代办名称
	 */
	private String taskName;
	/**
	 * 业务主键
	 */
	private String businessId;
	/**
	 * 代办接收时间
	 */
	private Date createTime;
	/**
	 * 连接地址
	 */
	private String formKey;
	/**
	 * 流程实例ID
	 */
	private String processId;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 主数据类型
	 */
	private String type;
	/**
	 * 实体名称
	 */
	private String name;
	/**
	 * 流程类型
	 */
	private String processType;
	/**
	 * 流程名称
	 */
	private String processName;
	/**
	 * 流程发起人
	 */
	private String applyUser;
	/**
	 * 流程发起时间
	 */
	private Date applyTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 分配到任务的人
	 */
	private String assignee;
	/**
	 * 任务定义key
	 */
	private String taskKey;
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonSerialize(using = JsonTimeSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getFormKey() {
		return formKey;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProcessType() {
		return processType;
	}
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	@JsonSerialize(using = JsonTimeSerializer.class)
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	@JsonSerialize(using = JsonTimeSerializer.class)
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getTaskKey() {
		return taskKey;
	}
	public void setTaskKey(String taskKey) {
		this.taskKey = taskKey;
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}	
}
