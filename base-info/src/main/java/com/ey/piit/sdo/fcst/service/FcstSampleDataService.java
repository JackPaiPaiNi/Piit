package com.ey.piit.sdo.fcst.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.fcst.repository.FcstSampleDataDao;
import com.ey.piit.sdo.fcst.vo.FcstSampleDataVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 采购FCST样机填报Service
 * @author 高文浩
 */
@Service
public class FcstSampleDataService {
	
	@Autowired
	private FcstSampleDataDao dao;
	@Autowired
	private ExportUtil exportUtil;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(FcstSampleDataVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		if(StringUtils.isEmpty(vo.getXsyid())){
			vo.setXsyid(user.getLoginAcct());
		}
		param.put("sfxsy", UserUtils.isXys());
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<FcstSampleDataVo> list = (List<FcstSampleDataVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	
	@SuppressWarnings("unchecked")
	public Object callQuery(FcstSampleDataVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		if(StringUtils.isEmpty(vo.getXsyid())){
			vo.setXsyid(user.getLoginAcct());
		}
		param.put("sfxsy", UserUtils.isXys());
		param.put("vo", vo);
		dao.callSelect(param);
		List<FcstSampleDataVo> list = (List<FcstSampleDataVo>) param.get("list");
		return list;
	}
	
	public Map<String, Object> callQueryWeek() {
		Map<String, Object> param = new HashMap<String, Object>();
		dao.callSelectWeek(param);
		return param;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void edit(FcstSampleDataVo vo) {
		//保存页面数据
		JSONArray array = JSONArray.fromObject(vo.getItemListStr());
		List<FcstSampleDataVo> list = ((List<FcstSampleDataVo>) JSONArray.toCollection(array, FcstSampleDataVo.class));
		for(int i=0;i<list.size();i++){
			FcstSampleDataVo sampleVo=list.get(i);
			validate(sampleVo);
			callBefore(sampleVo);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", sampleVo);
			dao.callInsert(param);
			this.callAfter(param);
		}
	}

	@Transactional
	public Map<String, Object> delete(FcstSampleDataVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callDelete(param);
		this.callAfter(param);
		return param;
	}
	
	/**
	 * 保存前进行验证
	 * @param vo
	 */
	private void validate (FcstSampleDataVo vo){
		if("".equals(vo.getKhbm())){
			throw new ServiceException("客户不能为空！");
		}
		if("".equals(vo.getXwgj())){
			throw new ServiceException("销往地不能为空！");
		}
		if("".equals(vo.getJixin())){
			throw new ServiceException("机芯不能为空！");
		}
		if("".equals(vo.getJixing())){
			throw new ServiceException("机型不能为空！");
		}
		if("".equals(vo.getSl())){
			throw new ServiceException("数量不能为空！");
		}
		if("".equals(vo.getPtbh())){
			throw new ServiceException("屏体编号不能为空！");
		}
		if("".equals(vo.getWgys())){
			throw new ServiceException("外观颜色不能为空！");
		}
		if("".equals(vo.getLogo())){
			throw new ServiceException("Logo不能为空！");
		}
		if("".equals(vo.getYjyt())){
			throw new ServiceException("样机用途不能为空！");
		}
		if("".equals(vo.getChsj())){
			throw new ServiceException("出货时间不能为空！");
		}
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(FcstSampleDataVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setXsyid(user.getLoginAcct());
		vo.setXsymc(user.getUserName());
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
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, FcstSampleDataVo vo){
		try {
			List<FcstSampleDataVo> list = (List<FcstSampleDataVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}

}