package com.ey.piit.interfaces.payment.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 收款DAO接口
 * @author 
 */
@BatisRepository
public interface IPayReceiveDao  {
	
	void callSelectById(Map<String, Object> param);
	
}