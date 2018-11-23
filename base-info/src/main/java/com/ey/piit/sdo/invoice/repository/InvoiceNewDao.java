package com.ey.piit.sdo.invoice.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 发票信息维护DAO接口
 * @author tianrong
 */
@BatisRepository
public interface InvoiceNewDao {
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
	//发票取消检查
	void callCancleCheck(Map<String, Object> param);
	// 发票删除
	void callDelete(Map<String, Object> param);
	// 发票可选订单查询
	void callQryOrder(Map<String, Object> param);
	
	void callQryMain(Map<String, Object> param);
	
	void callQryDetail(Map<String, Object> param);
	
	void callQryOther(Map<String, Object> param);

	void callQryMaterial(Map<String, Object> param);

	void callSaveMaterial(Map<String, Object> param);
	
	void callSaveTssapzt(Map<String, Object> param);

	// 附件提交
	void callSubmitFj(Map<String, Object> param);
	
	//未开票统计查询
	void callSelectWkptj(Map<String, Object> param);
	//保存发票对照表
	void callSaveInvoiceDzb(Map<String, Object> param);
	//查询发票对照表
	void callQryInvoiceDzb(Map<String, Object> param);
	//查询发票对照表用于判断是否需要重新SAP
	void callQryInvoiceDzbCxzt(Map<String, Object> param);
	
	//查询开票金额差异
   void callQryKpcy(Map<String, Object> param);
   
   //修改该发票推送SAP状态
   void callChangeFpzt(Map<String, Object> param);
	
}