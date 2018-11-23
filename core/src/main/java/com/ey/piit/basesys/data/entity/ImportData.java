/*
 * ImportData.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-12-04 Created
 */
package com.ey.piit.basesys.data.entity;

import com.ey.piit.core.entity.CoreEntity;

/**
 * T_IMPORT_DATA
 * 
 * @author Kevin Xu
 * @version 1.0 2015-12-04
 */
public class ImportData extends CoreEntity {

    private String id;
    private String importId;
    private Long rowNo;
    private Boolean isSuccess;
    private String errorMessage;
    private String excelRowId;
    private String excelRowCode;
    private String excelData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId == null ? null : importId.trim();
    }

    public Long getRowNo() {
        return rowNo;
    }

    public void setRowNo(Long rowNo) {
        this.rowNo = rowNo;
    }

    public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    public String getExcelRowId() {
        return excelRowId;
    }

    public void setExcelRowId(String excelRowId) {
        this.excelRowId = excelRowId == null ? null : excelRowId.trim();
    }

    public String getExcelRowCode() {
        return excelRowCode;
    }

    public void setExcelRowCode(String excelRowCode) {
        this.excelRowCode = excelRowCode == null ? null : excelRowCode.trim();
    }

    public String getExcelData() {
        return excelData;
    }

    public void setExcelData(String excelData) {
        this.excelData = excelData == null ? null : excelData.trim();
    }
}