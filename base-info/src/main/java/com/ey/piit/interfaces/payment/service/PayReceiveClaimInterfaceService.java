package com.ey.piit.interfaces.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.common.SAPConn;   
import com.ey.piit.interfaces.payment.dto.PayReceiveClaimBodyDto;
import com.ey.piit.interfaces.payment.dto.PayReceiveClaimMsgResponse;
import com.ey.piit.interfaces.payment.util.PayReceiveClaimUtil;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * 收款认领 接口服务类
 * @author tianrong
 *
 */
@Service
public class PayReceiveClaimInterfaceService {
	
      /**
       * 将数据传输至SAP
       * @return
       */
	public List<PayReceiveClaimMsgResponse> PayReceiveClaimSdoToSap(List<PayReceiveClaimBodyDto> list) throws Exception{
		List<PayReceiveClaimMsgResponse> prclist = new ArrayList<PayReceiveClaimMsgResponse>();
		try {
			String strXml = PayReceiveClaimUtil.payreceiveclaimMsgXml(list);
			System.out.println("strXml=====>"+strXml);
			// 调用SAP接口传输报文，并获取返回结果
			prclist = this.payReceiveClaimXmlToSap(strXml);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return prclist;
	}
     
    /**
     * 推送收款认领报文给SAP系统 并返回PayReceiveClaimMsgResponse
     * @param String PayReceiveClaimXmlStr
     * @return
     * @throws Exception
     */
  	private List<PayReceiveClaimMsgResponse> payReceiveClaimXmlToSap(String payReceiveClaimXmlStr) throws Exception{
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		List<PayReceiveClaimMsgResponse> list=new ArrayList<PayReceiveClaimMsgResponse>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP收款认领RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_FI_1000R");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", payReceiveClaimXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			String outxml=outParameter.getString("XML_OUT");
  			list = PayReceiveClaimUtil.ReadPayreceiveclaimXml(outxml,payReceiveClaimXmlStr);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return list;
  	}
  	
  	/**
     * 推送收款未认领报文给SAP系统 并返回PayReceiveClaimMsgResponse
     * @param String PayReceiveClaimXmlStr
     * @return
     * @throws Exception
     */

/*	private List<PayReceiveClaimMsgResponse> PayUnReceiveClaimXmlToSap(String payReceiveClaimXmlStr) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		List<PayReceiveClaimMsgResponse> list = new ArrayList<PayReceiveClaimMsgResponse>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP销售订单RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_FI_1000");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", payReceiveClaimXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getImportParameterList();
  			list = PayReceiveClaimUtil.ReadPayreceiveclaimXml(outParameter.getString("XML_OUT"),payReceiveClaimXmlStr);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return list;
  	}*/
  	/**
	 * 测试产生报文方法
	 */
    @SuppressWarnings("unused")
	private String test(){
    		List<PayReceiveClaimBodyDto> list = new ArrayList<PayReceiveClaimBodyDto>();
    		PayReceiveClaimBodyDto PayReceiveClaimBodyDto =new PayReceiveClaimBodyDto(); 
    		PayReceiveClaimBodyDto.setGsbm("2110");
    		PayReceiveClaimBodyDto.setSkrq("2016-07-14");
    		PayReceiveClaimBodyDto.setSkdh("160714001");
    		PayReceiveClaimBodyDto.setRlrq("2016-07-14");
    		PayReceiveClaimBodyDto.setRldh("16071400101");
    		PayReceiveClaimBodyDto.setKhbm("kh001");
    		PayReceiveClaimBodyDto.setSkdjje("10000.34");
    		PayReceiveClaimBodyDto.setSkbz("USD");
    		PayReceiveClaimBodyDto.setRlje("5000.23");
    		PayReceiveClaimBodyDto.setRlbz("USD");
    		PayReceiveClaimBodyDto.setFph("FPH001");
    		PayReceiveClaimBodyDto.setSxf("8.4");
    		PayReceiveClaimBodyDto.setSkyhzh("SKYHZH001");
    		PayReceiveClaimBodyDto.setSklx("A");
    		PayReceiveClaimBodyDto.setRlchbs("X");
    		PayReceiveClaimBodyDto.setWrlje("0.0");
    		PayReceiveClaimBodyDto.setZxbmfdm("ZHZHYY02010201");
    		PayReceiveClaimBodyDto.setQyrq("2016-08-31");
    		PayReceiveClaimBodyDto.setSjskrq("2016-07-05");
    		PayReceiveClaimBodyDto.setShbs("2");
    		PayReceiveClaimBodyDto.setLjyshje("4560.0");
    		
    		PayReceiveClaimBodyDto PayReceiveClaimBodyDto1 =new PayReceiveClaimBodyDto(); 
    		PayReceiveClaimBodyDto1.setGsbm("2110");
    		PayReceiveClaimBodyDto1.setSkrq("2016-07-15");
    		PayReceiveClaimBodyDto1.setSkdh("160714002");
    		PayReceiveClaimBodyDto1.setRlrq("2016-07-15");
    		PayReceiveClaimBodyDto1.setRldh("16071400202");
    		PayReceiveClaimBodyDto1.setKhbm("kh002");
    		PayReceiveClaimBodyDto1.setSkdjje("30000.0");
    		PayReceiveClaimBodyDto1.setSkbz("USD");
    		PayReceiveClaimBodyDto1.setRlje("8000.0");
    		PayReceiveClaimBodyDto1.setRlbz("USD");
    		PayReceiveClaimBodyDto1.setFph("FPH002");
    		PayReceiveClaimBodyDto1.setSxf("65.0");
    		PayReceiveClaimBodyDto1.setSkyhzh("SKYHZH002");
    		PayReceiveClaimBodyDto1.setSklx("A");
    		PayReceiveClaimBodyDto1.setRlchbs("");
    		PayReceiveClaimBodyDto1.setWrlje("0.0");
    		PayReceiveClaimBodyDto1.setZxbmfdm("ZHZHYY02010202");
    		PayReceiveClaimBodyDto1.setQyrq("2016-09-31");
    		PayReceiveClaimBodyDto1.setSjskrq("2016-07-15");
    		PayReceiveClaimBodyDto1.setShbs("1");
    		PayReceiveClaimBodyDto1.setLjyshje("30000.0");
    		
    		list.add(PayReceiveClaimBodyDto);
    		list.add(PayReceiveClaimBodyDto1);
    		
    		
    		String xmlStr=PayReceiveClaimUtil.payreceiveclaimMsgXml(list);
    		return xmlStr;
      }

      /**
  	 * 测试产生报文方法
  	 */
        private List<PayReceiveClaimBodyDto> listtest(){
      		List<PayReceiveClaimBodyDto> list = new ArrayList<PayReceiveClaimBodyDto>();
      		PayReceiveClaimBodyDto PayReceiveClaimBodyDto =new PayReceiveClaimBodyDto(); 
      		PayReceiveClaimBodyDto.setGsbm("5010");
      		PayReceiveClaimBodyDto.setSkrq("2016-08-12");
      		PayReceiveClaimBodyDto.setSkdh("160812003");
      		PayReceiveClaimBodyDto.setRlrq("2016-08-23");
      		PayReceiveClaimBodyDto.setRldh("16081200311");
      		PayReceiveClaimBodyDto.setKhbm("2000048");
      		PayReceiveClaimBodyDto.setSkdjje("10000.0000");
      		PayReceiveClaimBodyDto.setSkbz("USD");
      		PayReceiveClaimBodyDto.setRlje("1.0000");
      		PayReceiveClaimBodyDto.setRlbz("USD");
      		PayReceiveClaimBodyDto.setFph("");
      		PayReceiveClaimBodyDto.setSxf("0.0");
      		PayReceiveClaimBodyDto.setSkyhzh("1002");
      		PayReceiveClaimBodyDto.setSklx(" ");
      		PayReceiveClaimBodyDto.setRlchbs(" ");
      		PayReceiveClaimBodyDto.setWrlje("10000.0");
      		PayReceiveClaimBodyDto.setZxbmfdm("DM03");
      		PayReceiveClaimBodyDto.setQyrq("2016-08-16");
      		PayReceiveClaimBodyDto.setSjskrq("2016-08-12");
      		PayReceiveClaimBodyDto.setShbs("2");
      		PayReceiveClaimBodyDto.setLjyshje("0.0");
      		PayReceiveClaimBodyDto.setSkyhgsbm("2110");
      		PayReceiveClaimBodyDto.setTzqje("23.0");
      		
      		PayReceiveClaimBodyDto PayReceiveClaimBodyDto1 =new PayReceiveClaimBodyDto(); 
      		PayReceiveClaimBodyDto1.setGsbm("2110");
      		PayReceiveClaimBodyDto1.setSkrq("2016-07-15");
      		PayReceiveClaimBodyDto1.setSkdh("160714002");
      		PayReceiveClaimBodyDto1.setRlrq("2016-07-15");
      		PayReceiveClaimBodyDto1.setRldh("16071400202");
      		PayReceiveClaimBodyDto1.setKhbm("kh002");
      		PayReceiveClaimBodyDto1.setSkdjje("30000.0");
      		PayReceiveClaimBodyDto1.setSkbz("USD");
      		PayReceiveClaimBodyDto1.setRlje("8000.0");
      		PayReceiveClaimBodyDto1.setRlbz("USD");
      		PayReceiveClaimBodyDto1.setFph("FPH002");
      		PayReceiveClaimBodyDto1.setSxf("65.0");
      		PayReceiveClaimBodyDto1.setSkyhzh("SKYHZH002");
      		PayReceiveClaimBodyDto1.setSklx(" ");
      		PayReceiveClaimBodyDto1.setRlchbs("");
      		PayReceiveClaimBodyDto1.setWrlje("0.0");
      		PayReceiveClaimBodyDto1.setZxbmfdm("ZHZHYY02010202");
      		PayReceiveClaimBodyDto1.setQyrq("2016-09-31");
      		PayReceiveClaimBodyDto1.setSjskrq("2016-07-15");
      		PayReceiveClaimBodyDto1.setShbs("1");
      		PayReceiveClaimBodyDto1.setLjyshje("30000.0");
      		PayReceiveClaimBodyDto1.setSkyhgsbm("2110");
      		PayReceiveClaimBodyDto1.setTzqje("23.0");
      		
      		list.add(PayReceiveClaimBodyDto);
      		list.add(PayReceiveClaimBodyDto1);
      		
      		return list;
        }
        
      public static void main(String[] args) throws Exception{
    	/*//获取测试报文
  		String strXml=new PayReceiveClaimInterfaceService().test();
  		System.out.println(strXml);
  		//调用接口
		List<PayReceiveClaimMsgResponse> prclist=new  ArrayList<PayReceiveClaimMsgResponse>();
    	prclist=new PayReceiveClaimInterfaceService().PayReceiveClaimXmlToSap(strXml);
    	for (int i = 0; i < prclist.size(); i++) {
			PayReceiveClaimMsgResponse jb= prclist.get(i);
		    System.out.println(i+"-rldh="+jb.getRldh());
		    System.out.println(i+"-skdh="+jb.getSkdh());
		    System.out.println(i+"-result="+jb.getResult());
		    System.out.println(i+"-msg="+jb.getMsg());
		} */
    	  List<PayReceiveClaimBodyDto> list=new PayReceiveClaimInterfaceService().listtest();
    	  List<PayReceiveClaimMsgResponse> prclist=new  ArrayList<PayReceiveClaimMsgResponse>();
    	  prclist=new PayReceiveClaimInterfaceService().PayReceiveClaimSdoToSap(list);
    	  for (int i = 0; i < prclist.size(); i++) {
  			PayReceiveClaimMsgResponse jb= prclist.get(i);
  		    System.out.println(i+"-rldh="+jb.getDh());
  		    System.out.println(i+"-skdh="+jb.getSkdh());
  		    System.out.println(i+"-result="+jb.getResult());
  		    System.out.println(i+"-msg="+jb.getMsg());
  		}
  	}

}
