package com.ey.piit.interfaces.invoice.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ey.piit.interfaces.common.SAPConn;
import com.ey.piit.interfaces.invoice.dto.ZgListBodyDto;
import com.ey.piit.interfaces.invoice.dto.ZgListMsgResponse;
import com.ey.piit.interfaces.shippingsheet.dto.ShippingsheetBodyDto;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

/**
 * 装柜清单 接口服务类
 * @author tianrong
 *
 */
@Service
public class ZgListInterfaceService {
	
 
    /**
     * 推送装柜清单table给SAP系统 并返回msg
     * @param list
     * @return
     * @throws Exception
     */
  	public List<ZgListMsgResponse> ZgListSdoToSap(List<ZgListBodyDto> chlist) throws Exception{
  		String result = "";
  		String msg = "";
  		String chdhs = "";
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		List<ZgListMsgResponse> list=new ArrayList<ZgListMsgResponse>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP收款认领RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_CBS004");
  		    // 获取传入表参数T_ACCDOCUMENT  
            JCoTable inTable = function.getTableParameterList().getTable("Z_TAB");
            for(ZgListBodyDto dto : chlist){
            	inTable.appendRow();//增加一行  
           	    // 给表参数中的字段赋值
           	 	inTable.setValue("CHDNO", dto.getChdno());//出货通知书号
           	 	chdhs = chdhs + dto.getChdno() + "," ;
            }
  		    //执行函数
  			function.execute(destination);
  		    // 获返回信息
  			JCoParameterList outParameter = function.getExportParameterList();
  			result = outParameter.getString("ZFLAG");
  			msg = outParameter.getString("ZMESSAGE");
  			System.out.println("result===>"+result + ",msg=>"+msg);
  			ZgListMsgResponse zgqd = new ZgListMsgResponse();
  			zgqd.setResult(result);
  			zgqd.setMsg(msg);
  			zgqd.setInXml(chdhs);//记录此次出货通知书集合
  			list.add(zgqd);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return list;
  	}

      public static void main(String[] args) throws Exception{
    	//获取测试报文
    	  List<ZgListBodyDto> chlist = new ArrayList<ZgListBodyDto>();
  		ZgListBodyDto ZgListBodyDto =new ZgListBodyDto(); 
  		ZgListBodyDto.setChdno("SA18020371");
  		
  		ZgListBodyDto ZgListBodyDto1 =new ZgListBodyDto(); 
  		ZgListBodyDto1.setChdno("SA18020372");
  		
  		chlist.add(ZgListBodyDto);
  		chlist.add(ZgListBodyDto1);

  		//调用接口
  		List<ZgListMsgResponse> list=new ArrayList<ZgListMsgResponse>();
		list = new ZgListInterfaceService().ZgListSdoToSap(chlist);
  	}

}
