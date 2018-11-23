package com.ey.piit.sdo.invoice.vo;

import com.ey.piit.sdo.invoice.entity.InvoiceItem;

/**
 * 发票信息维护Entity
 * @author 高文浩
 */
public class InvoiceItemVo extends InvoiceItem {

	private String gsbm;			//公司编码
	private String khbm;			//客户编码
	private String khmc;			//客户名称
	private String gh;              //柜号
	private String beginZgrq;		//开始装柜日期
	private String endZgrq;			//结束装柜日期
	private String mdg;				//目的港
	private String cwzymc;			//船务专员
	private String zhfs;
	private String zhfsmc;

	public InvoiceItemVo() {
		super();
	}

	public InvoiceItemVo(String id){
		super(id);
	}

	public String getGsbm() {
		return gsbm;
	}

	public String getKhbm() {
		return khbm;
	}

	public String getKhmc() {
		return khmc;
	}

	public String getBeginZgrq() {
		return beginZgrq;
	}

	public String getEndZgrq() {
		return endZgrq;
	}

	public String getMdg() {
		return mdg;
	}

	public String getCwzymc() {
		return cwzymc;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public void setBeginZgrq(String beginZgrq) {
		this.beginZgrq = beginZgrq;
	}

	public void setEndZgrq(String endZgrq) {
		this.endZgrq = endZgrq;
	}

	public void setMdg(String mdg) {
		this.mdg = mdg;
	}

	public void setCwzymc(String cwzymc) {
		this.cwzymc = cwzymc;
	}

	public String getZhfs() {
		return zhfs;
	}

	public String getZhfsmc() {
		return zhfsmc;
	}

	public void setZhfs(String zhfs) {
		this.zhfs = zhfs;
	}

	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}

	public String getGh() {
		return gh;
	}

	public void setGh(String gh) {
		this.gh = gh;
	}

}