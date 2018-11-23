package com.ey.piit.sdo.order.vo;

import java.io.Serializable;

import com.ey.piit.sdo.order.entity.OrderDiversityItem;

/**
 * 多元化订单管理Entity
 * @author 高文浩
 */
public class OrderDiversityItemVo extends OrderDiversityItem implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5671338786177071710L;

	public OrderDiversityItemVo() {
		super();
	}

	public OrderDiversityItemVo(String id){
		super(id);
	}

}