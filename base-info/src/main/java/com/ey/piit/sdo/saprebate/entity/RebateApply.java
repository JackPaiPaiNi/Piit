package com.ey.piit.sdo.saprebate.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * sap返利申请Entity
 * @author 赵桃军
 */
public class RebateApply extends BaseEntity {
	
	private String splsh;		// 审批单流水号
	private String hhao;		// 行号
	private String bukrs;		// 公司代码
	private String zflnm;		// 返利申报单号
	private Integer zitem;		// 序号
	private String kunnr;		// 客户编码
	private String khmc;		// 客户名称
	private String zsalm;		// 业务员
	private String zsalmms;		// 业务员描述
	private String zrpnm;		// 返利政策编号
	private String zmodl;		// 型号
	private String waers;		// 货币码
	private BigDecimal xtjyje;		// 系统建议返利申报金额
	private BigDecimal cyje;		// 差异金额（新增）
	private Double zfkim;		// 实际已开票数量
	private String meins;		// 基本计量单位
	private BigDecimal zfamt;		// 返利申报金额
	private BigDecimal zyamt;		// 返利预提金额
	private String zybln;		// 预提会计凭证编号
	private Integer zbuze;		// 预提凭证行项目
	private String zlart;		// 凭证类型
	private String zlartms;		// 凭证类型描述
	private String zstau;		// 状态
	private String zwcbz;		// 完成标志
	private String userid;		// 用户名
	private Date cpudt;			// 系统日期
	private Date cputm;			// 系统时间
	private String sbyy;		// 申报原因
	private String zrcnm;       //返利分类编码
	private String zrcnmms;     //返利分类编码描述
	private Integer tssapzt;    //推送SAP状态
	
	
	
	public Integer getTssapzt() {
		return tssapzt;
	}

	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
	}

	public String getZrcnm() {
		return zrcnm;
	}

	public void setZrcnm(String zrcnm) {
		this.zrcnm = zrcnm;
	}

	public String getZrcnmms() {
		return zrcnmms;
	}

	public void setZrcnmms(String zrcnmms) {
		this.zrcnmms = zrcnmms;
	}

	public RebateApply() {
		super();
	}

	public RebateApply(String id){
		super(id);
	}

	/**
     * 审批单流水号
     */
	@Length(min=0, max=20, message="审批单流水号长度必须介于 0 和 20 之间")
	public String getSplsh() {
		return splsh;
	}

	/**
     * 审批单流水号
     */
	public void setSplsh(String splsh) {
		this.splsh = splsh == null ? null : splsh.trim();
	}
	
	/**
     * 行号
     */
	@Length(min=0, max=6, message="行号长度必须介于 0 和 6 之间")
	public String getHhao() {
		return hhao;
	}

	/**
     * 行号
     */
	public void setHhao(String hhao) {
		this.hhao = hhao == null ? null : hhao.trim();
	}
	
	/**
     * 公司代码
     */
	@Length(min=0, max=10, message="公司代码长度必须介于 0 和 10 之间")
	public String getBukrs() {
		return bukrs;
	}

	/**
     * 公司代码
     */
	public void setBukrs(String bukrs) {
		this.bukrs = bukrs == null ? null : bukrs.trim();
	}
	
	/**
     * 返利申报单号
     */
	@Length(min=0, max=20, message="返利申报单号长度必须介于 0 和 20 之间")
	public String getZflnm() {
		return zflnm;
	}

	/**
     * 返利申报单号
     */
	public void setZflnm(String zflnm) {
		this.zflnm = zflnm == null ? null : zflnm.trim();
	}
	
	/**
     * 行号
     */
	public Integer getZitem() {
		return zitem;
	}

	/**
     * 行号
     */
	public void setZitem(Integer zitem) {
		this.zitem = zitem;
	}
	
	/**
     * 客户编码
     */
	@Length(min=0, max=20, message="客户编码长度必须介于 0 和 20 之间")
	public String getKunnr() {
		return kunnr;
	}

	/**
     * 客户编码
     */
	public void setKunnr(String kunnr) {
		this.kunnr = kunnr == null ? null : kunnr.trim();
	}
	
	/**
     * 客户名称
     */
	@Length(min=0, max=400, message="客户名称长度必须介于 0 和 400 之间")
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
     * 业务员
     */
	@Length(min=0, max=20, message="业务员长度必须介于 0 和 20 之间")
	public String getZsalm() {
		return zsalm;
	}

	/**
     * 业务员
     */
	public void setZsalm(String zsalm) {
		this.zsalm = zsalm == null ? null : zsalm.trim();
	}
	
	/**
     * 业务员描述
     */
	@Length(min=0, max=50, message="业务员描述长度必须介于 0 和 50 之间")
	public String getZsalmms() {
		return zsalmms;
	}

	/**
     * 业务员描述
     */
	public void setZsalmms(String zsalmms) {
		this.zsalmms = zsalmms == null ? null : zsalmms.trim();
	}
	
	/**
     * 返利政策编号
     */
	@Length(min=0, max=20, message="返利政策编号长度必须介于 0 和 20 之间")
	public String getZrpnm() {
		return zrpnm;
	}

	/**
     * 返利政策编号
     */
	public void setZrpnm(String zrpnm) {
		this.zrpnm = zrpnm == null ? null : zrpnm.trim();
	}
	
	/**
     * 型号
     */
	@Length(min=0, max=50, message="型号长度必须介于 0 和 50 之间")
	public String getZmodl() {
		return zmodl;
	}

	/**
     * 型号
     */
	public void setZmodl(String zmodl) {
		this.zmodl = zmodl == null ? null : zmodl.trim();
	}
	
	/**
     * 货币码
     */
	@Length(min=0, max=10, message="货币码长度必须介于 0 和 10 之间")
	public String getWaers() {
		return waers;
	}

	/**
     * 货币码
     */
	public void setWaers(String waers) {
		this.waers = waers == null ? null : waers.trim();
	}
	
	/**
     * 实际已开票数量
     */
	public Double getZfkim() {
		return zfkim;
	}

	/**
     * 实际已开票数量
     */
	public void setZfkim(Double zfkim) {
		this.zfkim = zfkim;
	}
	
	/**
     * 基本计量单位
     */
	@Length(min=0, max=10, message="基本计量单位长度必须介于 0 和 10 之间")
	public String getMeins() {
		return meins;
	}

	/**
     * 基本计量单位
     */
	public void setMeins(String meins) {
		this.meins = meins == null ? null : meins.trim();
	}
	
	/**
     * 预提会计凭证编号
     */
	@Length(min=0, max=20, message="预提会计凭证编号长度必须介于 0 和 20 之间")
	public String getZybln() {
		return zybln;
	}

	/**
     * 预提会计凭证编号
     */
	public void setZybln(String zybln) {
		this.zybln = zybln == null ? null : zybln.trim();
	}
	
	/**
     * 预提凭证行项目
     */
	public Integer getZbuze() {
		return zbuze;
	}

	/**
     * 预提凭证行项目
     */
	public void setZbuze(Integer zbuze) {
		this.zbuze = zbuze;
	}
	
	/**
     * 凭证类型
     */
	@Length(min=0, max=10, message="凭证类型长度必须介于 0 和 10 之间")
	public String getZlart() {
		return zlart;
	}

	/**
     * 凭证类型
     */
	public void setZlart(String zlart) {
		this.zlart = zlart == null ? null : zlart.trim();
	}
	
	/**
     * 凭证类型描述
     */
	@Length(min=0, max=50, message="凭证类型描述长度必须介于 0 和 50 之间")
	public String getZlartms() {
		return zlartms;
	}

	/**
     * 凭证类型描述
     */
	public void setZlartms(String zlartms) {
		this.zlartms = zlartms == null ? null : zlartms.trim();
	}
	
	/**
     * 状态
     */
	@Length(min=0, max=10, message="状态长度必须介于 0 和 10 之间")
	public String getZstau() {
		return zstau;
	}

	/**
     * 状态
     */
	public void setZstau(String zstau) {
		this.zstau = zstau == null ? null : zstau.trim();
	}
	
	/**
     * 完成标志
     */
	@Length(min=0, max=10, message="完成标志长度必须介于 0 和 10 之间")
	public String getZwcbz() {
		return zwcbz;
	}

	/**
     * 完成标志
     */
	public void setZwcbz(String zwcbz) {
		this.zwcbz = zwcbz == null ? null : zwcbz.trim();
	}
	
	/**
     * 用户名
     */
	@Length(min=0, max=20, message="用户名长度必须介于 0 和 20 之间")
	public String getUserid() {
		return userid;
	}

	/**
     * 用户名
     */
	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}
	
	/**
     * 系统日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCpudt() {
		return cpudt;
	}

	/**
     * 系统日期
     */
	public void setCpudt(Date cpudt) {
		this.cpudt = cpudt;
	}
	
	/**
     * 系统时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCputm() {
		return cputm;
	}

	/**
     * 系统时间
     */
	public void setCputm(Date cputm) {
		this.cputm = cputm;
	}
	
	/**
     * 申报原因
     */
	@Length(min=0, max=255, message="申报原因长度必须介于 0 和 255 之间")
	public String getSbyy() {
		return sbyy;
	}

	/**
     * 申报原因
     */
	public void setSbyy(String sbyy) {
		this.sbyy = sbyy == null ? null : sbyy.trim();
	}

	public BigDecimal getXtjyje() {
		return xtjyje;
	}

	public void setXtjyje(BigDecimal xtjyje) {
		this.xtjyje = xtjyje;
	}

	public BigDecimal getCyje() {
		return cyje;
	}

	public void setCyje(BigDecimal cyje) {
		this.cyje = cyje;
	}

	public BigDecimal getZfamt() {
		return zfamt;
	}

	public void setZfamt(BigDecimal zfamt) {
		this.zfamt = zfamt;
	}

	public BigDecimal getZyamt() {
		return zyamt;
	}

	public void setZyamt(BigDecimal zyamt) {
		this.zyamt = zyamt;
	}
	
}