package com.ey.piit.sdo.art.vo;

import java.util.List;

import com.ey.piit.sdo.art.entity.Artoem;
import com.google.common.collect.Lists;

/**
 * 美工任务单OEMEntity
 * @author 魏诚
 */
public class ArtoemVo extends Artoem {
	
	private List<ArtLogVo> logList = Lists.newArrayList();		// 子表列表
	private String beginZdsj;
	private String endZdsj;
	private String ztmc;
	private Integer sfmgzjh;//查询条件
	private List<ArtoemVo> htylist;
	private Integer gcjsb;//工程技术部选择流程下一环节
	
	private String cpjl;
	
	
	public ArtoemVo() {
		super();
	}

	public ArtoemVo(String id){
		super(id);
	}

	public List<ArtLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<ArtLogVo> logList) {
		this.logList = logList;
	}

	public String getBeginZdsj() {
		return beginZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public Integer getSfmgzjh() {
		return sfmgzjh;
	}

	public void setSfmgzjh(Integer sfmgzjh) {
		this.sfmgzjh = sfmgzjh;
	}

	public List<ArtoemVo> getHtylist() {
		return htylist;
	}

	public void setHtylist(List<ArtoemVo> htylist) {
		this.htylist = htylist;
	}

	public Integer getGcjsb() {
		return gcjsb;
	}

	public void setGcjsb(Integer gcjsb) {
		this.gcjsb = gcjsb;
	}

	public String getCpjl() {
		return cpjl;
	}

	public void setCpjl(String cpjl) {
		this.cpjl = cpjl;
	}

	
}