package com.ey.piit.sdo.report.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * EuropeSKDorderStatus
 * @author 魏诚
 */
public class EuropeSKDorderStatus extends BaseEntity {
	
	private String ddid;
	private Integer bbh;
	private String khbm;
	private String khmc;
	private String zzkhm;
	private String zhfs;
	private String zhfsmc;
	private String gjmytk;
	private String gjmytkmc;
	private String gjmytkbz;
	private String pid;
	private String jixin;
    private String jixing;
    private String ccyq;
    private String mjxh;
    private String pp;
    private String xwgj;
    private String xwgjmc;
    private String zsj;
    private String dtjgf;
    private String jgfhj;
    private Double dj;
    private String zzkhdj;
    private Date zdsj;
    private Date jhrq;
    private String chdh;
    private Date etd;
    private Date eta;
    private String khyqddjhrq;
	
	public EuropeSKDorderStatus() {
		super();
	}

	public EuropeSKDorderStatus(String id){
		super(id);
	}

	public String getDdid() {
		return ddid;
	}

	public Integer getBbh() {
		return bbh;
	}

	public String getKhbm() {
		return khbm;
	}

	public String getKhmc() {
		return khmc;
	}

	public String getZzkhm() {
		return zzkhm;
	}

	public String getZhfs() {
		return zhfs;
	}

	public String getZhfsmc() {
		return zhfsmc;
	}

	public String getGjmytk() {
		return gjmytk;
	}

	public String getGjmytkbz() {
		return gjmytkbz;
	}

	public String getPid() {
		return pid;
	}

	public String getJixin() {
		return jixin;
	}

	public String getJixing() {
		return jixing;
	}

	public String getCcyq() {
		return ccyq;
	}

	public String getMjxh() {
		return mjxh;
	}

	public String getPp() {
		return pp;
	}

	public String getXwgj() {
		return xwgj;
	}

	public String getXwgjmc() {
		return xwgjmc;
	}

	public String getZsj() {
		return zsj;
	}

	public String getDtjgf() {
		return dtjgf;
	}

	public String getJgfhj() {
		return jgfhj;
	}

	public Double getDj() {
		return dj;
	}

	public String getZzkhdj() {
		return zzkhdj;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJhrq() {
		return jhrq;
	}

	public String getChdh() {
		return chdh;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEtd() {
		return etd;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEta() {
		return eta;
	}

	public String getKhyqddjhrq() {
		return khyqddjhrq;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public void setZzkhm(String zzkhm) {
		this.zzkhm = zzkhm;
	}

	public void setZhfs(String zhfs) {
		this.zhfs = zhfs;
	}

	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}

	public void setGjmytk(String gjmytk) {
		this.gjmytk = gjmytk;
	}

	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setJixin(String jixin) {
		this.jixin = jixin;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public void setCcyq(String ccyq) {
		this.ccyq = ccyq;
	}

	public void setMjxh(String mjxh) {
		this.mjxh = mjxh;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}

	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}

	public void setZsj(String zsj) {
		this.zsj = zsj;
	}

	public void setDtjgf(String dtjgf) {
		this.dtjgf = dtjgf;
	}

	public void setJgfhj(String jgfhj) {
		this.jgfhj = jgfhj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public void setZzkhdj(String zzkhdj) {
		this.zzkhdj = zzkhdj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public void setJhrq(Date jhrq) {
		this.jhrq = jhrq;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public void setEtd(Date etd) {
		this.etd = etd;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public void setKhyqddjhrq(String khyqddjhrq) {
		this.khyqddjhrq = khyqddjhrq;
	}

	public String getGjmytkmc() {
		return gjmytkmc;
	}

	public void setGjmytkmc(String gjmytkmc) {
		this.gjmytkmc = gjmytkmc;
	}
	
}