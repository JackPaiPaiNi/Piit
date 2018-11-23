/*
 * ResModuleService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-17 Created
 */
package com.ey.piit.basesys.resource.service;

import com.ey.piit.basesys.resource.repository.ResModuleDao;
import com.ey.piit.basesys.resource.vo.ResModuleVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * T_RES_MODULE
 * 模块类型
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-17
 */
@Service
public class ResModuleService extends CoreService {

    @Autowired
    private ResModuleDao resModuleDao;

    public ResModuleVo findById(String id) {
        return resModuleDao.selectById(id);
    }

    public List<ResModuleVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return resModuleDao.selectByPage(params, page);
    }

    @Override
    protected ICoreDao getDao() {
        return resModuleDao;
    }
}