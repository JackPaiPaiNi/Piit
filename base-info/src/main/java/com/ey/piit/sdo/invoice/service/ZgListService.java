package com.ey.piit.sdo.invoice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.interfaces.invoice.dao.IZgListDao;
import com.ey.piit.interfaces.invoice.dto.ZgListBodyDto;
import com.ey.piit.interfaces.invoice.dto.ZgListMsgResponse;
import com.ey.piit.interfaces.invoice.service.ZgListInterfaceService;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.sdo.invoice.repository.ZgListDao;
import com.ey.piit.sdo.invoice.vo.ZgListVo;

/**
 * 装柜清单Service
 * 
 * @author tianrong
 */
@Service
public class ZgListService {

	@Autowired
	private ZgListDao zgListDao;
	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	@Autowired
	private IZgListDao iDao;
	@Autowired
	private ZgListInterfaceService zgListInterfaceService;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(ZgListVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		zgListDao.callSelect(param);
		List<ZgListVo> list = (List<ZgListVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(ZgListVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		zgListDao.callSelect(param);
		List<ZgListVo> list = (List<ZgListVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, ZgListVo vo) {
		try {
			List<ZgListVo> list = (List<ZgListVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		//更新SAP状态
		tsSapAndWriteLog(vo);
	}
	
	@SuppressWarnings("unchecked")
	public void tsSapAndWriteLog(ZgListVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		iDao.callSelect(param);
		List<ZgListBodyDto> requestList = (List<ZgListBodyDto>) param.get("list");
		List<ZgListMsgResponse> responseList = null;
		// 调用sap接口
		try {
			responseList = zgListInterfaceService.ZgListSdoToSap(requestList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP装柜清单接口失败！");
		}
		// 回写推送SAP状态
		if(responseList.size() > 0){
			String id = Identities.uuid();//id相同记录同一次推送的出货单号
			for(ZgListBodyDto chd : requestList){
				Map<String, Object> param1 = new HashMap<String, Object>();
				param1.put("id", id);
				param1.put("chdno", chd.getChdno());
				param1.put("result", responseList.get(0).getResult());
				param1.put("msg", responseList.get(0).getMsg());
				zgListDao.callSaveChdTssapzt(param1);
				this.callAfter(param1);
			}
			// 保存推送返回信息日志
			saveTsSapLog(id,responseList);
		}else{
			throw new ServiceException("SAP返回数据为空");
		}
	}
	
	// 保存推送SAP日志
	public void saveTsSapLog(String id,List<ZgListMsgResponse> list) {
		for (ZgListMsgResponse zgListMsgResponse : list) {
			SapInterfaceLogVo logvo = new SapInterfaceLogVo();
			logvo.setId(id);
			logvo.setDh("");
			logvo.setMk("装柜清单");
			logvo.setSj(new Date());
			logvo.setFhzt("S".equals(zgListMsgResponse.getResult())?1:0);
			logvo.setFhxx(zgListMsgResponse.getMsg());
			logvo.setBw(zgListMsgResponse.getInXml());
			try {
				sapInterfaceLogService.save(logvo);
			} catch (Exception e) {
				new ServiceException("保存SAP返回信息日志出错");
			}
		}
	}
	
	/**
	 * 调用存储过程后判断操作是否成功
	 * 
	 * @param param
	 */
	private void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
}