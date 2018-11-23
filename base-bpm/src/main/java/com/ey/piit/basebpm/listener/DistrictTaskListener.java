package com.ey.piit.basebpm.listener;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;

import com.ey.piit.core.repository.UserDao;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.vo.DistrictLeaderVo;

@SuppressWarnings("serial")
public class DistrictTaskListener implements org.activiti.engine.delegate.TaskListener {
	
	private UserDao userDao;
	
	@Override
	public void notify(DelegateTask delegateTask) {
		Object objYwzCode = delegateTask.getVariable("groupCode");
		if (objYwzCode != null) {
			String ywzCode = objYwzCode.toString();
			//访问数据库取得业务组对应片区负责人
			List<DistrictLeaderVo> userList = this.getUserDao().selectByYwzCode(ywzCode);
			if (userList == null || userList.size() == 0) {
				throw new RuntimeException(delegateTask.getName()+"业务组"+ywzCode+"未找到片区负责人");
			} else if (userList.size() == 1) {
				delegateTask.setAssignee(userList.get(0).getFzrid());
			} else {
				boolean flag = false;
				for (int i = 0; i < userList.size(); i++) {
					delegateTask.addCandidateUser(userList.get(i).getFzrid());//设置组用户
					flag = true;
				}
				if (!flag) {
					throw new RuntimeException(delegateTask.getName()+"业务组"+ywzCode+"未找到片区负责人");
				}
			}
		} else {
			throw new RuntimeException(delegateTask.getName()+"节点未设置业务组");
		}
	}

	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = SpringUtils.getBean(UserDao.class);
		}
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
