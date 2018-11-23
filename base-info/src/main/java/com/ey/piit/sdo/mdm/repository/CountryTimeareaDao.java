package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.CountryTimeareaVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 国家时区关系管理DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface CountryTimeareaDao extends IBaseDao<CountryTimeareaVo> {
	
}