package com.ey.piit.sdo.price.vo;

import com.ey.piit.sdo.price.entity.BranchPrice;

/**
 * 分公司产品价格Entity
 * @author 邓海
 */
public class BranchPriceVo extends BranchPrice {
	
	private Integer type;//type 用于判断是否是修改数据,1为修改数据，0或者空为导入数据


	public BranchPriceVo() {
		super();
	}

	public BranchPriceVo(String id){
		super(id);
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	
}