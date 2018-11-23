package com.ey.piit.sdo.project.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 系统问题管理Entity
 * 
 * @author 赵桃军
 */
public class ProjectBug extends BaseEntity {

	private String xmjd; // 项目阶段（单元测试,集成测试,试运行,运维期）
	private String cdbm; // 菜单编码
	private String cdmc; // 菜单名称
	private String wtms; // 问题描述
	private String tcbm; // 提出部门
	private String tcbmmc; // 提出部门名称
	private String tcr; // 提出人
	private String tcrmc; // 提出人名称
	private Date tcsj; // 提出时间
	private Integer yxj; // 优先级（1:低;2:中,3:高,4:最高）
	private String clr; // 处理人
	private String clrmc; // 处理人名称
	private Integer zt; // 状态 1:草稿,2:审批中,3:驳回,4:审核通过（未分派）,5:处理中（已分派）,6:已处理,7:关闭
	private String clsm; // 处理说明
	private Date sjclsj; // 实际处理时间（对应已处理时间）
	private Integer wtfl; // 问题分类(1:程序BUG类,2:需求优化类,3:新需求类,4:权限类,5:数据类)
	private Date rwfpsj; // 任务分派时间
	private Date gbsj; // 关闭时间
	private Date yjclsj; // 预计处理时间
	private Date yqclsj; // 要求处理时间
	private String wtdh; // 问题单号
	private String xmjdmc; // 项目阶段名称
	private String yxjmc; // 优先级名称
	private String ztmc; // 状态名称
	private String wtflmc; // 问题分类名称

	public ProjectBug() {
		super();
	}

	public ProjectBug(String id) {
		super(id);
	}

	public String getXmjdmc() {
		return xmjdmc;
	}

	public void setXmjdmc(String xmjdmc) {
		this.xmjdmc = xmjdmc;
	}

	public String getYxjmc() {
		return yxjmc;
	}

	public void setYxjmc(String yxjmc) {
		this.yxjmc = yxjmc;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getWtflmc() {
		return wtflmc;
	}

	public void setWtflmc(String wtflmc) {
		this.wtflmc = wtflmc;
	}

	/**
	 * 项目阶段（单元测试,集成测试,试运行,运维期）
	 */
	@Length(min = 0, max = 50, message = "项目阶段（单元测试,集成测试,试运行,运维期）长度必须介于 0 和 50 之间")
	public String getXmjd() {
		return xmjd;
	}

	/**
	 * 项目阶段（单元测试,集成测试,试运行,运维期）
	 */
	public void setXmjd(String xmjd) {
		this.xmjd = xmjd == null ? null : xmjd.trim();
	}

	/**
	 * 菜单编码
	 */
	@Length(min = 0, max = 50, message = "菜单编码长度必须介于 0 和 50 之间")
	public String getCdbm() {
		return cdbm;
	}

	/**
	 * 菜单编码
	 */
	public void setCdbm(String cdbm) {
		this.cdbm = cdbm == null ? null : cdbm.trim();
	}

	/**
	 * 菜单名称
	 */
	@Length(min = 0, max = 50, message = "菜单名称长度必须介于 0 和 50 之间")
	public String getCdmc() {
		return cdmc;
	}

	/**
	 * 菜单名称
	 */
	public void setCdmc(String cdmc) {
		this.cdmc = cdmc == null ? null : cdmc.trim();
	}

	/**
	 * 问题描述
	 */
	@Length(min = 0, max = 2000, message = "问题描述长度必须介于 0 和 2000 之间")
	public String getWtms() {
		return wtms;
	}

	/**
	 * 问题描述
	 */
	public void setWtms(String wtms) {
		this.wtms = wtms == null ? null : wtms.trim();
	}

	/**
	 * 提出部门
	 */
	@Length(min = 0, max = 50, message = "提出部门长度必须介于 0 和 50 之间")
	public String getTcbm() {
		return tcbm;
	}

	/**
	 * 提出部门
	 */
	public void setTcbm(String tcbm) {
		this.tcbm = tcbm == null ? null : tcbm.trim();
	}

	/**
	 * 提出部门名称
	 */
	@Length(min = 0, max = 50, message = "提出部门名称长度必须介于 0 和 50 之间")
	public String getTcbmmc() {
		return tcbmmc;
	}

	/**
	 * 提出部门名称
	 */
	public void setTcbmmc(String tcbmmc) {
		this.tcbmmc = tcbmmc == null ? null : tcbmmc.trim();
	}

	/**
	 * 提出人
	 */
	@Length(min = 0, max = 50, message = "提出人长度必须介于 0 和 50 之间")
	public String getTcr() {
		return tcr;
	}

	/**
	 * 提出人
	 */
	public void setTcr(String tcr) {
		this.tcr = tcr == null ? null : tcr.trim();
	}

	/**
	 * 提出人名称
	 */
	@Length(min = 0, max = 50, message = "提出人名称长度必须介于 0 和 50 之间")
	public String getTcrmc() {
		return tcrmc;
	}

	/**
	 * 提出人名称
	 */
	public void setTcrmc(String tcrmc) {
		this.tcrmc = tcrmc == null ? null : tcrmc.trim();
	}

	/**
	 * 提出时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTcsj() {
		return tcsj;
	}

	/**
	 * 提出时间
	 */
	public void setTcsj(Date tcsj) {
		this.tcsj = tcsj;
	}

	/**
	 * 优先级（1:低;2:中,3:高,4:最高）
	 */
	public Integer getYxj() {
		return yxj;
	}

	/**
	 * 优先级（1:低;2:中,3:高,4:最高）
	 */
	public void setYxj(Integer yxj) {
		this.yxj = yxj;
	}

	/**
	 * 处理人
	 */
	@Length(min = 0, max = 50, message = "处理人长度必须介于 0 和 50 之间")
	public String getClr() {
		return clr;
	}

	/**
	 * 处理人
	 */
	public void setClr(String clr) {
		this.clr = clr == null ? null : clr.trim();
	}

	/**
	 * 处理人名称
	 */
	@Length(min = 0, max = 50, message = "处理人名称长度必须介于 0 和 50 之间")
	public String getClrmc() {
		return clrmc;
	}

	/**
	 * 处理人名称
	 */
	public void setClrmc(String clrmc) {
		this.clrmc = clrmc == null ? null : clrmc.trim();
	}

	/**
	 * 状态 1:草稿,2:审批中,3:驳回,4:审核通过（未分派）,5:处理中（已分派）,6:已处理,7:关闭
	 */
	public Integer getZt() {
		return zt;
	}

	/**
	 * 状态 1:草稿,2:审批中,3:驳回,4:审核通过（未分派）,5:处理中（已分派）,6:已处理,7:关闭
	 */
	public void setZt(Integer zt) {
		this.zt = zt;
	}

	/**
	 * 处理说明
	 */
	@Length(min = 0, max = 500, message = "处理说明长度必须介于 0 和 500 之间")
	public String getClsm() {
		return clsm;
	}

	/**
	 * 处理说明
	 */
	public void setClsm(String clsm) {
		this.clsm = clsm == null ? null : clsm.trim();
	}

	/**
	 * 实际处理时间（对应已处理时间）
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSjclsj() {
		return sjclsj;
	}

	/**
	 * 实际处理时间（对应已处理时间）
	 */
	public void setSjclsj(Date sjclsj) {
		this.sjclsj = sjclsj;
	}

	/**
	 * 问题分类(1:程序BUG类,2:需求优化类,3:新需求类,4:权限类,5:数据类)
	 */
	public Integer getWtfl() {
		return wtfl;
	}

	/**
	 * 问题分类(1:程序BUG类,2:需求优化类,3:新需求类,4:权限类,5:数据类)
	 */
	public void setWtfl(Integer wtfl) {
		this.wtfl = wtfl;
	}

	/**
	 * 任务分派时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getRwfpsj() {
		return rwfpsj;
	}

	/**
	 * 任务分派时间
	 */
	public void setRwfpsj(Date rwfpsj) {
		this.rwfpsj = rwfpsj;
	}

	/**
	 * 关闭时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getGbsj() {
		return gbsj;
	}

	/**
	 * 关闭时间
	 */
	public void setGbsj(Date gbsj) {
		this.gbsj = gbsj;
	}

	/**
	 * 预计处理时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjclsj() {
		return yjclsj;
	}

	/**
	 * 预计处理时间
	 */
	public void setYjclsj(Date yjclsj) {
		this.yjclsj = yjclsj;
	}

	/**
	 * 要求处理时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYqclsj() {
		return yqclsj;
	}

	/**
	 * 要求处理时间
	 */
	public void setYqclsj(Date yqclsj) {
		this.yqclsj = yqclsj;
	}

	/**
	 * 问题单号
	 */
	@Length(min = 0, max = 20, message = "问题单号长度必须介于 0 和 20 之间")
	public String getWtdh() {
		return wtdh;
	}

	/**
	 * 问题单号
	 */
	public void setWtdh(String wtdh) {
		this.wtdh = wtdh == null ? null : wtdh.trim();
	}

}