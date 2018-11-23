package com.ey.piit.sdo.deliverplan.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 走货计划单明细DAO接口
 * @author 邓海
 */
@BatisRepository
public interface DeliverPlanItemDao {
	void callInsert(Map<String, Object> param);
}