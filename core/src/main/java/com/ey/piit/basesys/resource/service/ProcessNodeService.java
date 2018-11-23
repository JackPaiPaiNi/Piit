/*
 * ProcessNodeService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-17 Created
 */
package com.ey.piit.basesys.resource.service;

import com.ey.piit.basesys.resource.repository.ProcessNodeDao;
import com.ey.piit.basesys.resource.vo.ProcessNodeVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * T_PROCESS_NODE
 * 流程节点
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-17
 */
@Service
public class ProcessNodeService extends CoreService {

    @Autowired
    private ProcessNodeDao processNodeDao;

    public ProcessNodeVo findById(String id) {
        return processNodeDao.selectById(id);
    }

    public List<ProcessNodeVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return processNodeDao.selectByPage(params, page);
    }

    @Override
    protected ICoreDao getDao() {
        return processNodeDao;
    }
}