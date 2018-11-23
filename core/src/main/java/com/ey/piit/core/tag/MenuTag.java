package com.ey.piit.core.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ey.piit.core.vo.ResourceVo;

public class MenuTag extends SimpleTagSupport{
	
	private List<ResourceVo> menus;

	public void setMenus(List<ResourceVo> menus) {
		this.menus = menus;
	}

	@Override
	public void doTag() throws JspException, IOException {
		String menus = buildMenus(this.menus);
		getJspContext().getOut().write(menus);
	}
	
	private String buildMenus(List<ResourceVo> menus){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < menus.size(); i++) {
			ResourceVo menu = menus.get(i);
			if (menu.getChildren() == null) {
				sb.append("<li>");
				sb.append("<a id=\"menu_").append(menu.getId()).append("\" href=\"javascript:addTabs({id:'").append(menu.getId()).append("',title: '").append(menu.getName()).append("',close: true,url: '").append(menu.getUrl()).append("'});\">");
				sb.append("<i class=\"").append(menu.getIcon()).append("\"></i>");
//				sb.append("<span class=\"menu-text\">").append(menu.getName()).append("</span>");
				sb.append(menu.getName());
				sb.append("</a>");
				sb.append("</li>");
			} else {
				sb.append("<li>");
				sb.append("<a href=\"javascript:void(0);\" class=\"dropdown-toggle\">");
				sb.append("<i class=\"").append(menu.getIcon()).append("\"></i>");
				sb.append("<span class=\"menu-text\">").append(menu.getName()).append("</span>");
				sb.append("<b class=\"arrow icon-angle-down\"></b>");
				sb.append("</a>");
				sb.append("<ul class=\"submenu\">");
				sb.append(buildMenus(menu.getChildren()));
				sb.append("</ul>");
				sb.append("</li>");
			}
		}
		return sb.toString();
	}

}
