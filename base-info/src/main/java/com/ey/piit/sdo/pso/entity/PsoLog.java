package com.ey.piit.sdo.pso.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 预走货日志Entity
 * @author 魏诚
 */
public class PsoLog extends BaseEntity {
	
	private String yzhdh;
    private String bbh;
    private String czlx;
    private String czzw;
    private String czr;
    private String czrmc;
    private Date czrj;
    private String nr;
    
    public PsoLog() {
		super();
	}

	public PsoLog(String id) {
		super(id);
	}
    
	public String getYzhdh() {
		return yzhdh;
	}
	public String getBbh() {
		return bbh;
	}
	public String getCzlx() {
		return czlx;
	}
	public String getCzr() {
		return czr;
	}
	public String getCzrmc() {
		return czrmc;
	}
	public Date getCzrj() {
		return czrj;
	}
	public String getNr() {
		return nr;
	}
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	public void setBbh(String bbh) {
		this.bbh = bbh;
	}
	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public void setCzrmc(String czrmc) {
		this.czrmc = czrmc;
	}
	public void setCzrj(Date czrj) {
		this.czrj = czrj;
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