package com.ey.piit.sdo.report.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单状态
 * @author zhaozhiyang
 *
 */
public class OrderStatus {
	
	private  Date   zdsj ; //制单日期
	private  String ddid ; //订单id
	private  String ztmc ; //订单状态
	private  String ddlxmc ; //订单类型名称
	private  Date   jhrq ; //交货日期
	private  String sl ; //数量
	private  String czzw ;  //操作岗位
	private  String czr ; //当前审批岗
	private  String czrmc ; //当前审批人
	private  String zdrid;  //制单人 
	private  String zdrmc;  //制单人 
	private  String ddlx;   //订单类型
	private String bbh;	//版本号
	
	
	
	public String getZdrmc() {
		return zdrmc;
	}
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}
	public String getDdlx() {
		return ddlx;
	}
	public void setDdlx(String ddlx) {
		this.ddlx = ddlx;
	}
	public String getZdrid() {
		return zdrid;
	}
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	public String getDdlxmc() {
		return ddlxmc;
	}
	public void setDdlxmc(String ddlxmc) {
		this.ddlxmc = ddlxmc;
	}
	public String getCzzw() {
		return czzw;
	}
	public void setCzzw(String czzw) {
		this.czzw = czzw;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public String getZtmc() {
		return ztmc;
	}
	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJhrq() {
		return jhrq;
	}
	public void setJhrq(Date jhrq) {
		this.jhrq = jhrq;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public String getCzrmc() {
		return czrmc;
	}
	public void setCzrmc(String czrmc) {
		this.czrmc = czrmc;
	}
	public String getBbh() {
		return bbh;
	}
	public void setBbh(String bbh) {
		this.bbh = bbh;
	}
	
	

}
