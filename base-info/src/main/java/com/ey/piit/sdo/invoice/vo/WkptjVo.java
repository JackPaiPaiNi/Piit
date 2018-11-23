package com.ey.piit.sdo.invoice.vo;

import com.ey.piit.sdo.deliver.entity.Deliver;

/**
 * 未开票统计
 * @author tianrong
 */
public class WkptjVo extends Deliver {
	private String ztmc;//状态名称
	private String ddid;//订单号
	private String jhdh;//交货单号
	private String yzhdh;//预走货单号
	private String beginZdsj;//开始制单时间
	private String endZdsj;  // 结束制单时间
	private String chztmc;//出货通知书状态
	
	public WkptjVo() {
		super();
	}

	public WkptjVo(String id){
		super(id);
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getJhdh() {
		return jhdh;
	}

	public void setJhdh(String jhdh) {
		this.jhdh = jhdh;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
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

	public String getChztmc() {
		return chztmc;
	}

	public void setChztmc(String chztmc) {
		this.chztmc = chztmc;
	}
	
}