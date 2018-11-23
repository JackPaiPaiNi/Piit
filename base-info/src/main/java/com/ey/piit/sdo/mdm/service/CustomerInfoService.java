package com.ey.piit.sdo.mdm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.sdo.mdm.repository.CustomerInfoDao;
import com.ey.piit.sdo.mdm.vo.CustomerInfoVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 客户信息维护Service
 * @author 赵桃军
 */
@Service
public class CustomerInfoService extends BaseService<CustomerInfoDao, CustomerInfoVo> {

	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private CustomerInfoDao customerInfoDao;

	@SuppressWarnings("unchecked")
	public Object queryCustomerXsyByPage(CustomerInfoVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		customerInfoDao.callSelect(param);
		List<CustomerInfoVo> list = (List<CustomerInfoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public Object queryCustomerXsy(CustomerInfoVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		customerInfoDao.callSelect(param);
		List<CustomerInfoVo> list = (List<CustomerInfoVo>) param.get("list");
    	return list;
	}
	// 更新客户主数据中的销售员信息
	@Transactional
	public Object editKhXsy(CustomerInfoVo customerInfoVo) {
		// 数据保存前
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", customerInfoVo);
		customerInfoDao.callUpdate(param);
		// 数据保存后
		this.callAfter(param);
		return customerInfoVo;
	}
	@SuppressWarnings("unchecked")
	public void exportCustomerXsy(HttpServletResponse response, Map<String, Object> params, CustomerInfoVo vo){
		try {
			List<CustomerInfoVo> list = (List<CustomerInfoVo>)this.queryCustomerXsy(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
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
	/**
	 * 同步客户主数据
	 */
	@Transactional
	public void tbkhxx() {
		customerInfoDao.callTbkhxx();
	}
}