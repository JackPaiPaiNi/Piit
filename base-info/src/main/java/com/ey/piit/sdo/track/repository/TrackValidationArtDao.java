package com.ey.piit.sdo.track.repository;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.track.vo.TrackValidationArtVo;

/**
 * 订单生产要求美工信息维护DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface TrackValidationArtDao extends IBaseDao<TrackValidationArtVo> {
	Map<String,Object> selectByDdid(Map<String, Object> param);
	//更新主表确认状态
	void updateMgqrzt(Map<String, Object> param);
}