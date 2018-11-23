package com.ey.piit.sdo.price.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.sdo.price.repository.BranchPriceDao;
import com.ey.piit.sdo.price.vo.BranchPriceVo;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;

/**
 * 分公司产品价格Service
 * @author 邓海
 */
@Service
public class BranchPriceService  {
	@Autowired
	private BranchPriceDao dao;

	@Autowired
	private ExportUtil exportUtil;
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(BranchPriceVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<BranchPriceVo> list = (List<BranchPriceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public BranchPriceVo callQueryById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<BranchPriceVo> list = (List<BranchPriceVo>) param.get("list");
		BranchPriceVo vo = list.get(0);
		return vo;
	}

	
	@SuppressWarnings("unchecked")
	public Object callQuery(BranchPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<BranchPriceVo> list = (List<BranchPriceVo>) param.get("list");
		return list;
	}
	
	
	private Map<String, Object> save(BranchPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		return param;
	}
	
	@Transactional
	public Object edit(BranchPriceVo vo) {	
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void submit(BranchPriceVo vo){
		this.callBefore(vo);
		vo.setType(1);//1表示修改数据
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
	}
	/**
	 * 获取价格
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public Object getPrice(String mxlx,String gjmytk,String khbm,String zhfs,String pid,String ks,String jixin,String jixing,String pizdsj){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("mxlx", mxlx);
		param.put("gjmytk", gjmytk);
		param.put("khbm", khbm);
		param.put("zhfs", zhfs);
		param.put("pid", pid);
		param.put("ks", ks);
		param.put("jixin", jixin);
		param.put("jixing", jixing);
		param.put("pizdsj", pizdsj);
		dao.getPrice(param);
		List<BranchPriceVo> list = (List<BranchPriceVo>) param.get("list");
		BranchPriceVo vo=new BranchPriceVo();
		if(list.size()>0){
			 vo= list.get(0);
		}else{
			vo.setDj(new BigDecimal(0.0));
		}
		return vo;
	}

	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(BranchPriceVo vo) {
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
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, BranchPriceVo vo){
		try {
			List<BranchPriceVo> list = (List<BranchPriceVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
}