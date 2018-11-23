/*
 * FilePersistenceDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-12-04 Created
 */
package com.ey.piit.basesys.data.repository;

import com.ey.piit.basesys.data.vo.FilePersistenceVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.base.BatisRepository;
import java.util.List;
import java.util.Map;

/**
 * 表名：T_FILE_PERSISTENCE
 * 
 * @author Kevin Xu
 * @version 1.0 2015-12-04
 */
@BatisRepository
public interface FilePersistenceDao extends ICoreDao {
    FilePersistenceVo selectById(String id);

    List<FilePersistenceVo> selectByPage(Map<String, Object> params, PageBounds page);
	
	int deleteByIds(String ids);
}