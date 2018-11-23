package com.ey.piit.sdo.custinv.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.sdo.custinv.dao.TjjgDao;
import com.ey.piit.sdo.custinv.vo.TjjgVo;


/**
 * 以调价结果为基础-调价结果表Service
 * 
 * @author 张钧俊
 */
@Service
public class TjjgService {
	@Autowired
	private TjjgDao tjjgDao;
	
	public Object callQueryByPage(TjjgVo vo,PageBounds page)
	{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		tjjgDao.callSelectTjjg(param);
		@SuppressWarnings({ "unchecked" })
		List<TjjgVo> list = (List<TjjgVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list,paginator);
	}
}
