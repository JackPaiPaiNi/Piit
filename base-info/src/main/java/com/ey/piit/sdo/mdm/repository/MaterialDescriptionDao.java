package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.MaterialDescriptionVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 物料其他语言描述DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface MaterialDescriptionDao extends IBaseDao<MaterialDescriptionVo> {
	 int count(MaterialDescriptionVo vo);
	 int updateByWlbhYy(MaterialDescriptionVo vo);
}