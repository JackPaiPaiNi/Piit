package com.ey.piit.sdo.project.vo;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * pid操作日志
 * 
 * @author zhaotaojun
 *
 */
public class ProjectBugLogVo extends BaseEntity {
	private String dh;
	private String czlx;
	private String czzw;
	private String czr;
	private String czrmc;
	private Date czrj;
	private String spyj;
	private String nr;
	

	
	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
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

	public String getCzzw() {
		return czzw;
	}

	public void setCzzw(String czzw) {
		this.czzw = czzw;
	}

	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public Date getCzrj() {
		return czrj;
	}

	public void setCzrj(Date czrj) {
		this.czrj = czrj;
	}

	public String getSpyj() {
		return spyj;
	}

	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}

}
