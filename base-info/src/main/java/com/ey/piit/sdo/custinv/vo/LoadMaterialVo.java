package com.ey.piit.sdo.custinv.vo;
/**
 * 
 * @author: junc
 * @date: 2018年7月9日  下午5:21:46
 * @Description: 物料信息
 *
 */
public class LoadMaterialVo {
	private String p_chdh;//  varchar2, --出货通知书单号
    private String p_ddid;//  varchar2, --订单id
    private String p_guino;//  varchar2, --柜号
    private String p_xtlb;//  varchar2, --系统类别
    private String p_zwpm;//  varchar2, --中文品名
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
	public String getP_xtlb() {
		return p_xtlb;
	}
	public void setP_xtlb(String p_xtlb) {
		this.p_xtlb = p_xtlb;
	}
	public String getP_zwpm() {
		return p_zwpm;
	}
	public void setP_zwpm(String p_zwpm) {
		this.p_zwpm = p_zwpm;
	}
	public String getP_guino() {
		return p_guino;
	}
	public void setP_guino(String p_guino) {
		this.p_guino = p_guino;
	}
	private String chdh;//b.chdno chdh, 
	private String ddid;// b.vbeln ddid, 
	private String dcno;//b.dcno, 
	private String guino;//b.guino, 
	private String ftno;//b.ftno, 
	private String gxnam;//b.gxnam, 
	private String wlbh;//b.matnr wlbh, 
	private String khlh;//b.kmatnr khlh, 
	private String wlms;// b.maktx wlms, 
	private Double sfqty;//b.sfqty, 
	private Integer boxnum;//b.boxnum, 
	private Integer kbnum;//b.kbnum,
	private Double kbzwet;//b.kbzwet, 
	private Double zxzmz;//b.mzwet zxzmz, 
	private String zwpm;//b.cpmna zwpm, 
	private String xtlb;//b.ztype xtlb,
	private Double sumzv;//case when nvl(trim(b.kbno),'' '') = '' '' then b.boxpv else b.kbzv end sumzv,
	
	private String jixing;//d.jixing, 
	private String hscode;//b.hscode, 
	private Double sl;//b.sfqty sl, 
	private String dw;//b.meins dw, 
	private Double zxzwet;//b.jzwet zxzwet, 
	private Double dj;//b.pmoney dj, 
	private Double je;//b.zmoney je, 
	private String khms;//b.pmaktx khms, 
	private String gysmc;//b.egname gysmc, 
	private String gysdz;//b.egaddr gysdz, 
	private String ycgj;//b.ycgj, 
	private String kbno;//b.kbno, 
	private String boxno;//b.boxno, 
	private String khxh;//b.ktype khxh, 
	private Double dgjz;//b.perwet dgjz, 
	private Double ddqty;//(b.sfqty-to_number(trim(b.foc01))) ddqty,
	private Double bsqty;//to_number(trim(b.foc01)) bsqty, 
	private Double ddje;//((b.sfqty-to_number(trim(b.foc01)))*b.pmoney) ddje, 
	private Double bsje;//(to_number(trim(b.foc01))*b.pmoney) bsje, 
	private String gszjh;//b.gszjh, 
	private String gszjms;//b.gszjm gszjms, 
	private Double gszjsl;//b.gszjs gszjsl, 
	private Double dxsl;//b.boxqty dxsl, 
	private Double zxmz;//b.mpwet zxmz, 
	private Double zxjz;//b.jpwet zxjz, 
	private Integer zxnum;//b.boxnum zxnum, 
	private Double zxzjz;//b.jzwet zxzjz, 
	private Double zxC;//b.boxl zx_c, 
	private Double zxK;//b.boxw zx_k, 
	private Double zxG;//b.boxh zx_g, 
	private Double kbC;//b.kbl kb_c, 
	private Double kbK;//b.kbw kb_k, 
	private Double kbG;//b.kbh kb_g, 
	private Double kbwet;//b.kbpwet kbwet, 
	private String pono;//b.polote pono
	private String zgdsn;//b.zgdsn
	
	private String erdat;
	private String ertim;
	private String chdat;
	private String cftno;
	public String getChdh() {
		return chdh;
	}
	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public String getDcno() {
		return dcno;
	}
	public void setDcno(String dcno) {
		this.dcno = dcno;
	}
	public String getGuino() {
		return guino;
	}
	public void setGuino(String guino) {
		this.guino = guino;
	}
	public String getFtno() {
		return ftno;
	}
	public void setFtno(String ftno) {
		this.ftno = ftno;
	}
	public String getGxnam() {
		return gxnam;
	}
	public void setGxnam(String gxnam) {
		this.gxnam = gxnam;
	}
	public String getWlbh() {
		return wlbh;
	}
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}
	public String getKhlh() {
		return khlh;
	}
	public void setKhlh(String khlh) {
		this.khlh = khlh;
	}
	public String getWlms() {
		return wlms;
	}
	public void setWlms(String wlms) {
		this.wlms = wlms;
	}
	public Double getSfqty() {
		return sfqty;
	}
	public void setSfqty(Double sfqty) {
		this.sfqty = sfqty;
	}
	public Integer getBoxnum() {
		return boxnum;
	}
	public void setBoxnum(Integer boxnum) {
		this.boxnum = boxnum;
	}
	public Integer getKbnum() {
		return kbnum;
	}
	public void setKbnum(Integer kbnum) {
		this.kbnum = kbnum;
	}
	public Double getKbzwet() {
		return kbzwet;
	}
	public void setKbzwet(Double kbzwet) {
		this.kbzwet = kbzwet;
	}
	public Double getZxzmz() {
		return zxzmz;
	}
	public void setZxzmz(Double zxzmz) {
		this.zxzmz = zxzmz;
	}
	public String getZwpm() {
		return zwpm;
	}
	public void setZwpm(String zwpm) {
		this.zwpm = zwpm;
	}
	public String getXtlb() {
		return xtlb;
	}
	public void setXtlb(String xtlb) {
		this.xtlb = xtlb;
	}
	public Double getSumzv() {
		return sumzv;
	}
	public void setSumzv(Double sumzv) {
		this.sumzv = sumzv;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public String getHscode() {
		return hscode;
	}
	public void setHscode(String hscode) {
		this.hscode = hscode;
	}
	public Double getSl() {
		return sl;
	}
	public void setSl(Double sl) {
		this.sl = sl;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public Double getZxzwet() {
		return zxzwet;
	}
	public void setZxzwet(Double zxzwet) {
		this.zxzwet = zxzwet;
	}
	public Double getDj() {
		return dj;
	}
	public void setDj(Double dj) {
		this.dj = dj;
	}
	public Double getJe() {
		return je;
	}
	public void setJe(Double je) {
		this.je = je;
	}
	public String getKhms() {
		return khms;
	}
	public void setKhms(String khms) {
		this.khms = khms;
	}
	public String getGysmc() {
		return gysmc;
	}
	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}
	public String getGysdz() {
		return gysdz;
	}
	public void setGysdz(String gysdz) {
		this.gysdz = gysdz;
	}
	public String getYcgj() {
		return ycgj;
	}
	public void setYcgj(String ycgj) {
		this.ycgj = ycgj;
	}
	public String getKbno() {
		return kbno;
	}
	public void setKbno(String kbno) {
		this.kbno = kbno;
	}
	public String getBoxno() {
		return boxno;
	}
	public void setBoxno(String boxno) {
		this.boxno = boxno;
	}
	public String getKhxh() {
		return khxh;
	}
	public void setKhxh(String khxh) {
		this.khxh = khxh;
	}
	public Double getDgjz() {
		return dgjz;
	}
	public void setDgjz(Double dgjz) {
		this.dgjz = dgjz;
	}
	public Double getDdqty() {
		return ddqty;
	}
	public void setDdqty(Double ddqty) {
		this.ddqty = ddqty;
	}
	public Double getBsqty() {
		return bsqty;
	}
	public void setBsqty(Double bsqty) {
		this.bsqty = bsqty;
	}
	public Double getDdje() {
		return ddje;
	}
	public void setDdje(Double ddje) {
		this.ddje = ddje;
	}
	public Double getBsje() {
		return bsje;
	}
	public void setBsje(Double bsje) {
		this.bsje = bsje;
	}
	public String getGszjh() {
		return gszjh;
	}
	public void setGszjh(String gszjh) {
		this.gszjh = gszjh;
	}
	public String getGszjms() {
		return gszjms;
	}
	public void setGszjms(String gszjms) {
		this.gszjms = gszjms;
	}
	public Double getGszjsl() {
		return gszjsl;
	}
	public void setGszjsl(Double gszjsl) {
		this.gszjsl = gszjsl;
	}
	public Double getDxsl() {
		return dxsl;
	}
	public void setDxsl(Double dxsl) {
		this.dxsl = dxsl;
	}
	public Double getZxmz() {
		return zxmz;
	}
	public void setZxmz(Double zxmz) {
		this.zxmz = zxmz;
	}
	public Double getZxjz() {
		return zxjz;
	}
	public void setZxjz(Double zxjz) {
		this.zxjz = zxjz;
	}
	public Integer getZxnum() {
		return zxnum;
	}
	public void setZxnum(Integer zxnum) {
		this.zxnum = zxnum;
	}
	public Double getZxzjz() {
		return zxzjz;
	}
	public void setZxzjz(Double zxzjz) {
		this.zxzjz = zxzjz;
	}
	
	public Double getZxC() {
		return zxC;
	}
	public void setZxC(Double zxC) {
		this.zxC = zxC;
	}
	public Double getZxK() {
		return zxK;
	}
	public void setZxK(Double zxK) {
		this.zxK = zxK;
	}
	public Double getZxG() {
		return zxG;
	}
	public void setZxG(Double zxG) {
		this.zxG = zxG;
	}
	public Double getKbC() {
		return kbC;
	}
	public void setKbC(Double kbC) {
		this.kbC = kbC;
	}
	public Double getKbK() {
		return kbK;
	}
	public void setKbK(Double kbK) {
		this.kbK = kbK;
	}
	public Double getKbG() {
		return kbG;
	}
	public void setKbG(Double kbG) {
		this.kbG = kbG;
	}
	public Double getKbwet() {
		return kbwet;
	}
	public void setKbwet(Double kbwet) {
		this.kbwet = kbwet;
	}
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public String getZgdsn() {
		return zgdsn;
	}
	public void setZgdsn(String zgdsn) {
		this.zgdsn = zgdsn;
	}
	public String getErdat() {
		return erdat;
	}
	public void setErdat(String erdat) {
		this.erdat = erdat;
	}
	public String getErtim() {
		return ertim;
	}
	public void setErtim(String ertim) {
		this.ertim = ertim;
	}
	public String getChdat() {
		return chdat;
	}
	public void setChdat(String chdat) {
		this.chdat = chdat;
	}
	public String getCftno() {
		return cftno;
	}
	public void setCftno(String cftno) {
		this.cftno = cftno;
	}
	
}
