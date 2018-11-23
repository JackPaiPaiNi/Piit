/*
 * ResCtrl.java
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
 * T_RES_CTRL
 * 功能控制_资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
public class ResCtrl extends CoreEntity {

    /**
     * 序号
     */
    private String id;
    /**
     * 模块标示
     */
    private String module;
    /**
     * 控制编号
     */
    private String ctrlCode;
    /**
     * 资源编号
     */
    private String resId;
    /**
     * 是否必填
     */
    private String isRequired;
    /**
     * 是否隐藏
     */
    private String isHide;
    /**
     * 是否只读
     */
    private String isReadonly;
    /**
     * 是否可编辑
     */
    private String isEnable;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 条件
     */
    private String condition;
    /**
     * 值
     */
    private String value;
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
     * 资源编号
     */
    public String getResId() {
        return resId;
    }

    /**
     * 资源编号
     */
    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    /**
     * 是否必填
     */
    public String getIsRequired() {
        return isRequired;
    }

    /**
     * 是否必填
     */
    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired == null ? null : isRequired.trim();
    }

    /**
     * 是否隐藏
     */
    public String getIsHide() {
        return isHide;
    }

    /**
     * 是否隐藏
     */
    public void setIsHide(String isHide) {
        this.isHide = isHide == null ? null : isHide.trim();
    }

    /**
     * 是否只读
     */
    public String getIsReadonly() {
        return isReadonly;
    }

    /**
     * 是否只读
     */
    public void setIsReadonly(String isReadonly) {
        this.isReadonly = isReadonly == null ? null : isReadonly.trim();
    }

    /**
     * 是否可编辑
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 是否可编辑
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
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
     * 条件
     */
    public String getCondition() {
        return condition;
    }

    /**
     * 条件
     */
    public void setCondition(String condition) {
        this.condition = condition == null ? null : condition.trim();
    }

    /**
     * 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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