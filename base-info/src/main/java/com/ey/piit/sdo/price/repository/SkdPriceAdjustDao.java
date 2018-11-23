package com.ey.piit.sdo.price.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * SKD调价单DAO接口
 * @author 邓海
 */
@BatisRepository
public interface SkdPriceAdjustDao {

	void callSelect(Map<String, Object> param);

	void callSelectById(Map<String, Object> param);
	
	void callQryDdxx(Map<String, Object> param);
	
	void callQryJhd(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
}