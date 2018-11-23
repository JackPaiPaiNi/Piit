/*
 * RoleOrgDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2016-01-13 Created
 */
package com.ey.piit.core.repository;

import java.util.Map;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 表名：T_ROLE_ORG
 * 表描述：角色_组织
 * 
 * @author Kevin Xu
 * @version 1.0 2016-09-13
 */
@BatisRepository
public interface RoleOrgDao {
    int deleteByParam(Map<String, String> param);
    
    int insert(CoreEntity record);
    
    int update(CoreEntity record);
}