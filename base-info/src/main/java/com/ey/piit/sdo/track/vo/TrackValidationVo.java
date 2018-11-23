package com.ey.piit.sdo.track.vo;



import java.util.Date;

import com.ey.piit.sdo.track.entity.TrackValidation;

/**
 * 订单生产要求维护Entity
 * @author 赵桃军
 */
public class TrackValidationVo extends TrackValidation {

	//软件确认状态
	private String rjqrzt;
	//是否存在问题点
	private String sfczwt;
	//生产计划时间确认状态
	private String scjhwczt;
	//确认类型 0软件确认 1计划完成时间确认
	private Integer qrlx;
	private Date wcsj;
	
	
	public TrackValidationVo() {
		super();
	}

	public TrackValidationVo(String id){
		super(id);
	}
	
	public String getScjhwczt() {
		return scjhwczt;
	}

	public void setScjhwczt(String scjhwczt) {
		this.scjhwczt = scjhwczt;
	}

	public String getRjqrzt() {
		return rjqrzt;
	}

	public void setRjqrzt(String rjqrzt) {
		this.rjqrzt = rjqrzt;
	}

	public String getSfczwt() {
		return sfczwt;
	}

	public void setSfczwt(String sfczwt) {
		this.sfczwt = sfczwt;
	}

	public Date getWcsj() {
		return wcsj;
	}

	public void setWcsj(Date wcsj) {
		this.wcsj = wcsj;
	}

	public Integer getQrlx() {
		return qrlx;
	}

	public void setQrlx(Integer qrlx) {
		this.qrlx = qrlx;
	}
	
}