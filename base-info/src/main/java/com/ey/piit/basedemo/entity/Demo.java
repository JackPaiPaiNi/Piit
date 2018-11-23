/*
 * Demo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-09-21 Created
 */
package com.ey.piit.basedemo.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.format.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 表名：t_demo
 * 
 * @author Kevin Xu
 * @version 1.0 2015-09-21
 */
public class Demo extends CoreEntity {

	/**
	 * 序号
	 */
	private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Long age;
    /**
     * 工资
     */
    private BigDecimal salary;
    private String phone;
    private String email;
    /**
     * 性别
     */
    private String sex;
    /**
     * 状态
     */
    private String status;
    /**
     * 描述
     */
    private String description;
    /**
     * 生日
     */
    private Date sdate;

    /**
	 * 序号
	 */
    public String getId() {
		return id;
	}

    /**
	 * 序号
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

    /**
     * 姓名
     */
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
     * 年龄
     */
    public Long getAge() {
        return age;
    }

    /**
     * 年龄
     */
    public void setAge(Long age) {
        this.age = age;
    }

    /**
     * 工资
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * 工资
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 性别
     */
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
     * 生日
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getSdate() {
        return sdate;
    }

    /**
     * 生日
     */
    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }
}