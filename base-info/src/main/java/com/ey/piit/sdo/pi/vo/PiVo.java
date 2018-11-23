package com.ey.piit.sdo.pi.vo;

import com.ey.piit.sdo.pi.entity.Pi;
import java.util.List;
import com.google.common.collect.Lists;

/**
 * PI管理Entity
 * @author 王歌
 */
public class PiVo extends Pi {

	private List<PiItemVo> piItemList = Lists.newArrayList();		// 子表列表
	private List<PiLogVo> logList = Lists.newArrayList();		// 日志子表列表
	private Double xyedye;	// 信用额度余额
	private Integer sfDyhpi;	// 是否多元化PI
	private String englishNumber;//英文数值
	private Double ttYbdje;	//tt已绑定金额
	private Double lcYbd;	//lc已绑定金额
	private String khlx;	//客户类型
	private String  ztmc ;
	private String khfl;	//客户分类（是否LG客户）
	private String smoshr;	//SMO审核人
	private String xdLc ;
	private String lcbh;//lc编号 PI绑定付款保障查询条件
	private String rldh;//认领单号 PI绑定付款保障查询条件
	
	
	

	public String getXdLc() {
		return xdLc;
	}

	public void setXdLc(String xdLc) {
		this.xdLc = xdLc;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public PiVo() {
		super();
	}

	public PiVo(String id){
		super(id);
	}
	public List<PiItemVo> getPiItemList() {
		return piItemList;
	}

	public void setPiItemList(List<PiItemVo> piItemList) {
		this.piItemList = piItemList;
	}

	public Double getXyedye() {
		return xyedye;
	}

	public void setXyedye(Double xyedye) {
		this.xyedye = xyedye;
	}

	public Integer getSfDyhpi() {
		return sfDyhpi;
	}

	public void setSfDyhpi(Integer sfDyhpi) {
		this.sfDyhpi = sfDyhpi;
	}

	public List<PiLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<PiLogVo> logList) {
		this.logList = logList;
	}

	public String getEnglishNumber() {
		return englishNumber;
	}

	public void setEnglishNumber(String englishNumber) {
		this.englishNumber = englishNumber;
	}

	public Double getTtYbdje() {
		return ttYbdje;
	}

	public Double getLcYbd() {
		return lcYbd;
	}

	public void setTtYbdje(Double ttYbdje) {
		this.ttYbdje = ttYbdje;
	}

	public void setLcYbd(Double lcYbd) {
		this.lcYbd = lcYbd;
	}

	public String getKhlx() {
		return khlx;
	}

	public void setKhlx(String khlx) {
		this.khlx = khlx;
	}

	public String getKhfl() {
		return khfl;
	}

	public void setKhfl(String khfl) {
		this.khfl = khfl;
	}

	public String getSmoshr() {
		return smoshr;
	}

	public void setSmoshr(String smoshr) {
		this.smoshr = smoshr;
	}

	public String getLcbh() {
		return lcbh;
	}

	public void setLcbh(String lcbh) {
		this.lcbh = lcbh;
	}

	public String getRldh() {
		return rldh;
	}

	public void setRldh(String rldh) {
		this.rldh = rldh;
	}
	
}