package com.ey.piit.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.entity.CoreEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.utils.DateUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.OrganizationVo;
import com.ey.piit.core.vo.RoleVo;

public abstract class CoreService {
	
	protected final Logger logger = Logger.getLogger(getClass());

	@Transactional
	public int edit(CoreEntity record) {
		if (Oper.add.equals(record.getOper())) {
			validate(record);
			saveBefore(record);
			int result = save(record);
			saveAfter(record);
			return result;
		} else if (Oper.edit.equals(record.getOper())) {
			validate(record);
			updateBefore(record);
			int result = update(record);
			updateAfter(record);
			return result;
		} else if (Oper.del.equals(record.getOper())) {
			deleteBefore(record);
			int result = delete(record);
			deleteAfter(record);
			return result;
		} else {
			return 0;
		}
	}

	public int saveOrUpdate(CoreEntity record) {
		if (StringUtils.isBlank(record.getId())) {
			record.setOper(Oper.add);
			validate(record);
			saveBefore(record);
			int result = save(record);
			saveAfter(record);
			return result;
		} else {
			record.setOper(Oper.edit);
			validate(record);
			updateBefore(record);
			int result = update(record);
			updateAfter(record);
			return result;
		}
	}

	protected int save(CoreEntity record) {
    	Date curDate = new Date();
    	if (StringUtils.isBlank(record.getId()) || "_empty".equals(record.getId())) {
    		record.setId(UUID.randomUUID().toString());
		}
    	if (record.getCreator() == null || record.getLastUpdater() == null) {
    		User curUser = findCurUser();
    		record.setCreator(curUser.getEmpCode());
    		record.setLastUpdater(curUser.getEmpCode());
		}
		record.setCreateTime(curDate);
		record.setLastUpdateTime(curDate);
		return getDao().insert(record);
	}

	protected int update(CoreEntity record) {
    	Date curDate = new Date();
    	if (record.getLastUpdater() == null) {
    		User curUser = findCurUser();
    		record.setLastUpdater(curUser.getEmpCode());
		}
		record.setLastUpdateTime(curDate);
		return getDao().updateAllById(record);
	}

	protected int delete(CoreEntity record) {
		if (record.getId().indexOf(",") != -1) {
			String[] ids = record.getId().split(",");
			int count = 0;
			for (int i = 0; i < ids.length; i++) {
				count += getDao().deleteById(ids[i]);
			}
			return count;
		} else {
			return getDao().deleteById(record.getId());
		}
	}

	public void validate(CoreEntity record) {
	}
	
	protected void saveBefore(CoreEntity record) {
	}
	protected void updateBefore(CoreEntity record) {
	}
	protected void deleteBefore(CoreEntity record) {
	}
	
	protected void saveAfter(CoreEntity record) {
	}
	protected void updateAfter(CoreEntity record) {
	}
	protected void deleteAfter(CoreEntity record) {
	}

	protected abstract ICoreDao getDao();
	
	protected User findCurUser(){
		Subject currentUser = SecurityUtils.getSubject();  
    	Session session = currentUser.getSession();
    	User curUser = (User)session.getAttribute(Constants.CURRENT_USER);
    	return curUser;
	}
	
	protected List<RoleVo> findCurRole(){
		Subject currentUser = SecurityUtils.getSubject();  
    	Session session = currentUser.getSession();
    	@SuppressWarnings("unchecked")
		List<RoleVo> roleList = (List<RoleVo>)session.getAttribute(Constants.CURRENT_ROLES);
    	return roleList;
	}
	
	protected List<OrganizationVo> findCurOrg(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		@SuppressWarnings("unchecked")
		List<OrganizationVo> orgList = (List<OrganizationVo>)session.getAttribute(Constants.CURRENT_ORGS);
		return orgList;
	}
	
	protected void putDateRange(Map<String, Object> params,String key){
		Date[] date = splitDate(params.get(key));
    	if (date != null) {
    		params.put(key+"Start", date[0]);
    		params.put(key+"End", date[1]);
		}
	}
	
	private Date[] splitDate(Object objDate){
    	String date = objDate == null ? null : objDate.toString();
    	if (StringUtils.isNotBlank(date)) {
    		String[] split = date.split(" ~ ");
    		if (split != null) {
    			Date dateStart = DateUtils.parseDate(split[0]);
    			Date dateend = DateUtils.parseDate(split[1]);
    			Date[] dateArr = {dateStart,dateend};
    			return dateArr;
			}
		}
		return null;
	}
	
	protected void putDate(Map<String, Object> params,String key){
		Object objDate = params.get(key);
		String date = objDate == null ? null : objDate.toString();
		if (StringUtils.isNotBlank(date)) {
			params.put(key, DateUtils.parseDate(date));
		}
	}
}
