package com.ey.piit.sdo.pso.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单Entity
 * @author 赵明
 */
public class PsoReferOrder extends BaseEntity {
	private String yzhlx;		// 预走货类型
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private Date ddyqjhrq;		    // 订单要求交货日期
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String ywz;			// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String xwgj;        //销往国家
	private String cylx;        //出运类型
	private String gjmytk;		// 国际贸易条款
	private String ddid;		// 订单ID
	private String ddlx;		// 订单类型
	private String ddlxmc;		// 订单类型名称
	private String jixing;		// 机型
	private String jixin;		// 机芯
	private String khxhms;		// 客户型号描述
	private Double cc;			// 尺寸
	private String zhfs;		// 走货方式
	private String zhfsmc;		// 走货方式名称
	private String chfl;		// 出货分类
	private String pp;			// 品牌
	private String pplx;			// 品牌类型
	private Double sl;			// 数量
	private String bz;			// 币种
	private BigDecimal dj;			// 单价
	private BigDecimal je;			// 金额
    private String fktj;		// 付款条件
	private String fktjmc;		// 付款条件名称
	private String ggmx;		// 规格明细
	private String ggmxmc;		// 规格明细名称
	private String ppp;			// 屏品牌
	private String pxh;			// 屏型号
	private String pbh;			// 屏编码
	private String pid;			// PID
	private String wlbh;		// 物料编号
	private String wlms;		// 物料描述
	private String cplx;		// 产品类型
	private String cplxmc;		// 产品类型
	private double mfjsl;		// 产品类型
	private Date zdsj;			// 制单时间
	private String beginZdsj;	
	private String endZdsj;
	private String beginJhsj;
	private String endJhsj;
	private String dditemid;
	private Integer ddsl;	// 订单数量
	private Integer yzhsl;	// 已走货数量
	private String piid; // PI号
	private String pilx; // PI类型
	private String pilxmc; // PI类型名称
	private String  scjd;           //生产基地
	private String  scjdmc;           //生产基地
	private BigDecimal ffbsje;		//付费备损金额
	private BigDecimal yzhje;		//已走货金额
	private String cpfl;	//产品分类
	private String cpflmc;	//产品分类名称
	private BigDecimal ce;	//误差金额
	private String model;	//我司型号（多元化）
	private String khxh;	//客户型号（多元化）
	private Integer sfBd;//多元化是否白电
	private String slbz;//大货订单的数量备注：区分是大货数量还是收费样机数量
	private String zhm;
	private String zhmmc;
	private String dsjlx;
	private String dsjlxmc;
	private String version;//	n	varchar2(20)	y			版本号
	private String versionmc;//	n	varchar2(50)	y			版本名称
	private String bs;//	n	varchar2(20)	y			标识号
	private String bsmc;//	n	varchar2(50)	y			标识名称
	
	public double getMfjsl() {
		return mfjsl;
	}
	public void setMfjsl(double mfjsl) {
		this.mfjsl = mfjsl;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getDdyqjhrq() {
		return ddyqjhrq;
	}
	public void setDdyqjhrq(Date ddyqjhrq) {
		this.ddyqjhrq = ddyqjhrq;
	}
	public String getWlms() {
		return wlms;
	}
	public void setWlms(String wlms) {
		this.wlms = wlms;
	}
	public String getCplx() {
		return cplx;
	}
	public void setCplx(String cplx) {
		this.cplx = cplx;
	}
	public String getCplxmc() {
		return cplxmc;
	}
	public void setCplxmc(String cplxmc) {
		this.cplxmc = cplxmc;
	}
	
	public String getZdrid() {
		return zdrid;
	}
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}
	public String getGsmc() {
		return gsmc;
	}
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}
	public String getXsyid() {
		return xsyid;
	}
	public void setXsyid(String xsyid) {
		this.xsyid = xsyid;
	}
	public String getCylx() {
		return cylx;
	}
	public void setCylx(String cylx) {
		this.cylx = cylx;
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
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public String getZdrmc() {
		return zdrmc;
	}
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
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
	public String getBeginZdsj() {
		return beginZdsj;
	}
	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}
	public String getEndZdsj() {
		return endZdsj;
	}
	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}
	public String getBeginJhsj() {
		return beginJhsj;
	}
	public void setBeginJhsj(String beginJhsj) {
		this.beginJhsj = beginJhsj;
	}
	public String getEndJhsj() {
		return endJhsj;
	}
	public void setEndJhsj(String endJhsj) {
		this.endJhsj = endJhsj;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Double getSl() {
		return sl;
	}
	public void setSl(Double sl) {
		this.sl = sl;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	
	public String getGsbm() {
		return gsbm;
	}
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getXsymc() {
		return xsymc;
	}
	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}
	public String getKhxhms() {
		return khxhms;
	}
	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms;
	}
	public Double getCc() {
		return cc;
	}
	public void setCc(Double cc) {
		this.cc = cc;
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
	public String getChfl() {
		return chfl;
	}
	public void setChfl(String chfl) {
		this.chfl = chfl;
	}
	public String getPp() {
		return pp;
	}
	public void setPp(String pp) {
		this.pp = pp;
	}
	public String getFktj() {
		return fktj;
	}
	public void setFktj(String fktj) {
		this.fktj = fktj;
	}
	public String getFktjmc() {
		return fktjmc;
	}
	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}
	public String getPpp() {
		return ppp;
	}
	public void setPpp(String ppp) {
		this.ppp = ppp;
	}
	public String getPxh() {
		return pxh;
	}
	public void setPxh(String pxh) {
		this.pxh = pxh;
	}

	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getGjmytk() {
		return gjmytk;
	}
	public void setGjmytk(String gjmytk) {
		this.gjmytk = gjmytk;
	}
	public String getYzhlx() {
		return yzhlx;
	}
	public void setYzhlx(String yzhlx) {
		this.yzhlx = yzhlx;
	}
	public String getWlbh() {
		return wlbh;
	}
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}
	public String getDditemid() {
		return dditemid;
	}
	public Integer getDdsl() {
		return ddsl;
	}
	public Integer getYzhsl() {
		return yzhsl;
	}
	public void setDditemid(String dditemid) {
		this.dditemid = dditemid;
	}
	public void setDdsl(Integer ddsl) {
		this.ddsl = ddsl;
	}
	public void setYzhsl(Integer yzhsl) {
		this.yzhsl = yzhsl;
	}
	public String getPbh() {
		return pbh;
	}
	public void setPbh(String pbh) {
		this.pbh = pbh;
	}
	public String getXwgj() {
		return xwgj;
	}
	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}
	public String getPiid() {
		return piid;
	}
	public String getPilx() {
		return pilx;
	}
	public String getPilxmc() {
		return pilxmc;
	}
	public void setPiid(String piid) {
		this.piid = piid;
	}
	public void setPilx(String pilx) {
		this.pilx = pilx;
	}
	public void setPilxmc(String pilxmc) {
		this.pilxmc = pilxmc;
	}
	public String getScjd() {
		return scjd;
	}
	public String getScjdmc() {
		return scjdmc;
	}
	public void setScjd(String scjd) {
		this.scjd = scjd;
	}
	public void setScjdmc(String scjdmc) {
		this.scjdmc = scjdmc;
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
	public BigDecimal getCe() {
		return ce;
	}
	public void setCe(BigDecimal ce) {
		this.ce = ce;
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
	public BigDecimal getFfbsje() {
		return ffbsje;
	}
	public void setFfbsje(BigDecimal ffbsje) {
		this.ffbsje = ffbsje;
	}
	public BigDecimal getYzhje() {
		return yzhje;
	}
	public void setYzhje(BigDecimal yzhje) {
		this.yzhje = yzhje;
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
	public String getPplx() {
		return pplx;
	}
	public void setPplx(String pplx) {
		this.pplx = pplx;
	}
	public Integer getSfBd() {
		return sfBd;
	}
	public void setSfBd(Integer sfBd) {
		this.sfBd = sfBd;
	}
	public String getSlbz() {
		return slbz;
	}
	public void setSlbz(String slbz) {
		this.slbz = slbz;
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
	public String getVersionmc() {
		return versionmc;
	}
	public void setVersionmc(String versionmc) {
		this.versionmc = versionmc;
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