package com.ey.piit.sdo.pso.vo;

import java.io.Serializable;

import com.ey.piit.sdo.pso.entity.PsoExhibition;

/**
 * 预走货Entity
 * @author 邓海
 */
public class PsoExhibitionVo extends PsoExhibition implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2955807832586287149L;

	public PsoExhibitionVo() {
		super();
	}

	public PsoExhibitionVo(String id){
		super(id);
	}

	

}