package com.ey.piit.interfaces.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.piit.interfaces.common.SAPConn;
import com.ey.piit.interfaces.common.ZZSAPConn;
import com.ey.piit.interfaces.order.dto.OrderBodyDto;
import com.ey.piit.interfaces.order.dto.OrderHeaderDto;
import com.ey.piit.interfaces.order.dto.OrderMsgResponse;
import com.ey.piit.interfaces.order.dto.OrderZZHeaderDto;
import com.ey.piit.interfaces.order.util.OrderUtil;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * 订单通知书 接口服务类 服务1：SDO与海外SAP接口 ；服务2：SDO与制造SAP接口
 * 
 * @author denghai
 *
 */
@Service
public class OrderInterfaceService {

	/**
	 * 供外部调用订单与海外sap接口
	 * */

	public OrderMsgResponse orderSdoToHwSap(OrderHeaderDto orderHeaderDto,
			List<OrderBodyDto> list) throws Exception {
		try {
			return orderXmlToHwSap(this.getOrderXmlStr(orderHeaderDto, list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 供外部调用订单与制造sap接口
	 */
	public OrderMsgResponse orderSdoToZzSap(OrderZZHeaderDto orderZZHeaderDto,
			List<OrderBodyDto> list) throws Exception {
		try {
			return orderXmlToZzSap(this.getOrderXmlStr(orderZZHeaderDto, list));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 生成订单通知书报文
	 * 
	 * @return
	 */
	private String getOrderXmlStr(OrderHeaderDto orderHeaderDto,
			List<OrderBodyDto> list) throws Exception {
		try {
			return OrderUtil.produceOrderMsgXml(orderHeaderDto, list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 生成订单通知书报文
	 * 
	 * @return
	 */
	private String getOrderXmlStr(OrderZZHeaderDto orderZZHeaderDto,
			List<OrderBodyDto> list) throws Exception {
		try {
			return OrderUtil.produceOrderMsgXml(orderZZHeaderDto, list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 推送订单通知书报文给海外SAP系统 并返回OrderMsgResponse
	 * 
	 * @param String
	 *            orderXmlStr
	 * @return
	 * @throws Exception
	 */
	private OrderMsgResponse orderXmlToHwSap(String orderXmlStr)
			throws Exception {
		JCoFunction function = null;
		// 返回对象含报文，和接口处理结果
		OrderMsgResponse outOrderMsgResponse = new OrderMsgResponse();
		// 连接sap，其实就类似于连接数据库
		JCoDestination destination = SAPConn.connect();
		try {
			// 调用SAP销售订单RFC函数名
			function = destination.getRepository().getFunction("Z_RFC_SDO_SALEORDER");
			// 将当前传入的值赋予各个参数
			// 获取传入表参数T_ACCDOCUMENT
			JCoParameterList inParameterList = function.getImportParameterList();
			// 报文内容
			inParameterList.setValue("XML_IN", orderXmlStr);// 报文内容
			System.out.println("hwxmlin==>" + orderXmlStr);
			// 执行函数
			function.execute(destination);
			// 获返回报文
			JCoParameterList outParameter = function.getExportParameterList();
			outOrderMsgResponse = OrderUtil.transfer(outParameter.getString("XML_OUT"));
			System.out.println("hwxmlout==>" + outParameter.getString("XML_OUT"));
		} catch (JCoException e) {
			e.printStackTrace();
			throw e;
		}
		outOrderMsgResponse.setInXml(orderXmlStr);
		return outOrderMsgResponse;
	}

	/**
	 * 推送订单通知书报文给制造SAP系统 并返回OrderMsgResponse
	 * 
	 * @param String
	 *            orderXmlStr
	 * @return
	 * @throws Exception
	 */
	private OrderMsgResponse orderXmlToZzSap(String orderXmlStr)
			throws Exception {
		JCoFunction function = null;
		// 返回对象含报文，和接口处理结果
		OrderMsgResponse outOrderMsgResponse = new OrderMsgResponse();
		// 连接sap，其实就类似于连接数据库
		JCoDestination destination = ZZSAPConn.connect();
		try {
			// 调用SAP销售订单RFC函数名
			function = destination.getRepository().getFunction("Z_RFC_SDO_SALEORDER");
			// 将当前传入的值赋予各个参数
			// 获取传入表参数T_ACCDOCUMENT
			JCoParameterList inParameterList = function.getImportParameterList();
			// 报文内容
			inParameterList.setValue("XML_IN", orderXmlStr);// 报文内容
			System.out.println("zzxmlin==>" + orderXmlStr);
			// 执行函数
			function.execute(destination);
			// 获返回报文
			JCoParameterList outParameter = function.getExportParameterList();
			System.out.println("zzxml==>" + outParameter.getString("XML_OUT"));
			outOrderMsgResponse = OrderUtil.transfer(outParameter.getString("XML_OUT"));
			
		} catch (JCoException e) {
			e.printStackTrace();
			throw e;
		}
		outOrderMsgResponse.setInXml(orderXmlStr);
		return outOrderMsgResponse;
	}

	/**
	 * 测试产生报文方法
	 */
	@SuppressWarnings("unused")
	public void test() {
		OrderHeaderDto msgHeader = new OrderHeaderDto();
		/**
		 * "1. 《订单通知书》中此处选择的是‘多元化产品’时，产品组为20，其它情况默认为10 2. 样机是10 3. 《备损订单》默认为30"
		 */
		msgHeader.setUpdate("I");
		msgHeader.setXszzdm("0102");
		msgHeader.setYwz("210");
		msgHeader.setXsddh("1780782S");
		// 大货订单 ZF01. 《订单通知书》对应ZF01 《样机订单》对应的订单类型为‘ZF04’
		// 《备损订单》对应为‘ZF05’《多元化订单》对应为‘ZF08’
		msgHeader.setDdlx("ZF01");
		msgHeader.setZhfs("Z002");
		msgHeader.setXszz("5250");
		msgHeader.setFxqd("10");// 默认全部10
		msgHeader.setCpz("10");
		msgHeader.setKhbm("SKY5150");
		msgHeader.setXwgj("ZA");
		msgHeader.setXsy("0050000046");
		msgHeader.setDdh("1780782S");
		msgHeader.setFktj("OA90");
		msgHeader.setGjmytk("CIF");
		msgHeader.setGjmytkbz("CIF DURBAN");
		msgHeader.setDdbm("S");
		msgHeader.setRz("CB,其他2,备注");
		msgHeader.setJhrq("2017-09-26");
		msgHeader.setMjxh("STL-49E2000G");
		msgHeader.setDdlb("翻单");
		msgHeader.setPp("SINOTEC");
		msgHeader.setHwkh("SKY5150");
		msgHeader.setBz("USD");

		List<OrderBodyDto> list = new ArrayList<OrderBodyDto>();
		/**
		 * 1. 《订单通知书》 a) CBU对应ZT01； b)
		 * CKD/SKD的PID对应ZT06，散件对应ZT01，收费备损对应ZT03，免费备损对应ZT04
		 * ，收费样机对应ZT01，免费样机对应ZT02； 2. 《多元化订单》收费产品对应ZT01，免费产品对应ZT02 3.
		 * 《样机订单》：收费样机对应ZT01，免费样机对应ZT02； 4. 《备损订单》收费备损对应ZT03，免费备损对应ZT04
		 */

		OrderBodyDto orderBodyDto1 = new OrderBodyDto();
		orderBodyDto1.setUpdate("I");
		orderBodyDto1.setRowid("1");// 行号
		orderBodyDto1.setWlbm("H49E20006M33GC1D70");
		orderBodyDto1.setXsdw("ST");
		orderBodyDto1.setSl("1200");
		orderBodyDto1.setXmlb("ZT07");
		orderBodyDto1.setGc("2110");// 默认全部传2110
		orderBodyDto1.setDj("2350000");
		orderBodyDto1.setBz("USD");
		orderBodyDto1.setJjyy("");// 订单新增 都传空；
		orderBodyDto1.setJgtj("ZP02");// 不含税ZP02 含税ZP01
		orderBodyDto1.setJgdw("10000");

		/**
		 * ZT01标准项目 ZT02免费项目 ZT03备损项目 ZT04备损免费 ZT04退货项目 ZT05退货免费 ZT06套件项目 1.
		 * 《大货订单》 a) 走货方式CBU对应ZT01； b)
		 * 走货方式为CKD/SKD的PID对应ZT06，散件对应ZT01，收费备损对应ZT03
		 * ，免费备损对应ZT04，收费样机对应ZT01，免费样机对应ZT02； 2. 《多元化订单》收费产品对应ZT01，免费产品对应ZT02 3.
		 * 《样机订单》：收费样机对应ZT01，免费样机对应ZT02； 4. 《备损订单》收费备损对应ZT03，免费备损对应ZT04
		 * 备注：备损传输样式详见表格下的截图
		 */
		list.add(orderBodyDto1);

		String xmlStr = OrderUtil.produceOrderMsgXml(msgHeader, list);
		System.out.println("xmlin==>"+xmlStr);
		try {
			OrderMsgResponse or = this.orderXmlToHwSap(xmlStr);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试制造SAP
	 */
	public void zztest() {
		OrderZZHeaderDto msgHeader = new OrderZZHeaderDto();
		/**
		 * "1. 《订单通知书》中此处选择的是‘多元化产品’时，产品组为20，其它情况默认为10 2. 样机是10 3. 《备损订单》默认为30"
		 */
		msgHeader.setUpdate("I");
		msgHeader.setXszzdm("");
		msgHeader.setYwz("");
		msgHeader.setXsddh("1801009W");
		// 大货订单 ZF01. 《订单通知书》对应ZF01 《样机订单》对应的订单类型为‘ZF04’
		// 《备损订单》对应为‘ZF05’《多元化订单》对应为‘ZF08’
		msgHeader.setDdlx("ZF10");
		msgHeader.setZhfs("Z001");
		msgHeader.setXszz("1200");
		msgHeader.setFxqd("10");// 默认全部10
		msgHeader.setCpz("10");
		msgHeader.setKhbm("0010000164");
		msgHeader.setXwgj("US");
		msgHeader.setXsy("SKY0001");
		msgHeader.setDdh("0010000164");
		msgHeader.setFktj("");
		msgHeader.setGjmytk("FOB");
		msgHeader.setGjmytkbz("SHENZHEN");
		msgHeader.setDdbm("M");
		msgHeader.setRz("");
		msgHeader.setJhrq("2016-10-30");
		msgHeader.setMjxh("55E72");
		msgHeader.setDdlb("新订单");
		msgHeader.setPp("Skyworth");
		//msgHeader.setGlddh("");
		//msgHeader.setMgrwd("SKYWORTH5M55A24E2000AEA2018");
		

		List<OrderBodyDto> list = new ArrayList<OrderBodyDto>();
		/**
		 * 1. 《订单通知书》 a) CBU对应ZT01； b)
		 * CKD/SKD的PID对应ZT06，散件对应ZT01，收费备损对应ZT03，免费备损对应ZT04
		 * ，收费样机对应ZT01，免费样机对应ZT02； 2. 《多元化订单》收费产品对应ZT01，免费产品对应ZT02 3.
		 * 《样机订单》：收费样机对应ZT01，免费样机对应ZT02； 4. 《备损订单》收费备损对应ZT03，免费备损对应ZT04
		 */

		OrderBodyDto orderBodyDto1 = new OrderBodyDto();
		orderBodyDto1.setUpdate("I");
		orderBodyDto1.setRowid("0");// 行号
		orderBodyDto1.setWlbm("S55T20006M40T00D7T");
		orderBodyDto1.setSl("200");
		orderBodyDto1.setXmlb("");
		orderBodyDto1.setGc("1107");
		orderBodyDto1.setDj("0");
		orderBodyDto1.setBz("");
		orderBodyDto1.setJjyy("");// 订单新增 都传空；
		orderBodyDto1.setJgtj("");// 不含税ZP02 含税ZP01
		orderBodyDto1.setXsdw("ST");
		orderBodyDto1.setXmlb("ZT01");

		/**
		 * ZT01标准项目 ZT02免费项目 ZT03备损项目 ZT04备损免费 ZT04退货项目 ZT05退货免费 ZT06套件项目 1.
		 * 《大货订单》 a) 走货方式CBU对应ZT01； b)
		 * 走货方式为CKD/SKD的PID对应ZT06，散件对应ZT01，收费备损对应ZT03
		 * ，免费备损对应ZT04，收费样机对应ZT01，免费样机对应ZT02； 2. 《多元化订单》收费产品对应ZT01，免费产品对应ZT02 3.
		 * 《样机订单》：收费样机对应ZT01，免费样机对应ZT02； 4. 《备损订单》收费备损对应ZT03，免费备损对应ZT04
		 * 备注：备损传输样式详见表格下的截图
		 */

		// list.add(orderBodyDto);
		list.add(orderBodyDto1);

		String xmlStr = OrderUtil.produceOrderMsgXml(msgHeader, list);
		System.out.println("xmlin==>"+xmlStr);
		/*try {
			OrderMsgResponse or = this.orderXmlToZzSap(xmlStr);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
	}
	
	
	public static void main(String[] args) {
		new OrderInterfaceService().zztest();
	}

}
