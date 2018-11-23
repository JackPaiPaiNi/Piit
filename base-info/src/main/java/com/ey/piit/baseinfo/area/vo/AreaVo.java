/*
 * AreaVo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-02 Created
 */
package com.ey.piit.baseinfo.area.vo;

import com.ey.piit.baseinfo.area.entity.Area;

/**
 * T_AREA
 * 一级对应国家
二级对应省
三级对应市

 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-02
 */
public class AreaVo extends Area {
	
	private String oldParentCode;
	
	private String parentName;
	
	private String oldStatus;

	public String getOldParentCode() {
		return oldParentCode;
	}

	public void setOldParentCode(String oldParentCode) {
		this.oldParentCode = oldParentCode;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
	}

}