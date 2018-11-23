package com.ey.piit.sdo.price.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ey.piit.sdo.price.entity.SkdPriceAdjust;

/**
 * SKD调价单Entity
 * @author 邓海
 */
public class SkdPriceAdjustVo extends SkdPriceAdjust {
	
	private List<SkdPriceAdjustItemVo> skdPriceAdjustItemList = new ArrayList<SkdPriceAdjustItemVo>();
    private  BigDecimal ce;//差额
	public List<SkdPriceAdjustItemVo> getSkdPriceAdjustItemList() {
		return skdPriceAdjustItemList;
	}

	public void setSkdPriceAdjustItemList(
			List<SkdPriceAdjustItemVo> skdPriceAdjustItemList) {
		this.skdPriceAdjustItemList = skdPriceAdjustItemList;
	}

	public BigDecimal getCe() {
		return ce;
	}

	public void setCe(BigDecimal ce) {
		this.ce = ce;
	}
	
	
}