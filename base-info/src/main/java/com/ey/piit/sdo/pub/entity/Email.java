package com.ey.piit.sdo.pub.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 邮件entity
 * @author 赵明
 */
public class Email extends BaseEntity{
	
	private String ywid;		// 业务ID
	private String ywdh;		// 业务单号
	private String name;		// 类型名称
	private String yxdz;		// 邮箱地址
	private String text;		// 内容
	private Date stime;			// 时间
	public String getYwid() {
		return ywid;
	}
	public void setYwid(String ywid) {
		this.ywid = ywid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	/**
     * 制单时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH24:MI:SS")
	@NotNull(message="制单时间不能为空")
	public Date getStime() {
		return stime;
	}

	/**
     * 制单时间
     */
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public String getYwdh() {
		return ywdh;
	}
	public void setYwdh(String ywdh) {
		this.ywdh = ywdh;
	}
	public String getYxdz() {
		return yxdz;
	}
	public void setYxdz(String yxdz) {
		this.yxdz = yxdz;
	}
}