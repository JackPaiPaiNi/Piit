package com.ey.piit.sdo.booking.vo;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订舱操作日志
 * @author denghai
 *
 */
public class BookingLogVo extends BaseEntity{
     private String dcdh;
     private String czlx;
     private String czzw;
     private String czr;
     private String czrmc;
     private Date czrj;
     private String nr;

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
	public String getDcdh() {
		return dcdh;
	}
	public void setDcdh(String dcdh) {
		this.dcdh = dcdh;
	}
	public void setCzrj(Date czrj) {
		this.czrj = czrj;
	}
	public String getCzzw() {
		return czzw;
	}
	public void setCzzw(String czzw) {
		this.czzw = czzw;
	}
}
