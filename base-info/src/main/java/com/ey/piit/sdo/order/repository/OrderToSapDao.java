package com.ey.piit.sdo.order.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 订单推送SAP管理DAO接口
 * @author 赵明
 */
@BatisRepository
public interface OrderToSapDao {
	
	void callSelect(Map<String, Object> param);
	void callCloseOrder(Map<String, Object> param);	
	void callComplete(Map<String, Object> param);	
	
}