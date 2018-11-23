package com.ey.piit.sdo.deliverplan.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 走货计划单DAO接口
 * @author 邓海
 */
@BatisRepository
public interface DeliverPlanDao {

	void callSelect(Map<String, Object> param);

	void callSelectById(Map<String, Object> param);
	
	void callQryZhmx(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);

	void callDelete(Map<String, Object> param);

	void callCombine(Map<String, Object> param);

	void callCancel(Map<String, Object> param);

	void callSelectWhb(Map<String, Object> param);

	void callSelectZhjh(Map<String, Object> param);
}