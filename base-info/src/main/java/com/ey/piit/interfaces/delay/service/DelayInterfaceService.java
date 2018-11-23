package com.ey.piit.interfaces.delay.service;


import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.common.SAPConn;   
import com.ey.piit.interfaces.delay.dto.DelayMsgRequest;
import com.ey.piit.interfaces.delay.dto.DelayMsgResponse;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

@Service
public class DelayInterfaceService {
	/**
	 * 供外部调用根据客户编码 获取客户应收超期
	 * @return
	 */
	public DelayMsgResponse qryKhYscqFromSap(DelayMsgRequest delayRequest) throws Exception{
		DelayMsgResponse delayMsgResponse = null;
		try {
			// 调用SAP接口，并获取返回结果
			delayMsgResponse = this.getKhyscqFromSap(delayRequest);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return delayMsgResponse;
	}

	/**
	 * 根据PID 和工厂 获取SAP pid BOM结果集
	 * @param String PayReceiveClaimXmlStr
	 * @return
	 * @throws Exception
	 */
	private DelayMsgResponse getKhyscqFromSap(DelayMsgRequest delayRequest) throws Exception{
		JCoFunction function = null;
		//返回对象含报文，和接口处理结果
		DelayMsgResponse delayMsgResponse=null;
		// 连接sap，其实就类似于连接数据库
		JCoDestination destination = SAPConn.connect();
		try {
			// 调用Z_RFC_FI165函数
			function = destination.getRepository().getFunction("Z_RFC_FI165");
			// 将当前传入的值赋予各个参数 PID
			//function.getImportParameterList().setValue("IV_GSBM",delayRequest.getGsbm());
			// 工厂
			function.getImportParameterList().setValue("IV_KHBM",delayRequest.getKhbm());
			// 执行从SAP取数据
			function.execute(destination);
			// 获取物料价格相关信息
			JCoTable outtable = function.getTableParameterList().getTable("T_OUT");
            if(!outtable.isEmpty()){
            	delayMsgResponse=new DelayMsgResponse();
				delayMsgResponse.setGsbm(outtable.getString("GSBM"));
				delayMsgResponse.setKhbm(outtable.getString("KHBM"));
				delayMsgResponse.setFph(outtable.getString("FPH"));
				delayMsgResponse.setJe(Double.parseDouble(outtable.getString("JE")));
				delayMsgResponse.setFktj(outtable.getString("FKTJ"));
				delayMsgResponse.setCqts(Integer.parseInt(outtable.getString("CQTS")));
				delayMsgResponse.setSfzc(outtable.getString("SFZC"));
					// 打印
				System.out.println("--------------------getKhyscqFromSap------------------------");
				System.out.println("公司编码---->" + outtable.getString("GSBM"));
				System.out.println("客户编码---->"+ outtable.getString("KHBM"));
				System.out.println("发票号---->" + outtable.getString("FPH"));
				System.out.println("金额---->"+ outtable.getString("JE"));
				System.out.println("付款条件---->"+ outtable.getString("FKTJ"));
				System.out.println("超期天数---->"+ outtable.getString("CQTS"));
				System.out.println("是否最长---->" + outtable.getString("SFZC"));
				System.out.println("----------------------------------------------");
            }
            

		} catch (JCoException e) {
			e.printStackTrace();
			throw e;
		}
		/*delayMsgResponse=new DelayMsgResponse();
		delayMsgResponse.setKhbm(delayRequest.getKhbm());
		delayMsgResponse.setCqts(0);
		delayMsgResponse.setGsbm(null);
		delayMsgResponse.setFph(null);
		delayMsgResponse.setJe(null);
		delayMsgResponse.setFktj(null);
		delayMsgResponse.setSfzc(null);*/
		
		return delayMsgResponse;
	}


	public static void main(String[] args) throws Exception{
		  DelayMsgRequest delayMsgRequest=new DelayMsgRequest();
		  delayMsgRequest.setKhbm("0010000235");//
          new DelayInterfaceService().qryKhYscqFromSap(delayMsgRequest);

	}
}
