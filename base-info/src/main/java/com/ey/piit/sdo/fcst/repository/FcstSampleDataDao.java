package com.ey.piit.sdo.fcst.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 采购FCST样机填报DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface FcstSampleDataDao {

	void callSelect(Map<String, Object> param);

	void callDelete(Map<String, Object> param);

	void callInsert(Map<String, Object> param);

	void callSelectWeek(Map<String, Object> param);
	
}