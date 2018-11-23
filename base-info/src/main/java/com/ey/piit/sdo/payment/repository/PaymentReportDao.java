package com.ey.piit.sdo.payment.repository;

import java.util.Map;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 付款保障报表接口
 * @author 赵明
 */
@BatisRepository
public interface PaymentReportDao {
	/**
	 * 收款银行当月总收款金额
	 * */
	void callSelectBankMonthTotalReceivables(Map<String, Object> param);
	/**
	 * 当月未认领凭证明细
	 * */
	void callSelectNotClaimDocumentsDetail(Map<String, Object> param);	
	/**
	 * 每个客户当月付款总金额及明细（已部分认领或全部认领）
	 * */
	void callSelectCustomPayDetail(Map<String, Object> param);	
	/**
	 * 每一张凭证的预收款总金额及已绑定的预收款金额
	 * */
	void callSelectDepositReceiptTotal(Map<String, Object> param);	
	/**
	 * PI与收款凭证号的关联关系及关联金额
	 * */
	void callSelectRelationshipRvn(Map<String, Object> param);		
	/**
	 * 客户信用额度及使用情况
	 * */
	void callSelectCustomerCreditAndUse(Map<String, Object> param);		
	/**
	 * 每个客户当月L/C登记清单
	 * */
	void callSelectCustomerLcRegistList(Map<String, Object> param);		
	/**
	 * PI与L/C关联关系
	 * */
	void callSelectPIAndLCRelationship(Map<String, Object> param);
	/**
	 * L/C绑定使用情况
	 * */
	void callSelectLCBindingsUsage(Map<String, Object> param);	
	/**
	 * L/C金额、开票金额、回款金额总览
	 * */
	void callSelectLCKpjeHkjeZl(Map<String, Object> param);	
	/**
	 * L/C议付的发票及回款详情
	 * */
	void callSelectLCNegotiationDetail(Map<String, Object> param);	
	/**
	 * 特批记录
	 * */
	void callSelectSpecialRecord(Map<String, Object> param);	
	/**
	 * 特批详细信息
	 * */
	void callSelectSpecialRecordDetail(Map<String, Object> param);	
	/**
	 * 回款明细表
	 * */
	void callSelectPaymentSchedule(Map<String, Object> param);	
	/**
	 * 额度占用情况
	 * */
	void callSelectCreditOccupancy(Map<String, Object> param);
	/**
	 * 客户付款情况总览
	 * */
	void callSelectCustomerPayments(Map<String, Object> param);	
	/**
	 * 付款条件订单使用情况总览
	 * */
	void callSelectUsagePaymentOrders(Map<String, Object> param);	
	
}