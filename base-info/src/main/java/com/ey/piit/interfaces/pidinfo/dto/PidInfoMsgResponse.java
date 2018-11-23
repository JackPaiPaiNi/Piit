package com.ey.piit.interfaces.pidinfo.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * PID申请 接口实体 传入报文 返回报文共用一个
 * @author denghai
 *
 */
@XStreamAlias("ROW")
public class PidInfoMsgResponse {
	@XStreamAlias("ID")
	private String id="";//唯一ID
	@XStreamAlias("MATNR")
	private String pid="";//PID
	@XStreamAlias("ZZMODEL")
	private String jixing="";//机型
	@XStreamAlias("ZZSIZE")
	private String cc="";//尺寸
	@XStreamAlias("ZZRESOL")
	private String fbl="";//分辨率
	@XStreamAlias("ZZBRAND")
	private String pp="";//品牌
	@XStreamAlias("ZZCATEG")
	private String cpfl="";//产品类别
	@XStreamAlias("ZZSERIES")
	private String cpxl="";//产品系列
	@XStreamAlias("ZZCLOCKM")
	private String jixin="";//机芯
	@XStreamAlias("ZZSHIPW")
	private String zhfs="";//走货方式
	@XStreamAlias("MSG")
	private String msg="";//处理消息 X：成功
	private String inXml;//推送报文
	
	public String getInXml() {
		return inXml;
	}
	public void setInXml(String inXml) {
		this.inXml = inXml;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	
	public String getPp() {
		return pp;
	}
	public void setPp(String pp) {
		this.pp = pp;
	}
	
	public String getCpxl() {
		return cpxl;
	}
	public void setCpxl(String cpxl) {
		this.cpxl = cpxl;
	}
	public String getJixin() {
		return jixin;
	}
	public void setJixin(String jixin) {
		this.jixin = jixin;
	}
	public String getZhfs() {
		return zhfs;
	}
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFbl() {
		return fbl;
	}
	public void setFbl(String fbl) {
		this.fbl = fbl;
	}
	public String getCpfl() {
		return cpfl;
	}
	public void setCpfl(String cpfl) {
		this.cpfl = cpfl;
	}
	
	
}
