package com.ey.piit.sdo.report.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ReceivePaymentInvoice
 * @author 高文浩
 */
public class ReceivePaymentInvoice extends BaseEntity {
	
	private String rldh;	//认领单号
	private String skdh;	//收款单号 
	private String khbm;	//客户编码
	private String khmc;	//客户名称
	private String fph;		//发票号
	private BigDecimal fpzje;	//发票总金额
	private String fpbz;	//发票币种
	private String ddid;	//订单号
	private String chdh;	//出货单号
	private BigDecimal ddzje;	//订单总金额
	private BigDecimal ddkpje;	//订单开票金额
	private BigDecimal ddsykkpje;	//订单剩余可开票金额
	private BigDecimal hkje;	//回款金额
	private BigDecimal ddychwsk;	//订单已出货未收款金额
	private String fktj;	//付款条件
	private String fktjmc;	//付款条件名称
	private Integer zq;	//账期
	private Date fprq;	//发票日期
	private String fpdqr;	//发票到期日

	public ReceivePaymentInvoice() {
		super();
	}

	public ReceivePaymentInvoice(String id){
		super(id);
	}

	public String getFph() {
		return fph;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}

	public String getKhbm() {
		return khbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}

	public String getRldh() {
		return rldh;
	}

	public void setRldh(String rldh) {
		this.rldh = rldh;
	}

	public String getSkdh() {
		return skdh;
	}

	public void setSkdh(String skdh) {
		this.skdh = skdh;
	}

	public BigDecimal getFpzje() {
		return fpzje;
	}

	public void setFpzje(BigDecimal fpzje) {
		this.fpzje = fpzje;
	}

	public String getFpbz() {
		return fpbz;
	}

	public void setFpbz(String fpbz) {
		this.fpbz = fpbz;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public BigDecimal getDdzje() {
		return ddzje;
	}

	public void setDdzje(BigDecimal ddzje) {
		this.ddzje = ddzje;
	}

	public BigDecimal getDdkpje() {
		return ddkpje;
	}

	public void setDdkpje(BigDecimal ddkpje) {
		this.ddkpje = ddkpje;
	}

	public BigDecimal getDdsykkpje() {
		return ddsykkpje;
	}

	public void setDdsykkpje(BigDecimal ddsykkpje) {
		this.ddsykkpje = ddsykkpje;
	}

	public BigDecimal getHkje() {
		return hkje;
	}

	public void setHkje(BigDecimal hkje) {
		this.hkje = hkje;
	}

	public BigDecimal getDdychwsk() {
		return ddychwsk;
	}

	public void setDdychwsk(BigDecimal ddychwsk) {
		this.ddychwsk = ddychwsk;
	}

	public String getFktj() {
		return fktj;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}

	public Integer getZq() {
		return zq;
	}

	public void setZq(Integer zq) {
		this.zq = zq;
	}

	public String getFpdqr() {
		return fpdqr;
	}

	public void setFpdqr(String fpdqr) {
		this.fpdqr = fpdqr;
	}
	
}