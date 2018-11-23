package com.ey.piit.sdo.report.vo;

import com.ey.piit.sdo.report.entity.MonthlyCountTable;

/**
 * MonthlyCountTableVo
 * @author 江果林
 */
public class MonthlyCountTableVo extends MonthlyCountTable {
	
	private String szgsj;//开始装柜时间
	private String ezgsj;  // 结束装柜时间
	private String xszz;  // 大区
	private String hwgyl;  // 海外供应链
	private Double hkdtousd;  // HKD到USD汇率
	private Double usdtormb;  // USD到RMB汇率
	private Double rmbtousd;	//RMB到USD汇率
	private Double eurtousd;	//EUR到USD
	public String getSzgsj() {
		return szgsj;
	}
	public void setSzgsj(String szgsj) {
		this.szgsj = szgsj;
	}
	public String getEzgsj() {
		return ezgsj;
	}
	public void setEzgsj(String ezgsj) {
		this.ezgsj = ezgsj;
	}
	public String getXszz() {
		return xszz;
	}
	public void setXszz(String xszz) {
		this.xszz = xszz;
	}
	public String getHwgyl() {
		return hwgyl;
	}
	public void setHwgyl(String hwgyl) {
		this.hwgyl = hwgyl;
	}
	public Double getHkdtousd() {
		return hkdtousd;
	}
	public void setHkdtousd(Double hkdtousd) {
		this.hkdtousd = hkdtousd;
	}
	public Double getUsdtormb() {
		return usdtormb;
	}
	public void setUsdtormb(Double usdtormb) {
		this.usdtormb = usdtormb;
	}
	public Double getRmbtousd() {
		return rmbtousd;
	}
	public void setRmbtousd(Double rmbtousd) {
		this.rmbtousd = rmbtousd;
	}
	public Double getEurtousd() {
		return eurtousd;
	}
	public void setEurtousd(Double eurtousd) {
		this.eurtousd = eurtousd;
	}
	
}
