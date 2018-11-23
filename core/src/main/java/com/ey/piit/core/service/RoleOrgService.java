/*
 * RoleOrgService.java
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
import com.ey.piit.core.repository.RoleOrgDao;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.RoleOrgVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

/**
 * T_ROLE_ORG
 * 角色_组织
 * 
 * @author Kevin Xu
 * @version 1.0 2016-09-13
 */
@Service
public class RoleOrgService {

    @Autowired
    private RoleOrgDao roleOrgDao;

    public int editRole(String roleId,List<RoleOrgVo> list) {
    	if (list == null || list.size() == 0) {
			return 0;
		}
    	int count = 0;
    	for (int i = 0; i < list.size(); i++) {
    		RoleOrgVo record = list.get(i);
    		Oper oper = record.getOper();
    		if (Oper.add.equals(oper)) {
    			record.setId(UUID.randomUUID().toString());
    			record.setRoleId(roleId);
    			insert(record);
    			count++;
    		} else if (Oper.edit.equals(oper)) {
    			record.setRoleId(roleId);
    			update(record);
    			count++;
    		} else if (Oper.del.equals(oper)) {
    			deleteByRoleIdOrgId(roleId,record.getOrgId());
    			count++;
    		} else {
    			throw new ServiceException("非法操作");
    		}
			
		}
    	return count;
    }
    
    public int insert(CoreEntity record) {
		return roleOrgDao.insert(record);
	}
    
    public int update(CoreEntity record) {
    	return roleOrgDao.update(record);
    }
    
    public int deleteByRoleIdOrgId(String roleId,String orgId) {
    	Map<String,String> param = new HashMap<String, String>();
    	param.put("roleId", roleId);
    	param.put("orgId", orgId);
    	return roleOrgDao.deleteByParam(param);
    }
    
    /**
	 * 过滤重复操作
	 * 格式：[{"orgId":"1","oper":"add","type":"0"},{"orgId":"2","oper":"del","type":"1"}]
	 * @param json
	 * @return
	 */
	public List<RoleOrgVo> filterRepeat(String json) {
		if (StringUtils.isBlank(json)) {
			return Lists.newArrayList();
		}
		Map<String,RoleOrgVo> map = new HashMap<String,RoleOrgVo>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			RoleOrgVo[] arr = objectMapper.readValue(json, RoleOrgVo[].class);
	        for (int i = 0; i < arr.length; i++) {
	        	RoleOrgVo roleOrg = arr[i];
	        	String orgId = roleOrg.getOrgId();
	        	Oper oper = roleOrg.getOper();
	        	RoleOrgVo mapOper = map.get(orgId);
	        	
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
							mapOper.setType(roleOrg.getType());
						} else if (Oper.del.equals(oper)) {
							map.remove(orgId);
						} else {
							throw new ServiceException("操作错误");
						}
					} else if (Oper.edit.equals(last)) {
						if (Oper.edit.equals(oper)) {
							map.put(orgId, roleOrg);
						} else if (Oper.del.equals(oper)) {
							map.put(orgId, roleOrg);
						} else {
							throw new ServiceException("操作错误");
						}
					} else if (Oper.del.equals(last)) {
						if (Oper.add.equals(oper)) {
							roleOrg.setOper(Oper.edit);
							map.put(orgId, roleOrg);
						} else {
							throw new ServiceException("操作错误");
						}
					}
				} else {
					map.put(orgId, roleOrg);
				}
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("Json格式转换异常",e);
	    }
		
		return Lists.newArrayList(map.values());
	}
}