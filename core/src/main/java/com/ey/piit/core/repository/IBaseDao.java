package com.ey.piit.core.repository;

import java.util.List;

import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.core.paginator.domain.PageBounds;

public interface IBaseDao<T> {

	T selectById(String id);

	List<T> select(T vo, PageBounds page);

	List<T> select(T vo);

	int insert(BaseEntity entity);

	int update(BaseEntity entity);

	int delete(BaseEntity entity);

}

