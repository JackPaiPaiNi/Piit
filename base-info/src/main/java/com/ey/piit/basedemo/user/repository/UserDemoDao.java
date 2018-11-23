package com.ey.piit.basedemo.user.repository;

import com.ey.piit.basedemo.user.vo.UserDemoVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 用户DAO接口
 * @author kevin
 */
@BatisRepository
public interface UserDemoDao extends IBaseDao<UserDemoVo> {
	public void callUserList(UserDemoVo vo);
	public void callVarchar(UserDemoVo vo);
}