package com.ey.piit.sdo.deliverplan.entity;

import java.math.BigDecimal;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 走货计划单明细实体
 * @author 邓海
 */
public class DeliverPlanItem extends BaseEntity {

	private String zhjhdh;//走货计划单号
	private Integer bbh;//版本号
	private String xszzmc;//销售组织
	private String xszz;//销售组织
	private String ywzmc;//业务组
	private String ywz;//业务组
	private String xsyid;//销售员ID
	private String xsymc;//销售员名称
	private String zdrid;//预走货制单人
	private String zdrmc;//预走货制单人
	private String khbm;//客户编码
	private String khmc;//客户名称
	private String ddid;//订单号
	private String zhfs;//走货方式
	private String zhfsmc;//走货方式
	private String jixing;//机型
	private String xwgjmc;//销往国家
	private String xwgj;//销往国家
	private String mytkmc;//贸易条款
	private String mytk;//贸易条款
	private Double sl;//数量
	private BigDecimal dj;//单价
	private BigDecimal je;//金额
	private String bz;//币种
	private String yjyhrq;//预计验货日期
	private String zgkssj;//装柜开始日期
	private String zgjssj;//装柜结束日期
	private String jgq;//截关期
	private String yjkcq;//预计开船期
	private String kcy;//开船月
	private String qygmc;//起运港
	private String qyg;//起运港
	private Integer chzt;//出货状态
	private String yzhdh;//预走货单号
	private String yzhlx;//预走货类型
	private String yzhlxmc;//预走货类型
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
	private String cdgsbm;//船贷公司编码
	private String cdgsmc;//船贷公司名称
	private String yzhsj;//预走货时间
	private String cylx;///出运类型
	private String cylxmc;//出运类型名称
	private String mdg;//目的港
	private String jcsj;//截重时间
	private String jfxtsj;//截放行条时间
	private String kcsj;//开船时间
	private String jblsj;//截补料时间
	private String scjd;//生产基地
	private String scjdmc;//生产基地
	private String gsbm;//公司编码
	private String gsmc;//公司名称
	private String dcdh;//订舱单号
	
	public DeliverPlanItem() {
		super();
	}

	public DeliverPlanItem(String id){
		super(id);
	}

	public String getZhjhdh() {
		return zhjhdh;
	}

	public void setZhjhdh(String zhjhdh) {
		this.zhjhdh = zhjhdh;
	}

	public Integer getBbh() {
		return bbh;
	}

	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}

	public String getXszzmc() {
		return xszzmc;
	}

	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc;
	}

	public String getXszz() {
		return xszz;
	}

	public void setXszz(String xszz) {
		this.xszz = xszz;
	}

	public String getYwzmc() {
		return ywzmc;
	}

	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc;
	}

	public String getYwz() {
		return ywz;
	}

	public void setYwz(String ywz) {
		this.ywz = ywz;
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

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
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

	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public String getXwgjmc() {
		return xwgjmc;
	}

	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}

	public String getXwgj() {
		return xwgj;
	}

	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}

	public String getMytkmc() {
		return mytkmc;
	}

	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc;
	}

	public String getMytk() {
		return mytk;
	}

	public void setMytk(String mytk) {
		this.mytk = mytk;
	}

	public Double getSl() {
		return sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	public String getKcy() {
		return kcy;
	}

	public void setKcy(String kcy) {
		this.kcy = kcy;
	}

	public String getQygmc() {
		return qygmc;
	}

	public void setQygmc(String qygmc) {
		this.qygmc = qygmc;
	}

	public String getQyg() {
		return qyg;
	}

	public void setQyg(String qyg) {
		this.qyg = qyg;
	}

	public Integer getChzt() {
		return chzt;
	}

	public void setChzt(Integer chzt) {
		this.chzt = chzt;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	public String getYzhlx() {
		return yzhlx;
	}

	public void setYzhlx(String yzhlx) {
		this.yzhlx = yzhlx;
	}

	public String getYzhlxmc() {
		return yzhlxmc;
	}

	public void setYzhlxmc(String yzhlxmc) {
		this.yzhlxmc = yzhlxmc;
	}

	public Integer getYgZgs() {
		return ygZgs;
	}

	public void setYgZgs(Integer ygZgs) {
		this.ygZgs = ygZgs;
	}

	public Integer getYg20gp() {
		return yg20gp;
	}

	public void setYg20gp(Integer yg20gp) {
		this.yg20gp = yg20gp;
	}

	public Integer getYg40gp() {
		return yg40gp;
	}

	public void setYg40gp(Integer yg40gp) {
		this.yg40gp = yg40gp;
	}

	public Integer getYg40hq() {
		return yg40hq;
	}

	public void setYg40hq(Integer yg40hq) {
		this.yg40hq = yg40hq;
	}

	public String getYgGsbz() {
		return ygGsbz;
	}

	public void setYgGsbz(String ygGsbz) {
		this.ygGsbz = ygGsbz;
	}

	public Integer getDcZcs() {
		return dcZcs;
	}

	public void setDcZcs(Integer dcZcs) {
		this.dcZcs = dcZcs;
	}

	public Integer getDc3d() {
		return dc3d;
	}

	public void setDc3d(Integer dc3d) {
		this.dc3d = dc3d;
	}

	public Integer getDc5d() {
		return dc5d;
	}

	public void setDc5d(Integer dc5d) {
		this.dc5d = dc5d;
	}

	public Integer getDc8d() {
		return dc8d;
	}

	public void setDc8d(Integer dc8d) {
		this.dc8d = dc8d;
	}

	public Integer getDc10d() {
		return dc10d;
	}

	public void setDc10d(Integer dc10d) {
		this.dc10d = dc10d;
	}

	public Integer getDc12d() {
		return dc12d;
	}

	public void setDc12d(Integer dc12d) {
		this.dc12d = dc12d;
	}

	public String getDcDcbz() {
		return dcDcbz;
	}

	public void setDcDcbz(String dcDcbz) {
		this.dcDcbz = dcDcbz;
	}

	public String getCdgsbm() {
		return cdgsbm;
	}

	public void setCdgsbm(String cdgsbm) {
		this.cdgsbm = cdgsbm;
	}

	public String getCdgsmc() {
		return cdgsmc;
	}

	public void setCdgsmc(String cdgsmc) {
		this.cdgsmc = cdgsmc;
	}

	public String getCylx() {
		return cylx;
	}

	public void setCylx(String cylx) {
		this.cylx = cylx;
	}

	public String getCylxmc() {
		return cylxmc;
	}

	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc;
	}

	public String getMdg() {
		return mdg;
	}

	public void setMdg(String mdg) {
		this.mdg = mdg;
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

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public String getGsmc() {
		return gsmc;
	}

	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
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

	public String getYjyhrq() {
		return yjyhrq;
	}

	public void setYjyhrq(String yjyhrq) {
		this.yjyhrq = yjyhrq;
	}

	public String getZgkssj() {
		return zgkssj;
	}

	public void setZgkssj(String zgkssj) {
		this.zgkssj = zgkssj;
	}

	public String getZgjssj() {
		return zgjssj;
	}

	public void setZgjssj(String zgjssj) {
		this.zgjssj = zgjssj;
	}

	public String getJgq() {
		return jgq;
	}

	public void setJgq(String jgq) {
		this.jgq = jgq;
	}

	public String getYjkcq() {
		return yjkcq;
	}

	public void setYjkcq(String yjkcq) {
		this.yjkcq = yjkcq;
	}

	public String getYzhsj() {
		return yzhsj;
	}

	public void setYzhsj(String yzhsj) {
		this.yzhsj = yzhsj;
	}

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	public String getJfxtsj() {
		return jfxtsj;
	}

	public void setJfxtsj(String jfxtsj) {
		this.jfxtsj = jfxtsj;
	}

	public String getKcsj() {
		return kcsj;
	}

	public void setKcsj(String kcsj) {		
		this.kcsj = kcsj;
	}

	public String getJblsj() {
		return jblsj;
	}

	public void setJblsj(String jblsj) {
		this.jblsj = jblsj;
	}

	public String getDcdh() {
		return dcdh;
	}

	public void setDcdh(String dcdh) {
		this.dcdh = dcdh;
	}
	
}