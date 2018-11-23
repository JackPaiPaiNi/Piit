package com.ey.piit.sdo.report.entity;

import com.ey.piit.core.entity.BaseEntity;

public class ShipplanCountTable extends BaseEntity{
	/**
	 * 出货计划统计表Entity
	 * @author 魏诚
	 */
	private String zgsjqj;     // 装柜时间
	private String hwgylmc;    // 海外供应链
	private String xszzmc;    // 大区
	private String ywzmc;    // 业务组名称
	private Integer zchsl;    // 出货总数量
	private Integer dykcsl;    // 当月开船数量
	private Integer dyjzsl;    // 当月在途结转下月开船数量
	private Double zchje;    // 总出货金额 USD
	private Double dykcje;    // 当月开船金额 USD
	private Double dyjzje;    // 当月在途结转下月开船金额USD
	private Double zhrmb;    // 转换RMB

	
	public String getZgsjqj() {
		return zgsjqj;
	}
	public void setZgsjqj(String zgsjqj) {
		this.zgsjqj = zgsjqj;
	}
	public String getXszzmc() {
		return xszzmc;
	}
	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc;
	}
	public String getHwgylmc() {
		return hwgylmc;
	}
	public void setHwgylmc(String hwgylmc) {
		this.hwgylmc = hwgylmc;
	}
	public String getYwzmc() {
		return ywzmc;
	}
	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc;
	}
	public Integer getZchsl() {
		return zchsl;
	}
	public void setZchsl(Integer zchsl) {
		this.zchsl = zchsl;
	}
	public Integer getDykcsl() {
		return dykcsl;
	}
	public void setDykcsl(Integer dykcsl) {
		this.dykcsl = dykcsl;
	}
	public Integer getDyjzsl() {
		return dyjzsl;
	}
	public void setDyjzsl(Integer dyjzsl) {
		this.dyjzsl = dyjzsl;
	}
	public Double getZchje() {
		return zchje;
	}
	public void setZchje(Double zchje) {
		this.zchje = zchje;
	}
	public Double getDykcje() {
		return dykcje;
	}
	public void setDykcje(Double dykcje) {
		this.dykcje = dykcje;
	}
	public Double getDyjzje() {
		return dyjzje;
	}
	public void setDyjzje(Double dyjzje) {
		this.dyjzje = dyjzje;
	}
	public Double getZhrmb() {
		return zhrmb;
	}
	public void setZhrmb(Double zhrmb) {
		this.zhrmb = zhrmb;
	}
	
	
}
