package com.ey.piit.sdo.pub.entity;

/**
 * 客户银行账号entity
 * @author 魏诚
 */
public class CustomerBankAccount {
	
	private String khbm;		// 客户编码
	private String yhzh;		// 银行账号
	private String yhbm;		// 银行编码
	private String yhlx;		// 银行类型
	private String yhmc;		// 银行名称
	private String yhdz;		// 银行地址
	private String swiftdm;		// swift代码
	
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getYhzh() {
		return yhzh;
	}
	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}
	public String getYhbm() {
		return yhbm;
	}
	public void setYhbm(String yhbm) {
		this.yhbm = yhbm;
	}
	public String getYhlx() {
		return yhlx;
	}
	public void setYhlx(String yhlx) {
		this.yhlx = yhlx;
	}
	public String getYhmc() {
		return yhmc;
	}
	public void setYhmc(String yhmc) {
		this.yhmc = yhmc;
	}
	public String getYhdz() {
		return yhdz;
	}
	public void setYhdz(String yhdz) {
		this.yhdz = yhdz;
	}
	public String getSwiftdm() {
		return swiftdm;
	}
	public void setSwiftdm(String swiftdm) {
		this.swiftdm = swiftdm;
	}
	
}