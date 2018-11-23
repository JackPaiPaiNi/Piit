package com.ey.piit.basesys.data.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;

import com.ey.piit.basesys.data.BaseExporter;
import com.ey.piit.basesys.data.ExporterFactory;
import com.ey.piit.basesys.data.entity.ExportSetting;
import com.ey.piit.basesys.data.entity.FilePersistence;
import com.ey.piit.basesys.data.handler.ExportDataHandler;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.utils.RandomUtils;
import com.ey.piit.core.utils.StringUtils;

/**
 * Excel Exporter
 * @author Kevin-Y.Xu
 */
public class ExcelExporter extends BaseExporter {
	
	private final Logger logger = Logger.getLogger(getClass());

	@Value("${export.size.excel}")
    private int exportSize;
//  private Map<String, WritableCellFormat> dateFormatter = new HashMap<String, WritableCellFormat>();
    
    public ExcelExporter() {
        super();
        
//      String[] formatters = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd H:mm:ss"};
//      for (String formatter : formatters) {
//          DateFormat dateFormat = new DateFormat(formatter);
//          WritableCellFormat wcf = new WritableCellFormat(dateFormat);
//          dateFormatter.put(formatter, wcf);
//      }
    }
    
    @SuppressWarnings("rawtypes")
	@Override
    public FilePersistence exportToFile(Collection<?> result, ExportSetting setting, User user, ExportDataHandler handler) {
        Integer rdm = Math.abs(RandomUtils.getRandom().nextInt(1000));
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String date = new SimpleDateFormat("yyyyMMdd").format(ts);
        String fs = new SimpleDateFormat("yyyyMMdd_HHmm").format(ts);
        
        String fileName = setting.getFileName();

        if (StringUtils.isNotEmpty(fileName))
            fileName += "_";
        else
            fileName = "";
        
        fileName += fs + "_" + rdm + ".xlsx";
        
        String realName = newFilePath(setting.getDirectory(), setting.getModule(), date);

        realName += fs + "_" + rdm + ".xlsx";
        
        File f = null;
        try {
            f = new File(realName);
            f.createNewFile();
            export(new FileOutputStream(f), result, setting, handler);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        
        // 导出文件名
        setting.setFileName(fileName);
        // 物理文件名
        setting.setRealName(realName);
        
        FilePersistence fp = new FilePersistence();
        fp.setFileName(fileName);
        fp.setPhysicalName(realName);
        fp.setOwnerModule(setting.getModule());
        fp.setContentLength(new BigDecimal(f.length()));
        fp.setContentType(ExporterFactory.FORMAT_EXCEL_CONTENT_TYPE);
        fp.setLogDate(ts);
        if (user != null)
            fp.setOperatorId(user.getEmpCode());
        
        return fp;
    }

    /**
     * 从数据库读数据，写入Excel
     * 
     * @param os
     *            数据流，如果是写本地文件的话，可以是FileOutputStream；
     *            如果是写Web下载的话，可以是ServletOupputStream
     * @param result
     *            数据结果列表
     * @param setting
     *            数据结果集对应Excel表列名映射导出对象
     * @throws Exception
     *             方法内的异常有ServiceException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void export(OutputStream os, Collection<?> result, ExportSetting setting, ExportDataHandler handler) throws Exception {

        Workbook wbook = null;
        try {
            // 创建工作文档对象
            wbook = new XSSFWorkbook();
            // 创建sheet对象
            Sheet sheet = (Sheet) wbook.createSheet("sheet1");
            
            handler.handleHead(wbook, sheet, setting);
            handler.handleDatas(wbook, sheet, setting, result);
            
            wbook.write(os); // 写入文件
            os.flush();
        } finally {
            try {
                os.close();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public int getExportSize() {
        return exportSize;
    }

    public void setExportSize(int exportSize) {
        this.exportSize = exportSize;
    }

}
