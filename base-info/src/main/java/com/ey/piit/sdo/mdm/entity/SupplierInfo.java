package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 供应商信息维护Entity
 * @author 高文浩
 */
public class SupplierInfo extends BaseEntity {
	
	private String gysbm;		// 供应商编码
	private String gysmc;		// 供应商名称
	private String gysjc;		// 供应商简称
	private String gsbm;		// 公司编码
	private String dz;		// 地址
	private String bz;		// 币种
	private String dh;		// 电话
	private String wz;		// 网址
	private String lxr;		// 联系人
	private String sjh;		// 手机号
	private String yx;		// 邮箱
	private String bzxx;		// 备注
	private Integer zt;		// 状态
	
	public SupplierInfo() {
		super();
	}

	public SupplierInfo(String id){
		super(id);
	}

	/**
     * 供应商编码
     */
	@Length(min=1, max=20, message="供应商编码长度必须介于 1 和 20 之间")
	public String getGysbm() {
		return gysbm;
	}

	/**
     * 供应商编码
     */
	public void setGysbm(String gysbm) {
		this.gysbm = gysbm == null ? null : gysbm.trim();
	}
	
	/**
     * 供应商名称
     */
	@Length(min=0, max=100, message="供应商名称长度必须介于 0 和 100 之间")
	public String getGysmc() {
		return gysmc;
	}

	/**
     * 供应商名称
     */
	public void setGysmc(String gysmc) {
		this.gysmc = gysmc == null ? null : gysmc.trim();
	}
	
	/**
     * 供应商简称
     */
	@Length(min=0, max=50, message="供应商简称长度必须介于 0 和 50 之间")
	public String getGysjc() {
		return gysjc;
	}

	/**
     * 供应商简称
     */
	public void setGysjc(String gysjc) {
		this.gysjc = gysjc == null ? null : gysjc.trim();
	}
	
	/**
     * 公司编码
     */
	@Length(min=0, max=20, message="公司编码长度必须介于 0 和 20 之间")
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
     * 币种
     */
	@Length(min=0, max=20, message="币种长度必须介于 0 和 20 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 币种
     */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
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
     * 网址
     */
	@Length(min=0, max=50, message="网址长度必须介于 0 和 50 之间")
	public String getWz() {
		return wz;
	}

	/**
     * 网址
     */
	public void setWz(String wz) {
		this.wz = wz == null ? null : wz.trim();
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
     * 手机号
     */
	@Length(min=0, max=20, message="手机号长度必须介于 0 和 20 之间")
	public String getSjh() {
		return sjh;
	}

	/**
     * 手机号
     */
	public void setSjh(String sjh) {
		this.sjh = sjh == null ? null : sjh.trim();
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
     * 备注
     */
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
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
	
}