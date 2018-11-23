package com.ey.piit.basesys.data.handler;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;

import com.ey.piit.basesys.data.entity.ExportSetting;
import com.ey.piit.basesys.data.entity.GridGroupHeader;
import com.ey.piit.basesys.data.entity.GridModel;
import com.ey.piit.core.utils.DateUtils;
import com.ey.piit.core.utils.StringUtils;

import net.sf.cglib.beans.BeanMap;

/**
 * 导出处理类
 * 
 * @author Kevin-Y.Xu
 *
 */
public class ExportDataHandler {

	/**
	 * 定义表头
	 */
	public void handleHead(final Workbook wbook, final Sheet sheet, final ExportSetting setting) {
		// 根据ExportColNames来创建Excel的列名
		Map<Integer, String> colNames = setting.getExportColNames();
		Map<Integer, List<GridGroupHeader>> groupHeaderList = setting.getExportGroupHeaderList();
		int titleRowTotal = groupHeaderList.size();

		CellStyle style = wbook.createCellStyle();// 新建样式对象
		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());// 设置表头背景颜色
		style.setFillPattern(org.apache.poi.ss.usermodel.FillPatternType.SOLID_FOREGROUND);
		style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
		style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);

		style.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN); // 下边框
		style.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN); // 左边框
		style.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle.THIN); // 上边框
		style.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN); // 右边框

		XSSFFont font = (XSSFFont) wbook.createFont();// 创建字体对象
		font.setFontName("微软雅黑");
		style.setFont(font);

		Map<Integer, Integer> colNumMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < titleRowTotal; i++) {
			List<GridGroupHeader> list = groupHeaderList.get(i);
			Row header = sheet.createRow(i);
			for (int j = 0; j < list.size(); j++) {
				GridGroupHeader groupHeader = list.get(j);
				int colNum = groupHeader.getStartColumn();

				Integer total = colNumMap.get(colNum);
				if (total == null) {
					total = 0;
				}
				colNumMap.put(colNum, total + 1);
				Integer numberOfColumns = groupHeader.getNumberOfColumns();
				if (1 != numberOfColumns) {
					int colEnd = colNum + numberOfColumns - 1;
					CellRangeAddress cra = new CellRangeAddress(i, i, colNum, colEnd);
					this.setRegionStyle(sheet, cra, style);
					sheet.addMergedRegion(cra);

					int curNum = colNum + 1;
					while (curNum <= colEnd) {
						Integer curTotal = colNumMap.get(curNum);
						if (curTotal == null) {
							curTotal = 0;
						}
						colNumMap.put(curNum, curTotal + 1);
						curNum++;
					}
				}
				Cell cell = header.createCell(colNum);
				cell.setCellStyle(style);
				cell.setCellValue(groupHeader.getTitleText());
			}
		}

		int count = colNames.size();
		Row header = sheet.createRow(titleRowTotal);
		for (int i = 0; i < count; i++) {
			String name = colNames.get(i);
			if (name == null) {
				break;
			}
			Integer rowNum = titleRowTotal;
			if (titleRowTotal != 0) {
				rowNum = colNumMap.get(i);
				rowNum = rowNum == null ? 0 : rowNum;
				if (titleRowTotal != rowNum) {
					CellRangeAddress cra = new CellRangeAddress(rowNum, titleRowTotal, i, i);
					this.setRegionStyle(sheet, cra, style);
					sheet.addMergedRegion(cra);
				}
			}
			header = sheet.getRow(rowNum);
			Cell cell = header.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(name);
		}
	}

	/**
	 * 处理数据
	 */
	public void handleDatas(final Workbook wbook, final Sheet sheet, final ExportSetting setting,
			final Collection<?> list) {
		Map<Integer, List<GridGroupHeader>> groupHeaderList = setting.getExportGroupHeaderList();
		Map<Integer, String> colNames = setting.getExportColNames();

		Map<Integer, String> colModels = setting.getExportColModels();
		Map<Integer, GridModel> colModelList = setting.getExportColModelList();

		for (int i = 0; i < colModelList.size(); i++) {
			GridModel model = colModelList.get(i);

			CellStyle cellStyle = getTextStyle(wbook);

			if (model.getFormatoptions() != null && StringUtils.isNotBlank(model.getFormatoptions().getNewformat())) {
				String format = model.getFormatoptions().getNewformat();
				if ("Y-m-d H:i:s".equals(format)) {
					format = "yyyy-MM-dd HH:mm:ss";
				} else if ("Y-m-d".equals(format)) {
					format = "yyyy-MM-dd";
				}
				DataFormat dataFormat = wbook.createDataFormat();
				cellStyle.setDataFormat(dataFormat.getFormat(format));
			}

			model.setCellStyle(cellStyle);
		}

		int rowNum = groupHeaderList.size();
		for (Object obj : list) {
			rowNum++;
			Row row = sheet.createRow(rowNum);
			Map<?, ?> map = BeanMap.create(obj);
			for (int i = 0; i < colNames.size(); i++) {
				GridModel model = colModelList.get(i);
				CellStyle cellStyle = model.getCellStyle();
				String col = colModels.get(i);
				Object propertye = map.get(col);
				Cell cell = row.createCell(i);

				if (propertye == null) {
					cell.setCellStyle(cellStyle);
					cell.setCellType(org.apache.poi.ss.usermodel.CellType.BLANK);
				} else {
					cell.setCellStyle(cellStyle);
					if (model.getEditoptions() != null && model.getMaps() != null) { // map转换
						String value = model.getMaps().get(propertye.toString());
						// cell.setCellType(Cell.CELL_TYPE_STRING);
						// 特殊处理FLAG字段(I-U-S-D)导出KEY值2017-1-9 ZhaoMing
						if ("flag".equals(model.getName())) {
							cell.setCellValue(propertye.toString());
						} else {
							cell.setCellValue(value);
						}
					} else if (propertye instanceof Date) {
						Date date = null;
						try {
							date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US)
									.parse(propertye.toString());
						} catch (Exception e) {
							date = DateUtils.convert(propertye.toString());
						}
						cell.setCellValue(date);
					} else if (propertye instanceof Integer) {
						cell.setCellValue(Integer.parseInt(propertye.toString()));
					} else if (propertye instanceof Double || propertye instanceof BigDecimal) {
						cell.setCellValue(Double.parseDouble(propertye.toString()));
					} else {
						cell.setCellValue(propertye.toString());
					}
				}

			}
		}

		/*
		 * for (int i = 0; i < colNames.size(); i++) { sheet.autoSizeColumn(i,
		 * true); // 调整宽度 }
		 */
	}

	protected CellStyle getTextStyle(Workbook wbook) {
		// 设置单元格类型
		CellStyle cellStyle = wbook.createCellStyle();

		cellStyle.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN); // 下边框
		cellStyle.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN); // 左边框
		cellStyle.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle.THIN); // 上边框
		cellStyle.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN); // 右边框

		XSSFFont font = (XSSFFont) wbook.createFont();// 创建字体对象
		font.setFontName("微软雅黑");
		font.setFontHeight(9);
		cellStyle.setFont(font);
		return cellStyle;
	}

	protected void setRegionStyle(Sheet sheet, CellRangeAddress region, CellStyle cellStyle) {
		RegionUtil.setBorderTop(cellStyle.getBorderTopEnum().getCode(), region, sheet);
		RegionUtil.setBorderRight(cellStyle.getBorderRightEnum().getCode(), region, sheet);
		RegionUtil.setBorderBottom(cellStyle.getBorderBottomEnum().getCode(), region, sheet);
		RegionUtil.setBorderLeft(cellStyle.getBorderLeftEnum().getCode(), region, sheet);
	}
}
