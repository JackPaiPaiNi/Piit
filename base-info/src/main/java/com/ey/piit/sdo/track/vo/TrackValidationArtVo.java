package com.ey.piit.sdo.track.vo;

import com.ey.piit.sdo.track.entity.TrackValidationArt;

/**
 * 订单生产要求美工信息维护Entity
 * @author 赵桃军
 */
public class TrackValidationArtVo extends TrackValidationArt {

	//软件确认状态
	private String mgqrzt ;
	
	public TrackValidationArtVo() {
		super();
	}

	public TrackValidationArtVo(String id){
		super(id);
	}
	
	public String getMgqrzt() {
		return mgqrzt;
	}

	public void setMgqrzt(String mgqrzt) {
		this.mgqrzt = mgqrzt;
	}

}