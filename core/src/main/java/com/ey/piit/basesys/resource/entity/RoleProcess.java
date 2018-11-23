/*
 * RoleProcess.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.entity;

import java.util.Date;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.format.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * T_ROLE_PROCESS
 * 角色_流程节点
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
public class RoleProcess extends CoreEntity {

    /**
     * 序号
     */
    private String id;
    /**
     * 控制编号
     */
    private String ctrlCode;
    /**
     * 角色编号
     */
    private String roleCode;
    /**
     * 节点编码
     */
    private String nodeCode;
    /**
     * 模块标示
     */
    private String module;
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
     * 序号
     */
    public String getId() {
        return id;
    }

    /**
     * 序号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 控制编号
     */
    public String getCtrlCode() {
        return ctrlCode;
    }

    /**
     * 控制编号
     */
    public void setCtrlCode(String ctrlCode) {
        this.ctrlCode = ctrlCode == null ? null : ctrlCode.trim();
    }

    /**
     * 角色编号
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 角色编号
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * 节点编码
     */
    public String getNodeCode() {
        return nodeCode;
    }

    /**
     * 节点编码
     */
    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode == null ? null : nodeCode.trim();
    }

    /**
     * 模块标示
     */
    public String getModule() {
        return module;
    }

    /**
     * 模块标示
     */
    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
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