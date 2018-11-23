package com.ey.piit.sdo.pso.vo;

import java.io.Serializable;

import com.ey.piit.sdo.pso.entity.PsoNotify;

/**
 * 预走货Entity
 * @author 赵桃军
 */
public class PsoNotifyVo extends PsoNotify implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2669000132365693996L;

	public PsoNotifyVo() {
		super();
	}

	public PsoNotifyVo(String id){
		super(id);
	}


}