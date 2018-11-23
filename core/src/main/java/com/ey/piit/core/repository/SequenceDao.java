package com.ey.piit.core.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 
 * @author Kevin-Y.Xu
 *
 */
@BatisRepository
public interface SequenceDao {

	String selectNextSequence(Map<String, Object> params);
	
}
