/*
 * RoleVo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.vo;

import java.util.List;

import com.ey.piit.core.entity.Role;

/**
 * T_ROLE
 * 角色
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
public class RoleVo extends Role {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6156961323091061872L;

	/**
	 * 格式：[{"id":"1","oper":"add"},{"id":"2","oper":"del"}]
	 */
	private String resources;
	
	/**
	 * 格式：[{"id":"1","oper":"add","type":"0"},{"id":"2","oper":"del","type":"1"}]
	 */
	private String orgs;
	
	private List<OrganizationVo> orgShow;//展示用

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getOrgs() {
		return orgs;
	}

	public void setOrgs(String orgs) {
		this.orgs = orgs;
	}

	public List<OrganizationVo> getOrgShow() {
		return orgShow;
	}

	public void setOrgShow(List<OrganizationVo> orgShow) {
		this.orgShow = orgShow;
	}
	
}