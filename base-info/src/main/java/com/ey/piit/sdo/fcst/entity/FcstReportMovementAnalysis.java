package com.ey.piit.sdo.fcst.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 采购FCST机芯分析报表Entity
 * @author 赵明
 */
public class FcstReportMovementAnalysis extends BaseEntity {
	
	private String jixin;		// 机芯
	private String jixing;		// 机型
	private String xsymc;		// 销售员名称
	private String khmc;		// 客户名称
	private String mcufa;		// mcufa
	private String ny;			// 年月
	private String zc;			// 周次
	private Double Ycs1Sz;		// 第1月上周预测数
	private Double Ycs1Bz;		// 第1月本周预测数
	private Double Ycs1Cy;		// 第1月差异预测数
	private Double Ycs2Sz;		// 第2月上周预测数
	private Double Ycs2Bz;		// 第2月本周预测数
	private Double Ycs2Cy;		// 第2月差异预测数
	private Double Ycs3Sz;		// 第3月上周预测数
	private Double Ycs3Bz;		// 第3月本周预测数
	private Double Ycs3Cy;		// 第3月差异预测数
	private Double HjSz;		// 第1-3月上周预测数
	private Double HjBz;		// 第1-3月本周预测数	
	private Double HjCy;		// 第1-3月差异预测数
	public FcstReportMovementAnalysis() {
		super();
	}

	public FcstReportMovementAnalysis(String id){
		super(id);
	}

	public String getNy() {
		return ny;
	}

	public void setNy(String ny) {
		this.ny = ny;
	}

	public String getJixin() {
		return jixin;
	}

	public void setJixin(String jixin) {
		this.jixin = jixin;
	}

	public String getMcufa() {
		return mcufa;
	}

	public void setMcufa(String mcufa) {
		this.mcufa = mcufa;
	}

	public Double getYcs1Sz() {
		return Ycs1Sz;
	}

	public void setYcs1Sz(Double ycs1Sz) {
		Ycs1Sz = ycs1Sz;
	}

	public Double getYcs1Bz() {
		return Ycs1Bz;
	}

	public void setYcs1Bz(Double ycs1Bz) {
		Ycs1Bz = ycs1Bz;
	}

	public Double getYcs1Cy() {
		return Ycs1Cy;
	}

	public void setYcs1Cy(Double ycs1Cy) {
		Ycs1Cy = ycs1Cy;
	}

	public Double getYcs2Sz() {
		return Ycs2Sz;
	}

	public void setYcs2Sz(Double ycs2Sz) {
		Ycs2Sz = ycs2Sz;
	}

	public Double getYcs2Bz() {
		return Ycs2Bz;
	}

	public void setYcs2Bz(Double ycs2Bz) {
		Ycs2Bz = ycs2Bz;
	}

	public Double getYcs2Cy() {
		return Ycs2Cy;
	}

	public void setYcs2Cy(Double ycs2Cy) {
		Ycs2Cy = ycs2Cy;
	}

	public Double getYcs3Sz() {
		return Ycs3Sz;
	}

	public void setYcs3Sz(Double ycs3Sz) {
		Ycs3Sz = ycs3Sz;
	}

	public Double getYcs3Bz() {
		return Ycs3Bz;
	}

	public void setYcs3Bz(Double ycs3Bz) {
		Ycs3Bz = ycs3Bz;
	}

	public Double getYcs3Cy() {
		return Ycs3Cy;
	}

	public void setYcs3Cy(Double ycs3Cy) {
		Ycs3Cy = ycs3Cy;
	}
	
	public Double getHjSz() {
		return HjSz;
	}

	public void setHjSz(Double hjSz) {
		HjSz = hjSz;
	}

	public Double getHjBz() {
		return HjBz;
	}

	public void setHjBz(Double hjBz) {
		HjBz = hjBz;
	}

	public Double getHjCy() {
		return HjCy;
	}

	public void setHjCy(Double hjCy) {
		HjCy = hjCy;
	}

	public String getZc() {
		return zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public String getXsymc() {
		return xsymc;
	}

	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}


}