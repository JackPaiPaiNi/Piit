package com.ey.piit.sdo.payment.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * LC登记Entity
 * @author 邓海
 */
public class LcReg extends BaseEntity {
	
	private String lcbh;		// 信用证号
	private BigDecimal ysyje;		// 已使用金额
	private BigDecimal je;		// LC金额
	private String bz;		// 币种
	private Date hqrq;		// 获取日期
	private String zbcfc;		// 正本存放处
	private String khbm;		// 申请人
	private String khmc;		// 申请人名称
	private Date kzrq;		// 开征日期
	private String gsbm;		// 受益人
	private String gsmc;		// 受益人名称
	private Date yxq;		// 有效期
	private Date zwzcq;		// 最晚装船期
	private Integer yfjdq;		// 议付交单期
	private String xyzxz;		// 信用证性质
	private String xyzxzmc;		// 信用证性质名称
	private Integer yfhcksj;		// 议付后付款时间
	private Integer sfxhlc;		// 是否循环LC
	private Integer xhlccssx;		// 循环LC次数上限
	private Integer sfbyxyz;		// 是否备用信用证
	private String mytk;		// 贸易条款
	private String mytkmc;		// 贸易条款名称
	private String qyg;		// 起运港
	private String qygmc;	// 起运港名称
	private String qygbz;	// 起运港备注
	private String mdg;		// 目的港
	private Integer zytkYxfy;		// 装运条款-允许分运
	private Integer zytkYxzy;		// 装运条款-允许转运
	private String kzh;		// 开证行
	private String kzhdm;		// 开证行SWIFT
	private String tzh;		// 通知行
	private String zdyfh;		// 指定议付行
	private Integer sfybdh;		// 是否有保兑行
	private String bdh;		// 保兑行
	private Integer sfycfh;		// 是否有偿付行
	private String cfh;		// 偿付行
	private String fj;		// 附件
	private String bzxx;		// 备注信息
	private String zdrid;		// 登记人ID
	private String zdrmc;		// 登记人名称
	private Date zdsj;		// 登记日期
	private Integer zt;		// 状态
	private String ztmc;	//状态名称
	private Integer bbh;		// 版本号
	private String sjc;		// 时间戳
	private String skzrq;		// 开始 开征日期
	private String ekzrq;		// 结束 开征日期
	private String beginZdsj;		// 开始 登记日期
	private String endZdsj;		// 结束 登记日期
	private String djyy ; //冻结原因
	private BigDecimal djje ; //冻结原因
	private String xsfph;//形式发票号
	private String yhckh;//银行参考号
	private String xgbbh;//修改版本号
	private Integer xyzxzts;//信用证性质 远期 天数
	private String fktj;//付款条件
	private String fktjmc;//付款条件名称
	
	
	
	public String getDjyy() {
		return djyy;
	}

	public void setDjyy(String djyy) {
		this.djyy = djyy;
	}

	public BigDecimal getDjje() {
		return djje;
	}

	public void setDjje(BigDecimal djje) {
		this.djje = djje;
	}

	public LcReg() {
		super();
	}

	public LcReg(String id){
		super(id);
	}

	/**
     * 信用证号
     */
	@Length(min=1, max=20, message="信用证号长度必须介于 1 和 20 之间")
	public String getLcbh() {
		return lcbh;
	}

	/**
     * 信用证号
     */
	public void setLcbh(String lcbh) {
		this.lcbh = lcbh == null ? null : lcbh.trim();
	}
	
	/**
     * LC金额
     */
	public BigDecimal getJe() {
		return je;
	}

	/**
     * LC金额
     */
	public void setJe(BigDecimal je) {
		this.je = je;
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
     * 获取日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getHqrq() {
		return hqrq;
	}

	/**
     * 获取日期
     */
	public void setHqrq(Date hqrq) {
		this.hqrq = hqrq;
	}
	
	/**
     * 正本存放处
     */
	@Length(min=0, max=50, message="正本存放处长度必须介于 0 和 50 之间")
	public String getZbcfc() {
		return zbcfc;
	}

	/**
     * 正本存放处
     */
	public void setZbcfc(String zbcfc) {
		this.zbcfc = zbcfc == null ? null : zbcfc.trim();
	}
	
	/**
     * 开征日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getKzrq() {
		return kzrq;
	}

	/**
     * 开征日期
     */
	public void setKzrq(Date kzrq) {
		this.kzrq = kzrq;
	}
	
	/**
     * 受益人名称
     */
	@Length(min=0, max=50, message="受益人名称长度必须介于 0 和 50 之间")
	public String getGsmc() {
		return gsmc;
	}

	/**
     * 受益人名称
     */
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc == null ? null : gsmc.trim();
	}
	
	/**
     * 有效期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYxq() {
		return yxq;
	}

	/**
     * 有效期
     */
	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}
	
	/**
     * 最晚装船期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZwzcq() {
		return zwzcq;
	}

	/**
     * 最晚装船期
     */
	public void setZwzcq(Date zwzcq) {
		this.zwzcq = zwzcq;
	}
	
	/**
     * 议付交单期
     */
	public Integer getYfjdq() {
		return yfjdq;
	}

	/**
     * 议付交单期
     */
	public void setYfjdq(Integer yfjdq) {
		this.yfjdq = yfjdq;
	}
	
	/**
     * 信用证性质
     */
	@Length(min=0, max=50, message="信用证性质长度必须介于 0 和 50 之间")
	public String getXyzxz() {
		return xyzxz;
	}

	/**
     * 信用证性质
     */
	public void setXyzxz(String xyzxz) {
		this.xyzxz = xyzxz == null ? null : xyzxz.trim();
	}
	
	/**
     * 信用证性质名称
     */
	@Length(min=0, max=50, message="信用证性质名称长度必须介于 0 和 50 之间")
	public String getXyzxzmc() {
		return xyzxzmc;
	}

	/**
     * 信用证性质名称
     */
	public void setXyzxzmc(String xyzxzmc) {
		this.xyzxzmc = xyzxzmc == null ? null : xyzxzmc.trim();
	}
	
	/**
     * 议付后付款时间
     */
	public Integer getYfhcksj() {
		return yfhcksj;
	}

	/**
     * 议付后付款时间
     */
	public void setYfhcksj(Integer yfhcksj) {
		this.yfhcksj = yfhcksj;
	}
	
	/**
     * 是否循环LC
     */
	public Integer getSfxhlc() {
		return sfxhlc;
	}

	/**
     * 是否循环LC
     */
	public void setSfxhlc(Integer sfxhlc) {
		this.sfxhlc = sfxhlc;
	}
	
	/**
     * 循环LC次数上限
     */
	public Integer getXhlccssx() {
		return xhlccssx;
	}

	/**
     * 循环LC次数上限
     */
	public void setXhlccssx(Integer xhlccssx) {
		this.xhlccssx = xhlccssx;
	}
	
	/**
     * 是否备用信用证
     */
	public Integer getSfbyxyz() {
		return sfbyxyz;
	}

	/**
     * 是否备用信用证
     */
	public void setSfbyxyz(Integer sfbyxyz) {
		this.sfbyxyz = sfbyxyz;
	}
	
	/**
     * 目的港
     */
	@Length(min=0, max=50, message="目的港长度必须介于 0 和 50 之间")
	public String getMdg() {
		return mdg;
	}

	/**
     * 目的港
     */
	public void setMdg(String mdg) {
		this.mdg = mdg == null ? null : mdg.trim();
	}
	
	/**
     * 装运条款-允许分运
     */
	public Integer getZytkYxfy() {
		return zytkYxfy;
	}

	/**
     * 装运条款-允许分运
     */
	public void setZytkYxfy(Integer zytkYxfy) {
		this.zytkYxfy = zytkYxfy;
	}
	
	/**
     * 装运条款-允许转运
     */
	public Integer getZytkYxzy() {
		return zytkYxzy;
	}

	/**
     * 装运条款-允许转运
     */
	public void setZytkYxzy(Integer zytkYxzy) {
		this.zytkYxzy = zytkYxzy;
	}
	
	/**
     * 开证行
     */
	@Length(min=0, max=50, message="开证行长度必须介于 0 和 50 之间")
	public String getKzh() {
		return kzh;
	}

	/**
     * 开证行
     */
	public void setKzh(String kzh) {
		this.kzh = kzh == null ? null : kzh.trim();
	}
	
	/**
     * 开证行SWIFT
     */
	@Length(min=0, max=20, message="开证行SWIFT长度必须介于 0 和 20 之间")
	public String getKzhdm() {
		return kzhdm;
	}

	/**
     * 开证行SWIFT
     */
	public void setKzhdm(String kzhdm) {
		this.kzhdm = kzhdm == null ? null : kzhdm.trim();
	}
	
	/**
     * 通知行
     */
	@Length(min=0, max=50, message="通知行长度必须介于 0 和 50 之间")
	public String getTzh() {
		return tzh;
	}

	/**
     * 通知行
     */
	public void setTzh(String tzh) {
		this.tzh = tzh == null ? null : tzh.trim();
	}
	
	/**
     * 指定议付行
     */
	@Length(min=0, max=50, message="指定议付行长度必须介于 0 和 50 之间")
	public String getZdyfh() {
		return zdyfh;
	}

	/**
     * 指定议付行
     */
	public void setZdyfh(String zdyfh) {
		this.zdyfh = zdyfh == null ? null : zdyfh.trim();
	}
	
	/**
     * 是否有保兑行
     */
	public Integer getSfybdh() {
		return sfybdh;
	}

	/**
     * 是否有保兑行
     */
	public void setSfybdh(Integer sfybdh) {
		this.sfybdh = sfybdh;
	}

	/**
     * 保兑行
     */
	@Length(min=0, max=50, message="保兑行长度必须介于 0 和 50 之间")
	public String getBdh() {
		return bdh;
	}

	/**
     * 保兑行
     */
	public void setBdh(String bdh) {
		this.bdh = bdh == null ? null : bdh.trim();
	}
	
	/**
     * 是否有偿付行
     */
	public Integer getSfycfh() {
		return sfycfh;
	}

	/**
     * 是否有偿付行
     */
	public void setSfycfh(Integer sfycfh) {
		this.sfycfh = sfycfh;
	}
	
	/**
     * 偿付行
     */
	@Length(min=0, max=50, message="偿付行长度必须介于 0 和 50 之间")
	public String getCfh() {
		return cfh;
	}

	/**
     * 偿付行
     */
	public void setCfh(String cfh) {
		this.cfh = cfh == null ? null : cfh.trim();
	}
	
	/**
     * 附件
     */
	@Length(min=0, max=500, message="附件长度必须介于 0 和 500 之间")
	public String getFj() {
		return fj;
	}

	/**
     * 附件
     */
	public void setFj(String fj) {
		this.fj = fj == null ? null : fj.trim();
	}
	
	/**
     * 备注信息
     */
	@Length(min=0, max=200, message="备注信息长度必须介于 0 和 200 之间")
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
     * 登记人ID
     */
	@Length(min=1, max=20, message="登记人ID长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * 登记人ID
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * 登记人名称
     */
	@Length(min=1, max=50, message="登记人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * 登记人名称
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}
	
	/**
     * 登记日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="登记日期不能为空")
	public Date getZdsj() {
		return zdsj;
	}

	/**
     * 登记日期
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

	public String getSkzrq() {
		return skzrq;
	}

	public void setSkzrq(String skzrq) {
		this.skzrq = skzrq;
	}

	public String getEkzrq() {
		return ekzrq;
	}

	public void setEkzrq(String ekzrq) {
		this.ekzrq = ekzrq;
	}

	public BigDecimal getYsyje() {
		return ysyje;
	}

	public void setYsyje(BigDecimal ysyje) {
		this.ysyje = ysyje;
	}

	public String getKhbm() {
		return khbm;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public String getMytk() {
		return mytk;
	}

	public void setMytk(String mytk) {
		this.mytk = mytk;
	}

	public String getMytkmc() {
		return mytkmc;
	}

	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc;
	}

	public String getQyg() {
		return qyg;
	}

	public void setQyg(String qyg) {
		this.qyg = qyg;
	}

	public String getQygmc() {
		return qygmc;
	}

	public void setQygmc(String qygmc) {
		this.qygmc = qygmc;
	}

	public String getQygbz() {
		return qygbz;
	}

	public void setQygbz(String qygbz) {
		this.qygbz = qygbz;
	}
	
	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getXsfph() {
		return xsfph;
	}

	public void setXsfph(String xsfph) {
		this.xsfph = xsfph;
	}

	public String getYhckh() {
		return yhckh;
	}

	public void setYhckh(String yhckh) {
		this.yhckh = yhckh;
	}

	public String getXgbbh() {
		return xgbbh;
	}

	public void setXgbbh(String xgbbh) {
		this.xgbbh = xgbbh;
	}

	public Integer getXyzxzts() {
		return xyzxzts;
	}

	public void setXyzxzts(Integer xyzxzts) {
		this.xyzxzts = xyzxzts;
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
	
}