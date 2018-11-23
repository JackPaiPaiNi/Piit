package com.ey.piit.sdo.payment.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 收款信息登记Entity
 * @author 邓海
 */
public class PayReceive extends BaseEntity {
	
	private String skdh;		// 收款单号
	private String fkr;		// 付款人
	private String fkyh;		// 付款银行
	private String fkgj;		// 付款国家
	private String fkgjmc;		// 付款国家名称
	private String bz;		// 币种
	private Date skrq;		// 收款日期
	private String skyh;		// 收款银行
	private String skyhmc;		// 收款银行名称
	private BigDecimal yrlje;		// 已认领金额
	private BigDecimal je;		// 金额
	private String pzh;		// 凭证号
	private BigDecimal cksxf;		// 参考手续费
	private String bzxx;		// 备注信息
	private BigDecimal sjsxf;		// 实际手续费
	private String fj;		// 手续费附件
	private String zdrid;		// 财务登记人ID
	private String zdrmc;		// 财务登记人名称
	private Date zdsj;		// 登记时间
	private Integer zt;		// 状态
	private String ztmc;	// 状态名称
	private Integer bbh;		// 版本号
	private String sjc;		// 时间戳
	private String sprid;		// 审批人
	private String sprmc;		// 审批人名称
	private Date spsj;		// 审批时间
	private String beginZdsj;		// 开始 登记时间
	private String endZdsj;		// 结束 登记时间
	private BigDecimal djje;//冻结金额
	private String djyy;//冻结原因
	private String jybz;//交易币种
	private BigDecimal hl;//汇率
	private Integer tssapzt; // 推送SAP状态
	private String sklb;	//收款类别
	private String sklbmc;	//收款类别名称
	private String gsbm;	//公司编码
	private String gsmc;	//公司名称
	
	public PayReceive() {
		super();
	}

	public PayReceive(String id){
		super(id);
	}

	/**
     * 收款单号
     */
	@Length(min=1, max=20, message="收款单号长度必须介于 1 和 20 之间")
	public String getSkdh() {
		return skdh;
	}

	/**
     * 收款单号
     */
	public void setSkdh(String skdh) {
		this.skdh = skdh == null ? null : skdh.trim();
	}
	
	/**
     * 付款人
     */
	@Length(min=0, max=50, message="付款人长度必须介于 0 和 50 之间")
	public String getFkr() {
		return fkr;
	}

	/**
     * 付款人
     */
	public void setFkr(String fkr) {
		this.fkr = fkr == null ? null : fkr.trim();
	}
	
	/**
     * 付款银行
     */
	@Length(min=0, max=100, message="付款银行长度必须介于 0 和 100 之间")
	public String getFkyh() {
		return fkyh;
	}

	/**
     * 付款银行
     */
	public void setFkyh(String fkyh) {
		this.fkyh = fkyh == null ? null : fkyh.trim();
	}
	
	/**
     * 付款国家
     */
	@Length(min=0, max=50, message="付款国家长度必须介于 0 和 50 之间")
	public String getFkgj() {
		return fkgj;
	}

	/**
     * 付款国家
     */
	public void setFkgj(String fkgj) {
		this.fkgj = fkgj == null ? null : fkgj.trim();
	}
	
	/**
     * 付款国家名称
     */
	@Length(min=0, max=50, message="付款国家名称长度必须介于 0 和 50 之间")
	public String getFkgjmc() {
		return fkgjmc;
	}

	/**
     * 付款国家名称
     */
	public void setFkgjmc(String fkgjmc) {
		this.fkgjmc = fkgjmc == null ? null : fkgjmc.trim();
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
	
	
	public String getPzh() {
		return pzh;
	}

	public void setPzh(String pzh) {
		this.pzh = pzh;
	}

	/**
     * 收款日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSkrq() {
		return skrq;
	}

	/**
     * 收款日期
     */
	public void setSkrq(Date skrq) {
		this.skrq = skrq;
	}
	
	/**
     * 收款银行
     */
	@Length(min=0, max=50, message="收款银行长度必须介于 0 和 50 之间")
	public String getSkyh() {
		return skyh;
	}

	/**
     * 收款银行
     */
	public void setSkyh(String skyh) {
		this.skyh = skyh == null ? null : skyh.trim();
	}
	
	/**
     * 收款银行名称
     */
	@Length(min=0, max=100, message="收款银行名称长度必须介于 0 和 100 之间")
	public String getSkyhmc() {
		return skyhmc;
	}

	/**
     * 收款银行名称
     */
	public void setSkyhmc(String skyhmc) {
		this.skyhmc = skyhmc == null ? null : skyhmc.trim();
	}
	
	/**
     * 金额
     */
	public BigDecimal getJe() {
		return je;
	}

	/**
     * 金额
     */
	public void setJe(BigDecimal je) {
		this.je = je;
	}


	
	/**
     * 参考手续费
     */
	public BigDecimal getCksxf() {
		return cksxf;
	}

	/**
     * 参考手续费
     */
	public void setCksxf(BigDecimal cksxf) {
		this.cksxf = cksxf;
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
     * 实际手续费
     */
	public BigDecimal getSjsxf() {
		return sjsxf;
	}

	/**
     * 实际手续费
     */
	public void setSjsxf(BigDecimal sjsxf) {
		this.sjsxf = sjsxf;
	}
	
	/**
     * 手续费附件
     */
	@Length(min=0, max=100, message="手续费附件长度必须介于 0 和 100 之间")
	public String getFj() {
		return fj;
	}

	/**
     * 手续费附件
     */
	public void setFj(String fj) {
		this.fj = fj == null ? null : fj.trim();
	}
	
	/**
     * 财务登记人ID
     */
	@Length(min=1, max=20, message="财务登记人ID长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * 财务登记人ID
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * 财务登记人名称
     */
	@Length(min=1, max=50, message="财务登记人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * 财务登记人名称
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}
	
	/**
     * 登记时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="登记时间不能为空")
	public Date getZdsj() {
		return zdsj;
	}

	/**
     * 登记时间
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
	
	public String getBeginZdsj() {
		return beginZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}
	
	public String getEndZdsj() {
		return endZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	public BigDecimal getYrlje() {
		return yrlje;
	}

	public void setYrlje(BigDecimal yrlje) {
		this.yrlje = yrlje;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public BigDecimal getDjje() {
		return djje;
	}

	public void setDjje(BigDecimal djje) {
		this.djje = djje;
	}

	public String getDjyy() {
		return djyy;
	}

	public void setDjyy(String djyy) {
		this.djyy = djyy;
	}

	public String getJybz() {
		return jybz;
	}

	public void setJybz(String jybz) {
		this.jybz = jybz;
	}

	public BigDecimal getHl() {
		return hl;
	}

	public void setHl(BigDecimal hl) {
		this.hl = hl;
	}

	public Integer getTssapzt() {
		return tssapzt;
	}

	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
	}

	public String getSklb() {
		return sklb;
	}

	public void setSklb(String sklb) {
		this.sklb = sklb;
	}

	public String getSklbmc() {
		return sklbmc;
	}

	public void setSklbmc(String sklbmc) {
		this.sklbmc = sklbmc;
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public String getGsmc() {
		return gsmc;
	}

	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}

}