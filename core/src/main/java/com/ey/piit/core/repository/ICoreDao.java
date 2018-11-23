package com.ey.piit.core.repository;

import com.ey.piit.core.entity.CoreEntity;

public interface ICoreDao {

	int deleteById(String id);

	int insert(CoreEntity record);

	int updateById(CoreEntity record);

	int updateAllById(CoreEntity record);

}
