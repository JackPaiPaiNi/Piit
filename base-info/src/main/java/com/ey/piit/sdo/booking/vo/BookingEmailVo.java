package com.ey.piit.sdo.booking.vo;

import java.util.Date;
import java.util.List;

import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.sdo.booking.entity.BookingReceiver;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

/**
 * 订舱发邮件Entity
 * @author 赵明
 */
public class BookingEmailVo extends BaseEntity{

	private List<BookingReceiver> receiverList = Lists.newArrayList();		// 收件人列表
	
	private String zdrmc ;//提交人
	private Date zdsj ;//制单时间
	private String yzhdh;//预走货单号
	private String dcdh;//订舱单号
	private String khmc;//客户名称
	private String fj;//附件
	private Integer bbh;//版本号
	public List<BookingReceiver> getReceiverList() {
		return receiverList;
	}
	public void setReceiverList(List<BookingReceiver> receiverList) {
		this.receiverList = receiverList;
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
	public String getYzhdh() {
		return yzhdh;
	}
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	public String getDcdh() {
		return dcdh;
	}
	public void setDcdh(String dcdh) {
		this.dcdh = dcdh;
	}

}