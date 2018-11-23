package com.ey.piit.core.repository;

import java.io.Serializable;
import java.util.List;

import com.ey.piit.core.entity.SchedulerSetting;
import com.ey.piit.core.repository.base.BatisRepository;

@BatisRepository
public interface SchedulerSettingDao {

	/**
	 * 添加
	 * @param scheduleInfo
	 * @return
	 */
	Serializable saveScheduleSetting(SchedulerSetting schedulerSetting);
	/**
	 * 更新
	 * @param scheduleInfo
	 */
	void updateScheduleSetting(SchedulerSetting schedulerSetting);
	
	/**
	 * 根据名字查询定时任务设置信息
	 */
	List<SchedulerSetting> findSchedulerSettingByName(String name);
	
	/**
	 * 根据定时任务ID查询
	 * @param id
	 * @return
	 */
	SchedulerSetting findScheduleSettingById(String id);
	
	/**
	 * 根据schedulerWar名称查询SchedulerSetting列表.
	 * @param schdulerWar 
	 * @return 返回SchedulerSetting列表.
	 */
	List<SchedulerSetting> findSchedulerSettingBySchedulerWar(String schedulerWar);
	/**
	 * 根据schedulerId 查询SchedulerSetting对象.
	 * @param schedulerId
	 * @return SchedulerSetting对象.
	 */
	SchedulerSetting findSchedulerSettingBySchedulerId(String schedulerId);
	
	List<SchedulerSetting> findSchedulerSettingList(SchedulerSetting schedulerSetting);
	
}
