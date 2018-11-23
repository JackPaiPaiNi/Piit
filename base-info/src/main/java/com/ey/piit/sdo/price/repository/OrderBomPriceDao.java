package com.ey.piit.sdo.price.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 销单BOM价格DAO接口
 * @author 邓海
 */
@BatisRepository
public interface OrderBomPriceDao {
	void callSelect(Map<String, Object> param);
	
	void callSelectJhd(Map<String, Object> param);
	
	void callSelectJhdByPage(Map<String, Object> param);	
	
	void callSelectOrderByPage(Map<String, Object> param);	
	
	void callSelectSKD(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callInsertJhd(Map<String, Object> param);
	
	void getPrice(Map<String, Object> param);
	
	void callValidateZje(Map<String, Object> param);
	
	
}