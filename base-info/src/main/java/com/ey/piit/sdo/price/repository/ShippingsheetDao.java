package com.ey.piit.sdo.price.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 出货资料表管理DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface ShippingsheetDao {
	void callSelect(Map<String, Object> param);
	
	void callSelectDtlByPage(Map<String, Object> param);
	
	void callSaveMain(Map<String, Object> param);

	void callSaveDtl(Map<String, Object> param);
	
	void callDeleteDtl(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);
}