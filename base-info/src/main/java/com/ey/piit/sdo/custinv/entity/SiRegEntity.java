package com.ey.piit.sdo.custinv.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author: junc
 * @date: 2018年6月29日 上午10:35:27
 * @Description: 发货指令 SI T_SI_REG entity
 */
public class SiRegEntity extends BaseEntity {

	private Integer zt;// is'状态';
	private String sjc;// is'时间戳';
	private String zdrid;// is'制单人id';
	private String zdrmc;// is'制单人名称';
	private String chdh;// is'出货单号';
	private String sino;// VARCHAR2(20) not null,
	private Date zdsj;// DATE,
	private String chrid; // VARCHAR2(20),
	private String chrmc; // VARCHAR2(50),
	private String chrdh; // VARCHAR2(20),
	private String chryx; // VARCHAR2(50),
	private String fph; // VARCHAR2(50),
	private String fhrxx; // CLOB,
	private String shrxx; // CLOB,
	private String tzrxx; // CLOB,
	private String qyg; //// VARCHAR2(100),
	private String shd; // VARCHAR2(100),
	private String mdg; // VARCHAR2(100),
	private String zzmdd; // VARCHAR2(100),
	private String cmhc; // VARCHAR2(100),
	private String ms; // CLOB
	private String marks;
	public SiRegEntity() {
		// TODO Auto-generated constructor stub
		super();
	}

	public SiRegEntity(String id) {
		// TODO Auto-generated constructor stub
		super(id);
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
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

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public String getSino() {
		return sino;
	}

	public void setSino(String sino) {
		this.sino = sino;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getChrid() {
		return chrid;
	}

	public void setChrid(String chrid) {
		this.chrid = chrid;
	}

	public String getChrmc() {
		return chrmc;
	}

	public void setChrmc(String chrmc) {
		this.chrmc = chrmc;
	}

	public String getChrdh() {
		return chrdh;
	}

	public void setChrdh(String chrdh) {
		this.chrdh = chrdh;
	}

	public String getChryx() {
		return chryx;
	}

	public void setChryx(String chryx) {
		this.chryx = chryx;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public String getFhrxx() {
		return fhrxx;
	}

	public void setFhrxx(String fhrxx) {
		this.fhrxx = fhrxx;
	}

	public String getShrxx() {
		return shrxx;
	}

	public void setShrxx(String shrxx) {
		this.shrxx = shrxx;
	}

	public String getTzrxx() {
		return tzrxx;
	}

	public void setTzrxx(String tzrxx) {
		this.tzrxx = tzrxx;
	}

	public String getQyg() {
		return qyg;
	}

	public void setQyg(String qyg) {
		this.qyg = qyg;
	}

	public String getShd() {
		return shd;
	}

	public void setShd(String shd) {
		this.shd = shd;
	}

	public String getMdg() {
		return mdg;
	}

	public void setMdg(String mdg) {
		this.mdg = mdg;
	}

	public String getZzmdd() {
		return zzmdd;
	}

	public void setZzmdd(String zzmdd) {
		this.zzmdd = zzmdd;
	}

	public String getCmhc() {
		return cmhc;
	}

	public void setCmhc(String cmhc) {
		this.cmhc = cmhc;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

}
