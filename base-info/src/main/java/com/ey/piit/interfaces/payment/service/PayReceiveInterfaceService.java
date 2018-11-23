package com.ey.piit.interfaces.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.common.SAPConn;   
import com.ey.piit.interfaces.payment.dto.PayReceiveBodyDto;
import com.ey.piit.interfaces.payment.dto.PayReceiveClaimBodyDto;
import com.ey.piit.interfaces.payment.dto.PayReceiveClaimMsgResponse;
import com.ey.piit.interfaces.payment.dto.PayReceiveMsgResponse;
import com.ey.piit.interfaces.payment.util.PayReceiveClaimUtil;
import com.ey.piit.interfaces.payment.util.PayReceiveUtil;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * 收款登记 接口服务类
 * @author 邓海
 *
 */
@Service
public class PayReceiveInterfaceService {
	
      /**
       * 将数据传输至SAP
       * @return
       */
	public PayReceiveMsgResponse PayReceiveSdoToSap(List<PayReceiveBodyDto> list) throws Exception{
		PayReceiveMsgResponse pr = new PayReceiveMsgResponse();
		try {
			// 调用SAP接口传输报文，并获取返回结果
			pr = this.payReceiveXmlToSap(PayReceiveUtil.payreceiveMsgXml(list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return pr;
	}
     
    /**
     * 推送收款登记报文给SAP系统 并返回PayReceiveMsgResponse
     * @param String PayReceiveClaimXmlStr
     * @return
     * @throws Exception
     */
  	private PayReceiveMsgResponse payReceiveXmlToSap(String payReceiveXmlStr) throws Exception{
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		PayReceiveMsgResponse payReceiveMsgResponse=new PayReceiveMsgResponse();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP收款认领RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_FI_1000B");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", payReceiveXmlStr);//报文内容
  			System.out.println("xmlin==>" + payReceiveXmlStr);
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			String outxml=outParameter.getString("XML_OUT");
  			System.out.println("xmlout==>" + outxml);
  			payReceiveMsgResponse = PayReceiveUtil.ReadPayreceiveXml(outxml,payReceiveXmlStr);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		payReceiveMsgResponse.setInXml(payReceiveXmlStr);
  		return payReceiveMsgResponse;
  	}
  	
  	
  	/**
	 * 测试产生报文方法
	 */
	private String test(){
    		List<PayReceiveBodyDto> list = new ArrayList<PayReceiveBodyDto>();
    		PayReceiveBodyDto payReceiveBodyDto =new PayReceiveBodyDto(); 
    		payReceiveBodyDto.setSkdh("160714001");
    		payReceiveBodyDto.setSkyhzh("16071400101");
    		payReceiveBodyDto.setJe("4560.0");
    		payReceiveBodyDto.setBz("USD");
    		payReceiveBodyDto.setSkrq("2016-07-14");
    		payReceiveBodyDto.setSkdjrq("2016-07-14");
    		payReceiveBodyDto.setBzxx("备注信息");
    		payReceiveBodyDto.setGsbm("2110");
    		payReceiveBodyDto.setFlag("");;
    		
    		list.add(payReceiveBodyDto);
    		
    		
    		String xmlStr=PayReceiveUtil.payreceiveMsgXml(list);
    		return xmlStr;
      }

    
        
      public static void main(String[] args) throws Exception{
    	  String xml=new PayReceiveInterfaceService().test();
    	  System.out.print(xml);
  	}

}
