package com.ey.piit.sdo.pso.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 预走货Entity
 * @author 赵桃军
 */
public class Pso extends BaseEntity {
	
	private String yzhdh;		// 预走货单号
	private String ckyzhdh;		// 参考预走货单号
	private String yzhlx;		// 预走货类型
	private String yzhlxmc;		// 预走货类型名称
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String xsyid;		// 销售代码（销售员）
	private String xsymc;		// 销售员名称
	private String ywz;		    // 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 业务部门（销售组织）
	private String xszzmc;		// 业务部门（销售组织名称）
	private String mytk;		// 贸易条款
	private String mytkmc;		// 贸易条款名称
	private Integer sfDsdfyf;	// 是否代收代付运费
	private BigDecimal ddje;		// 订单金额
	private BigDecimal qtje;		// 其他金额
	private BigDecimal zje;		    // 总金额
	private String ztyzhdh;		// 主体预走货单号
	private Date zgsj;		    // 装柜时间
	private Integer bzyqGj;		// 包装要求-挂架
	private Integer bzyqDz;		// 包装要求-底座
	private Integer bzyqBzkb;   // 包装要求-木质卡板
	private String fj;		    // 附件
	private Integer ygZgs;		// 用柜-总柜数
	private Integer yg20gp;		// 用柜-20GP
	private Integer yg40gp;		// 用柜-40GP
	private Integer yg40hq;		// 用柜-40HQ
	private String ygGsbz;		// 用柜- 柜数备注
	private Integer dcZcs;		// 吨车-总车数
	private Integer dc3d;		// 吨车-3吨
	private Integer dc5d;		// 吨车-5吨
	private Integer dc8d;		// 吨车-8吨
	private Integer dc10d;		// 吨车-10吨
	private Integer dc12d;		// 吨车-12吨
	private String dcDcbz;		// 吨车-吨车备注
	private String bcGdbs;		// 补充-跟单备损
	private String bcSpobs;		// 补充-SPO备损
	private String bcWjyq;		// 补充-文件要求
	private String bcZgyq;		// 补充-装柜要求
	private String bcQt;		// 补充-其他
	private String cylx;		// 出运类型
	private String cylxmc;		// 出运类型名称
	private String qyg;		    // 起运港
	private String qygmc;		// 起运港名称
	private String qygbz;		// 起运港备注
	private String mdg;		    // 目的港
	private String xwgj;		// 销往国家
	private String xwgjmc;		// 销往国家名称
	private String cdgsbm;		// 船代公司
	private String cdgsmc;		// 船代公司名称
	private String cdgslxr;		// 船代公司联系人
	private String cdgsdh;		// 船代公司电话
	private String cdgscz;		// 船代公司传真
	private String cdgsyb;		// 船代公司邮编
	private String cdgsyx;		// 船代公司邮箱
	private Integer sfXyyh;		// 是否需要验货
	private Date yjyhrq;		// 预计验货日期
	private String shfmc;		// 收货方名称
	private Integer kdlx;		// 快递类型
	private String kd;		    // 快递
	private String kdmc;		// 快递名称
	private String kdbz;		// 快递备注
	private Integer yfcd;		// 运费承担
	private String yflx;		// 运费类型
	private String yflxmc;		// 运费类型名称
	private String dfzh;		// 到付账户
	private BigDecimal ygyf;		// 预估运费
	private String yfbz;		// 运费币种
	private String yffj;		// 运费附件
	private String shfdz;		// 收货方地址
	private String shflxr;		// 收货方联系人
	private String shfdh;		// 收货方电话
	private String shfcz;		// 收货方传真
	private String shfyb;		// 收货方邮编
	private String shfyx;		// 收货方邮箱
	/*配合关务新增字段  魏诚  2018-05-24*/
	private String shfdm;
	private String shrdh;
	private String aeoqybm;
	/********end********/
	private String zdrid;		// 申请人
	private String zdrmc;		// 申请人名称
	private Date zdsj;		    // 申请时间
	private Integer cwsfcl;		// 船务是否处理
	private Integer jfsfsp;     // 技服是否审批
	private Integer cysfbl;     // 储运是否补录
	private Integer zt;		    // 状态
	private Integer bbh;		// 版本号
	private String sjc;		    // 时间戳
	private String cwzyid;		// 船务专员
	private String cwzymc;		// 船务专员名称
	private String beginZgsj;
	private String endZgsj;
	private Integer yssfcq ;    // 应收是否超期
	private String fktj;		// 付款条件
	private String fktjmc;		// 付款条件名称
	private Integer fkbzzt;		// 付款保障状态
	private String sapgsdm;		//SAP公司代码
	private String nr;			//客户应收超期检查结果
	private String  scjd;           //生产基地
	private String  scjdmc;           //生产基地
	private String  kbbz;        //卡板备注
	private Integer smoshzt;		//SMO审核状态
	private String bgbz;   //变更备注
	private String bzyqMzbz;//有无木质包装
	private String bzxx;   //备注
	private Integer sfBd;//多元化是否白电
	private String hwgyl;//海外供应链
	private String hwgylmc;//海外供应链
	private String zzg; //中转港
	
	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public String getBzyqMzbz() {
		return bzyqMzbz;
	}

	public void setBzyqMzbz(String bzyqMzbz) {
		this.bzyqMzbz = bzyqMzbz;
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

	public Integer getYssfcq() {
		return yssfcq;
	}

	public void setYssfcq(Integer yssfcq) {
		this.yssfcq = yssfcq;
	}

	public Pso() {
		super();
	}

	public Pso(String id){
		super(id);
	}

	/**
     * 预走货单号
     */
	@Length(min=1, max=20, message="预走货单号长度必须介于 1 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	/**
     * 预走货单号
     */
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh == null ? null : yzhdh.trim();
	}
	
	/**
     * 参考预走货单号
     */
	@Length(min=0, max=20, message="参考预走货单号长度必须介于 0 和 20 之间")
	public String getCkyzhdh() {
		return ckyzhdh;
	}

	/**
     * 参考预走货单号
     */
	public void setCkyzhdh(String ckyzhdh) {
		this.ckyzhdh = ckyzhdh == null ? null : ckyzhdh.trim();
	}
	
	/**
     * 预走货类型
     */
	@Length(min=0, max=20, message="预走货类型长度必须介于 0 和 20 之间")
	public String getYzhlx() {
		return yzhlx;
	}

	/**
     * 预走货类型
     */
	public void setYzhlx(String yzhlx) {
		this.yzhlx = yzhlx == null ? null : yzhlx.trim();
	}
	
	/**
     * 预走货类型名称
     */
	@Length(min=0, max=50, message="预走货类型名称长度必须介于 0 和 50 之间")
	public String getYzhlxmc() {
		return yzhlxmc;
	}

	/**
     * 预走货类型名称
     */
	public void setYzhlxmc(String yzhlxmc) {
		this.yzhlxmc = yzhlxmc == null ? null : yzhlxmc.trim();
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
     * 销售代码（销售员）
     */
	@Length(min=1, max=20, message="销售代码（销售员）长度必须介于 1 和 20 之间")
	public String getXsyid() {
		return xsyid;
	}

	/**
     * 销售代码（销售员）
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
	@Length(min=0, max=20, message="业务组长度必须介于 0 和 20 之间")
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
     * 业务部门（销售组织）
     */
	@Length(min=1, max=20, message="业务部门（销售组织）长度必须介于 1 和 20 之间")
	public String getXszz() {
		return xszz;
	}

	/**
     * 业务部门（销售组织）
     */
	public void setXszz(String xszz) {
		this.xszz = xszz == null ? null : xszz.trim();
	}
	
	/**
     * 业务部门（销售组织名称）
     */
	@Length(min=0, max=50, message="业务部门（销售组织名称）长度必须介于 0 和 50 之间")
	public String getXszzmc() {
		return xszzmc;
	}

	/**
     * 业务部门（销售组织名称）
     */
	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc == null ? null : xszzmc.trim();
	}
	
	/**
     * 贸易条款
     */
	@Length(min=0, max=20, message="贸易条款长度必须介于 0 和 20 之间")
	public String getMytk() {
		return mytk;
	}

	/**
     * 贸易条款
     */
	public void setMytk(String mytk) {
		this.mytk = mytk == null ? null : mytk.trim();
	}
	
	/**
     * 贸易条款名称
     */
	@Length(min=0, max=50, message="贸易条款名称长度必须介于 0 和 50 之间")
	public String getMytkmc() {
		return mytkmc;
	}

	/**
     * 贸易条款名称
     */
	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc == null ? null : mytkmc.trim();
	}
	
	/**
     * 是否代收代付运费
     */
	public Integer getSfDsdfyf() {
		return sfDsdfyf;
	}

	/**
     * 是否代收代付运费
     */
	public void setSfDsdfyf(Integer sfDsdfyf) {
		this.sfDsdfyf = sfDsdfyf;
	}
	
	/**
     * 主体预走货单号
     */
	@Length(min=0, max=20, message="主体预走货单号长度必须介于 0 和 20 之间")
	public String getZtyzhdh() {
		return ztyzhdh;
	}

	/**
     * 主体预走货单号
     */
	public void setZtyzhdh(String ztyzhdh) {
		this.ztyzhdh = ztyzhdh == null ? null : ztyzhdh.trim();
	}
	
	/**
     * 装柜时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZgsj() {
		return zgsj;
	}

	/**
     * 装柜时间
     */
	public void setZgsj(Date zgsj) {
		this.zgsj = zgsj;
	}
	
	/**
     * 包装要求-挂架
     */
	public Integer getBzyqGj() {
		return bzyqGj;
	}

	/**
     * 包装要求-挂架
     */
	public void setBzyqGj(Integer bzyqGj) {
		this.bzyqGj = bzyqGj;
	}
	
	/**
     * 包装要求-底座
     */
	public Integer getBzyqDz() {
		return bzyqDz;
	}

	/**
     * 包装要求-底座
     */
	public void setBzyqDz(Integer bzyqDz) {
		this.bzyqDz = bzyqDz;
	}
	
	/**
     * 包装要求-木质卡板
     */
	public Integer getBzyqBzkb() {
		return bzyqBzkb;
	}

	/**
     * 包装要求-木质卡板
     */
	public void setBzyqBzkb(Integer bzyqBzkb) {
		this.bzyqBzkb = bzyqBzkb;
	}
	
	/**
     * 附件
     */
	@Length(min=0, max=500, message="附件长度必须介于 0 和 500 之间")
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
     * 用柜-总柜数
     */
	public Integer getYgZgs() {
		return ygZgs;
	}

	/**
     * 用柜-总柜数
     */
	public void setYgZgs(Integer ygZgs) {
		this.ygZgs = ygZgs;
	}
	
	/**
     * 用柜-20GP
     */
	public Integer getYg20gp() {
		return yg20gp;
	}

	/**
     * 用柜-20GP
     */
	public void setYg20gp(Integer yg20gp) {
		this.yg20gp = yg20gp;
	}
	
	/**
     * 用柜-40GP
     */
	public Integer getYg40gp() {
		return yg40gp;
	}

	/**
     * 用柜-40GP
     */
	public void setYg40gp(Integer yg40gp) {
		this.yg40gp = yg40gp;
	}
	
	/**
     * 用柜-40HQ
     */
	public Integer getYg40hq() {
		return yg40hq;
	}

	/**
     * 用柜-40HQ
     */
	public void setYg40hq(Integer yg40hq) {
		this.yg40hq = yg40hq;
	}
	
	/**
     * 用柜- 柜数备注
     */
	@Length(min=0, max=100, message="用柜- 柜数备注长度必须介于 0 和 100 之间")
	public String getYgGsbz() {
		return ygGsbz;
	}

	/**
     * 用柜- 柜数备注
     */
	public void setYgGsbz(String ygGsbz) {
		this.ygGsbz = ygGsbz == null ? null : ygGsbz.trim();
	}
	
	/**
     * 吨车-总车数
     */
	public Integer getDcZcs() {
		return dcZcs;
	}

	/**
     * 吨车-总车数
     */
	public void setDcZcs(Integer dcZcs) {
		this.dcZcs = dcZcs;
	}
	
	/**
     * 吨车-3吨
     */
	public Integer getDc3d() {
		return dc3d;
	}

	/**
     * 吨车-3吨
     */
	public void setDc3d(Integer dc3d) {
		this.dc3d = dc3d;
	}
	
	/**
     * 吨车-5吨
     */
	@NotNull(message="吨车-5吨不能为空")
	public Integer getDc5d() {
		return dc5d;
	}

	/**
     * 吨车-5吨
     */
	public void setDc5d(Integer dc5d) {
		this.dc5d = dc5d;
	}
	
	/**
     * 吨车-8吨
     */
	@NotNull(message="吨车-8吨不能为空")
	public Integer getDc8d() {
		return dc8d;
	}

	/**
     * 吨车-8吨
     */
	public void setDc8d(Integer dc8d) {
		this.dc8d = dc8d;
	}
	
	/**
     * 吨车-10吨
     */
	public Integer getDc10d() {
		return dc10d;
	}

	/**
     * 吨车-10吨
     */
	public void setDc10d(Integer dc10d) {
		this.dc10d = dc10d;
	}
	
	/**
     * 吨车-12吨
     */
	public Integer getDc12d() {
		return dc12d;
	}

	/**
     * 吨车-12吨
     */
	public void setDc12d(Integer dc12d) {
		this.dc12d = dc12d;
	}
	
	/**
     * 吨车-吨车备注
     */
	@Length(min=0, max=100, message="吨车-吨车备注长度必须介于 0 和 100 之间")
	public String getDcDcbz() {
		return dcDcbz;
	}

	/**
     * 吨车-吨车备注
     */
	public void setDcDcbz(String dcDcbz) {
		this.dcDcbz = dcDcbz == null ? null : dcDcbz.trim();
	}
	
	/**
     * 补充-跟单备损
     */
	@Length(min=0, max=500, message="补充-跟单备损长度必须介于 0 和 500 之间")
	public String getBcGdbs() {
		return bcGdbs;
	}

	/**
     * 补充-跟单备损
     */
	public void setBcGdbs(String bcGdbs) {
		this.bcGdbs = bcGdbs == null ? null : bcGdbs.trim();
	}
	
	/**
     * 补充-SPO备损
     */
	@Length(min=0, max=500, message="补充-SPO备损长度必须介于 0 和 500 之间")
	public String getBcSpobs() {
		return bcSpobs;
	}

	/**
     * 补充-SPO备损
     */
	public void setBcSpobs(String bcSpobs) {
		this.bcSpobs = bcSpobs == null ? null : bcSpobs.trim();
	}
	
	/**
     * 补充-文件要求
     */
	@Length(min=0, max=500, message="补充-文件要求长度必须介于 0 和 500 之间")
	public String getBcWjyq() {
		return bcWjyq;
	}

	/**
     * 补充-文件要求
     */
	public void setBcWjyq(String bcWjyq) {
		this.bcWjyq = bcWjyq == null ? null : bcWjyq.trim();
	}
	
	/**
     * 补充-装柜要求
     */
	@Length(min=0, max=500, message="补充-装柜要求长度必须介于 0 和 500 之间")
	public String getBcZgyq() {
		return bcZgyq;
	}

	/**
     * 补充-装柜要求
     */
	public void setBcZgyq(String bcZgyq) {
		this.bcZgyq = bcZgyq == null ? null : bcZgyq.trim();
	}
	
	/**
     * 补充-其他
     */
	@Length(min=0, max=500, message="补充-其他长度必须介于 0 和 500 之间")
	public String getBcQt() {
		return bcQt;
	}

	/**
     * 补充-其他
     */
	public void setBcQt(String bcQt) {
		this.bcQt = bcQt == null ? null : bcQt.trim();
	}
	
	/**
     * 出运类型
     */
	@Length(min=0, max=20, message="出运类型长度必须介于 0 和 20 之间")
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
	@Length(min=0, max=50, message="出运类型名称长度必须介于 0 和 50 之间")
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
     * 起运港
     */
	@Length(min=0, max=20, message="起运港长度必须介于 0 和 20 之间")
	public String getQyg() {
		return qyg;
	}

	/**
     * 起运港
     */
	public void setQyg(String qyg) {
		this.qyg = qyg == null ? null : qyg.trim();
	}
	
	/**
     * 起运港名称
     */
	@Length(min=0, max=50, message="起运港名称长度必须介于 0 和 50 之间")
	public String getQygmc() {
		return qygmc;
	}

	/**
     * 起运港名称
     */
	public void setQygmc(String qygmc) {
		this.qygmc = qygmc == null ? null : qygmc.trim();
	}
	
	/**
     * 起运港备注
     */
	@Length(min=0, max=100, message="起运港备注长度必须介于 0 和 100 之间")
	public String getQygbz() {
		return qygbz;
	}

	/**
     * 起运港备注
     */
	public void setQygbz(String qygbz) {
		this.qygbz = qygbz == null ? null : qygbz.trim();
	}
	
	/**
     * 目的港
     */
	@Length(min=0, max=100, message="目的港长度必须介于 0 和 100 之间")
	public String getMdg() {
		return mdg;
	}

	/**
     * 目的港
     */
	public void setMdg(String mdg) {
		this.mdg = mdg == null ? null : mdg.trim();
	}
	
	/**
     * 销往国家
     */
	@Length(min=0, max=20, message="销往国家长度必须介于 0 和 20 之间")
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
     * 船代公司
     */
	@Length(min=0, max=20, message="船代公司长度必须介于 0 和 20 之间")
	public String getCdgsbm() {
		return cdgsbm;
	}

	/**
     * 船代公司
     */
	public void setCdgsbm(String cdgsbm) {
		this.cdgsbm = cdgsbm == null ? null : cdgsbm.trim();
	}
	
	/**
     * 船代公司名称
     */
	@Length(min=0, max=100, message="船代公司名称长度必须介于 0 和 100 之间")
	public String getCdgsmc() {
		return cdgsmc;
	}

	/**
     * 船代公司名称
     */
	public void setCdgsmc(String cdgsmc) {
		this.cdgsmc = cdgsmc == null ? null : cdgsmc.trim();
	}
	
	/**
     * 船代公司联系人
     */
	@Length(min=0, max=50, message="船代公司联系人长度必须介于 0 和 50 之间")
	public String getCdgslxr() {
		return cdgslxr;
	}

	/**
     * 船代公司联系人
     */
	public void setCdgslxr(String cdgslxr) {
		this.cdgslxr = cdgslxr == null ? null : cdgslxr.trim();
	}
	
	/**
     * 船代公司电话
     */
	@Length(min=0, max=20, message="船代公司电话长度必须介于 0 和 20 之间")
	public String getCdgsdh() {
		return cdgsdh;
	}

	/**
     * 船代公司电话
     */
	public void setCdgsdh(String cdgsdh) {
		this.cdgsdh = cdgsdh == null ? null : cdgsdh.trim();
	}
	
	/**
     * 船代公司传真
     */
	@Length(min=0, max=20, message="船代公司传真长度必须介于 0 和 20 之间")
	public String getCdgscz() {
		return cdgscz;
	}

	/**
     * 船代公司传真
     */
	public void setCdgscz(String cdgscz) {
		this.cdgscz = cdgscz == null ? null : cdgscz.trim();
	}
	
	/**
     * 船代公司邮编
     */
	@Length(min=0, max=20, message="船代公司邮编长度必须介于 0 和 20 之间")
	public String getCdgsyb() {
		return cdgsyb;
	}

	/**
     * 船代公司邮编
     */
	public void setCdgsyb(String cdgsyb) {
		this.cdgsyb = cdgsyb == null ? null : cdgsyb.trim();
	}
	
	/**
     * 船代公司邮箱
     */
	@Length(min=0, max=50, message="船代公司邮箱长度必须介于 0 和 50 之间")
	public String getCdgsyx() {
		return cdgsyx;
	}

	/**
     * 船代公司邮箱
     */
	public void setCdgsyx(String cdgsyx) {
		this.cdgsyx = cdgsyx == null ? null : cdgsyx.trim();
	}
	
	/**
     * 是否需要验货
     */
	public Integer getSfXyyh() {
		return sfXyyh;
	}

	/**
     * 是否需要验货
     */
	public void setSfXyyh(Integer sfXyyh) {
		this.sfXyyh = sfXyyh;
	}
	
	/**
     * 预计验货日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjyhrq() {
		return yjyhrq;
	}

	/**
     * 预计验货日期
     */
	public void setYjyhrq(Date yjyhrq) {
		this.yjyhrq = yjyhrq;
	}
	
	/**
     * 收货方名称
     */
	@Length(min=0, max=100, message="收货方名称长度必须介于 0 和 100 之间")
	public String getShfmc() {
		return shfmc;
	}

	/**
     * 收货方名称
     */
	public void setShfmc(String shfmc) {
		this.shfmc = shfmc == null ? null : shfmc.trim();
	}
	
	/**
     * 快递类型
     */
	public Integer getKdlx() {
		return kdlx;
	}

	/**
     * 快递类型
     */
	public void setKdlx(Integer kdlx) {
		this.kdlx = kdlx;
	}
	
	/**
     * 快递
     */
	@Length(min=0, max=20, message="快递长度必须介于 0 和 20 之间")
	public String getKd() {
		return kd;
	}

	/**
     * 快递
     */
	public void setKd(String kd) {
		this.kd = kd == null ? null : kd.trim();
	}
	
	/**
     * 快递名称
     */
	@Length(min=0, max=50, message="快递名称长度必须介于 0 和 50 之间")
	public String getKdmc() {
		return kdmc;
	}

	/**
     * 快递名称
     */
	public void setKdmc(String kdmc) {
		this.kdmc = kdmc == null ? null : kdmc.trim();
	}
	
	/**
     * 快递备注
     */
	@Length(min=0, max=100, message="快递备注长度必须介于 0 和 100 之间")
	public String getKdbz() {
		return kdbz;
	}

	/**
     * 快递备注
     */
	public void setKdbz(String kdbz) {
		this.kdbz = kdbz == null ? null : kdbz.trim();
	}
	
	/**
     * 运费承担
     */
	public Integer getYfcd() {
		return yfcd;
	}

	/**
     * 运费承担
     */
	public void setYfcd(Integer yfcd) {
		this.yfcd = yfcd;
	}
	
	/**
     * 运费类型
     */
	@Length(min=0, max=20, message="运费类型长度必须介于 0 和 20 之间")
	public String getYflx() {
		return yflx;
	}

	/**
     * 运费类型
     */
	public void setYflx(String yflx) {
		this.yflx = yflx == null ? null : yflx.trim();
	}
	
	/**
     * 运费类型名称
     */
	@Length(min=0, max=50, message="运费类型名称长度必须介于 0 和 50 之间")
	public String getYflxmc() {
		return yflxmc;
	}

	/**
     * 运费类型名称
     */
	public void setYflxmc(String yflxmc) {
		this.yflxmc = yflxmc == null ? null : yflxmc.trim();
	}
	
	/**
     * 到付账户
     */
	@Length(min=0, max=50, message="到付账户长度必须介于 0 和 50 之间")
	public String getDfzh() {
		return dfzh;
	}

	/**
     * 到付账户
     */
	public void setDfzh(String dfzh) {
		this.dfzh = dfzh == null ? null : dfzh.trim();
	}
	
	/**
     * 运费币种
     */
	@Length(min=0, max=20, message="运费币种长度必须介于 0 和 20 之间")
	public String getYfbz() {
		return yfbz;
	}

	/**
     * 运费币种
     */
	public void setYfbz(String yfbz) {
		this.yfbz = yfbz == null ? null : yfbz.trim();
	}
	
	/**
     * 运费附件
     */
	@Length(min=0, max=100, message="运费附件长度必须介于 0 和 100 之间")
	public String getYffj() {
		return yffj;
	}

	/**
     * 运费附件
     */
	public void setYffj(String yffj) {
		this.yffj = yffj == null ? null : yffj.trim();
	}
	
	/**
     * 收货方地址
     */
	@Length(min=0, max=100, message="收货方地址长度必须介于 0 和 100 之间")
	public String getShfdz() {
		return shfdz;
	}

	/**
     * 收货方地址
     */
	public void setShfdz(String shfdz) {
		this.shfdz = shfdz == null ? null : shfdz.trim();
	}
	
	/**
     * 收货方联系人
     */
	@Length(min=0, max=50, message="收货方联系人长度必须介于 0 和 50 之间")
	public String getShflxr() {
		return shflxr;
	}

	/**
     * 收货方联系人
     */
	public void setShflxr(String shflxr) {
		this.shflxr = shflxr == null ? null : shflxr.trim();
	}
	
	/**
     * 收货方电话
     */
	@Length(min=0, max=20, message="收货方电话长度必须介于 0 和 20 之间")
	public String getShfdh() {
		return shfdh;
	}

	/**
     * 收货方电话
     */
	public void setShfdh(String shfdh) {
		this.shfdh = shfdh == null ? null : shfdh.trim();
	}
	
	/**
     * 收货方传真
     */
	@Length(min=0, max=20, message="收货方传真长度必须介于 0 和 20 之间")
	public String getShfcz() {
		return shfcz;
	}

	/**
     * 收货方传真
     */
	public void setShfcz(String shfcz) {
		this.shfcz = shfcz == null ? null : shfcz.trim();
	}
	
	/**
     * 收货方邮编
     */
	@Length(min=0, max=20, message="收货方邮编长度必须介于 0 和 20 之间")
	public String getShfyb() {
		return shfyb;
	}

	/**
     * 收货方邮编
     */
	public void setShfyb(String shfyb) {
		this.shfyb = shfyb == null ? null : shfyb.trim();
	}
	
	/**
     * 收货方邮箱
     */
	@Length(min=0, max=50, message="收货方邮箱长度必须介于 0 和 50 之间")
	public String getShfyx() {
		return shfyx;
	}

	/**
     * 收货方邮箱
     */
	public void setShfyx(String shfyx) {
		this.shfyx = shfyx == null ? null : shfyx.trim();
	}
	
	/**
     * 申请人
     */
	@Length(min=1, max=20, message="申请人长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * 申请人
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * 申请人名称
     */
	@Length(min=1, max=50, message="申请人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * 申请人名称
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}
	
	/**
     * 申请时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="申请时间不能为空")
	public Date getZdsj() {
		return zdsj;
	}

	/**
     * 申请时间
     */
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
	
	/**
     * 船务是否处理
     */
	public Integer getCwsfcl() {
		return cwsfcl;
	}

	/**
     * 船务是否处理
     */
	public void setCwsfcl(Integer cwsfcl) {
		this.cwsfcl = cwsfcl;
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
     * 船务专员
     */
	@Length(min=1, max=20, message="船务专员长度必须介于 1 和 20 之间")
	public String getCwzyid() {
		return cwzyid;
	}

	/**
     * 船务专员
     */
	public void setCwzyid(String cwzyid) {
		this.cwzyid = cwzyid == null ? null : cwzyid.trim();
	}
	
	/**
     * 船务专员名称
     */
	@Length(min=0, max=50, message="船务专员名称长度必须介于 0 和 50 之间")
	public String getCwzymc() {
		return cwzymc;
	}

	/**
     * 船务专员名称
     */
	public void setCwzymc(String cwzymc) {
		this.cwzymc = cwzymc == null ? null : cwzymc.trim();
	}

	public String getBeginZgsj() {
		return beginZgsj;
	}

	public void setBeginZgsj(String beginZgsj) {
		this.beginZgsj = beginZgsj;
	}

	public String getEndZgsj() {
		return endZgsj;
	}

	public void setEndZgsj(String endZgsj) {
		this.endZgsj = endZgsj;
	}

	public Integer getJfsfsp() {
		return jfsfsp;
	}

	public void setJfsfsp(Integer jfsfsp) {
		this.jfsfsp = jfsfsp;
	}

	public Integer getCysfbl() {
		return cysfbl;
	}

	public void setCysfbl(Integer cysfbl) {
		this.cysfbl = cysfbl;
	}

	public String getFktj() {
		return fktj;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public Integer getFkbzzt() {
		return fkbzzt;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}

	public void setFkbzzt(Integer fkbzzt) {
		this.fkbzzt = fkbzzt;
	}

	public String getSapgsdm() {
		return sapgsdm;
	}

	public void setSapgsdm(String sapgsdm) {
		this.sapgsdm = sapgsdm;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getKbbz() {
		return kbbz;
	}

	public void setKbbz(String kbbz) {
		this.kbbz = kbbz;
	}

	public Integer getSmoshzt() {
		return smoshzt;
	}

	public void setSmoshzt(Integer smoshzt) {
		this.smoshzt = smoshzt;
	}

	public BigDecimal getDdje() {
		return ddje;
	}

	public void setDdje(BigDecimal ddje) {
		this.ddje = ddje;
	}

	public BigDecimal getQtje() {
		return qtje;
	}

	public void setQtje(BigDecimal qtje) {
		this.qtje = qtje;
	}

	public BigDecimal getZje() {
		return zje;
	}

	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}

	public BigDecimal getYgyf() {
		return ygyf;
	}

	public void setYgyf(BigDecimal ygyf) {
		this.ygyf = ygyf;
	}
	
	public Integer getSfBd() {
		return sfBd;
	}

	public void setSfBd(Integer sfBd) {
		this.sfBd = sfBd;
	}

	public String getHwgyl() {
		return hwgyl;
	}

	public void setHwgyl(String hwgyl) {
		this.hwgyl = hwgyl;
	}

	public String getHwgylmc() {
		return hwgylmc;
	}

	public void setHwgylmc(String hwgylmc) {
		this.hwgylmc = hwgylmc;
	}

	public String getShfdm() {
		return shfdm;
	}

	public void setShfdm(String shfdm) {
		this.shfdm = shfdm;
	}

	public String getShrdh() {
		return shrdh;
	}

	public void setShrdh(String shrdh) {
		this.shrdh = shrdh;
	}

	public String getAeoqybm() {
		return aeoqybm;
	}

	public void setAeoqybm(String aeoqybm) {
		this.aeoqybm = aeoqybm;
	}

	public String getZzg() {
		return zzg;
	}

	public void setZzg(String zzg) {
		this.zzg = zzg;
	}
	
}