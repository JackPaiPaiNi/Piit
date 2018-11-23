package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 客户分类管理Entity
 * @author 魏诚
 */
public class CustomerType extends BaseEntity {
	
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String khfl;		// 客户分类
	private String khflmc;		// 客户分类名称
	private String bzxx;		// 备注
	private Integer zt;		// 状态
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	
	public CustomerType() {
		super();
	}

	public CustomerType(String id){
		super(id);
	}

	/**
     * 客户编码
     */
	@Length(min=1, max=20, message="客户编码长度必须介于 1 和 20 之间")
	public String getKhbm() {
		return khbm;
	}

	/**
     * 客户编码
     */
	public void setKhbm(String khbm) {
		this.khbm = khbm == null ? null : khbm.trim();
	}
	
	/**
     * 客户名称
     */
	@Length(min=0, max=500, message="客户名称长度必须介于 0 和 500 之间")
	public String getKhmc() {
		return khmc;
	}

	/**
     * 客户名称
     */
	public void setKhmc(String khmc) {
		this.khmc = khmc == null ? null : khmc.trim();
	}
	
	/**
     * 客户分类
     */
	@Length(min=1, max=20, message="客户分类长度必须介于 1 和 20 之间")
	public String getKhfl() {
		return khfl;
	}

	/**
     * 客户分类
     */
	public void setKhfl(String khfl) {
		this.khfl = khfl == null ? null : khfl.trim();
	}
	
	/**
     * 客户分类名称
     */
	@Length(min=0, max=50, message="客户分类名称长度必须介于 0 和 50 之间")
	public String getKhflmc() {
		return khflmc;
	}

	/**
     * 客户分类名称
     */
	public void setKhflmc(String khflmc) {
		this.khflmc = khflmc == null ? null : khflmc.trim();
	}
	
	/**
     * 备注
     */
	@Length(min=0, max=500, message="备注长度必须介于 0 和 500 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
     * 备注
     */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
	}
	
	/**
     * 状态
     */
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
     * 制单人
     */
	@Length(min=0, max=50, message="制单人长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="制单人名称长度必须介于 0 和 50 之间")
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
	public Date getZdsj() {
		return zdsj;
	}

	/**
     * 制单时间
     */
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	
}