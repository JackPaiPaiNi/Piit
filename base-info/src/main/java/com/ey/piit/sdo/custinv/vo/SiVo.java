package com.ey.piit.sdo.custinv.vo;

import java.util.List;

import com.ey.piit.sdo.custinv.entity.SiRegEntity;
import com.google.common.collect.Lists;

/**
 * @author: junc
 * @date: 2018年6月29日 上午10:47:23
 * @Description: 发货指令
 */
public class SiVo extends SiRegEntity {
	private List<SiItemVo> siItemList = Lists.newArrayList();
	//主页查询条件
	private String schdh;// 出货通知书单号
	private String sfph;// 发票号
	private String so_no;// 订舱号
	private String gh;// 柜号
	private String consignee;// 收货人
	private String startCjrq;// 开始创建日期
	private String endCjrq;// 结束创建日期
	
	private Double sumKbzl;	//卡板总重量
	private Double sumKbtj;	//卡板总体积
	private Double sumVgm;	//总VGM
	private Double sumZxsl;	//纸箱总数量
	private Double sumKbsl;	//卡板总数量
	
	public String getSchdh() {
		return schdh;
	}

	public void setSchdh(String schdh) {
		this.schdh = schdh;
	}

	public String getSfph() {
		return sfph;
	}

	public void setSfph(String sfph) {
		this.sfph = sfph;
	}

	public String getSo_no() {
		return so_no;
	}

	public void setSo_no(String so_no) {
		this.so_no = so_no;
	}

	public String getGh() {
		return gh;
	}

	public void setGh(String gh) {
		this.gh = gh;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getStartCjrq() {
		return startCjrq;
	}

	public void setStartCjrq(String startCjrq) {
		this.startCjrq = startCjrq;
	}

	public String getEndCjrq() {
		return endCjrq;
	}

	public void setEndCjrq(String endCjrq) {
		this.endCjrq = endCjrq;
	}

	public List<SiItemVo> getSiItemList() {
		return siItemList;
	}

	public void setSiItemList(List<SiItemVo> siItemList) {
		this.siItemList = siItemList;
	}

	public SiVo() {
		// TODO Auto-generated constructor stub
		super();
	}

	public SiVo(String id) {
		// TODO Auto-generated constructor stub
		super(id);
	}

	public Double getSumKbzl() {
		return sumKbzl;
	}

	public void setSumKbzl(Double sumKbzl) {
		this.sumKbzl = sumKbzl;
	}

	public Double getSumKbtj() {
		return sumKbtj;
	}

	public void setSumKbtj(Double sumKbtj) {
		this.sumKbtj = sumKbtj;
	}

	public Double getSumVgm() {
		return sumVgm;
	}

	public void setSumVgm(Double sumVgm) {
		this.sumVgm = sumVgm;
	}

	public Double getSumZxsl() {
		return sumZxsl;
	}

	public void setSumZxsl(Double sumZxsl) {
		this.sumZxsl = sumZxsl;
	}

	public Double getSumKbsl() {
		return sumKbsl;
	}

	public void setSumKbsl(Double sumKbsl) {
		this.sumKbsl = sumKbsl;
	}
}
