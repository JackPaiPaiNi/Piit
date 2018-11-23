package com.ey.piit.sdo.price.vo;

import com.ey.piit.sdo.price.entity.OrderBomPrice;

/**
 * 销单bom价格价格Entity
 * @author 邓海
 */
public class OrderBomPriceVo extends OrderBomPrice {
	private String drlx;//导入类型
	private String chdh;//出货通知书单号
	
	public OrderBomPriceVo() {
		super();
	}

	public String getDrlx() {
		return drlx;
	}

	public void setDrlx(String drlx) {
		this.drlx = drlx;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}


}