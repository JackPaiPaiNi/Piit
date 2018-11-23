package com.ey.piit.sdo.price.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * SKD调价单明细DAO接口
 * @author 邓海
 */
@BatisRepository
public interface SkdPriceAdjustItemDao {
	void callInsert(Map<String, Object> param);
}