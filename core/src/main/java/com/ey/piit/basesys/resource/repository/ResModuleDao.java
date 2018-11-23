/*
 * ResModuleDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.repository;

import com.ey.piit.basesys.resource.vo.ResModuleVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.base.BatisRepository;
import java.util.List;
import java.util.Map;

/**
 * 表名：T_RES_MODULE
 * 表描述：模块类型
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
@BatisRepository
public interface ResModuleDao extends ICoreDao {
    ResModuleVo selectById(String id);

    List<ResModuleVo> selectByPage(Map<String, Object> params, PageBounds page);
}