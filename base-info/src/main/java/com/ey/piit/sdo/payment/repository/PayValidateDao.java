package com.ey.piit.sdo.payment.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 付款保障检查DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface PayValidateDao {
	
	void callSelectLog(Map<String, Object> param);
	
	void callCheckOrder(Map<String, Object> param);
	
	void callCheckPso(Map<String, Object> param);
	
	void callSaveLog(Map<String, Object> param);
	
}