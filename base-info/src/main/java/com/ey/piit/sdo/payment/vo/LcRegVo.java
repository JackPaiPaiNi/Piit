package com.ey.piit.sdo.payment.vo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ey.piit.sdo.payment.entity.LcReg;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * LC登记Entity
 * @author 邓海
 */
public class LcRegVo extends LcReg {

	private String piid;            // pi号
	private BigDecimal ye;				// 余额
	private List<LcRegItemVo> itemVoList=new ArrayList<LcRegItemVo>();//明细list
	private List<LcLogVo>   logList=new ArrayList<LcLogVo>();//审批日志list
	private List<LcRegVo> htylist = new ArrayList<LcRegVo>();//修改历史
	
	private String edbz;	// 额度币种
	private BigDecimal edye;	// 额度余额
	private BigDecimal hl;		// 汇率
	private Integer type ;
	private BigDecimal djjdje ;//冻结解冻金额
	private String fph;	//发票号
	private String cwymc;	//船务专员名称
	private Integer sfywh;//是否已维护过交单明细
	
	//以下是明细表字段
	private BigDecimal fpje;//发票金额
	private Date fprq;//发票日期
	private String fpbz;//发票币种
	private String yzhdh;//预走货单号
	private String ddid;//订单号
	private String qy;//区域
	private String qymc;//区域名称
	private String xsyid;//销售员id
	private String xsymc;//销售员名称
	private String cwyid;//船务员id
	private Date wjjryhrq;//文件寄入银行日期
	private Date tzhsdwjrq;//通知行收到文件日期
	private Date etdkcrq;//etd开船日期
	private Date tzhjdrq;//通知行寄单日期
	private String gzhm;//跟踪号码
	private String lcbfxx;//lc不符信息
	private String fj;//附件
	private Date dqfkr;//到期付款日
	private Integer sfyhk;//是否已回款
	private BigDecimal hkje;//回款金额
	private String  mxbzxx;//备注信息
	private String mxzdrid;// 制单人ID
	private String mxzdrmc;// 制单人名称
	private String chdh;//出货通知书号
	private BigDecimal bfdfy;//不符点费用
	private String bfdyy;//不符点原因
	private BigDecimal ce;//差额
	
	public BigDecimal getDjjdje() {
		return djjdje;
	}

	public void setDjjdje(BigDecimal djjdje) {
		this.djjdje = djjdje;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public LcRegVo() {
		super();
	}

	public LcRegVo(String id){
		super(id);
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public List<LcRegItemVo> getItemVoList() {
		return itemVoList;
	}

	public void setItemVoList(List<LcRegItemVo> itemVoList) {
		this.itemVoList = itemVoList;
	}

	public BigDecimal getYe() {
		return ye;
	}

	public void setYe(BigDecimal ye) {
		this.ye = ye;
	}

	public List<LcLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<LcLogVo> logList) {
		this.logList = logList;
	}

	public List<LcRegVo> getHtylist() {
		return htylist;
	}

	public void setHtylist(List<LcRegVo> htylist) {
		this.htylist = htylist;
	}

	public String getEdbz() {
		return edbz;
	}

	public BigDecimal getEdye() {
		return edye;
	}

	public BigDecimal getHl() {
		return hl;
	}

	public void setEdbz(String edbz) {
		this.edbz = edbz;
	}

	public void setEdye(BigDecimal edye) {
		this.edye = edye;
	}

	public void setHl(BigDecimal hl) {
		this.hl = hl;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public String getCwymc() {
		return cwymc;
	}

	public void setCwymc(String cwymc) {
		this.cwymc = cwymc;
	}

	public Integer getSfywh() {
		return sfywh;
	}

	public void setSfywh(Integer sfywh) {
		this.sfywh = sfywh;
	}

	public BigDecimal getFpje() {
		return fpje;
	}

	public void setFpje(BigDecimal fpje) {
		this.fpje = fpje;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFprq() {
		return fprq;
	}

	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}

	public String getFpbz() {
		return fpbz;
	}

	public void setFpbz(String fpbz) {
		this.fpbz = fpbz;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getQy() {
		return qy;
	}

	public void setQy(String qy) {
		this.qy = qy;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
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

	public String getCwyid() {
		return cwyid;
	}

	public void setCwyid(String cwyid) {
		this.cwyid = cwyid;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getWjjryhrq() {
		return wjjryhrq;
	}

	public void setWjjryhrq(Date wjjryhrq) {
		this.wjjryhrq = wjjryhrq;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTzhsdwjrq() {
		return tzhsdwjrq;
	}

	public void setTzhsdwjrq(Date tzhsdwjrq) {
		this.tzhsdwjrq = tzhsdwjrq;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEtdkcrq() {
		return etdkcrq;
	}

	public void setEtdkcrq(Date etdkcrq) {
		this.etdkcrq = etdkcrq;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTzhjdrq() {
		return tzhjdrq;
	}

	public void setTzhjdrq(Date tzhjdrq) {
		this.tzhjdrq = tzhjdrq;
	}

	public String getGzhm() {
		return gzhm;
	}

	public void setGzhm(String gzhm) {
		this.gzhm = gzhm;
	}

	public String getLcbfxx() {
		return lcbfxx;
	}

	public void setLcbfxx(String lcbfxx) {
		this.lcbfxx = lcbfxx;
	}

	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getDqfkr() {
		return dqfkr;
	}

	public void setDqfkr(Date dqfkr) {
		this.dqfkr = dqfkr;
	}

	public Integer getSfyhk() {
		return sfyhk;
	}

	public void setSfyhk(Integer sfyhk) {
		this.sfyhk = sfyhk;
	}

	public BigDecimal getHkje() {
		return hkje;
	}

	public void setHkje(BigDecimal hkje) {
		this.hkje = hkje;
	}

	public String getMxbzxx() {
		return mxbzxx;
	}

	public void setMxbzxx(String mxbzxx) {
		this.mxbzxx = mxbzxx;
	}

	public String getMxzdrid() {
		return mxzdrid;
	}

	public void setMxzdrid(String mxzdrid) {
		this.mxzdrid = mxzdrid;
	}

	public String getMxzdrmc() {
		return mxzdrmc;
	}

	public void setMxzdrmc(String mxzdrmc) {
		this.mxzdrmc = mxzdrmc;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public BigDecimal getBfdfy() {
		return bfdfy;
	}

	public void setBfdfy(BigDecimal bfdfy) {
		this.bfdfy = bfdfy;
	}

	public String getBfdyy() {
		return bfdyy;
	}

	public void setBfdyy(String bfdyy) {
		this.bfdyy = bfdyy;
	}

	public BigDecimal getCe() {
		return ce;
	}

	public void setCe(BigDecimal ce) {
		this.ce = ce;
	}

	
}