package com.ey.piit.core.entity;

import java.util.ArrayList;
import java.util.List;

public class AdEntity {

	private String cn;//姓名
	private String mail;
	private String displayname;//姓名
	private String givenname;//名字
	private String sn;//姓氏
	private String userprincipalname;
	private String department;//部门
	private String frem;//ID账号  SKY020693
	private String dn;//用于调整 新的部门格式 "CN=张三,"+"OU=test3,OU=中国区域营销总部,OU=创维集团,"
	private String olddn;//用于调整 老部门格式 "CN=张三,"+"OU=test1,OU=中国区域营销总部,OU=创维集团,";
	private List<String> forglist=new ArrayList<String>();//用于存储中国区域营销总部以下的组织结点 格式 ：test1,test2  "CN=张三,"+"OU=test2,OU=test1,OU=中国区域营销总部,OU=创维集团,";
    private String[] forgs=new String[]{};
	private String parent;//格式存储如 "OU=中国区域营销总部,OU=创维集团,"
    private String password;//重置密码
    private String msg;//生成域账号失败信息
    private String flag;//生成域账号成功标识 0失败 1成功
    private String ftype;//ehr中来自于哪张表
    private String idcard;//身份证后8位
    private String pwdlastset;//最后设置密码时间
    private String useraccountcontrol;//账号状态
    private String ou;
    private String extensionattribute1;//邮件存储位置
    private String pwd;//ad域账号密码
    private String adzh;//ad域账号
    private String zt;//ad域账号禁用状态
    private String describe;//描述
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getGivenname() {
		return givenname;
	}
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getUserprincipalname() {
		return userprincipalname;
	}
	public void setUserprincipalname(String userprincipalname) {
		this.userprincipalname = userprincipalname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFrem() {
		return frem;
	}
	public void setFrem(String frem) {
		this.frem = frem;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getOlddn() {
		return olddn;
	}
	public void setOlddn(String olddn) {
		this.olddn = olddn;
	}
	public List<String> getForglist() {
		return forglist;
	}
	public void setForglist(List<String> forglist) {
		this.forglist = forglist;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String[] getForgs() {
		return forgs;
	}
	public void setForgs(String[] forgs) {
		this.forgs = forgs;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPwdlastset() {
		return pwdlastset;
	}
	public void setPwdlastset(String pwdlastset) {
		this.pwdlastset = pwdlastset;
	}
	public String getUseraccountcontrol() {
		return useraccountcontrol;
	}
	public void setUseraccountcontrol(String useraccountcontrol) {
		this.useraccountcontrol = useraccountcontrol;
	}
	public String getOu() {
		return ou;
	}
	public void setOu(String ou) {
		this.ou = ou;
	}
	public String getExtensionattribute1() {
		return extensionattribute1;
	}
	public void setExtensionattribute1(String extensionattribute1) {
		this.extensionattribute1 = extensionattribute1;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAdzh() {
		return adzh;
	}
	public void setAdzh(String adzh) {
		this.adzh = adzh;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	

	
}
	
