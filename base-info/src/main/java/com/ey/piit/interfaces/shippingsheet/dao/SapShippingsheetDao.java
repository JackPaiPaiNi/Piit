package com.ey.piit.interfaces.shippingsheet.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 出货资料表DAO接口
 * @author 
 */
@BatisRepository
public interface SapShippingsheetDao  {
	
	void callSelectByDrdh(Map<String, Object> param);
	
}