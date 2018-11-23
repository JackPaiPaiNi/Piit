package com.ey.piit.sdo.order.vo;

import com.ey.piit.sdo.order.entity.OrderSpo;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;

/**
 * 备损订单管理Entity
 * @author 魏诚
 */
public class OrderSpoVo extends OrderSpo implements Serializable {
	   
	/**
	 * 
	 */
	private static final long serialVersionUID = -2812577027805941695L;
	
	private List<OrderSpoItemVo> orderSpoItemList = Lists.newArrayList();		// 子表列表
	private List<OrderReferPiVo> orderReferPiVo = Lists.newArrayList();	
	private List<OrderLogVo> logList = Lists.newArrayList();		            //订单日志
	private MultipartFile[] files;//上传用
	private String fileOper;//操作用
	private Integer wlje;//修改物料还是金额 
	private Integer  sfKszy ;
	private Integer type;//1取消 2撤回
	private String qxbz; //取消备注
	private String piid; // PI号
	
	public OrderSpoVo() {
		super();
	}
	
	public Integer getSfKszy() {
		return sfKszy;
	}

	public void setSfKszy(Integer sfKszy) {
		this.sfKszy = sfKszy;
	}

	public OrderSpoVo(String id){
		super(id);
	}
	
	public List<OrderSpoItemVo> getOrderSpoItemList() {
		return orderSpoItemList;
	}

	public void setOrderSpoItemList(List<OrderSpoItemVo> orderSpoItemList) {
		this.orderSpoItemList = orderSpoItemList;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public String getFileOper() {
		return fileOper;
	}

	public void setFileOper(String fileOper) {
		this.fileOper = fileOper;
	}

	public List<OrderLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<OrderLogVo> logList) {
		this.logList = logList;
	}

	public List<OrderReferPiVo> getOrderReferPiVo() {
		return orderReferPiVo;
	}

	public void setOrderReferPiVo(List<OrderReferPiVo> orderReferPiVo) {
		this.orderReferPiVo = orderReferPiVo;
	}

	public Integer getWlje() {
		return wlje;
	}

	public void setWlje(Integer wlje) {
		this.wlje = wlje;
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