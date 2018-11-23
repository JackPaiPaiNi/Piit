package com.ey.piit.sdo.agent.vo;

import com.ey.piit.sdo.agent.entity.Agent;

/**
 * 委托vo
 * @author 高文浩
 */
public class AgentVo extends Agent {
	private String ztmc;
	private String bwtrjs; //被委托人角色
	public AgentVo() {
		super();
	}

	public AgentVo(String id){
		super(id);
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getBwtrjs() {
		return bwtrjs;
	}

	public void setBwtrjs(String bwtrjs) {
		this.bwtrjs = bwtrjs;
	}
	
}