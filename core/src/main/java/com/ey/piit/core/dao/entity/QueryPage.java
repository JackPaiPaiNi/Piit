package com.ey.piit.core.dao.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class QueryPage {

	// 排序参数容器
	Map<String, String> sortMap = null;

	// 别名容器
	Map<String, String> aliasMap = null;

	// 每页记录数
	int pageSize;

	// 目标页
	int pageIndex;

	// 总记录数
	int totalRows;
	
	// 是否查询总数
	boolean calCount = true;

	// HQL
	String hqlString;

	// SQL
	String sqlString;

	// 查询条件列表
	List<ColumnValue> queryConditionList = new ArrayList<ColumnValue>();
	
	List<PageFooterColumn> pageFooter = new ArrayList<PageFooterColumn>();
	
	Class<?> dtoClass;
	
	RowMapper rowMapper;

	public QueryPage(int pageSize, int pageIndex) {
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
	}
	
	// 初始化操作
	public QueryPage(int pageSize, int pageIndex, String sortName,
			String sortOrder) {
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;

		if (sortName != null && !sortName.equals("")) {
			this.addSort(sortName, sortOrder);
		}
	}

	/**
	 * 排序
	 * 
	 * @param sortName
	 * @param sortOrder
	 */
	public void addSort(String sortName, String sortOrder) {

		if (sortMap == null) {
			sortMap = new LinkedHashMap<String, String>();
		}

		sortMap.put(sortName, sortOrder);
	}
	
	/**
	 * 设置排序
	 * 
	 * @param sortName
	 * @param sortOrder
	 */
	public void setSort(String sortName, String sortOrder) {

		if (sortMap == null) {
			sortMap = new LinkedHashMap<String, String>();
		}

		sortMap.put(sortName, sortOrder);
	}

	public Map<String, String> getSortMap() {
		return sortMap;
	}

	public void setSortMap(Map<String, String> sortMap) {
		this.sortMap = sortMap;
	}

	public void clearSortMap() {
		if (sortMap == null) {
			sortMap = new HashMap<String, String>();
		}

		sortMap.clear();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Map<String, String> getAliasMap() {
		return aliasMap;
	}

	public void setAliasMap(Map<String, String> aliasMap) {
		this.aliasMap = aliasMap;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public String getHqlString() {
		return hqlString;
	}

	public void setHqlString(String hqlString) {
		this.hqlString = hqlString;
	}

	public String getSqlString() {
		return sqlString;
	}

	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}

	public List<ColumnValue> getQueryConditionList() {
		return queryConditionList;
	}

	public void setQueryConditionList(List<ColumnValue> queryConditionList) {
		this.queryConditionList = queryConditionList;
	}

	public void addQueryCondition(String columeName, Object queryCondition) {
		this.queryConditionList
				.add(new ColumnValue(columeName, queryCondition));
	}

	public void clearQueryCondition() {
		this.queryConditionList.clear();
	}

	public List<PageFooterColumn> getPageFooter() {
		return pageFooter;
	}

	public void setPageFooter(List<PageFooterColumn> pageFooter) {
		this.pageFooter = pageFooter;
	}

	public void addPageFooterColumn(PageFooterColumn column) {
		pageFooter.add(column);
	}

	@SuppressWarnings("unchecked")
	public List getAllNotNullArg() {
		List args = new ArrayList();
		for (ColumnValue cv : this.queryConditionList) {
			if (cv.isNotNullValue())
				args.add(cv.getValue());
		}
		
		for (PageFooterColumn column : pageFooter) {
			args.add(column);
		}
		
		return args;
	}

	public boolean isCalCount() {
		return calCount;
	}

	public void setCalCount(boolean calCount) {
		this.calCount = calCount;
	}

	public Class<?> getDtoClass() {
		return dtoClass;
	}

	public void setDtoClass(Class<?> dtoClass) {
		this.dtoClass = dtoClass;
	}

	public RowMapper getRowMapper() {
		return rowMapper;
	}

	public void setRowMapper(RowMapper rowMapper) {
		this.rowMapper = rowMapper;
	}

}
