package com.ey.piit.interfaces.approve.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * SAP审批流
 * @author tianrong
 */
@BatisRepository
public interface IApproveDao  {
	
	void callSelectById(Map<String, Object> param);
	
	//费用申请，预提推送SAP取数
	void callSelectYtById(Map<String, Object> param);
	
	
}