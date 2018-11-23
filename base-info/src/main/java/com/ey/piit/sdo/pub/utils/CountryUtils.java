package com.ey.piit.sdo.pub.utils;

import java.util.List;

import com.ey.piit.baseinfo.area.vo.AreaVo;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.pub.repository.Select2Dao;

public class CountryUtils {
	
	private static Select2Dao select2Dao = (Select2Dao) SpringUtils.getBean(Select2Dao.class);
	
    public static String loadCountryOption(String isjqGrid) {
    	List<AreaVo> list = select2Dao.selectAllCountry();
    	if (list == null) {
			return "";
		}
		if("1".equals(isjqGrid)){
			return gjListToJson(list, null, null);
		} else {
			return gjListToHtml(list, null, null);
		}
    }
    
	public static String gjListToHtml(List<AreaVo> list,String code,String showType) {
		if (list == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<option role=\"option\" value=\"\">--请选择--</option>");
		for (int i = 0; i < list.size(); i++) {
			AreaVo record = list.get(i);
			sb.append("<option role=\"option\" value=\"");
			sb.append(record.getCode());
			sb.append("\">");
			sb.append(record.getCnName());
			sb.append("</option>");
		}
		return sb.toString();
	}
	
    public static String gjListToJson(List<AreaVo> list,String code,String showType) {
    	if (list == null) {
			return "";
		}
    	StringBuilder sb = new StringBuilder();
    	sb.append(":请选择;");
    	for (int i = 0; i < list.size(); i++) {
    		AreaVo record = list.get(i);
    		sb.append(record.getCode());
    		sb.append(":");
    		sb.append(record.getCnName());
    		sb.append(";");
		}
    	return StringUtils.substringBeforeLast(sb.toString(), ";");
    }
    
}
