package com.ey.piit.sdo.order.vo;

import java.io.Serializable;

import com.ey.piit.sdo.order.entity.OrderProductCkd;

/**
 * 大货订单管理Entity
 * @author 魏诚
 */
public class OrderProductCkdVo extends OrderProductCkd implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1321980384380158603L;

	public OrderProductCkdVo() {
		super();
	}

	public OrderProductCkdVo(String id){
		super(id);
	}
	
	private Integer sfBg ;

	public Integer getSfBg() {
		return sfBg;
	}

	public void setSfBg(Integer sfBg) {
		this.sfBg = sfBg;
	}

	
	


}