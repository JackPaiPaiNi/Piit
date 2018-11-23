package com.ey.piit.sdo.booking.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订舱通知书Entity
 * 
 * @author 赵明
 */
public class Booking extends BaseEntity {

	private String dcdh; // 订舱单号
	private String cylx; // 出运类型
	private String cylxmc; // 出运类型名称
	private String qyg; // 起运港
	private String qygmc; // 起运港名称
	private String qygbz; // 起运港备注
	private String mytk; // 贸易条款
	private String mytkmc; // 贸易条款
	private String mdg; // 目的港
	private String xwgj; // 销往国家
	private String xwgjmc; // 销往国家名称
	private String cdgsbm; // 船代公司
	private String cdgsmc; // 船代公司名称
	private String cdgslxr; // 船代公司联系人
	private String cdgsdh; // 船代公司电话
	private String cdgsyx; // 船代公司邮箱
	private String dch; // 订舱号
	private String cm; // 船名/航次/航班号
	private String hc; // 船名/航次/航班号
	private String hbh; // 船名/航次/航班号
	private Date yjkcq; // 预计开船期
	private Date yjdgq; // 预计到港期
	private Date zgrq; // 装柜日期
	private Integer ygZgs; // 用柜-总柜数
	private Integer yg20gp; // 用柜-20GP
	private Integer yg40gp; // 用柜-40GP
	private Integer yg40hq; // 用柜-40HQ
	private String ygGsbz; // 用柜- 柜数备注
	private Integer dcZcs; // 吨车-总车数
	private Integer dc3d; // 吨车-3吨
	private Integer dc5d; // 吨车-5吨
	private Integer dc8d; // 吨车-8吨
	private Integer dc10d; // 吨车-10吨
	private Integer dc12d; // 吨车-12吨
	private String dcDcbz; // 吨车-吨车备注
	private Date jcsj; // 截重时间
	private Date jfxtsj; // 截放行条时间
	private Date kcsj; // 开舱时间
	private Date jblsj; // 截补料/ENS/AMS时间
	private String kdlx; // 快递类型
	private String kdlxmc; // 快递类型名称
	private String kd; // 快递
	private String kdmc; // 快递名称
	private String kdbz; // 快递备注
	private String dfzh; // 到付账户
	private Date jgq; // 截关期
	private String fj; // 附件
	private String bzxx; // 备注信息
	private String zdrid; // 制单人
	private String zdrmc; // 制单人名称
	/* 预走货信息用于出货通知书 */
	private String gsbm; // 公司编码
	private String gsmc; // 公司名称
	private String khbm; // 客户编码
	private String khmc; // 客户名称
	private String xsyid; // 销售代码（销售员）
	private String xsymc; // 销售员名称
	private String bcGdbs; // 补充-跟单备损
	private String bcSpobs; // 补充-SPO备损
	private String bcWjyq; // 补充-文件要求
	private String bcZgyq; // 补充-装柜要求
	private String bcQt; // 补充-其他
	private String pxx; // 补充-屏信息
	private String cdgsyb; // 船代公司邮编
	private String cdgscz; // 船代公司传真
	private String yzhlx; // 预走货类型
	private Date zdsj; // 制单时间
	private String beginZdsj; // 制单开始时间
	private String endZdsj; // 制单结束时间
	private Integer zt; // 状态
	private String sjc; // 时间戳
	private String sfkt; // 是否客体
	private Integer yssfcq; // 应收是否超期
	private String scjd; // 生产基地
	private String scjdmc; // 生产基地名称

	public Booking() {
		super();
	}

	public Booking(String id) {
		super(id);
	}

	public String getScjdmc() {
		return scjdmc;
	}

	public void setScjdmc(String scjdmc) {
		this.scjdmc = scjdmc;
	}

	public String getScjd() {
		return scjd;
	}

	public void setScjd(String scjd) {
		this.scjd = scjd;
	}

	/**
	 * 订舱单号
	 */
	@Length(min = 1, max = 20, message = "订舱单号长度必须介于 1 和 20 之间")
	public String getDcdh() {
		return dcdh;
	}

	/**
	 * 订舱单号
	 */
	public void setDcdh(String dcdh) {
		this.dcdh = dcdh == null ? null : dcdh.trim();
	}

	/**
	 * 出运类型
	 */
	@Length(min = 1, max = 50, message = "出运类型长度必须介于 1 和 50 之间")
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
	 * 起运港
	 */
	@Length(min = 0, max = 50, message = "起运港长度必须介于 0 和 50 之间")
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
	@Length(min = 0, max = 50, message = "起运港名称长度必须介于 0 和 50 之间")
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
	@Length(min = 0, max = 100, message = "起运港备注长度必须介于 0 和 100 之间")
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
	@Length(min = 0, max = 100, message = "目的港长度必须介于 0 和 100 之间")
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
	@Length(min = 0, max = 50, message = "销往国家长度必须介于 0 和 50 之间")
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
	 * 船代公司
	 */
	@Length(min = 0, max = 20, message = "船代公司长度必须介于 0 和 20 之间")
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
	@Length(min = 0, max = 100, message = "船代公司名称长度必须介于 0 和 100 之间")
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
	@Length(min = 0, max = 50, message = "船代公司联系人长度必须介于 0 和 50 之间")
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
	@Length(min = 0, max = 20, message = "船代公司电话长度必须介于 0 和 20 之间")
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
	 * 船代公司邮箱
	 */
	@Length(min = 0, max = 50, message = "船代公司邮箱长度必须介于 0 和 50 之间")
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
	@Length(min = 0, max = 20, message = "订舱号长度必须介于 0 和 20 之间")
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
	@Length(min = 0, max = 50, message = "船名长度必须介于 0 和 50 之间")
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
	@Length(min = 0, max = 50, message = "航次长度必须介于 0 和 50 之间")
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
	@Length(min = 0, max = 50, message = "航班号长度必须介于 0 和 50 之间")
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
	 * ETA
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjdgq() {
		return yjdgq;
	}

	/**
	 * ETA
	 */
	public void setYjdgq(Date yjdgq) {
		this.yjdgq = yjdgq;
	}

	/**
	 * 装柜时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZgrq() {
		return zgrq;
	}

	/**
	 * 装柜时间
	 */
	public void setZgrq(Date zgrq) {
		this.zgrq = zgrq;
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
	@Length(min = 0, max = 100, message = "用柜- 柜数备注长度必须介于 0 和 100 之间")
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
	@NotNull(message = "吨车-5吨不能为空")
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
	@NotNull(message = "吨车-8吨不能为空")
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
	@Length(min = 0, max = 100, message = "吨车-吨车备注长度必须介于 0 和 100 之间")
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

	/**
	 * 截重时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	public Date getJcsj() {
		return jcsj;
	}

	/**
	 * 截重时间
	 * 使用自定义日期转换格式，防止spring自动装配抹掉时分秒
	 * @param jcsj
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

	public String getKdlx() {
		return kdlx;
	}

	public String getKdlxmc() {
		return kdlxmc;
	}

	public String getKd() {
		return kd;
	}

	public String getKdmc() {
		return kdmc;
	}

	public String getKdbz() {
		return kdbz;
	}

	public void setKdlx(String kdlx) {
		this.kdlx = kdlx;
	}

	public void setKdlxmc(String kdlxmc) {
		this.kdlxmc = kdlxmc;
	}

	public void setKd(String kd) {
		this.kd = kd;
	}

	public void setKdmc(String kdmc) {
		this.kdmc = kdmc;
	}

	public void setKdbz(String kdbz) {
		this.kdbz = kdbz;
	}

	/**
	 * 预计开船期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYjkcq() {
		return yjkcq;
	}

	/**
	 * 预计开船期
	 */
	public void setYjkcq(Date yjkcq) {
		this.yjkcq = yjkcq;
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
	 * 备注信息
	 */
	@Length(min = 0, max = 200, message = "备注信息长度必须介于 0 和 200 之间")
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
	@JsonFormat(pattern = "yyyy-MM-dd")
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

	public String getBcGdbs() {
		return bcGdbs;
	}

	public void setBcGdbs(String bcGdbs) {
		this.bcGdbs = bcGdbs;
	}

	public String getBcSpobs() {
		return bcSpobs;
	}

	public void setBcSpobs(String bcSpobs) {
		this.bcSpobs = bcSpobs;
	}

	public String getBcWjyq() {
		return bcWjyq;
	}

	public void setBcWjyq(String bcWjyq) {
		this.bcWjyq = bcWjyq;
	}

	public String getBcZgyq() {
		return bcZgyq;
	}

	public void setBcZgyq(String bcZgyq) {
		this.bcZgyq = bcZgyq;
	}

	public String getBcQt() {
		return bcQt;
	}

	public void setBcQt(String bcQt) {
		this.bcQt = bcQt;
	}

	public String getPxx() {
		return pxx;
	}

	public void setPxx(String pxx) {
		this.pxx = pxx;
	}

	public String getCdgsyb() {
		return cdgsyb;
	}

	public void setCdgsyb(String cdgsyb) {
		this.cdgsyb = cdgsyb;
	}

	public String getCdgscz() {
		return cdgscz;
	}

	public void setCdgscz(String cdgscz) {
		this.cdgscz = cdgscz;
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public String getYzhlx() {
		return yzhlx;
	}

	public void setYzhlx(String yzhlx) {
		this.yzhlx = yzhlx;
	}

	public String getMytk() {
		return mytk;
	}

	public void setMytk(String mytk) {
		this.mytk = mytk;
	}

	public String getMytkmc() {
		return mytkmc;
	}

	public void setMytkmc(String mytkmc) {
		this.mytkmc = mytkmc;
	}

	public String getSfkt() {
		return sfkt;
	}

	public void setSfkt(String sfkt) {
		this.sfkt = sfkt;
	}

	public Integer getYssfcq() {
		return yssfcq;
	}

	public void setYssfcq(Integer yssfcq) {
		this.yssfcq = yssfcq;
	}

	public String getGsmc() {
		return gsmc;
	}

	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}

	public String getDfzh() {
		return dfzh;
	}

	public void setDfzh(String dfzh) {
		this.dfzh = dfzh;
	}

}