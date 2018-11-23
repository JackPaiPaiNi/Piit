package com.ey.piit.sdo.track.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订单生产要求美工信息维护Entity
 * @author 赵桃军
 */
public class TrackValidationArt extends BaseEntity {
	
	private String ddid;		// 订单号
	private String mgzl;		// 美工资料
	private String qrfj;		// 确认附件
	private String bzxx;		// 备注
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Date beginXd ;   //下单开始时间
	private Date endXd ;
	
	
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

	public TrackValidationArt() {
		super();
	}

	public TrackValidationArt(String id){
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
     * 美工资料
     */
	@Length(min=1, max=50, message="美工资料长度必须介于 1 和 50 之间")
	public String getMgzl() {
		return mgzl;
	}

	/**
     * 美工资料
     */
	public void setMgzl(String mgzl) {
		this.mgzl = mgzl == null ? null : mgzl.trim();
	}
	
	/**
     * 确认附件
     */
	@Length(min=0, max=100, message="确认附件长度必须介于 0 和 100 之间")
	public String getQrfj() {
		return qrfj;
	}

	/**
     * 确认附件
     */
	public void setQrfj(String qrfj) {
		this.qrfj = qrfj == null ? null : qrfj.trim();
	}
	
	/**
     * 备注
     */
	@Length(min=0, max=200, message="备注长度必须介于 0 和 200 之间")
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