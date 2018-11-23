package com.ey.piit.interfaces.order.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * 订单通知书 接口传输实体 
 * 说明 ：请注意实体属性的顺序，不能随意调整，SAP解析报文依赖报文字段顺序
 * @author denghai
 *
 */
@XStreamAlias("HEAD")
public class OrderZZHeaderDto {
	@XStreamAlias("UPDATE")
	private String update = "";//操作类型
	@XStreamAlias("XSZZDM")
	private String xszzdm = "";//销售组织代码
	@XStreamAlias("YWZ")
	private String ywz = "";//业务组
	@XStreamAlias("XSDDH")
	private String xsddh = "";//销售订单号
	@XStreamAlias("DDLX")
	private String ddlx = "";//订单类型
	@XStreamAlias("ZHFS")
	private String zhfs = "";//走货方式
	@XStreamAlias("XSZZ")
	private String xszz = "";//销售组织
	@XStreamAlias("FXQD")
	private String fxqd = "";//分销渠道
	@XStreamAlias("CPZ")
	private String cpz = "";//SAP产品组 SDO订单类型
	@XStreamAlias("KHBM")
	private String khbm = "";//客户编码
	@XStreamAlias("XWGJ")
	private String xwgj = "";//销往国家
	@XStreamAlias("XSY")
	private String xsy = "";//销售员
	@XStreamAlias("DDH")
	private String ddh = "";//订单号
	@XStreamAlias("FKTJ")
	private String fktj = "";//付款条件
	@XStreamAlias("GJMYTK")
	private String gjmytk = "";//国际贸易条款
	@XStreamAlias("GJMYTKBZ")
	private String gjmytkbz = "";//国际贸易条款备注
	@XStreamAlias("DDBM")
	private String ddbm = "";//订单编码
	@XStreamAlias("RZ")
	private String rz = "";//认证1认证2认证3
	@XStreamAlias("JHRQ")
	private String jhrq = "";//交货日期
	@XStreamAlias("MJXH")
	private String mjxh = "";//买家型号
	@XStreamAlias("DDLB")
	private String ddlb = "";//订单类别
	@XStreamAlias("PP")
	private String pp = "";//品牌
	@XStreamAlias("HWKH")
	/*@XStreamOmitField*/
	private String hwkh = "";//海外客户
	@XStreamAlias("BZ")
	private String bz = "";//币种
	@XStreamAlias("TSDDFL")
	private String tsddfl = "";//特殊订单分类（当为模组CKD订单时，传Z001，其他则传空值）
	@XStreamAlias("GLDDH")
	private String glddh = "";//关联订单号
	@XStreamAlias("MGRWD")
	private String mgrwd = "";//美工任务单
	
	@XStreamAlias("PID")
	private String pid = "";//PID
	@XStreamAlias("DHSL")
	private Integer dhsl = 0;//大货数量
	@XStreamAlias("JGFS")
	private String jgfs = "";//加工方式
	@XStreamAlias("ZBB1")
	private String zbb1 = "";//走货码+版本号+标识号1
	@XStreamAlias("ZBB2")
	private String zbb2 = "";//走货码+版本号+标识号2
	@XStreamAlias("PBM")
	private String pbm = "";//屏编码
	@XStreamAlias("PBZYQ")
	private String pbzyq = "";//屏包装要求
	@XStreamAlias("PBZYQBZ")
	private String pbzyqbz = "";//屏包装要求备注
	@XStreamAlias("PLDXX")
	private String pldxx = "";//屏亮点选项
	@XStreamAlias("BHM")
	private String bhm = "";//屏是否需要保护膜
	@XStreamAlias("HFBS")
	private String hfbs = "";//是否付费备损
	@XStreamAlias("MFBS")
	private String mfbs = "";//免费备损
	@XStreamAlias("MFBSBL")
	private String mfbsbl = "";//免费备损比例
	@XStreamAlias("BSBZ")
	private String bsbz = "";//备损包装
	@XStreamAlias("BSBZBZ")
	private String bsbzbz = "";//备损包装备注
	@XStreamAlias("GDBSZG")
	private String gdbszg = "";//跟单备损料走柜
	@XStreamAlias("BSTX")
	private String bstx = "";//备损备注
	
	@XStreamOmitField 
    //忽略标签
	private String sfwx = "";//是否外协-用于样机订单
    @XStreamOmitField 
    //忽略标签
	private String pdddlb = "";//订单类别，用于多元化订单判断，只有多元化屏才需要推送到制造；
                               //判断备损订单，免费市场物料、收费市场物料、工装物料时，不需要推送到制造
    @XStreamOmitField 
    //忽略标签
	private Integer sfCzz = 0;//是否传制造 字段，用于判断是否需要传制造SAP
	
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getXszzdm() {
		return xszzdm;
	}
	public void setXszzdm(String xszzdm) {
		this.xszzdm = xszzdm;
	}
	public String getYwz() {
		return ywz;
	}
	public void setYwz(String ywz) {
		this.ywz = ywz;
	}
	public String getDdlx() {
		return ddlx;
	}
	public void setDdlx(String ddlx) {
		this.ddlx = ddlx;
	}
	public String getZhfs() {
		return zhfs;
	}
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs;
	}
	public String getXszz() {
		return xszz;
	}
	public void setXszz(String xszz) {
		this.xszz = xszz;
	}
	public String getFxqd() {
		return fxqd;
	}
	public void setFxqd(String fxqd) {
		this.fxqd = fxqd;
	}
	public String getCpz() {
		return cpz;
	}
	public void setCpz(String cpz) {
		this.cpz = cpz;
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getXwgj() {
		return xwgj;
	}
	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}
	public String getXsy() {
		return xsy;
	}
	public void setXsy(String xsy) {
		this.xsy = xsy;
	}
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getXsddh() {
		return xsddh;
	}
	public void setXsddh(String xsddh) {
		this.xsddh = xsddh;
	}
	public String getFktj() {
		return fktj;
	}
	public void setFktj(String fktj) {
		this.fktj = fktj;
	}
	public String getGjmytk() {
		return gjmytk;
	}
	public void setGjmytk(String gjmytk) {
		this.gjmytk = gjmytk;
	}
	public String getGjmytkbz() {
		return gjmytkbz;
	}
	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz;
	}
	public String getDdbm() {
		return ddbm;
	}
	public void setDdbm(String ddbm) {
		this.ddbm = ddbm;
	}
	public String getRz() {
		return rz;
	}
	public void setRz(String rz) {
		this.rz = rz;
	}
	public String getJhrq() {
		return jhrq;
	}
	public void setJhrq(String jhrq) {
		this.jhrq = jhrq;
	}
	public String getMjxh() {
		return mjxh;
	}
	public void setMjxh(String mjxh) {
		this.mjxh = mjxh;
	}
	public String getDdlb() {
		return ddlb;
	}
	public void setDdlb(String ddlb) {
		this.ddlb = ddlb;
	}
	public String getPp() {
		return pp;
	}
	public void setPp(String pp) {
		this.pp = pp;
	}
	public String getSfwx() {
		return sfwx;
	}
	public void setSfwx(String sfwx) {
		this.sfwx = sfwx;
	}
	public String getPdddlb() {
		return pdddlb;
	}
	public void setPdddlb(String pdddlb) {
		this.pdddlb = pdddlb;
	}
	public String getHwkh() {
		return hwkh;
	}
	public void setHwkh(String hwkh) {
		this.hwkh = hwkh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Integer getSfCzz() {
		return sfCzz;
	}
	public void setSfCzz(Integer sfCzz) {
		this.sfCzz = sfCzz;
	}
	public String getTsddfl() {
		return tsddfl;
	}
	public void setTsddfl(String tsddfl) {
		this.tsddfl = tsddfl;
	}
	public String getGlddh() {
		return glddh;
	}
	public void setGlddh(String glddh) {
		this.glddh = glddh;
	}
	public String getMgrwd() {
		return mgrwd;
	}
	public void setMgrwd(String mgrwd) {
		this.mgrwd = mgrwd;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Integer getDhsl() {
		return dhsl;
	}
	public void setDhsl(Integer dhsl) {
		this.dhsl = dhsl;
	}
	public String getJgfs() {
		return jgfs;
	}
	public void setJgfs(String jgfs) {
		this.jgfs = jgfs;
	}
	public String getZbb1() {
		return zbb1;
	}
	public void setZbb1(String zbb1) {
		this.zbb1 = zbb1;
	}
	public String getZbb2() {
		return zbb2;
	}
	public void setZbb2(String zbb2) {
		this.zbb2 = zbb2;
	}
	public String getPbm() {
		return pbm;
	}
	public void setPbm(String pbm) {
		this.pbm = pbm;
	}
	public String getPbzyq() {
		return pbzyq;
	}
	public void setPbzyq(String pbzyq) {
		this.pbzyq = pbzyq;
	}
	public String getPbzyqbz() {
		return pbzyqbz;
	}
	public void setPbzyqbz(String pbzyqbz) {
		this.pbzyqbz = pbzyqbz;
	}
	public String getPldxx() {
		return pldxx;
	}
	public void setPldxx(String pldxx) {
		this.pldxx = pldxx;
	}
	public String getBhm() {
		return bhm;
	}
	public void setBhm(String bhm) {
		this.bhm = bhm;
	}
	public String getHfbs() {
		return hfbs;
	}
	public void setHfbs(String hfbs) {
		this.hfbs = hfbs;
	}
	public String getMfbs() {
		return mfbs;
	}
	public void setMfbs(String mfbs) {
		this.mfbs = mfbs;
	}
	public String getMfbsbl() {
		return mfbsbl;
	}
	public void setMfbsbl(String mfbsbl) {
		this.mfbsbl = mfbsbl;
	}
	public String getBsbz() {
		return bsbz;
	}
	public void setBsbz(String bsbz) {
		this.bsbz = bsbz;
	}
	public String getBsbzbz() {
		return bsbzbz;
	}
	public void setBsbzbz(String bsbzbz) {
		this.bsbzbz = bsbzbz;
	}
	public String getGdbszg() {
		return gdbszg;
	}
	public void setGdbszg(String gdbszg) {
		this.gdbszg = gdbszg;
	}
	public String getBstx() {
		return bstx;
	}
	public void setBstx(String bstx) {
		this.bstx = bstx;
	}

}
