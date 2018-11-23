package com.ey.piit.sdo.pso.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 预走货Entity
 * 
 * @author 赵桃军
 */
public class PsoItem extends BaseEntity {

	private String yzhdh; // 预走货单号 父类
	private Integer bbh; // 版本号
	private String ddid; // 订单号
	private String cplx; // 产品类型
	private String cplxmc; // 产品类型名称
	private String jixing; // 我司型号
	private String khxhms; // 客户型号
	private String cpms; // 产品描述
	private String jixin; // 机芯
	private Double cc; // 尺寸
	private String zhfs; // 走货方式
	private String zhfsmc; // 走货方式名称
	private String chfl; // 出货分类
	private String chflmc; // 出货分类名称
	private String bzxx; // 备注信息
	private String pp; // 品牌
	private Integer sl; // 数量
	private Integer js; // 件数
	private Integer mfjsl; // 免费机数量
	private String bz; // 币种
	private BigDecimal dj; // 单价
	private BigDecimal je; // 金额
	private Date ddyqjhrq; // 订单要求交货日期
	private String ggmx; // 规格明细
	private String ggmxmc; // 规格明细名称
	private String ppp; // 屏品牌
	private String pxh; // 屏型号
	private String pbh; // 屏编号
	private BigDecimal pdj; // 屏单价
	private String spmc; // 商品名称
	private String ddlx; // 订单类型
	private String ddlxmc; //订单类型名称
	private BigDecimal ffbsje;	//付费备损金额
	private String spms;	//商品描述
	private String cpfl; // 产品分类
	private String cpflmc; // 产品分类名称
	private String model;	//我司型号（多元化）
	private String khxh;	//客户型号（多元化）
	private String gtin;	//GTIN号码
	private String cas;		//CAS号码
	private String pplx;	//品牌类型
	private String ckxhqk;	//出口享惠情况
	private String dsjlx;	//电视机类型编码
	private String dsjlxmc;	//电视机类型名称
	private String zhm;	//走货码	
	private String zhmmc; //走货码名称
	private String version;
	private String versionmc;
	private String pid;
	private String bs;
	private String bsmc;
	public PsoItem() {
		super();
	}

	public PsoItem(String id) {
		super(id);
	}

	public String getGgmx() {
		return ggmx;
	}

	public void setGgmx(String ggmx) {
		this.ggmx = ggmx;
	}

	public String getGgmxmc() {
		return ggmxmc;
	}

	public void setGgmxmc(String ggmxmc) {
		this.ggmxmc = ggmxmc;
	}

	/**
	 * 预走货单号
	 */
	@Length(min = 1, max = 20, message = "预走货单号长度必须介于 1 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	/**
	 * 版本号
	 */
	@NotNull(message = "版本号不能为空")
	public Integer getBbh() {
		return bbh;
	}

	/**
	 * 版本号
	 */
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}

	/**
	 * 订单号
	 */
	@Length(min = 0, max = 20, message = "订单号长度必须介于 0 和 20 之间")
	public String getDdid() {
		return ddid;
	}

	/**
	 * 订单号
	 */
	public void setDdid(String ddid) {
		this.ddid = ddid == null ? null : ddid.trim();
	}
	
	/**
	 * 产品类型
	 */
	@Length(min = 0, max = 20, message = "产品类型长度必须介于 0 和 20 之间")
	public String getCplx() {
		return cplx;
	}

	/**
	 * 产品类型
	 */
	public void setCplx(String cplx) {
		this.cplx = cplx == null ? null : cplx.trim();
	}

	/**
	 * 产品类型名称
	 */
	@Length(min = 0, max = 50, message = "产品类型名称长度必须介于 0 和 50 之间")
	public String getCplxmc() {
		return cplxmc;
	}

	/**
	 * 产品类型名称
	 */
	public void setCplxmc(String cplxmc) {
		this.cplxmc = cplxmc == null ? null : cplxmc.trim();
	}

	/**
	 * 我司型号
	 */
	@Length(min = 0, max = 50, message = "我司型号长度必须介于 0 和 50 之间")
	public String getJixing() {
		return jixing;
	}

	/**
	 * 我司型号
	 */
	public void setJixing(String jixing) {
		this.jixing = jixing == null ? null : jixing.trim();
	}

	/**
	 * 客户型号
	 */
	@Length(min = 0, max = 50, message = "客户型号长度必须介于 0 和 50 之间")
	public String getKhxhms() {
		return khxhms;
	}

	/**
	 * 客户型号
	 */
	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms == null ? null : khxhms.trim();
	}

	/**
	 * 产品描述
	 */
	@Length(min = 0, max = 100, message = "产品描述长度必须介于 0 和 100 之间")
	public String getCpms() {
		return cpms;
	}

	/**
	 * 产品描述
	 */
	public void setCpms(String cpms) {
		this.cpms = cpms == null ? null : cpms.trim();
	}

	/**
	 * 机芯
	 */
	@Length(min = 0, max = 50, message = "机芯长度必须介于 0 和 50 之间")
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
	 * 走货方式
	 */
	@Length(min = 0, max = 20, message = "走货方式长度必须介于 0 和 20 之间")
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
	@Length(min = 0, max = 50, message = "走货方式名称长度必须介于 0 和 50 之间")
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
	 * 出货分类
	 */
	@Length(min = 0, max = 20, message = "出货分类长度必须介于 0 和 20 之间")
	public String getChfl() {
		return chfl;
	}

	/**
	 * 出货分类
	 */
	public void setChfl(String chfl) {
		this.chfl = chfl == null ? null : chfl.trim();
	}

	/**
	 * 出货分类名称
	 */
	@Length(min = 0, max = 50, message = "出货分类名称长度必须介于 0 和 50 之间")
	public String getChflmc() {
		return chflmc;
	}

	/**
	 * 出货分类名称
	 */
	public void setChflmc(String chflmc) {
		this.chflmc = chflmc == null ? null : chflmc.trim();
	}

	/**
	 * 备注信息
	 */
	@Length(min = 0, max = 200, message = "备注信息长度必须介于 0 和 200 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
	 * 备注信息
	 */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
	}

	/**
	 * 品牌
	 */
	@Length(min = 0, max = 50, message = "品牌长度必须介于 0 和 50 之间")
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
	 * 数量
	 */
	public Integer getSl() {
		return sl;
	}

	/**
	 * 数量
	 */
	public void setSl(Integer sl) {
		this.sl = sl;
	}

	/**
	 * 件数
	 */
	public Integer getJs() {
		return js;
	}

	/**
	 * 件数
	 */
	public void setJs(Integer js) {
		this.js = js;
	}

	/**
	 * 免费机数量
	 */
	public Integer getMfjsl() {
		return mfjsl;
	}

	/**
	 * 免费机数量
	 */
	public void setMfjsl(Integer mfjsl) {
		this.mfjsl = mfjsl;
	}

	/**
	 * 币种
	 */
	@Length(min = 0, max = 20, message = "币种长度必须介于 0 和 20 之间")
	public String getBz() {
		return bz;
	}

	/**
	 * 币种
	 */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}

	/**
	 * 订单要求交货日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getDdyqjhrq() {
		return ddyqjhrq;
	}

	/**
	 * 订单要求交货日期
	 */
	public void setDdyqjhrq(Date ddyqjhrq) {
		this.ddyqjhrq = ddyqjhrq;
	}

	/**
	 * 屏品牌
	 */
	@Length(min = 0, max = 50, message = "屏品牌长度必须介于 0 和 50 之间")
	public String getPpp() {
		return ppp;
	}

	/**
	 * 屏品牌
	 */
	public void setPpp(String ppp) {
		this.ppp = ppp == null ? null : ppp.trim();
	}

	/**
	 * 屏型号
	 */
	@Length(min = 0, max = 50, message = "屏型号长度必须介于 0 和 50 之间")
	public String getPxh() {
		return pxh;
	}

	/**
	 * 屏型号
	 */
	public void setPxh(String pxh) {
		this.pxh = pxh == null ? null : pxh.trim();
	}

	/**
	 * 屏编号
	 */
	@Length(min = 0, max = 50, message = "屏编号长度必须介于 0 和 50 之间")
	public String getPbh() {
		return pbh;
	}

	/**
	 * 屏编号
	 */
	public void setPbh(String pbh) {
		this.pbh = pbh == null ? null : pbh.trim();
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getDdlx() {
		return ddlx;
	}

	public void setDdlx(String ddlx) {
		this.ddlx = ddlx;
	}

	public String getDdlxmc() {
		return ddlxmc;
	}

	public void setDdlxmc(String ddlxmc) {
		this.ddlxmc = ddlxmc;
	}

	public String getSpms() {
		return spms;
	}

	public void setSpms(String spms) {
		this.spms = spms;
	}

	public String getCpfl() {
		return cpfl;
	}

	public void setCpfl(String cpfl) {
		this.cpfl = cpfl;
	}

	public String getCpflmc() {
		return cpflmc;
	}

	public void setCpflmc(String cpflmc) {
		this.cpflmc = cpflmc;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public BigDecimal getPdj() {
		return pdj;
	}

	public void setPdj(BigDecimal pdj) {
		this.pdj = pdj;
	}

	public BigDecimal getFfbsje() {
		return ffbsje;
	}

	public void setFfbsje(BigDecimal ffbsje) {
		this.ffbsje = ffbsje;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getKhxh() {
		return khxh;
	}

	public void setKhxh(String khxh) {
		this.khxh = khxh;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public String getPplx() {
		return pplx;
	}

	public void setPplx(String pplx) {
		this.pplx = pplx;
	}

	public String getCkxhqk() {
		return ckxhqk;
	}

	public void setCkxhqk(String ckxhqk) {
		this.ckxhqk = ckxhqk;
	}

	public String getDsjlx() {
		return dsjlx;
	}

	public void setDsjlx(String dsjlx) {
		this.dsjlx = dsjlx;
	}

	public String getDsjlxmc() {
		return dsjlxmc;
	}

	public void setDsjlxmc(String dsjlxmc) {
		this.dsjlxmc = dsjlxmc;
	}

	public String getZhm() {
		return zhm;
	}

	public void setZhm(String zhm) {
		this.zhm = zhm;
	}

	public String getZhmmc() {
		return zhmmc;
	}

	public void setZhmmc(String zhmmc) {
		this.zhmmc = zhmmc;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersionmc() {
		return versionmc;
	}

	public void setVersionmc(String versionmc) {
		this.versionmc = versionmc;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public String getBsmc() {
		return bsmc;
	}

	public void setBsmc(String bsmc) {
		this.bsmc = bsmc;
	}
	
}