package com.ey.piit.sdo.agent.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 委托DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface AgentDao{
	void callInsert(Map<String, Object> param);
	void callSelect(Map<String, Object> param);
	void callSelectById(Map<String, Object> param);
	void callCancel(Map<String, Object> param);
}