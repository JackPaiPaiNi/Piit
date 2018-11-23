package com.ey.piit.sdo.project.vo;

import java.util.List;

import com.ey.piit.sdo.project.entity.ProjectBug;
import com.google.common.collect.Lists;

/**
 * 系统问题管理Entity
 * 
 * @author 赵桃军
 */
public class ProjectBugVo extends ProjectBug {

	private List<ProjectBugLogVo> logList = Lists.newArrayList();

	private String zdrid;
	private String zdrmc;
	private String flag ;
	private String spyj ;
	
	public String getSpyj() {
		return spyj;
	}

	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<ProjectBugLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<ProjectBugLogVo> logList) {
		this.logList = logList;
	}

	public ProjectBugVo() {
		super();
	}

	public ProjectBugVo(String id) {
		super(id);
	}

	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}

}