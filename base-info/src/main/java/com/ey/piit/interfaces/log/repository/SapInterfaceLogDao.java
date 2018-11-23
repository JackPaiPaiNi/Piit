package com.ey.piit.interfaces.log.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * SAP接口日志DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface SapInterfaceLogDao {
	
	void callSaveLog(Map<String, Object> param);

	void callSelectLog(Map<String, Object> param);
	
}