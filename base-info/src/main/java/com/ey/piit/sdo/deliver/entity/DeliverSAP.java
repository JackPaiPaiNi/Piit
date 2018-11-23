package com.ey.piit.sdo.deliver.entity;
import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SAP中间表 箱单明细查询
 * @author tianrong
 */
public class DeliverSAP extends BaseEntity {

	private Integer serino; //行号
	private String fph; //发票号
	private String mxlx; //出库明细类型
	private String chdh; //出货单号
	private String ddid; //订单号
	private String jhdh; //交货单号
	private String jhdhxmh; //交货单行项目号
	private Date zgrq; //装柜日期
	private String pono; //P.O.NO.
	private String potype; //PO-TYPE
	private String kbh; //卡板号
	private String gx; //柜型
	private String gh; //柜号
	private Double pz; //皮重KG
	private String fth; //封条号
	private String xh; //箱号
	private Double xs; //箱数
	private String jixing; //型号
	private String jixin; //机芯
	private String khxhms; //客户型号
	private String spms; //商品描述
	private String wllb; //物料类别
	private String wlbh; //物料编号
	private String wlmsYw; //物料描述（英文）
	private String wlmsZw; //物料描述（中文）
	private String wlmsKhyy; //物料描述（客户语言）
	private String khlh; //客户料号
	private Double mxsl; //每箱数量
	private Double moq; //MOQ最小包装量
	private String dw; //单位
	private BigDecimal dj; //单价（RMB）
	private Double zsl; //总数量
	private BigDecimal zje; //总金额
	private Double dhsl; //大货数量
	private BigDecimal dhje; //大货金额
	private Double mfsl; //免费数量
	private BigDecimal mfje; //免费金额
	private Double zxC; //纸箱长CM
	private Double zxK; //纸箱宽CM
	private Double zxG; //纸箱高CM
	private Double dgzl; //单个重量（净重）KG
	private Double djzmx; //单净重/箱KG
	private Double dmzmx; //单毛重/箱KG
	private Double zjz; //净重（总）KG
	private Double zmz; //毛重（总）KG
	private Double mkbmz; //每卡板毛重TTL GW
	private Double kbC; //卡板长CM
	private Double kbK; //卡板宽CM
	private Double kbG; //卡板高CM
	private Double kbtj; //卡板体积
	private String gysdm; //供应商代码
	private String gysmc; //供应商名称
	private String gysdz; //供应商地址
	private String ycgj; //原产国家
	private String khhgbm; //客户海关编码
	private String khhgbmms; //客户海关编码描述
	private String sjc; //时间戳
	private Integer scbj; //删除标记 1已删除 null未删除
	private Double zkbzl; //总卡板重量KG
	private int zt;//发票状态
	private String ztmc;//发票状态
	
	public DeliverSAP() {
		super();
	}

	public DeliverSAP(String id){
		super(id);
	}
	
	public Integer getSerino() {
		return serino;
	}
	public void setSerino(Integer serino) {
		this.serino = serino;
	}
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public String getMxlx() {
		return mxlx;
	}
	public void setMxlx(String mxlx) {
		this.mxlx = mxlx;
	}
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
	public String getJhdh() {
		return jhdh;
	}
	public void setJhdh(String jhdh) {
		this.jhdh = jhdh;
	}
	public String getJhdhxmh() {
		return jhdhxmh;
	}
	public void setJhdhxmh(String jhdhxmh) {
		this.jhdhxmh = jhdhxmh;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZgrq() {
		return zgrq;
	}
	public void setZgrq(Date zgrq) {
		this.zgrq = zgrq;
	}
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public String getPotype() {
		return potype;
	}
	public void setPotype(String potype) {
		this.potype = potype;
	}
	public String getKbh() {
		return kbh;
	}
	public void setKbh(String kbh) {
		this.kbh = kbh;
	}
	public String getGx() {
		return gx;
	}
	public void setGx(String gx) {
		this.gx = gx;
	}
	public String getGh() {
		return gh;
	}
	public void setGh(String gh) {
		this.gh = gh;
	}
	public Double getPz() {
		return pz;
	}
	public void setPz(Double pz) {
		this.pz = pz;
	}
	public String getFth() {
		return fth;
	}
	public void setFth(String fth) {
		this.fth = fth;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public Double getXs() {
		return xs;
	}
	public void setXs(Double xs) {
		this.xs = xs;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public String getJixin() {
		return jixin;
	}
	public void setJixin(String jixin) {
		this.jixin = jixin;
	}
	public String getKhxhms() {
		return khxhms;
	}
	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms;
	}
	public String getSpms() {
		return spms;
	}
	public void setSpms(String spms) {
		this.spms = spms;
	}
	public String getWllb() {
		return wllb;
	}
	public void setWllb(String wllb) {
		this.wllb = wllb;
	}
	public String getWlbh() {
		return wlbh;
	}
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}
	public String getWlmsYw() {
		return wlmsYw;
	}
	public void setWlmsYw(String wlmsYw) {
		this.wlmsYw = wlmsYw;
	}
	public String getWlmsZw() {
		return wlmsZw;
	}
	public void setWlmsZw(String wlmsZw) {
		this.wlmsZw = wlmsZw;
	}
	public String getWlmsKhyy() {
		return wlmsKhyy;
	}
	public void setWlmsKhyy(String wlmsKhyy) {
		this.wlmsKhyy = wlmsKhyy;
	}
	public String getKhlh() {
		return khlh;
	}
	public void setKhlh(String khlh) {
		this.khlh = khlh;
	}
	public Double getMxsl() {
		return mxsl;
	}
	public void setMxsl(Double mxsl) {
		this.mxsl = mxsl;
	}
	public Double getMoq() {
		return moq;
	}
	public void setMoq(Double moq) {
		this.moq = moq;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public BigDecimal getDj() {
		return dj;
	}
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	public Double getZsl() {
		return zsl;
	}
	public void setZsl(Double zsl) {
		this.zsl = zsl;
	}
	public BigDecimal getZje() {
		return zje;
	}
	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}
	public Double getDhsl() {
		return dhsl;
	}
	public void setDhsl(Double dhsl) {
		this.dhsl = dhsl;
	}
	public BigDecimal getDhje() {
		return dhje;
	}
	public void setDhje(BigDecimal dhje) {
		this.dhje = dhje;
	}
	public Double getMfsl() {
		return mfsl;
	}
	public void setMfsl(Double mfsl) {
		this.mfsl = mfsl;
	}
	public BigDecimal getMfje() {
		return mfje;
	}
	public void setMfje(BigDecimal mfje) {
		this.mfje = mfje;
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
	public Double getDgzl() {
		return dgzl;
	}
	public void setDgzl(Double dgzl) {
		this.dgzl = dgzl;
	}
	public Double getDjzmx() {
		return djzmx;
	}
	public void setDjzmx(Double djzmx) {
		this.djzmx = djzmx;
	}
	public Double getDmzmx() {
		return dmzmx;
	}
	public void setDmzmx(Double dmzmx) {
		this.dmzmx = dmzmx;
	}
	public Double getZjz() {
		return zjz;
	}
	public void setZjz(Double zjz) {
		this.zjz = zjz;
	}
	public Double getZmz() {
		return zmz;
	}
	public void setZmz(Double zmz) {
		this.zmz = zmz;
	}
	public Double getMkbmz() {
		return mkbmz;
	}
	public void setMkbmz(Double mkbmz) {
		this.mkbmz = mkbmz;
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
	public Double getKbtj() {
		return kbtj;
	}
	public void setKbtj(Double kbtj) {
		this.kbtj = kbtj;
	}
	public String getGysdm() {
		return gysdm;
	}
	public void setGysdm(String gysdm) {
		this.gysdm = gysdm;
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
	public String getKhhgbm() {
		return khhgbm;
	}
	public void setKhhgbm(String khhgbm) {
		this.khhgbm = khhgbm;
	}
	public String getKhhgbmms() {
		return khhgbmms;
	}
	public void setKhhgbmms(String khhgbmms) {
		this.khhgbmms = khhgbmms;
	}
	public String getSjc() {
		return sjc;
	}
	public void setSjc(String sjc) {
		this.sjc = sjc;
	}
	public Integer getScbj() {
		return scbj;
	}
	public void setScbj(Integer scbj) {
		this.scbj = scbj;
	}
	public Double getZkbzl() {
		return zkbzl;
	}
	public void setZkbzl(Double zkbzl) {
		this.zkbzl = zkbzl;
	}

	public int getZt() {
		return zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
	
	
	
}