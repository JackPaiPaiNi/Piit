package com.ey.piit.sdo.order.vo;

import java.io.Serializable;

import com.ey.piit.sdo.order.entity.OrderFyItem;

/**
 * 副营订单管理Entity
 * @author tianrong
 */
public class OrderFyItemVo extends OrderFyItem implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5671338786177071710L;
	
	private String wlzwms; // 物料中文描述
	public OrderFyItemVo() {
		super();
	}

	public OrderFyItemVo(String id){
		super(id);
	}

	public String getWlzwms() {
		return wlzwms;
	}

	public void setWlzwms(String wlzwms) {
		this.wlzwms = wlzwms;
	}

	
}