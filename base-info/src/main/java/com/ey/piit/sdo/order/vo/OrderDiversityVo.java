package com.ey.piit.sdo.order.vo;

import com.ey.piit.sdo.order.entity.OrderDiversity;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 多元化订单管理Entity
 * 
 * @author 高文浩
 */
public class OrderDiversityVo extends OrderDiversity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6927304334579113693L;

	private List<OrderDiversityItemVo> orderDiversityItemList = Lists.newArrayList(); // 子表列表
	private List<OrderLogVo> logList = Lists.newArrayList(); // 订单日志
	private String ztmc;
	private Integer type;// 1取消 2撤回
	private String qxbz; // 取消备注
	private String piid; // PI号

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public OrderDiversityVo() {
		super();
	}

	public OrderDiversityVo(String id) {
		super(id);
	}

	public List<OrderDiversityItemVo> getOrderDiversityItemList() {
		return orderDiversityItemList;
	}

	public void setOrderDiversityItemList(List<OrderDiversityItemVo> orderDiversityItemList) {
		this.orderDiversityItemList = orderDiversityItemList;
	}

	public List<OrderLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<OrderLogVo> logList) {
		this.logList = logList;
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

}