package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 国家时区关系管理Entity
 * @author 赵桃军
 */
public class CountryTimearea extends BaseEntity {
	
	private String gjdm;		// 国家代码
	private String sqmc;		// 时区名称
	private Long sdsq;		    // 是否首都时区：0否1是
	
	public CountryTimearea() {
		super();
	}

	public CountryTimearea(String id){
		super(id);
	}

	/**
     * 国家代码
     */
	@Length(min=0, max=50, message="国家代码长度必须介于 0 和 50 之间")
	public String getGjdm() {
		return gjdm;
	}

	/**
     * 国家代码
     */
	public void setGjdm(String gjdm) {
		this.gjdm = gjdm == null ? null : gjdm.trim();
	}
	
	
	/**
     * 时区名称
     */
	@Length(min=0, max=50, message="时区名称长度必须介于 0 和 50 之间")
	public String getSqmc() {
		return sqmc;
	}

	/**
     * 时区名称
     */
	public void setSqmc(String sqmc) {
		this.sqmc = sqmc == null ? null : sqmc.trim();
	}
	
	/**
     * 是否首都时区：0否1是
     */
	public Long getSdsq() {
		return sdsq;
	}

	/**
     * 是否首都时区：0否1是
     */
	public void setSdsq(Long sdsq) {
		this.sdsq = sdsq;
	}
	
}