package com.ey.piit.core.scheduler.job;

import java.net.InetAddress;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.SchedulerLog;
import com.ey.piit.core.repository.ScheduleLogDao;
import com.ey.piit.core.service.ScheduleService;
import com.ey.piit.core.spring.SpringUtils;

public abstract class BaseJob implements Job{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static String JOB_RESULT_SUCCESS="SUCCESS";
	public static String JOB_RESULT_FAILURE="FAILURE";
	public static String JOB_RESULT_EXCEPTION="EXCEPTION";
	
	protected ScheduleLogDao scheduleJobDao;
	
	private ScheduleService scheduleService;
	
	protected String id;
	//计划ID
	protected String schedulerId;
	//
	protected String jobName;
	//
	protected String jobDesc;
	
	protected String param1;
	
	protected String param2;
	
	private String hostName;
	
	private String hostAddress;
	
	protected Date startTime;
	
	public BaseJob() {
		try {
			this.hostName = InetAddress.getLocalHost().getHostName();
			this.hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public String getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(String schedulerId) {
		this.schedulerId = schedulerId;
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

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	protected void beforeExecute(JobExecutionContext context){
		scheduleService = getScheduleService();
		this.startTime = new Date(System.currentTimeMillis());
		
		SchedulerLog scheduleLog = new SchedulerLog();
		scheduleLog.setSchedulerId(context.getJobDetail().getJobDataMap().get(Constants.SCHEDULER_ID).toString());
		scheduleLog.setJobName(context.getJobDetail().getJobDataMap().get(Constants.JOB_NAME).toString());
		scheduleLog.setJobDesc(context.getJobDetail().getJobDataMap().get(Constants.JOB_DESC).toString());
		scheduleLog.setHostName(hostName);
		scheduleLog.setHostAddress(hostAddress);
		scheduleLog.setPrevStartTime(startTime);

		String id = scheduleService.saveScheduleLog(scheduleLog);
		
		this.id = id;
	}
	
	protected void afterExecute(JobExecutionContext context, String result){
		scheduleService = getScheduleService();
		Date now = new Date(System.currentTimeMillis());
		
		SchedulerLog scheduleLog = new SchedulerLog();
		scheduleLog.setSchedulerId(context.getJobDetail().getJobDataMap().get(Constants.SCHEDULER_ID).toString());
		scheduleLog.setJobName(context.getJobDetail().getJobDataMap().get(Constants.JOB_NAME).toString());
		scheduleLog.setJobDesc(context.getJobDetail().getJobDataMap().get(Constants.JOB_DESC).toString());
		scheduleLog.setHostName(hostName);
		scheduleLog.setHostAddress(hostAddress);
		
		scheduleLog.setId(id);
		scheduleLog.setPrevStartTime(startTime);
		scheduleLog.setPrevEndTime(now);
		scheduleLog.setPrevResult(result);
		
		scheduleService.updateSchduleLog(scheduleLog);
	}

	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this);
	}

	public ScheduleService getScheduleService() {
		if(scheduleService == null){
			return SpringUtils.getBean(ScheduleService.class);
		}
		return scheduleService;
	}
}
