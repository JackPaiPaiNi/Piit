package com.ey.piit.sdo.track.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.track.repository.TrackValidationArtDao;
import com.ey.piit.sdo.track.vo.TrackValidationArtVo;

/**
 * 订单生产要求美工信息维护Service
 * 
 * @author 赵桃军
 */
@Service
public class TrackValidationArtService extends BaseService<TrackValidationArtDao, TrackValidationArtVo> {
	
	
	// 根据订单号取美工确认信息
	public Object selectByDdid(String ddid) {
		Map<String, Object> param = new HashMap<>();
		param.put("ddid", ddid);
		dao.selectByDdid(param) ;
		return param.get("list") ;
	}
	
	// 修改
	public int saveOrUpdate(TrackValidationArtVo vo) {
		saveBefore(vo);
		//如果前台传的'jggid'那么说明是新增
		if(vo.getId().length()<9){
			vo.setId(null);
			vo.setOper(Oper.add);
		}else{
			vo.setOper(Oper.edit);
		}
		return super.edit(vo);
	}

	// 保存美工资料确认
	@Transactional
	public void saveArtMatel(List<TrackValidationArtVo> list) {
		//保存或编辑维护的美工资料
		for (TrackValidationArtVo trackValidationArtVo : list) {
			saveOrUpdate(trackValidationArtVo);
		}
		//保存完毕，更新美工确认状态
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", list.get(0));
		dao.updateMgqrzt(param);
		if(!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}

	// 保存前设置
	protected void saveBefore(TrackValidationArtVo vo) {
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}

	// 保存后检查
  	protected void saveAfter(int result) {
  		if(result != 1){
  			throw new ServiceException("保存失败!");
  		}
  	}

}