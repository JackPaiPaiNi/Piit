package com.ey.piit.sdo.art.vo;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 美工任务单日志
 * @author 魏诚
 *
 */
public class ArtLogVo extends BaseEntity{
	
     private String rwdh;
     private Integer bbh;
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
	public String getRwdh() {
		return rwdh;
	}
	public void setRwdh(String rwdh) {
		this.rwdh = rwdh;
	}
	public Integer getBbh() {
		return bbh;
	}
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	public String getCzzw() {
		return czzw;
	}
	public void setCzzw(String czzw) {
		this.czzw = czzw;
	}
	
}
