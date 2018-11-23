package com.ey.piit.sdo.agent.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 委托单Entity
 * 
 * @author 高文浩
 */
public class Agent extends BaseEntity {

	private String wtdh; // 委托单号
	private String wtr; // 委托人
	private String wtrmc; // 委托人名称
	private String bwtr; // 被委托人
	private String bwtrmc; // 被委托人名称
	private Date kssj; // 预计开船期
	private Date jssj; // 预计开船期
	private Integer zt; // 状态
	private String zdrid; // 制单人ID
	private String zdrmc; // 制单人名称
	private Date zdsj; // 制单时间
	private String wtbz; // 委托备注

	public Agent() {
		super();
	}

	public Agent(String id) {
		super(id);
	}

	public String getWtdh() {
		return wtdh;
	}

	public void setWtdh(String wtdh) {
		this.wtdh = wtdh;
	}

	public String getWtr() {
		return wtr;
	}

	public void setWtr(String wtr) {
		this.wtr = wtr;
	}

	public String getWtrmc() {
		return wtrmc;
	}

	public void setWtrmc(String wtrmc) {
		this.wtrmc = wtrmc;
	}

	public String getBwtr() {
		return bwtr;
	}

	public void setBwtr(String bwtr) {
		this.bwtr = bwtr;
	}

	public String getBwtrmc() {
		return bwtrmc;
	}

	public void setBwtrmc(String bwtrmc) {
		this.bwtrmc = bwtrmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getKssj() {
		return kssj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJssj() {
		return jssj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getWtbz() {
		return wtbz;
	}

	public void setWtbz(String wtbz) {
		this.wtbz = wtbz;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}
	
}