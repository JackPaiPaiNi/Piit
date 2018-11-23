package com.ey.piit.sdo.fcst.repository;

import com.ey.piit.sdo.fcst.vo.FcstWeekVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * FCST周次定义DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface FcstWeekDao extends IBaseDao<FcstWeekVo> {
	
}