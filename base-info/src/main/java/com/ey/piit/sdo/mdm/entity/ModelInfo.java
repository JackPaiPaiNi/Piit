package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 机型机芯维护Entity
 * @author 高文浩
 */
public class ModelInfo extends BaseEntity {
	
	private String code;		// 编码
	private String name;		// 名称
	private String type;		// 类别
	private Integer sort;		// 排序
	private String ext1;		// 扩展字段1
	private String ext2;		// 扩展字段2
	private String status;		// 状态
	private String remark;		// 备注
	
	public ModelInfo() {
		super();
	}

	public ModelInfo(String id){
		super(id);
	}

	/**
     * 编码
     */
	@Length(min=0, max=50, message="编码长度必须介于 0 和 50 之间")
	public String getCode() {
		return code;
	}

	/**
     * 编码
     */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}
	
	/**
     * 名称
     */
	@Length(min=0, max=200, message="名称长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	/**
     * 名称
     */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	
	/**
     * 类别
     */
	@Length(min=0, max=50, message="类别长度必须介于 0 和 50 之间")
	public String getType() {
		return type;
	}

	/**
     * 类别
     */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
	
	/**
     * 排序
     */
	public Integer getSort() {
		return sort;
	}

	/**
     * 排序
     */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	/**
     * 扩展字段1
     */
	@Length(min=0, max=200, message="扩展字段1长度必须介于 0 和 200 之间")
	public String getExt1() {
		return ext1;
	}

	/**
     * 扩展字段1
     */
	public void setExt1(String ext1) {
		this.ext1 = ext1 == null ? null : ext1.trim();
	}
	
	/**
     * 扩展字段2
     */
	@Length(min=0, max=200, message="扩展字段2长度必须介于 0 和 200 之间")
	public String getExt2() {
		return ext2;
	}

	/**
     * 扩展字段2
     */
	public void setExt2(String ext2) {
		this.ext2 = ext2 == null ? null : ext2.trim();
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
     * 备注
     */
	@Length(min=0, max=500, message="备注长度必须介于 0 和 500 之间")
	public String getRemark() {
		return remark;
	}

	/**
     * 备注
     */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
}