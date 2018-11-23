package com.ey.piit.interfaces.invoice.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 收款认领DAO接口
 * @author 邓海
 */
@BatisRepository
public interface IinvoiceDao  {
	
	void callSelectById(Map<String, Object> param);
	
	void callnewSelectById(Map<String, Object> param);
	
}