/*
 * RoleDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.repository;

import java.util.List;
import java.util.Map;

import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.core.vo.RoleVo;

/**
 * 表名：T_ROLE
 * 表描述：角色
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@BatisRepository
public interface RoleDao extends ICoreDao {
    RoleVo selectById(String id);

    List<RoleVo> selectByPage(Map<String, Object> params, PageBounds page);
    
    List<RoleVo> selectByUserId(String userId);
    
    List<RoleVo> selectAll();
}