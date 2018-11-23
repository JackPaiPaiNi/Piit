package com.ey.piit.interfaces.delivery.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 出货通知书DAO接口
 * @author 
 */
@BatisRepository
public interface SapDeliverDao  {
	
	void callSelectById(Map<String, Object> param);
	
}