package com.ey.piit.sdo.fcst.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * FCST周次定义Entity
 * @author 高文浩
 */
public class FcstWeek extends BaseEntity {
	
	private String nf;		// 年份
	private String yf;		// 月份
	private String zc;		// 周次
	private String rq;		// 日期
	private Date ksrq;		// 开始日期
	private Date jsrq;		// 结束日期
	private Integer zt;		// 状态
	private Integer xh;		// 序号
	
	public FcstWeek() {
		super();
	}

	public FcstWeek(String id){
		super(id);
	}

	/**
     * 年份
     */
	@Length(min=1, max=4, message="年份长度必须介于 1 和 4 之间")
	public String getNf() {
		return nf;
	}

	/**
     * 年份
     */
	public void setNf(String nf) {
		this.nf = nf == null ? null : nf.trim();
	}
	
	/**
     * 月份
     */
	@Length(min=1, max=2, message="月份长度必须介于 1 和 2 之间")
	public String getYf() {
		return yf;
	}

	/**
     * 月份
     */
	public void setYf(String yf) {
		this.yf = yf == null ? null : yf.trim();
	}
	
	/**
     * 周次
     */
	@Length(min=1, max=5, message="周次长度必须介于 1 和 5 之间")
	public String getZc() {
		return zc;
	}

	/**
     * 周次
     */
	public void setZc(String zc) {
		this.zc = zc == null ? null : zc.trim();
	}
	
	/**
     * 开始日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="开始日期不能为空")
	public Date getKsrq() {
		return ksrq;
	}

	/**
     * 开始日期
     */
	public void setKsrq(Date ksrq) {
		this.ksrq = ksrq;
	}
	
	/**
     * 结束日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="结束日期不能为空")
	public Date getJsrq() {
		return jsrq;
	}

	/**
     * 结束日期
     */
	public void setJsrq(Date jsrq) {
		this.jsrq = jsrq;
	}
	
	/**
     * 状态
     */
	public Integer getZt() {
		return zt;
	}

	/**
     * 状态
     */
	public void setZt(Integer zt) {
		this.zt = zt;
	}
	
	/**
     * 序号
     */
	public Integer getXh() {
		return xh;
	}

	/**
     * 序号
     */
	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getRq() {
		return rq;
	}

	public void setRq(String rq) {
		this.rq = rq;
	}
	
}