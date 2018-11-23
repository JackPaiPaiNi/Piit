/*
 * UserRoleService.java
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
import com.ey.piit.core.entity.UserRole;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.repository.UserRoleDao;

/**
 * T_USER_ROLE
 * 用户_角色
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
@Service
public class UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;
    
    public int deleteById(String id){
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("id", id);
    	return userRoleDao.deleteByParam(param);
    }
	
    public int deleteByUserId(String id){
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("userId", id);
    	return userRoleDao.deleteByParam(param);
	}
	
    public int deleteByRoleId(String id){
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("roleId", id);
    	return userRoleDao.deleteByParam(param);
	}
    
    public int deleteByUserIdRoleId(String userId,String roleId){
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("userId", userId);
    	param.put("roleId", roleId);
    	return userRoleDao.deleteByParam(param);
    }

    public int insert(CoreEntity record){
		return userRoleDao.insert(record);
	}

    public int editUser(String userId,Map<String, String> param){
    	if (param == null || param.size() == 0) {
			return 0;
		}
    	int count = 0;
    	Iterator<String> iterator = param.keySet().iterator();
    	while (iterator.hasNext()) {
    		String roleId = iterator.next();
    		String oper = param.get(roleId);
    		if ("add".equals(oper)) {
    			UserRole record = new UserRole();
    			record.setId(UUID.randomUUID().toString());
    			record.setUserId(userId);
    			record.setRoleId(roleId);
				insert(record);
				count++;
			} else if ("del".equals(oper)) {
				deleteByUserIdRoleId(userId,roleId);
    			count++;
			} else {
				throw new ServiceException("非法操作");
			}
		}
    	return count;
    }
    
    public int editRole(String roleId,Map<String, String> param){
    	if (param == null || param.size() == 0) {
			return 0;
		}
    	int count = 0;
    	Iterator<String> iterator = param.keySet().iterator();
    	while (iterator.hasNext()) {
    		String userId = iterator.next();
    		String oper = param.get(userId);
    		if ("add".equals(oper)) {
    			UserRole record = new UserRole();
    			record.setId(UUID.randomUUID().toString());
    			record.setRoleId(roleId);
    			record.setUserId(userId);
				insert(record);
				count++;
			} else if ("del".equals(oper)) {
				deleteByUserIdRoleId(userId,roleId);
    			count++;
			} else {
				throw new ServiceException("非法操作");
			}
		}
    	return count;
    }

}