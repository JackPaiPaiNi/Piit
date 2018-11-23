package com.ey.piit.sdo.pub.utils;

import java.util.List;

import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.mdm.repository.ModelInfoDao;
import com.ey.piit.sdo.mdm.vo.ModelInfoVo;

public class ModelUtils {
	
	private static ModelInfoDao modelInfoDao = (ModelInfoDao) SpringUtils.getBean(ModelInfoDao.class);
	
    public static String loadModelOption(String isjqGrid, String type) {
    	List<ModelInfoVo> list = modelInfoDao.selectByType(type);
    	if (list == null) {
			return "";
		}
		if("1".equals(isjqGrid)){
			return gjListToJson(list, null, null);
		} else {
			return gjListToHtml(list, null, null);
		}
    }
    
	public static String gjListToHtml(List<ModelInfoVo> list,String code,String showType) {
		if (list == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<option role=\"option\" value=\"\">--请选择--</option>");
		for (int i = 0; i < list.size(); i++) {
			ModelInfoVo record = list.get(i);
			sb.append("<option role=\"option\" value=\"");
			sb.append(record.getCode());
			sb.append("\">");
			sb.append(record.getName());
			sb.append("</option>");
		}
		return sb.toString();
	}
	
    public static String gjListToJson(List<ModelInfoVo> list,String code,String showType) {
    	if (list == null) {
			return "";
		}
    	StringBuilder sb = new StringBuilder();
    	sb.append(":请选择;");
    	for (int i = 0; i < list.size(); i++) {
    		ModelInfoVo record = list.get(i);
    		sb.append(record.getCode());
    		sb.append(":");
    		sb.append(record.getName());
    		sb.append(";");
		}
    	return StringUtils.substringBeforeLast(sb.toString(), ";");
    }
    
}
