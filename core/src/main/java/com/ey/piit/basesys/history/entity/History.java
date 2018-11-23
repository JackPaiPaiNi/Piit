package com.ey.piit.basesys.history.entity;

/**
 * 
 * @author Kevin-Y.Xu
 *
 */
public class History {
	
	private String id;

	/**
	 * 表名
	 */
	private String tableName;
	
	/**
	 * 历史表名
	 */
	private String tableNameHist;
	
	/**
	 * 临时表名
	 */
	private String tableNameTemp;
	
	/**
	 * 表字段字符串，格式：ID, SERVICE_ID, RETURN_CODE
	 */
	private String tableColumn;
	
	/**
	 * 驼峰表字段字符串，格式：ID "id", SERVICE_ID "serviceId", RETURN_CODE "returnCode"
	 */
	private String tableColumnCamel;
	
	/**
	 * 表字段值字符串，格式：#{id}, #{serviceId}, #{returnCode}
	 */
	private String columnValue;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableNameHist() {
		return tableNameHist;
	}

	public void setTableNameHist(String tableNameHist) {
		this.tableNameHist = tableNameHist;
	}

	public String getTableNameTemp() {
		return tableNameTemp;
	}

	public void setTableNameTemp(String tableNameTemp) {
		this.tableNameTemp = tableNameTemp;
	}

	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}

	public String getTableColumnCamel() {
		return tableColumnCamel;
	}

	public void setTableColumnCamel(String tableColumnCamel) {
		this.tableColumnCamel = tableColumnCamel;
	}

	public String getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	
}
