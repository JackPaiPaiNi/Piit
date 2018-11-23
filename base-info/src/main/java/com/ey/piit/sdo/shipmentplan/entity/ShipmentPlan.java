package com.ey.piit.sdo.shipmentplan.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 走货计划Entity
 * @author tianrong
 */
public class ShipmentPlan extends BaseEntity {
	
	private String dch;	//订舱号
	private Date jgq;	//截关期 
	private Date jvgm;	// 截VGM
	private Date jsi;	// 截SI
	private Date yjkcq;	// 预计开船期
	private String kcy;	//开船月
	private String tcgs;//拖车公司
	private String sgap;//上柜安排
	private Date yzhddsj;//预走货到达船务主管时间
	private String bzxx;//备注信息
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Date jszgsj;		// 结束装柜时间
	private String qyg;		    // 起运港
	private String qygmc;		// 起运港名称
	private Integer dc3d;		// 吨车-3吨
	private Integer dc5d;		// 吨车-5吨
	private Integer dc8d;		// 吨车-8吨
	private Integer dc10d;		// 吨车-10吨
	private Integer dc12d;		// 吨车-12吨
	private String chdh;		//出货单号
	
	public ShipmentPlan() {
		super();
	}

	public ShipmentPlan(String id){
		super(id);
	}

	public String getDch() {
		return dch;
	}

	public void setDch(String dch) {
		this.dch = dch;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJgq() {
		return jgq;
	}

	public void setJgq(Date jgq) {
		this.jgq = jgq;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJvgm() {
		return jvgm;
	}

	public void setJvgm(Date jvgm) {
		this.jvgm = jvgm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJsi() {
		return jsi;
	}

	public void setJsi(Date jsi) {
		this.jsi = jsi;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjkcq() {
		return yjkcq;
	}

	public void setYjkcq(Date yjkcq) {
		this.yjkcq = yjkcq;
	}

	public String getKcy() {
		return kcy;
	}

	public void setKcy(String kcy) {
		this.kcy = kcy;
	}

	public String getTcgs() {
		return tcgs;
	}

	public void setTcgs(String tcgs) {
		this.tcgs = tcgs;
	}

	public String getSgap() {
		return sgap;
	}

	public void setSgap(String sgap) {
		this.sgap = sgap;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYzhddsj() {
		return yzhddsj;
	}

	public void setYzhddsj(Date yzhddsj) {
		this.yzhddsj = yzhddsj;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJszgsj() {
		return jszgsj;
	}

	public void setJszgsj(Date jszgsj) {
		this.jszgsj = jszgsj;
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

	public Integer getDc3d() {
		return dc3d;
	}

	public void setDc3d(Integer dc3d) {
		this.dc3d = dc3d;
	}

	public Integer getDc5d() {
		return dc5d;
	}

	public void setDc5d(Integer dc5d) {
		this.dc5d = dc5d;
	}

	public Integer getDc8d() {
		return dc8d;
	}

	public void setDc8d(Integer dc8d) {
		this.dc8d = dc8d;
	}

	public Integer getDc10d() {
		return dc10d;
	}

	public void setDc10d(Integer dc10d) {
		this.dc10d = dc10d;
	}

	public Integer getDc12d() {
		return dc12d;
	}

	public void setDc12d(Integer dc12d) {
		this.dc12d = dc12d;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	
}