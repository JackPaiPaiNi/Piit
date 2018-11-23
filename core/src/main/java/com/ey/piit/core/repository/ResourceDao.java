/*
 * ResourceDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.core.vo.ResourceVo;

/**
 * 表名：T_RESOURCE
 * 表描述：资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@BatisRepository
public interface ResourceDao extends ICoreDao {
    ResourceVo selectById(String id);

    List<ResourceVo> selectByPage(Map<String, Object> params, PageBounds page);
    
    Set<String> selectPermissionByRoleIds(List<String> roleIds);
    
    List<ResourceVo> selectMenuByUserId(String userId);
    
    List<TreeNode> selectTree();
    
    List<TreeNode> selectTreeCheckedByRoleId(String roleId);
}