package com.ey.piit.sdo.track.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单生产要求维护Entity
 * @author 赵桃军
 */
public class TrackValidation extends BaseEntity {
	
	private String ddid;		// 订单号
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String  pid;		// PID
	private Date  ckzgsj;		// 出库装柜时间
	private Date  scjhwc;		// 生产计划完成确认时间
	private Date  scjhwcsj;		// 生产计划完成时间
	private Date rjqrsj;		// 软件确认时间
	private String rjzywtd;		// 软件主要问题点
	private String bzxx;		// 备注信息
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Date beginXd ;   //下单开始时间
	private Date endXd ;
	
	
	
	
	public Date getScjhwcsj() {
		return scjhwcsj;
	}

	public void setScjhwcsj(Date scjhwcsj) {
		this.scjhwcsj = scjhwcsj;
	}

	public Date getBeginXd() {
		return beginXd;
	}

	public void setBeginXd(Date beginXd) {
		this.beginXd = beginXd;
	}

	public Date getEndXd() {
		return endXd;
	}

	public void setEndXd(Date endXd) {
		this.endXd = endXd;
	}

	public TrackValidation() {
		super();
	}

	public TrackValidation(String id){
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
     * PID
     */
	@Length(min=0, max=50, message="PID长度必须介于 0 和 50 之间")
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
     * 出库装柜时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getCkzgsj() {
		return ckzgsj;
	}

	/**
     * 出库装柜时间
     */
	public void setCkzgsj(Date ckzgsj) {
		this.ckzgsj = ckzgsj;
	}
	
	/**
     * 生产计划完成时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScjhwc() {
		return scjhwc;
	}

	/**
     * 生产计划完成时间
     */
	public void setScjhwc(Date scjhwc) {
		this.scjhwc = scjhwc;
	}
	
	/**
     * 软件确认时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRjqrsj() {
		return rjqrsj;
	}

	/**
     * 软件确认时间
     */
	public void setRjqrsj(Date rjqrsj) {
		this.rjqrsj = rjqrsj;
	}
	
	/**
     * 软件主要问题点
     */
	@Length(min=0, max=200, message="软件主要问题点长度必须介于 0 和 200 之间")
	public String getRjzywtd() {
		return rjzywtd;
	}

	/**
     * 软件主要问题点
     */
	public void setRjzywtd(String rjzywtd) {
		this.rjzywtd = rjzywtd == null ? null : rjzywtd.trim();
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