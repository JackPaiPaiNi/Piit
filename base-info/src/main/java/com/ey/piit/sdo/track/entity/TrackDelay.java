package com.ey.piit.sdo.track.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订单延误原因维护Entity
 * @author 赵桃军
 */
public class TrackDelay extends BaseEntity {
	
	private String ddid;		// 订单号
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String ywjd;		// 延误节点
	private String ywjdmc;		// 延误节点名称
	private String ywyy;		// 延误原因
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	
	public TrackDelay() {
		super();
	}

	public TrackDelay(String id){
		super(id);
	}

	/**
     * 订单号
     */
	@Length(min=1, max=20, message="订单号长度必须介于 1 和 20 之间")
	public String getDdid() {
		return ddid;
	}

	/**
     * 订单号
     */
	public void setDdid(String ddid) {
		this.ddid = ddid == null ? null : ddid.trim();
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
	@Length(min=0, max=100, message="客户名称长度必须介于 0 和 100 之间")
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
     * 延误节点
     */
	@Length(min=1, max=20, message="延误节点长度必须介于 1 和 20 之间")
	public String getYwjd() {
		return ywjd;
	}

	/**
     * 延误节点
     */
	public void setYwjd(String ywjd) {
		this.ywjd = ywjd == null ? null : ywjd.trim();
	}
	
	/**
     * 延误节点名称
     */
	@Length(min=0, max=50, message="延误节点名称长度必须介于 0 和 50 之间")
	public String getYwjdmc() {
		return ywjdmc;
	}

	/**
     * 延误节点名称
     */
	public void setYwjdmc(String ywjdmc) {
		this.ywjdmc = ywjdmc == null ? null : ywjdmc.trim();
	}
	
	/**
     * 延误原因
     */
	@Length(min=0, max=200, message="延误原因长度必须介于 0 和 200 之间")
	public String getYwyy() {
		return ywyy;
	}

	/**
     * 延误原因
     */
	public void setYwyy(String ywyy) {
		this.ywyy = ywyy == null ? null : ywyy.trim();
	}
	
	/**
     * 制单人
     */
	@Length(min=1, max=20, message="制单人长度必须介于 1 和 20 之间")
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
	@Length(min=1, max=50, message="制单人名称长度必须介于 1 和 50 之间")
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
	@NotNull(message="制单时间不能为空")
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