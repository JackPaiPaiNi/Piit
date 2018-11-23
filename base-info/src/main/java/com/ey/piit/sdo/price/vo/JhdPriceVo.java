package com.ey.piit.sdo.price.vo;

import com.ey.piit.sdo.price.entity.JhdPrice;


/**
 * 交货单Entity
 * @author 邓海
 */
public class JhdPriceVo extends JhdPrice {
	private String zdrmc;
	private String zdrid;
	private String khbm;
	private String khmc;
	public String getZdrmc() {
		return zdrmc;
	}
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}
	public String getZdrid() {
		return zdrid;
	}
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
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

}