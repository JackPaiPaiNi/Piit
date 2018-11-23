package com.ey.piit.sdo.order.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 多元化订单管理Entity
 * 
 * @author 高文浩
 */
public class OrderDiversityItem extends BaseEntity {

	private String ddid; // 订单号
	private Integer bbh; // 版本号
	private String cplx; // 产品类型
	private String cplxmc; // 产品类型名称
	private String wlbh; // 我司型号
	private String khxhms; // 客户型号描述
	private Integer sl; // 数量
	private BigDecimal dj; // 单价
	private BigDecimal je; // 金额
	private Integer mfsl; // 免费数量
	private String piid;
	private String piitemid;
	private Integer yzhsl; // 已走货数量
	private String model; // 我司型号
	private String khxh; // 客户型号
	private String flag; // 操作类型
	private String flagmc; // 操作类型名称
	private Integer rn; // 行号

	public OrderDiversityItem() {
		super();
	}

	public OrderDiversityItem(String id) {
		super(id);
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	@Length(min = 0, max = 50, message = "物料编码长度必须介于 0 和 50 之间")
	public String getWlbh() {
		return wlbh;
	}

	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}

	public String getKhxhms() {
		return khxhms;
	}

	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms;
	}

	/**
	 * 订单号
	 */
	@Length(min = 1, max = 20, message = "订单号长度必须介于 1 和 20 之间")
	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	/**
	 * 版本号
	 */
	@NotNull(message = "版本号不能为空")
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
	 * 产品类型
	 */
	@Length(min = 0, max = 50, message = "产品类型长度必须介于 0 和 50 之间")
	public String getCplx() {
		return cplx;
	}

	/**
	 * 产品类型
	 */
	public void setCplx(String cplx) {
		this.cplx = cplx == null ? null : cplx.trim();
	}

	/**
	 * 产品类型名称
	 */
	@Length(min = 0, max = 50, message = "产品类型名称长度必须介于 0 和 50 之间")
	public String getCplxmc() {
		return cplxmc;
	}

	/**
	 * 产品类型名称
	 */
	public void setCplxmc(String cplxmc) {
		this.cplxmc = cplxmc == null ? null : cplxmc.trim();
	}

	/**
	 * 数量
	 */
	public Integer getSl() {
		return sl;
	}

	/**
	 * 数量
	 */
	public void setSl(Integer sl) {
		this.sl = sl;
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
	 * 金额
	 */
	public BigDecimal getJe() {
		return je;
	}

	/**
	 * 金额
	 */
	public void setJe(BigDecimal je) {
		this.je = je;
	}

	/**
	 * 免费数量
	 */
	public Integer getMfsl() {
		return mfsl;
	}

	/**
	 * 免费数量
	 */
	public void setMfsl(Integer mfsl) {
		this.mfsl = mfsl;
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

	public Integer getYzhsl() {
		return yzhsl;
	}

	public void setYzhsl(Integer yzhsl) {
		this.yzhsl = yzhsl;
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