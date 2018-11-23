package com.ey.piit.sdo.payment.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 收款认领DAO接口
 * @author 邓海
 */
@BatisRepository
public interface PayReceiveClaimDao  {
    void callSelect(Map<String, Object> param);
    
    void callSelectDbd(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callSelectInvoice(Map<String, Object> param);
	
	void callChangeById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callCancel(Map<String, Object> param);
	
	void callComplete(Map<String, Object> param);
	
	void callYskToHk(Map<String, Object> param);
	
	void callYskDjAndJd(Map<String, Object> param);
	
}