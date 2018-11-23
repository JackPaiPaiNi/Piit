package com.ey.piit.interfaces.payment.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 收款认领明细接口实体：
 * 		认领时，实时传输到SAP
 * 		除未认领金额为空外，其他字段信息均需要根据实际单据情况传递到SAP
 * 		根据业务情况部分字段也可能为空（如收款类型为预收款时，发票号为空）
 * 收款未认领明细接口实体：
 * 		每月最后一天24：00，传递本月未认领金额至SAP
 * 		根据单据情况传递公司编码、收款日期、收款单号、客户编码、收款金额、收款币种、手续费、收款银行账号、未认领金额至SAP，其他字段均为空
 * @author tianrong
 *
 */
@XStreamAlias("ROW")
public class PayReceiveClaimBodyDto {
	@XStreamAlias("GSBM")
	private String gsbm= "";//公司编码,RGB－〉2110，SOD－〉5010，SMO－〉5010
	@XStreamAlias("SKRQ")
	private String skrq= "";//收款登记日期,格式 YYYY-MM-DD
	@XStreamAlias("SKDH")
	private String skdh= "";//收款单号
	@XStreamAlias("RLRQ")
	private String rlrq= "";//认领日期,格式 YYYY-MM-DD
	@XStreamAlias("RLDH")
	private String rldh= "";//认领单号
	@XStreamAlias("KHBM")
	private String khbm= "";//客户编码
	@XStreamAlias("SKDJJE")
	private String skdjje= "0";//收款登记金额
	@XStreamAlias("SKBZ")
	private String skbz= "";//收款币种
	@XStreamAlias("TZQJE")
	private String tzqje= "0";//认领调整前金额 保留4位小数
	@XStreamAlias("RLJE")
	private String rlje= "0";//认领金额 保留4位小数
	@XStreamAlias("RLBZ")
	private String rlbz= "";//认领币种
	@XStreamAlias("FPH")
	private String fph= "";//发票号
	@XStreamAlias("SXF")
	private String sxf= "0";//手续费 保留4位小数
	@XStreamAlias("SKYHZH")
	private String skyhzh= "";//收款银行账号
	@XStreamAlias("SKLX")
	private String sklx= "";//收款类型,A 预收款，L 回款（信用证），N 回款（银行）
	@XStreamAlias("RLCHBS")
	private String rlchbs= "";//认领撤回标识，撤回时为"X"
	@XStreamAlias("WRLJE")
	private String wrlje= "0";//未认领金额
	@XStreamAlias("ZXBMFDM")
	private String zxbmfdm;//中信保买方代码
	@XStreamAlias("QYRQ")
	private String qyrq= "";//起运日期
	@XStreamAlias("SJSKRQ")
	private String sjskrq= "";// 实际收款日期
	@XStreamAlias("SHBS")
	private String shbs= "";//收汇标识：若发票已收汇金额+认领金额>=发票金额，则为1，否则为2
	@XStreamAlias("LJYSHJE")
	private String ljyshje= "0";//累计已收汇金额：发票已收汇金额+认领金额
	@XStreamAlias("SKYHGSBM")
	private String skyhgsbm= "";//收款银行公司编码,RGB－〉2110，SOD－〉5010，SMO－〉5010
	 
	
	public String getGsbm() {
		return gsbm;
	}
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	public String getSkrq() {
		return skrq;
	}
	public void setSkrq(String skrq) {
		this.skrq = skrq;
	}
	public String getSkdh() {
		return skdh;
	}
	public void setSkdh(String skdh) {
		this.skdh = skdh;
	}
	public String getRlrq() {
		return rlrq;
	}
	public void setRlrq(String rlrq) {
		this.rlrq = rlrq;
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

	public String getSkbz() {
		return skbz;
	}
	public void setSkbz(String skbz) {
		this.skbz = skbz;
	}

	public String getRlbz() {
		return rlbz;
	}
	public void setRlbz(String rlbz) {
		this.rlbz = rlbz;
	}
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}

	public String getSkyhzh() {
		return skyhzh;
	}
	public void setSkyhzh(String skyhzh) {
		this.skyhzh = skyhzh;
	}
	public String getSklx() {
		return sklx;
	}
	public void setSklx(String sklx) {
		this.sklx = sklx;
	}
	public String getRlchbs() {
		return rlchbs;
	}
	public void setRlchbs(String rlchbs) {
		this.rlchbs = rlchbs;
	}

	public String getZxbmfdm() {
		return zxbmfdm;
	}
	public void setZxbmfdm(String zxbmfdm) {
		this.zxbmfdm = zxbmfdm;
	}
	public String getQyrq() {
		return qyrq;
	}
	public void setQyrq(String qyrq) {
		this.qyrq = qyrq;
	}
	public String getSjskrq() {
		return sjskrq;
	}
	public void setSjskrq(String sjskrq) {
		this.sjskrq = sjskrq;
	}
	public String getShbs() {
		return shbs;
	}
	public void setShbs(String shbs) {
		this.shbs = shbs;
	}

	public String getSkyhgsbm() {
		return skyhgsbm;
	}
	public void setSkyhgsbm(String skyhgsbm) {
		this.skyhgsbm = skyhgsbm;
	}
	public String getSkdjje() {
		return skdjje;
	}
	public void setSkdjje(String skdjje) {
		this.skdjje = skdjje;
	}
	public String getTzqje() {
		return tzqje;
	}
	public void setTzqje(String tzqje) {
		this.tzqje = tzqje;
	}
	public String getRlje() {
		return rlje;
	}
	public void setRlje(String rlje) {
		this.rlje = rlje;
	}
	public String getSxf() {
		return sxf;
	}
	public void setSxf(String sxf) {
		this.sxf = sxf;
	}
	public String getWrlje() {
		return wrlje;
	}
	public void setWrlje(String wrlje) {
		this.wrlje = wrlje;
	}
	public String getLjyshje() {
		return ljyshje;
	}
	public void setLjyshje(String ljyshje) {
		this.ljyshje = ljyshje;
	}
	
}
