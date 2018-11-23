package com.ey.piit.sdo.pub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.sdo.mdm.vo.BankVo;
import com.ey.piit.sdo.order.vo.OrderProductVo;
import com.ey.piit.sdo.pub.repository.PubDataDao;

@Service
public class PubDataService {
	@Autowired 
	private  PubDataDao  pubDataDao;
	
	@SuppressWarnings("unchecked")
	public Object qryDhdd(OrderProductVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		pubDataDao.callSelectDhdd(param);
		List<BankVo> list = (List<BankVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	public Map<String, Object> checkwl(String wlbms){
		// 调用审批存储过程
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("wlbms", wlbms);
		pubDataDao.callCheckwl(param);
		return param;
	}
	
	

}
