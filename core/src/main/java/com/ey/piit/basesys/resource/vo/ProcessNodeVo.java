/*
 * ProcessNodeVo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.vo;

import com.ey.piit.basesys.resource.entity.ProcessNode;

/**
 * T_PROCESS_NODE
 * 流程节点
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
public class ProcessNodeVo extends ProcessNode {

	private String nodeNameV;

	public String getNodeNameV() {
		return nodeNameV;
	}

	public void setNodeNameV(String nodeNameV) {
		this.nodeNameV = nodeNameV;
		setNodeName(nodeNameV);
	}
}