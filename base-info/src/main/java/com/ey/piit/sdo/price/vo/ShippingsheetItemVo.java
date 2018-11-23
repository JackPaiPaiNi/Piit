package com.ey.piit.sdo.price.vo;

import java.io.Serializable;

import com.ey.piit.sdo.price.entity.ShippingsheetItem;

/**
 * 出货资料表明细管理Vo
 * @author 魏诚
 */
public class ShippingsheetItemVo extends ShippingsheetItem implements Serializable {

	private static final long serialVersionUID = -1321980384380158603L;

	public ShippingsheetItemVo() {
		super();
	}

	public ShippingsheetItemVo(String id){
		super(id);
	}

}