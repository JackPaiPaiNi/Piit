package com.ey.piit.sdo.art.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 美工任务单OEMDAO接口
 * @author 魏诚
 */
@BatisRepository
public interface ArtoemDao{
	// 美工任务单OEM插入主表
	void callInsert(Map<String, Object> param);
	// 美工任务单OEM查询方法
	void callSelect(Map<String, Object> param);	
	// 美工任务单OEM查询主明细信息
	void callSelectById(Map<String, Object> param);	
	// 美工任务单OEM提交
	void callSubmit(Map<String, Object> param);
	// 美工任务单OEM删除
	void callDelete(Map<String, Object> param);
	// 美工任务单OEM审核
	void callApprove(Map<String, Object> param);
	// 美工任务单OEM取回
	void callGetback(Map<String, Object> param);
	// 美工任务单OEM变更
	void callChange(Map<String, Object> param);
	
	void callBc(Map<String, Object> param);
	
	void callSelectHtyByRwdh(Map<String, Object> param);
	// 美工任务单OEM取消
	void callCancel(Map<String, Object> param);
	//美工任务单取消邮件通知
	void callSelectEmail(Map<String, Object> param);
	
}