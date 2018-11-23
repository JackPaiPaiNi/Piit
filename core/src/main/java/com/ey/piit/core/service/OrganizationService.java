/*
 * OrganizationService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.OrganizationDao;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.OrganizationVo;

/**
 * T_ORGANIZATION
 * 组织
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
@Service
public class OrganizationService extends CoreService {

	@Autowired
	private OrganizationDao organizationDao;

	public OrganizationVo findById(String id) {
		return organizationDao.selectById(id);
	}

	public List<OrganizationVo> queryByPage(Map<String, Object> params, PageBounds page) {
		return organizationDao.selectByPage(params, page);
	}
	
	/**
	 * 根据用户所属公司获取当前组织及其子组织
	 * @return
	 */
	public List<OrganizationVo> queryChildByUser(){
		User user = findCurUser();
		return organizationDao.selectChildByCode(user.getCompCode());
	}
	
	public String organizationListToHtml(List<OrganizationVo> organizationList){
		if (organizationList == null || organizationList.size() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<option value=\"\"></option>");
		for (int i = 0; i < organizationList.size(); i++) {
			OrganizationVo organization = organizationList.get(i);
			sb.append("<option value=\"");
			sb.append(organization.getCode());
			sb.append("\">");
			sb.append(organization.getName());
			sb.append("</option>");
		}
		return sb.toString();
	}
	
	public List<TreeNode> queryTree(String sys,String code,String name,String parentCode){
		
		//没有组织信息不能访问数据
		List<OrganizationVo> orgList = findCurOrg();
		if (orgList == null || orgList.size() == 0) {
			return new ArrayList<TreeNode>();
		}
		
		//展开节点
		if (StringUtils.isNotBlank(parentCode)) {
			return queryTreeByParent(sys,parentCode);
		}
		
		//如果没有给查询条件，那么返回根节点
		if (!"base".equals(sys) || (StringUtils.isBlank(code) && StringUtils.isBlank(name))) {
			List<TreeNode> list = queryTreeBySys(sys,code,name,orgList);
			return list;
		}
		
		//拼权限字符串
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < orgList.size(); i++) {
			OrganizationVo organizationVo = orgList.get(i);
			String path = organizationVo.getPath();
			if (i != 0) {
				sb.append(" or ");
			}
			sb.append(" PATH like '");
			sb.append(path);
			sb.append("%'");
		}
		String org = sb.toString();
		
		//查询
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		params.put("name", name);
		params.put("status", Constants.STATUS_ENABLED);
		params.put("org", org);
//		params.put("type", Constants.ORGANIZATION_TYPE_COMPANY);
		List<OrganizationVo> list = organizationDao.selectByPage(params);
		if (list == null || list.size() == 0) {
			return new ArrayList<TreeNode>();
		}
		
		//建索引
		Map<String, OrganizationVo> orgMap = new HashMap<String, OrganizationVo>(Math.max((int) (list.size()/0.75f) + 1, 16));
		
		//取得自己以及所有祖先的编码
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < list.size(); i++) {
			OrganizationVo organizationVo = list.get(i);
			String path = organizationVo.getPath();
			String[] split = path.split("/");
			for (int j = 0; j < split.length; j++) {
				set.add(split[j]);
			}
			orgMap.put(organizationVo.getCode(), organizationVo);
		}
		
		//拼成串
		boolean isFirst = true;
		String codes = "";
		int count = 0;
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			count++;
			String tempCode = iterator.next();
			if (isFirst) {
				isFirst = false;
			} else {
				codes += ",";
			}
			codes += "'"+tempCode+"'";
			
			//防止查询过多报错
			if (count >= Constants.TREE_QUERY_CODE_IN_MAX_COUNT) {
				break;
			}
		}
		
		//查询自己以及所有祖先
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("codes", codes);
		param.put("org", org);
		List<TreeNode> treeList = organizationDao.selectTreeBaseInCode(param);
		
		//改变颜色
		Map<String,String> colorMap = new HashMap<String,String>();
		colorMap.put(Constants.TREE_NODE_HIGH_LIGHT_COLOR_KEY, Constants.TREE_NODE_HIGH_LIGHT_COLOR_VALUE);
		for (int i = 0; i < treeList.size(); i++) {
			TreeNode treeNode = treeList.get(i);
			if (orgMap.get(treeNode.getId()) != null) {
				treeNode.setFont(colorMap);
			} else {
				treeNode.setOpen(true);
			}
		}
		return treeList;
	}
	
	private List<TreeNode> queryTreeByParent(String sys,String parentCode){
		
		//没有组织信息不能访问数据
		List<OrganizationVo> orgList = findCurOrg();
		if (orgList == null || orgList.size() == 0) {
			return new ArrayList<TreeNode>();
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		if (StringUtils.isBlank(parentCode)) {
			
			//显示根节点，应该显示自己所属组织
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < orgList.size(); i++) {
				OrganizationVo organizationVo = orgList.get(i);
				if (i != 0) {
					sb.append(",");
				}
				sb.append("'");
				sb.append(organizationVo.getCode());
				sb.append("'");
			}
			param.put("codeIn", sb.toString());
			param.put("parentCode", null);
		} else {
			param.put("codeIn", null);
			param.put("parentCode", parentCode);
		}
		param.put("parentCodeColumn", getColumnBySys(sys));
		return organizationDao.selectTreeByParent(param);
	}
	
	private List<TreeNode> queryTreeBySys(String sys,String code,String name,List<OrganizationVo> orgList){
		Map<String, Object> param = new HashMap<String, Object>();
		if (StringUtils.isBlank(code) && StringUtils.isBlank(name)) {
			
			//显示根节点，应该显示自己所属组织
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < orgList.size(); i++) {
				OrganizationVo organizationVo = orgList.get(i);
				if (i != 0) {
					sb.append(",");
				}
				sb.append("'");
				sb.append(organizationVo.getCode());
				sb.append("'");
			}
			param.put("codeIn", sb.toString());
		} else {
			
			//拼权限字符串
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < orgList.size(); i++) {
				OrganizationVo organizationVo = orgList.get(i);
				String path = organizationVo.getPath();
				if (i != 0) {
					sb.append(" or ");
				}
				sb.append(" PATH like '");
				sb.append(path);
				sb.append("%'");
			}
			
			param.put("codeIn", null);
			param.put("code", code);
			param.put("org", sb.toString());
		}
		param.put("name", name);
		param.put("parentCodeColumn", getColumnBySys(sys));
		return organizationDao.selectTreeBySys(param);
	}
	
	public OrganizationVo findByCode(String code) {
		if (StringUtils.isBlank(code)) {
			return null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		List<OrganizationVo> list = organizationDao.selectByPage(params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	private List<TreeNode> queryHistoryTreeByParent(String sys,String parentCode,Date date){
		if (date == null) {
			throw new ValidateException("时间不能为空");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("parentCode", parentCode);
		param.put("parentCodeColumn", getColumnBySys(sys));
		param.put("date", date);
		return organizationDao.selectHistoryTreeByParent(param);
	}
	
	public List<TreeNode> queryHistoryTreeBySys(String sys,String code,String name,String parentCode,Date date){
		if (date == null) {
			throw new ValidateException("时间不能为空");
		}
		if (StringUtils.isNotBlank(parentCode)) {
			return queryHistoryTreeByParent(sys,parentCode,date);
		}
		Map<String, Object> param = new HashMap<String, Object>();
		if (StringUtils.isBlank(code) && StringUtils.isBlank(name)) {
			param.put("parentCode", "isNull");
		} else {
			param.put("code", code);
			param.put("name", name);
		}
		param.put("parentCodeColumn", getColumnBySys(sys));
		param.put("date", date);
		return organizationDao.selectHistoryTreeBySys(param);
	}
	
	private String getColumnBySys(String sys){
		if ("base".equals(sys)) {
			sys = "BASE_PARENT_ORG_CODE";
		} else if ("hs".equals(sys)) {
			sys = "NC_PARENT_ORG_CODE";
		} else if ("zj".equals(sys)) {
			sys = "ZJ_PARENT_ORG_CODE";
		} else if ("ys".equals(sys)) {
			sys = "YS_PARENT_ORG_CODE";
		} else {
			throw new ValidateException("无效的系统标示");
		}
		return sys;
	}
	
	@Override
	protected ICoreDao getDao() {
		return organizationDao;
	}
	
	public List<OrganizationVo> queryByUserId(String userId) {
		return organizationDao.selectByUserId(userId);
	}
	
	public List<OrganizationVo> queryByRoleId(String roleId) {
		return organizationDao.selectByRoleId(roleId);
	}
	
	public List<OrganizationVo> queryChildByCode(String code) {
		return organizationDao.selectChildByCode(code);
	}
	
	public List<OrganizationVo> queryByCode(String orgCode) {
		return organizationDao.selectByCode(orgCode);
	}
}