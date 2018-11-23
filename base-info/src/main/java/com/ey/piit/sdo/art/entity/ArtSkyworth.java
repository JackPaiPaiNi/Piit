package com.ey.piit.sdo.art.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 美工任务单SkyworthEntity
 * 
 * @author tianrong
 */
public class ArtSkyworth extends BaseEntity {
	
	private  String  rwdh;    //任务单号
	private  Integer  bbh;    //版本号
	private String wjbh; // 文件编号
	private  String  zdrid;    //制单人
	private  String  zdrmc;    //制单人名称
	private  Date  zdsj;    //制单时间
	private  Integer  zt;    //状态
	private  String  sjc;    //时间戳
	private  String  pid;    //PID
	private  String  wkysbz;    //外壳颜色标准
	private  String  wkysbzmc;    //外壳颜色标准名称
	private  String  zhfs;    //走货方式
	private  String  zhfsmc;    //走货方式名称
	private  String  khpp;    //客户品牌
	private  String  xwgj;    //销往国家
	private  String  xwgjmc;    //销往国家名称
	private  String  jixing;    //机型
	private  String  jixin;    //机芯
	private  String  tmh;    //条码号
	private  Integer  rzCb;    //认证-CB
	private  Integer  rzCe;    //认证-CE
	private  Integer  rzEtl;    //认证-ETL
	private  Integer  rzFcc;    //认证-FCC
	private Integer rzWu; // 认证-无
	private Integer rzDb; // 认证-杜比
	private Integer rzDts; // 认证-DTS
	private Integer rzHdmi; // 认证-HDMI
	private  Integer  rzQt;    //认证-其他
	private  Integer  mk;    //面壳
	private  Integer  mkLx;    //面壳-带logo-类型
	private  Integer  ykq;    //遥控器
	private  Integer  dzgntp;    //端子功能贴片
	private  Integer  ksczzn;    //快速操作指南
	private  String  ksczznBz;    //快速操作指南-多语种-备注
	private  Integer  ksczznGwcg;    //快速操作指南-国外采购，只提供电子文档资料
	private  Integer  ksczznSqbh;    //快速操作指南-国外采购-申请编号
	private  Integer  dzazsm;    //底座安装说明
	private  String  dzazsmBz;    //底座安装说明-多语种-备注
	private  Integer  dzazsmGwcg;    //底座安装说明-国外采购，只提供电子文档资料
	private  Integer  dzazsmSqbh;    //底座安装说明-国外采购-申请编号
	private  Integer  zx;    //纸箱
	private  Integer  zxGwcg;    //纸箱-国外采购，只提供电子文档资料
	private  Integer  zxSqbh;    //纸箱-国外采购-申请编号
	private  Integer  zxxhtz;    //纸箱型号贴纸
	private  Integer  zxxhtzSqbh;    //纸箱型号贴纸-国外采购-申请编号
	private  Integer  hgtz;    //后盖贴纸
	private  Integer  hgtzSqbh;    //后盖贴纸-国外采购-申请编号
	private  Integer  bzk;    //保证卡
	private  Integer  bzkSqbh;    //保证卡-国外采购-申请编号
	private  Integer  wxtz;    //维修贴纸
	private  Integer  wxtzSqbh;    //维修贴纸-国外采购-申请编号
	private  Integer  zjxhtz;    //整机序号贴纸
	private  Integer  zjxhtzBzcc;    //整机序号贴纸-标准尺寸
	private  Integer  zjxhtzYl;    //整机序号贴纸-用量
	private  String  zjxhtzYlBz;    //整机序号贴纸-用量-备注
	private  String  mgqtyq;    //美工其他要求
	private String fj;	//附件
	private  String  mgzjh;    //美工组件号
	private  Date  sxsj;    //生效时间
	private  Integer  bgSflc;    //变更-是否量产
	private Integer bgSflcValue; // 变更-是否量产 value
	private  String  bgLcksddh;    //变更-量产开始订单号
	private  Integer  bgSjddsl;    //变更-涉及订单数量
	private  String  bgNr;    //变更-内容
	private  String  bgYy;    //变更-原因
	private  Integer  nxtz;    //能效贴纸
	private  Integer  nxtzSqbh;    //能效贴纸-国外采购-申请编号
	private Integer mbbs;//模板标识
	private String ywz;		// 销售员所属业务组
	private String ywzmc;		// 销售员所属业务组名称
	private String xszz;		// 销售员所属销售组织
	private String xszzmc;		// 销售员所属销售组织名称
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String rzQtBz; // 认证-其他-备注
	private String khxh; // 客户型号
	private String vbbh ;
	private Integer zxxhtzGwcg; //纸箱型号贴纸国外采购
	private Integer bzkGwcg;  //保证卡国外采购

	public ArtSkyworth() {
		super();
	}

	public ArtSkyworth(String id) {
		super(id);
	}

	public String getRwdh() {
		return rwdh;
	}

	public void setRwdh(String rwdh) {
		this.rwdh = rwdh;
	}

	public Integer getBbh() {
		return bbh;
	}

	public void setBbh(Integer bbh) {
		this.bbh = bbh;
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

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getWkysbz() {
		return wkysbz;
	}

	public void setWkysbz(String wkysbz) {
		this.wkysbz = wkysbz;
	}

	public String getWkysbzmc() {
		return wkysbzmc;
	}

	public void setWkysbzmc(String wkysbzmc) {
		this.wkysbzmc = wkysbzmc;
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

	public String getKhpp() {
		return khpp;
	}

	public void setKhpp(String khpp) {
		this.khpp = khpp;
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

	public String getTmh() {
		return tmh;
	}

	public void setTmh(String tmh) {
		this.tmh = tmh;
	}
	
	public Integer getMk() {
		return mk;
	}

	public void setMk(Integer mk) {
		this.mk = mk;
	}

	public Integer getYkq() {
		return ykq;
	}

	public void setYkq(Integer ykq) {
		this.ykq = ykq;
	}

	public Integer getDzgntp() {
		return dzgntp;
	}

	public void setDzgntp(Integer dzgntp) {
		this.dzgntp = dzgntp;
	}

	public Integer getKsczzn() {
		return ksczzn;
	}

	public void setKsczzn(Integer ksczzn) {
		this.ksczzn = ksczzn;
	}

	public Integer getDzazsm() {
		return dzazsm;
	}

	public void setDzazsm(Integer dzazsm) {
		this.dzazsm = dzazsm;
	}

	public Integer getZx() {
		return zx;
	}

	public void setZx(Integer zx) {
		this.zx = zx;
	}

	public Integer getZxxhtz() {
		return zxxhtz;
	}

	public void setZxxhtz(Integer zxxhtz) {
		this.zxxhtz = zxxhtz;
	}

	public Integer getHgtz() {
		return hgtz;
	}

	public void setHgtz(Integer hgtz) {
		this.hgtz = hgtz;
	}

	public Integer getBzk() {
		return bzk;
	}

	public void setBzk(Integer bzk) {
		this.bzk = bzk;
	}

	public Integer getWxtz() {
		return wxtz;
	}

	public void setWxtz(Integer wxtz) {
		this.wxtz = wxtz;
	}

	public Integer getZjxhtz() {
		return zjxhtz;
	}

	public void setZjxhtz(Integer zjxhtz) {
		this.zjxhtz = zjxhtz;
	}

	public String getMgqtyq() {
		return mgqtyq;
	}

	public void setMgqtyq(String mgqtyq) {
		this.mgqtyq = mgqtyq;
	}

	public String getMgzjh() {
		return mgzjh;
	}

	public void setMgzjh(String mgzjh) {
		this.mgzjh = mgzjh;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSxsj() {
		return sxsj;
	}

	public void setSxsj(Date sxsj) {
		this.sxsj = sxsj;
	}

	public Integer getBgSflc() {
		return bgSflc;
	}

	public void setBgSflc(Integer bgSflc) {
		this.bgSflc = bgSflc;
	}

	public Integer getRzCb() {
		return rzCb;
	}

	public void setRzCb(Integer rzCb) {
		this.rzCb = rzCb;
	}

	public Integer getRzCe() {
		return rzCe;
	}

	public void setRzCe(Integer rzCe) {
		this.rzCe = rzCe;
	}

	public Integer getRzEtl() {
		return rzEtl;
	}

	public void setRzEtl(Integer rzEtl) {
		this.rzEtl = rzEtl;
	}

	public Integer getRzFcc() {
		return rzFcc;
	}

	public void setRzFcc(Integer rzFcc) {
		this.rzFcc = rzFcc;
	}

	public Integer getRzQt() {
		return rzQt;
	}

	public void setRzQt(Integer rzQt) {
		this.rzQt = rzQt;
	}

	public Integer getMkLx() {
		return mkLx;
	}

	public void setMkLx(Integer mkLx) {
		this.mkLx = mkLx;
	}

	public String getKsczznBz() {
		return ksczznBz;
	}

	public void setKsczznBz(String ksczznBz) {
		this.ksczznBz = ksczznBz;
	}

	public Integer getKsczznSqbh() {
		return ksczznSqbh;
	}

	public void setKsczznSqbh(Integer ksczznSqbh) {
		this.ksczznSqbh = ksczznSqbh;
	}

	public String getDzazsmBz() {
		return dzazsmBz;
	}

	public void setDzazsmBz(String dzazsmBz) {
		this.dzazsmBz = dzazsmBz;
	}

	public Integer getDzazsmSqbh() {
		return dzazsmSqbh;
	}

	public void setDzazsmSqbh(Integer dzazsmSqbh) {
		this.dzazsmSqbh = dzazsmSqbh;
	}

	public Integer getZxSqbh() {
		return zxSqbh;
	}

	public void setZxSqbh(Integer zxSqbh) {
		this.zxSqbh = zxSqbh;
	}

	public Integer getZxxhtzSqbh() {
		return zxxhtzSqbh;
	}

	public void setZxxhtzSqbh(Integer zxxhtzSqbh) {
		this.zxxhtzSqbh = zxxhtzSqbh;
	}

	public Integer getHgtzSqbh() {
		return hgtzSqbh;
	}

	public void setHgtzSqbh(Integer hgtzSqbh) {
		this.hgtzSqbh = hgtzSqbh;
	}

	public Integer getBzkSqbh() {
		return bzkSqbh;
	}

	public void setBzkSqbh(Integer bzkSqbh) {
		this.bzkSqbh = bzkSqbh;
	}

	public Integer getWxtzSqbh() {
		return wxtzSqbh;
	}

	public void setWxtzSqbh(Integer wxtzSqbh) {
		this.wxtzSqbh = wxtzSqbh;
	}

	public String getBgLcksddh() {
		return bgLcksddh;
	}

	public void setBgLcksddh(String bgLcksddh) {
		this.bgLcksddh = bgLcksddh;
	}

	public Integer getBgSjddsl() {
		return bgSjddsl;
	}

	public void setBgSjddsl(Integer bgSjddsl) {
		this.bgSjddsl = bgSjddsl;
	}

	public String getBgNr() {
		return bgNr;
	}

	public void setBgNr(String bgNr) {
		this.bgNr = bgNr;
	}

	public String getBgYy() {
		return bgYy;
	}

	public void setBgYy(String bgYy) {
		this.bgYy = bgYy;
	}

	public Integer getZjxhtzBzcc() {
		return zjxhtzBzcc;
	}

	public void setZjxhtzBzcc(Integer zjxhtzBzcc) {
		this.zjxhtzBzcc = zjxhtzBzcc;
	}

	public Integer getZjxhtzYl() {
		return zjxhtzYl;
	}

	public void setZjxhtzYl(Integer zjxhtzYl) {
		this.zjxhtzYl = zjxhtzYl;
	}

	public Integer getKsczznGwcg() {
		return ksczznGwcg;
	}

	public void setKsczznGwcg(Integer ksczznGwcg) {
		this.ksczznGwcg = ksczznGwcg;
	}

	public Integer getDzazsmGwcg() {
		return dzazsmGwcg;
	}

	public void setDzazsmGwcg(Integer dzazsmGwcg) {
		this.dzazsmGwcg = dzazsmGwcg;
	}

	public Integer getZxGwcg() {
		return zxGwcg;
	}

	public void setZxGwcg(Integer zxGwcg) {
		this.zxGwcg = zxGwcg;
	}

	public String getWjbh() {
		return wjbh;
	}

	public void setWjbh(String wjbh) {
		this.wjbh = wjbh;
	}

	public Integer getRzWu() {
		return rzWu;
	}

	public void setRzWu(Integer rzWu) {
		this.rzWu = rzWu;
	}

	public Integer getRzDb() {
		return rzDb;
	}

	public void setRzDb(Integer rzDb) {
		this.rzDb = rzDb;
	}

	public Integer getRzDts() {
		return rzDts;
	}

	public void setRzDts(Integer rzDts) {
		this.rzDts = rzDts;
	}

	public Integer getRzHdmi() {
		return rzHdmi;
	}

	public void setRzHdmi(Integer rzHdmi) {
		this.rzHdmi = rzHdmi;
	}

	public String getZjxhtzYlBz() {
		return zjxhtzYlBz;
	}

	public void setZjxhtzYlBz(String zjxhtzYlBz) {
		this.zjxhtzYlBz = zjxhtzYlBz;
	}

	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	public Integer getNxtz() {
		return nxtz;
	}

	public void setNxtz(Integer nxtz) {
		this.nxtz = nxtz;
	}

	public Integer getNxtzSqbh() {
		return nxtzSqbh;
	}

	public void setNxtzSqbh(Integer nxtzSqbh) {
		this.nxtzSqbh = nxtzSqbh;
	}

	public Integer getMbbs() {
		return mbbs;
	}

	public void setMbbs(Integer mbbs) {
		this.mbbs = mbbs;
	}

	public Integer getBgSflcValue() {
		return bgSflcValue;
	}

	public void setBgSflcValue(Integer bgSflcValue) {
		this.bgSflcValue = bgSflcValue;
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

	public String getRzQtBz() {
		return rzQtBz;
	}

	public void setRzQtBz(String rzQtBz) {
		this.rzQtBz = rzQtBz;
	}

	public String getKhxh() {
		return khxh;
	}

	public void setKhxh(String khxh) {
		this.khxh = khxh;
	}

	public String getVbbh() {
		return vbbh;
	}

	public void setVbbh(String vbbh) {
		this.vbbh = vbbh;
	}

	public Integer getZxxhtzGwcg() {
		return zxxhtzGwcg;
	}

	public void setZxxhtzGwcg(Integer zxxhtzGwcg) {
		this.zxxhtzGwcg = zxxhtzGwcg;
	}

	public Integer getBzkGwcg() {
		return bzkGwcg;
	}

	public void setBzkGwcg(Integer bzkGwcg) {
		this.bzkGwcg = bzkGwcg;
	}

	

	
}