package com.ey.piit.sdo.orderProduct.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 大货订单管理Entity
 * 
 * @author 魏诚
 */
public class OrderProductNew extends BaseEntity {

	private String ddid; // 订单号
	private String ckddh; // 参考订单号
	private String glddh; // 关联订单号
	private String gsbm; // 公司编码
	private String gsmc; // 公司名称
	private String ddbmlx; // 订单编码类型
	private String ddbmlxmc; // 订单编码类型名称
	private String ddlx; // 订单类型
	private String ddlxmc; // 订单类型名称
	private String ddlb; // 订单类别
	private String ddlbmc; // 订单类别名称
	private String ywlx; // 业务类型
	private String ywlxmc; // 业务类型名称
	private String xsyid; // 销售员
	private String xsymc; // 销售员名称
	private String ywz; // 业务组
	private String ywzmc; // 业务组名称
	private String xszz; // 销售组织
	private String xszzmc; // 销售组织名称
	private String pid; // PID
	private String wsxh; // 我司型号
	private String jixin; // 机芯
	private String mjxh; // 买家型号
	private Integer sfWxdd; // 是否外协订单
	private Integer sfNxyfcp; // 是否内销研发产品
	private String ggmx; // 规格明细
	private String ggmxmc; // 规格明细名称
	private String ggmxbz; // 规格明细备注
	private Integer sfXp; // 是否新品
	private String bz; // 币种
	private String fktj; // 付款条件
	private String fktjmc; // 付款条件名称
	private String gjmytk; // 国际贸易条款
	private String gjmytkmc; // 国际贸易条款名称
	private String gjmytkbz; // 国际贸易条款备注
	private Integer sl; // 数量
	private BigDecimal dj; // 单价
	private BigDecimal je; // 金额
	private BigDecimal ffbsje; // 付费备损金额
	private BigDecimal zje; // 总金额
	private String zhfs; // 走货方式
	private String zhfsmc; // 走货方式名称
	private Integer zhbhwjP; // 走货不含物件-屏
	private Integer zhbhwjJk; // 走货不含物件-机壳
	private Integer zhbhwjYkq; // 走货不含物件-遥控器
	private Integer zhbhwjLb; // 走货不含物件-喇叭
	private Integer zhbhwjZx; // 走货不含物件-纸箱
	private Integer zhbhwjPm; // 走货不含物件-泡沫
	private Integer zhbhwjJxZb; // 走货不含物件-机芯+主板
	private Integer xddzhP; // 需单独走货-屏
	private Integer xddzhJk; // 需单独走货-机壳
	private Integer xddzhLb; // 需单独走货-喇叭
	private Integer xddzhZx; // 需单独走货-纸箱
	private Integer xddzhJxZb; // 需单独走货-机芯+主板
	private String cylx; // 出运类型
	private String cylxmc; // 出运类型名称
	private String cylxbz; // 出运类型备注
	private Date jhrq; // 交货日期
	private Date fgsshrq; // 分公司收货日期
	private Integer sfYh; // 是否验货
	private String yczs; // 预测周数
	private String sfyhbz; // 是否验货备注
	private Date ycrq; // 预测日期
	private Date yhrq; // 验货日期
	private Long ycsl; // 预测数量
	private String jbxxbz; // 基本信息备注
	private String khbm; // 客户编码
	private String khmc; // 客户名称
	private String xwgj; // 销往国家
	private String xwgjmc; // 销往国家名称
	private String sq; // 时区
	private String pp; // 品牌
	private String ccyy; // 出厂语言
	private String ccyymc; // 出厂语言名称
	private String kjlogo; // 开机LOGO
	private String kjlogofj; // 开机LOGO附件
	private String ppp; // 屏品牌
	private String pxh; // 屏型号
	private String pbm; // 屏编码
	private String pxxbc; // 屏信息补充
	// private Integer sf3d; // 是否3D
	private String fbl; // 分辨率
	private String fblmc; // 分辨率名称
	private String fblbz; // 分辨率备注
	private String pld; // 屏亮点
	private String pldmc; // 屏亮点名称
	private String pbzyq; // 屏包装要求
	private String pbzyqmc; // 屏包装要求名称
	private String pbzyqbz; // 屏包装要求备注
	private Integer rz1Cb; // 认证1-CB
	private Integer rz1Ce; // 认证1-CE
	private Integer rz1Etl; // 认证1-ETL
	private Integer rz1Ul; // 认证1-UL
	private Integer rz1Pse; // 认证1-PSE
	private Integer rz1Rf; // 认证1-RF
	private Integer rz1Rte; // 认证1-RTE
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
	private Integer sfRohs; // 是否要RoHS
	private String ctlx; // 插头类型
	private String ctlxmc; // 插头类型名称
	private String ctlxbz; // 插头类型备注
	private Integer sfSpq; // 是否要适配器
	private Integer sfReach; // 是否需要REACH
	private String wkysbz; // 外壳颜色标准
	private String paomo; // 泡沫
	private String paomomc; // 泡沫名称
	private String paomobz; // 泡沫备注
	private Integer fhlQk; // 防火料-前壳
	private Integer fhlHk; // 防火料-后壳
	private Integer fhlDzjlz; // 防火料-底座及立柱
	private Integer fhlAvzj; // 防火料-AV支架
	private Integer fhlBxy; // 防火料-不需要
	private String fhlBz; // 防火料备注
	private Integer sfDc; // 是否要电池
	private String guajia; // 挂架
	private String guajiamc; // 挂架名称
	private String guajiabz; // 挂架备注
	private Integer fhlQt; // 防火料-其他
	private String gjbz; // 挂架包装
	private String gjbzmc; // 挂架包装名称
	private String gjbzbz; // 挂架包装备注
	// private Integer sf3dyj; // 是否要3D眼镜
	private String dzbz; // 底座包装
	private String dzbzmc; // 底座包装名称
	private String dzbzbz; // 底座包装备注
	private String qtfjbz; // 其他附件备注
	private Integer sfFfbs; // 是否付费备损
	private String ffbsqdfj; // 付费备损清单附件
	private String mfbs; // 免费备损
	private String mfbsmc; // 免费备损名称
	private Double mfbsbl; // 免费备损比例
	private String mfbsqdfj; // 免费备损清单附件
	private String bsbz; // 备损包装
	private String bsbzmc; // 备损包装名称
	private String bsbzbz; // 备损包装备注
	private String gdbslzg; // 跟单备损料走柜
	private String gdbslzgmc; // 跟单备损料走柜名称
	private String bsxxbz; // 备损信息备注
	private Integer sfP; // 是否有屏
	private Integer sfIc; // 是否需要IC程序烧录
	private String sfShckdflgy; // 是否S/H/CKD辅料供应
	private String skdqkxjgpj; // SKD前壳需加工配件
	private String shckdjgyq; // S/H/CKD加工要求
	private String shckdjgyqbz; // S/H/CKD加工要求附件
	private String shckdxcxwlmx; // S/H/CKD需成型物料明细
	private String shckdxcxwlmxfj; // S/H/CKD需成型物料明细附件
	private String cpqtyqbz; // 产品其他要求备注
	private String cpqtyqfj; // 产品其他要求附件
	private String zdrid; // 制单人
	private String zdrmc; // 制单人名称
	private Date zdsj; // 制单时间
	private Integer zt; // 状态
	private Integer bbh; // 版本号
	private String sjc; // 时间戳
	private Integer fkbzzt; // 付款保障状态
	private Integer tssapzt; // 推送SAP状态
	private String scjd; // 生产基地
	private String scjdmc; // 生产基地
	private String yddid; // 原订单id
	private Integer sfBg; // 是否变更
	private String bgbz; // 变更备注
	private Integer sfFjelbg; // 是否非金额类变更
	private String fzbgbz;// 辅助变更备注
	private String jgfs;// 加工方式
	private String jgfsmc;// 加工方式名称
	private String qd; // 渠道
	private String qdmc; // 渠道名称
	private Integer sfCh; // 是否撤回
	private Integer mztzDsky; // 模组贴纸-带SKYWORTH
	private Integer mztzBdsky; // 模组贴纸-不带SKYWORTH
	private Integer mztzDmichina; // 模组贴纸-带MADE IN CHINA
	private Integer mztzBdmichina; // 模组贴纸-不带MADE IN CHINA
	private Integer wbzxtzDsky; // 外包装箱贴纸-带SKYWORTH
	private Integer wbzxtzBdsky; // 外包装箱贴纸-不带SKYWORTH
	private Integer wbzxtzDmichina; // 外包装箱贴纸-带MADE IN CHINA
	private Integer wbzxtzBdmichina; // 外包装箱贴纸-不带MADE IN CHINA
	private Integer kbchjdbyqP; // 是否需要带卡板出货及打包要求-屏
	private Integer kbchjdbyqSj; // 是否需要带卡板出货及打包要求-散件
	private Integer kbchjdbyqZj; // 是否需要带卡板出货及打包要求-整机
	private Integer kbchjdbyqJzj; // 是否需要带卡板出货及打包要求-假整机
	private Integer dzpop; // 电子POP
	private String kjms; // 开机模式选项
	private String kjmsmc; // 开机模式选项名称
	private BigDecimal yzhje; // 已走货金额
	private Integer sfZt; // 是否暂停
	private Integer sfBhm;// 屏是否需要保护摸
	private String cbuwlfj;// cub物料附件
	private String wjbh;	//文件编号
	private Integer rz1Cet;		// 认证1：安全-cETLus
	private Integer rz1Paq;		// 认证1：安全-PSE-安全
	private Integer rz1Nom;		// 认证1：安全-NOM
	private Integer rz1Raq;		// 认证1：安全-RED-安全
	private Integer rz1Smaq;	// 认证1：安全-S-mark 安全
	private Integer rz2Pe;		// 认证2：电磁兼容-PSE-EMC
	private Integer rz2Rr;		// 认证2：电磁兼容-RED-RF
	private Integer rz2Rtte;	// 认证2：电磁兼容-RTTE
	private Integer rz2Sme;		// 认证2：电磁兼容-S-mark -EMC
	private Integer rz3Dd;		// 认证3：专利-DD
	private Integer rz3Ddj;		// 认证3：专利-DD+
	private Integer rz3Dts;		// 认证3：专利-DTS
	private Integer rz3Cij;		// 认证3：专利-CI+
	private Integer rz3Mhl;		// 认证3：专利-MHL
	private Integer rz3Bqb;		// 认证3：专利-BQB
	private Integer rz4Erp;		// 认证4：能效-ERP
	private Integer rz4Gems;	// 认证4：能效-GEMS
	private Integer rz4Bee;		// 认证4：能效-BEE
	private Integer rz4Nrc;		// 认证4：能效-NRcan
	private Integer rz4Nfnx;	// 认证4：能效-南非能效
	private Integer rz4Es7;		// 认证4：能效-Energy star 7.0
	private String rz4Bz;		//认证4：能效-备注
	private Integer rz5Qt;		// 认证5：其他-其他L
	private Integer rz4Eg;		//认证4：能效-Energy Guide
	private Integer rz1Cetl;	//认证1：安全-cETL
	private Integer sfMzckd;	//是否模组CKD
	private Integer yjsl;	//样机数量
	private String gysbm;	//供应商编码
	private String gysmc;	//供应商名称
	
	private String zhm;		//走货码
	private String zhmmc;	//走货码名称
	private String dsjlx;		//走货码
	private String dsjlxmc;	//走货码名称
	private String version;//	n	varchar2(20)	y			版本号
	private String versionmc;//	n	varchar2(50)	y			版本名称
	private String bs;//	n	varchar2(20)	y			标识号
	private String bsmc;//	n	varchar2(50)	y			标识名称
	private String zhmt;//	n	varchar2(20)	y			走货码2
	private String zhmmct;//	n	varchar2(200)	y			走货码名称2
	private String versiont;//	n	varchar2(20)	y			版本号2
	private String versionmct;//	n	varchar2(50)	y			版本名称2
	private String bst;//	n	varchar2(20)	y			标识号2
	private String bsmct;//	n	varchar2(50)	y			标识名称2
	
	
	private String mgrwdh;		// 美工任务单号
	private String xlh; // 序列号
	private String xlhmc; // 序列号名称
	private String xlhbz; // 序列号备注
	private String xlhqt; // 序列号其他
	private String mgqtyqbz; // 美工其他要求备注

	public Integer getSfBhm() {
		return sfBhm;
	}

	public String getCbuwlfj() {
		return cbuwlfj;
	}

	public void setCbuwlfj(String cbuwlfj) {
		this.cbuwlfj = cbuwlfj;
	}

	public void setSfBhm(Integer sfBhm) {
		this.sfBhm = sfBhm;
	}

	public Integer getMztzDsky() {
		return mztzDsky;
	}

	public void setMztzDsky(Integer mztzDsky) {
		this.mztzDsky = mztzDsky;
	}

	public Integer getMztzBdsky() {
		return mztzBdsky;
	}

	public void setMztzBdsky(Integer mztzBdsky) {
		this.mztzBdsky = mztzBdsky;
	}

	public Integer getMztzDmichina() {
		return mztzDmichina;
	}

	public void setMztzDmichina(Integer mztzDmichina) {
		this.mztzDmichina = mztzDmichina;
	}

	public Integer getMztzBdmichina() {
		return mztzBdmichina;
	}

	public void setMztzBdmichina(Integer mztzBdmichina) {
		this.mztzBdmichina = mztzBdmichina;
	}

	public Integer getWbzxtzDsky() {
		return wbzxtzDsky;
	}

	public void setWbzxtzDsky(Integer wbzxtzDsky) {
		this.wbzxtzDsky = wbzxtzDsky;
	}

	public Integer getWbzxtzBdsky() {
		return wbzxtzBdsky;
	}

	public void setWbzxtzBdsky(Integer wbzxtzBdsky) {
		this.wbzxtzBdsky = wbzxtzBdsky;
	}

	public Integer getWbzxtzDmichina() {
		return wbzxtzDmichina;
	}

	public void setWbzxtzDmichina(Integer wbzxtzDmichina) {
		this.wbzxtzDmichina = wbzxtzDmichina;
	}

	public Integer getWbzxtzBdmichina() {
		return wbzxtzBdmichina;
	}

	public void setWbzxtzBdmichina(Integer wbzxtzBdmichina) {
		this.wbzxtzBdmichina = wbzxtzBdmichina;
	}

	public Integer getKbchjdbyqP() {
		return kbchjdbyqP;
	}

	public void setKbchjdbyqP(Integer kbchjdbyqP) {
		this.kbchjdbyqP = kbchjdbyqP;
	}

	public Integer getKbchjdbyqSj() {
		return kbchjdbyqSj;
	}

	public void setKbchjdbyqSj(Integer kbchjdbyqSj) {
		this.kbchjdbyqSj = kbchjdbyqSj;
	}

	public Integer getKbchjdbyqZj() {
		return kbchjdbyqZj;
	}

	public void setKbchjdbyqZj(Integer kbchjdbyqZj) {
		this.kbchjdbyqZj = kbchjdbyqZj;
	}

	public Integer getKbchjdbyqJzj() {
		return kbchjdbyqJzj;
	}

	public void setKbchjdbyqJzj(Integer kbchjdbyqJzj) {
		this.kbchjdbyqJzj = kbchjdbyqJzj;
	}

	public Integer getDzpop() {
		return dzpop;
	}

	public void setDzpop(Integer dzpop) {
		this.dzpop = dzpop;
	}

	public String getKjms() {
		return kjms;
	}

	public void setKjms(String kjms) {
		this.kjms = kjms;
	}

	public String getKjmsmc() {
		return kjmsmc;
	}

	public void setKjmsmc(String kjmsmc) {
		this.kjmsmc = kjmsmc;
	}

	public String getQd() {
		return qd;
	}

	public void setQd(String qd) {
		this.qd = qd;
	}

	public String getQdmc() {
		return qdmc;
	}

	public void setQdmc(String qdmc) {
		this.qdmc = qdmc;
	}

	public Integer getSfCh() {
		return sfCh;
	}

	public void setSfCh(Integer sfCh) {
		this.sfCh = sfCh;
	}

	public Integer getFhlBxy() {
		return fhlBxy;
	}

	public void setFhlBxy(Integer fhlBxy) {
		this.fhlBxy = fhlBxy;
	}

	public String getJgfs() {
		return jgfs;
	}

	public void setJgfs(String jgfs) {
		this.jgfs = jgfs;
	}

	public String getJgfsmc() {
		return jgfsmc;
	}

	public void setJgfsmc(String jgfsmc) {
		this.jgfsmc = jgfsmc;
	}

	public String getFzbgbz() {
		return fzbgbz;
	}

	public void setFzbgbz(String fzbgbz) {
		this.fzbgbz = fzbgbz;
	}

	public Integer getSfFjelbg() {
		return sfFjelbg;
	}

	public void setSfFjelbg(Integer sfFjelbg) {
		this.sfFjelbg = sfFjelbg;
	}

	public String getBgbz() {
		return bgbz;
	}

	public void setBgbz(String bgbz) {
		this.bgbz = bgbz;
	}

	public Integer getSfBg() {
		return sfBg;
	}

	public void setSfBg(Integer sfBg) {
		this.sfBg = sfBg;
	}

	public String getScjd() {
		return scjd;
	}

	public void setScjd(String scjd) {
		this.scjd = scjd;
	}

	public String getScjdmc() {
		return scjdmc;
	}

	public void setScjdmc(String scjdmc) {
		this.scjdmc = scjdmc;
	}

	public OrderProductNew() {
		super();
	}

	public OrderProductNew(String id) {
		super(id);
	}

	/**
	 * 订单号
	 */
	@Length(min = 1, max = 20, message = "订单号长度必须介于 1 和 20 之间")
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
	 * 参考订单号
	 */
	@Length(min = 0, max = 20, message = "参考订单号长度必须介于 0 和 20 之间")
	public String getCkddh() {
		return ckddh;
	}

	/**
	 * 参考订单号
	 */
	public void setCkddh(String ckddh) {
		this.ckddh = ckddh == null ? null : ckddh.trim();
	}

	/**
	 * 关联订单号
	 */
	@Length(min = 0, max = 20, message = "关联订单号长度必须介于 0 和 20 之间")
	public String getGlddh() {
		return glddh;
	}

	/**
	 * 关联订单号
	 */
	public void setGlddh(String glddh) {
		this.glddh = glddh == null ? null : glddh.trim();
	}

	/**
	 * 公司编码
	 */
	@Length(min = 1, max = 20, message = "公司编码长度必须介于 1 和 20 之间")
	public String getGsbm() {
		return gsbm;
	}

	/**
	 * 公司编码
	 */
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm == null ? null : gsbm.trim();
	}

	/**
	 * 公司名称
	 */
	@Length(min = 0, max = 100, message = "公司名称长度必须介于 0 和 100 之间")
	public String getGsmc() {
		return gsmc;
	}

	/**
	 * 公司名称
	 */
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc == null ? null : gsmc.trim();
	}

	/**
	 * 订单编码类型
	 */
	@Length(min = 0, max = 20, message = "订单编码类型长度必须介于 0 和 20 之间")
	public String getDdbmlx() {
		return ddbmlx;
	}

	/**
	 * 订单编码类型
	 */
	public void setDdbmlx(String ddbmlx) {
		this.ddbmlx = ddbmlx == null ? null : ddbmlx.trim();
	}

	/**
	 * 订单编码类型名称
	 */
	@Length(min = 0, max = 50, message = "订单编码类型名称长度必须介于 0 和 50 之间")
	public String getDdbmlxmc() {
		return ddbmlxmc;
	}

	/**
	 * 订单编码类型名称
	 */
	public void setDdbmlxmc(String ddbmlxmc) {
		this.ddbmlxmc = ddbmlxmc == null ? null : ddbmlxmc.trim();
	}

	/**
	 * 订单类型
	 */
	@Length(min = 1, max = 20, message = "订单类型长度必须介于 1 和 20 之间")
	public String getDdlx() {
		return ddlx;
	}

	/**
	 * 订单类型
	 */
	public void setDdlx(String ddlx) {
		this.ddlx = ddlx == null ? null : ddlx.trim();
	}

	/**
	 * 订单类型名称
	 */
	@Length(min = 0, max = 50, message = "订单类型名称长度必须介于 0 和 50 之间")
	public String getDdlxmc() {
		return ddlxmc;
	}

	/**
	 * 订单类型名称
	 */
	public void setDdlxmc(String ddlxmc) {
		this.ddlxmc = ddlxmc == null ? null : ddlxmc.trim();
	}

	/**
	 * 订单类别
	 */
	@Length(min = 1, max = 20, message = "订单类别长度必须介于 1 和 20 之间")
	public String getDdlb() {
		return ddlb;
	}

	/**
	 * 订单类别
	 */
	public void setDdlb(String ddlb) {
		this.ddlb = ddlb == null ? null : ddlb.trim();
	}

	/**
	 * 订单类别名称
	 */
	@Length(min = 0, max = 50, message = "订单类别名称长度必须介于 0 和 50 之间")
	public String getDdlbmc() {
		return ddlbmc;
	}

	/**
	 * 订单类别名称
	 */
	public void setDdlbmc(String ddlbmc) {
		this.ddlbmc = ddlbmc == null ? null : ddlbmc.trim();
	}

	/**
	 * 业务类型
	 */
	@Length(min = 1, max = 20, message = "业务类型长度必须介于 1 和 20 之间")
	public String getYwlx() {
		return ywlx;
	}

	/**
	 * 业务类型
	 */
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx == null ? null : ywlx.trim();
	}

	/**
	 * 业务类型名称
	 */
	@Length(min = 0, max = 50, message = "业务类型名称长度必须介于 0 和 50 之间")
	public String getYwlxmc() {
		return ywlxmc;
	}

	/**
	 * 业务类型名称
	 */
	public void setYwlxmc(String ywlxmc) {
		this.ywlxmc = ywlxmc == null ? null : ywlxmc.trim();
	}

	/**
	 * 销售员
	 */
	@Length(min = 0, max = 20, message = "销售员长度必须介于 0 和 20 之间")
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
	@Length(min = 0, max = 50, message = "销售员名称长度必须介于 0 和 50 之间")
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
	 * 业务组
	 */
	@Length(min = 0, max = 20, message = "业务组长度必须介于 0 和 20 之间")
	public String getYwz() {
		return ywz;
	}

	/**
	 * 业务组
	 */
	public void setYwz(String ywz) {
		this.ywz = ywz == null ? null : ywz.trim();
	}

	/**
	 * 业务组名称
	 */
	@Length(min = 0, max = 50, message = "业务组名称长度必须介于 0 和 50 之间")
	public String getYwzmc() {
		return ywzmc;
	}

	/**
	 * 业务组名称
	 */
	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc == null ? null : ywzmc.trim();
	}

	/**
	 * 销售组织
	 */
	@Length(min = 0, max = 20, message = "销售组织长度必须介于 0 和 20 之间")
	public String getXszz() {
		return xszz;
	}

	/**
	 * 销售组织
	 */
	public void setXszz(String xszz) {
		this.xszz = xszz == null ? null : xszz.trim();
	}

	/**
	 * 销售组织名称
	 */
	@Length(min = 0, max = 50, message = "销售组织名称长度必须介于 0 和 50 之间")
	public String getXszzmc() {
		return xszzmc;
	}

	/**
	 * 销售组织名称
	 */
	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc == null ? null : xszzmc.trim();
	}

	/**
	 * PID
	 */
	@Length(min = 0, max = 20, message = "PID长度必须介于 0 和 20 之间")
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
	 * 我司型号
	 */
	@Length(min = 0, max = 50, message = "我司型号长度必须介于 0 和 50 之间")
	public String getWsxh() {
		return wsxh;
	}

	/**
	 * 我司型号
	 */
	public void setWsxh(String wsxh) {
		this.wsxh = wsxh == null ? null : wsxh.trim();
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
	 * 买家型号
	 */
	@Length(min = 0, max = 50, message = "买家型号长度必须介于 0 和 50 之间")
	public String getMjxh() {
		return mjxh;
	}

	/**
	 * 买家型号
	 */
	public void setMjxh(String mjxh) {
		this.mjxh = mjxh == null ? null : mjxh.trim();
	}

	/**
	 * 是否外协订单
	 */
	public Integer getSfWxdd() {
		return sfWxdd;
	}

	/**
	 * 是否外协订单
	 */
	public void setSfWxdd(Integer sfWxdd) {
		this.sfWxdd = sfWxdd;
	}

	/**
	 * 是否内销研发产品
	 */
	public Integer getSfNxyfcp() {
		return sfNxyfcp;
	}

	/**
	 * 是否内销研发产品
	 */
	public void setSfNxyfcp(Integer sfNxyfcp) {
		this.sfNxyfcp = sfNxyfcp;
	}

	/**
	 * 规格明细
	 */
	@Length(min = 0, max = 20, message = "规格明细长度必须介于 0 和 20 之间")
	public String getGgmx() {
		return ggmx;
	}

	/**
	 * 规格明细
	 */
	public void setGgmx(String ggmx) {
		this.ggmx = ggmx == null ? null : ggmx.trim();
	}

	/**
	 * 规格明细名称
	 */
	@Length(min = 0, max = 50, message = "规格明细名称长度必须介于 0 和 50 之间")
	public String getGgmxmc() {
		return ggmxmc;
	}

	/**
	 * 规格明细名称
	 */
	public void setGgmxmc(String ggmxmc) {
		this.ggmxmc = ggmxmc == null ? null : ggmxmc.trim();
	}

	/**
	 * 规格明细备注
	 */
	@Length(min = 0, max = 100, message = "规格明细备注长度必须介于 0 和 100 之间")
	public String getGgmxbz() {
		return ggmxbz;
	}

	/**
	 * 规格明细备注
	 */
	public void setGgmxbz(String ggmxbz) {
		this.ggmxbz = ggmxbz == null ? null : ggmxbz.trim();
	}

	/**
	 * 是否新品
	 */
	public Integer getSfXp() {
		return sfXp;
	}

	/**
	 * 是否新品
	 */
	public void setSfXp(Integer sfXp) {
		this.sfXp = sfXp;
	}

	/**
	 * 币种
	 */
	@Length(min = 0, max = 20, message = "币种长度必须介于 0 和 20 之间")
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
	@Length(min = 0, max = 20, message = "付款条件长度必须介于 0 和 20 之间")
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
	 * 付款条件名称
	 */
	@Length(min = 0, max = 50, message = "付款条件名称长度必须介于 0 和 50 之间")
	public String getFktjmc() {
		return fktjmc;
	}

	/**
	 * 付款条件名称
	 */
	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc == null ? null : fktjmc.trim();
	}

	/**
	 * 国际贸易条款
	 */
	@Length(min = 0, max = 20, message = "国际贸易条款长度必须介于 0 和 20 之间")
	public String getGjmytk() {
		return gjmytk;
	}

	/**
	 * 国际贸易条款
	 */
	public void setGjmytk(String gjmytk) {
		this.gjmytk = gjmytk == null ? null : gjmytk.trim();
	}

	/**
	 * 国际贸易条款名称
	 */
	@Length(min = 0, max = 50, message = "国际贸易条款名称长度必须介于 0 和 50 之间")
	public String getGjmytkmc() {
		return gjmytkmc;
	}

	/**
	 * 国际贸易条款名称
	 */
	public void setGjmytkmc(String gjmytkmc) {
		this.gjmytkmc = gjmytkmc == null ? null : gjmytkmc.trim();
	}

	/**
	 * 国际贸易条款备注
	 */
	@Length(min = 0, max = 100, message = "国际贸易条款备注长度必须介于 0 和 100 之间")
	public String getGjmytkbz() {
		return gjmytkbz;
	}

	/**
	 * 国际贸易条款备注
	 */
	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz == null ? null : gjmytkbz.trim();
	}

	/**
	 * 数量
	 */
	public Integer getSl() {
		return sl;
	}

	/**
	 * 数量
	 */
	public void setSl(Integer sl) {
		this.sl = sl;
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
	 * 金额
	 */
	public BigDecimal getJe() {
		return je;
	}

	/**
	 * 金额
	 */
	public void setJe(BigDecimal je) {
		this.je = je;
	}

	/**
	 * 付费备损金额
	 */
	public BigDecimal getFfbsje() {
		return ffbsje;
	}

	/**
	 * 付费备损金额
	 */
	public void setFfbsje(BigDecimal ffbsje) {
		this.ffbsje = ffbsje;
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
	 * 走货不含物件-屏
	 */
	public Integer getZhbhwjP() {
		return zhbhwjP;
	}

	/**
	 * 走货不含物件-屏
	 */
	public void setZhbhwjP(Integer zhbhwjP) {
		this.zhbhwjP = zhbhwjP;
	}

	/**
	 * 走货不含物件-机壳
	 */
	public Integer getZhbhwjJk() {
		return zhbhwjJk;
	}

	/**
	 * 走货不含物件-机壳
	 */
	public void setZhbhwjJk(Integer zhbhwjJk) {
		this.zhbhwjJk = zhbhwjJk;
	}

	/**
	 * 走货不含物件-遥控器
	 */
	public Integer getZhbhwjYkq() {
		return zhbhwjYkq;
	}

	/**
	 * 走货不含物件-遥控器
	 */
	public void setZhbhwjYkq(Integer zhbhwjYkq) {
		this.zhbhwjYkq = zhbhwjYkq;
	}

	/**
	 * 走货不含物件-喇叭
	 */
	public Integer getZhbhwjLb() {
		return zhbhwjLb;
	}

	/**
	 * 走货不含物件-喇叭
	 */
	public void setZhbhwjLb(Integer zhbhwjLb) {
		this.zhbhwjLb = zhbhwjLb;
	}

	/**
	 * 走货不含物件-纸箱
	 */
	public Integer getZhbhwjZx() {
		return zhbhwjZx;
	}

	/**
	 * 走货不含物件-纸箱
	 */
	public void setZhbhwjZx(Integer zhbhwjZx) {
		this.zhbhwjZx = zhbhwjZx;
	}

	/**
	 * 走货不含物件-泡沫
	 */
	public Integer getZhbhwjPm() {
		return zhbhwjPm;
	}

	/**
	 * 走货不含物件-泡沫
	 */
	public void setZhbhwjPm(Integer zhbhwjPm) {
		this.zhbhwjPm = zhbhwjPm;
	}

	/**
	 * 走货不含物件-机芯+主板
	 */
	public Integer getZhbhwjJxZb() {
		return zhbhwjJxZb;
	}

	/**
	 * 走货不含物件-机芯+主板
	 */
	public void setZhbhwjJxZb(Integer zhbhwjJxZb) {
		this.zhbhwjJxZb = zhbhwjJxZb;
	}

	/**
	 * 需单独走货-屏
	 */
	public Integer getXddzhP() {
		return xddzhP;
	}

	/**
	 * 需单独走货-屏
	 */
	public void setXddzhP(Integer xddzhP) {
		this.xddzhP = xddzhP;
	}

	/**
	 * 需单独走货-机壳
	 */
	public Integer getXddzhJk() {
		return xddzhJk;
	}

	/**
	 * 需单独走货-机壳
	 */
	public void setXddzhJk(Integer xddzhJk) {
		this.xddzhJk = xddzhJk;
	}

	/**
	 * 需单独走货-喇叭
	 */
	public Integer getXddzhLb() {
		return xddzhLb;
	}

	/**
	 * 需单独走货-喇叭
	 */
	public void setXddzhLb(Integer xddzhLb) {
		this.xddzhLb = xddzhLb;
	}

	/**
	 * 需单独走货-纸箱
	 */
	public Integer getXddzhZx() {
		return xddzhZx;
	}

	/**
	 * 需单独走货-纸箱
	 */
	public void setXddzhZx(Integer xddzhZx) {
		this.xddzhZx = xddzhZx;
	}

	/**
	 * 需单独走货-机芯+主板
	 */
	public Integer getXddzhJxZb() {
		return xddzhJxZb;
	}

	/**
	 * 需单独走货-机芯+主板
	 */
	public void setXddzhJxZb(Integer xddzhJxZb) {
		this.xddzhJxZb = xddzhJxZb;
	}

	/**
	 * 出运类型
	 */
	@Length(min = 0, max = 20, message = "出运类型长度必须介于 0 和 20 之间")
	public String getCylx() {
		return cylx;
	}

	/**
	 * 出运类型
	 */
	public void setCylx(String cylx) {
		this.cylx = cylx == null ? null : cylx.trim();
	}

	/**
	 * 出运类型名称
	 */
	@Length(min = 0, max = 50, message = "出运类型名称长度必须介于 0 和 50 之间")
	public String getCylxmc() {
		return cylxmc;
	}

	/**
	 * 出运类型名称
	 */
	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc == null ? null : cylxmc.trim();
	}

	/**
	 * 出运类型备注
	 */
	@Length(min = 0, max = 100, message = "出运类型备注长度必须介于 0 和 100 之间")
	public String getCylxbz() {
		return cylxbz;
	}

	/**
	 * 出运类型备注
	 */
	public void setCylxbz(String cylxbz) {
		this.cylxbz = cylxbz == null ? null : cylxbz.trim();
	}

	/**
	 * 交货日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJhrq() {
		return jhrq;
	}

	/**
	 * 交货日期
	 */
	public void setJhrq(Date jhrq) {
		this.jhrq = jhrq;
	}

	/**
	 * 分公司收货日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getFgsshrq() {
		return fgsshrq;
	}

	/**
	 * 分公司收货日期
	 */
	public void setFgsshrq(Date fgsshrq) {
		this.fgsshrq = fgsshrq;
	}

	/**
	 * 是否验货
	 */
	public Integer getSfYh() {
		return sfYh;
	}

	/**
	 * 是否验货
	 */
	public void setSfYh(Integer sfYh) {
		this.sfYh = sfYh;
	}

	/**
	 * 预测周数
	 */
	@Length(min = 0, max = 50, message = "预测周数长度必须介于 0 和 50 之间")
	public String getYczs() {
		return yczs;
	}

	/**
	 * 预测周数
	 */
	public void setYczs(String yczs) {
		this.yczs = yczs == null ? null : yczs.trim();
	}

	/**
	 * 是否验货备注
	 */
	@Length(min = 0, max = 100, message = "是否验货备注长度必须介于 0 和 100 之间")
	public String getSfyhbz() {
		return sfyhbz;
	}

	/**
	 * 是否验货备注
	 */
	public void setSfyhbz(String sfyhbz) {
		this.sfyhbz = sfyhbz == null ? null : sfyhbz.trim();
	}

	/**
	 * 预测日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYcrq() {
		return ycrq;
	}

	/**
	 * 预测日期
	 */
	public void setYcrq(Date ycrq) {
		this.ycrq = ycrq;
	}

	/**
	 * 验货日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYhrq() {
		return yhrq;
	}

	/**
	 * 验货日期
	 */
	public void setYhrq(Date yhrq) {
		this.yhrq = yhrq;
	}

	/**
	 * 预测数量
	 */
	public Long getYcsl() {
		return ycsl;
	}

	/**
	 * 预测数量
	 */
	public void setYcsl(Long ycsl) {
		this.ycsl = ycsl;
	}

	/**
	 * 基本信息备注
	 */
	@Length(min = 0, max = 200, message = "基本信息备注长度必须介于 0 和 200 之间")
	public String getJbxxbz() {
		return jbxxbz;
	}

	/**
	 * 基本信息备注
	 */
	public void setJbxxbz(String jbxxbz) {
		this.jbxxbz = jbxxbz == null ? null : jbxxbz.trim();
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
	@Length(min = 0, max = 100, message = "客户名称长度必须介于 0 和 100 之间")
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
	 * 销往国家
	 */
	@Length(min = 0, max = 20, message = "销往国家长度必须介于 0 和 20 之间")
	public String getXwgj() {
		return xwgj;
	}

	/**
	 * 销往国家
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
	 * 时区
	 */
	@Length(min = 0, max = 20, message = "时区长度必须介于 0 和 20 之间")
	public String getSq() {
		return sq;
	}

	/**
	 * 时区
	 */
	public void setSq(String sq) {
		this.sq = sq == null ? null : sq.trim();
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
	 * 出厂语言
	 */
	@Length(min = 0, max = 20, message = "出厂语言长度必须介于 0 和 20 之间")
	public String getCcyy() {
		return ccyy;
	}

	/**
	 * 出厂语言
	 */
	public void setCcyy(String ccyy) {
		this.ccyy = ccyy == null ? null : ccyy.trim();
	}

	/**
	 * 出厂语言名称
	 */
	@Length(min = 0, max = 50, message = "出厂语言名称长度必须介于 0 和 50 之间")
	public String getCcyymc() {
		return ccyymc;
	}

	/**
	 * 出厂语言名称
	 */
	public void setCcyymc(String ccyymc) {
		this.ccyymc = ccyymc == null ? null : ccyymc.trim();
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
	 * 开机LOGO附件
	 */
	@Length(min = 0, max = 100, message = "开机LOGO附件长度必须介于 0 和 100 之间")
	public String getKjlogofj() {
		return kjlogofj;
	}

	/**
	 * 开机LOGO附件
	 */
	public void setKjlogofj(String kjlogofj) {
		this.kjlogofj = kjlogofj == null ? null : kjlogofj.trim();
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
	 * 屏编码
	 */
	@Length(min = 0, max = 50, message = "屏编码长度必须介于 0 和 50 之间")
	public String getPbm() {
		return pbm;
	}

	/**
	 * 屏编码
	 */
	public void setPbm(String pbm) {
		this.pbm = pbm == null ? null : pbm.trim();
	}

	/**
	 * 屏信息补充
	 */
	@Length(min = 0, max = 100, message = "屏信息补充长度必须介于 0 和 100 之间")
	public String getPxxbc() {
		return pxxbc;
	}

	/**
	 * 屏信息补充
	 */
	public void setPxxbc(String pxxbc) {
		this.pxxbc = pxxbc == null ? null : pxxbc.trim();
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
	 * 屏亮点
	 */
	@Length(min = 0, max = 20, message = "屏亮点长度必须介于 0 和 20 之间")
	public String getPld() {
		return pld;
	}

	/**
	 * 屏亮点
	 */
	public void setPld(String pld) {
		this.pld = pld == null ? null : pld.trim();
	}

	/**
	 * 屏亮点名称
	 */
	@Length(min = 0, max = 50, message = "屏亮点名称长度必须介于 0 和 50 之间")
	public String getPldmc() {
		return pldmc;
	}

	/**
	 * 屏亮点名称
	 */
	public void setPldmc(String pldmc) {
		this.pldmc = pldmc == null ? null : pldmc.trim();
	}

	/**
	 * 屏包装要求
	 */
	@Length(min = 0, max = 20, message = "屏包装要求长度必须介于 0 和 20 之间")
	public String getPbzyq() {
		return pbzyq;
	}

	/**
	 * 屏包装要求
	 */
	public void setPbzyq(String pbzyq) {
		this.pbzyq = pbzyq == null ? null : pbzyq.trim();
	}

	/**
	 * 屏包装要求名称
	 */
	@Length(min = 0, max = 50, message = "屏包装要求名称长度必须介于 0 和 50 之间")
	public String getPbzyqmc() {
		return pbzyqmc;
	}

	/**
	 * 屏包装要求名称
	 */
	public void setPbzyqmc(String pbzyqmc) {
		this.pbzyqmc = pbzyqmc == null ? null : pbzyqmc.trim();
	}

	/**
	 * 屏包装要求备注
	 */
	@Length(min = 0, max = 100, message = "屏包装要求备注长度必须介于 0 和 100 之间")
	public String getPbzyqbz() {
		return pbzyqbz;
	}

	/**
	 * 屏包装要求备注
	 */
	public void setPbzyqbz(String pbzyqbz) {
		this.pbzyqbz = pbzyqbz == null ? null : pbzyqbz.trim();
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
	 * 认证1-RF
	 */
	public Integer getRz1Rf() {
		return rz1Rf;
	}

	/**
	 * 认证1-RF
	 */
	public void setRz1Rf(Integer rz1Rf) {
		this.rz1Rf = rz1Rf;
	}

	/**
	 * 认证1-RTE
	 */
	public Integer getRz1Rte() {
		return rz1Rte;
	}

	/**
	 * 认证1-RTE
	 */
	public void setRz1Rte(Integer rz1Rte) {
		this.rz1Rte = rz1Rte;
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
	 * 是否要RoHS
	 */
	public Integer getSfRohs() {
		return sfRohs;
	}

	/**
	 * 是否要RoHS
	 */
	public void setSfRohs(Integer sfRohs) {
		this.sfRohs = sfRohs;
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
	 * 是否要适配器
	 */
	public Integer getSfSpq() {
		return sfSpq;
	}

	/**
	 * 是否要适配器
	 */
	public void setSfSpq(Integer sfSpq) {
		this.sfSpq = sfSpq;
	}

	/**
	 * 是否需要REACH
	 */
	public Integer getSfReach() {
		return sfReach;
	}

	/**
	 * 是否需要REACH
	 */
	public void setSfReach(Integer sfReach) {
		this.sfReach = sfReach;
	}

	/**
	 * 外壳颜色标准
	 */
	@Length(min = 0, max = 50, message = "外壳颜色标准长度必须介于 0 和 50 之间")
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
	 * 防火料备注
	 */
	@Length(min = 0, max = 100, message = "防火料备注长度必须介于 0 和 100 之间")
	public String getFhlBz() {
		return fhlBz;
	}

	/**
	 * 防火料备注
	 */
	public void setFhlBz(String fhlBz) {
		this.fhlBz = fhlBz == null ? null : fhlBz.trim();
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
	 * 防火料-其他
	 */
	public Integer getFhlQt() {
		return fhlQt;
	}

	/**
	 * 防火料-其他
	 */
	public void setFhlQt(Integer fhlQt) {
		this.fhlQt = fhlQt;
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
	 * 挂架包装备注
	 */
	@Length(min = 0, max = 100, message = "挂架包装备注长度必须介于 0 和 100 之间")
	public String getGjbzbz() {
		return gjbzbz;
	}

	/**
	 * 挂架包装备注
	 */
	public void setGjbzbz(String gjbzbz) {
		this.gjbzbz = gjbzbz == null ? null : gjbzbz.trim();
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
	 * 其他附件备注
	 */
	@Length(min = 0, max = 200, message = "其他附件备注长度必须介于 0 和 200 之间")
	public String getQtfjbz() {
		return qtfjbz;
	}

	/**
	 * 其他附件备注
	 */
	public void setQtfjbz(String qtfjbz) {
		this.qtfjbz = qtfjbz == null ? null : qtfjbz.trim();
	}

	/**
	 * 是否付费备损
	 */
	public Integer getSfFfbs() {
		return sfFfbs;
	}

	/**
	 * 是否付费备损
	 */
	public void setSfFfbs(Integer sfFfbs) {
		this.sfFfbs = sfFfbs;
	}

	/**
	 * 付费备损清单附件
	 */
	@Length(min = 0, max = 100, message = "付费备损清单附件长度必须介于 0 和 100 之间")
	public String getFfbsqdfj() {
		return ffbsqdfj;
	}

	/**
	 * 付费备损清单附件
	 */
	public void setFfbsqdfj(String ffbsqdfj) {
		this.ffbsqdfj = ffbsqdfj == null ? null : ffbsqdfj.trim();
	}

	/**
	 * 免费备损
	 */
	@Length(min = 0, max = 20, message = "免费备损长度必须介于 0 和 20 之间")
	public String getMfbs() {
		return mfbs;
	}

	/**
	 * 免费备损
	 */
	public void setMfbs(String mfbs) {
		this.mfbs = mfbs == null ? null : mfbs.trim();
	}

	/**
	 * 免费备损名称
	 */
	@Length(min = 0, max = 50, message = "免费备损名称长度必须介于 0 和 50 之间")
	public String getMfbsmc() {
		return mfbsmc;
	}

	/**
	 * 免费备损名称
	 */
	public void setMfbsmc(String mfbsmc) {
		this.mfbsmc = mfbsmc == null ? null : mfbsmc.trim();
	}

	/**
	 * 免费备损比例
	 */
	public Double getMfbsbl() {
		return mfbsbl;
	}

	/**
	 * 免费备损比例
	 */
	public void setMfbsbl(Double mfbsbl) {
		this.mfbsbl = mfbsbl;
	}

	/**
	 * 免费备损清单附件
	 */
	@Length(min = 0, max = 100, message = "免费备损清单附件长度必须介于 0 和 100 之间")
	public String getMfbsqdfj() {
		return mfbsqdfj;
	}

	/**
	 * 免费备损清单附件
	 */
	public void setMfbsqdfj(String mfbsqdfj) {
		this.mfbsqdfj = mfbsqdfj == null ? null : mfbsqdfj.trim();
	}

	/**
	 * 备损包装
	 */
	@Length(min = 0, max = 20, message = "备损包装长度必须介于 0 和 20 之间")
	public String getBsbz() {
		return bsbz;
	}

	/**
	 * 备损包装
	 */
	public void setBsbz(String bsbz) {
		this.bsbz = bsbz == null ? null : bsbz.trim();
	}

	/**
	 * 备损包装名称
	 */
	@Length(min = 0, max = 50, message = "备损包装名称长度必须介于 0 和 50 之间")
	public String getBsbzmc() {
		return bsbzmc;
	}

	/**
	 * 备损包装名称
	 */
	public void setBsbzmc(String bsbzmc) {
		this.bsbzmc = bsbzmc == null ? null : bsbzmc.trim();
	}

	/**
	 * 备损包装备注
	 */
	@Length(min = 0, max = 100, message = "备损包装备注长度必须介于 0 和 100 之间")
	public String getBsbzbz() {
		return bsbzbz;
	}

	/**
	 * 备损包装备注
	 */
	public void setBsbzbz(String bsbzbz) {
		this.bsbzbz = bsbzbz == null ? null : bsbzbz.trim();
	}

	/**
	 * 跟单备损料走柜
	 */
	@Length(min = 0, max = 20, message = "跟单备损料走柜长度必须介于 0 和 20 之间")
	public String getGdbslzg() {
		return gdbslzg;
	}

	/**
	 * 跟单备损料走柜
	 */
	public void setGdbslzg(String gdbslzg) {
		this.gdbslzg = gdbslzg == null ? null : gdbslzg.trim();
	}

	/**
	 * 跟单备损料走柜名称
	 */
	@Length(min = 0, max = 50, message = "跟单备损料走柜名称长度必须介于 0 和 50 之间")
	public String getGdbslzgmc() {
		return gdbslzgmc;
	}

	/**
	 * 跟单备损料走柜名称
	 */
	public void setGdbslzgmc(String gdbslzgmc) {
		this.gdbslzgmc = gdbslzgmc == null ? null : gdbslzgmc.trim();
	}

	/**
	 * 备损信息备注
	 */
	@Length(min = 0, max = 200, message = "备损信息备注长度必须介于 0 和 200 之间")
	public String getBsxxbz() {
		return bsxxbz;
	}

	/**
	 * 备损信息备注
	 */
	public void setBsxxbz(String bsxxbz) {
		this.bsxxbz = bsxxbz == null ? null : bsxxbz.trim();
	}

	/**
	 * 是否有屏
	 */
	public Integer getSfP() {
		return sfP;
	}

	/**
	 * 是否有屏
	 */
	public void setSfP(Integer sfP) {
		this.sfP = sfP;
	}

	/**
	 * 是否需要IC程序烧录
	 */
	public Integer getSfIc() {
		return sfIc;
	}

	/**
	 * 是否需要IC程序烧录
	 */
	public void setSfIc(Integer sfIc) {
		this.sfIc = sfIc;
	}

	/**
	 * 是否S/H/CKD辅料供应
	 */
	@Length(min = 0, max = 50, message = "是否S/H/CKD辅料供应长度必须介于 0 和 50 之间")
	public String getSfShckdflgy() {
		return sfShckdflgy;
	}

	/**
	 * 是否S/H/CKD辅料供应
	 */
	public void setSfShckdflgy(String sfShckdflgy) {
		this.sfShckdflgy = sfShckdflgy == null ? null : sfShckdflgy.trim();
	}

	/**
	 * SKD前壳需加工配件
	 */
	@Length(min = 0, max = 50, message = "SKD前壳需加工配件长度必须介于 0 和 50 之间")
	public String getSkdqkxjgpj() {
		return skdqkxjgpj;
	}

	/**
	 * SKD前壳需加工配件
	 */
	public void setSkdqkxjgpj(String skdqkxjgpj) {
		this.skdqkxjgpj = skdqkxjgpj == null ? null : skdqkxjgpj.trim();
	}

	/**
	 * S/H/CKD加工要求
	 */
	@Length(min = 0, max = 100, message = "S/H/CKD加工要求长度必须介于 0 和 100 之间")
	public String getShckdjgyq() {
		return shckdjgyq;
	}

	/**
	 * S/H/CKD加工要求
	 */
	public void setShckdjgyq(String shckdjgyq) {
		this.shckdjgyq = shckdjgyq == null ? null : shckdjgyq.trim();
	}

	/**
	 * S/H/CKD加工要求附件
	 */
	@Length(min = 0, max = 100, message = "S/H/CKD加工要求附件长度必须介于 0 和 100 之间")
	public String getShckdjgyqbz() {
		return shckdjgyqbz;
	}

	/**
	 * S/H/CKD加工要求附件
	 */
	public void setShckdjgyqbz(String shckdjgyqbz) {
		this.shckdjgyqbz = shckdjgyqbz == null ? null : shckdjgyqbz.trim();
	}

	/**
	 * S/H/CKD需成型物料明细
	 */
	@Length(min = 0, max = 100, message = "S/H/CKD需成型物料明细长度必须介于 0 和 100 之间")
	public String getShckdxcxwlmx() {
		return shckdxcxwlmx;
	}

	/**
	 * S/H/CKD需成型物料明细
	 */
	public void setShckdxcxwlmx(String shckdxcxwlmx) {
		this.shckdxcxwlmx = shckdxcxwlmx == null ? null : shckdxcxwlmx.trim();
	}

	/**
	 * S/H/CKD需成型物料明细附件
	 */
	@Length(min = 0, max = 100, message = "S/H/CKD需成型物料明细附件长度必须介于 0 和 100 之间")
	public String getShckdxcxwlmxfj() {
		return shckdxcxwlmxfj;
	}

	/**
	 * S/H/CKD需成型物料明细附件
	 */
	public void setShckdxcxwlmxfj(String shckdxcxwlmxfj) {
		this.shckdxcxwlmxfj = shckdxcxwlmxfj == null ? null : shckdxcxwlmxfj.trim();
	}

	/**
	 * 产品其他要求备注
	 */
	@Length(min = 0, max = 200, message = "产品其他要求备注长度必须介于 0 和 200 之间")
	public String getCpqtyqbz() {
		return cpqtyqbz;
	}

	/**
	 * 产品其他要求备注
	 */
	public void setCpqtyqbz(String cpqtyqbz) {
		this.cpqtyqbz = cpqtyqbz == null ? null : cpqtyqbz.trim();
	}

	/**
	 * 产品其他要求附件
	 */
	@Length(min = 0, max = 100, message = "产品其他要求附件长度必须介于 0 和 100 之间")
	public String getCpqtyqfj() {
		return cpqtyqfj;
	}

	/**
	 * 产品其他要求附件
	 */
	public void setCpqtyqfj(String cpqtyqfj) {
		this.cpqtyqfj = cpqtyqfj == null ? null : cpqtyqfj.trim();
	}

	/**
	 * 制单人
	 */
	@Length(min = 1, max = 20, message = "制单人长度必须介于 1 和 20 之间")
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
	@Length(min = 1, max = 50, message = "制单人名称长度必须介于 1 和 50 之间")
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
	@NotNull(message = "制单时间不能为空")
	public Date getZdsj() {
		return zdsj;
	}

	/**
	 * 制单时间
	 */
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
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
	 * 版本号
	 */
	@NotNull(message = "版本号不能为空")
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
	 * 付款保障状态
	 */
	public Integer getFkbzzt() {
		return fkbzzt;
	}

	/**
	 * 付款保障状态
	 */
	public void setFkbzzt(Integer fkbzzt) {
		this.fkbzzt = fkbzzt;
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
	
	public String getYddid() {
		return yddid;
	}

	public void setYddid(String yddid) {
		this.yddid = yddid;
	}

	public BigDecimal getYzhje() {
		return yzhje;
	}

	public void setYzhje(BigDecimal yzhje) {
		this.yzhje = yzhje;
	}

	public Integer getSfZt() {
		return sfZt;
	}

	public void setSfZt(Integer sfZt) {
		this.sfZt = sfZt;
	}

	public String getWjbh() {
		return wjbh;
	}

	public void setWjbh(String wjbh) {
		this.wjbh = wjbh;
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

	public Integer getSfMzckd() {
		return sfMzckd;
	}

	public void setSfMzckd(Integer sfMzckd) {
		this.sfMzckd = sfMzckd;
	}

	public String getMgrwdh() {
		return mgrwdh;
	}

	public void setMgrwdh(String mgrwdh) {
		this.mgrwdh = mgrwdh;
	}

	public Integer getRz4Eg() {
		return rz4Eg;
	}

	public void setRz4Eg(Integer rz4Eg) {
		this.rz4Eg = rz4Eg;
	}

	public Integer getRz1Cetl() {
		return rz1Cetl;
	}

	public void setRz1Cetl(Integer rz1Cetl) {
		this.rz1Cetl = rz1Cetl;
	}

	public String getXlh() {
		return xlh;
	}

	public void setXlh(String xlh) {
		this.xlh = xlh;
	}

	public String getXlhmc() {
		return xlhmc;
	}

	public void setXlhmc(String xlhmc) {
		this.xlhmc = xlhmc;
	}

	public String getXlhbz() {
		return xlhbz;
	}

	public void setXlhbz(String xlhbz) {
		this.xlhbz = xlhbz;
	}

	public String getMgqtyqbz() {
		return mgqtyqbz;
	}

	public void setMgqtyqbz(String mgqtyqbz) {
		this.mgqtyqbz = mgqtyqbz;
	}

	public String getXlhqt() {
		return xlhqt;
	}

	public void setXlhqt(String xlhqt) {
		this.xlhqt = xlhqt;
	}

	public Integer getYjsl() {
		return yjsl;
	}

	public void setYjsl(Integer yjsl) {
		this.yjsl = yjsl;
	}

	public String getGysbm() {
		return gysbm;
	}

	public void setGysbm(String gysbm) {
		this.gysbm = gysbm;
	}

	public String getGysmc() {
		return gysmc;
	}

	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}

	public String getZhm() {
		return zhm;
	}

	public void setZhm(String zhm) {
		this.zhm = zhm;
	}

	public String getZhmmc() {
		return zhmmc;
	}

	public void setZhmmc(String zhmmc) {
		this.zhmmc = zhmmc;
	}

	public String getDsjlx() {
		return dsjlx;
	}

	public void setDsjlx(String dsjlx) {
		this.dsjlx = dsjlx;
	}

	public String getDsjlxmc() {
		return dsjlxmc;
	}

	public void setDsjlxmc(String dsjlxmc) {
		this.dsjlxmc = dsjlxmc;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersionmc() {
		return versionmc;
	}

	public void setVersionmc(String versionmc) {
		this.versionmc = versionmc;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public String getBsmc() {
		return bsmc;
	}

	public void setBsmc(String bsmc) {
		this.bsmc = bsmc;
	}

	public String getZhmt() {
		return zhmt;
	}

	public void setZhmt(String zhmt) {
		this.zhmt = zhmt;
	}

	public String getZhmmct() {
		return zhmmct;
	}

	public void setZhmmct(String zhmmct) {
		this.zhmmct = zhmmct;
	}

	public String getVersiont() {
		return versiont;
	}

	public void setVersiont(String versiont) {
		this.versiont = versiont;
	}

	public String getVersionmct() {
		return versionmct;
	}

	public void setVersionmct(String versionmct) {
		this.versionmct = versionmct;
	}

	public String getBst() {
		return bst;
	}

	public void setBst(String bst) {
		this.bst = bst;
	}

	public String getBsmct() {
		return bsmct;
	}

	public void setBsmct(String bsmct) {
		this.bsmct = bsmct;
	}
	
	
}