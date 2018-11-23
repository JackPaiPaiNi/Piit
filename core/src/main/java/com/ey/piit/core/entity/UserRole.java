/*
 * UserRole.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.entity;

/**
 * T_USER_ROLE
 * 用户_角色
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
public class UserRole extends CoreEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1371085800994935901L;
	
	/**
     * 用户ID
     */
    private String userId;
    /**
     * 角色ID
     */
    private String roleId;

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
}