package com.ey.piit.sdo.track.repository;

import java.util.List;
import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.track.vo.TrackInfoVo;
import com.ey.piit.sdo.track.vo.TrackZtVo;

/**
 * 订单跟踪主表查询DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface TrackInfoDao extends IBaseDao<TrackInfoVo> {
	List<TrackInfoVo> callSelect(Map<String, Object> param);
	// 订单创建
	void callInsert(Map<String, Object> param);
	// 预走货创建
	void callUpdatePsoCreate(Map<String, Object> param);
	// 查询订单整体状态
	List<TrackZtVo> callSelectZtzt(Map<String, Object> param);
	// 更新订单跟踪状态
    void updateDdgzzt(Map<String, Object> param);
    // 订单详细信息查询
    void callSelectDdxq(Map<String, Object> param);
    // 同步订单状态
	void callTbddzt();
	
}