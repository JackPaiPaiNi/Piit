package com.ey.piit.sdo.deliver.entity;

import java.math.BigDecimal;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 出货通知书费用明细Entity
 * @author 邓海
 */
public class DeliverCost extends BaseEntity {
	
	private String yzhdh;		// 预走货单号 父类
	private Integer bbh;		// 版本号
	private String qtxmmc;		// 其他项目名称
	private String qtxm;		// 其他项目
	private String yt;		// 用途
	private String bz;		// 币种
	private BigDecimal je;		// 金额
	private String skdh;		//收款单号
	public String getYzhdh() {
		return yzhdh;
	}
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	public Integer getBbh() {
		return bbh;
	}
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public BigDecimal getJe() {
		return je;
	}
	public void setJe(BigDecimal je) {
		this.je = je;
	}
	
	public String getQtxmmc() {
		return qtxmmc;
	}
	public void setQtxmmc(String qtxmmc) {
		this.qtxmmc = qtxmmc;
	}
	public String getYt() {
		return yt;
	}
	public void setYt(String yt) {
		this.yt = yt;
	}
	public String getSkdh() {
		return skdh;
	}
	public void setSkdh(String skdh) {
		this.skdh = skdh;
	}
	public String getQtxm() {
		return qtxm;
	}
	public void setQtxm(String qtxm) {
		this.qtxm = qtxm;
	}
	
}