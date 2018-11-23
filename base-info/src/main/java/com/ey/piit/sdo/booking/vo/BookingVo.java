package com.ey.piit.sdo.booking.vo;

import com.ey.piit.sdo.booking.entity.Booking;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 订舱通知书Entity
 * @author 赵明
 */
public class BookingVo extends Booking {

	private List<BookingItemVo> bookingItemList = Lists.newArrayList();		// 子表列表
	private List<BookingLogVo> logList = Lists.newArrayList();		// 子表列表
	private String sapgsdm;		//SAP公司编码
	
	private String nr;	//应收超期提示内容
	private String khlx;	//客户类型
	private String yzhdh;		// 预走货单号
	private String kh;			// 客户
	public BookingVo() {
		super();
	}

	public BookingVo(String id){
		super(id);
	}
	
	public List<BookingItemVo> getBookingItemList() {
		return bookingItemList;
	}

	public void setBookingItemList(List<BookingItemVo> bookingItemList) {
		this.bookingItemList = bookingItemList;
	}

	public String getSapgsdm() {
		return sapgsdm;
	}

	public void setSapgsdm(String sapgsdm) {
		this.sapgsdm = sapgsdm;
	}


	public List<BookingLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<BookingLogVo> logList) {
		this.logList = logList;
	}


	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getKhlx() {
		return khlx;
	}

	public void setKhlx(String khlx) {
		this.khlx = khlx;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}
	
}