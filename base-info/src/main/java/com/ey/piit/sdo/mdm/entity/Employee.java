package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 员工维护Entity
 * 
 * @author 高文浩
 */
public class Employee extends BaseEntity {

	private String loginAcct; // 用户账号
	private String empCode; // 工号
	private String email; // 邮件地址
	private String name; // 姓名
	private String companyCode; // 所在公司
	private String post; // 职位
	private String certificateType; // 证件类型
	private String certificateNo; // 证件号
	private String postType; // 岗位类别
	private String mainPost; // 是否主职
	private String sex; // 性别
	private String status; // 状态
	private String description; // 描述
	private String deptCode; // 所在部门
	private String groupCode; // 所在业务组
	private String deptName;
	private String phone; // 电话
	private String fax; // 传真
	private String ywmc; // 英文名称
	private String xsy; // 销售员
	private String xsz; // 销售组
	private String dh; // 电话
	private String cz; // 传真
	private String xsyZz; // 销售员(制造SAP)
	private String xszZz; // 销售组(制造SAP)
	private String ywjc; // 英文简称 （开票用）
	private String xszzbm; // 销售组织编码（开票用）

	public String getYwjc() {
		return ywjc;
	}

	public void setYwjc(String ywjc) {
		this.ywjc = ywjc;
	}

	public String getXszzbm() {
		return xszzbm;
	}

	public void setXszzbm(String xszzbm) {
		this.xszzbm = xszzbm;
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

	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public String getCz() {
		return cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	public Employee() {
		super();
	}

	public Employee(String id) {
		super(id);
	}

	/**
	 * 用户账号
	 */
	@Length(min = 0, max = 100, message = "用户账号长度必须介于 0 和 100 之间")
	public String getLoginAcct() {
		return loginAcct;
	}

	/**
	 * 用户账号
	 */
	public void setLoginAcct(String loginAcct) {
		this.loginAcct = loginAcct == null ? null : loginAcct.trim();
	}

	/**
	 * 工号
	 */
	@Length(min = 0, max = 200, message = "工号长度必须介于 0 和 200 之间")
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * 工号
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode == null ? null : empCode.trim();
	}

	/**
	 * 邮件地址
	 */
	@Length(min = 0, max = 200, message = "邮件地址长度必须介于 0 和 200 之间")
	public String getEmail() {
		return email;
	}

	/**
	 * 邮件地址
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * 姓名
	 */
	@Length(min = 0, max = 200, message = "姓名长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 所在公司
	 */
	@Length(min = 0, max = 200, message = "所在公司长度必须介于 0 和 200 之间")
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * 所在公司
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode == null ? null : companyCode.trim();
	}

	/**
	 * 职位
	 */
	@Length(min = 0, max = 200, message = "职位长度必须介于 0 和 200 之间")
	public String getPost() {
		return post;
	}

	/**
	 * 职位
	 */
	public void setPost(String post) {
		this.post = post == null ? null : post.trim();
	}

	/**
	 * 证件类型
	 */
	@Length(min = 0, max = 200, message = "证件类型长度必须介于 0 和 200 之间")
	public String getCertificateType() {
		return certificateType;
	}

	/**
	 * 证件类型
	 */
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType == null ? null : certificateType.trim();
	}

	/**
	 * 证件号
	 */
	@Length(min = 0, max = 200, message = "证件号长度必须介于 0 和 200 之间")
	public String getCertificateNo() {
		return certificateNo;
	}

	/**
	 * 证件号
	 */
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo == null ? null : certificateNo.trim();
	}

	/**
	 * 岗位类别
	 */
	@Length(min = 0, max = 200, message = "岗位类别长度必须介于 0 和 200 之间")
	public String getPostType() {
		return postType;
	}

	/**
	 * 岗位类别
	 */
	public void setPostType(String postType) {
		this.postType = postType == null ? null : postType.trim();
	}

	/**
	 * 是否主职
	 */
	@Length(min = 0, max = 2, message = "是否主职长度必须介于 0 和 2 之间")
	public String getMainPost() {
		return mainPost;
	}

	/**
	 * 是否主职
	 */
	public void setMainPost(String mainPost) {
		this.mainPost = mainPost == null ? null : mainPost.trim();
	}

	/**
	 * 性别
	 */
	@Length(min = 0, max = 2, message = "性别长度必须介于 0 和 2 之间")
	public String getSex() {
		return sex;
	}

	/**
	 * 性别
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	/**
	 * 状态
	 */
	@Length(min = 0, max = 2, message = "状态长度必须介于 0 和 2 之间")
	public String getStatus() {
		return status;
	}

	/**
	 * 状态
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * 描述
	 */
	@Length(min = 0, max = 500, message = "描述长度必须介于 0 和 500 之间")
	public String getDescription() {
		return description;
	}

	/**
	 * 描述
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * 所在部门
	 */
	@Length(min = 0, max = 200, message = "所在部门长度必须介于 0 和 200 之间")
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * 所在部门
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode == null ? null : deptCode.trim();
	}

	/**
	 * 所在业务组
	 */
	@Length(min = 0, max = 200, message = "所在业务组长度必须介于 0 和 200 之间")
	public String getGroupCode() {
		return groupCode;
	}

	/**
	 * 所在业务组
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode == null ? null : groupCode.trim();
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

}