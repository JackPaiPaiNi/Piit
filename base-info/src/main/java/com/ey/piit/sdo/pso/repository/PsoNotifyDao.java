package com.ey.piit.sdo.pso.repository;
import java.util.Map;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 预走货DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface PsoNotifyDao   {
	void callInsert(Map<String, Object> param);
}