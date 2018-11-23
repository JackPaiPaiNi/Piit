package com.ey.piit.sdo.pso.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 预走货Entity
 * @author 赵桃军
 */
public class PsoOther extends BaseEntity {
	
	private String yzhdh;		// 预走货单号 父类
	private Integer bbh;		// 版本号
	private String qtxm;		// 其他项目
	private String qtxmmc;		// 其他项目名称
	private String bz;		// 币种
	private String yt;		// 用途
	private BigDecimal je;		// 金额
	private String skdh;		// 收款单号
	
	public PsoOther() {
		super();
	}

	public PsoOther(String id){
		super(id);
	}


	/**
     * 预走货单号
     */
	@Length(min=1, max=20, message="预走货单号长度必须介于 1 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	
	/**
     * 版本号
     */
	@NotNull(message="版本号不能为空")
	public Integer getBbh() {
		return bbh;
	}

	/**
     * 版本号
     */
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}
	
	/**
     * 其他项目
     */
	@Length(min=0, max=20, message="其他项目长度必须介于 0 和 20 之间")
	public String getQtxm() {
		return qtxm;
	}

	/**
     * 其他项目
     */
	public void setQtxm(String qtxm) {
		this.qtxm = qtxm == null ? null : qtxm.trim();
	}
	
	/**
     * 其他项目名称
     */
	@Length(min=0, max=50, message="其他项目名称长度必须介于 0 和 50 之间")
	public String getQtxmmc() {
		return qtxmmc;
	}

	/**
     * 其他项目名称
     */
	public void setQtxmmc(String qtxmmc) {
		this.qtxmmc = qtxmmc == null ? null : qtxmmc.trim();
	}
	
	/**
     * 币种
     */
	@Length(min=0, max=20, message="币种长度必须介于 0 和 20 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 币种
     */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}
	
	/**
     * 用途
     */
	@Length(min=0, max=100, message="用途长度必须介于 0 和 100 之间")
	public String getYt() {
		return yt;
	}

	/**
     * 用途
     */
	public void setYt(String yt) {
		this.yt = yt == null ? null : yt.trim();
	}
	
	
	
	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	/**
     * 收款单号
     */
	@Length(min=0, max=50, message="收款单号长度必须介于 0 和 50 之间")
	public String getSkdh() {
		return skdh;
	}

	/**
     * 收款单号
     */
	public void setSkdh(String skdh) {
		this.skdh = skdh == null ? null : skdh.trim();
	}
	
}