package com.ey.piit.baseinfo.utils;

import java.util.List;
import java.util.Map;

import com.ey.piit.baseinfo.common.Constants;
import com.ey.piit.baseinfo.dict.repository.DictDao;
import com.ey.piit.baseinfo.dict.vo.DictVo;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.CacheUtils;
import com.ey.piit.core.utils.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 字典工具类
 */
public class DictUtils {
	private static DictDao dictDao = SpringUtils.getBean(DictDao.class);

	public static final String CACHE_DICT_MAP = "dictMap";
	
	public static String findDictName(String code, String type, String defaultCode){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(code)){
			for (DictVo dict : queryByType(type)){
				if (type.equals(dict.getParentType()) && code.equals(dict.getCode())){
					return dict.getName();
				}
			}
		}
		return defaultCode;
	}
	
	public static String findDictNames(String codes, String type, String defaultCode){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(codes)){
			List<String> valueList = Lists.newArrayList();
			for (String code : StringUtils.split(codes, ",")){
				valueList.add(findDictName(code, type, defaultCode));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultCode;
	}

	public static String findDictCode(String name, String type, String defaultName){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(name)){
			for (DictVo dict : queryByType(type)){
				if (type.equals(dict.getParentType()) && name.equals(dict.getName())){
					return dict.getCode();
				}
			}
		}
		return defaultName;
	}
	
	public static List<DictVo> queryByType(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<DictVo>> dictMap = (Map<String, List<DictVo>>)CacheUtils.get(CACHE_DICT_MAP);
		if (dictMap == null || dictMap.get(type) == null){
			dictMap = Maps.newHashMap();
			for (DictVo dict : dictDao.selectByType(type)){
				List<DictVo> dictList = dictMap.get(dict.getParentType());
				if (dictList != null){
					dictList.add(dict);
				}else{
					dictMap.put(dict.getParentType(), Lists.newArrayList(dict));
				}
			}
			CacheUtils.put(CACHE_DICT_MAP, dictMap);
		}
		List<DictVo> dictList = dictMap.get(type);
		if (dictList == null){
			dictList = Lists.newArrayList();
		}
		return dictList;
	}
	
	private static String dictListToHtml(List<DictVo> list,String code,String showType) {
    	if (list == null) {
			return "";
		}
    	StringBuilder sb = new StringBuilder();
		sb.append("<option role=\"option\" value=\"\"");
		if (code != null){
			sb.append(">");
		} else {
			sb.append(" selected>");
		}
		sb.append("--请选择--</option>");
    	for (int i = 0; i < list.size(); i++) {
    		DictVo record = list.get(i);
    		sb.append("<option role=\"option\" value=\"");
    		sb.append(record.getCode());
    		sb.append("\" id=\"");
    		sb.append(record.getId());
    		
    		if (code != null && code.equals(record.getCode())) {
    			sb.append("\" selected>");
			} else {
				sb.append("\">");
			}
    		
    		if (StringUtils.isBlank(showType)) {
    			sb.append(record.getName());
			} else if (Constants.DICT_TYPE_SHOW_TYPE_CODE_NAME.equals(showType)) {
				sb.append(record.getCode());
				sb.append("-");
				sb.append(record.getName());
			}
    		sb.append("</option>");
		}
    	return sb.toString();
    }
    
    public static String loadDictOption(String type,String code,String showType){
    	List<DictVo> list = queryByType(type);
    	return dictListToHtml(list,code,showType);
    }
    
    public static String loadDictCodeNameOption(String type){
    	List<DictVo> list = queryByType(type);
    	return dictListToHtml(list,null,"01");
    }
    
    public static String loadDictOption(String type){
    	List<DictVo> list = queryByType(type);
    	return dictListToHtml(list,null,null);
    }
    
    public static String loadDictEditOption(String type){
    	List<DictVo> list = queryByType(type);
    	return dictListToJson(list);
    }
    
    private static String dictListToJson(List<DictVo> list) {
    	if (list == null) {
			return "";
		}
    	StringBuilder sb = new StringBuilder();
    	sb.append(":请选择;");
    	for (int i = 0; i < list.size(); i++) {
    		DictVo record = list.get(i);
    		sb.append(record.getCode());
    		sb.append(":");
    		sb.append(record.getName());
    		sb.append(";");
		}
    	return StringUtils.substringBeforeLast(sb.toString(), ";");
    }
    
    public static void clearCache(){
		CacheUtils.remove(CACHE_DICT_MAP);
	}
	
}
