package com.ey.piit.interfaces.common;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * 与制造SAP连接配置
 * @author denghai
 */
public class ZZSAPConn {
	private static final ZZSAPConn single = new ZZSAPConn();
	private static final String ABAP_AS_POOLED = "ZZ_ABAP_AS_WITH_POOL" ;
	//测试库服务器海外SAP 172.20.1.186  制造sap  172.20.1.63 制造sap 正式 172.20.1.62 
	//海外SAP RAC : 172.20.1.182 制造SAP RAC:172.20.1.61
	private static String JCO_ASHOST ="172.20.1.61";
	private static String JCO_USER ="SDO01";//测试库SAP用户名 
	private static String JCO_PASSWD ="654321";//测试库密码  
	private static String ZS_JCO_ASHOST ="172.20.1.61";//正式库服务器
	private static String ZS_JCO_USER ="SDO01";//正式库SAP用户名 
	private static String ZS_JCO_PASSWD ="654321";//正式库密码  
	private static String JCO_SYSNR = "00";//测试库sap系统编号
	private static String JCO_CLIENT = "600";//正式库SAP集团 测试130  正式600
	private static String JCO_LANG = "zh";//登录语言  
	private static String JCO_POOL_CAPACITY = "50";//最大连接数  
	private static String JCO_PEAK_LIMIT ="50";//最大连接线程
	private static Logger log = Logger.getLogger(ZZSAPConn.class); // 初始化日志对象

	
	private  ZZSAPConn(){
	   //拿到连接模式
	   String connMode = "1";
	   //连接正式库的情况
	   if("1".equals(connMode)){
		      JCO_ASHOST = ZS_JCO_ASHOST;
			  JCO_USER   = ZS_JCO_USER;
			  JCO_PASSWD = ZS_JCO_PASSWD;
	   }
	}
	public static ZZSAPConn getInstance(){
		return ZZSAPConn.single;
	}
	static {
		Properties connectProperties = new Properties();
		connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST,JCO_ASHOST);// 服务器
		connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,JCO_SYSNR); // 系统编号
		connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT,JCO_CLIENT); // SAP集团
		connectProperties.setProperty(DestinationDataProvider.JCO_USER,JCO_USER); // SAP用户名
		connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD,JCO_PASSWD); // 密码
		connectProperties.setProperty(DestinationDataProvider.JCO_LANG,JCO_LANG); // 登录语言
		connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY,JCO_POOL_CAPACITY); // 最大连接数
		connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT,JCO_PEAK_LIMIT); // 最大连接线程
		createDataFile(ABAP_AS_POOLED, "jcoDestination", connectProperties);
	}

	/**
	 * 创建SAP接口属性文件。
	 * 
	 * @param name
	 *            ABAP管道名称
	 * @param suffix
	 *            属性文件后缀
	 * @param properties
	 *            属性文件内容
	 */
	private static void createDataFile(String name, String suffix,
			Properties properties) {
		File cfg = new File(name + "." + suffix);
		if (cfg.exists()) {
			cfg.deleteOnExit();
		}
		try {
			FileOutputStream fos = new FileOutputStream(cfg, false);
			properties.store(fos, "for tests only !");
			fos.close();
		} catch (Exception e) {
			log.error("Create Data file fault, error msg: " + e.toString());
			e.printStackTrace();
			throw new RuntimeException("Unable to create the destination file "+ cfg.getName(), e);
		}
	}

	/**
	 * 获取SAP连接
	 * 
	 * @return SAP连接对象
	 */
	public static JCoDestination connect() {
		JCoDestination destination = null;
		try {
			destination = JCoDestinationManager.getDestination(ABAP_AS_POOLED);
		} catch (JCoException e) {
			e.printStackTrace();
			log.error("Connect SAP fault, error msg: " + e.toString());
		}
		return destination;
	}

	/**
	 * 获取SAP数据操作对象
	 * @param functionName 要调用的service方法
	 * @param tableName 表名
	 * @param split 分隔符
	 * @param noData 无数据返回值
	 * @return
	 */
	public static JCoTable getJCoTable(String functionName, String tableName, String split, String noData){
		JCoTable options = null;
		try {
			JCoDestination destination = SAPConn.connect();
			JCoFunction function = destination.getRepository().getFunctionTemplate(functionName).getFunction();
			function.getImportParameterList().setValue("QUERY_TABLE", tableName);// 设置要查询的表名
			function.getImportParameterList().setValue("DELIMITER", split);// 设置分隔符
			function.getImportParameterList().setValue("NO_DATA", noData);// 设置无数据
			options = function.getTableParameterList().getTable("OPTIONS");// 查询条件
		} catch (JCoException e) {
			e.printStackTrace();
			log.error("Get SAP JCoTable fault, error msg: " + e.toString());
		}
		return options;
	}
	
}
