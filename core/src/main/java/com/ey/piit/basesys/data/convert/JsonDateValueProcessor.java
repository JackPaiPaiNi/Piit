package com.ey.piit.basesys.data.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ey.piit.core.utils.DateUtils;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateValueProcessor implements JsonValueProcessor {
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		if (value == null)
			return null;

		String[] array = (String[]) value;
		Date[] dates = new Date[array.length];
		for (int i = 0, n = dates.length; i < n; i++) {
			dates[i] = DateUtils.convert(array[i]);
		}
		return dates;
	}

	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		if (value == null)
			return null;

		return new SimpleDateFormat(DEFAULT_DATE_PATTERN).format(value);
	}

}
