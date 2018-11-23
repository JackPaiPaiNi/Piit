package com.ey.piit.sdo.payment.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 收款信息登记DAO接口
 * @author 邓海
 */
@BatisRepository
public interface PayReceiveDao {
    void callSelect(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callSelectByDh(Map<String, Object> param);
	
	void callSelectDrl(Map<String, Object> param);
	
	void callChangeById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callCancel(Map<String, Object> param);
	
	void callFrozen(Map<String, Object> param);

	void callSaveTssapzt(Map<String, Object> param);
	
	void callModifyBzxx(Map<String, Object> param);
	
}