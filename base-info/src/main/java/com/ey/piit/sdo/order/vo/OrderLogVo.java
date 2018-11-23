package com.ey.piit.sdo.order.vo;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订单操作日志
 * @author denghai
 *
 */
public class OrderLogVo extends BaseEntity{
     private String ddid;
     private String bbh;
     private String czlx;
     private String czzw;
     private String czr;
     private String czrmc;
     private Date czrj;
     private String nr;
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public String getBbh() {
		return bbh;
	}
	public void setBbh(String bbh) {
		this.bbh = bbh;
	}
	public String getCzlx() {
		return czlx;
	}
	public void setCzlx(String czlx) {
		this.czlx = czlx;
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
	public Date getCzrj() {
		return czrj;
	}
	public void setCzrj(Date czrj) {
		this.czrj = czrj;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getCzzw() {
		return czzw;
	}
	public void setCzzw(String czzw) {
		this.czzw = czzw;
	}
}
