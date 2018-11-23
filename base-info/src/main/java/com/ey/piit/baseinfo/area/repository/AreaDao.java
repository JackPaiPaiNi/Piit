/*
 * AreaDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-02 Created
 */
package com.ey.piit.baseinfo.area.repository;

import java.util.List;
import java.util.Map;

import com.ey.piit.baseinfo.area.vo.AreaVo;
import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 表名：T_AREA
 * 表描述：一级对应国家
二级对应省
三级对应市

 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-02
 */
@BatisRepository
public interface AreaDao extends ICoreDao {
    AreaVo selectById(String id);

    List<AreaVo> selectByPage(Map<String, Object> params, PageBounds page);
    
    List<AreaVo> selectByPage(Map<String, Object> params);
    
    List<TreeNode> selectTreeByParentCode(Map<String, Object> params);
    
    void updateChildCountByCode(Map<String, Object> params);
    
    AreaVo selectByCode(String code);
    
    List<AreaVo> selectChildByCode(String code);
    
    List<TreeNode> selectTreeInCode(Map<String, Object> params);
    
    void updateChildStatusByPath(Map<String, Object> params);
}