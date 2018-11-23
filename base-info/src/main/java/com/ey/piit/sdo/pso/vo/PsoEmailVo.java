package com.ey.piit.sdo.pso.vo;

import java.util.Date;
import java.util.List;

import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.sdo.pso.entity.PsoReceiver;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

/**
 * 预走货船务处理发邮件Entity
 * @author 高文浩
 */
public class PsoEmailVo extends BaseEntity{

	private List<PsoReceiver> receiverList = Lists.newArrayList();	// 收件人列表
	
	private String cwzymc ;//船务专员名称
	private Date zdsj ;//制单时间
	private String yzhdh;//预走货单号
	private String khmc;//客户名称
	
	
	public List<PsoReceiver> getReceiverList() {
		return receiverList;
	}
	public void setReceiverList(List<PsoReceiver> receiverList) {
		this.receiverList = receiverList;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getYzhdh() {
		return yzhdh;
	}
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZdsj() {
		return zdsj;
	}
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	public String getCwzymc() {
		return cwzymc;
	}
	public void setCwzymc(String cwzymc) {
		this.cwzymc = cwzymc;
	}
	
}