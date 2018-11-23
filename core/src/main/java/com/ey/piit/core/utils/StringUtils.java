package com.ey.piit.core.utils;

import java.util.Iterator;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class StringUtils extends org.apache.commons.lang3.StringUtils{

	public static String getCompactStringFromJson(JSONObject jsonObject) {

		if (jsonObject == null)
			return null;

		try {
			Iterator keys = jsonObject.keys();
			StringBuffer sb = new StringBuffer("{");

			while (keys.hasNext()) {
				Object key = keys.next();
				Object value = jsonObject.get(key);

				if (value == null)
					continue;
				if (value instanceof String
						&& StringUtils.isEmpty((String) value))
					continue;

				if (sb.length() > 1) {
					sb.append(',');
				}

				sb.append(JSONUtils.quote(key.toString()));
				sb.append(':');
				sb.append(JSONUtils.valueToString(jsonObject.get(key)));
			}
			sb.append('}');
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
	
}
