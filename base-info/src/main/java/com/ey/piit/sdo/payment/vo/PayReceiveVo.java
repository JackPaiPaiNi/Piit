package com.ey.piit.sdo.payment.vo;

import java.math.BigDecimal;
import java.util.List;

import com.ey.piit.sdo.payment.entity.PayReceive;

/**
 * 收款信息登记Entity
 * 
 * @author 邓海
 */
public class PayReceiveVo extends PayReceive {

	private String ssksj;// 开始收款时间
	private String esksj;// 结束收款时间
	private String rows;// 收款单ids 多个
	private BigDecimal wrlje;// 未认领金额
	private List<PayReceiveClaimVo> payReceiveClaimList;
	private List<PayReceiveVo> itemList;
	private String rlzt;	// 认领状态
	private BigDecimal zje;//总金额
	private BigDecimal djjdje;//冻结或解冻金额
	private Integer type ;//冻结或解冻标志
	private BigDecimal sykrlje;//剩余可认领金额
	

	
	
	
	public Integer getType() {
		return type;
	}



	public void setType(Integer type) {
		this.type = type;
	}



	public BigDecimal getDjjdje() {
		return djjdje;
	}



	public void setDjjdje(BigDecimal djjdje) {
		this.djjdje = djjdje;
	}



	public PayReceiveVo() {
		super();
	}
	
	

	public BigDecimal getZje() {
		return zje;
	}



	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}


	public List<PayReceiveVo> getItemList() {
		return itemList;
	}



	public void setItemList(List<PayReceiveVo> itemList) {
		this.itemList = itemList;
	}



	public List<PayReceiveClaimVo> getPayReceiveClaimList() {
		return payReceiveClaimList;
	}

	public void setPayReceiveClaimList(List<PayReceiveClaimVo> payReceiveClaimList) {
		this.payReceiveClaimList = payReceiveClaimList;
	}

	public PayReceiveVo(String id) {
		super(id);
	}

	public String getSsksj() {
		return ssksj;
	}

	public void setSsksj(String ssksj) {
		this.ssksj = ssksj;
	}

	public String getEsksj() {
		return esksj;
	}

	public void setEsksj(String esksj) {
		this.esksj = esksj;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public BigDecimal getWrlje() {
		return wrlje;
	}

	public void setWrlje(BigDecimal wrlje) {
		this.wrlje = wrlje;
	}

	public String getRlzt() {
		return rlzt;
	}

	public void setRlzt(String rlzt) {
		this.rlzt = rlzt;
	}



	public BigDecimal getSykrlje() {
		return sykrlje;
	}



	public void setSykrlje(BigDecimal sykrlje) {
		this.sykrlje = sykrlje;
	}

}