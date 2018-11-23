package com.ey.piit.sdo.track.repository;

import com.ey.piit.sdo.track.vo.TrackDelayVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 订单延误原因维护DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface TrackDelayDao extends IBaseDao<TrackDelayVo> {
	Map<String,Object> selectByDdid(Map<String, Object> param);
	int count(TrackDelayVo vo);
}