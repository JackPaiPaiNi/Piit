/*
 * Area.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-11 Created
 */
package com.ey.piit.baseinfo.area.entity;

import java.util.Date;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.format.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * T_AREA
 * 一级对应国家
二级对应省
三级对应市
四级对应区县
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-11
 */
public class Area extends CoreEntity {
	/**
	 * 首都时区
	 */
	private  String sdsq ;
	

    public String getSdsq() {
		return sdsq;
	}

	public void setSdsq(String sdsq) {
		this.sdsq = sdsq;
	}

	/**
     * 序号
     */
    private String id;
    /**
     * 编码
     */
    private String code;
    /**
     * 三位编码
     */
    private String extCode;
    /**
     * 中文名称
     */
    private String cnName;
    /**
     * 英文名称
     */
    private String enName;
    /**
     * 上级节点编号
     */
    private String parentCode;
    /**
     * 全路径编码
     */
    private String fullPathCode;
    /**
     * 子计数
     */
    private Integer childCount;
    /**
     * 层级
     */
    private Integer levels;
    /**
     * 排序
     */
    private Long sort;
    /**
     * 中文全称
     */
    private String cnFullName;
    /**
     * 英文全称
     */
    private String enFullName;
    /**
     * 状态
     */
    private String status;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String lastUpdater;
    /**
     * 修改时间
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
     * 三位编码
     */
    public String getExtCode() {
        return extCode;
    }

    /**
     * 三位编码
     */
    public void setExtCode(String extCode) {
        this.extCode = extCode == null ? null : extCode.trim();
    }

    /**
     * 中文名称
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * 中文名称
     */
    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    /**
     * 英文名称
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 英文名称
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * 上级节点编号
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 上级节点编号
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     * 全路径编码
     */
    public String getFullPathCode() {
        return fullPathCode;
    }

    /**
     * 全路径编码
     */
    public void setFullPathCode(String fullPathCode) {
        this.fullPathCode = fullPathCode == null ? null : fullPathCode.trim();
    }

    /**
     * 子计数
     */
    public Integer getChildCount() {
        return childCount;
    }

    /**
     * 子计数
     */
    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    /**
     * 层级
     */
    public Integer getLevels() {
        return levels;
    }

    /**
     * 层级
     */
    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    /**
     * 排序
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 中文全称
     */
    public String getCnFullName() {
        return cnFullName;
    }

    /**
     * 中文全称
     */
    public void setCnFullName(String cnFullName) {
        this.cnFullName = cnFullName == null ? null : cnFullName.trim();
    }

    /**
     * 英文全称
     */
    public String getEnFullName() {
        return enFullName;
    }

    /**
     * 英文全称
     */
    public void setEnFullName(String enFullName) {
        this.enFullName = enFullName == null ? null : enFullName.trim();
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
     * 修改人
     */
    public String getLastUpdater() {
        return lastUpdater;
    }

    /**
     * 修改人
     */
    public void setLastUpdater(String lastUpdater) {
        this.lastUpdater = lastUpdater == null ? null : lastUpdater.trim();
    }

    /**
     * 修改时间
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 修改时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    
   
}