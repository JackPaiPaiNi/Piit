package com.ey.piit.sdo.pso.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 预走货Entity
 * @author 赵桃军
 */
public class PsoNotify extends BaseEntity {
	
	private String yzhdh;		// 预走货单号 父类
	private Integer bbh;		// 版本号
	private Integer xh;		// 序号
	private String tzrmc;		// 通知人名称
	private String tzrdz;		// 通知人地址
	private String tzrlxr;		// 通知人联系人
	private String tzrdh;		// 通知人电话
	private String tzrcz;		// 通知人传真
	private String tzryb;		// 通知人邮编
	private String tzryx;		// 通知人邮箱
	
	private String tzfdm;
	private String tzfdh;
	
	public PsoNotify() {
		super();
	}

	public PsoNotify(String id){
		super(id);
	}

	

	/**
     * 预走货单号
     */
	@Length(min=1, max=20, message="预走货单号长度必须介于 1 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
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
     * 序号
     */
	public Integer getXh() {
		return xh;
	}

	/**
     * 序号
     */
	public void setXh(Integer xh) {
		this.xh = xh;
	}
	
	/**
     * 通知人名称
     */
	@Length(min=0, max=100, message="通知人名称长度必须介于 0 和 100 之间")
	public String getTzrmc() {
		return tzrmc;
	}

	/**
     * 通知人名称
     */
	public void setTzrmc(String tzrmc) {
		this.tzrmc = tzrmc == null ? null : tzrmc.trim();
	}
	
	/**
     * 通知人地址
     */
	@Length(min=0, max=100, message="通知人地址长度必须介于 0 和 100 之间")
	public String getTzrdz() {
		return tzrdz;
	}

	/**
     * 通知人地址
     */
	public void setTzrdz(String tzrdz) {
		this.tzrdz = tzrdz == null ? null : tzrdz.trim();
	}
	
	/**
     * 通知人联系人
     */
	@Length(min=0, max=50, message="通知人联系人长度必须介于 0 和 50 之间")
	public String getTzrlxr() {
		return tzrlxr;
	}

	/**
     * 通知人联系人
     */
	public void setTzrlxr(String tzrlxr) {
		this.tzrlxr = tzrlxr == null ? null : tzrlxr.trim();
	}
	
	/**
     * 通知人电话
     */
	@Length(min=0, max=20, message="通知人电话长度必须介于 0 和 20 之间")
	public String getTzrdh() {
		return tzrdh;
	}

	/**
     * 通知人电话
     */
	public void setTzrdh(String tzrdh) {
		this.tzrdh = tzrdh == null ? null : tzrdh.trim();
	}
	
	/**
     * 通知人传真
     */
	@Length(min=0, max=20, message="通知人传真长度必须介于 0 和 20 之间")
	public String getTzrcz() {
		return tzrcz;
	}

	/**
     * 通知人传真
     */
	public void setTzrcz(String tzrcz) {
		this.tzrcz = tzrcz == null ? null : tzrcz.trim();
	}
	
	/**
     * 通知人邮编
     */
	@Length(min=0, max=20, message="通知人邮编长度必须介于 0 和 20 之间")
	public String getTzryb() {
		return tzryb;
	}

	/**
     * 通知人邮编
     */
	public void setTzryb(String tzryb) {
		this.tzryb = tzryb == null ? null : tzryb.trim();
	}
	
	/**
     * 通知人邮箱
     */
	@Length(min=0, max=50, message="通知人邮箱长度必须介于 0 和 50 之间")
	public String getTzryx() {
		return tzryx;
	}

	/**
     * 通知人邮箱
     */
	public void setTzryx(String tzryx) {
		this.tzryx = tzryx == null ? null : tzryx.trim();
	}

	public String getTzfdm() {
		return tzfdm;
	}

	public void setTzfdm(String tzfdm) {
		this.tzfdm = tzfdm;
	}

	public String getTzfdh() {
		return tzfdh;
	}

	public void setTzfdh(String tzfdh) {
		this.tzfdh = tzfdh;
	}
	
}