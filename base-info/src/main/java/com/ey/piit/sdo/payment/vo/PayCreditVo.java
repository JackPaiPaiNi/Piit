package com.ey.piit.sdo.payment.vo;

import java.math.BigDecimal;

import com.ey.piit.sdo.payment.entity.PayCredit;

/**
 * 信用额度管理Entity
 * @author 田荣
 */
public class PayCreditVo extends PayCredit {

	private String rows;// 多个信用额度
	private BigDecimal syed;// 剩余额度
	private String   beginZdsj ;
	private String   endZdsj ;
	private Integer  type ; //操纵类型  解冻或冻结
	
	private BigDecimal tzje;//调整金额
	private String tzyy;//调整原因
	private Integer sfcq ; //是否超期
	
	
	

	public Integer getSfcq() {
		return sfcq;
	}

	public void setSfcq(Integer sfcq) {
		this.sfcq = sfcq;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getBeginZdsj() {
		return beginZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	public PayCreditVo() {
		super();
	}

	public PayCreditVo(String id){
		super(id);
	}
	
	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public BigDecimal getSyed() {
		return syed;
	}

	public void setSyed(BigDecimal syed) {
		this.syed = syed;
	}

	public BigDecimal getTzje() {
		return tzje;
	}

	public void setTzje(BigDecimal tzje) {
		this.tzje = tzje;
	}

	public String getTzyy() {
		return tzyy;
	}

	public void setTzyy(String tzyy) {
		this.tzyy = tzyy;
	}

}