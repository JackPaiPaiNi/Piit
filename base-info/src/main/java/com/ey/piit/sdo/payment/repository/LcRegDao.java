package com.ey.piit.sdo.payment.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * LC登记DAO接口
 * @author 邓海
 */
@BatisRepository
public interface LcRegDao {
	void callSelect(Map<String, Object> param);
	
	void callSelectDbd(Map<String, Object> param);
		
	void callSelectById(Map<String, Object> param);
	
	void callChangeById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);
	
	void callDelete(Map<String, Object> param);
	
	void callSelectJdmxByLcbh(Map<String, Object> param);
	
	void callSaveJdmx(Map<String, Object> param);
	
	void callDeleteJdmx(Map<String, Object> param);	
	
	void callFrozen(Map<String, Object> param);

	void callSelectJdmx(Map<String, Object> param);
	
	void callSelectMx(Map<String, Object> param);
}