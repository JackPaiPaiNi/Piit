package com.ey.piit.sdo.report.vo;

import com.ey.piit.sdo.report.entity.OrderLinkData;

/**
 * OrderLinkEntity
 * @author 赵明
 */
public class OrderLinkDataVo extends OrderLinkData {
	private String beginZdsj;
	private String endZdsj ;
	private String gjmytkmc;
	private String gjmytkbz;
	private String zdrid;
	private String beginZwjhsj;//最晚交货日期 开始
	private String endZwjhsj ;//最晚交货日期 结束
	private String beginTssapsj;//推送sap时间 开始
	private String endTssapsj;//推送sap时间 开始
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
	public OrderLinkDataVo() {
		super();
	}

	public OrderLinkDataVo(String id){
		super(id);
	}

	public String getGjmytkmc() {
		return gjmytkmc;
	}

	public void setGjmytkmc(String gjmytkmc) {
		this.gjmytkmc = gjmytkmc;
	}

	public String getGjmytkbz() {
		return gjmytkbz;
	}

	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz;
	}

	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getBeginZwjhsj() {
		return beginZwjhsj;
	}

	public void setBeginZwjhsj(String beginZwjhsj) {
		this.beginZwjhsj = beginZwjhsj;
	}

	public String getEndZwjhsj() {
		return endZwjhsj;
	}

	public void setEndZwjhsj(String endZwjhsj) {
		this.endZwjhsj = endZwjhsj;
	}

	public String getBeginTssapsj() {
		return beginTssapsj;
	}

	public void setBeginTssapsj(String beginTssapsj) {
		this.beginTssapsj = beginTssapsj;
	}

	public String getEndTssapsj() {
		return endTssapsj;
	}

	public void setEndTssapsj(String endTssapsj) {
		this.endTssapsj = endTssapsj;
	}
	
	
}