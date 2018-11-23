package com.ey.piit.sdo.price.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * SKD价格Entity
 * @author 邓海
 */
public class SkdPrice extends BaseEntity {
	
	private String wlbh;		// 物料编号
	private String wlms;		// 物料描述
	private String dw;		// 单位
	private String bz;		// 币种
	private Date yxqks;		// 有效期开始
	private Date yxqjs;		// 有效期结束
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private BigDecimal dj;	//单价
	
	
	public SkdPrice() {
		super();
	}

	public SkdPrice(String id){
		super(id);
	}

	

	/**
     * 有效期开始
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="有效期开始不能为空")
	public Date getYxqks() {
		return yxqks;
	}

	/**
     * 有效期开始
     */
	public void setYxqks(Date yxqks) {
		this.yxqks = yxqks;
	}
	
	/**
     * 有效期结束
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="有效期结束不能为空")
	public Date getYxqjs() {
		return yxqjs;
	}

	/**
     * 有效期结束
     */
	public void setYxqjs(Date yxqjs) {
		this.yxqjs = yxqjs;
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

	public String getWlbh() {
		return wlbh;
	}

	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}

	public String getWlms() {
		return wlms;
	}

	public void setWlms(String wlms) {
		this.wlms = wlms;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

}