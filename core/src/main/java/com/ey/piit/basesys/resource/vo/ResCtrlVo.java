/*
 * ResCtrlVo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.vo;

import com.ey.piit.basesys.resource.entity.ResCtrl;

/**
 * T_RES_CTRL
 * 功能控制_资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
public class ResCtrlVo extends ResCtrl {

	private String resType;
	private String roleCode;
	private String nodeName;
	private String parentId;
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}