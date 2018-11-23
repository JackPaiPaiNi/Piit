package com.ey.piit.sdo.payment.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

public class PayPiBind extends BaseEntity {
	
	private String piid;// piid号
	private String khbm;//客户编码
	private String khmc;//客户名称
	private String fktj;//付款条件
	private String fktjmc;//付款条件名称
	private BigDecimal zje;//总金额
	private String bz;//币种
	private BigDecimal tt_xdyq;//tt下单前要求金额
	private BigDecimal tt_ckyq;//tt出库前要求金额
	private BigDecimal tt_ybdje;//tt已绑定定金金额
	private BigDecimal tt_ysyje;//tt已使用金额
	private String tt_bz;//tt币种
	private BigDecimal lc_yq;//lc要求金额
	private BigDecimal lc_ybd;//lc已绑定金额
	private String lc_bz;//lc币种
	private BigDecimal oa_yq;//oa要求金额
	private BigDecimal dp_yq;//dp要求金额
	private String sjc; // 时间戳
	
	public PayPiBind() {
		super();
	}

	public PayPiBind(String id) {
		super(id);
	}
	
	public BigDecimal getOa_yq() {
		return oa_yq;
	}
	public BigDecimal getDp_yq() {
		return dp_yq;
	}
	public void setOa_yq(BigDecimal oa_yq) {
		this.oa_yq = oa_yq;
	}
	public void setDp_yq(BigDecimal dp_yq) {
		this.dp_yq = dp_yq;
	}
	public String getPiid() {
		return piid;
	}
	public String getKhbm() {
		return khbm;
	}
	public String getKhmc() {
		return khmc;
	}
	public String getFktj() {
		return fktj;
	}
	public String getFktjmc() {
		return fktjmc;
	}
	public BigDecimal getZje() {
		return zje;
	}
	public String getBz() {
		return bz;
	}
	public BigDecimal getTt_xdyq() {
		return tt_xdyq;
	}
	public BigDecimal getTt_ckyq() {
		return tt_ckyq;
	}
	public BigDecimal getTt_ybdje() {
		return tt_ybdje;
	}
	public BigDecimal getTt_ysyje() {
		return tt_ysyje;
	}
	public String getTt_bz() {
		return tt_bz;
	}
	public BigDecimal getLc_yq() {
		return lc_yq;
	}
	public BigDecimal getLc_ybd() {
		return lc_ybd;
	}
	public String getLc_bz() {
		return lc_bz;
	}
	public void setPiid(String piid) {
		this.piid = piid;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public void setFktj(String fktj) {
		this.fktj = fktj;
	}
	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}
	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public void setTt_xdyq(BigDecimal tt_xdyq) {
		this.tt_xdyq = tt_xdyq;
	}
	public void setTt_ckyq(BigDecimal tt_ckyq) {
		this.tt_ckyq = tt_ckyq;
	}
	public void setTt_ybdje(BigDecimal tt_ybdje) {
		this.tt_ybdje = tt_ybdje;
	}
	public void setTt_ysyje(BigDecimal tt_ysyje) {
		this.tt_ysyje = tt_ysyje;
	}
	public void setTt_bz(String tt_bz) {
		this.tt_bz = tt_bz;
	}
	public void setLc_yq(BigDecimal lc_yq) {
		this.lc_yq = lc_yq;
	}
	public void setLc_ybd(BigDecimal lc_ybd) {
		this.lc_ybd = lc_ybd;
	}
	public void setLc_bz(String lc_bz) {
		this.lc_bz = lc_bz;
	}

	/**
	 * 时间戳
	 */
	@Length(min = 1, max = 20, message = "时间戳长度必须介于 1 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
	 * 时间戳
	 */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
	}
}
