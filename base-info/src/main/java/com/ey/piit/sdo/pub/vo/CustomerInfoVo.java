package com.ey.piit.sdo.pub.vo;

import com.ey.piit.sdo.mdm.entity.CustomerInfo;

/**
 * 客户信息维护Entity
 * @author 赵桃军
 */
public class CustomerInfoVo extends CustomerInfo {

	private String fktjms;		// 付款条件描述

	public CustomerInfoVo() {
		super();
	}

	public CustomerInfoVo(String id){
		super(id);
	}

	public String getFktjms() {
		return fktjms;
	}

	public void setFktjms(String fktjms) {
		this.fktjms = fktjms;
	}

}