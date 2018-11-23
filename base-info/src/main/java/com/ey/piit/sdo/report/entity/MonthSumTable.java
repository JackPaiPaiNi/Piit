package com.ey.piit.sdo.report.entity;

import com.ey.piit.core.entity.BaseEntity;

public class MonthSumTable extends BaseEntity{
	/**
	 * 月度数据汇总表Entity
	 * @author 江果林
	 */
	private String zgsjqj;      //装柜时间
	private String xszzmc;      //大区
	private Double syztsl;		//月开船销售量上月在途
	private Double bykcsl;		//月开船销售量本月开船
	private Double dyxjsl;		//月开船销售量小计
	private Double sntqsl;		//月开船销售量上年同期
	private Double tbbdsl;		//月开船销售量同比变动
	private Double syztje;		//月开船销售额上月在途
	private Double bykcje;		//月开船销售额本月开船
	private Double dyxjje;  	//月开船销售额小计
	private Double sntqje;  	//月开船销售额上年同期
	private Double tbbdje;  	//月开船销售额同比变动
	
	
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
	public Double getSyztsl() {
		return syztsl;
	}
	public void setSyztsl(Double syztsl) {
		this.syztsl = syztsl;
	}
	public Double getBykcsl() {
		return bykcsl;
	}
	public void setBykcsl(Double bykcsl) {
		this.bykcsl = bykcsl;
	}
	public Double getDyxjsl() {
		return dyxjsl;
	}
	public void setDyxjsl(Double dyxjsl) {
		this.dyxjsl = dyxjsl;
	}
	public Double getSntqsl() {
		return sntqsl;
	}
	public void setSntqsl(Double sntqsl) {
		this.sntqsl = sntqsl;
	}
	public Double getTbbdsl() {
		return tbbdsl;
	}
	public void setTbbdsl(Double tbbdsl) {
		this.tbbdsl = tbbdsl;
	}
	public Double getSyztje() {
		return syztje;
	}
	public void setSyztje(Double syztje) {
		this.syztje = syztje;
	}
	public Double getBykcje() {
		return bykcje;
	}
	public void setBykcje(Double bykcje) {
		this.bykcje = bykcje;
	}
	public Double getDyxjje() {
		return dyxjje;
	}
	public void setDyxjje(Double dyxjje) {
		this.dyxjje = dyxjje;
	}
	public Double getSntqje() {
		return sntqje;
	}
	public void setSntqje(Double sntqje) {
		this.sntqje = sntqje;
	}
	public Double getTbbdje() {
		return tbbdje;
	}
	public void setTbbdje(Double tbbdje) {
		this.tbbdje = tbbdje;
	}
	
	
}
