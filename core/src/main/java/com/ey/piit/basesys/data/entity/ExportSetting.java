package com.ey.piit.basesys.data.entity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ey.piit.core.paginator.domain.PageBounds;

public class ExportSetting extends PageBounds {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1875244830890136571L;
	
	//下载显示的文件名
	private String fileName;
	//在服务器端保存的文件名
	private String realName;
	
	public final static String EXPORT_COL_NAMES = "exportColNames";
	public final static String EXPORT_COL_MODELS = "exportColModels";
	public final static String EXPORT_COL_MODEL_LIST = "exportColModelList";
	public final static String EXPORT_COL_TYPE = "";
	public final static String EXPORT_GROUP_HEADER_LIST = "exportGroupHeaderList";
	private Map<Integer,String> exportColNames = new HashMap<Integer,String>();
	private Map<Integer,String> exportColModels = new HashMap<Integer,String>();
	private Map<Integer, GridModel> exportColModelList = new HashMap<Integer, GridModel>();
	private Map<String, ExportColType> exportColTypes = new LinkedHashMap<String, ExportColType>();
	private Map<Integer, List<GridGroupHeader>> exportGroupHeaderList = new HashMap<Integer, List<GridGroupHeader>>();

	private String title;
	
	private String format;
	private String directory;
	private String module;
	
	public ExportSetting() {
		super();
	}
	
	public Map<String, ExportColType> getExportColTypes() {
		return exportColTypes;
	}
	
	public void setExportColTypes(Map<String, ExportColType> exportColTypes) {
		this.exportColTypes = exportColTypes;
	}

	public ExportSetting setExportColTypes(String column,ExportColType exportColType) {
		exportColTypes.put(column, exportColType);
		return this;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setEncodeFileName(String fileName) {
		try {
			this.fileName = URLEncoder.encode(URLEncoder.encode(fileName, "UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			this.fileName = fileName;
		}
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Map<Integer, String> getExportColNames() {
		return exportColNames;
	}


	public void setExportColNames(Map<Integer, String> exportColNames) {
		this.exportColNames = exportColNames;
	}


	public Map<Integer, String> getExportColModels() {
		return exportColModels;
	}


	public void setExportColModels(Map<Integer, String> exportColModels) {
		this.exportColModels = exportColModels;
	}


	public void addExportColName(int index, String name){
		this.exportColNames.put(index,name);
	}
	
	public void addExportColModel(int index, String model){
		this.exportColModels.put(index,model);
	}

	public void addExportColModelList(int index, GridModel gridModel){
		this.exportColModelList.put(index, gridModel);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Map<Integer, GridModel> getExportColModelList() {
		return exportColModelList;
	}

	public void setExportColModelList(Map<Integer, GridModel> exportColModelList) {
		this.exportColModelList = exportColModelList;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Map<Integer, List<GridGroupHeader>> getExportGroupHeaderList() {
		return exportGroupHeaderList;
	}

	public void setExportGroupHeaderList(Map<Integer, List<GridGroupHeader>> exportGroupHeaderList) {
		this.exportGroupHeaderList = exportGroupHeaderList;
	}
	
	public void addExportGroupHeaderList(int index, List<GridGroupHeader> groupHeaderList){
		this.exportGroupHeaderList.put(index, groupHeaderList);
	}

}
