package com.ey.piit.sdo.payment.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 特批查询Entity
 * @author 田荣
 */
public class PaySpecial extends BaseEntity {
	
	private String tpdh;		// 特批单号
	private String dh;			// 单号
	private String djlx;		// 订单类型
	private String djlxmc;		// 订单类型名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String tpjd;		// 特批节点
	private String tpjdmc;		// 特批节点名称
	private String tplb;		// 特批类别
	private String tplbmc;		// 特批类别名称
	private Date tpsj;		// 特批时间
	private String bzxx;		// 备注信息
	private String fj;		// 附件
	private Integer sfYsy;		// 是否已使用
	private Integer sfYxc;		// 是否已消除
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Integer sfYsc;	// 是否已删除
	private String sjc;		// 时间戳
	
	public PaySpecial() {
		super();
	}

	public PaySpecial(String id){
		super(id);
	}

	/**
     * 特批单号
     */
	@Length(min=1, max=20, message="特批单号长度必须介于 1 和 20 之间")
	public String getTpdh() {
		return tpdh;
	}

	/**
     * 特批单号
     */
	public void setTpdh(String tpdh) {
		this.tpdh = tpdh == null ? null : tpdh.trim();
	}
	
	/**
     * 客户编码
     */
	public String getKhbm() {
		return khbm;
	}

	/**
     * 客户编码
     */
	public void setKhbm(String khbm) {
		this.khbm = khbm == null ? null : khbm.trim();
	}
	
	/**
     * 客户名称
     */
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
     * 特批节点
     */
	@Length(min=0, max=50, message="特批节点长度必须介于 0 和 50 之间")
	public String getTpjd() {
		return tpjd;
	}

	/**
     * 特批节点
     */
	public void setTpjd(String tpjd) {
		this.tpjd = tpjd == null ? null : tpjd.trim();
	}
	
	/**
     * 特批节点名称
     */
	@Length(min=0, max=50, message="特批节点名称长度必须介于 0 和 50 之间")
	public String getTpjdmc() {
		return tpjdmc;
	}

	/**
     * 特批节点名称
     */
	public void setTpjdmc(String tpjdmc) {
		this.tpjdmc = tpjdmc == null ? null : tpjdmc.trim();
	}
	
	/**
     * 特批类别
     */
	@Length(min=1, max=50, message="特批类别长度必须介于 1 和 50 之间")
	public String getTplb() {
		return tplb;
	}

	/**
     * 特批类别
     */
	public void setTplb(String tplb) {
		this.tplb = tplb == null ? null : tplb.trim();
	}
	
	/**
     * 特批类别名称
     */
	@Length(min=0, max=50, message="特批类别名称长度必须介于 0 和 50 之间")
	public String getTplbmc() {
		return tplbmc;
	}

	/**
     * 特批类别名称
     */
	public void setTplbmc(String tplbmc) {
		this.tplbmc = tplbmc == null ? null : tplbmc.trim();
	}
	
	/**
     * 特批时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTpsj() {
		return tpsj;
	}

	/**
     * 特批时间
     */
	public void setTpsj(Date tpsj) {
		this.tpsj = tpsj;
	}
	
	/**
     * 备注信息
     */
	public String getBzxx() {
		return bzxx;
	}

	/**
     * 备注信息
     */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
	}
	
	/**
     * 附件
     */
	public String getFj() {
		return fj;
	}

	/**
     * 附件
     */
	public void setFj(String fj) {
		this.fj = fj == null ? null : fj.trim();
	}
	
	/**
     * 是否已使用
     */
	public Integer getSfYsy() {
		return sfYsy;
	}

	/**
     * 是否已使用
     */
	public void setSfYsy(Integer sfYsy) {
		this.sfYsy = sfYsy;
	}
	
	/**
     * 是否已消除
     */
	public Integer getSfYxc() {
		return sfYxc;
	}

	/**
     * 是否已消除
     */
	public void setSfYxc(Integer sfYxc) {
		this.sfYxc = sfYxc;
	}
	
	/**
     * 制单人
     */
	@Length(min=1, max=20, message="制单人长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * 制单人
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * 制单人名称
     */
	@Length(min=1, max=50, message="制单人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * 制单人名称
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}
	
	/**
     * 制单时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZdsj() {
		return zdsj;
	}

	/**
     * 制单时间
     */
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public Integer getSfYsc() {
		return sfYsc;
	}

	public void setSfYsc(Integer sfYsc) {
		this.sfYsc = sfYsc;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}

	public String getDh() {
		return dh;
	}

	public String getDjlx() {
		return djlx;
	}

	public String getDjlxmc() {
		return djlxmc;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public void setDjlx(String djlx) {
		this.djlx = djlx;
	}

	public void setDjlxmc(String djlxmc) {
		this.djlxmc = djlxmc;
	}

}