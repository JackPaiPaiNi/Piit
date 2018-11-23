package com.ey.piit.sdo.track.service;

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
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.track.repository.TrackInfoDao;
import com.ey.piit.sdo.track.vo.TrackInfoVo;
import com.ey.piit.sdo.track.vo.TrackZtVo;

/**
 * 订单跟踪主表查询Service
 * @author 赵桃军
 */
@Service
public class TrackInfoService extends BaseService<TrackInfoDao, TrackInfoVo> {
	
	@Autowired
	private ExportUtil exportUtil;
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(TrackInfoVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<TrackInfoVo> list = (List<TrackInfoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public List<TrackInfoVo> callQuery(TrackInfoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		param.put("vo", vo);
		dao.callSelect(param);
		List<TrackInfoVo> list = (List<TrackInfoVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callSelectZtzt(String ddid){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddid", ddid);
		dao.callSelectZtzt(param);
		List<TrackZtVo> list = (List<TrackZtVo>) param.get("list");
    	return list;
	}
	
	public void export(HttpServletResponse response, Map<String, Object> params, TrackInfoVo vo) {
		try {
			List<TrackInfoVo> list = (List<TrackInfoVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	/**
	 * 订单详细信息查询
	 * @param ddid
	 * @return
	 */
	public Object callQueryDdxq(String ddid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddid", ddid);
		dao.callSelectDdxq(param);
		return param;
	}
	
	/**
	 * 同步订单状态
	 */
	public void tbddzt() {
		dao.callTbddzt();
	}
	
	
}