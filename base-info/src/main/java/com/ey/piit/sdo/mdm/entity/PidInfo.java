package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * PID信息申请Entity
 * 
 * @author 高文浩
 */
public class PidInfo extends BaseEntity {

	private String pid; // PID
	private Date jhwcsj; // 计划完成时间
	private Date chyqwcsj; // 出货要求完成时间
	private Double yjnxsl; // 预计年销售量
	private String khbm; // 客户编码
	private String khmc; // 客户名称
	private String pp; // 品牌
	private String jixin; // 机芯
	private String jixing; // 机型
	private Double cc; // 尺寸
	private String zhfs; // 走货方式
	private String zhfsmc; // 走货方式名称
	private String xwgj; // 数据值集
	private String xwgjmc; // 销往国家名称
	private Integer rz1Cb; // 认证1-CB
	private Integer rz1Ce; // 认证1-CE
	private Integer rz1Etl; // 认证1-ETL
	private Integer rz1Ul; // 认证1-UL
	private Integer rz1Pse; // 认证1-PSE
	private Integer rz1Qt; // 认证1-其他
	private String rz1Bz; // 认证1-备注
	private Integer rz2Emc; // 认证2-EMC
	private Integer rz2Fcc; // 认证2-FCC
	private Integer rz2Meps; // 认证2-MEPS
	private Integer rz2Es; // 认证2-Energy Star
	private Integer rz2Qt; // 认证2-其他
	private String rz2Bz; // 认证2-备注
	private Integer rz3Hdmi; // 认证3-HDMI
	private Integer rz3Usb; // 认证3-USB
	private Integer rz3Qt; // 认证3-其他
	private String rz3Bz; // 认证3-备注
	private String ctlxbz; // 插头类型备注
	private String dianya; // 电压
	private String dianyamc; // 电压名称
	private String dianyabz; // 电压备注
	private Integer sfDykg; // 是否要电源开关
	private Integer sfReach; // 是否要REACH
	private String djgl; // 待机功率
	private String djglmc; // 待机功率名称
	private String djglbz; // 待机功率备注
	private String wifi; // WIFI
	private String wifimc; // WIFI名称
	private String wifibz; // WIFI备注
	private Integer fjgbPgs3d; // 附加功能-偏光式3D
	private Integer fjgnKms3d; // 附加功能-快门式3D
	private Integer fjgnCij; // 附加功能-CI+
	private Integer fjgnCi; // 附加功能-CI
	private Integer fjgnScart; // 附加功能-SCART
	private Integer sl3dyjh; // 3D眼镜盒数
	private String osdyy; // OSD语言
	private String paomo; // 泡沫
	private String paomomc; // 泡沫名称
	private String paomobz; // 泡沫备注
	private Integer fhlHk; // 防火料-后壳
	private Integer fhlDzjlz; // 防火料-底座及立柱
	private String dzbzbz; // 底座包装备注
	private String guajia; // 挂架
	private String guajiamc; // 挂架名称
	private String pfl; // 屏分类
	private String ppp; // 屏品牌
	private String pxh; // 屏型号
	private String pbh; // 屏编号
	private String fbl; // 分辨率
	private String fblmc; // 分辨率名称
	private String fblbz; // 分辨率备注
	private Integer sf3d; // 是否3D
	private String dy; // 电源
	private String dymc; // 电源名称
	private String dybz; // 电源备注
	private String ykq; // 遥控器
	private String ykqmc; // 遥控器名称
	private String ykqbz; // 遥控器备注
	private String ctlx; // 插头类型
	private String ctlxmc; // 插头类型名称
	private String wkysbz; // 外壳颜色标准
	private Integer fhlQk; // 防火料-前壳
	private Integer fhlAvzj; // 防火料-AV支架
	private Integer sfDc; // 是否要电池
	private String kjlogo; // 开机LOGO
	private String osdccyysz; // OSD出厂语言设置
	private String mnlbz; // 模拟量标准
	private String mnlbzmc; // 模拟量标准名称
	private String mnlbzbz; // 模拟量标准备注
	private String zlbz; // 质量标准
	private String zlbzmc; // 质量标准名称
	private String zlbzbz; // 质量标准备注
	private Integer sfSybg; // 是否实验报告
	private String sybgbz; // 实验报告备注
	private String yspzcgs; // 音视频支持格式
	private String yspzcgsmc; // 音视频支持格式名称
	private String yspzcgebz; // 音视频支持格式备注
	private String wlgnyq; // 网络功能要求
	private String wlgnyqmc; // 网络功能要求名称
	private String wlgnyqbz; // 网络功能要求备注
	private String qtbz; // 其他备注
	private String fj; // 附件
	private String dzgcs; // 电子工程师
	private String dzgcsmc; // 电子工程师名称
	private String dygcs; // 电源工程师
	private String dygcsmc; // 电源工程师名称
	private String jggcs; // 结构工程师
	private String jggcsmc; // 结构工程师名称
	private String wl; // 网络
	private String wlmc; // 网络名称
	private String jgzjh; // 结构组件号
	private String dyzjh; // 电源组件号
	private String dzzjh; // 电子组件号
	private String hlzjh; // 恒流组件号
	private Double jyyjsl; // 建议样机数量
	private String guajiabz; // 挂架备注
	private String gjbz; // 挂架包装
	private String gjbzmc; // 挂架包装名称
	private String dzbz; // 底座包装
	private String dzbzmc; // 底座包装名称
	private String bzxx; // 备注
	private String zdrid; // 创建人
	private String zdrmc; // 创建人名称
	private Date cjsj; // 创建时间
	private Integer zt; // 状态
	private String sjc; // 时间戳
	private Integer tssapzt; // 推送SAP状态
	private String xsyid; // 销售员id
	private String xsymc; // 销售员名称
	private String cpfl; // 产品分类
	private String cpflmc; // 产品分类名称
	private String cpxl; // 产品系列
	private String ggmx; // 规格明细
	private String ggmxmc; // 规格明细名称
	private Integer rz1Rf; // 认证1RF
	private Integer rz1Rte; // 认证1RTE
	private Integer sfBg; // 是否变更
	private String jgfs; // 加工方式
	private String jgfsmc; // 加工方式
	private Integer pidyjsl; // PID样机数量
	private String pidxh; // PID流水号
	private Integer rz1Cet; // 认证1：安全-cETLus
	private Integer rz1Paq; // 认证1：安全-PSE-安全
	private Integer rz1Nom; // 认证1：安全-NOM
	private Integer rz1Raq; // 认证1：安全-RED-安全
	private Integer rz1Smaq; // 认证1：安全-S-mark 安全
	private Integer rz1Cetl; // 认证1：安全 rz1cEtl

	private Integer rz2Pe; // 认证2：电磁兼容-PSE-EMC
	private Integer rz2Rr; // 认证2：电磁兼容-RED-RF
	private Integer rz2Rtte; // 认证2：电磁兼容-RTTE
	private Integer rz2Sme; // 认证2：电磁兼容-S-mark -EMC
	private Integer rz3Dd; // 认证3：专利-DD
	private Integer rz3Ddj; // 认证3：专利-DD+
	private Integer rz3Dts; // 认证3：专利-DTS
	private Integer rz3Cij; // 认证3：专利-CI+
	private Integer rz3Mhl; // 认证3：专利-MHL
	private Integer rz3Bqb; // 认证3：专利-BQB
	private Integer rz4Erp; // 认证4：能效-ERP
	private Integer rz4Gems; // 认证4：能效-GEMS
	private Integer rz4Bee; // 认证4：能效-BEE
	private Integer rz4Nrc; // 认证4：能效-NRcan
	private Integer rz4Nfnx; // 认证4：能效-南非能效
	private Integer rz4Es7; // 认证4：能效-Energy star 7.0
	private Integer rz4Eg; // 认证4：能效-Energy Guide

	private String rz4Bz; // 认证4：能效-备注
	private Integer rz5Qt; // 认证5：其他-其他L
	//专利名称
	private Integer zlmc1;
	private Integer zlmc2;
	private Integer zlmc3;
	private Integer zlmc4;
	private Integer zlmc5;
	private Integer zlmc6;
	private Integer zlmc7;
	private Integer zlmc8;
	private Integer zlmc9;
	private Integer zlmc10;
	private Integer zlmc11;
	private Integer zlmc12;
	private Integer zlmc13;
	private Integer zlmc14;
	private Integer zlmc15;
	private Integer zlmc16;
	private Integer zlmc17;
	private Integer zlmc21;
	private Integer zlmc22;
	//平台名称
	private Integer ptmc1;
	private Integer ptmc2;
	private Integer ptmc3;
	private Integer ptmc4;
	private Integer ptmc5;
	private Integer ptmc6;
	private Integer ptmc7;
	private Integer ptmc8;
	private Integer ptmc9;
	private Integer ptmc10;
	private Integer ptmc11;
	private Integer ptmc12;
	private Integer ptmc13;
	private Integer ptmc14;
	private Integer ptmc15;
	private Integer ptmc16;
	private Integer ptmc17;
	private Integer ptmc18;
	private Integer ptmc19;
	private Integer ptmc20;
	private Integer ptmc21;

	
	public Integer getRz1Cetl() {
		return rz1Cetl;
	}

	public void setRz1Cetl(Integer rz1Cetl) {
		this.rz1Cetl = rz1Cetl;
	}

	public Integer getRz4Eg() {
		return rz4Eg;
	}

	public void setRz4Eg(Integer rz4Eg) {
		this.rz4Eg = rz4Eg;
	}

	public String getJgfsmc() {
		return jgfsmc;
	}

	public void setJgfsmc(String jgfsmc) {
		this.jgfsmc = jgfsmc;
	}

	public String getJgfs() {
		return jgfs;
	}

	public void setJgfs(String jgfs) {
		this.jgfs = jgfs;
	}

	public Integer getSfBg() {
		return sfBg;
	}

	public void setSfBg(Integer sfBg) {
		this.sfBg = sfBg;
	}

	public PidInfo() {
		super();
	}

	public Integer getRz1Rf() {
		return rz1Rf;
	}

	public void setRz1Rf(Integer rz1Rf) {
		this.rz1Rf = rz1Rf;
	}

	public Integer getRz1Rte() {
		return rz1Rte;
	}

	public void setRz1Rte(Integer rz1Rte) {
		this.rz1Rte = rz1Rte;
	}

	public PidInfo(String id) {
		super(id);
	}

	public String getXsyid() {
		return xsyid;
	}

	public void setXsyid(String xsyid) {
		this.xsyid = xsyid;
	}

	public String getXsymc() {
		return xsymc;
	}

	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}

	public String getCpfl() {
		return cpfl;
	}

	public void setCpfl(String cpfl) {
		this.cpfl = cpfl;
	}

	public String getCpflmc() {
		return cpflmc;
	}

	public void setCpflmc(String cpflmc) {
		this.cpflmc = cpflmc;
	}

	public String getCpxl() {
		return cpxl;
	}

	public void setCpxl(String cpxl) {
		this.cpxl = cpxl;
	}

	public String getGgmx() {
		return ggmx;
	}

	public void setGgmx(String ggmx) {
		this.ggmx = ggmx;
	}

	public String getGgmxmc() {
		return ggmxmc;
	}

	public void setGgmxmc(String ggmxmc) {
		this.ggmxmc = ggmxmc;
	}

	/**
	 * PID
	 */
	@Length(min = 1, max = 50, message = "PID长度必须介于 1 和 50 之间")
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
	 * 计划完成时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJhwcsj() {
		return jhwcsj;
	}

	/**
	 * 计划完成时间
	 */
	public void setJhwcsj(Date jhwcsj) {
		this.jhwcsj = jhwcsj;
	}

	/**
	 * 出货要求完成时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getChyqwcsj() {
		return chyqwcsj;
	}

	/**
	 * 出货要求完成时间
	 */
	public void setChyqwcsj(Date chyqwcsj) {
		this.chyqwcsj = chyqwcsj;
	}

	/**
	 * 预计年销售量
	 */
	public Double getYjnxsl() {
		return yjnxsl;
	}

	/**
	 * 预计年销售量
	 */
	public void setYjnxsl(Double yjnxsl) {
		this.yjnxsl = yjnxsl;
	}

	/**
	 * 客户编码
	 */
	@Length(min = 0, max = 20, message = "客户编码长度必须介于 0 和 20 之间")
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
	@Length(min = 0, max = 50, message = "客户名称长度必须介于 0 和 50 之间")
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
	 * 品牌
	 */
	@Length(min = 0, max = 50, message = "品牌长度必须介于 0 和 50 之间")
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
	 * 机芯
	 */
	@Length(min = 0, max = 50, message = "机芯长度必须介于 0 和 50 之间")
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
	 * 机型
	 */
	@Length(min = 1, max = 50, message = "机型长度必须介于 1 和 50 之间")
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
	 * 走货方式
	 */
	@Length(min = 0, max = 20, message = "走货方式长度必须介于 0 和 20 之间")
	public String getZhfs() {
		return zhfs;
	}

	/**
	 * 走货方式
	 */
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs == null ? null : zhfs.trim();
	}

	/**
	 * 走货方式名称
	 */
	@Length(min = 0, max = 50, message = "走货方式名称长度必须介于 0 和 50 之间")
	public String getZhfsmc() {
		return zhfsmc;
	}

	/**
	 * 走货方式名称
	 */
	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc == null ? null : zhfsmc.trim();
	}

	/**
	 * 数据值集
	 */
	@Length(min = 0, max = 20, message = "数据值集长度必须介于 0 和 20 之间")
	public String getXwgj() {
		return xwgj;
	}

	/**
	 * 数据值集
	 */
	public void setXwgj(String xwgj) {
		this.xwgj = xwgj == null ? null : xwgj.trim();
	}

	/**
	 * 销往国家名称
	 */
	@Length(min = 0, max = 50, message = "销往国家名称长度必须介于 0 和 50 之间")
	public String getXwgjmc() {
		return xwgjmc;
	}

	/**
	 * 销往国家名称
	 */
	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc == null ? null : xwgjmc.trim();
	}

	/**
	 * 认证1-CB
	 */
	public Integer getRz1Cb() {
		return rz1Cb;
	}

	/**
	 * 认证1-CB
	 */
	public void setRz1Cb(Integer rz1Cb) {
		this.rz1Cb = rz1Cb;
	}

	/**
	 * 认证1-CE
	 */
	public Integer getRz1Ce() {
		return rz1Ce;
	}

	/**
	 * 认证1-CE
	 */
	public void setRz1Ce(Integer rz1Ce) {
		this.rz1Ce = rz1Ce;
	}

	/**
	 * 认证1-ETL
	 */
	public Integer getRz1Etl() {
		return rz1Etl;
	}

	/**
	 * 认证1-ETL
	 */
	public void setRz1Etl(Integer rz1Etl) {
		this.rz1Etl = rz1Etl;
	}

	/**
	 * 认证1-UL
	 */
	public Integer getRz1Ul() {
		return rz1Ul;
	}

	/**
	 * 认证1-UL
	 */
	public void setRz1Ul(Integer rz1Ul) {
		this.rz1Ul = rz1Ul;
	}

	/**
	 * 认证1-PSE
	 */
	public Integer getRz1Pse() {
		return rz1Pse;
	}

	/**
	 * 认证1-PSE
	 */
	public void setRz1Pse(Integer rz1Pse) {
		this.rz1Pse = rz1Pse;
	}

	/**
	 * 认证1-其他
	 */
	public Integer getRz1Qt() {
		return rz1Qt;
	}

	/**
	 * 认证1-其他
	 */
	public void setRz1Qt(Integer rz1Qt) {
		this.rz1Qt = rz1Qt;
	}

	/**
	 * 认证1-备注
	 */
	@Length(min = 0, max = 100, message = "认证1-备注长度必须介于 0 和 100 之间")
	public String getRz1Bz() {
		return rz1Bz;
	}

	/**
	 * 认证1-备注
	 */
	public void setRz1Bz(String rz1Bz) {
		this.rz1Bz = rz1Bz == null ? null : rz1Bz.trim();
	}

	/**
	 * 认证2-EMC
	 */
	public Integer getRz2Emc() {
		return rz2Emc;
	}

	/**
	 * 认证2-EMC
	 */
	public void setRz2Emc(Integer rz2Emc) {
		this.rz2Emc = rz2Emc;
	}

	/**
	 * 认证2-FCC
	 */
	public Integer getRz2Fcc() {
		return rz2Fcc;
	}

	/**
	 * 认证2-FCC
	 */
	public void setRz2Fcc(Integer rz2Fcc) {
		this.rz2Fcc = rz2Fcc;
	}

	/**
	 * 认证2-MEPS
	 */
	public Integer getRz2Meps() {
		return rz2Meps;
	}

	/**
	 * 认证2-MEPS
	 */
	public void setRz2Meps(Integer rz2Meps) {
		this.rz2Meps = rz2Meps;
	}

	/**
	 * 认证2-Energy Star
	 */
	public Integer getRz2Es() {
		return rz2Es;
	}

	/**
	 * 认证2-Energy Star
	 */
	public void setRz2Es(Integer rz2Es) {
		this.rz2Es = rz2Es;
	}

	/**
	 * 认证2-其他
	 */
	public Integer getRz2Qt() {
		return rz2Qt;
	}

	/**
	 * 认证2-其他
	 */
	public void setRz2Qt(Integer rz2Qt) {
		this.rz2Qt = rz2Qt;
	}

	/**
	 * 认证2-备注
	 */
	@Length(min = 0, max = 100, message = "认证2-备注长度必须介于 0 和 100 之间")
	public String getRz2Bz() {
		return rz2Bz;
	}

	/**
	 * 认证2-备注
	 */
	public void setRz2Bz(String rz2Bz) {
		this.rz2Bz = rz2Bz == null ? null : rz2Bz.trim();
	}

	/**
	 * 认证3-HDMI
	 */
	public Integer getRz3Hdmi() {
		return rz3Hdmi;
	}

	/**
	 * 认证3-HDMI
	 */
	public void setRz3Hdmi(Integer rz3Hdmi) {
		this.rz3Hdmi = rz3Hdmi;
	}

	/**
	 * 认证3-USB
	 */
	public Integer getRz3Usb() {
		return rz3Usb;
	}

	/**
	 * 认证3-USB
	 */
	public void setRz3Usb(Integer rz3Usb) {
		this.rz3Usb = rz3Usb;
	}

	/**
	 * 认证3-其他
	 */
	public Integer getRz3Qt() {
		return rz3Qt;
	}

	/**
	 * 认证3-其他
	 */
	public void setRz3Qt(Integer rz3Qt) {
		this.rz3Qt = rz3Qt;
	}

	/**
	 * 认证3-备注
	 */
	@Length(min = 0, max = 100, message = "认证3-备注长度必须介于 0 和 100 之间")
	public String getRz3Bz() {
		return rz3Bz;
	}

	/**
	 * 认证3-备注
	 */
	public void setRz3Bz(String rz3Bz) {
		this.rz3Bz = rz3Bz == null ? null : rz3Bz.trim();
	}

	/**
	 * 插头类型备注
	 */
	@Length(min = 0, max = 100, message = "插头类型备注长度必须介于 0 和 100 之间")
	public String getCtlxbz() {
		return ctlxbz;
	}

	/**
	 * 插头类型备注
	 */
	public void setCtlxbz(String ctlxbz) {
		this.ctlxbz = ctlxbz == null ? null : ctlxbz.trim();
	}

	/**
	 * 电压
	 */
	@Length(min = 0, max = 20, message = "电压长度必须介于 0 和 20 之间")
	public String getDianya() {
		return dianya;
	}

	/**
	 * 电压
	 */
	public void setDianya(String dianya) {
		this.dianya = dianya == null ? null : dianya.trim();
	}

	/**
	 * 电压名称
	 */
	@Length(min = 0, max = 50, message = "电压名称长度必须介于 0 和 50 之间")
	public String getDianyamc() {
		return dianyamc;
	}

	/**
	 * 电压名称
	 */
	public void setDianyamc(String dianyamc) {
		this.dianyamc = dianyamc == null ? null : dianyamc.trim();
	}

	/**
	 * 电压备注
	 */
	@Length(min = 0, max = 100, message = "电压备注长度必须介于 0 和 100 之间")
	public String getDianyabz() {
		return dianyabz;
	}

	/**
	 * 电压备注
	 */
	public void setDianyabz(String dianyabz) {
		this.dianyabz = dianyabz == null ? null : dianyabz.trim();
	}

	/**
	 * 是否要电源开关
	 */
	public Integer getSfDykg() {
		return sfDykg;
	}

	/**
	 * 是否要电源开关
	 */
	public void setSfDykg(Integer sfDykg) {
		this.sfDykg = sfDykg;
	}

	/**
	 * 是否要REACH
	 */
	public Integer getSfReach() {
		return sfReach;
	}

	/**
	 * 是否要REACH
	 */
	public void setSfReach(Integer sfReach) {
		this.sfReach = sfReach;
	}

	/**
	 * 待机功率
	 */
	@Length(min = 0, max = 20, message = "待机功率长度必须介于 0 和 20 之间")
	public String getDjgl() {
		return djgl;
	}

	/**
	 * 待机功率
	 */
	public void setDjgl(String djgl) {
		this.djgl = djgl == null ? null : djgl.trim();
	}

	/**
	 * 待机功率名称
	 */
	@Length(min = 0, max = 50, message = "待机功率名称长度必须介于 0 和 50 之间")
	public String getDjglmc() {
		return djglmc;
	}

	/**
	 * 待机功率名称
	 */
	public void setDjglmc(String djglmc) {
		this.djglmc = djglmc == null ? null : djglmc.trim();
	}

	/**
	 * 待机功率备注
	 */
	@Length(min = 0, max = 100, message = "待机功率备注长度必须介于 0 和 100 之间")
	public String getDjglbz() {
		return djglbz;
	}

	/**
	 * 待机功率备注
	 */
	public void setDjglbz(String djglbz) {
		this.djglbz = djglbz == null ? null : djglbz.trim();
	}

	/**
	 * WIFI
	 */
	@Length(min = 0, max = 20, message = "WIFI长度必须介于 0 和 20 之间")
	public String getWifi() {
		return wifi;
	}

	/**
	 * WIFI
	 */
	public void setWifi(String wifi) {
		this.wifi = wifi == null ? null : wifi.trim();
	}

	/**
	 * WIFI名称
	 */
	@Length(min = 0, max = 50, message = "WIFI名称长度必须介于 0 和 50 之间")
	public String getWifimc() {
		return wifimc;
	}

	/**
	 * WIFI名称
	 */
	public void setWifimc(String wifimc) {
		this.wifimc = wifimc == null ? null : wifimc.trim();
	}

	/**
	 * WIFI备注
	 */
	@Length(min = 0, max = 100, message = "WIFI备注长度必须介于 0 和 100 之间")
	public String getWifibz() {
		return wifibz;
	}

	/**
	 * WIFI备注
	 */
	public void setWifibz(String wifibz) {
		this.wifibz = wifibz == null ? null : wifibz.trim();
	}

	/**
	 * 附加功能-偏光式3D
	 */
	public Integer getFjgbPgs3d() {
		return fjgbPgs3d;
	}

	/**
	 * 附加功能-偏光式3D
	 */
	public void setFjgbPgs3d(Integer fjgbPgs3d) {
		this.fjgbPgs3d = fjgbPgs3d;
	}

	/**
	 * 附加功能-快门式3D
	 */
	public Integer getFjgnKms3d() {
		return fjgnKms3d;
	}

	/**
	 * 附加功能-快门式3D
	 */
	public void setFjgnKms3d(Integer fjgnKms3d) {
		this.fjgnKms3d = fjgnKms3d;
	}

	/**
	 * 附加功能-CI+
	 */
	public Integer getFjgnCij() {
		return fjgnCij;
	}

	/**
	 * 附加功能-CI+
	 */
	public void setFjgnCij(Integer fjgnCij) {
		this.fjgnCij = fjgnCij;
	}

	/**
	 * 附加功能-CI
	 */
	public Integer getFjgnCi() {
		return fjgnCi;
	}

	/**
	 * 附加功能-CI
	 */
	public void setFjgnCi(Integer fjgnCi) {
		this.fjgnCi = fjgnCi;
	}

	/**
	 * 附加功能-SCART
	 */
	public Integer getFjgnScart() {
		return fjgnScart;
	}

	/**
	 * 附加功能-SCART
	 */
	public void setFjgnScart(Integer fjgnScart) {
		this.fjgnScart = fjgnScart;
	}

	/**
	 * 3D眼镜盒数
	 */
	public Integer getSl3dyjh() {
		return sl3dyjh;
	}

	/**
	 * 3D眼镜盒数
	 */
	public void setSl3dyjh(Integer sl3dyjh) {
		this.sl3dyjh = sl3dyjh;
	}

	/**
	 * OSD语言
	 */
	@Length(min = 0, max = 100, message = "OSD语言长度必须介于 0 和 100 之间")
	public String getOsdyy() {
		return osdyy;
	}

	/**
	 * OSD语言
	 */
	public void setOsdyy(String osdyy) {
		this.osdyy = osdyy == null ? null : osdyy.trim();
	}

	/**
	 * 泡沫
	 */
	@Length(min = 0, max = 20, message = "泡沫长度必须介于 0 和 20 之间")
	public String getPaomo() {
		return paomo;
	}

	/**
	 * 泡沫
	 */
	public void setPaomo(String paomo) {
		this.paomo = paomo == null ? null : paomo.trim();
	}

	/**
	 * 泡沫名称
	 */
	@Length(min = 0, max = 50, message = "泡沫名称长度必须介于 0 和 50 之间")
	public String getPaomomc() {
		return paomomc;
	}

	/**
	 * 泡沫名称
	 */
	public void setPaomomc(String paomomc) {
		this.paomomc = paomomc == null ? null : paomomc.trim();
	}

	/**
	 * 泡沫备注
	 */
	@Length(min = 0, max = 100, message = "泡沫备注长度必须介于 0 和 100 之间")
	public String getPaomobz() {
		return paomobz;
	}

	/**
	 * 泡沫备注
	 */
	public void setPaomobz(String paomobz) {
		this.paomobz = paomobz == null ? null : paomobz.trim();
	}

	/**
	 * 防火料-后壳
	 */
	public Integer getFhlHk() {
		return fhlHk;
	}

	/**
	 * 防火料-后壳
	 */
	public void setFhlHk(Integer fhlHk) {
		this.fhlHk = fhlHk;
	}

	/**
	 * 防火料-底座及立柱
	 */
	public Integer getFhlDzjlz() {
		return fhlDzjlz;
	}

	/**
	 * 防火料-底座及立柱
	 */
	public void setFhlDzjlz(Integer fhlDzjlz) {
		this.fhlDzjlz = fhlDzjlz;
	}

	/**
	 * 底座包装备注
	 */
	@Length(min = 0, max = 100, message = "底座包装备注长度必须介于 0 和 100 之间")
	public String getDzbzbz() {
		return dzbzbz;
	}

	/**
	 * 底座包装备注
	 */
	public void setDzbzbz(String dzbzbz) {
		this.dzbzbz = dzbzbz == null ? null : dzbzbz.trim();
	}

	/**
	 * 挂架
	 */
	@Length(min = 0, max = 20, message = "挂架长度必须介于 0 和 20 之间")
	public String getGuajia() {
		return guajia;
	}

	/**
	 * 挂架
	 */
	public void setGuajia(String guajia) {
		this.guajia = guajia == null ? null : guajia.trim();
	}

	/**
	 * 挂架名称
	 */
	@Length(min = 0, max = 50, message = "挂架名称长度必须介于 0 和 50 之间")
	public String getGuajiamc() {
		return guajiamc;
	}

	/**
	 * 挂架名称
	 */
	public void setGuajiamc(String guajiamc) {
		this.guajiamc = guajiamc == null ? null : guajiamc.trim();
	}

	/**
	 * 屏分类
	 */
	@Length(min = 0, max = 50, message = "屏分类长度必须介于 0 和 50 之间")
	public String getPfl() {
		return pfl;
	}

	/**
	 * 屏分类
	 */
	public void setPfl(String pfl) {
		this.pfl = pfl == null ? null : pfl.trim();
	}

	/**
	 * 屏品牌
	 */
	@Length(min = 0, max = 50, message = "屏品牌长度必须介于 0 和 50 之间")
	public String getPpp() {
		return ppp;
	}

	/**
	 * 屏品牌
	 */
	public void setPpp(String ppp) {
		this.ppp = ppp == null ? null : ppp.trim();
	}

	/**
	 * 屏型号
	 */
	@Length(min = 0, max = 50, message = "屏型号长度必须介于 0 和 50 之间")
	public String getPxh() {
		return pxh;
	}

	/**
	 * 屏型号
	 */
	public void setPxh(String pxh) {
		this.pxh = pxh == null ? null : pxh.trim();
	}

	/**
	 * 屏编号
	 */
	@Length(min = 0, max = 50, message = "屏编号长度必须介于 0 和 50 之间")
	public String getPbh() {
		return pbh;
	}

	/**
	 * 屏编号
	 */
	public void setPbh(String pbh) {
		this.pbh = pbh == null ? null : pbh.trim();
	}

	/**
	 * 分辨率
	 */
	@Length(min = 0, max = 20, message = "分辨率长度必须介于 0 和 20 之间")
	public String getFbl() {
		return fbl;
	}

	/**
	 * 分辨率
	 */
	public void setFbl(String fbl) {
		this.fbl = fbl == null ? null : fbl.trim();
	}

	/**
	 * 分辨率名称
	 */
	@Length(min = 0, max = 50, message = "分辨率名称长度必须介于 0 和 50 之间")
	public String getFblmc() {
		return fblmc;
	}

	/**
	 * 分辨率名称
	 */
	public void setFblmc(String fblmc) {
		this.fblmc = fblmc == null ? null : fblmc.trim();
	}

	/**
	 * 分辨率备注
	 */
	@Length(min = 0, max = 100, message = "分辨率备注长度必须介于 0 和 100 之间")
	public String getFblbz() {
		return fblbz;
	}

	/**
	 * 分辨率备注
	 */
	public void setFblbz(String fblbz) {
		this.fblbz = fblbz == null ? null : fblbz.trim();
	}

	/**
	 * 是否3D
	 */
	public Integer getSf3d() {
		return sf3d;
	}

	/**
	 * 是否3D
	 */
	public void setSf3d(Integer sf3d) {
		this.sf3d = sf3d;
	}

	/**
	 * 电源
	 */
	@Length(min = 0, max = 20, message = "电源长度必须介于 0 和 20 之间")
	public String getDy() {
		return dy;
	}

	/**
	 * 电源
	 */
	public void setDy(String dy) {
		this.dy = dy == null ? null : dy.trim();
	}

	/**
	 * 电源名称
	 */
	@Length(min = 0, max = 50, message = "电源名称长度必须介于 0 和 50 之间")
	public String getDymc() {
		return dymc;
	}

	/**
	 * 电源名称
	 */
	public void setDymc(String dymc) {
		this.dymc = dymc == null ? null : dymc.trim();
	}

	/**
	 * 电源备注
	 */
	@Length(min = 0, max = 100, message = "电源备注长度必须介于 0 和 100 之间")
	public String getDybz() {
		return dybz;
	}

	/**
	 * 电源备注
	 */
	public void setDybz(String dybz) {
		this.dybz = dybz == null ? null : dybz.trim();
	}

	/**
	 * 遥控器
	 */
	@Length(min = 0, max = 20, message = "遥控器长度必须介于 0 和 20 之间")
	public String getYkq() {
		return ykq;
	}

	/**
	 * 遥控器
	 */
	public void setYkq(String ykq) {
		this.ykq = ykq == null ? null : ykq.trim();
	}

	/**
	 * 遥控器名称
	 */
	@Length(min = 0, max = 50, message = "遥控器名称长度必须介于 0 和 50 之间")
	public String getYkqmc() {
		return ykqmc;
	}

	/**
	 * 遥控器名称
	 */
	public void setYkqmc(String ykqmc) {
		this.ykqmc = ykqmc == null ? null : ykqmc.trim();
	}

	/**
	 * 遥控器备注
	 */
	@Length(min = 0, max = 100, message = "遥控器备注长度必须介于 0 和 100 之间")
	public String getYkqbz() {
		return ykqbz;
	}

	/**
	 * 遥控器备注
	 */
	public void setYkqbz(String ykqbz) {
		this.ykqbz = ykqbz == null ? null : ykqbz.trim();
	}

	/**
	 * 插头类型
	 */
	@Length(min = 0, max = 20, message = "插头类型长度必须介于 0 和 20 之间")
	public String getCtlx() {
		return ctlx;
	}

	/**
	 * 插头类型
	 */
	public void setCtlx(String ctlx) {
		this.ctlx = ctlx == null ? null : ctlx.trim();
	}

	/**
	 * 插头类型名称
	 */
	@Length(min = 0, max = 50, message = "插头类型名称长度必须介于 0 和 50 之间")
	public String getCtlxmc() {
		return ctlxmc;
	}

	/**
	 * 插头类型名称
	 */
	public void setCtlxmc(String ctlxmc) {
		this.ctlxmc = ctlxmc == null ? null : ctlxmc.trim();
	}

	/**
	 * 外壳颜色标准
	 */
	@Length(min = 0, max = 100, message = "外壳颜色标准长度必须介于 0 和 100 之间")
	public String getWkysbz() {
		return wkysbz;
	}

	/**
	 * 外壳颜色标准
	 */
	public void setWkysbz(String wkysbz) {
		this.wkysbz = wkysbz == null ? null : wkysbz.trim();
	}

	/**
	 * 防火料-前壳
	 */
	public Integer getFhlQk() {
		return fhlQk;
	}

	/**
	 * 防火料-前壳
	 */
	public void setFhlQk(Integer fhlQk) {
		this.fhlQk = fhlQk;
	}

	/**
	 * 防火料-AV支架
	 */
	public Integer getFhlAvzj() {
		return fhlAvzj;
	}

	/**
	 * 防火料-AV支架
	 */
	public void setFhlAvzj(Integer fhlAvzj) {
		this.fhlAvzj = fhlAvzj;
	}

	/**
	 * 是否要电池
	 */
	public Integer getSfDc() {
		return sfDc;
	}

	/**
	 * 是否要电池
	 */
	public void setSfDc(Integer sfDc) {
		this.sfDc = sfDc;
	}

	/**
	 * 开机LOGO
	 */
	@Length(min = 0, max = 50, message = "开机LOGO长度必须介于 0 和 50 之间")
	public String getKjlogo() {
		return kjlogo;
	}

	/**
	 * 开机LOGO
	 */
	public void setKjlogo(String kjlogo) {
		this.kjlogo = kjlogo == null ? null : kjlogo.trim();
	}

	/**
	 * OSD出厂语言设置
	 */
	@Length(min = 0, max = 50, message = "OSD出厂语言设置长度必须介于 0 和 50 之间")
	public String getOsdccyysz() {
		return osdccyysz;
	}

	/**
	 * OSD出厂语言设置
	 */
	public void setOsdccyysz(String osdccyysz) {
		this.osdccyysz = osdccyysz == null ? null : osdccyysz.trim();
	}

	/**
	 * 模拟量标准
	 */
	@Length(min = 0, max = 20, message = "模拟量标准长度必须介于 0 和 20 之间")
	public String getMnlbz() {
		return mnlbz;
	}

	/**
	 * 模拟量标准
	 */
	public void setMnlbz(String mnlbz) {
		this.mnlbz = mnlbz == null ? null : mnlbz.trim();
	}

	/**
	 * 模拟量标准名称
	 */
	@Length(min = 0, max = 50, message = "模拟量标准名称长度必须介于 0 和 50 之间")
	public String getMnlbzmc() {
		return mnlbzmc;
	}

	/**
	 * 模拟量标准名称
	 */
	public void setMnlbzmc(String mnlbzmc) {
		this.mnlbzmc = mnlbzmc == null ? null : mnlbzmc.trim();
	}

	/**
	 * 模拟量标准备注
	 */
	@Length(min = 0, max = 100, message = "模拟量标准备注长度必须介于 0 和 100 之间")
	public String getMnlbzbz() {
		return mnlbzbz;
	}

	/**
	 * 模拟量标准备注
	 */
	public void setMnlbzbz(String mnlbzbz) {
		this.mnlbzbz = mnlbzbz == null ? null : mnlbzbz.trim();
	}

	/**
	 * 质量标准
	 */
	@Length(min = 0, max = 20, message = "质量标准长度必须介于 0 和 20 之间")
	public String getZlbz() {
		return zlbz;
	}

	/**
	 * 质量标准
	 */
	public void setZlbz(String zlbz) {
		this.zlbz = zlbz == null ? null : zlbz.trim();
	}

	/**
	 * 质量标准名称
	 */
	@Length(min = 0, max = 50, message = "质量标准名称长度必须介于 0 和 50 之间")
	public String getZlbzmc() {
		return zlbzmc;
	}

	/**
	 * 质量标准名称
	 */
	public void setZlbzmc(String zlbzmc) {
		this.zlbzmc = zlbzmc == null ? null : zlbzmc.trim();
	}

	/**
	 * 质量标准备注
	 */
	@Length(min = 0, max = 100, message = "质量标准备注长度必须介于 0 和 100 之间")
	public String getZlbzbz() {
		return zlbzbz;
	}

	/**
	 * 质量标准备注
	 */
	public void setZlbzbz(String zlbzbz) {
		this.zlbzbz = zlbzbz == null ? null : zlbzbz.trim();
	}

	/**
	 * 是否实验报告
	 */
	public Integer getSfSybg() {
		return sfSybg;
	}

	/**
	 * 是否实验报告
	 */
	public void setSfSybg(Integer sfSybg) {
		this.sfSybg = sfSybg;
	}

	/**
	 * 实验报告备注
	 */
	@Length(min = 0, max = 100, message = "实验报告备注长度必须介于 0 和 100 之间")
	public String getSybgbz() {
		return sybgbz;
	}

	/**
	 * 实验报告备注
	 */
	public void setSybgbz(String sybgbz) {
		this.sybgbz = sybgbz == null ? null : sybgbz.trim();
	}

	/**
	 * 音视频支持格式
	 */
	@Length(min = 0, max = 50, message = "音视频支持格式长度必须介于 0 和 50 之间")
	public String getYspzcgs() {
		return yspzcgs;
	}

	/**
	 * 音视频支持格式
	 */
	public void setYspzcgs(String yspzcgs) {
		this.yspzcgs = yspzcgs == null ? null : yspzcgs.trim();
	}

	/**
	 * 音视频支持格式名称
	 */
	@Length(min = 0, max = 100, message = "音视频支持格式名称长度必须介于 0 和 100 之间")
	public String getYspzcgsmc() {
		return yspzcgsmc;
	}

	/**
	 * 音视频支持格式名称
	 */
	public void setYspzcgsmc(String yspzcgsmc) {
		this.yspzcgsmc = yspzcgsmc == null ? null : yspzcgsmc.trim();
	}

	/**
	 * 音视频支持格式备注
	 */
	@Length(min = 0, max = 100, message = "音视频支持格式备注长度必须介于 0 和 100 之间")
	public String getYspzcgebz() {
		return yspzcgebz;
	}

	/**
	 * 音视频支持格式备注
	 */
	public void setYspzcgebz(String yspzcgebz) {
		this.yspzcgebz = yspzcgebz == null ? null : yspzcgebz.trim();
	}

	/**
	 * 网络功能要求
	 */
	@Length(min = 0, max = 50, message = "网络功能要求长度必须介于 0 和 50 之间")
	public String getWlgnyq() {
		return wlgnyq;
	}

	/**
	 * 网络功能要求
	 */
	public void setWlgnyq(String wlgnyq) {
		this.wlgnyq = wlgnyq == null ? null : wlgnyq.trim();
	}

	/**
	 * 网络功能要求名称
	 */
	@Length(min = 0, max = 100, message = "网络功能要求名称长度必须介于 0 和 100 之间")
	public String getWlgnyqmc() {
		return wlgnyqmc;
	}

	/**
	 * 网络功能要求名称
	 */
	public void setWlgnyqmc(String wlgnyqmc) {
		this.wlgnyqmc = wlgnyqmc == null ? null : wlgnyqmc.trim();
	}

	/**
	 * 网络功能要求备注
	 */
	@Length(min = 0, max = 100, message = "网络功能要求备注长度必须介于 0 和 100 之间")
	public String getWlgnyqbz() {
		return wlgnyqbz;
	}

	/**
	 * 网络功能要求备注
	 */
	public void setWlgnyqbz(String wlgnyqbz) {
		this.wlgnyqbz = wlgnyqbz == null ? null : wlgnyqbz.trim();
	}

	/**
	 * 其他备注
	 */
	@Length(min = 0, max = 200, message = "其他备注长度必须介于 0 和 200 之间")
	public String getQtbz() {
		return qtbz;
	}

	/**
	 * 其他备注
	 */
	public void setQtbz(String qtbz) {
		this.qtbz = qtbz == null ? null : qtbz.trim();
	}

	/**
	 * 附件
	 */
	@Length(min = 0, max = 100, message = "附件长度必须介于 0 和 100 之间")
	public String getFj() {
		return fj;
	}

	/**
	 * 附件
	 */
	public void setFj(String fj) {
		this.fj = fj == null ? null : fj.trim();
	}

	/**
	 * 电子工程师
	 */
	@Length(min = 0, max = 20, message = "电子工程师长度必须介于 0 和 20 之间")
	public String getDzgcs() {
		return dzgcs;
	}

	/**
	 * 电子工程师
	 */
	public void setDzgcs(String dzgcs) {
		this.dzgcs = dzgcs == null ? null : dzgcs.trim();
	}

	/**
	 * 电子工程师名称
	 */
	@Length(min = 0, max = 50, message = "电子工程师名称长度必须介于 0 和 50 之间")
	public String getDzgcsmc() {
		return dzgcsmc;
	}

	/**
	 * 电子工程师名称
	 */
	public void setDzgcsmc(String dzgcsmc) {
		this.dzgcsmc = dzgcsmc == null ? null : dzgcsmc.trim();
	}

	/**
	 * 电源工程师
	 */
	@Length(min = 0, max = 20, message = "电源工程师长度必须介于 0 和 20 之间")
	public String getDygcs() {
		return dygcs;
	}

	/**
	 * 电源工程师
	 */
	public void setDygcs(String dygcs) {
		this.dygcs = dygcs == null ? null : dygcs.trim();
	}

	/**
	 * 电源工程师名称
	 */
	@Length(min = 0, max = 50, message = "电源工程师名称长度必须介于 0 和 50 之间")
	public String getDygcsmc() {
		return dygcsmc;
	}

	/**
	 * 电源工程师名称
	 */
	public void setDygcsmc(String dygcsmc) {
		this.dygcsmc = dygcsmc == null ? null : dygcsmc.trim();
	}

	/**
	 * 结构工程师
	 */
	@Length(min = 0, max = 20, message = "结构工程师长度必须介于 0 和 20 之间")
	public String getJggcs() {
		return jggcs;
	}

	/**
	 * 结构工程师
	 */
	public void setJggcs(String jggcs) {
		this.jggcs = jggcs == null ? null : jggcs.trim();
	}

	/**
	 * 结构工程师名称
	 */
	@Length(min = 0, max = 50, message = "结构工程师名称长度必须介于 0 和 50 之间")
	public String getJggcsmc() {
		return jggcsmc;
	}

	/**
	 * 结构工程师名称
	 */
	public void setJggcsmc(String jggcsmc) {
		this.jggcsmc = jggcsmc == null ? null : jggcsmc.trim();
	}

	/**
	 * 网络
	 */
	@Length(min = 0, max = 20, message = "网络长度必须介于 0 和 20 之间")
	public String getWl() {
		return wl;
	}

	/**
	 * 网络
	 */
	public void setWl(String wl) {
		this.wl = wl == null ? null : wl.trim();
	}

	/**
	 * 网络名称
	 */
	@Length(min = 0, max = 50, message = "网络名称长度必须介于 0 和 50 之间")
	public String getWlmc() {
		return wlmc;
	}

	/**
	 * 网络名称
	 */
	public void setWlmc(String wlmc) {
		this.wlmc = wlmc == null ? null : wlmc.trim();
	}

	/**
	 * 结构组件号
	 */
	@Length(min = 0, max = 50, message = "结构组件号长度必须介于 0 和 50 之间")
	public String getJgzjh() {
		return jgzjh;
	}

	/**
	 * 结构组件号
	 */
	public void setJgzjh(String jgzjh) {
		this.jgzjh = jgzjh == null ? null : jgzjh.trim();
	}

	/**
	 * 电源组件号
	 */
	@Length(min = 0, max = 50, message = "电源组件号长度必须介于 0 和 50 之间")
	public String getDyzjh() {
		return dyzjh;
	}

	/**
	 * 电源组件号
	 */
	public void setDyzjh(String dyzjh) {
		this.dyzjh = dyzjh == null ? null : dyzjh.trim();
	}

	/**
	 * 电子组件号
	 */
	@Length(min = 0, max = 50, message = "电子组件号长度必须介于 0 和 50 之间")
	public String getDzzjh() {
		return dzzjh;
	}

	/**
	 * 电子组件号
	 */
	public void setDzzjh(String dzzjh) {
		this.dzzjh = dzzjh == null ? null : dzzjh.trim();
	}

	/**
	 * 恒流组件号
	 */
	@Length(min = 0, max = 50, message = "恒流组件号长度必须介于 0 和 50 之间")
	public String getHlzjh() {
		return hlzjh;
	}

	/**
	 * 恒流组件号
	 */
	public void setHlzjh(String hlzjh) {
		this.hlzjh = hlzjh == null ? null : hlzjh.trim();
	}

	/**
	 * 建议样机数量
	 */
	public Double getJyyjsl() {
		return jyyjsl;
	}

	/**
	 * 建议样机数量
	 */
	public void setJyyjsl(Double jyyjsl) {
		this.jyyjsl = jyyjsl;
	}

	/**
	 * 挂架备注
	 */
	@Length(min = 0, max = 100, message = "挂架备注长度必须介于 0 和 100 之间")
	public String getGuajiabz() {
		return guajiabz;
	}

	/**
	 * 挂架备注
	 */
	public void setGuajiabz(String guajiabz) {
		this.guajiabz = guajiabz == null ? null : guajiabz.trim();
	}

	/**
	 * 挂架包装
	 */
	@Length(min = 0, max = 20, message = "挂架包装长度必须介于 0 和 20 之间")
	public String getGjbz() {
		return gjbz;
	}

	/**
	 * 挂架包装
	 */
	public void setGjbz(String gjbz) {
		this.gjbz = gjbz == null ? null : gjbz.trim();
	}

	/**
	 * 挂架包装名称
	 */
	@Length(min = 0, max = 50, message = "挂架包装名称长度必须介于 0 和 50 之间")
	public String getGjbzmc() {
		return gjbzmc;
	}

	/**
	 * 挂架包装名称
	 */
	public void setGjbzmc(String gjbzmc) {
		this.gjbzmc = gjbzmc == null ? null : gjbzmc.trim();
	}

	/**
	 * 底座包装
	 */
	@Length(min = 0, max = 20, message = "底座包装长度必须介于 0 和 20 之间")
	public String getDzbz() {
		return dzbz;
	}

	/**
	 * 底座包装
	 */
	public void setDzbz(String dzbz) {
		this.dzbz = dzbz == null ? null : dzbz.trim();
	}

	/**
	 * 底座包装名称
	 */
	@Length(min = 0, max = 50, message = "底座包装名称长度必须介于 0 和 50 之间")
	public String getDzbzmc() {
		return dzbzmc;
	}

	/**
	 * 底座包装名称
	 */
	public void setDzbzmc(String dzbzmc) {
		this.dzbzmc = dzbzmc == null ? null : dzbzmc.trim();
	}

	/**
	 * 备注
	 */
	@Length(min = 0, max = 100, message = "备注长度必须介于 0 和 100 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
	 * 备注
	 */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
	}

	/**
	 * 创建人
	 */
	@Length(min = 1, max = 20, message = "创建人长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
	 * 创建人
	 */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}

	/**
	 * 创建人名称
	 */
	@Length(min = 1, max = 50, message = "创建人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
	 * 创建人名称
	 */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "创建时间不能为空")
	public Date getCjsj() {
		return cjsj;
	}

	/**
	 * 创建时间
	 */
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	/**
	 * 状态
	 */
	@NotNull(message = "状态不能为空")
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
	 * 时间戳
	 */
	@Length(min = 1, max = 20, message = "时间戳长度必须介于 1 和 20 之间")
	public String getSjc() {
		return sjc;
	}

	/**
	 * 时间戳
	 */
	public void setSjc(String sjc) {
		this.sjc = sjc == null ? null : sjc.trim();
	}

	/**
	 * 推送SAP状态
	 */
	public Integer getTssapzt() {
		return tssapzt;
	}

	/**
	 * 推送SAP状态
	 */
	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
	}

	public Integer getPidyjsl() {
		return pidyjsl;
	}

	public void setPidyjsl(Integer pidyjsl) {
		this.pidyjsl = pidyjsl;
	}

	public String getPidxh() {
		return pidxh;
	}

	public void setPidxh(String pidxh) {
		this.pidxh = pidxh;
	}

	public Integer getRz1Cet() {
		return rz1Cet;
	}

	public void setRz1Cet(Integer rz1Cet) {
		this.rz1Cet = rz1Cet;
	}

	public Integer getRz1Paq() {
		return rz1Paq;
	}

	public void setRz1Paq(Integer rz1Paq) {
		this.rz1Paq = rz1Paq;
	}

	public Integer getRz1Nom() {
		return rz1Nom;
	}

	public void setRz1Nom(Integer rz1Nom) {
		this.rz1Nom = rz1Nom;
	}

	public Integer getRz1Raq() {
		return rz1Raq;
	}

	public void setRz1Raq(Integer rz1Raq) {
		this.rz1Raq = rz1Raq;
	}

	public Integer getRz1Smaq() {
		return rz1Smaq;
	}

	public void setRz1Smaq(Integer rz1Smaq) {
		this.rz1Smaq = rz1Smaq;
	}

	public Integer getRz2Pe() {
		return rz2Pe;
	}

	public void setRz2Pe(Integer rz2Pe) {
		this.rz2Pe = rz2Pe;
	}

	public Integer getRz2Rr() {
		return rz2Rr;
	}

	public void setRz2Rr(Integer rz2Rr) {
		this.rz2Rr = rz2Rr;
	}

	public Integer getRz2Rtte() {
		return rz2Rtte;
	}

	public void setRz2Rtte(Integer rz2Rtte) {
		this.rz2Rtte = rz2Rtte;
	}

	public Integer getRz2Sme() {
		return rz2Sme;
	}

	public void setRz2Sme(Integer rz2Sme) {
		this.rz2Sme = rz2Sme;
	}

	public Integer getRz3Dd() {
		return rz3Dd;
	}

	public void setRz3Dd(Integer rz3Dd) {
		this.rz3Dd = rz3Dd;
	}

	public Integer getRz3Ddj() {
		return rz3Ddj;
	}

	public void setRz3Ddj(Integer rz3Ddj) {
		this.rz3Ddj = rz3Ddj;
	}

	public Integer getRz3Dts() {
		return rz3Dts;
	}

	public void setRz3Dts(Integer rz3Dts) {
		this.rz3Dts = rz3Dts;
	}

	public Integer getRz3Cij() {
		return rz3Cij;
	}

	public void setRz3Cij(Integer rz3Cij) {
		this.rz3Cij = rz3Cij;
	}

	public Integer getRz3Mhl() {
		return rz3Mhl;
	}

	public void setRz3Mhl(Integer rz3Mhl) {
		this.rz3Mhl = rz3Mhl;
	}

	public Integer getRz3Bqb() {
		return rz3Bqb;
	}

	public void setRz3Bqb(Integer rz3Bqb) {
		this.rz3Bqb = rz3Bqb;
	}

	public Integer getRz4Erp() {
		return rz4Erp;
	}

	public void setRz4Erp(Integer rz4Erp) {
		this.rz4Erp = rz4Erp;
	}

	public Integer getRz4Gems() {
		return rz4Gems;
	}

	public void setRz4Gems(Integer rz4Gems) {
		this.rz4Gems = rz4Gems;
	}

	public Integer getRz4Bee() {
		return rz4Bee;
	}

	public void setRz4Bee(Integer rz4Bee) {
		this.rz4Bee = rz4Bee;
	}

	public Integer getRz4Nrc() {
		return rz4Nrc;
	}

	public void setRz4Nrc(Integer rz4Nrc) {
		this.rz4Nrc = rz4Nrc;
	}

	public Integer getRz4Nfnx() {
		return rz4Nfnx;
	}

	public void setRz4Nfnx(Integer rz4Nfnx) {
		this.rz4Nfnx = rz4Nfnx;
	}

	public Integer getRz4Es7() {
		return rz4Es7;
	}

	public void setRz4Es7(Integer rz4Es7) {
		this.rz4Es7 = rz4Es7;
	}

	public String getRz4Bz() {
		return rz4Bz;
	}

	public void setRz4Bz(String rz4Bz) {
		this.rz4Bz = rz4Bz;
	}

	public Integer getRz5Qt() {
		return rz5Qt;
	}

	public void setRz5Qt(Integer rz5Qt) {
		this.rz5Qt = rz5Qt;
	}

	public Integer getZlmc1() {
		return zlmc1;
	}

	public void setZlmc1(Integer zlmc1) {
		this.zlmc1 = zlmc1;
	}

	public Integer getZlmc2() {
		return zlmc2;
	}

	public void setZlmc2(Integer zlmc2) {
		this.zlmc2 = zlmc2;
	}

	public Integer getZlmc3() {
		return zlmc3;
	}

	public void setZlmc3(Integer zlmc3) {
		this.zlmc3 = zlmc3;
	}

	public Integer getZlmc4() {
		return zlmc4;
	}

	public void setZlmc4(Integer zlmc4) {
		this.zlmc4 = zlmc4;
	}

	public Integer getZlmc5() {
		return zlmc5;
	}

	public void setZlmc5(Integer zlmc5) {
		this.zlmc5 = zlmc5;
	}

	public Integer getZlmc6() {
		return zlmc6;
	}

	public void setZlmc6(Integer zlmc6) {
		this.zlmc6 = zlmc6;
	}

	public Integer getZlmc7() {
		return zlmc7;
	}

	public void setZlmc7(Integer zlmc7) {
		this.zlmc7 = zlmc7;
	}

	public Integer getZlmc8() {
		return zlmc8;
	}

	public void setZlmc8(Integer zlmc8) {
		this.zlmc8 = zlmc8;
	}

	public Integer getZlmc9() {
		return zlmc9;
	}

	public void setZlmc9(Integer zlmc9) {
		this.zlmc9 = zlmc9;
	}

	public Integer getZlmc10() {
		return zlmc10;
	}

	public void setZlmc10(Integer zlmc10) {
		this.zlmc10 = zlmc10;
	}

	public Integer getZlmc11() {
		return zlmc11;
	}

	public void setZlmc11(Integer zlmc11) {
		this.zlmc11 = zlmc11;
	}

	public Integer getZlmc12() {
		return zlmc12;
	}

	public void setZlmc12(Integer zlmc12) {
		this.zlmc12 = zlmc12;
	}

	public Integer getZlmc13() {
		return zlmc13;
	}

	public void setZlmc13(Integer zlmc13) {
		this.zlmc13 = zlmc13;
	}

	public Integer getZlmc14() {
		return zlmc14;
	}

	public void setZlmc14(Integer zlmc14) {
		this.zlmc14 = zlmc14;
	}

	public Integer getZlmc15() {
		return zlmc15;
	}

	public void setZlmc15(Integer zlmc15) {
		this.zlmc15 = zlmc15;
	}

	public Integer getZlmc16() {
		return zlmc16;
	}

	public void setZlmc16(Integer zlmc16) {
		this.zlmc16 = zlmc16;
	}

	public Integer getZlmc17() {
		return zlmc17;
	}

	public void setZlmc17(Integer zlmc17) {
		this.zlmc17 = zlmc17;
	}

	public Integer getZlmc21() {
		return zlmc21;
	}

	public void setZlmc21(Integer zlmc21) {
		this.zlmc21 = zlmc21;
	}

	public Integer getZlmc22() {
		return zlmc22;
	}

	public void setZlmc22(Integer zlmc22) {
		this.zlmc22 = zlmc22;
	}

	public Integer getPtmc1() {
		return ptmc1;
	}

	public void setPtmc1(Integer ptmc1) {
		this.ptmc1 = ptmc1;
	}

	public Integer getPtmc2() {
		return ptmc2;
	}

	public void setPtmc2(Integer ptmc2) {
		this.ptmc2 = ptmc2;
	}

	public Integer getPtmc3() {
		return ptmc3;
	}

	public void setPtmc3(Integer ptmc3) {
		this.ptmc3 = ptmc3;
	}

	public Integer getPtmc4() {
		return ptmc4;
	}

	public void setPtmc4(Integer ptmc4) {
		this.ptmc4 = ptmc4;
	}

	public Integer getPtmc5() {
		return ptmc5;
	}

	public void setPtmc5(Integer ptmc5) {
		this.ptmc5 = ptmc5;
	}

	public Integer getPtmc6() {
		return ptmc6;
	}

	public void setPtmc6(Integer ptmc6) {
		this.ptmc6 = ptmc6;
	}

	public Integer getPtmc7() {
		return ptmc7;
	}

	public void setPtmc7(Integer ptmc7) {
		this.ptmc7 = ptmc7;
	}

	public Integer getPtmc8() {
		return ptmc8;
	}

	public void setPtmc8(Integer ptmc8) {
		this.ptmc8 = ptmc8;
	}

	public Integer getPtmc9() {
		return ptmc9;
	}

	public void setPtmc9(Integer ptmc9) {
		this.ptmc9 = ptmc9;
	}

	public Integer getPtmc10() {
		return ptmc10;
	}

	public void setPtmc10(Integer ptmc10) {
		this.ptmc10 = ptmc10;
	}

	public Integer getPtmc11() {
		return ptmc11;
	}

	public void setPtmc11(Integer ptmc11) {
		this.ptmc11 = ptmc11;
	}

	public Integer getPtmc12() {
		return ptmc12;
	}

	public void setPtmc12(Integer ptmc12) {
		this.ptmc12 = ptmc12;
	}

	public Integer getPtmc13() {
		return ptmc13;
	}

	public void setPtmc13(Integer ptmc13) {
		this.ptmc13 = ptmc13;
	}

	public Integer getPtmc14() {
		return ptmc14;
	}

	public void setPtmc14(Integer ptmc14) {
		this.ptmc14 = ptmc14;
	}

	public Integer getPtmc15() {
		return ptmc15;
	}

	public void setPtmc15(Integer ptmc15) {
		this.ptmc15 = ptmc15;
	}

	public Integer getPtmc16() {
		return ptmc16;
	}

	public void setPtmc16(Integer ptmc16) {
		this.ptmc16 = ptmc16;
	}

	public Integer getPtmc17() {
		return ptmc17;
	}

	public void setPtmc17(Integer ptmc17) {
		this.ptmc17 = ptmc17;
	}

	public Integer getPtmc18() {
		return ptmc18;
	}

	public void setPtmc18(Integer ptmc18) {
		this.ptmc18 = ptmc18;
	}

	public Integer getPtmc19() {
		return ptmc19;
	}

	public void setPtmc19(Integer ptmc19) {
		this.ptmc19 = ptmc19;
	}

	public Integer getPtmc20() {
		return ptmc20;
	}

	public void setPtmc20(Integer ptmc20) {
		this.ptmc20 = ptmc20;
	}

	public Integer getPtmc21() {
		return ptmc21;
	}

	public void setPtmc21(Integer ptmc21) {
		this.ptmc21 = ptmc21;
	}

}