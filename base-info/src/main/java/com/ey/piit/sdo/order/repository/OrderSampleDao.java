package com.ey.piit.sdo.order.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 样机订单管理DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface OrderSampleDao {
	void callSelect(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);
	
	void callComplete(Map<String, Object> param);
	
	void callActive(Map<String, Object> param);
	
	void callSelectByDh(Map<String, Object> param);
	
	void callCancel(Map<String, Object> param);
	
	void callChange(Map<String, Object> param);
	
	void callSelectEmail(Map<String, Object> param);
	
	void callGetback(Map<String, Object> param);
}