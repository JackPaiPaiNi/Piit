package com.ey.piit.sdo.saprebate.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SAP返利政策Entity
 * 
 * @author 赵桃军
 */
public class RebatePolicy extends BaseEntity {

	private String splsh;  // 审批单流水号
	private String hhao;   // 行号
	private String bukrs;  // 公司代码
	private String zrpnm;  // 返利政策编号
	private Integer zitem; // 行号
	private String zrcnm;  // 返利分类编码
	private String zrcnmms; // 返利分类编码描述
	private String zbran; // 品牌
	private String zprod; // 产品系列
	private String kunnr; // 客户编号
	private String khmc; // 客户名称
	private String zmodl; // 型号
	private String zpdec; // 产品型号描述
	private String qdms; // 渠道描述
	private String zsway; // 返利依据汇总方式
	private BigDecimal zbvulF; // 返利依据值从
	private BigDecimal zbvulU; // 返利依据值到
	private String zptyp; // 返利价格类型
	private String zrnum; // 返利基数
	private String zrbat; // 返利价格
	private String zmult; // 乘数
	private Date zvdatF; // 有效期从
	private Date zvdatU; // 有效期止
	private String zstau; // 状态
	private String zremk; // 备注
	private String userid; // 用户名
	private Date cpudt; // 系统日期
	private Date cputm; // 系统时间
	private Integer tssapzt;    //推送SAP状态
	private String zsalm;   //业务员
	private String zsalmms; //业务员描述
	private String zbid;    //主表id
	
	
	

	
	
	
	public String getZbid() {
		return zbid;
	}

	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

	public String getZsalm() {
		return zsalm;
	}

	public void setZsalm(String zsalm) {
		this.zsalm = zsalm;
	}

	public String getZsalmms() {
		return zsalmms;
	}

	public void setZsalmms(String zsalmms) {
		this.zsalmms = zsalmms;
	}

	public Integer getTssapzt() {
		return tssapzt;
	}

	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
	}

	public RebatePolicy() {
		super();
	}

	public RebatePolicy(String id) {
		super(id);
	}

	/**
	 * 审批单流水号
	 */
	@Length(min = 0, max = 20, message = "审批单流水号长度必须介于 0 和 20 之间")
	public String getSplsh() {
		return splsh;
	}

	/**
	 * 审批单流水号
	 */
	public void setSplsh(String splsh) {
		this.splsh = splsh == null ? null : splsh.trim();
	}

	/**
	 * 行号
	 */
	@Length(min = 0, max = 6, message = "行号长度必须介于 0 和 6 之间")
	public String getHhao() {
		return hhao;
	}

	/**
	 * 行号
	 */
	public void setHhao(String hhao) {
		this.hhao = hhao == null ? null : hhao.trim();
	}

	/**
	 * 公司代码
	 */
	@Length(min = 0, max = 10, message = "公司代码长度必须介于 0 和 10 之间")
	public String getBukrs() {
		return bukrs;
	}

	/**
	 * 公司代码
	 */
	public void setBukrs(String bukrs) {
		this.bukrs = bukrs == null ? null : bukrs.trim();
	}

	/**
	 * 返利政策编号
	 */
	@Length(min = 0, max = 20, message = "返利政策编号长度必须介于 0 和 20 之间")
	public String getZrpnm() {
		return zrpnm;
	}

	/**
	 * 返利政策编号
	 */
	public void setZrpnm(String zrpnm) {
		this.zrpnm = zrpnm == null ? null : zrpnm.trim();
	}

	/**
	 * 行号
	 */
	public Integer getZitem() {
		return zitem;
	}

	/**
	 * 行号
	 */
	public void setZitem(Integer zitem) {
		this.zitem = zitem;
	}

	/**
	 * 返利分类编码
	 */
	@Length(min = 0, max = 20, message = "返利分类编码长度必须介于 0 和 20 之间")
	public String getZrcnm() {
		return zrcnm;
	}

	/**
	 * 返利分类编码
	 */
	public void setZrcnm(String zrcnm) {
		this.zrcnm = zrcnm == null ? null : zrcnm.trim();
	}

	/**
	 * 返利分类编码描述
	 */
	@Length(min = 0, max = 50, message = "返利分类编码描述长度必须介于 0 和 50 之间")
	public String getZrcnmms() {
		return zrcnmms;
	}

	/**
	 * 返利分类编码描述
	 */
	public void setZrcnmms(String zrcnmms) {
		this.zrcnmms = zrcnmms == null ? null : zrcnmms.trim();
	}

	/**
	 * 品牌
	 */
	@Length(min = 0, max = 50, message = "品牌长度必须介于 0 和 50 之间")
	public String getZbran() {
		return zbran;
	}

	/**
	 * 品牌
	 */
	public void setZbran(String zbran) {
		this.zbran = zbran == null ? null : zbran.trim();
	}

	/**
	 * 产品系列
	 */
	@Length(min = 0, max = 10, message = "产品系列长度必须介于 0 和 10 之间")
	public String getZprod() {
		return zprod;
	}

	/**
	 * 产品系列
	 */
	public void setZprod(String zprod) {
		this.zprod = zprod == null ? null : zprod.trim();
	}

	/**
	 * 客户编号
	 */
	@Length(min = 0, max = 20, message = "客户编号长度必须介于 0 和 20 之间")
	public String getKunnr() {
		return kunnr;
	}

	/**
	 * 客户编号
	 */
	public void setKunnr(String kunnr) {
		this.kunnr = kunnr == null ? null : kunnr.trim();
	}

	/**
	 * 客户名称
	 */
	@Length(min = 0, max = 50, message = "客户名称长度必须介于 0 和 50 之间")
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
	 * 型号
	 */
	@Length(min = 0, max = 50, message = "型号长度必须介于 0 和 50 之间")
	public String getZmodl() {
		return zmodl;
	}

	/**
	 * 型号
	 */
	public void setZmodl(String zmodl) {
		this.zmodl = zmodl == null ? null : zmodl.trim();
	}

	/**
	 * 产品型号描述
	 */
	@Length(min = 0, max = 50, message = "产品型号描述长度必须介于 0 和 50 之间")
	public String getZpdec() {
		return zpdec;
	}

	/**
	 * 产品型号描述
	 */
	public void setZpdec(String zpdec) {
		this.zpdec = zpdec == null ? null : zpdec.trim();
	}

	/**
	 * 渠道描述
	 */
	@Length(min = 0, max = 50, message = "渠道描述长度必须介于 0 和 50 之间")
	public String getQdms() {
		return qdms;
	}

	/**
	 * 渠道描述
	 */
	public void setQdms(String qdms) {
		this.qdms = qdms == null ? null : qdms.trim();
	}

	/**
	 * 返利依据汇总方式
	 */
	@Length(min = 0, max = 20, message = "返利依据汇总方式长度必须介于 0 和 20 之间")
	public String getZsway() {
		return zsway;
	}

	/**
	 * 返利依据汇总方式
	 */
	public void setZsway(String zsway) {
		this.zsway = zsway == null ? null : zsway.trim();
	}


	/**
	 * 返利价格类型
	 */
	@Length(min = 0, max = 10, message = "返利价格类型长度必须介于 0 和 10 之间")
	public String getZptyp() {
		return zptyp;
	}

	/**
	 * 返利价格类型
	 */
	public void setZptyp(String zptyp) {
		this.zptyp = zptyp == null ? null : zptyp.trim();
	}

	/**
	 * 返利基数
	 */
	@Length(min = 0, max = 50, message = "返利基数长度必须介于 0 和 50 之间")
	public String getZrnum() {
		return zrnum;
	}

	/**
	 * 返利基数
	 */
	public void setZrnum(String zrnum) {
		this.zrnum = zrnum == null ? null : zrnum.trim();
	}

	/**
	 * 返利价格
	 */
	@Length(min = 0, max = 50, message = "返利价格长度必须介于 0 和 50 之间")
	public String getZrbat() {
		return zrbat;
	}

	/**
	 * 返利价格
	 */
	public void setZrbat(String zrbat) {
		this.zrbat = zrbat == null ? null : zrbat.trim();
	}

	/**
	 * 乘数
	 */
	@Length(min = 0, max = 50, message = "乘数长度必须介于 0 和 50 之间")
	public String getZmult() {
		return zmult;
	}

	/**
	 * 乘数
	 */
	public void setZmult(String zmult) {
		this.zmult = zmult == null ? null : zmult.trim();
	}

	/**
	 * 有效期从
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZvdatF() {
		return zvdatF;
	}

	/**
	 * 有效期从
	 */
	public void setZvdatF(Date zvdatF) {
		this.zvdatF = zvdatF;
	}

	/**
	 * 有效期止
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZvdatU() {
		return zvdatU;
	}

	/**
	 * 有效期止
	 */
	public void setZvdatU(Date zvdatU) {
		this.zvdatU = zvdatU;
	}

	/**
	 * 状态
	 */
	@Length(min = 0, max = 10, message = "状态长度必须介于 0 和 10 之间")
	public String getZstau() {
		return zstau;
	}

	/**
	 * 状态
	 */
	public void setZstau(String zstau) {
		this.zstau = zstau == null ? null : zstau.trim();
	}

	/**
	 * 备注
	 */
	@Length(min = 0, max = 200, message = "备注长度必须介于 0 和 200 之间")
	public String getZremk() {
		return zremk;
	}

	/**
	 * 备注
	 */
	public void setZremk(String zremk) {
		this.zremk = zremk == null ? null : zremk.trim();
	}

	/**
	 * 用户名
	 */
	@Length(min = 0, max = 20, message = "用户名长度必须介于 0 和 20 之间")
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户名
	 */
	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	/**
	 * 系统日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCpudt() {
		return cpudt;
	}

	/**
	 * 系统日期
	 */
	public void setCpudt(Date cpudt) {
		this.cpudt = cpudt;
	}

	/**
	 * 系统时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCputm() {
		return cputm;
	}

	/**
	 * 系统时间
	 */
	public void setCputm(Date cputm) {
		this.cputm = cputm;
	}

	public BigDecimal getZbvulF() {
		return zbvulF;
	}

	public void setZbvulF(BigDecimal zbvulF) {
		this.zbvulF = zbvulF;
	}

	public BigDecimal getZbvulU() {
		return zbvulU;
	}

	public void setZbvulU(BigDecimal zbvulU) {
		this.zbvulU = zbvulU;
	}
	
}