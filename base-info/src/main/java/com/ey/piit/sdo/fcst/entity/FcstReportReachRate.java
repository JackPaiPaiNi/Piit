package com.ey.piit.sdo.fcst.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 采购FCST达成率报表Entity
 * @author 赵明
 */
public class FcstReportReachRate extends BaseEntity {
	
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String pid;			// PID
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String ywz;			// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String ny;			// 年月
	private String zc;			// 走货周
	private String zhr;			// 走货日
	private String zhy;			// 走货月
	private String xwgjmc;		// 销往国家
	private String ddlbmc;		// 订单类别
	private String cc;			// 尺寸
	private String jixin;		// 机芯
	private String jixing;		// 机型
	private String mcufa;		// MCUFA
	private String sjyp;		// 实际用屏
	private String zzz;			// 最早周
	private String tqzs;		// 提前周数
	private String pp;			// 品牌
	private String zhfsmc;		// 走货方式
	private String zcfl;		// 周次分类
	private Double w1Ycs;		// 预测数
	private Double w2Ycs;		// 预测数
	private Double w3Ycs;		// 预测数
	private Double w4Ycs;		// 预测数
	private Double w5Ycs;		// 预测数
	private Double w6Ycs;		// 预测数
	private Double w7Ycs;		// 预测数
	private Double w8Ycs;		// 预测数
	private Double w9Ycs;		// 预测数
	private Double w10Ycs;		// 预测数
	private Double w11Ycs;		// 预测数
	private Double w12Ycs;		// 预测数
	private Double w13Ycs;		// 预测数
	private Double w14Ycs;		// 预测数
	private Double w15Ycs;		// 预测数
	private Double w16Ycs;		// 预测数
	private Double w17Ycs;		// 预测数
	private Double sl;//总订单数
	private Double wfcsdcs;//FCST达成数无FCST
	private Double dcs14;//FCST达成数1-4周
	private Double dcs58;//FCST达成数5-8周
	private Double dcs913;//FCST达成数9-13周
	private Double wfcsdcl;//FCST达成率无FCST
	private Double dcl14;//FCST达成率1-4周
	private Double dcl58;//FCST达成率5-8周
	private Double dcl913;//FCST达成率9-13周
	
	public FcstReportReachRate() {
		super();
	}

	public FcstReportReachRate(String id){
		super(id);
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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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

	public String getYwz() {
		return ywz;
	}

	public void setYwz(String ywz) {
		this.ywz = ywz;
	}

	public String getYwzmc() {
		return ywzmc;
	}

	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc;
	}

	public String getXszz() {
		return xszz;
	}

	public void setXszz(String xszz) {
		this.xszz = xszz;
	}

	public String getXszzmc() {
		return xszzmc;
	}

	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc;
	}

	public String getNy() {
		return ny;
	}

	public void setNy(String ny) {
		this.ny = ny;
	}

	public Double getSl() {
		return sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public Double getWfcsdcs() {
		return wfcsdcs;
	}

	public void setWfcsdcs(Double wfcsdcs) {
		this.wfcsdcs = wfcsdcs;
	}

	public Double getDcs14() {
		return dcs14;
	}

	public void setDcs14(Double dcs14) {
		this.dcs14 = dcs14;
	}

	public Double getDcs58() {
		return dcs58;
	}

	public void setDcs58(Double dcs58) {
		this.dcs58 = dcs58;
	}

	public Double getDcs913() {
		return dcs913;
	}

	public void setDcs913(Double dcs913) {
		this.dcs913 = dcs913;
	}

	public Double getWfcsdcl() {
		return wfcsdcl;
	}

	public void setWfcsdcl(Double wfcsdcl) {
		this.wfcsdcl = wfcsdcl;
	}

	public Double getDcl14() {
		return dcl14;
	}

	public void setDcl14(Double dcl14) {
		this.dcl14 = dcl14;
	}

	public Double getDcl58() {
		return dcl58;
	}

	public void setDcl58(Double dcl58) {
		this.dcl58 = dcl58;
	}

	public Double getDcl913() {
		return dcl913;
	}

	public void setDcl913(Double dcl913) {
		this.dcl913 = dcl913;
	}

	public String getZc() {
		return zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	public String getXwgjmc() {
		return xwgjmc;
	}

	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}

	public String getDdlbmc() {
		return ddlbmc;
	}

	public void setDdlbmc(String ddlbmc) {
		this.ddlbmc = ddlbmc;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getJixin() {
		return jixin;
	}

	public void setJixin(String jixin) {
		this.jixin = jixin;
	}

	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public String getMcufa() {
		return mcufa;
	}

	public void setMcufa(String mcufa) {
		this.mcufa = mcufa;
	}

	public String getSjyp() {
		return sjyp;
	}

	public void setSjyp(String sjyp) {
		this.sjyp = sjyp;
	}

	public String getZzz() {
		return zzz;
	}

	public void setZzz(String zzz) {
		this.zzz = zzz;
	}

	public String getTqzs() {
		return tqzs;
	}

	public void setTqzs(String tqzs) {
		this.tqzs = tqzs;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public String getZhfsmc() {
		return zhfsmc;
	}

	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}

	public Double getW1Ycs() {
		return w1Ycs;
	}

	public void setW1Ycs(Double w1Ycs) {
		this.w1Ycs = w1Ycs;
	}

	public Double getW2Ycs() {
		return w2Ycs;
	}

	public void setW2Ycs(Double w2Ycs) {
		this.w2Ycs = w2Ycs;
	}

	public Double getW3Ycs() {
		return w3Ycs;
	}

	public void setW3Ycs(Double w3Ycs) {
		this.w3Ycs = w3Ycs;
	}

	public Double getW4Ycs() {
		return w4Ycs;
	}

	public void setW4Ycs(Double w4Ycs) {
		this.w4Ycs = w4Ycs;
	}

	public Double getW5Ycs() {
		return w5Ycs;
	}

	public void setW5Ycs(Double w5Ycs) {
		this.w5Ycs = w5Ycs;
	}

	public Double getW6Ycs() {
		return w6Ycs;
	}

	public void setW6Ycs(Double w6Ycs) {
		this.w6Ycs = w6Ycs;
	}

	public Double getW7Ycs() {
		return w7Ycs;
	}

	public void setW7Ycs(Double w7Ycs) {
		this.w7Ycs = w7Ycs;
	}

	public Double getW8Ycs() {
		return w8Ycs;
	}

	public void setW8Ycs(Double w8Ycs) {
		this.w8Ycs = w8Ycs;
	}

	public Double getW9Ycs() {
		return w9Ycs;
	}

	public void setW9Ycs(Double w9Ycs) {
		this.w9Ycs = w9Ycs;
	}

	public Double getW10Ycs() {
		return w10Ycs;
	}

	public void setW10Ycs(Double w10Ycs) {
		this.w10Ycs = w10Ycs;
	}

	public Double getW11Ycs() {
		return w11Ycs;
	}

	public void setW11Ycs(Double w11Ycs) {
		this.w11Ycs = w11Ycs;
	}

	public Double getW12Ycs() {
		return w12Ycs;
	}

	public void setW12Ycs(Double w12Ycs) {
		this.w12Ycs = w12Ycs;
	}

	public Double getW13Ycs() {
		return w13Ycs;
	}

	public void setW13Ycs(Double w13Ycs) {
		this.w13Ycs = w13Ycs;
	}

	public Double getW14Ycs() {
		return w14Ycs;
	}

	public void setW14Ycs(Double w14Ycs) {
		this.w14Ycs = w14Ycs;
	}

	public Double getW15Ycs() {
		return w15Ycs;
	}

	public void setW15Ycs(Double w15Ycs) {
		this.w15Ycs = w15Ycs;
	}

	public Double getW16Ycs() {
		return w16Ycs;
	}

	public void setW16Ycs(Double w16Ycs) {
		this.w16Ycs = w16Ycs;
	}

	public Double getW17Ycs() {
		return w17Ycs;
	}

	public void setW17Ycs(Double w17Ycs) {
		this.w17Ycs = w17Ycs;
	}

	public String getZcfl() {
		return zcfl;
	}

	public void setZcfl(String zcfl) {
		this.zcfl = zcfl;
	}

	public String getZhr() {
		return zhr;
	}

	public void setZhr(String zhr) {
		this.zhr = zhr;
	}

	public String getZhy() {
		return zhy;
	}

	public void setZhy(String zhy) {
		this.zhy = zhy;
	}


}