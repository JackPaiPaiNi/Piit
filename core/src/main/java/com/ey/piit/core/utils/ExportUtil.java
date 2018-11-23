package com.ey.piit.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ey.piit.basesys.data.BaseExporter;
import com.ey.piit.basesys.data.ExporterFactory;
import com.ey.piit.basesys.data.entity.ExportSetting;
import com.ey.piit.basesys.data.entity.GridGroupHeader;
import com.ey.piit.basesys.data.entity.GridModel;
import com.ey.piit.basesys.data.handler.ExportDataHandler;
import com.ey.piit.core.exception.ServiceException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Component
public class ExportUtil {
	
	private static final Logger logger = Logger.getLogger(ExportUtil.class);
	
	@Autowired
	private ExporterFactory exporterFactory;
	
	@Value("${tmp.file.folder}")
	private String exporterDirectory;
	
	@Value("${application.name}")
	private String exporterModule;
	
	private void populateExportData(Map<String, Object> parameters, ExportSetting exportSetting) {
		String values = (String)parameters.get(ExportSetting.EXPORT_COL_MODEL_LIST+0);
		int count = 0;
		while (StringUtils.isNotBlank(values)) {
            try {
                JsonConfig config = new JsonConfig();
                config.setExcludes(new String[]{"editrules"});
                JSONObject json = JSONObject.fromObject(values, config);
                GridModel model = (GridModel) JSONObject.toBean(json, GridModel.class);
                
                String colNames = (String)parameters.get(ExportSetting.EXPORT_COL_NAMES+count);
                exportSetting.addExportColName(count, colNames);
                
                String colModels = (String)parameters.get(ExportSetting.EXPORT_COL_MODELS+count);
                exportSetting.addExportColModel(count, colModels);
                
                if (StringUtils.isNotBlank(model.getWidth()) && model.getWidth().indexOf("%") > 0) {
                    model.setRealWidth(Float.floatToIntBits(Float.valueOf(model.getWidth()) * 1000));
                } else {
                    model.setRealWidth(Integer.valueOf(model.getWidth()));
                }
                if (model.getEditoptions() != null) {
                    String option = model.getEditoptions().getValue();
                    if (StringUtils.isNotBlank(option)) {
                    	String[] ms = option.split(";");
                    	HashMap<String, String> maps = new HashMap<String, String>(ms.length);
                    	for (String m : ms) {
                    		String[] d = m.split(":");
                    		if (d.length >= 2)
                    			maps.put(d[0].trim(), d[1].trim());
                    	}
                    	model.setMaps(maps);
					}
                }
                exportSetting.addExportColModelList(count, model);
                count++;
                values = (String)parameters.get(ExportSetting.EXPORT_COL_MODEL_LIST+count);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                values = null;
            }
        }
		String fileName = (String)parameters.get("fileName");
		if (StringUtils.isNotBlank(fileName)) {
            exportSetting.setFileName(fileName);
        }
	}
	
	@SuppressWarnings("unchecked")
	private void populateExportHeader(Map<String, Object> parameters, ExportSetting exportSetting) {
		Map<Integer, String> colModels = exportSetting.getExportColModels();
		String values = (String) parameters.get(ExportSetting.EXPORT_GROUP_HEADER_LIST + 0);
		int count = 0;
		while (StringUtils.isNotBlank(values)) {
			try {
				JSONArray json = JSONArray.fromObject(values);
				List<GridGroupHeader> headerList = (List<GridGroupHeader>)JSONArray.toCollection(json,GridGroupHeader.class);
				int sameIndex = 0;
				
				first:
				for (int i = 0; i < headerList.size(); i++) {
					GridGroupHeader groupHeader = headerList.get(i);
					for (int j = sameIndex; j < colModels.size(); j++) {
						String name = colModels.get(j);
						if (name.equals(groupHeader.getStartColumnName())) {
							sameIndex = j;
							groupHeader.setStartColumn(j);
							continue first;
						}
					}
				}
				
				exportSetting.addExportGroupHeaderList(count, headerList);
				count++;
				values = (String) parameters.get(ExportSetting.EXPORT_GROUP_HEADER_LIST + count);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				values = null;
			}
		}
	}
	
	public void exportSync(HttpServletResponse response, Map<String, Object> parameters, List<?> list) {
		FileInputStream input = null;
		ServletOutputStream output = null;
    	try {
    		ExportSetting exportSetting = new ExportSetting();
    		
    		this.populateExportData(parameters, exportSetting);
    		this.populateExportHeader(parameters, exportSetting);
    		
			String format = exportSetting.getFormat();
			BaseExporter exporter = exporterFactory.createExporter(format);
			exportSetting.setDirectory(exporterDirectory);
			exportSetting.setLimit(exporter.getExportSize());
			exportSetting.setPage(1);
    		
			if(StringUtils.isEmpty(exportSetting.getModule())){
				exportSetting.setModule(exporterModule);
			}
    		exporter.exportToFile(list, exportSetting, null, new ExportDataHandler());
    			
			String realName = exportSetting.getRealName();
			String fileName = exportSetting.getFileName();
			
			String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment;filename=" + codedFileName);
			
			File file = new File(realName);
			input = new FileInputStream(file);
			output = response.getOutputStream();
			IOUtils.copy(input, output);
		} catch (IOException e) {
			throw new ServiceException(e);
		} finally {
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(output);
		}
	}
	
}
