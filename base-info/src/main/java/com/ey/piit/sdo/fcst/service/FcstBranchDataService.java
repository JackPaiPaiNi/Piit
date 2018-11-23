package com.ey.piit.sdo.fcst.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.Emp;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.vo.OrganizationVo;
import com.ey.piit.core.vo.UserVo;
import com.ey.piit.sdo.fcst.repository.FcstBranchDataDao;
import com.ey.piit.sdo.fcst.vo.FcstBranchDataVo;
import com.ey.piit.sdo.fcst.vo.FcstBranchTmpVo;
import com.ey.piit.sdo.fcst.vo.FcstDataTitleVo;
import com.ey.piit.sdo.mdm.vo.EmployeeVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 分公司销售数据填报Service
 * @author 赵桃军
 */
@Service
public class FcstBranchDataService  {
	
	@Autowired
	private FcstBranchDataDao dao ;
	@Autowired
	private ExportUtil exportUtil;
	/**
	 * 查询当前已经填报的预测数据
	 * @param vo
	 * @return
	 */
	public Object callQuery(FcstBranchTmpVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
	    callBefore(vo);
		param.put("vo", vo);
		dao.callSelect(param);
		return param.get("list");
	}
	/**
	 * 查询分公司销售预测历史
	 * @param vo
	 * @return
	 */
	public Object callQueryHistory(FcstBranchDataVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectHistory(param);
		return param.get("list");
	}
	/**
	 * 查询分公司销售预测统计分析
	 * @param vo
	 * @return
	 */
	public Object callQueryStatistic(FcstBranchDataVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		callBeforeFcstBranchVo(vo);
		param.put("vo", vo);
		dao.callSelectStatistic(param);
		return param.get("list");
	}
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(FcstBranchTmpVo vo, PageBounds page) {
		callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public Object callQueryStatisticByPage(FcstBranchDataVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		callBeforeFcstBranchVo(vo);
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectStatistic(param);
		List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}	
	/**
	 * 查询分公司销售预测统计分析报表表头
	 * @param vo
	 * @return
	 */
	public Object callQueryStatisticTitles(FcstBranchDataVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		callBeforeFcstBranchVo(vo);
		param.put("vo", vo);
		dao.callSelectStatisticTitles(param);
		return param.get("list");
	}
	@SuppressWarnings("unchecked")
	public Object callQueryHistoryByPage(FcstBranchDataVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectHistory(param);
		List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}	
	@SuppressWarnings("unchecked")
	public Object callQueryBranchModelByPage(FcstBranchDataVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectBranchModel(param);
		List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}	
	@SuppressWarnings("unchecked")
	public Object callQueryBranchModel(FcstBranchDataVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectBranchModel(param);
		List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>) param.get("list");
		return list;
	}
	@Transactional
	public void editModelChart(FcstBranchDataVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		callBeforeFcstBranchVo(vo);
		param.put("vo", vo);
		if (Oper.add.equals(vo.getOper())) {
			dao.insertModelChart(param);
		} else if (Oper.edit.equals(vo.getOper())) {
			dao.updateModelChart(param);
		} else if (Oper.del.equals(vo.getOper())) {
			dao.deleteModelChart(param);
		}
		callAfter(param);
	}
	/**
	 * 根据分公司和型号查询出历史数据
	 * @param ids
	 * @return
	 */
	public Object callQueryJoin(FcstBranchTmpVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		callBefore(vo);
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectJoin(param);
		return param.get("list");
	}

	/**
	 * 查询动态表头数据
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryHtyTitles(FcstBranchDataVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("syyyymm", vo.getBeginNy());
		param.put("eyyyymm", vo.getEndNy());
		dao.callSelectHtyTitles(param);
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hblist);
		return map;
	}
	/**
	 * 查询动态表头数据
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryTitles() {
		Map<String, Object> param = new HashMap<String, Object>();
		dao.callSelectTitles(param);
		List<FcstDataTitleVo> hblist = (List<FcstDataTitleVo>) param.get("hblist");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hblist", hblist);
		return map;
	}	
	// 保存预测数据到基础表
	public  void saveBase(String sjc){
		//行转列写入基础表
		Map<String, Object> param = new HashMap<String, Object>();
		FcstBranchTmpVo vo = new  FcstBranchTmpVo();
		vo.setSjc(sjc);
		param.put("vo", vo);
		dao.callSave(param);
		callAfter(param);
	}
	// 保存预测数据到中间表
	@Transactional
	public void callEditList(List<FcstBranchTmpVo> list) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS"); 
		String sjc = sdFormat.format(new Date()); 
		//保存进入临时表
		for (FcstBranchTmpVo vo : list) {
			vo.setSjc(sjc);
			this.callBefore(vo);
			Map<String, Object> param = this.callInsert(vo);
			callAfter(param);
		}
		saveBase(sjc);
	}

	// 删除预测数据
	@Transactional
	public void callDeleteList(List<FcstBranchTmpVo> list) {
		Map<String, Object> param = new HashMap<String, Object>();
		for (FcstBranchTmpVo vo : list) {
			this.callBefore(vo);
			param.put("vo", vo);
			dao.callDelete(param);
			callAfter(param);
		}
	}
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, FcstBranchTmpVo vo){
		try {
			List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void exportBranchModel(HttpServletResponse response, Map<String, Object> params, FcstBranchDataVo vo){
		try {
			List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>)this.callQueryBranchModel(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	@SuppressWarnings("unchecked")
	public void exportHistory(HttpServletResponse response, Map<String, Object> params, FcstBranchDataVo vo){
		try {
			List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>)this.callQueryHistory(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	@SuppressWarnings("unchecked")
	public void exportStatistic(HttpServletResponse response, Map<String, Object> params, FcstBranchDataVo vo){
		try {
			List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>)this.callQueryStatistic(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}	
	/**
	 * 预测数据保存到中间表
	 * @param vo
	 * @return
	 */
	private Map<String, Object> callInsert(FcstBranchTmpVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		return param;
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(FcstBranchTmpVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setXszz(user.getDeptCode());
		vo.setYwz(user.getGroupCode());
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * @param vo
	 */
	private void callBeforeFcstBranchVo(FcstBranchDataVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setXszz(user.getDeptCode());
		vo.setYwz(user.getGroupCode());
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	/**
	 * 调用存储过程后判断操作是否成功
	 * @param param
	 */
	private void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}

}