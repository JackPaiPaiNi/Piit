package com.ey.piit.sdo.pi.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * PI管理Entity
 * @author 赵明
 */
public class PiItem extends BaseEntity {
	
	private	String	piid;		//	pi号
	private	String	mxlxmc;		//	明细类型名称
	private	String	pid;		//	pid
	private	String	wlbh;		//	物料编号
	private	String	khxhms;		//	客户型号描述
	private	String	ks;			//	款式
	private	String	ksmc;		//	款式名称
	private	String	mxlx;		//	明细类型
	private	String	dw;			//	单位
	private	Integer	sl;			//	数量
	private	BigDecimal	dj;			//	单价
	private	BigDecimal	je;			//	金额
	private	String	ckddh;		//	参考订单号
	private	String	jixin;		//	机芯
	private	String	jixing;		//	机型
	private	Integer	mfsl;		//	免费数量（多元化pi）
	private	Integer	bbh;		//	版本号
	private BigDecimal tj;	//特价
	private String model;	//我司型号（多元化用）
	private String khxh;	//客户型号
	private	Integer	yxdsl;			//	已下单数量
	private	Integer	spzsl;			//	审批中数量
	public PiItem() {
		super();
	}

	public PiItem(String id){
		super(id);
	}
	
	/**
     * 物料编号
     */
	@Length(min=0, max=50, message="物料编号长度必须介于 0 和 50 之间")
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
     * 客户型号描述
     */
	@Length(min=0, max=100, message="客户型号描述长度必须介于 0 和 100 之间")
	public String getKhxhms() {
		return khxhms;
	}

	/**
     * 客户型号描述
     */
	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms == null ? null : khxhms.trim();
	}
	
	/**
     * 明细类型
     */
	@Length(min=0, max=50, message="明细类型长度必须介于 0 和 50 之间")
	public String getMxlx() {
		return mxlx;
	}

	/**
     * 明细类型
     */
	public void setMxlx(String mxlx) {
		this.mxlx = mxlx == null ? null : mxlx.trim();
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
	
	
	
	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public void setTj(BigDecimal tj) {
		this.tj = tj;
	}
	

	public BigDecimal getTj() {
		return tj;
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
	
	/**
     * 机型
     */
	@Length(min=0, max=20, message="机型长度必须介于 0 和 20 之间")
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
     * 免费数量（多元化PI）
     */
	public Integer getMfsl() {
		return mfsl;
	}

	/**
     * 免费数量（多元化PI）
     */
	public void setMfsl(Integer mfsl) {
		this.mfsl = mfsl;
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

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public String getMxlxmc() {
		return mxlxmc;
	}

	public void setMxlxmc(String mxlxmc) {
		this.mxlxmc = mxlxmc;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getKs() {
		return ks;
	}

	public void setKs(String ks) {
		this.ks = ks;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public String getCkddh() {
		return ckddh;
	}

	public void setCkddh(String ckddh) {
		this.ckddh = ckddh;
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

	public Integer getYxdsl() {
		return yxdsl;
	}

	public void setYxdsl(Integer yxdsl) {
		this.yxdsl = yxdsl;
	}

	public Integer getSpzsl() {
		return spzsl;
	}

	public void setSpzsl(Integer spzsl) {
		this.spzsl = spzsl;
	}
	
}