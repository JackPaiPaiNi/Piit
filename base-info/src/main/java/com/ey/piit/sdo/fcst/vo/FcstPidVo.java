package com.ey.piit.sdo.fcst.vo;

/**
 * FCST填报 PID抓取
 * @author Jun
 *
 */
public class FcstPidVo {
	private String id;
	private String pid;
	private String jixin;
	private String jixing;
	private Double cc;
	private String zhfs;
	private String zhfsmc;
	private String iszjh;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getJixin() {
		return jixin;
	}
	public void setJixin(String jixin) {
		this.jixin = jixin;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public Double getCc() {
		return cc;
	}
	public void setCc(Double cc) {
		this.cc = cc;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIszjh() {
		return iszjh;
	}
	public void setIszjh(String iszjh) {
		this.iszjh = iszjh;
	}
}
