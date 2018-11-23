package com.ey.piit.sdo.deliver.entity;

import java.math.BigDecimal;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 出货通知书展会样机Entity
 * @author 邓海
 */
public class DeliverExhibition extends BaseEntity {
	
	private String yzhdh;		// 预走货单号 父类
	private Integer bbh;		// 版本号
	private String spmc;		// 商品名称
	private String yjly;		// 样机来源
	private String jixing;		// 机型
	private Integer sl;		// 数量
	private String bz;		// 币种
	private BigDecimal je;		// 金额
	private BigDecimal dj;		// 单价
	private String bzxx;		//备注信息
	public String getYzhdh() {
		return yzhdh;
	}
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	public Integer getBbh() {
		return bbh;
	}
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	public String getSpmc() {
		return spmc;
	}
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	public String getYjly() {
		return yjly;
	}
	public void setYjly(String yjly) {
		this.yjly = yjly;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public Integer getSl() {
		return sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public BigDecimal getJe() {
		return je;
	}
	public void setJe(BigDecimal je) {
		this.je = je;
	}
	public BigDecimal getDj() {
		return dj;
	}
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	public String getBzxx() {
		return bzxx;
	}
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}
	
}