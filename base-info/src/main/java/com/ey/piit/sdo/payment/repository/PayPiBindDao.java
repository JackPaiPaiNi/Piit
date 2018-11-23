package com.ey.piit.sdo.payment.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * PI付款保障关联DAO接口
 * @author 田荣
 */
@BatisRepository
public interface PayPiBindDao {
	void callSelect(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callInsertItem(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callSelectItem(Map<String, Object> param);
}