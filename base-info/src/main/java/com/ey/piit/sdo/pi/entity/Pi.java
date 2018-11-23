package com.ey.piit.sdo.pi.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PI管理Entity
 * @author 赵明
 */
public class Pi extends BaseEntity {
	
	private String scjd;		//生产基地
	private String scjdmc;		//生产基地名称
	private String piid;		// PI号
	private String ckpih;		// 参考PI号
	private Date piyxq;			// PI有效期
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private String gsywmc;		// 公司英文名称
	private String gsywdz;		// 公司英文地址
	private String pilx;		// PI类型
	private String pilxmc;		// PI类型名称
	private String xszz;		//所属组织
	private String xszzmc;		//所属组织名称
	private String ywz;			//业务组
	private String ywzmc;		//业务组名称
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String khdz;		// 客户地址
	private String khdh;		// 客户电话
	private String khyx;		// 客户邮箱
	private String khlxr;		// 客户联系人
	private String khpp;		// 客户品牌
	private String cylx;		// 出运类型
	private String cylxmc;		// 出运类型名称
	private String cylxbz;		// 出运类型备注
	private String pimd;		// PI目的
	private String pimdmc;		// PI目的名称
	private String pimdbz;		// PI目的备注
	private String zhfs;		// 走货方式
	private String zhfsmc;		// 走货方式名称
	private String yqdhrq1;		// 要求到货日期1
	private String yqdhrq2;		// 要求到货日期2
	private String yqdhrq3;		// 要求到货日期3
	private String yqdhrq4;		// 要求到货日期4
	private String yqdhrq5;		// 要求到货日期5
	private String gjmytk;		// 国际贸易条款
	private String gjmytkmc;	// 国际贸易条款名称
	private String gjmytkbz;	// 国际贸易条款备注
	private String bz;			// 币种
	private String bzmc;		// 币种名称
	private String fktj;		// 付款条件
	private String fktjmc;		// 付款条件名称
	private String skyhmc;		// 收款银行名称
	private String skyhzh;		// 收款银行账号
	private String skyhdz;		// 收款银行地址
	private String skyhdm;		// 收款银行代码
	private String lcskyhmc;	// LC收款银行名称
	private String lcskyhzh;	// LC收款银行账号
	private String lcskyhdz;	// LC收款银行地址
	private String lcskyhdm;	// LC收款银行代码
	private String syr;			// 受益人
	private String syrdz;		// 受益人地址
	private String bzxx;		// 备注信息
	private String cpbzxx;		// 产品备注信息
	private BigDecimal zje;			// 总金额
	private Integer zsl;		// 总数量
	private String dyhcggyspi;	// 多元化采购供应商PI附件
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;			// 制单时间
	private Integer zt;			// 状态
	private Integer bbh;		// 版本号
	private String sjc;			// 时间戳
	private String beginZdsj;	// 开始 制单时间
	private String endZdsj;		// 结束 制单时间
	private Integer sfFgstj;	//是否分公司特价
	private Integer sfSmosh;	//是否SMO审核
	private String bgbz;   //变更备注
	private Integer sfCh;	//是否撤回
	private String pilb;	//备损PI类别
	private String pilbmc;	//备损PI类别
	private Integer sfBd;//多元化PI是否白电
	
	public Pi() {
		super();
	}

	public Pi(String id){
		super(id);
	}

	
	public String getBgbz() {
		return bgbz;
	}

	public void setBgbz(String bgbz) {
		this.bgbz = bgbz;
	}

	/**
     * 生产基地
     */
	public String getScjd() {
		return scjd;
	}

	/**
     * 生产基地
     */
	public void setScjd(String scjd) {
		this.scjd = scjd;
	}

	/**
     * 生产基地名称
     */
	public String getScjdmc() {
		return scjdmc;
	}

	/**
     * 生产基地名称
     */
	public void setScjdmc(String scjdmc) {
		this.scjdmc = scjdmc;
	}

	/**
     * PI号
     */
	@Length(min=1, max=20, message="PI号长度必须介于 1 和 20 之间")
	public String getPiid() {
		return piid;
	}

	/**
     * PI号
     */
	public void setPiid(String piid) {
		this.piid = piid == null ? null : piid.trim();
	}
	
	/**
     * 公司编码
     */
	@Length(min=1, max=20, message="公司编码长度必须介于 1 和 20 之间")
	public String getGsbm() {
		return gsbm;
	}

	/**
     * 公司编码
     */
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm == null ? null : gsbm.trim();
	}
	
	/**
     * 公司名称
     */
	@Length(min=0, max=100, message="公司名称长度必须介于 0 和 100 之间")
	public String getGsmc() {
		return gsmc;
	}

	/**
     * 公司名称
     */
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc == null ? null : gsmc.trim();
	}
	
	/**
     * PI类型
     */
	@Length(min=1, max=50, message="PI类型长度必须介于 1 和 50 之间")
	public String getPilx() {
		return pilx;
	}

	/**
     * PI类型
     */
	public void setPilx(String pilx) {
		this.pilx = pilx == null ? null : pilx.trim();
	}
	
	/**
     * PI类型名称
     */
	@Length(min=0, max=50, message="PI类型名称长度必须介于 0 和 50 之间")
	public String getPilxmc() {
		return pilxmc;
	}

	/**
     * PI类型名称
     */
	public void setPilxmc(String pilxmc) {
		this.pilxmc = pilxmc == null ? null : pilxmc.trim();
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
	@Length(min=0, max=100, message="客户名称长度必须介于 0 和 100 之间")
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
     * 客户地址
     */
	@Length(min=0, max=200, message="客户地址长度必须介于 0 和 200 之间")
	public String getKhdz() {
		return khdz;
	}

	/**
     * 客户地址
     */
	public void setKhdz(String khdz) {
		this.khdz = khdz == null ? null : khdz.trim();
	}
	
	/**
     * 客户电话
     */
	@Length(min=0, max=20, message="客户电话长度必须介于 0 和 20 之间")
	public String getKhdh() {
		return khdh;
	}

	/**
     * 客户电话
     */
	public void setKhdh(String khdh) {
		this.khdh = khdh == null ? null : khdh.trim();
	}

	/**
     * 客户联系人
     */
	@Length(min=0, max=50, message="客户联系人长度必须介于 0 和 50 之间")
	public String getKhlxr() {
		return khlxr;
	}

	/**
     * 客户联系人
     */
	public void setKhlxr(String khlxr) {
		this.khlxr = khlxr == null ? null : khlxr.trim();
	}

	/**
     * PI目的
     */
	@Length(min=0, max=50, message="PI目的长度必须介于 0 和 50 之间")
	public String getPimd() {
		return pimd;
	}

	/**
     * PI目的
     */
	public void setPimd(String pimd) {
		this.pimd = pimd == null ? null : pimd.trim();
	}
	
	/**
     * PI目的名称
     */
	@Length(min=0, max=50, message="PI目的名称长度必须介于 0 和 50 之间")
	public String getPimdmc() {
		return pimdmc;
	}

	/**
     * PI目的名称
     */
	public void setPimdmc(String pimdmc) {
		this.pimdmc = pimdmc == null ? null : pimdmc.trim();
	}
	
	/**
     * PI目的备注
     */
	@Length(min=0, max=100, message="PI目的备注长度必须介于 0 和 100 之间")
	public String getPimdbz() {
		return pimdbz;
	}

	/**
     * PI目的备注
     */
	public void setPimdbz(String pimdbz) {
		this.pimdbz = pimdbz == null ? null : pimdbz.trim();
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

	/**
     * 国际贸易条款
     */
	@Length(min=0, max=100, message="国际贸易条款长度必须介于 0 和 100 之间")
	public String getGjmytk() {
		return gjmytk;
	}

	/**
     * 国际贸易条款
     */
	public void setGjmytk(String gjmytk) {
		this.gjmytk = gjmytk == null ? null : gjmytk.trim();
	}
	
	/**
     * 币种
     */
	@Length(min=0, max=50, message="币种长度必须介于 0 和 50 之间")
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
     * 币种名称
     */
	@Length(min=0, max=50, message="币种名称长度必须介于 0 和 50 之间")
	public String getBzmc() {
		return bzmc;
	}

	/**
     * 币种名称
     */
	public void setBzmc(String bzmc) {
		this.bzmc = bzmc == null ? null : bzmc.trim();
	}
	
	/**
     * 付款方式名称
     */
	@Length(min=0, max=50, message="付款方式名称长度必须介于 0 和 50 之间")
	public String getFktjmc() {
		return fktjmc;
	}

	/**
     * 付款方式名称
     */
	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc == null ? null : fktjmc.trim();
	}
	
	/**
     * 收款银行名称
     */
	@Length(min=0, max=100, message="收款银行名称长度必须介于 0 和 100 之间")
	public String getSkyhmc() {
		return skyhmc;
	}

	/**
     * 收款银行名称
     */
	public void setSkyhmc(String skyhmc) {
		this.skyhmc = skyhmc == null ? null : skyhmc.trim();
	}
	
	/**
     * 收款银行账号
     */
	@Length(min=0, max=50, message="收款银行账号长度必须介于 0 和 50 之间")
	public String getSkyhzh() {
		return skyhzh;
	}

	/**
     * 收款银行账号
     */
	public void setSkyhzh(String skyhzh) {
		this.skyhzh = skyhzh == null ? null : skyhzh.trim();
	}
	
	/**
     * 收款银行地址
     */
	@Length(min=0, max=100, message="收款银行地址长度必须介于 0 和 100 之间")
	public String getSkyhdz() {
		return skyhdz;
	}

	/**
     * 收款银行地址
     */
	public void setSkyhdz(String skyhdz) {
		this.skyhdz = skyhdz == null ? null : skyhdz.trim();
	}
	
	/**
     * 收款银行代码
     */
	@Length(min=0, max=20, message="收款银行代码长度必须介于 0 和 20 之间")
	public String getSkyhdm() {
		return skyhdm;
	}

	/**
     * 收款银行代码
     */
	public void setSkyhdm(String skyhdm) {
		this.skyhdm = skyhdm == null ? null : skyhdm.trim();
	}
	
	/**
     * LC收款银行名称
     */
	@Length(min=0, max=100, message="LC收款银行名称长度必须介于 0 和 100 之间")
	public String getLcskyhmc() {
		return lcskyhmc;
	}

	/**
     * LC收款银行名称
     */
	public void setLcskyhmc(String lcskyhmc) {
		this.lcskyhmc = lcskyhmc == null ? null : lcskyhmc.trim();
	}
	
	/**
     * LC收款银行账号
     */
	@Length(min=0, max=50, message="LC收款银行账号长度必须介于 0 和 50 之间")
	public String getLcskyhzh() {
		return lcskyhzh;
	}

	/**
     * LC收款银行账号
     */
	public void setLcskyhzh(String lcskyhzh) {
		this.lcskyhzh = lcskyhzh == null ? null : lcskyhzh.trim();
	}
	
	/**
     * LC收款银行地址
     */
	@Length(min=0, max=100, message="LC收款银行地址长度必须介于 0 和 100 之间")
	public String getLcskyhdz() {
		return lcskyhdz;
	}

	/**
     * LC收款银行地址
     */
	public void setLcskyhdz(String lcskyhdz) {
		this.lcskyhdz = lcskyhdz == null ? null : lcskyhdz.trim();
	}
	
	/**
     * LC收款银行代码
     */
	@Length(min=0, max=20, message="LC收款银行代码长度必须介于 0 和 20 之间")
	public String getLcskyhdm() {
		return lcskyhdm;
	}

	/**
     * LC收款银行代码
     */
	public void setLcskyhdm(String lcskyhdm) {
		this.lcskyhdm = lcskyhdm == null ? null : lcskyhdm.trim();
	}
	
	/**
     * 受益人
     */
	@Length(min=0, max=50, message="受益人长度必须介于 0 和 50 之间")
	public String getSyr() {
		return syr;
	}

	/**
     * 受益人
     */
	public void setSyr(String syr) {
		this.syr = syr == null ? null : syr.trim();
	}
	
	/**
     * 受益人地址
     */
	@Length(min=0, max=100, message="受益人地址长度必须介于 0 和 100 之间")
	public String getSyrdz() {
		return syrdz;
	}

	/**
     * 受益人地址
     */
	public void setSyrdz(String syrdz) {
		this.syrdz = syrdz == null ? null : syrdz.trim();
	}
	
	/**
     * 备注信息
     */
	@Length(min=0, max=500, message="备注信息长度必须介于 0 和 500 之间")
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
     * 总金额
     */
	public BigDecimal getZje() {
		return zje;
	}

	/**
     * 总金额
     */
	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}
	
	/**
     * 多元化采购供应商PI附件
     */
	@Length(min=0, max=100, message="多元化采购供应商PI附件长度必须介于 0 和 100 之间")
	public String getDyhcggyspi() {
		return dyhcggyspi;
	}

	/**
     * 多元化采购供应商PI附件
     */
	public void setDyhcggyspi(String dyhcggyspi) {
		this.dyhcggyspi = dyhcggyspi == null ? null : dyhcggyspi.trim();
	}
	
	/**
     * 制单人
     */
	@Length(min=1, max=20, message="制单人长度必须介于 1 和 20 之间")
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
	@Length(min=1, max=50, message="制单人名称长度必须介于 1 和 50 之间")
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
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="制单时间不能为空")
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
     * 状态
     */
	@NotNull(message="状态不能为空")
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
     * 版本号
     */
	@NotNull(message="版本号不能为空")
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
     * 时间戳
     */
	@Length(min=1, max=20, message="时间戳长度必须介于 1 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
     * 时间戳
     */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
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

	public String getGsywmc() {
		return gsywmc;
	}

	public void setGsywmc(String gsywmc) {
		this.gsywmc = gsywmc;
	}

	public String getGsywdz() {
		return gsywdz;
	}

	public void setGsywdz(String gsywdz) {
		this.gsywdz = gsywdz;
	}

	public String getKhyx() {
		return khyx;
	}

	public void setKhyx(String khyx) {
		this.khyx = khyx;
	}

	public String getCylx() {
		return cylx;
	}

	public void setCylx(String cylx) {
		this.cylx = cylx;
	}

	public String getCylxmc() {
		return cylxmc;
	}

	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc;
	}

	public String getCylxbz() {
		return cylxbz;
	}

	public void setCylxbz(String cylxbz) {
		this.cylxbz = cylxbz;
	}

	public String getYqdhrq1() {
		return yqdhrq1;
	}

	public void setYqdhrq1(String yqdhrq1) {
		this.yqdhrq1 = yqdhrq1;
	}

	public String getYqdhrq2() {
		return yqdhrq2;
	}

	public void setYqdhrq2(String yqdhrq2) {
		this.yqdhrq2 = yqdhrq2;
	}

	public String getYqdhrq3() {
		return yqdhrq3;
	}

	public void setYqdhrq3(String yqdhrq3) {
		this.yqdhrq3 = yqdhrq3;
	}

	public String getYqdhrq4() {
		return yqdhrq4;
	}

	public void setYqdhrq4(String yqdhrq4) {
		this.yqdhrq4 = yqdhrq4;
	}

	public String getYqdhrq5() {
		return yqdhrq5;
	}

	public void setYqdhrq5(String yqdhrq5) {
		this.yqdhrq5 = yqdhrq5;
	}

	public String getGjmytkmc() {
		return gjmytkmc;
	}

	public void setGjmytkmc(String gjmytkmc) {
		this.gjmytkmc = gjmytkmc;
	}

	public String getGjmytkbz() {
		return gjmytkbz;
	}

	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz;
	}

	public String getFktj() {
		return fktj;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public String getCkpih() {
		return ckpih;
	}

	public void setCkpih(String ckpih) {
		this.ckpih = ckpih;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getPiyxq() {
		return piyxq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setPiyxq(Date piyxq) {
		this.piyxq = piyxq;
	}

	public Integer getZsl() {
		return zsl;
	}

	public void setZsl(Integer zsl) {
		this.zsl = zsl;
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

	public Integer getSfFgstj() {
		return sfFgstj;
	}

	public void setSfFgstj(Integer sfFgstj) {
		this.sfFgstj = sfFgstj;
	}

	public Integer getSfSmosh() {
		return sfSmosh;
	}

	public void setSfSmosh(Integer sfSmosh) {
		this.sfSmosh = sfSmosh;
	}

	public Integer getSfCh() {
		return sfCh;
	}

	public void setSfCh(Integer sfCh) {
		this.sfCh = sfCh;
	}

	public String getKhpp() {
		return khpp;
	}

	public void setKhpp(String khpp) {
		this.khpp = khpp;
	}

	public String getCpbzxx() {
		return cpbzxx;
	}

	public void setCpbzxx(String cpbzxx) {
		this.cpbzxx = cpbzxx;
	}

	public String getPilb() {
		return pilb;
	}

	public void setPilb(String pilb) {
		this.pilb = pilb;
	}

	public String getPilbmc() {
		return pilbmc;
	}

	public void setPilbmc(String pilbmc) {
		this.pilbmc = pilbmc;
	}

	public Integer getSfBd() {
		return sfBd;
	}

	public void setSfBd(Integer sfBd) {
		this.sfBd = sfBd;
	}

	
	
	
}