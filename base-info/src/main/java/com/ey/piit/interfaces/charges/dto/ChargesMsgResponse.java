package com.ey.piit.interfaces.charges.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 工装海运费 接口实体 传入报文 返回报文共用一个
 * @author denghai
 *
 */
@XStreamAlias("ROW")
public class ChargesMsgResponse {
	@XStreamAlias("ID")
	private String id="";//唯一ID
	@XStreamAlias("GSBM")
	private String gsbm="";//公司编码
	@XStreamAlias("FPRQ")
	private String fprq="";//发票日期
	@XStreamAlias("KHBM")
	private String khbm="";//客户编码
	@XStreamAlias("BZ")
	private String bz="";//币种
	@XStreamAlias("JE")
	private String je="";//金额
	@XStreamAlias("LX")
	private String lx="";//类型
	@XStreamAlias("PZH")
	private String pzh="";//凭证号,当凭证号为空，则返回失败，不为空，返回成功
	@XStreamAlias("MSG")
	private String msg="";//处理消息
	private String inXml;//推送报文
	
	public String getGsbm() {
		return gsbm;
	}
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	public String getFprq() {
		return fprq;
	}
	public void setFprq(String fprq) {
		this.fprq = fprq;
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getPzh() {
		return pzh;
	}
	public void setPzh(String pzh) {
		this.pzh = pzh;
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
	public String getInXml() {
		return inXml;
	}
	public void setInXml(String inXml) {
		this.inXml = inXml;
	}
	
}
