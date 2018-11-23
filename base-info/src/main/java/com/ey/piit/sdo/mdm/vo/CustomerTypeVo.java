package com.ey.piit.sdo.mdm.vo;

import com.ey.piit.sdo.mdm.entity.CustomerType;

/**
 * 客户分类管理Entity
 * @author 魏诚
 */
public class CustomerTypeVo extends CustomerType {
	
	private String kh;
	
	public CustomerTypeVo() {
		super();
	}

	public CustomerTypeVo(String id){
		super(id);
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

}