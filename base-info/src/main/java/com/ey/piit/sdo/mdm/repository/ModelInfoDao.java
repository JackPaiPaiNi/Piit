package com.ey.piit.sdo.mdm.repository;

import java.util.List;

import com.ey.piit.sdo.mdm.vo.ModelInfoVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 机型机芯维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface ModelInfoDao extends IBaseDao<ModelInfoVo> {
	
	//查询机型、机芯
	List<ModelInfoVo> selectByType(String type);
	
}