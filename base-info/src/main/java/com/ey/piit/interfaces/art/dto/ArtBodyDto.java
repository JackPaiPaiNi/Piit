package com.ey.piit.interfaces.art.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 美工任务单接口实体
 * @author 魏诚
 *
 */
@XStreamAlias("ROW")
public class ArtBodyDto {
	
	@XStreamAlias("SHEETNO")
	private String sheetno = "";//美工任务单号
	@XStreamAlias("MATNR")
	private String matnr = "";//组件号
	
	
	public String getSheetno() {
		return sheetno;
	}
	public void setSheetno(String sheetno) {
		this.sheetno = sheetno;
	}
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	
}
