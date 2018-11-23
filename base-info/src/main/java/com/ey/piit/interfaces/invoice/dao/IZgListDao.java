package com.ey.piit.interfaces.invoice.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 装柜清单查询接口
 * @author 
 */
@BatisRepository
public interface IZgListDao  {
	
	void callSelect(Map<String, Object> param);
	
}