package com.ey.piit.sdo.order.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 样机订单管理Entity
 * @author 高文浩
 */
public class OrderSample extends BaseEntity {
	
	private String ddid;		// 订单号
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private String ddlx;		// 订单类型
	private String ddlxmc;		// 订单类型名称
	private String ywlx;		// 业务类型
	private String ywlxmc;		// 业务类型名称
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String ywz;		// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String xwgj;		// 销往国家
	private String xwgjmc;		// 销往国家名称
	private String xsxz;		// 销售性质
	private String xsxzmc;		// 销售性质名称
	private String yjlx;		// 样机类型
	private String yjlxmc;		// 样机类型名称
	private String yjyt;		// 样机用途
	private String yjytmc;		// 样机用途名称
	private String gc;		// 工厂
	private String gcmc;		// 工厂名称
	private Integer sfFt;		// 是否返退
	private Integer sfWx;		// 是否外协
	private Integer sfMf;		// 是否免费
	private String fktj;		// 付款条件
	private String fktjmc;		// 付款条件名称
	private Date jhrq;		// 交货日期
	private String pm;		// 屏幕
	private String pmmc;		// 屏幕名称
	private String zs;		// 注塑
	private String zsmc;		// 注塑名称
	private String wj;		// 五金
	private String wjmc;		// 五金名称
	private String zb;		// 主板
	private String zbmc;		// 主板名称
	private String dy;		// 电源
	private String dymc;		// 电源名称
	private String bc;		// 包材
	private String bcmc;		// 包材名称
	private String pid;		// PID
	private String zbxh;		// 主板型号
	private String jixing;		// 型号
	private String zbfa;		// 主板方案
	private String zbfamc;		// 主板方案名称
	private String pp;		// 品牌
	private BigDecimal dj;		// 单价
	private BigDecimal jgf;		// 加工费
	private BigDecimal yf;		// 运费
	private BigDecimal dtzj;		// 单台总价
	private Integer pisl;		// PI数量
	private Integer sl;		// 数量
	private BigDecimal zje;		// 总金额
	private String bz;		// 币种
	private String khyhyq;		// 客户验货要求
	private String qtbz;		// 其他备注
	private String ctlx;		// 插头类型
	private String ctlxmc;		// 插头类型名称
	private String ctlxbz;		// 插头类型备注
	private String dianya;		// 电压
	private String dianyamc;		// 电压名称
	private String dianyabz;		// 电压备注
	private Integer sfDykg;		// 是否要电源开关
	private Integer sfRohs;		// 是否要RoHS
	private Integer sfReach;		// 是否要REACH
	private String djgl;		// 待机功率
	private String djglmc;		// 待机功率名称
	private String djglbz;		// 待机功率备注
	private Integer fjgbPgs3d;		// 附加功能-偏光式3D
	private Integer fjgnKms3d;		// 附加功能-快门式3D
	private Integer fjgnCij;		// 附加功能-CI+
	private Integer fjgnCi;		// 附加功能-CI
	private Integer fjgnScart;		// 附加功能-SCART
	private Integer sl3dyjh;		// 3D眼镜盒数
	private String osdyy;		// OSD语言
	private String wkysbz;		// 外壳颜色标准
	private String paomo;		// 泡沫
	private String paomomc;		// 泡沫名称
	private String qkgy;		// 前壳工艺
	private String qkgymc;		// 前壳工艺名称
	private Integer sfQkfhl;		// 前壳是否防火料
	private String hkgy;		// 后壳工艺
	private String hkgymc;		// 后壳工艺名称
	private Integer sfHkfhl;		// 后壳是否防火料
	private Integer sfHkxraytz;		// 后壳是否X-RAY贴纸
	private String dzgy;		// 底座工艺
	private String dzgymc;		// 底座工艺名称
	private String dzgybz;		// 底座工艺备注
	private Integer sfDzfhl;		// 底座是否防火料
	private String dzbz;		// 底座包装
	private String dzbzmc;		// 底座包装名称
	private String dzbzbz;		// 底座包装备注
	private String guajia;		// 挂架
	private String guajiamc;		// 挂架名称
	private String guajiabz;		// 挂架备注
	private String gjbz;		// 挂架包装
	private String gjbzmc;		// 挂架包装名称
	private String ppp;		// 屏品牌
	private String pxh;		// 屏型号
	private String pbh;		// 屏编号
	private Integer sf3d;		// 是否3D
	private String fbl;		// 分辨率
	private String fblmc;		// 分辨率名称
	private String dylx;		// 电源类型
	private String dylxmc;		// 电源类型名称
	private String dylxbz;		// 电源类型备注
	private String ykq;		// 遥控器
	private String ykqmc;		// 遥控器名称
	private String ykqbz;		// 遥控器备注
	private Integer sfDc;		// 是否要电池
	private String kjlogo;		//开机LOGO
	private String osdccyysz;		// OSD出厂语言设置
	private String mnlbz;		// 模拟量标准
	private String mnlbzmc;		// 模拟量标准名称
	private String mnlbzbz;		// 模拟量标准备注
	private String zlbz;		// 质量标准
	private String zlbzmc;		// 质量标准名称
	private String zlbzbz;		// 质量标准备注
	private Integer jyyqGzps;		// 检验要求-主观评审
	private Integer jyyqJgaq;		// 检验要求-结构安全
	private Integer jyyqDxn;		// 检验要求-电性能
	private Integer jyyqAqgy;		// 检验要求-安全工艺
	private Integer jyyqRzcs;		// 检验要求-认证测试
	private String jyff;		// 检验方法
	private String jyffmc;		// 检验方法名称
	private String cpjlid;		// 产品经理
	private String cpjlmc;		// 产品经理名称
	private String jgsjsid;		// 结构设计师
	private String jgsjsmc;		// 结构设计师名称
	private String dzsjsid;		// 电子设计师
	private String dzsjsmc;		// 电子设计师名称
	private String dysjsid;		// 电源设计师
	private String dysjsmc;		// 电源设计师名称
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Integer zt;		// 状态
	private Integer bbh;		// 版本号
	private String sjc;		// 时间戳
	private Integer fkbzzt;		// 付款保障状态
	private Integer tssapzt;		// 推送SAP状态
	private String beginZdsj;		// 开始 制单时间
	private String endZdsj;		// 结束 制单时间
	private String  scjd;           //生产基地
	private String  scjdmc;           //生产基地
	private String  yddid;           //原订单号
	private String gjmytk;		// 国际贸易条款
	private String gjmytkmc;	// 国际贸易条款名称
	private String gjmytkbz;	// 国际贸易条款备注
	private String bgbz;        //变更备注
	private Integer sfFjelbg;   //是否非金额类变更
	private String fzbgbz;      //辅助变更备注
	private Integer sfCh ;      //是否撤回标记
	private String qd;	//渠道
	private String qdmc;	//渠道名称
	private Integer fjgnWifi;  //附加功能-WIFI
	private Integer fjgnWifidongle;  //附加功能-WIFI Dongle
	private BigDecimal yzhje;	//已走货金额
	private Integer sfMx;		// 是否要木箱
	private String ggmx; // 规格明细
	private String ggmxmc; // 规格明细名称
	private String ggmxbz; // 规格明细备注
	private String nxdj; // 能效等级
	private String dsjlx;
	private String dsjlxmc;

	public Integer getFjgnWifi() {
		return fjgnWifi;
	}

	public void setFjgnWifi(Integer fjgnWifi) {
		this.fjgnWifi = fjgnWifi;
	}

	public Integer getFjgnWifidongle() {
		return fjgnWifidongle;
	}

	public void setFjgnWifidongle(Integer fjgnWifidongle) {
		this.fjgnWifidongle = fjgnWifidongle;
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

	public OrderSample() {
		super();
	}

	public OrderSample(String id){
		super(id);
	}

	/**
     * 订单号
     */
	@Length(min=1, max=20, message="订单号长度必须介于 1 和 20 之间")
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
     * 公司编码
     */
	@Length(min=1, max=20, message="公司编码长度必须介于 1 和 20 之间")
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
	@Length(min=0, max=100, message="公司名称长度必须介于 0 和 100 之间")
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
     * 订单类型
     */
	@Length(min=1, max=50, message="订单类型长度必须介于 1 和 50 之间")
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
	@Length(min=0, max=50, message="订单类型名称长度必须介于 0 和 50 之间")
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
     * 业务类型
     */
	@Length(min=1, max=50, message="业务类型长度必须介于 1 和 50 之间")
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
	@Length(min=0, max=50, message="业务类型名称长度必须介于 0 和 50 之间")
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
     * 业务组
     */
	@Length(min=0, max=50, message="业务组长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="业务组名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="销售组织长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="销售组织名称长度必须介于 0 和 50 之间")
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
     * 客户编码
     */
	@Length(min=0, max=20, message="客户编码长度必须介于 0 和 20 之间")
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
     * 销往国家
     */
	@Length(min=0, max=50, message="销往国家长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="销往国家名称长度必须介于 0 和 50 之间")
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
     * 销售性质
     */
	@Length(min=0, max=50, message="销售性质长度必须介于 0 和 50 之间")
	public String getXsxz() {
		return xsxz;
	}

	/**
     * 销售性质
     */
	public void setXsxz(String xsxz) {
		this.xsxz = xsxz == null ? null : xsxz.trim();
	}
	
	/**
     * 销售性质名称
     */
	@Length(min=0, max=50, message="销售性质名称长度必须介于 0 和 50 之间")
	public String getXsxzmc() {
		return xsxzmc;
	}

	/**
     * 销售性质名称
     */
	public void setXsxzmc(String xsxzmc) {
		this.xsxzmc = xsxzmc == null ? null : xsxzmc.trim();
	}
	
	/**
     * 样机类型
     */
	@Length(min=0, max=50, message="样机类型长度必须介于 0 和 50 之间")
	public String getYjlx() {
		return yjlx;
	}

	/**
     * 样机类型
     */
	public void setYjlx(String yjlx) {
		this.yjlx = yjlx == null ? null : yjlx.trim();
	}
	
	/**
     * 样机类型名称
     */
	@Length(min=0, max=50, message="样机类型名称长度必须介于 0 和 50 之间")
	public String getYjlxmc() {
		return yjlxmc;
	}

	/**
     * 样机类型名称
     */
	public void setYjlxmc(String yjlxmc) {
		this.yjlxmc = yjlxmc == null ? null : yjlxmc.trim();
	}
	
	/**
     * 样机用途
     */
	@Length(min=0, max=50, message="样机用途长度必须介于 0 和 50 之间")
	public String getYjyt() {
		return yjyt;
	}

	/**
     * 样机用途
     */
	public void setYjyt(String yjyt) {
		this.yjyt = yjyt == null ? null : yjyt.trim();
	}
	
	/**
     * 样机用途名称
     */
	@Length(min=0, max=50, message="样机用途名称长度必须介于 0 和 50 之间")
	public String getYjytmc() {
		return yjytmc;
	}

	/**
     * 样机用途名称
     */
	public void setYjytmc(String yjytmc) {
		this.yjytmc = yjytmc == null ? null : yjytmc.trim();
	}
	
	/**
     * 工厂
     */
	@Length(min=0, max=50, message="工厂长度必须介于 0 和 50 之间")
	public String getGc() {
		return gc;
	}

	/**
     * 工厂
     */
	public void setGc(String gc) {
		this.gc = gc == null ? null : gc.trim();
	}
	
	/**
     * 工厂名称
     */
	@Length(min=0, max=50, message="工厂名称长度必须介于 0 和 50 之间")
	public String getGcmc() {
		return gcmc;
	}

	/**
     * 工厂名称
     */
	public void setGcmc(String gcmc) {
		this.gcmc = gcmc == null ? null : gcmc.trim();
	}
	
	/**
     * 是否返退
     */
	public Integer getSfFt() {
		return sfFt;
	}

	/**
     * 是否返退
     */
	public void setSfFt(Integer sfFt) {
		this.sfFt = sfFt;
	}
	
	/**
     * 是否外协
     */
	public Integer getSfWx() {
		return sfWx;
	}

	/**
     * 是否外协
     */
	public void setSfWx(Integer sfWx) {
		this.sfWx = sfWx;
	}
	
	/**
     * 是否免费
     */
	public Integer getSfMf() {
		return sfMf;
	}

	/**
     * 是否免费
     */
	public void setSfMf(Integer sfMf) {
		this.sfMf = sfMf;
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
     * 付款条件名称
     */
	@Length(min=0, max=50, message="付款条件名称长度必须介于 0 和 50 之间")
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
     * 屏幕
     */
	@Length(min=0, max=50, message="屏幕长度必须介于 0 和 50 之间")
	public String getPm() {
		return pm;
	}

	/**
     * 屏幕
     */
	public void setPm(String pm) {
		this.pm = pm == null ? null : pm.trim();
	}
	
	/**
     * 屏幕名称
     */
	@Length(min=0, max=50, message="屏幕名称长度必须介于 0 和 50 之间")
	public String getPmmc() {
		return pmmc;
	}

	/**
     * 屏幕名称
     */
	public void setPmmc(String pmmc) {
		this.pmmc = pmmc == null ? null : pmmc.trim();
	}
	
	/**
     * 注塑
     */
	@Length(min=0, max=50, message="注塑长度必须介于 0 和 50 之间")
	public String getZs() {
		return zs;
	}

	/**
     * 注塑
     */
	public void setZs(String zs) {
		this.zs = zs == null ? null : zs.trim();
	}
	
	/**
     * 注塑名称
     */
	@Length(min=0, max=50, message="注塑名称长度必须介于 0 和 50 之间")
	public String getZsmc() {
		return zsmc;
	}

	/**
     * 注塑名称
     */
	public void setZsmc(String zsmc) {
		this.zsmc = zsmc == null ? null : zsmc.trim();
	}
	
	/**
     * 五金
     */
	@Length(min=0, max=50, message="五金长度必须介于 0 和 50 之间")
	public String getWj() {
		return wj;
	}

	/**
     * 五金
     */
	public void setWj(String wj) {
		this.wj = wj == null ? null : wj.trim();
	}
	
	/**
     * 五金名称
     */
	@Length(min=0, max=50, message="五金名称长度必须介于 0 和 50 之间")
	public String getWjmc() {
		return wjmc;
	}

	/**
     * 五金名称
     */
	public void setWjmc(String wjmc) {
		this.wjmc = wjmc == null ? null : wjmc.trim();
	}
	
	/**
     * 主板
     */
	@Length(min=0, max=50, message="主板长度必须介于 0 和 50 之间")
	public String getZb() {
		return zb;
	}

	/**
     * 主板
     */
	public void setZb(String zb) {
		this.zb = zb == null ? null : zb.trim();
	}
	
	/**
     * 主板名称
     */
	@Length(min=0, max=50, message="主板名称长度必须介于 0 和 50 之间")
	public String getZbmc() {
		return zbmc;
	}

	/**
     * 主板名称
     */
	public void setZbmc(String zbmc) {
		this.zbmc = zbmc == null ? null : zbmc.trim();
	}
	
	/**
     * 电源
     */
	@Length(min=0, max=50, message="电源长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="电源名称长度必须介于 0 和 50 之间")
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
     * 包材
     */
	@Length(min=0, max=50, message="包材长度必须介于 0 和 50 之间")
	public String getBc() {
		return bc;
	}

	/**
     * 包材
     */
	public void setBc(String bc) {
		this.bc = bc == null ? null : bc.trim();
	}
	
	/**
     * 包材名称
     */
	@Length(min=0, max=50, message="包材名称长度必须介于 0 和 50 之间")
	public String getBcmc() {
		return bcmc;
	}

	/**
     * 包材名称
     */
	public void setBcmc(String bcmc) {
		this.bcmc = bcmc == null ? null : bcmc.trim();
	}
	
	/**
     * PID
     */
	@Length(min=0, max=20, message="PID长度必须介于 0 和 20 之间")
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
     * 主板型号
     */
	@Length(min=0, max=50, message="主板型号长度必须介于 0 和 50 之间")
	public String getZbxh() {
		return zbxh;
	}

	/**
     * 主板型号
     */
	public void setZbxh(String zbxh) {
		this.zbxh = zbxh;
	}
	
	/**
     * 机型
     */
	@Length(min=0, max=50, message="机型长度必须介于 0 和 50 之间")
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
     * 主板方案
     */
	@Length(min=0, max=50, message="主板方案长度必须介于 0 和 50 之间")
	public String getZbfa() {
		return zbfa;
	}

	/**
     * 主板方案
     */
	public void setZbfa(String zbfa) {
		this.zbfa = zbfa == null ? null : zbfa.trim();
	}
	
	/**
     * 主板方案名称
     */
	@Length(min=0, max=50, message="主板方案名称长度必须介于 0 和 50 之间")
	public String getZbfamc() {
		return zbfamc;
	}

	/**
     * 主板方案名称
     */
	public void setZbfamc(String zbfamc) {
		this.zbfamc = zbfamc == null ? null : zbfamc.trim();
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
     * 加工费
     */
	public BigDecimal getJgf() {
		return jgf;
	}

	/**
     * 加工费
     */
	public void setJgf(BigDecimal jgf) {
		this.jgf = jgf;
	}
	
	/**
     * 运费
     */
	public BigDecimal getYf() {
		return yf;
	}

	/**
     * 运费
     */
	public void setYf(BigDecimal yf) {
		this.yf = yf;
	}
	
	/**
     * 单台总价
     */
	public BigDecimal getDtzj() {
		return dtzj;
	}

	/**
     * 单台总价
     */
	public void setDtzj(BigDecimal dtzj) {
		this.dtzj = dtzj;
	}
	
	/**
     * PI数量
     */
	public Integer getPisl() {
		return pisl;
	}

	/**
     * PI数量
     */
	public void setPisl(Integer pisl) {
		this.pisl = pisl;
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
     * 客户验货要求
     */
	@Length(min=0, max=200, message="客户验货要求长度必须介于 0 和 200 之间")
	public String getKhyhyq() {
		return khyhyq;
	}

	/**
     * 客户验货要求
     */
	public void setKhyhyq(String khyhyq) {
		this.khyhyq = khyhyq == null ? null : khyhyq.trim();
	}
	
	/**
     * 其他备注
     */
	@Length(min=0, max=200, message="其他备注长度必须介于 0 和 200 之间")
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
     * 插头类型
     */
	@Length(min=0, max=50, message="插头类型长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="插头类型名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=100, message="插头类型备注长度必须介于 0 和 100 之间")
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
	@Length(min=0, max=50, message="电压长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="电压名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=100, message="电压备注长度必须介于 0 和 100 之间")
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
	@Length(min=0, max=50, message="待机功率长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="待机功率名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=100, message="待机功率备注长度必须介于 0 和 100 之间")
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
	@Length(min=0, max=100, message="OSD语言长度必须介于 0 和 100 之间")
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
     * 外壳颜色标准
     */
	@Length(min=0, max=100, message="外壳颜色标准长度必须介于 0 和 100 之间")
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
	@Length(min=0, max=50, message="泡沫长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="泡沫名称长度必须介于 0 和 50 之间")
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
     * 前壳工艺
     */
	@Length(min=0, max=50, message="前壳工艺长度必须介于 0 和 50 之间")
	public String getQkgy() {
		return qkgy;
	}

	/**
     * 前壳工艺
     */
	public void setQkgy(String qkgy) {
		this.qkgy = qkgy == null ? null : qkgy.trim();
	}
	
	/**
     * 前壳工艺名称
     */
	@Length(min=0, max=50, message="前壳工艺名称长度必须介于 0 和 50 之间")
	public String getQkgymc() {
		return qkgymc;
	}

	/**
     * 前壳工艺名称
     */
	public void setQkgymc(String qkgymc) {
		this.qkgymc = qkgymc == null ? null : qkgymc.trim();
	}
	
	/**
     * 前壳是否防火料
     */
	public Integer getSfQkfhl() {
		return sfQkfhl;
	}

	/**
     * 前壳是否防火料
     */
	public void setSfQkfhl(Integer sfQkfhl) {
		this.sfQkfhl = sfQkfhl;
	}
	
	/**
     * 后壳工艺
     */
	@Length(min=0, max=50, message="后壳工艺长度必须介于 0 和 50 之间")
	public String getHkgy() {
		return hkgy;
	}

	/**
     * 后壳工艺
     */
	public void setHkgy(String hkgy) {
		this.hkgy = hkgy == null ? null : hkgy.trim();
	}
	
	/**
     * 后壳工艺名称
     */
	@Length(min=0, max=50, message="后壳工艺名称长度必须介于 0 和 50 之间")
	public String getHkgymc() {
		return hkgymc;
	}

	/**
     * 后壳工艺名称
     */
	public void setHkgymc(String hkgymc) {
		this.hkgymc = hkgymc == null ? null : hkgymc.trim();
	}
	
	/**
     * 后壳是否防火料
     */
	public Integer getSfHkfhl() {
		return sfHkfhl;
	}

	/**
     * 后壳是否防火料
     */
	public void setSfHkfhl(Integer sfHkfhl) {
		this.sfHkfhl = sfHkfhl;
	}
	
	/**
     * 后壳是否X-RAY贴纸
     */
	public Integer getSfHkxraytz() {
		return sfHkxraytz;
	}

	/**
     * 后壳是否X-RAY贴纸
     */
	public void setSfHkxraytz(Integer sfHkxraytz) {
		this.sfHkxraytz = sfHkxraytz;
	}
	
	/**
     * 底座工艺
     */
	@Length(min=0, max=50, message="底座工艺长度必须介于 0 和 50 之间")
	public String getDzgy() {
		return dzgy;
	}

	/**
     * 底座工艺
     */
	public void setDzgy(String dzgy) {
		this.dzgy = dzgy == null ? null : dzgy.trim();
	}
	
	/**
     * 底座工艺名称
     */
	@Length(min=0, max=50, message="底座工艺名称长度必须介于 0 和 50 之间")
	public String getDzgymc() {
		return dzgymc;
	}

	/**
     * 底座工艺名称
     */
	public void setDzgymc(String dzgymc) {
		this.dzgymc = dzgymc == null ? null : dzgymc.trim();
	}
	
	/**
     * 底座工艺备注
     */
	@Length(min=0, max=100, message="底座工艺备注长度必须介于 0 和 100 之间")
	public String getDzgybz() {
		return dzgybz;
	}

	/**
     * 底座工艺备注
     */
	public void setDzgybz(String dzgybz) {
		this.dzgybz = dzgybz == null ? null : dzgybz.trim();
	}
	
	/**
     * 底座是否防火料
     */
	public Integer getSfDzfhl() {
		return sfDzfhl;
	}

	/**
     * 底座是否防火料
     */
	public void setSfDzfhl(Integer sfDzfhl) {
		this.sfDzfhl = sfDzfhl;
	}
	
	/**
     * 底座包装
     */
	@Length(min=0, max=50, message="底座包装长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="底座包装名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=100, message="底座包装备注长度必须介于 0 和 100 之间")
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
	@Length(min=0, max=50, message="挂架长度必须介于 0 和 50 之间")
	public String getGuajia() {
		return guajia;
	}

	/**
     * 挂架类型
     */
	public void setGuajia(String guajia) {
		this.guajia = guajia;
	}
	
	/**
     * 挂架名称
     */
	@Length(min=0, max=50, message="挂架名称长度必须介于 0 和 50 之间")
	public String getGuajiamc() {
		return guajiamc;
	}

	/**
     * 挂架名称
     */
	public void setGuajiamc(String guajiamc) {
		this.guajiamc = guajiamc;
	}
	
	/**
     * 挂架包装
     */
	@Length(min=0, max=50, message="挂架包装长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="挂架包装名称长度必须介于 0 和 50 之间")
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
     * 挂架备注信息
     */
	@Length(min=0, max=100, message="挂架备注信息长度必须介于 0 和 100 之间")
	public String getGuajiabz() {
		return guajiabz;
	}

	/**
     * 挂架备注信息
     */
	public void setGuajiabz(String guajiabz) {
		this.guajiabz = guajiabz;
	}
	
	/**
     * 屏品牌
     */
	@Length(min=0, max=50, message="屏品牌长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="屏型号长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="屏编号长度必须介于 0 和 50 之间")
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
     * 分辨率
     */
	@Length(min=0, max=50, message="分辨率长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="分辨率名称长度必须介于 0 和 50 之间")
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
     * 电源类型
     */
	@Length(min=0, max=50, message="电源类型长度必须介于 0 和 50 之间")
	public String getDylx() {
		return dylx;
	}

	/**
     * 电源类型
     */
	public void setDylx(String dylx) {
		this.dylx = dylx == null ? null : dylx.trim();
	}
	
	/**
     * 电源类型名称
     */
	@Length(min=0, max=50, message="电源类型名称长度必须介于 0 和 50 之间")
	public String getDylxmc() {
		return dylxmc;
	}

	/**
     * 电源类型名称
     */
	public void setDylxmc(String dylxmc) {
		this.dylxmc = dylxmc == null ? null : dylxmc.trim();
	}
	
	/**
     * 电源类型备注
     */
	@Length(min=0, max=100, message="电源类型备注长度必须介于 0 和 100 之间")
	public String getDylxbz() {
		return dylxbz;
	}

	/**
     * 电源类型备注
     */
	public void setDylxbz(String dylxbz) {
		this.dylxbz = dylxbz == null ? null : dylxbz.trim();
	}
	
	/**
     * 遥控器
     */
	@Length(min=0, max=50, message="遥控器长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="遥控器名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=100, message="遥控器备注长度必须介于 0 和 100 之间")
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
	@Length(min=0, max=50, message="开机LOGO长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="OSD出厂语言设置长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="模拟量标准长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="模拟量标准名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=100, message="模拟量标准备注长度必须介于 0 和 100 之间")
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
	@Length(min=0, max=50, message="质量标准长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=50, message="质量标准名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=100, message="质量标准备注长度必须介于 0 和 100 之间")
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
     * 检验要求-主观评审
     */
	public Integer getJyyqGzps() {
		return jyyqGzps;
	}

	/**
     * 检验要求-主观评审
     */
	public void setJyyqGzps(Integer jyyqGzps) {
		this.jyyqGzps = jyyqGzps;
	}
	
	/**
     * 检验要求-结构安全
     */
	public Integer getJyyqJgaq() {
		return jyyqJgaq;
	}

	/**
     * 检验要求-结构安全
     */
	public void setJyyqJgaq(Integer jyyqJgaq) {
		this.jyyqJgaq = jyyqJgaq;
	}
	
	/**
     * 检验要求-电性能
     */
	public Integer getJyyqDxn() {
		return jyyqDxn;
	}

	/**
     * 检验要求-电性能
     */
	public void setJyyqDxn(Integer jyyqDxn) {
		this.jyyqDxn = jyyqDxn;
	}
	
	/**
     * 检验要求-安全工艺
     */
	public Integer getJyyqAqgy() {
		return jyyqAqgy;
	}

	/**
     * 检验要求-安全工艺
     */
	public void setJyyqAqgy(Integer jyyqAqgy) {
		this.jyyqAqgy = jyyqAqgy;
	}
	
	/**
     * 检验方法
     */
	@Length(min=0, max=50, message="检验方法长度必须介于 0 和 50 之间")
	public String getJyff() {
		return jyff;
	}

	/**
     * 检验方法
     */
	public void setJyff(String jyff) {
		this.jyff = jyff == null ? null : jyff.trim();
	}
	
	/**
     * 检验方法名称
     */
	@Length(min=0, max=50, message="检验方法名称长度必须介于 0 和 50 之间")
	public String getJyffmc() {
		return jyffmc;
	}

	/**
     * 检验方法名称
     */
	public void setJyffmc(String jyffmc) {
		this.jyffmc = jyffmc == null ? null : jyffmc.trim();
	}
	
	/**
     * 产品经理
     */
	@Length(min=0, max=20, message="产品经理长度必须介于 0 和 20 之间")
	public String getCpjlid() {
		return cpjlid;
	}

	/**
     * 产品经理
     */
	public void setCpjlid(String cpjlid) {
		this.cpjlid = cpjlid == null ? null : cpjlid.trim();
	}
	
	/**
     * 产品经理名称
     */
	@Length(min=0, max=50, message="产品经理名称长度必须介于 0 和 50 之间")
	public String getCpjlmc() {
		return cpjlmc;
	}

	/**
     * 产品经理名称
     */
	public void setCpjlmc(String cpjlmc) {
		this.cpjlmc = cpjlmc == null ? null : cpjlmc.trim();
	}
	
	/**
     * 结构设计师
     */
	@Length(min=0, max=20, message="结构设计师长度必须介于 0 和 20 之间")
	public String getJgsjsid() {
		return jgsjsid;
	}

	/**
     * 结构设计师
     */
	public void setJgsjsid(String jgsjsid) {
		this.jgsjsid = jgsjsid == null ? null : jgsjsid.trim();
	}
	
	/**
     * 结构设计师名称
     */
	@Length(min=0, max=50, message="结构设计师名称长度必须介于 0 和 50 之间")
	public String getJgsjsmc() {
		return jgsjsmc;
	}

	/**
     * 结构设计师名称
     */
	public void setJgsjsmc(String jgsjsmc) {
		this.jgsjsmc = jgsjsmc == null ? null : jgsjsmc.trim();
	}
	
	/**
     * 电子设计师
     */
	@Length(min=0, max=20, message="电子设计师长度必须介于 0 和 20 之间")
	public String getDzsjsid() {
		return dzsjsid;
	}

	/**
     * 电子设计师
     */
	public void setDzsjsid(String dzsjsid) {
		this.dzsjsid = dzsjsid == null ? null : dzsjsid.trim();
	}
	
	/**
     * 电子设计师名称
     */
	@Length(min=0, max=50, message="电子设计师名称长度必须介于 0 和 50 之间")
	public String getDzsjsmc() {
		return dzsjsmc;
	}

	/**
     * 电子设计师名称
     */
	public void setDzsjsmc(String dzsjsmc) {
		this.dzsjsmc = dzsjsmc == null ? null : dzsjsmc.trim();
	}
	
	/**
     * 电源设计师
     */
	@Length(min=0, max=20, message="电源设计师长度必须介于 0 和 20 之间")
	public String getDysjsid() {
		return dysjsid;
	}

	/**
     * 电源设计师
     */
	public void setDysjsid(String dysjsid) {
		this.dysjsid = dysjsid == null ? null : dysjsid.trim();
	}
	
	/**
     * 电源设计师名称
     */
	@Length(min=0, max=50, message="电源设计师名称长度必须介于 0 和 50 之间")
	public String getDysjsmc() {
		return dysjsmc;
	}

	/**
     * 电源设计师名称
     */
	public void setDysjsmc(String dysjsmc) {
		this.dysjsmc = dysjsmc == null ? null : dysjsmc.trim();
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
	@JsonFormat(pattern = "yyyy-MM-dd")
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
	
	/**
     * 状态
     */
	@NotNull(message="状态不能为空")
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
     * 时间戳
     */
	@Length(min=1, max=20, message="时间戳长度必须介于 1 和 20 之间")
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

	public String getBeginZdsj() {
		return beginZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}
	
	public String getYddid() {
		return yddid;
	}

	public void setYddid(String yddid) {
		this.yddid = yddid;
	}

	/**
     * 国际贸易条款
     */
	@Length(min=0, max=20, message="国际贸易条款长度必须介于 0 和 20 之间")
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
	@Length(min=0, max=50, message="国际贸易条款名称长度必须介于 0 和 50 之间")
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
	@Length(min=0, max=100, message="国际贸易条款备注长度必须介于 0 和 100 之间")
	public String getGjmytkbz() {
		return gjmytkbz;
	}

	/**
     * 国际贸易条款备注
     */
	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz == null ? null : gjmytkbz.trim();
	}

	public BigDecimal getYzhje() {
		return yzhje;
	}

	public void setYzhje(BigDecimal yzhje) {
		this.yzhje = yzhje;
	}

	public Integer getSfMx() {
		return sfMx;
	}

	public void setSfMx(Integer sfMx) {
		this.sfMx = sfMx;
	}

	public Integer getJyyqRzcs() {
		return jyyqRzcs;
	}

	public void setJyyqRzcs(Integer jyyqRzcs) {
		this.jyyqRzcs = jyyqRzcs;
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

	public String getGgmxbz() {
		return ggmxbz;
	}

	public void setGgmxbz(String ggmxbz) {
		this.ggmxbz = ggmxbz;
	}

	public String getNxdj() {
		return nxdj;
	}

	public void setNxdj(String nxdj) {
		this.nxdj = nxdj;
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
	
	
}