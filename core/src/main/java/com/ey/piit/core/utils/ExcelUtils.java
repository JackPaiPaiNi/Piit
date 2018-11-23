package com.ey.piit.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ey.piit.core.entity.SheetDataEntity;

/** 
 * excel操作公共类-提供excel按照模板输出 
 * @author wxd
 * 
 */  
@Component
public class ExcelUtils {  
	protected static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /** 
     * Sheet复制 
     * @param fromSheet 
     * @param toSheet 
     * @param copyValueFlag 
     */  
    public void copySheet(Workbook wb,Sheet fromSheet, Sheet toSheet, boolean copyValueFlag) {  
        //合并区域处理  
        mergerRegion(fromSheet, toSheet);  
        int index = 0;  
        for(int rowN=0;rowN<=fromSheet.getLastRowNum();rowN++){
        	Row tmpRow = fromSheet.getRow(rowN);
        	Row newRow = toSheet.createRow(tmpRow.getRowNum());
        	CellStyle style = tmpRow.getRowStyle();
        	if(style != null){
        		newRow.setRowStyle(tmpRow.getRowStyle());  
        	}
        	newRow.setHeight(tmpRow.getHeight());
        	//针对第一行设置行宽  
            if(index == 0) {  
                int first = tmpRow.getFirstCellNum();  
                int last = tmpRow.getLastCellNum();  
                for(int i = first ; i < last ; i++) {  
                    int w = fromSheet.getColumnWidth(i);  
                    toSheet.setColumnWidth(i, w + 1);  
                }  
                toSheet.setDefaultColumnWidth(fromSheet.getDefaultColumnWidth());  
            }
            //行复制  
            copyRow(wb,tmpRow,newRow,copyValueFlag);  
              
            index++ ;  
        }
    } 
    /** 
     * 行复制功能 
     * @param fromRow 
     * @param toRow 
     */  
     public void copyRow(Workbook wb,Row fromRow,Row toRow,boolean copyValueFlag){  
        for (Iterator<Cell> cellIt = fromRow.cellIterator(); cellIt.hasNext();) {  
            Cell tmpCell = cellIt.next();  
            Cell newCell = toRow.createCell(tmpCell.getColumnIndex());  
            copyCell(wb,tmpCell, newCell, copyValueFlag);  
        }  
    }  
    /** 
    * 复制原有sheet的合并单元格到新创建的sheet 
    *  
    * @param sheetCreat 新创建sheet 
    * @param sheet      原有的sheet 
    */  
     public void mergerRegion(Sheet fromSheet, Sheet toSheet) {  
       int sheetMergerCount = fromSheet.getNumMergedRegions();  
       for (int i = 0; i < sheetMergerCount; i++) {  
             
           CellRangeAddress cra = fromSheet.getMergedRegion(i);  
          
           toSheet.addMergedRegion(cra);  
       }  
    }  
    /** 
     * 复制单元格 
     *  
     * @param srcCell 
     * @param distCell 
     * @param copyValueFlag 
     *            true则连同cell的内容一起复制 
     */  
    @SuppressWarnings("deprecation")
	public void copyCell(Workbook wb,Cell srcCell, Cell distCell,  
            boolean copyValueFlag) {  
          
           
          
        CellStyle newstyle=wb.createCellStyle();  
        //copyCellStyle(srcCell.getCellStyle(), newstyle);  
        //distCell.setEncoding(srcCell.);  
        newstyle.cloneStyleFrom(srcCell.getCellStyle());  
        //样式  
        distCell.setCellStyle(newstyle);  
        //评论  
        if (srcCell.getCellComment() != null) {  
            distCell.setCellComment(srcCell.getCellComment());  
        }  
        // 不同数据类型处理  
        CellType srcCellType = srcCell.getCellTypeEnum();  
        distCell.setCellType(srcCellType);  
          
           
        if (copyValueFlag) {  
            if (srcCellType == CellType.NUMERIC) {  
                if (DateUtil.isCellDateFormatted(srcCell)) {  
                    distCell.setCellValue(srcCell.getDateCellValue());  
                } else {  
                    distCell.setCellValue(srcCell.getNumericCellValue());  
                }  
            } else if (srcCellType == CellType.STRING ) {  
                distCell.setCellValue(srcCell.getRichStringCellValue());  
            } else if (srcCellType == CellType.BLANK ) {  
                // nothing21  
            } else if (srcCellType == CellType.BOOLEAN  ) {  
                distCell.setCellValue(srcCell.getBooleanCellValue());  
            } else if (srcCellType == CellType.ERROR ) {  
                distCell.setCellErrorValue(srcCell.getErrorCellValue());  
               
            } else if (srcCellType == CellType.FORMULA  ) {  
                distCell.setCellFormula(srcCell.getCellFormula());  
            } else { // nothing29  
            }  
        }  
    }  
      
      
    /** 
     * 写入excel数据 
     * @param model 采用的模板 位置在 src/model/下 模板第一个sheet页必须是模板sheet 
     * @param sheetDatas 模板数据 
     */  
       
	public void writeData(HttpServletResponse response,String model , OutputStream out,SheetDataEntity... sheetDatas) {  
          
        Workbook wb = null;  
        FileInputStream input = null;
        String filePath = ExcelUtils.class.getResource("/").getPath();
        try {  
        	if(filePath.endsWith("WEB-INF/classes/")){
        		filePath = filePath.replace("WEB-INF/classes/", "template/" + model);
        	}
            filePath = filePath.substring(1);
            input = new FileInputStream(new File(filePath));
              
            if(model.endsWith(".xlsx"))  
            	wb = new XSSFWorkbook(input);  
            else if(model.endsWith(".xls"))  
            	wb = new HSSFWorkbook(input);  
        } catch (IOException e) {  
            throw new RuntimeException("model excel file load error :" + filePath);  
        }  
           
        //就一个的话 直接用模板  
        int size = sheetDatas.length ;  
        for(int i = 0 ; i < size  ; i++) {  
            //写数据  
            writeData(sheetDatas[i], wb.getSheetAt(i));  
        }  
        try {  
            wb.write(response.getOutputStream());  
            wb.write(out);  
            out.flush();  
            wb.close();  
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
          
    }  
      
    /** 
     * 向sheet页中写入数据 
     * @param values 数据Map 
     * @param sheet sheet 
     */  
      @SuppressWarnings("deprecation")
	public void writeData(SheetDataEntity sheetData , Sheet sheet) {  
        //从sheet中找到匹配符 #{}表示单个 , ${}表示集合,从该单元格开始向下追加  
        for(Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {  
            Row row = rowIt.next();  
            //取cell  
            for(int j = row.getFirstCellNum() ; j < row.getLastCellNum() ; j++) {  
                Cell cell = row.getCell(j);  
                //判断cell的内容是否包含 $ 或者#  
                if(cell != null && cell.getCellTypeEnum() == CellType.STRING && cell.getStringCellValue() != null   
                            && (cell.getStringCellValue().contains("$") || cell.getStringCellValue().contains("#") )) {  
                    //剥离# $  
                    String[] winds = getWildcard(cell.getStringCellValue().trim());  
                    for(String wind : winds) {  
                        writeData(sheetData, wind , cell , sheet);  
                    }  
                }  
            }  
        }  
    }  
      
    /** 
     * 填充数据 
     * @param values 
     * @param keyWind #{name}只替换当前 or ${names} 从当前行开始向下替换 
     */  
    @SuppressWarnings("deprecation")
	public void writeData(SheetDataEntity sheetData , String keyWind , Cell cell , Sheet sheet) {  
        String key = keyWind.substring(2 , keyWind.length() - 1);  
        if(keyWind.startsWith("#")) {  
            //简单替换  
            Object value = sheetData.get(key);  
            //为空则替换为空字符串  
            if(value == null)   
            	value = "" ;  
            if(value instanceof Date){
            	value = DateUtils.format((Date)value, "yyyy-MM-dd");
            }
            String cellValue = cell.getStringCellValue();  
            cellValue = cellValue.replace(keyWind, value.toString());  
            cell.setCellValue(cellValue);  
        } else  if(keyWind.startsWith("$")) {  
            //从list中每个实体开始解,行数从当前开始  
            int rowindex = cell.getRowIndex();  
            int columnindex = cell.getColumnIndex();  
            List<? extends Object> listdata = sheetData.getDatas();  
            //不为空的时候开始填充  
            if(listdata != null && !listdata.isEmpty()){  
                for(Object o : listdata) {  
                    Object cellValue = getValue(o, key);  
                    Row row = sheet.getRow(rowindex);  
                    if(row == null) {  
                        row = sheet.createRow(rowindex);  
                    }  
                    //取出cell  
                    Cell c = row.getCell(columnindex);  
                    if(c == null)   
                        c = row.createCell(columnindex);  
                    if(cell.getCellStyle() != null){   
                        c.setCellStyle(cell.getCellStyle());  
                    }  
                    if(cell.getCellTypeEnum() != null) {  
                        c.setCellType(cell.getCellTypeEnum());  
                    }  
                    if(cellValue != null) {  
                        if(cellValue instanceof Number || isNumber(cellValue) )  
                            c.setCellValue( Double.valueOf(cellValue.toString()));  
                        else if(cellValue instanceof Boolean)  
                            c.setCellValue((Boolean)cellValue);  
                        else if(cellValue instanceof Date)  
                            c.setCellValue((Date)cellValue);  
                        else  
                            c.setCellValue(cellValue.toString());  
                    } else {  
                        //数据为空 如果当前单元格已经有数据则重置为空  
                        if(c.getStringCellValue() != null) {  
                            c.setCellValue("");  
                        }  
                    }  
                    rowindex++ ;  
                }  
            } else {  
                //list数据为空则将$全部替换空字符串  
                String cellValue = "" ;  
                   
                cell.setCellValue(cellValue);  
            }  
        }  
    }  
    

	
	/** 
	   * 从实体中解析出字段数据 
	   * @param data 可能为pojo或者map 从field中解析 
	   * @param field 字段名称 
	   * @return 
	   */  
	     
	@SuppressWarnings("unchecked")
	public Object getValue(Object data , String field) {  
	      if(data instanceof Map) {  
	          Map<String, Object> map = (Map<String, Object>) data;  
	          return map.get(field);  
	      }  
	      try {  
	            
	          String method = "get" + field.substring(0 , 1).toUpperCase() + field.substring(1);  
	            
	          Method m = data.getClass().getMethod(method);  
	            
	          if(m != null) {  
	              return m.invoke(data);  
	          }  
	            
	      } catch (Exception e) {  
	          logger.error("data invoke error , data:" + data + " , key:" + field);  
	          return null;  
	      }   
	        
	        
	      return null ;  
	        
	  }  
	    
	  /** 
	   * 判断是否为数字 
	   * @param v 
	   * @return 
	   */  
	  public boolean isNumber(Object v) {  
	        
	      if(v == null) return false;   
	        
	      if(v instanceof Number) {  
	          return true ;  
	      } else if(v.toString().matches("^\\d+$")) {  
	          return true ;  
	      } else if(v.toString().matches("^-?\\d+\\.?\\d+$")) {  
	          return true ;  
	      } else {  
	          try{  
	              Double.parseDouble(v.toString());  
	              return true ;  
	          }catch(Exception e) {  
	              return false;  
	          }  
	           
	            
	      }  
	        
	  }  
	  
	/** 
	   * 返回 #{} 或者 ${} 中包含的值 
	   * @param str 
	   * @param type 
	   * @return eg:#{name} ${ages}  
	   */  
	  public String[] getWildcard(String str ) {  
	        
	     List<String> list = new ArrayList<String>();  
	       
	     int start = 0;  
	     while(start < str.length() && start >= 0) {  
	           
	         start = str.indexOf("{", start);  
	           
	         int end = str.indexOf("}", start);  
	         if(start > 0) {  
	             String wc = str.substring(start - 1 , end + 1);  
	               
	             list.add(wc);  
	         }  
	          
	         if(start < 0) break ;  
	           
	         start = end + 1;  
	           
	     }  
	       
	     return list.toArray(new String[0]);  
	        
	  }  
	  
	  /**
	   * 根据日期获取文件名称
	   * @return
	   */
	  public String getFileName(){
		  	Integer rdm = Math.abs(RandomUtils.getRandom().nextInt(1000));
	        Timestamp ts = new Timestamp(System.currentTimeMillis());
	        String date = new SimpleDateFormat("yyyyMMdd").format(ts);
	        String fs = new SimpleDateFormat("yyyyMMdd_HHmm").format(ts);
	        String fileName = "/" + date + "/" + fs + "_" + rdm + ".xlsx";
	        return fileName;
	  }
}  