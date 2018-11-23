package com.ey.piit.sdo.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 收款认领Entity
 * @author 邓海
 */
public class PayReceiveClaim extends BaseEntity {
	
	private String rldh;        //认领单号
	private String skdh;		// 收款单号
	private String khbm;
	private String khmc;
	private String sklx;		// 收款类型
	private String sklxmc;		// 收款类型名称
	private String bz;		// 收款币种
	private BigDecimal je;		// 认领金额
	private BigDecimal rljetz;		// 认领金额调整
	private BigDecimal ybdje;		// 已绑定金额
	private String fph;		// 发票号
	private BigDecimal fpje;		// 发票金额
	private String fpbz;		// 发票币种
	private String ddh;		// 订单号
	private String lcbh;		// LC编号
	private String gsbm;		// 接单主体
	private String gsmc;		// 接单主体名称
	private String bzxx;		// 备注信息
	private String zdrid;		// 认领人ID
	private String zdrmc;		// 认领人名称
	private Date zdsj;		// 认领日期
	private Integer zt;		// 状态
	private String ztmc;	// 状态名称
	private Integer bbh;		// 版本号
	private String sjc;		// 时间戳
	private String sprid;		// 审批人
	private String sprmc;		// 审批人名称
	private Date spsj;		// 审批时间
	private Integer tssapzt;		// 推送SAP状态
	private BigDecimal sjsxf;		// 实际手续费
	private String fj;		// 附件
	private BigDecimal djje;//预收款冻结金额
	
	public PayReceiveClaim() {
		super();
	}

	public PayReceiveClaim(String id){
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
     * 收款类型
     */
	@Length(min=1, max=50, message="收款类型长度必须介于 1 和 50 之间")
	public String getSklx() {
		return sklx;
	}

	/**
     * 收款类型
     */
	public void setSklx(String sklx) {
		this.sklx = sklx == null ? null : sklx.trim();
	}
	
	/**
     * 收款类型名称
     */
	@Length(min=0, max=50, message="收款类型名称长度必须介于 0 和 50 之间")
	public String getSklxmc() {
		return sklxmc;
	}

	/**
     * 收款类型名称
     */
	public void setSklxmc(String sklxmc) {
		this.sklxmc = sklxmc == null ? null : sklxmc.trim();
	}
	
	/**
     * 收款币种
     */
	@Length(min=0, max=50, message="收款币种长度必须介于 0 和 50 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 收款币种
     */
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	/**
     * 发票号
     */
	@Length(min=0, max=20, message="发票号长度必须介于 0 和 20 之间")
	public String getFph() {
		return fph;
	}

	/**
     * 发票号
     */
	public void setFph(String fph) {
		this.fph = fph == null ? null : fph.trim();
	}
	
	/**
     * 发票币种
     */
	@Length(min=0, max=50, message="发票币种长度必须介于 0 和 50 之间")
	public String getFpbz() {
		return fpbz;
	}

	/**
     * 发票币种
     */
	public void setFpbz(String fpbz) {
		this.fpbz = fpbz == null ? null : fpbz.trim();
	}
	
	/**
     * 订单号
     */
	@Length(min=0, max=20, message="订单号长度必须介于 0 和 20 之间")
	public String getDdh() {
		return ddh;
	}

	/**
     * 订单号
     */
	public void setDdh(String ddh) {
		this.ddh = ddh == null ? null : ddh.trim();
	}
	
	/**
     * LC编号
     */
	@Length(min=0, max=20, message="LC编号长度必须介于 0 和 20 之间")
	public String getLcbh() {
		return lcbh;
	}

	/**
     * LC编号
     */
	public void setLcbh(String lcbh) {
		this.lcbh = lcbh == null ? null : lcbh.trim();
	}
	
	/**
     * 接单主体
     */
	@Length(min=0, max=50, message="接单主体长度必须介于 0 和 50 之间")
	public String getGsbm() {
		return gsbm;
	}

	/**
     * 接单主体
     */
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm == null ? null : gsbm.trim();
	}
	
	/**
     * 接单主体名称
     */
	@Length(min=0, max=50, message="接单主体名称长度必须介于 0 和 50 之间")
	public String getGsmc() {
		return gsmc;
	}

	/**
     * 接单主体名称
     */
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc == null ? null : gsmc.trim();
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
     * 认领人ID
     */
	@Length(min=1, max=20, message="认领人ID长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * 认领人ID
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * 认领人名称
     */
	@Length(min=1, max=50, message="认领人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * 认领人名称
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}
	
	/**
     * 认领日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="认领日期不能为空")
	public Date getZdsj() {
		return zdsj;
	}

	/**
     * 认领日期
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
     * 推送SAP状态
     */
	public Integer getTssapzt() {
		return tssapzt;
	}

	/**
     * 推送SAP状态
     */
	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
	}

	public String getRldh() {
		return rldh;
	}

	public void setRldh(String rldh) {
		this.rldh = rldh;
	}

	public String getKhbm() {
		return khbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public BigDecimal getRljetz() {
		return rljetz;
	}

	public void setRljetz(BigDecimal rljetz) {
		this.rljetz = rljetz;
	}

	public BigDecimal getYbdje() {
		return ybdje;
	}

	public void setYbdje(BigDecimal ybdje) {
		this.ybdje = ybdje;
	}

	public BigDecimal getFpje() {
		return fpje;
	}

	public void setFpje(BigDecimal fpje) {
		this.fpje = fpje;
	}

	public BigDecimal getSjsxf() {
		return sjsxf;
	}

	public void setSjsxf(BigDecimal sjsxf) {
		this.sjsxf = sjsxf;
	}

	public BigDecimal getDjje() {
		return djje;
	}

	public void setDjje(BigDecimal djje) {
		this.djje = djje;
	}
	
}