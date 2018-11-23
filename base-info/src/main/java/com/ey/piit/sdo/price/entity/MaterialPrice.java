package com.ey.piit.sdo.price.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 物料价格Entity
 * @author 高文浩
 */
public class MaterialPrice extends BaseEntity {
	
	private String wlbh;		// 物料编号
	private Double dj;		// 单价（RMB）
	private Double djUsd;		// 单价（USD）
	private Double djHkd;		// 单价（HKD）
	private Date gxsj;		// 更新时间
	private String sjc;		// 时间戳
	
	public MaterialPrice() {
		super();
	}

	public MaterialPrice(String id){
		super(id);
	}

	/**
     * 物料编号
     */
	@Length(min=1, max=50, message="物料编号长度必须介于 1 和 50 之间")
	public String getWlbh() {
		return wlbh;
	}

	/**
     * 物料编号
     */
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh == null ? null : wlbh.trim();
	}
	
	/**
     * 单价（RMB）
     */
	@NotNull(message="单价（RMB）不能为空")
	public Double getDj() {
		return dj;
	}

	/**
     * 单价（RMB）
     */
	public void setDj(Double dj) {
		this.dj = dj;
	}
	
	/**
     * 单价（USD）
     */
	public Double getDjUsd() {
		return djUsd;
	}

	/**
     * 单价（USD）
     */
	public void setDjUsd(Double djUsd) {
		this.djUsd = djUsd;
	}
	
	/**
     * 单价（HKD）
     */
	public Double getDjHkd() {
		return djHkd;
	}

	/**
     * 单价（HKD）
     */
	public void setDjHkd(Double djHkd) {
		this.djHkd = djHkd;
	}
	
	/**
     * 更新时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGxsj() {
		return gxsj;
	}

	/**
     * 更新时间
     */
	public void setGxsj(Date gxsj) {
		this.gxsj = gxsj;
	}
	
	/**
     * 时间戳
     */
	@Length(min=1, max=20, message="时间戳长度必须介于 1 和 20 之间")
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