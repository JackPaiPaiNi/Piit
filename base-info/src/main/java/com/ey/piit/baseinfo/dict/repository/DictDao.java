/*
 * DictDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-12 Created
 */
package com.ey.piit.baseinfo.dict.repository;

import com.ey.piit.baseinfo.dict.vo.DictVo;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.base.BatisRepository;
import java.util.List;
import java.util.Map;

/**
 * 表名：T_DICT
 * 表描述：包括:币种、税种、公司类型
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-12
 */
@BatisRepository
public interface DictDao extends ICoreDao {
    DictVo selectById(String id);

    List<DictVo> selectByPage(Map<String, Object> params, PageBounds page);
    
    List<DictVo> selectByPage(Map<String, Object> params);
    
    List<DictVo> selectByType(String type);
    
    List<DictVo> selectCountByType();
    
}