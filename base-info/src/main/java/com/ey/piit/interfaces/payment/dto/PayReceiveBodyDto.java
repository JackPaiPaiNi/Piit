package com.ey.piit.interfaces.payment.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 收款登記接口实体
 * @author denghai 
 *
 */
@XStreamAlias("ROW")
public class PayReceiveBodyDto {
	@XStreamAlias("SKDH")
	private String skdh= "";//收款登记
	@XStreamAlias("GSBM")
	private String gsbm ="";//公司编码
	@XStreamAlias("SKYHZH")
	private String skyhzh= "";//收款银行账号
	@XStreamAlias("JE")
	private String je= "0";//金额
	@XStreamAlias("BZ")
	private String bz= "";//币种
	@XStreamAlias("SKRQ")
	private String skrq= "";//收款日期 格式 YYYY-MM-DD
	@XStreamAlias("SKDJRQ")
	private String skdjrq= "";//收款登记日期 格式 YYYY-MM-DD
	@XStreamAlias("BZXX")
	private String bzxx= "";//备注信息
	@XStreamAlias("FLAG")
	private String flag= "";//撤回标识
	

	public String getSkdh() {
		return skdh;
	}
	public void setSkdh(String skdh) {
		this.skdh = skdh;
	}
	public String getSkyhzh() {
		return skyhzh;
	}
	public void setSkyhzh(String skyhzh) {
		this.skyhzh = skyhzh;
	}
	
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getSkrq() {
		return skrq;
	}
	public void setSkrq(String skrq) {
		this.skrq = skrq;
	}
	public String getSkdjrq() {
		return skdjrq;
	}
	public void setSkdjrq(String skdjrq) {
		this.skdjrq = skdjrq;
	}
	public String getBzxx() {
		return bzxx;
	}
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}
	public String getGsbm() {
		return gsbm;
	}
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
