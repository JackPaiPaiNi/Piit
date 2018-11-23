package com.ey.piit.sdo.art.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 美工任务单OEMEntity
 * 
 * @author 魏诚
 */
public class Artoem extends BaseEntity {

	private String rwdh; // 任务单号
	private Integer bbh; // 版本号
	private String wjbh; // 文件编号
	private String zdrid; // 制单人
	private String zdrmc; // 制单人名称
	private Date zdsj; // 制单时间
	private Integer zt; // 状态
	private String sjc; // 时间戳
	private String pid; // pid
	private String wkysbz; // 外壳颜色标准
	private String wkysbzmc; // 外壳颜色标准名称
	private String zhfs; // 走货方式
	private String zhfsmc; // 走货方式名称
	private String khbm; // 客户编码
	private String khmc; // 客户名称
	private String xwgj; // 销往国家
	private String xwgjmc; // 销往国家名称
	private String khxh; // 客户型号
	private String khpp; // 客户品牌
	private Integer ppzx; // 品牌造型
	private Integer rzCb; // 认证-cb
	private Integer rzCe; // 认证-ce
	private Integer rzEtl; // 认证-etl
	private Integer rzFcc; // 认证-fcc
	private Integer rzWu; // 认证-无
	private Integer rzDb; // 认证-杜比
	private Integer rzDts; // 认证-DTS
	private Integer rzHdmi; // 认证-HDMI
	private Integer rzQt; // 认证-其他
	private String rzQtBz; // 认证-其他-备注
	private Integer ppwjgs; // 品牌文件格式
	private Integer ppwj; // 品牌文件
	private String jixing; // 机型
	private String jixin; // 机芯
	private Integer mkSfLogo; // 面壳-是否带logo
	private Integer mkLogoWz; // 面壳-带logo-位置
	private String mkLogoWzBz; // 面壳-带logo-位置-备注
	private Integer mkLogoCc; // 面壳-带logo-尺寸
	private Double mkLogoCcC; // 面壳-带logo-尺寸-长
	private Double mkLogoCcK; // 面壳-带logo-尺寸-宽
	private Integer mkLogoGy; // 面壳-带logo-工艺
	private String mkLogoGyBz; // 面壳-带logo-工艺-备注
	private Integer mkLogoYs; // 面壳-带logo-颜色
	private String mkLogoYsBz; // 面壳-带logo-颜色-备注
	private Integer mkQt; // 面壳-其他
	private String mkQtBz; // 面壳-其他-备注
	private Integer mkQtWz; // 面壳-其他-位置
	private String mkQtWzBz; // 面壳-其他-位置-备注
	private Integer mkQtCc; // 面壳-其他-尺寸
	private Double mkQtCcC; // 面壳-其他-尺寸-长
	private Double mkQtCcK; // 面壳-其他-尺寸-宽
	private Integer mkQtGy; // 面壳-其他-工艺
	private String mkQtGyBz; // 面壳-其他-工艺-备注
	private Integer mkQtYs; // 面壳-其他-颜色
	private String mkQtYsBz; // 面壳-其他-颜色-备注
	private Integer mkQtKgwjgs; // 面壳-其他-客供文件格式
	private Integer mkQtKgwj; // 面壳-其他-客供文件
	private Integer sfYkq; // 是否需要遥控器
	private Integer ykqSfLogo; // 遥控器-是否带logo
	private Integer ykqLogoWz; // 遥控器-带logo器-位置
	private Integer ykqLogoCc; // 遥控器-带logo-尺寸
	private Double ykqLogoCcC; // 遥控器-带logo-尺寸-长
	private Double ykqLogoCcK; // 遥控器-带logo-尺寸-宽
	private Integer ykqLogoGy; // 遥控器-带logo-工艺
	private String ykqLogoGyBz; // 遥控器-带logo-工艺-备注
	private Integer ykqLogoYs; // 遥控器-带logo-颜色
	private String ykqLogoYsBz; // 遥控器-带logo-颜色-备注
	private Integer ykqQt; // 遥控器-其他
	private String ykqQtBz; // 遥控器-其他-备注
	private Integer ykqQtWz; // 遥控器-其他-位置
	private String ykqQtWzBz; // 遥控器-其他-位置-备注
	private Integer ykqQtCc; // 遥控器-其他-尺寸
	private Double ykqQtCcC; // 遥控器-其他-尺寸-长
	private Double ykqQtCcK; // 遥控器-其他-尺寸-宽
	private Integer ykqQtGy; // 遥控器-其他-工艺
	private String ykqQtGyBz; // 遥控器-其他-工艺-备注
	private Integer ykqQtYs; // 遥控器-其他-颜色
	private String ykqQtYsBz; // 遥控器-其他-颜色-备注
	private Integer ykqQtKgwjgs; // 遥控器-其他-客供文件格式
	private Integer ykqQtKgwj; // 遥控器-其他-客供文件
	private Integer sfSms; // 是否需要说明书
	private Integer smsLx; // 说明书类型
	private Integer smsYz; // 说明书-单语种
	private Integer smsYzYz; // 说明书-单语种-语种
	private String smsYzYzBz; // 说明书-单语种-语种-备注
	private Integer smsYzCc; // 说明书-单语种-尺寸
	private String smsYzCcBz; // 说明书-单语种-尺寸-备注
	private Integer smsYzYsys; // 说明书-单语种-印刷颜色
	private String smsYzYsysBz; // 说明书-单语种-印刷颜色-备注
	private Integer smsYzCz; // 说明书-单语种-材质及装订方式
	private String smsYzCzBz; // 说明书-单语种-材质及装订方式-备注
	private Integer smsDyz; // 说明书-多语种
	private Integer smsDyzYz; // 说明书-多语种-语种
	private String smsDyzYzBz; // 说明书-多语种-语种-备注
	private Integer smsDyzCc; // 说明书-多语种-尺寸
	private String smsDyzCcBz; // 说明书-多语种-尺寸-备注
	private Integer smsDyzYsys; // 说明书-多语种-印刷颜色
	private String smsDyzYsysBz; // 说明书-多语种-印刷颜色-备注
	private Integer smsDyzCz; // 说明书-多语种-材质
	private String smsDyzCzBz; // 说明书-多语种-材质-备注
	private Integer smsDyzZdfs; // 说明书-多语种-装订方式
	private Integer smsZsj; // 说明书-再设计
	private Integer smsZsjKgscgs; // 说明书-再设计-客供素材格式
	private Integer smsZsjKgscwj; // 说明书-再设计-客供素材文件
	private Integer smsBkg; // 说明书-不可改
	private Integer smsBkgKgzlgs; // 说明书-不可改-客供资料格式
	private Integer smsBkgKgzlwj; // 说明书-不可改-客供资料文件
	private Integer smsWc; // 说明书-外采
	private Integer smsSqbh; // 说明书-申请编号
	private Integer sfDzazsm; // 是否需要底座安装说明
	private Integer dzazsmYz; // 底座安装说明-语种
	private String dzazsmYzBz; // 底座安装说明-语种-备注
	private Integer dzazsmYs; // 底座安装说明-印刷
	private Integer dzazsmWc; // 底座安装说明-外采
	private Integer dzazsmSqbh; // 底座安装说明-申请编号
	private Integer sfZx; // 是否需要纸箱
	private Integer zxLx; // 纸箱-类型
	private Integer zxSjbz; // 纸箱-设计标准
	private Integer zxBkgKgzlgs; // 纸箱-不可改-客供资料格式
	private Integer zxBkgKgzlwj; // 纸箱-不可改-客供资料文件
	private String zxZsjXlm; // 纸箱-再设计-系列名
	private String zxZsjTdgn; // 纸箱-再设计-特点功能
	private String zxZsjQt; // 纸箱-再设计-其他
	private Integer zxZsjKgscgs; // 纸箱-再设计-客供素材格式
	private Integer zxZsjKgscwj; // 纸箱-再设计-客供素材文件
	private Integer zxWc; // 纸箱-外采
	private Integer zxSqbh; // 纸箱-申请编号
	private Integer sfZxtz; // 是否需要纸箱贴纸
	private Integer zxtzZlbz; // 纸箱贴纸-资料标准
	private String zxtzBzzlTmh; // 纸箱贴纸-标准资料-条码号
	private Integer zxtzBkgKgzlgs; // 纸箱贴纸-不可改-客供资料格式
	private Integer zxtzBkgKgzlwj; // 纸箱贴纸-不可改-客供资料文件
	private String zxtzZsjTmh; // 纸箱贴纸--再设计-条码号
	private String zxtzZsjCdxx; // 纸箱贴纸--再设计-产地信息
	private String zxtzZsjQt; // 纸箱贴纸--再设计-其他
	private Integer zxtzZsjKgscgs; // 纸箱贴纸--再设计-客供素材格式
	private Integer zxtzZsjKgscwj; // 纸箱贴纸--再设计-客供素材文件
	private Integer zxtzWc; // 纸箱贴纸-外采
	private Integer zxtzSqbh; // 纸箱贴纸-申请编号
	private Integer sfHgtz; // 是否需要后盖贴纸
	private Integer hgtzZlbz; // 后盖贴纸-资料标准
	private String hgtzBzzlJksxx; // 后盖贴纸-标准资料-进口商信息
	private String hgtzBzzlZzsxx; // 后盖贴纸-标准资料-制造商信息
	private String hgtzBzzlCdxx; // 后盖贴纸-标准资料-产地信息
	private Integer hgtzBkgKgzlgs; // 后盖贴纸-不可改-客供资料格式
	private Integer hgtzBkgKgzlwj; // 后盖贴纸-不可改-客供资料文件
	private String hgtzZsjCdxx; // 后盖贴纸--再设计-产地信息
	private String hgtzZsjQt; // 后盖贴纸--再设计-其他
	private Integer hgtzZsjKgscgs; // 后盖贴纸--再设计-客供素材格式
	private Integer hgtzZsjKgscwj; // 后盖贴纸--再设计-客供素材文件
	private Integer hgtzWc; // 后盖贴纸-外采
	private Integer hgtzSqbh; // 后盖贴纸-申请编号
	private Integer sfBzk; // 是否需要保证卡
	private Integer bzkZlbz; // 保证卡-资料标准
	private Integer bzkBkgKgzlgs; // 保证卡-不可改-客供资料格式
	private Integer bzkBkgCzysyq; // 保证卡-不可改-材质印刷要求
	private String bzkBkgCzysyqBz; // 保证卡-不可改-材质印刷要求-备注
	private Integer bzkBkgZdyq; // 保证卡-不可改-装订要求
	private Integer bzkBkgKgzlwj; // 保证卡-不可改-客供资料文件
	private Integer bzkWc; // 保证卡-外采
	private Integer bzkSqbh; // 保证卡-申请编号
	private Integer sfZjxhtz; // 是否需要整机序号贴纸
	private Integer zjxhtzXhbz; // 整机序号贴纸-序号标准
	private String zjxhtzXhbzKgxh; // 整机序号贴纸-序号标准-客供序号
	private Integer zjxhtzGsbzCc; // 整机序号贴纸-公司标准-尺寸
	private Integer zjxhtzGsbzYljztwz; // 整机序号贴纸-公司标准-用量及粘贴位置
	private String zjxhtzGsbzYljztwzBz; // 整机序号贴纸-公司标准-用量及粘贴位置-备注
	private Integer zjxhtzKgCc; // 整机序号贴纸-客供-尺寸
	private String zjxhtzKgCcBz; // 整机序号贴纸-客供-尺寸-备注
	private Integer zjxhtzKgYljztwz; // 整机序号贴纸-客供-用量及粘贴位置
	private String zjxhtzKgYljztwzBz; // 整机序号贴纸-客供-用量及粘贴位置-备注
	private String zjxhtzKgCzdtsyq; // 整机序号贴纸-客供-材质等特殊要求
	private String mgqtyq; // 美工其他要求
	private String fj;	//附件
	private String mgzjh; // 美工组件号
	private Date sxsj; // 生效时间
	private Integer sfBg; // 是否变更
	private Integer bgSflc; // 变更-是否量产
	private Integer bgSflcValue; // 变更-是否量产 value
	private String bgLcksddh; // 变更-量产开始订单号
	private Integer bgSjddsl; // 变更-涉及订单数量
	private String bgNr; // 变更-内容
	private String bgYy; // 变更-原因
	private String bgSqr; // 变更申请人id
	private String bgSqrmc; // 变更申请人名称
	private Date bgSqsj; // 变更申请时间
	private Integer dzazsmNr; // 底座安装说明-内容
	private Integer sfNxtz;   // 是否能效贴纸
	private Integer nxtzYlWz; // 能效贴纸用量位置
	private String nxtzYlWzBz; // 能效贴纸用量位置-备注
	private Integer nxtzWc;   // 能效贴纸-外采
	private Integer nxtzSqbh; // 能效贴纸-申请编号
	private Integer mbbs;//模板标识
	private String ywz;		// 销售员所属业务组
	private String ywzmc;		// 销售员所属业务组名称
	private String xszz;		// 销售员所属销售组织
	private String xszzmc;		// 销售员所属销售组织名称
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String vbbh;
	private String bzkBkgZdyqBz;//保证卡-不可改-装订要求-备注
	private String bzkBkgKgzlwjBz;//保证卡-不可改-客供资料文件-备注

	public Artoem() {
		super();
	}

	public Artoem(String id) {
		super(id);
	}

	public String getRwdh() {
		return rwdh;
	}

	public void setRwdh(String rwdh) {
		this.rwdh = rwdh;
	}

	public Integer getBbh() {
		return bbh;
	}

	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}

	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getWkysbz() {
		return wkysbz;
	}

	public void setWkysbz(String wkysbz) {
		this.wkysbz = wkysbz;
	}

	public String getWkysbzmc() {
		return wkysbzmc;
	}

	public void setWkysbzmc(String wkysbzmc) {
		this.wkysbzmc = wkysbzmc;
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

	public String getXwgj() {
		return xwgj;
	}

	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}

	public String getXwgjmc() {
		return xwgjmc;
	}

	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}

	public String getKhxh() {
		return khxh;
	}

	public void setKhxh(String khxh) {
		this.khxh = khxh;
	}

	public String getKhpp() {
		return khpp;
	}

	public void setKhpp(String khpp) {
		this.khpp = khpp;
	}

	public Integer getPpzx() {
		return ppzx;
	}

	public void setPpzx(Integer ppzx) {
		this.ppzx = ppzx;
	}

	public Integer getRzCb() {
		return rzCb;
	}

	public void setRzCb(Integer rzCb) {
		this.rzCb = rzCb;
	}

	public Integer getRzCe() {
		return rzCe;
	}

	public void setRzCe(Integer rzCe) {
		this.rzCe = rzCe;
	}

	public Integer getRzEtl() {
		return rzEtl;
	}

	public void setRzEtl(Integer rzEtl) {
		this.rzEtl = rzEtl;
	}

	public Integer getRzFcc() {
		return rzFcc;
	}

	public void setRzFcc(Integer rzFcc) {
		this.rzFcc = rzFcc;
	}

	public Integer getRzQt() {
		return rzQt;
	}

	public void setRzQt(Integer rzQt) {
		this.rzQt = rzQt;
	}

	public String getRzQtBz() {
		return rzQtBz;
	}

	public void setRzQtBz(String rzQtBz) {
		this.rzQtBz = rzQtBz;
	}

	public Integer getPpwjgs() {
		return ppwjgs;
	}

	public void setPpwjgs(Integer ppwjgs) {
		this.ppwjgs = ppwjgs;
	}

	public Integer getPpwj() {
		return ppwj;
	}

	public void setPpwj(Integer ppwj) {
		this.ppwj = ppwj;
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

	public Integer getMkSfLogo() {
		return mkSfLogo;
	}

	public void setMkSfLogo(Integer mkSfLogo) {
		this.mkSfLogo = mkSfLogo;
	}

	public Integer getMkLogoWz() {
		return mkLogoWz;
	}

	public void setMkLogoWz(Integer mkLogoWz) {
		this.mkLogoWz = mkLogoWz;
	}

	public String getMkLogoWzBz() {
		return mkLogoWzBz;
	}

	public void setMkLogoWzBz(String mkLogoWzBz) {
		this.mkLogoWzBz = mkLogoWzBz;
	}

	public Integer getMkLogoCc() {
		return mkLogoCc;
	}

	public void setMkLogoCc(Integer mkLogoCc) {
		this.mkLogoCc = mkLogoCc;
	}

	public Double getMkLogoCcC() {
		return mkLogoCcC;
	}

	public void setMkLogoCcC(Double mkLogoCcC) {
		this.mkLogoCcC = mkLogoCcC;
	}

	public Double getMkLogoCcK() {
		return mkLogoCcK;
	}

	public void setMkLogoCcK(Double mkLogoCcK) {
		this.mkLogoCcK = mkLogoCcK;
	}

	public Integer getMkLogoGy() {
		return mkLogoGy;
	}

	public void setMkLogoGy(Integer mkLogoGy) {
		this.mkLogoGy = mkLogoGy;
	}

	public Integer getMkLogoYs() {
		return mkLogoYs;
	}

	public void setMkLogoYs(Integer mkLogoYs) {
		this.mkLogoYs = mkLogoYs;
	}

	public String getMkLogoYsBz() {
		return mkLogoYsBz;
	}

	public void setMkLogoYsBz(String mkLogoYsBz) {
		this.mkLogoYsBz = mkLogoYsBz;
	}

	public Integer getMkQt() {
		return mkQt;
	}

	public void setMkQt(Integer mkQt) {
		this.mkQt = mkQt;
	}

	public String getMkQtBz() {
		return mkQtBz;
	}

	public void setMkQtBz(String mkQtBz) {
		this.mkQtBz = mkQtBz;
	}

	public Integer getMkQtWz() {
		return mkQtWz;
	}

	public void setMkQtWz(Integer mkQtWz) {
		this.mkQtWz = mkQtWz;
	}

	public String getMkQtWzBz() {
		return mkQtWzBz;
	}

	public void setMkQtWzBz(String mkQtWzBz) {
		this.mkQtWzBz = mkQtWzBz;
	}

	public Integer getMkQtCc() {
		return mkQtCc;
	}

	public void setMkQtCc(Integer mkQtCc) {
		this.mkQtCc = mkQtCc;
	}

	public Double getMkQtCcC() {
		return mkQtCcC;
	}

	public void setMkQtCcC(Double mkQtCcC) {
		this.mkQtCcC = mkQtCcC;
	}

	public Double getMkQtCcK() {
		return mkQtCcK;
	}

	public void setMkQtCcK(Double mkQtCcK) {
		this.mkQtCcK = mkQtCcK;
	}

	public Integer getMkQtGy() {
		return mkQtGy;
	}

	public void setMkQtGy(Integer mkQtGy) {
		this.mkQtGy = mkQtGy;
	}

	public String getMkQtGyBz() {
		return mkQtGyBz;
	}

	public void setMkQtGyBz(String mkQtGyBz) {
		this.mkQtGyBz = mkQtGyBz;
	}

	public Integer getMkQtYs() {
		return mkQtYs;
	}

	public void setMkQtYs(Integer mkQtYs) {
		this.mkQtYs = mkQtYs;
	}

	public String getMkQtYsBz() {
		return mkQtYsBz;
	}

	public void setMkQtYsBz(String mkQtYsBz) {
		this.mkQtYsBz = mkQtYsBz;
	}

	public Integer getMkQtKgwjgs() {
		return mkQtKgwjgs;
	}

	public void setMkQtKgwjgs(Integer mkQtKgwjgs) {
		this.mkQtKgwjgs = mkQtKgwjgs;
	}

	public Integer getMkQtKgwj() {
		return mkQtKgwj;
	}

	public void setMkQtKgwj(Integer mkQtKgwj) {
		this.mkQtKgwj = mkQtKgwj;
	}

	public Integer getYkqSfLogo() {
		return ykqSfLogo;
	}

	public void setYkqSfLogo(Integer ykqSfLogo) {
		this.ykqSfLogo = ykqSfLogo;
	}

	public Integer getYkqLogoWz() {
		return ykqLogoWz;
	}

	public void setYkqLogoWz(Integer ykqLogoWz) {
		this.ykqLogoWz = ykqLogoWz;
	}

	public Integer getYkqLogoCc() {
		return ykqLogoCc;
	}

	public void setYkqLogoCc(Integer ykqLogoCc) {
		this.ykqLogoCc = ykqLogoCc;
	}

	public Double getYkqLogoCcC() {
		return ykqLogoCcC;
	}

	public void setYkqLogoCcC(Double ykqLogoCcC) {
		this.ykqLogoCcC = ykqLogoCcC;
	}

	public Double getYkqLogoCcK() {
		return ykqLogoCcK;
	}

	public void setYkqLogoCcK(Double ykqLogoCcK) {
		this.ykqLogoCcK = ykqLogoCcK;
	}

	public Integer getYkqLogoGy() {
		return ykqLogoGy;
	}

	public void setYkqLogoGy(Integer ykqLogoGy) {
		this.ykqLogoGy = ykqLogoGy;
	}

	public String getYkqLogoGyBz() {
		return ykqLogoGyBz;
	}

	public void setYkqLogoGyBz(String ykqLogoGyBz) {
		this.ykqLogoGyBz = ykqLogoGyBz;
	}

	public Integer getYkqLogoYs() {
		return ykqLogoYs;
	}

	public void setYkqLogoYs(Integer ykqLogoYs) {
		this.ykqLogoYs = ykqLogoYs;
	}

	public String getYkqLogoYsBz() {
		return ykqLogoYsBz;
	}

	public void setYkqLogoYsBz(String ykqLogoYsBz) {
		this.ykqLogoYsBz = ykqLogoYsBz;
	}

	public Integer getYkqQt() {
		return ykqQt;
	}

	public void setYkqQt(Integer ykqQt) {
		this.ykqQt = ykqQt;
	}

	public String getYkqQtBz() {
		return ykqQtBz;
	}

	public void setYkqQtBz(String ykqQtBz) {
		this.ykqQtBz = ykqQtBz;
	}

	public Integer getYkqQtWz() {
		return ykqQtWz;
	}

	public void setYkqQtWz(Integer ykqQtWz) {
		this.ykqQtWz = ykqQtWz;
	}

	public String getYkqQtWzBz() {
		return ykqQtWzBz;
	}

	public void setYkqQtWzBz(String ykqQtWzBz) {
		this.ykqQtWzBz = ykqQtWzBz;
	}

	public Integer getYkqQtCc() {
		return ykqQtCc;
	}

	public void setYkqQtCc(Integer ykqQtCc) {
		this.ykqQtCc = ykqQtCc;
	}

	public Double getYkqQtCcC() {
		return ykqQtCcC;
	}

	public void setYkqQtCcC(Double ykqQtCcC) {
		this.ykqQtCcC = ykqQtCcC;
	}

	public Double getYkqQtCcK() {
		return ykqQtCcK;
	}

	public void setYkqQtCcK(Double ykqQtCcK) {
		this.ykqQtCcK = ykqQtCcK;
	}

	public Integer getYkqQtGy() {
		return ykqQtGy;
	}

	public void setYkqQtGy(Integer ykqQtGy) {
		this.ykqQtGy = ykqQtGy;
	}

	public String getYkqQtGyBz() {
		return ykqQtGyBz;
	}

	public void setYkqQtGyBz(String ykqQtGyBz) {
		this.ykqQtGyBz = ykqQtGyBz;
	}

	public Integer getYkqQtYs() {
		return ykqQtYs;
	}

	public void setYkqQtYs(Integer ykqQtYs) {
		this.ykqQtYs = ykqQtYs;
	}

	public String getYkqQtYsBz() {
		return ykqQtYsBz;
	}

	public void setYkqQtYsBz(String ykqQtYsBz) {
		this.ykqQtYsBz = ykqQtYsBz;
	}

	public Integer getYkqQtKgwjgs() {
		return ykqQtKgwjgs;
	}

	public void setYkqQtKgwjgs(Integer ykqQtKgwjgs) {
		this.ykqQtKgwjgs = ykqQtKgwjgs;
	}

	public Integer getYkqQtKgwj() {
		return ykqQtKgwj;
	}

	public void setYkqQtKgwj(Integer ykqQtKgwj) {
		this.ykqQtKgwj = ykqQtKgwj;
	}

	public Integer getSfSms() {
		return sfSms;
	}

	public void setSfSms(Integer sfSms) {
		this.sfSms = sfSms;
	}

	public Integer getSmsLx() {
		return smsLx;
	}

	public void setSmsLx(Integer smsLx) {
		this.smsLx = smsLx;
	}

	public Integer getSmsYz() {
		return smsYz;
	}

	public void setSmsYz(Integer smsYz) {
		this.smsYz = smsYz;
	}

	public Integer getSmsYzYz() {
		return smsYzYz;
	}

	public void setSmsYzYz(Integer smsYzYz) {
		this.smsYzYz = smsYzYz;
	}

	public String getSmsYzYzBz() {
		return smsYzYzBz;
	}

	public void setSmsYzYzBz(String smsYzYzBz) {
		this.smsYzYzBz = smsYzYzBz;
	}

	public Integer getSmsYzCc() {
		return smsYzCc;
	}

	public void setSmsYzCc(Integer smsYzCc) {
		this.smsYzCc = smsYzCc;
	}

	public String getSmsYzCcBz() {
		return smsYzCcBz;
	}

	public void setSmsYzCcBz(String smsYzCcBz) {
		this.smsYzCcBz = smsYzCcBz;
	}

	public Integer getSmsYzYsys() {
		return smsYzYsys;
	}

	public void setSmsYzYsys(Integer smsYzYsys) {
		this.smsYzYsys = smsYzYsys;
	}

	public Integer getSmsYzCz() {
		return smsYzCz;
	}

	public void setSmsYzCz(Integer smsYzCz) {
		this.smsYzCz = smsYzCz;
	}

	public Integer getSmsDyz() {
		return smsDyz;
	}

	public void setSmsDyz(Integer smsDyz) {
		this.smsDyz = smsDyz;
	}

	public Integer getSmsDyzYz() {
		return smsDyzYz;
	}

	public void setSmsDyzYz(Integer smsDyzYz) {
		this.smsDyzYz = smsDyzYz;
	}

	public String getSmsDyzYzBz() {
		return smsDyzYzBz;
	}

	public void setSmsDyzYzBz(String smsDyzYzBz) {
		this.smsDyzYzBz = smsDyzYzBz;
	}

	public Integer getSmsDyzCc() {
		return smsDyzCc;
	}

	public void setSmsDyzCc(Integer smsDyzCc) {
		this.smsDyzCc = smsDyzCc;
	}

	public String getSmsDyzCcBz() {
		return smsDyzCcBz;
	}

	public void setSmsDyzCcBz(String smsDyzCcBz) {
		this.smsDyzCcBz = smsDyzCcBz;
	}

	public Integer getSmsDyzYsys() {
		return smsDyzYsys;
	}

	public void setSmsDyzYsys(Integer smsDyzYsys) {
		this.smsDyzYsys = smsDyzYsys;
	}

	public Integer getSmsDyzCz() {
		return smsDyzCz;
	}

	public void setSmsDyzCz(Integer smsDyzCz) {
		this.smsDyzCz = smsDyzCz;
	}

	public Integer getSmsDyzZdfs() {
		return smsDyzZdfs;
	}

	public void setSmsDyzZdfs(Integer smsDyzZdfs) {
		this.smsDyzZdfs = smsDyzZdfs;
	}

	public Integer getSmsZsj() {
		return smsZsj;
	}

	public void setSmsZsj(Integer smsZsj) {
		this.smsZsj = smsZsj;
	}

	public Integer getSmsZsjKgscgs() {
		return smsZsjKgscgs;
	}

	public void setSmsZsjKgscgs(Integer smsZsjKgscgs) {
		this.smsZsjKgscgs = smsZsjKgscgs;
	}

	public Integer getSmsZsjKgscwj() {
		return smsZsjKgscwj;
	}

	public void setSmsZsjKgscwj(Integer smsZsjKgscwj) {
		this.smsZsjKgscwj = smsZsjKgscwj;
	}

	public Integer getSmsBkg() {
		return smsBkg;
	}

	public void setSmsBkg(Integer smsBkg) {
		this.smsBkg = smsBkg;
	}

	public Integer getSmsBkgKgzlgs() {
		return smsBkgKgzlgs;
	}

	public void setSmsBkgKgzlgs(Integer smsBkgKgzlgs) {
		this.smsBkgKgzlgs = smsBkgKgzlgs;
	}

	public Integer getSmsBkgKgzlwj() {
		return smsBkgKgzlwj;
	}

	public void setSmsBkgKgzlwj(Integer smsBkgKgzlwj) {
		this.smsBkgKgzlwj = smsBkgKgzlwj;
	}

	public Integer getSmsWc() {
		return smsWc;
	}

	public void setSmsWc(Integer smsWc) {
		this.smsWc = smsWc;
	}

	public Integer getSmsSqbh() {
		return smsSqbh;
	}

	public void setSmsSqbh(Integer smsSqbh) {
		this.smsSqbh = smsSqbh;
	}

	public Integer getSfDzazsm() {
		return sfDzazsm;
	}

	public void setSfDzazsm(Integer sfDzazsm) {
		this.sfDzazsm = sfDzazsm;
	}

	public Integer getDzazsmYz() {
		return dzazsmYz;
	}

	public void setDzazsmYz(Integer dzazsmYz) {
		this.dzazsmYz = dzazsmYz;
	}

	public String getDzazsmYzBz() {
		return dzazsmYzBz;
	}

	public void setDzazsmYzBz(String dzazsmYzBz) {
		this.dzazsmYzBz = dzazsmYzBz;
	}

	public Integer getDzazsmYs() {
		return dzazsmYs;
	}

	public void setDzazsmYs(Integer dzazsmYs) {
		this.dzazsmYs = dzazsmYs;
	}

	public Integer getDzazsmWc() {
		return dzazsmWc;
	}

	public void setDzazsmWc(Integer dzazsmWc) {
		this.dzazsmWc = dzazsmWc;
	}

	public Integer getDzazsmSqbh() {
		return dzazsmSqbh;
	}

	public void setDzazsmSqbh(Integer dzazsmSqbh) {
		this.dzazsmSqbh = dzazsmSqbh;
	}

	public Integer getSfZx() {
		return sfZx;
	}

	public void setSfZx(Integer sfZx) {
		this.sfZx = sfZx;
	}

	public Integer getZxLx() {
		return zxLx;
	}

	public void setZxLx(Integer zxLx) {
		this.zxLx = zxLx;
	}

	public Integer getZxSjbz() {
		return zxSjbz;
	}

	public void setZxSjbz(Integer zxSjbz) {
		this.zxSjbz = zxSjbz;
	}

	public Integer getZxBkgKgzlgs() {
		return zxBkgKgzlgs;
	}

	public void setZxBkgKgzlgs(Integer zxBkgKgzlgs) {
		this.zxBkgKgzlgs = zxBkgKgzlgs;
	}

	public Integer getZxBkgKgzlwj() {
		return zxBkgKgzlwj;
	}

	public void setZxBkgKgzlwj(Integer zxBkgKgzlwj) {
		this.zxBkgKgzlwj = zxBkgKgzlwj;
	}

	public String getZxZsjXlm() {
		return zxZsjXlm;
	}

	public void setZxZsjXlm(String zxZsjXlm) {
		this.zxZsjXlm = zxZsjXlm;
	}

	public String getZxZsjTdgn() {
		return zxZsjTdgn;
	}

	public void setZxZsjTdgn(String zxZsjTdgn) {
		this.zxZsjTdgn = zxZsjTdgn;
	}

	public String getZxZsjQt() {
		return zxZsjQt;
	}

	public void setZxZsjQt(String zxZsjQt) {
		this.zxZsjQt = zxZsjQt;
	}

	public Integer getZxZsjKgscgs() {
		return zxZsjKgscgs;
	}

	public void setZxZsjKgscgs(Integer zxZsjKgscgs) {
		this.zxZsjKgscgs = zxZsjKgscgs;
	}

	public Integer getZxZsjKgscwj() {
		return zxZsjKgscwj;
	}

	public void setZxZsjKgscwj(Integer zxZsjKgscwj) {
		this.zxZsjKgscwj = zxZsjKgscwj;
	}

	public Integer getZxWc() {
		return zxWc;
	}

	public void setZxWc(Integer zxWc) {
		this.zxWc = zxWc;
	}

	public Integer getZxSqbh() {
		return zxSqbh;
	}

	public void setZxSqbh(Integer zxSqbh) {
		this.zxSqbh = zxSqbh;
	}

	public Integer getSfZxtz() {
		return sfZxtz;
	}

	public void setSfZxtz(Integer sfZxtz) {
		this.sfZxtz = sfZxtz;
	}

	public Integer getZxtzZlbz() {
		return zxtzZlbz;
	}

	public void setZxtzZlbz(Integer zxtzZlbz) {
		this.zxtzZlbz = zxtzZlbz;
	}

	public String getZxtzBzzlTmh() {
		return zxtzBzzlTmh;
	}

	public void setZxtzBzzlTmh(String zxtzBzzlTmh) {
		this.zxtzBzzlTmh = zxtzBzzlTmh;
	}

	public Integer getZxtzBkgKgzlgs() {
		return zxtzBkgKgzlgs;
	}

	public void setZxtzBkgKgzlgs(Integer zxtzBkgKgzlgs) {
		this.zxtzBkgKgzlgs = zxtzBkgKgzlgs;
	}

	public Integer getZxtzBkgKgzlwj() {
		return zxtzBkgKgzlwj;
	}

	public void setZxtzBkgKgzlwj(Integer zxtzBkgKgzlwj) {
		this.zxtzBkgKgzlwj = zxtzBkgKgzlwj;
	}

	public String getZxtzZsjTmh() {
		return zxtzZsjTmh;
	}

	public void setZxtzZsjTmh(String zxtzZsjTmh) {
		this.zxtzZsjTmh = zxtzZsjTmh;
	}

	public String getZxtzZsjCdxx() {
		return zxtzZsjCdxx;
	}

	public void setZxtzZsjCdxx(String zxtzZsjCdxx) {
		this.zxtzZsjCdxx = zxtzZsjCdxx;
	}

	public String getZxtzZsjQt() {
		return zxtzZsjQt;
	}

	public void setZxtzZsjQt(String zxtzZsjQt) {
		this.zxtzZsjQt = zxtzZsjQt;
	}

	public Integer getZxtzZsjKgscgs() {
		return zxtzZsjKgscgs;
	}

	public void setZxtzZsjKgscgs(Integer zxtzZsjKgscgs) {
		this.zxtzZsjKgscgs = zxtzZsjKgscgs;
	}

	public Integer getZxtzZsjKgscwj() {
		return zxtzZsjKgscwj;
	}

	public void setZxtzZsjKgscwj(Integer zxtzZsjKgscwj) {
		this.zxtzZsjKgscwj = zxtzZsjKgscwj;
	}

	public Integer getZxtzWc() {
		return zxtzWc;
	}

	public void setZxtzWc(Integer zxtzWc) {
		this.zxtzWc = zxtzWc;
	}

	public Integer getZxtzSqbh() {
		return zxtzSqbh;
	}

	public void setZxtzSqbh(Integer zxtzSqbh) {
		this.zxtzSqbh = zxtzSqbh;
	}

	public Integer getSfHgtz() {
		return sfHgtz;
	}

	public void setSfHgtz(Integer sfHgtz) {
		this.sfHgtz = sfHgtz;
	}

	public Integer getHgtzZlbz() {
		return hgtzZlbz;
	}

	public void setHgtzZlbz(Integer hgtzZlbz) {
		this.hgtzZlbz = hgtzZlbz;
	}

	public String getHgtzBzzlJksxx() {
		return hgtzBzzlJksxx;
	}

	public void setHgtzBzzlJksxx(String hgtzBzzlJksxx) {
		this.hgtzBzzlJksxx = hgtzBzzlJksxx;
	}

	public String getHgtzBzzlZzsxx() {
		return hgtzBzzlZzsxx;
	}

	public void setHgtzBzzlZzsxx(String hgtzBzzlZzsxx) {
		this.hgtzBzzlZzsxx = hgtzBzzlZzsxx;
	}

	public String getHgtzBzzlCdxx() {
		return hgtzBzzlCdxx;
	}

	public void setHgtzBzzlCdxx(String hgtzBzzlCdxx) {
		this.hgtzBzzlCdxx = hgtzBzzlCdxx;
	}

	public Integer getHgtzBkgKgzlgs() {
		return hgtzBkgKgzlgs;
	}

	public void setHgtzBkgKgzlgs(Integer hgtzBkgKgzlgs) {
		this.hgtzBkgKgzlgs = hgtzBkgKgzlgs;
	}

	public Integer getHgtzBkgKgzlwj() {
		return hgtzBkgKgzlwj;
	}

	public void setHgtzBkgKgzlwj(Integer hgtzBkgKgzlwj) {
		this.hgtzBkgKgzlwj = hgtzBkgKgzlwj;
	}

	public String getHgtzZsjCdxx() {
		return hgtzZsjCdxx;
	}

	public void setHgtzZsjCdxx(String hgtzZsjCdxx) {
		this.hgtzZsjCdxx = hgtzZsjCdxx;
	}

	public String getHgtzZsjQt() {
		return hgtzZsjQt;
	}

	public void setHgtzZsjQt(String hgtzZsjQt) {
		this.hgtzZsjQt = hgtzZsjQt;
	}

	public Integer getHgtzZsjKgscgs() {
		return hgtzZsjKgscgs;
	}

	public void setHgtzZsjKgscgs(Integer hgtzZsjKgscgs) {
		this.hgtzZsjKgscgs = hgtzZsjKgscgs;
	}

	public Integer getHgtzZsjKgscwj() {
		return hgtzZsjKgscwj;
	}

	public void setHgtzZsjKgscwj(Integer hgtzZsjKgscwj) {
		this.hgtzZsjKgscwj = hgtzZsjKgscwj;
	}

	public Integer getHgtzWc() {
		return hgtzWc;
	}

	public void setHgtzWc(Integer hgtzWc) {
		this.hgtzWc = hgtzWc;
	}

	public Integer getHgtzSqbh() {
		return hgtzSqbh;
	}

	public void setHgtzSqbh(Integer hgtzSqbh) {
		this.hgtzSqbh = hgtzSqbh;
	}

	public Integer getSfBzk() {
		return sfBzk;
	}

	public void setSfBzk(Integer sfBzk) {
		this.sfBzk = sfBzk;
	}

	public Integer getBzkZlbz() {
		return bzkZlbz;
	}

	public void setBzkZlbz(Integer bzkZlbz) {
		this.bzkZlbz = bzkZlbz;
	}

	public Integer getBzkBkgKgzlgs() {
		return bzkBkgKgzlgs;
	}

	public void setBzkBkgKgzlgs(Integer bzkBkgKgzlgs) {
		this.bzkBkgKgzlgs = bzkBkgKgzlgs;
	}

	public Integer getBzkBkgCzysyq() {
		return bzkBkgCzysyq;
	}

	public void setBzkBkgCzysyq(Integer bzkBkgCzysyq) {
		this.bzkBkgCzysyq = bzkBkgCzysyq;
	}

	public String getBzkBkgCzysyqBz() {
		return bzkBkgCzysyqBz;
	}

	public void setBzkBkgCzysyqBz(String bzkBkgCzysyqBz) {
		this.bzkBkgCzysyqBz = bzkBkgCzysyqBz;
	}

	public Integer getBzkBkgZdyq() {
		return bzkBkgZdyq;
	}

	public void setBzkBkgZdyq(Integer bzkBkgZdyq) {
		this.bzkBkgZdyq = bzkBkgZdyq;
	}

	public Integer getBzkBkgKgzlwj() {
		return bzkBkgKgzlwj;
	}

	public void setBzkBkgKgzlwj(Integer bzkBkgKgzlwj) {
		this.bzkBkgKgzlwj = bzkBkgKgzlwj;
	}

	public Integer getBzkWc() {
		return bzkWc;
	}

	public void setBzkWc(Integer bzkWc) {
		this.bzkWc = bzkWc;
	}

	public Integer getBzkSqbh() {
		return bzkSqbh;
	}

	public void setBzkSqbh(Integer bzkSqbh) {
		this.bzkSqbh = bzkSqbh;
	}

	public Integer getSfZjxhtz() {
		return sfZjxhtz;
	}

	public void setSfZjxhtz(Integer sfZjxhtz) {
		this.sfZjxhtz = sfZjxhtz;
	}

	public Integer getZjxhtzXhbz() {
		return zjxhtzXhbz;
	}

	public void setZjxhtzXhbz(Integer zjxhtzXhbz) {
		this.zjxhtzXhbz = zjxhtzXhbz;
	}

	public String getZjxhtzXhbzKgxh() {
		return zjxhtzXhbzKgxh;
	}

	public void setZjxhtzXhbzKgxh(String zjxhtzXhbzKgxh) {
		this.zjxhtzXhbzKgxh = zjxhtzXhbzKgxh;
	}

	public Integer getZjxhtzGsbzCc() {
		return zjxhtzGsbzCc;
	}

	public void setZjxhtzGsbzCc(Integer zjxhtzGsbzCc) {
		this.zjxhtzGsbzCc = zjxhtzGsbzCc;
	}

	public Integer getZjxhtzGsbzYljztwz() {
		return zjxhtzGsbzYljztwz;
	}

	public void setZjxhtzGsbzYljztwz(Integer zjxhtzGsbzYljztwz) {
		this.zjxhtzGsbzYljztwz = zjxhtzGsbzYljztwz;
	}

	public String getZjxhtzGsbzYljztwzBz() {
		return zjxhtzGsbzYljztwzBz;
	}

	public void setZjxhtzGsbzYljztwzBz(String zjxhtzGsbzYljztwzBz) {
		this.zjxhtzGsbzYljztwzBz = zjxhtzGsbzYljztwzBz;
	}

	public Integer getZjxhtzKgCc() {
		return zjxhtzKgCc;
	}

	public void setZjxhtzKgCc(Integer zjxhtzKgCc) {
		this.zjxhtzKgCc = zjxhtzKgCc;
	}

	public String getZjxhtzKgCcBz() {
		return zjxhtzKgCcBz;
	}

	public void setZjxhtzKgCcBz(String zjxhtzKgCcBz) {
		this.zjxhtzKgCcBz = zjxhtzKgCcBz;
	}

	public Integer getZjxhtzKgYljztwz() {
		return zjxhtzKgYljztwz;
	}

	public void setZjxhtzKgYljztwz(Integer zjxhtzKgYljztwz) {
		this.zjxhtzKgYljztwz = zjxhtzKgYljztwz;
	}

	public String getZjxhtzKgYljztwzBz() {
		return zjxhtzKgYljztwzBz;
	}

	public void setZjxhtzKgYljztwzBz(String zjxhtzKgYljztwzBz) {
		this.zjxhtzKgYljztwzBz = zjxhtzKgYljztwzBz;
	}

	public String getZjxhtzKgCzdtsyq() {
		return zjxhtzKgCzdtsyq;
	}

	public void setZjxhtzKgCzdtsyq(String zjxhtzKgCzdtsyq) {
		this.zjxhtzKgCzdtsyq = zjxhtzKgCzdtsyq;
	}

	public String getMgqtyq() {
		return mgqtyq;
	}

	public void setMgqtyq(String mgqtyq) {
		this.mgqtyq = mgqtyq;
	}

	public String getMgzjh() {
		return mgzjh;
	}

	public void setMgzjh(String mgzjh) {
		this.mgzjh = mgzjh;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSxsj() {
		return sxsj;
	}

	public void setSxsj(Date sxsj) {
		this.sxsj = sxsj;
	}

	public Integer getSfBg() {
		return sfBg;
	}

	public void setSfBg(Integer sfBg) {
		this.sfBg = sfBg;
	}

	public Integer getBgSflc() {
		return bgSflc;
	}

	public void setBgSflc(Integer bgSflc) {
		this.bgSflc = bgSflc;
	}

	public String getBgLcksddh() {
		return bgLcksddh;
	}

	public void setBgLcksddh(String bgLcksddh) {
		this.bgLcksddh = bgLcksddh;
	}

	public Integer getBgSjddsl() {
		return bgSjddsl;
	}

	public void setBgSjddsl(Integer bgSjddsl) {
		this.bgSjddsl = bgSjddsl;
	}

	public String getBgNr() {
		return bgNr;
	}

	public void setBgNr(String bgNr) {
		this.bgNr = bgNr;
	}

	public String getBgYy() {
		return bgYy;
	}

	public void setBgYy(String bgYy) {
		this.bgYy = bgYy;
	}

	public String getBgSqr() {
		return bgSqr;
	}

	public void setBgSqr(String bgSqr) {
		this.bgSqr = bgSqr;
	}

	public String getBgSqrmc() {
		return bgSqrmc;
	}

	public void setBgSqrmc(String bgSqrmc) {
		this.bgSqrmc = bgSqrmc;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getBgSqsj() {
		return bgSqsj;
	}

	public void setBgSqsj(Date bgSqsj) {
		this.bgSqsj = bgSqsj;
	}

	public String getWjbh() {
		return wjbh;
	}

	public void setWjbh(String wjbh) {
		this.wjbh = wjbh;
	}

	public Integer getRzWu() {
		return rzWu;
	}

	public void setRzWu(Integer rzWu) {
		this.rzWu = rzWu;
	}

	public Integer getRzDb() {
		return rzDb;
	}

	public void setRzDb(Integer rzDb) {
		this.rzDb = rzDb;
	}

	public Integer getRzDts() {
		return rzDts;
	}

	public void setRzDts(Integer rzDts) {
		this.rzDts = rzDts;
	}

	public Integer getRzHdmi() {
		return rzHdmi;
	}

	public void setRzHdmi(Integer rzHdmi) {
		this.rzHdmi = rzHdmi;
	}

	public String getMkLogoGyBz() {
		return mkLogoGyBz;
	}

	public void setMkLogoGyBz(String mkLogoGyBz) {
		this.mkLogoGyBz = mkLogoGyBz;
	}

	public Integer getSfYkq() {
		return sfYkq;
	}

	public void setSfYkq(Integer sfYkq) {
		this.sfYkq = sfYkq;
	}

	public String getSmsYzYsysBz() {
		return smsYzYsysBz;
	}

	public void setSmsYzYsysBz(String smsYzYsysBz) {
		this.smsYzYsysBz = smsYzYsysBz;
	}

	public String getSmsYzCzBz() {
		return smsYzCzBz;
	}

	public void setSmsYzCzBz(String smsYzCzBz) {
		this.smsYzCzBz = smsYzCzBz;
	}

	public String getSmsDyzYsysBz() {
		return smsDyzYsysBz;
	}

	public void setSmsDyzYsysBz(String smsDyzYsysBz) {
		this.smsDyzYsysBz = smsDyzYsysBz;
	}

	public String getSmsDyzCzBz() {
		return smsDyzCzBz;
	}

	public void setSmsDyzCzBz(String smsDyzCzBz) {
		this.smsDyzCzBz = smsDyzCzBz;
	}

	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	public Integer getDzazsmNr() {
		return dzazsmNr;
	}

	public void setDzazsmNr(Integer dzazsmNr) {
		this.dzazsmNr = dzazsmNr;
	}

	public Integer getSfNxtz() {
		return sfNxtz;
	}

	public void setSfNxtz(Integer sfNxtz) {
		this.sfNxtz = sfNxtz;
	}

	public Integer getNxtzYlWz() {
		return nxtzYlWz;
	}

	public void setNxtzYlWz(Integer nxtzYlWz) {
		this.nxtzYlWz = nxtzYlWz;
	}

	public String getNxtzYlWzBz() {
		return nxtzYlWzBz;
	}

	public void setNxtzYlWzBz(String nxtzYlWzBz) {
		this.nxtzYlWzBz = nxtzYlWzBz;
	}

	public Integer getNxtzWc() {
		return nxtzWc;
	}

	public void setNxtzWc(Integer nxtzWc) {
		this.nxtzWc = nxtzWc;
	}

	public Integer getNxtzSqbh() {
		return nxtzSqbh;
	}

	public void setNxtzSqbh(Integer nxtzSqbh) {
		this.nxtzSqbh = nxtzSqbh;
	}

	public Integer getMbbs() {
		return mbbs;
	}

	public void setMbbs(Integer mbbs) {
		this.mbbs = mbbs;
	}

	public Integer getBgSflcValue() {
		return bgSflcValue;
	}

	public void setBgSflcValue(Integer bgSflcValue) {
		this.bgSflcValue = bgSflcValue;
	}

	public String getYwz() {
		return ywz;
	}

	public void setYwz(String ywz) {
		this.ywz = ywz;
	}

	public String getYwzmc() {
		return ywzmc;
	}

	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc;
	}

	public String getXszz() {
		return xszz;
	}

	public void setXszz(String xszz) {
		this.xszz = xszz;
	}

	public String getXszzmc() {
		return xszzmc;
	}

	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc;
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

	public String getVbbh() {
		return vbbh;
	}

	public void setVbbh(String vbbh) {
		this.vbbh = vbbh;
	}

	public String getBzkBkgZdyqBz() {
		return bzkBkgZdyqBz;
	}

	public void setBzkBkgZdyqBz(String bzkBkgZdyqBz) {
		this.bzkBkgZdyqBz = bzkBkgZdyqBz;
	}

	public String getBzkBkgKgzlwjBz() {
		return bzkBkgKgzlwjBz;
	}

	public void setBzkBkgKgzlwjBz(String bzkBkgKgzlwjBz) {
		this.bzkBkgKgzlwjBz = bzkBkgKgzlwjBz;
	}

}