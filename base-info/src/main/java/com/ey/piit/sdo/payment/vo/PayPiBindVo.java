package com.ey.piit.sdo.payment.vo;

import java.util.List;

import com.ey.piit.sdo.payment.entity.PayPiBind;
import com.google.common.collect.Lists;

public class PayPiBindVo extends PayPiBind {

	private Double tt_xdzb;//tt下单占比
	private Double tt_ckzb;//tt出库占比
	private Double tt_hxbdje;//tt还需绑定金额
	private Double tt_wsyje;//tt未使用金额
	private Double lc_zb;//lc占比
	private String lc_sfmzyq;//lc是否满足要求
	private Double oa_zb;//oa占比
	private Double dp_zb;//dp占总金额比例
	private Double lc_ysyje;//lc已使用金额
	private Double lc_hxbd;//lc还需绑定
	private Double lc_wsyje;//lc未使用金额
	private List<PayPiBindDetailVo> tt_xxlist = Lists.newArrayList();		// TT绑定
	private List<PayPiBindDetailVo> lc_xxlist = Lists.newArrayList();		// LC绑定
	
	public PayPiBindVo() {
		super();
	}

	public PayPiBindVo(String id){
		super(id);
	}
	
	public Double getTt_xdzb() {
		return tt_xdzb;
	}
	
	public void setTt_xdzb(Double tt_xdzb) {
		this.tt_xdzb = tt_xdzb;
	}
	
	public Double getTt_ckzb() {
		return tt_ckzb;
	}
	
	public void setTt_ckzb(Double tt_ckzb) {
		this.tt_ckzb = tt_ckzb;
	}
	
	public Double getTt_hxbdje() {
		return tt_hxbdje;
	}
	
	public void setTt_hxbdje(Double tt_hxbdje) {
		this.tt_hxbdje = tt_hxbdje;
	}
	
	public Double getTt_wsyje() {
		return tt_wsyje;
	}
	
	public void setTt_wsyje(Double tt_wsyje) {
		this.tt_wsyje = tt_wsyje;
	}
	
	public Double getLc_zb() {
		return lc_zb;
	}
	
	public void setLc_zb(Double lc_zb) {
		this.lc_zb = lc_zb;
	}
	
	public String getLc_sfmzyq() {
		return lc_sfmzyq;
	}
	
	public void setLc_sfmzyq(String lc_sfmzyq) {
		this.lc_sfmzyq = lc_sfmzyq;
	}
	
	public Double getOa_zb() {
		return oa_zb;
	}
	
	public void setOa_zb(Double oa_zb) {
		this.oa_zb = oa_zb;
	}
	
	public Double getDp_zb() {
		return dp_zb;
	}
	
	public void setDp_zb(Double dp_zb) {
		this.dp_zb = dp_zb;
	}
	
	public List<PayPiBindDetailVo> getTt_xxlist() {
		return tt_xxlist;
	}
	
	public List<PayPiBindDetailVo> getLc_xxlist() {
		return lc_xxlist;
	}
	
	public void setTt_xxlist(List<PayPiBindDetailVo> tt_xxlist) {
		this.tt_xxlist = tt_xxlist;
	}
	
	public void setLc_xxlist(List<PayPiBindDetailVo> lc_xxlist) {
		this.lc_xxlist = lc_xxlist;
	}

	public Double getLc_ysyje() {
		return lc_ysyje;
	}

	public void setLc_ysyje(Double lc_ysyje) {
		this.lc_ysyje = lc_ysyje;
	}

	public Double getLc_hxbd() {
		return lc_hxbd;
	}

	public void setLc_hxbd(Double lc_hxbd) {
		this.lc_hxbd = lc_hxbd;
	}

	public Double getLc_wsyje() {
		return lc_wsyje;
	}

	public void setLc_wsyje(Double lc_wsyje) {
		this.lc_wsyje = lc_wsyje;
	}
	
}
