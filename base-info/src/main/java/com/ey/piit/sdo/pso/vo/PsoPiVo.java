package com.ey.piit.sdo.pso.vo;

import java.io.Serializable;

import com.ey.piit.sdo.pso.entity.PsoPi;

/**
 * 预走货PI
 * @author 魏诚
 */
public class PsoPiVo extends PsoPi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2314970086014281278L;

	public PsoPiVo() {
		super();
	}

	public PsoPiVo(String id){
		super(id);
	}
}