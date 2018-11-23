<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

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
		}
		.print_table tr:LAST-CHILD td{
			border: none;
		}
	</style>
	
</head>
<body>
<div class="print_page">
	<div style="text-align: center;">
		<div style="font-size: x-large; margin-left: 0px;"><b>SHIPPING INSTRUCTION</b></div>
		<div align="right">
			<button id="btn-print" type="button" class="btn btn-light btn-sm" onclick="javascript:print();">
				<i class="icon-print icon-on-right bigger-110"></i>
				打印
			</button>
		</div>
		<hr>
		<div style="text-align: right;"><b>No.：</b>${shippingInstruction.bldh}</div>
		<div style="text-align: right;"><b>Date：</b>
			<fmt:formatDate value="${shippingInstruction.zdsj}" pattern="yyyy-MM-dd"/></div>
	</div>
	<br>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 15%;"><b>To:</b></td>
			<td style="width: 35%;">${shippingInstruction.cdgs}</td>
			<td style="width: 15%;"><b>ATTN:</b></td>
			<td style="width: 35%;">${shippingInstruction.cdgslxr}</td>
		</tr>
		<tr>
			<td colspan="4"><b>FM</b></td>
		</tr>
		<tr>
			<td><b>SHIPPING DEPT:</b></td>
			<td>${shippingInstruction.cwzy}</td>
			<td><b>TEL:</b></td>
			<td>${shippingInstruction.dh}</td>
		</tr>
		<tr>
			<td><b>FAX:</b></td>
			<td>${shippingInstruction.cz}</td>
			<td><b>E-mail:</b></td>
			<td>${shippingInstruction.yx}</td>
		</tr>
	</table>
	<hr>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 15%; vertical-align: top;"><b>SHIPPER:</b></td>
			<td><pre style="margin: 0; padding: 0;">${shippingInstruction.gsxx}</pre></td>
		</tr>
		<tr>
			<td style="width: 15%; vertical-align: top;"><b>CONSIGNEE:</b></td>
			<td><pre style="margin: 0; padding: 0;">${shippingInstruction.shrxx}</pre></td>
		</tr>
		<tr>
			<td style="width: 15%; vertical-align: top;"><b>NOTIFY:</b></td>
			<td><pre style="margin: 0; padding: 0;">${shippingInstruction.tzrxx}</pre></td>
		</tr>
	</table>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 20%;"><b>PORT OF LOADING:</b></td>
			<td style="width: 30%;">${shippingInstruction.qyg}</td>
			<td style="width: 20%;"><b>PORT OF DISCHARGE:</b></td>
			<td style="width: 30%;">${shippingInstruction.xhg}</td>
		</tr>
		<tr>
			<td><b>PLACE OF DELIVERY:</b></td>
			<td>${shippingInstruction.mdg}</td>
			<td><b>VESSEL NAME:</b></td>
			<td>${shippingInstruction.cmhchbh}</td>
		</tr>
		<tr>
			<td><b>FREIGHT COLLECT:</b></td>
			<td colspan="3">${shippingInstruction.mytk}</td>
		</tr>
		<tr>
			<td><b>MARKS & NOS:</b></td>
			<td colspan="3">${shippingInstruction.mtxx}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th>CTNR NO.</th>
			<th>SEAL NO.</th>
			<th>TTL MEAS</th>
			<th>TTL CTNS</th>
			<th>TTL PKGS</th>
			<th>TTL GW</th>
			<th>TARE</th>
			<th>VGM</th>
			<th>CTNR TYPE</th>
			<th>S/O NO.</th>
		</tr>
			<c:forEach items="${shippingInstruction.shippingInstructionItemList}" var="item">
			<tr>
				<td>${item.gh}</td>
				<td>${item.fth}</td>
				<td align="right"><fmt:formatNumber value="${item.kbtj}" pattern="#,##0.00"/></td>
				<td align="right"><fmt:formatNumber value="${item.xs}" pattern="#,##0"/></td>
				<td align="right"><fmt:formatNumber value="${item.zsl}" pattern="#,##0"/></td>
				<td align="right"><fmt:formatNumber value="${item.gmz}" pattern="#,##0.00"/></td>
				<td align="right"><fmt:formatNumber value="${item.pz}" pattern="#,##0.00"/></td>
				<td align="right"><fmt:formatNumber value="${item.zmz}" pattern="#,##0.00"/></td>
				<td>${item.gx}</td>
				<td>${item.dch}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2" align="left"><b>TOTAL</b></td>
				<td align="right"><fmt:formatNumber value="${shippingInstruction.sumKbtj}" pattern="#,##0.00"/></td>
				<td align="right"><fmt:formatNumber value="${shippingInstruction.sumXs}" pattern="#,##0"/></td>
				<td align="right"><fmt:formatNumber value="${shippingInstruction.sumZsl}" pattern="#,##0"/></td>
				<td align="right"><fmt:formatNumber value="${shippingInstruction.sumGmz}" pattern="#,##0.00"/></td>
				<td align="right"><fmt:formatNumber value="${shippingInstruction.sumPz}" pattern="#,##0.00"/></td>
				<td align="right"><fmt:formatNumber value="${shippingInstruction.sumZmz}" pattern="#,##0.00"/></td>
				<td></td>
				<td></td>
			</tr>
	</table>
</div>
</body>
<script type="text/javascript">
	function print(){
		window.open("<c:url value='/invoice/shippingInstruction/reportDown'/>?bldh=${shippingInstruction.bldh}");
	}
</script>
</html>