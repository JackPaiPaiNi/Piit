package com.ey.piit.interfaces.shippingsheet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.common.SAPConn;
import com.ey.piit.interfaces.shippingsheet.dto.ShippingsheetBodyDto;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

/**
 * 出货资料表接口服务类
 * @author 魏诚
 *
 */
@Service
public class ShippingsheetInterfaceService {
	
	/**
     * 推送出货资料表给SAP系统 并返回List<ShippingsheetMsgResponse>
     * @param list
     * @return
     * @throws Exception
     */
    public Map<String, String> shippingsheetSdoToSap(List<ShippingsheetBodyDto> list) throws Exception{
	    JCoFunction function = null;
 		//返回对象含报文，和接口处理结果
 		Map<String, String> resultMap = new HashMap<String, String>();
 		// 连接sap，其实就类似于连接数据库
 		JCoDestination destination = SAPConn.connect();
 		try {
 			// 调用SAP出货通知书RFC函数名
 			function = destination.getRepository().getFunction("Z_RFC_CBS005");
 			// 获取传入表参数T_ACCDOCUMENT  
            JCoTable inTable = function.getTableParameterList().getTable("Z_TAB");
            for(ShippingsheetBodyDto dto : list){
            	inTable.appendRow();//增加一行  
           	    // 给表参数中的字段赋值
           	 	inTable.setValue("MATNR", dto.getMatnr());//物料编号
           		inTable.setValue("VBELN", dto.getVbeln());//订单号
           		inTable.setValue("PRICE", dto.getPrice());//申报单价
           		inTable.setValue("WAERS", dto.getWaers());//币别
           		inTable.setValue("MEINS", dto.getMeins());//单位
           		inTable.setValue("ZNOTE", dto.getZnote());//标识（D：删除 M：修改或者新增）
            }
 		    // 执行函数
 			function.execute(destination);
 			JCoParameterList outParameter = function.getExportParameterList();
 			resultMap.put("result", outParameter.getString("ZFLAG"));
 			resultMap.put("message", outParameter.getString("ZMESSAGE"));
 		} catch (JCoException e) {
 			e.printStackTrace();
 			throw e;
 		}
 		return resultMap;
    }
  	
  	/**
	 * 测试产生报文方法
	 */
    public void test(){
		List<ShippingsheetBodyDto> list = new ArrayList<ShippingsheetBodyDto>();
	
		ShippingsheetBodyDto shippingsheetBodyDto = new ShippingsheetBodyDto(); 
		shippingsheetBodyDto.setMatnr("0100-00B22000-02");//物料编号
		shippingsheetBodyDto.setVbeln("17B0005M");//订单号
		shippingsheetBodyDto.setPrice("10");//申报单价
		shippingsheetBodyDto.setWaers("USD");//币别
		shippingsheetBodyDto.setMeins("PC");//单位
		shippingsheetBodyDto.setZnote("M");//标识（D：删除 M：修改或者新增）
		
		ShippingsheetBodyDto shippingsheetBodyDto1 = new ShippingsheetBodyDto(); 
		shippingsheetBodyDto1.setMatnr("0100-00B22000-06");//物料编号
		shippingsheetBodyDto1.setVbeln("1780036P");//订单号
		shippingsheetBodyDto1.setPrice("1000");//申报单价
		shippingsheetBodyDto1.setWaers("RMB");//币别
		shippingsheetBodyDto1.setMeins("PC");//单位
		shippingsheetBodyDto1.setZnote("M");//标识（D：删除 M：修改或者新增）

		list.add(shippingsheetBodyDto);
		list.add(shippingsheetBodyDto1);
		
		try {
			Map<String, String> resultMap = this.shippingsheetSdoToSap(list);
			System.out.println(resultMap);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
    
    
    public static void main(String[] args){
  		new ShippingsheetInterfaceService().test();
  	}
    
}
