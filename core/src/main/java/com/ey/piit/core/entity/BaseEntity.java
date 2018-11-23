package com.ey.piit.core.entity;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.utils.UserUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseEntity {
	
	public enum Oper{
		add,edit,del
	}
	
	protected Oper oper;
	protected String id;
	protected User creator;
	protected Date createTime;
	protected User lastUpdater;
	protected Date lastUpdateTime;
	protected String remarks;
	protected String delFlag; // 删除标记（0：正常；1：删除；2：审核）
	protected String token;
	protected String msg;//返回给前台的消息
	protected String result = "1";//返回给前台的标记（为控制弹出图标）
	
	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";
	
	/**
	 * 是否分发
	 */
	protected boolean isPub;
	
	// 审核使用
	private String processId;
	private String taskId;
	private Integer approveType;     //审批类型1通过 2驳回 3终审
	private String spyj;            //审批意见
	private Integer sfBg;		// 是否变更中
	private Integer sfQx;		// 是否取消中
	
	public BaseEntity() {
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public BaseEntity(String id) {
		this();
		this.id = id;
	}
	
	public void preInsert(){
		if (StringUtils.isBlank(this.id) || "_empty".equals(this.id)) {
			this.id = Identities.uuid();
		}
		if (this.creator == null || this.creator.id == null || this.lastUpdater == null || this.lastUpdater.id == null) {
			User user = UserUtils.getUser();
    		this.lastUpdater = user;
			this.creator = user;
		}
		this.lastUpdateTime = new Date();
		this.createTime = this.lastUpdateTime;
	}
	
	public void preUpdate(){
		if (this.lastUpdater == null || this.lastUpdater.id == null){
			User user = UserUtils.getUser();
			this.lastUpdater = user;
		}
		this.lastUpdateTime = new Date();
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public Oper getOper() {
		return oper;
	}

	public void setOper(Oper oper) {
		this.oper = oper;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

	public boolean isPub() {
		return isPub;
	}

	public void setPub(boolean isPub) {
		this.isPub = isPub;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getLastUpdater() {
		return lastUpdater;
	}

	public void setLastUpdater(User lastUpdater) {
		this.lastUpdater = lastUpdater;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	public String getSpyj() {
		return spyj;
	}

	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}

	public Integer getApproveType() {
		return approveType;
	}

	public void setApproveType(Integer approveType) {
		this.approveType = approveType;
	}
	

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Integer getSfBg() {
		return sfBg;
	}

	public Integer getSfQx() {
		return sfQx;
	}

	public void setSfBg(Integer sfBg) {
		this.sfBg = sfBg;
	}

	public void setSfQx(Integer sfQx) {
		this.sfQx = sfQx;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
