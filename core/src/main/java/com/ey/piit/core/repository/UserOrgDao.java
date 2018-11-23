/*
 * UserOrgDao.java
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
 * 表名：T_USER_ORG
 * 表描述：用户_组织
 * 
 * @author Kevin Xu
 * @version 1.0 2016-01-13
 */
@BatisRepository
public interface UserOrgDao {
    int deleteByParam(Map<String, String> param);
    
    int insert(CoreEntity record);
    
    int update(CoreEntity record);
}