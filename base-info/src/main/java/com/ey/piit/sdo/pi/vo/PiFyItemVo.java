package com.ey.piit.sdo.pi.vo;

import com.ey.piit.sdo.pi.entity.PiItem;

/**
 * PI管理Entity
 * @author 王歌
 */
public class PiFyItemVo extends PiItem {

	private	String	ztmc;		//	明细状态
	
	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public PiFyItemVo() {
		super();
	}

	public PiFyItemVo(String id){
		super(id);
	}

}