package com.ey.piit.interfaces.approve.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.approve.dto.ApproveBodyDto;
import com.ey.piit.interfaces.approve.dto.ApproveMsgResponse;
import com.ey.piit.interfaces.approve.util.ApproveUtil;
import com.ey.piit.interfaces.common.SAPConn;   
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * SAP单据审批流 回调 接口服务类
 * @author denghai
 *
 */
@Service
public class ApproveInterfaceService {
	
	
	/**
	 * 供外部调用 SAP单据审批流  推送给SAP单据状态
	 * */
	public List<ApproveMsgResponse> approveSdoToSap(List<ApproveBodyDto> list) throws Exception{
		try {
			return approveXmlToSap(this.getApproveXmlStr(list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
      /**
       * 生成报文
       * @return
       */
    private String getApproveXmlStr(List<ApproveBodyDto> list) throws Exception{
    	try {
    		return ApproveUtil.produceApproveMsgXml(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
      
    /**
     * 推送SAP单据审批结果报文给SAP系统 并返回ApproveMsgResponse
     * @param String orderXmlStr
     * @return
     * @throws Exception
     */
    private List<ApproveMsgResponse> approveXmlToSap(String approveXmlStr) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		List<ApproveMsgResponse> outlist=new ArrayList<ApproveMsgResponse>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP 单据审批结果 RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_SD17");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", approveXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			String outXml=outParameter.getString("XML_OUT");
  			System.out.println("approveoutXml===>"+outXml);
  			outlist=ApproveUtil.transfer(outXml,approveXmlStr);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return outlist;
  	}
  	
  
      
	public static void main(String[] args){
    	  ApproveBodyDto dto =new ApproveBodyDto(); 
    	  dto.setGsbm("5030");
    	  dto.setDjlx("2");
    	  dto.setDh("5030B0000000008");
    	  dto.setDhhxm("1");
    	  dto.setSpjg("4");//4审批通过 5审批驳回
    	  dto.setSpyj("");
    	  
    	  /*ApproveBodyDto dto1 =new ApproveBodyDto(); 
    	  dto1.setGsbm("5050");
    	  dto1.setDjlx("1");
    	  dto1.setDh("dh004");
    	  dto1.setDhhxm("2");
    	  dto1.setSpjg("5");//4审批通过 5审批驳回
    	  dto1.setSpyj("数据不完整");*/
    	  
    	  List<ApproveBodyDto> list = new ArrayList<ApproveBodyDto>();
    	  list.add(dto);
    	  //list.add(dto1);
    	  try {
    		  new ApproveInterfaceService().approveSdoToSap(list);
  		} catch (Exception e) {
  			// TODO 自动生成的 catch 块
  			e.printStackTrace();
  		}
  	}


}
