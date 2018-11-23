package com.ey.piit.sdo.fcst.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * fcstEntity
 * @author 赵桃军
 */
public class FcstNotice extends BaseEntity {
	
	private String nr;		// 内容
	private String zc;		// 周次
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	
	public FcstNotice() {
		super();
	}

	public FcstNotice(String id){
		super(id);
	}
	
	/**
     * 内容
     */
	public String getNr() {
		return nr;
	}

	/**
     * 内容
     */
	public void setNr(String nr) {
		this.nr = nr == null ? null : nr.trim();
	}
	/**
     * 周次
     */
	public String getZc() {
		return zc;
	}

	/**
     * 周次
     */
	public void setZc(String zc) {
		this.zc = zc == null ? null : zc.trim();
	}
	/**
     * 制单人
     */
	@Length(min=1, max=20, message="制单人长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * 制单人
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * 制单人名称
     */
	@Length(min=0, max=50, message="制单人名称长度必须介于 0 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * 制单人名称
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}
	
	/**
     * 制单时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="制单时间不能为空")
	public Date getZdsj() {
		return zdsj;
	}

	/**
     * 制单时间
     */
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	
}