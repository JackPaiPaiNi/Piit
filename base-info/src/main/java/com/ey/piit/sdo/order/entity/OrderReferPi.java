package com.ey.piit.sdo.order.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订单引用PIEntity
 * @author 赵明
 */
public class OrderReferPi extends BaseEntity {
	
	private String ddid;		// 订单号
	private Integer bbh;		// 版本号
	private String piid;		// PI号
	private String pilx;		// pi类型
	private String piitemid;		// PI明细ID
	private String pilxmc;		// pi类型名称
	private String bz;		// 币种
	private String mxlx;		// 明细类型
	private String mxlxmc;		// 明细类型名称
	private String pid;		// PID
	private String khxhms;		// 客户型号描述
	private String wlbh;		// 物料编号
	private Integer sl;		// 数量
	private String jixin;		// 机芯
	private String jixing;		// 机型
	private String dw;		// 单位
	private BigDecimal dj;		// 单价
	private BigDecimal je;		// 金额
	private Integer yzhsl;	// 已走货数量
	private Integer pisl;	// PI数量
	private String ks;	//款式
	private String ksmc;	//款式名称
	private Integer sfBd;//多元化 是否白电
	private Integer yjsl;	//样机数量
	
	public OrderReferPi() {
		super();
	}

	public OrderReferPi(String id){
		super(id);
	}

	/**
     * 订单号
     */
	@Length(min=1, max=20, message="订单号长度必须介于 1 和 20 之间")
	public String getDdid() {
		return ddid;
	}

	/**
     * 订单号
     */
	public void setDdid(String ddid) {
		this.ddid = ddid == null ? null : ddid.trim();
	}
	
	/**
     * 版本号
     */
	@NotNull(message="版本号不能为空")
	public Integer getBbh() {
		return bbh;
	}

	/**
     * 版本号
     */
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	
	/**
     * PI号
     */
	@Length(min=1, max=20, message="PI号长度必须介于 1 和 20 之间")
	public String getPiid() {
		return piid;
	}

	/**
     * PI号
     */
	public void setPiid(String piid) {
		this.piid = piid == null ? null : piid.trim();
	}
	
	/**
     * pilx
     */
	@Length(min=1, max=50, message="pilx长度必须介于 1 和 50 之间")
	public String getPilx() {
		return pilx;
	}

	/**
     * pilx
     */
	public void setPilx(String pilx) {
		this.pilx = pilx == null ? null : pilx.trim();
	}
	
	/**
     * PI明细ID
     */
	@Length(min=1, max=50, message="PI明细ID长度必须介于 1 和 50 之间")
	public String getPiitemid() {
		return piitemid;
	}

	/**
     * PI明细ID
     */
	public void setPiitemid(String piitemid) {
		this.piitemid = piitemid == null ? null : piitemid.trim();
	}
	
	/**
     * pilxmc
     */
	@Length(min=0, max=50, message="pilxmc长度必须介于 0 和 50 之间")
	public String getPilxmc() {
		return pilxmc;
	}

	/**
     * pilxmc
     */
	public void setPilxmc(String pilxmc) {
		this.pilxmc = pilxmc == null ? null : pilxmc.trim();
	}
	
	/**
     * 币种
     */
	@Length(min=0, max=50, message="币种长度必须介于 0 和 50 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 币种
     */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}
	
	/**
     * mxlx
     */
	@Length(min=0, max=50, message="mxlx长度必须介于 0 和 50 之间")
	public String getMxlx() {
		return mxlx;
	}

	/**
     * mxlx
     */
	public void setMxlx(String mxlx) {
		this.mxlx = mxlx == null ? null : mxlx.trim();
	}
	
	/**
     * mxlxmc
     */
	@Length(min=0, max=50, message="mxlxmc长度必须介于 0 和 50 之间")
	public String getMxlxmc() {
		return mxlxmc;
	}

	/**
     * mxlxmc
     */
	public void setMxlxmc(String mxlxmc) {
		this.mxlxmc = mxlxmc == null ? null : mxlxmc.trim();
	}
	
	/**
     * PID
     */
	@Length(min=0, max=50, message="PID长度必须介于 0 和 50 之间")
	public String getPid() {
		return pid;
	}

	/**
     * PID
     */
	public void setPid(String pid) {
		this.pid = pid == null ? null : pid.trim();
	}
	
	/**
     * 客户型号描述
     */
	@Length(min=0, max=100, message="客户型号描述长度必须介于 0 和 100 之间")
	public String getKhxhms() {
		return khxhms;
	}

	/**
     * 客户型号描述
     */
	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms == null ? null : khxhms.trim();
	}
	
	/**
     * 物料编号
     */
	@Length(min=0, max=50, message="物料编号长度必须介于 0 和 50 之间")
	public String getWlbh() {
		return wlbh;
	}

	/**
     * 物料编号
     */
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh == null ? null : wlbh.trim();
	}
	
	/**
     * 数量
     */
	public Integer getSl() {
		return sl;
	}

	/**
     * 数量
     */
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	
	/**
     * 机芯
     */
	@Length(min=0, max=50, message="机芯长度必须介于 0 和 50 之间")
	public String getJixin() {
		return jixin;
	}

	/**
     * 机芯
     */
	public void setJixin(String jixin) {
		this.jixin = jixin == null ? null : jixin.trim();
	}
	
	/**
     * jixing
     */
	@Length(min=0, max=50, message="jixing长度必须介于 0 和 50 之间")
	public String getJixing() {
		return jixing;
	}

	/**
     * jixing
     */
	public void setJixing(String jixing) {
		this.jixing = jixing == null ? null : jixing.trim();
	}
	
	/**
     * dw
     */
	@Length(min=0, max=20, message="dw长度必须介于 0 和 20 之间")
	public String getDw() {
		return dw;
	}

	/**
     * dw
     */
	public void setDw(String dw) {
		this.dw = dw == null ? null : dw.trim();
	}
	
	/**
     * dj
     */
	public BigDecimal getDj() {
		return dj;
	}

	/**
     * dj
     */
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public Integer getYzhsl() {
		return yzhsl;
	}

	public void setYzhsl(Integer yzhsl) {
		this.yzhsl = yzhsl;
	}

	public Integer getPisl() {
		return pisl;
	}

	public void setPisl(Integer pisl) {
		this.pisl = pisl;
	}

	public String getKs() {
		return ks;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKs(String ks) {
		this.ks = ks;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public Integer getSfBd() {
		return sfBd;
	}

	public void setSfBd(Integer sfBd) {
		this.sfBd = sfBd;
	}

	public Integer getYjsl() {
		return yjsl;
	}

	public void setYjsl(Integer yjsl) {
		this.yjsl = yjsl;
	}

	
	
}