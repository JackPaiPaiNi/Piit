package com.ey.piit.sdo.invoice.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 商业发票维护Entity
 * @author 高文浩
 */
public class InvoiceItem extends BaseEntity {
	
	private String serino;		//行号
	private String fph;		// 发票号 父类
	private String mxlx;		// 出库明细类型
	private String chdh;		// 出货单号
	private String ddid;		// 订单号
	private String jhdh;		// 交货单号
	private String jhdhxmh;		// 交货单行项目号
	private Date zgrq;		// 装柜日期
	private String pono;		// P.O.NO.
	private String potype;		// PO-TYPE
	private String kbh;		// 卡板号
	private String gx;		// 柜型
	private String gh;		// 柜号
	private Double pz;		// 皮重KG
	private String fth;		// 封条号
	private String xh;		// 箱号
	private Double xs;		// 箱数
	private String jixing;		// 型号
	private String jixin;		// 机芯
	private String khxhms;		// 客户型号
	private String spms;		// 商品描述
	private String wllb;		// 物料类别
	private String wlbh;		// 物料编号
	private String wlmsYw;		// 物料描述（英文）
	private String wlmsZw;		// 物料描述（中文）
	private String wlmsKhyy;		// 物料描述（客户语言）
	private String khlh;		// 客户料号
	private Double mxsl;		// 每箱数量
	private Double moq;		// M.O.Q
	private String dw;		// 单位
	private BigDecimal dj;		// 单价
	private Double zsl;		// 总数量
	private BigDecimal zje;		// 总金额
	private Double dhsl;		// 大货数量
	private BigDecimal dhje;		// 大货金额
	private Double mfsl;		// 免费数量
	private BigDecimal mfje;		// 免费金额
	private Double zxC;		// 纸箱长CM
	private Double zxK;		// 纸箱宽CM
	private Double zxG;		// 纸箱高CM
	private Double dgzl;		// 单个重量（净重）KG
	private Double djzmx;		// 单净重/箱KG
	private Double dmzmx;		// 单毛重/箱KG
	private Double zjz;		// 净重（总）KG
	private Double zmz;		// 毛重（总）KG
	private Double mkbmz;		// 每卡板毛重TTL GW
	private Double kbC;		// 卡板长CM
	private Double kbK;		// 卡板宽CM
	private Double kbG;		// 卡板高CM
	private Double kbtj;		// 卡板体积
	private String gysdm;		// 供应商代码
	private String gysmc;		// 供应商名称
	private String gysdz;		// 供应商地址
	private String ycgj;		// 原产国家
	private String khhgbm;		// 客户海关编码
	private String khhgbmms;		// 客户海关编码描述
	private String sjc;			//时间戳
	
	public InvoiceItem() {
		super();
	}

	public InvoiceItem(String id){
		super(id);
	}
	
	public String getSerino() {
		return serino;
	}

	public void setSerino(String serino) {
		this.serino = serino;
	}

	/**
     * 出库明细类型
     */
	@Length(min=0, max=20, message="出库明细类型长度必须介于 0 和 20 之间")
	public String getMxlx() {
		return mxlx;
	}

	/**
     * 出库明细类型
     */
	public void setMxlx(String mxlx) {
		this.mxlx = mxlx == null ? null : mxlx.trim();
	}
	
	/**
     * 交货单号
     */
	@Length(min=0, max=20, message="交货单号长度必须介于 0 和 20 之间")
	public String getJhdh() {
		return jhdh;
	}

	/**
     * 交货单号
     */
	public void setJhdh(String jhdh) {
		this.jhdh = jhdh == null ? null : jhdh.trim();
	}
	
	/**
     * 交货单行项目号
     */
	@Length(min=0, max=20, message="交货单行项目号长度必须介于 0 和 20 之间")
	public String getJhdhxmh() {
		return jhdhxmh;
	}

	/**
     * 交货单行项目号
     */
	public void setJhdhxmh(String jhdhxmh) {
		this.jhdhxmh = jhdhxmh == null ? null : jhdhxmh.trim();
	}
	
	/**
     * 装柜日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZgrq() {
		return zgrq;
	}

	/**
     * 装柜日期
     */
	public void setZgrq(Date zgrq) {
		this.zgrq = zgrq;
	}
	
	/**
     * 发票号
     */
	@Length(min=0, max=20, message="发票号长度必须介于 0 和 20 之间")
	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}
	
	/**
     * 出货单号
     */
	@Length(min=0, max=20, message="出货单号长度必须介于 0 和 20 之间")
	public String getChdh() {
		return chdh;
	}

	/**
     * 出货单号
     */
	public void setChdh(String chdh) {
		this.chdh = chdh == null ? null : chdh.trim();
	}
	
	/**
     * 订单号
     */
	@Length(min=0, max=20, message="订单号长度必须介于 0 和 20 之间")
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
     * P.O.NO.
     */
	@Length(min=0, max=50, message="P.O.NO.长度必须介于 0 和 50 之间")
	public String getPono() {
		return pono;
	}

	/**
     * P.O.NO.
     */
	public void setPono(String pono) {
		this.pono = pono == null ? null : pono.trim();
	}
	
	/**
     * PO-TYPE
     */
	@Length(min=0, max=50, message="PO-TYPE长度必须介于 0 和 50 之间")
	public String getPotype() {
		return potype;
	}

	/**
     * PO-TYPE
     */
	public void setPotype(String potype) {
		this.potype = potype == null ? null : potype.trim();
	}

	/**
     * 卡板号
     */
	@Length(min=0, max=50, message="卡板号长度必须介于 0 和 50 之间")
	public String getKbh() {
		return kbh;
	}

	/**
     * 卡板号
     */
	public void setKbh(String kbh) {
		this.kbh = kbh == null ? null : kbh.trim();
	}
	
	/**
     * 柜型
     */
	@Length(min=0, max=50, message="柜型长度必须介于 0 和 50 之间")
	public String getGx() {
		return gx;
	}

	/**
     * 柜型
     */
	public void setGx(String gx) {
		this.gx = gx == null ? null : gx.trim();
	}
	
	/**
     * 柜号
     */
	@Length(min=0, max=50, message="柜号长度必须介于 0 和 50 之间")
	public String getGh() {
		return gh;
	}

	/**
     * 柜号
     */
	public void setGh(String gh) {
		this.gh = gh == null ? null : gh.trim();
	}
	
	/**
     * 皮重KG
     */
	public Double getPz() {
		return pz;
	}

	/**
     * 皮重KG
     */
	public void setPz(Double pz) {
		this.pz = pz;
	}
	
	/**
     * 封条号
     */
	@Length(min=0, max=50, message="封条号长度必须介于 0 和 50 之间")
	public String getFth() {
		return fth;
	}

	/**
     * 封条号
     */
	public void setFth(String fth) {
		this.fth = fth == null ? null : fth.trim();
	}
	
	/**
     * 箱号
     */
	@Length(min=0, max=50, message="箱号长度必须介于 0 和 50 之间")
	public String getXh() {
		return xh;
	}

	/**
     * 箱号
     */
	public void setXh(String xh) {
		this.xh = xh == null ? null : xh.trim();
	}
	
	/**
     * 箱数
     */
	public Double getXs() {
		return xs;
	}

	/**
     * 箱数
     */
	public void setXs(Double xs) {
		this.xs = xs;
	}
	
	/**
     * 型号
     */
	@Length(min=0, max=50, message="型号长度必须介于 0 和 50 之间")
	public String getJixing() {
		return jixing;
	}

	/**
     * 型号
     */
	public void setJixing(String jixing) {
		this.jixing = jixing == null ? null : jixing.trim();
	}
	
	/**
     * 机芯
     */
	@Length(min=0, max=50, message="机芯长度必须介于 0 和 50 之间")
	public String getJixin() {
		return jixin;
	}

	/**
     * 机芯
     */
	public void setJixin(String jixin) {
		this.jixin = jixin == null ? null : jixin.trim();
	}
	
	/**
     * 客户型号
     */
	@Length(min=0, max=50, message="客户型号长度必须介于 0 和 50 之间")
	public String getKhxhms() {
		return khxhms;
	}

	/**
     * 客户型号
     */
	public void setKhxhms(String khxhms) {
		this.khxhms = khxhms == null ? null : khxhms.trim();
	}
	
	/**
     * 商品描述
     */
	@Length(min=0, max=200, message="商品描述长度必须介于 0 和 200 之间")
	public String getSpms() {
		return spms;
	}

	/**
     * 商品描述
     */
	public void setSpms(String spms) {
		this.spms = spms == null ? null : spms.trim();
	}
	
	/**
     * 物料编号
     */
	@Length(min=0, max=50, message="物料编号长度必须介于 0 和 50 之间")
	public String getWlbh() {
		return wlbh;
	}

	/**
     * 物料编号
     */
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh == null ? null : wlbh.trim();
	}
	
	/**
     * 客户料号
     */
	@Length(min=0, max=50, message="客户料号长度必须介于 0 和 50 之间")
	public String getKhlh() {
		return khlh;
	}

	/**
     * 客户料号
     */
	public void setKhlh(String khlh) {
		this.khlh = khlh == null ? null : khlh.trim();
	}
	
	/**
     * 物料描述（英文）
     */
	@Length(min=0, max=100, message="物料描述（英文）长度必须介于 0 和 100 之间")
	public String getWlmsYw() {
		return wlmsYw;
	}

	/**
     * 物料描述（英文）
     */
	public void setWlmsYw(String wlmsYw) {
		this.wlmsYw = wlmsYw == null ? null : wlmsYw.trim();
	}
	
	/**
     * 物料描述（中文）
     */
	@Length(min=0, max=100, message="物料描述（中文）长度必须介于 0 和 100 之间")
	public String getWlmsZw() {
		return wlmsZw;
	}

	/**
     * 物料描述（中文）
     */
	public void setWlmsZw(String wlmsZw) {
		this.wlmsZw = wlmsZw == null ? null : wlmsZw.trim();
	}
	
	/**
     * 物料描述（客户语言）
     */
	@Length(min=0, max=100, message="物料描述（客户语言）长度必须介于 0 和 100 之间")
	public String getWlmsKhyy() {
		return wlmsKhyy;
	}

	/**
     * 物料描述（客户语言）
     */
	public void setWlmsKhyy(String wlmsKhyy) {
		this.wlmsKhyy = wlmsKhyy == null ? null : wlmsKhyy.trim();
	}
	
	/**
     * 每箱数量
     */
	public Double getMxsl() {
		return mxsl;
	}

	/**
     * 每箱数量
     */
	public void setMxsl(Double mxsl) {
		this.mxsl = mxsl;
	}
	
	/**
     * M.O.Q
     */
	public Double getMoq() {
		return moq;
	}

	/**
     * M.O.Q
     */
	public void setMoq(Double moq) {
		this.moq = moq;
	}
	
	/**
     * 总数量
     */
	public Double getZsl() {
		return zsl;
	}

	/**
     * 总数量
     */
	public void setZsl(Double zsl) {
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
     * 大货数量
     */
	public Double getDhsl() {
		return dhsl;
	}

	/**
     * 大货数量
     */
	public void setDhsl(Double dhsl) {
		this.dhsl = dhsl;
	}
	
	/**
     * 免费数量
     */
	public Double getMfsl() {
		return mfsl;
	}

	/**
     * 免费数量
     */
	public void setMfsl(Double mfsl) {
		this.mfsl = mfsl;
	}
	
	/**
     * 纸箱长CM
     */
	public Double getZxC() {
		return zxC;
	}

	/**
     * 纸箱长CM
     */
	public void setZxC(Double zxC) {
		this.zxC = zxC;
	}
	
	/**
     * 纸箱宽CM
     */
	public Double getZxK() {
		return zxK;
	}

	/**
     * 纸箱宽CM
     */
	public void setZxK(Double zxK) {
		this.zxK = zxK;
	}
	
	/**
     * 纸箱高CM
     */
	public Double getZxG() {
		return zxG;
	}

	/**
     * 纸箱高CM
     */
	public void setZxG(Double zxG) {
		this.zxG = zxG;
	}
	
	/**
     * 单个重量（净重）KG
     */
	public Double getDgzl() {
		return dgzl;
	}

	/**
     * 单个重量（净重）KG
     */
	public void setDgzl(Double dgzl) {
		this.dgzl = dgzl;
	}
	
	/**
     * 单净重/箱KG
     */
	public Double getDjzmx() {
		return djzmx;
	}

	/**
     * 单净重/箱KG
     */
	public void setDjzmx(Double djzmx) {
		this.djzmx = djzmx;
	}
	
	/**
     * 单毛重/箱KG
     */
	public Double getDmzmx() {
		return dmzmx;
	}

	/**
     * 单毛重/箱KG
     */
	public void setDmzmx(Double dmzmx) {
		this.dmzmx = dmzmx;
	}
	
	/**
     * 净重（总）KG
     */
	public Double getZjz() {
		return zjz;
	}

	/**
     * 净重（总）KG
     */
	public void setZjz(Double zjz) {
		this.zjz = zjz;
	}
	
	/**
     * 毛重（总）KG
     */
	public Double getZmz() {
		return zmz;
	}

	/**
     * 毛重（总）KG
     */
	public void setZmz(Double zmz) {
		this.zmz = zmz;
	}
	
	/**
     * 每卡板毛重TTL GW
     */
	public Double getMkbmz() {
		return mkbmz;
	}

	/**
     * 每卡板毛重TTL GW
     */
	public void setMkbmz(Double mkbmz) {
		this.mkbmz = mkbmz;
	}
	
	/**
     * 卡板长CM
     */
	public Double getKbC() {
		return kbC;
	}

	/**
     * 卡板长CM
     */
	public void setKbC(Double kbC) {
		this.kbC = kbC;
	}
	
	/**
     * 卡板宽CM
     */
	public Double getKbK() {
		return kbK;
	}

	/**
     * 卡板宽CM
     */
	public void setKbK(Double kbK) {
		this.kbK = kbK;
	}
	
	/**
     * 卡板高CM
     */
	public Double getKbG() {
		return kbG;
	}

	/**
     * 卡板高CM
     */
	public void setKbG(Double kbG) {
		this.kbG = kbG;
	}
	
	/**
     * 卡板体积
     */
	public Double getKbtj() {
		return kbtj;
	}

	/**
     * 卡板体积
     */
	public void setKbtj(Double kbtj) {
		this.kbtj = kbtj;
	}
	
	/**
     * 供应商代码
     */
	@Length(min=0, max=20, message="供应商代码长度必须介于 0 和 20 之间")
	public String getGysdm() {
		return gysdm;
	}

	/**
     * 供应商代码
     */
	public void setGysdm(String gysdm) {
		this.gysdm = gysdm == null ? null : gysdm.trim();
	}
	
	/**
     * 供应商名称
     */
	@Length(min=0, max=100, message="供应商名称长度必须介于 0 和 100 之间")
	public String getGysmc() {
		return gysmc;
	}

	/**
     * 供应商名称
     */
	public void setGysmc(String gysmc) {
		this.gysmc = gysmc == null ? null : gysmc.trim();
	}
	
	/**
     * 供应商地址
     */
	@Length(min=0, max=100, message="供应商地址长度必须介于 0 和 100 之间")
	public String getGysdz() {
		return gysdz;
	}

	/**
     * 供应商地址
     */
	public void setGysdz(String gysdz) {
		this.gysdz = gysdz == null ? null : gysdz.trim();
	}
	
	/**
     * 原产国家
     */
	@Length(min=0, max=50, message="原产国家长度必须介于 0 和 50 之间")
	public String getYcgj() {
		return ycgj;
	}

	/**
     * 原产国家
     */
	public void setYcgj(String ycgj) {
		this.ycgj = ycgj == null ? null : ycgj.trim();
	}
	
	/**
     * 客户海关编码
     */
	@Length(min=0, max=50, message="客户海关编码长度必须介于 0 和 50 之间")
	public String getKhhgbm() {
		return khhgbm;
	}

	/**
     * 客户海关编码
     */
	public void setKhhgbm(String khhgbm) {
		this.khhgbm = khhgbm == null ? null : khhgbm.trim();
	}
	
	/**
     * 客户海关编码描述
     */
	@Length(min=0, max=100, message="客户海关编码描述长度必须介于 0 和 100 之间")
	public String getKhhgbmms() {
		return khhgbmms;
	}

	/**
     * 客户海关编码描述
     */
	public void setKhhgbmms(String khhgbmms) {
		this.khhgbmms = khhgbmms == null ? null : khhgbmms.trim();
	}
	
	/**
     * 单位
     */
	@Length(min=0, max=20, message="单位长度必须介于 0 和 20 之间")
	public String getDw() {
		return dw;
	}

	/**
     * 单位
     */
	public void setDw(String dw) {
		this.dw = dw == null ? null : dw.trim();
	}
	
	/**
     * 单价
     */
	public BigDecimal getDj() {
		return dj;
	}

	/**
     * 单价
     */
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	
	/**
     * 大货金额
     */
	public BigDecimal getDhje() {
		return dhje;
	}

	/**
     * 大货金额
     */
	public void setDhje(BigDecimal dhje) {
		this.dhje = dhje;
	}
	
	/**
     * 免费金额
     */
	public BigDecimal getMfje() {
		return mfje;
	}

	/**
     * 免费金额
     */
	public void setMfje(BigDecimal mfje) {
		this.mfje = mfje;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}

	public String getWllb() {
		return wllb;
	}

	public void setWllb(String wllb) {
		this.wllb = wllb;
	}
	
}