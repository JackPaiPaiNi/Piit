package com.ey.piit.sdo.track.repository;

import com.ey.piit.sdo.track.vo.TrackStepDayDeadlineVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 订单节点预计完成时间设置DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface TrackStepDayDeadlineDao extends IBaseDao<TrackStepDayDeadlineVo> {
	
   void updateDictName(TrackStepDayDeadlineVo vo);
	
}