package com.ey.piit.sdo.track.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.track.repository.TrackValidationDao;
import com.ey.piit.sdo.track.vo.TrackSoftwareVo;
import com.ey.piit.sdo.track.vo.TrackValidationVo;

/**
 * 订单生产要求维护Service
 * @author 赵桃军
 */
@Service
public class TrackValidationService extends BaseService<TrackValidationDao, TrackValidationVo> {
	
	@Autowired
	private ExportUtil exportUtil;
	
	
	
	//批量修改或保存
	@Transactional
	public void saveOrUpdateAll(List<TrackValidationVo> list ){
		for(TrackValidationVo vo: list){
			addOrUpdate(vo);
		}
	}
	//保存或修改
	public void addOrUpdate(TrackValidationVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.saveBefore(vo);
		if(vo.getQrlx() == 0){
			vo.setWcsj(vo.getRjqrsj());
		}else if(vo.getQrlx() == 1){
			vo.setWcsj(vo.getScjhwc());
		}
		param.put("vo", vo);
		dao.callInsert(param);
		this.saveAfter(param);
	}
	
	//导出页面用户选中订单信息
	public void exportDdxx(HttpServletResponse response, Map<String, Object> params, List<TrackValidationVo> list) {
		try {
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	//导入软件确认信息保存
	@Transactional
	public void saveSoftWareImport(List<TrackSoftwareVo> list){
		for(TrackValidationVo softWareVo : list) {
			softWareVo.setQrlx(0);
			this.addOrUpdate(softWareVo);
		}
	}
	
	//导入计划完成时间信息保存
	@Transactional
	public void savePlainTimeImport(List<TrackValidationVo> list){
		for(TrackValidationVo trackValidationVo : list) {
			trackValidationVo.setQrlx(1);
			this.addOrUpdate(trackValidationVo);
		}
	}
	
	//保存前设置
	protected void saveBefore(TrackValidationVo vo) {
		vo.setId(Identities.uuid());
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	
	//保存后验证
	protected void saveAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
}