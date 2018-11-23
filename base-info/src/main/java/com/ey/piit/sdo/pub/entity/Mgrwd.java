package com.ey.piit.sdo.pub.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 美工任务单
 * @author 魏诚
 *
 */
public class Mgrwd extends BaseEntity {
	
	private String rwdh;
	private Integer bbh;
	private String zdrid;
	private String zdrmc;
	private Date zdsj;
	private Integer zt;
	private String sjc;
	private String pid;
	private String wkysbz;
	private String wkysbzmc;
	private String zhfs;
	private String zhfsmc;
	private String khpp;
	private String xwgj;
	private String xwgjmc;
	private String jixing;
	private String jixin;
	private String ztmc;
	private Integer mbbs;
	private String mbbsmc;
	
	public String getRwdh() {
		return rwdh;
	}
	public void setRwdh(String rwdh) {
		this.rwdh = rwdh;
	}
	public Integer getBbh() {
		return bbh;
	}
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
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
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getWkysbz() {
		return wkysbz;
	}
	public void setWkysbz(String wkysbz) {
		this.wkysbz = wkysbz;
	}
	public String getWkysbzmc() {
		return wkysbzmc;
	}
	public void setWkysbzmc(String wkysbzmc) {
		this.wkysbzmc = wkysbzmc;
	}
	public String getZhfs() {
		return zhfs;
	}
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs;
	}
	public String getZhfsmc() {
		return zhfsmc;
	}
	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}
	public String getKhpp() {
		return khpp;
	}
	public void setKhpp(String khpp) {
		this.khpp = khpp;
	}
	public String getXwgj() {
		return xwgj;
	}
	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}
	public String getXwgjmc() {
		return xwgjmc;
	}
	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public String getJixin() {
		return jixin;
	}
	public void setJixin(String jixin) {
		this.jixin = jixin;
	}
	public String getZtmc() {
		return ztmc;
	}
	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
	public Integer getMbbs() {
		return mbbs;
	}
	public void setMbbs(Integer mbbs) {
		this.mbbs = mbbs;
	}
	public String getMbbsmc() {
		return mbbsmc;
	}
	public void setMbbsmc(String mbbsmc) {
		this.mbbsmc = mbbsmc;
	}
	
}
