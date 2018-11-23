package com.ey.piit.sdo.deliver.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 出货通知书管理Entity
 * 
 * @author 魏诚
 */
public class DeliverDb {
	private String id; // 预走货id
	private String dcdh; // 订舱单号
	private String yzhdh; // 预走货单号
	private String yzhlx; // 预走货类型编码
	private String yzhlxmc; // 预走货类型名称
	private String xsbm; // 销售部门
	private String xsbmmc; // 销售部门名称
	private String xsyid; // 销售员
	private String xsymc; // 销售员名称
	private String qydm; // 区域代码
	private String qymc; // 区域名称
	private String khbm; // 客户编码
	private String khmc; // 客户名称
	private Date zgsj; // 装柜时间
	private Date yzhsj; // 预走货时间
	private String yzhfqrid; // 预走货发起人
	private String yzhfqrmc; // 预走货发起人名称
	private String beginZgsj; // 开始装柜时间
	private String endZgsj; // 结束装柜时间
	private String qyg; // 起运港
	private String mdg; // 目的港
	private String mytk; // 贸易条款
	private String mytkmc;	//贸易条款名称
	private String cylx; // 出运类型
	private String scjd;
	private String scjdmc;
	private String zdrid;
	private String gsbm; //公司编码
	
	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getScjd() {
		return scjd;
	}

	public void setScjd(String scjd) {
		this.scjd = scjd;
	}

	public String getScjdmc() {
		return scjdmc;
	}

	public void setScjdmc(String scjdmc) {
		this.scjdmc = scjdmc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDcdh() {
		return dcdh;
	}

	public void setDcdh(String dcdh) {
		this.dcdh = dcdh;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	public String getYzhlx() {
		return yzhlx;
	}

	public void setYzhlx(String yzhlx) {
		this.yzhlx = yzhlx;
	}

	public String getYzhlxmc() {
		return yzhlxmc;
	}

	public void setYzhlxmc(String yzhlxmc) {
		this.yzhlxmc = yzhlxmc;
	}

	public String getXsbm() {
		return xsbm;
	}

	public void setXsbm(String xsbm) {
		this.xsbm = xsbm;
	}

	public String getXsbmmc() {
		return xsbmmc;
	}

	public void setXsbmmc(String xsbmmc) {
		this.xsbmmc = xsbmmc;
	}

	public String getQydm() {
		return qydm;
	}

	public void setQydm(String qydm) {
		this.qydm = qydm;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZgsj() {
		return zgsj;
	}

	public void setZgsj(Date zgsj) {
		this.zgsj = zgsj;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYzhsj() {
		return yzhsj;
	}

	public void setYzhsj(Date yzhsj) {
		this.yzhsj = yzhsj;
	}

	public String getYzhfqrid() {
		return yzhfqrid;
	}

	public void setYzhfqrid(String yzhfqrid) {
		this.yzhfqrid = yzhfqrid;
	}

	public String getYzhfqrmc() {
		return yzhfqrmc;
	}

	public void setYzhfqrmc(String yzhfqrmc) {
		this.yzhfqrmc = yzhfqrmc;
	}

	public String getBeginZgsj() {
		return beginZgsj;
	}

	public void setBeginZgsj(String beginZgsj) {
		this.beginZgsj = beginZgsj;
	}

	public String getEndZgsj() {
		return endZgsj;
	}

	public void setEndZgsj(String endZgsj) {
		this.endZgsj = endZgsj;
	}

	public String getXsyid() {
		return xsyid;
	}

	public void setXsyid(String xsyid) {
		this.xsyid = xsyid;
	}

	public String getXsymc() {
		return xsymc;
	}

	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}

	public String getQyg() {
		return qyg;
	}

	public void setQyg(String qyg) {
		this.qyg = qyg;
	}

	public String getMdg() {
		return mdg;
	}

	public void setMdg(String mdg) {
		this.mdg = mdg;
	}

	public String getMytk() {
		return mytk;
	}

	public void setMytk(String mytk) {
		this.mytk = mytk;
	}

	public String getCylx() {
		return cylx;
	}

	public void setCylx(String cylx) {
		this.cylx = cylx;
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public String getMytkmc() {
		return mytkmc;
	}

	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc;
	}

}