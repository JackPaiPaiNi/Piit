package com.ey.piit.sdo.track.vo;

import com.ey.piit.sdo.track.entity.TrackDelay;

/**
 * 订单延误原因维护Entity
 * 
 * @author 赵桃军
 */
public class TrackDelayVo extends TrackDelay {

	public TrackDelayVo() {
		super();
	}

	public TrackDelayVo(String id) {
		super(id);
	}

	private String zbid;

	private String ddId;

	public String getDdId() {
		return ddId;
	}

	public void setDdId(String ddId) {
		this.ddId = ddId;
	}

	public String getZbid() {
		return zbid;
	}

	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

}