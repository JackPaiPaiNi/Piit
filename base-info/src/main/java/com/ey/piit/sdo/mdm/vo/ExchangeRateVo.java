package com.ey.piit.sdo.mdm.vo;

import com.ey.piit.sdo.mdm.entity.ExchangeRate;

/**
 * 汇率Entity
 * @author 赵桃军
 */
public class ExchangeRateVo extends ExchangeRate {
	
	private String rq;		// 日期

	public ExchangeRateVo() {
		super();
	}

	public ExchangeRateVo(String id){
		super(id);
	}

	public String getRq() {
		return rq;
	}

	public void setRq(String rq) {
		this.rq = rq;
	}

}