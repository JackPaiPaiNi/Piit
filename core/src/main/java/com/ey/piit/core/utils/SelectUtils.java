package com.ey.piit.core.utils;

import java.util.HashMap;
import java.util.Map;

import com.ey.piit.core.entity.SelectBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SelectUtils {

	/**
	 * 过滤重复操作
	 * 格式：[{"id":"1","oper":"add"},{"id":"2","oper":"del"}]
	 * @param json
	 * @return
	 */
	public static Map<String,String> filterRepeat(String json) {
		Map<String,String> map = new HashMap<String,String>();
		if (StringUtils.isBlank(json)) {
			return map;
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			SelectBean[] arr = objectMapper.readValue(json, SelectBean[].class);
	        for (int i = 0; i < arr.length; i++) {
	        	SelectBean selectBean = arr[i];
	        	String id = selectBean.getId();
	        	String oper = selectBean.getOper();
	        	String mapOper = map.get(id);
	        	if (mapOper != null) {
	        		if (!mapOper.equals(oper)) {
	        			map.remove(id);
					}
				} else {
					map.put(id, oper);
				}
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("Json格式转换异常",e);
	    }
		return map;
	}
	
}
