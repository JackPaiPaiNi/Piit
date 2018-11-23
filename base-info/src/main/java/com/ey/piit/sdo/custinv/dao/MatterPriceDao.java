package com.ey.piit.sdo.custinv.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 客户物料价格库DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface MatterPriceDao {
	void callSelect(Map<String, Object> param);
	
	void callSave(Map<String, Object> param);
}