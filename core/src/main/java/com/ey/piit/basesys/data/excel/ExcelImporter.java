package com.ey.piit.basesys.data.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.BaseImporter;
import com.ey.piit.basesys.data.convert.JsonDateValueProcessor;
import com.ey.piit.basesys.data.entity.FilePersistence;
import com.ey.piit.basesys.data.entity.ImportData;
import com.ey.piit.basesys.data.entity.ImportInfo;
import com.ey.piit.basesys.data.excel.setting.ExcelSetting;
import com.ey.piit.basesys.data.excel.setting.ExcelSettingColumn;
import com.ey.piit.basesys.data.excel.setting.ExcelSettingHelper;
import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.basesys.data.handler.ImportDataPreviewHandler;
import com.ey.piit.basesys.data.service.ImporterService;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.utils.DateUtils;
import com.ey.piit.core.utils.RandomUtils;
import com.ey.piit.core.utils.StringUtils;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

/**
 * Excel 导入类
 */
public class ExcelImporter extends BaseImporter {

	private Map<Class<?>, ExcelSetting> mappings = new HashMap<Class<?>, ExcelSetting>();
	
	private int gRowNum;
	private int gCellNum;
	
	@Autowired
	private ImporterService importerService;
	
	public ExcelImporter() {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(this.getClass().getResourceAsStream("/excel.xml"));
			
			List<ExcelSetting> settings = ExcelSettingHelper.parseExcelSettings(document);
			for(ExcelSetting setting : settings) {
				mappings.put(Class.forName(setting.getClassName()), setting);
			}
		} catch (Exception e) {
			logger.error("no excel.xml");
		}
	}

	// *************************  public methods ************************* //
	
	@Override
	public <E> String importFile(Class<E> clz, File file, Map<String, String> params) {
		if (mappings == null) {
			throw new ServiceException("excel配置信息加载失败！");
		}
		
		String suffix = getSuffix(file.getName());
		File newFile = fillNewFile(file,suffix);
		return importFileCore(clz,newFile,params,suffix);
	}
	
	@Override
	public <E> String importFile(Class<E> clz, MultipartFile file, Map<String, String> params) {
		if (mappings == null) {
			throw new ServiceException("excel配置信息加载失败！");
		}
		
		String suffix = getSuffix(file.getOriginalFilename());
		File newFile = fillNewFile(file,suffix);
		return importFileCore(clz,newFile,params,suffix);
	}

	@Override
	public <E> String importFilePreview(Class<E> clz, File file, Map<String, String> params) {
		if (mappings == null) {
			throw new ServiceException("excel配置信息加载失败！");
		}
		
		String suffix = getSuffix(file.getName());
		File newFile = fillNewFile(file,suffix);
		return importFilePreviewCore(clz,newFile,params,suffix);
	}

	@Override
	public <E> String importFilePreview(Class<E> clz, MultipartFile file, Map<String, String> params) {
		if (mappings == null) {
			throw new ServiceException("excel配置信息加载失败！");
		}
		
		String suffix = getSuffix(file.getOriginalFilename());
		File newFile = fillNewFile(file,suffix);
		return importFilePreviewCore(clz,newFile,params,suffix);
	}
	
	@Override
	public <E> List<E> importFileReturn(Class<E> clz, MultipartFile file, Map<String, String> params) {
		if (mappings == null) {
			throw new ServiceException("excel配置信息加载失败！");
		}
		
		String suffix = getSuffix(file.getOriginalFilename());
		return importFileReturnCore(clz,file,params,suffix);
	}

	public ExcelSetting findExcelSetting(Class<?> clz){
		return mappings.get(clz);
	}

	// *************************  private methods ************************* //

//	@SuppressWarnings("unchecked")
	private <E> List<E> readExcel(Class<E> clz, Sheet sheet,
			ExcelSetting setting) throws Exception {

		Map<Integer, ExcelSettingColumn> columns = setting.getColumns();
		
		int rowNum = sheet.getLastRowNum() + 1;
//		List<ImportData> datas = new ArrayList<ImportData>(column);
//		List<ImportData> successDatas = new ArrayList<ImportData>(column);
		List<E> es = new ArrayList<E>(columns.size());
//		List<E> successEs = new ArrayList<E>(column);
		
		// 一行一行读Excel数据
		for (int i = setting.getStartRow(); i < rowNum; i++) {
			gRowNum = i;

			// 处理一行数据
			E e = clz.newInstance();
			
//			Cell[] cells = sheet.getRow(i);
//			ImportData data = readRow(e, columns, sheet, i);
			Row row = sheet.getRow(i);
			readRow(e, columns, row);
			
//			data.setRowNo(Long.valueOf(i));
			
//			if (data.getIsSuccess()) {	// 通过配置校验
//				successDatas.add(data);
//				successEs.add(e);
//			}

//			logger.debug(ToStringBuilder.reflectionToString(data));
			
//			datas.add(data);
			es.add(e);
		}
		
		// 校验数据 callback
//		handling.checkData(successEs, successDatas, null);
		
		return es;
	}

	@SuppressWarnings("unchecked")
	private <E> List<ImportData> readExcelPreview(Class<E> clz, Sheet sheet,
			ExcelSetting setting, Map<String, String> params) throws Exception {

		Map<Integer, ExcelSettingColumn> columns = setting.getColumns();
		ImportDataPreviewHandler<E> handling = null;
		
		// 获取handling对象
		Object obj = ExcelSettingHelper.getImportDataHanler(setting.getHandleClass());
//		if ( !ImportDataPreviewHandling.class.isAssignableFrom())
		if (!(obj instanceof ImportDataPreviewHandler)) {
			throw new ServiceException("handleClass 必须是ImportDataPreviewHandling的子类");
		}
		handling = (ImportDataPreviewHandler<E>) obj;
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.NOPROP);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		
		int rowNum = sheet.getLastRowNum() + 1;
		int columnNum = columns.size();
		List<ImportData> datas = new ArrayList<ImportData>(columnNum);
		List<ImportData> successDatas = new ArrayList<ImportData>(columnNum);
//		List<E> es = new ArrayList<E>(column);
		List<E> successEs = new ArrayList<E>(columnNum);
		
		// 一行一行读Excel数据
		for (int i = setting.getStartRow(); i < rowNum; i++) {
			gRowNum = i;

			// 处理一行数据
			E e = clz.newInstance();
			
//			Cell[] cells = sheet.getRow(i);
			Row row = sheet.getRow(i);
			ImportData data = readRow(e, columns, row);
			
			data.setRowNo(Long.valueOf(i));
			if(StringUtils.isNotEmpty(setting.getIdField())) {
				Object excelRowId = PropertyUtils.getProperty(e, setting.getIdField());
				if (excelRowId != null)
					data.setExcelRowId(excelRowId.toString());
			}
			if(StringUtils.isNotEmpty(setting.getCodeField())) {
				Object excelRowCode = PropertyUtils.getProperty(e, setting.getCodeField());
				if (excelRowCode != null)
					data.setExcelRowCode(excelRowCode.toString());
			}
			
//			data.setExcelData(Hibernate.createClob(JSONObject.fromObject(e).toString()));
//			data.setExcelData(JSONObject.fromObject(e).toString());
			data.setExcelData(StringUtils.getCompactStringFromJson(JSONObject.fromObject(e, jsonConfig)));
			
			if (data.getIsSuccess()) {	// 通过配置校验
				successDatas.add(data);
				successEs.add(e);
			}

//			logger.debug(ToStringBuilder.reflectionToString(data));
			
			datas.add(data);
//			es.add(e);
		}
		
		// 校验数据 callback
		handling.checkData(successEs, successDatas, params);
		
		return datas;
	}

	/**
	 * 读取行数据
	 * @param <E>
	 * @param e
	 * @param columns
	 * @param sheet
	 * @param rowNum
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <E>ImportData readRow(E e, Map<Integer, ExcelSettingColumn> columns, Row row) throws Exception {
		ImportData data = new ImportData();
		
		boolean isSuccess = true;
		StringBuffer errorMessage = new StringBuffer();
		
		for (Entry<Integer, ExcelSettingColumn> entry : columns.entrySet()) {
			int j = entry.getKey();
			gCellNum = j;
			ExcelSettingColumn excelSettingColumn = entry.getValue();
			
			Class type = excelSettingColumn.getType();
			Object obj = null;
			Cell cell = row.getCell(j);
			if (cell == null){
				if (excelSettingColumn.isRequired()) {
					isSuccess = false;
					errorMessage.append(excelSettingColumn.getName() + "不能为空！");
				}
			} else if(Cell.CELL_TYPE_BLANK == cell.getCellType()) {
				if (excelSettingColumn.isRequired()) {
					isSuccess = false;
					errorMessage.append(excelSettingColumn.getName() + "不能为空！");
				}
			} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					if (!(Date.class.isAssignableFrom(type))){
						throw new ValidateException("日期类型错误");
					}
					obj = cell.getDateCellValue();
				} else if (String.class.isAssignableFrom(type)){
					cell.setCellType(Cell.CELL_TYPE_STRING);
					obj = cell.getStringCellValue();
				} else {
					if (!(Number.class.isAssignableFrom(type))){
						throw new ValidateException("数字类型错误");
					}
					cell.setCellType(Cell.CELL_TYPE_STRING);
					obj = NumberUtils.parseNumber(cell.getStringCellValue(), type);
				}
			} else if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
				if (String.class.isAssignableFrom(type)) {
					obj = cell.getStringCellValue();
					
					if (excelSettingColumn.getMinLength() != null
							&& ((String)obj).length() < excelSettingColumn.getMinLength()) {
						isSuccess = false;
						errorMessage.append(excelSettingColumn.getName() + "：长度不能小于" + excelSettingColumn.getMinLength());
					}
					if (excelSettingColumn.getMaxLength() != null
							&& ((String)obj).length() > excelSettingColumn.getMaxLength()) {
						isSuccess = false;
						errorMessage.append(excelSettingColumn.getName() + "：长度不能大于" + excelSettingColumn.getMaxLength());
					}
				} else if (Date.class.isAssignableFrom(type)) {	// label 格式中存放日期数据
					obj = DateUtils.convert(cell.getStringCellValue());
				} else if (Number.class.isAssignableFrom(type)) {	// label 格式中存放数字格式
					obj = NumberUtils.parseNumber(cell.getStringCellValue(), type);
				}
			}
			
			PropertyUtils.setProperty(e, excelSettingColumn.getField(), obj);
		}
		
		data.setIsSuccess(isSuccess);
		data.setErrorMessage(errorMessage.toString());
		
		return data;
	}

	private FilePersistence fillFilePersistence(File file, Date now) {
		
		//创建文件对象
		FilePersistence fp = new FilePersistence();
		fp.setId(UUID.randomUUID().toString());
		fp.setFileName(file.getName());
		fp.setOwnerModule(IMPORT_MODULE);
//		fp.setContentType(null);
		fp.setOperatorId(this.findCurUser().getEmpCode());
		fp.setLogDate(now);
		fp.setPhysicalName(file.getAbsolutePath());
		
		return fp;
	}
	
	private ImportInfo fillImportInfo(ExcelSetting setting, Date now, String fileId, Map<String, String> params) {
		
		ImportInfo importInfo = new ImportInfo();
		
		importInfo.setDefaultConfig(setting.isDefaultConfig() ? "Y" : "N");
//		importInfo.setExcelConfig(ExcelSettingHelper.createExcelSetting(setting));
		importInfo.setClassName(setting.getClassName());
		importInfo.setExcelId(setting.getId());
		importInfo.setImportTime(now);
		if (params != null && params.size() > 0) {
			JSONObject json = new JSONObject();
			json.putAll(params);
			importInfo.setImportParams(json.toString());
		}
		
		return importInfo;
	}
	
	private File fillNewFile(File file,String suffix) {
		String direcotry = importerDirectory + IMPORT_MODULE + File.separator 
			+ System.currentTimeMillis() + "_" + Math.abs(RandomUtils.getRandom().nextInt()) + "." + suffix;
//		String direcotry = file.getParent() + File.separator + System.currentTimeMillis() + "_" + Math.abs(RandomUtils.getRandom().nextInt()) + ".xls";
		
		File newFile = new File(direcotry);
		if (!newFile.getParentFile().exists()) {
			newFile.getParentFile().mkdirs();
		}
//		file.renameTo(newFile);
		
		logger.info(file.getAbsolutePath() + " to " + newFile.getAbsolutePath());
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream(newFile);
			
			IOUtils.copy(is, os);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
		
		return newFile;
	}
	
	private File fillNewFile(MultipartFile file,String suffix) {
		String direcotry = importerDirectory + IMPORT_MODULE + File.separator 
			+ System.currentTimeMillis() + "_" + Math.abs(RandomUtils.getRandom().nextInt()) + "." + suffix;
		
		File newFile = new File(direcotry);
		if (!newFile.getParentFile().exists()) {
			newFile.getParentFile().mkdirs();
		}
		
		logger.info(file.getOriginalFilename() + " to " + newFile.getAbsolutePath());
		
		try {
			file.transferTo(newFile);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return newFile;
	}
	
	private String getSuffix(String fileName) {
		String suffix = "";
		int indexOf = fileName.lastIndexOf(".");
		if (indexOf != -1) {
			suffix = fileName.substring(indexOf + 1, fileName.length());
		}
		return suffix;
	}
	
	@SuppressWarnings("unchecked")
	private <E> String importFileCore(Class<E> clz, File file, Map<String, String> params, String suffix) {
		String importId = null;
		Date now = new Date(Calendar.getInstance().getTimeInMillis());
		
		// 读取配置信息
		ExcelSetting setting = mappings.get(clz);
		List<E> list = null;
		ImportDataHandler<E> handling = null;
		
		// 读取excel
		InputStream is = null;
		try {
			Workbook workbook = null;
			gRowNum = 0;
			gCellNum = 0;
			
			is = new FileInputStream(file);
			
	        if ("xls".equals(suffix)) {
	        	workbook = new HSSFWorkbook(is);
	        } else {
	        	workbook = new XSSFWorkbook(is);
	        }
			Sheet sheet = workbook.getSheetAt(0);

			// 生成两个对象
			FilePersistence filePersistence = fillFilePersistence(file, now);
			ImportInfo importInfo = fillImportInfo(setting, now, filePersistence.getId(), params);
			
			// 获取handling对象
			Object obj = ExcelSettingHelper.getImportDataHanler(setting.getHandleClass());
//			if ( !ImportDataPreviewHandling.class.isAssignableFrom())
			if (!(obj instanceof ImportDataHandler)) {
				throw new ServiceException("handleClass 必须是ImportDataHandling的子类");
			}
			handling = (ImportDataHandler<E>) obj;
			
			// 不做动态列选择
			long time1 = System.nanoTime()/1000000;
			
			list = readExcel(clz, sheet, setting);
			
			long time2 = System.nanoTime()/1000000;
			
			// 不用预览，不保存数据
			importId = importerService.saveImportData(filePersistence, importInfo, null);
			long time3 = System.nanoTime()/1000000;
			
			logger.info("解析Excel时间：" + (time2 - time1));
			logger.info("导入数据库时间：" + (time3 - time2));
			
		} catch (ValidateException e) {
			Map<Integer, ExcelSettingColumn> columns = setting.getColumns();
			ExcelSettingColumn column = columns.get(gCellNum);
			String columnName = column.getName();
			throw new ValidateException((gRowNum+1)+"行 "+columnName+":"+e.getMessage());
		} catch (Exception e) {
			Map<Integer, ExcelSettingColumn> columns = setting.getColumns();
			ExcelSettingColumn column = columns.get(gCellNum);
			String columnName = column.getName();
			throw new ServiceException((gRowNum+1)+"行 "+columnName+":"+e.getMessage(),e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 同线程中处理导入数据
		handling.handleDatas(list, params);
		
		return importId;
	}
	
	private <E> String importFilePreviewCore(Class<E> clz, File file, Map<String, String> params, String suffix) {
		String importId = null;
		Date now = new Date(Calendar.getInstance().getTimeInMillis());
		
		// 读取配置信息
		ExcelSetting setting = mappings.get(clz);
		
		// 读取excel
		InputStream is = null;
		try {
			Workbook workbook = null;
			gRowNum = 0;
			gCellNum = 0;
			
			is = new FileInputStream(file);
			
	        if ("xls".equals(suffix)) {
	        	workbook = new HSSFWorkbook(is);
	        } else {
	        	workbook = new XSSFWorkbook(is);
	        }
			Sheet sheet = workbook.getSheetAt(0);

			// 生成两个对象
			FilePersistence filePersistence = fillFilePersistence(file, now);
			ImportInfo importInfo = fillImportInfo(setting, now, filePersistence.getId(), params);
			List<ImportData> datas = null;
			
			if (setting.isDefaultConfig()) {
				long time1 = System.nanoTime()/1000000;
				
				datas = readExcelPreview(clz, sheet, setting, params);
				
				long time2 = System.nanoTime()/1000000;
				
				importId = importerService.saveImportData(filePersistence, importInfo, datas);
				long time3 = System.nanoTime()/1000000;
				
				logger.info("解析Excel时间：" + (time2 - time1));
				logger.info("导入数据库时间：" + (time3 - time2));
			} else {	// 预读取数据,并在界面上由用户选择列
				
			}
			
		} catch (ValidateException e) {
			Map<Integer, ExcelSettingColumn> columns = setting.getColumns();
			ExcelSettingColumn column = columns.get(gCellNum);
			String columnName = column.getName();
			throw new ValidateException((gRowNum+1)+"行 "+columnName+":"+e.getMessage());
		} catch (Exception e) {
			Map<Integer, ExcelSettingColumn> columns = setting.getColumns();
			ExcelSettingColumn column = columns.get(gCellNum);
			String columnName = column.getName();
			throw new ServiceException((gRowNum+1)+"行 "+columnName+":"+e.getMessage(),e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return importId;
	}
	
	private <E> List<E> importFileReturnCore(Class<E> clz, MultipartFile file, Map<String, String> params, String suffix) {
		
		// 读取配置信息
		ExcelSetting setting = mappings.get(clz);
		List<E> list = null;
		
		// 读取excel
		InputStream is = null;
		try {
			Workbook workbook = null;
			gRowNum = 0;
			gCellNum = 0;
			
			is = file.getInputStream();
			
	        if ("xls".equals(suffix)) {
	        	workbook = new HSSFWorkbook(is);
	        } else {
	        	workbook = new XSSFWorkbook(is);
	        }
			Sheet sheet = workbook.getSheetAt(0);

			// 不做动态列选择
			long time1 = System.nanoTime()/1000000;
			
			list = readExcel(clz, sheet, setting);
			
			long time2 = System.nanoTime()/1000000;
			
			logger.info("解析Excel时间：" + (time2 - time1));
			
		} catch (ValidateException e) {
			Map<Integer, ExcelSettingColumn> columns = setting.getColumns();
			ExcelSettingColumn column = columns.get(gCellNum);
			String columnName = column.getName();
			throw new ValidateException((gRowNum+1)+"行 "+columnName+":"+e.getMessage());
		} catch (Exception e) {
			Map<Integer, ExcelSettingColumn> columns = setting.getColumns();
			ExcelSettingColumn column = columns.get(gCellNum);
			String columnName = column.getName();
			throw new ServiceException((gRowNum+1)+"行 "+columnName+":"+e.getMessage(),e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
}

