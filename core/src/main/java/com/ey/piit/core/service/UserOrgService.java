/*
 * UserOrgService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2016-01-13 Created
 */
package com.ey.piit.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.entity.CoreEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.repository.UserOrgDao;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.UserOrgVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

/**
 * T_USER_ORG
 * 用户_组织
 * 
 * @author Kevin Xu
 * @version 1.0 2016-01-13
 */
@Service
public class UserOrgService {

    @Autowired
    private UserOrgDao userOrgDao;

    public int editUser(String userId,List<UserOrgVo> list) {
    	if (list == null || list.size() == 0) {
			return 0;
		}
    	int count = 0;
    	for (int i = 0; i < list.size(); i++) {
    		UserOrgVo record = list.get(i);
    		Oper oper = record.getOper();
    		if (Oper.add.equals(oper)) {
    			record.setId(UUID.randomUUID().toString());
    			record.setUserId(userId);
    			insert(record);
    			count++;
    		} else if (Oper.edit.equals(oper)) {
    			record.setUserId(userId);
    			update(record);
    			count++;
    		} else if (Oper.del.equals(oper)) {
    			deleteByUserIdOrgId(userId,record.getOrgId());
    			count++;
    		} else {
    			throw new ServiceException("非法操作");
    		}
			
		}
    	return count;
    }
    
    public int insert(CoreEntity record) {
		return userOrgDao.insert(record);
	}
    
    public int update(CoreEntity record) {
    	return userOrgDao.update(record);
    }
    
    public int deleteByUserIdOrgId(String userId,String orgId) {
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("userId", userId);
    	param.put("orgId", orgId);
    	return userOrgDao.deleteByParam(param);
    }
    
    /**
	 * 过滤重复操作
	 * 格式：[{"orgId":"1","oper":"add","groupId":"","type":"0"},{"orgId":"2","oper":"del","groupId":"","type":"1"}]
	 * @param json
	 * @return
	 */
	public List<UserOrgVo> filterRepeat(String json) {
		if (StringUtils.isBlank(json)) {
			return Lists.newArrayList();
		}
		Map<String,UserOrgVo> map = new HashMap<String,UserOrgVo>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UserOrgVo[] arr = objectMapper.readValue(json, UserOrgVo[].class);
	        for (int i = 0; i < arr.length; i++) {
	        	UserOrgVo userOrg = arr[i];
	        	String orgId = userOrg.getOrgId();
	        	Oper oper = userOrg.getOper();
	        	UserOrgVo mapOper = map.get(orgId);
	        	
	        	/*
	        	  1(上一个)  2(当前)		
					add	    add	       不可能	
					add	    edit	把1的type改成2的值	
					add	    del	       从map中删掉	
					edit	add	       不可能	
					edit	edit	替换map值	
					edit	del	       替换map值	
					del	    add	       把2的oper改成edit	
					del	    edit	不可能	
					del	    del	       不可能	
				*/
	        	if (mapOper != null) {
	        		Oper last = mapOper.getOper();
	        		if (Oper.add.equals(last)) {
						if (Oper.edit.equals(oper)) {
							mapOper.setType(userOrg.getType());
						} else if (Oper.del.equals(oper)) {
							map.remove(orgId);
						} else {
							throw new ServiceException("操作错误");
						}
					} else if (Oper.edit.equals(last)) {
						if (Oper.edit.equals(oper)) {
							map.put(orgId, userOrg);
						} else if (Oper.del.equals(oper)) {
							map.put(orgId, userOrg);
						} else {
							throw new ServiceException("操作错误");
						}
					} else if (Oper.del.equals(last)) {
						if (Oper.add.equals(oper)) {
							userOrg.setOper(Oper.edit);
							map.put(orgId, userOrg);
						} else {
							throw new ServiceException("操作错误");
						}
					}
				} else {
					map.put(orgId, userOrg);
				}
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("Json格式转换异常",e);
	    }
		
		return Lists.newArrayList(map.values());
	}
}