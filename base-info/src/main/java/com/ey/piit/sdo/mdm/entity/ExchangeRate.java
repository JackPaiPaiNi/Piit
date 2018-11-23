package com.ey.piit.sdo.mdm.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 汇率Entity
 * @author 赵桃军
 */
public class ExchangeRate extends BaseEntity {
	
	private Date yxqks;		// 有效期开始
	private Date yxqjs;		// 有效期结束
	private String cbz;		// 从币种
	private String dbz;		// 到币种
	private BigDecimal bl;		// 比例
	private String sjc;		// 时间戳
	
	public ExchangeRate() {
		super();
	}

	public ExchangeRate(String id){
		super(id);
	}

	/**
     * 有效期开始
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYxqks() {
		return yxqks;
	}

	/**
     * 有效期开始
     */
	public void setYxqks(Date yxqks) {
		this.yxqks = yxqks;
	}
	
	/**
     * 有效期结束
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYxqjs() {
		return yxqjs;
	}

	/**
     * 有效期结束
     */
	public void setYxqjs(Date yxqjs) {
		this.yxqjs = yxqjs;
	}
	
	/**
     * 从币种
     */
	@Length(min=0, max=20, message="从币种长度必须介于 0 和 20 之间")
	public String getCbz() {
		return cbz;
	}

	/**
     * 从币种
     */
	public void setCbz(String cbz) {
		this.cbz = cbz == null ? null : cbz.trim();
	}
	
	/**
     * 到币种
     */
	@Length(min=0, max=20, message="到币种长度必须介于 0 和 20 之间")
	public String getDbz() {
		return dbz;
	}

	/**
     * 到币种
     */
	public void setDbz(String dbz) {
		this.dbz = dbz == null ? null : dbz.trim();
	}
	
	
	public BigDecimal getBl() {
		return bl;
	}

	public void setBl(BigDecimal bl) {
		this.bl = bl;
	}

	/**
     * 时间戳
     */
	@Length(min=0, max=20, message="时间戳长度必须介于 0 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
     * 时间戳
     */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
	}
	
}