/*
 * DemoService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-09-21 Created
 */
package com.ey.piit.basedemo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basedemo.repository.DemoDao;
import com.ey.piit.basedemo.vo.DemoVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;

/**
 * 表名：t_demo
 * 
 * @author Kevin Xu
 * @version 1.0 2015-09-21
 */
@Service
public class DemoService extends CoreService {

    @Autowired
    private DemoDao demoDao;

    /*
     * 以下四个方法不重写使用父类默认方法没有业务逻辑
     * 
    @Override
    protected int save(BaseEntity record) {
    	// 业务逻辑
    }
    
    @Override
    protected int update(BaseEntity record) {
    	// 业务逻辑
    }
    
    @Override
    protected int delete(BaseEntity record) {
    	// 业务逻辑
    }
    
    @Override
    protected void validate() {
    	// 业务逻辑
    }
    */
    
    public DemoVo findById(String id) {
        return demoDao.selectById(id);
    }

    public List<DemoVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return demoDao.selectByPage(params, page);
    }

    @Override
    protected ICoreDao getDao() {
        return demoDao;
    }
}