package com.ey.piit.sdo.payment.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 信用额度管理Entity
 * @author 田荣
 */
public class PayCredit extends BaseEntity {
	
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String sszz;		// 所属组织
	private String sszzmc;		// 所属组织名称
	private String zxbmfdm;		// 中信保买方编码
	private String gj;		// 国家
	private String gjmc;		// 国家名称
	private String xyedlx;		// 信用额度类型
	private String xyedlxmc;		// 信用额度类型名称
	private String kzh;			// LC开证行
	private String kzhdm;		// LC开证行SWIFT
	private BigDecimal zxbed;		// 中信保额度
	private BigDecimal nbgled;		// 内部管理额度
	private BigDecimal ysyed;		// 已使用额度
	private String bz;		// 币种
	private Date yxq;		// 有效期
	private Integer xexzq;		// 限额闲置期
	private Double pfbl;		//赔付比例
	private Integer sfxh;		// 是否循环
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Integer zt;		// 状态
	private String ztmc;	// 状态名称
	private Integer bbh;		// 版本号
	private String sjc;		// 时间戳
	private String sprid;		// 审批人
	private String sprmc;		// 审批人名称
	private Date spsj;		// 审批时间
	private Date ksyxq;//开始有效期
	private Double pfblJsfx;//赔付比例 拒收风险
	private Integer zq;//账期
	//不做维护字段，但需要关联其他表查询
	private Date zxkcrq;
	
	private Integer sfXnkh ; //是否虚拟客户标记
	private String bzxx;	//备注信息
	
	
	
	
	
	public Integer getSfXnkh() {
		return sfXnkh;
	}

	public void setSfXnkh(Integer sfXnkh) {
		this.sfXnkh = sfXnkh;
	}

	public PayCredit() {
		super();
	}

	public PayCredit(String id){
		super(id);
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
     * 所属组织
     */
	@Length(min=0, max=20, message="所属组织长度必须介于 0 和 20 之间")
	public String getSszz() {
		return sszz;
	}

	/**
     * 所属组织
     */
	public void setSszz(String sszz) {
		this.sszz = sszz == null ? null : sszz.trim();
	}
	
	/**
     * 所属组织名称
     */
	@Length(min=0, max=50, message="所属组织名称长度必须介于 0 和 50 之间")
	public String getSszzmc() {
		return sszzmc;
	}

	/**
     * 所属组织名称
     */
	public void setSszzmc(String sszzmc) {
		this.sszzmc = sszzmc == null ? null : sszzmc.trim();
	}
	
	/**
     * 中信保买方编码
     */
	@Length(min=1, max=20, message="中信保买方编码长度必须介于 1 和 20 之间")
	public String getZxbmfdm() {
		return zxbmfdm;
	}

	/**
     * 中信保买方编码
     */
	public void setZxbmfdm(String zxbmfdm) {
		this.zxbmfdm = zxbmfdm;
	}

	/**
     * 国家
     */
	@Length(min=0, max=20, message="国家长度必须介于 0 和 20 之间")
	public String getGj() {
		return gj;
	}

	/**
     * 国家
     */
	public void setGj(String gj) {
		this.gj = gj == null ? null : gj.trim();
	}
	
	/**
     * 国家名称
     */
	@Length(min=0, max=50, message="国家名称长度必须介于 0 和 50 之间")
	public String getGjmc() {
		return gjmc;
	}

	/**
     * 国家名称
     */
	public void setGjmc(String gjmc) {
		this.gjmc = gjmc == null ? null : gjmc.trim();
	}
	
	/**
     * 信用额度类型
     */
	@Length(min=1, max=50, message="信用额度类型长度必须介于 1 和 50 之间")
	public String getXyedlx() {
		return xyedlx;
	}

	/**
     * 信用额度类型
     */
	public void setXyedlx(String xyedlx) {
		this.xyedlx = xyedlx == null ? null : xyedlx.trim();
	}
	
	/**
     * 信用额度类型名称
     */
	@Length(min=0, max=50, message="信用额度类型名称长度必须介于 0 和 50 之间")
	public String getXyedlxmc() {
		return xyedlxmc;
	}

	/**
     * 信用额度类型名称
     */
	public void setXyedlxmc(String xyedlxmc) {
		this.xyedlxmc = xyedlxmc == null ? null : xyedlxmc.trim();
	}
	
	public String getKzh() {
		return kzh;
	}

	public void setKzh(String kzh) {
		this.kzh = kzh;
	}

	public String getKzhdm() {
		return kzhdm;
	}

	public void setKzhdm(String kzhdm) {
		this.kzhdm = kzhdm;
	}

	public BigDecimal getYsyed() {
		return ysyed;
	}

	public void setYsyed(BigDecimal ysyed) {
		this.ysyed = ysyed;
	}

	/**
     * 中信保额度
     */
	public BigDecimal getZxbed() {
		return zxbed;
	}

	/**
     * 中信保额度
     */
	public void setZxbed(BigDecimal zxbed) {
		this.zxbed = zxbed;
	}
	
	/**
     * 内部管理额度
     */
	public BigDecimal getNbgled() {
		return nbgled;
	}

	/**
     * 内部管理额度
     */
	public void setNbgled(BigDecimal nbgled) {
		this.nbgled = nbgled;
	}
	
	/**
     * 币种
     */
	@Length(min=0, max=50, message="币种长度必须介于 0 和 50 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 币种
     */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}
	
	/**
     * 有效期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYxq() {
		return yxq;
	}

	/**
     * 有效期
     */
	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}
	
	/**
     * 限额闲置期
     */
	public Integer getXexzq() {
		return xexzq;
	}

	/**
     * 限额闲置期
     */
	public void setXexzq(Integer xexzq) {
		this.xexzq = xexzq;
	}
	
	/**
     * 赔付比例
     */
	public Double getPfbl() {
		return pfbl;
	}

	/**
     * 赔付比例
     */
	public void setPfbl(Double pfbl) {
		this.pfbl = pfbl;
	}
	
	/**
     * 是否循环
     */
	public Integer getSfxh() {
		return sfxh;
	}

	/**
     * 是否循环
     */
	public void setSfxh(Integer sfxh) {
		this.sfxh = sfxh;
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
	@JsonFormat(pattern = "yyyy-MM-dd")
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
	
	/**
     * 状态
     */
	@NotNull(message="状态不能为空")
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
     * 版本号
     */
	@NotNull(message="版本号不能为空")
	public Integer getBbh() {
		return bbh;
	}

	/**
     * 版本号
     */
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	
	/**
     * 时间戳
     */
	@Length(min=1, max=20, message="时间戳长度必须介于 1 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
     * 时间戳
     */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
	}
	
	/**
     * 审批人
     */
	@Length(min=0, max=20, message="审批人长度必须介于 0 和 20 之间")
	public String getSprid() {
		return sprid;
	}

	/**
     * 审批人
     */
	public void setSprid(String sprid) {
		this.sprid = sprid == null ? null : sprid.trim();
	}
	
	/**
     * 审批人名称
     */
	@Length(min=0, max=50, message="审批人名称长度必须介于 0 和 50 之间")
	public String getSprmc() {
		return sprmc;
	}

	/**
     * 审批人名称
     */
	public void setSprmc(String sprmc) {
		this.sprmc = sprmc == null ? null : sprmc.trim();
	}
	
	/**
     * 审批时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSpsj() {
		return spsj;
	}

	/**
     * 审批时间
     */
	public void setSpsj(Date spsj) {
		this.spsj = spsj;
	}
	
	/**
     * 最新开船日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZxkcrq() {
		return zxkcrq;
	}

	/**
     * 最新开船日期
     */
	public void setZxkcrq(Date zxkcrq) {
		this.zxkcrq = zxkcrq;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getKsyxq() {
		return ksyxq;
	}

	public void setKsyxq(Date ksyxq) {
		this.ksyxq = ksyxq;
	}

	public Double getPfblJsfx() {
		return pfblJsfx;
	}

	public void setPfblJsfx(Double pfblJsfx) {
		this.pfblJsfx = pfblJsfx;
	}

	public Integer getZq() {
		return zq;
	}

	public void setZq(Integer zq) {
		this.zq = zq;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}
	
}