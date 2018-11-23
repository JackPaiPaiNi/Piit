/**
 * 定时任务信息
 */
package com.ey.piit.core.entity;


import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SchedulerLog{

	//id
	private String id;
	
	//与任务相关的ID
	private String schedulerId;
	
	//任务名称
	private String jobName;
	
	//任务介绍
	private String jobDesc;
	
	//服务器主机名
	private String hostName;
	
	//服务器地址
	private String hostAddress;
	
	//上次开始运行时间
	private Date prevStartTime;
	
	//上次任务执行结果
	private String prevResult;
	
	//上次截止运行时间
	private Date prevEndTime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(String schedulerId) {
		this.schedulerId = schedulerId;
	}

	public Date getPrevStartTime() {
		return prevStartTime;
	}

	public void setPrevStartTime(Date prevStartTime) {
		this.prevStartTime = prevStartTime;
	}

	public String getPrevResult() {
		return prevResult;
	}

	public void setPrevResult(String prevResult) {
		this.prevResult = prevResult;
	}

	public Date getPrevEndTime() {
		return prevEndTime;
	}

	public void setPrevEndTime(Date prevEndTime) {
		this.prevEndTime = prevEndTime;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}