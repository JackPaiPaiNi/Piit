package com.ey.piit.sdo.fcst.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 采购FCST临时填报Entity
 * @author 邓海
 */
public class TmpFcstData extends BaseEntity {
	
	private String khbm;	// 客户编码
	private String khmc;	// 客户名称
	private String pid;		// PID
	private String xsyid;	// 销售员
	private String xsymc;	// 销售员名称
	private String ywz;		// 业务组
	private String ywzmc;	// 业务组名称
	private String xszz;	// 销售组织
	private String xszzmc;	// 销售组织名称
	private String lrfs;	// 录入方式
	private String lrfsmc;	// 录入方式名称
	private String pp;		// 品牌
	private String xwgj;	// 销往国家
	private String xwgjbm;	// 销往国家编码
	private String xwgjmc;	// 销往国家名称
	private String zhfs;	// 走货方式
	private String zhfsmc;	// 走货方式名称
	private String ddlb;	// 订单类别
	private String ddlbbm;	// 订单类别编码
	private String ddlbmc;	// 订单类别名称
	private Double cc;		// 尺寸
	private String jixing;	// 机型
	private String jixin;	// 机芯
	private String mcufa;	// MCU方案
	private String sjyp;	// 实际用屏
	private Double ycs;		// 预测数
	private Double dds;		// 订单数
	private Double wxds;	// 未下单数
	private String zc;		// 周次
	private String kszc;	//开始周次
	private String jszc;	//结束周次
	private Double w1Ycs=0.0;	// 第1周预测数
	private Double w2Ycs=0.0;	// 第2周预测数	
	private Double w3Ycs=0.0;	// 第3周预测数
	private Double w4Ycs=0.0;	// 第4周预测数
	private Double w5Ycs=0.0;	// 第5周预测数
	private Double w6Ycs=0.0;	// 第6周预测数
	private Double w7Ycs=0.0;	// 第7周预测数
	private Double w8Ycs=0.0;	// 第8周预测数
	private Double w9Ycs=0.0;	// 第9周预测数
	private Double w10Ycs=0.0;	// 第10周预测数
	private Double w11Ycs=0.0;	// 第11周预测数
	private Double w12Ycs=0.0;	// 第12周预测数
	private Double w13Ycs=0.0;	// 第13周预测数
	private Double w14Ycs=0.0;	// 第14周预测数
	private Double w15Ycs=0.0;	// 第15周预测数
	private Double w16Ycs=0.0;	// 第16周预测数
	private Double w17Ycs=0.0;	// 第17周预测数
	private Double w18Ycs=0.0;	// 第18周预测数
	private Double w19Ycs=0.0;	// 第19周预测数
	private Double w20Ycs=0.0;	// 第20周预测数
	private Double w21Ycs=0.0;	// 第21周预测数
	private Double w22Ycs=0.0;	// 第22周预测数
	private Double w23Ycs=0.0;	// 第23周预测数
	private Double w24Ycs=0.0;	// 第24周预测数
	private Double w25Ycs=0.0;	// 第25周预测数
	private Double w1Dds=0.0;	// 第1周订单数
	private Double w2Dds=0.0;	// 第2周订单数	
	private Double w3Dds=0.0;	// 第3周订单数
	private Double w4Dds=0.0;	// 第4周订单数
	private Double w5Dds=0.0;	// 第5周订单数
	private Double w6Dds=0.0;	// 第6周订单数
	private Double w7Dds=0.0;	// 第7周订单数
	private Double w8Dds=0.0;	// 第8周订单数
	private Double w9Dds=0.0;	// 第9周订单数
	private Double w10Dds=0.0;	// 第10周订单数
	private Double w11Dds=0.0;	// 第11周订单数
	private Double w12Dds=0.0;	// 第12周订单数
	private Double w13Dds=0.0;	// 第13周订单数
	private Double w14Dds=0.0;	// 第14周订单数
	private Double w15Dds=0.0;	// 第15周订单数
	private Double w16Dds=0.0;	// 第16周订单数
	private Double w17Dds=0.0;	// 第17周订单数
	private Double w18Dds=0.0;	// 第18周订单数
	private Double w19Dds=0.0;	// 第19周订单数
	private Double w20Dds=0.0;	// 第20周订单数
	private Double w21Dds=0.0;	// 第21周订单数
	private Double w22Dds=0.0;	// 第22周订单数
	private Double w23Dds=0.0;	// 第23周订单数
	private Double w24Dds=0.0;	// 第24周订单数
	private Double w25Dds=0.0;	// 第25周未下单数
	private Double w1Wxds=0.0;	// 第1周未下单数
	private Double w2Wxds=0.0;	// 第2周未下单数
	private Double w3Wxds=0.0;	// 第3周未下单数
	private Double w4Wxds=0.0;	// 第4周未下单数
	private Double w5Wxds=0.0;	// 第5周未下单数
	private Double w6Wxds=0.0;	// 第6周未下单数
	private Double w7Wxds=0.0;	// 第7周未下单数
	private Double w8Wxds=0.0;	// 第8周未下单数
	private Double w9Wxds=0.0;	// 第9周未下单数
	private Double w10Wxds=0.0;	// 第10周未下单数
	private Double w11Wxds=0.0;	// 第11周未下单数
	private Double w12Wxds=0.0;	// 第12周未下单数
	private Double w13Wxds=0.0;	// 第13周未下单数
	private Double w14Wxds=0.0;	// 第14周未下单数
	private Double w15Wxds=0.0;	// 第15周未下单数
	private Double w16Wxds=0.0;	// 第16周未下单数
	private Double w17Wxds=0.0;	// 第17周未下单数
	private Double w18Wxds=0.0;	// 第18周未下单数
	private Double w19Wxds=0.0;	// 第19周未下单数
	private Double w20Wxds=0.0;	// 第20周未下单数
	private Double w21Wxds=0.0;	// 第21周未下单数
	private Double w22Wxds=0.0;	// 第22周未下单数
	private Double w23Wxds=0.0;	// 第23周未下单数
	private Double w24Wxds=0.0;	// 第24周未下单数
	private Double w25Wxds=0.0;	// 第25周未下单数
	private String zdrid;	// 制单人
	private String zdrmc;	// 制单人名称
	private Date zdsj;		// 制单时间
	private String sjc;     //时间戳
	
	public TmpFcstData() {
		super();
	}

	public TmpFcstData(String id){
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
	@Length(min=0, max=50, message="客户名称长度必须介于 0 和 50 之间")
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
     * PID
     */
	@Length(min=1, max=50, message="PID长度必须介于 1 和 50 之间")
	public String getPid() {
		return pid;
	}

	/**
     * PID
     */
	public void setPid(String pid) {
		this.pid = pid == null ? null : pid.trim();
	}
	
	/**
     * 销售员
     */
	@Length(min=0, max=20, message="销售员长度必须介于 0 和 20 之间")
	public String getXsyid() {
		return xsyid;
	}

	/**
     * 销售员
     */
	public void setXsyid(String xsyid) {
		this.xsyid = xsyid == null ? null : xsyid.trim();
	}
	
	/**
     * 销售员名称
     */
	@Length(min=0, max=50, message="销售员名称长度必须介于 0 和 50 之间")
	public String getXsymc() {
		return xsymc;
	}

	/**
     * 销售员名称
     */
	public void setXsymc(String xsymc) {
		this.xsymc = xsymc == null ? null : xsymc.trim();
	}
	
	/**
     * 业务组
     */
	@Length(min=0, max=20, message="业务组长度必须介于 0 和 20 之间")
	public String getYwz() {
		return ywz;
	}

	/**
     * 业务组
     */
	public void setYwz(String ywz) {
		this.ywz = ywz == null ? null : ywz.trim();
	}
	
	/**
     * 业务组名称
     */
	@Length(min=0, max=50, message="业务组名称长度必须介于 0 和 50 之间")
	public String getYwzmc() {
		return ywzmc;
	}

	/**
     * 业务组名称
     */
	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc == null ? null : ywzmc.trim();
	}
	
	/**
     * 销售组织
     */
	@Length(min=0, max=20, message="销售组织长度必须介于 0 和 20 之间")
	public String getXszz() {
		return xszz;
	}

	/**
     * 销售组织
     */
	public void setXszz(String xszz) {
		this.xszz = xszz == null ? null : xszz.trim();
	}
	
	/**
     * 销售组织名称
     */
	@Length(min=0, max=50, message="销售组织名称长度必须介于 0 和 50 之间")
	public String getXszzmc() {
		return xszzmc;
	}

	/**
     * 销售组织名称
     */
	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc == null ? null : xszzmc.trim();
	}
	
	/**
     * 录入方式
     */
	@Length(min=0, max=20, message="录入方式长度必须介于 0 和 20 之间")
	public String getLrfs() {
		return lrfs;
	}

	/**
     * 录入方式
     */
	public void setLrfs(String lrfs) {
		this.lrfs = lrfs == null ? null : lrfs.trim();
	}
	
	/**
     * 录入方式名称
     */
	@Length(min=0, max=50, message="录入方式名称长度必须介于 0 和 50 之间")
	public String getLrfsmc() {
		return lrfsmc;
	}

	/**
     * 录入方式名称
     */
	public void setLrfsmc(String lrfsmc) {
		this.lrfsmc = lrfsmc == null ? null : lrfsmc.trim();
	}
	
	/**
     * 品牌
     */
	@Length(min=0, max=50, message="品牌长度必须介于 0 和 50 之间")
	public String getPp() {
		return pp;
	}

	/**
     * 品牌
     */
	public void setPp(String pp) {
		this.pp = pp == null ? null : pp.trim();
	}
	
	/**
     * 销往国家
     */
	@Length(min=0, max=20, message="销往国家长度必须介于 0 和 20 之间")
	public String getXwgj() {
		return xwgj;
	}

	/**
     * 销往国家
     */
	public void setXwgj(String xwgj) {
		this.xwgj = xwgj == null ? null : xwgj.trim();
	}
	
	/**
     * 销往国家名称
     */
	@Length(min=0, max=50, message="销往国家名称长度必须介于 0 和 50 之间")
	public String getXwgjmc() {
		return xwgjmc;
	}

	/**
     * 销往国家名称
     */
	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc == null ? null : xwgjmc.trim();
	}
	
	/**
     * 走货方式
     */
	@Length(min=0, max=20, message="走货方式长度必须介于 0 和 20 之间")
	public String getZhfs() {
		return zhfs;
	}

	/**
     * 走货方式
     */
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs == null ? null : zhfs.trim();
	}
	
	/**
     * 走货方式名称
     */
	@Length(min=0, max=50, message="走货方式名称长度必须介于 0 和 50 之间")
	public String getZhfsmc() {
		return zhfsmc;
	}

	/**
     * 走货方式名称
     */
	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc == null ? null : zhfsmc.trim();
	}
	
	/**
     * 订单类别
     */
	@Length(min=0, max=20, message="订单类别长度必须介于 0 和 20 之间")
	public String getDdlb() {
		return ddlb;
	}

	/**
     * 订单类别
     */
	public void setDdlb(String ddlb) {
		this.ddlb = ddlb == null ? null : ddlb.trim();
	}
	
	/**
     * 订单类别名称
     */
	@Length(min=0, max=50, message="订单类别名称长度必须介于 0 和 50 之间")
	public String getDdlbmc() {
		return ddlbmc;
	}

	/**
     * 订单类别名称
     */
	public void setDdlbmc(String ddlbmc) {
		this.ddlbmc = ddlbmc == null ? null : ddlbmc.trim();
	}
	
	/**
     * 尺寸
     */
	public Double getCc() {
		return cc;
	}

	/**
     * 尺寸
     */
	public void setCc(Double cc) {
		this.cc = cc;
	}
	
	/**
     * 机型
     */
	@Length(min=0, max=50, message="机型长度必须介于 0 和 50 之间")
	public String getJixing() {
		return jixing;
	}

	/**
     * 机型
     */
	public void setJixing(String jixing) {
		this.jixing = jixing == null ? null : jixing.trim();
	}
	
	/**
     * 机芯
     */
	@Length(min=0, max=50, message="机芯长度必须介于 0 和 50 之间")
	public String getJixin() {
		return jixin;
	}

	/**
     * 机芯
     */
	public void setJixin(String jixin) {
		this.jixin = jixin == null ? null : jixin.trim();
	}
	
	/**
     * MCU方案
     */
	@Length(min=0, max=50, message="MCU方案长度必须介于 0 和 50 之间")
	public String getMcufa() {
		return mcufa;
	}

	/**
     * MCU方案
     */
	public void setMcufa(String mcufa) {
		this.mcufa = mcufa == null ? null : mcufa.trim();
	}
	
	/**
     * 实际用屏
     */
	@Length(min=0, max=50, message="实际用屏长度必须介于 0 和 50 之间")
	public String getSjyp() {
		return sjyp;
	}

	/**
     * 实际用屏
     */
	public void setSjyp(String sjyp) {
		this.sjyp = sjyp == null ? null : sjyp.trim();
	}
	
	/**
     * 周次
     */
	@Length(min=1, max=5, message="周次长度必须介于 1 和 5 之间")
	public String getZc() {
		return zc;
	}

	/**
     * 周次
     */
	public void setZc(String zc) {
		this.zc = zc == null ? null : zc.trim();
	}

	public Double getW1Ycs() {
		return w1Ycs;
	}

	public void setW1Ycs(Double w1Ycs) {
		this.w1Ycs =  w1Ycs == null ? 0.0 : w1Ycs;
	}

	public Double getW2Ycs() {
		return w2Ycs;
	}

	public void setW2Ycs(Double w2Ycs) {
		this.w2Ycs = w2Ycs == null ? 0.0 : w2Ycs;
	}

	public Double getW3Ycs() {
		return w3Ycs;
	}

	public void setW3Ycs(Double w3Ycs) {
		this.w3Ycs = w3Ycs == null ? 0.0 : w3Ycs;
	}

	public Double getW4Ycs() {
		return w4Ycs;
	}

	public void setW4Ycs(Double w4Ycs) {
		this.w4Ycs = w4Ycs == null ? 0.0 : w4Ycs;
	}

	public Double getW5Ycs() {
		return w5Ycs;
	}

	public void setW5Ycs(Double w5Ycs) {
		this.w5Ycs = w5Ycs == null ? 0.0 : w5Ycs;
	}

	public Double getW6Ycs() {
		return w6Ycs;
	}

	public void setW6Ycs(Double w6Ycs) {
		this.w6Ycs = w6Ycs == null ? 0.0 : w6Ycs;
	}

	public Double getW7Ycs() {
		return w7Ycs;
	}

	public void setW7Ycs(Double w7Ycs) {
		this.w7Ycs = w7Ycs == null ? 0.0 : w7Ycs;
	}

	public Double getW8Ycs() {
		return w8Ycs;
	}

	public void setW8Ycs(Double w8Ycs) {
		this.w8Ycs = w8Ycs == null ? 0.0 : w8Ycs;
	}

	public Double getW9Ycs() {
		return w9Ycs;
	}

	public void setW9Ycs(Double w9Ycs) {
		this.w9Ycs = w9Ycs == null ? 0.0 : w9Ycs;
	}

	public Double getW10Ycs() {
		return w10Ycs;
	}

	public void setW10Ycs(Double w10Ycs) {
		this.w10Ycs = w10Ycs == null ? 0.0 : w10Ycs;
	}

	public Double getW11Ycs() {
		return w11Ycs;
	}

	public void setW11Ycs(Double w11Ycs) {
		this.w11Ycs = w11Ycs == null ? 0.0 : w11Ycs;
	}

	public Double getW12Ycs() {
		return w12Ycs;
	}

	public void setW12Ycs(Double w12Ycs) {
		this.w12Ycs = w12Ycs == null ? 0.0 : w12Ycs;
	}

	public Double getW13Ycs() {
		return w13Ycs;
	}

	public void setW13Ycs(Double w13Ycs) {
		this.w13Ycs = w13Ycs == null ? 0.0 : w13Ycs;
	}

	public Double getW14Ycs() {
		return w14Ycs;
	}

	public void setW14Ycs(Double w14Ycs) {
		this.w14Ycs = w14Ycs == null ? 0.0 : w14Ycs;
	}

	public Double getW15Ycs() {
		return w15Ycs;
	}

	public void setW15Ycs(Double w15Ycs) {
		this.w15Ycs = w15Ycs == null ? 0.0 : w15Ycs;
	}

	public Double getW16Ycs() {
		return w16Ycs;
	}

	public void setW16Ycs(Double w16Ycs) {
		this.w16Ycs = w16Ycs == null ? 0.0 : w16Ycs;
	}

	public Double getW17Ycs() {
		return w17Ycs;
	}

	public void setW17Ycs(Double w17Ycs) {
		this.w17Ycs = w17Ycs == null ? 0.0 : w17Ycs;
	}

	public Double getW18Ycs() {
		return w18Ycs;
	}

	public void setW18Ycs(Double w18Ycs) {
		this.w18Ycs = w18Ycs == null ? 0.0 : w18Ycs;
	}

	public Double getW19Ycs() {
		return w19Ycs;
	}

	public void setW19Ycs(Double w19Ycs) {
		this.w19Ycs = w19Ycs == null ? 0.0 : w19Ycs;
	}

	public Double getW20Ycs() {
		return w20Ycs;
	}

	public void setW20Ycs(Double w20Ycs) {
		this.w20Ycs = w20Ycs == null ? 0.0 : w20Ycs;
	}

	public Double getW21Ycs() {
		return w21Ycs;
	}

	public void setW21Ycs(Double w21Ycs) {
		this.w21Ycs = w21Ycs == null ? 0.0 : w21Ycs;
	}

	public Double getW22Ycs() {
		return w22Ycs;
	}

	public void setW22Ycs(Double w22Ycs) {
		this.w22Ycs = w22Ycs == null ? 0.0 : w22Ycs;
	}

	public Double getW23Ycs() {
		return w23Ycs;
	}

	public void setW23Ycs(Double w23Ycs) {
		this.w23Ycs = w23Ycs == null ? 0.0 : w23Ycs;
	}

	public Double getW24Ycs() {
		return w24Ycs;
	}

	public void setW24Ycs(Double w24Ycs) {
		this.w24Ycs = w24Ycs == null ? 0.0 : w24Ycs;
	}

	public Double getW25Ycs() {
		return w25Ycs;
	}

	public void setW25Ycs(Double w25Ycs) {
		this.w25Ycs = w25Ycs == null ? 0.0 : w25Ycs;
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

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}

	public Double getW1Dds() {
		return w1Dds;
	}

	public void setW1Dds(Double w1Dds) {
		this.w1Dds = w1Dds == null ? 0.0 : w1Dds;
	}

	public Double getW2Dds() {
		return w2Dds;
	}

	public void setW2Dds(Double w2Dds) {
		this.w2Dds = w2Dds == null ? 0.0 : w2Dds;
	}

	public Double getW3Dds() {
		return w3Dds;
	}

	public void setW3Dds(Double w3Dds) {
		this.w3Dds = w3Dds == null ? 0.0 : w3Dds;
	}

	public Double getW4Dds() {
		return w4Dds;
	}

	public void setW4Dds(Double w4Dds) {
		this.w4Dds = w4Dds == null ? 0.0 : w4Dds;
	}

	public Double getW5Dds() {
		return w5Dds;
	}

	public void setW5Dds(Double w5Dds) {
		this.w5Dds = w5Dds == null ? 0.0 : w5Dds;
	}

	public Double getW6Dds() {
		return w6Dds;
	}

	public void setW6Dds(Double w6Dds) {
		this.w6Dds = w6Dds == null ? 0.0 : w6Dds;
	}

	public Double getW7Dds() {
		return w7Dds;
	}

	public void setW7Dds(Double w7Dds) {
		this.w7Dds = w7Dds == null ? 0.0 : w7Dds;
	}

	public Double getW8Dds() {
		return w8Dds;
	}

	public void setW8Dds(Double w8Dds) {
		this.w8Dds = w8Dds == null ? 0.0 : w8Dds;
	}

	public Double getW9Dds() {
		return w9Dds;
	}

	public void setW9Dds(Double w9Dds) {
		this.w9Dds = w9Dds == null ? 0.0 : w9Dds;
	}

	public Double getW10Dds() {
		return w10Dds;
	}

	public void setW10Dds(Double w10Dds) {
		this.w10Dds = w10Dds == null ? 0.0 : w10Dds;
	}

	public Double getW11Dds() {
		return w11Dds;
	}

	public void setW11Dds(Double w11Dds) {
		this.w11Dds = w11Dds == null ? 0.0 : w11Dds;
	}

	public Double getW12Dds() {
		return w12Dds;
	}

	public void setW12Dds(Double w12Dds) {
		this.w12Dds = w12Dds == null ? 0.0 : w12Dds;
	}

	public Double getW13Dds() {
		return w13Dds;
	}

	public void setW13Dds(Double w13Dds) {
		this.w13Dds = w13Dds == null ? 0.0 : w13Dds;
	}

	public Double getW14Dds() {
		return w14Dds;
	}

	public void setW14Dds(Double w14Dds) {
		this.w14Dds = w14Dds == null ? 0.0 : w14Dds;
	}

	public Double getW15Dds() {
		return w15Dds;
	}

	public void setW15Dds(Double w15Dds) {
		this.w15Dds = w15Dds == null ? 0.0 : w15Dds;
	}

	public Double getW16Dds() {
		return w16Dds;
	}

	public void setW16Dds(Double w16Dds) {
		this.w16Dds = w16Dds == null ? 0.0 : w16Dds;
	}

	public Double getW17Dds() {
		return w17Dds;
	}

	public void setW17Dds(Double w17Dds) {
		this.w17Dds = w17Dds == null ? 0.0 : w17Dds;
	}

	public Double getW18Dds() {
		return w18Dds;
	}

	public void setW18Dds(Double w18Dds) {
		this.w18Dds = w18Dds == null ? 0.0 : w18Dds;
	}

	public Double getW19Dds() {
		return w19Dds;
	}

	public void setW19Dds(Double w19Dds) {
		this.w19Dds = w19Dds == null ? 0.0 : w19Dds;
	}

	public Double getW20Dds() {
		return w20Dds;
	}

	public void setW20Dds(Double w20Dds) {
		this.w20Dds = w20Dds == null ? 0.0 : w20Dds;
	}

	public Double getW21Dds() {
		return w21Dds;
	}

	public void setW21Dds(Double w21Dds) {
		this.w21Dds = w21Dds == null ? 0.0 : w21Dds;
	}

	public Double getW22Dds() {
		return w22Dds;
	}

	public void setW22Dds(Double w22Dds) {
		this.w22Dds = w22Dds == null ? 0.0 : w22Dds;
	}

	public Double getW23Dds() {
		return w23Dds;
	}

	public void setW23Dds(Double w23Dds) {
		this.w23Dds = w23Dds == null ? 0.0 : w23Dds;
	}

	public Double getW24Dds() {
		return w24Dds;
	}

	public void setW24Dds(Double w24Dds) {
		this.w24Dds = w24Dds == null ? 0.0 : w24Dds;
	}

	public Double getW25Dds() {
		return w25Dds;
	}

	public void setW25Dds(Double w25Dds) {
		this.w25Dds = w25Dds == null ? 0.0 : w25Dds;
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
	/**
     * 未下单数
     */
	public Double getWxds() {
		return wxds;
	}

	/**
     * 未下单数
     */
	public void setWxds(Double wxds) {
		this.wxds = wxds;
	}

	public Double getW1Wxds() {
		return w1Wxds;
	}

	public void setW1Wxds(Double w1Wxds) {
		this.w1Wxds = w1Wxds == null ? 0.0 : w1Wxds;
	}

	public Double getW2Wxds() {
		return w2Wxds;
	}

	public void setW2Wxds(Double w2Wxds) {
		this.w2Wxds = w2Wxds == null ? 0.0 : w2Wxds;
	}

	public Double getW3Wxds() {
		return w3Wxds;
	}

	public void setW3Wxds(Double w3Wxds) {
		this.w3Wxds = w3Wxds == null ? 0.0 : w3Wxds;
	}

	public Double getW4Wxds() {
		return w4Wxds;
	}

	public void setW4Wxds(Double w4Wxds) {
		this.w4Wxds = w4Wxds == null ? 0.0 : w4Wxds;
	}

	public Double getW5Wxds() {
		return w5Wxds;
	}

	public void setW5Wxds(Double w5Wxds) {
		this.w5Wxds = w5Wxds == null ? 0.0 : w5Wxds;
	}

	public Double getW6Wxds() {
		return w6Wxds;
	}

	public void setW6Wxds(Double w6Wxds) {
		this.w6Wxds = w6Wxds == null ? 0.0 : w6Wxds;
	}

	public Double getW7Wxds() {
		return w7Wxds;
	}

	public void setW7Wxds(Double w7Wxds) {
		this.w7Wxds = w7Wxds == null ? 0.0 : w7Wxds;
	}

	public Double getW8Wxds() {
		return w8Wxds;
	}

	public void setW8Wxds(Double w8Wxds) {
		this.w8Wxds = w8Wxds == null ? 0.0 : w8Wxds;
	}

	public Double getW9Wxds() {
		return w9Wxds;
	}

	public void setW9Wxds(Double w9Wxds) {
		this.w9Wxds = w9Wxds == null ? 0.0 : w9Wxds;
	}

	public Double getW10Wxds() {
		return w10Wxds;
	}

	public void setW10Wxds(Double w10Wxds) {
		this.w10Wxds = w10Wxds == null ? 0.0 : w10Wxds;
	}

	public Double getW11Wxds() {
		return w11Wxds;
	}

	public void setW11Wxds(Double w11Wxds) {
		this.w11Wxds = w11Wxds == null ? 0.0 : w11Wxds;
	}

	public Double getW12Wxds() {
		return w12Wxds;
	}

	public void setW12Wxds(Double w12Wxds) {
		this.w12Wxds = w12Wxds == null ? 0.0 : w12Wxds;
	}

	public Double getW13Wxds() {
		return w13Wxds;
	}

	public void setW13Wxds(Double w13Wxds) {
		this.w13Wxds = w13Wxds == null ? 0.0 : w13Wxds;
	}

	public Double getW14Wxds() {
		return w14Wxds;
	}

	public void setW14Wxds(Double w14Wxds) {
		this.w14Wxds = w14Wxds == null ? 0.0 : w14Wxds;
	}

	public Double getW15Wxds() {
		return w15Wxds;
	}

	public void setW15Wxds(Double w15Wxds) {
		this.w15Wxds = w15Wxds == null ? 0.0 : w15Wxds;
	}

	public Double getW16Wxds() {
		return w16Wxds;
	}

	public void setW16Wxds(Double w16Wxds) {
		this.w16Wxds = w16Wxds == null ? 0.0 : w16Wxds;
	}

	public Double getW17Wxds() {
		return w17Wxds;
	}

	public void setW17Wxds(Double w17Wxds) {
		this.w17Wxds = w17Wxds == null ? 0.0 : w17Wxds;
	}

	public Double getW18Wxds() {
		return w18Wxds;
	}

	public void setW18Wxds(Double w18Wxds) {
		this.w18Wxds = w18Wxds == null ? 0.0 : w18Wxds;
	}

	public Double getW19Wxds() {
		return w19Wxds;
	}

	public void setW19Wxds(Double w19Wxds) {
		this.w19Wxds = w19Wxds == null ? 0.0 : w19Wxds;
	}

	public Double getW20Wxds() {
		return w20Wxds;
	}

	public void setW20Wxds(Double w20Wxds) {
		this.w20Wxds = w20Wxds == null ? 0.0 : w20Wxds;
	}

	public Double getW21Wxds() {
		return w21Wxds;
	}

	public void setW21Wxds(Double w21Wxds) {
		this.w21Wxds = w21Wxds == null ? 0.0 : w21Wxds;
	}

	public Double getW22Wxds() {
		return w22Wxds;
	}

	public void setW22Wxds(Double w22Wxds) {
		this.w22Wxds = w22Wxds == null ? 0.0 : w22Wxds;
	}

	public Double getW23Wxds() {
		return w23Wxds;
	}

	public void setW23Wxds(Double w23Wxds) {
		this.w23Wxds = w23Wxds == null ? 0.0 : w23Wxds;
	}

	public Double getW24Wxds() {
		return w24Wxds;
	}

	public void setW24Wxds(Double w24Wxds) {
		this.w24Wxds = w24Wxds == null ? 0.0 : w24Wxds;
	}

	public Double getW25Wxds() {
		return w25Wxds;
	}

	public void setW25Wxds(Double w25Wxds) {
		this.w25Wxds = w25Wxds == null ? 0.0 : w25Wxds;
	}

	public String getDdlbbm() {
		return ddlbbm;
	}

	public void setDdlbbm(String ddlbbm) {
		this.ddlbbm = ddlbbm;
	}

	public String getKszc() {
		return kszc;
	}

	public void setKszc(String kszc) {
		this.kszc = kszc;
	}

	public String getJszc() {
		return jszc;
	}

	public void setJszc(String jszc) {
		this.jszc = jszc;
	}

	public String getXwgjbm() {
		return xwgjbm;
	}

	public void setXwgjbm(String xwgjbm) {
		this.xwgjbm = xwgjbm;
	}
	
}