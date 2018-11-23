package com.ey.piit.sdo.price.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 分公司产品价格Entity
 * @author 邓海
 */
public class BranchPrice extends BaseEntity {
	
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String bz;		// 币种
	private String fktj;		// 付款条件
	private Integer ts;		// 天数
	private Double bfl;		// 保费率
	private String pp;		// 品牌
	private String qy;		// 区域
	private String jgfs;		// 加工方式
	private String pid;		// PID
	private String zxppbm;		// 最新配屏编码
	private Double cc;		// 尺寸
	private String cplb;		// 产品类别
	private String sf3d;		// 2D/3D
	private String paneltype;		// PanelType
	private String jixing;		// 机型
	private String jixin;		// 机芯
	private String ks;		// 款式
	private String pm;		// 泡沫
	private String zx;		// 纸箱
	private String ch;		// 彩盒
	private String gj;		// 挂架
	private String pbc;		// 屏包材
	private String bsbhp;		// 1%备损（不含屏）
	private String qttsyq;		// 其他特殊要求
	private BigDecimal fobP;		// FOB屏价格
	private BigDecimal fobSj;		// FOB散件价格
	private BigDecimal fobZj;		// FOB整机价格
	private BigDecimal fobZb;		// FOB主板价格
	private BigDecimal cifP;		// CIF屏价格
	private BigDecimal cifSj;		// CIF散件价格
	private BigDecimal cifZj;		// CIF整机价格
	private BigDecimal cifZb;		// CIF主板价格
	private Date yxqks;		// 有效期开始
	private Date yxqjs;		// 有效期结束
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private BigDecimal dj;	//
	
	
	public BranchPrice() {
		super();
	}

	public BranchPrice(String id){
		super(id);
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
     * 天数
     */
	public Integer getTs() {
		return ts;
	}

	/**
     * 天数
     */
	public void setTs(Integer ts) {
		this.ts = ts;
	}
	
	/**
     * 保费率
     */
	public Double getBfl() {
		return bfl;
	}

	/**
     * 保费率
     */
	public void setBfl(Double bfl) {
		this.bfl = bfl;
	}
	
	/**
     * 品牌
     */
	@Length(min=0, max=20, message="品牌长度必须介于 0 和 20 之间")
	public String getPp() {
		return pp;
	}

	/**
     * 品牌
     */
	public void setPp(String pp) {
		this.pp = pp == null ? null : pp.trim();
	}
	
	/**
     * 区域
     */
	@Length(min=0, max=50, message="区域长度必须介于 0 和 50 之间")
	public String getQy() {
		return qy;
	}

	/**
     * 区域
     */
	public void setQy(String qy) {
		this.qy = qy == null ? null : qy.trim();
	}
	
	/**
     * 加工方式
     */
	@Length(min=0, max=50, message="加工方式长度必须介于 0 和 50 之间")
	public String getJgfs() {
		return jgfs;
	}

	/**
     * 加工方式
     */
	public void setJgfs(String jgfs) {
		this.jgfs = jgfs == null ? null : jgfs.trim();
	}
	
	/**
     * PID
     */
	@Length(min=1, max=50, message="PID长度必须介于 1 和 50 之间")
	public String getPid() {
		return pid;
	}

	/**
     * PID
     */
	public void setPid(String pid) {
		this.pid = pid == null ? null : pid.trim();
	}
	
	/**
     * 最新配屏编码
     */
	@Length(min=0, max=50, message="最新配屏编码长度必须介于 0 和 50 之间")
	public String getZxppbm() {
		return zxppbm;
	}

	/**
     * 最新配屏编码
     */
	public void setZxppbm(String zxppbm) {
		this.zxppbm = zxppbm == null ? null : zxppbm.trim();
	}
	
	/**
     * 尺寸
     */
	public Double getCc() {
		return cc;
	}

	/**
     * 尺寸
     */
	public void setCc(Double cc) {
		this.cc = cc;
	}
	
	/**
     * 产品类别
     */
	@Length(min=0, max=50, message="产品类别长度必须介于 0 和 50 之间")
	public String getCplb() {
		return cplb;
	}

	/**
     * 产品类别
     */
	public void setCplb(String cplb) {
		this.cplb = cplb == null ? null : cplb.trim();
	}
	
	/**
     * 2D/3D
     */
	@Length(min=0, max=20, message="2D/3D长度必须介于 0 和 20 之间")
	public String getSf3d() {
		return sf3d;
	}

	/**
     * 2D/3D
     */
	public void setSf3d(String sf3d) {
		this.sf3d = sf3d == null ? null : sf3d.trim();
	}
	
	/**
     * PanelType
     */
	@Length(min=0, max=50, message="PanelType长度必须介于 0 和 50 之间")
	public String getPaneltype() {
		return paneltype;
	}

	/**
     * PanelType
     */
	public void setPaneltype(String paneltype) {
		this.paneltype = paneltype == null ? null : paneltype.trim();
	}
	
	/**
     * 机型
     */
	@Length(min=1, max=50, message="机型长度必须介于 1 和 50 之间")
	public String getJixing() {
		return jixing;
	}

	/**
     * 机型
     */
	public void setJixing(String jixing) {
		this.jixing = jixing == null ? null : jixing.trim();
	}
	
	/**
     * 机芯
     */
	@Length(min=1, max=20, message="机芯长度必须介于 1 和 20 之间")
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
     * 款式
     */
	@Length(min=1, max=50, message="款式长度必须介于 1 和 50 之间")
	public String getKs() {
		return ks;
	}

	/**
     * 款式
     */
	public void setKs(String ks) {
		this.ks = ks == null ? null : ks.trim();
	}
	
	/**
     * 泡沫
     */
	@Length(min=0, max=50, message="泡沫长度必须介于 0 和 50 之间")
	public String getPm() {
		return pm;
	}

	/**
     * 泡沫
     */
	public void setPm(String pm) {
		this.pm = pm == null ? null : pm.trim();
	}
	
	/**
     * 纸箱
     */
	@Length(min=0, max=50, message="纸箱长度必须介于 0 和 50 之间")
	public String getZx() {
		return zx;
	}

	/**
     * 纸箱
     */
	public void setZx(String zx) {
		this.zx = zx == null ? null : zx.trim();
	}
	
	/**
     * 彩盒
     */
	@Length(min=0, max=50, message="彩盒长度必须介于 0 和 50 之间")
	public String getCh() {
		return ch;
	}

	/**
     * 彩盒
     */
	public void setCh(String ch) {
		this.ch = ch == null ? null : ch.trim();
	}
	
	/**
     * 挂架
     */
	@Length(min=0, max=50, message="挂架长度必须介于 0 和 50 之间")
	public String getGj() {
		return gj;
	}

	/**
     * 挂架
     */
	public void setGj(String gj) {
		this.gj = gj == null ? null : gj.trim();
	}
	
	/**
     * 屏包材
     */
	@Length(min=0, max=50, message="屏包材长度必须介于 0 和 50 之间")
	public String getPbc() {
		return pbc;
	}

	/**
     * 屏包材
     */
	public void setPbc(String pbc) {
		this.pbc = pbc == null ? null : pbc.trim();
	}
	
	
	
	public String getBsbhp() {
		return bsbhp;
	}

	public void setBsbhp(String bsbhp) {
		this.bsbhp = bsbhp;
	}

	/**
     * 其他特殊要求
     */
	@Length(min=0, max=100, message="其他特殊要求长度必须介于 0 和 100 之间")
	public String getQttsyq() {
		return qttsyq;
	}

	/**
     * 其他特殊要求
     */
	public void setQttsyq(String qttsyq) {
		this.qttsyq = qttsyq == null ? null : qttsyq.trim();
	}
	
	
	public BigDecimal getFobP() {
		return fobP;
	}

	public void setFobP(BigDecimal fobP) {
		this.fobP = fobP;
	}

	public BigDecimal getFobSj() {
		return fobSj;
	}

	public void setFobSj(BigDecimal fobSj) {
		this.fobSj = fobSj;
	}

	public BigDecimal getFobZj() {
		return fobZj;
	}

	public void setFobZj(BigDecimal fobZj) {
		this.fobZj = fobZj;
	}

	public BigDecimal getCifP() {
		return cifP;
	}

	public void setCifP(BigDecimal cifP) {
		this.cifP = cifP;
	}

	public BigDecimal getCifSj() {
		return cifSj;
	}

	public void setCifSj(BigDecimal cifSj) {
		this.cifSj = cifSj;
	}

	public BigDecimal getCifZj() {
		return cifZj;
	}

	public void setCifZj(BigDecimal cifZj) {
		this.cifZj = cifZj;
	}

	public void setFobZb(BigDecimal fobZb) {
		this.fobZb = fobZb;
	}

	public void setCifZb(BigDecimal cifZb) {
		this.cifZb = cifZb;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	/**
     * 有效期开始
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="有效期开始不能为空")
	public Date getYxqks() {
		return yxqks;
	}

	/**
     * 有效期开始
     */
	public void setYxqks(Date yxqks) {
		this.yxqks = yxqks;
	}
	
	/**
     * 有效期结束
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="有效期结束不能为空")
	public Date getYxqjs() {
		return yxqjs;
	}

	/**
     * 有效期结束
     */
	public void setYxqjs(Date yxqjs) {
		this.yxqjs = yxqjs;
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

	public BigDecimal getFobZb() {
		return fobZb;
	}

	public BigDecimal getCifZb() {
		return cifZb;
	}

	public BigDecimal getDj() {
		return dj;
	}

	
}