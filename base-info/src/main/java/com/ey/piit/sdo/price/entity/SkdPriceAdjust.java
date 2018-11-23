package com.ey.piit.sdo.price.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SKD调价单明细实体
 * @author 邓海
 */
public class SkdPriceAdjust extends BaseEntity {

	private String tjdid;//调价单号
	private String ddid;//订单号
	private String chdh;//出货通知书单号
	private BigDecimal ddzje;//订单总金额
	private BigDecimal zje;//总金额
	private String zdrid;//制单人
	private String zdrmc;//制单人
	private Date zdsj;//制单时间
	private Integer zt;//状态
	private String sjc;//时间戳
	private String bz;//币种
	private String khbm;//客户编码
	private String khmc;//客户名称
	private String ztmc;//状态名称
	
	public SkdPriceAdjust() {
		super();
	}

	public SkdPriceAdjust(String id){
		super(id);
	}

	public String getTjdid() {
		return tjdid;
	}

	public void setTjdid(String tjdid) {
		this.tjdid = tjdid;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public BigDecimal getDdzje() {
		return ddzje;
	}

	public void setDdzje(BigDecimal ddzje) {
		this.ddzje = ddzje;
	}

	public BigDecimal getZje() {
		return zje;
	}

	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}

	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getKhbm() {
		return khbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}


}