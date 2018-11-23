package com.ey.piit.sdo.pub.utils;

import java.util.List;

import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.mdm.repository.CompanyInfoDao;
import com.ey.piit.sdo.mdm.vo.CompanyInfoVo;

public class CompanyInfoUtils {
	
	private static CompanyInfoDao companyInfoDao = (CompanyInfoDao) SpringUtils.getBean(CompanyInfoDao.class);
	
	public static String loadCompanyOption(String isjqGrid){
		CompanyInfoVo companyVo = new CompanyInfoVo();

		List<CompanyInfoVo> list = companyInfoDao.select(companyVo);
		if("1".equals(isjqGrid)){
			return companyListToJqGrid(list, null, null);
		} else {
			return companyListToHtml(list, null, null);
		}
	}

	public static String companyListToHtml(List<CompanyInfoVo> list,String code,String showType) {
		if (list == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<option role=\"option\" value=\"\">--请选择--</option>");
		for (int i = 0; i < list.size(); i++) {
			CompanyInfoVo record = list.get(i);
			sb.append("<option role=\"option\" value=\"");
			sb.append(record.getGsbm());
			sb.append("\">");
			sb.append(record.getGsbm()+"-"+record.getGszwmc());
			sb.append("</option>");
		}

		return sb.toString();
	}
	
    public static String companyListToJqGrid(List<CompanyInfoVo> list,String code,String showType) {
    	if (list == null) {
			return "";
		}
    	StringBuilder sb = new StringBuilder();
    	sb.append(":请选择;");
    	for (int i = 0; i < list.size(); i++) {
    		CompanyInfoVo record = list.get(i);
    		sb.append(record.getGsbm());
    		sb.append(":");
    		sb.append(record.getGsbm());
    		sb.append(";");
		}
    	return StringUtils.substringBeforeLast(sb.toString(), ";");
    }

}
