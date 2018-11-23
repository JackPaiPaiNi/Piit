package com.ey.piit.sdo.pub.utils;

import java.util.List;

import com.ey.piit.core.repository.OrganizationDao;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.OrganizationVo;



public class OrganaziationUtils {
	
	private static OrganizationDao organizationDao = (OrganizationDao) SpringUtils.getBean(OrganizationDao.class);
	
	public static String loadYwzOption(String isjqGrid){
		List<OrganizationVo> list1 = organizationDao.selectChildByCode("0101");
		List<OrganizationVo> list2 = organizationDao.selectChildByCode("0102");
		List<OrganizationVo> list3 = organizationDao.selectChildByCode("0103");
		List<OrganizationVo> list4 = organizationDao.selectChildByCode("0104");
		list1.addAll(list2);list3.addAll(list4);list1.addAll(list3);
		if("1".equals(isjqGrid)){
			return ywzListToJqGrid(list1, null, null);
		} else {
			return ywzListHtml(list1, null, null);
		}
	}

	public static String ywzListHtml(List<OrganizationVo> list,String code,String showType) {
		if (list == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<option role=\"option\" value=\"");
		sb.append("");
		sb.append("\">");
		sb.append("--请选择--");
		sb.append("</option>");
		for (int i = 0; i < list.size(); i++) {
			OrganizationVo record = list.get(i);
			sb.append("<option role=\"option\" value=\"");
			sb.append(record.getCode());
			sb.append("\">");
			sb.append(record.getName());
			sb.append("</option>");
		}
		return sb.toString();
	}
	
    public static String ywzListToJqGrid(List<OrganizationVo> list,String code,String showType) {
    	if (list == null) {
			return "";
		}
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < list.size(); i++) {
    		OrganizationVo record = list.get(i);
    		sb.append(record.getCode());
    		sb.append(":");
    		sb.append(record.getName());
    		sb.append(";");
		}
    	return StringUtils.substringBeforeLast(sb.toString(), ";");
    }

}
