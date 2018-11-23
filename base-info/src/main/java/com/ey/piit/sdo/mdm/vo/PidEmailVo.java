package com.ey.piit.sdo.mdm.vo;

import java.util.Date;
import java.util.List;

import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.sdo.mdm.entity.PidReceiver;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

/**
 * PID申请发邮件Entity
 * @author 赵明
 */
public class PidEmailVo extends BaseEntity{

	private List<PidReceiver> receiverList1 = Lists.newArrayList();		// PID审批结束后收件人列表
	private List<PidReceiver> receiverList0 = Lists.newArrayList();		// 填写PID样机数量后收件人列表
	
	private String zdrmc ;//提交人
	private Date cjsj ;//制单时间
	private String pid;//PID号
	private String jixing;//机型
	private String jixin;//机芯
	private String xwgjmc;//销往国家名称
	private String khmc;//客户名称
	private Double yjnxsl;//预计年销数量
	private Integer pidyjsl;//PID样机数量
	
	public List<PidReceiver> getReceiverList1() {
		return receiverList1;
	}
	public void setReceiverList1(List<PidReceiver> receiverList1) {
		this.receiverList1 = receiverList1;
	}
	public List<PidReceiver> getReceiverList0() {
		return receiverList0;
	}
	public void setReceiverList0(List<PidReceiver> receiverList0) {
		this.receiverList0 = receiverList0;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public String getJixin() {
		return jixin;
	}
	public void setJixin(String jixin) {
		this.jixin = jixin;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getXwgjmc() {
		return xwgjmc;
	}
	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}
	public String getZdrmc() {
		return zdrmc;
	}
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCjsj() {
		return cjsj;
	}
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}
	public Double getYjnxsl() {
		return yjnxsl;
	}
	public void setYjnxsl(Double yjnxsl) {
		this.yjnxsl = yjnxsl;
	}
	public Integer getPidyjsl() {
		return pidyjsl;
	}
	public void setPidyjsl(Integer pidyjsl) {
		this.pidyjsl = pidyjsl;
	}
	
}