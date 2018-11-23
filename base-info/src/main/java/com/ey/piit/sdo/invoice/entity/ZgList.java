package com.ey.piit.sdo.invoice.entity;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 装柜清单Entity
 * @author tianrong
 */
public class ZgList extends BaseEntity {
	
	private String guino;    //柜号
	private String chdat;    //出货日期
	private String cftno;    //厂封
	private String zgdsn;    //装柜清单项目 自动按导入顺序+1
	private String bukrs;    //公司代码 申报的公司
	private String dcno;    //订舱号
	private String gxnam;    //柜型
	private String ftno;    //封条号
	private String tare;    //TARE
	private String sygs;    //运输公司
	private String fhnam;    //发货员 
	private String poter;    //港口
	private String cheno;    //车牌
	private String bynam;    //搬运工
	private String jctim;    //进厂时间
	private String cctim;    //出厂时间
	private String erdat;    //创建日期 新建时，自动抓取当前日期
	private String ertim;    //创建时间 新建时，自动抓取当前时间
	private String ernam;    //创建的用户名 新建时，自动转换当前操作账号保存
	private String zflag;    //确认标识 X：装柜清单已确认
	private String chdno;    //出货通知书号
	private String vbeln;    //订单号
	private String note1;    //备注
	private Integer cyxno;    //储运箱单号 生成储运箱单时更新
	private Integer cyxsn;    //储运箱单项目 生成储运箱单时更新
	private String zgroup;    //群组 生成储运箱单时更新
	private String cmatnr;    //备案序号 生成储运箱单时更新
	private String cmaktx;    //商品名称 生成储运箱单时更新
	private String cmeins;    //申报单位 生成储运箱单时更新
	private String aenam;    //最近修改的用户名  修改时，自动转换当前操作账号保存
	private String aedat;    //修改日期 修改时，自动抓取当前日期
	private String aetim;    //修改时间 修改时，自动抓取当前时间
	private Integer kbnum;    //卡板数
	private String kbno;    //卡板号 
	private String boxno;    //箱编号
	private String jgtyp;    //加工类型
	private String matnr;    //物料编号
	private String maktx;    //物料描述
	private Double perwet;    //单个重量KG
	private Double boxqty;    //每箱数量
	private Integer boxnum;    //箱数
	private Double yfqty;    //应发数 
	private Double sfqty;    //实发数 
	private String meins;    //单位
	private Double boxl;    //尺码长cm
	private Double boxw;    //尺码宽cm
	private Double boxh;    //尺码高cm
	private Double mpwet;    //毛重kg
	private Double mzwet;    //总毛重kg
	private Double bcwet;    //包材重量/箱kg
	private Double jpwet;    //净重kg
	private Double jzwet;    //总净重kg
	private String cpmna;    //中文品名
	private String ztype;    //类别
	private String foc01;    //1%备损
	private Double kbpwet;    //每卡板重量kg
	private Double kbzwet;    //总卡板重量kg 根据每卡板重量KBPWET*卡板数KBNUM
	private Double kbpjwet;    //每卡板净重kg
	private Double kbqty;    //每卡板数量
	private Double kbl;    //卡板尺码(L)cm
	private Double kbw;    //卡板尺码(W)cm
	private Double kbh;    //卡板尺码(H)cm
	private Double kbpv;    //每卡板体积M3
	private Double kbzv;    //卡板总体积M3 CKD/SKD时：根据每卡板体积KBPV*卡板数KBNUM
	private String gszjh;    //创维组件号
	private String gszjm;    //组件号描述 
	private Double gszjs;    //组件数量
	private String hscode;    //HS.CODE
	private String dutyr;    //Duty rate
	private String epmna;    //英文品名
	private String htno;    //合同号
	private Double minbz;    //最小包装
	private String kmatnr;    //客户料号
	private String polote;    //PO号/批次
	private String lifnr;    //供应商代码 
	private String egname;    //供应商英文名称 
	private String egaddr;    //供应商英文地址
	private String ycgj;    //原产国家
	private String pmaktx;    //葡语描述
	private String csmgj;    //潮湿敏感等级
	private String khfl;    //类型/客户分类
	private String jxtyp;    //机型
	private String jixin;    //机芯
	private String ktype;    //客户型号
	private String potype;    //PO-TYPE
	private String neno;    //N.E.号 
	private String ncmno;    //NCM Code
	private String ncm;    //NCM
	private Double djqty;    //单机用量
	private Double ddqty;    //订单数量
	private String weihao;    //位号
	private Double pmoney;    //单价USD
	private Double zmoney;    //总价USD
	private String ckdno;    //参考订单
	private Double boxpv;    //箱子体积M3
	private String bey01;    //备用窗口01
	private String bey02;    //备用窗口02
	private String bey03;    //备用窗口03
	private String bey04;    //备用窗口04
	private String zhlx;    //走货类型 CBU/CKD/SKD
	private Double dgmz;	//单个毛重 = MPWET / BOXQTY
	private Double kbzjz;	//卡板总净重 = KBPJWET * KBNUM

	public ZgList() {
		super();
	}

	public ZgList(String id){
		super(id);
	}
	
	public String getGuino() {
		return guino;
	}

	public void setGuino(String guino) {
		this.guino = guino;
	}

	public String getCftno() {
		return cftno;
	}

	public void setCftno(String cftno) {
		this.cftno = cftno;
	}

	public String getBukrs() {
		return bukrs;
	}

	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}

	public String getDcno() {
		return dcno;
	}

	public void setDcno(String dcno) {
		this.dcno = dcno;
	}

	public String getGxnam() {
		return gxnam;
	}

	public void setGxnam(String gxnam) {
		this.gxnam = gxnam;
	}

	public String getFtno() {
		return ftno;
	}

	public void setFtno(String ftno) {
		this.ftno = ftno;
	}

	public String getTare() {
		return tare;
	}

	public void setTare(String tare) {
		this.tare = tare;
	}

	public String getSygs() {
		return sygs;
	}

	public void setSygs(String sygs) {
		this.sygs = sygs;
	}

	public String getFhnam() {
		return fhnam;
	}

	public void setFhnam(String fhnam) {
		this.fhnam = fhnam;
	}

	public String getPoter() {
		return poter;
	}

	public void setPoter(String poter) {
		this.poter = poter;
	}

	public String getCheno() {
		return cheno;
	}

	public void setCheno(String cheno) {
		this.cheno = cheno;
	}

	public String getBynam() {
		return bynam;
	}

	public void setBynam(String bynam) {
		this.bynam = bynam;
	}

	public String getJctim() {
		return jctim;
	}

	public void setJctim(String jctim) {
		this.jctim = jctim;
	}

	public String getCctim() {
		return cctim;
	}

	public void setCctim(String cctim) {
		this.cctim = cctim;
	}

	public String getErtim() {
		return ertim;
	}

	public void setErtim(String ertim) {
		this.ertim = ertim;
	}

	public String getErnam() {
		return ernam;
	}

	public void setErnam(String ernam) {
		this.ernam = ernam;
	}

	public String getZflag() {
		return zflag;
	}

	public void setZflag(String zflag) {
		this.zflag = zflag;
	}

	public String getChdno() {
		return chdno;
	}

	public void setChdno(String chdno) {
		this.chdno = chdno;
	}

	public String getVbeln() {
		return vbeln;
	}

	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}

	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public Integer getCyxsn() {
		return cyxsn;
	}

	public void setCyxsn(Integer cyxsn) {
		this.cyxsn = cyxsn;
	}

	public String getZgroup() {
		return zgroup;
	}

	public void setZgroup(String zgroup) {
		this.zgroup = zgroup;
	}

	public String getCmatnr() {
		return cmatnr;
	}

	public void setCmatnr(String cmatnr) {
		this.cmatnr = cmatnr;
	}

	public String getCmaktx() {
		return cmaktx;
	}

	public void setCmaktx(String cmaktx) {
		this.cmaktx = cmaktx;
	}

	public String getCmeins() {
		return cmeins;
	}

	public void setCmeins(String cmeins) {
		this.cmeins = cmeins;
	}

	public String getAenam() {
		return aenam;
	}

	public void setAenam(String aenam) {
		this.aenam = aenam;
	}

	public String getAetim() {
		return aetim;
	}

	public void setAetim(String aetim) {
		this.aetim = aetim;
	}

	public Integer getKbnum() {
		return kbnum;
	}

	public void setKbnum(Integer kbnum) {
		this.kbnum = kbnum;
	}

	public String getKbno() {
		return kbno;
	}

	public void setKbno(String kbno) {
		this.kbno = kbno;
	}

	public String getBoxno() {
		return boxno;
	}

	public void setBoxno(String boxno) {
		this.boxno = boxno;
	}

	public String getJgtyp() {
		return jgtyp;
	}

	public void setJgtyp(String jgtyp) {
		this.jgtyp = jgtyp;
	}

	public String getMatnr() {
		return matnr;
	}

	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}

	public String getMaktx() {
		return maktx;
	}

	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}

	public Double getPerwet() {
		return perwet;
	}

	public void setPerwet(Double perwet) {
		this.perwet = perwet;
	}

	public Double getBoxqty() {
		return boxqty;
	}

	public void setBoxqty(Double boxqty) {
		this.boxqty = boxqty;
	}

	public Integer getBoxnum() {
		return boxnum;
	}

	public void setBoxnum(Integer boxnum) {
		this.boxnum = boxnum;
	}

	public Double getYfqty() {
		return yfqty;
	}

	public void setYfqty(Double yfqty) {
		this.yfqty = yfqty;
	}

	public Double getSfqty() {
		return sfqty;
	}

	public void setSfqty(Double sfqty) {
		this.sfqty = sfqty;
	}

	public String getMeins() {
		return meins;
	}

	public void setMeins(String meins) {
		this.meins = meins;
	}

	public Double getBoxl() {
		return boxl;
	}

	public void setBoxl(Double boxl) {
		this.boxl = boxl;
	}

	public Double getBoxw() {
		return boxw;
	}

	public void setBoxw(Double boxw) {
		this.boxw = boxw;
	}

	public Double getBoxh() {
		return boxh;
	}

	public void setBoxh(Double boxh) {
		this.boxh = boxh;
	}

	public Double getMpwet() {
		return mpwet;
	}

	public void setMpwet(Double mpwet) {
		this.mpwet = mpwet;
	}

	public Double getMzwet() {
		return mzwet;
	}

	public void setMzwet(Double mzwet) {
		this.mzwet = mzwet;
	}

	public Double getBcwet() {
		return bcwet;
	}

	public void setBcwet(Double bcwet) {
		this.bcwet = bcwet;
	}

	public Double getJpwet() {
		return jpwet;
	}

	public void setJpwet(Double jpwet) {
		this.jpwet = jpwet;
	}

	public Double getJzwet() {
		return jzwet;
	}

	public void setJzwet(Double jzwet) {
		this.jzwet = jzwet;
	}

	public String getCpmna() {
		return cpmna;
	}

	public void setCpmna(String cpmna) {
		this.cpmna = cpmna;
	}

	public String getZtype() {
		return ztype;
	}

	public void setZtype(String ztype) {
		this.ztype = ztype;
	}

	public String getFoc01() {
		return foc01;
	}

	public void setFoc01(String foc01) {
		this.foc01 = foc01;
	}

	public Double getKbpwet() {
		return kbpwet;
	}

	public void setKbpwet(Double kbpwet) {
		this.kbpwet = kbpwet;
	}

	public Double getKbzwet() {
		return kbzwet;
	}

	public void setKbzwet(Double kbzwet) {
		this.kbzwet = kbzwet;
	}

	public Double getKbpjwet() {
		return kbpjwet;
	}

	public void setKbpjwet(Double kbpjwet) {
		this.kbpjwet = kbpjwet;
	}

	public Double getKbqty() {
		return kbqty;
	}

	public void setKbqty(Double kbqty) {
		this.kbqty = kbqty;
	}

	public Double getKbl() {
		return kbl;
	}

	public void setKbl(Double kbl) {
		this.kbl = kbl;
	}

	public Double getKbw() {
		return kbw;
	}

	public void setKbw(Double kbw) {
		this.kbw = kbw;
	}

	public Double getKbh() {
		return kbh;
	}

	public void setKbh(Double kbh) {
		this.kbh = kbh;
	}

	public Double getKbpv() {
		return kbpv;
	}

	public void setKbpv(Double kbpv) {
		this.kbpv = kbpv;
	}

	public Double getKbzv() {
		return kbzv;
	}

	public void setKbzv(Double kbzv) {
		this.kbzv = kbzv;
	}

	public String getGszjh() {
		return gszjh;
	}

	public void setGszjh(String gszjh) {
		this.gszjh = gszjh;
	}

	public String getGszjm() {
		return gszjm;
	}

	public void setGszjm(String gszjm) {
		this.gszjm = gszjm;
	}

	public Double getGszjs() {
		return gszjs;
	}

	public void setGszjs(Double gszjs) {
		this.gszjs = gszjs;
	}

	public String getHscode() {
		return hscode;
	}

	public void setHscode(String hscode) {
		this.hscode = hscode;
	}

	public String getDutyr() {
		return dutyr;
	}

	public void setDutyr(String dutyr) {
		this.dutyr = dutyr;
	}

	public String getEpmna() {
		return epmna;
	}

	public void setEpmna(String epmna) {
		this.epmna = epmna;
	}

	public String getHtno() {
		return htno;
	}

	public void setHtno(String htno) {
		this.htno = htno;
	}

	public Double getMinbz() {
		return minbz;
	}

	public void setMinbz(Double minbz) {
		this.minbz = minbz;
	}

	public String getKmatnr() {
		return kmatnr;
	}

	public void setKmatnr(String kmatnr) {
		this.kmatnr = kmatnr;
	}

	public String getPolote() {
		return polote;
	}

	public void setPolote(String polote) {
		this.polote = polote;
	}

	public String getLifnr() {
		return lifnr;
	}

	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}

	public String getEgname() {
		return egname;
	}

	public void setEgname(String egname) {
		this.egname = egname;
	}

	public String getEgaddr() {
		return egaddr;
	}

	public void setEgaddr(String egaddr) {
		this.egaddr = egaddr;
	}

	public String getYcgj() {
		return ycgj;
	}

	public void setYcgj(String ycgj) {
		this.ycgj = ycgj;
	}

	public String getPmaktx() {
		return pmaktx;
	}

	public void setPmaktx(String pmaktx) {
		this.pmaktx = pmaktx;
	}

	public String getCsmgj() {
		return csmgj;
	}

	public void setCsmgj(String csmgj) {
		this.csmgj = csmgj;
	}

	public String getKhfl() {
		return khfl;
	}

	public void setKhfl(String khfl) {
		this.khfl = khfl;
	}

	public String getJixin() {
		return jixin;
	}

	public void setJixin(String jixin) {
		this.jixin = jixin;
	}

	public String getKtype() {
		return ktype;
	}

	public void setKtype(String ktype) {
		this.ktype = ktype;
	}

	public String getPotype() {
		return potype;
	}

	public void setPotype(String potype) {
		this.potype = potype;
	}

	public String getNeno() {
		return neno;
	}

	public void setNeno(String neno) {
		this.neno = neno;
	}

	public String getNcmno() {
		return ncmno;
	}

	public void setNcmno(String ncmno) {
		this.ncmno = ncmno;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public Double getDjqty() {
		return djqty;
	}

	public void setDjqty(Double djqty) {
		this.djqty = djqty;
	}

	public Double getDdqty() {
		return ddqty;
	}

	public void setDdqty(Double ddqty) {
		this.ddqty = ddqty;
	}

	public String getWeihao() {
		return weihao;
	}

	public void setWeihao(String weihao) {
		this.weihao = weihao;
	}

	public Double getPmoney() {
		return pmoney;
	}

	public void setPmoney(Double pmoney) {
		this.pmoney = pmoney;
	}

	public Double getZmoney() {
		return zmoney;
	}

	public void setZmoney(Double zmoney) {
		this.zmoney = zmoney;
	}

	public String getCkdno() {
		return ckdno;
	}

	public void setCkdno(String ckdno) {
		this.ckdno = ckdno;
	}

	public Double getBoxpv() {
		return boxpv;
	}

	public void setBoxpv(Double boxpv) {
		this.boxpv = boxpv;
	}

	public String getBey01() {
		return bey01;
	}

	public void setBey01(String bey01) {
		this.bey01 = bey01;
	}

	public String getBey02() {
		return bey02;
	}

	public void setBey02(String bey02) {
		this.bey02 = bey02;
	}

	public String getBey03() {
		return bey03;
	}

	public void setBey03(String bey03) {
		this.bey03 = bey03;
	}

	public String getBey04() {
		return bey04;
	}

	public void setBey04(String bey04) {
		this.bey04 = bey04;
	}

	public String getZhlx() {
		return zhlx;
	}

	public void setZhlx(String zhlx) {
		this.zhlx = zhlx;
	}

	public Double getDgmz() {
		return dgmz;
	}

	public void setDgmz(Double dgmz) {
		this.dgmz = dgmz;
	}

	public Double getKbzjz() {
		return kbzjz;
	}

	public void setKbzjz(Double kbzjz) {
		this.kbzjz = kbzjz;
	}

	public String getChdat() {
		return chdat;
	}

	public void setChdat(String chdat) {
		this.chdat = chdat;
	}

	public String getErdat() {
		return erdat;
	}

	public void setErdat(String erdat) {
		this.erdat = erdat;
	}

	public Integer getCyxno() {
		return cyxno;
	}

	public void setCyxno(Integer cyxno) {
		this.cyxno = cyxno;
	}

	public String getAedat() {
		return aedat;
	}

	public void setAedat(String aedat) {
		this.aedat = aedat;
	}

	public String getJxtyp() {
		return jxtyp;
	}

	public void setJxtyp(String jxtyp) {
		this.jxtyp = jxtyp;
	}

	public String getZgdsn() {
		return zgdsn;
	}

	public void setZgdsn(String zgdsn) {
		this.zgdsn = zgdsn;
	}

	
	
}