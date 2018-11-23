/*
 * AreaService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-02 Created
 */
package com.ey.piit.baseinfo.area.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ey.piit.baseinfo.area.repository.AreaDao;
import com.ey.piit.baseinfo.area.vo.AreaVo;
import com.ey.piit.baseinfo.common.Constants;
import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;
import com.ey.piit.core.utils.StringUtils;

/**
 * T_AREA
 * 一级对应国家
二级对应省
三级对应市

 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-02
 */
@Service
public class AreaService extends CoreService {

    @Autowired
    private AreaDao areaDao;

    public AreaVo findById(String id) {
        return areaDao.selectById(id);
    }

    public List<AreaVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return areaDao.selectByPage(params, page);
    }
    
    public List<TreeNode> queryTree(String code,String name,String parentCode,String status){
    	
    	//展开节点
    	if (StringUtils.isNotBlank(parentCode)) {
    		return queryTreeByParentCode(parentCode,status);
		}
    	
    	//如果没有给查询条件，那么返回根节点
    	if (StringUtils.isBlank(code) && StringUtils.isBlank(name) && !Constants.STATUS_DISABLED.equals(status)) {
        	return queryTreeByParentCode(parentCode,status);
		}
    	
    	//查询
    	Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		params.put("cnName", name);
		params.put("status", status);
		List<AreaVo> list = areaDao.selectByPage(params);
		if (list == null || list.size() == 0) {
			return new ArrayList<TreeNode>();
		}
		
		//建索引
		Map<String, AreaVo> areaMap = new HashMap<String, AreaVo>(Math.max((int) (list.size()/0.75f) + 1, 16));
		
		//取得自己以及所有祖先的编码
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < list.size(); i++) {
			AreaVo areaVo = list.get(i);
			String path = areaVo.getFullPathCode();
			String[] split = path.split("/");
			for (int j = 0; j < split.length; j++) {
				set.add(split[j]);
			}
			areaMap.put(areaVo.getCode(), areaVo);
		}
		
		//拼成串
    	boolean isFirst = true;
    	String codes = "";
    	int count = 0;
    	Iterator<String> iterator = set.iterator();
    	while (iterator.hasNext()) {
    		count++;
    		String tempCode = iterator.next();
    		if (isFirst) {
    			isFirst = false;
			} else {
				codes += ",";
			}
    		codes += "'"+tempCode+"'";
    		
    		//防止查询过多报错
    		if (count >= com.ey.piit.core.common.Constants.TREE_QUERY_CODE_IN_MAX_COUNT) {
				break;
			}
		}
    	
    	//查询自己以及所有祖先
    	Map<String, Object> param = new HashMap<String, Object>();
    	param.put("codes", codes);
    	List<TreeNode> treeList = areaDao.selectTreeInCode(param);
    	
    	//改变颜色
    	Map<String,String> colorMap = new HashMap<String,String>();
    	colorMap.put(com.ey.piit.core.common.Constants.TREE_NODE_HIGH_LIGHT_COLOR_KEY, com.ey.piit.core.common.Constants.TREE_NODE_HIGH_LIGHT_COLOR_VALUE);
    	for (int i = 0; i < treeList.size(); i++) {
			TreeNode treeNode = treeList.get(i);
			if (areaMap.get(treeNode.getId()) != null) {
				treeNode.setFont(colorMap);
			} else {
				treeNode.setOpen(true);
			}
		}
    	return treeList;
    }
    
    private List<TreeNode> queryTreeByParentCode(String parentCode,String status){
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("parentCode", parentCode);
    	params.put("status", status);
    	return areaDao.selectTreeByParentCode(params);
    }
    
    private String areaListToHtml(List<TreeNode> list,String code) {
    	if (list == null) {
			return "";
		}
    	boolean isHave = false;
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < list.size(); i++) {
    		TreeNode record = list.get(i);
    		boolean isSelected = false;
    		if(code != null && code.equals(record.getId())){
    			isSelected = true;
    			isHave = true;
    		} else if (Constants.STATUS_DISABLED.equals(record.getStatus())) {
    			continue;
    		}
    		sb.append("<option value=\"");
    		sb.append(record.getId());//编码
    		
    		if (isSelected) {
    			sb.append("\" selected>");
			} else {
				sb.append("\">");
			}
    		sb.append(record.getExt2());
    		sb.append("</option>");
		}
    	if(!isHave && StringUtils.isNotBlank(code)){
    		sb.insert(0, "</option>");
    		sb.insert(0, code);
    		sb.insert(0, "\" selected>");
    		sb.insert(0, code);
    		sb.insert(0, "<option value=\"");
    	}
    	return sb.toString();
    }
    
    public String loadAreaOption(String parentCode, String code){
    	List<TreeNode> list = queryTreeByParentCode(parentCode,null);
    	return areaListToHtml(list,code);
    }

    @Override
    protected ICoreDao getDao() {
        return areaDao;
    }

	@Override
	protected int save(CoreEntity record) {
		record.setPub(true);
		
		AreaVo area = (AreaVo)record;
		area.setChildCount(0);
		
		int result = 0;
		try {
			result = super.save(record);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				throw new ValidateException("编码重复");
			}
			throw e;
		}
		
		if (StringUtils.isNotBlank(area.getParentCode())) {
			
			//增加孩子计数
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("childCountAdd", "Y");
			params.put("code", area.getParentCode());
			areaDao.updateChildCountByCode(params);
		}
		
		return result;
	}
	
	@Override
	protected int update(CoreEntity record) {
		record.setPub(true);
		
		AreaVo area = (AreaVo)record;
		String oldParentCode = area.getOldParentCode() == null ? "" : area.getOldParentCode();
		String newParentCode = area.getParentCode() == null ? "" : area.getParentCode();
		String oldPath = area.getCode();
		String newPath = area.getFullPathCode();
		int oldParentLevel = 1;
		int newParentLevel = 1;
		String oldStatus = area.getOldStatus() == null ? "" : area.getOldStatus();
		String newStatus = area.getStatus() == null ? "" : area.getStatus();
		AreaVo newParentDb = null;
		List<AreaVo> childList = null;
		boolean isChangeParentCode = !oldParentCode.equals(newParentCode);
		
		//如果上级节点发生变化
		if (isChangeParentCode) {
			childList = areaDao.selectChildByCode(area.getCode());//需要先查，再更新本节点，如果顺序倒过来会出错
		}
		
		int result = 0;
		try {
			result = super.update(record);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				throw new ValidateException("编码重复");
			}
			throw e;
		}
		
		//如果上级节点发生变化
		if (isChangeParentCode) {
			if (StringUtils.isNotBlank(newParentCode)) {
				
				//增加孩子计数
				if (newParentDb == null) {
					newParentDb = findByCode(newParentCode);
				}
				
				newParentLevel = newParentDb.getLevels();
				
				AreaVo newParent = new AreaVo();
				newParent.setId(newParentDb.getId());
				newParent.setChildCount(newParentDb.getChildCount() + 1);
				if (newParent.getChildCount() < 0) {
					throw new ServiceException("系统错误");
				}
				areaDao.updateById(newParent);
			}
			
			if (StringUtils.isNotBlank(oldParentCode)) {
				
				//减少孩子计数
				AreaVo oldParentDb = findByCode(oldParentCode);
				
				oldPath = oldParentDb.getFullPathCode() + "/" + area.getCode();
				oldParentLevel = oldParentDb.getLevels();
				
				AreaVo oldParent = new AreaVo();
				oldParent.setId(oldParentDb.getId());
				oldParent.setChildCount(oldParentDb.getChildCount() - 1);
				if (oldParent.getChildCount() < 0) {
					throw new ServiceException("系统错误");
				}
				areaDao.updateById(oldParent);
			}
			
			int level = newParentLevel - oldParentLevel;
			
			//修改全路径和层级
			for (int i = 0; i < childList.size(); i++) {
				AreaVo areaSubDb = childList.get(i);
				AreaVo areaSub = new AreaVo();
				areaSub.setId(areaSubDb.getId());
				areaSub.setFullPathCode(areaSubDb.getFullPathCode().replaceFirst(oldPath, newPath));
				areaSub.setLevels(areaSubDb.getLevels() + level);
				areaDao.updateById(areaSub);
			}
		}
		
		//如果状态发生改变
		if (!oldStatus.equals(newStatus)) {
			if (Constants.STATUS_DISABLED.equals(newStatus)) {//禁用
				if(StringUtils.isNotBlank(area.getFullPathCode())){
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("path", area.getFullPathCode());
					params.put("status", 0);
					areaDao.updateChildStatusByPath(params);
				}
			}
		}
		
		return result;
	}

	@Override
	protected void deleteAfter(CoreEntity record) {
		record.setPub(true);
		
		AreaVo area = (AreaVo)record;
		
		if (StringUtils.isNotBlank(area.getParentCode())) {
			
			//减少孩子计数
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("childCountDel", "Y");
			params.put("code", area.getParentCode());
			areaDao.updateChildCountByCode(params);
		}
	}
	
	@Override
	public void validate(CoreEntity record) {
		AreaVo area = (AreaVo)record;
		String code = area.getCode();
		if (StringUtils.isNotBlank(code) && code.equals(area.getParentCode())) {
			throw new ServiceException("上级节点不能是本节点");
		}
		
		if (StringUtils.isNotBlank(area.getParentCode())) {
			AreaVo newParentDb = findByCode(area.getParentCode());
			if (Constants.STATUS_DISABLED.equals(newParentDb.getStatus())) {
				if (Constants.STATUS_ENABLED.equals(area.getStatus())) {
					throw new ValidateException("上级节点被禁用，状态不能改为启用");
				}
			}
		}
		
		if (StringUtils.isBlank(area.getCode())) {
			throw new ServiceException("编码不能为空");
		}
		if (StringUtils.isBlank(area.getCnName())) {
			throw new ServiceException("中文名称不能为空");
		}
		if (StringUtils.isBlank(area.getStatus())) {
			throw new ServiceException("状态不能为空");
		}
	}

	public AreaVo findByCode(String code){
		if(StringUtils.isNotBlank(code)){
			AreaVo areaVo = areaDao.selectByCode(code);
			return areaVo;
		}
		return null;
	}
    
}