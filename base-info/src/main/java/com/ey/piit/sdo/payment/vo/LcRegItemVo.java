package com.ey.piit.sdo.payment.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LcRegItemVo extends BaseEntity{
	
	private String lcbh;//LC编号
	private String fph;//发票号
	private BigDecimal fpje;//发票金额
	private Date fprq;//发票日期
	private String fpbz;//发票币种
	private String yzhdh;//预走货单号
	private String ddid;//订单号
	private String qy;//区域
	private String qymc;//区域名称
	private String xsyid;//销售员id
	private String xsymc;//销售员名称
	private String cwyid;//船务员id
	private String cwymc;//船务员名称
	private Date wjjryhrq;//文件寄入银行日期
	private Date tzhsdwjrq;//通知行收到文件日期
	private Date etdkcrq;//etd开船日期
	private Date tzhjdrq;//通知行寄单日期
	private String gzhm;//跟踪号码
	private String lcbfxx;//lc不符信息
	private String fj;//附件
	private Date dqfkr;//到期付款日
	private Integer sfyhk;//是否已回款
	private BigDecimal hkje;//回款金额
	private String  bzxx;//备注信息
	private String zdrid;// 制单人ID
	private String zdrmc;// 制单人名称
	private String chdh;//出货通知书号
	private BigDecimal bfdfy;//不符点费用
	private String bfdyy;//不符点原因
	
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public BigDecimal getFpje() {
		return fpje;
	}
	public void setFpje(BigDecimal fpje) {
		this.fpje = fpje;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}
	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}
	public String getFpbz() {
		return fpbz;
	}
	public void setFpbz(String fpbz) {
		this.fpbz = fpbz;
	}
	public String getYzhdh() {
		return yzhdh;
	}
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public String getQy() {
		return qy;
	}
	public void setQy(String qy) {
		this.qy = qy;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public String getXsyid() {
		return xsyid;
	}
	public void setXsyid(String xsyid) {
		this.xsyid = xsyid;
	}
	public String getXsymc() {
		return xsymc;
	}
	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}
	public String getCwyid() {
		return cwyid;
	}
	public void setCwyid(String cwyid) {
		this.cwyid = cwyid;
	}
	public String getCwymc() {
		return cwymc;
	}
	public void setCwymc(String cwymc) {
		this.cwymc = cwymc;
	}
	public String getGzhm() {
		return gzhm;
	}
	public void setGzhm(String gzhm) {
		this.gzhm = gzhm;
	}
	public String getLcbfxx() {
		return lcbfxx;
	}
	public void setLcbfxx(String lcbfxx) {
		this.lcbfxx = lcbfxx;
	}
	public Integer getSfyhk() {
		return sfyhk;
	}
	public void setSfyhk(Integer sfyhk) {
		this.sfyhk = sfyhk;
	}
	public BigDecimal getHkje() {
		return hkje;
	}
	public void setHkje(BigDecimal hkje) {
		this.hkje = hkje;
	}
	public String getBzxx() {
		return bzxx;
	}
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}
	
	public String getLcbh() {
		return lcbh;
	}
	public void setLcbh(String lcbh) {
		this.lcbh = lcbh;
	}
	public String getFj() {
		return fj;
	}
	public void setFj(String fj) {
		this.fj = fj;
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
	public Date getWjjryhrq() {
		return wjjryhrq;
	}
	public void setWjjryhrq(Date wjjryhrq) {
		this.wjjryhrq = wjjryhrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTzhsdwjrq() {
		return tzhsdwjrq;
	}
	public void setTzhsdwjrq(Date tzhsdwjrq) {
		this.tzhsdwjrq = tzhsdwjrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEtdkcrq() {
		return etdkcrq;
	}
	public void setEtdkcrq(Date etdkcrq) {
		this.etdkcrq = etdkcrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTzhjdrq() {
		return tzhjdrq;
	}
	public void setTzhjdrq(Date tzhjdrq) {
		this.tzhjdrq = tzhjdrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getDqfkr() {
		return dqfkr;
	}
	public void setDqfkr(Date dqfkr) {
		this.dqfkr = dqfkr;
	}
	public String getChdh() {
		return chdh;
	}
	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	
	public String getBfdyy() {
		return bfdyy;
	}
	public void setBfdyy(String bfdyy) {
		this.bfdyy = bfdyy;
	}
	public BigDecimal getBfdfy() {
		return bfdfy;
	}
	public void setBfdfy(BigDecimal bfdfy) {
		this.bfdfy = bfdfy;
	}
	
}
