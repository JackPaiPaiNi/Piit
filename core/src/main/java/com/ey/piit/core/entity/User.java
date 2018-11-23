/*
 * User.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.entity;

import com.ey.piit.core.format.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * T_USER
 * 用户
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
public class User extends CoreEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 75447553087424044L;
	
	/**
     * 用户账号
     */
    private String loginAcct;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 工号
     */
    private String empCode;
    /**
     * 所属公司
     */
    private String compCode;
    /**
     * 邮件地址
     */
    private String email;
    /**
     * 状态
     */
    private String status;
    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改人
     */
    private String lastUpdater;
    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;
    
	/**
	 * 缺省角色
	 */
    private String defautRole;
    
    //==========扩展==========
    private String deptCode;//销售组织代码
    private String groupCode;//业务组代码
    private String deptName;//销售组织代码
    private String groupName;//业务组名称
    private Integer sfxgmm = 0;//是否修改过初始密码 0否 1是

    /**
     * 用户账号
     */
    public String getLoginAcct() {
        return loginAcct;
    }

    /**
     * 用户账号
     */
    public void setLoginAcct(String loginAcct) {
        this.loginAcct = loginAcct == null ? null : loginAcct.trim();
    }

    /**
     * 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 工号
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     * 工号
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode == null ? null : empCode.trim();
    }

    /**
     * 所属公司
     */
    public String getCompCode() {
        return compCode;
    }

    /**
     * 所属公司
     */
    public void setCompCode(String compCode) {
        this.compCode = compCode == null ? null : compCode.trim();
    }

    /**
     * 邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮件地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改人
     */
    public String getLastUpdater() {
        return lastUpdater;
    }

    /**
     * 最后修改人
     */
    public void setLastUpdater(String lastUpdater) {
        this.lastUpdater = lastUpdater == null ? null : lastUpdater.trim();
    }

    /**
     * 最后修改时间
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 最后修改时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 缺省角色
     */
	public String getDefautRole() {
		return defautRole;
	}

	/**
     * 缺省角色
     */
	public void setDefautRole(String defautRole) {
		this.defautRole = defautRole;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getSfxgmm() {
		return sfxgmm;
	}

	public void setSfxgmm(Integer sfxgmm) {
		this.sfxgmm = sfxgmm;
	}


}
