package com.ey.piit.sdo.fcst.vo;

import com.ey.piit.sdo.fcst.entity.FcstReportReachRate;

/**
 * 采购FCST达成率报表Entity
 * @author 赵明
 */
public class FcstReportReachRateVo extends FcstReportReachRate {

	private String colname;//列名格式：07月（0701-0731）
	private String yyyymm;//当月 格式：201607
	private String level;//汇总层级 1：销售组织 2业务组 3销售员 4客户
	public FcstReportReachRateVo() {
		super();
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getYyyymm() {
		return yyyymm;
	}
	public void setYyyymm(String yyyymm) {
		this.yyyymm = yyyymm;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}


}