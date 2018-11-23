package com.ey.piit.sdo.custinv.vo;

import java.util.List;

import com.google.common.collect.Lists;

public class ShippingNoticeVo {
	private List<SiShippingNoticeVo> siShippingNotices = Lists.newArrayList();
	private String khmc;
	private String beginZgrq;
	private String endZgrq;
	private String chtzs;
	private String ddh;
	private String guino;
	private Integer sfsi;
	public Integer getSfsi() {
		return sfsi;
	}
	public void setSfsi(Integer sfsi) {
		this.sfsi = sfsi;
	}
	public List<SiShippingNoticeVo> getSiShippingNotices() {
		return siShippingNotices;
	}
	public void setSiShippingNotices(List<SiShippingNoticeVo> siShippingNotices) {
		this.siShippingNotices = siShippingNotices;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
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
	public String getChtzs() {
		return chtzs;
	}
	public void setChtzs(String chtzs) {
		this.chtzs = chtzs;
	}
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getGuino() {
		return guino;
	}
	public void setGuino(String guino) {
		this.guino = guino;
	}

}
