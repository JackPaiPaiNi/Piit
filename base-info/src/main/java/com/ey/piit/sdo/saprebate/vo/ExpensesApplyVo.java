package com.ey.piit.sdo.saprebate.vo;

import java.util.List;

import com.ey.piit.sdo.saprebate.entity.ExpensesApply;
import com.ey.piit.sdo.sapspecial.vo.SapApproveLogVo;

/**
 * sap费用审批Entity
 * @author 赵桃军
 */
public class ExpensesApplyVo extends ExpensesApply {

	
	
	private  List<SapApproveLogVo> logList ;
	public ExpensesApplyVo() {
		super();
	}

	public ExpensesApplyVo(String id){
		super(id);
	}
	public List<SapApproveLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<SapApproveLogVo> logList) {
		this.logList = logList;
	}

}