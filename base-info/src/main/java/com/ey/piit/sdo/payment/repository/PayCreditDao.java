package com.ey.piit.sdo.payment.repository;

import java.util.Map;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 信用额度管理DAO接口
 * @author 田荣
 */
@BatisRepository
public interface PayCreditDao {
	void callSelect(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callChangeById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);
	
	void callFrozen(Map<String, Object> param);
	
	void callAdjust(Map<String, Object> param);
	
	
}