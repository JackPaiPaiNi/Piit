package com.ey.piit.sdo.mdm.entity;





import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 银行信息维护Entity
 * @author 赵桃军
 */
public class Bank extends BaseEntity {
	private String zwmc;		// 中文名称
	private String ywmc;		// 英文名称
	private String zwdz;		// 中文地址
	private String ywdz;		// 英文地址
	private String swiftdm;		// SWIFT代码
	private Integer sfKhkzh;		// 银行类型
	private String bzxx;		// 备注
	
	public Bank() {
		super();
	}

	public Bank(String id){
		super(id);
	}

	
	/**
     * 中文名称
     */
	@Length(min=0, max=100, message="中文名称长度必须介于 0 和 100 之间")
	public String getZwmc() {
		return zwmc;
	}

	/**
     * 中文名称
     */
	public void setZwmc(String zwmc) {
		this.zwmc = zwmc == null ? null : zwmc.trim();
	}
	
	/**
     * 英文名称
     */
	@Length(min=0, max=100, message="英文名称长度必须介于 0 和 100 之间")
	public String getYwmc() {
		return ywmc;
	}

	/**
     * 英文名称
     */
	public void setYwmc(String ywmc) {
		this.ywmc = ywmc == null ? null : ywmc.trim();
	}
	
	/**
     * 中文地址
     */
	@Length(min=0, max=100, message="中文地址长度必须介于 0 和 100 之间")
	public String getZwdz() {
		return zwdz;
	}

	/**
     * 中文地址
     */
	public void setZwdz(String zwdz) {
		this.zwdz = zwdz == null ? null : zwdz.trim();
	}
	
	/**
     * 英文地址
     */
	@Length(min=0, max=100, message="英文地址长度必须介于 0 和 100 之间")
	public String getYwdz() {
		return ywdz;
	}

	/**
     * 英文地址
     */
	public void setYwdz(String ywdz) {
		this.ywdz = ywdz == null ? null : ywdz.trim();
	}
	
	/**
     * SWIFT代码
     */
	@Length(min=0, max=20, message="SWIFT代码长度必须介于 0 和 20 之间")
	public String getSwiftdm() {
		return swiftdm;
	}

	/**
     * SWIFT代码
     */
	public void setSwiftdm(String swiftdm) {
		this.swiftdm = swiftdm == null ? null : swiftdm.trim();
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
    * 是否客户开证行
    * @return
    */
	public Integer getSfKhkzh() {
		return sfKhkzh;
	}
	
	public void setSfKhkzh(Integer sfKhkzh) {
		this.sfKhkzh = sfKhkzh;
	}
	

	
}