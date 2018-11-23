package com.ey.piit.sdo.order.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 备损订单管理DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface OrderSpoItemDao {
	void callInsert(Map<String, Object> param);
}