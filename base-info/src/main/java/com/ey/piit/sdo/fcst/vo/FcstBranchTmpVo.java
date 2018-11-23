package com.ey.piit.sdo.fcst.vo;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 分公司销售数据填报Entity
 * 
 * @author 赵桃军
 */
public class FcstBranchTmpVo extends BaseEntity {
	
	private String fgsdm   ;  // 分公司代码
	private String fgsmc   ;  // 分公司名称
	private String jixings ;  // 机型，逗号分隔
	private String cc;        // 尺寸
	private String ny;        // 年月
	private String xm;        // 项目
	private String zbxh;      // 总部型号
	private String fgsxh;     // 分公司型号
	private String jhjcc;     // 合计
	private String jixing;    // 机型
	private String jixingH;    
	private String jixingT;
	private String ywz;
	private String ywzmc;
	private String xszz;
	private String xszzmc;
	private String ywzH;
	private String ywzT;
	private String pid ;
	private String pidH;
	private String pidT;
	private String zdrid;
	private String zdrmc;
	private Date   zdsj;
	private String sjc;
	
	private String m1;
	private String m2;
	private String m3;
	private String m4;
	private String m5;
	private String m6;
	private String m7;
	private String m8;
	private String m9;
	private String m10;
	private String m11;
	private String m12;
	
	private String h1;
	private String h2;
	private String h3;
	private String h4;
	private String h5;
	private String h6;
	private String h7;
	private String h8;
	private String h9;
	private String h10;
	private String h11;
	private String h12;
	
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	private String t6;
	private String t7;
	private String t8;
	private String t9;
	private String t10;
	private String t11;
	private String t12;
	
	private String m1Ycs;
	private String m2Ycs;
	private String m3Ycs;
	private String m4Ycs;
	private String m5Ycs;
	private String m6Ycs;
	private String m7Ycs;
	private String m8Ycs;
	private String m9Ycs;
	private String m10Ycs;
	private String m11Ycs;
	private String m12Ycs;
	
	private String m1Sjs;
	private String m2Sjs;
	private String m3Sjs;
	private String m4Sjs;
	private String m5Sjs;
	private String m6Sjs;
	private String m7Sjs;
	private String m8Sjs;
	private String m9Sjs;
	private String m10Sjs;
	private String m11Sjs;
	private String m12Sjs;
	
	private String m1Dcl;
	private String m2Dcl;
	private String m3Dcl;
	private String m4Dcl;
	private String m5Dcl;
	private String m6Dcl;
	private String m7Dcl;
	private String m8Dcl;
	private String m9Dcl;
	private String m10Dcl;
	private String m11Dcl;
	private String m12Dcl;
	
	private Double j0cc;
	private Double j14cc;
	private Double j19cc;
	private Double j22cc;
	private Double j24cc;
	private Double j28cc;
	private Double j29cc;
	private Double j32cc;
	private Double j39cc;
	private Double j40cc;
	private Double j42cc;
	private Double j43cc;
	private Double j47cc;
	private Double j49cc;
	private Double j50cc;
	private Double j55cc;
	private Double j58cc;
	private Double j60cc;
	private Double j65cc;
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

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getJixings() {
		return jixings;
	}

	public void setJixings(String jixings) {
		this.jixings = jixings;
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

	public String getYwzH() {
		return ywzH;
	}

	public void setYwzH(String ywzH) {
		this.ywzH = ywzH;
	}

	public String getPidH() {
		return pidH;
	}

	public void setPidH(String pidH) {
		this.pidH = pidH;
	}

	public String getJixingH() {
		return jixingH;
	}

	public void setJixingH(String jixingH) {
		this.jixingH = jixingH;
	}

	public String getYwzT() {
		return ywzT;
	}

	public void setYwzT(String ywzT) {
		this.ywzT = ywzT;
	}

	public String getPidT() {
		return pidT;
	}

	public void setPidT(String pidT) {
		this.pidT = pidT;
	}

	public String getJixingT() {
		return jixingT;
	}

	public void setJixingT(String jixingT) {
		this.jixingT = jixingT;
	}

	public String getYwz() {
		return ywz;
	}

	public void setYwz(String ywz) {
		this.ywz = ywz;
	}

	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public String getH1() {
		return h1;
	}

	public void setH1(String h1) {
		this.h1 = h1;
	}

	public String getH2() {
		return h2;
	}

	public void setH2(String h2) {
		this.h2 = h2;
	}

	public String getH3() {
		return h3;
	}

	public void setH3(String h3) {
		this.h3 = h3;
	}

	public String getH4() {
		return h4;
	}

	public void setH4(String h4) {
		this.h4 = h4;
	}

	public String getH5() {
		return h5;
	}

	public void setH5(String h5) {
		this.h5 = h5;
	}

	public String getH6() {
		return h6;
	}

	public void setH6(String h6) {
		this.h6 = h6;
	}

	public String getH7() {
		return h7;
	}

	public void setH7(String h7) {
		this.h7 = h7;
	}

	public String getH8() {
		return h8;
	}

	public void setH8(String h8) {
		this.h8 = h8;
	}

	public String getH9() {
		return h9;
	}

	public void setH9(String h9) {
		this.h9 = h9;
	}

	public String getH10() {
		return h10;
	}

	public void setH10(String h10) {
		this.h10 = h10;
	}

	public String getH11() {
		return h11;
	}

	public void setH11(String h11) {
		this.h11 = h11;
	}

	public String getH12() {
		return h12;
	}

	public void setH12(String h12) {
		this.h12 = h12;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getT3() {
		return t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}

	public String getT4() {
		return t4;
	}

	public void setT4(String t4) {
		this.t4 = t4;
	}

	public String getT5() {
		return t5;
	}

	public void setT5(String t5) {
		this.t5 = t5;
	}

	public String getT6() {
		return t6;
	}

	public void setT6(String t6) {
		this.t6 = t6;
	}

	public String getT7() {
		return t7;
	}

	public void setT7(String t7) {
		this.t7 = t7;
	}

	public String getT8() {
		return t8;
	}

	public void setT8(String t8) {
		this.t8 = t8;
	}

	public String getT9() {
		return t9;
	}

	public void setT9(String t9) {
		this.t9 = t9;
	}

	public String getT10() {
		return t10;
	}

	public void setT10(String t10) {
		this.t10 = t10;
	}

	public String getT11() {
		return t11;
	}

	public void setT11(String t11) {
		this.t11 = t11;
	}

	public String getT12() {
		return t12;
	}

	public void setT12(String t12) {
		this.t12 = t12;
	}

	public String getM1() {
		return m1;
	}

	public void setM1(String m1) {
		this.m1 = m1;
	}

	public String getM2() {
		return m2;
	}

	public void setM2(String m2) {
		this.m2 = m2;
	}

	public String getM3() {
		return m3;
	}

	public void setM3(String m3) {
		this.m3 = m3;
	}

	public String getM4() {
		return m4;
	}

	public void setM4(String m4) {
		this.m4 = m4;
	}

	public String getM5() {
		return m5;
	}

	public void setM5(String m5) {
		this.m5 = m5;
	}

	public String getM6() {
		return m6;
	}

	public void setM6(String m6) {
		this.m6 = m6;
	}

	public String getM7() {
		return m7;
	}

	public void setM7(String m7) {
		this.m7 = m7;
	}

	public String getM8() {
		return m8;
	}

	public void setM8(String m8) {
		this.m8 = m8;
	}

	public String getM9() {
		return m9;
	}

	public void setM9(String m9) {
		this.m9 = m9;
	}

	public String getM10() {
		return m10;
	}

	public void setM10(String m10) {
		this.m10 = m10;
	}

	public String getM11() {
		return m11;
	}

	public void setM11(String m11) {
		this.m11 = m11;
	}

	public String getM12() {
		return m12;
	}

	public void setM12(String m12) {
		this.m12 = m12;
	}

	public String getM1Ycs() {
		return m1Ycs;
	}

	public void setM1Ycs(String m1Ycs) {
		this.m1Ycs = m1Ycs;
	}

	public String getM2Ycs() {
		return m2Ycs;
	}

	public void setM2Ycs(String m2Ycs) {
		this.m2Ycs = m2Ycs;
	}

	public String getM3Ycs() {
		return m3Ycs;
	}

	public void setM3Ycs(String m3Ycs) {
		this.m3Ycs = m3Ycs;
	}

	public String getM4Ycs() {
		return m4Ycs;
	}

	public void setM4Ycs(String m4Ycs) {
		this.m4Ycs = m4Ycs;
	}

	public String getM5Ycs() {
		return m5Ycs;
	}

	public void setM5Ycs(String m5Ycs) {
		this.m5Ycs = m5Ycs;
	}

	public String getM6Ycs() {
		return m6Ycs;
	}

	public void setM6Ycs(String m6Ycs) {
		this.m6Ycs = m6Ycs;
	}

	public String getM7Ycs() {
		return m7Ycs;
	}

	public void setM7Ycs(String m7Ycs) {
		this.m7Ycs = m7Ycs;
	}

	public String getM8Ycs() {
		return m8Ycs;
	}

	public void setM8Ycs(String m8Ycs) {
		this.m8Ycs = m8Ycs;
	}

	public String getM9Ycs() {
		return m9Ycs;
	}

	public void setM9Ycs(String m9Ycs) {
		this.m9Ycs = m9Ycs;
	}

	public String getM10Ycs() {
		return m10Ycs;
	}

	public void setM10Ycs(String m10Ycs) {
		this.m10Ycs = m10Ycs;
	}

	public String getM11Ycs() {
		return m11Ycs;
	}

	public void setM11Ycs(String m11Ycs) {
		this.m11Ycs = m11Ycs;
	}

	public String getM12Ycs() {
		return m12Ycs;
	}

	public void setM12Ycs(String m12Ycs) {
		this.m12Ycs = m12Ycs;
	}

	public String getM1Sjs() {
		return m1Sjs;
	}

	public void setM1Sjs(String m1Sjs) {
		this.m1Sjs = m1Sjs;
	}

	public String getM2Sjs() {
		return m2Sjs;
	}

	public void setM2Sjs(String m2Sjs) {
		this.m2Sjs = m2Sjs;
	}

	public String getM3Sjs() {
		return m3Sjs;
	}

	public void setM3Sjs(String m3Sjs) {
		this.m3Sjs = m3Sjs;
	}

	public String getM4Sjs() {
		return m4Sjs;
	}

	public void setM4Sjs(String m4Sjs) {
		this.m4Sjs = m4Sjs;
	}

	public String getM5Sjs() {
		return m5Sjs;
	}

	public void setM5Sjs(String m5Sjs) {
		this.m5Sjs = m5Sjs;
	}

	public String getM6Sjs() {
		return m6Sjs;
	}

	public void setM6Sjs(String m6Sjs) {
		this.m6Sjs = m6Sjs;
	}

	public String getM7Sjs() {
		return m7Sjs;
	}

	public void setM7Sjs(String m7Sjs) {
		this.m7Sjs = m7Sjs;
	}

	public String getM8Sjs() {
		return m8Sjs;
	}

	public void setM8Sjs(String m8Sjs) {
		this.m8Sjs = m8Sjs;
	}

	public String getM9Sjs() {
		return m9Sjs;
	}

	public void setM9Sjs(String m9Sjs) {
		this.m9Sjs = m9Sjs;
	}

	public String getM10Sjs() {
		return m10Sjs;
	}

	public void setM10Sjs(String m10Sjs) {
		this.m10Sjs = m10Sjs;
	}

	public String getM11Sjs() {
		return m11Sjs;
	}

	public void setM11Sjs(String m11Sjs) {
		this.m11Sjs = m11Sjs;
	}

	public String getM12Sjs() {
		return m12Sjs;
	}

	public void setM12Sjs(String m12Sjs) {
		this.m12Sjs = m12Sjs;
	}

	public String getM1Dcl() {
		return m1Dcl;
	}

	public void setM1Dcl(String m1Dcl) {
		this.m1Dcl = m1Dcl;
	}

	public String getM2Dcl() {
		return m2Dcl;
	}

	public void setM2Dcl(String m2Dcl) {
		this.m2Dcl = m2Dcl;
	}

	public String getM3Dcl() {
		return m3Dcl;
	}

	public void setM3Dcl(String m3Dcl) {
		this.m3Dcl = m3Dcl;
	}

	public String getM4Dcl() {
		return m4Dcl;
	}

	public void setM4Dcl(String m4Dcl) {
		this.m4Dcl = m4Dcl;
	}

	public String getM5Dcl() {
		return m5Dcl;
	}

	public void setM5Dcl(String m5Dcl) {
		this.m5Dcl = m5Dcl;
	}

	public String getM6Dcl() {
		return m6Dcl;
	}

	public void setM6Dcl(String m6Dcl) {
		this.m6Dcl = m6Dcl;
	}

	public String getM7Dcl() {
		return m7Dcl;
	}

	public void setM7Dcl(String m7Dcl) {
		this.m7Dcl = m7Dcl;
	}

	public String getM8Dcl() {
		return m8Dcl;
	}

	public void setM8Dcl(String m8Dcl) {
		this.m8Dcl = m8Dcl;
	}

	public String getM9Dcl() {
		return m9Dcl;
	}

	public void setM9Dcl(String m9Dcl) {
		this.m9Dcl = m9Dcl;
	}

	public String getM10Dcl() {
		return m10Dcl;
	}

	public void setM10Dcl(String m10Dcl) {
		this.m10Dcl = m10Dcl;
	}

	public String getM11Dcl() {
		return m11Dcl;
	}

	public void setM11Dcl(String m11Dcl) {
		this.m11Dcl = m11Dcl;
	}

	public String getM12Dcl() {
		return m12Dcl;
	}

	public void setM12Dcl(String m12Dcl) {
		this.m12Dcl = m12Dcl;
	}

	public Double getJ0cc() {
		return j0cc;
	}

	public void setJ0cc(Double j0cc) {
		this.j0cc = j0cc;
	}

	public Double getJ14cc() {
		return j14cc;
	}

	public void setJ14cc(Double j14cc) {
		this.j14cc = j14cc;
	}

	public Double getJ19cc() {
		return j19cc;
	}

	public void setJ19cc(Double j19cc) {
		this.j19cc = j19cc;
	}

	public Double getJ22cc() {
		return j22cc;
	}

	public void setJ22cc(Double j22cc) {
		this.j22cc = j22cc;
	}

	public Double getJ24cc() {
		return j24cc;
	}

	public void setJ24cc(Double j24cc) {
		this.j24cc = j24cc;
	}

	public Double getJ28cc() {
		return j28cc;
	}

	public void setJ28cc(Double j28cc) {
		this.j28cc = j28cc;
	}

	public Double getJ29cc() {
		return j29cc;
	}

	public void setJ29cc(Double j29cc) {
		this.j29cc = j29cc;
	}

	public Double getJ32cc() {
		return j32cc;
	}

	public void setJ32cc(Double j32cc) {
		this.j32cc = j32cc;
	}

	public Double getJ39cc() {
		return j39cc;
	}

	public void setJ39cc(Double j39cc) {
		this.j39cc = j39cc;
	}

	public Double getJ40cc() {
		return j40cc;
	}

	public void setJ40cc(Double j40cc) {
		this.j40cc = j40cc;
	}

	public Double getJ42cc() {
		return j42cc;
	}

	public void setJ42cc(Double j42cc) {
		this.j42cc = j42cc;
	}

	public Double getJ43cc() {
		return j43cc;
	}

	public void setJ43cc(Double j43cc) {
		this.j43cc = j43cc;
	}

	public Double getJ47cc() {
		return j47cc;
	}

	public void setJ47cc(Double j47cc) {
		this.j47cc = j47cc;
	}

	public Double getJ49cc() {
		return j49cc;
	}

	public void setJ49cc(Double j49cc) {
		this.j49cc = j49cc;
	}

	public Double getJ50cc() {
		return j50cc;
	}

	public void setJ50cc(Double j50cc) {
		this.j50cc = j50cc;
	}

	public Double getJ55cc() {
		return j55cc;
	}

	public void setJ55cc(Double j55cc) {
		this.j55cc = j55cc;
	}

	public Double getJ58cc() {
		return j58cc;
	}

	public void setJ58cc(Double j58cc) {
		this.j58cc = j58cc;
	}

	public Double getJ60cc() {
		return j60cc;
	}

	public void setJ60cc(Double j60cc) {
		this.j60cc = j60cc;
	}

	public Double getJ65cc() {
		return j65cc;
	}

	public void setJ65cc(Double j65cc) {
		this.j65cc = j65cc;
	}

	public String getNy() {
		return ny;
	}

	public void setNy(String ny) {
		this.ny = ny;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getJhjcc() {
		return jhjcc;
	}

	public void setJhjcc(String jhjcc) {
		this.jhjcc = jhjcc;
	}

	public String getZbxh() {
		return zbxh;
	}

	public void setZbxh(String zbxh) {
		this.zbxh = zbxh;
	}

	public String getFgsxh() {
		return fgsxh;
	}

	public void setFgsxh(String fgsxh) {
		this.fgsxh = fgsxh;
	}

	public String getFgsdm() {
		return fgsdm;
	}

	public void setFgsdm(String fgsdm) {
		this.fgsdm = fgsdm;
	}

	public String getFgsmc() {
		return fgsmc;
	}

	public void setFgsmc(String fgsmc) {
		this.fgsmc = fgsmc;
	}

}