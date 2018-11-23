package com.ey.piit.interfaces.pidbom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.common.ZZSAPConn;  
import com.ey.piit.interfaces.pidbom.dto.PidBomRequest;
import com.ey.piit.interfaces.pidbom.dto.PidBomResponse;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;
/**
 * PID bom接口需要调用制造SAP接口，注意服务器IP连接地址，用户名和密码一致
 * @author denghai
 *
 */
@Service
public class PidBomInterfaceService {
	/**
	 * 供外部调用根据PID,工厂 获取PID Bom数据集
	 * @return
	 */
	public List<PidBomResponse> qryPidBomFromSap(PidBomRequest pidBomRequest) throws Exception{
		List<PidBomResponse> pidBomList = new ArrayList<PidBomResponse>();
		try {
			// 调用SAP接口，并获取返回结果
			pidBomList = this.getPidBomFromSap(pidBomRequest);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return pidBomList;
	}
	/**
	 * 供外部调用根据PID,工厂 获取PID Bom数据集
	 * @return
	 */
	public List<PidBomResponse> qryPpxxFromSap(PidBomRequest pidBomRequest) throws Exception{
		List<PidBomResponse> pidBomList = new ArrayList<PidBomResponse>();
		try {
			// 调用SAP接口，并获取返回结果
			pidBomList = this.getPpxxFromSap(pidBomRequest);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return pidBomList;
	}
	
	/**
	 * 查询PID是否已激活
	 * @return
	 */
	public boolean qryPidSfsxFromSap(PidBomRequest pidBomRequest) throws Exception{
		boolean flag = false;
		try {
			// 调用SAP接口，并获取返回结果
			flag = this.getPidSfsxFromSap(pidBomRequest);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return flag;
	}
	
	/**
	 * 根据PID 和工厂 获取SAP pid BOM结果集
	 * @param String PayReceiveClaimXmlStr
	 * @return
	 * @throws Exception
	 */
	private List<PidBomResponse> getPidBomFromSap(PidBomRequest pidBomRequest) throws Exception{
		JCoFunction function = null;
		//返回对象含报文，和接口处理结果
		List<PidBomResponse> list=new ArrayList<PidBomResponse>();
		// 连接sap，其实就类似于连接数据库
		JCoDestination destination = ZZSAPConn.connect();
		try {
			// 调用Z_RFC_QAI_0003函数
			function = destination.getRepository().getFunction("Z_RFC_MM_1002");
			// 将当前传入的值赋予各个参数 PID
			function.getImportParameterList().setValue("MATNR",pidBomRequest.getPid());
			// 工厂
			function.getImportParameterList().setValue("WERKS",pidBomRequest.getGc());
			// 执行从SAP取数据
			function.execute(destination);
			// 获取物料价格相关信息
			JCoTable outtable = function.getTableParameterList().getTable("ITAB");
			for(int i=0;i<outtable.getNumRows();i++){
				PidBomResponse pidBomResponse = new PidBomResponse();
				pidBomResponse.setPid(pidBomRequest.getPid());
				pidBomResponse.setWlbh(outtable.getString("MATNR"));
				pidBomResponse.setWlms(outtable.getString("MAKTX"));
				pidBomResponse.setSl(Double.parseDouble(outtable.getString("MENGE")));
				pidBomResponse.setDw(outtable.getString("MEINS"));
				pidBomResponse.setMsg(outtable.getString("MESSAGE"));
				// 打印
				System.out.println("--------------------PID-BOM------------------------");
				System.out.println("物料编号---->" + outtable.getString("MATNR"));
				System.out.println("物料描述---->"+ outtable.getString("MAKTX"));
				System.out.println("数量---->" + outtable.getString("MENGE"));
				System.out.println("计量数量单位---->"+ outtable.getString("MEINS"));
				System.out.println("信息---->" + outtable.getString("MESSAGE"));
				System.out.println("----------------------------------------------");
				list.add(pidBomResponse);
				outtable.nextRow();
			}

		} catch (JCoException e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	/**
	 * 根据PID 和工厂 获取SAP pid BOM结果集
	 * @param String PayReceiveClaimXmlStr
	 * @return
	 * @throws Exception
	 */
	private List<PidBomResponse> getPpxxFromSap(PidBomRequest pidBomRequest) throws Exception{
		JCoFunction function = null;
		//返回对象含报文，和接口处理结果
		List<PidBomResponse> list=new ArrayList<PidBomResponse>();
		// 连接sap，其实就类似于连接数据库
		JCoDestination destination = ZZSAPConn.connect();
		try {
			// 调用Z_RFC_QAI_0003函数
			function = destination.getRepository().getFunction("Z_RFC_MM_1002");
			// 将当前传入的值赋予各个参数 PID
			function.getImportParameterList().setValue("MATNR",pidBomRequest.getPid());
			// 工厂
			function.getImportParameterList().setValue("WERKS",pidBomRequest.getGc());
			// 执行从SAP取数据
			function.execute(destination);
			// 获取物料价格相关信息
			JCoTable outtable = function.getTableParameterList().getTable("ITAB");
			for(int i=0;i<outtable.getNumRows();i++){
				PidBomResponse pidBomResponse = new PidBomResponse();
				pidBomResponse.setPid(pidBomRequest.getPid());
				pidBomResponse.setWlbh(outtable.getString("MATNR"));
				list.add(pidBomResponse);
				break; 
			}

		} catch (JCoException e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	/**
	 * 根据PID 和工厂 获取此PID是否激活
	 * @param String getPidSfsxFromSap
	 * @return
	 * @throws Exception
	 */
	private boolean getPidSfsxFromSap(PidBomRequest pidBomRequest) throws Exception{
		String flag = "00";
		JCoFunction function = null;
		// 连接sap，其实就类似于连接数据库
		JCoDestination destination = ZZSAPConn.connect();
		try {
			// 调用Z_RFC_SDO_BOM函数
			function = destination.getRepository().getFunction("Z_RFC_SDO_BOM");
			// 将当前传入的值赋予各个参数 PID
			function.getImportParameterList().setValue("MATNR",pidBomRequest.getPid());
			// 工厂
			function.getImportParameterList().setValue("WERKS",pidBomRequest.getGc());
			// 执行从SAP取数据
			function.execute(destination);
			// 获取返回信息
			JCoTable outtable = function.getTableParameterList().getTable("ZSDOBOM");
			for(int i=0;i<outtable.getNumRows();i++){
				flag = outtable.getString("STLST");
				outtable.nextRow();
			}
		} catch (JCoException e) {
			e.printStackTrace();
			throw e;
		}
		//01 表示有bom ，00表示没有bom
		if("01".equals(flag)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		PidBomRequest pidBomRequest=new PidBomRequest();
		pidBomRequest.setGc("1107");
		pidBomRequest.setPid("C19L19TS2JXXXXXXXX");
		List<PidBomResponse> list=new PidBomInterfaceService().qryPidBomFromSap(pidBomRequest);
		System.out.println(list);
	}
}
