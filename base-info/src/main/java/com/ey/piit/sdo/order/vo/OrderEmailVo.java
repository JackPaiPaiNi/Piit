package com.ey.piit.sdo.order.vo;

import java.util.Date;
import java.util.List;

import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.sdo.order.entity.OrderReceiver;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

/**
 * 订单发邮件Entity
 * @author 赵明
 */
public class OrderEmailVo extends BaseEntity{

	private List<OrderReceiver> receiverList = Lists.newArrayList();// 收件人列表
	
	private String zdrmc ;//提交人
	private String zdrid ;//提交人ID
	private String xsymc ;//销售员名称
	private Date zdsj ;//制单时间
	private String djlx;//业务单据
	private String ddid;//订单号
	private String khmc;//客户名称
	private Double sl;	//数量
	private String wsxh;//我司型号
	private String pp;//品牌
	private String jixin;//机芯
	
	public List<OrderReceiver> getReceiverList() {
		return receiverList;
	}
	public void setReceiverList(List<OrderReceiver> receiverList) {
		this.receiverList = receiverList;
	}
	public String getZdrmc() {
		return zdrmc;
	}
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}
	public String getDjlx() {
		return djlx;
	}
	public void setDjlx(String djlx) {
		this.djlx = djlx;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZdsj() {
		return zdsj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public Double getSl() {
		return sl;
	}
	public void setSl(Double sl) {
		this.sl = sl;
	}
	public String getXsymc() {
		return xsymc;
	}
	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}
	public String getWsxh() {
		return wsxh;
	}
	public void setWsxh(String wsxh) {
		this.wsxh = wsxh;
	}
	public String getPp() {
		return pp;
	}
	public void setPp(String pp) {
		this.pp = pp;
	}
	public String getZdrid() {
		return zdrid;
	}
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}
	public String getJixin() {
		return jixin;
	}
	public void setJixin(String jixin) {
		this.jixin = jixin;
	}
	

}