package com.ey.piit.sdo.invoice.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 补料单信息维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface ShippingInstructionDao {

	void callSelect(Map<String, Object> param);

	void callSelectById(Map<String, Object> param);

	void callSelectChxx(Map<String, Object> param);
	
	void callSelectBlxx(Map<String, Object> param);

	void callInsert(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
}