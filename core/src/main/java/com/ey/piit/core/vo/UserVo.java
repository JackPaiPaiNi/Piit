/*
 * UserVo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.vo;

import java.util.List;

import com.ey.piit.core.entity.User;

/**
 * T_USER
 * 用户
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
public class UserVo extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9041727963399127152L;

	/**
	 * 格式：[{"id":"1","oper":"add"},{"id":"2","oper":"del"}]
	 */
	private String roles;
	
	/**
	 * 格式：[{"id":"1","oper":"add","groupId":"","type":"0"},{"id":"2","oper":"del","groupId":"","type":"1"}]
	 */
	private String orgs;
	
	private List<OrganizationVo> orgShow;//展示用
	
	private String compName;
	//更新前工号
	private String oldEmpCode;
	//旧密码
	private String  oldPassword;
	
	
	
	
	

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getOldEmpCode() {
		return oldEmpCode;
	}

	public void setOldEmpCode(String oldEmpCode) {
		this.oldEmpCode = oldEmpCode;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getOrgs() {
		return orgs;
	}

	public void setOrgs(String orgs) {
		this.orgs = orgs;
	}

	public List<OrganizationVo> getOrgShow() {
		return orgShow;
	}

	public void setOrgShow(List<OrganizationVo> orgShow) {
		this.orgShow = orgShow;
	}
	
}