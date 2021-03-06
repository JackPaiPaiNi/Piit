/*
 * UserRoleDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.repository;

import java.util.Map;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 表名：T_USER_ROLE
 * 表描述：用户_角色
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
@BatisRepository
public interface UserRoleDao {
	int deleteByParam(Map<String, String> param);

	int insert(CoreEntity record);
}