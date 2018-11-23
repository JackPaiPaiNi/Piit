package com.ey.piit.sdo.price.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderBomPrice  extends BaseEntity{
	private String ddid;		// 订单号 父类
	private Integer bbh;		// 版本号
	private String wlbm;		// 物料编码
	private String ms;		    // 描述
	private Integer djyl;		// 单机用量
	private Integer sdjysl;		// 上单结余数量
	private Integer dhsl;		// 大货数量
	private Integer mfbssl;		// 免费备损数量
	private Integer ffbssl;		// 付费备损数量
	private Integer moqsl;		// MOQ数量
	private Integer xdsl;		// 下单数量
	private Integer sapdhddsl;	// SAP大货订单数量
	private Integer bdjysl;		// 本单结余数量
	private String ne;		    // NE
	private String po;		    // PO
	private String ncmcode;		// NCMCODE
	private String ncm;		    // NCM
	private String dw;		    // 单位（研发bom单位）
	private BigDecimal jz;		    // 净重（kg）
	private BigDecimal mz;		    // 毛重（kg）
	private String gysbm;		// 供应商编码
	private String gysmc;		// 供应商名称
	private String gysdz;		// 供应商地址
	private String ycd;		// 原产地
	private Integer sfYc;		// 是否移除 0否 1是
	private BigDecimal dj;		    // 单价
	private String bz;		    // 币种
	private String pid;		    // PID号
	private String zdrid;		    // 制单人
	private String zdrmc;		    // 制单人
	private Date zdsj;		    // 制单时间
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public Integer getBbh() {
		return bbh;
	}
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	public String getWlbm() {
		return wlbm;
	}
	public void setWlbm(String wlbm) {
		this.wlbm = wlbm;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public Integer getDjyl() {
		return djyl;
	}
	public void setDjyl(Integer djyl) {
		this.djyl = djyl;
	}
	public Integer getSdjysl() {
		return sdjysl;
	}
	public void setSdjysl(Integer sdjysl) {
		this.sdjysl = sdjysl;
	}
	public Integer getDhsl() {
		return dhsl;
	}
	public void setDhsl(Integer dhsl) {
		this.dhsl = dhsl;
	}
	public Integer getMfbssl() {
		return mfbssl;
	}
	public void setMfbssl(Integer mfbssl) {
		this.mfbssl = mfbssl;
	}
	public Integer getFfbssl() {
		return ffbssl;
	}
	public void setFfbssl(Integer ffbssl) {
		this.ffbssl = ffbssl;
	}
	public Integer getMoqsl() {
		return moqsl;
	}
	public void setMoqsl(Integer moqsl) {
		this.moqsl = moqsl;
	}
	public Integer getXdsl() {
		return xdsl;
	}
	public void setXdsl(Integer xdsl) {
		this.xdsl = xdsl;
	}
	public Integer getSapdhddsl() {
		return sapdhddsl;
	}
	public void setSapdhddsl(Integer sapdhddsl) {
		this.sapdhddsl = sapdhddsl;
	}
	public Integer getBdjysl() {
		return bdjysl;
	}
	public void setBdjysl(Integer bdjysl) {
		this.bdjysl = bdjysl;
	}
	public String getNe() {
		return ne;
	}
	public void setNe(String ne) {
		this.ne = ne;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getNcmcode() {
		return ncmcode;
	}
	public void setNcmcode(String ncmcode) {
		this.ncmcode = ncmcode;
	}
	public String getNcm() {
		return ncm;
	}
	public void setNcm(String ncm) {
		this.ncm = ncm;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public BigDecimal getJz() {
		return jz;
	}
	public void setJz(BigDecimal jz) {
		this.jz = jz;
	}
	public BigDecimal getMz() {
		return mz;
	}
	public void setMz(BigDecimal mz) {
		this.mz = mz;
	}
	public String getGysbm() {
		return gysbm;
	}
	public void setGysbm(String gysbm) {
		this.gysbm = gysbm;
	}
	public String getGysmc() {
		return gysmc;
	}
	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}
	public Integer getSfYc() {
		return sfYc;
	}
	public void setSfYc(Integer sfYc) {
		this.sfYc = sfYc;
	}
	public BigDecimal getDj() {
		return dj;
	}
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getZdrid() {
		return zdrid;
	}
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}
	public String getZdrmc() {
		return zdrmc;
	}
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	public String getGysdz() {
		return gysdz;
	}
	public void setGysdz(String gysdz) {
		this.gysdz = gysdz;
	}
	public String getYcd() {
		return ycd;
	}
	public void setYcd(String ycd) {
		this.ycd = ycd;
	}


}
