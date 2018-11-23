package com.ey.piit.sdo.saprebate.vo;

import java.util.List;

import com.ey.piit.sdo.saprebate.entity.Title;
import com.ey.piit.sdo.sapspecial.vo.SapApproveLogVo;
import com.google.common.collect.Lists;

/**
 * sap费用审批Entity
 * 
 * @author 赵桃军
 */
public class TitleVo extends Title {
	
	
	private ExpensesApplyVo  expApply  ;//费用申请明细
	
	private List<RebateApplyVo> rbtApplyList = Lists.newArrayList();   // 返利申请明细表
	
	private List<RebatePolicyVo> rbpPolicyList = Lists.newArrayList();  // 返利政策明细表
	
	private List<SapApproveLogVo> logList = Lists.newArrayList();      //  审批日志明细表
	
    private String  type; // 审批类型
	
	private String  zdrid; //制单人id
    
	private String  zdrmc; //制单人名称
	
	private String  zdsj ; //制单人名称
	
	private String  nr   ; //内容
	
	private String  beginZdsj ; //开始提交时间
	
	private String  endZdsj ; //开始提交时间
	
	private String sjc; // 时间戳
	
	private Integer zt; // 状态
	
	private String ztmc; // 状态名称
	
	private int sfhx;  //是否有后续节点
	
	private String flsbh ;//返利申报号
	
	private String flzch; //返利政策号
	
	
	
	
	

	public String getFlsbh() {
		return flsbh;
	}

	public void setFlsbh(String flsbh) {
		this.flsbh = flsbh;
	}

	public String getFlzch() {
		return flzch;
	}

	public void setFlzch(String flzch) {
		this.flzch = flzch;
	}

	public int getSfhx() {
		return sfhx;
	}

	public void setSfhx(int sfhx) {
		this.sfhx = sfhx;
	}

	public ExpensesApplyVo getExpApply() {
		return expApply;
	}

	public void setExpApply(ExpensesApplyVo expApply) {
		this.expApply = expApply;
	}

	public List<RebateApplyVo> getRbtApplyList() {
		return rbtApplyList;
	}

	public void setRbtApplyList(List<RebateApplyVo> rbtApplyList) {
		this.rbtApplyList = rbtApplyList;
	}

	
	public List<RebatePolicyVo> getRbpPolicyList() {
		return rbpPolicyList;
	}

	public void setRbpPolicyList(List<RebatePolicyVo> rbpPolicyList) {
		this.rbpPolicyList = rbpPolicyList;
	}

	public List<SapApproveLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<SapApproveLogVo> logList) {
		this.logList = logList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}

	public String getZdsj() {
		return zdsj;
	}

	public void setZdsj(String zdsj) {
		this.zdsj = zdsj;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getBeginZdsj() {
		return beginZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}


}