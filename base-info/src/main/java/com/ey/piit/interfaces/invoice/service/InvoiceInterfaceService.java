package com.ey.piit.interfaces.invoice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.interfaces.common.SAPConn;   
import com.ey.piit.interfaces.invoice.dto.InvoiceBodyDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceCancelDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceCancelMsgRquest;
import com.ey.piit.interfaces.invoice.dto.InvoiceHeaderDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceMsgResponse;
import com.ey.piit.interfaces.invoice.util.InvoiceUtil;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

/**
 * 商业发票明细 接口服务类
 * @author tianrong
 *
 */
@Service
public class InvoiceInterfaceService {
	
	/**
	 * 供外部调用的sdo推送商业发票给SAP接口
	 */
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	
	public InvoiceMsgResponse invoiceSdoToSap(InvoiceHeaderDto invoiceHeaderDto,List<InvoiceBodyDto> list) throws Exception{
		try {
			return invoiceXmlToSap(this.getInvoiceXmlStr(invoiceHeaderDto, list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	//新发票功能
	public List<InvoiceMsgResponse> invoicenewSdoToSap(InvoiceHeaderDto invoiceHeaderDto,List<InvoiceBodyDto> list) throws Exception{
		try {
			String inxml = this.getInvoiceXmlStr(invoiceHeaderDto, list);
			//先存储报文
			// 保存推送日志
			SapInterfaceLogVo logvo = new SapInterfaceLogVo();
			logvo.setId(Identities.uuid());
			logvo.setDh(invoiceHeaderDto.getFph());
			logvo.setMk("商业发票" + invoiceHeaderDto.getFplx());
			logvo.setSj(new Date());
			logvo.setFhzt(-1);
			logvo.setFhxx("推送前保存");
			logvo.setBw(inxml);
			try {
				sapInterfaceLogService.save(logvo);
			} catch (Exception e) {
				new ServiceException("推送前保存商业发票报文出错!");
			}
			return invoiceXmlToSapNew(inxml);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 供外部调用的sdo批量冲销商业发票SAP接口
	 */
	
	public List<InvoiceCancelDto> cancelInvoiceSdoToSap(InvoiceCancelMsgRquest invoiceCancelMsgRquest) throws Exception{
		try {
			return this.cancelInvoiceToSap(invoiceCancelMsgRquest);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 供外部调用的sdo单条冲销商业发票SAP接口
	 */
	
	public List<InvoiceCancelDto> singleCancelInvoiceSdoToSap(String fph,String cxrq) throws Exception{
		try {
			return this.singleInvoiceCancelToSap(fph,cxrq);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
      /**
       * 生成商业发票明细报文
       * @return
       */
    private String getInvoiceXmlStr(InvoiceHeaderDto invoiceHeaderDto,List<InvoiceBodyDto> list) throws Exception{
    	try {
    		return InvoiceUtil.InvoiceMsgXml(invoiceHeaderDto, list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
      
    /**
     * 推送商业发票明细报文给SAP系统 并返回InvoiceMsgResponse
     * @param String invoiceXmlStr
     * @return
     * @throws Exception
     */
    private InvoiceMsgResponse invoiceXmlToSap(String invoiceXmlStr) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		InvoiceMsgResponse invoiceMsgResponse= new InvoiceMsgResponse();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP 商业发票推送RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_SD27");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", invoiceXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			String outXml=outParameter.getString("XML_OUT");
  			invoiceMsgResponse =InvoiceUtil.transfer(outXml);
  			System.out.println("OutXml=====>"+outXml);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return invoiceMsgResponse;
  	}
    
  //新发票功能
  	private List<InvoiceMsgResponse> invoiceXmlToSapNew(String invoiceXmlStr) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		List<InvoiceMsgResponse> Ilist = new ArrayList<InvoiceMsgResponse>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP 商业发票推送RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_SD27");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("XML_IN", invoiceXmlStr);//报文内容
  		    //执行函数
  			function.execute(destination);
  			// 获返回报文
  			JCoParameterList outParameter = function.getExportParameterList();
  			String outXml=outParameter.getString("XML_OUT");
  			Ilist =InvoiceUtil.transfernew(invoiceXmlStr,outXml);
  			System.out.println("OutXml=====>"+outXml);
  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return Ilist;
  	}
  	
  	/**
     * 单条冲销SAP商业发票接口
     * @param String fph发票号  String cxrq 冲销日期
     * @return
     * @throws Exception
     */
  	private List<InvoiceCancelDto> singleInvoiceCancelToSap(String fph,String cxrq) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		//nvoiceMsgResponse outInvoiceMsgResponse=new InvoiceMsgResponse();
  		List<InvoiceCancelDto> resultList = new ArrayList<InvoiceCancelDto>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		try {
  			// 调用SAP 商业发票推送RFC函数名
  			function = destination.getRepository().getFunction("Z_RFC_SD27_CX");
  			// 将当前传入的值赋予各个参数
  			// 获取传入表参数T_ACCDOCUMENT
  			JCoParameterList inParameterList = function.getImportParameterList();	
  			// 报文内容
  			inParameterList.setValue("IV_FPH", fph);//SDO发票号
  			inParameterList.setValue("IV_BUDAT", cxrq);//冲销日期 yyyy-mm-dd
  		    //执行函数
  			function.execute(destination);
  			JCoTable outTable = function.getTableParameterList().getTable("ET_TABLE");  
  			for(int i=0;i<outTable.getNumRows();i++){
  				//设置指针位置
  			     outTable.setRow(i);
	       		 InvoiceCancelDto invoiceCancelDto = new InvoiceCancelDto();
	       		 invoiceCancelDto.setFph(outTable.getString("FPH")); 
	       		 invoiceCancelDto.setSapfph(outTable.getString("SAPFP")); 
	       		 invoiceCancelDto.setFplx(outTable.getString("FPLX")); 
	       		 invoiceCancelDto.setResult(outTable.getString("RESULT")); //X成功 F失败
	       		 invoiceCancelDto.setMsg(outTable.getString("MSG"));  
	       		 resultList.add(invoiceCancelDto);
            }     
       	 outTable.clear();//清空本次条件，如果要继续传入值去或者还要循环，那得将之前的条件清空 

  		} catch (JCoException e) {
  			e.printStackTrace();
  			throw e;
  		}
  		return resultList;
  	}
  	
  	 /**
     * 批量冲销SAP商业发票接口
     * @param String invoiceXmlStr
     * @return
     * @throws Exception
     */
  	private List<InvoiceCancelDto> cancelInvoiceToSap(InvoiceCancelMsgRquest invoiceCancelMsgRquest) throws Exception {
  		JCoFunction function = null;
  		//返回对象含报文，和接口处理结果
  		List<InvoiceCancelDto> resultList = new ArrayList<InvoiceCancelDto>();
  		// 连接sap，其实就类似于连接数据库
  		JCoDestination destination = SAPConn.connect();
  		 try {  
             //调用ZRFC_GET_REMAIN_SUM函数  
             function = destination.getRepository().getFunction("Z_RFC_SD27_CX");  
             //获取传入表参数T_ACCDOCUMENT  
             JCoTable inTable = function.getTableParameterList().getTable("IT_TABLE");  
             List<InvoiceCancelDto> list= invoiceCancelMsgRquest.getInvoiceCancelList();
             for(InvoiceCancelDto invoiceCancelDto:list){
            	 inTable.appendRow();//增加一行  
            	   //给表参数中的字段赋值，此处测试，就随便传两个值进去  
            	 inTable.setValue("FPH", invoiceCancelDto.getFph());  //发票号
            	 inTable.setValue("SAPFP", invoiceCancelDto.getSapfph()); //sap发票号
            	 inTable.setValue("FPLX", invoiceCancelDto.getFplx());  //1销售发票 2公司间发票
            	 inTable.setValue("BUDAT", invoiceCancelDto.getCxrq()); //yyyy-mm-dd 
             }

             function.execute(destination);  
             JCoTable outTable = function.getTableParameterList().getTable("ET_TABLE");  
        	 while(outTable.nextRow()){
        		 InvoiceCancelDto invoiceCancelDto = new InvoiceCancelDto();
        		 invoiceCancelDto.setFph(outTable.getString("FPH")); 
        		 invoiceCancelDto.setSapfph(outTable.getString("SAPFP")); 
        		 invoiceCancelDto.setFplx(outTable.getString("FPLX")); 
        		 invoiceCancelDto.setResult(outTable.getString("RESULT")); //X成功 F失败
        		 invoiceCancelDto.setMsg(outTable.getString("MSG"));  
        		 resultList.add(invoiceCancelDto);
             }     
        	 outTable.clear();//清空本次条件，如果要继续传入值去或者还要循环，那得将之前的条件清空  
         }catch (Exception e) {  
             e.printStackTrace();  
         }  
  		return resultList;
  	}
  	
  	/**
	 * 测试产生报文方法
	 */
     /* public InvoiceMsgResponse test(){
    		InvoiceHeaderDto Header = new InvoiceHeaderDto();
    		Header.setGsbm("2110");
    		Header.setKhbm("kh001");
    		Header.setZxbdm("MFDM001");
    		Header.setFph("FP001");
    		Header.setJe("180000.0");
    		Header.setKprq("2016-06-06");
    		Header.setQyrq("2016-07-06");
    		Header.setYjddq("2016-07-15");
    		Header.setCylx("ZYFS001");
    		Header.setFktj("T000");
    		Header.setGjmytj("MY001");
    		Header.setGjmytjbz("MY002");
    		Header.setBz("USD");
    		Header.setTdh("TD001");
    		Header.setLcbh("LC001");
    		Header.setHgbm("hgbm");
    		Header.setKzhdm("KZHDM");
    		Header.setKpfs("1");
    	

    		List<InvoiceBodyDto> list = new ArrayList<InvoiceBodyDto>();
    		InvoiceBodyDto BodyDto =new InvoiceBodyDto(); 
    		BodyDto.setDdh("DD001");
    		BodyDto.setChdh("CHDH001");
    		//BodyDto.setWllb("001");
    		BodyDto.setWlbm("WLBM001");
    		BodyDto.setWlms("WLMS001");
    		BodyDto.setSl(5000);
    		BodyDto.setDw("DW01");
    		BodyDto.setDj(new BigDecimal(100.0));
    		//BodyDto.setJe(40000.0);
    		
    		list.add(BodyDto);
    		
    		String xmlStr=InvoiceUtil.InvoiceMsgXml(Header, list);
    		System.out.println(xmlStr);
    		InvoiceMsgResponse imr=new InvoiceMsgResponse();;
    		try {
    			imr=new InvoiceInterfaceService().invoiceSdoToSap(Header,list);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    		return imr;
    		
      }
      
       public static void main(String[] args){
    	  InvoiceMsgResponse imr=new InvoiceInterfaceService().test();
    	  System.out.println(imr);
  	}
  	
  	*/
  	
  	public List<InvoiceMsgResponse> test(){
		InvoiceHeaderDto Header = new InvoiceHeaderDto();
		Header.setGsbm("2110");
		Header.setKhbm("kh001");
		Header.setZxbdm("MFDM001");
		Header.setFph("FP001");
		Header.setJe("180000.0");
		Header.setKprq("2016-06-06");
		Header.setQyrq("2016-07-06");
		Header.setYjddq("2016-07-15");
		Header.setCylx("ZYFS001");
		Header.setFktj("T000");
		Header.setGjmytj("MY001");
		Header.setGjmytjbz("MY002");
		Header.setBz("USD");
		Header.setTdh("TD001");
		Header.setLcbh("LC001");
		Header.setHgbm("hgbm");
		Header.setKzhdm("KZHDM");
		Header.setKpfs("1");
	

		List<InvoiceBodyDto> list = new ArrayList<InvoiceBodyDto>();
		InvoiceBodyDto BodyDto =new InvoiceBodyDto(); 
		BodyDto.setDdh("DD001");
		BodyDto.setChdh("CHDH001");
		//BodyDto.setWllb("001");
		BodyDto.setWlbm("WLBM001");
		BodyDto.setWlms("WLMS001");
		BodyDto.setSl(new BigDecimal(5000.0));
		BodyDto.setDw("DW01");
		BodyDto.setDj(new BigDecimal(100.0));
		//BodyDto.setJe(40000.0);
		
		list.add(BodyDto);
		
		String xmlStr=InvoiceUtil.InvoiceMsgXml(Header, list);
		System.out.println(xmlStr);
		List<InvoiceMsgResponse> imr=new ArrayList<InvoiceMsgResponse>();;
		try {
			imr=new InvoiceInterfaceService().invoicenewSdoToSap(Header,list);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return imr;
		
  }
      
      public static void main(String[] args){
    	  List<InvoiceMsgResponse> imr=new InvoiceInterfaceService().test();
    	  System.out.println(imr);
  	}


}
