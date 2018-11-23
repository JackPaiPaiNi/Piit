package com.ey.piit.sdo.report.repository;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.report.vo.ReportSkdOrderStatusVo;

/**
 * 欧洲供应链SKD订单状态表DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface ReportSkdOrderStatusDao extends IBaseDao<ReportSkdOrderStatusVo> {
	
}