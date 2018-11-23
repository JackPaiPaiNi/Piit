package com.ey.piit.sdo.fcst.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 分公司销售数据填报Entity
 * @author 赵桃军
 */
public class FcstBranchData extends BaseEntity {
	
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String ywz;		    // 业务组
	private String ywzmc;		// 业务组名称
	private String fgsdm;		// 分公司代码
	private String fgsmc;		// 分公司名称
	private String cc;			// 尺寸
	private String pid;			// PID
	private String jixing;		// 机型
	private String ny;			// 年月
	private Double ycs;			// 预测数
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date   zdsj;		// 制单时间
	private String sjc;			// 时间戳
	private String beginCcd;	// 开始 尺寸段
	private String endCcd;		// 结束 尺寸段
	private String   beginNy ; 	//起始年月
	private String   endNy ;  	//起始年月
	
	
	
	
	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBeginNy() {
		return beginNy;
	}

	public void setBeginNy(String beginNy) {
		this.beginNy = beginNy;
	}

	public String getEndNy() {
		return endNy;
	}

	public void setEndNy(String endNy) {
		this.endNy = endNy;
	}

	public FcstBranchData() {
		super();
	}

	public FcstBranchData(String id){
		super(id);
	}

	/**
     * 销售组织
     */
	@Length(min=1, max=20, message="销售组织长度必须介于 1 和 20 之间")
	public String getXszz() {
		return xszz;
	}

	/**
     * 销售组织
     */
	public void setXszz(String xszz) {
		this.xszz = xszz == null ? null : xszz.trim();
	}
	
	/**
     * 销售组织名称
     */
	@Length(min=0, max=50, message="销售组织名称长度必须介于 0 和 50 之间")
	public String getXszzmc() {
		return xszzmc;
	}

	/**
     * 销售组织名称
     */
	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc == null ? null : xszzmc.trim();
	}
	
	/**
     * 业务组
     */
	@Length(min=1, max=20, message="业务组长度必须介于 1 和 20 之间")
	public String getYwz() {
		return ywz;
	}

	/**
     * 业务组
     */
	public void setYwz(String ywz) {
		this.ywz = ywz == null ? null : ywz.trim();
	}
	
	/**
     * 业务组名称
     */
	@Length(min=0, max=50, message="业务组名称长度必须介于 0 和 50 之间")
	public String getYwzmc() {
		return ywzmc;
	}

	/**
     * 业务组名称
     */
	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc == null ? null : ywzmc.trim();
	}
	
	
	/**
     * PID
     */
	@Length(min=0, max=50, message="PID长度必须介于 0 和 50 之间")
	public String getPid() {
		return pid;
	}

	/**
     * PID
     */
	public void setPid(String pid) {
		this.pid = pid == null ? null : pid.trim();
	}
	
	/**
     * 机型
     */
	@Length(min=1, max=50, message="机型长度必须介于 1 和 50 之间")
	public String getJixing() {
		return jixing;
	}

	/**
     * 机型
     */
	public void setJixing(String jixing) {
		this.jixing = jixing == null ? null : jixing.trim();
	}
	
	/**
     * 年月
     */
	@Length(min=1, max=6, message="年月长度必须介于 1 和 6 之间")
	public String getNy() {
		return ny;
	}

	/**
     * 年月
     */
	public void setNy(String ny) {
		this.ny = ny == null ? null : ny.trim();
	}
	
	/**
     * 预测数
     */
	public Double getYcs() {
		return ycs;
	}

	/**
     * 预测数
     */
	public void setYcs(Double ycs) {
		this.ycs = ycs;
	}
	
	/**
     * 制单人
     */
	@Length(min=0, max=20, message="制单人长度必须介于 0 和 20 之间")
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
	public Date getZdsj() {
		return zdsj;
	}

	/**
     * 制单时间
     */
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	
	/**
     * 时间戳
     */
	@Length(min=0, max=20, message="时间戳长度必须介于 0 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
     * 时间戳
     */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
	}
	
	public String getBeginCcd() {
		return beginCcd;
	}

	public void setBeginCcd(String beginCcd) {
		this.beginCcd = beginCcd;
	}
	
	public String getEndCcd() {
		return endCcd;
	}

	public void setEndCcd(String endCcd) {
		this.endCcd = endCcd;
	}

	public String getFgsdm() {
		return fgsdm;
	}

	public void setFgsdm(String fgsdm) {
		this.fgsdm = fgsdm;
	}

	public String getFgsmc() {
		return fgsmc;
	}

	public void setFgsmc(String fgsmc) {
		this.fgsmc = fgsmc;
	}
		
}