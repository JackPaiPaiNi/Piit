package com.ey.piit.basesys.utils;

import java.util.HashMap;
import java.util.Map;

import com.ey.piit.basesys.para.repository.ParaConfigDao;
import com.ey.piit.basesys.para.vo.ParaConfigVo;
import com.ey.piit.core.common.Constants;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.CacheUtils;
import com.google.common.collect.Maps;

/**
 * 参数配置工具类
 */
public class ParaConfigUtils {
	private static ParaConfigDao paraConfigDao = SpringUtils.getBean(ParaConfigDao.class);

	public static final String CACHE_PARA_CONFIG = "paraCache";
	
	public static Map<String, ParaConfigVo> queryParaConfig(){
		@SuppressWarnings("unchecked")
		Map<String, ParaConfigVo> map = (Map<String, ParaConfigVo>)CacheUtils.get(CACHE_PARA_CONFIG);
		if (map == null) {
			map = Maps.newHashMap();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("status", Constants.STATUS_ENABLED);
			for (ParaConfigVo vo : paraConfigDao.selectByPage(params)){
				map.put(vo.getKey(), vo);
			}
			CacheUtils.put(CACHE_PARA_CONFIG,map);
		}
		return map;
	}
	
	public static ParaConfigVo findParaConfig(String key){
		Map<String, ParaConfigVo> map = queryParaConfig();
		ParaConfigVo vo = map.get(key);
		if (null == vo) {
			return null;
		}
		return vo;
	}
	
	public static String findParaVal(String key){
		Map<String, ParaConfigVo> map = queryParaConfig();
		ParaConfigVo vo = map.get(key);
		if (null == vo) {
			return null;
		}
		return vo.getValue();
	}
	
	/*public static String findParaVal(String key, String status){
		Object object = CacheUtils.get(CACHE_PARA_CONFIG, key);
		if (null == object) {
			return null;
		}
		ParaConfigVo vo = (ParaConfigVo)object;
		if (status == vo.getStatus()) {
			return vo.getValue();
		}
		return null;
	}*/
	
	public static void clearCache(){
		CacheUtils.remove(CACHE_PARA_CONFIG);
	}
	
}
