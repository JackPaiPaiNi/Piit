package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.mdm.vo.AmspryVo;

/**
 * 澳门审批人员维护DAO接口
 * @author 赵明
 */
@BatisRepository
public interface AmspryDao extends IBaseDao<AmspryVo> {

	//void callSelect(Map<String, Object> param);

	int updateEmploeeName(AmspryVo amspryVo);

	int updateUserName(AmspryVo amspryVo);
}