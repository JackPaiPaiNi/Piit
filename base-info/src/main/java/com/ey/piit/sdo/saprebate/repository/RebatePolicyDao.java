package com.ey.piit.sdo.saprebate.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * SAP返利政策DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface RebatePolicyDao  {
	
	Map<String, Object> callSelectRebatePolicyById(Map<String, Object> param);
	
	Map<String, Object> callViewRebatePolicyById(Map<String, Object> param);
	
	Map<String, Object> callRebatePolicyItemApprove(Map<String, Object> param);
	
	Map<String, Object> callRebatePolicyItemComplete(Map<String, Object> param);
	
}