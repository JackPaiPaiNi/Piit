package com.ey.piit.interfaces.pidbom.dto;
/**
 * 获取PID BOM数据集的请求实体
 * @author denghai
 *
 */
public class PidBomRequest {
	
	private String pid;//pid
	private String gc;//工厂
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getGc() {
		return gc;
	}
	public void setGc(String gc) {
		this.gc = gc;
	}
	

}
