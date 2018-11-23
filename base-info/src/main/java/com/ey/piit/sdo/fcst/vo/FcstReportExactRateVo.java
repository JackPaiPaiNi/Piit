package com.ey.piit.sdo.fcst.vo;

import com.ey.piit.sdo.fcst.entity.FcstReportExactRate;

/**
 * 采购FCST准确率报表Entity
 * @author 邓海
 */
public class FcstReportExactRateVo extends FcstReportExactRate {

	private String colname;//列名格式：07月（0701-0731）
	private String yyyymm;//当月 格式：201607
	private String level;//汇总层级 1：销售组织 2业务组 3销售员 4客户
	public FcstReportExactRateVo() {
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