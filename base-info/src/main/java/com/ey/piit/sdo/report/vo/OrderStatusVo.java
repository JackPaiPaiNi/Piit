package com.ey.piit.sdo.report.vo;

import com.ey.piit.sdo.report.entity.OrderStatus;

public class OrderStatusVo extends OrderStatus {
	
    
	private  String     dqclr;    //当前处理人
	private  String     beginZdsj;//开始制单时间
	private  String     endZdsj;  // 结束制单时间
	private  String     beginJhsj;//开始交货时间
	private  String     endJhsj;  // 结束交货日趋
	public String getDqclr() {
		return dqclr;
	}
	public void setDqclr(String dqclr) {
		this.dqclr = dqclr;
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
	public String getBeginJhsj() {
		return beginJhsj;
	}
	public void setBeginJhsj(String beginJhsj) {
		this.beginJhsj = beginJhsj;
	}
	public String getEndJhsj() {
		return endJhsj;
	}
	public void setEndJhsj(String endJhsj) {
		this.endJhsj = endJhsj;
	}
	
	
}
