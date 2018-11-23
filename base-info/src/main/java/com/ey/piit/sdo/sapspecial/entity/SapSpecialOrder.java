package com.ey.piit.sdo.sapspecial.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * sap特价审批管理Entity
 * @author 赵桃军
 */
public class SapSpecialOrder extends BaseEntity {
	
	private String xsdd;		// 销售订单
	private String spcl;		// 审批策略
	private String xszz;		// 销售组织
	private String fxqd;		// 分销渠道
	private String xsbgs;		// 销售办公室
	private String jgqd;		// 价格清单
	private String cgdd;		// 采购订单
	private String khmc;		// 客户名称
	private String xsy;			// 销售员
	private String sqr;			// 申请人
	private Date sqrq;			// 申请日期
	private Date ddrq;			// 订单日期
	private Date djrq;			// 定价日期
	private String fktj;		// 付款条件
	private String jshb;		// 结算货币
	private String sjc;			// 时间戳
	private Integer zt;			// 单据状态
	private String  ztmc;  		//状态名称
	private String  bukrs;      //公司代码
	private Integer tssapzt ;   //推送SAP状态
	private String  dept;       //sdo销售员所在分公司代码

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getBukrs() {
		return bukrs;
	}

	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}

	public Integer getTssapzt() {
		return tssapzt;
	}

	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
	}

	public SapSpecialOrder() {
		super();
	}

	public SapSpecialOrder(String id){
		super(id);
	}
	
	
	

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	/**
     * 销售订单
     */
	@Length(min=0, max=10, message="销售订单长度必须介于 0 和 10 之间")
	public String getXsdd() {
		return xsdd;
	}

	/**
     * 销售订单
     */
	public void setXsdd(String xsdd) {
		this.xsdd = xsdd == null ? null : xsdd.trim();
	}
	
	/**
     * 审批策略
     */
	@Length(min=0, max=1, message="审批策略长度必须介于 0 和 1 之间")
	public String getSpcl() {
		return spcl;
	}

	/**
     * 审批策略
     */
	public void setSpcl(String spcl) {
		this.spcl = spcl == null ? null : spcl.trim();
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
     * 分销渠道
     */
	@Length(min=0, max=20, message="分销渠道长度必须介于 0 和 20 之间")
	public String getFxqd() {
		return fxqd;
	}

	/**
     * 分销渠道
     */
	public void setFxqd(String fxqd) {
		this.fxqd = fxqd == null ? null : fxqd.trim();
	}
	
	/**
     * 销售办公室
     */
	@Length(min=0, max=20, message="销售办公室长度必须介于 0 和 20 之间")
	public String getXsbgs() {
		return xsbgs;
	}

	/**
     * 销售办公室
     */
	public void setXsbgs(String xsbgs) {
		this.xsbgs = xsbgs == null ? null : xsbgs.trim();
	}
	
	/**
     * 价格清单
     */
	@Length(min=0, max=20, message="价格清单长度必须介于 0 和 20 之间")
	public String getJgqd() {
		return jgqd;
	}

	/**
     * 价格清单
     */
	public void setJgqd(String jgqd) {
		this.jgqd = jgqd == null ? null : jgqd.trim();
	}
	
	/**
     * 采购订单
     */
	@Length(min=0, max=20, message="采购订单长度必须介于 0 和 20 之间")
	public String getCgdd() {
		return cgdd;
	}

	/**
     * 采购订单
     */
	public void setCgdd(String cgdd) {
		this.cgdd = cgdd == null ? null : cgdd.trim();
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
	@Length(min=0, max=50, message="销售员长度必须介于 0 和 50 之间")
	public String getXsy() {
		return xsy;
	}

	/**
     * 销售员
     */
	public void setXsy(String xsy) {
		this.xsy = xsy == null ? null : xsy.trim();
	}
	
	/**
     * 申请人
     */
	@Length(min=0, max=12, message="申请人长度必须介于 0 和 12 之间")
	public String getSqr() {
		return sqr;
	}

	/**
     * 申请人
     */
	public void setSqr(String sqr) {
		this.sqr = sqr == null ? null : sqr.trim();
	}
	
	/**
     * 申请日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSqrq() {
		return sqrq;
	}

	/**
     * 申请日期
     */
	public void setSqrq(Date sqrq) {
		this.sqrq = sqrq;
	}
	
	/**
     * 订单日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDdrq() {
		return ddrq;
	}

	/**
     * 订单日期
     */
	public void setDdrq(Date ddrq) {
		this.ddrq = ddrq;
	}
	
	/**
     * 定价日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDjrq() {
		return djrq;
	}

	/**
     * 定价日期
     */
	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}
	
	/**
     * 付款条件
     */
	@Length(min=0, max=4, message="付款条件长度必须介于 0 和 4 之间")
	public String getFktj() {
		return fktj;
	}

	/**
     * 付款条件
     */
	public void setFktj(String fktj) {
		this.fktj = fktj == null ? null : fktj.trim();
	}
	
	/**
     * 结算货币
     */
	@Length(min=0, max=20, message="结算货币长度必须介于 0 和 20 之间")
	public String getJshb() {
		return jshb;
	}

	/**
     * 结算货币
     */
	public void setJshb(String jshb) {
		this.jshb = jshb == null ? null : jshb.trim();
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
	
	/**
     * 单据状态
     */
	public Integer getZt() {
		return zt;
	}

	/**
     * 单据状态
     */
	public void setZt(Integer zt) {
		this.zt = zt;
	}
	
}