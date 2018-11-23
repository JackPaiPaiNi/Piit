/*
 * Organization.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.entity;

import com.ey.piit.core.format.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * T_ORGANIZATION
 * 组织
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
public class Organization extends CoreEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3935294431722093058L;
	
	/**
     * 序号
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 类型
     */
    private String type;
    /**
     * 全路径 样式：1/2/3
     */
    private String path;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private String status;
    /**
     * 管理架构上级节点
     */
    private String baseParentOrgCode;
    /**
     * 核算系统上级节点
     */
    private String ncParentOrgCode;
    /**
     * 资金系统上级节点
     */
    private String zjParentOrgCode;
    /**
     * 税务系统上级节点
     */
    private String swParentOrgCode;
    /**
     * 预算系统上级节点
     */
    private String ysParentOrgCode;
    /**
     * 资产系统上级节点
     */
    private String zcParentOrgCode;
    /**
     * 股份核算系统上级节点
     */
    private String ebsParentOrgCode;
    /**
     * 财务共享系统上级节点
     */
    private String cwParentOrgCode;
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

    private String parentName;
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
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
     * 全路径 样式：1/2/3
     */
    public String getPath() {
        return path;
    }

    /**
     * 全路径 样式：1/2/3
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
     * 管理架构上级节点
     */
    public String getBaseParentOrgCode() {
        return baseParentOrgCode;
    }

    /**
     * 管理架构上级节点
     */
    public void setBaseParentOrgCode(String baseParentOrgCode) {
        this.baseParentOrgCode = baseParentOrgCode == null ? null : baseParentOrgCode.trim();
    }

    /**
     * 核算系统上级节点
     */
    public String getNcParentOrgCode() {
        return ncParentOrgCode;
    }

    /**
     * 核算系统上级节点
     */
    public void setNcParentOrgCode(String ncParentOrgCode) {
        this.ncParentOrgCode = ncParentOrgCode == null ? null : ncParentOrgCode.trim();
    }

    /**
     * 资金系统上级节点
     */
    public String getZjParentOrgCode() {
        return zjParentOrgCode;
    }

    /**
     * 资金系统上级节点
     */
    public void setZjParentOrgCode(String zjParentOrgCode) {
        this.zjParentOrgCode = zjParentOrgCode == null ? null : zjParentOrgCode.trim();
    }

    /**
     * 税务系统上级节点
     */
    public String getSwParentOrgCode() {
        return swParentOrgCode;
    }

    /**
     * 税务系统上级节点
     */
    public void setSwParentOrgCode(String swParentOrgCode) {
        this.swParentOrgCode = swParentOrgCode == null ? null : swParentOrgCode.trim();
    }

    /**
     * 预算系统上级节点
     */
    public String getYsParentOrgCode() {
        return ysParentOrgCode;
    }

    /**
     * 预算系统上级节点
     */
    public void setYsParentOrgCode(String ysParentOrgCode) {
        this.ysParentOrgCode = ysParentOrgCode == null ? null : ysParentOrgCode.trim();
    }

    /**
     * 资产系统上级节点
     */
    public String getZcParentOrgCode() {
        return zcParentOrgCode;
    }

    /**
     * 资产系统上级节点
     */
    public void setZcParentOrgCode(String zcParentOrgCode) {
        this.zcParentOrgCode = zcParentOrgCode == null ? null : zcParentOrgCode.trim();
    }

    /**
     * 股份核算系统上级节点
     */
    public String getEbsParentOrgCode() {
        return ebsParentOrgCode;
    }

    /**
     * 股份核算系统上级节点
     */
    public void setEbsParentOrgCode(String ebsParentOrgCode) {
        this.ebsParentOrgCode = ebsParentOrgCode == null ? null : ebsParentOrgCode.trim();
    }

    /**
     * 财务共享系统上级节点
     */
    public String getCwParentOrgCode() {
        return cwParentOrgCode;
    }

    /**
     * 财务共享系统上级节点
     */
    public void setCwParentOrgCode(String cwParentOrgCode) {
        this.cwParentOrgCode = cwParentOrgCode == null ? null : cwParentOrgCode.trim();
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}