package com.ey.piit.interfaces.log.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * SAP接口日志Entity
 * @author 魏诚
 */
public class SapInterfaceLog extends BaseEntity {
	
	private String mk;		// 模块
	private String dh;		// 单号
	private Date sj;		// 时间
	private Integer fhzt;		// 返回状态（1成功，0失败，2 海外成功，制造失败）
	private String fhxx;		// 返回信息
	private String bw;		// 传输报文
	
	public SapInterfaceLog() {
		super();
	}

	public SapInterfaceLog(String id){
		super(id);
	}

	/**
     * 模块
     */
	@Length(min=0, max=50, message="模块长度必须介于 0 和 50 之间")
	public String getMk() {
		return mk;
	}

	/**
     * 模块
     */
	public void setMk(String mk) {
		this.mk = mk == null ? null : mk.trim();
	}
	
	/**
     * 单号
     */
	@Length(min=0, max=20, message="单号长度必须介于 0 和 20 之间")
	public String getDh() {
		return dh;
	}

	/**
     * 单号
     */
	public void setDh(String dh) {
		this.dh = dh == null ? null : dh.trim();
	}
	
	/**
     * 时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSj() {
		return sj;
	}

	/**
     * 时间
     */
	public void setSj(Date sj) {
		this.sj = sj;
	}
	
	/**
     * 返回状态（1成功，0失败，2 海外成功，制造失败）
     */
	public Integer getFhzt() {
		return fhzt;
	}

	/**
     * 返回状态（1成功，0失败，2 海外成功，制造失败）
     */
	public void setFhzt(Integer fhzt) {
		this.fhzt = fhzt;
	}
	
	/**
     * 返回信息
     */
	public String getFhxx() {
		return fhxx;
	}

	/**
     * 返回信息
     */
	public void setFhxx(String fhxx) {
		this.fhxx = fhxx == null ? null : fhxx.trim();
	}

	public String getBw() {
		return bw;
	}

	public void setBw(String bw) {
		this.bw = bw;
	}
		
}