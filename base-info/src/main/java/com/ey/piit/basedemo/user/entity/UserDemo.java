package com.ey.piit.basedemo.user.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 用户Entity
 * @author kevin
 */
public class UserDemo extends BaseEntity {
	
	private String loginAcct;		// 用户账号
	private String userName;		// 用户名
	private String password;		// 密码
	private String empCode;		// 工号
	private String compCode;		// 所属公司
	private String email;		// 邮件地址
	private String status;		// 状态
	private String type;		// 类型
	private String description;		// 描述
	private String defautRole;		// 默认角色
	
	public UserDemo() {
		super();
	}

	public UserDemo(String id){
		super(id);
	}

	/**
     * 用户账号
     */
	@Length(min=0, max=50, message="用户账号长度必须介于 0 和 50 之间")
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
     * 用户名
     */
	@Length(min=0, max=50, message="用户名长度必须介于 0 和 50 之间")
	public String getUserName() {
		return userName;
	}

	/**
     * 用户名
     */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}
	
	/**
     * 密码
     */
	@Length(min=0, max=50, message="密码长度必须介于 0 和 50 之间")
	public String getPassword() {
		return password;
	}

	/**
     * 密码
     */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
	
	/**
     * 工号
     */
	@Length(min=0, max=50, message="工号长度必须介于 0 和 50 之间")
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
     * 所属公司
     */
	@Length(min=0, max=50, message="所属公司长度必须介于 0 和 50 之间")
	public String getCompCode() {
		return compCode;
	}

	/**
     * 所属公司
     */
	public void setCompCode(String compCode) {
		this.compCode = compCode == null ? null : compCode.trim();
	}
	
	/**
     * 邮件地址
     */
	@Length(min=0, max=200, message="邮件地址长度必须介于 0 和 200 之间")
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
     * 状态
     */
	@Length(min=0, max=2, message="状态长度必须介于 0 和 2 之间")
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
     * 类型
     */
	@Length(min=0, max=2, message="类型长度必须介于 0 和 2 之间")
	public String getType() {
		return type;
	}

	/**
     * 类型
     */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
	
	/**
     * 描述
     */
	@Length(min=0, max=500, message="描述长度必须介于 0 和 500 之间")
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
     * 默认角色
     */
	@Length(min=0, max=50, message="默认角色长度必须介于 0 和 50 之间")
	public String getDefautRole() {
		return defautRole;
	}

	/**
     * 默认角色
     */
	public void setDefautRole(String defautRole) {
		this.defautRole = defautRole == null ? null : defautRole.trim();
	}
	
}