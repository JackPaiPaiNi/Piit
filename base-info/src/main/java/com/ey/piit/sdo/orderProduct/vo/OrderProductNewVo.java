package com.ey.piit.sdo.orderProduct.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.ey.piit.sdo.order.vo.OrderBgmxVo;
import com.ey.piit.sdo.order.vo.OrderLogVo;
import com.ey.piit.sdo.order.vo.OrderProductCkdVo;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;
import com.ey.piit.sdo.orderProduct.entity.OrderProductNew;
import com.google.common.collect.Lists;

/**
 * 大货订单管理Entity
 * @author 魏诚
 */
public class OrderProductNewVo extends OrderProductNew implements Serializable {
	
	private static final long serialVersionUID = 6264083094062050200L;
	
	private List<OrderReferPiVo> orderReferPiList = Lists.newArrayList();		    // 子表列表
	private List<OrderProductCkdVo> wycCkdList = Lists.newArrayList();		            // 子表列表
	private List<OrderProductCkdVo> yycCkdList = Lists.newArrayList();		            //已移除ckdlist
	private List<OrderLogVo> logList = Lists.newArrayList();		            //订单日志
	private List<OrderBgmxVo> bgmxList = Lists.newArrayList();		            //变更明细
	
	// ckd物料清单查询使用
	private Integer sfYc;
	private String wlbm;
	private String ms;
	private String ztmc;
	private String   beginZdsj;
	private String   endZdsj ;
	private String beginJhrq;
	private String endJhrq;
	// 审批流使用 字段
	private Integer sfjp;
	private Integer sftjbhr;//是否提交到驳回人
	private Integer slje;//修改数量还是金额
	private String lccpjl;//用于流程选择产品经理
	private String lccpjlmc;//产品经理名称
	private String dzgcs;//电子设计师ID
	private String dygcs;//电源设计师ID
	private String jggcs;//结构设计师ID
	private Integer type;//1取消 2撤回
	private String qxbz; //取消备注
	private String wlmc;//网络名称
	private String isRestart;	//是否重选开始，1：是， 0：否
	private String piid; // PI号
	private Integer rwdtype;
	
	private BigDecimal yjbl;
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

	public String getBeginJhrq() {
		return beginJhrq;
	}

	public String getEndJhrq() {
		return endJhrq;
	}

	public void setBeginJhrq(String beginJhrq) {
		this.beginJhrq = beginJhrq;
	}

	public void setEndJhrq(String endJhrq) {
		this.endJhrq = endJhrq;
	}

	public String getWlbm() {
		return wlbm;
	}

	public void setWlbm(String wlbm) {
		this.wlbm = wlbm;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public Integer getSfYc() {
		return sfYc;
	}

	public void setSfYc(Integer sfYc) {
		this.sfYc = sfYc;
	}

	public OrderProductNewVo() {
		super();
	}
	
	public List<OrderProductCkdVo> getYycCkdList() {
		return yycCkdList;
	}

	public void setYycCkdList(List<OrderProductCkdVo> yycCkdList) {
		this.yycCkdList = yycCkdList;
	}

	public List<OrderProductCkdVo> getWycCkdList() {
		return wycCkdList;
	}

	public void setWycCkdList(List<OrderProductCkdVo> wycCkdList) {
		this.wycCkdList = wycCkdList;
	}

	public OrderProductNewVo(String id){
		super(id);
	}

	public List<OrderReferPiVo> getOrderReferPiList() {
		return orderReferPiList;
	}

	public void setOrderReferPiList(List<OrderReferPiVo> orderReferPiList) {
		this.orderReferPiList = orderReferPiList;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public List<OrderLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<OrderLogVo> logList) {
		this.logList = logList;
	}

	public Integer getSfjp() {
		return sfjp;
	}

	public void setSfjp(Integer sfjp) {
		this.sfjp = sfjp;
	}

	public Integer getSftjbhr() {
		return sftjbhr;
	}

	public void setSftjbhr(Integer sftjbhr) {
		this.sftjbhr = sftjbhr;
	}

	public List<OrderBgmxVo> getBgmxList() {
		return bgmxList;
	}

	public void setBgmxList(List<OrderBgmxVo> bgmxList) {
		this.bgmxList = bgmxList;
	}

	public Integer getSlje() {
		return slje;
	}

	public void setSlje(Integer slje) {
		this.slje = slje;
	}

	public String getLccpjl() {
		return lccpjl;
	}

	public void setLccpjl(String lccpjl) {
		this.lccpjl = lccpjl;
	}

	public String getLccpjlmc() {
		return lccpjlmc;
	}

	public void setLccpjlmc(String lccpjlmc) {
		this.lccpjlmc = lccpjlmc;
	}

	public String getDzgcs() {
		return dzgcs;
	}

	public String getDygcs() {
		return dygcs;
	}

	public String getJggcs() {
		return jggcs;
	}

	public void setDzgcs(String dzgcs) {
		this.dzgcs = dzgcs;
	}

	public void setDygcs(String dygcs) {
		this.dygcs = dygcs;
	}

	public void setJggcs(String jggcs) {
		this.jggcs = jggcs;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getQxbz() {
		return qxbz;
	}

	public void setQxbz(String qxbz) {
		this.qxbz = qxbz;
	}

	public String getWlmc() {
		return wlmc;
	}

	public void setWlmc(String wlmc) {
		this.wlmc = wlmc;
	}

	public String getIsRestart() {
		return isRestart;
	}

	public void setIsRestart(String isRestart) {
		this.isRestart = isRestart;
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public Integer getRwdtype() {
		return rwdtype;
	}

	public void setRwdtype(Integer rwdtype) {
		this.rwdtype = rwdtype;
	}

	public BigDecimal getYjbl() {
		return yjbl;
	}

	public void setYjbl(BigDecimal yjbl) {
		this.yjbl = yjbl;
	}
	
	
}