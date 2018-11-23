package com.ey.piit.interfaces.delivery.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 出货通知书通知书 接口传输实体 
 * 说明 ：请注意实体属性的顺序，不能随意调整，SAP解析报文依赖报文字段顺序
 * @author denghai
 *
 */
@XStreamAlias("HEAD")
public class DeliverHeaderDto {
	@XStreamAlias("UPDATE")
	private String update = "";//操作类型
	@XStreamAlias("CHDH")
	private String chdh = "";//出货单号
	@XStreamAlias("FHR")
	private String fhr = "";//发函人
	@XStreamAlias("XWGJ")
	private String xwgj = "";//销往国家
	@XStreamAlias("GSBM")
	private String gsbm = "";//公司编码
	@XStreamAlias("ZDRQ")
	private String zdrq = "";//制单日期
	@XStreamAlias("GSMC")
	private String gsmc = "";//公司名称
	@XStreamAlias("DCH")
	private String dch = "";//订舱号
	@XStreamAlias("FPH")
	private String fph = "";//发票号
	@XStreamAlias("BGFS")
	private String bgfsmc = "";//报关方式
	@XStreamAlias("ZYSGJ")
	private String cylxmc = "";//出运类型 运输工具

	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getChdh() {
		return chdh;
	}
	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	public String getFhr() {
		return fhr;
	}
	public void setFhr(String fhr) {
		this.fhr = fhr;
	}
	public String getXwgj() {
		return xwgj;
	}
	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}
	public String getGsbm() {
		return gsbm;
	}
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	public String getZdrq() {
		return zdrq;
	}
	public void setZdrq(String zdrq) {
		this.zdrq = zdrq;
	}
	public String getGsmc() {
		return gsmc;
	}
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}
	public String getDch() {
		return dch;
	}
	public void setDch(String dch) {
		this.dch = dch;
	}
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public String getBgfsmc() {
		return bgfsmc;
	}
	public void setBgfsmc(String bgfsmc) {
		this.bgfsmc = bgfsmc;
	}
	public String getCylxmc() {
		return cylxmc;
	}
	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc;
	}
	
	
	

}
