package com.ey.piit.sdo.saprebate.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * sap返利申请DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface RebateApplyDao  {
	Map<String, Object> callSelectRebateApplyById(Map<String, Object> param);
	
	Map<String, Object> callViewRebateApplyById(Map<String, Object> param);
	
	Map<String, Object> callRebateApplyItemApprove(Map<String, Object> param);
	
	Map<String, Object> callRebateApplyItemComplete(Map<String, Object> param);
	
}