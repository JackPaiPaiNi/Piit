package com.ey.piit.sdo.payment.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 特批维护DAO接口
 * @author 田荣
 */
@BatisRepository
public interface PaySpecialDao {

	void callSelect(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callDelete(Map<String, Object> param);

	void callXc(Map<String, Object> param);
	
	// 待特批的订单查询
	void callSelectOrder(Map<String, Object> param);
	// 待特批的预走货查询（应收超期）
	void callSelectYzh(Map<String, Object> param);
	
	/**
	 * 查找是否存在应收超期特批
	 * @param param
	 */
	void callQueryYscqtp(Map<String, Object> param);
}