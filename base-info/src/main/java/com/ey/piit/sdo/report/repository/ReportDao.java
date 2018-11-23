package com.ey.piit.sdo.report.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 报表接口
 * @author 赵明
 */
@BatisRepository
public interface ReportDao {

	void callSelectPiOrder(Map<String, Object> param);
	
	void callSelectOrderLinkData(Map<String, Object> param);
	
	void callSelectOrderStatus(Map<String, Object> param);
	
	void callSelectInvoiceTable(Map<String, Object> param);
	
	void callSelectEuropeSKDorderStatus(Map<String, Object> param);
	
	void callSelectPaymentReceive(Map<String, Object> param);

	void callSelectReceivePaymentInvoice(Map<String, Object> param);

	void callSelectSapDelivery(Map<String, Object> param);
	
}