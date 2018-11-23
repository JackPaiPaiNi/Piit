package com.ey.piit.sdo.invoice.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 发票其他费用明细DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface InvoiceOtherDao{

	void callInsertOther(Map<String, Object> dtlParam);
	void callSaveOtherTssapzt(Map<String, Object> dtlParam);
	
}