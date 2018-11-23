package com.ey.piit.sdo.pso.vo;

import java.io.Serializable;

import com.ey.piit.sdo.pso.entity.PsoLog;

/**
 * 预走货操作日志
 * @author 魏诚
 *
 */
public class PsoLogVo extends PsoLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -908286576082577252L;

	public PsoLogVo() {
		super();
	}

	public PsoLogVo(String id){
		super(id);
	}
	
}
