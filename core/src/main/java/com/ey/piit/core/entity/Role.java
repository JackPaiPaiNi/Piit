/*
 * Role.java
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
 * T_ROLE
 * 角色
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
public class Role extends CoreEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7416696477601214563L;
	
	/**
     * 角色编号
     */
    private String code;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色类型：01菜单角色，02流程角色，03预警角色
     */
    private String type;
    /**
     * 状态
     */
    private String status;
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
     * 角色编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 角色编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 角色类型：01菜单角色，02流程角色，03预警角色
     */
    public String getType() {
        return type;
    }

    /**
     * 角色类型：01菜单角色，02流程角色，03预警角色
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
}