package com.ey.piit.sdo.report.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PaymentReceive
 * @author 邓海
 */
public class PaymentReceive extends BaseEntity {
	
	private String fph;
	private Date fprq;
	private Date skrq;
	private String xsyid;
	private String xsymc;
	private String khbm;
	private String khmc;
	private String bz;
	private BigDecimal je;

	
	public PaymentReceive() {
		super();
	}

	public PaymentReceive(String id){
		super(id);
	}

	public String getFph() {
		return fph;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSkrq() {
		return skrq;
	}

	public void setSkrq(Date skrq) {
		this.skrq = skrq;
	}

	public String getXsyid() {
		return xsyid;
	}

	public void setXsyid(String xsyid) {
		this.xsyid = xsyid;
	}

	public String getXsymc() {
		return xsymc;
	}

	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
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

	public void setFph(String fph) {
		this.fph = fph;
	}

	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}

	
	
}