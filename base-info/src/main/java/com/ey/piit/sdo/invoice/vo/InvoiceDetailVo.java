package com.ey.piit.sdo.invoice.vo;

import com.ey.piit.sdo.invoice.entity.InvoiceDetail;

/**
 * 发票明细信息维护Entity
 * @author tianrong
 */
public class InvoiceDetailVo extends InvoiceDetail {

	private String gsbm;			//公司编码
	private String khbm;			//客户编码
	private String khmc;			//客户名称
	private String gh;              //柜号
	private String beginZgrq;		//开始装柜日期
	private String endZgrq;			//结束装柜日期
	private String zhfs;			//走货方式
	private String zhfsmc;			//走货方式名称
	private String zgrq;			//装柜日期
	private String ddlx;			//订单类型
	private String ddlxmc;			//订单类型名称
	private String qyg;				//起运港
	private String qygmc;			//起运港名称
	private String mdg;				//目的港
	private String mdgmc;			//目的港名称
	private String cwzyid;			//船务专员
	private String cwzymc;			//船务专员
	private String scjd;			//生产基地
	private String scjdmc;			//生产基地名称

	
	public InvoiceDetailVo() {
		super();
	}

	public InvoiceDetailVo(String id){
		super(id);
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
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

	public String getGh() {
		return gh;
	}

	public void setGh(String gh) {
		this.gh = gh;
	}

	public String getBeginZgrq() {
		return beginZgrq;
	}

	public void setBeginZgrq(String beginZgrq) {
		this.beginZgrq = beginZgrq;
	}

	public String getEndZgrq() {
		return endZgrq;
	}

	public void setEndZgrq(String endZgrq) {
		this.endZgrq = endZgrq;
	}

	public String getMdg() {
		return mdg;
	}

	public void setMdg(String mdg) {
		this.mdg = mdg;
	}

	public String getCwzymc() {
		return cwzymc;
	}

	public void setCwzymc(String cwzymc) {
		this.cwzymc = cwzymc;
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

	public String getZgrq() {
		return zgrq;
	}

	public void setZgrq(String zgrq) {
		this.zgrq = zgrq;
	}

	public String getDdlx() {
		return ddlx;
	}

	public void setDdlx(String ddlx) {
		this.ddlx = ddlx;
	}

	public String getDdlxmc() {
		return ddlxmc;
	}

	public void setDdlxmc(String ddlxmc) {
		this.ddlxmc = ddlxmc;
	}

	public String getQyg() {
		return qyg;
	}

	public void setQyg(String qyg) {
		this.qyg = qyg;
	}

	public String getQygmc() {
		return qygmc;
	}

	public void setQygmc(String qygmc) {
		this.qygmc = qygmc;
	}

	public String getMdgmc() {
		return mdgmc;
	}

	public void setMdgmc(String mdgmc) {
		this.mdgmc = mdgmc;
	}

	public String getCwzyid() {
		return cwzyid;
	}

	public void setCwzyid(String cwzyid) {
		this.cwzyid = cwzyid;
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

	

}