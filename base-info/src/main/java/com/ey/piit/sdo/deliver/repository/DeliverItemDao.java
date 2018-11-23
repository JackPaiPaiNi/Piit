package com.ey.piit.sdo.deliver.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 出货通知书管理DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface DeliverItemDao {
	void callInsert(Map<String, Object> param);
}