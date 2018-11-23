package com.ey.piit.sdo.sapspecial.vo;

import com.ey.piit.sdo.sapspecial.entity.SapApproveLog;

public class SapApproveLogVo extends SapApproveLog {
	
	private int   zt ;
	
	public int getZt() {
		return zt;
	}
	public void setZt(int zt) {
		this.zt = zt;
	}
	public  SapApproveLogVo(){
		super();
	}
	public  SapApproveLogVo(String id){
		super(id);
	}
	
	

}
