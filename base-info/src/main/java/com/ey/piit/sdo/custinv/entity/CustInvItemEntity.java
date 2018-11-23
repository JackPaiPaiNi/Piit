package com.ey.piit.sdo.custinv.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 
 * @author: 魏诚
 * @Date: 2018年7月5日
 * @Description: 客户发票明细表 T_CUSTINV_ITEM ENTITY
 */
public class CustInvItemEntity extends BaseEntity {
										// 1 2				3
	private String fph;    //发票号		       
	private String chdh;    //出货单号        
	private String ddid;    //订单号        Job No.
	private String wlbh;    //物料编号 Part No.
	private String wlms;    //物料描述   DESCRIPTION   
	private String hscode;    //hs code    HS CODE
	private Integer sl;    //数量
	private String dw;    //单位
	private Double zxzwet;    //箱总重量
	private Double dj;    //单价
	private Double je;    //金额
	private String khlh;    //客户料号
	private String khms;    //客户描述
	private String gysmc;    //供应商名称
	private String gysdz;    //供应商地址
	private String ycgj;    //原产国家
	private String spmc; //商品名称
	private String khxh; //客户型号
	
	public CustInvItemEntity() {
		super();
	}

	public CustInvItemEntity(String id) {
		super(id);
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getWlbh() {
		return wlbh;
	}

	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}

	public String getWlms() {
		return wlms;
	}

	public void setWlms(String wlms) {
		this.wlms = wlms;
	}

	public String getHscode() {
		return hscode;
	}

	public void setHscode(String hscode) {
		this.hscode = hscode;
	}

	public Integer getSl() {
		return sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public Double getZxzwet() {
		return zxzwet;
	}

	public void setZxzwet(Double zxzwet) {
		this.zxzwet = zxzwet;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Double getJe() {
		return je;
	}

	public void setJe(Double je) {
		this.je = je;
	}

	public String getKhlh() {
		return khlh;
	}

	public void setKhlh(String khlh) {
		this.khlh = khlh;
	}

	public String getKhms() {
		return khms;
	}

	public void setKhms(String khms) {
		this.khms = khms;
	}

	public String getGysmc() {
		return gysmc;
	}

	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}

	public String getGysdz() {
		return gysdz;
	}

	public void setGysdz(String gysdz) {
		this.gysdz = gysdz;
	}

	public String getYcgj() {
		return ycgj;
	}

	public void setYcgj(String ycgj) {
		this.ycgj = ycgj;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getKhxh() {
		return khxh;
	}

	public void setKhxh(String khxh) {
		this.khxh = khxh;
	}

}
