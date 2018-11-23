package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 产品研发BOM查看Entity
 * @author 赵桃军
 */
public class ProductBom extends BaseEntity {
	
	private String pid;		// PID
	private String wlbm;		// 物料编码
	private String wlms;		// 物料描述
	private Double djyl;		// 单机用量
	private String dw;		// 单位
	
	public ProductBom() {
		super();
	}

	public ProductBom(String id){
		super(id);
	}

	/**
     * PID
     */
	@Length(min=1, max=50, message="PID长度必须介于 1 和 50 之间")
	public String getPid() {
		return pid;
	}

	/**
     * PID
     */
	public void setPid(String pid) {
		this.pid = pid == null ? null : pid.trim();
	}
	
	/**
     * 物料编码
     */
	@Length(min=1, max=50, message="物料编码长度必须介于 1 和 50 之间")
	public String getWlbm() {
		return wlbm;
	}

	/**
     * 物料编码
     */
	public void setWlbm(String wlbm) {
		this.wlbm = wlbm == null ? null : wlbm.trim();
	}
	
	/**
     * 物料描述
     */
	@Length(min=0, max=100, message="物料描述长度必须介于 0 和 100 之间")
	public String getWlms() {
		return wlms;
	}

	/**
     * 物料描述
     */
	public void setWlms(String wlms) {
		this.wlms = wlms == null ? null : wlms.trim();
	}
	
	/**
     * 单机用量
     */
	@NotNull(message="单机用量不能为空")
	public Double getDjyl() {
		return djyl;
	}

	/**
     * 单机用量
     */
	public void setDjyl(Double djyl) {
		this.djyl = djyl;
	}
	
	/**
     * 单位
     */
	@Length(min=1, max=20, message="单位长度必须介于 1 和 20 之间")
	public String getDw() {
		return dw;
	}

	/**
     * 单位
     */
	public void setDw(String dw) {
		this.dw = dw == null ? null : dw.trim();
	}
	
}