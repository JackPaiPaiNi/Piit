package com.ey.piit.sdo.custinv.entity;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author: 魏诚
 * @Date: 2018年7月5日
 * @Description: 客户发票主表 T_CUSTINV_REG ENTITY
 */
public class CustInvEntity extends BaseEntity {
	
	private String fph;    //发票号 --
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date fprq;    //发票日期 --
	private String gsbm;    //公司编码  --
	private String gszwmc;    //公司中文名称 --
	private String gsywmc;    //公司英文名称 --
	private String gsdz;    //公司地址 --
	private String gsdh;    //公司电话 --
	private String khbm;    //客户编码 --
	private String khmc;    //客户名称 --
	private String khdh;    //客户电话 --
	private String khdz;    //客户地址 --
	private String shfmc;    //收货方名称 --
	private String shfdz;    //收货方地址  --
	private String shfdh;    //收货方电话 --
	private String shdmc;    //收货地名称 --
	private String shddz;    //收货地地址 --
	private String shddh;    //收货地电话 --
	private String orderno;    //订单号 --
	private String qyg;    //起运港 --
	private String mdg;    //目的港 --
	private String mytk;    //贸易条款 --
	private String mytkmc;    //贸易条款名称 --
	private String fktj;    //付款条件 --
	private String fktjmc;    //付款条件名称 --
	private String cmhc;    //船名航次 --
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date qyrq;    //起运日期  --
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date yjdgq;    //预计到港期 --
	private String marks;	//Marks &Nos --
	private String ms;    //备注信息 --
	private String tdh;    //提单号 --
	private String ycgj;    //原产国家 --
	private Integer zsl;    //总数量
	private BigDecimal zje;    //总金额
	private String footer;    //发票底部描述--
	private Double deposit;    //定金 --
	private Double tobepaid;    //剩余未收款 --
	private String khpo;    //客户po  --
	private String zhfs;    //走货方式 --
	private String zhfsmc;    //走货方式名称 --
	private String cylx;    //出运类型 --
	private String cylxmc;    //出运类型名称 --
	private String skyhmc;    //收款银行名称 --
	private String skyhdz;    //收款银行地址 --
	private String skyhdm;    //收款银行代码 --
	private String skyhzh;    //收款银行账号 --
	private String syr;    //受益人 --
	private String syrdz;    //受益人地址 --
	private String fpmb;    //发票模板 --
	private String fpmbmc;    //发票模板名称 --
	private String xdmb;    //箱单模板 --
	private String xdmbmc;    //箱单模板名称 --
	private String zdrid;    //制单人id --
	private String zdrmc;    //制单人名称 --
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date zdsj;    //制单时间 --
	private Integer zt;    //状态	--
	private String sjc;    //时间戳 
	

	public CustInvEntity() {
		super();
	}

	public CustInvEntity(String id) {
		super(id);
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}

	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public String getGszwmc() {
		return gszwmc;
	}

	public void setGszwmc(String gszwmc) {
		this.gszwmc = gszwmc;
	}

	public String getGsywmc() {
		return gsywmc;
	}

	public void setGsywmc(String gsywmc) {
		this.gsywmc = gsywmc;
	}

	public String getGsdz() {
		return gsdz;
	}

	public void setGsdz(String gsdz) {
		this.gsdz = gsdz;
	}

	public String getGsdh() {
		return gsdh;
	}

	public void setGsdh(String gsdh) {
		this.gsdh = gsdh;
	}

	public String getKhbm() {
		return khbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getKhdh() {
		return khdh;
	}

	public void setKhdh(String khdh) {
		this.khdh = khdh;
	}

	public String getKhdz() {
		return khdz;
	}

	public void setKhdz(String khdz) {
		this.khdz = khdz;
	}

	public String getShfmc() {
		return shfmc;
	}

	public void setShfmc(String shfmc) {
		this.shfmc = shfmc;
	}

	public String getShfdz() {
		return shfdz;
	}

	public void setShfdz(String shfdz) {
		this.shfdz = shfdz;
	}

	public String getShfdh() {
		return shfdh;
	}

	public void setShfdh(String shfdh) {
		this.shfdh = shfdh;
	}

	public String getShdmc() {
		return shdmc;
	}

	public void setShdmc(String shdmc) {
		this.shdmc = shdmc;
	}

	public String getShddz() {
		return shddz;
	}

	public void setShddz(String shddz) {
		this.shddz = shddz;
	}

	public String getShddh() {
		return shddh;
	}

	public void setShddh(String shddh) {
		this.shddh = shddh;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getQyg() {
		return qyg;
	}

	public void setQyg(String qyg) {
		this.qyg = qyg;
	}

	public String getMdg() {
		return mdg;
	}

	public void setMdg(String mdg) {
		this.mdg = mdg;
	}

	public String getMytk() {
		return mytk;
	}

	public void setMytk(String mytk) {
		this.mytk = mytk;
	}

	public String getMytkmc() {
		return mytkmc;
	}

	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc;
	}

	public String getFktj() {
		return fktj;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}

	public String getCmhc() {
		return cmhc;
	}

	public void setCmhc(String cmhc) {
		this.cmhc = cmhc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getQyrq() {
		return qyrq;
	}

	public void setQyrq(Date qyrq) {
		this.qyrq = qyrq;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjdgq() {
		return yjdgq;
	}

	public void setYjdgq(Date yjdgq) {
		this.yjdgq = yjdgq;
	}
	public String getTdh() {
		return tdh;
	}

	public void setTdh(String tdh) {
		this.tdh = tdh;
	}

	public String getYcgj() {
		return ycgj;
	}

	public void setYcgj(String ycgj) {
		this.ycgj = ycgj;
	}

	public Integer getZsl() {
		return zsl;
	}

	public void setZsl(Integer zsl) {
		this.zsl = zsl;
	}

	
	public BigDecimal getZje() {
		return zje;
	}

	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getTobepaid() {
		return tobepaid;
	}

	public void setTobepaid(Double tobepaid) {
		this.tobepaid = tobepaid;
	}

	public String getKhpo() {
		return khpo;
	}

	public void setKhpo(String khpo) {
		this.khpo = khpo;
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

	public String getCylx() {
		return cylx;
	}

	public void setCylx(String cylx) {
		this.cylx = cylx;
	}

	public String getCylxmc() {
		return cylxmc;
	}

	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc;
	}

	public String getSkyhmc() {
		return skyhmc;
	}

	public void setSkyhmc(String skyhmc) {
		this.skyhmc = skyhmc;
	}

	public String getSkyhdz() {
		return skyhdz;
	}

	public void setSkyhdz(String skyhdz) {
		this.skyhdz = skyhdz;
	}

	public String getSkyhdm() {
		return skyhdm;
	}

	public void setSkyhdm(String skyhdm) {
		this.skyhdm = skyhdm;
	}

	public String getSkyhzh() {
		return skyhzh;
	}

	public void setSkyhzh(String skyhzh) {
		this.skyhzh = skyhzh;
	}

	public String getSyr() {
		return syr;
	}

	public void setSyr(String syr) {
		this.syr = syr;
	}

	public String getSyrdz() {
		return syrdz;
	}

	public void setSyrdz(String syrdz) {
		this.syrdz = syrdz;
	}

	public String getFpmb() {
		return fpmb;
	}

	public void setFpmb(String fpmb) {
		this.fpmb = fpmb;
	}

	public String getFpmbmc() {
		return fpmbmc;
	}

	public void setFpmbmc(String fpmbmc) {
		this.fpmbmc = fpmbmc;
	}

	public String getXdmb() {
		return xdmb;
	}

	public void setXdmb(String xdmb) {
		this.xdmb = xdmb;
	}

	public String getXdmbmc() {
		return xdmbmc;
	}

	public void setXdmbmc(String xdmbmc) {
		this.xdmbmc = xdmbmc;
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
	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
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

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}
	
}
