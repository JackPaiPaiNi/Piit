package com.ey.piit.sdo.order.repository;
import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 大货订单管理DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface OrderProductCkdDao  {
	void callInsert(Map<String, Object> param);
	void callSelectById(Map<String, Object> param);
	void callSelectByPage(Map<String, Object> param);
	void callAddOrRemove(Map<String, Object> param);
	void callCompute(Map<String, Object> param);
	void callDelete(Map<String, Object> param);
}