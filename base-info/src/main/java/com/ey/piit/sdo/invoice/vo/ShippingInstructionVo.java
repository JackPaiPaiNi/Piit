package com.ey.piit.sdo.invoice.vo;

import com.ey.piit.sdo.invoice.entity.ShippingInstruction;
import java.util.List;
import com.google.common.collect.Lists;

/**
 * 补料单信息维护Entity
 * @author 高文浩
 */
public class ShippingInstructionVo extends ShippingInstruction {

	private List<ShippingInstructionItemVo> shippingInstructionItemList = Lists.newArrayList();		// 子表列表
	
	private Double sumKbtj;	//总卡板体积
	private Double sumXs;	//总箱数
	private Double sumZsl;	//总（总数量）
	private Double sumPz;	//总皮重
	private Double sumGmz;	//总柜毛重
	private Double sumZmz;	//总（总毛重）
	
	public ShippingInstructionVo() {
		super();
	}

	public ShippingInstructionVo(String id){
		super(id);
	}
	public List<ShippingInstructionItemVo> getShippingInstructionItemList() {
		return shippingInstructionItemList;
	}

	public void setShippingInstructionItemList(List<ShippingInstructionItemVo> shippingInstructionItemList) {
		this.shippingInstructionItemList = shippingInstructionItemList;
	}

	public Double getSumKbtj() {
		return sumKbtj;
	}

	public void setSumKbtj(Double sumKbtj) {
		this.sumKbtj = sumKbtj;
	}

	public Double getSumXs() {
		return sumXs;
	}

	public void setSumXs(Double sumXs) {
		this.sumXs = sumXs;
	}

	public Double getSumZsl() {
		return sumZsl;
	}

	public void setSumZsl(Double sumZsl) {
		this.sumZsl = sumZsl;
	}

	public Double getSumPz() {
		return sumPz;
	}

	public void setSumPz(Double sumPz) {
		this.sumPz = sumPz;
	}

	public Double getSumGmz() {
		return sumGmz;
	}

	public void setSumGmz(Double sumGmz) {
		this.sumGmz = sumGmz;
	}

	public Double getSumZmz() {
		return sumZmz;
	}

	public void setSumZmz(Double sumZmz) {
		this.sumZmz = sumZmz;
	}
	
}