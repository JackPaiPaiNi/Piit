package com.ey.piit.basebpm.listener;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.impl.el.FixedValue;

import com.ey.piit.core.repository.UserDao;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.vo.UserVo;

@SuppressWarnings("serial")
public class TaskListener implements org.activiti.engine.delegate.TaskListener {
	protected FixedValue roleCode;
	protected FixedValue isSameDept;
	protected FixedValue isSameGroup;
	protected FixedValue isSameOrg;
	private UserDao userDao;
	
	@Override
	public void notify(DelegateTask delegateTask) {
		//用来指定任务的办理人
		Object objRoleCode = roleCode.getValue(delegateTask);
		if (objRoleCode != null) {
			String roleCode = objRoleCode.toString();
			/*delegateTask.setAssignee(roleCode);//TODO XUY
			delegateTask.setVariable("role", roleCode);
			System.out.println("role=="+roleCode);
			return;*/
			boolean isSameDept = false;
			boolean isSameGroup = false;
			boolean isSameOrg = false;
			String deptCode = "";
			String groupCode = "";
			String orgCode = "";
			if (this.isSameDept != null) {
				Object objIsSameDept = this.isSameDept.getValue(delegateTask);
				if (objIsSameDept != null) {
					isSameDept = Boolean.valueOf(objIsSameDept.toString());
				}
			}
			if (this.isSameGroup != null) {
				Object objIsSameGroup = this.isSameGroup.getValue(delegateTask);
				if (objIsSameGroup != null) {
					isSameGroup = Boolean.valueOf(objIsSameGroup.toString());
				}
			}
			if (this.isSameOrg != null) {
				Object objIsSameOrg = this.isSameOrg.getValue(delegateTask);
				if (objIsSameOrg != null) {
					isSameOrg = Boolean.valueOf(objIsSameOrg.toString());
				}
			}
			if (isSameDept) {
				Object objDeptCode = delegateTask.getVariable("deptCode");
				if (objDeptCode == null) {
					throw new RuntimeException("未设置组织信息");
				}
				deptCode = objDeptCode.toString();
			} else if (isSameGroup) {
				Object objGroupCode = delegateTask.getVariable("groupCode");
				if (objGroupCode == null) {
					throw new RuntimeException("未设置组织信息");
				}
				groupCode = objGroupCode.toString();
			} else if (isSameOrg) {
				Object objOrgCode = delegateTask.getVariable("orgCode");
				if (objOrgCode == null) {
					throw new RuntimeException("未设置组织信息");
				}
				orgCode = objOrgCode.toString();
			}
			
			//访问数据库取得角色对应用户
			List<UserVo> userList = getUserDao().selectByRoleCode(roleCode);
			if (userList == null || userList.size() == 0) {
				throw new RuntimeException(delegateTask.getName()+"节点设置的角色"+objRoleCode+"未找到用户");
			} else if (userList.size() == 1) {
				UserVo user = userList.get(0);
				if (isSameDept) {
					if (deptCode.equals(user.getCompCode())) {
						delegateTask.setAssignee(user.getEmpCode());
					} else {
						throw new RuntimeException(delegateTask.getName()+"节点设置的角色"+objRoleCode+"未找到对应组织的用户");
					}
				} else if (isSameGroup) {
					if (groupCode.equals(user.getCompCode())) {
						delegateTask.setAssignee(user.getEmpCode());
					} else {
						throw new RuntimeException(delegateTask.getName()+"节点设置的角色"+objRoleCode+"未找到对应组织的用户");
					}
				} else if (isSameOrg) {
					if (orgCode.indexOf(user.getCompCode())!=-1) {
						delegateTask.setAssignee(user.getEmpCode());
					} else {
						throw new RuntimeException(delegateTask.getName()+"节点设置的角色"+objRoleCode+"未找到对应组织的用户");
					}
				} else {
					delegateTask.setAssignee(user.getEmpCode());
				}
			} else {
				boolean flag = false;
				for (int i = 0; i < userList.size(); i++) {
					UserVo user = userList.get(i);
					if (isSameDept) {
						if (deptCode.equals(user.getCompCode())) {
							delegateTask.addCandidateUser(user.getEmpCode());
							flag = true;
						}
					} else if (isSameGroup) {
						if (groupCode.equals(user.getCompCode())) {
							delegateTask.addCandidateUser(user.getEmpCode());
							flag = true;
						}
					} else if (isSameOrg) {
						if (orgCode.indexOf(user.getCompCode())!=-1) {
							delegateTask.addCandidateUser(user.getEmpCode());
							flag = true;
						}
					} else {
						delegateTask.addCandidateUser(user.getEmpCode());//设置组用户
						flag = true;
					}
				}
				if (!flag) {
					throw new RuntimeException(delegateTask.getName()+"节点设置的角色"+objRoleCode+"未找到对应组织的用户");
				}
			}
			/*Map<String, Object> variables = delegateTask.getVariables();
			variables.put(Constants.VAR_KEY_TASK_NAME, delegateTask.getName());
			variables.put(Constants.VAR_KEY_FORM_KEY, delegateTask.getFormKey());
			getEmailSystemService().sendEmailByBpmTask(variables, userList);*/
		} else {
			throw new RuntimeException(delegateTask.getName()+"节点未设置角色ID");
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
