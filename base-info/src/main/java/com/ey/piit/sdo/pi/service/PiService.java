package com.ey.piit.sdo.pi.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basebpm.entity.ProcessBean;
import com.ey.piit.basebpm.service.ProcessInstanceService;
import com.ey.piit.basebpm.service.ProcessTaskService;
import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.NumberUtils;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.mdm.service.MaterialInfoService;
import com.ey.piit.sdo.pi.repository.PiDao;
import com.ey.piit.sdo.pi.repository.PiItemDao;
import com.ey.piit.sdo.pi.vo.PiFyItemVo;
import com.ey.piit.sdo.pi.vo.PiItemVo;
import com.ey.piit.sdo.pi.vo.PiLogVo;
import com.ey.piit.sdo.pi.vo.PiVo;
import com.ey.piit.sdo.pub.service.PubDataService;

/**
 * PI管理Service
 * @author 王歌
 */
@Service
public class PiService{

	@Autowired
	private PiItemDao piItemDao;
	@Autowired
	private PiDao piDao;
	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private ProcessInstanceService processInstanceService;
	@Autowired
	private ProcessTaskService processTaskService;
	@Autowired
	private MaterialInfoService materialInfoService;
	@Autowired
    private ExcelImporter excelImporter;
	@Autowired
	private PubDataService pubDataService;
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PiVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		piDao.callSelect(param);
		List<PiVo> list = (List<PiVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 多元化屏PI查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryScreenByPage(PiVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		piDao.callScreenSelect(param);
		List<PiVo> list = (List<PiVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		piDao.callSelectById(param);
		List<PiVo> list = (List<PiVo>) param.get("list");
		List<PiItemVo> piList = (List<PiItemVo>) param.get("piList");
		List<PiLogVo> logList = (List<PiLogVo>) param.get("logList");
		PiVo vo =new PiVo();

		if(list.size()>0){
			vo = list.get(0);
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
		    vo.setEnglishNumber(NumberUtils.toEnglish(zje.toString()));
		    vo.setPiItemList(piList);
		    vo.setLogList(logList);
		}
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryPrintById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		piDao.callSelectPrintById(param);
		List<PiVo> list = (List<PiVo>) param.get("list");
		List<PiItemVo> piList = (List<PiItemVo>) param.get("piList");
		List<PiLogVo> logList = (List<PiLogVo>) param.get("logList");
		PiVo vo =new PiVo();

		if(list.size()>0){
			vo = list.get(0);
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
		    vo.setEnglishNumber(NumberUtils.toEnglish(zje.toString()));
		    vo.setPiItemList(piList);
		    vo.setLogList(logList);
		}
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryByDh(String piid){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("piid",piid);
		piDao.callSelectByDh(param);
		List<PiVo> list = (List<PiVo>) param.get("list");
		List<PiItemVo> piList = (List<PiItemVo>) param.get("piList");
		PiVo vo = new PiVo();
		if(list.size() > 0){
			vo = list.get(0);
			vo.setPiItemList(piList);
		}
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(PiVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		piDao.callSelect(param);
		List<PiVo> list = (List<PiVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryScreen(PiVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		piDao.callScreenSelect(param);
		List<PiVo> list = (List<PiVo>) param.get("list");
		return list;
	}
	
	@Transactional
	public Object edit(PiVo vo) {
		// 数据保存前
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		// 数据保存后
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void delete(String id,String sjc,int zt,String processId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		piDao.callDelete(param);
		this.callAfter(param);
		if(zt == 3 && !"".equals(processId)){
			processInstanceService.deleteProcessInstance(processId);
		}
	}

	@Transactional
	public void submit(PiVo vo){
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		piDao.callSubmit(param);
		this.callAfter(param);
		// 审批流处理开始
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("gsbm", vo.getGsbm());
		variables.put("xszz", vo.getXszz());
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("groupCode", vo.getYwz());//业务组
		variables.put("xsyid", vo.getXsyid());//指定销售员ID
		variables.put("pilb", vo.getPilb());//备损PI类别
		String sqr = UserUtils.hasRole("1-yx-xsy") ? "1-yx-xsy" : "0";
		variables.put("sqr", sqr);
		/*是否含有备损行
		 * 由于海外营销组织架构变更，流程中不需要此判断条件
		 * （是否分公司特价、是否有备损行）
		 * 修改人：魏诚   2018-4-2
		 */
		/*variables.put("sfFgstj", vo.getSfFgstj()==null?0:1);//是否分公司特价
		String sfbsh = "0";
		for(int i =0;i< vo.getPiItemList().size();i++){
			String mxlx = vo.getPiItemList().get(i).getMxlx();
			if(!("1".equals(mxlx) || "2".equals(mxlx) || "3".equals(mxlx))){//如果明细类型不等于齐套、屏、散件不含屏
				sfbsh ="1";
				break;
			}
		}
		variables.put("sfbsh", sfbsh);*/
		variables.put("sfBd", vo.getSfBd()==null?"0":vo.getSfBd());//是否白电
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("khbm", vo.getKhbm());
		piDao.callQueryKhlxByKhbm(param1);
		//若客户类型为LG客户则将khlx的值设置为1,不是则为0
		if("SDO-000000".equals(param1.get("resultCode").toString())){
			variables.put("khlx", "1");
		}else{
			variables.put("khlx", "0");
		}
		// 判断是否驳回
		if(!("".equals(vo.getTaskId())) && !("null".equals(vo.getTaskId()))){
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getPiid());
			if("1".equals(vo.getPilx())){
				processBean.setProcessKey("pi_product");
				processBean.setType("大货PI");//流程类型
			}else if("2".equals(vo.getPilx())){
				//备损PI
				processBean.setProcessKey("pi_spo");
				processBean.setType("备损PI");//流程类型
			}else if("3".equals(vo.getPilx())){
				//样机PI
				processBean.setProcessKey("pi_sample-01");
				processBean.setType("样机PI");//流程类型
			}else if("4".equals(vo.getPilx())){
				//多元化PI
				processBean.setProcessKey("pi_diversity");
				processBean.setType("多元化PI");//流程类型
			}else if("5".equals(vo.getPilx())){
				//多元化屏PI
				processBean.setProcessKey("pi_diversityp");
				processBean.setType("多元化屏PI");//流程类型
			}else if("6".equals(vo.getPilx())){
				//多元化屏PI
				processBean.setProcessKey("pi_smo_diversity");
				processBean.setType("SMO多元化PI");//流程类型
			}else if("7".equals(vo.getPilx())){
				//外采PI
				processBean.setProcessKey("pi_wc");
				processBean.setType("外采PI");//流程类型
			}else if("8".equals(vo.getPilx())){
				//工装PI
				processBean.setProcessKey("pi_fy");
				processBean.setType("工装PI");//流程类型
			}else if("9".equals(vo.getPilx())){
				//线体PI
				processBean.setProcessKey("pi_fy");
				processBean.setType("线体PI");//流程类型
			}else if("10".equals(vo.getPilx())){
				//模具PI
				processBean.setProcessKey("pi_fy");
				processBean.setType("模具PI");//流程类型
			}
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
			processInstanceService.startProcessInstance(processBean);
			//审批流有一开始就结束了，需要进行终审
			spcialApprove(vo);
		}
	}
	
	//审批流有一开始就结束了，需要进行终审
	public void spcialApprove(PiVo vo){
		PiVo votmp = (PiVo) callQueryById(vo.getId());
		boolean isEnd = processInstanceService.isProcessEnd(votmp.getProcessId());
		if(isEnd){
			votmp.setApproveType(3);
			Map<String, Object> param2 = new HashMap<String, Object>();
			param2.put("vo", votmp);
			piDao.callApprove(param2);
			this.callAfter(param2);
		}
	}
	
	@Transactional
	public Object approve(PiVo vo){
		this.callBefore(vo);
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		if(vo.getApproveType() == 1){
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else if(vo.getApproveType() == 2){
			variables.put("out", "reject");
			processTaskService.rejectTaskRestart(vo.getProcessId());
		}
		// 判断是不是终审
		boolean isEnd = processInstanceService.isProcessEnd(vo.getProcessId());
		if(isEnd && vo.getApproveType()==1){
			vo.setApproveType(3);
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		piDao.callApprove(param);
		this.callAfter(param);
		return vo ;
	}
	
	private Map<String, Object> save(PiVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		piDao.callInsert(param);
		//备损PI，多元化PI,多元化屏判断物料编号是否重复
		/*if("2".equals(vo.getPilx()) || "4".equals(vo.getPilx()) || "5".equals(vo.getPilx())){
			for(int i=0; i<vo.getPiItemList().size();i++){
				String wlbh1 = vo.getPiItemList().get(i).getWlbh();
				for(int j=i+1; j<vo.getPiItemList().size(); j++){
					String wlbh2 = vo.getPiItemList().get(j).getWlbh();
					if(wlbh1.equals(wlbh2)){
						throw new ServiceException("物料编号："+wlbh1+"重复！");
					}
				}
				
			}
		}*/
		// 循环插入订单关联PI
		for (PiItemVo piItem : vo.getPiItemList()){
			piItem.setPiid(vo.getPiid());
			piItem.setBbh(vo.getBbh());
			piItem.setId(Identities.uuid());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", piItem);
			piItemDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		return param;
	}
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, PiVo vo){
		try {
			List<PiVo> list = (List<PiVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void screenExport(HttpServletResponse response, Map<String, Object> params, PiVo vo){
		try {
			List<PiVo> list = (List<PiVo>)this.callQueryScreen(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@Transactional
	public void cancel(PiVo vo, Integer type){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("type", type);
		piDao.callCancel(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void change(PiVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		piDao.callChange(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void bfchange(PiVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		piDao.callBfChange(param);
		this.callAfter(param);
	}
	
	/**
	 * SMO审核处理
	 * @param id
	 * @return
	 */
	@Transactional
	public Object smoApprove(PiVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		piDao.callSmoApprove(param);
		this.callAfter(param);
		return param;
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(PiVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	
	/**
	 * 调用存储过程后判断操作是否成功
	 * @param param
	 */
	private void callAfter(Map<String, Object> param){ 
		if(!"SDO-000000".equals(param.get("resultCode").toString())){
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
	
	public void getback(PiVo vo){
		DeleteProcess(vo);
		back(vo);
	}
	public void DeleteProcess(PiVo vo) {
		// 1.删除流程实例
		try {
			processInstanceService.deleteProcessInstance(vo.getProcessId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void back(PiVo vo) {
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		piDao.callGetback(param);
		this.callAfter(param);
	}
	
	public Object importFile(MultipartFile file){
		List<PiFyItemVo> list =excelImporter.importFileReturn(PiFyItemVo.class, file, null);
    	List<PiItemVo> newlist = new ArrayList<PiItemVo>();
    	String wlbms = "";
    	for (PiFyItemVo piItem : list) {
    		wlbms = wlbms + piItem.getWlbh() + ",";
    		PiItemVo newvo = new PiItemVo();
    		newvo.setMxlx(piItem.getMxlx());
    		newvo.setWlbh(piItem.getWlbh());
    		newvo.setKhxhms(piItem.getKhxhms());
    		newvo.setSl(piItem.getSl());
    		newvo.setDj(piItem.getDj());
    		newvo.setMfsl(piItem.getMfsl());
    		newvo.setCkddh(piItem.getCkddh());
    		newvo.setJixin(piItem.getJixin());
    		newvo.setJixing(piItem.getJixing());
    		newlist.add(newvo);
		}
    	Map<String, Object> param1 = pubDataService.checkwl(wlbms);
		if ("SDO-000000".equals(param1.get("resultCode").toString())) {
    		Paginator paginator = new Paginator(1, 1000, newlist.size());
    		return new PageList<PiItemVo>(newlist,paginator);
		}else{
			throw new ServiceException("物料" + param1.get("resultMsg").toString() + "不存在！");
		}
		
	}
}