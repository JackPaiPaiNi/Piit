package com.ey.piit.sdo.order.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 大货订单管理DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface OrderProductDao {
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
	
	void callCancelApprove(Map<String, Object> param);
	
	void callChange(Map<String, Object> param);
	
	void callCheckValue(Map<String, Object> param);
	
	void callSelectEmail(Map<String, Object> param);
	
	void callGetback(Map<String, Object> param);

	void callPause(Map<String, Object> param);

	void callPauseSubmit(Map<String, Object> param);

	void callPauseApprove(Map<String, Object> param);
	
	void callSelectByIdView(Map<String, Object> param);
}