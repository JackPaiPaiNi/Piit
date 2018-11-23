<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
	<style type="text/css">
		.print_page{
			width: 756px;
			margin: 0 auto;
			font-family: Bookman Old Style;
			font-size: 11px;
		}
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
		.print_table tr:FIRST-CHILD td, .print_table tr:FIRST-CHILD th{
			border-top: 1px solid #000;
		}
		.print_table tr td:FIRST-CHILD, .print_table tr th:FIRST-CHILD{
			border-left: 1px solid #000;
		}
		.print_table td,.print_table th{
			border-bottom: 1px solid #000;
			border-right: 1px solid #000;
			word-wrap : break-word;
			word-break : break-all;
		}
		.print_lable{
			width: 100%;
			float: left;
			color: blue; 
			font-size: 15px; 
			font-weight: bold; 
			background-color: #AAAAAA;
		}
		.pre{
			background-color:#ffffff;
			border:1px solid #ffffff;
			margin :0px 0 0 0px;
			padding:0px;
			white-space: pre-line!important;      
			white-space: -moz-pre-wrap; 
			white-space: -pre-wrap;     
			white-space: -o-pre-wrap;   
			word-wrap: break-word;  
		}
	</style>
	
</head>
<body>
<div class="print_page">
	<div style="text-align: center;">
		<div>
			<c:if test="${orderProduct.gsbm != 'MCO'}">
				<div style="float: left;">
					<img style="width:200px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_logo.jpg">
				</div>
				<div style="float: left;">
					<div style="font-size: x-large; margin-left: 0px;"><b>${orderProduct.gsmc}</b></div>
					<%-- <div style="font-size: 13px;">RGB
						${orderProduct.gsywmc}</div> --%>
				</div>
			</c:if>
			<c:if test="${orderProduct.gsbm == 'MCO'}">
				<div style="float: center;">
					<div style="font-size: x-large; margin-left: 0px;"><b>${orderProduct.gsmc}</b></div>
				</div>
			</c:if>
			<div style="clear: both;"></div>
		</div>
		<hr>
		<div style="font-size: large; font-weight: bold; text-decoration: underline; padding: 5px;">大货订单</div>
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 25%"><b>订单号：</b>${orderProduct.ddid}</td>
				<td style="width: 25%"><b>参考订单号：</b>${orderProduct.ckddh}</td>
				<td style="width: 25%"><b>关联订单号：</b><%-- ${orderProduct.glddh} --%></td>
				<td style="width: 25%"><b>文件编号：</b>${orderProduct.wjbh}</td>
			</tr>
		</table>
	</div>
	<br>
	<label class="print_lable" >订单基本信息</label>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">表头信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>生产基地:</b></td>
			<td style="width: 23%;">${orderProduct.scjdmc}</td>
			<td style="width: 10%;"><b>公司编码:</b></td>
			<td style="width: 23%;">${orderProduct.gsbm}</td>
			<td style="width: 10%;"><b>公司名称:</b></td>
			<td style="width: 23%;">${orderProduct.gsmc}</td>
		</tr>
		<tr>
		    <td style="width: 10%;"><b>订单编码类型:</b></td>
			<td style="width: 23%;">${orderProduct.ddbmlxmc}</td>
			<td style="width: 10%;"><b>订单类型:</b></td>
			<td style="width: 23%;">${orderProduct.ddlxmc}</td>
			<td style="width: 10%;"><b>订单类别:</b></td>
			<td style="width: 23%;">${orderProduct.ddlbmc}</td>
		
		</tr>
		<tr>
			<td style="width: 10%;"><b>业务类型:</b></td>
			<td style="width: 23%;">${orderProduct.ywlxmc}</td>
			<td style="width: 23%;">
				<c:choose>
				   <c:when test="${orderProduct.zt == '1'}">草稿 
				   </c:when>
				   <c:when test="${orderProduct.zt == '2'}">审批中 
				   </c:when>
				   <c:when test="${orderProduct.zt == '3'}">驳回 
				   </c:when>
				   <c:when test="${orderProduct.zt == '4'}">审批通过 
				   </c:when>
				   <c:when test="${orderProduct.zt == '5'}">已生效 
				   </c:when>
				   <c:when test="${orderProduct.zt == '6'}">取消 
				   </c:when>
				</c:choose>
			</td>
			<td style="width: 23%;">${orderProduct.ztmc}</td>
			<td style="width: 10%;"><b>制单人:</b></td>
			<td style="width: 23%;">${orderProduct.zdrmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>制单日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderProduct.zdsj}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>销售员:</b></td>
			<td style="width: 23%;">${orderProduct.xsymc}</td>
			<td style="width: 10%;"><b>业务组:</b></td>
			<td style="width: 23%;">${orderProduct.ywzmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>销售组织:</b></td>
			<td style="width: 23%;">${orderProduct.xszzmc}</td>
			<td style="width: 10%;"><b>是否模组CKD:</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfMzckd == 1}">是</c:if>
				<c:if test="${orderProduct.sfMzckd == 0}">否</c:if>
			</td>
			<td style="width: 10%;"><b>供应商:</b></td>
			<td style="width: 23%;">${orderProduct.gysmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>版本号:</b></td>
			<td style="width: 23%;">${orderProduct.bbh}</td>
			<td style="width: 10%;"></td>
			<td style="width: 10%;"></td>
			<td style="width: 10%;"></td>
			<td style="width: 23%;"></td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="10" style="font-size: 13px; text-align: left;">PI信息</th>
		</tr>
		<tr>
			<th>PI号</th>
			<th>PI类型</th>
			<th>明细类型</th>
			<th>PID</th>
			<th>币种</th>
			<th>我司型号</th>
			<th>客户型号描述</th>
			<th>大货数量</th>
			<th>收费样机数量</th>
		</tr>
		<c:forEach items="${orderProduct.orderReferPiList}" var="item">
			<tr>
				<td>${item.piid}</td>
				<td>${item.pilxmc}</td>
				<td>${item.mxlxmc}</td>
				<td>${item.pid}</td>
				<td>${item.bz}</td>
				<td>${item.jixing}</td>
				<td>${item.khxhms}</td>
				<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
				<td align="right"><fmt:formatNumber value="${item.yjsl}" pattern="#,##0"/></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">基本信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>PID:</b></td>
			<td style="width: 23%;">${orderProduct.pid}</td>
			<td style="width: 10%;"><b>我司型号:</b></td>
			<td style="width: 23%;">${orderProduct.wsxh}</td>
			<td style="width: 10%;"><b>机芯:</b></td>
			<td style="width: 23%;">${orderProduct.jixin}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>买家型号:</b></td>
			<td style="width: 23%;">${orderProduct.mjxh}</td>
			<td style="width: 10%;"><b>外协订单:</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfWxdd == 1}">外协</c:if>
				<c:if test="${orderProduct.sfWxdd == 0}">非外协</c:if>
			</td>
			<td style="width: 10%;"><b>内销研发产品:</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfNxyfcp == 1}">是</c:if>
				<c:if test="${orderProduct.sfNxyfcp == 0}">否</c:if>
			</td>
		</tr>
		<tr>
		     <td style="width: 10%;"><b>规格明细:</b></td>
			 <td style="width: 23%;">${orderProduct.ggmxmc}</td>
			 <td style="width: 10%;"><b>规格明细备注:</b></td>
			 <td style="width: 23%;">${orderProduct.ggmxbz}</td>
			 <td style="width: 10%;"><b>是否新品:</b></td>
			 <td style="width: 23%;">
				<c:if test="${orderProduct.sfXp == 1}">是</c:if>
				<c:if test="${orderProduct.sfXp == 0}">否</c:if>
			 </td>
		</tr>
		<tr>
		    <td style="width: 10%;"><b>付款方式:</b></td>
			<td style="width: 23%;">${orderProduct.fktj}</td>
			<td style="width: 10%;"><b>国际贸易条款:</b></td>
			<td style="width: 23%;">${orderProduct.gjmytkmc}</td>
			<td style="width: 10%;"><b>国际贸易条款备注:</b></td>
			<td style="width: 23%;">${orderProduct.gjmytkbz}</td>
		</tr>
		<tr>
		    <td style="width: 10%;"><b>币种:</b></td>
		    <td style="width: 23%;">${orderProduct.bz}</td>
		    <td style="width: 10%;"><b>大货数量:</b></td>
			<td style="width: 23%;">${orderProduct.sl}</td>
			<td style="width: 10%;"><b>收费样机数量:</b></td>
			<td style="width: 23%;">${orderProduct.yjsl}</td>
		
		</tr>
		<tr>
			<td style="width: 10%;"><b>走货方式:</b></td>
			<td style="width: 23%;">${orderProduct.zhfsmc}</td>
		    <td style="width: 10%;"><b>加工方式:</b></td>
		    <td style="width: 23%;">${orderProduct.jgfsmc}</td>
		    <td style="width: 10%;">&nbsp;</td>
			<td style="width: 23%;">&nbsp;</td>
		</tr>
		<tr>
			<td><b>走货不含物件:</b></td>
			<td colspan="5">
				<c:if test="${orderProduct.zhbhwjP == 1}">屏</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.zhbhwjJk == 1}">机壳</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.zhbhwjYkq == 1}">遥控器</c:if>&nbsp;&nbsp;
		    	<c:if test="${orderProduct.zhbhwjLb == 1}">喇叭</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.zhbhwjZx == 1}">纸箱</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.zhbhwjPm == 1}">高频头</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.zhbhwjJxZb == 1}">机芯+主板</c:if>
	      	</td>
		</tr>
		<tr>
			<td><b>需单独走货物：</b></td>
			<td colspan="5">
				<c:if test="${orderProduct.xddzhP == 1}">屏</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.xddzhJk == 1}">机壳</c:if>&nbsp;&nbsp;
		    	<c:if test="${orderProduct.xddzhLb == 1}">喇叭</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.xddzhZx == 1}">纸箱</c:if>&nbsp;&nbsp;
		    	<c:if test="${orderProduct.xddzhJxZb == 1}">机芯+主板</c:if>
			</td>
		</tr>
		<tr>
			<td><b>备案料号:</b></td>
			<td colspan="5">${orderProduct.zhm}-${orderProduct.version}-${orderProduct.bs} ; 
			${orderProduct.zhmt}-${orderProduct.versiont}-${orderProduct.bst}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>出运类型:</b></td>
			<td style="width: 23%;">${orderProduct.cylxmc}</td>
			<td style="width: 10%;"><b>出运类型备注:</b></td>
			<td style="width: 23%;">${orderProduct.cylxbz}</td>
			<td style="width: 10%;"><b>交货日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderProduct.jhrq}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
		    <td style="width: 10%;"><b>分公司收货日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderProduct.fgsshrq}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>预测周数:</b></td>
			<td style="width: 23%;">${orderProduct.yczs}</td>
			<td style="width: 10%;"><b>预测数量:</b></td>
			<td style="width: 23%;">${orderProduct.ycsl}</td>
	  </tr>	
	   <tr>
			<td style="width: 10%;"><b>是否验货：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfYh == 1}">是</c:if>
				<c:if test="${orderProduct.sfYh == 0}">否</c:if>
			</td>
			<td style="width: 10%;"><b>验货日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderProduct.yhrq}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>渠道:</b></td>
			<td style="width: 23%;">${orderProduct.qdmc}</td>
		</tr>
		<tr>
		    <td style="width: 10%;"><b>电视机类型：</b></td>
			<td colspan="6">${orderProduct.dsjlxmc}</td>
		</tr>
		<tr>
		    <td style="width: 10%;"><b>是否验货备注：</b></td>
			<td colspan="6">${orderProduct.sfyhbz}</td>
		</tr>
		<tr>
		<td><b>基本信息备注：</b></td>
			<td colspan="6"><PRE class="pre">${orderProduct.jbxxbz}</PRE></td>
			
		</tr>
		<tr>
			<td><b>变更信息备注：</b></td>
				<td colspan="6"><PRE class="pre">${orderProduct.bgbz}</PRE></td>
		</tr>
		<tr>
			<td><b>辅助变更备注：</b></td>
				<td colspan="6"><PRE class="pre">${orderProduct.fzbgbz}</PRE></td>
		</tr>
		<tr>
		    <td style="width: 10%;"><b>付款保障 状态：</b></td>
			<td colspan="6">
			   <c:choose>
				   <c:when test="${orderProduct.fkbzzt == '1'}">通过</c:when>
				   <c:when test="${orderProduct.fkbzzt == '0'}">未通过</c:when>
		       </c:choose>
			</td>
		</tr>
	</table>
	<br>
	<label class="print_lable" >客户基本信息</label>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">客户信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>客户编码:</b></td>
			<td style="width: 23%;">${orderProduct.khbm}</td>
			<td style="width: 10%;"><b>客户名称:</b></td>
			<td style="width: 23%;">${orderProduct.khmc}</td>
			<td style="width: 10%;"><b>销往国家:</b></td>
			<td style="width: 23%;">${orderProduct.xwgjmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>时区:</b></td>
			<td style="width: 23%;">${orderProduct.sq}</td>
			<td style="width: 10%;"><b>品牌:</b></td>
			<td style="width: 23%;">${orderProduct.pp}</td>
			<td style="width: 10%;"><b>出厂语言:</b></td>
			<td style="width: 23%;">${orderProduct.ccyymc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>开机Logo:</b></td>
			<td style="width: 23%;">${orderProduct.kjlogo}</td>
			<td style="width: 10%;"><b>开机模式:</b></td>
			<td style="width: 23%;">${orderProduct.kjmsmc}</td>
			<td style="width: 10%;"><b>电子POP:</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.dzpop == 1}">需要</c:if>
				<c:if test="${orderProduct.dzpop == 0}">不需要</c:if>
			</td>
		</tr>
		<tr>	
			<td style="width: 10%;"><b>附件:</b></td>
			<td colspan="5">${orderProduct.kjlogofj}</td>
		</tr>
	</table>
	<br>
	<label class="print_lable" >产品基本信息</label>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">屏体信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>屏品牌:</b></td>
			<td style="width: 23%;">${orderProduct.ppp}</td>
			<td style="width: 10%;"><b>屏型号:</b></td>
			<td style="width: 23%;">${orderProduct.pxh}</td>
			<td style="width: 10%;"><b>屏编码:</b></td>
			<td style="width: 23%;">${orderProduct.pxxbc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>分辨率:</b></td>
			<td style="width: 23%;">${orderProduct.fblmc}</td>
			<td style="width: 10%;"><b>分辨率备注:</b></td>
			<td style="width: 23%;">${orderProduct.fblbz}</td>
			<td style="width: 10%;"><b>屏亮点选项:</b></td>
			<td style="width: 23%;">${orderProduct.pldmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>屏是否需要保护膜：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfBhm == 1}">需要</c:if>
				<c:if test="${orderProduct.sfBhm == 0}">不需要</c:if>
			</td>
		    <td style="width: 10%;"><b>屏包装要求:</b></td>
			<td style="width: 23%;" colspan="3">${orderProduct.pbzyqmc}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">认证信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>认证：安全</b></td>
			<td style="width: 90%;" colspan="5">
				<c:if test="${orderProduct.rz1Cb == 1}">CB&nbsp;&nbsp;</c:if>  
		      	<c:if test="${orderProduct.rz1Etl == 1}">ETL&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Cetl == 1}">cETL&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Paq == 1}">PSE-安全&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Raq == 1}">RED-安全&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Smaq == 1}">S-mark 安全</c:if>
			</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>认证：安全备注</b></td>
			<td style="width: 90%;" colspan="5" >${orderProduct.rz1Bz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>认证：电磁兼容</b></td>
			<td style="width: 90%;" colspan="5">
				<c:if test="${orderProduct.rz2Emc == 1}">EMC&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz2Fcc == 1}">FCC&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz2Rtte == 1}">RTTE&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz2Pe == 1}">PSE-EMC&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz2Rr == 1}">RED-RF&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz2Sme == 1}">S-mark -EMC</c:if>
			</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>认证：电磁兼容备注</b></td>
			<td style="width: 90%;" colspan="5" >${orderProduct.rz2Bz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>认证：能效</b></td>
			<td style="width: 90%;" colspan="5">
		      	<c:if test="${orderProduct.rz4Erp == 1}">ERP&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz4Gems == 1}">GEMS&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz4Bee == 1}">BEE&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz4Nrc == 1}">NRcan&nbsp;&nbsp;</c:if>
				<c:if test="${orderProduct.rz4Nfnx == 1}">南非能效&nbsp;&nbsp;</c:if>
				<c:if test="${orderProduct.rz4Eg == 1}">Energy Guide</c:if>
			</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>认证：能效备注</b></td>
			<td style="width: 90%;" colspan="5" >${orderProduct.rz4Bz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>认证：专利</b></td>
			<td style="width: 90%;" colspan="5">
				<c:if test="${orderProduct.rz3Hdmi == 1}">HDMI&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz3Dd == 1}">DD&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz3Dts == 1}">DTS&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz3Cij == 1}">CI+&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz3Bqb == 1}">BQB&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz3Mhl == 1}">MHL</c:if>
			</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>认证：专利备注</b></td>
			<td style="width: 90%;" colspan="5" >${orderProduct.rz3Bz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>老格式认证项：（新下PID不能勾选）</b></td>
			<td style="width: 90%;" colspan="5">
				<c:if test="${orderProduct.rz1Ce == 1}">CE&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Ul == 1}">UL&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Pse == 1}">PSE&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz2Meps == 1}">MEPS&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz2Es == 1}">Energy Star&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz3Usb == 1}">USB&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Rf == 1}">RF&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Rte == 1}">RTE&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Cet == 1}">cETLus&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz1Nom == 1}">NOM&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz3Ddj == 1}">DD+&nbsp;&nbsp;</c:if>
		      	<c:if test="${orderProduct.rz4Es7 == 1}">Energy star 7.0</c:if>
			</td>
		</tr>
		<tr>
			<td style="width: 13%;"><b>认证：其他</b></td>
			<td style="width: 20%;">
		      	<c:if test="${orderProduct.rz5Qt == 1}">其他</c:if>
			</td>
			<td style="width: 10%;"><b>是否需要RoHS：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfRohs == 1}">需要</c:if>
				<c:if test="${orderProduct.sfRohs == 0}">不需要</c:if>
			</td>
			<td style="width: 10%;"><b>是否需要REACH：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfReach == 1}">需要</c:if>
				<c:if test="${orderProduct.sfReach == 0}">不需要</c:if>
			</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">电源信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>插头类型：</b></td>
			<td style="width: 23%;">${orderProduct.ctlxmc}</td>
			<td style="width: 33%;" colspan="2">${orderProduct.ctlxbz}</td>
			<td style="width: 10%;"><b>适配器：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfSpq == 1}">需要</c:if>
				<c:if test="${orderProduct.sfSpq == 0}">不需要</c:if>
			</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">结构特性信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>外壳颜色标准：</b></td>
			<td style="width: 23%;">${orderProduct.wkysbz}</td>
			<td style="width: 10%;"><b>泡沫：</b></td>
			<td style="width: 56%;" colspan="3">${orderProduct.paomomc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>防火料：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.fhlQk == 1}">前壳</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.fhlHk == 1}">后壳</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.fhlDzjlz == 1}">底座及立柱</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.fhlAvzj == 1}">AV支架</c:if>
		      	<c:if test="${orderProduct.fhlBxy == 1}">不需要</c:if>
			</td>
			<td style="width: 66%;" colspan="4">${orderProduct.fhlBz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>模组贴纸：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.mztzDsky == 1}">带SKYWORTH</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.mztzBdsky == 1}">不带SKYWORTH</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.mztzDmichina == 1}">带MADE IN CHINA</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.mztzBdmichina == 1}">不带MADE IN CHINA</c:if>
			</td>
			<td style="width: 10%;"><b>外包装箱贴纸：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.wbzxtzDsky == 1}">带SKYWORTH</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.wbzxtzBdsky == 1}">不带SKYWORTH</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.wbzxtzDmichina == 1}">带MADE IN CHINA</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.wbzxtzBdmichina == 1}">不带MADE IN CHINA</c:if>
			</td>
			<td style="width: 10%;"><b>是否需要带卡板出货：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.kbchjdbyqP == 1}">屏</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.kbchjdbyqSj == 1}">散件</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.kbchjdbyqZj == 1}">整机</c:if>&nbsp;&nbsp;
		      	<c:if test="${orderProduct.kbchjdbyqJzj == 1}">假整机</c:if>
			</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">附件信息</th>
		</tr>
		<tr>		
			<td style="width: 10%;"><b>挂架：</b></td>
			<td style="width: 23%;">${orderProduct.guajiamc}</td>
			<td style="width: 10%;"><b>挂架备注：</b></td>
			<td style="width: 23%;">${orderProduct.guajiabz}</td>
			<td style="width: 10%;"><b>挂架包装：</b></td>
			<td style="width: 23%;" colspan="3">${orderProduct.gjbzmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>挂架包装备注：</b></td>
		    <td style="width: 23%;">${orderProduct.gjbzbz}</td>
		    <td style="width: 10%;"><b>电池：</b></td> 
		    <td style="width: 23%;">
				<c:if test="${orderProduct.sfDc == 1}">需要</c:if>
				<c:if test="${orderProduct.sfDc == 0}">不需要</c:if>
		    </td>
		    <td style="width: 10%;"><b>底座包装：</b></td>
		    <td style="width: 23%;">${orderProduct.dzbzmc}</td>
		</tr>
		<tr>
		    <td style="width: 10%;"><b>底座包装备注：</b></td>
		    <td style="width: 90%;" colspan="5">${orderProduct.dzbzbz}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">SKD/CKD选项</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>有无屏：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfP == 1}">有</c:if>
				<c:if test="${orderProduct.sfP == 0}">无</c:if>
			</td>
			<td style="width: 10%;"><b>IC程序烧录：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfIc == 1}">需要</c:if>
				<c:if test="${orderProduct.sfIc == 0}">不需要</c:if>
			</td>
			<td style="width: 10%;"><b>S/H/CKD辅料供应：</b></td>
			<td style="width: 23%;">
				<c:if test="${orderProduct.sfShckdflgy == 1}">需要</c:if>
				<c:if test="${orderProduct.sfShckdflgy == 0}">不需要</c:if>
			</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>SKD前壳需加工配件：</b></td>
			<td style="width: 23%;"><PRE class="pre">${orderProduct.skdqkxjgpj}</PRE></td>
			<td style="width: 10%;"><b>S/H/CKD加工要求：</b></td>
			<td style="width: 23%;"><PRE class="pre">${orderProduct.shckdjgyq}</PRE></td>
			<td style="width: 33%;" colspan="2">${orderProduct.shckdjgyqbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>S/H/CKD需成型物料明细：</b></td>
			<td style="width: 23%;">${orderProduct.shckdxcxwlmx}</td>
			<td style="width: 66%;" colspan="4">${orderProduct.shckdxcxwlmxfj}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">产品其他备注信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>产品其他要求备注：</b></td>
			<td style="width: 89%;" colspan="5"><PRE class="pre">${orderProduct.cpqtyqbz}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>产品其他要求附件：</b></td>
			<td style="width: 89%;"colspan="5">${orderProduct.cpqtyqfj}</td>
		</tr>
	</table>
	<br>
	<label class="print_lable" >美工基本信息</label>
	<table class="print_table" cellspacing="0" cellpadding="0">
	    <tr>
			<td style="width: 10%;"><b>美工任务单号:</b></td>
			<td style="width: 15%;">${orderProduct.mgrwdh}</td>
			<td style="width: 10%;"><b>序列号类型:</b></td>
			<td style="width: 15%;">${orderProduct.xlh}</td>
			<td style="width: 10%;"><b>序列号码:</b></td>		
			<td style="width: 15%;">${orderProduct.xlhbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>序列号其他:</b></td>		
			<td colspan="5" style="width: 15%;">${orderProduct.xlhqt}</td>
		</tr>
		<tr>
	        <td style="width: 10%;" ><b>美工其他要求备注:</b></td>
			<td style="width: 90%;" colspan="5"><PRE class="pre">${orderProduct.mgqtyqbz}</PRE></td>
	    </tr>
	</table>
	<br>
	<label class="print_lable" >备损物料信息</label>
	<table class="print_table" cellspacing="0" cellpadding="0">
	   <tr>
	        <td style="width: 10%;"><b>是否付费备损:</b></td>
	        <td style="width: 23%;">
				<c:if test="${orderProduct.sfFfbs == 1}">是</c:if>
				<c:if test="${orderProduct.sfFfbs == 0}">否</c:if>
			</td>
			<td style="width: 10%;"><b>付费备损清单:</b></td>
			<c:set var="ffbsqdfj" value="${orderProduct.ffbsqdfj}"/>
			<c:set var="ffbsqdxx" value="${fn:replace(ffbsqdfj,'icon-remove', 'fa fa-file')}"/>
			<td style="width: 23%;">${fn:replace(ffbsqdxx,'red', '')}</td>
			<td style="width: 10%;"><b>免费备损名称：</b></td>
			<td style="width: 23%;">${orderProduct.mfbsmc}</td>
	    </tr>
	    <tr>
	        <td style="width: 10%;"><b>免费备损附件：</b></td>
	        <c:set var="mfbsqdfj" value="${orderProduct.mfbsqdfj}"/>
			<c:set var="mfbsqdxx" value="${fn:replace(mfbsqdfj,'icon-remove', 'fa fa-file')}"/>
			<td style="width: 23%;"><b>免费备损清单：</b>${fn:replace(mfbsqdxx,'red', '')}</td>
	        <td style="width: 10%;"><b>免费备损比例:</b></td>
			<td style="width: 23%;">${orderProduct.mfbsbl}</td>
			<td style="width: 10%;"><b>备损包装:</b></td>
			<td style="width: 23%;">${orderProduct.bsbzmc}</td>
	    </tr>
	     <tr>
	        <td style="width: 10%;"><b>备损包装备注:</b></td>
			<td style="width: 23%;">${orderProduct.bsbzbz}</td>
	        <td style="width: 10%;"><b>跟单备损走柜:</b></td>
			<td style="width: 23%;">${orderProduct.gdbslzgmc}</td>
			<td style="width: 10%;"><b>备损备注:</b></td>
			<td style="width: 23%;"><PRE class="pre">${orderProduct.bsxxbz}</PRE></td>
	    </tr>
	</table>
    <br>
	<label class="print_lable"  onclick="javascript:showOrHideCkdqd();">CKD物料清单（隐藏或显示）</label>
	<table id="print_table_div_ckd" class="print_table" cellspacing="0" cellpadding="0">
	<tr>
		<th>物料编码</th>
		<th>描述</th>
		<th>单机用量</th>
		<th>免费备损数量</th>
		<th>付费备损数量</th>
		<th>MOQ数量</th>
		<th>SAP大货订单数量</th>
	</tr>
	<c:forEach items="${orderProduct.wycCkdList}" var="item">
		<tr>
			<td>${item.wlbm}</td>
			<td>${item.ms}</td>
			<td align="right"><fmt:formatNumber value="${item.djyl}" pattern="#,##0"/></td>
			<td align="right"><fmt:formatNumber value="${item.mfbssl}" pattern="#,##0"/></td>
			<td align="right"><fmt:formatNumber value="${item.ffbssl}" pattern="#,##0"/></td>
			<td align="right"><fmt:formatNumber value="${item.moqsl}" pattern="#,##0"/></td>
			<td align="right"><fmt:formatNumber value="${item.sapdhddsl}" pattern="#,##0"/></td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<label class="print_lable"  onclick="javascript:showOrHideSplog();">审批日志（隐藏或显示）</label>
	<table id="print_table_div" class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th style="width:10%">订单号</th>
			<th style="width:5%">版本号</th>
			<th style="width:10%">操作类型</th>
			<th style="width:10%">操作职位</th>
			<th style="width:20%">操作人账号</th>
			<th style="width:20%">操作人名称</th>
			<th style="width:10%">操作时间</th>
			<th style="width:15%">处理意见</th>
		</tr>
		<c:forEach items="${orderProduct.logList}" var="item">
			<tr>
				<td>${item.ddid}</td>
				<td>${item.bbh}</td>
				<td>${item.czlx}</td>
				<td>${item.czzw}</td>
				<td>${item.czr}</td>
				<td>${item.czrmc}</td>
				<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${item.nr}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
<script type="text/javascript">
    var splog=false;
    var ckdqd=false;
	$(function($){
		$(".skycheckbox").prop("disabled","disabled");
		$(".skyradio").prop("disabled","disabled");
		
		$.bindAjax({
			url:"<c:url value='/payment/payValidate/search'/>",
			data:{id : "${orderProduct.id}" },
			action:"search"
		},function(response){
			if(response[0]){
				$("#fkbzrz").html(response[0].zy);
			}else{
				$("#fkbzrz").html('无');
			}
		});
		
		
	});
	
	function showOrHideSplog(){
		if(splog){
			$("#print_table_div").show();
			splog = false;
		}else{
			$("#print_table_div").hide();
			splog = true;
		}
	}
	function showOrHideCkdqd(){
		if(ckdqd){
			$("#print_table_div_ckd").show();
			ckdqd = false;
		}else{
			$("#print_table_div_ckd").hide();
			ckdqd = true;
		}
	}
</script>
</html>