<%@page import="com.ey.piit.sdo.pi.vo.PiVo"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<%
PiVo pi = (PiVo)request.getAttribute("pi");

String permission = "" ;
if( "1".equals(pi.getPilx())){
	 //大货
     permission = "pi:pi:price" ;
}else if("2".equals(pi.getPilx())){
	//备损
	  permission = "pi:piSPO:price" ;	
}else if("3".equals(pi.getPilx())){
	//样机
	    permission = "pi:piSample:price" ;	
}else if("4".equals(pi.getPilx())){
	 //多元化
	  permission = "pi:piDiversity:price" ;	
}else if("5".equals(pi.getPilx())){
	//多元化屏
	      permission = "pi:piDiversity:price" ;	
}else if("6".equals(pi.getPilx())){
	//多元化屏
    permission = "pi:piDiversity:price" ;	
}else if("7".equals(pi.getPilx())||"8".equals(pi.getPilx())||"9".equals(pi.getPilx())||"10".equals(pi.getPilx())){
	//副营业务
    permission = "pi:piFy:price" ;	
}
request.setAttribute("permission", permission);

%>

<!DOCTYPE html>
<html>
<head>
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
		.print_table tr:LAST-CHILD td{
			border: none;
		}
		.pre{
			background-color:#ffffff;
			border:1px solid #ffffff;
			margin :0px 0 0 0px;
			padding:0px !important; 
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
		<c:choose>
			<c:when test="${pi.gsbm == 'MCO'}">
				<div style="font-size: 13px;">${pi.gsywmc}</div>
				<div style="font-size: x-large; margin-left: 0px;"><b>${pi.gsmc}</b></div>
			</c:when>
			<c:otherwise>
				<div>
					<div style="float: left;">
						<img style="width:200px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_logo.jpg">
					</div>
					<div style="float: left; margin-left: 100px;">
						<div style="font-size: x-large;"><b>${pi.gsmc}</b></div>
						<div style="font-size: 13px;">${pi.gsywmc}</div>
					</div>
					<div style="clear: both;"></div>
				</div>
			</c:otherwise>
		</c:choose>
		<hr>
		<div style="margin-top: -5px;">${pi.gsywdz}</div>
		<div style="font-size: large; font-weight: bold; text-decoration: underline; padding: 5px;">Pro-forma Invoice</div>
		<div style="text-align: right;"><b>Invoice No：</b>${pi.piid}</div>
		<div style="text-align: right;"><b>Date：</b><fmt:formatDate value="${pi.zdsj}" pattern="yyyy-MM-dd"/></div>
	</div>
	<br>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 10%;"><b>To:</b></td>
			<td style="width: 35%;">${pi.khmc}</td>
			<td style="width: 10%;"><b>Address:</b></td>
			<td colspan="3" style="width: 45%;">${pi.khdz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>ATTN:</b></td>
			<td style="width: 35%;">${pi.khlxr}</td>
			<td style="width: 10%;"><b>TEL:</b></td>
			<td style="width: 15%;">${pi.khdh}</td>
			<td style="width: 10%;"><b>EMAIL:</b></td>
			<td style="width: 20%;">${pi.khyx}</td>
		</tr>
		<tr>
			<td><b>Format:</b></td>
			<td>${pi.zhfsmc}</td>
			<td><b>Purpose:</b></td>
			<td>${pi.pimdmc}</td>
		</tr>
		<tr>
			<td><b>Brand:</b></td>
			<td>${pi.khpp}</td>
			<td style="width: 20%;"><b>Target Delivery Date:</b></td>
			<td colspan="3">${pi.yqdhrq1}&nbsp;${pi.yqdhrq2}&nbsp;${pi.yqdhrq5}&nbsp;${pi.yqdhrq4}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>Pay Terms:</b></td>
			<td style="width: 35%;">${pi.fktjmc}</td>
			<td><b>Price Terms:</b></td>
			<td>${pi.gjmytkmc}&nbsp;${pi.gjmytkbz}</td>
			<td><b>Currency:</b></td>
			<td>${pi.bz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>Shipment:</b></td>
			<td colspan="5">${pi.cylxmc}&nbsp;${pi.cylxbz}</td>
		</tr>
	</table>
	<br>
	<c:if test="${pi.pilx == '1'}">
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr align="center">
			<th style="width: 80px">Model No.</th>
			<th style="width: 80px">Chassis</th>
			<th style="width: 290px">Description</th>
			<th style="width: 60px">Quantity</th>
			<shiro:hasPermission name="${permission}"> 
			<th style="width: 120px">Unit Price</th>
			<th style="width: 120px">Total Amount</th>
			</shiro:hasPermission>
		</tr>
			<c:forEach items="${pi.piItemList}" var="item">
			<tr align="center">
				<td>${item.jixing}</td>
				<td>${item.jixin}</td>
				<td align="left">${item.khxhms}</td>
				<td><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
				<shiro:hasPermission name="${permission}"> 
				<c:if test="${pi.sfFgstj == '1'}">
					<td><fmt:formatNumber value="${item.tj}" pattern="#,##0.000000"/></td>
				</c:if>
				<c:if test="${pi.sfFgstj == '0'}">
					<td><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
				</c:if>
				<td><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
				</shiro:hasPermission>
			</tr>
			</c:forEach>
			<c:if test="${not empty pi.zsl}">
				<tr>
					<td colspan="2" align="right"><b>TOTAL:</b></td>
					<td>&nbsp;</td>
					<td align="center"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
					<shiro:hasPermission name="${permission}"> 
					<td>&nbsp;</td>
					<td align="center"><b><fmt:formatNumber value="${pi.zje}" pattern="#,#00.000000"/></b></td>
					</shiro:hasPermission>
				</tr>
			</c:if>
	</table>
	</c:if>
	<c:if test="${pi.pilx == '2'}">
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr align="center">
			<th style="width: 100px">Meterial No.</th>
			<th>Description</th>
			<th style="width: 50px">Unit</th>
			<th style="width: 60px">Quantity</th>
			<shiro:hasPermission name="${permission}"> 
			<th style="width: 90px">Unit Price</th>
			<th style="width: 90px">Total Amount</th>
			</shiro:hasPermission>
			<th style="width: 70px">Refer Order</th>
			<th style="width: 70px">Mechanism</th>
			<th style="width: 60px">ModelNo</th>
		</tr>
			<c:forEach items="${pi.piItemList}" var="item">
			<tr align="center">
				<td>${item.wlbh}</td>
				<td align="left">${item.khxhms}</td>
				<td>${item.dw}</td>
				<td><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
				<shiro:hasPermission name="${permission}"> 
				<td><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
				<td><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
				</shiro:hasPermission>
				<td>${item.ckddh}</td>
				<td>${item.jixin}</td>
				<td>${item.jixing}</td>
			</tr>
			</c:forEach>
			<c:if test="${not empty pi.zsl}">
				<tr>
					<td colspan="2" align="right"><b>TOTAL:</b></td>
					<td>&nbsp;</td>
					<td align="right"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
					<td>&nbsp;</td>
					<shiro:hasPermission name="${permission}"> 
					<td align="right"><b><fmt:formatNumber value="${pi.zje}" pattern="#,#00.000000"/></b></td>
					</shiro:hasPermission>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
	</table>
	</c:if>
	<c:if test="${pi.pilx == '3'}">
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr align="center">
			<th>Model No.</th>
			<th>Chassis</th>
			<th>Description</th>
			<th>Quantity</th>
			<shiro:hasPermission name="${permission}"> 
			<th>Unit Price</th>
			<th>Total Amount</th>
			</shiro:hasPermission>
		</tr>
			<c:forEach items="${pi.piItemList}" var="item">
			<tr align="center">
				<td>${item.jixing}</td>
				<td>${item.jixin}</td>
				<td align="left">${item.khxhms}</td>
				<td><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
				<shiro:hasPermission name="${permission}"> 
				<td><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
				<td><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
				</shiro:hasPermission>
			</tr>
			</c:forEach>
			<c:if test="${not empty pi.zsl}">
				<tr>
					<td colspan="2" align="right"><b>TOTAL:</b></td>
					<td>&nbsp;</td>
					<td align="center"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
					<td>&nbsp;</td>
					<shiro:hasPermission name="${permission}"> 
					<td align="center"><b><fmt:formatNumber value="${pi.zje}" pattern="#,#00.000000"/></b></td>
					</shiro:hasPermission>
				</tr>
			</c:if>
	</table>
	</c:if>
	<c:if test="${pi.pilx == '4' || pi.pilx == '5' || pi.pilx == '6'}">
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th style="width: 100px">Model</th>
			<th>Description</th>
			<th style="width: 60px">Quantity</th>
			<th style="width: 60px">FOC</th>
			<shiro:hasPermission name="${permission}"> 
			<th style="width: 100px">Unit Price</th>
			<th style="width: 100px">Total Amount</th>
			</shiro:hasPermission>
		</tr>
			<c:forEach items="${pi.piItemList}" var="item"  >
			<tr>
				<%-- <td align="center"/>${fn:split(item.khxhms,';')[0]}</td>
				<td align="left"/>${fn:split(item.khxhms,';')[1]}</td> --%>
				<td align="center">${item.khxh}</td>
				<td align="left">${item.khxhms}</td>
				<td align="center"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
				<td align="center"><fmt:formatNumber value="${item.mfsl}" pattern="#,##0"/></td>
				<shiro:hasPermission name="${permission}"> 
				<td><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
				<td align="center"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
				</shiro:hasPermission>
			</tr>
			</c:forEach>
			<c:if test="${not empty pi.zsl}">
				<tr>
					<td align="center"><b>TOTAL:</b></td>
					<td>&nbsp;</td>
				    <td align="center"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<shiro:hasPermission name="${permission}"> 
					<td align="center"><b><fmt:formatNumber value="${pi.zje}" pattern="#,#00.000000"/></b></td>
					</shiro:hasPermission>
				</tr>
			</c:if>
	</table>
	</c:if>
	<c:if test="${pi.pilx == '7' || pi.pilx == '8' || pi.pilx == '9' || pi.pilx == '10'}">
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th style="width: 100px">Model</th>
			<th>Description</th>
			<th style="width: 60px">Quantity</th>
			<th style="width: 60px">FOC</th>
			<shiro:hasPermission name="${permission}"> 
			<th style="width: 100px">Unit Price</th>
			<th style="width: 100px">Total Amount</th>
			</shiro:hasPermission>
		</tr>
			<c:forEach items="${pi.piItemList}" var="item"  >
			<tr>
				<%-- <td align="center"/>${fn:split(item.khxhms,';')[0]}</td>
				<td align="left"/>${fn:split(item.khxhms,';')[1]}</td> --%>
				<td align="center">${item.khxh}</td>
				<td align="left">${item.khxhms}</td>
				<td align="center"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
				<td align="center"><fmt:formatNumber value="${item.mfsl}" pattern="#,##0"/></td>
				<shiro:hasPermission name="${permission}"> 
				<td><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
				<td align="center"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
				</shiro:hasPermission>
			</tr>
			</c:forEach>
			<c:if test="${not empty pi.zsl}">
				<tr>
					<td align="center"><b>TOTAL:</b></td>
					<td>&nbsp;</td>
				    <td align="center"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<shiro:hasPermission name="${permission}"> 
					<td align="center"><b><fmt:formatNumber value="${pi.zje}" pattern="#,#00.000000"/></b></td>
					</shiro:hasPermission>
				</tr>
			</c:if>
	</table>
	</c:if>
	<br>
	<c:if test="${pi.bz == 'USD'}">
		<div style="font-size: 10px;"><b>TOTAL SAY US DOLLARS ${pi.englishNumber}</b></div>
	</c:if>
	<c:if test="${pi.bz == 'RMB'}">
		<div style="font-size: 10px;"><b>TOTAL SAY CNY ${pi.englishNumber}</b></div>
	</c:if>
	<c:if test="${pi.bz == 'HKD'}">
		<div style="font-size: 10px;"><b>TOTAL SAY HK DOLLARS ${pi.englishNumber}</b></div>
	</c:if>
	<c:if test="${pi.bz == 'EUR'}">
		<div style="font-size: 10px;"><b>TOTAL SAY EURO ${pi.englishNumber}</b></div>
	</c:if>
	<br><br>
	<table cellspacing="0" cellpadding="0">
		<c:if test="${pi.lcskyhdm == 'SCBLMOMX'}">
			<tr>
				<td style="width: 25%;"><b>CORRESPONDENT BANK:</b></td>
				<td style="width: 75%;">Standard Chartered Bank New York (Swift : SCBLUS33XXX)</td>
			</tr>
		</c:if>
	    <c:if test="${not empty pi.skyhmc}">
		   	<tr>
				<td><b>Bank Name:</b></td>
				<td>${pi.skyhmc}</td>
			</tr>
	    </c:if>
	    <c:if test="${not empty pi.skyhdz}">
		     <tr>
				<td><b>Bank Address:</b></td>
				<td>${pi.skyhdz}</td>
			</tr>
	    </c:if>
	    <c:if test="${not empty pi.skyhdm}">
		     <tr>
				<td><b>Swift Code:</b></td>
				<td>${pi.skyhdm}</td>
			</tr>
	    </c:if>
	    <c:if test="${not empty pi.skyhzh}">
		     <tr>
				<td><b>Account No.：</b></td>
				<td>${pi.skyhzh}</td>
			</tr>
	    </c:if>
		<c:if test="${not empty pi.lcskyhmc}">
			   <tr>
				<td><b>L/C Advising Bank Name ：</b></td>
				<td>${pi.lcskyhmc}</td>
			  </tr>
		 </c:if>
		 <c:if test="${not empty pi.lcskyhdz}">
			  <tr>
				<td><b>L/C Advising Bank Address：</b></td>
				<td>${pi.lcskyhdz}</td>
			 </tr>
		 </c:if>
		 <c:if test="${not empty pi.lcskyhdm}">
			  <tr>
				<td><b>L/C Advising Swift Code：</b></td>
				<td>${pi.lcskyhdm}</td>
			 </tr>
		 </c:if>
		  <c:if test="${not empty pi.lcskyhdm}">
			  <tr>
				<td><b>L/C Advising Account No.：</b></td>
				<td>${pi.lcskyhzh}</td>
			 </tr>
		 </c:if>
		
		<tr>
			<td><b>Beneficiary:</b></td>
			<td>${pi.syr}</td>
		</tr>
		<tr>
			<td><b>Beneficiary Address:</b></td>
			<td>${pi.syrdz}</td>
		</tr>
		<tr>
			<td><b>Remark:</b></td>
			<td><PRE class="pre">${pi.bzxx}</PRE></td>
		</tr>
	</table>
	<br><br>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 40%"><b>Supplier:</b></td>
			<td style="width: 10%"></td>
			<td style="width: 40%"><b>Buyer:</b></td>
			<td style="width: 10%"></td>
		</tr>
		<tr>
			<td style="height: 50px; vertical-align: bottom; border-bottom: 2px solid gray; padding-bottom: 5px;">
				<!-- 0101区域业务部   010106北美业务组  010107拉美业务组  暂无巴西业务组-->
				<c:if test="${pi.zt == '5'}">
					<c:choose>
						<c:when test="${pi.gsbm == 'MCO'}">
							<img style="border-width: 0px; width: 102px; height: 70px;" src="${pageContext.request.contextPath}/static/css/images/MCO-CZ-sign.png">
							<div align="left">Shira Shing</div>
						</c:when>
						<c:when test="${pi.gsbm == 'SOS'}">
							<img style="border-width: 0px;" src="${pageContext.request.contextPath}/static/css/images/SOS-LXA-sign.png">
						</c:when>
						<c:otherwise>
							<c:if test="${pi.pilx == '1' || pi.pilx == '2' || pi.pilx == '3'}">
								<%-- <c:if test="${pi.xszz == '0101'}">
									<c:choose>
										<c:when test="${pi.ywz == '010106' || pi.ywz == '010107'}">Pippen Chen</c:when>
										<c:otherwise>Jeffrey Liu</c:otherwise>
									</c:choose>
								</c:if>
								<!-- 0102品牌业务部 -->
								<c:if test="${pi.xszz == '0102'}">万智(Zhi Wang)</c:if>
								<!-- 010301东芝业务组 -->
								<c:if test="${pi.ywz == '010301'}">李强</c:if>
								<!-- 0104海外战略业务部 -->
								<c:if test="${pi.xszz == '0104'}">崔恺 (Ken Cui)</c:if> --%>
								<c:if test="${pi.xszz == '0101'}">万智(Zhi Wang)</c:if>
								<c:if test="${pi.xszz == '0102'}">Pippen Chen</c:if>
								<c:if test="${pi.xszz == '0103' || pi.xszz == '0104'}">Jeffrey Liu</c:if>
								<c:if test="${pi.xszz == '0105'}">张朋</c:if>
								<c:if test="${pi.xszz == '0106'}">崔恺 (Ken Cui)</c:if>
								<c:if test="${pi.xszz == '0107'}">李强</c:if>
							</c:if>
							<c:if test="${pi.pilx == '4' || pi.pilx == '6'}">
								Rino
							</c:if>
							<c:if test="${pi.pilx == '5'}">
								Andy Liu
							</c:if>
							<c:if test="${pi.pilx == '7' || pi.pilx == '8' || pi.pilx == '9' || pi.pilx == '10'}">
								Rino
							</c:if>
						</c:otherwise>
					</c:choose>
					<!-- SMO审核人 -->
					<c:if test="${pi.gsbm == 'SMO' || pi.gsbm == 'MCO' || pi.gsbm == 'SOS'}">
						<font style="clear:both;float:right">${pi.smoshr}</font>
					</c:if>
			   </c:if>
			</td>
			<td></td>
			<td style="vertical-align: bottom; border-bottom: 2px solid gray; padding-bottom: 5px;"></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2">${pi.gsywmc}</td>
			<td colspan="2">${pi.khmc}</td>
		</tr>
	</table>
	<c:if test="${pi.zt == '5'}">
		<div style="margin-top: -80px; margin-left: 100px; position: absolute;">
		<c:if test="${ empty pi.khfl}">
			<c:if test="${pi.gsbm == 'RGB'}" var="name2">
			<img style="border-width: 0px;" src="${pageContext.request.contextPath}/static/css/images/RGB_Small.png">
			</c:if>  
		 	<c:if test="${pi.gsbm == 'SMO'}" var="name1">
			<img style="border-width: 0px;" src="${pageContext.request.contextPath}/static/css/images/SMO_Small.png">
			</c:if>
			<c:if test="${pi.gsbm == 'SOS'}" var="name3">
			<img style="border-width: 0px; width: 121px; height: 100px;" src="${pageContext.request.contextPath}/static/css/images/SOS_Small.png">
			</c:if>
			<c:if test="${pi.gsbm == 'MCO'}" var="name4">
			<img style="border-width: 0px; width: 121px; height: 100px;" src="${pageContext.request.contextPath}/static/css/images/MCO_Small.png">
			</c:if>
		 	<c:if test="${pi.gsbm == '10010'}" var="name1">
			<img style="border-width: 0px;" src="${pageContext.request.contextPath}/static/css/images/SOD_Small.png">
			</c:if>
		</c:if>
		<c:if test="${pi.khfl == '1' && pi.sfSmosh == '1'}" var="name1">
			<img style="border-width: 0px;" src="${pageContext.request.contextPath}/static/css/images/SOD_Small.png">
		</c:if>
		</div>
	</c:if>
</div>
</body>
</html>