package com.ey.piit.sdo.pso.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.ey.piit.sdo.pso.entity.Pso;
import com.google.common.collect.Lists;

/**
 * 预走货Entity
 * @author 赵桃军
 */
public class PsoVo extends Pso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1185373672850409101L;
	private List<PsoItemVo> psoItemList = Lists.newArrayList();		// 子表列表
	private List<PsoPiVo> psoPiList = Lists.newArrayList();		// 子表列表
	private List<PsoNotifyVo> psoNotifyList = Lists.newArrayList();		// 子表列表
	private List<PsoOtherVo> psoOtherList = Lists.newArrayList();		// 子表列表
	private List<PsoExhibitionVo> psoExhibitionList = Lists.newArrayList();		// 子表列表
	private List<PsoLogVo> logList = Lists.newArrayList();		// 子表列表
	private String beginZdsj;
	private String endZdsj;
	private String ztmc;		// 状态名称
	private Integer sfDyhyzh;	// 是否多元化预走货
	private Integer sfZtyzh;	// 是否主体预走货
	private String sfRestart1;
	private String sfRestart2;
	private String dcdh;	//订舱单号
	private String khlx;	//客户类型
	private Integer sfCybl;	// 是否储运进行补录
	private String ddid;    //订单id（pso界面查询条件用）
	private Double mxzsl; //明细总数量
	private BigDecimal mxzje;//明细总金额
	private Double mxzjs;//明细总件数
	private Integer sfDc;//是否订舱
	private Integer sfCh;//是否出货
	private String yjcwzyid;	//需发邮件的船务专员ID
	private String yjcwzymc;	//需发邮件的船务专员名称
	private String sfChehui;	//是否撤回
	private String piid;	//PI号
	private Integer smozt;	//SMO SOS MCO审核状态
	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
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

	public PsoVo() {
		super();
	}

	public PsoVo(String id){
		super(id);
	}
	
	public List<PsoItemVo> getPsoItemList() {
		return psoItemList;
	}

	public void setPsoItemList(List<PsoItemVo> psoItemList) {
		this.psoItemList = psoItemList;
	}
	
	public List<PsoPiVo> getPsoPiList() {
		return psoPiList;
	}

	public void setPsoPiList(List<PsoPiVo> psoPiList) {
		this.psoPiList = psoPiList;
	}

	public List<PsoNotifyVo> getPsoNotifyList() {
		return psoNotifyList;
	}

	public void setPsoNotifyList(List<PsoNotifyVo> psoNotifyList) {
		this.psoNotifyList = psoNotifyList;
	}
	
	public List<PsoOtherVo> getPsoOtherList() {
		return psoOtherList;
	}

	public void setPsoOtherList(List<PsoOtherVo> psoOtherList) {
		this.psoOtherList = psoOtherList;
	}

	public String getSfRestart1() {
		return sfRestart1;
	}

	public String getSfRestart2() {
		return sfRestart2;
	}

	public void setSfRestart1(String sfRestart1) {
		this.sfRestart1 = sfRestart1;
	}

	public void setSfRestart2(String sfRestart2) {
		this.sfRestart2 = sfRestart2;
	}

	public Integer getSfDyhyzh() {
		return sfDyhyzh;
	}

	public void setSfDyhyzh(Integer sfDyhyzh) {
		this.sfDyhyzh = sfDyhyzh;
	}

	public List<PsoLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<PsoLogVo> logList) {
		this.logList = logList;
	}

	public Integer getSfZtyzh() {
		return sfZtyzh;
	}

	public void setSfZtyzh(Integer sfZtyzh) {
		this.sfZtyzh = sfZtyzh;
	}

	public List<PsoExhibitionVo> getPsoExhibitionList() {
		return psoExhibitionList;
	}

	public void setPsoExhibitionList(List<PsoExhibitionVo> psoExhibitionList) {
		this.psoExhibitionList = psoExhibitionList;
	}

	public String getDcdh() {
		return dcdh;
	}

	public void setDcdh(String dcdh) {
		this.dcdh = dcdh;
	}

	public String getKhlx() {
		return khlx;
	}

	public void setKhlx(String khlx) {
		this.khlx = khlx;
	}

	public Integer getSfCybl() {
		return sfCybl;
	}

	public void setSfCybl(Integer sfCybl) {
		this.sfCybl = sfCybl;
	}

	public Double getMxzsl() {
		return mxzsl;
	}

	public void setMxzsl(Double mxzsl) {
		this.mxzsl = mxzsl;
	}

	public Double getMxzjs() {
		return mxzjs;
	}

	public void setMxzjs(Double mxzjs) {
		this.mxzjs = mxzjs;
	}

	public Integer getSfDc() {
		return sfDc;
	}

	public void setSfDc(Integer sfDc) {
		this.sfDc = sfDc;
	}

	public Integer getSfCh() {
		return sfCh;
	}

	public void setSfCh(Integer sfCh) {
		this.sfCh = sfCh;
	}

	public BigDecimal getMxzje() {
		return mxzje;
	}

	public void setMxzje(BigDecimal mxzje) {
		this.mxzje = mxzje;
	}

	public String getYjcwzyid() {
		return yjcwzyid;
	}

	public void setYjcwzyid(String yjcwzyid) {
		this.yjcwzyid = yjcwzyid;
	}

	public String getYjcwzymc() {
		return yjcwzymc;
	}

	public void setYjcwzymc(String yjcwzymc) {
		this.yjcwzymc = yjcwzymc;
	}

	public String getSfChehui() {
		return sfChehui;
	}

	public void setSfChehui(String sfChehui) {
		this.sfChehui = sfChehui;
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public Integer getSmozt() {
		return smozt;
	}

	public void setSmozt(Integer smozt) {
		this.smozt = smozt;
	}

}