package com.ey.piit.core.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.Emp;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.OrganizationVo;
import com.ey.piit.core.vo.RoleVo;

public abstract class BaseService<D extends IBaseDao<T>, T extends BaseEntity> {

	protected final Logger logger = Logger.getLogger(getClass());

	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	@Autowired
	protected ExportUtil exportUtil;

	public T findById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		return dao.selectById(id);
	}

	public List<T> queryByPage(T vo, PageBounds page) {
		return dao.select(vo, page);
	}

	public List<T> queryByParam(T vo) {
		return dao.select(vo);
	}

	@Transactional
	public int edit(T entity) {
		if (Oper.add.equals(entity.getOper())) {
			validate(entity);
			saveBefore(entity);
			int result = save(entity);
			saveAfter(entity);
			return result;
		} else if (Oper.edit.equals(entity.getOper())) {
			validate(entity);
			updateBefore(entity);
			int result = update(entity);
			updateAfter(entity);
			return result;
		} else if (Oper.del.equals(entity.getOper())) {
			deleteBefore(entity);
			int result = delete(entity);
			deleteAfter(entity);
			return result;
		} else {
			return 0;
		}
	}

	public int saveOrUpdate(T entity) {
		if (StringUtils.isBlank(entity.getId())) {
			entity.setOper(Oper.add);
			validate(entity);
			saveBefore(entity);
			int result = save(entity);
			saveAfter(entity);
			return result;
		} else {
			entity.setOper(Oper.edit);
			validate(entity);
			updateBefore(entity);
			int result = update(entity);
			updateAfter(entity);
			return result;
		}
	}

	protected int save(T entity) {
		entity.preInsert();
		return dao.insert(entity);
	}

	protected int update(T entity) {
		entity.preUpdate();
		return dao.update(entity);
	}

	protected int delete(T entity) {
		if (entity.getId().indexOf(",") != -1) {
			String[] ids = entity.getId().split(",");
			int count = 0;
			for (int i = 0; i < ids.length; i++) {
				BaseEntity baseEntity = new BaseEntity(ids[i]);
				baseEntity.preUpdate();
				count += dao.delete(baseEntity);
			}
			return count;
		} else {
			entity.preUpdate();
			return dao.delete(entity);
		}
	}

	protected User findCurUser() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		User curUser = (User) session.getAttribute(Constants.CURRENT_USER);
		return curUser;
	}

	protected List<RoleVo> findCurRole() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		@SuppressWarnings("unchecked")
		List<RoleVo> roleList = (List<RoleVo>) session.getAttribute(Constants.CURRENT_ROLES);
		return roleList;
	}

	protected List<OrganizationVo> findCurOrg() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		@SuppressWarnings("unchecked")
		List<OrganizationVo> orgList = (List<OrganizationVo>) session.getAttribute(Constants.CURRENT_ORGS);
		return orgList;
	}

	protected Emp findCurEmp() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		Emp curEmp = (Emp) session.getAttribute(Constants.CURRENT_EMP);
		return curEmp;
	}

	public void validate(T entity) {
	}

	protected void saveBefore(T entity) {
	}

	protected void updateBefore(T entity) {
	}

	protected void deleteBefore(T entity) {
	}

	protected void saveAfter(T entity) {
	}

	protected void updateAfter(T entity) {
	}

	protected void deleteAfter(T entity) {
	}

	public void export(HttpServletResponse response, Map<String, Object> params, T vo) {
		try {
			List<T> list = this.queryByParam(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
}
