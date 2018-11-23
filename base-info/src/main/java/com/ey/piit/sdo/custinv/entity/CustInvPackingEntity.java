package com.ey.piit.sdo.custinv.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * @author: 魏诚
 * @Date: 2018年7月5日
 * @Description: 客户发票箱单表 T_CUSTINV_PACKING ENTITY
 */
public class CustInvPackingEntity extends BaseEntity {
	private String fph; // 发票号
	private String guino; // 柜号
	private String gxnam;//柜型
	private String ftno; // 封条号
	private String kbno; // 卡板号
	private String boxno; // 箱编号
	private String chdh; // 出货单号
	private String ddid; // 订单号
	private String wlbh; // 物料编号
	private String wlms; // 物料描述
	private String khxh; // 客户型号
	private Double dgjz; // 单个净重
	private Integer sfqty; // 实发数
	private String dw; // 单位
	private Integer ddqty; // 订单数=实发数-1%备损数
	private Integer bsqty; // 1%备损数
	private Double dj; // 单价
	private Double ddje; // 订单金额
	private Double bsje; // 备损金额
	private String gszjh; // 创维组件号
	private String gszjms; // 创维组件描述
	private Integer gszjsl; // 创维组件数量
	private Integer dxsl; // 单箱数量
	private Double zxmz; // 单箱毛重
	private Double zxjz; // 单箱净重
	private Integer zxnum; // 箱数
	private Double zxzmz; // 箱总毛重
	private Double zxzjz; // 箱总净重
	private Double zxC; // 纸箱长cm
	private Double zxK; // 纸箱宽cm
	private Double zxG; // 纸箱高cm
	private Double kbC; // 卡板长cm
	private Double kbK; // 卡板宽cm
	private Double kbG; // 卡板高cm
	private Integer kbnum; // 卡板数
	private Double kbwet; // 每卡板重量
	private Double kbzwet; // 卡板总重量
	private Double sumzv; // 总体积（如果无卡板取箱子总体积，有卡板取卡板总体积）
	private String ycgj; // 原产国家
	private String pono; // p.o.no.
	private String gysmc; // 供应商名称
	private String khlh; // 客户料号
	private String khms; // 客户描述
	private String hscode; // hs code
	private String zgdsn;

	private String erdat;//     varchar2(20)   y         排序使用
	private String ertim;//     varchar2(20)   y         排序使用
	private String chdat;//     varchar2(20)   y         排序使用
	private String cftno;//     varchar2(50)   y         排序使用
	
	public CustInvPackingEntity() {
		super();
	}

	public CustInvPackingEntity(String id) {
		super(id);
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
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

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getWlbh() {
		return wlbh;
	}

	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}

	public String getWlms() {
		return wlms;
	}

	public void setWlms(String wlms) {
		this.wlms = wlms;
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

	public Integer getSfqty() {
		return sfqty;
	}

	public void setSfqty(Integer sfqty) {
		this.sfqty = sfqty;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public Integer getDdqty() {
		return ddqty;
	}

	public void setDdqty(Integer ddqty) {
		this.ddqty = ddqty;
	}

	public Integer getBsqty() {
		return bsqty;
	}

	public void setBsqty(Integer bsqty) {
		this.bsqty = bsqty;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
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

	public Integer getGszjsl() {
		return gszjsl;
	}

	public void setGszjsl(Integer gszjsl) {
		this.gszjsl = gszjsl;
	}

	public Integer getDxsl() {
		return dxsl;
	}

	public void setDxsl(Integer dxsl) {
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

	public Double getZxzmz() {
		return zxzmz;
	}

	public void setZxzmz(Double zxzmz) {
		this.zxzmz = zxzmz;
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

	public Integer getKbnum() {
		return kbnum;
	}

	public void setKbnum(Integer kbnum) {
		this.kbnum = kbnum;
	}

	public Double getKbwet() {
		return kbwet;
	}

	public void setKbwet(Double kbwet) {
		this.kbwet = kbwet;
	}

	public Double getKbzwet() {
		return kbzwet;
	}

	public void setKbzwet(Double kbzwet) {
		this.kbzwet = kbzwet;
	}

	public Double getSumzv() {
		return sumzv;
	}

	public void setSumzv(Double sumzv) {
		this.sumzv = sumzv;
	}

	public String getYcgj() {
		return ycgj;
	}

	public void setYcgj(String ycgj) {
		this.ycgj = ycgj;
	}

	public String getPono() {
		return pono;
	}

	public void setPono(String pono) {
		this.pono = pono;
	}

	public String getGysmc() {
		return gysmc;
	}

	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}

	public String getKhlh() {
		return khlh;
	}

	public void setKhlh(String khlh) {
		this.khlh = khlh;
	}

	public String getKhms() {
		return khms;
	}

	public void setKhms(String khms) {
		this.khms = khms;
	}

	public String getHscode() {
		return hscode;
	}

	public void setHscode(String hscode) {
		this.hscode = hscode;
	}

	public String getZgdsn() {
		return zgdsn;
	}

	public void setZgdsn(String zgdsn) {
		this.zgdsn = zgdsn;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public String getGxnam() {
		return gxnam;
	}

	public void setGxnam(String gxnam) {
		this.gxnam = gxnam;
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
