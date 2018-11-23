package com.ey.piit.sdo.order.vo;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.sdo.order.entity.OrderReferPi;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单引用PIEntity
 * @author 赵明
 */
public class OrderReferPiVo extends OrderReferPi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -879990411388289415L;
	
	private String xsyid;		// 销售员ID
	private String xsymc;		// 销售员名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String ywz;			// 业务组
	private String ywzmc;		// 业务组名称
	private String gjmytk;		// 国际贸易条款
	private String gjmytkmc;		// 国际贸易条款名称
	private String gjmytkbz;		// 国际贸易条款备注
	private String zhfs;		// 走货方式
	private String zhfsmc;		// 走货方式名称
	private String cylx;		// 出运类型
	private String cylxmc;		// 出运类型名称
	private String zdrid;		// 制单人id
	private String zdrmc;		// 制单人名称
	private String khmc;		// 客户名称
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private Date piyxq;		// pi有效期
	private String khbm;		// 客户编码
	private Integer yxdsl;		// 已下单数量
	private Integer spzsl;		// 审批中数量
	private String fktj;		// 付款条件
	private String fktjmc;		// 付款条件名称
	private String beginZdsj;	// 开始 制单时间
	private String endZdsj;		// 结束 制单时间
	private String wllx;
	private String wllxmc;
	private String ckddh;
	private Integer mfsl;	// 免费数量
	private String scjd;	// 生产基地
	private String scjdmc;	// 生产基地名称
	private String wlms;//物料描述
	private String model;	//我司型号
	private String khxh;	//客户型号
	private String pilb;	//PI类别
	private String pilbmc;	//PI类别

	public OrderReferPiVo() {
		super();
	}

	public OrderReferPiVo(String id){
		super(id);
	}

	public Integer getYxdsl() {
		return yxdsl;
	}

	public void setYxdsl(Integer yxdsl) {
		this.yxdsl = yxdsl;
	}
    
	

	public String getBeginZdsj() {
		return beginZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	/**
     * piyxq
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPiyxq() {
		return piyxq;
	}

	/**
     * piyxq
     */
	public void setPiyxq(Date piyxq) {
		this.piyxq = piyxq;
	}
	
	/**
     * xsymc
     */
	@Length(min=0, max=50, message="xsymc长度必须介于 0 和 50 之间")
	public String getXsymc() {
		return xsymc;
	}

	/**
     * xsymc
     */
	public void setXsymc(String xsymc) {
		this.xsymc = xsymc == null ? null : xsymc.trim();
	}
	
	/**
     * gjmytk
     */
	@Length(min=0, max=50, message="gjmytk长度必须介于 0 和 50 之间")
	public String getGjmytk() {
		return gjmytk;
	}

	/**
     * gjmytk
     */
	public void setGjmytk(String gjmytk) {
		this.gjmytk = gjmytk == null ? null : gjmytk.trim();
	}
	
	/**
     * gjmytkmc
     */
	@Length(min=0, max=50, message="gjmytkmc长度必须介于 0 和 50 之间")
	public String getGjmytkmc() {
		return gjmytkmc;
	}

	/**
     * gjmytkmc
     */
	public void setGjmytkmc(String gjmytkmc) {
		this.gjmytkmc = gjmytkmc == null ? null : gjmytkmc.trim();
	}
	
	/**
     * zhfs
     */
	@Length(min=0, max=50, message="zhfs长度必须介于 0 和 50 之间")
	public String getZhfs() {
		return zhfs;
	}

	/**
     * zhfs
     */
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs == null ? null : zhfs.trim();
	}
	
	/**
     * zhfsmc
     */
	@Length(min=0, max=50, message="zhfsmc长度必须介于 0 和 50 之间")
	public String getZhfsmc() {
		return zhfsmc;
	}

	/**
     * zhfsmc
     */
	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc == null ? null : zhfsmc.trim();
	}
	
	/**
     * cylx
     */
	@Length(min=0, max=50, message="cylx长度必须介于 0 和 50 之间")
	public String getCylx() {
		return cylx;
	}

	/**
     * cylx
     */
	public void setCylx(String cylx) {
		this.cylx = cylx == null ? null : cylx.trim();
	}
	
	/**
     * cylxmc
     */
	@Length(min=0, max=50, message="cylxmc长度必须介于 0 和 50 之间")
	public String getCylxmc() {
		return cylxmc;
	}

	/**
     * cylxmc
     */
	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc == null ? null : cylxmc.trim();
	}
	
	/**
     * zdrid
     */
	@Length(min=0, max=20, message="zdrid长度必须介于 0 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * zdrid
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * zdrmc
     */
	@Length(min=0, max=50, message="zdrmc长度必须介于 0 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * zdrmc
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}
	
	/**
     * xszzmc
     */
	@Length(min=0, max=50, message="xszzmc长度必须介于 0 和 50 之间")
	public String getXszzmc() {
		return xszzmc;
	}

	/**
     * xszzmc
     */
	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc == null ? null : xszzmc.trim();
	}
	
	/**
     * xsyid
     */
	@Length(min=0, max=20, message="xsyid长度必须介于 0 和 20 之间")
	public String getXsyid() {
		return xsyid;
	}

	/**
     * xsyid
     */
	public void setXsyid(String xsyid) {
		this.xsyid = xsyid == null ? null : xsyid.trim();
	}
	

	/**
     * xszz
     */
	@Length(min=0, max=20, message="xszz长度必须介于 0 和 20 之间")
	public String getXszz() {
		return xszz;
	}

	/**
     * xszz
     */
	public void setXszz(String xszz) {
		this.xszz = xszz == null ? null : xszz.trim();
	}
	
	/**
     * gsbm
     */
	@Length(min=0, max=20, message="gsbm长度必须介于 0 和 20 之间")
	public String getGsbm() {
		return gsbm;
	}

	/**
     * gsbm
     */
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm == null ? null : gsbm.trim();
	}
	
	/**
     * gsmc
     */
	@Length(min=0, max=50, message="gsmc长度必须介于 0 和 50 之间")
	public String getGsmc() {
		return gsmc;
	}

	/**
     * gsmc
     */
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc == null ? null : gsmc.trim();
	}
	
	/**
     * 客户名称
     */
	@Length(min=0, max=100, message="客户名称长度必须介于 0 和 100 之间")
	public String getKhmc() {
		return khmc;
	}

	/**
     * 客户名称
     */
	public void setKhmc(String khmc) {
		this.khmc = khmc == null ? null : khmc.trim();
	}

	/**
     * 客户编码
     */
	@Length(min=0, max=20, message="客户编码长度必须介于 0 和 20 之间")
	public String getKhbm() {
		return khbm;
	}

	/**
     * 客户编码
     */
	public void setKhbm(String khbm) {
		this.khbm = khbm == null ? null : khbm.trim();
	}

	public String getFktj() {
		return fktj;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}

	public String getYwz() {
		return ywz;
	}

	public void setYwz(String ywz) {
		this.ywz = ywz;
	}

	public String getYwzmc() {
		return ywzmc;
	}

	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc;
	}

	public String getWllx() {
		return wllx;
	}

	public void setWllx(String wllx) {
		this.wllx = wllx;
	}

	public String getCkddh() {
		return ckddh;
	}

	public void setCkddh(String ckddh) {
		this.ckddh = ckddh;
	}

	public String getWllxmc() {
		return wllxmc;
	}

	public void setWllxmc(String wllxmc) {
		this.wllxmc = wllxmc;
	}

	public String getGjmytkbz() {
		return gjmytkbz;
	}

	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz;
	}

	public Integer getMfsl() {
		return mfsl;
	}

	public void setMfsl(Integer mfsl) {
		this.mfsl = mfsl;
	}

	public String getScjd() {
		return scjd;
	}

	public String getScjdmc() {
		return scjdmc;
	}

	public void setScjd(String scjd) {
		this.scjd = scjd;
	}

	public void setScjdmc(String scjdmc) {
		this.scjdmc = scjdmc;
	}

	public String getWlms() {
		return wlms;
	}

	public void setWlms(String wlms) {
		this.wlms = wlms;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getKhxh() {
		return khxh;
	}

	public void setKhxh(String khxh) {
		this.khxh = khxh;
	}

	public Integer getSpzsl() {
		return spzsl;
	}

	public void setSpzsl(Integer spzsl) {
		this.spzsl = spzsl;
	}

	public String getPilb() {
		return pilb;
	}

	public void setPilb(String pilb) {
		this.pilb = pilb;
	}

	public String getPilbmc() {
		return pilbmc;
	}

	public void setPilbmc(String pilbmc) {
		this.pilbmc = pilbmc;
	}
	
}