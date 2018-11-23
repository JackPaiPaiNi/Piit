/*
 * RoleOrg.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2016-01-13 Created
 */
package com.ey.piit.core.entity;

/**
 * T_ROLE_ORG
 * 角色_组织
 * 
 * @author Kevin Xu
 * @version 1.0 2016-09-13
 */
public class RoleOrg extends CoreEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5051497520207716160L;
	
	/**
     * 序号
     */
    private String id;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 组织ID
     */
    private String orgId;
    /**
     * 控制类型
     */
    private String type;

    /**
     * 序号
     */
    public String getId() {
        return id;
    }

    /**
     * 序号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 组织ID
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 组织ID
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

	/**
	 * 控制类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 控制类型
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
}