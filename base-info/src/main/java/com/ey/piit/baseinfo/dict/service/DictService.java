/*
 * DictService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-12 Created
 */
package com.ey.piit.baseinfo.dict.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.baseinfo.common.Constants;
import com.ey.piit.baseinfo.dict.repository.DictDao;
import com.ey.piit.baseinfo.dict.vo.DictVo;
import com.ey.piit.baseinfo.utils.DictUtils;
import com.ey.piit.basesys.utils.ParaConfigUtils;
import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.HttpUtils;
import com.ey.piit.core.utils.StringUtils;

/**
 * T_DICT 包括:币种、税种、公司类型
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-12
 */
@Service
public class DictService extends CoreService {

	@Autowired
	private DictDao dictDao;
	@Autowired
	private ExportUtil exportUtil;

	private static Map<String, Map<String, DictVo>> map;

	public DictVo findById(String id) {
		return dictDao.selectById(id);
	}

	public List<DictVo> queryByPage(Map<String, Object> params, PageBounds page) {
		return dictDao.selectByPage(params, page);
	}

	@Override
	protected ICoreDao getDao() {
		return dictDao;
	}

	public String loadDictOption(String type, String code, String showType) {
		return DictUtils.loadDictOption(type, code, showType);
	}

	private List<TreeNode> dictListToTree(List<DictVo> list, String showType) {
		if (list == null) {
			return new ArrayList<TreeNode>();
		}
		List<TreeNode> treeList = new ArrayList<TreeNode>(list.size());
		for (int i = 0; i < list.size(); i++) {
			DictVo record = list.get(i);
			TreeNode tree = new TreeNode();
			tree.setId(record.getCode());
			tree.setExt(record.getId());
			tree.setpId(record.getParentCode());

			if (StringUtils.isBlank(showType)) {
				tree.setName(record.getName());
			} else if (Constants.DICT_TYPE_SHOW_TYPE_CODE_NAME.equals(showType)) {
				tree.setName(record.getCode() + "-" + record.getName());
			}
			treeList.add(tree);
		}
		return treeList;
	}

	public List<TreeNode> loadDictTree(String type, String showType) {
		List<DictVo> list = queryByType(type);
		return dictListToTree(list, showType);
	}

	private List<TreeNode> dictListToLazyTree(List<DictVo> list, String parentCode, String showType) {
		if (list == null) {
			return new ArrayList<TreeNode>();
		}
		List<TreeNode> treeList = new ArrayList<TreeNode>(list.size());
		for (int i = 0; i < list.size(); i++) {
			DictVo record = list.get(i);
			if (StringUtils.isBlank(parentCode)) {
				if (StringUtils.isNotBlank(record.getParentCode())) {
					continue;
				}
			} else if (!parentCode.equals(record.getParentCode())) {
				continue;
			}
			TreeNode tree = new TreeNode();
			tree.setId(record.getCode());
			tree.setExt(record.getId());
			tree.setpId(record.getParentCode());

			if (StringUtils.isBlank(showType)) {
				tree.setName(record.getName());
			} else if (Constants.DICT_TYPE_SHOW_TYPE_CODE_NAME.equals(showType)) {
				tree.setName(record.getCode() + "-" + record.getName());
			}
			treeList.add(tree);
		}
		return treeList;
	}

	public List<TreeNode> loadDictLazyTree(String type, String parentCode, String showType) {
		List<DictVo> list = queryByType(type);
		return dictListToLazyTree(list, parentCode, showType);
	}

	public DictVo find(String type, String code) {
		if (map == null || map.isEmpty()) {
			load();
		}
		Map<String, DictVo> inMap = map.get(type);
		if (inMap != null) {
			DictVo dictVo = inMap.get(code);
			return dictVo;
		}
		return null;
	}

	public List<DictVo> queryByType(String type) {
		return DictUtils.queryByType(type);
	}

	public String findByType(String type) {
		List<DictVo> list = queryByType(type);
		if (list == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			DictVo dict = list.get(i);
			if (i != 0) {
				sb.append(";");
			}
			sb.append(dict.getCode());
			sb.append(":");
			sb.append(dict.getName());
		}
		return sb.toString();
	}

	@Override
	protected void saveAfter(CoreEntity record) {
		record.setPub(true);
		// clearCache();//TODO xuy 上线时注掉
		// TODO xuy 上线时解注
		String address = ParaConfigUtils.findParaVal("MAIN_SERVER_ADDRESS");
		HttpUtils.postRequest(address + "/base/common/refreshCache",
				"type=" + com.ey.piit.basesys.common.Constants.CACHE_TYPE_DICT);
	}

	@Override
	protected void updateAfter(CoreEntity record) {
		record.setPub(true);
		// clearCache();//TODO xuy 上线时注掉
		// TODO xuy 上线时解注
		String address = ParaConfigUtils.findParaVal("MAIN_SERVER_ADDRESS");
		HttpUtils.postRequest(address + "/base/common/refreshCache",
				"type=" + com.ey.piit.basesys.common.Constants.CACHE_TYPE_DICT);
	}

	@Override
	protected void deleteAfter(CoreEntity record) {
		record.setPub(true);
		// clearCache();//TODO xuy 上线时注掉
		// TODO xuy 上线时解注
		String address = ParaConfigUtils.findParaVal("MAIN_SERVER_ADDRESS");
		HttpUtils.postRequest(address + "/base/common/refreshCache",
				"type=" + com.ey.piit.basesys.common.Constants.CACHE_TYPE_DICT);
	}

	public static void clearCache() {
		map = null;
		if (map != null) {
			map.clear();
		}
		DictUtils.clearCache();
	}

	private void load() {
		List<DictVo> list = queryAll();
		List<DictVo> typeList = dictDao.selectCountByType();
		Map<String, Map<String, DictVo>> tmpMap = new HashMap<String, Map<String, DictVo>>(
				Math.max((int) (typeList.size() / 0.75f) + 1, 16));

		for (int i = 0; i < list.size(); i++) {
			DictVo record = list.get(i);
			String parentType = record.getParentType();
			int count = 0;
			for (int j = 0; j < typeList.size(); j++) {
				DictVo dictVo = typeList.get(j);
				if (parentType.equals(dictVo.getParentType())) {
					count = Integer.parseInt(dictVo.getExt1());
					break;
				}
			}

			Map<String, DictVo> tmpInMap = tmpMap.get(parentType);
			if (tmpInMap == null) {
				tmpInMap = new HashMap<String, DictVo>(Math.max((int) (count / 0.75f) + 1, 16));
				tmpMap.put(parentType, tmpInMap);
			}
			tmpInMap.put(record.getCode(), record);
		}

		map = tmpMap;
	}

	private List<DictVo> queryAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", "1");
		params.put("order", "PARENT_TYPE,SORT");
		return dictDao.selectByPage(params);
	}

	@Override
	public void validate(CoreEntity record) {
		DictVo dictVo = (DictVo) record;

		if (StringUtils.isBlank(dictVo.getCode())) {
			throw new ServiceException("编码不能为空");
		}
		if (StringUtils.isBlank(dictVo.getName())) {
			throw new ServiceException("名称不能为空");
		}
		if (StringUtils.isBlank(dictVo.getParentType())) {
			throw new ServiceException("类别不能为空");
		}
		if (StringUtils.isBlank(dictVo.getStatus())) {
			throw new ServiceException("状态不能为空");
		}
	}

	public void export(HttpServletResponse response, Map<String, Object> params) {
		try {
			List<DictVo> list = (List<DictVo>) this.queryAll();
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}
}