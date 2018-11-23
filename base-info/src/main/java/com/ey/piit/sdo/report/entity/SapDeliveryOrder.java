package com.ey.piit.sdo.report.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * SAP交货单明细Entity
 * @author 高文浩
 */
public class SapDeliveryOrder extends BaseEntity {
	
	private String chdh;		// 出货通知书单号
	private Date sjfhrq;		// 实际发货日期
	private String ddid;		// 订单号
	private String jhdh;		// 交货单号
	private Integer serino;		// 行项目号（交货单）
	private String fph;		// 发票号
	private String wlbh;		// 物料编号
	private Double jhsl;		// 交货数量
	private String wldw;		// 物料单位
	private String wlms;		// 物料描述
	private String xmlb;		// 项目类别
	private BigDecimal dj;		// 销售单价
	private Integer jgdw;		// 价格单位
	private String bz;		// 币种
	private Date zdsj;		// 制单时间
	private String sjc;		// 时间戳
	private Long scbj;		// 删除标记 1已删除 null未删除
	private Integer ddxxmh;		// 订单行项目号
	private BigDecimal tzdj;		// 调整单价(SKD齐套出货会回写）
	private BigDecimal ddhjje;		// 订单合计金额
	private Integer tssapzt_syfp;		// 推送SAP状态商业发票
	private Integer tssapzt_gsjfp;		// 推送SAP状态公司间发票
	private BigDecimal fpje;			//发票金额
	private String zdrmc;		// 制单人名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String cwkpr;//船务开票人
	private String cwkprmc;//船务开票人
	
	public Integer getTssapzt_syfp() {
		return tssapzt_syfp;
	}

	public void setTssapzt_syfp(Integer tssapzt_syfp) {
		this.tssapzt_syfp = tssapzt_syfp;
	}

	public Integer getTssapzt_gsjfp() {
		return tssapzt_gsjfp;
	}

	public void setTssapzt_gsjfp(Integer tssapzt_gsjfp) {
		this.tssapzt_gsjfp = tssapzt_gsjfp;
	}

	public BigDecimal getFpje() {
		return fpje;
	}

	public void setFpje(BigDecimal fpje) {
		this.fpje = fpje;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}

	public SapDeliveryOrder() {
		super();
	}

	public SapDeliveryOrder(String id){
		super(id);
	}

	/**
     * 出货通知书单号
     */
	@Length(min=1, max=20, message="出货通知书单号长度必须介于 1 和 20 之间")
	public String getChdh() {
		return chdh;
	}

	/**
     * 出货通知书单号
     */
	public void setChdh(String chdh) {
		this.chdh = chdh == null ? null : chdh.trim();
	}
	
	/**
     * 实际发货日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSjfhrq() {
		return sjfhrq;
	}

	/**
     * 实际发货日期
     */
	public void setSjfhrq(Date sjfhrq) {
		this.sjfhrq = sjfhrq;
	}
	
	/**
     * 订单号
     */
	@Length(min=1, max=20, message="订单号长度必须介于 1 和 20 之间")
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
     * 交货单号
     */
	@Length(min=1, max=20, message="交货单号长度必须介于 1 和 20 之间")
	public String getJhdh() {
		return jhdh;
	}

	/**
     * 交货单号
     */
	public void setJhdh(String jhdh) {
		this.jhdh = jhdh == null ? null : jhdh.trim();
	}
	
	/**
     * 行项目号（交货单）
     */
	@NotNull(message="行项目号（交货单）不能为空")
	public Integer getSerino() {
		return serino;
	}

	/**
     * 行项目号（交货单）
     */
	public void setSerino(Integer serino) {
		this.serino = serino;
	}
	
	/**
     * 发票号
     */
	@Length(min=0, max=100, message="发票号长度必须介于 0 和 100 之间")
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
     * 物料编号
     */
	@Length(min=1, max=50, message="物料编号长度必须介于 1 和 50 之间")
	public String getWlbh() {
		return wlbh;
	}

	/**
     * 物料编号
     */
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh == null ? null : wlbh.trim();
	}
	
	/**
     * 交货数量
     */
	@NotNull(message="交货数量不能为空")
	public Double getJhsl() {
		return jhsl;
	}

	/**
     * 交货数量
     */
	public void setJhsl(Double jhsl) {
		this.jhsl = jhsl;
	}
	
	/**
     * 物料单位
     */
	@Length(min=0, max=50, message="物料单位长度必须介于 0 和 50 之间")
	public String getWldw() {
		return wldw;
	}

	/**
     * 物料单位
     */
	public void setWldw(String wldw) {
		this.wldw = wldw == null ? null : wldw.trim();
	}
	
	/**
     * 物料描述
     */
	@Length(min=0, max=500, message="物料描述长度必须介于 0 和 500 之间")
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
     * 项目类别
     */
	@Length(min=0, max=20, message="项目类别长度必须介于 0 和 20 之间")
	public String getXmlb() {
		return xmlb;
	}

	/**
     * 项目类别
     */
	public void setXmlb(String xmlb) {
		this.xmlb = xmlb == null ? null : xmlb.trim();
	}
	
	/**
     * 价格单位
     */
	public Integer getJgdw() {
		return jgdw;
	}

	/**
     * 价格单位
     */
	public void setJgdw(Integer jgdw) {
		this.jgdw = jgdw;
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
	
	/**
     * 制单时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     * 删除标记 1已删除 null未删除
     */
	public Long getScbj() {
		return scbj;
	}

	/**
     * 删除标记 1已删除 null未删除
     */
	public void setScbj(Long scbj) {
		this.scbj = scbj;
	}
	
	/**
     * 订单行项目号
     */
	@NotNull(message="订单行项目号不能为空")
	public Integer getDdxxmh() {
		return ddxxmh;
	}

	/**
     * 订单行项目号
     */
	public void setDdxxmh(Integer ddxxmh) {
		this.ddxxmh = ddxxmh;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getTzdj() {
		return tzdj;
	}

	public void setTzdj(BigDecimal tzdj) {
		this.tzdj = tzdj;
	}

	public BigDecimal getDdhjje() {
		return ddhjje;
	}

	public void setDdhjje(BigDecimal ddhjje) {
		this.ddhjje = ddhjje;
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

	public String getCwkpr() {
		return cwkpr;
	}

	public void setCwkpr(String cwkpr) {
		this.cwkpr = cwkpr;
	}

	public String getCwkprmc() {
		return cwkprmc;
	}

	public void setCwkprmc(String cwkprmc) {
		this.cwkprmc = cwkprmc;
	}
	
}