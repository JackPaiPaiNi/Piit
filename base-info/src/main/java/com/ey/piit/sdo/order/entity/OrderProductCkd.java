package com.ey.piit.sdo.order.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 大货订单管理Entity
 * @author 魏诚
 */
public class OrderProductCkd extends BaseEntity {
	
	private String ddid;		// 订单号 父类
	private Integer bbh;		// 版本号
	private String wlbm;		// 物料编码
	private String ms;		    // 描述
	private Integer djyl;		// 单机用量--
	private Double sdjysl;		// 上单结余数量
	private Double dhsl;		// 大货数量
	private Double mfbssl;		// 免费备损数量
	private Double ffbssl;		// 付费备损数量
	private Integer moqsl;		// MOQ数量--
	private Double xdsl;		// 下单数量
	private Double sapdhddsl;	// SAP大货订单数量
	private Double bdjysl;		// 本单结余数量
	private String ne;		    // NE
	private String po;		    // PO
	private String ncmcode;		// NCMCODE
	private String ncm;		    // NCM
	private String dw;		    // 单位（研发bom单位）
	private BigDecimal jz;		    // 净重（kg）
	private BigDecimal mz;		    // 毛重（kg）
	private String gysbm;		// 供应商编码
	private String gysmc;		// 供应商名称
	private String gysdz;		// 供应商地址
	private String ycd;		    // 原产地
	private Integer sfYc;		// 是否移除 0否 1是
	private BigDecimal dj;		    // 单价
	private String bz;		    // 币种
	private String pid;		    // PID号
	private Integer rn;		    // 行号
	private String flag;		// 操作类型
	
	private Integer sFbg;      //是否变更
	private Integer sfYj;	//是否样机
	
	
	
	public Integer getsFbg() {
		return sFbg;
	}

	public void setsFbg(Integer sFbg) {
		this.sFbg = sFbg;
	}

	public OrderProductCkd() {
		super();
	}

	public OrderProductCkd(String id){
		super(id);
	}

	

	/**
     * 订单号
     */
	@Length(min=1, max=20, message="订单号长度必须介于 1 和 20 之间")
	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
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
     * 物料编码
     */
	@Length(min=0, max=50, message="物料编码长度必须介于 0 和 50 之间")
	public String getWlbm() {
		return wlbm;
	}

	/**
     * 物料编码
     */
	public void setWlbm(String wlbm) {
		this.wlbm = wlbm == null ? null : wlbm.trim();
	}
	
	/**
     * 描述
     */
	@Length(min=0, max=100, message="描述长度必须介于 0 和 100 之间")
	public String getMs() {
		return ms;
	}

	/**
     * 描述
     */
	public void setMs(String ms) {
		this.ms = ms == null ? null : ms.trim();
	}
	
	/**
     * 单机用量
     */
	public Integer getDjyl() {
		return djyl;
	}

	/**
     * 单机用量
     */
	public void setDjyl(Integer djyl) {
		this.djyl = djyl;
	}
	
	/**
     * 上单结余数量
     */
	public Double getSdjysl() {
		return sdjysl;
	}

	/**
     * 上单结余数量
     */
	public void setSdjysl(Double sdjysl) {
		this.sdjysl = sdjysl;
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
     * 免费备损数量
     */
	public Double getMfbssl() {
		return mfbssl;
	}

	/**
     * 免费备损数量
     */
	public void setMfbssl(Double mfbssl) {
		this.mfbssl = mfbssl;
	}
	
	/**
     * 付费备损数量
     */
	public Double getFfbssl() {
		return ffbssl;
	}

	/**
     * 付费备损数量
     */
	public void setFfbssl(Double ffbssl) {
		this.ffbssl = ffbssl;
	}
	
	/**
     * MOQ数量
     */
	public Integer getMoqsl() {
		return moqsl;
	}

	/**
     * MOQ数量
     */
	public void setMoqsl(Integer moqsl) {
		this.moqsl = moqsl;
	}
	
	/**
     * 下单数量
     */
	public Double getXdsl() {
		return xdsl;
	}

	/**
     * 下单数量
     */
	public void setXdsl(Double xdsl) {
		this.xdsl = xdsl;
	}
	
	/**
     * SAP大货订单数量
     */
	public Double getSapdhddsl() {
		return sapdhddsl;
	}

	/**
     * SAP大货订单数量
     */
	public void setSapdhddsl(Double sapdhddsl) {
		this.sapdhddsl = sapdhddsl;
	}
	
	/**
     * 本单结余数量
     */
	public Double getBdjysl() {
		return bdjysl;
	}

	/**
     * 本单结余数量
     */
	public void setBdjysl(Double bdjysl) {
		this.bdjysl = bdjysl;
	}
	
	/**
     * NE
     */
	@Length(min=0, max=50, message="NE长度必须介于 0 和 50 之间")
	public String getNe() {
		return ne;
	}

	/**
     * NE
     */
	public void setNe(String ne) {
		this.ne = ne == null ? null : ne.trim();
	}
	
	/**
     * PO
     */
	@Length(min=0, max=50, message="PO长度必须介于 0 和 50 之间")
	public String getPo() {
		return po;
	}

	/**
     * PO
     */
	public void setPo(String po) {
		this.po = po == null ? null : po.trim();
	}
	
	/**
     * NCMCODE
     */
	@Length(min=0, max=50, message="NCMCODE长度必须介于 0 和 50 之间")
	public String getNcmcode() {
		return ncmcode;
	}

	/**
     * NCMCODE
     */
	public void setNcmcode(String ncmcode) {
		this.ncmcode = ncmcode == null ? null : ncmcode.trim();
	}
	
	/**
     * NCM
     */
	@Length(min=0, max=50, message="NCM长度必须介于 0 和 50 之间")
	public String getNcm() {
		return ncm;
	}

	/**
     * NCM
     */
	public void setNcm(String ncm) {
		this.ncm = ncm == null ? null : ncm.trim();
	}
	
	/**
     * 单位（研发bom单位）
     */
	@Length(min=0, max=20, message="单位（研发bom单位）长度必须介于 0 和 20 之间")
	public String getDw() {
		return dw;
	}

	/**
     * 单位（研发bom单位）
     */
	public void setDw(String dw) {
		this.dw = dw == null ? null : dw.trim();
	}
	
	
	
	public BigDecimal getJz() {
		return jz;
	}

	public void setJz(BigDecimal jz) {
		this.jz = jz;
	}

	public BigDecimal getMz() {
		return mz;
	}

	public void setMz(BigDecimal mz) {
		this.mz = mz;
	}

	/**
     * 供应商编码
     */
	@Length(min=0, max=50, message="供应商编码长度必须介于 0 和 50 之间")
	public String getGysbm() {
		return gysbm;
	}

	/**
     * 供应商编码
     */
	public void setGysbm(String gysbm) {
		this.gysbm = gysbm == null ? null : gysbm.trim();
	}
	
	/**
     * 供应商名称
     */
	@Length(min=0, max=50, message="供应商名称长度必须介于 0 和 50 之间")
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
     * 是否移除 0否 1是
     */
	public Integer getSfYc() {
		return sfYc;
	}

	/**
     * 是否移除 0否 1是
     */
	public void setSfYc(Integer sfYc) {
		this.sfYc = sfYc;
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
     * 币种
     */
	@Length(min=0, max=20, message="币种长度必须介于 0 和 20 之间")
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
     * PID号
     */
	@Length(min=0, max=50, message="PID号长度必须介于 0 和 50 之间")
	public String getPid() {
		return pid;
	}

	/**
     * PID号
     */
	public void setPid(String pid) {
		this.pid = pid == null ? null : pid.trim();
	}

	public String getGysdz() {
		return gysdz;
	}

	public void setGysdz(String gysdz) {
		this.gysdz = gysdz;
	}

	public String getYcd() {
		return ycd;
	}

	public void setYcd(String ycd) {
		this.ycd = ycd;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getSfYj() {
		return sfYj;
	}

	public void setSfYj(Integer sfYj) {
		this.sfYj = sfYj;
	}
	
}