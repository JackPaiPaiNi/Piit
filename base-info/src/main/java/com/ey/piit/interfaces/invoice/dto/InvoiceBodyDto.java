package com.ey.piit.interfaces.invoice.dto;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 商业发票明细接口实体
 * @author tianrong
 *
 */
@XStreamAlias("ZROW")
public class InvoiceBodyDto {
	@XStreamAlias("DDH")
	private String ddh = "";//订单号
	@XStreamAlias("CHDH")
	private String chdh = "";//出货单号
	@XStreamAlias("JHDH")
	private String jhdh = "";//交货单号
	@XStreamAlias("SERINO")
	private String serino = "";//行项目序号（交货单）
	@XStreamAlias("DDXXMH")
	private String ddxxmh = "";//行项目序号（订单）
	@XStreamAlias("FPJE")
	private BigDecimal fpje = new BigDecimal(0);//订单开票金额（含备损）
	@XStreamAlias("XMLB")
	private String xmlb = "";//项目类别
	@XStreamAlias("WLBM")
	private String wlbm  = "";//物料编码
	@XStreamAlias("WLMS")
	private String wlms  = "";//描述
	@XStreamAlias("SL")
	private BigDecimal sl = new BigDecimal(0);//总数量
	@XStreamAlias("DW")
	private String dw  = "";//单位
	@XStreamAlias("DJ")
	private BigDecimal dj = new BigDecimal(0);//单价
	@XStreamAlias("JGDW")
	private String jgdw  = "";//价格单位
	/*@XStreamAlias("JE")
	private Double je =0.0;//金额
*/	
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getChdh() {
		return chdh;
	}
	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public String getWlbm() {
		return wlbm;
	}
	public void setWlbm(String wlbm) {
		this.wlbm = wlbm;
	}
	public String getWlms() {
		return wlms;
	}
	public void setWlms(String wlms) {
		this.wlms = wlms;
	}
	
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public BigDecimal getDj() {
		return dj;
	}
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	public String getJhdh() {
		return jhdh;
	}
	public void setJhdh(String jhdh) {
		this.jhdh = jhdh;
	}
	public String getSerino() {
		return serino;
	}
	public void setSerino(String serino) {
		this.serino = serino;
	}
	public String getDdxxmh() {
		return ddxxmh;
	}
	public void setDdxxmh(String ddxxmh) {
		this.ddxxmh = ddxxmh;
	}
	public BigDecimal getFpje() {
		return fpje;
	}
	public void setFpje(BigDecimal fpje) {
		this.fpje = fpje;
	}
	public String getXmlb() {
		return xmlb;
	}
	public void setXmlb(String xmlb) {
		this.xmlb = xmlb;
	}
	public String getJgdw() {
		return jgdw;
	}
	public void setJgdw(String jgdw) {
		this.jgdw = jgdw;
	}
	public BigDecimal getSl() {
		return sl;
	}
	public void setSl(BigDecimal sl) {
		this.sl = sl;
	}

	
	
}
