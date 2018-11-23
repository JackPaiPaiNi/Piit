package com.ey.piit.sdo.pso.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ey.piit.sdo.pso.entity.PsoItem;

/**
 * 预走货Entity
 * @author 赵桃军
 */
public class PsoItemVo extends PsoItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7792414168359864021L;
	private String piid; // PI号
	private String pilx; // PI类型
	private String pilxmc; // PI类型名称
	private BigDecimal ce;	//差额
	private String sfJsxf;	//单价*数量是否等于总价，误差0.0001，N不相等，Y相等

	public PsoItemVo() {
		super();
	}

	public PsoItemVo(String id){
		super(id);
	}

	public String getPiid() {
		return piid;
	}

	public String getPilx() {
		return pilx;
	}

	public String getPilxmc() {
		return pilxmc;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public void setPilx(String pilx) {
		this.pilx = pilx;
	}

	public void setPilxmc(String pilxmc) {
		this.pilxmc = pilxmc;
	}

	public BigDecimal getCe() {
		return ce;
	}

	public void setCe(BigDecimal ce) {
		this.ce = ce;
	}

	public String getSfJsxf() {
		return sfJsxf;
	}

	public void setSfJsxf(String sfJsxf) {
		this.sfJsxf = sfJsxf;
	}
	
}