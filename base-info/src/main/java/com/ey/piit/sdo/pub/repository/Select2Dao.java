package com.ey.piit.sdo.pub.repository;

import java.util.List;
import java.util.Map;

import com.ey.piit.baseinfo.area.vo.AreaVo;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 表名：T_AREA
 * 表描述：一级对应国家
二级对应省
三级对应市

 * 
 * @author 魏诚
 * @version 1.0 2015-6-12
 */
@BatisRepository
public interface Select2Dao {
	// 查询所有国家
    List<AreaVo> selectAllCountry();

	void callSelectSjsByRole(Map<String, Object> param);
	
	void callSelectJgfs(Map<String, Object> param);
	
	void callSelectShfdm(Map<String, Object> param);
}