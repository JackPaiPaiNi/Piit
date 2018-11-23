/*
 * RoleResource.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.entity;

/**
 * T_ROLE_RESOURCE
 * 角色_资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
public class RoleResource extends CoreEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6253422204484798429L;
	
	/**
     * 角色ID
     */
    private String roleId;
    /**
     * 资源ID
     */
    private String resourceId;

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
     * 资源ID
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 资源ID
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }
}