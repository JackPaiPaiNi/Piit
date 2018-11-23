package com.ey.piit.sdo.custinv.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 以装柜清单为基础-调价表DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface ZgqdPriceDao {
	void callSelectZgqd(Map<String, Object> param);
	
	void callZgqdAdjust1(Map<String, Object> param);
	
	void callZgqdAdjust2(Map<String, Object> param);
	
	void callJhdAdjust(Map<String, Object> param);
}