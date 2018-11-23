/*
 * ParaConfig.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-24 Created
 */
package com.ey.piit.basesys.para.entity;

import com.ey.piit.core.entity.CoreEntity;

/**
 * T_PARA_CONFIG
 * MDM配置表
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-24
 */
public class ParaConfig extends CoreEntity {

    /**
     * 序号
     */
    private String id;
    /**
     * 参数标签
     */
    private String key;
    /**
     * 参数类型
     */
    private String type;
    /**
     * 参数值
     */
    private String value;
    /**
     * 参数描述
     */
    private String description;
    /**
     * 状态
     */
    private String status;
    /**
     * 开始时间
     */
    private String startDate;
    /**
     * 结束时间
     */
    private String endDate;
    /**
     * EXT1
     */
    private String ext1;
    /**
     * EXT2
     */
    private String ext2;

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
     * 参数标签
     */
    public String getKey() {
        return key;
    }

    /**
     * 参数标签
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 参数类型
     */
    public String getType() {
        return type;
    }

    /**
     * 参数类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 参数值
     */
    public String getValue() {
        return value;
    }

    /**
     * 参数值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 参数描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 参数描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * 开始时间
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 开始时间
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * 结束时间
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 结束时间
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * EXT1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * EXT1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * EXT2
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * EXT2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }
}