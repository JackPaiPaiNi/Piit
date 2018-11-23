package com.ey.piit.sdo.order.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 样机订单辅助变更管理DAO接口
 * @author tianrong
 */
@BatisRepository
public interface OrderSampleFzbgDao {
	void callSelect(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);
	
	void callChange(Map<String, Object> param);
	
	void callGetback(Map<String, Object> param);
}