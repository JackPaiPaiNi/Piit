package com.ey.piit.sdo.price.entity;

import java.math.BigDecimal;

import com.ey.piit.core.entity.BaseEntity;

/**
 * SKD调价单明细实体
 * @author 邓海
 */
public class SkdPriceAdjustItem extends BaseEntity {

	private String tjdid;//调价单号
	private String xmlb;//项目类别
	private String jhdh;//交货单号
	private Integer serino;//行项目号（交货单）
	private String wlbh;//物料编号
	private String wlms;//物料描述
	private String wldw;//物料单位
	private BigDecimal dj;//单价
	private BigDecimal tzdj;//调整单价
	private Double sl;//数量
	private Double jhsl;//数量
	private BigDecimal je;//金额
	private BigDecimal tzje;//调整金额
	private Integer jgdw;//价格单位
	private String bz;//币种


	public SkdPriceAdjustItem() {
		super();
	}

	public SkdPriceAdjustItem(String id){
		super(id);
	}

	public String getTjdid() {
		return tjdid;
	}

	public void setTjdid(String tjdid) {
		this.tjdid = tjdid;
	}

	public String getXmlb() {
		return xmlb;
	}

	public void setXmlb(String xmlb) {
		this.xmlb = xmlb;
	}

	public String getJhdh() {
		return jhdh;
	}

	public void setJhdh(String jhdh) {
		this.jhdh = jhdh;
	}

	public Integer getSerino() {
		return serino;
	}

	public void setSerino(Integer serino) {
		this.serino = serino;
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

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getTzdj() {
		return tzdj;
	}

	public void setTzdj(BigDecimal tzdj) {
		this.tzdj = tzdj;
	}

	public Double getSl() {
		return sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public BigDecimal getTzje() {
		return tzje;
	}

	public void setTzje(BigDecimal tzje) {
		this.tzje = tzje;
	}

	public Integer getJgdw() {
		return jgdw;
	}

	public void setJgdw(Integer jgdw) {
		this.jgdw = jgdw;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getWldw() {
		return wldw;
	}

	public void setWldw(String wldw) {
		this.wldw = wldw;
	}

	public Double getJhsl() {
		return jhsl;
	}

	public void setJhsl(Double jhsl) {
		this.jhsl = jhsl;
	}

}