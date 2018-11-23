package com.ey.piit.sdo.custinv.service;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.SheetDataEntity;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.ExcelUtils;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.NumberUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.custinv.dao.CustInvDao;
import com.ey.piit.sdo.custinv.entity.CustInvEntity;
import com.ey.piit.sdo.custinv.vo.CustInvItemVo;
import com.ey.piit.sdo.custinv.vo.CustInvPackingVo;
import com.ey.piit.sdo.custinv.vo.CustInvVo;
import com.ey.piit.sdo.custinv.vo.LoadMaterialVo;
import com.ey.piit.sdo.custinv.vo.MaterialCustinvVo;

@Service
public class CustInvService {
	@Autowired
	private CustInvDao dao;
	
	@Autowired
	private ExcelUtils excelUtils;
	
	@Value("${tmp.file.folder}")
	private String exporterDirectory;
	
	@Value("${application.name}")
	private String exporterModule;

	/**
	 * @param vo
	 * @return
	 * @Description: 主页查询发票信息集合
	 */
	@SuppressWarnings("unchecked")
	public Object search(CustInvVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelects(param);
		List<CustInvVo> list = (List<CustInvVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	/**
	 * @param vo
	 * @return
	 * @Description: 保存发票信息
	 */
	@Transactional
	public Object save(CustInvVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callSaveMain(param);
		//保存发票明细
		for (CustInvItemVo custInvItem : vo.getCustInvItems()) {
			Map<String, Object> itemParam=new HashMap<String, Object>();
			custInvItem.setFph(vo.getFph());
			custInvItem.setId(Identities.uuid());
			itemParam.put("vo", custInvItem);
			dao.callSaveItems(itemParam);
			this.callAfter(itemParam);
		}
		//保存箱单明细
		for (CustInvPackingVo custInvPacking : vo.getCustInvPackings()) {
			Map<String, Object> packingParam=new HashMap<String, Object>();
			custInvPacking.setFph(vo.getFph());
			custInvPacking.setId(Identities.uuid());
			packingParam.put("vo", custInvPacking);
			dao.callSaveFindPackings(packingParam);
			this.callAfter(packingParam);
		}
		this.callAfter(param);
		return null;
	}

	
	private void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(CustInvVo vo) {
		/*if (Oper.add.equals(vo.getOper())) { vo.preInsert(); } else if
		 * (Oper.edit.equals(vo.getOper())) { vo.preUpdate(); }
		 */
		if (StringUtils.isBlank(vo.getId()) || "_empty".equals(vo.getId())) {
			vo.setId(Identities.uuid());
		}
		if(StringUtils.isBlank(vo.getGsbm())){
			vo.setGsbm("RGB-TEST");
		}
		if(StringUtils.isBlank(vo.getKhbm())){
			vo.setKhbm("RGB-TEST");
		}
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	/**
	 * @param id
	 *            =>发票箱单主信息ID
	 * @param sjc
	 *            =>发票箱单时间戳
	 * @return
	 * @Description: 删除发票箱单信息
	 */
	public Object delete(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p_id", id);
		param.put("p_sjc", sjc);
		dao.callDelete(param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", param.get("resultCode"));
		result.put("resultMsg",param.get("resultMsg"));
		return result;
	}

	/**
	 * @param id
	 *            =>发票箱单主信息ID
	 * @param sjc
	 *            =>发票箱单时间戳
	 * @return
	 * @Description: 取消已提交发票箱单信息
	 */
	public Object cancel(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p_id", id);
		param.put("p_sjc", sjc);
		User user = UserUtils.getUser();
		param.put("p_czr", user.getLoginAcct());
		param.put("p_czrmc", user.getUserName());
		dao.callCancel(param);
		Map<String, Object> result=new HashMap<String,Object>();
		result.put("resultCode", param.get("resultCode"));
		result.put("resultMsg", param.get("resultMsg"));
		return result;
	}

	/**
	 * @param id
	 *            =>发票箱单主信息ID
	 * @param sjc
	 *            =>发票箱单时间戳
	 * @return
	 * @Description: 提交发票箱单信息
	 */
	public Object submit(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p_id", id);
		param.put("p_sjc", sjc);
		dao.callSubmit(param);
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("resultCode", param.get("resultCode"));
		result.put("resultMsg", param.get("resultMsg"));
		return result;
	}

	/**
	 * @param id
	 *            =>发票箱单ID
	 * @return Object =>查询结果集
	 * @Description: 根据发票箱单ID号查询发票箱单信息
	 */
	@SuppressWarnings("unchecked")
	public Object findById(String id,Integer isEdit) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("isedit", isEdit);
		dao.callFindById(param);
		List<CustInvVo> list=(List<CustInvVo>)param.get("list");
		CustInvVo vo=new CustInvVo();
		if(list!=null&&list.size()>0){
			vo=list.get(0);
			List<CustInvItemVo> fpList=(List<CustInvItemVo>)param.get("fpList");
			List<CustInvPackingVo> xdList=(List<CustInvPackingVo>)param.get("xdList");
			DecimalFormat df = new DecimalFormat(".00");
			String str = "";
			if(!vo.getZje().equals(BigDecimal.ZERO)){
				str = df.format(vo.getZje());
			}
			String zje="";
			if(str == null || "".equals(str)){
				zje = "0";
			}else{
				zje= str.toString();
			}
			vo.setEnglishAmount(NumberUtils.toEnglish(zje.toString()));
			vo.setCustInvItems(fpList);
			vo.setCustInvPackings(xdList);
		}
		return vo;
	}

	/**
	 * @param vo
	 *            查询条件
	 * @param page
	 *            封装分页对象
	 * @return 查询结果集分页
	 * @Description: 查询可选取的物料信息
	 */
	@SuppressWarnings("unchecked")
	public Object callLoadMaterial(LoadMaterialVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callLoadMaterial(param);
		List<LoadMaterialVo> list = (List<LoadMaterialVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);

	}
	
	/**
	 * @param param
	 * @Description: 加载选取后的发票箱单信息
	 */
	@SuppressWarnings("unchecked")
	public Object callLoadCUSTINV(String p_chdh,String p_ddid,String p_chxx){
		List<CustInvItemVo> fpList=null;
		if(!"".equals(p_chxx)&&null!=p_chxx){
			Map<String,Object> paramS=new HashMap<String,Object>();
			paramS.put("p_chxx", p_chxx);
			dao.callFPMX_BY_CHXX(paramS);
			fpList=(List<CustInvItemVo>)paramS.get("fpList");
		}
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("p_chdh", p_chdh);
		param.put("p_ddid", p_ddid);
		dao.callLoadCUSTINV(param);
		MaterialCustinvVo vo=null;
		List<MaterialCustinvVo> list = (List<MaterialCustinvVo>) param.get("list");
		if(list==null||list.size()<1){
			vo=new MaterialCustinvVo();
		}else {
			vo=list.get(0);
		}
		Map<String, Object> result=new HashMap<String,Object>();
		result.put("vo", vo);
		result.put("fpList", fpList);
		return result;
	}
	
	/**
	 * 发票信息导出
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void export(String id, Map<String, Object> params, HttpServletResponse response) {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			param.put("isedit", 0);
			dao.callFindById(param);
			List<CustInvVo> list=(List<CustInvVo>)param.get("list");
			CustInvVo vo=new CustInvVo();
			if(list!=null&&list.size()>0){
				vo=list.get(0);
				List<CustInvItemVo> fpList=(List<CustInvItemVo>)param.get("fpList");
				List<CustInvPackingVo> xdList=(List<CustInvPackingVo>)param.get("xdList");
				DecimalFormat df = new DecimalFormat(".00");
				String str = "";
				if(!vo.getZje().equals(BigDecimal.ZERO)){
					str = df.format(vo.getZje());
				}
				String zje="";
				if(str == null || "".equals(str)){
					zje = "0";
				}else{
					zje= str.toString();
				}
				vo.setEnglishAmount(NumberUtils.toEnglish(zje.toString()));
				vo.setCustInvItems(fpList);
				vo.setCustInvPackings(xdList);
				
				SheetDataEntity[] sds = new SheetDataEntity[2];
				String fileName = excelUtils.getFileName();
				String pathName = exporterDirectory + exporterModule + fileName;
				File fi = new File(pathName);
				if(!fi.exists()){
					if(!fi.getParentFile().exists()){
						fi.getParentFile().mkdirs();
					}
					fi.createNewFile();
				}
				SheetDataEntity sd = new SheetDataEntity("invoiceInfo");
				SheetDataEntity sd1 = new SheetDataEntity("pakingInfo");
				//sd.addData(vo);
				sd.addDatas(fpList);
				sd1.addDatas(xdList);
				sds[0] = sd;
				sds[1] = sd1;
				Field[] fields = CustInvEntity.class.getDeclaredFields();
				for(int i=0;i<fields.length;i++){
					String fieldName = fields[i].getName();
					String method = "get" + fieldName.substring(0 , 1).toUpperCase() + fieldName.substring(1);  
			        Method m = vo.getClass().getMethod(method);  
					sd.put(fieldName, m.invoke(vo));
				}
				sd.put("englishAmount", NumberUtils.toEnglish(zje.toString()));
				String[] fileStr = fileName.split("/");
				
				String codedFileName = fileStr[fileStr.length-1];
				codedFileName = java.net.URLEncoder.encode(codedFileName, "UTF-8");
				response.setContentType("application/vnd.ms-excel;charset=UTF-8");
				response.setHeader("Content-disposition", "attachment;filename=" + codedFileName);
				excelUtils.writeData(response,"invoiceExport.xlsx", new FileOutputStream(fi) ,sds);
			}
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
}
