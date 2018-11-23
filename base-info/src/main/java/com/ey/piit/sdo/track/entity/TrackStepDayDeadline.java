package com.ey.piit.sdo.track.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订单节点预计完成时间设置Entity
 * @author 赵桃军
 */
public class TrackStepDayDeadline extends BaseEntity {
	
	private String ddlx;		// 订单类型
	private String ddlxmc;		// 订单类型名称
	private String ddlb;		// 订单类别
	private String ddlbmc;		// 订单类别名称
	private String zhfs;		// 走货方式
	private String zhfsmc;		// 走货方式名称
	private String khlx;		// 客户类型
	private Double ddzgd;		// 订单转工单
	private Double rjqr;		// 软件确认
	private Double scjhwc;		// 生产计划完成
	private String khlxmc;		// 客户类型名称
	private Double xd;		// 下单
	private Double ddsp;		// 订单审批
	private Double scddxd;		// 生产订单下达
	private Double ycps;		// 一次评审
	private Double mgqr;		// 美工确认
	private Double yzhcj;		// 预走货创建
	private Double yzhwc;		// 预走货完成
	private Double rk;		// 入库
	private Double ck;		// 出库
	private Double bg;		// 报关
	private Double cy;		// 出运
	private Double sjsh;		// 散件收货
	private Double zjsh;		// 整机收货
	private String xwgj;       //销往国家
	private String xwgjmc;     //销往国家名称
	private Integer sfxp;     //是否新品
	
	
	public TrackStepDayDeadline() {
		super();
	}

	
	
	public Integer getSfxp() {
		return sfxp;
	}



	public void setSfxp(Integer sfxp) {
		this.sfxp = sfxp;
	}



	public TrackStepDayDeadline(String id){
		super(id);
	}
	
	public String getXwgj() {
		return xwgj;
	}

	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}

	public String getXwgjmc() {
		return xwgjmc;
	}

	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}

	/**
     * 订单类型
     */
	@Length(min=1, max=20, message="订单类型长度必须介于 1 和 20 之间")
	public String getDdlx() {
		return ddlx;
	}

	/**
     * 订单类型
     */
	public void setDdlx(String ddlx) {
		this.ddlx = ddlx == null ? null : ddlx.trim();
	}
	
	/**
     * 订单类型名称
     */
	@Length(min=0, max=50, message="订单类型名称长度必须介于 0 和 50 之间")
	public String getDdlxmc() {
		return ddlxmc;
	}

	/**
     * 订单类型名称
     */
	public void setDdlxmc(String ddlxmc) {
		this.ddlxmc = ddlxmc == null ? null : ddlxmc.trim();
	}
	
	/**
     * 订单类别
     */
	@Length(min=1, max=20, message="订单类别长度必须介于 1 和 20 之间")
	public String getDdlb() {
		return ddlb;
	}

	/**
     * 订单类别
     */
	public void setDdlb(String ddlb) {
		this.ddlb = ddlb == null ? null : ddlb.trim();
	}
	
	/**
     * 订单类别名称
     */
	@Length(min=0, max=50, message="订单类别名称长度必须介于 0 和 50 之间")
	public String getDdlbmc() {
		return ddlbmc;
	}

	/**
     * 订单类别名称
     */
	public void setDdlbmc(String ddlbmc) {
		this.ddlbmc = ddlbmc == null ? null : ddlbmc.trim();
	}
	
	/**
     * 走货方式
     */
	@Length(min=1, max=20, message="走货方式长度必须介于 1 和 20 之间")
	public String getZhfs() {
		return zhfs;
	}

	/**
     * 走货方式
     */
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs == null ? null : zhfs.trim();
	}
	
	/**
     * 走货方式名称
     */
	@Length(min=0, max=50, message="走货方式名称长度必须介于 0 和 50 之间")
	public String getZhfsmc() {
		return zhfsmc;
	}

	/**
     * 走货方式名称
     */
	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc == null ? null : zhfsmc.trim();
	}
	
	/**
     * 客户类型
     */
	@Length(min=1, max=20, message="客户类型长度必须介于 1 和 20 之间")
	public String getKhlx() {
		return khlx;
	}

	/**
     * 客户类型
     */
	public void setKhlx(String khlx) {
		this.khlx = khlx == null ? null : khlx.trim();
	}
	
	/**
     * 订单转工单
     */
	public Double getDdzgd() {
		return ddzgd;
	}

	/**
     * 订单转工单
     */
	public void setDdzgd(Double ddzgd) {
		this.ddzgd = ddzgd;
	}
	
	/**
     * 软件确认
     */
	public Double getRjqr() {
		return rjqr;
	}

	/**
     * 软件确认
     */
	public void setRjqr(Double rjqr) {
		this.rjqr = rjqr;
	}
	
	/**
     * 生产计划完成
     */
	public Double getScjhwc() {
		return scjhwc;
	}

	/**
     * 生产计划完成
     */
	public void setScjhwc(Double scjhwc) {
		this.scjhwc = scjhwc;
	}
	
	/**
     * 客户类型名称
     */
	@Length(min=0, max=50, message="客户类型名称长度必须介于 0 和 50 之间")
	public String getKhlxmc() {
		return khlxmc;
	}

	/**
     * 客户类型名称
     */
	public void setKhlxmc(String khlxmc) {
		this.khlxmc = khlxmc == null ? null : khlxmc.trim();
	}
	
	/**
     * 下单
     */
	public Double getXd() {
		return xd;
	}

	/**
     * 下单
     */
	public void setXd(Double xd) {
		this.xd = xd;
	}
	
	/**
     * 订单审批
     */
	public Double getDdsp() {
		return ddsp;
	}

	/**
     * 订单审批
     */
	public void setDdsp(Double ddsp) {
		this.ddsp = ddsp;
	}
	
	/**
     * 生产订单下达
     */
	public Double getScddxd() {
		return scddxd;
	}

	/**
     * 生产订单下达
     */
	public void setScddxd(Double scddxd) {
		this.scddxd = scddxd;
	}
	
	/**
     * 一次评审
     */
	public Double getYcps() {
		return ycps;
	}

	/**
     * 一次评审
     */
	public void setYcps(Double ycps) {
		this.ycps = ycps;
	}
	
	/**
     * 美工确认
     */
	public Double getMgqr() {
		return mgqr;
	}

	/**
     * 美工确认
     */
	public void setMgqr(Double mgqr) {
		this.mgqr = mgqr;
	}
	
	/**
     * 预走货创建
     */
	public Double getYzhcj() {
		return yzhcj;
	}

	/**
     * 预走货创建
     */
	public void setYzhcj(Double yzhcj) {
		this.yzhcj = yzhcj;
	}
	
	/**
     * 预走货完成
     */
	public Double getYzhwc() {
		return yzhwc;
	}

	/**
     * 预走货完成
     */
	public void setYzhwc(Double yzhwc) {
		this.yzhwc = yzhwc;
	}
	
	/**
     * 入库
     */
	public Double getRk() {
		return rk;
	}

	/**
     * 入库
     */
	public void setRk(Double rk) {
		this.rk = rk;
	}
	
	/**
     * 出库
     */
	public Double getCk() {
		return ck;
	}

	/**
     * 出库
     */
	public void setCk(Double ck) {
		this.ck = ck;
	}
	
	/**
     * 报关
     */
	public Double getBg() {
		return bg;
	}

	/**
     * 报关
     */
	public void setBg(Double bg) {
		this.bg = bg;
	}
	
	/**
     * 出运
     */
	public Double getCy() {
		return cy;
	}

	/**
     * 出运
     */
	public void setCy(Double cy) {
		this.cy = cy;
	}
	
	/**
     * 散件收货
     */
	public Double getSjsh() {
		return sjsh;
	}

	/**
     * 散件收货
     */
	public void setSjsh(Double sjsh) {
		this.sjsh = sjsh;
	}
	
	/**
     * 整机收货
     */
	public Double getZjsh() {
		return zjsh;
	}

	/**
     * 整机收货
     */
	public void setZjsh(Double zjsh) {
		this.zjsh = zjsh;
	}
	
}