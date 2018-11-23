/*
 * ResourceService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.ResourceDao;
import com.ey.piit.core.vo.ResourceVo;

/**
 * T_RESOURCE
 * 资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@Service
public class ResourceService extends CoreService {

    @Autowired
    private ResourceDao resourceDao;
    
    public ResourceVo findById(String id) {
        return resourceDao.selectById(id);
    }

    public List<ResourceVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return resourceDao.selectByPage(params, page);
    }
    
    public Set<String> queryPermissionByRoleIds(List<String> roleIds) {
    	if (roleIds == null || roleIds.size() == 0) {
			return new HashSet<String>();
		}
    	return resourceDao.selectPermissionByRoleIds(roleIds);
    }
    
    public List<ResourceVo> queryMenuByUserId(String userId) {
    	return resourceDao.selectMenuByUserId(userId);
    }
    
    public List<TreeNode> queryTree(){
    	return resourceDao.selectTree();
    }
    
    /**
     * 根据角色ID显示是否选中
     * @return
     */
    public List<TreeNode> queryTreeCheckedByRoleId(String roleId){
    	return resourceDao.selectTreeCheckedByRoleId(roleId);
    }

    @Override
    protected ICoreDao getDao() {
        return resourceDao;
    }
}