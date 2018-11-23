package com.ey.piit.sdo.pso.repository;
import java.util.Map;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 预走货DAO接口
 * @author 邓海
 */
@BatisRepository
public interface PsoExhibitionDao   {
	void callInsert(Map<String, Object> param);
}