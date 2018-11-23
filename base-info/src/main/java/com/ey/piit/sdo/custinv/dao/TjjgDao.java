package com.ey.piit.sdo.custinv.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 以调价结果为基础-调价结果表DAO接口
 * @author 张钧俊
 */
@BatisRepository
public interface TjjgDao {
	void callSelectTjjg(Map<String,Object> param);
}
