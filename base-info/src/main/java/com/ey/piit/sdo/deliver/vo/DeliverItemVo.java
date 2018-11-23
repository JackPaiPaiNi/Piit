package com.ey.piit.sdo.deliver.vo;

import java.math.BigDecimal;

import com.ey.piit.sdo.deliver.entity.DeliverItem;

/**
 * 出货通知书明细Entity
 * @author 魏诚
 */
public class DeliverItemVo extends DeliverItem {

	private String yzhlx;
	
	private BigDecimal bgje;  //报关金额
	
	public BigDecimal getBgje() {
		return bgje;
	}

	public void setBgje(BigDecimal bgje) {
		this.bgje = bgje;
	}

	public DeliverItemVo() {
		super();
	}

	public DeliverItemVo(String id){
		super(id);
	}

	public String getYzhlx() {
		return yzhlx;
	}

	public void setYzhlx(String yzhlx) {
		this.yzhlx = yzhlx;
	}

}