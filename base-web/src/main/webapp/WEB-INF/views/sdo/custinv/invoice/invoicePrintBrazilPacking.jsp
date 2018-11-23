<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<!-- 巴西箱单打印页 -->
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		.print_page{
			width: 1080px;
			margin: 0 auto;
			font-family: Bookman Old Style;
		}
		.print_head{
			font-size: 10px;
		}
		.print_info{
			font-size:8px;
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
		.head_table td{
		vertical-align: text-top;
		}
	</style>
</head>
<body>
<div class="print_page">
	<div class="print_head">
	<input type="hidden" name="id" value="${si.id}"/>
	<input type="hidden" name="sjc" value="${si.sjc}"/>
	<div style="text-align: center; padding-top: 10px;">
		<div style="font-size: x-large; margin-left: 0px;"><b>${invoice.gsywmc}</b></div>
		<div style="font-size: x-large; margin-left: 0px;"><b>${invoice.gszwmc}</b></div>
		<div style="margin-left: 0px;"><b>${invoice.gsdz}</b></div>
	</div>
	<br>
	<div style="text-align: center;font-size: x-large; margin-left: 0px;">PACKING  LIST</div>
	<br>
	<br>
	<table class="head_table" cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 12%;" rowspan="3" ><strong>Sold to</strong></td>
			<td style="width: 43%" >${invoice.khmc}</td>
			<td style="width: 15%" ><strong>Invoice No.:</strong></td>
			<td style="width: 30%">${invoice.fph }</td>
		</tr>
		<tr>
			<td>${invoice.khdz}</td>
			<td><strong>Invoice Date: </strong></td>
			<td><fmt:formatDate value="${invoice.fprq}" type="date" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>${invoice.khdh}</td>
			<td rowspan="5" ><strong>JOB NO.:</strong></td>
			<td rowspan="5"><pre class="pre">${invoice.orderno }</pre></td>
		</tr>
		<tr>
			<td rowspan="3" ><strong>Consignee</strong></td>
			<td >${invoice.shfmc}</td>
		</tr>
		<tr>
			<td>${invoice.shfdz }</td>
		</tr>
		<tr>
			<td>${invoice.shfdh }</td>
		</tr>
		<tr>
			<td rowspan="3" ><strong>Delivery to:</strong></td>
			<td >${invoice.shdmc}</td>
		</tr>
		<tr>
			<td>${invoice.shddz}</td>
		</tr>
		<tr>
			<td>${invoice.shddh}</td>
		</tr>
		<tr>
			<td><strong>Shipped per</strong></td>
			<td>${invoice.cmhc}</td>
			<td><strong>PORT OF LOADING:</strong></td>
			<td>${invoice.qyg}</td>
		</tr>
		<tr>
			<td><strong>On board date</strong></td>
			<td><fmt:formatDate value="${invoice.qyrq}" type="date" pattern="yyyy-MM-dd"/></td>
			<td><strong>PORT OF DISCHARGE:</strong></td>
			<td>${invoice.mdg}</td>
		</tr>
		<tr>
			<td><strong>ETA ON/ABT</strong></td>
			<td><fmt:formatDate value="${invoice.yjdgq}" type="date" pattern="yyyy-MM-dd"/></td>
			<td><strong>DELIVER TERM: </strong></td>
			<td>${invoice.mytkmc}</td>
		</tr>
		<tr>
			<td><strong>B/L NO.</strong></td>
			<td>${invoice.tdh}</td>
			<td><strong>PAYMENT TERMS:</strong></td>
			<td>${invoice.fktjmc}</td>
		</tr>
		<tr>
			<td><strong>Marks & Nos.</strong></td>
			<td>${invoice.marks}</td>
			<td><strong>ORIGIN OF GOODS:</strong></td>
			<td>${invoice.ycgj}</td>
		</tr>
		<tr>
			<td><strong>Description</strong></td>
			<td colspan="3"><pre class="pre">${invoice.ms}</pre></td>
		</tr>
	</table>
	</div>
	<br>
	<div class="print_info">
	<table class="print_table" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<th width="60px">PO NO.</th>
				<th width="80px">CONTAINER NUMBER</th>
				<th width="100px">SUPPLIER PART NUMBER</th>
				<th width="150px">ITEM DESCRIPTION</th>
				<th width="80px">BRIC DESCRIPTION</th>
				<th width="30px">UNIT</th>
				<th width="50px">TOTAL QTY</th>
				<th width="50px">QTY OF CARTON</th>
				<th width="25px">CARTON Nº</th>
				<th width="50px">QTY OF PALLET</th>
				<th width="50px">NET WEIGHT/PC</th>
				<th width="50px">TOTAL NET WEIGHT(KG)</th>
				<th width="50px">GROSS WEIGHT / CARTON</th>
				<th width="50px">TOTAL GROSS WEIGHT (KG)</th>
				<th width="60px">TOTAL SIZE (CBM)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${invoice.custInvPackings}" var="item">
				<tr>
					<td>${item.pono}</td>
					<td>
						<c:choose> 
							<c:when test="${item.guino =='SUB TOTAL' || item.guino =='TOTAL'}">
								<strong>${item.guino}</strong>
	 						</c:when>      
							<c:otherwise>${item.guino}</c:otherwise> 
						</c:choose>
					</td>
					<td>${item.wlbh}</td>
					<td>${item.wlms}</td>
					<td>${item.khms}</td>
					<td>${item.dw}</td>
					<td align="right"><c:choose>
									<c:when test="${item.sfqty>0}">
										<fmt:formatNumber value="${item.sfqty}" pattern="#,##0" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
					<td align="right"><c:choose>
									<c:when test="${item.zxnum>0}">
										<fmt:formatNumber value="${item.zxnum}" pattern="#,##0" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
					<td>${item.boxno}</td>
					<td align="right"><c:choose>
									<c:when test="${item.kbnum>0}">
										<fmt:formatNumber value="${item.kbnum}" pattern="#,##0" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
					<td align="right"><c:choose>
									<c:when test="${item.dgjz>0}">
										<fmt:formatNumber value="${item.dgjz}" pattern="#,##0.000" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
					<td align="right"><c:choose>
									<c:when test="${item.zxzjz>0}">
										<fmt:formatNumber value="${item.zxzjz}" pattern="#,##0.000" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
					<td align="right"><c:choose>
									<c:when test="${item.zxmz>0}">
										<fmt:formatNumber value="${item.zxmz}" pattern="#,##0.000" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
					<td align="right"><c:choose>
									<c:when test="${item.kbzwet>0}">
										<fmt:formatNumber value="${item.kbzwet}" pattern="#,##0.000" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
					<td align="right"><c:choose>
									<c:when test="${item.sumzv>0}">
										<fmt:formatNumber value="${item.sumzv}" pattern="#,##0.000" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
</body>
</html>