package com.ey.piit.sdo.order.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 备损订单管理Entity
 * @author 魏诚
 */
public class OrderSpo extends BaseEntity {
	
	private String ddid;		// 订单号
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private String ddlx;		// 订单类型
	private String ddlxmc;		// 订单类型名称
	private String ddlb;		// 订单类别
	private String ddlbmc;		// 订单类别名称
	private String ywlx;		// 业务类型
	private String ywlxmc;		// 业务类型名称
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String ywz;		// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String bz;		// 币种
	private String fktj;		// 付款条件
	private String fktjmc;		// 付款条件名称
	private String gjmytk;		// 国际贸易条款
	private String gjmytkmc;		// 国际贸易条款名称
	private String gjmytkbz;		// 国际贸易条款备注
	private Integer zsl;		// 总数量
	private BigDecimal zje;		// 总金额
	private String cylx;		// 出运类型
	private String cylxmc;		// 出运类型名称
	private Date jhrq;		// 交货日期
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String xwgj;		// 销往国家
	private String xwgjmc;		// 销往国家名称
	private Integer sfMf;		// 是否免费
	private String zrhf;		// 责任划分
	private String zrhfmc;		// 责任划分名称
	private String ksbh;		// 客诉编号
	private String zyg;		// 装运/起运港
	private String zygmc;		// 装运/起运港名称
	private String zygbz;		// 装运/起运港备注
	private String fycdbm;		// 费用承担部门
	private String fycdbmmc;		// 费用承担部门名称
	private String fj;		// 附件
	private String mfblyy;		// 免费补料原因
	private String bzxx;		// 备注信息
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Integer zt;		// 状态
	private String ztmc;	//状态名称
	private Integer bbh;		// 版本号
	private String sjc;		// 时间戳
	private Integer fkbzzt;		// 付款保障状态
	private Integer tssapzt;		// 推送SAP状态
	private String beginZdsj;		// 开始 制单时间
	private String endZdsj;		// 结束 制单时间
	private String  scjd;           //生产基地
	private String  scjdmc;           //生产基地
	private String yddid;//原订单号
	private String bgbz;   //变更备注
	private Integer sfFjelbg;   //是否非金额类变更
	private Integer sfCzz;//是否传制造SAP
	private String qd;	//渠道
	private String qdmc;	//渠道名称
	private Integer  sfCh; //是否撤回标记
	private BigDecimal yzhje;	//已走货金额
	private String gcbfj;		// 工程部附件
	private String dsjlx;
	private String dsjlxmc;
	
	public String getQd() {
		return qd;
	}

	public void setQd(String qd) {
		this.qd = qd;
	}

	public String getQdmc() {
		return qdmc;
	}

	public void setQdmc(String qdmc) {
		this.qdmc = qdmc;
	}

	public Integer getSfCh() {
		return sfCh;
	}

	public void setSfCh(Integer sfCh) {
		this.sfCh = sfCh;
	}

	public Integer getSfCzz() {
		return sfCzz;
	}

	public void setSfCzz(Integer sfCzz) {
		this.sfCzz = sfCzz;
	}

	public Integer getSfFjelbg() {
		return sfFjelbg;
	}

	public void setSfFjelbg(Integer sfFjelbg) {
		this.sfFjelbg = sfFjelbg;
	}

	public String getBgbz() {
		return bgbz;
	}

	public void setBgbz(String bgbz) {
		this.bgbz = bgbz;
	}

	public String getScjd() {
		return scjd;
	}

	public void setScjd(String scjd) {
		this.scjd = scjd;
	}

	public String getScjdmc() {
		return scjdmc;
	}

	public void setScjdmc(String scjdmc) {
		this.scjdmc = scjdmc;
	}

	public OrderSpo() {
		super();
	}

	public OrderSpo(String id){
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
     * 公司编码
     */
	@Length(min=1, max=20, message="公司编码长度必须介于 1 和 20 之间")
	public String getGsbm() {
		return gsbm;
	}

	/**
     * 公司编码
     */
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm == null ? null : gsbm.trim();
	}
	
	/**
     * 公司名称
     */
	@Length(min=0, max=100, message="公司名称长度必须介于 0 和 100 之间")
	public String getGsmc() {
		return gsmc;
	}

	/**
     * 公司名称
     */
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc == null ? null : gsmc.trim();
	}
	
	/**
     * 订单类型
     */
	@Length(min=1, max=50, message="订单类型长度必须介于 1 和 50 之间")
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
	@Length(min=1, max=50, message="订单类别长度必须介于 1 和 50 之间")
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
     * 业务类型
     */
	@Length(min=1, max=50, message="业务类型长度必须介于 1 和 50 之间")
	public String getYwlx() {
		return ywlx;
	}

	/**
     * 业务类型
     */
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx == null ? null : ywlx.trim();
	}
	
	/**
     * 业务类型名称
     */
	@Length(min=0, max=50, message="业务类型名称长度必须介于 0 和 50 之间")
	public String getYwlxmc() {
		return ywlxmc;
	}

	/**
     * 业务类型名称
     */
	public void setYwlxmc(String ywlxmc) {
		this.ywlxmc = ywlxmc == null ? null : ywlxmc.trim();
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
     * 业务组
     */
	@Length(min=0, max=50, message="业务组长度必须介于 0 和 50 之间")
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
     * 销售组织
     */
	@Length(min=0, max=50, message="销售组织长度必须介于 0 和 50 之间")
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
     * 币种
     */
	@Length(min=0, max=50, message="币种长度必须介于 0 和 50 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 币种
     */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}
	
	/**
     * 付款条件
     */
	@Length(min=0, max=50, message="付款条件长度必须介于 0 和 50 之间")
	public String getFktj() {
		return fktj;
	}

	/**
     * 付款条件
     */
	public void setFktj(String fktj) {
		this.fktj = fktj == null ? null : fktj.trim();
	}
	
	/**
     * 付款条件名称
     */
	@Length(min=0, max=50, message="付款条件名称长度必须介于 0 和 50 之间")
	public String getFktjmc() {
		return fktjmc;
	}

	/**
     * 付款条件名称
     */
	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc == null ? null : fktjmc.trim();
	}
	
	/**
     * 国际贸易条款
     */
	@Length(min=0, max=100, message="国际贸易条款长度必须介于 0 和 100 之间")
	public String getGjmytk() {
		return gjmytk;
	}

	/**
     * 国际贸易条款
     */
	public void setGjmytk(String gjmytk) {
		this.gjmytk = gjmytk == null ? null : gjmytk.trim();
	}
	
	/**
     * 国际贸易条款名称
     */
	@Length(min=0, max=50, message="国际贸易条款名称长度必须介于 0 和 50 之间")
	public String getGjmytkmc() {
		return gjmytkmc;
	}

	/**
     * 国际贸易条款名称
     */
	public void setGjmytkmc(String gjmytkmc) {
		this.gjmytkmc = gjmytkmc == null ? null : gjmytkmc.trim();
	}
	
	/**
     * 国际贸易条款备注
     */
	@Length(min=0, max=50, message="国际贸易条款备注长度必须介于 0 和 50 之间")
	public String getGjmytkbz() {
		return gjmytkbz;
	}

	/**
     * 国际贸易条款备注
     */
	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz == null ? null : gjmytkbz.trim();
	}
	
	/**
     * 总数量
     */
	public Integer getZsl() {
		return zsl;
	}

	/**
     * 总数量
     */
	public void setZsl(Integer zsl) {
		this.zsl = zsl;
	}

	/**
     * 总金额
     */
	public BigDecimal getZje() {
		return zje;
	}

	/**
     * 总金额
     */
	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}
	
	/**
     * 出运类型
     */
	@Length(min=0, max=50, message="出运类型长度必须介于 0 和 50 之间")
	public String getCylx() {
		return cylx;
	}

	/**
     * 出运类型
     */
	public void setCylx(String cylx) {
		this.cylx = cylx == null ? null : cylx.trim();
	}
	
	/**
     * 出运类型名称
     */
	@Length(min=0, max=50, message="出运类型名称长度必须介于 0 和 50 之间")
	public String getCylxmc() {
		return cylxmc;
	}

	/**
     * 出运类型名称
     */
	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc == null ? null : cylxmc.trim();
	}
	
	/**
     * 交货日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
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
     * 销往国家
     */
	@Length(min=0, max=50, message="销往国家长度必须介于 0 和 50 之间")
	public String getXwgj() {
		return xwgj;
	}

	/**
     * 销往国家
     */
	public void setXwgj(String xwgj) {
		this.xwgj = xwgj == null ? null : xwgj.trim();
	}
	
	/**
     * 销往国家名称
     */
	@Length(min=0, max=50, message="销往国家名称长度必须介于 0 和 50 之间")
	public String getXwgjmc() {
		return xwgjmc;
	}

	/**
     * 销往国家名称
     */
	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc == null ? null : xwgjmc.trim();
	}
	
	/**
     * 是否免费
     */
	public Integer getSfMf() {
		return sfMf;
	}

	/**
     * 是否免费
     */
	public void setSfMf(Integer sfMf) {
		this.sfMf = sfMf;
	}
	
	/**
     * 责任划分
     */
	@Length(min=0, max=20, message="责任划分长度必须介于 0 和 20 之间")
	public String getZrhf() {
		return zrhf;
	}

	/**
     * 责任划分
     */
	public void setZrhf(String zrhf) {
		this.zrhf = zrhf == null ? null : zrhf.trim();
	}
	
	/**
     * 责任划分名称
     */
	@Length(min=0, max=50, message="责任划分名称长度必须介于 0 和 50 之间")
	public String getZrhfmc() {
		return zrhfmc;
	}

	/**
     * 责任划分名称
     */
	public void setZrhfmc(String zrhfmc) {
		this.zrhfmc = zrhfmc == null ? null : zrhfmc.trim();
	}
	
	/**
     * 客诉编号
     */
	@Length(min=0, max=20, message="客诉编号长度必须介于 0 和 20 之间")
	public String getKsbh() {
		return ksbh;
	}

	/**
     * 客诉编号
     */
	public void setKsbh(String ksbh) {
		this.ksbh = ksbh == null ? null : ksbh.trim();
	}
	
	/**
     * 装运/起运港
     */
	@Length(min=0, max=50, message="装运/起运港长度必须介于 0 和 50 之间")
	public String getZyg() {
		return zyg;
	}

	/**
     * 装运/起运港
     */
	public void setZyg(String zyg) {
		this.zyg = zyg == null ? null : zyg.trim();
	}
	
	/**
     * 装运/起运港名称
     */
	@Length(min=0, max=50, message="装运/起运港名称长度必须介于 0 和 50 之间")
	public String getZygmc() {
		return zygmc;
	}

	/**
     * 装运/起运港名称
     */
	public void setZygmc(String zygmc) {
		this.zygmc = zygmc == null ? null : zygmc.trim();
	}
	
	/**
     * 装运/起运港备注
     */
	@Length(min=0, max=50, message="装运/起运港备注长度必须介于 0 和 50 之间")
	public String getZygbz() {
		return zygbz;
	}

	/**
     * 装运/起运港备注
     */
	public void setZygbz(String zygbz) {
		this.zygbz = zygbz == null ? null : zygbz.trim();
	}
	
	/**
     * 费用承担部门
     */
	@Length(min=0, max=50, message="费用承担部门长度必须介于 0 和 50 之间")
	public String getFycdbm() {
		return fycdbm;
	}

	/**
     * 费用承担部门
     */
	public void setFycdbm(String fycdbm) {
		this.fycdbm = fycdbm == null ? null : fycdbm.trim();
	}
	
	/**
     * 费用承担部门名称
     */
	@Length(min=0, max=50, message="费用承担部门名称长度必须介于 0 和 50 之间")
	public String getFycdbmmc() {
		return fycdbmmc;
	}

	/**
     * 费用承担部门名称
     */
	public void setFycdbmmc(String fycdbmmc) {
		this.fycdbmmc = fycdbmmc == null ? null : fycdbmmc.trim();
	}
	
	/**
     * 附件
     */
	@Length(min=0, max=100, message="附件长度必须介于 0 和 100 之间")
	public String getFj() {
		return fj;
	}

	/**
     * 附件
     */
	public void setFj(String fj) {
		this.fj = fj == null ? null : fj.trim();
	}
	
	/**
     * 免费补料原因
     */
	@Length(min=0, max=20, message="免费补料原因长度必须介于 0 和 20 之间")
	public String getMfblyy() {
		return mfblyy;
	}

	/**
     * 免费补料原因
     */
	public void setMfblyy(String mfblyy) {
		this.mfblyy = mfblyy == null ? null : mfblyy.trim();
	}
	
	/**
     * 备注信息
     */
	@Length(min=0, max=200, message="备注信息长度必须介于 0 和 200 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
     * 备注信息
     */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
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
	@Length(min=1, max=50, message="制单人名称长度必须介于 1 和 50 之间")
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
	
	/**
     * 状态
     */
	@NotNull(message="状态不能为空")
	public Integer getZt() {
		return zt;
	}

	/**
     * 状态
     */
	public void setZt(Integer zt) {
		this.zt = zt;
	}
	
	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
	
	/**
     * 版本号
     */
	@NotNull(message="版本号不能为空")
	public Integer getBbh() {
		return bbh;
	}

	/**
     * 版本号
     */
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	
	/**
     * 时间戳
     */
	@Length(min=1, max=20, message="时间戳长度必须介于 1 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
     * 时间戳
     */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
	}
	
	/**
     * 付款保障状态
     */
	public Integer getFkbzzt() {
		return fkbzzt;
	}

	/**
     * 付款保障状态
     */
	public void setFkbzzt(Integer fkbzzt) {
		this.fkbzzt = fkbzzt;
	}
	
	/**
     * 推送SAP状态
     */
	public Integer getTssapzt() {
		return tssapzt;
	}

	/**
     * 推送SAP状态
     */
	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
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
	
	public String getYddid() {
		return yddid;
	}

	public void setYddid(String yddid) {
		this.yddid = yddid;
	}

	public BigDecimal getYzhje() {
		return yzhje;
	}

	public void setYzhje(BigDecimal yzhje) {
		this.yzhje = yzhje;
	}

	public String getGcbfj() {
		return gcbfj;
	}

	public void setGcbfj(String gcbfj) {
		this.gcbfj = gcbfj;
	}

	public String getDsjlx() {
		return dsjlx;
	}

	public void setDsjlx(String dsjlx) {
		this.dsjlx = dsjlx;
	}

	public String getDsjlxmc() {
		return dsjlxmc;
	}

	public void setDsjlxmc(String dsjlxmc) {
		this.dsjlxmc = dsjlxmc;
	}
	
}