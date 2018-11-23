/*
 * ImportInfo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-12-04 Created
 */
package com.ey.piit.basesys.data.entity;

import java.util.Date;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.format.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * T_IMPORT_INFO
 * 
 * @author Kevin Xu
 * @version 1.0 2015-12-04
 */
public class ImportInfo extends CoreEntity {

    private String id;
    private String fileId;
    private String excelId;
    private Date importTime;
    private String defaultConfig;
    private String className;
    private String importParams;
    private String excelConfig;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getExcelId() {
        return excelId;
    }

    public void setExcelId(String excelId) {
        this.excelId = excelId == null ? null : excelId.trim();
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getImportTime() {
        return importTime;
    }

    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    public String getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(String defaultConfig) {
        this.defaultConfig = defaultConfig == null ? null : defaultConfig.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getImportParams() {
        return importParams;
    }

    public void setImportParams(String importParams) {
        this.importParams = importParams == null ? null : importParams.trim();
    }

    public String getExcelConfig() {
        return excelConfig;
    }

    public void setExcelConfig(String excelConfig) {
        this.excelConfig = excelConfig == null ? null : excelConfig.trim();
    }
}