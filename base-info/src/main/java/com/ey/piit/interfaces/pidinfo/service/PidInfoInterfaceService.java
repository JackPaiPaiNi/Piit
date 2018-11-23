package com.ey.piit.interfaces.pidinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.common.SAPConn;
import com.ey.piit.interfaces.pidinfo.dto.PidInfoMsgResponse;
import com.ey.piit.interfaces.pidinfo.util.PidInfoUtil;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * PID申请推送 接口服务类
 * @author denghai
 *
 */
@Service
public class PidInfoInterfaceService {
	
	
	/**
	 * 供外部调用PID申请与sap接口
	 * */
	
   public List<PidInfoMsgResponse> pidInfoSdoToSap(List<PidInfoMsgResponse> list) throws Exception{
		try {
			return pidInfoXmlToSap(this.getPidInfoXmlStr(list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
   }
	
      /**
       * 生成PID申请报文
       * @return
       */
    private String getPidInfoXmlStr(List<PidInfoMsgResponse> list) throws Exception{
    	try {
    		return PidInfoUtil.producePidInfoMsgXml(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
      
    /**
     * 推送PID报文给SAP系统 并返回PidInfoMsgResponse
     * @param String orderXmlStr
     * @return
     * @throws Exception
     */
    private List<PidInfoMsgResponse> pidInfoXmlToSap(String pidInfoXmlStr) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		List<PidInfoMsgResponse> outList=new ArrayList<PidInfoMsgResponse>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP 工装海运费RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_SDO_MM1001");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", pidInfoXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			String outXml=outParameter.getString("XML_OUT");
  			System.out.println("outXml===>"+outXml);
  			String msg=outParameter.getString("MSG");
  			System.out.println("msg=>"+msg);
  			outList=PidInfoUtil.transfer(outXml,pidInfoXmlStr);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return outList;
  	}
  	
  
      
      public static void main(String[] args){
    	  PidInfoMsgResponse response=new PidInfoMsgResponse();
    	  response.setId("1");;
    	  response.setPid("C19L19TS2JXXXXXXXX");
    	  response.setJixing("19E20");
    	  response.setJixin("8M48A");
    	  response.setFbl("30");
    	  response.setCpfl("");
    	  response.setCpxl("");
      	  response.setPp("skyworth");
       	  response.setZhfs("CKD");
       	  response.setCc("19.00");
    	  response.setMsg("");

    	  List<PidInfoMsgResponse> list=new ArrayList<PidInfoMsgResponse>();
    	  list.add(response);
    	  
    	  try {
			new PidInfoInterfaceService().pidInfoSdoToSap(list);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
  	}


}
