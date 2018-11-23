package com.ey.piit.sdo.track.vo;

import java.util.Date;

import com.ey.piit.sdo.track.entity.TrackInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单跟踪主表查询Entity
 * @author 赵桃军
 */
public class TrackInfoVo extends TrackInfo {
	
    private String ywjd;	  // 延误节点
    private  String sfwhjhwcsj;		// 是否维护计划完成时间
    private Date ckzgsj;	  // 出库装柜时间
    private Date rjqrsj ;     //软件确认时间
    private String  rjzywtd ; //软件主要问题点
    private String bzxx ;     //备注信息
    private String sfqr;      //软件是否确认
    private String rjsfczwtd; //软禁是否存在问题点
    
    
    
    
    
    
    public String getRjsfczwtd() {
		return rjsfczwtd;
	}

	public void setRjsfczwtd(String rjsfczwtd) {
		this.rjsfczwtd = rjsfczwtd;
	}

	public String getSfqr() {
		return sfqr;
	}

	public void setSfqr(String sfqr) {
		this.sfqr = sfqr;
	}

	@JsonFormat(pattern = "yyyy-MM-dd") 
	public Date getRjqrsj() {
		return rjqrsj;
	}

	public void setRjqrsj(Date rjqrsj) {
		this.rjqrsj = rjqrsj;
	}

	public String getRjzywtd() {
		return rjzywtd;
	}

	public void setRjzywtd(String rjzywtd) {
		this.rjzywtd = rjzywtd;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public String getSfwhjhwcsj() {
		return sfwhjhwcsj;
	}

	public void setSfwhjhwcsj(String sfwhjhwcsj) {
		this.sfwhjhwcsj = sfwhjhwcsj;
	}

	public String getYwjd() {
		return ywjd;
	}

	public void setYwjd(String ywjd) {
		this.ywjd = ywjd;
	}

	public TrackInfoVo() {
		super();
	}

	public TrackInfoVo(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getCkzgsj() {
		return ckzgsj;
	}

	public void setCkzgsj(Date ckzgsj) {
		this.ckzgsj = ckzgsj;
	}

}