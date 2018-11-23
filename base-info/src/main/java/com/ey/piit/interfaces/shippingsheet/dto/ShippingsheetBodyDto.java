package com.ey.piit.interfaces.shippingsheet.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 出货资料表接口实体
 * 说明 ：请注意实体属性的顺序，不能随意调整，SAP解析报文依赖报文字段顺序
 * @author 魏诚
 *
 */
@XStreamAlias("ROW")
public class ShippingsheetBodyDto {
	
	@XStreamAlias("MATNR")
	private String matnr = "";//物料编号
	@XStreamAlias("VBELN")
	private String vbeln = "";//订单号
	@XStreamAlias("PRICE")
	private String price = "";//申报单价
	@XStreamAlias("WAERS")
	private String waers = "";//币别
	@XStreamAlias("MEINS")
	private String meins = "";//单位
	@XStreamAlias("ZNOTE")
	private String znote = "";//标识（D：删除 M：修改或者新增）
	
	
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public String getVbeln() {
		return vbeln;
	}
	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWaers() {
		return waers;
	}
	public void setWaers(String waers) {
		this.waers = waers;
	}
	public String getMeins() {
		return meins;
	}
	public void setMeins(String meins) {
		this.meins = meins;
	}
	public String getZnote() {
		return znote;
	}
	public void setZnote(String znote) {
		this.znote = znote;
	}

}
