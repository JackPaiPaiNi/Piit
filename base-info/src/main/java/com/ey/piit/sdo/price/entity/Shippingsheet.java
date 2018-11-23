package com.ey.piit.sdo.price.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 出货资料表主表Entity
 * 
 * @author 魏诚
 */
public class Shippingsheet extends BaseEntity {

	private String drdh; // 导入单号
	private Integer zt; // 状态
	private String sjc; // 时间戳
	private String zdrid; // 制单人
	private String zdrmc; // 制单人名称
	private Date zdsj; // 制单时间

	public Shippingsheet() {
		super();
	}

	public Shippingsheet(String id) {
		super(id);
	}

	/**
	 * 制单人
	 */
	@Length(min = 1, max = 20, message = "制单人长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
	 * 制单人
	 */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}

	/**
	 * 制单人名称
	 */
	@Length(min = 1, max = 50, message = "制单人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
	 * 制单人名称
	 */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}

	/**
	 * 制单时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "制单时间不能为空")
	public Date getZdsj() {
		return zdsj;
	}

	/**
	 * 制单时间
	 */
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	/**
	 * 状态
	 */
	@NotNull(message = "状态不能为空")
	public Integer getZt() {
		return zt;
	}

	/**
	 * 状态
	 */
	public void setZt(Integer zt) {
		this.zt = zt;
	}

	/**
	 * 时间戳
	 */
	@Length(min = 1, max = 20, message = "时间戳长度必须介于 1 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
	 * 时间戳
	 */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
	}

	public String getDrdh() {
		return drdh;
	}

	public void setDrdh(String drdh) {
		this.drdh = drdh;
	}

}