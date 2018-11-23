package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 船代公司信息维护Entity
 * @author 高文浩
 */
public class ShippingCompany extends BaseEntity {
	
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private String lxr;		// 联系人
	private String dh;		// 电话
	private String cz;		// 传真
	private String yb;		// 邮编
	private String yx;		// 邮箱
	private String dz;		// 地址
	private String bzxx;		// 备注信息
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Integer zt;		// 状态
	
	public ShippingCompany() {
		super();
	}

	public ShippingCompany(String id){
		super(id);
	}

	/**
     * 公司编码
     */
	@Length(min=1, max=20, message="公司编码长度必须介于 1 和 20 之间")
	public String getGsbm() {
		return gsbm;
	}

	/**
     * 公司编码
     */
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm == null ? null : gsbm.trim();
	}
	
	/**
     * 公司名称
     */
	@Length(min=0, max=100, message="公司名称长度必须介于 0 和 100 之间")
	public String getGsmc() {
		return gsmc;
	}

	/**
     * 公司名称
     */
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc == null ? null : gsmc.trim();
	}
	
	/**
     * 联系人
     */
	@Length(min=0, max=50, message="联系人长度必须介于 0 和 50 之间")
	public String getLxr() {
		return lxr;
	}

	/**
     * 联系人
     */
	public void setLxr(String lxr) {
		this.lxr = lxr == null ? null : lxr.trim();
	}
	
	/**
     * 电话
     */
	@Length(min=0, max=20, message="电话长度必须介于 0 和 20 之间")
	public String getDh() {
		return dh;
	}

	/**
     * 电话
     */
	public void setDh(String dh) {
		this.dh = dh == null ? null : dh.trim();
	}
	
	/**
     * 传真
     */
	@Length(min=0, max=20, message="传真长度必须介于 0 和 20 之间")
	public String getCz() {
		return cz;
	}

	/**
     * 传真
     */
	public void setCz(String cz) {
		this.cz = cz == null ? null : cz.trim();
	}
	
	/**
     * 邮编
     */
	@Length(min=0, max=20, message="邮编长度必须介于 0 和 20 之间")
	public String getYb() {
		return yb;
	}

	/**
     * 邮编
     */
	public void setYb(String yb) {
		this.yb = yb == null ? null : yb.trim();
	}
	
	/**
     * 邮箱
     */
	@Length(min=0, max=50, message="邮箱长度必须介于 0 和 50 之间")
	public String getYx() {
		return yx;
	}

	/**
     * 邮箱
     */
	public void setYx(String yx) {
		this.yx = yx == null ? null : yx.trim();
	}
	
	/**
     * 地址
     */
	@Length(min=0, max=100, message="地址长度必须介于 0 和 100 之间")
	public String getDz() {
		return dz;
	}

	/**
     * 地址
     */
	public void setDz(String dz) {
		this.dz = dz == null ? null : dz.trim();
	}
	
	/**
     * 备注信息
     */
	@Length(min=0, max=200, message="备注信息长度必须介于 0 和 200 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
     * 备注信息
     */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
	}
	
	/**
     * 制单人
     */
	@Length(min=0, max=20, message="制单人长度必须介于 0 和 20 之间")
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
	
}