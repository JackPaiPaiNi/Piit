/*
 * RoleResourceService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.entity.RoleResource;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.repository.RoleResourceDao;

/**
 * T_ROLE_RESOURCE
 * 角色_资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
@Service
public class RoleResourceService {

    @Autowired
    private RoleResourceDao roleResourceDao;
    
    public int deleteById(String id){
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("id", id);
    	return roleResourceDao.deleteByParam(param);
    }
	
    public int deleteByRoleId(String id){
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("roleId", id);
    	return roleResourceDao.deleteByParam(param);
	}
	
    public int deleteByResourceId(String id){
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("resourceId", id);
    	return roleResourceDao.deleteByParam(param);
	}
    
    public int deleteByRoleIdResourceId(String roleId,String resourceId){
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("roleId", roleId);
    	param.put("resourceId", resourceId);
    	return roleResourceDao.deleteByParam(param);
    }

    public int insert(CoreEntity record){
		return roleResourceDao.insert(record);
	}
    
    public int editRole(String roleId,Map<String, String> param){
    	if (param == null || param.size() == 0) {
			return 0;
		}
    	int count = 0;
    	Iterator<String> iterator = param.keySet().iterator();
    	while (iterator.hasNext()) {
    		String resourceId = iterator.next();
    		String oper = param.get(resourceId);
    		if ("add".equals(oper)) {
    			RoleResource record = new RoleResource();
    			record.setId(UUID.randomUUID().toString());
    			record.setRoleId(roleId);
    			record.setResourceId(resourceId);
				insert(record);
				count++;
			} else if ("del".equals(oper)) {
				deleteByRoleIdResourceId(roleId,resourceId);
    			count++;
			} else {
				throw new ServiceException("非法操作");
			}
		}
    	return count;
    }

}