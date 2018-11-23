package com.ey.piit.interfaces.delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.common.SAPConn;   
import com.ey.piit.interfaces.delivery.dto.DeliverBodyDto;
import com.ey.piit.interfaces.delivery.dto.DeliverHeaderDto;
import com.ey.piit.interfaces.delivery.dto.DeliverMsgResponse;
import com.ey.piit.interfaces.delivery.util.DeliverUtil;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * 出货通知书 接口服务类
 * @author denghai
 *
 */
@Service
public class DeliverInterfaceService {
	
	
	/**
	 * 供外部调用出货通知书与sap接口
	 * */
	
   public DeliverMsgResponse deliverSdoToSap(DeliverHeaderDto deliverHeaderDto,List<DeliverBodyDto> list) throws Exception{
		try {
			return deliverXmlToSap(this.getDeliverXmlStr(deliverHeaderDto, list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
   }
	
      /**
       * 生成出货通知书报文
       * @return
       */
    private String getDeliverXmlStr(DeliverHeaderDto deliverHeaderDto,List<DeliverBodyDto> list) throws Exception{
    	try {
    		return DeliverUtil.produceDeliverMsgXml(deliverHeaderDto, list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
      
    /**
     * 推送出货通知书报文给SAP系统 并返回DeliverMsgResponse
     * @param String deliverXmlStr
     * @return
     * @throws Exception
     */
    private DeliverMsgResponse deliverXmlToSap(String deliverXmlStr) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		DeliverMsgResponse outDeliverMsgResponse=new DeliverMsgResponse();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP出货通知书RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_SDO_1001");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", deliverXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			outDeliverMsgResponse=DeliverUtil.transfer(outParameter.getString("XML_OUT"));
  			
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		System.out.println("xml==>"+outDeliverMsgResponse.getOutXml());
  		//设置输入报文
  		outDeliverMsgResponse.setInXml(deliverXmlStr);
  		return outDeliverMsgResponse;
  	}
  	
  	/**
	 * 测试产生报文方法
	 */
      public void test(){
    	  DeliverHeaderDto msgHeader = new DeliverHeaderDto();
    		
            msgHeader.setChdh("SA16060003");
    		msgHeader.setFhr("susan");	
    		msgHeader.setUpdate("I");
    		msgHeader.setXwgj("XWGJ");
    		msgHeader.setGsbm("5050");
    		msgHeader.setZdrq("2016-09-09");
    		msgHeader.setGsmc("创维澳门离岸商业服务有限公司");

    		List<DeliverBodyDto> list = new ArrayList<DeliverBodyDto>();
    	
    		DeliverBodyDto deliverBodyDto =new DeliverBodyDto(); 
    		deliverBodyDto.setUpdate("I");
    		deliverBodyDto.setRowid("1");
    		deliverBodyDto.setDdh("20000310");
    		deliverBodyDto.setSpmc("SPMC");
    		deliverBodyDto.setUpdate("I");
    		deliverBodyDto.setJixing("JIXING");
    		deliverBodyDto.setKhxh("KHXH");
    		deliverBodyDto.setBz("RMB");
    		deliverBodyDto.setJe("6000");
    		deliverBodyDto.setPp("pp");
    		deliverBodyDto.setSl("2");
    		deliverBodyDto.setYzhdh("yzhdh");
    		
    		deliverBodyDto.setMfjsl("4");
    		deliverBodyDto.setDj("100");
    		
    		DeliverBodyDto deliverBodyDto1 =new DeliverBodyDto(); 
    		deliverBodyDto1.setUpdate("I");
    		deliverBodyDto1.setRowid("2");
    		deliverBodyDto1.setDdh("20000310");
    		deliverBodyDto1.setSpmc("SPMC");
    		deliverBodyDto1.setUpdate("I");
    		deliverBodyDto1.setJixing("JIXING");
    		deliverBodyDto1.setKhxh("KHXH");
    		deliverBodyDto1.setBz("RMB");
    		deliverBodyDto1.setJe("5000");
    		deliverBodyDto1.setPp("pp");
    		deliverBodyDto1.setSl("2");
    		deliverBodyDto1.setYzhdh("yzhdh");
    		deliverBodyDto1.setMfjsl("4");
    		deliverBodyDto1.setDj("400");
    		
    		/*DeliverBodyDto deliverBodyDto2 =new DeliverBodyDto(); 
    		deliverBodyDto2.setDdh("20000265");
    		deliverBodyDto2.setSpmc("SPMC");
    		deliverBodyDto2.setUpdate("I");
    		deliverBodyDto2.setJixing("JIXING");
    		deliverBodyDto2.setKhxh("KHXH");
    		deliverBodyDto2.setBz("RMB");
    		deliverBodyDto2.setJe("2000");
    		deliverBodyDto2.setPp("pp");
    		deliverBodyDto2.setSl("20");
    		deliverBodyDto2.setYzhdh("yzhdh");
    		deliverBodyDto2.setMfjsl("2");
    		deliverBodyDto2.setDj("300");*/

    		list.add(deliverBodyDto);
    		list.add(deliverBodyDto1);
    		//list.add(deliverBodyDto2);
    		
    		String xmlStr=DeliverUtil.produceDeliverMsgXml(msgHeader, list);
    		System.out.println(xmlStr);
    		try {
    			DeliverMsgResponse dmr=this.deliverXmlToSap(xmlStr);
    			System.out.println(dmr);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
      }
      
      public static void main(String[] args){
  		new DeliverInterfaceService().test();
  	}


}
