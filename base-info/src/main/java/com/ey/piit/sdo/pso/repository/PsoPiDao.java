package com.ey.piit.sdo.pso.repository;


import java.util.Map;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 预走货PIDAO接口
 * @author 魏诚
 */
@BatisRepository
public interface PsoPiDao  {
	void callInsert(Map<String, Object> param);
}