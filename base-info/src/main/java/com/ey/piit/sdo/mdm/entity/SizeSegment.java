package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 尺寸段维护Entity
 * @author 赵桃军
 */
public class SizeSegment extends BaseEntity {
	
	private String ccdbh;		// 尺寸段
	private String ccdmc;		// 尺寸段名称
	private Double kscc;		// 开始尺寸
	private Double jscc;		// 结束尺寸
	
	public SizeSegment() {
		super();
	}

	public SizeSegment(String id){
		super(id);
	}

	/**
     * 尺寸段
     */
	@Length(min=1, max=20, message="尺寸段长度必须介于 1 和 20 之间")
	public String getCcdbh() {
		return ccdbh;
	}

	/**
     * 尺寸段
     */
	public void setCcdbh(String ccdbh) {
		this.ccdbh = ccdbh == null ? null : ccdbh.trim();
	}
	
	/**
     * 尺寸段名称
     */
	@Length(min=1, max=50, message="尺寸段名称长度必须介于 1 和 50 之间")
	public String getCcdmc() {
		return ccdmc;
	}

	/**
     * 尺寸段名称
     */
	public void setCcdmc(String ccdmc) {
		this.ccdmc = ccdmc == null ? null : ccdmc.trim();
	}
	
	/**
     * 开始尺寸
     */
	@NotNull(message="开始尺寸不能为空")
	public Double getKscc() {
		return kscc;
	}

	/**
     * 开始尺寸
     */
	public void setKscc(Double kscc) {
		this.kscc = kscc;
	}
	
	/**
     * 结束尺寸
     */
	@NotNull(message="结束尺寸不能为空")
	public Double getJscc() {
		return jscc;
	}

	/**
     * 结束尺寸
     */
	public void setJscc(Double jscc) {
		this.jscc = jscc;
	}
	
}