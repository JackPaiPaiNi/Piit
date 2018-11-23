package com.ey.piit.sdo.deliver.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 出货通知书管理DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface DeliverDao {
	// 代办查询
	void callSelectDb(Map<String, Object> param);
	// 预走货查询
	void callSelectYzhxx(Map<String, Object> param);	
	// 新增出货通知书根据预走货单号查询
	void callSelectYzh(Map<String, Object> param);
	// 出货通知书查询
	void callSelect(Map<String, Object> param);
	// 出货通知书查询BY ID
	void callSelectById(Map<String, Object> param);
	//报关打印查询
	void callQueryByPrintBg(Map<String, Object> param);
	// 出货通知书变更BY ID
	void callChangeById(Map<String, Object> param);
	//出货通知书查询邮件内容
	void callSelectEmail(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callComplete(Map<String, Object> param);
	//出货通知书取消
	void callCancel(Map<String, Object> param);
	//更新发送邮件状态
	void callYjztSave(Map<String, Object> param);
	//查询SAP箱单明细
	void callSelectSAPDeliver(Map<String, Object> param);
	//多元化屏出货通知书查询
	void callScreenSelect(Map<String, Object> param);
	//查询出货信息
	void callSelectChxx(Map<String, Object> param);
}