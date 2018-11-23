package com.ey.piit.sdo.mdm.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * PID信息维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface PidInfoDao {
	
	void callSubmit(Map<String, Object> param);

	void callInsert(Map<String, Object> param);

	void callApprove(Map<String, Object> param);

	void callSelect(Map<String, Object> param);

	void callSelectById(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	//PID补充信息保存
	void callBcxxSave(Map<String, Object> param);
	
	void callSavePidInfoTssapzt(Map<String, Object> param);
	
	void callSelectEmail(Map<String, Object> param);
	
	void callChange(Map<String, Object> param);
	//计划完成时间更新
	void callJhwcsjSave(Map<String, Object> param);
	
	
	
}