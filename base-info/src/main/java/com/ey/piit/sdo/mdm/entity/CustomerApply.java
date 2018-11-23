package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 客户信息申请Entity
 * @author 高文浩
 */
public class CustomerApply extends BaseEntity {
	
	private String sqdh;		// 申请单号
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String khjc;		// 客户简称
	private String gj;		// 数据值集
	private String gwdz;		// 官网地址
	private String lxr;		// 联系人
	private String lxr2;		// 联系人2
	private String lxr3;		// 联系人3
	private String sjh;		// 手机号
	private String dh;		// 电话
	private String cz;		// 传真
	private String yx;		// 邮箱
	private String skype;		// Skype
	private String whatapp;		// Whatapp
	private String xxdz;		// 详细地址
	private String pp;		// 品牌
	private String fktj;		// 付款条件
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String glkhbm;		// 关联客户编码
	private String bzxx;		// 备注
	private String zdrid;		// 创建人
	private String zdrmc;		// 创建人名称
	private Date cjsj;		// 创建时间
	private Integer zt;		// 状态：0代表未审核；1审核中；2审核通过；-1审核不通过；
	private String sjc;		// 时间戳
	
	public CustomerApply() {
		super();
	}

	public CustomerApply(String id){
		super(id);
	}

	/**
     * 申请单号
     */
	@Length(min=1, max=20, message="申请单号长度必须介于 1 和 20 之间")
	public String getSqdh() {
		return sqdh;
	}

	/**
     * 申请单号
     */
	public void setSqdh(String sqdh) {
		this.sqdh = sqdh == null ? null : sqdh.trim();
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
	@Length(min=1, max=100, message="客户名称长度必须介于 1 和 100 之间")
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
     * 客户简称
     */
	@Length(min=0, max=50, message="客户简称长度必须介于 0 和 50 之间")
	public String getKhjc() {
		return khjc;
	}

	/**
     * 客户简称
     */
	public void setKhjc(String khjc) {
		this.khjc = khjc == null ? null : khjc.trim();
	}
	
	/**
     * 数据值集
     */
	@Length(min=0, max=20, message="数据值集长度必须介于 0 和 20 之间")
	public String getGj() {
		return gj;
	}

	/**
     * 数据值集
     */
	public void setGj(String gj) {
		this.gj = gj == null ? null : gj.trim();
	}
	
	/**
     * 官网地址
     */
	@Length(min=0, max=50, message="官网地址长度必须介于 0 和 50 之间")
	public String getGwdz() {
		return gwdz;
	}

	/**
     * 官网地址
     */
	public void setGwdz(String gwdz) {
		this.gwdz = gwdz == null ? null : gwdz.trim();
	}
	
	/**
     * 联系人
     */
	@Length(min=0, max=50, message="联系人长度必须介于 0 和 50 之间")
	public String getLxr() {
		return lxr;
	}

	/**
     * 联系人
     */
	public void setLxr(String lxr) {
		this.lxr = lxr == null ? null : lxr.trim();
	}
	
	/**
     * 联系人2
     */
	@Length(min=0, max=50, message="联系人2长度必须介于 0 和 50 之间")
	public String getLxr2() {
		return lxr2;
	}

	/**
     * 联系人2
     */
	public void setLxr2(String lxr2) {
		this.lxr2 = lxr2 == null ? null : lxr2.trim();
	}
	
	/**
     * 联系人3
     */
	@Length(min=0, max=50, message="联系人3长度必须介于 0 和 50 之间")
	public String getLxr3() {
		return lxr3;
	}

	/**
     * 联系人3
     */
	public void setLxr3(String lxr3) {
		this.lxr3 = lxr3 == null ? null : lxr3.trim();
	}
	
	/**
     * 手机号
     */
	@Length(min=0, max=20, message="手机号长度必须介于 0 和 20 之间")
	public String getSjh() {
		return sjh;
	}

	/**
     * 手机号
     */
	public void setSjh(String sjh) {
		this.sjh = sjh == null ? null : sjh.trim();
	}
	
	/**
     * 电话
     */
	@Length(min=0, max=20, message="电话长度必须介于 0 和 20 之间")
	public String getDh() {
		return dh;
	}

	/**
     * 电话
     */
	public void setDh(String dh) {
		this.dh = dh == null ? null : dh.trim();
	}
	
	/**
     * 传真
     */
	@Length(min=0, max=20, message="传真长度必须介于 0 和 20 之间")
	public String getCz() {
		return cz;
	}

	/**
     * 传真
     */
	public void setCz(String cz) {
		this.cz = cz == null ? null : cz.trim();
	}
	
	/**
     * 邮箱
     */
	@Length(min=0, max=50, message="邮箱长度必须介于 0 和 50 之间")
	public String getYx() {
		return yx;
	}

	/**
     * 邮箱
     */
	public void setYx(String yx) {
		this.yx = yx == null ? null : yx.trim();
	}
	
	/**
     * Skype
     */
	@Length(min=0, max=50, message="Skype长度必须介于 0 和 50 之间")
	public String getSkype() {
		return skype;
	}

	/**
     * Skype
     */
	public void setSkype(String skype) {
		this.skype = skype == null ? null : skype.trim();
	}
	
	/**
     * Whatapp
     */
	@Length(min=0, max=50, message="Whatapp长度必须介于 0 和 50 之间")
	public String getWhatapp() {
		return whatapp;
	}

	/**
     * Whatapp
     */
	public void setWhatapp(String whatapp) {
		this.whatapp = whatapp == null ? null : whatapp.trim();
	}
	
	/**
     * 详细地址
     */
	@Length(min=0, max=100, message="详细地址长度必须介于 0 和 100 之间")
	public String getXxdz() {
		return xxdz;
	}

	/**
     * 详细地址
     */
	public void setXxdz(String xxdz) {
		this.xxdz = xxdz == null ? null : xxdz.trim();
	}
	
	/**
     * 品牌
     */
	@Length(min=0, max=50, message="品牌长度必须介于 0 和 50 之间")
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
     * 付款条件
     */
	@Length(min=1, max=100, message="付款条件长度必须介于 1 和 100 之间")
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
     * 关联客户编码
     */
	@Length(min=0, max=20, message="关联客户编码长度必须介于 0 和 20 之间")
	public String getGlkhbm() {
		return glkhbm;
	}

	/**
     * 关联客户编码
     */
	public void setGlkhbm(String glkhbm) {
		this.glkhbm = glkhbm == null ? null : glkhbm.trim();
	}
	
	/**
     * 备注
     */
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
     * 备注
     */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
	}
	
	/**
     * 创建人
     */
	@Length(min=1, max=20, message="创建人长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
     * 创建人
     */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}
	
	/**
     * 创建人名称
     */
	@Length(min=1, max=50, message="创建人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
     * 创建人名称
     */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}
	
	/**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="创建时间不能为空")
	public Date getCjsj() {
		return cjsj;
	}

	/**
     * 创建时间
     */
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
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
	
}