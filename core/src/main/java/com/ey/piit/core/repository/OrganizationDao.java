/*
 * OrganizationDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.repository;

import java.util.List;
import java.util.Map;

import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.core.vo.OrganizationVo;

/**
 * 表名：T_ORGANIZATION
 * 表描述：组织
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
@BatisRepository
public interface OrganizationDao extends ICoreDao {
	OrganizationVo selectById(String id);

	List<OrganizationVo> selectByPage(Map<String, Object> params, PageBounds page);
	
	List<OrganizationVo> selectChildByCode(String code);
	
	List<TreeNode> selectTreeByParent(Map<String, Object> params);
	
	List<TreeNode> selectTreeBySys(Map<String, Object> params);
	
	List<TreeNode> selectTreeBaseInCode(Map<String, Object> params);
	
	List<OrganizationVo> selectByPage(Map<String, Object> params);
	
	List<TreeNode> selectHistoryTreeByParent(Map<String, Object> params);
	
	List<TreeNode> selectHistoryTreeBySys(Map<String, Object> params);
	
	List<OrganizationVo> selectByUserId(String userId);
	
	List<OrganizationVo> selectByRoleId(String roleId);
	
	List<OrganizationVo> selectByCode(String orgCode);
}