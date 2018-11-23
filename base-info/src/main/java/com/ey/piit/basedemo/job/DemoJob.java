package com.ey.piit.basedemo.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

import com.ey.piit.basedemo.user.service.UserDemoService;
import com.ey.piit.core.scheduler.job.BaseJob;
import com.ey.piit.core.spring.SpringUtils;

@DisallowConcurrentExecution
public class DemoJob extends BaseJob implements InterruptableJob {
	
	private static UserDemoService userDemoService = SpringUtils.getBean(UserDemoService.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
	
		logger.info("-------------------------------Get Demo Job Start-------------------------------");
		
		try {

			//开始执行之前先写定时任务日志记录，记录开始时间
			super.beforeExecute(context);
			
			// 执行任务操作
//			userDemoService.xxxxxxx();
			
			//业务执行完之后写定时任务日志记录，记录结束时间以及运行结果
			super.afterExecute(context, BaseJob.JOB_RESULT_SUCCESS);
		} catch (Throwable e) {
			try {
				logger.error(e.getMessage(), e);
				super.afterExecute(context, BaseJob.JOB_RESULT_FAILURE);
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		}
	
		logger.info("-------------------------------Get Demo Job End-------------------------------");
	
	}

	@Override
	public void interrupt() throws UnableToInterruptJobException {
		// TODO Auto-generated method stub
		
	}

}
