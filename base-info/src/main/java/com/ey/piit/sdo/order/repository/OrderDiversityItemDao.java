package com.ey.piit.sdo.order.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 多元化订单管理DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface OrderDiversityItemDao {

	void callInsert(Map<String, Object> dtlParam);
	
}