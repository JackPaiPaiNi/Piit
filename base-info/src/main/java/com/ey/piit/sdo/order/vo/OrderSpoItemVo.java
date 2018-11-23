package com.ey.piit.sdo.order.vo;

import java.io.Serializable;

import com.ey.piit.sdo.order.entity.OrderSpoItem;

/**
 * 备损订单管理Entity
 * @author 魏诚
 */
public class OrderSpoItemVo extends OrderSpoItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8049620645458935293L;

	public OrderSpoItemVo() {
		super();
	}

	public OrderSpoItemVo(String id){
		super(id);
	}

}