package com.ey.piit.sdo.custinv.vo;

import java.util.List;

import com.ey.piit.sdo.custinv.entity.CustInvEntity;
import com.google.common.collect.Lists;

public class CustInvVo extends CustInvEntity{
	private List<CustInvItemVo> custInvItems=Lists.newArrayList();
	private List<CustInvPackingVo> custInvPackings=Lists.newArrayList();
	private String conditionFph;//发票号
	private String conditionTdh;//提单号
	private String conditionZt;//状态
	private String conditionKh;//客户
	private String conditionZdr;//制单人
	private String conditionDdh;//订单号
	private String conditionChdh;//出货单号
	private String conditionSDdDate;//发票开始时间
	private String conditionEDdDate;//发票结束时间
	
	
	private String englishAmount;
	public String getEnglishAmount() {
		return englishAmount;
	}
	public void setEnglishAmount(String englishAmount) {
		this.englishAmount = englishAmount;
	}
	public CustInvVo() {
		// TODO Auto-generated constructor stub
		super();
	}
	public CustInvVo(String id) {
		// TODO Auto-generated constructor stub
		super(id);
	}
	public List<CustInvItemVo> getCustInvItems() {
		return custInvItems;
	}
	public void setCustInvItems(List<CustInvItemVo> custInvItems) {
		this.custInvItems = custInvItems;
	}
	public List<CustInvPackingVo> getCustInvPackings() {
		return custInvPackings;
	}
	public void setCustInvPackings(List<CustInvPackingVo> custInvPackings) {
		this.custInvPackings = custInvPackings;
	}
	public String getConditionFph() {
		return conditionFph;
	}
	public void setConditionFph(String conditionFph) {
		this.conditionFph = conditionFph;
	}
	public String getConditionTdh() {
		return conditionTdh;
	}
	public void setConditionTdh(String conditionTdh) {
		this.conditionTdh = conditionTdh;
	}
	public String getConditionZt() {
		return conditionZt;
	}
	public void setConditionZt(String conditionZt) {
		this.conditionZt = conditionZt;
	}
	public String getConditionKh() {
		return conditionKh;
	}
	public void setConditionKh(String conditionKh) {
		this.conditionKh = conditionKh;
	}
	public String getConditionZdr() {
		return conditionZdr;
	}
	public void setConditionZdr(String conditionZdr) {
		this.conditionZdr = conditionZdr;
	}
	public String getConditionDdh() {
		return conditionDdh;
	}
	public void setConditionDdh(String conditionDdh) {
		this.conditionDdh = conditionDdh;
	}
	public String getConditionChdh() {
		return conditionChdh;
	}
	public void setConditionChdh(String conditionChdh) {
		this.conditionChdh = conditionChdh;
	}
	public String getConditionSDdDate() {
		return conditionSDdDate;
	}
	public void setConditionSDdDate(String conditionSDdDate) {
		this.conditionSDdDate = conditionSDdDate;
	}
	public String getConditionEDdDate() {
		return conditionEDdDate;
	}
	public void setConditionEDdDate(String conditionEDdDate) {
		this.conditionEDdDate = conditionEDdDate;
	}
	
	
}
