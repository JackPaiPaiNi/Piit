package com.ey.piit.sdo.pub.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LcInfo extends BaseEntity {
	
	private String lcbh;//lc编号
	private Double je;//lc金额
	private Double ye;//余额
	private String bz;//币种
	private String khbm;//客户编码
	private String khmc;//客户名称
	private String kzh;//开证行
	private String kzhmc;//开证行名称
	private String kzhdm;//开证行代码
	private String tzh;//通知行
	private String zdyfh;//指定议付行
	private Date kzrq;//开证日期
	private Date hqrq;//获取日期
	private String mytk;//交货条件
	private String mytkmc;//交货条件名称
	private Date zwzcq;//最晚装船期
	
	public String getLcbh() {
		return lcbh;
	}
	public void setLcbh(String lcbh) {
		this.lcbh = lcbh;
	}
	public Double getJe() {
		return je;
	}
	public void setJe(Double je) {
		this.je = je;
	}
	public Double getYe() {
		return ye;
	}
	public void setYe(Double ye) {
		this.ye = ye;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getKzh() {
		return kzh;
	}
	public void setKzh(String kzh) {
		this.kzh = kzh;
	}
	public String getKzhmc() {
		return kzhmc;
	}
	public void setKzhmc(String kzhmc) {
		this.kzhmc = kzhmc;
	}
	public String getKzhdm() {
		return kzhdm;
	}
	public void setKzhdm(String kzhdm) {
		this.kzhdm = kzhdm;
	}
	public String getTzh() {
		return tzh;
	}
	public void setTzh(String tzh) {
		this.tzh = tzh;
	}
	public String getZdyfh() {
		return zdyfh;
	}
	public void setZdyfh(String zdyfh) {
		this.zdyfh = zdyfh;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getKzrq() {
		return kzrq;
	}
	public void setKzrq(Date kzrq) {
		this.kzrq = kzrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getHqrq() {
		return hqrq;
	}
	public void setHqrq(Date hqrq) {
		this.hqrq = hqrq;
	}
	public String getMytk() {
		return mytk;
	}
	public void setMytk(String mytk) {
		this.mytk = mytk;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZwzcq() {
		return zwzcq;
	}
	public void setZwzcq(Date zwzcq) {
		this.zwzcq = zwzcq;
	}
	public String getMytkmc() {
		return mytkmc;
	}
	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc;
	}
	
}
