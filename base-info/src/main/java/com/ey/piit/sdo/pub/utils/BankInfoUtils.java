package com.ey.piit.sdo.pub.utils;

import java.util.List;

import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.mdm.repository.BankDao;
import com.ey.piit.sdo.mdm.vo.BankVo;

public class BankInfoUtils {
	private static BankDao bankDao = (BankDao) SpringUtils.getBean(BankDao.class);

	/**
	 * 
	 * @param isjqGrid
	 * @return isjqGrid： 1 代表jqGrid下拉用 0 代表页面下拉用
	 */
	public static String loadBankInfoOption(String isjqGrid) {
		List<BankVo> list = (List<BankVo>) bankDao.select(new BankVo());
		if (list == null) {
			return "";
		}
		if ("1".equals(isjqGrid)) {
			return gjListToJson(list, null, null);
		} else {
			return gjListToHtml(list, null, null);
		}
	}

	public static String gjListToHtml(List<BankVo> list, String code,
			String showType) {
		if (list == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<option role=\"option\" value=\"\">--请选择--</option>");
		for (int i = 0; i < list.size(); i++) {
			BankVo record = list.get(i);
			sb.append("<option role=\"option\" value=\"");
			sb.append(record.getSwiftdm());
			sb.append("\">");
			sb.append(record.getZwmc());
			sb.append("</option>");
		}
		return sb.toString();
	}

	public static String gjListToJson(List<BankVo> list, String code,
			String showType) {
		if (list == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
    	sb.append(":请选择;");
		for (int i = 0; i < list.size(); i++) {
			BankVo record = list.get(i);
			sb.append(record.getSwiftdm());
			sb.append(":");
			sb.append(record.getZwmc());
			sb.append(";");
		}
		return StringUtils.substringBeforeLast(sb.toString(), ";");
	}
}
