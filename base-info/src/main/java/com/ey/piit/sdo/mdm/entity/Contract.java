package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 合同信息维护Entity
 * @author 高文浩
 */
public class Contract extends BaseEntity {
	
	private String htbh;		// 合同编号
	private String htmc;		// 合同名称
	private String fqrid;		// 发起人
	private String fqrmc;		// 发起人名称
	private Date fqrq;		// 发起日期
	private String htlx;		// 合同类型
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String khdz;		// 客户地址
	private String qyf;		// 签约方
	private String qyf2;		// 签约方2
	private String qyf3;		// 签约方3
	private Integer sfk;		// 收付款
	private String bz;		// 币种
	private BigDecimal htje;		// 合同金额
	private String fktj;		// 付款条件
	private Date yxqks;		// 有效期开始
	private Date yxqjs;		// 有效期结束
	private String zt;		// 状态
	private String htjk;		// 合同简况
	private Integer htfs;		// 合同份数
	private String gdzt;		// 归档状态
	private Date gdrq;		// 归档日期
	private String bzxx;		// 备注
	private Date beginFqrq;		// 开始 发起日期
	private Date endFqrq;		// 结束 发起日期
	private String htlxmc;		//合同类型名称
	private String fktjmc;		//付款条件名称
	private String gdztmc;		//归档状态名称
	private String fj;	//附件
	
	public Contract() {
		super();
	}

	public Contract(String id){
		super(id);
	}

	/**
     * 合同编号
     */
	@Length(min=1, max=20, message="合同编号长度必须介于 1 和 20 之间")
	public String getHtbh() {
		return htbh;
	}

	/**
     * 合同编号
     */
	public void setHtbh(String htbh) {
		this.htbh = htbh == null ? null : htbh.trim();
	}
	
	/**
     * 合同名称
     */
	@Length(min=0, max=100, message="合同名称长度必须介于 0 和 100 之间")
	public String getHtmc() {
		return htmc;
	}

	/**
     * 合同名称
     */
	public void setHtmc(String htmc) {
		this.htmc = htmc == null ? null : htmc.trim();
	}
	
	/**
     * 发起人
     */
	@Length(min=1, max=20, message="发起人长度必须介于 1 和 20 之间")
	public String getFqrid() {
		return fqrid;
	}

	/**
     * 发起人
     */
	public void setFqrid(String fqrid) {
		this.fqrid = fqrid == null ? null : fqrid.trim();
	}
	
	/**
     * 发起人名称
     */
	@Length(min=0, max=50, message="发起人名称长度必须介于 0 和 50 之间")
	public String getFqrmc() {
		return fqrmc;
	}

	/**
     * 发起人名称
     */
	public void setFqrmc(String fqrmc) {
		this.fqrmc = fqrmc == null ? null : fqrmc.trim();
	}
	
	/**
     * 发起日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发起日期不能为空")
	public Date getFqrq() {
		return fqrq;
	}

	/**
     * 发起日期
     */
	public void setFqrq(Date fqrq) {
		this.fqrq = fqrq;
	}
	
	/**
     * 合同类型
     */
	@Length(min=1, max=20, message="合同类型长度必须介于 1 和 20 之间")
	public String getHtlx() {
		return htlx;
	}

	/**
     * 合同类型
     */
	public void setHtlx(String htlx) {
		this.htlx = htlx == null ? null : htlx.trim();
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
     * 客户地址
     */
	@Length(min=0, max=200, message="客户地址长度必须介于 0 和 200 之间")
	public String getKhdz() {
		return khdz;
	}

	/**
     * 客户地址
     */
	public void setKhdz(String khdz) {
		this.khdz = khdz == null ? null : khdz.trim();
	}
	
	/**
     * 签约方
     */
	@Length(min=0, max=100, message="签约方长度必须介于 0 和 100 之间")
	public String getQyf() {
		return qyf;
	}

	/**
     * 签约方
     */
	public void setQyf(String qyf) {
		this.qyf = qyf == null ? null : qyf.trim();
	}
	
	/**
     * 签约方2
     */
	@Length(min=0, max=100, message="签约方2长度必须介于 0 和 100 之间")
	public String getQyf2() {
		return qyf2;
	}

	/**
     * 签约方2
     */
	public void setQyf2(String qyf2) {
		this.qyf2 = qyf2 == null ? null : qyf2.trim();
	}
	
	/**
     * 签约方3
     */
	@Length(min=0, max=100, message="签约方3长度必须介于 0 和 100 之间")
	public String getQyf3() {
		return qyf3;
	}

	/**
     * 签约方3
     */
	public void setQyf3(String qyf3) {
		this.qyf3 = qyf3 == null ? null : qyf3.trim();
	}
	
	/**
     * 收付款
     */
	public Integer getSfk() {
		return sfk;
	}

	/**
     * 收付款
     */
	public void setSfk(Integer sfk) {
		this.sfk = sfk;
	}
	
	/**
     * 币种
     */
	@Length(min=0, max=20, message="币种长度必须介于 0 和 20 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 币种
     */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}
	
	
	public BigDecimal getHtje() {
		return htje;
	}

	public void setHtje(BigDecimal htje) {
		this.htje = htje;
	}

	/**
     * 付款条件
     */
	@Length(min=0, max=20, message="付款条件长度必须介于 0 和 20 之间")
	public String getFktj() {
		return fktj;
	}

	/**
     * 付款条件
     */
	public void setFktj(String fktj) {
		this.fktj = fktj == null ? null : fktj.trim();
	}
	
	/**
     * 有效期开始
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     * 状态
     */
	@Length(min=0, max=20, message="状态长度必须介于 0 和 20 之间")
	public String getZt() {
		return zt;
	}

	/**
     * 状态
     */
	public void setZt(String zt) {
		this.zt = zt == null ? null : zt.trim();
	}
	
	/**
     * 合同简况
     */
	@Length(min=0, max=500, message="合同简况长度必须介于 0 和 500 之间")
	public String getHtjk() {
		return htjk;
	}

	/**
     * 合同简况
     */
	public void setHtjk(String htjk) {
		this.htjk = htjk == null ? null : htjk.trim();
	}
	
	/**
     * 合同份数
     */
	public Integer getHtfs() {
		return htfs;
	}

	/**
     * 合同份数
     */
	public void setHtfs(Integer htfs) {
		this.htfs = htfs;
	}
	
	/**
     * 归档状态
     */
	@Length(min=0, max=20, message="归档状态长度必须介于 0 和 20 之间")
	public String getGdzt() {
		return gdzt;
	}

	/**
     * 归档状态
     */
	public void setGdzt(String gdzt) {
		this.gdzt = gdzt == null ? null : gdzt.trim();
	}
	
	/**
     * 归档日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGdrq() {
		return gdrq;
	}

	/**
     * 归档日期
     */
	public void setGdrq(Date gdrq) {
		this.gdrq = gdrq;
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
	
	public Date getBeginFqrq() {
		return beginFqrq;
	}

	public void setBeginFqrq(Date beginFqrq) {
		this.beginFqrq = beginFqrq;
	}
	
	public Date getEndFqrq() {
		return endFqrq;
	}

	public void setEndFqrq(Date endFqrq) {
		this.endFqrq = endFqrq;
	}

	public String getHtlxmc() {
		return htlxmc;
	}

	public void setHtlxmc(String htlxmc) {
		this.htlxmc = htlxmc;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}

	public String getGdztmc() {
		return gdztmc;
	}

	public void setGdztmc(String gdztmc) {
		this.gdztmc = gdztmc;
	}

	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}
	
}