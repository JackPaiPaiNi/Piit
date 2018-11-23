package com.ey.piit.sdo.payment.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 付款保障报表Entity
 * @author 赵明
 */
public class PaymentReport extends BaseEntity {
	
	private String lx;		    // 类型
	private String skyh;		// 收款银行
	private String skyhmc;		// 收款银行名称
	private String bz;			// 币种
	private Double je;			// 收款金额
	private Double sjsxf;		// 实际手续费
	private Double yrlje;		// 已认领金额
	private Double wrlje;		// 未认领金额
	private String yyyymm;		// 年月
	private String pzh;			// 凭证号
	private String fkr;			// 付款人
	private String fkyh;		// 付款银行
	private String fkgjmc;		// 付款地
	private String bzxx;		// 文本信息
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String yskd;		// 预收款单
	private String hkyh;		// 回款(银行)
	private String hklc;		// 回款(LC)
	private String hkqt;		// 回款(其他)
	private Double ybdje;		// 已绑定金额
	private Double wbdje;		// 未绑定金额
	private String piid;		// PIID
	private String xyedlxmc;	// 信用额度类型
	private String kzh;			// 开证行
	private Date yxq;			// 有效期
	private Double pfbl;		// 赔付比例
	private String xexzq;		// 闲置期
	private Double nbgled;		// 信用额度总额
	private Double syedye;		// 信用额度余额	
	private Double zybl;		// 已占用比例
	private Date zxkcq;			// 最新开船期
	private Date zdsj;			// 登记时间
	private String lcbh;		// L/C编号
	private Double lc_yq;		// PI要求L/C金额
	private String lc_kzh;		// L/C号
	private String lc_bz;		// L/C币种
	private Double lc_ybd;		// L/C绑定金额
	private Double lc_wbd;		// L/C未绑定金额
	private String sfmz;		// 绑定是否满足要求
	private Double ykpje;		// 已开票金额
	private Double wkpje;		// 未开票金额
	private Double yhkje;		// 已回款金额
	private Double ykpwhkje;	// 已开票，未回款金额
	private String fph;			// 发票号
	private Double fpje;		// 发票金额
	private String sfyhk;		// 是否已回款
	private Double hkje;		// 回款金额
	private String ddid;		// 订单号
	private Double ddje;		// 订单金额
	private String sf_yxc;		// 是否有未消除特批记录
	private Date tpsj;			// 特批时间
	private String tpjdmc;		// 特批节点
	private String tplxmc;		// 特批类型
	private Double tpje;		// 特批金额
	private Double yxcje;		// 已消除金额
	private Double wxcje;		// 未消除金额
	private String yzhdh;		// 预走货号
	private Date zgsj;			// 装柜日期
	private String sf_ysc;		// 特批状态
	private String ywzmc;		// 业务组名称
	private String xsymc;		// 销售员名称
	private Date fprq;			// 发票日期
	private String mytkmc;		// 贸易条款名称
	private Date sjhkrq;		// 实际回款日期
	private Double whkje;		// 未回款金额
	private Date sj;			// 时间
	private String jd;			// 流程
	private String fklx;		// 占用额度类型
	private Double tpwxcje;		// 特批未消除金额
	private String fktjmc;		// 付款条件
	private Double usd_je;		// 订单总金额（USD）
	private Double rmb_je;		// 订单总金额（RMB）
	private Double usd_zb;		// 占总订单的比例（USD）
	public PaymentReport() {
		super();
	}

	public PaymentReport(String id){
		super(id);
	}

	public String getSkyh() {
		return skyh;
	}

	public void setSkyh(String skyh) {
		this.skyh = skyh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Double getYrlje() {
		return yrlje;
	}

	public void setYrlje(Double yrlje) {
		this.yrlje = yrlje;
	}

	public Double getWrlje() {
		return wrlje;
	}

	public void setWrlje(Double wrlje) {
		this.wrlje = wrlje;
	}
	@JsonFormat(pattern = "yyyyMM")
	public String getYyyymm() {
		return yyyymm;
	}
	@JsonFormat(pattern = "yyyyMM")
	public void setYyyymm(String yyyymm) {
		this.yyyymm = yyyymm;
	}

	public String getSkyhmc() {
		return skyhmc;
	}

	public void setSkyhmc(String skyhmc) {
		this.skyhmc = skyhmc;
	}

	public Double getSjsxf() {
		return sjsxf;
	}

	public void setSjsxf(Double sjsxf) {
		this.sjsxf = sjsxf;
	}

	public Double getJe() {
		return je;
	}

	public void setJe(Double je) {
		this.je = je;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getPzh() {
		return pzh;
	}

	public void setPzh(String pzh) {
		this.pzh = pzh;
	}

	public String getFkr() {
		return fkr;
	}

	public void setFkr(String fkr) {
		this.fkr = fkr;
	}

	public String getFkyh() {
		return fkyh;
	}

	public void setFkyh(String fkyh) {
		this.fkyh = fkyh;
	}

	public String getFkgjmc() {
		return fkgjmc;
	}

	public void setFkgjmc(String fkgjmc) {
		this.fkgjmc = fkgjmc;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
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

	public String getYskd() {
		return yskd;
	}

	public void setYskd(String yskd) {
		this.yskd = yskd;
	}

	public String getHkyh() {
		return hkyh;
	}

	public void setHkyh(String hkyh) {
		this.hkyh = hkyh;
	}

	public String getHklc() {
		return hklc;
	}

	public void setHklc(String hklc) {
		this.hklc = hklc;
	}

	public String getHkqt() {
		return hkqt;
	}

	public void setHkqt(String hkqt) {
		this.hkqt = hkqt;
	}

	public Double getYbdje() {
		return ybdje;
	}

	public void setYbdje(Double ybdje) {
		this.ybdje = ybdje;
	}

	public Double getWbdje() {
		return wbdje;
	}

	public void setWbdje(Double wbdje) {
		this.wbdje = wbdje;
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public String getXyedlxmc() {
		return xyedlxmc;
	}

	public void setXyedlxmc(String xyedlxmc) {
		this.xyedlxmc = xyedlxmc;
	}

	public String getKzh() {
		return kzh;
	}

	public void setKzh(String kzh) {
		this.kzh = kzh;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYxq() {
		return yxq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}

	public Double getPfbl() {
		return pfbl;
	}

	public void setPfbl(Double pfbl) {
		this.pfbl = pfbl;
	}

	public String getXexzq() {
		return xexzq;
	}

	public void setXexzq(String xexzq) {
		this.xexzq = xexzq;
	}

	public Double getNbgled() {
		return nbgled;
	}

	public void setNbgled(Double nbgled) {
		this.nbgled = nbgled;
	}

	public Double getSyedye() {
		return syedye;
	}

	public void setSyedye(Double syedye) {
		this.syedye = syedye;
	}

	public Double getZybl() {
		return zybl;
	}

	public void setZybl(Double zybl) {
		this.zybl = zybl;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZxkcq() {
		return zxkcq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setZxkcq(Date zxkcq) {
		this.zxkcq = zxkcq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getLcbh() {
		return lcbh;
	}

	public void setLcbh(String lcbh) {
		this.lcbh = lcbh;
	}

	public Double getLc_yq() {
		return lc_yq;
	}

	public void setLc_yq(Double lc_yq) {
		this.lc_yq = lc_yq;
	}

	public String getLc_kzh() {
		return lc_kzh;
	}

	public void setLc_kzh(String lc_kzh) {
		this.lc_kzh = lc_kzh;
	}

	public String getLc_bz() {
		return lc_bz;
	}

	public void setLc_bz(String lc_bz) {
		this.lc_bz = lc_bz;
	}

	public Double getLc_ybd() {
		return lc_ybd;
	}

	public void setLc_ybd(Double lc_ybd) {
		this.lc_ybd = lc_ybd;
	}

	public String getSfmz() {
		return sfmz;
	}

	public void setSfmz(String sfmz) {
		this.sfmz = sfmz;
	}

	public Double getLc_wbd() {
		return lc_wbd;
	}

	public void setLc_wbd(Double lc_wbd) {
		this.lc_wbd = lc_wbd;
	}

	public Double getYkpje() {
		return ykpje;
	}

	public void setYkpje(Double ykpje) {
		this.ykpje = ykpje;
	}

	public Double getWkpje() {
		return wkpje;
	}

	public void setWkpje(Double wkpje) {
		this.wkpje = wkpje;
	}

	public Double getYhkje() {
		return yhkje;
	}

	public void setYhkje(Double yhkje) {
		this.yhkje = yhkje;
	}

	public Double getYkpwhkje() {
		return ykpwhkje;
	}

	public void setYkpwhkje(Double ykpwhkje) {
		this.ykpwhkje = ykpwhkje;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public Double getFpje() {
		return fpje;
	}

	public void setFpje(Double fpje) {
		this.fpje = fpje;
	}

	public String getSfyhk() {
		return sfyhk;
	}

	public void setSfyhk(String sfyhk) {
		this.sfyhk = sfyhk;
	}

	public Double getHkje() {
		return hkje;
	}

	public void setHkje(Double hkje) {
		this.hkje = hkje;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public Double getDdje() {
		return ddje;
	}

	public void setDdje(Double ddje) {
		this.ddje = ddje;
	}

	public String getSf_yxc() {
		return sf_yxc;
	}

	public void setSf_yxc(String sf_yxc) {
		this.sf_yxc = sf_yxc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTpsj() {
		return tpsj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setTpsj(Date tpsj) {
		this.tpsj = tpsj;
	}

	public String getTpjdmc() {
		return tpjdmc;
	}

	public void setTpjdmc(String tpjdmc) {
		this.tpjdmc = tpjdmc;
	}

	public String getTplxmc() {
		return tplxmc;
	}

	public void setTplxmc(String tplxmc) {
		this.tplxmc = tplxmc;
	}

	public Double getTpje() {
		return tpje;
	}

	public void setTpje(Double tpje) {
		this.tpje = tpje;
	}

	public Double getYxcje() {
		return yxcje;
	}

	public void setYxcje(Double yxcje) {
		this.yxcje = yxcje;
	}

	public Double getWxcje() {
		return wxcje;
	}

	public void setWxcje(Double wxcje) {
		this.wxcje = wxcje;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZgsj() {
		return zgsj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setZgsj(Date zgsj) {
		this.zgsj = zgsj;
	}

	public String getSf_ysc() {
		return sf_ysc;
	}

	public void setSf_ysc(String sf_ysc) {
		this.sf_ysc = sf_ysc;
	}

	public String getYwzmc() {
		return ywzmc;
	}

	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc;
	}

	public String getXsymc() {
		return xsymc;
	}

	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}

	public String getMytkmc() {
		return mytkmc;
	}

	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSjhkrq() {
		return sjhkrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setSjhkrq(Date sjhkrq) {
		this.sjhkrq = sjhkrq;
	}

	public Double getWhkje() {
		return whkje;
	}

	public void setWhkje(Double whkje) {
		this.whkje = whkje;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSj() {
		return sj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setSj(Date sj) {
		this.sj = sj;
	}

	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	public String getFklx() {
		return fklx;
	}

	public void setFklx(String fklx) {
		this.fklx = fklx;
	}

	public Double getTpwxcje() {
		return tpwxcje;
	}

	public void setTpwxcje(Double tpwxcje) {
		this.tpwxcje = tpwxcje;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}

	public Double getUsd_je() {
		return usd_je;
	}

	public void setUsd_je(Double usd_je) {
		this.usd_je = usd_je;
	}

	public Double getRmb_je() {
		return rmb_je;
	}

	public void setRmb_je(Double rmb_je) {
		this.rmb_je = rmb_je;
	}

	public Double getUsd_zb() {
		return usd_zb;
	}

	public void setUsd_zb(Double usd_zb) {
		this.usd_zb = usd_zb;
	}
	
}