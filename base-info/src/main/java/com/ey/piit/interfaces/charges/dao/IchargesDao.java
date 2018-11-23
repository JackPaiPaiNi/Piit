package com.ey.piit.interfaces.charges.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 工装海运费
 * @author tianrong
 */
@BatisRepository
public interface IchargesDao  {
	
	void callSelectById(Map<String, Object> param);
	
}