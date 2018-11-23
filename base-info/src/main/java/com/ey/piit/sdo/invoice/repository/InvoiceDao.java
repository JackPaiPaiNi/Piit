package com.ey.piit.sdo.invoice.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 发票信息维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface InvoiceDao {
	// 发票主页面查询
	void callSelect(Map<String, Object> param);
	// 发票主明细查询
	void callSelectById(Map<String, Object> param);
	// 发票主表保存
	void callInsert(Map<String, Object> param);
	// 发票主表提交
	void callSubmit(Map<String, Object> param);
	// 发票取消
	void callCancle(Map<String, Object> param);
	// 发票删除
	void callDelete(Map<String, Object> param);
	// 发票可选订单查询
	void callQryOrder(Map<String, Object> param);
	
	void callQryMain(Map<String, Object> param);
	
	void callQryItem(Map<String, Object> param);
	
	void callQryPacking(Map<String, Object> param);
	
	void callQryOther(Map<String, Object> param);

	void callQryMaterial(Map<String, Object> param);

	void callSaveMaterial(Map<String, Object> param);
	
	void callSaveTssapzt(Map<String, Object> param);

	// 附件提交
	void callSubmitFj(Map<String, Object> param);
	
	//未开票统计查询
	void callSelectWkptj(Map<String, Object> param);
	
}