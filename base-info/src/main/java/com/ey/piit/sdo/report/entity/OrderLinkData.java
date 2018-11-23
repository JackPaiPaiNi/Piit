package com.ey.piit.sdo.report.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * OrderLinkEntity
 * @author 赵明
 */
public class OrderLinkData extends BaseEntity {
	
	private String mfbsmc;		// 免费备损名称
	private Date tssapsj;		// 推送SAP时间
	private String ycps;		// 一次评审
	private String ddzgd;		// 订单转工单
	private String zc;			// 周次
	private Date jhrq;			// 交货日期
	private Date ycrq;			// 预测日期
	private String yczs;		// 预测周数
	private String pp;			// 品牌
	private String rz1;			// 认证1
	private String rz2;			// 认证2
	private String rz3;			// 认证3
	private String sf_rohs;		// 是否ROHS
	private String sf_reach;	// 是否REACH
	private String sf_yh;		// PI号
	private String sf_p;		// 是否屏
	private String sf_ffbs;		// 是否付费备损
	private String fktj;		// 付款条件
	private String fktjmc;		// 付款条件名称
	private String xwgjmc;		// 销往国家
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String xsymc;		// 销售员
	private String ywzmc;		// 业务组
	private String xszzmc;		// 销售组
	private String yf;			// PI号
	private String ddlxmc;		// 订单类型
	private String zt;			// 状态
	private String ddid;		// 订单ID
	private String ddlbmc;		// 订单类别
	private String zhfsmc;		// 走货方式
	private String jgfsmc;		// 加工方式
	private String pid;			// PID
	private String jixin;		// 机芯
	private String wsxh;		// 我司型号
	private String cc;			// 尺寸
	private String pxxbc;		// 屏编号
	private String mjxh;		// 买家型号
	private String ddlx;		// 订单类型
	private Double dj;			// 单价
	private Double sl;			// 数量
	private Double zje;			// 总金额
	private Double ycsl;		// 预测数量
	private Date zdsj;			// 制单时间
	private Date ycpsjhrq;		// 一次评审交货日期
	private String bbh;	
	private String ztmc ;
	private Date zzjhrq;	//最早交货日期
	private Date zwjhrq;	//最晚交货日期
	private String gsbm;	// 公司
	private String mgrwdh;
	private String wkysbz;
	private String dsjlx;
	private String dsjlxmc;
	private String kjlogo;
	private String ccyymc;
	private String zhm;     //走货码
	private String version;//	n	varchar2(20)	y			版本号
	private String bs;//	n	varchar2(20)	y			标识号
	private String zhmt;//	n	varchar2(20)	y			走货码2
	private String versiont;//	n	varchar2(20)	y			版本号2
	private String bst;//	n	varchar2(20)	y			标识号2
	
	public OrderLinkData() {
		super();
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

	public OrderLinkData(String id){
		super(id);
	}
	
	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getMfbsmc() {
		return mfbsmc;
	}

	public void setMfbsmc(String mfbsmc) {
		this.mfbsmc = mfbsmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTssapsj() {
		return tssapsj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setTssapsj(Date tssapsj) {
		this.tssapsj = tssapsj;
	}

	public String getYcps() {
		return ycps;
	}

	public void setYcps(String ycps) {
		this.ycps = ycps;
	}

	public String getDdzgd() {
		return ddzgd;
	}

	public void setDdzgd(String ddzgd) {
		this.ddzgd = ddzgd;
	}

	public String getZc() {
		return zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJhrq() {
		return jhrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setJhrq(Date jhrq) {
		this.jhrq = jhrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYcpsjhrq() {
		return ycpsjhrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setYcpsjhrq(Date ycpsjhrq) {
		this.ycpsjhrq = ycpsjhrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYcrq() {
		return ycrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setYcrq(Date ycrq) {
		this.ycrq = ycrq;
	}

	public String getYczs() {
		return yczs;
	}

	public void setYczs(String yczs) {
		this.yczs = yczs;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public String getRz2() {
		return rz2;
	}

	public void setRz2(String rz2) {
		this.rz2 = rz2;
	}

	public String getRz3() {
		return rz3;
	}

	public void setRz3(String rz3) {
		this.rz3 = rz3;
	}

	public String getSf_rohs() {
		return sf_rohs;
	}

	public void setSf_rohs(String sf_rohs) {
		this.sf_rohs = sf_rohs;
	}

	public String getSf_reach() {
		return sf_reach;
	}

	public void setSf_reach(String sf_reach) {
		this.sf_reach = sf_reach;
	}

	public String getSf_yh() {
		return sf_yh;
	}

	public void setSf_yh(String sf_yh) {
		this.sf_yh = sf_yh;
	}

	public String getSf_ffbs() {
		return sf_ffbs;
	}

	public void setSf_ffbs(String sf_ffbs) {
		this.sf_ffbs = sf_ffbs;
	}

	public String getFktj() {
		return fktj;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public String getXwgjmc() {
		return xwgjmc;
	}

	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
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

	public String getXsymc() {
		return xsymc;
	}

	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}

	public String getYwzmc() {
		return ywzmc;
	}

	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc;
	}

	public String getXszzmc() {
		return xszzmc;
	}

	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc;
	}

	public String getYf() {
		return yf;
	}

	public void setYf(String yf) {
		this.yf = yf;
	}

	public String getDdlxmc() {
		return ddlxmc;
	}

	public void setDdlxmc(String ddlxmc) {
		this.ddlxmc = ddlxmc;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getDdlbmc() {
		return ddlbmc;
	}

	public void setDdlbmc(String ddlbmc) {
		this.ddlbmc = ddlbmc;
	}

	public String getZhfsmc() {
		return zhfsmc;
	}

	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
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

	public String getWsxh() {
		return wsxh;
	}

	public void setWsxh(String wsxh) {
		this.wsxh = wsxh;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getPxxbc() {
		return pxxbc;
	}

	public void setPxxbc(String pxxbc) {
		this.pxxbc = pxxbc;
	}

	public String getMjxh() {
		return mjxh;
	}

	public void setMjxh(String mjxh) {
		this.mjxh = mjxh;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Double getSl() {
		return sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public Double getZje() {
		return zje;
	}

	public void setZje(Double zje) {
		this.zje = zje;
	}

	public Double getYcsl() {
		return ycsl;
	}

	public void setYcsl(Double ycsl) {
		this.ycsl = ycsl;
	}

	public String getRz1() {
		return rz1;
	}

	public void setRz1(String rz1) {
		this.rz1 = rz1;
	}

	public String getSf_p() {
		return sf_p;
	}

	public void setSf_p(String sf_p) {
		this.sf_p = sf_p;
	}

	public String getDdlx() {
		return ddlx;
	}

	public void setDdlx(String ddlx) {
		this.ddlx = ddlx;
	}

	public String getBbh() {
		return bbh;
	}

	public void setBbh(String bbh) {
		this.bbh = bbh;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZzjhrq() {
		return zzjhrq;
	}

	public void setZzjhrq(Date zzjhrq) {
		this.zzjhrq = zzjhrq;
	}

	public Date getZwjhrq() {
		return zwjhrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setZwjhrq(Date zwjhrq) {
		this.zwjhrq = zwjhrq;
	}

	public String getJgfsmc() {
		return jgfsmc;
	}

	public void setJgfsmc(String jgfsmc) {
		this.jgfsmc = jgfsmc;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public String getMgrwdh() {
		return mgrwdh;
	}

	public void setMgrwdh(String mgrwdh) {
		this.mgrwdh = mgrwdh;
	}

	public String getWkysbz() {
		return wkysbz;
	}

	public void setWkysbz(String wkysbz) {
		this.wkysbz = wkysbz;
	}

	public String getKjlogo() {
		return kjlogo;
	}

	public void setKjlogo(String kjlogo) {
		this.kjlogo = kjlogo;
	}

	public String getCcyymc() {
		return ccyymc;
	}

	public void setCcyymc(String ccyymc) {
		this.ccyymc = ccyymc;
	}

	public String getZhm() {
		return zhm;
	}

	public void setZhm(String zhm) {
		this.zhm = zhm;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public String getZhmt() {
		return zhmt;
	}

	public void setZhmt(String zhmt) {
		this.zhmt = zhmt;
	}

	public String getVersiont() {
		return versiont;
	}

	public void setVersiont(String versiont) {
		this.versiont = versiont;
	}

	public String getBst() {
		return bst;
	}

	public void setBst(String bst) {
		this.bst = bst;
	}
	
	
}