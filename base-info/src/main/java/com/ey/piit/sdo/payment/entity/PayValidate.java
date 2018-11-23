package com.ey.piit.sdo.payment.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 付款保障检查Entity
 * @author 魏诚
 */
public class PayValidate extends BaseEntity {

	private String jd;		// 节点
	private String ddid;		// 订单号
	private String yzhdh;		// 预走货单号
	private String zy;		// 备注信息
	
	public PayValidate() {
		super();
	}

	public PayValidate(String id){
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
     * 预走货单号
     */
	@Length(min=0, max=20, message="预走货单号长度必须介于 0 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	/**
     * 预走货单号
     */
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh == null ? null : yzhdh.trim();
	}
	
	/**
     * 节点
     */
	@Length(min=0, max=50, message="节点长度必须介于 0 和 50 之间")
	public String getJd() {
		return jd;
	}

	/**
     * 节点
     */
	public void setJd(String jd) {
		this.jd = jd == null ? null : jd.trim();
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}
	
}