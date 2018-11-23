/*
 * ParaConfigDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-24 Created
 */
package com.ey.piit.basesys.para.repository;

import com.ey.piit.basesys.para.vo.ParaConfigVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.base.BatisRepository;
import java.util.List;
import java.util.Map;

/**
 * 表名：T_PARA_CONFIG
 * 表描述：MDM配置表
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-24
 */
@BatisRepository
public interface ParaConfigDao extends ICoreDao {
    ParaConfigVo selectById(String id);

    List<ParaConfigVo> selectByPage(Map<String, Object> params, PageBounds page);
    
    List<ParaConfigVo> selectByPage(Map<String, Object> params);
}