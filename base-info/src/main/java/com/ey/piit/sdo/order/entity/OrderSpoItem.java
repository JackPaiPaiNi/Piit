package com.ey.piit.sdo.order.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 备损订单管理Entity
 * @author 魏诚
 */
public class OrderSpoItem extends BaseEntity {
	
	private String ddid;		// 订单号
	private Integer bbh;		// 版本号
	private String wllx;		// 物料类型
	private String wllxmc;		// 物料类型名称
	private String wlbh;		// 物料编号
	private String wlms;		// 物料描述
	private String bz;		// 币种
	private BigDecimal sl;		// 数量
	private String dw;		// 单位
	private BigDecimal  dj;		// 单价
	private String ckddh;		// 参考订单号
	private String jixing;		// 机型
	private String jixin;		// 机芯
	private String piid;
	private String piitemid;
	private BigDecimal je;		//总金额
	private Integer yzhsl;	// 已走货数量
	private String flag;	// 操作类型
	private String flagmc;	// 操作类型名称
	
	public OrderSpoItem() {
		super();
	}

	public OrderSpoItem(String id){
		super(id);
	}

	/**
     * 订单号
     */
	@Length(min=1, max=20, message="订单号长度必须介于 1 和 20 之间")
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
     * 物料类型
     */
	@Length(min=0, max=20, message="物料类型长度必须介于 0 和 20 之间")
	public String getWllx() {
		return wllx;
	}

	/**
     * 物料类型
     */
	public void setWllx(String wllx) {
		this.wllx = wllx == null ? null : wllx.trim();
	}
	
	/**
     * 物料类型名称
     */
	@Length(min=0, max=50, message="物料类型名称长度必须介于 0 和 50 之间")
	public String getWllxmc() {
		return wllxmc;
	}

	/**
     * 物料类型名称
     */
	public void setWllxmc(String wllxmc) {
		this.wllxmc = wllxmc == null ? null : wllxmc.trim();
	}
	
	/**
     * 物料编号
     */
	@Length(min=1, max=50, message="物料编号长度必须介于 1 和 50 之间")
	public String getWlbh() {
		return wlbh;
	}

	/**
     * 物料编号
     */
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh == null ? null : wlbh.trim();
	}
	
	/**
     * 物料描述
     */
	@Length(min=0, max=100, message="物料描述长度必须介于 0 和 100 之间")
	public String getWlms() {
		return wlms;
	}

	/**
     * 物料描述
     */
	public void setWlms(String wlms) {
		this.wlms = wlms == null ? null : wlms.trim();
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
     * 数量
     */
	public BigDecimal getSl() {
		return sl;
	}

	/**
     * 数量
     */
	public void setSl(BigDecimal sl) {
		this.sl = sl;
	}
	
	/**
     * 单位
     */
	@Length(min=0, max=20, message="单位长度必须介于 0 和 20 之间")
	public String getDw() {
		return dw;
	}

	/**
     * 单位
     */
	public void setDw(String dw) {
		this.dw = dw == null ? null : dw.trim();
	}
	
	/**
     * 单价
     */
	public BigDecimal getDj() {
		return dj;
	}

	/**
     * 单价
     */
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	
	/**
     * 参考订单号
     */
	@Length(min=0, max=20, message="参考订单号长度必须介于 0 和 20 之间")
	public String getCkddh() {
		return ckddh;
	}

	/**
     * 参考订单号
     */
	public void setCkddh(String ckddh) {
		this.ckddh = ckddh == null ? null : ckddh.trim();
	}
	
	/**
     * 机型
     */
	@Length(min=0, max=50, message="机型长度必须介于 0 和 50 之间")
	public String getJixing() {
		return jixing;
	}

	/**
     * 机型
     */
	public void setJixing(String jixing) {
		this.jixing = jixing == null ? null : jixing.trim();
	}
	
	/**
     * 机芯
     */
	@Length(min=0, max=20, message="机芯长度必须介于 0 和 20 之间")
	public String getJixin() {
		return jixin;
	}

	/**
     * 机芯
     */
	public void setJixin(String jixin) {
		this.jixin = jixin == null ? null : jixin.trim();
	}

	public String getPiitemid() {
		return piitemid;
	}

	public void setPiitemid(String piitemid) {
		this.piitemid = piitemid;
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public Integer getYzhsl() {
		return yzhsl;
	}

	public void setYzhsl(Integer yzhsl) {
		this.yzhsl = yzhsl;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlagmc() {
		return flagmc;
	}

	public void setFlagmc(String flagmc) {
		this.flagmc = flagmc;
	}
	
}