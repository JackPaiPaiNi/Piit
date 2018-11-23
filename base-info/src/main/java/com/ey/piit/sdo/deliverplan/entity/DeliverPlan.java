package com.ey.piit.sdo.deliverplan.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 走货计划单明细实体
 * @author 邓海
 */
public class DeliverPlan extends BaseEntity {

	private String zhjhdh;//走货计划单号

	private String zdrid;//制单人
	private String zdrmc;//制单人
	private Date zdsj;//制单时间
	private Integer zt;//状态
	private String sjc;//时间戳
	private String ztmc;//状态名称
	private Date zgkssj;//装柜开始时间
	private Date zgjssj;//装柜结束时间
	private String lx;//类型1子类 2父类
	private String lxmc;	//类型名称
	public DeliverPlan() {
		super();
	}

	public DeliverPlan(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getZhjhdh() {
		return zhjhdh;
	}

	public void setZhjhdh(String zhjhdh) {
		this.zhjhdh = zhjhdh;
	}

	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZgkssj() {
		return zgkssj;
	}

	public void setZgkssj(Date zgkssj) {
		this.zgkssj = zgkssj;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZgjssj() {
		return zgjssj;
	}

	public void setZgjssj(Date zgjssj) {
		this.zgjssj = zgjssj;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getLxmc() {
		return lxmc;
	}

	public void setLxmc(String lxmc) {
		this.lxmc = lxmc;
	}
	
}