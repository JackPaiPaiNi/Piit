package com.ey.piit.sdo.mdm.vo;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 客户申请操作日志
 * @author gaowenhao
 *
 */
public class CustomerApplyLogVo extends BaseEntity{
     private String sqdh;
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
	public void setCzrj(Date czrj) {
		this.czrj = czrj;
	}
	public String getCzzw() {
		return czzw;
	}
	public void setCzzw(String czzw) {
		this.czzw = czzw;
	}
	public String getSqdh() {
		return sqdh;
	}
	public void setSqdh(String sqdh) {
		this.sqdh = sqdh;
	}
	
}
