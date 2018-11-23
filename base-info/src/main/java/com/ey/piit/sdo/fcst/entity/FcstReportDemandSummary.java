package com.ey.piit.sdo.fcst.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 三月滚动FCST需求汇总报表Entity
 * @author 赵明
 */
public class FcstReportDemandSummary extends BaseEntity {
	
	private String zhfsmc;		// 出货方式
	private String xszzmc;		// 组织
	private String pp;			// 品牌
	private String ny;			// 年月
	private Double dds01;		// 第1月下单数
	private Double fcst01;		// 第1月FCST数
	private Double dds02;		// 第2月下单数
	private Double fcst02;		// 第2月FCST数
	private Double dds03;		// 第3月下单数
	private Double fcst03;		// 第3月下单数
	private Double ddhj;		// 合计
	private Double tsfcst;		// 特殊录入
	private String zc;		// 特殊录入
	public FcstReportDemandSummary() {
		super();
	}

	public FcstReportDemandSummary(String id){
		super(id);
	}

	public String getZhfsmc() {
		return zhfsmc;
	}

	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}

	public String getXszzmc() {
		return xszzmc;
	}

	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public Double getDds01() {
		return dds01;
	}

	public void setDds01(Double dds01) {
		this.dds01 = dds01;
	}

	public Double getFcst01() {
		return fcst01;
	}

	public void setFcst01(Double fcst01) {
		this.fcst01 = fcst01;
	}

	public Double getDds02() {
		return dds02;
	}

	public void setDds02(Double dds02) {
		this.dds02 = dds02;
	}

	public Double getFcst02() {
		return fcst02;
	}

	public void setFcst02(Double fcst02) {
		this.fcst02 = fcst02;
	}

	public Double getDds03() {
		return dds03;
	}

	public void setDds03(Double dds03) {
		this.dds03 = dds03;
	}

	public Double getFcst03() {
		return fcst03;
	}

	public void setFcst03(Double fcst03) {
		this.fcst03 = fcst03;
	}

	public Double getDdhj() {
		return ddhj;
	}

	public void setDdhj(Double ddhj) {
		this.ddhj = ddhj;
	}

	public Double getTsfcst() {
		return tsfcst;
	}

	public void setTsfcst(Double tsfcst) {
		this.tsfcst = tsfcst;
	}

	public String getNy() {
		return ny;
	}

	public void setNy(String ny) {
		this.ny = ny;
	}

	public String getZc() {
		return zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}
}