package com.ey.piit.interfaces.charges.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.charges.dto.ChargesMsgResponse;
import com.ey.piit.interfaces.charges.util.ChargesUtil;
import com.ey.piit.interfaces.common.SAPConn;   
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * 工装海运费 接口服务类
 * @author denghai
 *
 */
@Service
public class ChargesInterfaceService {
	
	
	/**
	 * 供外部调用工装海运费与sap接口
	 * */
	
   public List<ChargesMsgResponse> chargesSdoToSap(List<ChargesMsgResponse> list) throws Exception{
		try {
			return chargesXmlToSap(this.getChargesXmlStr(list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
   }
	
      /**
       * 生成工装海运费报文
       * @return
       */
    private String getChargesXmlStr(List<ChargesMsgResponse> list) throws Exception{
    	try {
    		return ChargesUtil.produceChargesMsgXml(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
      
    /**
     * 推送订单通知书报文给SAP系统 并返回OrderMsgResponse
     * @param String orderXmlStr
     * @return
     * @throws Exception
     */
    private List<ChargesMsgResponse> chargesXmlToSap(String chargesXmlStr) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		List<ChargesMsgResponse> outList=new ArrayList<ChargesMsgResponse>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP 工装海运费RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_SDO_FI1001");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", chargesXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			String outXml=outParameter.getString("XML_OUT");
  			System.out.println("outXml===>"+outXml);
  			String msg=outParameter.getString("MSG");
  			System.out.println("msg=>"+msg);
  			outList=ChargesUtil.transfer(outXml,chargesXmlStr);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return outList;
  	}
  	
  
      
      public static void main(String[] args){
    	  ChargesMsgResponse response=new ChargesMsgResponse();
    	  response.setBz("RMB");
    	  response.setFprq("2016-09-09");
    	  response.setGsbm("2110");
    	  response.setJe("123");
    	  response.setKhbm("10000002");
    	  response.setLx("01");
    	  response.setMsg("");
    	  response.setPzh("");
    	  List<ChargesMsgResponse> list=new ArrayList<ChargesMsgResponse>();
    	  list.add(response);
    	  
    	  try {
			new ChargesInterfaceService().chargesSdoToSap(list);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
  	}


}
