package com.ey.piit.sdo.price.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * SKD价格DAO接口
 * @author 邓海
 */
@BatisRepository
public interface SkdPriceDao {
	void callSelect(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void getPrice(Map<String, Object> param);
	
	
}