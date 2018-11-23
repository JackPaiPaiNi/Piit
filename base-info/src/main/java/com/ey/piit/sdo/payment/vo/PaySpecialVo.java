package com.ey.piit.sdo.payment.vo;

import java.util.List;

import com.ey.piit.sdo.payment.entity.PaySpecial;
import com.google.common.collect.Lists;

/**
 * 特批查询Entity
 * @author 田荣
 */
public class PaySpecialVo extends PaySpecial {
	
	private String stpsj;// 特批时间
	private String etpsj;// 特批时间
	private String gsbm;
	private String xsymc;
	private String piid;//pi号
	

	private List<PaySpecialItemVo> itemList = Lists.newArrayList();// 子表列表
	
	public PaySpecialVo() {
		super();
	}

	public PaySpecialVo(String id){
		super(id);
	}

	public String getStpsj() {
		return stpsj;
	}

	public void setStpsj(String stpsj) {
		this.stpsj = stpsj;
	}

	public String getEtpsj() {
		return etpsj;
	}

	public void setEtpsj(String etpsj) {
		this.etpsj = etpsj;
	}

	public List<PaySpecialItemVo> getItemList() {
		return itemList;
	}

	public void setItemList(List<PaySpecialItemVo> itemList) {
		this.itemList = itemList;
	}

	public String getGsbm() {
		return gsbm;
	}

	public String getXsymc() {
		return xsymc;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public void setXsymc(String xsymc) {
		this.xsymc = xsymc;
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}
	
}