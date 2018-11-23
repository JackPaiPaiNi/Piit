package com.ey.piit.sdo.deliver.vo;

import java.util.Date;
import java.util.List;

import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.sdo.deliver.entity.DeliverReceiver;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

/**
 * 出货通知书发邮件Entity
 * @author 邓海
 */
public class DeliverEmailVo extends BaseEntity{

	private List<DeliverReceiver> receiverList = Lists.newArrayList();		// 收件人列表
	private List<DeliverReceiver> receiverYzhList = Lists.newArrayList();	// 预走货收件人列表
	
	
	private String zdrmc ;//提交人
	private Date zdsj ;//制单时间
	private String djlx;//业务单据
	private String chdh;//出货通知书单号
	private String qygmc;//起运港
	private String ddh;//订单号
	private String khmc;//客户名称
	private String fj;//附件
	private Integer bbh;//版本号
	private String cylxmc;//出运类型名称
	private String zhfsmc;//走货方式名称
	private String bgfsmc;//报关方式名称
	public List<DeliverReceiver> getReceiverList() {
		return receiverList;
	}
	public void setReceiverList(List<DeliverReceiver> receiverList) {
		this.receiverList = receiverList;
	}
	public List<DeliverReceiver> getReceiverYzhList() {
		return receiverYzhList;
	}
	public void setReceiverYzhList(List<DeliverReceiver> receiverYzhList) {
		this.receiverYzhList = receiverYzhList;
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
	public String getChdh() {
		return chdh;
	}
	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	public String getQygmc() {
		return qygmc;
	}
	public void setQygmc(String qygmc) {
		this.qygmc = qygmc;
	}
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
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
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	public String getFj() {
		return fj;
	}
	public void setFj(String fj) {
		this.fj = fj;
	}
	public Integer getBbh() {
		return bbh;
	}
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	public String getCylxmc() {
		return cylxmc;
	}
	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc;
	}
	public String getZhfsmc() {
		return zhfsmc;
	}
	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}
	public String getBgfsmc() {
		return bgfsmc;
	}
	public void setBgfsmc(String bgfsmc) {
		this.bgfsmc = bgfsmc;
	}

}