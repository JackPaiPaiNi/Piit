package com.ey.piit.sdo.fcst.entity;


public class FcstDataTitle  {
	
	private String week;		// 周次 如w1623
	private String month;		// 月份 如07月
	private String day;		// 日期 如0704-0710
	//private Integer month_cols;		// 月份跨列数 如8
	private String editable;//列是否可编辑
	
	private String colname;//合并列名显示
	private String colspan;//跨列数
	private String flag;//合并次数 1/2
	
	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}

	public String getEditable() {
		return editable;
	}
	public void setEditable(String editable) {
		this.editable = editable;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getColspan() {
		return colspan;
	}
	public void setColspan(String colspan) {
		this.colspan = colspan;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

}
