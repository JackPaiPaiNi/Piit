package com.ey.piit.core.repository;

import com.ey.piit.core.entity.SchedulerLog;
import com.ey.piit.core.repository.base.BatisRepository;

@BatisRepository
public interface ScheduleLogDao {
	/**
	 * 添加
	 * @param scheduleInfo
	 * @return
	 */
	void saveScheduleLog(SchedulerLog scheduleLog);
	/**
	 * 更新
	 * @param scheduleInfo
	 */
	void updateSchduleLog(SchedulerLog scheduleLog);
	
	/**
	 * 根据自定义的ID查询单条定时任务信息
	 */
	SchedulerLog findScheduleInfoByScheduleId(String schedulerId);
	/**
	 * 根据定时任务ID查询
	 * @param id
	 * @return
	 */
	SchedulerLog findScheduleInfoById(String id);
}