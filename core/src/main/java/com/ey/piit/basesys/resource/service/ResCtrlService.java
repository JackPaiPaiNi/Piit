/*
 * ResCtrlService.java
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

import com.ey.piit.basesys.resource.repository.ResCtrlDao;
import com.ey.piit.basesys.resource.vo.ResCtrlVo;
import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;

/**
 * T_RES_CTRL
 * 功能控制_资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-17
 */
@Service
public class ResCtrlService extends CoreService {

    @Autowired
    private ResCtrlDao resCtrlDao;
    
    @Autowired
    private RoleProcessService roleProcessService;

    public ResCtrlVo findById(String id) {
        return resCtrlDao.selectById(id);
    }

    public List<ResCtrlVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return resCtrlDao.selectByPage(params, page);
    }

    @Override
	protected void saveBefore(CoreEntity record) {
    	ResCtrlVo resCtrl = (ResCtrlVo)record;
    	if (!roleProcessService.isExistByCtrlCode(resCtrl.getCtrlCode())) {
			throw new ValidateException("控制编码不存在");
		}
		super.saveBefore(record);
	}

	@Override
	protected void updateBefore(CoreEntity record) {
		ResCtrlVo resCtrl = (ResCtrlVo)record;
    	if (!roleProcessService.isExistByCtrlCode(resCtrl.getCtrlCode())) {
			throw new ValidateException("控制编码不存在");
		}
		super.updateBefore(record);
	}

	@Override
    protected ICoreDao getDao() {
        return resCtrlDao;
    }
    
	public List<ResCtrlVo> queryResCtrlList(String roleCode, String module, String nodeName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleCode", roleCode);
		params.put("module", module);
		params.put("nodeName", nodeName);
		return resCtrlDao.selectVResCtrl(params);
	}
}