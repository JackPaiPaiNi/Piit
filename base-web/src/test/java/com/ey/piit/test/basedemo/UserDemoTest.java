package com.ey.piit.test.basedemo;

import org.junit.Test;

import com.ey.piit.basedemo.user.repository.UserDemoDao;
import com.ey.piit.basedemo.user.vo.UserDemoVo;
import com.ey.piit.test.core.BaseTest;

public class UserDemoTest extends BaseTest{

//	@Test
//	public void callUserList(){
//		UserDemoDao userDao = wac.getBean(UserDemoDao.class);
//		
//		UserDemoVo demoVo = userDao.selectById("1");
//		System.out.println(demoVo);
//		
//		UserDemoVo vo = new UserDemoVo();
//		vo.setUserName("admin");
//		userDao.callUserList(vo);
//		System.out.println(vo.getUserList());
//	}
	
	@Test
	public void callVarchar(){
		UserDemoDao userDao = wac.getBean(UserDemoDao.class);
		
		UserDemoVo vo = new UserDemoVo();
		/*vo.setpId(12345);
		vo.setpName("admin");
		userDao.callVarchar(vo);
		System.out.println(vo.getpMsg());
		System.out.println(vo.getpReturn());*/
	}
}
