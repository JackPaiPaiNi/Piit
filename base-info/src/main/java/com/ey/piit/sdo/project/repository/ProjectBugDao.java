package com.ey.piit.sdo.project.repository;

import com.ey.piit.sdo.project.vo.ProjectBugVo;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 系统问题管理DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface ProjectBugDao extends IBaseDao<ProjectBugVo> {
	
	void callSelect(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callDelete(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);
	
	void callSaveXmzg(Map<String, Object> param);
	
	void callSaveKfry(Map<String, Object> param);
	
	
}