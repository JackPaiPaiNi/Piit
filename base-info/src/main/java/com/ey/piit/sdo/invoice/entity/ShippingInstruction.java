package com.ey.piit.sdo.invoice.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 补料单信息维护Entity
 * @author 高文浩
 */
public class ShippingInstruction extends BaseEntity {
	
	private String bldh;		// 补料单号
	private String cdgs;		// 船代公司
	private String cdgslxr;		// 船代公司联系人
	private String cwzy;		// 船务专员
	private String cwzymc;		// 船务专员名称
	private String dh;		// 电话
	private String cz;		// 传真
	private String yx;		// 邮箱
	private String gsxx;		// 公司信息
	private String shrxx;		// 收货人信息
	private String tzrxx;		// 通知人信息
	private String qyg;		// 起运港
	private String xhg;		// 卸货港
	private String mdg;		// 目的港
	private String cmhchbh;		// 船名航次航班号
	private String wlms;		// 物料描述
	private String mytk;		// 贸易条款
	private String mtxx;		// 唛头信息
	private Date zdsj;			// 制单时间
	private String beginZdsj;
	private String endZdsj;
	private String chxx;	//出货信息
	
	public ShippingInstruction() {
		super();
	}

	public ShippingInstruction(String id){
		super(id);
	}

	/**
     * 补料单号
     */
	@Length(min=1, max=20, message="补料单号长度必须介于 1 和 20 之间")
	public String getBldh() {
		return bldh;
	}

	/**
     * 补料单号
     */
	public void setBldh(String bldh) {
		this.bldh = bldh == null ? null : bldh.trim();
	}
	
	/**
     * 船代公司
     */
	@Length(min=0, max=100, message="船代公司长度必须介于 0 和 100 之间")
	public String getCdgs() {
		return cdgs;
	}

	/**
     * 船代公司
     */
	public void setCdgs(String cdgs) {
		this.cdgs = cdgs == null ? null : cdgs.trim();
	}
	
	/**
     * 船代公司联系人
     */
	@Length(min=0, max=50, message="船代公司联系人长度必须介于 0 和 50 之间")
	public String getCdgslxr() {
		return cdgslxr;
	}

	/**
     * 船代公司联系人
     */
	public void setCdgslxr(String cdgslxr) {
		this.cdgslxr = cdgslxr == null ? null : cdgslxr.trim();
	}
	
	/**
     * 船务专员
     */
	@Length(min=0, max=20, message="船务专员长度必须介于 0 和 20 之间")
	public String getCwzy() {
		return cwzy;
	}

	/**
     * 船务专员
     */
	public void setCwzy(String cwzy) {
		this.cwzy = cwzy == null ? null : cwzy.trim();
	}
	
	/**
     * 船务专员名称
     */
	@Length(min=0, max=50, message="船务专员名称长度必须介于 0 和 50 之间")
	public String getCwzymc() {
		return cwzymc;
	}

	/**
     * 船务专员名称
     */
	public void setCwzymc(String cwzymc) {
		this.cwzymc = cwzymc == null ? null : cwzymc.trim();
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
     * 公司信息
     */
	public String getGsxx() {
		return gsxx;
	}

	/**
     * 公司信息
     */
	public void setGsxx(String gsxx) {
		this.gsxx = gsxx == null ? null : gsxx.trim();
	}
	
	/**
     * 收货人信息
     */
	public String getShrxx() {
		return shrxx;
	}

	/**
     * 收货人信息
     */
	public void setShrxx(String shrxx) {
		this.shrxx = shrxx == null ? null : shrxx.trim();
	}
	
	/**
     * 通知人信息
     */
	public String getTzrxx() {
		return tzrxx;
	}

	/**
     * 通知人信息
     */
	public void setTzrxx(String tzrxx) {
		this.tzrxx = tzrxx == null ? null : tzrxx.trim();
	}
	
	/**
     * 起运港
     */
	@Length(min=0, max=100, message="起运港长度必须介于 0 和 100 之间")
	public String getQyg() {
		return qyg;
	}

	/**
     * 起运港
     */
	public void setQyg(String qyg) {
		this.qyg = qyg == null ? null : qyg.trim();
	}
	
	/**
     * 卸货港
     */
	@Length(min=0, max=100, message="卸货港长度必须介于 0 和 100 之间")
	public String getXhg() {
		return xhg;
	}

	/**
     * 卸货港
     */
	public void setXhg(String xhg) {
		this.xhg = xhg == null ? null : xhg.trim();
	}
	
	/**
     * 目的港
     */
	@Length(min=0, max=100, message="目的港长度必须介于 0 和 100 之间")
	public String getMdg() {
		return mdg;
	}

	/**
     * 目的港
     */
	public void setMdg(String mdg) {
		this.mdg = mdg == null ? null : mdg.trim();
	}
	
	/**
     * 船名航次航班号
     */
	@Length(min=0, max=100, message="船名航次航班号长度必须介于 0 和 100 之间")
	public String getCmhchbh() {
		return cmhchbh;
	}

	/**
     * 船名航次航班号
     */
	public void setCmhchbh(String cmhchbh) {
		this.cmhchbh = cmhchbh == null ? null : cmhchbh.trim();
	}
	
	/**
     * 物料描述
     */
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
     * 贸易条款
     */
	public String getMytk() {
		return mytk;
	}

	/**
     * 贸易条款
     */
	public void setMytk(String mytk) {
		this.mytk = mytk == null ? null : mytk.trim();
	}
	
	/**
     * 唛头信息
     */
	@Length(min=0, max=100, message="唛头信息长度必须介于 0 和 100 之间")
	public String getMtxx() {
		return mtxx;
	}

	/**
     * 唛头信息
     */
	public void setMtxx(String mtxx) {
		this.mtxx = mtxx == null ? null : mtxx.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getBeginZdsj() {
		return beginZdsj;
	}

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	public String getChxx() {
		return chxx;
	}

	public void setChxx(String chxx) {
		this.chxx = chxx;
	}
	
}