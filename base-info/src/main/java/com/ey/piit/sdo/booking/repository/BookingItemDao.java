package com.ey.piit.sdo.booking.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 订舱通知书DAO接口
 * @author 赵明
 */
@BatisRepository
public interface BookingItemDao {
	void callInsert(Map<String, Object> param);
}