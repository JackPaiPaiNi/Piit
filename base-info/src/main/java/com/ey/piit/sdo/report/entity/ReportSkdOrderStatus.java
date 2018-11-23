package com.ey.piit.sdo.report.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 欧洲供应链SKD订单状态表Entity
 * @author 魏诚
 */
public class ReportSkdOrderStatus extends BaseEntity {
	
	private String ddid;		// 订单号
	private String chdh;		// 出货单号
	private Integer hsztsl;		// 海上在途数量
	private Integer wlddblgcsl;		// 物料到达波兰工厂数量
	private Integer skddscsl;		// skd待生产数量
	private Integer zjdchsl;		// 整机待出货数量
	private Integer zjblpsl;		// 整机不良品数量
	private Integer wztsl;		// 无状态数量
	private Integer chsl;		// 出货数量
	private Date blgcchrq;		// 波兰工厂出货日期
	private String bcchkhmc;		// 本次出货客户名
	private String bzxx;		// 备注
	
	public ReportSkdOrderStatus() {
		super();
	}

	public ReportSkdOrderStatus(String id){
		super(id);
	}

	/**
     * 订单号
     */
	@Length(min=0, max=50, message="订单号长度必须介于 0 和 50 之间")
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
     * 出货单号
     */
	@Length(min=0, max=50, message="出货单号长度必须介于 0 和 50 之间")
	public String getChdh() {
		return chdh;
	}

	/**
     * 出货单号
     */
	public void setChdh(String chdh) {
		this.chdh = chdh == null ? null : chdh.trim();
	}
	
	/**
     * 海上在途数量
     */
	public Integer getHsztsl() {
		return hsztsl;
	}

	/**
     * 海上在途数量
     */
	public void setHsztsl(Integer hsztsl) {
		this.hsztsl = hsztsl;
	}
	
	/**
     * 物料到达波兰工厂数量
     */
	public Integer getWlddblgcsl() {
		return wlddblgcsl;
	}

	/**
     * 物料到达波兰工厂数量
     */
	public void setWlddblgcsl(Integer wlddblgcsl) {
		this.wlddblgcsl = wlddblgcsl;
	}
	
	/**
     * skd待生产数量
     */
	public Integer getSkddscsl() {
		return skddscsl;
	}

	/**
     * skd待生产数量
     */
	public void setSkddscsl(Integer skddscsl) {
		this.skddscsl = skddscsl;
	}
	
	/**
     * 整机待出货数量
     */
	public Integer getZjdchsl() {
		return zjdchsl;
	}

	/**
     * 整机待出货数量
     */
	public void setZjdchsl(Integer zjdchsl) {
		this.zjdchsl = zjdchsl;
	}
	
	/**
     * 整机不良品数量
     */
	public Integer getZjblpsl() {
		return zjblpsl;
	}

	/**
     * 整机不良品数量
     */
	public void setZjblpsl(Integer zjblpsl) {
		this.zjblpsl = zjblpsl;
	}
	
	/**
     * 无状态数量
     */
	public Integer getWztsl() {
		return wztsl;
	}

	/**
     * 无状态数量
     */
	public void setWztsl(Integer wztsl) {
		this.wztsl = wztsl;
	}
	
	/**
     * 出货数量
     */
	public Integer getChsl() {
		return chsl;
	}

	/**
     * 出货数量
     */
	public void setChsl(Integer chsl) {
		this.chsl = chsl;
	}
	
	/**
     * 波兰工厂出货日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBlgcchrq() {
		return blgcchrq;
	}

	/**
     * 波兰工厂出货日期
     */
	public void setBlgcchrq(Date blgcchrq) {
		this.blgcchrq = blgcchrq;
	}
	
	/**
     * 本次出货客户名
     */
	@Length(min=0, max=500, message="本次出货客户名长度必须介于 0 和 500 之间")
	public String getBcchkhmc() {
		return bcchkhmc;
	}

	/**
     * 本次出货客户名
     */
	public void setBcchkhmc(String bcchkhmc) {
		this.bcchkhmc = bcchkhmc == null ? null : bcchkhmc.trim();
	}
	
	/**
     * 备注
     */
	@Length(min=0, max=2000, message="备注长度必须介于 0 和 2000 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
     * 备注
     */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
	}
	
}