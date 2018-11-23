package com.ey.piit.sdo.custinv.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;


/**
 * @author: 张钧俊
 * @Date: 2018年11月20日
 * @Description: 调价结果主表 T_PRICE_RESULT
 */
public class TjjgEntity extends BaseEntity {
	
	private String chdh;		// 出货单号
	private String ddid;		// 订单号
	private String khbm;		// 客户编码
	private String wlbh;		// 物料编码
	private String wlms;		// 物料描述（货描）
	private Integer sl;			// 数量
	private String dw;		    // 单位
	private String bz;		    // 币种
	private BigDecimal jgkdj;	//价格库单价
	private BigDecimal jgkje;	//价格库金额
	private Integer    notjbz;    //不可调价标志
	private Integer    recxbz;	  //多个订单重复物料标志
	private BigDecimal	tzdj;	 //调整单价
	private BigDecimal  tzje;	 //调整后金额
	private Integer     tjdx;	 //调价对象
	


	public TjjgEntity(){
		super();
	}
	
	public TjjgEntity(String id){
		super(id);
	}
	
	public String getChdh() {
		return chdh;
	}
	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getWlbh() {
		return wlbh;
	}
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}
	public String getWlms() {
		return wlms;
	}
	public void setWlms(String wlms) {
		this.wlms = wlms;
	}
	public Integer getSl() {
		return sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	/**
     * 单位（研发bom单位）
     */
	@Length(min=0, max=20, message="单位（研发bom单位）长度必须介于 0 和 20 之间")
	public String getDw() {
		return dw;
	}
	/**
     * 单位（研发bom单位）
     */
	public void setDw(String dw) {
		this.dw = dw == null ? null : dw.trim();
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
	public BigDecimal getJgkdj() {
		return jgkdj;
	}
	public void setJgkdj(BigDecimal jgkdj) {
		this.jgkdj = jgkdj;
	}
	public BigDecimal getJgkje() {
		return jgkje;
	}
	public void setJgkje(BigDecimal jgkje) {
		this.jgkje = jgkje;
	}
	public Integer getNotjbz() {
		return notjbz;
	}
	public void setNotjbz(Integer notjbz) {
		this.notjbz = notjbz;
	}
	public Integer getRecxbz() {
		return recxbz;
	}
	public void setRecxbz(Integer recxbz) {
		this.recxbz = recxbz;
	}
	public BigDecimal getTzdj() {
		return tzdj;
	}
	public void setTzdj(BigDecimal tzdj) {
		this.tzdj = tzdj;
	}
	public BigDecimal getTzje() {
		return tzje;
	}
	public void setTzje(BigDecimal tzje) {
		this.tzje = tzje;
	}
	public Integer getTjdx() {
		return tjdx;
	}

	public void setTjdx(Integer tjdx) {
		this.tjdx = tjdx;
	}

}
