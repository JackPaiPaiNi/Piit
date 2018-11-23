package com.ey.piit.sdo.fcst.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 采购FCST填报Entity
 * @author 邓海
 */
public class FcstData extends BaseEntity {
	
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
	private String nf;		// 年份
	private String yf;		// 月份
	private String zc;		// 周次
	private Double ycs;		// 预测数
	private Double dds;		// 订单数
	private Double wxds;		// 未下单数
	private Double zql;		// 准确率
	private String pp;		// 品牌
	private String xwgj;		// 销往国家
	private String xwgjbm;		// 销往国家编码
	private String xwgjmc;		// 销往国家名称
	private String zhfs;		// 走货方式
	private String zhfsmc;		// 走货方式名称
	private String ddlb;		// 订单类别
	private String ddlbbm;		// 订单类别编码
	private String ddlbmc;		// 订单类别名称
	private Double cc;		// 尺寸
	private String jixing;		// 机型
	private String jixin;		// 机芯
	private String mcufa;		// MCU方案
	private String sjyp;		// 实际用屏
	private Integer zt;		// 状态
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private String psrid;		// 评审人
	private String psrmc;		// 评审人名称
	private Date pssj;		// 评审时间
	private String psyj;		// 评审意见
	private String sjc;		// 时间戳
	
	public FcstData() {
		super();
	}

	public FcstData(String id){
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
     * 年份
     */
	@Length(min=0, max=4, message="年份长度必须介于 0 和 4 之间")
	public String getNf() {
		return nf;
	}

	/**
     * 年份
     */
	public void setNf(String nf) {
		this.nf = nf == null ? null : nf.trim();
	}
	
	/**
     * 月份
     */
	@Length(min=0, max=2, message="月份长度必须介于 0 和 2 之间")
	public String getYf() {
		return yf;
	}

	/**
     * 月份
     */
	public void setYf(String yf) {
		this.yf = yf == null ? null : yf.trim();
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
	
	/**
     * 预测数
     */
	@NotNull(message="预测数不能为空")
	public Double getYcs() {
		return ycs;
	}

	/**
     * 预测数
     */
	public void setYcs(Double ycs) {
		this.ycs = ycs;
	}
	
	/**
     * 订单数
     */
	public Double getDds() {
		return dds;
	}

	/**
     * 订单数
     */
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
	
	/**
     * 准确率
     */
	public Double getZql() {
		return zql;
	}

	/**
     * 准确率
     */
	public void setZql(Double zql) {
		this.zql = zql;
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
     * 状态
     */
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
     * 制单人
     */
	@Length(min=0, max=20, message="制单人长度必须介于 0 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * 制单人
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * 制单人名称
     */
	@Length(min=0, max=50, message="制单人名称长度必须介于 0 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * 制单人名称
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
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
     * 评审人
     */
	@Length(min=0, max=20, message="评审人长度必须介于 0 和 20 之间")
	public String getPsrid() {
		return psrid;
	}

	/**
     * 评审人
     */
	public void setPsrid(String psrid) {
		this.psrid = psrid == null ? null : psrid.trim();
	}
	
	/**
     * 评审人名称
     */
	@Length(min=0, max=50, message="评审人名称长度必须介于 0 和 50 之间")
	public String getPsrmc() {
		return psrmc;
	}

	/**
     * 评审人名称
     */
	public void setPsrmc(String psrmc) {
		this.psrmc = psrmc == null ? null : psrmc.trim();
	}
	
	/**
     * 评审时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPssj() {
		return pssj;
	}

	/**
     * 评审时间
     */
	public void setPssj(Date pssj) {
		this.pssj = pssj;
	}
	
	/**
     * 评审意见
     */
	@Length(min=0, max=200, message="评审意见长度必须介于 0 和 200 之间")
	public String getPsyj() {
		return psyj;
	}

	/**
     * 评审意见
     */
	public void setPsyj(String psyj) {
		this.psyj = psyj == null ? null : psyj.trim();
	}
	
	/**
     * 时间戳
     */
	@Length(min=0, max=20, message="时间戳长度必须介于 0 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
     * 时间戳
     */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
	}

	public String getDdlbbm() {
		return ddlbbm;
	}

	public void setDdlbbm(String ddlbbm) {
		this.ddlbbm = ddlbbm;
	}

	public String getXwgjbm() {
		return xwgjbm;
	}

	public void setXwgjbm(String xwgjbm) {
		this.xwgjbm = xwgjbm;
	}
	
}