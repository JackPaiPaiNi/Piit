package com.ey.piit.core.scheduler.factory;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.SchedulerSetting;
import com.ey.piit.core.repository.SchedulerSettingDao;

/**
 * 容器初始化时，通过group和scheduleID获取所有此job工程的相关定义的job
 * 如果job不存在的，初始化
 * 如果job存在的，更新cron表达式
 * 直接数据库中配置，不需要spring中配置相关的job
 * 如需实现页面管理监控，载入@Autowired private Scheduler scheduler;并新增相关service服务和页面
 * @author Yingjie.Wu
 *
 */
public class InitSchedulerFactoryBean extends SchedulerFactoryBean {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final Map<String, String> triggerStateMap = new HashMap<String, String>();
	static {
		triggerStateMap.put(Trigger.TriggerState.BLOCKED.name(),"停用");
		triggerStateMap.put(Trigger.TriggerState.NONE.name() ,"等待");
		triggerStateMap.put(Trigger.TriggerState.NORMAL.name() ,"运行中");
		triggerStateMap.put(Trigger.TriggerState.COMPLETE.name() ,"完成");
		triggerStateMap.put(Trigger.TriggerState.ERROR.name() ,"异常状态");
		triggerStateMap.put(Trigger.TriggerState.PAUSED.name() ,"挂起");
	}
	
	private List<JobDetail> jobDetails;
	
	@Autowired
	private SchedulerSettingDao schedulerSettingDao;
	private String group = Scheduler.DEFAULT_GROUP;
	/**
	 * 根据TriggerState状态码得到状态名称. 
	 * @param triggerState 状态码. 引用Trigger中的状态码定义.
	 * @return 返回状态名称.
	 * @throws IllegalArgumentException 如果传入的triggerState不在Trigger中定义,抛出此异常.
	 * @see org.quartz.Trigger
	 */
	public static String getTriggerStateName(String triggerState) {
		if (!triggerStateMap.containsKey(triggerState)) {
			throw new IllegalArgumentException("不合法的TriggerState:" + triggerState);
		}
		return triggerStateMap.get(triggerState);
	}
	
	public InitSchedulerFactoryBean() {

	}

	public List<JobDetail> getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(List<JobDetail> jobDetails) {
		this.jobDetails = jobDetails;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	protected void startScheduler(Scheduler arg0, int arg1)	throws SchedulerException {
		SchedulerSetting schedulerSetting = new SchedulerSetting();
//		schedulerSetting.setSchedulerId(this.getScheduler().getSchedulerName());
//		schedulerSetting.setGroupId(this.getGroup());
		List<SchedulerSetting> schedulerSettings = schedulerSettingDao.findSchedulerSettingList(schedulerSetting);
		for (SchedulerSetting setting : schedulerSettings) {
			logger.debug("Scheduler Setting->" + setting);
			
			startJob(setting);
		}
		
		super.startScheduler(arg0, arg1);
	}
	
	private void startJob(SchedulerSetting setting) {
		logger.debug("start job: " + setting.getSchedulerId());
		
		if (setting.isEnable()) {
			// Cron触发器
			if (setting.isCronType()) {
				cronSchedule(setting);
			// Simple触发器
			} else if (setting.isSimpleType()) {
				simpleSchedule(setting);
			}
		//如果定时器已经被禁用，则从将定时器移除	
		} else {
			removeTrigger(setting.getTriggerName(), setting.getGroupId());
		}
	}

	@SuppressWarnings("unchecked")
	public void cronSchedule(SchedulerSetting schedulerSetting) {
		//为了集群中各个节点中的触发器名字统一，统一使用配置的schedulerID来做触发器名称
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(schedulerSetting.getTriggerName(), schedulerSetting.getGroupId());
			CronTrigger cronTrigger = (CronTrigger) this.getScheduler().getTrigger(triggerKey);
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedulerSetting.getCronExpress());
			
			if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionDoNothing.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionDoNothing();
			}else if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionFireAndProceed.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionFireAndProceed();
			}else if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionIgnoreMisfires.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionIgnoreMisfires();
			}else{
				scheduleBuilder.withMisfireHandlingInstructionDoNothing();
			}
			
//			如果trigger不存在，则创建一个
			if(null == cronTrigger){
//				通过注入的jobClass获取最终的jobDetail实例
				JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(schedulerSetting.getJobClass())).withIdentity(schedulerSetting.getJobName(), schedulerSetting.getGroupId()).build();
				jobDetail.getJobDataMap().put(Constants.JOB_NAME, schedulerSetting.getJobName());
				jobDetail.getJobDataMap().put(Constants.JOB_DESC, schedulerSetting.getDescription());
				jobDetail.getJobDataMap().put(Constants.TRIGGER_NAME, schedulerSetting.getTriggerName());
				jobDetail.getJobDataMap().put(Constants.SCHEDULER_ID, schedulerSetting.getSchedulerId());
				jobDetail.getJobDataMap().put(Constants.PARAM_1, schedulerSetting.getParam1());
				jobDetail.getJobDataMap().put(Constants.PARAM_2, schedulerSetting.getParam2());
				
				cronTrigger = TriggerBuilder.newTrigger().withIdentity(schedulerSetting.getTriggerName(), schedulerSetting.getGroupId()).withSchedule(scheduleBuilder).build();
				this.getScheduler().scheduleJob(jobDetail, cronTrigger);
//			如果trigger已经存在，则更新cronExpress
			}else{
				cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				//按新的trigger重新设置job执行
				this.getScheduler().rescheduleJob(triggerKey, cronTrigger);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public void simpleSchedule(SchedulerSetting schedulerSetting) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(schedulerSetting.getTriggerName(), schedulerSetting.getGroupId());
			SimpleTrigger simpleTrigger = (SimpleTrigger) this.getScheduler().getTrigger(triggerKey);
			SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withRepeatCount(schedulerSetting.getSimpleRepeatCount())
				.withIntervalInSeconds(schedulerSetting.getSimpleRepeatIntervel());
			
			if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionFireNow.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionFireNow();
			}else if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionIgnoreMisfires.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionIgnoreMisfires();
			}else if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionNextWithExistingCount.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionNextWithExistingCount();
			}else if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionNextWithRemainingCount.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionNextWithRemainingCount();
			}else if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionNowWithExistingCount.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionNowWithExistingCount();
			}else if(schedulerSetting.getMisfireHandling() == Constants.MisFireHandling.withMisfireHandlingInstructionNowWithRemainingCount.getCode()){
				scheduleBuilder.withMisfireHandlingInstructionNowWithRemainingCount();
			}else{
				scheduleBuilder.withMisfireHandlingInstructionFireNow();
			}
			
	//		如果trigger不存在，则创建一个
			if(null == simpleTrigger){
				JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(schedulerSetting.getJobClass())).withIdentity(schedulerSetting.getJobName(), schedulerSetting.getGroupId()).build();
				jobDetail.getJobDataMap().put(Constants.JOB_NAME, schedulerSetting.getJobName());
				jobDetail.getJobDataMap().put(Constants.JOB_DESC, schedulerSetting.getDescription());
				jobDetail.getJobDataMap().put(Constants.TRIGGER_NAME, schedulerSetting.getTriggerName());
				jobDetail.getJobDataMap().put(Constants.SCHEDULER_ID, schedulerSetting.getSchedulerId());
				jobDetail.getJobDataMap().put(Constants.PARAM_1, schedulerSetting.getParam1());
				jobDetail.getJobDataMap().put(Constants.PARAM_2, schedulerSetting.getParam2());
				
				simpleTrigger = TriggerBuilder.newTrigger().withIdentity(schedulerSetting.getTriggerName(), schedulerSetting.getGroupId()).withSchedule(scheduleBuilder).build();
				this.getScheduler().scheduleJob(jobDetail, simpleTrigger);
			}else{
				simpleTrigger = simpleTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				//按新的trigger重新设置job执行
				this.getScheduler().rescheduleJob(triggerKey, simpleTrigger);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void pauseTrigger(String triggerName, String group) {
		try {
			JobKey jobKey = JobKey.jobKey(triggerName, group);
			this.getScheduler().pauseJob(jobKey);// 停止触发器
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unused")
	private void resumeTrigger(String triggerName, String group) {
		try {
			JobKey jobKey = JobKey.jobKey(triggerName, group);
			this.getScheduler().resumeJob(jobKey);// 重启触发器
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	private boolean removeTrigger(String triggerName, String group) {
		try {
			JobKey jobKey = JobKey.jobKey(triggerName, group);
			boolean result = this.getScheduler().deleteJob(jobKey);// 移除触发器
			
			return result;
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

	public void destroy() {
		logger.info("destroy quartz schedule...");
		
		try {
			this.getScheduler().shutdown();
			super.destroy();
		} catch (SchedulerException e) {
			logger.error(e.getMessage(), e);
		}
		
	}
}
