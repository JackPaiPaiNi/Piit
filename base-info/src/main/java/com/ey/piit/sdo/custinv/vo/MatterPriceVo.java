package com.ey.piit.sdo.custinv.vo;

import java.io.Serializable;

import com.ey.piit.sdo.custinv.entity.MatterPrice;

/**
 * 客户物料价格库Vo
 * @author 魏诚
 */
public class MatterPriceVo extends MatterPrice implements Serializable {

	private static final long serialVersionUID = -1321980384380158603L;

	public MatterPriceVo() {
		super();
	}

	public MatterPriceVo(String id){
		super(id);
	}

}