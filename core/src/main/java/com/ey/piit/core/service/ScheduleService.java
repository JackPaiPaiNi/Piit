package com.ey.piit.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.entity.SchedulerLog;
import com.ey.piit.core.repository.ScheduleLogDao;
import com.ey.piit.core.utils.Identities;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleLogDao scheduleJobDao;

	public String saveScheduleLog(SchedulerLog scheduleLog) {
		
		String uuid = Identities.uuid();
		scheduleLog.setId(uuid);
		scheduleJobDao.saveScheduleLog(scheduleLog);
		
		return uuid;
	}

	public void updateSchduleLog(SchedulerLog scheduleLog) {
		scheduleJobDao.updateSchduleLog(scheduleLog);
	}
}
