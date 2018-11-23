package com.ey.piit.sdo.track.repository;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.track.vo.TrackValidationVo;

/**
 * 订单生产要求维护DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface TrackValidationDao extends IBaseDao<TrackValidationVo> {
	void callInsert(Map<String, Object> param);
}