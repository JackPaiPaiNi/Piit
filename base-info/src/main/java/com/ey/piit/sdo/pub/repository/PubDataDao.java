package com.ey.piit.sdo.pub.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 
 * @author zhaotaojun
 * @version 1.0 2017-1-11
 */
@BatisRepository
public interface PubDataDao {
	
	void callSelectDhdd(Map<String, Object> param);
	//检查物料是存在
	void callCheckwl(Map<String, Object> param);
	
}