package com.ey.piit.sdo.custinv.vo;

import java.io.Serializable;

import com.ey.piit.sdo.custinv.entity.ZgqdPrice;

/**
 * 以装柜清单为基础-调价表Vo
 * @author 魏诚
 */
public class ZgqdPriceVo extends ZgqdPrice implements Serializable {

	private static final long serialVersionUID = -1321980384380158603L;
	
	private String wlbhs;	// 不可调价物料编码（逗号隔开）

	public ZgqdPriceVo() {
		super();
	}

	public ZgqdPriceVo(String id){
		super(id);
	}

	public String getWlbhs() {
		return wlbhs;
	}

	public void setWlbhs(String wlbhs) {
		this.wlbhs = wlbhs;
	}

}