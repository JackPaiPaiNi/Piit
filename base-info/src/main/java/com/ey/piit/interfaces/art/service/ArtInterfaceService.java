package com.ey.piit.interfaces.art.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.art.dto.ArtBodyDto;
import com.ey.piit.interfaces.art.dto.ArtMsgResponse;
import com.ey.piit.interfaces.art.util.ArtUtil;
import com.ey.piit.interfaces.common.ZZSAPConn;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * 美工任务单 接口服务类
 * @author 魏诚
 *
 */
@Service
public class ArtInterfaceService {
	
	
	/**
	 * 供外部调用美工任务单与sap接口
	 * */
	
   public ArtMsgResponse artSdoToSap(List<ArtBodyDto> list) throws Exception{
		try {
			return artXmlToSap(this.getArtXmlStr(list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
   }
	
      /**
       * 生成美工任务单报文
       * @return
       */
    private String getArtXmlStr(List<ArtBodyDto> list) throws Exception{
    	try {
    		return ArtUtil.produceArtMsgXml(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
      
    /**
     * 推送美工任务单报文给SAP系统 并返回ArtMsgResponse
     * @param String ArtXmlStr
     * @return
     * @throws Exception
     */
    private ArtMsgResponse artXmlToSap(String artXmlStr) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		ArtMsgResponse outArtMsgResponse=new ArtMsgResponse();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = ZZSAPConn.connect();
  		try {
  			// 调用SAP美工任务单RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_SDO_1000");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("INXML", artXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			outArtMsgResponse=ArtUtil.transfer(outParameter.getString("OUTXML"));
  			
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		System.out.println("xml==>"+outArtMsgResponse.getOutXml());
  		//设置输入报文
  		outArtMsgResponse.setInXml(artXmlStr);
  		return outArtMsgResponse;
  	}
  	
  	/**
	 * 测试产生报文方法
	 */
    public void test(){
    	List<ArtBodyDto> list = new ArrayList<ArtBodyDto>();
    	
		ArtBodyDto ArtBodyDto =new ArtBodyDto(); 
		ArtBodyDto.setSheetno("SOFTLOGICPRIZM7N01T32E2LKC18V0");
		ArtBodyDto.setMatnr("PP00-32E2X0-BR");
		
		list.add(ArtBodyDto);
    		
    	String xmlStr = ArtUtil.produceArtMsgXml(list);
    	System.out.println(xmlStr);
		try {
			ArtMsgResponse dmr = this.artXmlToSap(xmlStr);
			System.out.println(dmr);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
      
    public static void main(String[] args){
  		new ArtInterfaceService().test();
  	}


}
