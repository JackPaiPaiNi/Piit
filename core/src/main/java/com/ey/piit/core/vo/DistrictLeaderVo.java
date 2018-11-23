/*
 * DistrictLeaderVo.java
 * Copyright(C) 2015-2020
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.vo;


/**
 * DistrictLeaderVo
 * 片区负责人
 * 
 * @author 魏诚
 * @version 1.0 2018-03-29
 */
public class DistrictLeaderVo {
	
	private String id;//表唯一标识
	private String ywzid;//业务组id
	private String ywz;//业务组名称
	private String pqid;//片区id
	private String pq;//片区名称
	private String fzrid;//负责人id
	private String fzr;//负责人名称
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYwzid() {
		return ywzid;
	}
	public void setYwzid(String ywzid) {
		this.ywzid = ywzid;
	}
	public String getYwz() {
		return ywz;
	}
	public void setYwz(String ywz) {
		this.ywz = ywz;
	}
	public String getPqid() {
		return pqid;
	}
	public void setPqid(String pqid) {
		this.pqid = pqid;
	}
	public String getPq() {
		return pq;
	}
	public void setPq(String pq) {
		this.pq = pq;
	}
	public String getFzrid() {
		return fzrid;
	}
	public void setFzrid(String fzrid) {
		this.fzrid = fzrid;
	}
	public String getFzr() {
		return fzr;
	}
	public void setFzr(String fzr) {
		this.fzr = fzr;
	}

}
