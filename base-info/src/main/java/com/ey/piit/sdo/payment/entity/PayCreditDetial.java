package com.ey.piit.sdo.payment.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 信用额度使用明细查询Entity
 * @author zhaotaojun
 */
public class PayCreditDetial extends BaseEntity {
	
	private String ddid;		// 订单号
	private String piid;		// PI号
	private String yzhdh;		// 预走货单号
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String fktj;		// 付款条件
	private String jd;		// 节点
	private String fklx;		// 付款类型
	private String lcKzh;		// LC开证行
	private String lcKzhmc;		// LC开证行名称
	private Double pije;		// PI金额
	private Double je;		// 金额
	private Double tpje;		// 特批金额
	private String bz;		// 币种
	private Date sj;		// 时间
	private String tpdh;		// 特批单号
	private String bzxx;		// 备注信息
	private String edbz;		// 额度币种
	private Double edje;		// 额度金额
	private Double ydEdHl;		// 原单到额度汇率
	
	public PayCreditDetial() {
		super();
	}

	public PayCreditDetial(String id){
		super(id);
	}

	/**
     * 订单号
     */
	@Length(min=0, max=20, message="订单号长度必须介于 0 和 20 之间")
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
     * PI号
     */
	@Length(min=0, max=20, message="PI号长度必须介于 0 和 20 之间")
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
     * 预走货单号
     */
	@Length(min=0, max=20, message="预走货单号长度必须介于 0 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	/**
     * 预走货单号
     */
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh == null ? null : yzhdh.trim();
	}
	
	/**
     * 客户编码
     */
	@Length(min=1, max=20, message="客户编码长度必须介于 1 和 20 之间")
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
     * 付款条件
     */
	@Length(min=0, max=100, message="付款条件长度必须介于 0 和 100 之间")
	public String getFktj() {
		return fktj;
	}

	/**
     * 付款条件
     */
	public void setFktj(String fktj) {
		this.fktj = fktj == null ? null : fktj.trim();
	}
	
	/**
     * 节点
     */
	@Length(min=0, max=50, message="节点长度必须介于 0 和 50 之间")
	public String getJd() {
		return jd;
	}

	/**
     * 节点
     */
	public void setJd(String jd) {
		this.jd = jd == null ? null : jd.trim();
	}
	
	/**
     * 付款类型
     */
	@Length(min=1, max=50, message="付款类型长度必须介于 1 和 50 之间")
	public String getFklx() {
		return fklx;
	}

	/**
     * 付款类型
     */
	public void setFklx(String fklx) {
		this.fklx = fklx == null ? null : fklx.trim();
	}
	
	/**
     * LC开证行
     */
	@Length(min=0, max=20, message="LC开证行长度必须介于 0 和 20 之间")
	public String getLcKzh() {
		return lcKzh;
	}

	/**
     * LC开证行
     */
	public void setLcKzh(String lcKzh) {
		this.lcKzh = lcKzh == null ? null : lcKzh.trim();
	}
	
	/**
     * LC开证行名称
     */
	@Length(min=0, max=500, message="LC开证行名称长度必须介于 0 和 500 之间")
	public String getLcKzhmc() {
		return lcKzhmc;
	}

	/**
     * LC开证行名称
     */
	public void setLcKzhmc(String lcKzhmc) {
		this.lcKzhmc = lcKzhmc == null ? null : lcKzhmc.trim();
	}
	
	/**
     * PI金额
     */
	public Double getPije() {
		return pije;
	}

	/**
     * PI金额
     */
	public void setPije(Double pije) {
		this.pije = pije;
	}
	
	/**
     * 金额
     */
	public Double getJe() {
		return je;
	}

	/**
     * 金额
     */
	public void setJe(Double je) {
		this.je = je;
	}
	
	/**
     * 特批金额
     */
	public Double getTpje() {
		return tpje;
	}

	/**
     * 特批金额
     */
	public void setTpje(Double tpje) {
		this.tpje = tpje;
	}
	
	/**
     * 币种
     */
	@Length(min=0, max=20, message="币种长度必须介于 0 和 20 之间")
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
     * 时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSj() {
		return sj;
	}

	/**
     * 时间
     */
	public void setSj(Date sj) {
		this.sj = sj;
	}
	
	/**
     * 特批单号
     */
	@Length(min=0, max=20, message="特批单号长度必须介于 0 和 20 之间")
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
     * 备注信息
     */
	@Length(min=0, max=200, message="备注信息长度必须介于 0 和 200 之间")
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
     * 额度币种
     */
	@Length(min=0, max=20, message="额度币种长度必须介于 0 和 20 之间")
	public String getEdbz() {
		return edbz;
	}

	/**
     * 额度币种
     */
	public void setEdbz(String edbz) {
		this.edbz = edbz == null ? null : edbz.trim();
	}
	
	/**
     * 额度金额
     */
	public Double getEdje() {
		return edje;
	}

	/**
     * 额度金额
     */
	public void setEdje(Double edje) {
		this.edje = edje;
	}
	
	/**
     * 原单到额度汇率
     */
	public Double getYdEdHl() {
		return ydEdHl;
	}

	/**
     * 原单到额度汇率
     */
	public void setYdEdHl(Double ydEdHl) {
		this.ydEdHl = ydEdHl;
	}
	
}