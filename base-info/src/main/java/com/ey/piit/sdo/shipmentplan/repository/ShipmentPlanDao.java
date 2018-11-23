package com.ey.piit.sdo.shipmentplan.repository;
import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 走货计划DAO接口
 * @author tianrong
 */
@BatisRepository
public interface ShipmentPlanDao {
    void callSelect(Map<String, Object> param);
	
    void callSelectByYzhdh(Map<String, Object> param);
    
	void callInsert(Map<String, Object> param);
	
	void callInterfaceSelect(Map<String, Object> param);
}