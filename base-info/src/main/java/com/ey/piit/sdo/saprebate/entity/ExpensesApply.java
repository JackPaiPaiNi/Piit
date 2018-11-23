package com.ey.piit.sdo.saprebate.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * sap费用审批Entity
 * @author 赵桃军
 */
public class ExpensesApply extends BaseEntity {
	
	private String bukrs;		// 公司代码
	private String zfynm;		// 费用申请单号
	private String zstau;		// 状态
	private String zappm;		// 申请人
	private String ztele;		// 联系电话
	private String zsalm;		// 业务员
	private String zsalmms;		// 业务员描述
	private String zreas;		// 申请事由
	private String zetyp;		// 费用类型
	private String zetypms;		// 费用类型描述
	private BigDecimal zaamt;		// 申请金额
	private String waers;		// 货币码
	private BigDecimal rmbje;		// 人民币金额
	private String zrece;		// 支付方
	private String pzhslr;		// 辅助核算内容（描述）
	private String zbelo;		// 归属方
	private String zbeloms;		// 归属方描述
	private String zdepa;		// 承担部门
	private String zdepams;		// 承担部门描述
	private String zedes;		// 费用描述
	private String zybln;		// 预提会计凭证编号
	private Integer zbuze;		// 预提凭证行项目
	private BigDecimal zyamt;		// 返利预提金额
	private String userid;		// 用户名
	private Date cpudt;		// 系统日期
	private Date cputm;		// 系统时间
	private Integer tssapzt;    //推送SAP状态
	private String zspcd;		// 审批代码（对于费用类型的归类）
	
	
	
	
	
	public String getZspcd() {
		return zspcd;
	}

	public void setZspcd(String zspcd) {
		this.zspcd = zspcd;
	}

	public ExpensesApply() {
		super();
	}

	public ExpensesApply(String id){
		super(id);
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
     * 费用申请单号
     */
	@Length(min=0, max=20, message="费用申请单号长度必须介于 0 和 20 之间")
	public String getZfynm() {
		return zfynm;
	}

	/**
     * 费用申请单号
     */
	public void setZfynm(String zfynm) {
		this.zfynm = zfynm == null ? null : zfynm.trim();
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
     * 申请人
     */
	@Length(min=0, max=20, message="申请人长度必须介于 0 和 20 之间")
	public String getZappm() {
		return zappm;
	}

	/**
     * 申请人
     */
	public void setZappm(String zappm) {
		this.zappm = zappm == null ? null : zappm.trim();
	}
	
	/**
     * 联系电话
     */
	@Length(min=0, max=20, message="联系电话长度必须介于 0 和 20 之间")
	public String getZtele() {
		return ztele;
	}

	/**
     * 联系电话
     */
	public void setZtele(String ztele) {
		this.ztele = ztele == null ? null : ztele.trim();
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
     * 申请事由
     */
	@Length(min=0, max=200, message="申请事由长度必须介于 0 和 200 之间")
	public String getZreas() {
		return zreas;
	}

	/**
     * 申请事由
     */
	public void setZreas(String zreas) {
		this.zreas = zreas == null ? null : zreas.trim();
	}
	
	/**
     * 费用类型
     */
	@Length(min=0, max=10, message="费用类型长度必须介于 0 和 10 之间")
	public String getZetyp() {
		return zetyp;
	}

	/**
     * 费用类型
     */
	public void setZetyp(String zetyp) {
		this.zetyp = zetyp == null ? null : zetyp.trim();
	}
	
	/**
     * 费用类型描述
     */
	@Length(min=0, max=50, message="费用类型描述长度必须介于 0 和 50 之间")
	public String getZetypms() {
		return zetypms;
	}

	/**
     * 费用类型描述
     */
	public void setZetypms(String zetypms) {
		this.zetypms = zetypms == null ? null : zetypms.trim();
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
     * 支付方
     */
	@Length(min=0, max=50, message="支付方长度必须介于 0 和 50 之间")
	public String getZrece() {
		return zrece;
	}

	/**
     * 支付方
     */
	public void setZrece(String zrece) {
		this.zrece = zrece == null ? null : zrece.trim();
	}
	
	/**
     * 辅助核算内容（描述）
     */
	@Length(min=0, max=50, message="辅助核算内容（描述）长度必须介于 0 和 50 之间")
	public String getPzhslr() {
		return pzhslr;
	}

	/**
     * 辅助核算内容（描述）
     */
	public void setPzhslr(String pzhslr) {
		this.pzhslr = pzhslr == null ? null : pzhslr.trim();
	}
	
	/**
     * 归属方
     */
	@Length(min=0, max=20, message="归属方长度必须介于 0 和 20 之间")
	public String getZbelo() {
		return zbelo;
	}

	/**
     * 归属方
     */
	public void setZbelo(String zbelo) {
		this.zbelo = zbelo == null ? null : zbelo.trim();
	}
	
	/**
     * 归属方描述
     */
	@Length(min=0, max=50, message="归属方描述长度必须介于 0 和 50 之间")
	public String getZbeloms() {
		return zbeloms;
	}

	/**
     * 归属方描述
     */
	public void setZbeloms(String zbeloms) {
		this.zbeloms = zbeloms == null ? null : zbeloms.trim();
	}
	
	/**
     * 承担部门
     */
	@Length(min=0, max=20, message="承担部门长度必须介于 0 和 20 之间")
	public String getZdepa() {
		return zdepa;
	}

	/**
     * 承担部门
     */
	public void setZdepa(String zdepa) {
		this.zdepa = zdepa == null ? null : zdepa.trim();
	}
	
	/**
     * 承担部门描述
     */
	@Length(min=0, max=50, message="承担部门描述长度必须介于 0 和 50 之间")
	public String getZdepams() {
		return zdepams;
	}

	/**
     * 承担部门描述
     */
	public void setZdepams(String zdepams) {
		this.zdepams = zdepams == null ? null : zdepams.trim();
	}
	
	/**
     * 费用描述
     */
	@Length(min=0, max=200, message="费用描述长度必须介于 0 和 200 之间")
	public String getZedes() {
		return zedes;
	}

	/**
     * 费用描述
     */
	public void setZedes(String zedes) {
		this.zedes = zedes == null ? null : zedes.trim();
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

	public Integer getTssapzt() {
		return tssapzt;
	}

	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
	}

	public BigDecimal getZaamt() {
		return zaamt;
	}

	public void setZaamt(BigDecimal zaamt) {
		this.zaamt = zaamt;
	}

	public BigDecimal getRmbje() {
		return rmbje;
	}

	public void setRmbje(BigDecimal rmbje) {
		this.rmbje = rmbje;
	}

	public BigDecimal getZyamt() {
		return zyamt;
	}

	public void setZyamt(BigDecimal zyamt) {
		this.zyamt = zyamt;
	}
	
}