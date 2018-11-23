package com.ey.piit.sdo.invoice.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 装柜清单DAO接口
 * @author tianrong
 */
@BatisRepository
public interface ZgListDao {
	
	void callSelect(Map<String, Object> param);
	
	void callSaveChdTssapzt(Map<String, Object> param);
	
}