package com.ey.piit.sdo.price.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.ey.piit.sdo.price.entity.Shippingsheet;
import com.google.common.collect.Lists;

/**
 * 出货资料表主表Vo
 * @author 魏诚
 */
public class ShippingsheetVo extends Shippingsheet implements Serializable {
	
	private static final long serialVersionUID = 6264083094062050200L;
	
	private List<ShippingsheetItemVo> mxList = Lists.newArrayList();		            // 子表列表
	
	private String ztmc;
	private String ddid;		// 订单号 父类
	private String wlbh;		// 物料编码
	private String dw;		    // 单位（研发bom单位）
	private BigDecimal dj;		// 单价
	private String bz;		    // 币种
	private String flag;		// 操作类型
	
	public ShippingsheetVo() {
		super();
	}
	
	public ShippingsheetVo(String id) {
		super(id);
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public List<ShippingsheetItemVo> getMxList() {
		return mxList;
	}

	public void setMxList(List<ShippingsheetItemVo> mxList) {
		this.mxList = mxList;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getWlbh() {
		return wlbh;
	}

	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}