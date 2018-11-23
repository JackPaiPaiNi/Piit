package com.ey.piit.sdo.deliver.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 出货通知书Entity
 * @author 魏诚
 */
public class Deliver extends BaseEntity {
	
	private String chdh;		// 出货单号
	private String ychdh;		// 原出货单号
	private String gsbm;		// 公司编码
	private String gsmc;		// 公司名称
	private String shr;		// 收函人
	private String fhr;		// 发函人
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String ywz;		// 业务组
	private String ywzmc;		// 业务组名称
	private String xszz;		// 销售组织
	private String xszzmc;		// 销售组织名称
	private String bgfs;		// 报关方式
	private String bgfsmc;		// 报关方式名称
	private String bgfsbz;		// 报关方式备注
	private String bcGdbs;		// 补充-跟单备损
	private String bcSpobs;		// 补充-SPO备损
	private String bcWjyq;		// 补充-文件要求
	private String bcZgyq;		// 补充-装柜要求
	private String bcQt;		// 补充-其他
	private String pxx;		// 屏信息
	private String cylx;		// 出运类型
	private String cylxmc;		// 出运类型名称
	private String qyg;		// 起运港
	private String qygmc;		// 起运港名称
	private String qygbz;		// 起运港备注
	private String mdg;		// 目的港
	private String xwgj;		// 销往国家
	private String xwgjmc;		// 销往国家名称
	private String cdgsbm;		// 船代公司
	private String cdgsmc;		// 船代公司名称
	private String cdgslxr;		// 船代公司联系人
	private String cdgsdh;		// 船代公司电话
	private String cdgscz;		// 船代公司传真
	private String cdgsyb;		// 船代公司邮编
	private String cdgsyx;		// 船代公司邮箱
	private String dch;		// 订舱号
	private String cm;		// 船名
	private String hc;		// 航次
	private String hbh;		// 航班号
	private Date yjkcq;		// 预计开船期（ETD）
	private Date yjdgq;		// 预计到港期（ETA）
	private Date zgrq;		// 装柜日期
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
	private Date jcsj;		// 截重时间
	private Date jfxtsj;		// 截放行条时间
	private Date kcsj;		// 开舱时间
	private Date jgq;		// 截关期
	private Date jblsj;		// 截补料/ENS/AMS时间
	private String kdxx;		// 快递信息
	private String fj;		// 附件
	private String tcgs;		// 拖车公司
	private String bzxx;		// 备注信息
	private String ggsm;		// 更改说明
	private String zdrid;		// 制单人
	private String zdrmc;		// 制单人名称
	private Date zdsj;		// 制单时间
	private String beginZdsj;	// 开始 制单时间
	private String endZdsj;		// 结束 制单时间
	private Integer zt;		// 状态
	private Integer bbh;		// 版本号
	private String sjc;		// 时间戳
	private Integer sfBg;		// 是否变更
	private Integer tssapzt;		// 推送SAP状态
	private String scjd;
	private String scjdmc;
	private BigDecimal zje;//出货通知书总金额
	private Integer zsl;//总数量
	private String fph;// 发票号
	private String cwkpr;//船务开票人
	private String cwkprmc;//船务开票人
	
	public Deliver() {
		super();
	}

	public Deliver(String id){
		super(id);
	}
	/**
	 * 自定义日期格式化
	 */
	private Date dateFormat(String date,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date rdDate = null;
		try {
			rdDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rdDate;
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

	/**
     * 出货单号
     */
	@Length(min=1, max=20, message="出货单号长度必须介于 1 和 20 之间")
	public String getChdh() {
		return chdh;
	}

	/**
     * 出货单号
     */
	public void setChdh(String chdh) {
		this.chdh = chdh == null ? null : chdh.trim();
	}
	
	/**
     * 原出货单号
     */
	@Length(min=0, max=20, message="原出货单号长度必须介于 0 和 20 之间")
	public String getYchdh() {
		return ychdh;
	}

	/**
     * 原出货单号
     */
	public void setYchdh(String ychdh) {
		this.ychdh = ychdh == null ? null : ychdh.trim();
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
     * 收函人
     */
	@Length(min=0, max=100, message="收函人长度必须介于 0 和 100 之间")
	public String getShr() {
		return shr;
	}

	/**
     * 收函人
     */
	public void setShr(String shr) {
		this.shr = shr == null ? null : shr.trim();
	}
	
	/**
     * 发函人
     */
	@Length(min=0, max=100, message="发函人长度必须介于 0 和 100 之间")
	public String getFhr() {
		return fhr;
	}

	/**
     * 发函人
     */
	public void setFhr(String fhr) {
		this.fhr = fhr == null ? null : fhr.trim();
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
     * 报关方式
     */
	@Length(min=0, max=20, message="报关方式长度必须介于 0 和 20 之间")
	public String getBgfs() {
		return bgfs;
	}

	/**
     * 报关方式
     */
	public void setBgfs(String bgfs) {
		this.bgfs = bgfs == null ? null : bgfs.trim();
	}
	
	/**
     * 报关方式名称
     */
	@Length(min=0, max=50, message="报关方式名称长度必须介于 0 和 50 之间")
	public String getBgfsmc() {
		return bgfsmc;
	}

	/**
     * 报关方式名称
     */
	public void setBgfsmc(String bgfsmc) {
		this.bgfsmc = bgfsmc == null ? null : bgfsmc.trim();
	}
	
	/**
     * 报关方式备注
     */
	@Length(min=0, max=100, message="报关方式备注长度必须介于 0 和 100 之间")
	public String getBgfsbz() {
		return bgfsbz;
	}

	/**
     * 报关方式备注
     */
	public void setBgfsbz(String bgfsbz) {
		this.bgfsbz = bgfsbz == null ? null : bgfsbz.trim();
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
     * 屏信息
     */
	public String getPxx() {
		return pxx;
	}

	/**
     * 屏信息
     */
	public void setPxx(String pxx) {
		this.pxx = pxx == null ? null : pxx.trim();
	}
	
	/**
     * 出运类型
     */
	@Length(min=1, max=20, message="出运类型长度必须介于 1 和 20 之间")
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
     * 订舱号
     */
	@Length(min=0, max=200, message="订舱号长度必须介于 0 和 200 之间")
	public String getDch() {
		return dch;
	}

	/**
     * 订舱号
     */
	public void setDch(String dch) {
		this.dch = dch == null ? null : dch.trim();
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
     * 预计开船期（ETD）
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjkcq() {
		return yjkcq;
	}

	/**
     * 预计开船期（ETD）
     */
	public void setYjkcq(Date yjkcq) {
		this.yjkcq = yjkcq;
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
     * 装柜日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	public Date getZgrq() {
		return zgrq;
	}

	/**
     * 装柜日期
     */
	public void setZgrq(String zgrq) {
		this.zgrq = this.dateFormat(zgrq,"yyyy-MM-dd HH:mm");
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
     * 截重时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	public Date getJcsj() {
		return jcsj;
	}

	/**
     * 截重时间
     */
	public void setJcsj(String jcsj) {
		this.jcsj = this.dateFormat(jcsj,"yyyy-MM-dd HH:mm");
		
	}
	
	/**
	 * 截放行条时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	public Date getJfxtsj() {
		return jfxtsj;
	}

	/**
	 * 截放行条时间
	 */
	public void setJfxtsj(String jfxtsj) {
		this.jfxtsj = this.dateFormat(jfxtsj,"yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 开舱时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	public Date getKcsj() {
		return kcsj;
	}

	/**
	 * 开舱时间
	 */
	public void setKcsj(String kcsj) {
		this.kcsj = this.dateFormat(kcsj,"yyyy-MM-dd HH:mm");
		
	}
	
	/**
     * 截关期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	public Date getJgq() {
		return jgq;
	}

	/**
     * 截关期
     */
	public void setJgq(String jgq) {
		this.jgq = this.dateFormat(jgq,"yyyy-MM-dd HH:mm");
	}
	
	/**
     * 截补料/ENS/AMS时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	public Date getJblsj() {
		return jblsj;
	}

	/**
     * 截补料/ENS/AMS时间
     */
	public void setJblsj(String jblsj) {
		this.jblsj = this.dateFormat(jblsj,"yyyy-MM-dd HH:mm");
		
	}
	
	/**
     * 快递信息
     */
	@Length(min=0, max=100, message="快递信息长度必须介于 0 和 100 之间")
	public String getKdxx() {
		return kdxx;
	}

	/**
     * 快递信息
     */
	public void setKdxx(String kdxx) {
		this.kdxx = kdxx == null ? null : kdxx.trim();
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
     * 拖车公司
     */
	@Length(min=0, max=100, message="拖车公司长度必须介于 0 和 100 之间")
	public String getTcgs() {
		return tcgs;
	}

	/**
     * 拖车公司
     */
	public void setTcgs(String tcgs) {
		this.tcgs = tcgs == null ? null : tcgs.trim();
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
     * 更改说明
     */
	@Length(min=0, max=200, message="更改说明长度必须介于 0 和 200 之间")
	public String getGgsm() {
		return ggsm;
	}

	/**
     * 更改说明
     */
	public void setGgsm(String ggsm) {
		this.ggsm = ggsm == null ? null : ggsm.trim();
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
     * 是否变更
     */
	public Integer getSfBg() {
		return sfBg;
	}

	/**
     * 是否变更
     */
	public void setSfBg(Integer sfBg) {
		this.sfBg = sfBg;
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

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	public BigDecimal getZje() {
		return zje;
	}

	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}

	public Integer getZsl() {
		return zsl;
	}

	public void setZsl(Integer zsl) {
		this.zsl = zsl;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public String getCwkpr() {
		return cwkpr;
	}

	public void setCwkpr(String cwkpr) {
		this.cwkpr = cwkpr;
	}

	public String getCwkprmc() {
		return cwkprmc;
	}

	public void setCwkprmc(String cwkprmc) {
		this.cwkprmc = cwkprmc;
	}
	
}