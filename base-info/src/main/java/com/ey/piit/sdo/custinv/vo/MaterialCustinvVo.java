package com.ey.piit.sdo.custinv.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author: junc
 * @date: 2018年7月9日  下午4:17:00
 * @Description:发票箱单明细拉取加载
 */
public class MaterialCustinvVo{
	private String p_chdh;//   varchar2, --出货单号
    private String p_ddid;//   varchar2, --订单号
	public String getP_chdh() {
		return p_chdh;
	}
	public void setP_chdh(String p_chdh) {
		this.p_chdh = p_chdh;
	}
	public String getP_ddid() {
		return p_ddid;
	}
	public void setP_ddid(String p_ddid) {
		this.p_ddid = p_ddid;
	}
	private String fph;//a.fph,
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date fprq;    //发票日期 --
	private String gsbm;//a.gsbm, 
	private String gszwmc;//gs.gszwmc, 
	private String gsywmc;//gs.gsywmc, 
	private String gsdz;//gs.gsywdz gsdz, 
	private String khbm;//a.khbm, 
	private String khmc;//a.khmc, 
	private String khdh;//kh.dh khdh, 
	private String khdz;//kh.dz khdz,
	private String shfmc;//c.shfmc, 
	private String shfdz;//c.shfdz, 
	private String shfdh;//c.shfdh, 
	private String shdmc;//c.shfmc shdmc, 
	private String shddz;//c.shfdz shddz, 
	private String shddh;//c.shfdh shddh, 
	private String qygmc;//a.qygmc, 
	private String mdg;//a.mdg;//, 
	private String mytk;//b.mytk, 
	private String mytkmc;//b.mytkmc,
	private String fktj;//c.fktj,
	private String fktjmc;//c.fktjmc,
	private String cmhc;//a.cm||a.hc cmhc,
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date qyrq;//a.yjkcq qyrq,
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date yjdgq;//a.yjdgq,
	private String zhfs;//b.zhfs,
	private String zhfsmc;//b.zhfsmc,
	private String cylx;//a.cylx,
	private String cylxmc;//a.cylxmc
	
	private String skyhzh;
	private String skyhmc;
	private String skyhdz;
	private String skyhdm;
	private String syr;//, e.
	private String syrdz;
	
	
	
	
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
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
	public String getQygmc() {
		return qygmc;
	}
	public void setQygmc(String qygmc) {
		this.qygmc = qygmc;
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
	public String getSkyhzh() {
		return skyhzh;
	}
	public void setSkyhzh(String skyhzh) {
		this.skyhzh = skyhzh;
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
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}
	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}
}
