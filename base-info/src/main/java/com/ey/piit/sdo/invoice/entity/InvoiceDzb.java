package com.ey.piit.sdo.invoice.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 发票对照表Entity
 * @author tiaorong
 */
public class InvoiceDzb extends BaseEntity {
	
	private String id;
	private String fph;//发票号
	private String chdh;//出货单号
	private String ddid;//订单id
	private String sapfph;//sap发票号
	private BigDecimal sapfpje;//sap发票金额
	private Integer sapfplx;//sap发票类型
	private Date zdsj;
	private String outXml;
	private String result;
	private String msg;
	private String sfCx;
	private String cxmsg;
	
	public InvoiceDzb() {
		super();
	}

	public InvoiceDzb(String id){
		super(id);
	}

	
	public String getCxmsg() {
		return cxmsg;
	}

	public void setCxmsg(String cxmsg) {
		this.cxmsg = cxmsg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getSapfph() {
		return sapfph;
	}

	public void setSapfph(String sapfph) {
		this.sapfph = sapfph;
	}

	public BigDecimal getSapfpje() {
		return sapfpje;
	}

	public void setSapfpje(BigDecimal sapfpje) {
		this.sapfpje = sapfpje;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSfCx() {
		return sfCx;
	}

	public void setSfCx(String sfCx) {
		this.sfCx = sfCx;
	}

	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getOutXml() {
		return outXml;
	}

	public void setOutXml(String outXml) {
		this.outXml = outXml;
	}

	public Integer getSapfplx() {
		return sapfplx;
	}

	public void setSapfplx(Integer sapfplx) {
		this.sapfplx = sapfplx;
	}

}