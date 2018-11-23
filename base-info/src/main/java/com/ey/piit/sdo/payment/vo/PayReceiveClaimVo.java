package com.ey.piit.sdo.payment.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ey.piit.sdo.payment.entity.PayReceiveClaim;

/**
 * 收款认领Entity
 * @author 邓海
 */
public class PayReceiveClaimVo extends PayReceiveClaim {
	
	private List<PayReceiveClaimVo> list = new ArrayList<PayReceiveClaimVo>();
	private String beginZdsj;		// 开始认领 时间
	private String endZdsj;		// 结束 认领时间
	private String rows;//审批时批量组装行记录
	private BigDecimal syed;//剩余额度
	
	private String edbz;		// 认领币种
	private BigDecimal edsyed;		// 剩余额度（认领币种）
	private BigDecimal hl;		// 汇率
	private Integer type;//冻结和解冻类型 1：冻结； 2：解冻
	private BigDecimal zje;//总金额
	private String fktj;//付款条件
	private String fktjmc;//付款条件名称
	

	public PayReceiveClaimVo() {
		super();
	}

	public PayReceiveClaimVo(String id){
		super(id);
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

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public List<PayReceiveClaimVo> getList() {
		return list;
	}

	public void setList(List<PayReceiveClaimVo> list) {
		this.list = list;
	}

	public String getEdbz() {
		return edbz;
	}

	public void setEdbz(String edbz) {
		this.edbz = edbz;
	}

	public BigDecimal getSyed() {
		return syed;
	}

	public void setSyed(BigDecimal syed) {
		this.syed = syed;
	}

	public BigDecimal getEdsyed() {
		return edsyed;
	}

	public void setEdsyed(BigDecimal edsyed) {
		this.edsyed = edsyed;
	}

	public BigDecimal getHl() {
		return hl;
	}

	public void setHl(BigDecimal hl) {
		this.hl = hl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getZje() {
		return zje;
	}

	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}

	public String getFktj() {
		return fktj;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public String getFktjmc() {
		return fktjmc;
	}

	public void setFktjmc(String fktjmc) {
		this.fktjmc = fktjmc;
	}
	
}