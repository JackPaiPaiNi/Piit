package com.ey.piit.sdo.track.service;

import org.springframework.stereotype.Service;

import com.ey.piit.sdo.track.repository.TrackStepDayDeadlineDao;
import com.ey.piit.sdo.track.vo.TrackStepDayDeadlineVo;
import com.ey.piit.core.service.BaseService;

/**
 * 订单节点预计完成时间设置Service
 * @author 赵桃军
 */
@Service
public class TrackStepDayDeadlineService extends BaseService<TrackStepDayDeadlineDao, TrackStepDayDeadlineVo> {
	
	protected void saveAfter(TrackStepDayDeadlineVo vo) {
		dao.updateDictName(vo);
	}
}