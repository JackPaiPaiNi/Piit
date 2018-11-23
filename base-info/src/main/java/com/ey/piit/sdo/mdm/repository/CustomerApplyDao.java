package com.ey.piit.sdo.mdm.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 客户信息申请DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface CustomerApplyDao{

	void callSubmit(Map<String, Object> param);

	void callInsert(Map<String, Object> param);

	void callApprove(Map<String, Object> param);

	void callSelect(Map<String, Object> param);

	void callSelectById(Map<String, Object> param);

	void callDelete(Map<String, Object> param);

}