package com.ey.piit.sdo.track.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订单跟踪主表查询Entity
 * @author 赵桃军
 */
public class TrackInfo extends BaseEntity {
	
	private String ddid;		// 订单号
	private String ddlx;		// 订单类型
	private String ddlxmc;		// 订单类型名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String ywz;		// 业务组
	private String ywzmc;		// 业务组名称
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String pid;		// PID
	private String jixing;		// 创维型号
	private String khxhms;		// 买家型号
	private String ddztzt;		// 订单整体状态
	private String sfczywjd;		// 是否存在延误节点
	private Date xdyq;		// 下单（要求）
	private Date xd;		// 下单
	private Date jhrq;		// 交货日期
	private Date scjhwcyq;		// 生产计划完成（要求）
	private Date scjhwcjh;		// 生产计划完成（计划）
	private Date scjhwc;		// 生产计划完成
	private String scjhwczt;		// 生产计划完成状态
	private Date ddspyq;		// 订单审批（要求）
	private Date ddspjh;		// 订单审批（计划）
	private Date ddsp;		// 订单审批
	private String ddspzt;		// 订单审批状态
	private Date scddxdyq;		// 生产订单下达（要求）
	private Date scddxdjh;		// 生产订单下达（计划）
	private Date scddxd;		// 生产订单下达
	private String scddxdzt;		// 生产订单下达状态
	private Date ycpsyq;		// 一次评审（要求）
	private Date ycpsjh;		// 一次评审（计划）
	private Date ycps;		// 一次评审
	private String ycpszt;		// 一次评审状态
	private Date mgqryq;		// 美工确认（要求）
	private Date mgqrjh;		// 美工确认（计划）
	private Date mgqr;		// 美工确认
	private String mgqrzt;		// 美工确认状态
	private Date ddzgdyq;		// 订单转工单（要求）
	private Date ddzgdjh;		// 订单转工单（计划）
	private Date ddzgd;		// 订单转工单
	private String ddzgdzt;		// 订单转工单状态
	private Date rjqryq;		// 软件确认（要求）
	private Date rjqrjh;		// 软件确认（计划）
	private Date rjqr;		// 软件确认
	private String rjqrzt;		// 软件确认状态
	private Date yzhcjyq;		// 预走货创建（要求）
	private Date yzhcjjh;		// 预走货创建（计划）
	private Date yzhcj;		// 预走货创建
	private String yzhcjzt;		// 预走货创建状态
	private Date yzhwcyq;		// 预走货完成（要求）
	private Date yzhwcjh;		// 预走货完成（计划）
	private Date yzhwc;		// 预走货完成
	private String yzhwczt;		// 预走货完成状态
	private Date rkyq;		// 入库（要求）
	private Date rkjh;		// 入库（计划）
	private Date rk;		// 入库
	private String rkzt;		// 入库状态
	private Date ckyq;		// 出库（要求）
	private Date ckjh;		// 出库（计划）
	private Date ck;		// 出库
	private String ckzt;		// 出库状态
	private Date bgyq;		// 报关（要求）
	private Date bgjh;		// 报关（计划）
	private Date bg;		// 报关
	private String bgzt;		// 报关状态
	private Date cyyq;		// 出运（要求）
	private Date cyjh;		// 出运（计划）
	private Date cy;		// 出运
	private String cyzt;		// 出运状态
	private Date sjshyq;		// 散件收货（要求）
	private Date sjshjh;		// 散件收货（计划）
	private Date sjsh;		// 散件收货
	private String sjshzt;		// 散件收货状态
	private Date zjshyq;		// 整机收货（要求）
	private Date zjshjh;		// 整机收货（计划）
	private Date zjsh;		// 整机收货
	private String zjshzt;		// 整机收货状态
	private String beginXd;		// 开始 下单
	private String endXd;		// 结束 下单
	private String beginJhrq;		// 开始 交货日期
	private String endJhrq;		// 结束 交货日期
	private Date beginCyyq;		// 开始 出运（要求）
	private Date endCyyq;		// 结束 出运（要求）
	private String endCy;         //开始出运
	private String beginCy;       //开始出运
	
	
	
	public String getEndCy() {
		return endCy;
	}

	public void setEndCy(String endCy) {
		this.endCy = endCy;
	}

	public String getBeginCy() {
		return beginCy;
	}

	public void setBeginCy(String beginCy) {
		this.beginCy = beginCy;
	}

	public TrackInfo() {
		super();
	}

	public TrackInfo(String id){
		super(id);
	}

	/**
     * 订单号
     */
	@Length(min=1, max=20, message="订单号长度必须介于 1 和 20 之间")
	public String getDdid() {
		return ddid;
	}

	/**
     * 订单号
     */
	public void setDdid(String ddid) {
		this.ddid = ddid == null ? null : ddid.trim();
	}
	
	/**
     * 订单类型
     */
	@Length(min=0, max=20, message="订单类型长度必须介于 0 和 20 之间")
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
     * 销售组织
     */
	@Length(min=0, max=20, message="销售组织长度必须介于 0 和 20 之间")
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
	@Length(min=0, max=20, message="业务组长度必须介于 0 和 20 之间")
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
     * 销售员
     */
	@Length(min=0, max=20, message="销售员长度必须介于 0 和 20 之间")
	public String getXsyid() {
		return xsyid;
	}

	/**
     * 销售员
     */
	public void setXsyid(String xsyid) {
		this.xsyid = xsyid == null ? null : xsyid.trim();
	}
	
	/**
     * 销售员名称
     */
	@Length(min=0, max=50, message="销售员名称长度必须介于 0 和 50 之间")
	public String getXsymc() {
		return xsymc;
	}

	/**
     * 销售员名称
     */
	public void setXsymc(String xsymc) {
		this.xsymc = xsymc == null ? null : xsymc.trim();
	}
	
	/**
     * 客户编码
     */
	@Length(min=0, max=20, message="客户编码长度必须介于 0 和 20 之间")
	public String getKhbm() {
		return khbm;
	}

	/**
     * 客户编码
     */
	public void setKhbm(String khbm) {
		this.khbm = khbm == null ? null : khbm.trim();
	}
	
	/**
     * 客户名称
     */
	@Length(min=0, max=100, message="客户名称长度必须介于 0 和 100 之间")
	public String getKhmc() {
		return khmc;
	}

	/**
     * 客户名称
     */
	public void setKhmc(String khmc) {
		this.khmc = khmc == null ? null : khmc.trim();
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
     * 创维型号
     */
	@Length(min=0, max=50, message="创维型号长度必须介于 0 和 50 之间")
	public String getJixing() {
		return jixing;
	}

	/**
     * 创维型号
     */
	public void setJixing(String jixing) {
		this.jixing = jixing == null ? null : jixing.trim();
	}
	
	/**
     * 买家型号
     */
	@Length(min=0, max=100, message="买家型号长度必须介于 0 和 100 之间")
	public String getKhxhms() {
		return khxhms;
	}

	/**
     * 买家型号
     */
	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms == null ? null : khxhms.trim();
	}
	
	/**
     * 订单整体状态
     */
	@Length(min=0, max=20, message="订单整体状态长度必须介于 0 和 20 之间")
	public String getDdztzt() {
		return ddztzt;
	}

	/**
     * 订单整体状态
     */
	public void setDdztzt(String ddztzt) {
		this.ddztzt = ddztzt == null ? null : ddztzt.trim();
	}
	
	/**
     * 是否存在延误节点
     */
	@Length(min=0, max=20, message="是否存在延误节点长度必须介于 0 和 20 之间")
	public String getSfczywjd() {
		return sfczywjd;
	}

	/**
     * 是否存在延误节点
     */
	public void setSfczywjd(String sfczywjd) {
		this.sfczywjd = sfczywjd == null ? null : sfczywjd.trim();
	}
	
	/**
     * 下单（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXdyq() {
		return xdyq;
	}

	/**
     * 下单（要求）
     */
	public void setXdyq(Date xdyq) {
		this.xdyq = xdyq;
	}
	
	/**
     * 下单
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXd() {
		return xd;
	}

	/**
     * 下单
     */
	public void setXd(Date xd) {
		this.xd = xd;
	}
	
	/**
     * 交货日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJhrq() {
		return jhrq;
	}

	/**
     * 交货日期
     */
	public void setJhrq(Date jhrq) {
		this.jhrq = jhrq;
	}
	
	/**
     * 生产计划完成（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScjhwcyq() {
		return scjhwcyq;
	}

	/**
     * 生产计划完成（要求）
     */
	public void setScjhwcyq(Date scjhwcyq) {
		this.scjhwcyq = scjhwcyq;
	}
	
	/**
     * 生产计划完成（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScjhwcjh() {
		return scjhwcjh;
	}

	/**
     * 生产计划完成（计划）
     */
	public void setScjhwcjh(Date scjhwcjh) {
		this.scjhwcjh = scjhwcjh;
	}
	
	/**
     * 生产计划完成
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScjhwc() {
		return scjhwc;
	}

	/**
     * 生产计划完成
     */
	public void setScjhwc(Date scjhwc) {
		this.scjhwc = scjhwc;
	}
	
	/**
     * 生产计划完成状态
     */
	@Length(min=0, max=20, message="生产计划完成状态长度必须介于 0 和 20 之间")
	public String getScjhwczt() {
		return scjhwczt;
	}

	/**
     * 生产计划完成状态
     */
	public void setScjhwczt(String scjhwczt) {
		this.scjhwczt = scjhwczt == null ? null : scjhwczt.trim();
	}
	
	/**
     * 订单审批（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDdspyq() {
		return ddspyq;
	}

	/**
     * 订单审批（要求）
     */
	public void setDdspyq(Date ddspyq) {
		this.ddspyq = ddspyq;
	}
	
	/**
     * 订单审批（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDdspjh() {
		return ddspjh;
	}

	/**
     * 订单审批（计划）
     */
	public void setDdspjh(Date ddspjh) {
		this.ddspjh = ddspjh;
	}
	
	/**
     * 订单审批
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDdsp() {
		return ddsp;
	}

	/**
     * 订单审批
     */
	public void setDdsp(Date ddsp) {
		this.ddsp = ddsp;
	}
	
	/**
     * 订单审批状态
     */
	@Length(min=0, max=20, message="订单审批状态长度必须介于 0 和 20 之间")
	public String getDdspzt() {
		return ddspzt;
	}

	/**
     * 订单审批状态
     */
	public void setDdspzt(String ddspzt) {
		this.ddspzt = ddspzt == null ? null : ddspzt.trim();
	}
	
	/**
     * 生产订单下达（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScddxdyq() {
		return scddxdyq;
	}

	/**
     * 生产订单下达（要求）
     */
	public void setScddxdyq(Date scddxdyq) {
		this.scddxdyq = scddxdyq;
	}
	
	/**
     * 生产订单下达（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScddxdjh() {
		return scddxdjh;
	}

	/**
     * 生产订单下达（计划）
     */
	public void setScddxdjh(Date scddxdjh) {
		this.scddxdjh = scddxdjh;
	}
	
	/**
     * 生产订单下达
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScddxd() {
		return scddxd;
	}

	/**
     * 生产订单下达
     */
	public void setScddxd(Date scddxd) {
		this.scddxd = scddxd;
	}
	
	/**
     * 生产订单下达状态
     */
	@Length(min=0, max=20, message="生产订单下达状态长度必须介于 0 和 20 之间")
	public String getScddxdzt() {
		return scddxdzt;
	}

	/**
     * 生产订单下达状态
     */
	public void setScddxdzt(String scddxdzt) {
		this.scddxdzt = scddxdzt == null ? null : scddxdzt.trim();
	}
	
	/**
     * 一次评审（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYcpsyq() {
		return ycpsyq;
	}

	/**
     * 一次评审（要求）
     */
	public void setYcpsyq(Date ycpsyq) {
		this.ycpsyq = ycpsyq;
	}
	
	/**
     * 一次评审（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYcpsjh() {
		return ycpsjh;
	}

	/**
     * 一次评审（计划）
     */
	public void setYcpsjh(Date ycpsjh) {
		this.ycpsjh = ycpsjh;
	}
	
	/**
     * 一次评审
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYcps() {
		return ycps;
	}

	/**
     * 一次评审
     */
	public void setYcps(Date ycps) {
		this.ycps = ycps;
	}
	
	/**
     * 一次评审状态
     */
	@Length(min=0, max=20, message="一次评审状态长度必须介于 0 和 20 之间")
	public String getYcpszt() {
		return ycpszt;
	}

	/**
     * 一次评审状态
     */
	public void setYcpszt(String ycpszt) {
		this.ycpszt = ycpszt == null ? null : ycpszt.trim();
	}
	
	/**
     * 美工确认（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMgqryq() {
		return mgqryq;
	}

	/**
     * 美工确认（要求）
     */
	public void setMgqryq(Date mgqryq) {
		this.mgqryq = mgqryq;
	}
	
	/**
     * 美工确认（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMgqrjh() {
		return mgqrjh;
	}

	/**
     * 美工确认（计划）
     */
	public void setMgqrjh(Date mgqrjh) {
		this.mgqrjh = mgqrjh;
	}
	
	/**
     * 美工确认
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMgqr() {
		return mgqr;
	}

	/**
     * 美工确认
     */
	public void setMgqr(Date mgqr) {
		this.mgqr = mgqr;
	}
	
	/**
     * 美工确认状态
     */
	@Length(min=0, max=20, message="美工确认状态长度必须介于 0 和 20 之间")
	public String getMgqrzt() {
		return mgqrzt;
	}

	/**
     * 美工确认状态
     */
	public void setMgqrzt(String mgqrzt) {
		this.mgqrzt = mgqrzt == null ? null : mgqrzt.trim();
	}
	
	/**
     * 订单转工单（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDdzgdyq() {
		return ddzgdyq;
	}

	/**
     * 订单转工单（要求）
     */
	public void setDdzgdyq(Date ddzgdyq) {
		this.ddzgdyq = ddzgdyq;
	}
	
	/**
     * 订单转工单（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDdzgdjh() {
		return ddzgdjh;
	}

	/**
     * 订单转工单（计划）
     */
	public void setDdzgdjh(Date ddzgdjh) {
		this.ddzgdjh = ddzgdjh;
	}
	
	/**
     * 订单转工单
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDdzgd() {
		return ddzgd;
	}

	/**
     * 订单转工单
     */
	public void setDdzgd(Date ddzgd) {
		this.ddzgd = ddzgd;
	}
	
	/**
     * 订单转工单状态
     */
	@Length(min=0, max=20, message="订单转工单状态长度必须介于 0 和 20 之间")
	public String getDdzgdzt() {
		return ddzgdzt;
	}

	/**
     * 订单转工单状态
     */
	public void setDdzgdzt(String ddzgdzt) {
		this.ddzgdzt = ddzgdzt == null ? null : ddzgdzt.trim();
	}
	
	/**
     * 软件确认（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRjqryq() {
		return rjqryq;
	}

	/**
     * 软件确认（要求）
     */
	public void setRjqryq(Date rjqryq) {
		this.rjqryq = rjqryq;
	}
	
	/**
     * 软件确认（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRjqrjh() {
		return rjqrjh;
	}

	/**
     * 软件确认（计划）
     */
	public void setRjqrjh(Date rjqrjh) {
		this.rjqrjh = rjqrjh;
	}
	
	/**
     * 软件确认
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRjqr() {
		return rjqr;
	}

	/**
     * 软件确认
     */
	public void setRjqr(Date rjqr) {
		this.rjqr = rjqr;
	}
	
	/**
     * 软件确认状态
     */
	@Length(min=0, max=20, message="软件确认状态长度必须介于 0 和 20 之间")
	public String getRjqrzt() {
		return rjqrzt;
	}

	/**
     * 软件确认状态
     */
	public void setRjqrzt(String rjqrzt) {
		this.rjqrzt = rjqrzt == null ? null : rjqrzt.trim();
	}
	
	/**
     * 预走货创建（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYzhcjyq() {
		return yzhcjyq;
	}

	/**
     * 预走货创建（要求）
     */
	public void setYzhcjyq(Date yzhcjyq) {
		this.yzhcjyq = yzhcjyq;
	}
	
	/**
     * 预走货创建（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYzhcjjh() {
		return yzhcjjh;
	}

	/**
     * 预走货创建（计划）
     */
	public void setYzhcjjh(Date yzhcjjh) {
		this.yzhcjjh = yzhcjjh;
	}
	
	/**
     * 预走货创建
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYzhcj() {
		return yzhcj;
	}

	/**
     * 预走货创建
     */
	public void setYzhcj(Date yzhcj) {
		this.yzhcj = yzhcj;
	}
	
	/**
     * 预走货创建状态
     */
	@Length(min=0, max=20, message="预走货创建状态长度必须介于 0 和 20 之间")
	public String getYzhcjzt() {
		return yzhcjzt;
	}

	/**
     * 预走货创建状态
     */
	public void setYzhcjzt(String yzhcjzt) {
		this.yzhcjzt = yzhcjzt == null ? null : yzhcjzt.trim();
	}
	
	/**
     * 预走货完成（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYzhwcyq() {
		return yzhwcyq;
	}

	/**
     * 预走货完成（要求）
     */
	public void setYzhwcyq(Date yzhwcyq) {
		this.yzhwcyq = yzhwcyq;
	}
	
	/**
     * 预走货完成（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYzhwcjh() {
		return yzhwcjh;
	}

	/**
     * 预走货完成（计划）
     */
	public void setYzhwcjh(Date yzhwcjh) {
		this.yzhwcjh = yzhwcjh;
	}
	
	/**
     * 预走货完成
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYzhwc() {
		return yzhwc;
	}

	/**
     * 预走货完成
     */
	public void setYzhwc(Date yzhwc) {
		this.yzhwc = yzhwc;
	}
	
	/**
     * 预走货完成状态
     */
	@Length(min=0, max=20, message="预走货完成状态长度必须介于 0 和 20 之间")
	public String getYzhwczt() {
		return yzhwczt;
	}

	/**
     * 预走货完成状态
     */
	public void setYzhwczt(String yzhwczt) {
		this.yzhwczt = yzhwczt == null ? null : yzhwczt.trim();
	}
	
	/**
     * 入库（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRkyq() {
		return rkyq;
	}

	/**
     * 入库（要求）
     */
	public void setRkyq(Date rkyq) {
		this.rkyq = rkyq;
	}
	
	/**
     * 入库（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRkjh() {
		return rkjh;
	}

	/**
     * 入库（计划）
     */
	public void setRkjh(Date rkjh) {
		this.rkjh = rkjh;
	}
	
	/**
     * 入库
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRk() {
		return rk;
	}

	/**
     * 入库
     */
	public void setRk(Date rk) {
		this.rk = rk;
	}
	
	/**
     * 入库状态
     */
	@Length(min=0, max=20, message="入库状态长度必须介于 0 和 20 之间")
	public String getRkzt() {
		return rkzt;
	}

	/**
     * 入库状态
     */
	public void setRkzt(String rkzt) {
		this.rkzt = rkzt == null ? null : rkzt.trim();
	}
	
	/**
     * 出库（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCkyq() {
		return ckyq;
	}

	/**
     * 出库（要求）
     */
	public void setCkyq(Date ckyq) {
		this.ckyq = ckyq;
	}
	
	/**
     * 出库（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCkjh() {
		return ckjh;
	}

	/**
     * 出库（计划）
     */
	public void setCkjh(Date ckjh) {
		this.ckjh = ckjh;
	}
	
	/**
     * 出库
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCk() {
		return ck;
	}

	/**
     * 出库
     */
	public void setCk(Date ck) {
		this.ck = ck;
	}
	
	/**
     * 出库状态
     */
	@Length(min=0, max=20, message="出库状态长度必须介于 0 和 20 之间")
	public String getCkzt() {
		return ckzt;
	}

	/**
     * 出库状态
     */
	public void setCkzt(String ckzt) {
		this.ckzt = ckzt == null ? null : ckzt.trim();
	}
	
	/**
     * 报关（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBgyq() {
		return bgyq;
	}

	/**
     * 报关（要求）
     */
	public void setBgyq(Date bgyq) {
		this.bgyq = bgyq;
	}
	
	/**
     * 报关（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBgjh() {
		return bgjh;
	}

	/**
     * 报关（计划）
     */
	public void setBgjh(Date bgjh) {
		this.bgjh = bgjh;
	}
	
	/**
     * 报关
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBg() {
		return bg;
	}

	/**
     * 报关
     */
	public void setBg(Date bg) {
		this.bg = bg;
	}
	
	/**
     * 报关状态
     */
	@Length(min=0, max=20, message="报关状态长度必须介于 0 和 20 之间")
	public String getBgzt() {
		return bgzt;
	}

	/**
     * 报关状态
     */
	public void setBgzt(String bgzt) {
		this.bgzt = bgzt == null ? null : bgzt.trim();
	}
	
	/**
     * 出运（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCyyq() {
		return cyyq;
	}

	/**
     * 出运（要求）
     */
	public void setCyyq(Date cyyq) {
		this.cyyq = cyyq;
	}
	
	/**
     * 出运（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCyjh() {
		return cyjh;
	}

	/**
     * 出运（计划）
     */
	public void setCyjh(Date cyjh) {
		this.cyjh = cyjh;
	}
	
	/**
     * 出运
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCy() {
		return cy;
	}

	/**
     * 出运
     */
	public void setCy(Date cy) {
		this.cy = cy;
	}
	
	/**
     * 出运状态
     */
	@Length(min=0, max=20, message="出运状态长度必须介于 0 和 20 之间")
	public String getCyzt() {
		return cyzt;
	}

	/**
     * 出运状态
     */
	public void setCyzt(String cyzt) {
		this.cyzt = cyzt == null ? null : cyzt.trim();
	}
	
	/**
     * 散件收货（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSjshyq() {
		return sjshyq;
	}

	/**
     * 散件收货（要求）
     */
	public void setSjshyq(Date sjshyq) {
		this.sjshyq = sjshyq;
	}
	
	/**
     * 散件收货（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSjshjh() {
		return sjshjh;
	}

	/**
     * 散件收货（计划）
     */
	public void setSjshjh(Date sjshjh) {
		this.sjshjh = sjshjh;
	}
	
	/**
     * 散件收货
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSjsh() {
		return sjsh;
	}

	/**
     * 散件收货
     */
	public void setSjsh(Date sjsh) {
		this.sjsh = sjsh;
	}
	
	/**
     * 散件收货状态
     */
	@Length(min=0, max=20, message="散件收货状态长度必须介于 0 和 20 之间")
	public String getSjshzt() {
		return sjshzt;
	}

	/**
     * 散件收货状态
     */
	public void setSjshzt(String sjshzt) {
		this.sjshzt = sjshzt == null ? null : sjshzt.trim();
	}
	
	/**
     * 整机收货（要求）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZjshyq() {
		return zjshyq;
	}

	/**
     * 整机收货（要求）
     */
	public void setZjshyq(Date zjshyq) {
		this.zjshyq = zjshyq;
	}
	
	/**
     * 整机收货（计划）
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZjshjh() {
		return zjshjh;
	}

	/**
     * 整机收货（计划）
     */
	public void setZjshjh(Date zjshjh) {
		this.zjshjh = zjshjh;
	}
	
	/**
     * 整机收货
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZjsh() {
		return zjsh;
	}

	/**
     * 整机收货
     */
	public void setZjsh(Date zjsh) {
		this.zjsh = zjsh;
	}
	
	/**
     * 整机收货状态
     */
	@Length(min=0, max=20, message="整机收货状态长度必须介于 0 和 20 之间")
	public String getZjshzt() {
		return zjshzt;
	}

	/**
     * 整机收货状态
     */
	public void setZjshzt(String zjshzt) {
		this.zjshzt = zjshzt == null ? null : zjshzt.trim();
	}
	
	public String getBeginXd() {
		return beginXd;
	}

	public void setBeginXd(String beginXd) {
		this.beginXd = beginXd;
	}
	
	public String getEndXd() {
		return endXd;
	}

	public void setEndXd(String endXd) {
		this.endXd = endXd;
	}
		
	public String getBeginJhrq() {
		return beginJhrq;
	}

	public void setBeginJhrq(String beginJhrq) {
		this.beginJhrq = beginJhrq;
	}
	
	public String getEndJhrq() {
		return endJhrq;
	}

	public void setEndJhrq(String endJhrq) {
		this.endJhrq = endJhrq;
	}
		
	public Date getBeginCyyq() {
		return beginCyyq;
	}

	public void setBeginCyyq(Date beginCyyq) {
		this.beginCyyq = beginCyyq;
	}
	
	public Date getEndCyyq() {
		return endCyyq;
	}

	public void setEndCyyq(Date endCyyq) {
		this.endCyyq = endCyyq;
	}
		
}