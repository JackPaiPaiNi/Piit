package com.ey.piit.sdo.booking.vo;

import java.util.Date;

import com.ey.piit.sdo.booking.entity.BookingItem;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订舱通知书Entity
 * @author 赵明
 */
public class BookingItemVo extends BookingItem {

	private String sfkt;//是否客体
	private Date zgsj;//装柜时间
	private Integer yg_40hq;//用柜40HQ
	private Integer yg_20gp;//用柜20GP
	private Integer yg_40gp;//用柜40GP
	private String  yg_gsbz;//用柜备注
	private Integer dc_3d;//3吨车
	private Integer dc_5d;//5吨车
	private Integer dc_8d;//8吨车
	private Integer dc_10d;//10吨车
	private Integer dc_12d;//12吨车
	private String dc_dcbz;//吨车备注

	public BookingItemVo() {
		super();
	}

	public BookingItemVo(String id){
		super(id);
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZgsj() {
		return zgsj;
	}

	public void setZgsj(Date zgsj) {
		this.zgsj = zgsj;
	}

	public Integer getYg_40hq() {
		return yg_40hq;
	}

	public void setYg_40hq(Integer yg_40hq) {
		this.yg_40hq = yg_40hq;
	}

	public Integer getYg_20gp() {
		return yg_20gp;
	}

	public void setYg_20gp(Integer yg_20gp) {
		this.yg_20gp = yg_20gp;
	}

	public Integer getYg_40gp() {
		return yg_40gp;
	}

	public void setYg_40gp(Integer yg_40gp) {
		this.yg_40gp = yg_40gp;
	}

	public String getYg_gsbz() {
		return yg_gsbz;
	}

	public void setYg_gsbz(String yg_gsbz) {
		this.yg_gsbz = yg_gsbz;
	}

	public Integer getDc_3d() {
		return dc_3d;
	}

	public void setDc_3d(Integer dc_3d) {
		this.dc_3d = dc_3d;
	}

	public Integer getDc_5d() {
		return dc_5d;
	}

	public void setDc_5d(Integer dc_5d) {
		this.dc_5d = dc_5d;
	}

	public Integer getDc_8d() {
		return dc_8d;
	}

	public void setDc_8d(Integer dc_8d) {
		this.dc_8d = dc_8d;
	}

	public Integer getDc_10d() {
		return dc_10d;
	}

	public void setDc_10d(Integer dc_10d) {
		this.dc_10d = dc_10d;
	}

	public Integer getDc_12d() {
		return dc_12d;
	}

	public void setDc_12d(Integer dc_12d) {
		this.dc_12d = dc_12d;
	}

	public String getDc_dcbz() {
		return dc_dcbz;
	}

	public void setDc_dcbz(String dc_dcbz) {
		this.dc_dcbz = dc_dcbz;
	}

	public String getSfkt() {
		return sfkt;
	}

	public void setSfkt(String sfkt) {
		this.sfkt = sfkt;
	}
}