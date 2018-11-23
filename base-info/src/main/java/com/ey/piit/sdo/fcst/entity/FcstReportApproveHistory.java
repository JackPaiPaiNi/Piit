package com.ey.piit.sdo.fcst.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * FCST评审历史entity
 * @author 高文浩
 *
 */
public class FcstReportApproveHistory extends BaseEntity {
	
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String pid;		// PID
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String ywz;		// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String lrfs;		// 录入方式
	private String lrfsmc;		// 录入方式名称
	private String zc;		// 周次
	private Double ycs;		// 预测数
	private Double dds;		// 订单数
	private Double wxds;		// 未下单数
	private String pp;		// 品牌
	private String xwgj;		// 销往国家
	private String xwgjmc;		// 销往国家名称
	private String zhfs;		// 走货方式
	private String zhfsmc;		// 走货方式名称
	private String ddlb;		// 订单类别
	private String ddlbmc;		// 订单类别名称
	private Double cc;		// 尺寸
	private String jixing;		// 机型
	private String jixin;		// 机芯
	private String mcufa;		// MCU方案
	private String sjyp;		// 实际用屏
	
	private Double w1Ycs;		// 第1周预测数
	private Double w2Ycs;		// 第2周预测数	
	private Double w3Ycs;		// 第3周预测数
	private Double w4Ycs;		// 第4周预测数
	private Double w5Ycs;		// 第5周预测数
	private Double w6Ycs;		// 第6周预测数
	private Double w7Ycs;		// 第7周预测数
	private Double w8Ycs;		// 第8周预测数
	private Double w9Ycs;		// 第9周预测数
	private Double w10Ycs;		// 第10周预测数
	private Double w11Ycs;		// 第11周预测数
	private Double w12Ycs;		// 第12周预测数
	private Double w13Ycs;		// 第13周预测数
	private Double w14Ycs;		// 第14周预测数
	private Double w15Ycs;		// 第15周预测数
	private Double w16Ycs;		// 第16周预测数
	private Double w17Ycs;		// 第17周预测数

	private Double w1Dds;		// 第1周订单数
	private Double w2Dds;		// 第2周订单数	
	private Double w3Dds;		// 第3周订单数
	private Double w4Dds;		// 第4周订单数
	private Double w5Dds;		// 第5周订单数
	private Double w6Dds;		// 第6周订单数
	private Double w7Dds;		// 第7周订单数
	private Double w8Dds;		// 第8周订单数
	private Double w9Dds;		// 第9周订单数
	private Double w10Dds;		// 第10周订单数
	private Double w11Dds;		// 第11周订单数
	private Double w12Dds;		// 第12周订单数
	private Double w13Dds;		// 第13周订单数
	private Double w14Dds;		// 第14周订单数
	private Double w15Dds;		// 第15周订单数
	private Double w16Dds;		// 第16周订单数
	private Double w17Dds;		// 第17周订单数
	
	private Double w1Wxds;		// 第1周未下单数
	private Double w2Wxds;		// 第2周未下单数	
	private Double w3Wxds;		// 第3周未下单数
	private Double w4Wxds;		// 第4周未下单数
	private Double w5Wxds;		// 第5周未下单数
	private Double w6Wxds;		// 第6周未下单数
	private Double w7Wxds;		// 第7周未下单数
	private Double w8Wxds;		// 第8周未下单数
	private Double w9Wxds;		// 第9周未下单数
	private Double w10Wxds;		// 第10周未下单数
	private Double w11Wxds;		// 第11周未下单数
	private Double w12Wxds;		// 第12周未下单数
	private Double w13Wxds;		// 第13周未下单数
	private Double w14Wxds;		// 第14周未下单数
	private Double w15Wxds;		// 第15周未下单数
	private Double w16Wxds;		// 第16周未下单数
	private Double w17Wxds;		// 第17周未下单数
	
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
	public String getLrfs() {
		return lrfs;
	}
	public void setLrfs(String lrfs) {
		this.lrfs = lrfs;
	}
	public String getLrfsmc() {
		return lrfsmc;
	}
	public void setLrfsmc(String lrfsmc) {
		this.lrfsmc = lrfsmc;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public Double getYcs() {
		return ycs;
	}
	public void setYcs(Double ycs) {
		this.ycs = ycs;
	}
	public Double getDds() {
		return dds;
	}
	public void setDds(Double dds) {
		this.dds = dds;
	}
	public Double getWxds() {
		return wxds;
	}
	public void setWxds(Double wxds) {
		this.wxds = wxds;
	}
	public String getPp() {
		return pp;
	}
	public void setPp(String pp) {
		this.pp = pp;
	}
	public String getXwgj() {
		return xwgj;
	}
	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}
	public String getXwgjmc() {
		return xwgjmc;
	}
	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}
	public String getZhfs() {
		return zhfs;
	}
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs;
	}
	public String getZhfsmc() {
		return zhfsmc;
	}
	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}
	public String getDdlb() {
		return ddlb;
	}
	public void setDdlb(String ddlb) {
		this.ddlb = ddlb;
	}
	public String getDdlbmc() {
		return ddlbmc;
	}
	public void setDdlbmc(String ddlbmc) {
		this.ddlbmc = ddlbmc;
	}
	public Double getCc() {
		return cc;
	}
	public void setCc(Double cc) {
		this.cc = cc;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public String getJixin() {
		return jixin;
	}
	public void setJixin(String jixin) {
		this.jixin = jixin;
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
	public Double getW1Dds() {
		return w1Dds;
	}
	public void setW1Dds(Double w1Dds) {
		this.w1Dds = w1Dds;
	}
	public Double getW2Dds() {
		return w2Dds;
	}
	public void setW2Dds(Double w2Dds) {
		this.w2Dds = w2Dds;
	}
	public Double getW3Dds() {
		return w3Dds;
	}
	public void setW3Dds(Double w3Dds) {
		this.w3Dds = w3Dds;
	}
	public Double getW4Dds() {
		return w4Dds;
	}
	public void setW4Dds(Double w4Dds) {
		this.w4Dds = w4Dds;
	}
	public Double getW5Dds() {
		return w5Dds;
	}
	public void setW5Dds(Double w5Dds) {
		this.w5Dds = w5Dds;
	}
	public Double getW6Dds() {
		return w6Dds;
	}
	public void setW6Dds(Double w6Dds) {
		this.w6Dds = w6Dds;
	}
	public Double getW7Dds() {
		return w7Dds;
	}
	public void setW7Dds(Double w7Dds) {
		this.w7Dds = w7Dds;
	}
	public Double getW8Dds() {
		return w8Dds;
	}
	public void setW8Dds(Double w8Dds) {
		this.w8Dds = w8Dds;
	}
	public Double getW9Dds() {
		return w9Dds;
	}
	public void setW9Dds(Double w9Dds) {
		this.w9Dds = w9Dds;
	}
	public Double getW10Dds() {
		return w10Dds;
	}
	public void setW10Dds(Double w10Dds) {
		this.w10Dds = w10Dds;
	}
	public Double getW11Dds() {
		return w11Dds;
	}
	public void setW11Dds(Double w11Dds) {
		this.w11Dds = w11Dds;
	}
	public Double getW12Dds() {
		return w12Dds;
	}
	public void setW12Dds(Double w12Dds) {
		this.w12Dds = w12Dds;
	}
	public Double getW13Dds() {
		return w13Dds;
	}
	public void setW13Dds(Double w13Dds) {
		this.w13Dds = w13Dds;
	}
	public Double getW14Dds() {
		return w14Dds;
	}
	public void setW14Dds(Double w14Dds) {
		this.w14Dds = w14Dds;
	}
	public Double getW15Dds() {
		return w15Dds;
	}
	public void setW15Dds(Double w15Dds) {
		this.w15Dds = w15Dds;
	}
	public Double getW16Dds() {
		return w16Dds;
	}
	public void setW16Dds(Double w16Dds) {
		this.w16Dds = w16Dds;
	}
	public Double getW17Dds() {
		return w17Dds;
	}
	public void setW17Dds(Double w17Dds) {
		this.w17Dds = w17Dds;
	}
	public Double getW1Wxds() {
		return w1Wxds;
	}
	public void setW1Wxds(Double w1Wxds) {
		this.w1Wxds = w1Wxds;
	}
	public Double getW2Wxds() {
		return w2Wxds;
	}
	public void setW2Wxds(Double w2Wxds) {
		this.w2Wxds = w2Wxds;
	}
	public Double getW3Wxds() {
		return w3Wxds;
	}
	public void setW3Wxds(Double w3Wxds) {
		this.w3Wxds = w3Wxds;
	}
	public Double getW4Wxds() {
		return w4Wxds;
	}
	public void setW4Wxds(Double w4Wxds) {
		this.w4Wxds = w4Wxds;
	}
	public Double getW5Wxds() {
		return w5Wxds;
	}
	public void setW5Wxds(Double w5Wxds) {
		this.w5Wxds = w5Wxds;
	}
	public Double getW6Wxds() {
		return w6Wxds;
	}
	public void setW6Wxds(Double w6Wxds) {
		this.w6Wxds = w6Wxds;
	}
	public Double getW7Wxds() {
		return w7Wxds;
	}
	public void setW7Wxds(Double w7Wxds) {
		this.w7Wxds = w7Wxds;
	}
	public Double getW8Wxds() {
		return w8Wxds;
	}
	public void setW8Wxds(Double w8Wxds) {
		this.w8Wxds = w8Wxds;
	}
	public Double getW9Wxds() {
		return w9Wxds;
	}
	public void setW9Wxds(Double w9Wxds) {
		this.w9Wxds = w9Wxds;
	}
	public Double getW10Wxds() {
		return w10Wxds;
	}
	public void setW10Wxds(Double w10Wxds) {
		this.w10Wxds = w10Wxds;
	}
	public Double getW11Wxds() {
		return w11Wxds;
	}
	public void setW11Wxds(Double w11Wxds) {
		this.w11Wxds = w11Wxds;
	}
	public Double getW12Wxds() {
		return w12Wxds;
	}
	public void setW12Wxds(Double w12Wxds) {
		this.w12Wxds = w12Wxds;
	}
	public Double getW13Wxds() {
		return w13Wxds;
	}
	public void setW13Wxds(Double w13Wxds) {
		this.w13Wxds = w13Wxds;
	}
	public Double getW14Wxds() {
		return w14Wxds;
	}
	public void setW14Wxds(Double w14Wxds) {
		this.w14Wxds = w14Wxds;
	}
	public Double getW15Wxds() {
		return w15Wxds;
	}
	public void setW15Wxds(Double w15Wxds) {
		this.w15Wxds = w15Wxds;
	}
	public Double getW16Wxds() {
		return w16Wxds;
	}
	public void setW16Wxds(Double w16Wxds) {
		this.w16Wxds = w16Wxds;
	}
	public Double getW17Wxds() {
		return w17Wxds;
	}
	public void setW17Wxds(Double w17Wxds) {
		this.w17Wxds = w17Wxds;
	}
	
}