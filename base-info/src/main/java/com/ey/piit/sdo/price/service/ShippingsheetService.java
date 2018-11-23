package com.ey.piit.sdo.price.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.interfaces.shippingsheet.dao.SapShippingsheetDao;
import com.ey.piit.interfaces.shippingsheet.dto.ShippingsheetBodyDto;
import com.ey.piit.interfaces.shippingsheet.service.ShippingsheetInterfaceService;
import com.ey.piit.sdo.order.vo.OrderProductVo;
import com.ey.piit.sdo.price.repository.ShippingsheetDao;
import com.ey.piit.sdo.price.vo.ShippingsheetItemVo;
import com.ey.piit.sdo.price.vo.ShippingsheetVo;

/**
 * 出货资料表管理Service
 * 
 * @author 魏诚
 */
@Service
public class ShippingsheetService {

	@Autowired
	private ShippingsheetDao dao;
	
	@Autowired
	private SapShippingsheetDao toSapDao;

	@Autowired
	private ExportUtil exportUtil;

	@Autowired
	private ShippingsheetInterfaceService toSapService;
	
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
    
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(ShippingsheetVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<ShippingsheetVo> list = (List<ShippingsheetVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(ShippingsheetVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<ShippingsheetVo> list = (List<ShippingsheetVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryMxByPage(String drdh, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("drdh", drdh);
		param.put("page", page);
		dao.callSelectDtlByPage(param);
		List<ShippingsheetItemVo> list = (List<ShippingsheetItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryMx(String drdh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("drdh", drdh);
		dao.callSelectDtlByPage(param);
		List<ShippingsheetItemVo> list = (List<ShippingsheetItemVo>) param.get("list");
		return list;
	}

	@Transactional
	public ShippingsheetVo saveMain(ShippingsheetVo vo) {
		if(vo == null){
			User user = UserUtils.getUser();
			vo = new ShippingsheetVo();
			vo.setId(Identities.uuid());
			vo.setZdrid(user.getLoginAcct());
			vo.setZdrmc(user.getUserName());
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callSaveMain(param);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public Object saveMx(ShippingsheetVo vo) {
		// 先删除该导入单号下的明细
		this.deleteMx(vo.getDrdh());
		// 循环保存明细
		for(ShippingsheetItemVo item : vo.getMxList()){
			if(StringUtils.isBlank(item.getId())){
				item.setId(Identities.uuid());
			}
			item.setDrdh(vo.getDrdh());
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", item);
			// 明细保存
			dao.callSaveDtl(param);
			this.callAfter(param);
		}
		return vo;
	}

	@Transactional
	public Object submit(ShippingsheetVo vo) {
		this.tsSapAndWriteLog(vo.getDrdh());
		// 设置当前提交人
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSubmit(param);
		this.callAfter(param);
		return param;
	}
	
	private void deleteMx(String drdh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("drdh", drdh);
		dao.callDeleteDtl(param);
		this.callAfter(param);
	}

	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, ShippingsheetVo vo) {
		try {
			List<OrderProductVo> list = (List<OrderProductVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}

	@SuppressWarnings("unchecked")
	public void exportMx(HttpServletResponse response, Map<String, Object> params, String drdh) {
		try {
			List<ShippingsheetItemVo> list = (List<ShippingsheetItemVo>) this.callQueryMx(drdh);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	// 推送SAP并且记录返信息货日志
	@SuppressWarnings("unchecked")
	private void tsSapAndWriteLog(String drdh) {
		// 取推送sap数据
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("drdh", drdh);
		toSapDao.callSelectByDrdh(param);
		List<ShippingsheetBodyDto> list = (List<ShippingsheetBodyDto>) param.get("bodyList");
		// 判断有无数据
		if(list.size() == 0){
			throw new ServiceException("系统推送SAP时未找到数据！");
		}
		// 执行推送
		Map<String, String> response = null;
		try {
			response = this.pushSAP(list);
		} catch (Exception e) {
			throw new ServiceException("出货资料表推送SAP失败！");
		}
		// 保存推送返回信息日志
		this.saveTsSapLog(drdh, response);
	}
	
	private Map<String, String> pushSAP(List<ShippingsheetBodyDto> list) {
		Map<String, String> response = null;
		// 调用sap接口
		try {
			response = toSapService.shippingsheetSdoToSap(list);
		} catch (Exception e) {
			throw new ServiceException("调用SAP出货资料表接口失败！");
		}
		// 判断是否推送成功
    	if (response != null && "S".equals(response.get("result"))) {
			// sap接口调用成功
		} else {
			throw new ServiceException("调用SAP出货资料表接口失败！");
		}
    	
		return response;
	}

	// 保存推送制造SAP和海外SAP反馈细信息日志
	private SapInterfaceLogVo saveTsSapLog(String drdh, Map<String, String> response) {
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(Identities.uuid());
		logvo.setDh(drdh);
		logvo.setMk("出货资料表");
		logvo.setSj(new Date());
		logvo.setFhzt("S".equals(response.get("result"))?1:0);
		logvo.setFhxx(response.get("message"));
		// 此处直接推送二维表，无报文
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			throw new ServiceException("保存SAP返回信息日志出错");
		}
		return logvo ;
	}

	/**
	 * 调用存储过程后判断操作是否成功
	 * 
	 * @param param
	 */
	public void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
    
}