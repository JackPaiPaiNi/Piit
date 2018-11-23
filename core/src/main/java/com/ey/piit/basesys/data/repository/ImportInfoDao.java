/*
 * ImportInfoDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-12-04 Created
 */
package com.ey.piit.basesys.data.repository;

import com.ey.piit.basesys.data.vo.ImportInfoVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.base.BatisRepository;
import java.util.List;
import java.util.Map;

/**
 * 表名：T_IMPORT_INFO
 * 
 * @author Kevin Xu
 * @version 1.0 2015-12-04
 */
@BatisRepository
public interface ImportInfoDao extends ICoreDao {
    ImportInfoVo selectById(String id);

    List<ImportInfoVo> selectByPage(Map<String, Object> params, PageBounds page);
}