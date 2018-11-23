package com.ey.piit.sdo.order.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 订单管理DAO接口
 * @author 赵明
 */
@BatisRepository
public interface OrderReferPiDao {
	void callSelectSPO(Map<String, Object> param);

	void callSelectOrder(Map<String, Object> param);
	
	void callSelectSample(Map<String, Object> param);
	
	void callSelectDiversity(Map<String, Object> param);
	
	void callSelectFy(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSelectByPIId(Map<String, Object> param);
	
	
}