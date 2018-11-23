package com.ey.piit.sdo.booking.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 订舱通知书DAO接口
 * @author 赵明
 */
@BatisRepository
public interface BookingDao{
	// 订舱插入主表
	void callInsert(Map<String, Object> param);
	// 订舱查询方法
	void callSelect(Map<String, Object> param);	
	// 订舱查询主明细信息
	void callSelectById(Map<String, Object> param);	
	// 根据预走货单号查询客体预走货
	void callSelectKtyzh(Map<String, Object> param);
	// 订舱查询主明细信息
	void callSelectByYzhdhs(Map<String, Object> param);	
	// 订舱提交
	void callSubmit(Map<String, Object> param);
	// 订舱删除
	void callDelete(Map<String, Object> param);
	// 根据订舱查询预走货明细
    void callSelectYzhDtl(Map<String, Object> param);
    // 应收超期保存
	void callYscqSave(Map<String, Object> param);
	// 审核
	void callApprove(Map<String, Object> param);
	// 订舱待办查询
	void callSelectDB(Map<String, Object> param);
	//订舱取消
	void callCancel(Map<String, Object> param);	
	// 发送邮件
	void callSelectEmail(Map<String, Object> param);
	
	void callGetback(Map<String, Object> param);
}