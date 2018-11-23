package com.ey.piit.basesys.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.ey.piit.basesys.data.excel.ExcelExporter;
import com.ey.piit.core.utils.StringUtils;

/**
 * Exporter Factory
 * @author Kevin-Y.Xu
 */
public class ExporterFactory {
	
	public final static String FORMAT_EXCEL = "xls";
	public final static String FORMAT_PDF = "pdf";
	
	public final static String FORMAT_EXCEL_CONTENT_TYPE = "application/vnd.ms-excel";
	
	@Autowired
	private ExcelExporter excelExporter;

	public BaseExporter createExporter(String format) {
		
		BaseExporter exporter = null;
		
		if (StringUtils.isEmpty(format))
			format = FORMAT_EXCEL;
		
		if (FORMAT_EXCEL.equals(format)) {
			exporter = excelExporter;
		} else {
			return null;
		}
		
		return exporter;
	}
}
