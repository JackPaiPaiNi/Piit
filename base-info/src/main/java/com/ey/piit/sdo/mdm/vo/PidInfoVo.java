package com.ey.piit.sdo.mdm.vo;

import java.util.List;

import com.ey.piit.sdo.mdm.entity.PidInfo;
import com.google.common.collect.Lists;

/**
 * PID信息维护Entity
 * @author 高文浩
 */
public class PidInfoVo extends PidInfo {

    private String ms ; 
    private List<PidInfoLogVo> logList = Lists.newArrayList();		            //PID日志
    private String ztmc;		// 状态名称
    private String jggcsbz ;    //结构工程师备注
    private String gc;//工厂
    private String sb;//商标
    private String cpmc;//产品名称
    private String khxh;//客户型号
    private String zzs;//制造商
    private String wifixh;//wifi型号
    private String zbzjh;//主板组件号
    private String tsxq;//特殊需求
    private String tjryj;//提交人意见
    private String cjrmc;	//创建人名称
 
	public String getJggcsbz() {
		return jggcsbz;
	}

	public void setJggcsbz(String jggcsbz) {
		this.jggcsbz = jggcsbz;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public PidInfoVo() {
		super();
	}

	public PidInfoVo(String id){
		super(id);
	}

	public List<PidInfoLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<PidInfoLogVo> logList) {
		this.logList = logList;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getGc() {
		return gc;
	}

	public void setGc(String gc) {
		this.gc = gc;
	}

	public String getSb() {
		return sb;
	}

	public void setSb(String sb) {
		this.sb = sb;
	}

	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	public String getKhxh() {
		return khxh;
	}

	public void setKhxh(String khxh) {
		this.khxh = khxh;
	}

	public String getZzs() {
		return zzs;
	}

	public void setZzs(String zzs) {
		this.zzs = zzs;
	}

	public String getWifixh() {
		return wifixh;
	}

	public void setWifixh(String wifixh) {
		this.wifixh = wifixh;
	}

	public String getZbzjh() {
		return zbzjh;
	}

	public void setZbzjh(String zbzjh) {
		this.zbzjh = zbzjh;
	}

	public String getTsxq() {
		return tsxq;
	}

	public void setTsxq(String tsxq) {
		this.tsxq = tsxq;
	}

	public String getTjryj() {
		return tjryj;
	}

	public void setTjryj(String tjryj) {
		this.tjryj = tjryj;
	}

	public String getCjrmc() {
		return cjrmc;
	}

	public void setCjrmc(String cjrmc) {
		this.cjrmc = cjrmc;
	}
	

}