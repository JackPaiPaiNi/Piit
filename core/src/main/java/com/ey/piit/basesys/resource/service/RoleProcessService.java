/*
 * RoleProcessService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-17 Created
 */
package com.ey.piit.basesys.resource.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basesys.resource.repository.RoleProcessDao;
import com.ey.piit.basesys.resource.vo.RoleProcessVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;

/**
 * T_ROLE_PROCESS
 * 角色_流程节点
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-17
 */
@Service
public class RoleProcessService extends CoreService {

    @Autowired
    private RoleProcessDao roleProcessDao;

    public RoleProcessVo findById(String id) {
        return roleProcessDao.selectById(id);
    }

    public List<RoleProcessVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return roleProcessDao.selectByPage(params, page);
    }

    @Override
    protected ICoreDao getDao() {
        return roleProcessDao;
    }
    
    public boolean isExistByCtrlCode(String ctrlCode) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("ctrlCode", ctrlCode);
    	List<RoleProcessVo> list = roleProcessDao.selectByPage(params);
		return list != null && list.size() > 0;
	}
    
}