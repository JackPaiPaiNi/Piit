/*
 * ResourceVo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.vo;

import java.util.List;

import com.ey.piit.core.entity.Resource;

/**
 * T_RESOURCE
 * 资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
public class ResourceVo extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1104654515267606261L;
	
	private List<ResourceVo> children;

	public List<ResourceVo> getChildren() {
		return children;
	}

	public void setChildren(List<ResourceVo> children) {
		this.children = children;
	}

}