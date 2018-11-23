package com.ey.piit.sdo.fcst.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 采购FCST样机填报Entity
 * @author 高文浩
 */
public class FcstSampleData extends BaseEntity {
	
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String ywz;		// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String nf;		// 年份
	private String yf;		// 月份
	private String zc;		// 周次
	private Double sl;		// 数量
	private String xwgj;		// 销往国家
	private String xwgjmc;		// 销往国家名称
	private String jixing;		// 机型
	private String jixin;		// 机芯
	private String ptbh;		// 屏体编号
	private String wgys;		// 外观颜色
	private String logo;		// Logo
	private String yjyt;		// 样机用途
	private String chsj;		// 出货时间
	private Integer zt;		// 状态
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private String psrid;		// 评审人
	private String psrmc;		// 评审人名称
	private Date pssj;		// 评审时间
	private String psyj;		// 评审意见
	private String sjc;		// 时间戳
	
	public FcstSampleData() {
		super();
	}

	public FcstSampleData(String id){
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
     * 数量
     */
	public Double getSl() {
		return sl;
	}

	/**
     * 数量
     */
	public void setSl(Double sl) {
		this.sl = sl;
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
     * 机型
     */
	@Length(min=1, max=50, message="机型长度必须介于 1 和 50 之间")
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
	@Length(min=1, max=50, message="机芯长度必须介于 1 和 50 之间")
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
     * 屏体编号
     */
	@Length(min=0, max=100, message="屏体编号长度必须介于 0 和 100 之间")
	public String getPtbh() {
		return ptbh;
	}

	/**
     * 屏体编号
     */
	public void setPtbh(String ptbh) {
		this.ptbh = ptbh == null ? null : ptbh.trim();
	}
	
	/**
     * 外观颜色
     */
	@Length(min=0, max=100, message="外观颜色长度必须介于 0 和 100 之间")
	public String getWgys() {
		return wgys;
	}

	/**
     * 外观颜色
     */
	public void setWgys(String wgys) {
		this.wgys = wgys == null ? null : wgys.trim();
	}
	
	/**
     * Logo
     */
	@Length(min=0, max=100, message="Logo长度必须介于 0 和 100 之间")
	public String getLogo() {
		return logo;
	}

	/**
     * Logo
     */
	public void setLogo(String logo) {
		this.logo = logo == null ? null : logo.trim();
	}
	
	/**
     * 样机用途
     */
	@Length(min=0, max=100, message="样机用途长度必须介于 0 和 100 之间")
	public String getYjyt() {
		return yjyt;
	}

	/**
     * 样机用途
     */
	public void setYjyt(String yjyt) {
		this.yjyt = yjyt == null ? null : yjyt.trim();
	}
	
	/**
     * 出货时间
     */
	@Length(min=0, max=100, message="出货时间长度必须介于 0 和 100 之间")
	public String getChsj() {
		return chsj;
	}

	/**
     * 出货时间
     */
	public void setChsj(String chsj) {
		this.chsj = chsj == null ? null : chsj.trim();
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
	
}