package com.ey.piit.sdo.pi.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * PI管理DAO接口
 * @author 王歌
 */
@BatisRepository
public interface PiItemDao {
	void callSelect(Map<String, Object> param);
	void callInsert(Map<String, Object> param);
	void callSelectBypIid(Map<String, Object> param);
}