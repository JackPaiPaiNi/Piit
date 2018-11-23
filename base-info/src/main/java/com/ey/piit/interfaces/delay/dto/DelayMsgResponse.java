package com.ey.piit.interfaces.delay.dto;


public class DelayMsgResponse {
	private String gsbm = "";// 公司编码
	private String khbm = "";// 客户编码
	private String fph ="";// 发票号
	private Double je = 0.0;// 金额
	private String fktj = "";// 付款条件
	private Integer cqts = 0;// 超期天数
	private String sfzc = "";// 是否为最长

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

	public String getKhbm() {
		return khbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public Double getJe() {
		return je;
	}

	public void setJe(Double je) {
		this.je = je;
	}

	public String getFktj() {
		return fktj;
	}

	public void setFktj(String fktj) {
		this.fktj = fktj;
	}

	public Integer getCqts() {
		return cqts;
	}

	public void setCqts(Integer cqts) {
		this.cqts = cqts;
	}

	public String getSfzc() {
		return sfzc;
	}

	public void setSfzc(String sfzc) {
		this.sfzc = sfzc;
	}

	@Override
	public String toString() {
		return "[公司编码=" + gsbm + ", 客户编码=" + khbm 
				 + ", 付款条件=" + fktj + ", 超期天数=" + cqts + ", 金额=" + je +"]";
	}
	

}
