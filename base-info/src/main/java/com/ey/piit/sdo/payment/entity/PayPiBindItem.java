package com.ey.piit.sdo.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PI付款保障已使用明细Entity
 * 
 * @author 田荣
 */
public class PayPiBindItem extends BaseEntity {

	private String piid;  //PI号
	private String ddid;  //订单号
	private String yzhdh;  //预走货单号
	private String fklx;  //付款类型
	private String jd;  //节点
	private String bz;  //币种
	private BigDecimal syje;  //使用金额
	private Date zdsj;  //制单时间
	private String bzxx;  //备注信息
	private String zdrid;  //勾兑人
	private String zdrmc;  //勾兑人名称
	private Date gdsj;  //勾兑时间
	private Integer sfZdgd;  //是否自动勾兑 1：是 0 否
	private String gddh;  //勾兑单号
	private Integer flag;  //冲销标记  1冲销正向或逆向;null则为正常（用于勾兑过滤数据）
	private String beginZdsj;		// 开始 登记时间
	private String endZdsj;		// 结束 登记时间

	public PayPiBindItem() {
		super();
	}

	public PayPiBindItem(String id) {
		super(id);
	}
	
	public String getPiid() {
		return piid;
	}
	public void setPiid(String piid) {
		this.piid = piid;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public String getYzhdh() {
		return yzhdh;
	}
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	public String getFklx() {
		return fklx;
	}
	public void setFklx(String fklx) {
		this.fklx = fklx;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public BigDecimal getSyje() {
		return syje;
	}
	public void setSyje(BigDecimal syje) {
		this.syje = syje;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	public String getBzxx() {
		return bzxx;
	}
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
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
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getGdsj() {
		return gdsj;
	}
	public void setGdsj(Date gdsj) {
		this.gdsj = gdsj;
	}
	public String getGddh() {
		return gddh;
	}
	public void setGddh(String gddh) {
		this.gddh = gddh;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getBeginZdsj() {
		return beginZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	public Integer getSfZdgd() {
		return sfZdgd;
	}

	public void setSfZdgd(Integer sfZdgd) {
		this.sfZdgd = sfZdgd;
	}
	
	
}
