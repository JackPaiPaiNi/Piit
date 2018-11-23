package com.ey.piit.sdo.custinv.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 
 * @author: junc
 * @date: 2018年6月29日 上午10:45:26
 * @Description: 发货指令详情 SI T_SI_ITEM ENTITY
 */
public class SiItemEntity extends BaseEntity {
	private String sino;// is 'SI单号';
	private String guino;// is '柜号';
	private String ftno;// is '封条号';
	private Double kbzwet;// is '卡板总重量';
	private Double kbzv;// is '卡板总体积';
	private Double vgm;// is 'vgm = kbzwet + tare';
	private Integer boxsum;// is '总箱数';
	private Integer kbsum;// is '总卡板数';
	private String gxnam;// is '柜型';
	private String dcno;// is '订舱号';
	private String tare;// is 'TREA';

	public SiItemEntity() {
		// TODO Auto-generated constructor stub
		super();
	}

	public SiItemEntity(String id) {
		// TODO Auto-generated constructor stub
		super(id);
	}

	public String getSino() {
		return sino;
	}

	public void setSino(String sino) {
		this.sino = sino;
	}

	public String getGuino() {
		return guino;
	}

	public void setGuino(String guino) {
		this.guino = guino;
	}

	public String getFtno() {
		return ftno;
	}

	public void setFtno(String ftno) {
		this.ftno = ftno;
	}

	public Double getKbzwet() {
		return kbzwet;
	}

	public void setKbzwet(Double kbzwet) {
		this.kbzwet = kbzwet;
	}

	public Double getKbzv() {
		return kbzv;
	}

	public void setKbzv(Double kbzv) {
		this.kbzv = kbzv;
	}

	public Double getVgm() {
		return vgm;
	}

	public void setVgm(Double vgm) {
		this.vgm = vgm;
	}

	public Integer getBoxsum() {
		return boxsum;
	}

	public void setBoxsum(Integer boxsum) {
		this.boxsum = boxsum;
	}

	public Integer getKbsum() {
		return kbsum;
	}

	public void setKbsum(Integer kbsum) {
		this.kbsum = kbsum;
	}

	public String getGxnam() {
		return gxnam;
	}

	public void setGxnam(String gxnam) {
		this.gxnam = gxnam;
	}

	public String getDcno() {
		return dcno;
	}

	public void setDcno(String dcno) {
		this.dcno = dcno;
	}

	public String getTare() {
		return tare;
	}

	public void setTare(String tare) {
		this.tare = tare;
	}

}
