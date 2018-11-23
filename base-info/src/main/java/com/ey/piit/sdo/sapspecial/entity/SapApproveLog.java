package com.ey.piit.sdo.sapspecial.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

public class SapApproveLog extends BaseEntity {
	
	private  String  id ;     //id
	private  String  dh ;     //单号
	private  String  sjc ;    //时间戳
	private  String  czlx ;   //操作类型
	private  String  czr ;    //操作人
	private  String  czrmc ;  //操作人名称
	private  Date    czsj;    //操作时间
	private  String  type;    //操作类型
	private  String  nr ;      //内容
	
	public  SapApproveLog(){
		super();
	}
	public  SapApproveLog(String id){
		super(id);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getSjc() {
		return sjc;
	}
	public void setSjc(String sjc) {
		this.sjc = sjc;
	}
	public String getCzlx() {
		return czlx;
	}
	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public String getCzrmc() {
		return czrmc;
	}
	public void setCzrmc(String czrmc) {
		this.czrmc = czrmc;
	}
	
	public Date getCzsj() {
		return czsj;
	}
	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}

}
