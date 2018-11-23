/*
 * DemoDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-09-21 Created
 */
package com.ey.piit.basedemo.repository;

import com.ey.piit.basedemo.vo.DemoVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.base.BatisRepository;
import java.util.List;
import java.util.Map;

/**
 * 表名：t_demo
 * 
 * @author Kevin Xu
 * @version 1.0 2015-09-21
 */
@BatisRepository
public interface DemoDao extends ICoreDao {
    DemoVo selectById(String id);

    List<DemoVo> selectByPage(Map<String, Object> params, PageBounds page);
}