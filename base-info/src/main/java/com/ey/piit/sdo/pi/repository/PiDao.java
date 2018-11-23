package com.ey.piit.sdo.pi.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * PI管理DAO接口
 * @author 王歌
 */
@BatisRepository
public interface PiDao {
	void callSelect(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callDelete(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callSelectPrintById(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);
	
	void callSelectByDh(Map<String, Object> param);
	
	void callCancel(Map<String, Object> param);
	
	void callChange(Map<String, Object> param);
	
	void callBfChange(Map<String, Object> param);
	//查询客户类型
	void callQueryKhlxByKhbm(Map<String, Object> param);
	//SMO审核
	void callSmoApprove(Map<String, Object> param);
	
	void callGetback(Map<String, Object> param);

	void callScreenSelect(Map<String, Object> param);

}