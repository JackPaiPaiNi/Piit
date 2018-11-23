package com.ey.piit.core.entity;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 节点信息
 * 
 * @author Kevin-Y.Xu
 *
 */
public class TreeNode {

	/**
	 * ID
	 */
	private String id;
	
	/**
	 * 父节点ID
	 */
	@JsonInclude(Include.NON_EMPTY)
	private String pId;

	/**
	 * 节点名字
	 */
	@JsonInclude(Include.NON_EMPTY)
	private String name;
	
	@JsonIgnore
	private Boolean parent;
	
	/**
	 * 是否为父节点
	 */
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty("isParent")
	private Boolean isParent = true;

	/**
	 * 节点类型
	 */
	@JsonInclude(Include.NON_EMPTY)
	private String type;

	/**
	 * 是否被选中
	 */
	@JsonInclude(Include.NON_EMPTY)
	private Boolean checked;
	
	/**
	 * 是否被展开
	 */
	@JsonInclude(Include.NON_EMPTY)
	private Boolean open = true;
	
	/**
	 * 子节点列表
	 */
	@JsonInclude(Include.NON_EMPTY)
	private List<TreeNode> children;
	
	@JsonInclude(Include.NON_EMPTY)
	private String ext;
	
	@JsonInclude(Include.NON_EMPTY)
	private String ext2;
	
	@JsonInclude(Include.NON_EMPTY)
	private String path;
	
	@JsonInclude(Include.NON_EMPTY)
	private Map<String, String> font;
	
	@JsonInclude(Include.NON_EMPTY)
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getParent() {
		return parent;
	}

	public void setParent(Boolean parent) {
		this.parent = parent;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public Map<String, String> getFont() {
		return font;
	}

	public void setFont(Map<String, String> font) {
		this.font = font;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
