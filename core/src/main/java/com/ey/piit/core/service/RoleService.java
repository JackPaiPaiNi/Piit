/*
 * RoleService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.RoleDao;
import com.ey.piit.core.utils.SelectUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.OrganizationVo;
import com.ey.piit.core.vo.RoleOrgVo;
import com.ey.piit.core.vo.RoleVo;

/**
 * T_ROLE
 * 角色
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@Service
public class RoleService extends CoreService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleResourceService roleResourceService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private RoleOrgService roleOrgService;
	
	@Override
	protected int save(CoreEntity record) {
		RoleVo role = (RoleVo)record;
		int result = 0;
		
		try {
			result = super.save(role);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				throw new ValidateException("编码重复");
			}
			throw e;
		}
		
		Map<String, String> resourceMap = SelectUtils.filterRepeat(role.getResources());
		roleResourceService.editRole(role.getId(),resourceMap);
		
		List<RoleOrgVo> roleOrgList = roleOrgService.filterRepeat(role.getOrgs());
		roleOrgService.editRole(role.getId(),roleOrgList);
		
		return result;
	}
	
	@Override
	protected int update(CoreEntity record) {
		RoleVo role = (RoleVo)record;
		int result = 0;
		
		try {
			result = super.update(role);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				throw new ValidateException("编码重复");
			}
		}
		
		Map<String, String> resourceMap = SelectUtils.filterRepeat(role.getResources());
		roleResourceService.editRole(role.getId(),resourceMap);
		
		List<RoleOrgVo> roleOrgList = roleOrgService.filterRepeat(role.getOrgs());
		roleOrgService.editRole(role.getId(),roleOrgList);
		
		return result;
	}
	
	@Override
	protected int delete(CoreEntity record) {
		int result = super.delete(record);
		String[] ids = record.getId().split(",");
		for (int i = 0; i < ids.length; i++) {
			userRoleService.deleteByRoleId(record.getId());
			roleResourceService.deleteByRoleId(record.getId());
		}
		return result;
	}

	public RoleVo findById(String id) {
		RoleVo roleVo = roleDao.selectById(id);
		List<OrganizationVo> orgList = organizationService.queryByRoleId(id);
		roleVo.setOrgShow(orgList);
		return roleVo;
	}

	public List<RoleVo> queryByPage(Map<String, Object> params, PageBounds page) {
		return roleDao.selectByPage(params, page);
	}
	
	public List<RoleVo> queryByUserId(String userId) {
		if (StringUtils.isBlank(userId)) {
			return new ArrayList<RoleVo>();
		}
		return roleDao.selectByUserId(userId);
	}
	
	public List<RoleVo> queryAll(){
		return roleDao.selectAll();
	}
	
	public String roleListToHtml(List<RoleVo> roleAllList,List<RoleVo> roleList){
		if (roleAllList == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int size = 0;
		RoleVo role = null;
		if (roleList != null && roleList.size() != 0) {
			role = roleList.get(index);//取第一条数据
			size = roleList.size();
		}
		for (int i = 0; i < roleAllList.size(); i++) {
			RoleVo roleAll = roleAllList.get(i);
			sb.append("<option value=\"");
			sb.append(roleAll.getId());
			sb.append("\" type=\"");
			sb.append(roleAll.getType());
			
			//排好序的两个list，如果匹配取下一个
			if (role != null && role.getCode().equals(roleAll.getCode())) {
				sb.append("\" selected>");
				sb.append("【");
				sb.append(roleAll.getType());
				sb.append("】");
				sb.append(roleAll.getName());
				sb.append("</option>");
				index++;
				if (index >= size) {
					role = null;
				} else {
					role = roleList.get(index);
				}
			} else {
				sb.append("\">");
				sb.append("【");
				sb.append(roleAll.getType());
				sb.append("】");
				sb.append(roleAll.getName());
				sb.append("</option>");
			}
		}
		return sb.toString();
	}
	
	@Override
	protected ICoreDao getDao() {
		return roleDao;
	}
}