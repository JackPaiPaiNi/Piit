package com.ey.piit.sdo.report.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PiOrderEntity
 * @author 赵明
 */
public class PiOrderData extends BaseEntity {
	
	private String piid;	// PI号
	private Double pije;	// PI金额
	private Date pizdsj;	// PI制单时间
	private String ddid;	// 订单号
	private Double ddje;	// 订单金额
	private Date ddzdsj;	// 订单制单时间
	private String yzhdh;	// 预走货号
	private Double yzhje;	// 预走货金额
	private Date yzhzdsj;	// 预走货制单时间
	private String chdh;	// 出货通知书号
	private Double chje;	// 出货通知书金额
	private Date chzdsj;	// 出货通知书制单时间
	public PiOrderData() {
		super();
	}

	public PiOrderData(String id){
		super(id);
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public Double getPije() {
		return pije;
	}

	public void setPije(Double pije) {
		this.pije = pije;
	}

	public Date getPizdsj() {
		return pizdsj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setPizdsj(Date pizdsj) {
		this.pizdsj = pizdsj;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public Double getDdje() {
		return ddje;
	}

	public void setDdje(Double ddje) {
		this.ddje = ddje;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getDdzdsj() {
		return ddzdsj;
	}

	public void setDdzdsj(Date ddzdsj) {
		this.ddzdsj = ddzdsj;
	}

	public Double getYzhje() {
		return yzhje;
	}

	public void setYzhje(Double yzhje) {
		this.yzhje = yzhje;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYzhzdsj() {
		return yzhzdsj;
	}

	public void setYzhzdsj(Date yzhzdsj) {
		this.yzhzdsj = yzhzdsj;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public Double getChje() {
		return chje;
	}

	public void setChje(Double chje) {
		this.chje = chje;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getChzdsj() {
		return chzdsj;
	}

	public void setChzdsj(Date chzdsj) {
		this.chzdsj = chzdsj;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
}