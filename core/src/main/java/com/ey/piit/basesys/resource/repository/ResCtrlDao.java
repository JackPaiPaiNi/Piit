/*
 * ResCtrlDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.repository;

import com.ey.piit.basesys.resource.vo.ResCtrlVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.base.BatisRepository;
import java.util.List;
import java.util.Map;

/**
 * 表名：T_RES_CTRL
 * 表描述：功能控制_资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
@BatisRepository
public interface ResCtrlDao extends ICoreDao {
    ResCtrlVo selectById(String id);

    List<ResCtrlVo> selectByPage(Map<String, Object> params, PageBounds page);
    
    List<ResCtrlVo> selectVResCtrl(Map<String, Object> params);
}