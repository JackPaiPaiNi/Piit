package com.ey.piit.sdo.deliverplan.vo;
import java.util.ArrayList;
import java.util.List;

import com.ey.piit.sdo.deliverplan.entity.DeliverPlan;


/**
 * 走货计划单Entity
 * @author 邓海
 */
public class DeliverPlanVo extends DeliverPlan {
	
	private List<DeliverPlanItemVo> deliverPlanItemList = new ArrayList<DeliverPlanItemVo>();
	private String khbm;//客户编码
	private String ddid;
	private String yzhdh;
	private String zhjhdhs;//走货计划单号拼接字符串
	private String szgkssj;
	private String ezgjssj;
	public List<DeliverPlanItemVo> getDeliverPlanItemList() {
		return deliverPlanItemList;
	}

	public void setDeliverPlanItemList(
			List<DeliverPlanItemVo> deliverPlanItemList) {
		this.deliverPlanItemList = deliverPlanItemList;
	}

	public String getKhbm() {
		return khbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	public String getZhjhdhs() {
		return zhjhdhs;
	}

	public void setZhjhdhs(String zhjhdhs) {
		this.zhjhdhs = zhjhdhs;
	}

	public String getSzgkssj() {
		return szgkssj;
	}

	public void setSzgkssj(String szgkssj) {
		this.szgkssj = szgkssj;
	}

	public String getEzgjssj() {
		return ezgjssj;
	}

	public void setEzgjssj(String ezgjssj) {
		this.ezgjssj = ezgjssj;
	}
}