package com.ey.piit.sdo.report.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * InvoiceTable
 * @author 魏诚
 */
public class InvoiceTable extends BaseEntity {
	
	private String fph;
	private Date fprq;
	private String xwgj;
	private String xwgjmc;
	private String xsyid;
	private String xsymc;
	private String zdrid;
	private String zdrmc;
	private String khbm;
	private String khmc;
	private String brandName;
	private String lcbh;
	private String fktj;
	private String fktjmc;
    private String ddid;
    private String jixing;
    private String zhfs;
    private String zhfsmc;
    private Integer sl;
    private String mytk;
    private String mytkmc;
    private Double dj;
    private Double xtkpzje;
    private Double sjfpzje;
    private String bz;
    private String cm;
    private String hc;
    private String hbh;
    private String xhg;
    private String mdg;
    private String qyg;
    private Date zcrq;
    private Date yjdgq;
    private String tdh;
    private String gx;
    private Integer gs;
    private String gh;
    private String tcgs;
    private String tcgsfp;
    private String transportCosts;
    private String yzhdh;
    private Date receiveDate;
    private String remark;
    private Integer tssapzt_syfp;		// 推送SAP状态商业发票
	private Integer tssapzt_gsjfp;		// 推送SAP状态公司间发票
	private String czrmc;	//操作人名称
	private String cdgsmc;	//船代公司名称
	private String qygmc;	//起运港名称
	private String bzxx;	//发票备注
	private Double qtfyje;	//其他费用金额
	private String chdh;	//出货单号
	private Date zdsj;	//SDO发票日期
	private String cwczzy;//船务操作专员
	private String spmc;
	private Integer mfjsl;
	private String cylxmc;//出运类型
	private String gsbm;
	
	public InvoiceTable() {
		super();
	}

	public InvoiceTable(String id){
		super(id);
	}

	public String getFph() {
		return fph;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}

	public String getXwgj() {
		return xwgj;
	}

	public String getXwgjmc() {
		return xwgjmc;
	}

	public String getXsyid() {
		return xsyid;
	}

	public String getXsymc() {
		return xsymc;
	}

	public String getZdrid() {
		return zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public String getKhbm() {
		return khbm;
	}

	public String getKhmc() {
		return khmc;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getLcbh() {
		return lcbh;
	}

	public String getFktj() {
		return fktj;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public String getDdid() {
		return ddid;
	}

	public String getJixing() {
		return jixing;
	}

	public String getZhfs() {
		return zhfs;
	}

	public String getZhfsmc() {
		return zhfsmc;
	}

	public Integer getSl() {
		return sl;
	}

	public String getMytk() {
		return mytk;
	}

	public String getMytkmc() {
		return mytkmc;
	}

	public Double getDj() {
		return dj;
	}

	public Double getXtkpzje() {
		return xtkpzje;
	}

	public Double getSjfpzje() {
		return sjfpzje;
	}

	public String getBz() {
		return bz;
	}

	public String getCm() {
		return cm;
	}

	public String getHc() {
		return hc;
	}

	public String getHbh() {
		return hbh;
	}

	public String getXhg() {
		return xhg;
	}

	public String getMdg() {
		return mdg;
	}

	public String getQyg() {
		return qyg;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZcrq() {
		return zcrq;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjdgq() {
		return yjdgq;
	}

	public String getTdh() {
		return tdh;
	}

	public String getGx() {
		return gx;
	}

	public Integer getGs() {
		return gs;
	}

	public String getGh() {
		return gh;
	}

	public String getTcgs() {
		return tcgs;
	}

	public String getTcgsfp() {
		return tcgsfp;
	}

	public String getTransportCosts() {
		return transportCosts;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getReceiveDate() {
		return receiveDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}

	public void setXwgj(String xwgj) {
		this.xwgj = xwgj;
	}

	public void setXwgjmc(String xwgjmc) {
		this.xwgjmc = xwgjmc;
	}

	public void setXsyid(String xsyid) {
		this.xsyid = xsyid;
	}

	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setLcbh(String lcbh) {
		this.lcbh = lcbh;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public void setZhfs(String zhfs) {
		this.zhfs = zhfs;
	}

	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	public void setMytk(String mytk) {
		this.mytk = mytk;
	}

	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public void setXtkpzje(Double xtkpzje) {
		this.xtkpzje = xtkpzje;
	}

	public void setSjfpzje(Double sjfpzje) {
		this.sjfpzje = sjfpzje;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}

	public void setHc(String hc) {
		this.hc = hc;
	}

	public void setHbh(String hbh) {
		this.hbh = hbh;
	}

	public void setXhg(String xhg) {
		this.xhg = xhg;
	}

	public void setMdg(String mdg) {
		this.mdg = mdg;
	}

	public void setQyg(String qyg) {
		this.qyg = qyg;
	}

	public void setZcrq(Date zcrq) {
		this.zcrq = zcrq;
	}

	public void setYjdgq(Date yjdgq) {
		this.yjdgq = yjdgq;
	}

	public void setTdh(String tdh) {
		this.tdh = tdh;
	}

	public void setGx(String gx) {
		this.gx = gx;
	}

	public void setGs(Integer gs) {
		this.gs = gs;
	}

	public void setGh(String gh) {
		this.gh = gh;
	}

	public void setTcgs(String tcgs) {
		this.tcgs = tcgs;
	}

	public void setTcgsfp(String tcgsfp) {
		this.tcgsfp = tcgsfp;
	}

	public void setTransportCosts(String transportCosts) {
		this.transportCosts = transportCosts;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getCzrmc() {
		return czrmc;
	}

	public void setCzrmc(String czrmc) {
		this.czrmc = czrmc;
	}

	public String getCdgsmc() {
		return cdgsmc;
	}

	public void setCdgsmc(String cdgsmc) {
		this.cdgsmc = cdgsmc;
	}

	public String getQygmc() {
		return qygmc;
	}

	public void setQygmc(String qygmc) {
		this.qygmc = qygmc;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public Double getQtfyje() {
		return qtfyje;
	}

	public void setQtfyje(Double qtfyje) {
		this.qtfyje = qtfyje;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public String getCwczzy() {
		return cwczzy;
	}

	public void setCwczzy(String cwczzy) {
		this.cwczzy = cwczzy;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public Integer getMfjsl() {
		return mfjsl;
	}

	public void setMfjsl(Integer mfjsl) {
		this.mfjsl = mfjsl;
	}

	public String getCylxmc() {
		return cylxmc;
	}

	public void setCylxmc(String cylxmc) {
		this.cylxmc = cylxmc;
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	
}