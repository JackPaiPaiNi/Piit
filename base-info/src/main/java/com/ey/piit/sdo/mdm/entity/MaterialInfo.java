package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 物料管理Entity
 * @author 田荣
 */
public class MaterialInfo extends BaseEntity {
	
	private String wlbh;		// 物料编号
	private String wllx;		// 物料类型
	private String wlz;		// 物料组
	private Double mpq;		// 最小包装量MPQ
	private String wldmszw;		// 物料短描述（中文）
	private String wldmsyw;		// 物料短描述（英文）
	private String wlms;		// 物料描述（英文）
	private String ggcc;		// 规格尺寸
	private String cpdl;		// 成品大类
	private String cpzl;		// 成品中类
	private String cpxl;		// 成品小类
	private String wldw;		// 物料单位
	private String wlzt;		// 物料状态
	private String sjc;		// 时间戳
	private String dj;	//单价
	private String model; //我司型号（多元化用）
	private String khxh; //客户型号
	
	public MaterialInfo() {
		super();
	}

	public MaterialInfo(String id){
		super(id);
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
     * 物料类型
     */
	@Length(min=0, max=50, message="物料类型长度必须介于 0 和 50 之间")
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
     * 物料组
     */
	@Length(min=0, max=50, message="物料组长度必须介于 0 和 50 之间")
	public String getWlz() {
		return wlz;
	}

	/**
     * 物料组
     */
	public void setWlz(String wlz) {
		this.wlz = wlz == null ? null : wlz.trim();
	}
	
	public Double getMpq() {
		return mpq;
	}

	public void setMpq(Double mpq) {
		this.mpq = mpq;
	}

	/**
     * 物料短描述（中文）
     */
	@Length(min=0, max=50, message="物料短描述（中文）长度必须介于 0 和 50 之间")
	public String getWldmszw() {
		return wldmszw;
	}

	/**
     * 物料短描述（中文）
     */
	public void setWldmszw(String wldmszw) {
		this.wldmszw = wldmszw == null ? null : wldmszw.trim();
	}
	
	/**
     * 物料短描述（英文）
     */
	@Length(min=0, max=50, message="物料短描述（英文）长度必须介于 0 和 50 之间")
	public String getWldmsyw() {
		return wldmsyw;
	}

	/**
     * 物料短描述（英文）
     */
	public void setWldmsyw(String wldmsyw) {
		this.wldmsyw = wldmsyw == null ? null : wldmsyw.trim();
	}
	
	/**
     * 物料描述（英文）
     */
	@Length(min=0, max=255, message="物料描述（英文）长度必须介于 0 和 255 之间")
	public String getWlms() {
		return wlms;
	}

	/**
     * 物料描述（英文）
     */
	public void setWlms(String wlms) {
		this.wlms = wlms == null ? null : wlms.trim();
	}
	
	/**
     * 规格尺寸
     */
	@Length(min=0, max=20, message="规格尺寸长度必须介于 0 和 20 之间")
	public String getGgcc() {
		return ggcc;
	}

	/**
     * 规格尺寸
     */
	public void setGgcc(String ggcc) {
		this.ggcc = ggcc == null ? null : ggcc.trim();
	}
	
	/**
     * 成品大类
     */
	@Length(min=0, max=50, message="成品大类长度必须介于 0 和 50 之间")
	public String getCpdl() {
		return cpdl;
	}

	/**
     * 成品大类
     */
	public void setCpdl(String cpdl) {
		this.cpdl = cpdl == null ? null : cpdl.trim();
	}
	
	/**
     * 成品中类
     */
	@Length(min=0, max=50, message="成品中类长度必须介于 0 和 50 之间")
	public String getCpzl() {
		return cpzl;
	}

	/**
     * 成品中类
     */
	public void setCpzl(String cpzl) {
		this.cpzl = cpzl == null ? null : cpzl.trim();
	}
	
	/**
     * 成品小类
     */
	@Length(min=0, max=50, message="成品小类长度必须介于 0 和 50 之间")
	public String getCpxl() {
		return cpxl;
	}

	/**
     * 成品小类
     */
	public void setCpxl(String cpxl) {
		this.cpxl = cpxl == null ? null : cpxl.trim();
	}
	
	/**
     * 物料单位
     */
	@Length(min=0, max=20, message="物料单位长度必须介于 0 和 20 之间")
	public String getWldw() {
		return wldw;
	}

	/**
     * 物料单位
     */
	public void setWldw(String wldw) {
		this.wldw = wldw == null ? null : wldw.trim();
	}
	
	/**
     * 物料状态
     */
	@Length(min=0, max=20, message="物料状态长度必须介于 0 和 20 之间")
	public String getWlzt() {
		return wlzt;
	}

	/**
     * 物料状态
     */
	public void setWlzt(String wlzt) {
		this.wlzt = wlzt == null ? null : wlzt.trim();
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

	public String getDj() {
		return dj;
	}

	public void setDj(String dj) {
		this.dj = dj;
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
	
}