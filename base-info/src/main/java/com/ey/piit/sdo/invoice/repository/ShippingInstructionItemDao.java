package com.ey.piit.sdo.invoice.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 补料单信息维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface ShippingInstructionItemDao{

	void callInsertItem(Map<String, Object> dtlParam);

	void callSelectCkmxByChxx(Map<String, Object> param);
	
}