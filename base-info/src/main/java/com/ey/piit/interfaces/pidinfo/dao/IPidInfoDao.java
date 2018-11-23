package com.ey.piit.interfaces.pidinfo.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * pid 申请
 * @author 邓海
 */
@BatisRepository
public interface IPidInfoDao  {
	
	void callSelectById(Map<String, Object> param);
	
}