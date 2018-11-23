/*
 * UserDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.repository;

import java.util.List;
import java.util.Map;

import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.core.vo.DistrictLeaderVo;
import com.ey.piit.core.vo.EmpVo;
import com.ey.piit.core.vo.UserVo;

/**
 * 表名：T_USER
 * 表描述：用户
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@BatisRepository
public interface UserDao extends ICoreDao {
    UserVo selectById(String id);

    List<UserVo> selectByPage(Map<String, Object> params, PageBounds page);
    
    List<UserVo> selectByPage(Map<String, Object> params);
    
    UserVo selectByLoginAcct(String loginAcct);
    
    List<UserVo> selectByRoleId(String id);
    
    List<UserVo> selectByRoleCode(String roleCode);
    
    EmpVo selectEmployeeByEmpCode(String empCode);
    
    int deleteByEmpCode(UserVo vo);
    
	int updateByEmpCode(UserVo vo);
	
	int updatePswdByEmpcode(UserVo vo);
	
	List<DistrictLeaderVo> selectByYwzCode(String ywzCode);
}