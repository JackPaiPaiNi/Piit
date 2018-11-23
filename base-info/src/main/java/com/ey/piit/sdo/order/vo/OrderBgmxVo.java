package com.ey.piit.sdo.order.vo;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订单变更明细
 * @author tianrong
 *
 */
public class OrderBgmxVo extends BaseEntity{
	 private Integer djlx;//单据类型
	 private String djlxMx;//单据类型描述
	 private String id;//id
	 private String ddid;//订单id
	 private Integer bbh;//版本号
	 private Integer bbhOld;//变更前的版本号
	 private String zdmc;//字段名称
     private String zdmx;//字段描述
     private String zdlx;//字段类型
     private String zdfz;//字段分组
     private String zdnrOld;//变更前内容
     private String zdnrNew;//变更后内容
     private String sjc;//变更记录的时间戳
     private Date stime;//创建时间
     private Date etime;//处理时间
     private String zdr;//制单人信息
     private Integer flag;//记录状态
     private String flagMx;//记录状态
     private String bz;//备注
	public Integer getDjlx() {
		return djlx;
	}
	public void setDjlx(Integer djlx) {
		this.djlx = djlx;
	}
	public String getDjlxMx() {
		return djlxMx;
	}
	public void setDjlxMx(String djlxMx) {
		this.djlxMx = djlxMx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public Integer getBbh() {
		return bbh;
	}
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	public Integer getBbhOld() {
		return bbhOld;
	}
	public void setBbhOld(Integer bbhOld) {
		this.bbhOld = bbhOld;
	}
	public String getZdmc() {
		return zdmc;
	}
	public void setZdmc(String zdmc) {
		this.zdmc = zdmc;
	}
	public String getZdmx() {
		return zdmx;
	}
	public void setZdmx(String zdmx) {
		this.zdmx = zdmx;
	}
	public String getZdlx() {
		return zdlx;
	}
	public void setZdlx(String zdlx) {
		this.zdlx = zdlx;
	}
	public String getZdfz() {
		return zdfz;
	}
	public void setZdfz(String zdfz) {
		this.zdfz = zdfz;
	}
	public String getZdnrOld() {
		return zdnrOld;
	}
	public void setZdnrOld(String zdnrOld) {
		this.zdnrOld = zdnrOld;
	}
	public String getZdnrNew() {
		return zdnrNew;
	}
	public void setZdnrNew(String zdnrNew) {
		this.zdnrNew = zdnrNew;
	}
	public String getSjc() {
		return sjc;
	}
	public void setSjc(String sjc) {
		this.sjc = sjc;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Date getEtime() {
		return etime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	public String getFlagMx() {
		return flagMx;
	}
	public void setFlagMx(String flagMx) {
		this.flagMx = flagMx;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getZdr() {
		return zdr;
	}
	public void setZdr(String zdr) {
		this.zdr = zdr;
	}
	
     
}
