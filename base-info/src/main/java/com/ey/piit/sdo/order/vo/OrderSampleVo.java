package com.ey.piit.sdo.order.vo;

import java.io.Serializable;
import java.util.List;

import com.ey.piit.sdo.order.entity.OrderSample;
import com.google.common.collect.Lists;

/**
 * 样机订单管理Entity
 * @author 高文浩
 */
public class OrderSampleVo extends OrderSample implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 623630810855627042L;
	
	private List<OrderReferPiVo> orderReferPiList = Lists.newArrayList();		// 子表列表
	private List<OrderLogVo> logList = Lists.newArrayList();		            //订单日志
	private List<OrderBgmxVo> bgmxList = Lists.newArrayList();		            //变更明细
	private String ztmc;
	private String dzgcs;//电子工程师ID
	private String dygcs;//电源工程师ID
	private String jggcs;//结构工程师ID
	private Integer slje;//修改数量还是金额
	private String lccpjl;//用于流程选择产品经理
	private String lccpjlmc;//产品经理名称
	private Integer type;//1取消 2撤回
	private String qxbz; //取消备注
	private String piid; // PI号
	
	public OrderSampleVo() {
		super();
	}

	public OrderSampleVo(String id){
		super(id);
	}
	
	public List<OrderReferPiVo> getOrderReferPiList() {
		return orderReferPiList;
	}

	public void setOrderReferPiList(List<OrderReferPiVo> orderReferPiList) {
		this.orderReferPiList = orderReferPiList;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public List<OrderLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<OrderLogVo> logList) {
		this.logList = logList;
	}

	public String getDzgcs() {
		return dzgcs;
	}

	public void setDzgcs(String dzgcs) {
		this.dzgcs = dzgcs;
	}

	public String getDygcs() {
		return dygcs;
	}

	public void setDygcs(String dygcs) {
		this.dygcs = dygcs;
	}

	public String getJggcs() {
		return jggcs;
	}

	public void setJggcs(String jggcs) {
		this.jggcs = jggcs;
	}

	public List<OrderBgmxVo> getBgmxList() {
		return bgmxList;
	}

	public void setBgmxList(List<OrderBgmxVo> bgmxList) {
		this.bgmxList = bgmxList;
	}

	public Integer getSlje() {
		return slje;
	}

	public void setSlje(Integer slje) {
		this.slje = slje;
	}

	public String getLccpjl() {
		return lccpjl;
	}

	public void setLccpjl(String lccpjl) {
		this.lccpjl = lccpjl;
	}

	public String getLccpjlmc() {
		return lccpjlmc;
	}

	public void setLccpjlmc(String lccpjlmc) {
		this.lccpjlmc = lccpjlmc;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getQxbz() {
		return qxbz;
	}

	public void setQxbz(String qxbz) {
		this.qxbz = qxbz;
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

}