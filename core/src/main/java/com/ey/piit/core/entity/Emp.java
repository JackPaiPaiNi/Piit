package com.ey.piit.core.entity;

import java.io.Serializable;

public class Emp extends CoreEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7639000401124958287L;
	
	private String loginAcct;		// 用户账号
	private String empCode;		// 工号
	private String email;		// 邮件地址
	private String name;		// 姓名
	private String companyCode;		// 所在公司
	private String post;		// 职位
	private String certificateType;		// 证件类型
	private String certificateNo;		// 证件号
	private String postType;		// 岗位类别
	private String mainPost;		// 是否主职
	private String sex;		// 性别
	private String status;		// 状态
	private String description;		// 描述
	private String deptCode;		// dept_code
	private String groupCode;		// group_code
	private String phone;//电话
	private String fax;//传真
	private String ywmc;//英文名称
	private String xsy;//销售员（SAP）
	private String xsz;//销售组（SAP）
	private String xsyZz;//销售员（制造SAP）
	private String xszZz;//销售组（制造SAP）
	
	public String getLoginAcct() {
		return loginAcct;
	}
	public void setLoginAcct(String loginAcct) {
		this.loginAcct = loginAcct;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getMainPost() {
		return mainPost;
	}
	public void setMainPost(String mainPost) {
		this.mainPost = mainPost;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getYwmc() {
		return ywmc;
	}
	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}
	public String getXsy() {
		return xsy;
	}
	public void setXsy(String xsy) {
		this.xsy = xsy;
	}
	public String getXsz() {
		return xsz;
	}
	public void setXsz(String xsz) {
		this.xsz = xsz;
	}
	public String getXsyZz() {
		return xsyZz;
	}
	public void setXsyZz(String xsyZz) {
		this.xsyZz = xsyZz;
	}
	public String getXszZz() {
		return xszZz;
	}
	public void setXszZz(String xszZz) {
		this.xszZz = xszZz;
	}
	
}
