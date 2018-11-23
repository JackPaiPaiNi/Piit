package com.ey.piit.sdo.invoice.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.ey.piit.core.entity.BaseEntity;

/**
 * 发票明细信息维护Entity
 * @author tianrong
 */
public class InvoiceDetail extends BaseEntity {
	
	private String id;  //ID
	private String chdh;  //出货通知书单号
	private Date sjfhrq;  //实际发货日期
	private String ddid;  //订单号
	private String jhdh;  //交货单号
	private Integer serino;  //行项目号（交货单）
	private String fph;  //发票号
	private String wlbh;  //物料编号
	private BigDecimal jhsl;  //交货数量
	private String wldw;  //物料单位
	private String wlms;  //物料描述
	private String xmlb;  //项目类别
	private BigDecimal dj;  //销售单价
	private Integer jgdw;  //价格单位
	private String bz;  //币种
	private String sjc;  //时间戳
	private Integer ddxxmh;  //订单行项目号
	private BigDecimal je;  //金额
	private String model;//型号

	
	public InvoiceDetail() {
		super();
	}

	public InvoiceDetail(String id){
		super(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public BigDecimal getJhsl() {
		return jhsl;
	}

	public void setJhsl(BigDecimal jhsl) {
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

	public Integer getDdxxmh() {
		return ddxxmh;
	}

	public void setDdxxmh(Integer ddxxmh) {
		this.ddxxmh = ddxxmh;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
}