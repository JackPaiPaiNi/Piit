/*
 * ResInfoService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-17 Created
 */
package com.ey.piit.basesys.resource.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basesys.resource.repository.ResInfoDao;
import com.ey.piit.basesys.resource.vo.ResInfoVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;

/**
 * T_RES_INFO
 * 流程资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-17
 */
@Service
public class ResInfoService extends CoreService {

    @Autowired
    private ResInfoDao resInfoDao;

    public ResInfoVo findById(String id) {
        return resInfoDao.selectById(id);
    }

    public List<ResInfoVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return resInfoDao.selectByPage(params, page);
    }

    @Override
    protected ICoreDao getDao() {
        return resInfoDao;
    }
    
}