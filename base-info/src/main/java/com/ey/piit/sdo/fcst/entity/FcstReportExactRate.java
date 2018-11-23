package com.ey.piit.sdo.fcst.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 采购FCST准确率报表Entity
 * @author 邓海
 */
public class FcstReportExactRate extends BaseEntity {
	
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String pid;		// PID
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String ywz;		// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String ny;//年月
	
	private Double ycs;//当月预测数
	private Double dds;//当月订单数
	private Double pcz;//当月偏差值
	private Double zql;//当月准确率
	
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
	private Double w18Ycs;		// 第18周预测数
	private Double w19Ycs;		// 第19周预测数
	private Double w20Ycs;		// 第20周预测数

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
	private Double w18Dds;		// 第18周订单数
	private Double w19Dds;		// 第19周订单数
	private Double w20Dds;		// 第20周订单数
	
	private Double w1Pcz;		// 第1周偏差值
	private Double w2Pcz;		// 第2周偏差值	
	private Double w3Pcz;		// 第3周偏差值
	private Double w4Pcz;		// 第4周偏差值
	private Double w5Pcz;		// 第5周偏差值
	private Double w6Pcz;		// 第6周偏差值
	private Double w7Pcz;		// 第7周偏差值
	private Double w8Pcz;		// 第8周偏差值
	private Double w9Pcz;		// 第9周偏差值
	private Double w10Pcz;		// 第10周偏差值
	private Double w11Pcz;		// 第11周偏差值
	private Double w12Pcz;		// 第12周偏差值
	private Double w13Pcz;		// 第13周偏差值
	private Double w14Pcz;		// 第14周偏差值
	private Double w15Pcz;		// 第15周偏差值
	private Double w16Pcz;		// 第16周偏差值
	private Double w17Pcz;		// 第17周偏差值
	private Double w18Pcz;		// 第18周偏差值
	private Double w19Pcz;		// 第19周偏差值
	private Double w20Pcz;		// 第20周偏差值
	
	private Double w1Zql;		// 第1周准确率
	private Double w2Zql;		// 第2周准确率	
	private Double w3Zql;		// 第3周准确率
	private Double w4Zql;		// 第4周准确率
	private Double w5Zql;		// 第5周准确率
	private Double w6Zql;		// 第6周准确率
	private Double w7Zql;		// 第7周准确率
	private Double w8Zql;		// 第8周准确率
	private Double w9Zql;		// 第9周准确率
	private Double w10Zql;		// 第10周准确率
	private Double w11Zql;		// 第11周准确率
	private Double w12Zql;		// 第12周准确率
	private Double w13Zql;		// 第13周准确率
	private Double w14Zql;		// 第14周准确率
	private Double w15Zql;		// 第15周准确率
	private Double w16Zql;		// 第16周准确率
	private Double w17Zql;		// 第17周准确率
	private Double w18Zql;		// 第18周准确率
	private Double w19Zql;		// 第19周准确率
	private Double w20Zql;		// 第20周准确率

	
	public FcstReportExactRate() {
		super();
	}

	public FcstReportExactRate(String id){
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

	public Double getPcz() {
		return pcz;
	}

	public void setPcz(Double pcz) {
		this.pcz = pcz;
	}

	public Double getZql() {
		return zql;
	}

	public void setZql(Double zql) {
		this.zql = zql;
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

	public Double getW18Ycs() {
		return w18Ycs;
	}

	public void setW18Ycs(Double w18Ycs) {
		this.w18Ycs = w18Ycs;
	}

	public Double getW19Ycs() {
		return w19Ycs;
	}

	public void setW19Ycs(Double w19Ycs) {
		this.w19Ycs = w19Ycs;
	}

	public Double getW20Ycs() {
		return w20Ycs;
	}

	public void setW20Ycs(Double w20Ycs) {
		this.w20Ycs = w20Ycs;
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

	public Double getW18Dds() {
		return w18Dds;
	}

	public void setW18Dds(Double w18Dds) {
		this.w18Dds = w18Dds;
	}

	public Double getW19Dds() {
		return w19Dds;
	}

	public void setW19Dds(Double w19Dds) {
		this.w19Dds = w19Dds;
	}

	public Double getW20Dds() {
		return w20Dds;
	}

	public void setW20Dds(Double w20Dds) {
		this.w20Dds = w20Dds;
	}

	public Double getW1Pcz() {
		return w1Pcz;
	}

	public void setW1Pcz(Double w1Pcz) {
		this.w1Pcz = w1Pcz;
	}

	public Double getW2Pcz() {
		return w2Pcz;
	}

	public void setW2Pcz(Double w2Pcz) {
		this.w2Pcz = w2Pcz;
	}

	public Double getW3Pcz() {
		return w3Pcz;
	}

	public void setW3Pcz(Double w3Pcz) {
		this.w3Pcz = w3Pcz;
	}

	public Double getW4Pcz() {
		return w4Pcz;
	}

	public void setW4Pcz(Double w4Pcz) {
		this.w4Pcz = w4Pcz;
	}

	public Double getW5Pcz() {
		return w5Pcz;
	}

	public void setW5Pcz(Double w5Pcz) {
		this.w5Pcz = w5Pcz;
	}

	public Double getW6Pcz() {
		return w6Pcz;
	}

	public void setW6Pcz(Double w6Pcz) {
		this.w6Pcz = w6Pcz;
	}

	public Double getW7Pcz() {
		return w7Pcz;
	}

	public void setW7Pcz(Double w7Pcz) {
		this.w7Pcz = w7Pcz;
	}

	public Double getW8Pcz() {
		return w8Pcz;
	}

	public void setW8Pcz(Double w8Pcz) {
		this.w8Pcz = w8Pcz;
	}

	public Double getW9Pcz() {
		return w9Pcz;
	}

	public void setW9Pcz(Double w9Pcz) {
		this.w9Pcz = w9Pcz;
	}

	public Double getW10Pcz() {
		return w10Pcz;
	}

	public void setW10Pcz(Double w10Pcz) {
		this.w10Pcz = w10Pcz;
	}

	public Double getW11Pcz() {
		return w11Pcz;
	}

	public void setW11Pcz(Double w11Pcz) {
		this.w11Pcz = w11Pcz;
	}

	public Double getW12Pcz() {
		return w12Pcz;
	}

	public void setW12Pcz(Double w12Pcz) {
		this.w12Pcz = w12Pcz;
	}

	public Double getW13Pcz() {
		return w13Pcz;
	}

	public void setW13Pcz(Double w13Pcz) {
		this.w13Pcz = w13Pcz;
	}

	public Double getW14Pcz() {
		return w14Pcz;
	}

	public void setW14Pcz(Double w14Pcz) {
		this.w14Pcz = w14Pcz;
	}

	public Double getW15Pcz() {
		return w15Pcz;
	}

	public void setW15Pcz(Double w15Pcz) {
		this.w15Pcz = w15Pcz;
	}

	public Double getW16Pcz() {
		return w16Pcz;
	}

	public void setW16Pcz(Double w16Pcz) {
		this.w16Pcz = w16Pcz;
	}

	public Double getW17Pcz() {
		return w17Pcz;
	}

	public void setW17Pcz(Double w17Pcz) {
		this.w17Pcz = w17Pcz;
	}

	public Double getW18Pcz() {
		return w18Pcz;
	}

	public void setW18Pcz(Double w18Pcz) {
		this.w18Pcz = w18Pcz;
	}

	public Double getW19Pcz() {
		return w19Pcz;
	}

	public void setW19Pcz(Double w19Pcz) {
		this.w19Pcz = w19Pcz;
	}

	public Double getW20Pcz() {
		return w20Pcz;
	}

	public void setW20Pcz(Double w20Pcz) {
		this.w20Pcz = w20Pcz;
	}

	public Double getW1Zql() {
		return w1Zql;
	}

	public void setW1Zql(Double w1Zql) {
		this.w1Zql = w1Zql;
	}

	public Double getW2Zql() {
		return w2Zql;
	}

	public void setW2Zql(Double w2Zql) {
		this.w2Zql = w2Zql;
	}

	public Double getW3Zql() {
		return w3Zql;
	}

	public void setW3Zql(Double w3Zql) {
		this.w3Zql = w3Zql;
	}

	public Double getW4Zql() {
		return w4Zql;
	}

	public void setW4Zql(Double w4Zql) {
		this.w4Zql = w4Zql;
	}

	public Double getW5Zql() {
		return w5Zql;
	}

	public void setW5Zql(Double w5Zql) {
		this.w5Zql = w5Zql;
	}

	public Double getW6Zql() {
		return w6Zql;
	}

	public void setW6Zql(Double w6Zql) {
		this.w6Zql = w6Zql;
	}

	public Double getW7Zql() {
		return w7Zql;
	}

	public void setW7Zql(Double w7Zql) {
		this.w7Zql = w7Zql;
	}

	public Double getW8Zql() {
		return w8Zql;
	}

	public void setW8Zql(Double w8Zql) {
		this.w8Zql = w8Zql;
	}

	public Double getW9Zql() {
		return w9Zql;
	}

	public void setW9Zql(Double w9Zql) {
		this.w9Zql = w9Zql;
	}

	public Double getW10Zql() {
		return w10Zql;
	}

	public void setW10Zql(Double w10Zql) {
		this.w10Zql = w10Zql;
	}

	public Double getW11Zql() {
		return w11Zql;
	}

	public void setW11Zql(Double w11Zql) {
		this.w11Zql = w11Zql;
	}

	public Double getW12Zql() {
		return w12Zql;
	}

	public void setW12Zql(Double w12Zql) {
		this.w12Zql = w12Zql;
	}

	public Double getW13Zql() {
		return w13Zql;
	}

	public void setW13Zql(Double w13Zql) {
		this.w13Zql = w13Zql;
	}

	public Double getW14Zql() {
		return w14Zql;
	}

	public void setW14Zql(Double w14Zql) {
		this.w14Zql = w14Zql;
	}

	public Double getW15Zql() {
		return w15Zql;
	}

	public void setW15Zql(Double w15Zql) {
		this.w15Zql = w15Zql;
	}

	public Double getW16Zql() {
		return w16Zql;
	}

	public void setW16Zql(Double w16Zql) {
		this.w16Zql = w16Zql;
	}

	public Double getW17Zql() {
		return w17Zql;
	}

	public void setW17Zql(Double w17Zql) {
		this.w17Zql = w17Zql;
	}

	public Double getW18Zql() {
		return w18Zql;
	}

	public void setW18Zql(Double w18Zql) {
		this.w18Zql = w18Zql;
	}

	public Double getW19Zql() {
		return w19Zql;
	}

	public void setW19Zql(Double w19Zql) {
		this.w19Zql = w19Zql;
	}

	public Double getW20Zql() {
		return w20Zql;
	}

	public void setW20Zql(Double w20Zql) {
		this.w20Zql = w20Zql;
	}

	public String getNy() {
		return ny;
	}

	public void setNy(String ny) {
		this.ny = ny;
	}


}