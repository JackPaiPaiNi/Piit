package com.ey.piit.sdo.order.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 副营订单管理DAO接口
 * @author tianrong
 */
@BatisRepository
public interface OrderFyItemDao {

	void callInsert(Map<String, Object> dtlParam);
	
}