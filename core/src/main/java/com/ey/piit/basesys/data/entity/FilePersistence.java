/*
 * FilePersistence.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-12-04 Created
 */
package com.ey.piit.basesys.data.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.format.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * T_FILE_PERSISTENCE
 * 
 * @author Kevin Xu
 * @version 1.0 2015-12-04
 */
public class FilePersistence extends CoreEntity {

    private String id;
	private String fileName;// 文件名
	private String physicalName;// 物理文件名
	private String operatorId;// 操作者ID
	private String ownerModule;// 模块
	private Date logDate;// 日志时间
	private String contentType;//文件类型
	private BigDecimal contentLength;//文件大小，单位字节
	private String downloadPath;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getPhysicalName() {
        return physicalName;
    }

    public void setPhysicalName(String physicalName) {
        this.physicalName = physicalName == null ? null : physicalName.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getOwnerModule() {
        return ownerModule;
    }

    public void setOwnerModule(String ownerModule) {
        this.ownerModule = ownerModule == null ? null : ownerModule.trim();
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public BigDecimal getContentLength() {
        return contentLength;
    }

    public void setContentLength(BigDecimal contentLength) {
        this.contentLength = contentLength;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath == null ? null : downloadPath.trim();
    }
}
