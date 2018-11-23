package com.ey.piit.webservice.shipplan;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 走货计划接口Entity
 * @author 魏诚
 */
public class ShipPlanPojo implements Serializable {

	private static final long serialVersionUID = 3754073150787087093L;
	
	private String billNo;  //订单号
	private String shape; //形式
	private String size; //型号
	private String saleCountry; //销售国
	private Double qty; //订单量 （Double）
	private Double sjQty; //散件量 （Double）
	private String boatNo; //订舱号
	private String loadingPort; //起运港
	private Integer smallBox;  //20柜
	private Integer middleBox; //40GP
	private Integer bigBox; //40HQ
	private Date shipmentDate;//装货日期
	private Date closeDate; //截关期
	private Date cutVgm; //截VGM
	private Date cutSi; //截SI
	private String carrier; //拖车公司
	private String boatDocumentary; //船务跟单

	public ShipPlanPojo() {
		super();
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSaleCountry() {
		return saleCountry;
	}

	public void setSaleCountry(String saleCountry) {
		this.saleCountry = saleCountry;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getSjQty() {
		return sjQty;
	}

	public void setSjQty(Double sjQty) {
		this.sjQty = sjQty;
	}

	public String getBoatNo() {
		return boatNo;
	}

	public void setBoatNo(String boatNo) {
		this.boatNo = boatNo;
	}

	public String getLoadingPort() {
		return loadingPort;
	}

	public void setLoadingPort(String loadingPort) {
		this.loadingPort = loadingPort;
	}

	public Integer getSmallBox() {
		return smallBox;
	}

	public void setSmallBox(Integer smallBox) {
		this.smallBox = smallBox;
	}

	public Integer getMiddleBox() {
		return middleBox;
	}

	public void setMiddleBox(Integer middleBox) {
		this.middleBox = middleBox;
	}

	public Integer getBigBox() {
		return bigBox;
	}

	public void setBigBox(Integer bigBox) {
		this.bigBox = bigBox;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getCutVgm() {
		return cutVgm;
	}

	public void setCutVgm(Date cutVgm) {
		this.cutVgm = cutVgm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getCutSi() {
		return cutSi;
	}

	public void setCutSi(Date cutSi) {
		this.cutSi = cutSi;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getBoatDocumentary() {
		return boatDocumentary;
	}

	public void setBoatDocumentary(String boatDocumentary) {
		this.boatDocumentary = boatDocumentary;
	}

}