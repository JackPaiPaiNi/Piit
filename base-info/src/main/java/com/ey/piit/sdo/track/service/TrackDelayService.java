package com.ey.piit.sdo.track.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.track.repository.TrackDelayDao;
import com.ey.piit.sdo.track.vo.TrackDelayVo;
import com.ey.piit.sdo.track.vo.TrackInfoVo;

/**
 * 订单延误原因维护Service
 * @author 赵桃军
 */
@Service
public class TrackDelayService extends BaseService<TrackDelayDao, TrackDelayVo> {
	
	@Autowired
	private TrackInfoService trackInfoService;
	
	@Autowired
	private ExportUtil exportUtil;
	
	//根据订单号取信息
    public Object selectByDdid(String ddid) {
    	Map<String, Object> param = new HashMap<>();
		param.put("ddid", ddid);
		dao.selectByDdid(param) ;
		return param.get("list") ;
    }
	
	//新增或修改
	public int saveOrUpdate(TrackDelayVo vo) {
		int count = dao.count(vo);
		int result = 0 ;
		saveBefore(vo);
		if(count == 0){
			vo.setOper(Oper.add);
			vo.setId(vo.getDdId());
			result = dao.insert(vo);
		}else if(count == 1){
			vo.setOper(Oper.edit);
			vo.setId(vo.getDdId());
			result =  update(vo);
		}else{
			throw new ServiceException("保存或更新时未影响任何数据!");
		}
		saveAfter(result);
		return result;
	}

    //保存延误原因
    @Transactional
    public Object saveDelayReasons(List<TrackDelayVo> list){
    	for(TrackDelayVo trackDelayVo:list){
    		saveOrUpdate(trackDelayVo);
    	}
    	Map<String,Object> map = new HashMap<String,Object>() ;
    	map.put("msg", "成功");
    	return map ;
    }
    
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, TrackInfoVo vo) {
		try {
			List<TrackDelayVo> allList = new ArrayList<TrackDelayVo>();
			List<TrackInfoVo> list = trackInfoService.callQuery(vo);
			for(TrackInfoVo trackInfoVo : list){
				List<TrackDelayVo> tempList = (List<TrackDelayVo>)this.selectByDdid(trackInfoVo.getDdid());
				for(TrackDelayVo trackDelayVo : tempList){
					allList.add(trackDelayVo);
				}
			}
			exportUtil.exportSync(response, params, allList);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@Transactional
	//导入信息保存
	public void saveImport(List<TrackDelayVo> list){
		for (TrackDelayVo trackDelayVo : list) {
			saveOrUpdate(trackDelayVo);
		}
	}
	
    //保存前设置
  	protected void saveBefore(TrackDelayVo vo) {
  		User user = UserUtils.getUser();
  		vo.setZdrid(user.getLoginAcct());
  		vo.setZdrmc(user.getUserName());
  		vo.setZdsj(new Date());
  	}
  	
  	//保存后检查
  	protected void saveAfter(int result) {
  		if(result != 1){
  			throw new ServiceException("保存失败!");
  		}
  	}
}