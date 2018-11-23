package com.ey.piit.sdo.shipmentplan.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.sdo.shipmentplan.entity.ShipmentPlan;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 走货计划Entity
 * @author tianrong
 */
public class ShipmentPlanVo extends ShipmentPlan implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2638513458973549359L;
	
	private String yzhdh;		// 预走货单号
	private String yzhlx;		// 预走货类型
	private String yzhlxmc;		// 预走货类型名称
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String xsyid;		// 销售代码（销售员）
	private String xsymc;		// 销售员名称
	private String ywz;		    // 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 业务部门（销售组织）
	private String xszzmc;		// 业务部门（销售组织名称）
	private String mytk;		// 贸易条款
	private String mytkmc;		// 贸易条款名称
	private Date zgsj;		    // 装柜时间
	private Integer yg20gp;		// 用柜-20GP
	private Integer yg40gp;		// 用柜-40GP
	private Integer yg40hq;		// 用柜-40HQ
	private String cylx;		// 出运类型
	private String cylxmc;		// 出运类型名称
	private String qyg;		    // 起运港
	private String qygmc;		// 起运港名称
	private String mdg;		    // 目的港
	private String xwgj;		// 销往国家
	private String xwgjmc;		// 销往国家名称
	private String xszcid;		// 预走货申请人：销售支持
	private String xszcmc;		// 预走货申请人名称：销售支持
	private Integer zt;		    // 状态
	private String ztmc;		    // 状态
	private Integer bbh;		    // 版本号
	private String cwzyid;		// 船务专员
	private String cwzymc;		// 船务专员名称
	private String hwgyl;		// 海外供应链
	private String hwgylmc;		// 海外供应链名称）
	private String ztyzhdh;		// 主体预走货单号

	private String ddid; // 订单号
	private String jixing; // 我司型号
	private String khxhms; // 客户型号
	private Double cc; // 尺寸
	private String zhfs; // 走货方式
	private String zhfsmc; // 走货方式名称
	private String chfl; // 出货分类
	private String chflmc; // 出货分类名称
	private String pp; // 品牌
	private String mfjsl; // 免费机数量
	private String sl; // 数量
	private String sjsl; // 散件数量
	private String bz; // 币种
	private BigDecimal dj; // 单价
	private BigDecimal je; // 金额
	private String spmc; // 商品名称
	
	private String chzt;//出货状态
	
	private String szgsj;//装柜时间
	private String ezgsj;//装柜时间
	private String sjgq;//截关期
	private String ejgq;//截关期
	private String sjvgm;//截VGM
	private String ejvgm;//截VGM
	private String sjsi;//截SI
	private String ejsi;//截SI
	private String syjkcq;//预计开船期
	private String eyjkcq;//预计开船期
	

	public ShipmentPlanVo() {
		super();
	}

	public ShipmentPlanVo(String id){
		super(id);
	}

	/**
     * 预走货单号
     */
	@Length(min=1, max=20, message="预走货单号长度必须介于 1 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	/**
     * 预走货单号
     */
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh == null ? null : yzhdh.trim();
	}
	
	/**
     * 预走货类型
     */
	@Length(min=0, max=20, message="预走货类型长度必须介于 0 和 20 之间")
	public String getYzhlx() {
		return yzhlx;
	}

	/**
     * 预走货类型
     */
	public void setYzhlx(String yzhlx) {
		this.yzhlx = yzhlx == null ? null : yzhlx.trim();
	}
	
	/**
     * 预走货类型名称
     */
	@Length(min=0, max=50, message="预走货类型名称长度必须介于 0 和 50 之间")
	public String getYzhlxmc() {
		return yzhlxmc;
	}

	/**
     * 预走货类型名称
     */
	public void setYzhlxmc(String yzhlxmc) {
		this.yzhlxmc = yzhlxmc == null ? null : yzhlxmc.trim();
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
     * 客户编码
     */
	@Length(min=1, max=20, message="客户编码长度必须介于 1 和 20 之间")
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
     * 销售代码（销售员）
     */
	@Length(min=1, max=20, message="销售代码（销售员）长度必须介于 1 和 20 之间")
	public String getXsyid() {
		return xsyid;
	}

	/**
     * 销售代码（销售员）
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
     * 业务部门（销售组织）
     */
	@Length(min=1, max=20, message="业务部门（销售组织）长度必须介于 1 和 20 之间")
	public String getXszz() {
		return xszz;
	}

	/**
     * 业务部门（销售组织）
     */
	public void setXszz(String xszz) {
		this.xszz = xszz == null ? null : xszz.trim();
	}
	
	/**
     * 业务部门（销售组织名称）
     */
	@Length(min=0, max=50, message="业务部门（销售组织名称）长度必须介于 0 和 50 之间")
	public String getXszzmc() {
		return xszzmc;
	}

	/**
     * 业务部门（销售组织名称）
     */
	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc == null ? null : xszzmc.trim();
	}
	
	/**
     * 贸易条款
     */
	@Length(min=0, max=20, message="贸易条款长度必须介于 0 和 20 之间")
	public String getMytk() {
		return mytk;
	}

	/**
     * 贸易条款
     */
	public void setMytk(String mytk) {
		this.mytk = mytk == null ? null : mytk.trim();
	}
	
	/**
     * 贸易条款名称
     */
	@Length(min=0, max=50, message="贸易条款名称长度必须介于 0 和 50 之间")
	public String getMytkmc() {
		return mytkmc;
	}

	/**
     * 贸易条款名称
     */
	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc == null ? null : mytkmc.trim();
	}
	
	/**
     * 装柜时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZgsj() {
		return zgsj;
	}

	/**
     * 装柜时间
     */
	public void setZgsj(Date zgsj) {
		this.zgsj = zgsj;
	}
	
	/**
     * 用柜-20GP
     */
	public Integer getYg20gp() {
		return yg20gp;
	}

	/**
     * 用柜-20GP
     */
	public void setYg20gp(Integer yg20gp) {
		this.yg20gp = yg20gp;
	}
	
	/**
     * 用柜-40GP
     */
	public Integer getYg40gp() {
		return yg40gp;
	}

	/**
     * 用柜-40GP
     */
	public void setYg40gp(Integer yg40gp) {
		this.yg40gp = yg40gp;
	}
	
	/**
     * 用柜-40HQ
     */
	public Integer getYg40hq() {
		return yg40hq;
	}

	/**
     * 用柜-40HQ
     */
	public void setYg40hq(Integer yg40hq) {
		this.yg40hq = yg40hq;
	}
	
	/**
     * 出运类型
     */
	@Length(min=0, max=20, message="出运类型长度必须介于 0 和 20 之间")
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
     * 起运港
     */
	@Length(min=0, max=20, message="起运港长度必须介于 0 和 20 之间")
	public String getQyg() {
		return qyg;
	}

	/**
     * 起运港
     */
	public void setQyg(String qyg) {
		this.qyg = qyg == null ? null : qyg.trim();
	}
	
	/**
     * 起运港名称
     */
	@Length(min=0, max=50, message="起运港名称长度必须介于 0 和 50 之间")
	public String getQygmc() {
		return qygmc;
	}

	/**
     * 起运港名称
     */
	public void setQygmc(String qygmc) {
		this.qygmc = qygmc == null ? null : qygmc.trim();
	}
	
	/**
     * 目的港
     */
	@Length(min=0, max=100, message="目的港长度必须介于 0 和 100 之间")
	public String getMdg() {
		return mdg;
	}

	/**
     * 目的港
     */
	public void setMdg(String mdg) {
		this.mdg = mdg == null ? null : mdg.trim();
	}
	
	/**
     * 销往国家
     */
	@Length(min=0, max=20, message="销往国家长度必须介于 0 和 20 之间")
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
	
	public String getXszcid() {
		return xszcid;
	}

	public void setXszcid(String xszcid) {
		this.xszcid = xszcid;
	}

	public String getXszcmc() {
		return xszcmc;
	}

	public void setXszcmc(String xszcmc) {
		this.xszcmc = xszcmc;
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

	/**
     * 船务专员
     */
	@Length(min=1, max=20, message="船务专员长度必须介于 1 和 20 之间")
	public String getCwzyid() {
		return cwzyid;
	}

	/**
     * 船务专员
     */
	public void setCwzyid(String cwzyid) {
		this.cwzyid = cwzyid == null ? null : cwzyid.trim();
	}
	
	/**
     * 船务专员名称
     */
	@Length(min=0, max=50, message="船务专员名称长度必须介于 0 和 50 之间")
	public String getCwzymc() {
		return cwzymc;
	}

	/**
     * 船务专员名称
     */
	public void setCwzymc(String cwzymc) {
		this.cwzymc = cwzymc == null ? null : cwzymc.trim();
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public String getKhxhms() {
		return khxhms;
	}

	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms;
	}

	public Double getCc() {
		return cc;
	}

	public void setCc(Double cc) {
		this.cc = cc;
	}

	public String getZhfs() {
		return zhfs;
	}

	public void setZhfs(String zhfs) {
		this.zhfs = zhfs;
	}

	public String getZhfsmc() {
		return zhfsmc;
	}

	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}

	public String getChfl() {
		return chfl;
	}

	public void setChfl(String chfl) {
		this.chfl = chfl;
	}

	public String getChflmc() {
		return chflmc;
	}

	public void setChflmc(String chflmc) {
		this.chflmc = chflmc;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
	
	public String getSzgsj() {
		return szgsj;
	}

	public void setSzgsj(String szgsj) {
		this.szgsj = szgsj;
	}

	public String getEzgsj() {
		return ezgsj;
	}

	public void setEzgsj(String ezgsj) {
		this.ezgsj = ezgsj;
	}

	public String getSjgq() {
		return sjgq;
	}

	public void setSjgq(String sjgq) {
		this.sjgq = sjgq;
	}

	public String getEjgq() {
		return ejgq;
	}

	public void setEjgq(String ejgq) {
		this.ejgq = ejgq;
	}

	public String getSjvgm() {
		return sjvgm;
	}

	public void setSjvgm(String sjvgm) {
		this.sjvgm = sjvgm;
	}

	public String getEjvgm() {
		return ejvgm;
	}

	public void setEjvgm(String ejvgm) {
		this.ejvgm = ejvgm;
	}

	public String getSjsi() {
		return sjsi;
	}

	public void setSjsi(String sjsi) {
		this.sjsi = sjsi;
	}

	public String getEjsi() {
		return ejsi;
	}

	public void setEjsi(String ejsi) {
		this.ejsi = ejsi;
	}

	public String getSyjkcq() {
		return syjkcq;
	}

	public void setSyjkcq(String syjkcq) {
		this.syjkcq = syjkcq;
	}

	public String getEyjkcq() {
		return eyjkcq;
	}

	public void setEyjkcq(String eyjkcq) {
		this.eyjkcq = eyjkcq;
	}
	
	public String getChzt() {
		return chzt;
	}

	public void setChzt(String chzt) {
		this.chzt = chzt;
	}

	public Integer getBbh() {
		return bbh;
	}

	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}

	public String getHwgyl() {
		return hwgyl;
	}

	public void setHwgyl(String hwgyl) {
		this.hwgyl = hwgyl;
	}

	public String getHwgylmc() {
		return hwgylmc;
	}

	public void setHwgylmc(String hwgylmc) {
		this.hwgylmc = hwgylmc;
	}

	public String getZtyzhdh() {
		return ztyzhdh;
	}

	public void setZtyzhdh(String ztyzhdh) {
		this.ztyzhdh = ztyzhdh;
	}

	public String getMfjsl() {
		return mfjsl;
	}

	public void setMfjsl(String mfjsl) {
		this.mfjsl = mfjsl.equals("0")==true?"":mfjsl;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl.equals("0")==true?"":sl;
	}

	public String getSjsl() {
		return sjsl;
	}

	public void setSjsl(String sjsl) {
		this.sjsl = sjsl.equals("0")==true?"":sjsl;
	}
	
}