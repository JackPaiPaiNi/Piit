package com.ey.piit.interfaces.approve.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * SAP审批流
 * @author tianrong
 *
 */
@XStreamAlias("ROW")
public class ApproveBodyDto {
	@XStreamAlias("GSBM")
	private String gsbm="";//公司编码
	@XStreamAlias("DH")
	private String dh="";//单据编号
	@XStreamAlias("DHHXM")
	private String dhhxm="";//行项目
	@XStreamAlias("DJLX")
	private String djlx="";//单据类型
	@XStreamAlias("SPJG")
	private String spjg="";//审批结果
	@XStreamAlias("SPYJ")
	private String spyj="";//审批意见
	public String getGsbm() {
		return gsbm;
	}
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getDhhxm() {
		return dhhxm;
	}
	public void setDhhxm(String dhhxm) {
		this.dhhxm = dhhxm;
	}
	public String getDjlx() {
		return djlx;
	}
	public void setDjlx(String djlx) {
		this.djlx = djlx;
	}
	public String getSpjg() {
		return spjg;
	}
	public void setSpjg(String spjg) {
		this.spjg = spjg;
	}
	public String getSpyj() {
		return spyj;
	}
	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}
	
}