package com.ey.piit.sdo.payment.vo;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * LC登记操作日志
 * @author denghai
 *
 */
public class LcLogVo extends BaseEntity{
     private String lcbh;
     private String bbh;
     private String czlx;
     private String czzw;
     private String czr;
     private String czrmc;
     private Date czrj;
     private String nr;
	
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
	public void setCzsj(Date czrj) {
		this.czrj = czrj;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public void setCzrj(Date czrj) {
		this.czrj = czrj;
	}
	public String getLcbh() {
		return lcbh;
	}
	public void setLcbh(String lcbh) {
		this.lcbh = lcbh;
	}
	public String getCzzw() {
		return czzw;
	}
	public void setCzzw(String czzw) {
		this.czzw = czzw;
	}
}
