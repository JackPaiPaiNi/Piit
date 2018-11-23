package com.ey.piit.sdo.invoice.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 发票信息维护Entity
 * @author 高文浩
 */
public class Invoice extends BaseEntity {
	
	private String fph;			// 发票号
	private String fph2;		//发票号2（拆分时用)
	private String fplx;		// 发票类型
	private String fplxmc;		// 发票类型名称
	private String xsyid;		// 销售员ID
	private String xsymc;		// 销售员名称
	private String ywz;			// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private String gsdz;		// 公司地址
	private String gslxdh;		// 公司联系电话
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String khdh;		// 客户电话
	private String khdz;		// 客户地址
	private String shfmc;		// 收货方名称
	private String shfdz;		// 收货方地址
	private String shflxr;		// 收货方联系人
	private String shfdh;		// 收货方电话
	private String shfcz;		// 收货方传真
	private String shfyb;		// 收货方邮编
	private String shfyx;		// 收货方邮箱
	private String zhfs;		// 走货方式
	private String zhfsmc;		// 走货方式名称
	private String cylx;		// 出运类型
	private String cylxmc;		// 出运类型名称
	private String mytk;		// 贸易条款
	private String mytkmc;		// 贸易条款名称
	private BigDecimal zje;			//总金额
	private BigDecimal sjfpzje;			//实际发票总金额
	private String bz;		// 币种
	private Integer sfBg;		// 是否需要报关
	private String fktj;		// 付款条件
	private String fktjmc;		// 付款条件名称
	private String lcbh;		// LC编号
	private String qyg;		// 起运港
	private String qygmc;		// 起运港名称
	private String qygbz;		// 起运港备注
	private String mdg;		// 目的港
	private String xhg;		// 卸货港
	private String cm;		// 船名
	private String hc;		// 航次
	private String hbh;		// 航班号
	private Date fprq;		// 发票日期
	private Date qyrq;		// 起运日期
	private Date yjdgq;		// 预计到港期（ETA）
	private String tdh;		// 提单号
	private String kpfs;		// 开票方式
	private String kpfsmc;		// 开票方式名称
	private Integer sfAfktjcfjg;		// 是否按付款条件拆分价格
	private Double cfbl1;		// 拆分比例1
	private Double cfbl2;		// 拆分比例2
	private String fpmb;		// 发票模板
	private String fpmbmc;		// 发票模板名称
	private String xdmb;		// 箱单模板
	private String xdmbmx;		// 箱单模板名称
	private String fj;		// 附件
	private String xdwlmsyy;		// 箱单物料描述语言
	private String xdwlmsyymc;		// 箱单物料描述语言名称
	private String hgspbm;			//海关商品编码
	private String hgspms;			//海关商品名称
	private String bzxx;		// 备注信息
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private Integer zt;		// 状态
	private String sjc;		// 时间戳
	private Integer tssapzt_syfp;		// 推送SAP状态商业发票
	private Integer tssapzt_gsjfp;		// 推送SAP状态公司间发票
	private String chdh;	//出货单号
	private Integer gztssapzt;//工装海运费推送SAP状态
	private String gjmytkbz;	//贸易条款备注
	private Double zsl;		// 总数量
	private String cxrid;		// 冲销人
	private String cxrmc;		// 冲销人名称
	private Date cxrq;		// 冲销时间
	
	
	public Double getZsl() {
		return zsl;
	}

	public void setZsl(Double zsl) {
		this.zsl = zsl;
	}

	public Invoice() {
		super();
	}

	public Invoice(String id){
		super(id);
	}
	/**
     * 发票号
     */
	public String getFph() {
		return fph;
	}

	/**
     * 发票号
     */
	public void setFph(String fph) {
		this.fph = fph == null ? null : fph.trim();
	}
	
	/**
     * 发票类型
     */
	@Length(min=1, max=20, message="发票类型长度必须介于 1 和 20 之间")
	public String getFplx() {
		return fplx;
	}

	/**
     * 发票类型
     */
	public void setFplx(String fplx) {
		this.fplx = fplx == null ? null : fplx.trim();
	}
	
	/**
     * 发票类型名称
     */
	@Length(min=0, max=50, message="发票类型名称长度必须介于 0 和 50 之间")
	public String getFplxmc() {
		return fplxmc;
	}

	/**
     * 发票类型名称
     */
	public void setFplxmc(String fplxmc) {
		this.fplxmc = fplxmc == null ? null : fplxmc.trim();
	}
	
	/**
     * 销售员
     */
	@Length(min=1, max=20, message="销售员长度必须介于 1 和 20 之间")
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
	@Length(min=1, max=20, message="业务组长度必须介于 1 和 20 之间")
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
	@Length(min=1, max=20, message="销售组织长度必须介于 1 和 20 之间")
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
     * 公司地址
     */
	@Length(min=0, max=100, message="公司地址长度必须介于 0 和 100 之间")
	public String getGsdz() {
		return gsdz;
	}

	/**
     * 公司地址
     */
	public void setGsdz(String gsdz) {
		this.gsdz = gsdz == null ? null : gsdz.trim();
	}
	
	/**
     * 公司联系电话
     */
	@Length(min=0, max=20, message="公司联系电话长度必须介于 0 和 20 之间")
	public String getGslxdh() {
		return gslxdh;
	}

	/**
     * 公司联系电话
     */
	public void setGslxdh(String gslxdh) {
		this.gslxdh = gslxdh == null ? null : gslxdh.trim();
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
     * 客户电话
     */
	@Length(min=0, max=20, message="客户电话长度必须介于 0 和 20 之间")
	public String getKhdh() {
		return khdh;
	}

	/**
     * 客户电话
     */
	public void setKhdh(String khdh) {
		this.khdh = khdh == null ? null : khdh.trim();
	}
	
	/**
     * 客户地址
     */
	@Length(min=0, max=100, message="客户地址长度必须介于 0 和 100 之间")
	public String getKhdz() {
		return khdz;
	}

	/**
     * 客户地址
     */
	public void setKhdz(String khdz) {
		this.khdz = khdz == null ? null : khdz.trim();
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
     * 走货方式
     */
	@Length(min=0, max=20, message="走货方式长度必须介于 0 和 20 之间")
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
	@Length(min=0, max=50, message="走货方式名称长度必须介于 0 和 50 之间")
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
     * 是否需要报关
     */
	public Integer getSfBg() {
		return sfBg;
	}

	/**
     * 是否需要报关
     */
	public void setSfBg(Integer sfBg) {
		this.sfBg = sfBg;
	}
	
	/**
     * 付款条件
     */
	@Length(min=0, max=20, message="付款条件长度必须介于 0 和 20 之间")
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
	@Length(min=0, max=100, message="付款条件名称长度必须介于 0 和 100 之间")
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
     * LC编号
     */
	@Length(min=0, max=20, message="LC编号长度必须介于 0 和 20 之间")
	public String getLcbh() {
		return lcbh;
	}

	/**
     * LC编号
     */
	public void setLcbh(String lcbh) {
		this.lcbh = lcbh == null ? null : lcbh.trim();
	}
	
	/**
     * 起运港
     */
	@Length(min=0, max=500, message="起运港长度必须介于 0 和 500 之间")
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
	@Length(min=0, max=500, message="起运港名称长度必须介于 0 和 500 之间")
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
	@Length(min=0, max=500, message="起运港备注长度必须介于 0 和 500 之间")
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
	@Length(min=0, max=500, message="目的港长度必须介于 0 和 500 之间")
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
     * 卸货港
     */
	@Length(min=0, max=500, message="卸货港长度必须介于 0 和 500 之间")
	public String getXhg() {
		return xhg;
	}

	/**
     * 卸货港
     */
	public void setXhg(String xhg) {
		this.xhg = xhg == null ? null : xhg.trim();
	}
	
	/**
     * 船名
     */
	@Length(min=0, max=50, message="船名长度必须介于 0 和 50 之间")
	public String getCm() {
		return cm;
	}

	/**
     * 船名
     */
	public void setCm(String cm) {
		this.cm = cm == null ? null : cm.trim();
	}
	
	/**
     * 航次
     */
	@Length(min=0, max=50, message="航次长度必须介于 0 和 50 之间")
	public String getHc() {
		return hc;
	}

	/**
     * 航次
     */
	public void setHc(String hc) {
		this.hc = hc == null ? null : hc.trim();
	}
	
	/**
     * 航班号
     */
	@Length(min=0, max=50, message="航班号长度必须介于 0 和 50 之间")
	public String getHbh() {
		return hbh;
	}

	/**
     * 航班号
     */
	public void setHbh(String hbh) {
		this.hbh = hbh == null ? null : hbh.trim();
	}
	
	/**
     * 发票日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}

	/**
     * 发票日期
     */
	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}
	
	/**
     * 起运日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getQyrq() {
		return qyrq;
	}

	/**
     * 起运日期
     */
	public void setQyrq(Date qyrq) {
		this.qyrq = qyrq;
	}
	
	/**
     * 预计到港期（ETA）
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjdgq() {
		return yjdgq;
	}

	/**
     * 预计到港期（ETA）
     */
	public void setYjdgq(Date yjdgq) {
		this.yjdgq = yjdgq;
	}
	
	/**
     * 提单号
     */
	@Length(min=0, max=50, message="提单号长度必须介于 0 和 50 之间")
	public String getTdh() {
		return tdh;
	}

	/**
     * 提单号
     */
	public void setTdh(String tdh) {
		this.tdh = tdh == null ? null : tdh.trim();
	}
	
	/**
     * 开票方式
     */
	@Length(min=0, max=20, message="开票方式长度必须介于 0 和 20 之间")
	public String getKpfs() {
		return kpfs;
	}

	/**
     * 开票方式
     */
	public void setKpfs(String kpfs) {
		this.kpfs = kpfs == null ? null : kpfs.trim();
	}
	
	/**
     * 开票方式名称
     */
	@Length(min=0, max=50, message="开票方式名称长度必须介于 0 和 50 之间")
	public String getKpfsmc() {
		return kpfsmc;
	}

	/**
     * 开票方式名称
     */
	public void setKpfsmc(String kpfsmc) {
		this.kpfsmc = kpfsmc == null ? null : kpfsmc.trim();
	}
	
	/**
     * 是否按付款条件拆分价格
     */
	public Integer getSfAfktjcfjg() {
		return sfAfktjcfjg;
	}

	/**
     * 是否按付款条件拆分价格
     */
	public void setSfAfktjcfjg(Integer sfAfktjcfjg) {
		this.sfAfktjcfjg = sfAfktjcfjg;
	}
	
	/**
     * 拆分比例1
     */
	public Double getCfbl1() {
		return cfbl1;
	}

	/**
     * 拆分比例1
     */
	public void setCfbl1(Double cfbl1) {
		this.cfbl1 = cfbl1;
	}
	
	/**
     * 拆分比例2
     */
	public Double getCfbl2() {
		return cfbl2;
	}

	/**
     * 拆分比例2
     */
	public void setCfbl2(Double cfbl2) {
		this.cfbl2 = cfbl2;
	}
	
	/**
     * 发票模板
     */
	@Length(min=0, max=20, message="发票模板长度必须介于 0 和 20 之间")
	public String getFpmb() {
		return fpmb;
	}

	/**
     * 发票模板
     */
	public void setFpmb(String fpmb) {
		this.fpmb = fpmb == null ? null : fpmb.trim();
	}
	
	/**
     * 发票模板名称
     */
	@Length(min=0, max=50, message="发票模板名称长度必须介于 0 和 50 之间")
	public String getFpmbmc() {
		return fpmbmc;
	}

	/**
     * 发票模板名称
     */
	public void setFpmbmc(String fpmbmc) {
		this.fpmbmc = fpmbmc == null ? null : fpmbmc.trim();
	}
	
	/**
     * 箱单模板
     */
	@Length(min=0, max=20, message="箱单模板长度必须介于 0 和 20 之间")
	public String getXdmb() {
		return xdmb;
	}

	/**
     * 箱单模板
     */
	public void setXdmb(String xdmb) {
		this.xdmb = xdmb == null ? null : xdmb.trim();
	}
	
	/**
     * 箱单模板名称
     */
	@Length(min=0, max=50, message="箱单模板名称长度必须介于 0 和 50 之间")
	public String getXdmbmx() {
		return xdmbmx;
	}

	/**
     * 箱单模板名称
     */
	public void setXdmbmx(String xdmbmx) {
		this.xdmbmx = xdmbmx == null ? null : xdmbmx.trim();
	}
	
	/**
     * 附件
     */
	@Length(min=0, max=100, message="附件长度必须介于 0 和 100 之间")
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
     * 箱单物料描述语言
     */
	@Length(min=0, max=20, message="箱单物料描述语言长度必须介于 0 和 20 之间")
	public String getXdwlmsyy() {
		return xdwlmsyy;
	}

	/**
     * 箱单物料描述语言
     */
	public void setXdwlmsyy(String xdwlmsyy) {
		this.xdwlmsyy = xdwlmsyy == null ? null : xdwlmsyy.trim();
	}
	
	/**
     * 箱单物料描述语言名称
     */
	@Length(min=0, max=50, message="箱单物料描述语言名称长度必须介于 0 和 50 之间")
	public String getXdwlmsyymc() {
		return xdwlmsyymc;
	}

	/**
     * 箱单物料描述语言名称
     */
	public void setXdwlmsyymc(String xdwlmsyymc) {
		this.xdwlmsyymc = xdwlmsyymc == null ? null : xdwlmsyymc.trim();
	}
	
	/**
     * 备注信息
     */
	@Length(min=0, max=200, message="备注信息长度必须介于 0 和 200 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
     * 备注信息
     */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
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
	

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public BigDecimal getZje() {
		return zje;
	}

	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}

	public String getHgspbm() {
		return hgspbm;
	}

	public void setHgspbm(String hgspbm) {
		this.hgspbm = hgspbm;
	}

	public String getHgspms() {
		return hgspms;
	}

	public void setHgspms(String hgspms) {
		this.hgspms = hgspms;
	}

	public Integer getGztssapzt() {
		return gztssapzt;
	}

	public void setGztssapzt(Integer gztssapzt) {
		this.gztssapzt = gztssapzt;
	}

	public Integer getTssapzt_syfp() {
		return tssapzt_syfp;
	}

	public void setTssapzt_syfp(Integer tssapzt_syfp) {
		this.tssapzt_syfp = tssapzt_syfp;
	}

	public Integer getTssapzt_gsjfp() {
		return tssapzt_gsjfp;
	}

	public void setTssapzt_gsjfp(Integer tssapzt_gsjfp) {
		this.tssapzt_gsjfp = tssapzt_gsjfp;
	}

	public String getGjmytkbz() {
		return gjmytkbz;
	}

	public void setGjmytkbz(String gjmytkbz) {
		this.gjmytkbz = gjmytkbz;
	}

	@Length(min=1, max=20, message="发票号长度必须介于 1 和 20 之间")
	public String getFph2() {
		return fph2;
	}

	public void setFph2(String fph2) {
		this.fph2 = fph2 == null ? null : fph2.trim();
	}

	public BigDecimal getSjfpzje() {
		return sjfpzje;
	}

	public void setSjfpzje(BigDecimal sjfpzje) {
		this.sjfpzje = sjfpzje;
	}
	
	/**
     * 冲销人
     */
	@Length(min=1, max=20, message="冲销人长度必须介于 1 和 20 之间")
	public String getCxrid() {
		return cxrid;
	}

	/**
     * 冲销人
     */
	public void setCxrid(String cxrid) {
		this.cxrid = cxrid == null ? null : cxrid.trim();
	}
	
	/**
     * 冲销人名称
     */
	@Length(min=1, max=50, message="冲销人名称长度必须介于 1 和 50 之间")
	public String getCxrmc() {
		return cxrmc;
	}

	/**
     * 冲销人名称
     */
	public void setCxrmc(String cxrmc) {
		this.cxrmc = cxrmc == null ? null : cxrmc.trim();
	}
	
	/**
     * 冲销时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="冲销时间不能为空")
	public Date getCxrq() {
		return cxrq;
	}

	/**
     * 冲销时间
     */
	public void setCxrq(Date cxrq) {
		this.cxrq = cxrq;
	}
}