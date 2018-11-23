/*
 * UserOrg.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2016-01-13 Created
 */
package com.ey.piit.core.entity;

/**
 * T_USER_ORG
 * 用户_组织
 * 
 * @author Kevin Xu
 * @version 1.0 2016-01-13
 */
public class UserOrg extends CoreEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1349592649283268300L;
	
	/**
     * 序号
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 组织ID
     */
    private String orgId;
    /**
     * 组织分组
     */
    private String groupId;
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
     * 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * 组织分组
     */
	public String getGroupId() {
		return groupId;
	}

	/**
     * 组织分组
     */
	public void setGroupId(String groupId) {
		this.groupId = groupId == null ? null : groupId.trim();
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