/*
 * OrganizationVo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.vo;

import com.ey.piit.core.entity.Organization;

/**
 * T_ORGANIZATION
 * 组织
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
public class OrganizationVo extends Organization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1842773943698247415L;
	
	private String operType;

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}
}