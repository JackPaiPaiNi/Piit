package com.ey.piit.basesys.history.repository;

import java.util.Map;

import com.ey.piit.basesys.history.entity.History;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 
 * @author Kevin-Y.Xu
 *
 */
@BatisRepository
public interface HistoryDao {

	int insert(Map<String, Object> record);

	Map<String, Object> selectTempById(History record);
	
	int deleteTempById(History record);
	
}
