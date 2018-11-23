package com.ey.piit.sdo.price.vo;

import com.ey.piit.sdo.price.entity.SkdPrice;

/**
 * SKD价格Entity
 * @author 邓海
 */
public class SkdPriceVo extends SkdPrice {
	
	private Integer type;//type 用于判断是否是修改数据,1为修改数据，0或者空为导入数据
	
	private String flagmc ;


	public SkdPriceVo() {
		super();
	}
	
	

	public String getFlagmc() {
		return flagmc;
	}



	public void setFlagmc(String flagmc) {
		this.flagmc = flagmc;
	}



	public SkdPriceVo(String id){
		super(id);
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	
}