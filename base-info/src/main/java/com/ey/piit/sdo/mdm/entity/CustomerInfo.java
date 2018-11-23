package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 客户信息维护Entity
 * @author 赵桃军
 */
public class CustomerInfo extends BaseEntity {
	
	private String khbm;		// 客户编码
	private String khmc;		// 客户名称
	private String khlx;		// 客户类型
	private String khlxmc;		// 客户类型名称
	private String khjc;		// 客户简称
	private String pp;		// 品牌
	private String fktj;		// 付款条件
	private String dz;		// 地址
	private String bz;		// 币种
	private String dh;		// 电话
	private String wz;		// 网址
	private String lxr;		// 联系人
	private String sjh;		// 手机号
	private String yx;		// 邮箱
	private String skype;		// Skype
	private String whatapp;		// Whatapp
	private String xsyid;		// 销售员
	private String xsymc;		// 销售员名称
	private String xwgj;		// 销往国家编码
	private String xwgjmc;		// 销往国家名称
	private String glkhbm;		// 关联客户编码
	private String zxbmfdm;		// 中信保买方代码
	private String bzxx;		// 备注
	private String xyedye;		// 信用额度余额
	private Integer yxhts;		// 销售合同或品牌代理合同合同数
	private Integer zt;		// 状态
	
	public CustomerInfo() {
		super();
	}

	public CustomerInfo(String id){
		super(id);
	}
	
	

	public String getKhlx() {
		return khlx;
	}

	public void setKhlx(String khlx) {
		this.khlx = khlx;
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
     * 地址
     */
	@Length(min=0, max=100, message="地址长度必须介于 0 和 100 之间")
	public String getDz() {
		return dz;
	}

	/**
     * 地址
     */
	public void setDz(String dz) {
		this.dz = dz == null ? null : dz.trim();
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
     * 网址
     */
	@Length(min=0, max=50, message="网址长度必须介于 0 和 50 之间")
	public String getWz() {
		return wz;
	}

	/**
     * 网址
     */
	public void setWz(String wz) {
		this.wz = wz == null ? null : wz.trim();
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
     * 销往国家编码
     */
	@Length(min=0, max=20, message="销往国家编码长度必须介于 0 和 20 之间")
	public String getXwgj() {
		return xwgj;
	}

	/**
     * 销往国家编码
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
     * 中信保买方代码
     */
	@Length(min=0, max=20, message="中信保买方代码长度必须介于 0 和 20 之间")
	public String getZxbmfdm() {
		return zxbmfdm;
	}

	/**
     * 中信保买方代码
     */
	public void setZxbmfdm(String zxbmfdm) {
		this.zxbmfdm = zxbmfdm == null ? null : zxbmfdm.trim();
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
     * 状态
     */
	public Integer getZt() {
		return zt;
	}

	/**
     * 状态
     */
	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getXyedye() {
		return xyedye;
	}

	public void setXyedye(String xyedye) {
		this.xyedye = xyedye;
	}

	public Integer getYxhts() {
		return yxhts;
	}

	public void setYxhts(Integer yxhts) {
		this.yxhts = yxhts;
	}

	public String getKhlxmc() {
		return khlxmc;
	}

	public void setKhlxmc(String khlxmc) {
		this.khlxmc = khlxmc;
	}
	
}