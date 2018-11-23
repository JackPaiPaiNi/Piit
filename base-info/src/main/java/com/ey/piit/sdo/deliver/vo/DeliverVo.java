package com.ey.piit.sdo.deliver.vo;

import java.math.BigDecimal;
import java.util.List;

import com.ey.piit.sdo.deliver.entity.Deliver;
import com.ey.piit.sdo.pso.vo.PsoNotifyVo;
import com.ey.piit.sdo.pso.vo.PsoOtherVo;
import com.google.common.collect.Lists;

/**
 * 出货通知书Entity
 * @author 魏诚
 */
public class DeliverVo extends Deliver {

	private List<DeliverItemVo> deliverItemList = Lists.newArrayList();		// 子表列表
	private List<DeliverExhibitionVo> deliverExhibitionList = Lists.newArrayList();		// 子表列表
	private List<PsoOtherVo> deliverOtherList = Lists.newArrayList();		// 子表列表
	private List<DeliverCostVo> deliverCostList = Lists.newArrayList();		// 子表列表
	private String ztmc ;
	private String gsywmc;// 公司英文名称
	private String tssaplx ;//推送sap类型 1推送 2取消
	private Integer sfYfyj ;//是否已发邮件 0否 1是
	
	
	private String yzhdh;//用于查询
	private String ddid;//用于查询
	/*配合关务新增字段  魏诚  2018-05-24*/
	private String shfmc;		// 收货方名称
	private String shfdz;		// 收货方地址
	private String shflxr;		// 收货方联系人
	private String shfdh;		// 收货方电话
	private String shfcz;		// 收货方传真
	private String shfyb;		// 收货方邮编
	private String shfyx;		// 收货方邮箱
	private String shfdm;
	private String shrdh;
	private String aeoqybm;
	private List<PsoNotifyVo> notifyList = Lists.newArrayList();		// 子表列表
	
	public DeliverVo() {
		super();
	}

	public DeliverVo(String id){
		super(id);
	}

	public List<DeliverItemVo> getDeliverItemList() {
		return deliverItemList;
	}

	public String getZtmc() {
		return ztmc;
	}

	public String getGsywmc() {
		return gsywmc;
	}

	public void setDeliverItemList(List<DeliverItemVo> deliverItemList) {
		this.deliverItemList = deliverItemList;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public void setGsywmc(String gsywmc) {
		this.gsywmc = gsywmc;
	}

	public String getTssaplx() {
		return tssaplx;
	}

	public void setTssaplx(String tssaplx) {
		this.tssaplx = tssaplx;
	}

	public List<DeliverExhibitionVo> getDeliverExhibitionList() {
		return deliverExhibitionList;
	}

	public void setDeliverExhibitionList(
			List<DeliverExhibitionVo> deliverExhibitionList) {
		this.deliverExhibitionList = deliverExhibitionList;
	}

	public Integer getSfYfyj() {
		return sfYfyj;
	}

	public void setSfYfyj(Integer sfYfyj) {
		this.sfYfyj = sfYfyj;
	}

	public List<DeliverCostVo> getDeliverCostList() {
		return deliverCostList;
	}

	public void setDeliverCostList(List<DeliverCostVo> deliverCostList) {
		this.deliverCostList = deliverCostList;
	}

	public List<PsoOtherVo> getDeliverOtherList() {
		return deliverOtherList;
	}

	public void setDeliverOtherList(List<PsoOtherVo> deliverOtherList) {
		this.deliverOtherList = deliverOtherList;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getShfmc() {
		return shfmc;
	}

	public void setShfmc(String shfmc) {
		this.shfmc = shfmc;
	}

	public String getShfdz() {
		return shfdz;
	}

	public void setShfdz(String shfdz) {
		this.shfdz = shfdz;
	}

	public String getShflxr() {
		return shflxr;
	}

	public void setShflxr(String shflxr) {
		this.shflxr = shflxr;
	}

	public String getShfdh() {
		return shfdh;
	}

	public void setShfdh(String shfdh) {
		this.shfdh = shfdh;
	}

	public String getShfcz() {
		return shfcz;
	}

	public void setShfcz(String shfcz) {
		this.shfcz = shfcz;
	}

	public String getShfyb() {
		return shfyb;
	}

	public void setShfyb(String shfyb) {
		this.shfyb = shfyb;
	}

	public String getShfyx() {
		return shfyx;
	}

	public void setShfyx(String shfyx) {
		this.shfyx = shfyx;
	}

	public String getShfdm() {
		return shfdm;
	}

	public void setShfdm(String shfdm) {
		this.shfdm = shfdm;
	}

	public String getShrdh() {
		return shrdh;
	}

	public void setShrdh(String shrdh) {
		this.shrdh = shrdh;
	}

	public String getAeoqybm() {
		return aeoqybm;
	}

	public void setAeoqybm(String aeoqybm) {
		this.aeoqybm = aeoqybm;
	}

	public List<PsoNotifyVo> getNotifyList() {
		return notifyList;
	}

	public void setNotifyList(List<PsoNotifyVo> notifyList) {
		this.notifyList = notifyList;
	}
	
}