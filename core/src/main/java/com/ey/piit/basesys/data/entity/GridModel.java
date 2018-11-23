package com.ey.piit.basesys.data.entity;

import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GridModel {
	private String name;
	private String index;
	private String width;
	private String formatter;
	private GridModelEditOptions editoptions;
	private GridModelFormatOptions formatoptions;
	private GridModelFormOptions formoptions;
	private Boolean hidden;
	private Boolean hidedlg;
	
	// generate property
	private Integer realWidth;
	private Map<String, String> maps;
	
	// 指定的字段不会被序列化和反序列化。
	@JsonIgnore
	private CellStyle cellStyle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public GridModelEditOptions getEditoptions() {
		return editoptions;
	}

	public void setEditoptions(GridModelEditOptions editoptions) {
		this.editoptions = editoptions;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Boolean getHidedlg() {
		return hidedlg;
	}

	public void setHidedlg(Boolean hidedlg) {
		this.hidedlg = hidedlg;
	}

	public Integer getRealWidth() {
		return realWidth;
	}

	public void setRealWidth(Integer realWidth) {
		this.realWidth = realWidth;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	public GridModelFormatOptions getFormatoptions() {
		return formatoptions;
	}

	public void setFormatoptions(GridModelFormatOptions formatoptions) {
		this.formatoptions = formatoptions;
	}

	public GridModelFormOptions getFormoptions() {
		return formoptions;
	}

	public void setFormoptions(GridModelFormOptions formoptions) {
		this.formoptions = formoptions;
	}

	public CellStyle getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(CellStyle cellStyle) {
		this.cellStyle = cellStyle;
	}
}
