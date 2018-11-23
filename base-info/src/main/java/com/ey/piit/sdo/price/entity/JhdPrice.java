package com.ey.piit.sdo.price.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


public class JhdPrice  extends BaseEntity{
	
	private String chdh;//出货通知书单号
	private Date sjfhrq;//实际发货日期
	private String ddid;//订单号
	private String jhdh;//交货单号
	private Integer serino;//行项目号（交货单）
	private String fph;//发票号
	private String wlbh;//物料编号
	private Double jhsl;//交货数量
	private String wldw;//物料单位
	private String wlms;//物料描述
	private String xmlb;//项目类别
	private BigDecimal dj;//销售单价
	private Integer jgdw;//价格单位
	private String bz;//币种
	private Date zdsj;//制单时间
	private String sjc;//时间戳
	private String ddxxmh;//订单行项目号
	private Integer scbj;//删除标记 1已删除 null未删除
	private BigDecimal ddhjje;//开票订单合计金额

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	public String getChdh() {
		return chdh;
	}
	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	public Date getSjfhrq() {
		return sjfhrq;
	}
	public void setSjfhrq(Date sjfhrq) {
		this.sjfhrq = sjfhrq;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
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
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public String getWlbh() {
		return wlbh;
	}
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}
	public Double getJhsl() {
		return jhsl;
	}
	public void setJhsl(Double jhsl) {
		this.jhsl = jhsl;
	}
	public String getWldw() {
		return wldw;
	}
	public void setWldw(String wldw) {
		this.wldw = wldw;
	}
	public String getWlms() {
		return wlms;
	}
	public void setWlms(String wlms) {
		this.wlms = wlms;
	}
	public String getXmlb() {
		return xmlb;
	}
	public void setXmlb(String xmlb) {
		this.xmlb = xmlb;
	}
	public BigDecimal getDj() {
		return dj;
	}
	public void setDj(BigDecimal dj) {
		this.dj = dj;
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
	public String getSjc() {
		return sjc;
	}
	public void setSjc(String sjc) {
		this.sjc = sjc;
	}
	public String getDdxxmh() {
		return ddxxmh;
	}
	public void setDdxxmh(String ddxxmh) {
		this.ddxxmh = ddxxmh;
	}
	public Integer getScbj() {
		return scbj;
	}
	public void setScbj(Integer scbj) {
		this.scbj = scbj;
	}
	public BigDecimal getDdhjje() {
		return ddhjje;
	}
	public void setDdhjje(BigDecimal ddhjje) {
		this.ddhjje = ddhjje;
	}
	


}
