<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<!-- 阿根廷发票打印页 -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.print_page {
	width: 1080px;
	margin: 0 auto;
	font-family: Bookman Old Style;
}

.print_head {
	font-size: 10px;
}

.print_info {
	font-size: 8px;
}

table {
	width: 100%;
}

table td {
	padding: 5px;
}

.print_table tr:FIRST-CHILD td, .print_table tr:FIRST-CHILD th {
	border-top: 1px solid #000;
}

.print_table tr td:FIRST-CHILD, .print_table tr th:FIRST-CHILD {
	border-left: 1px solid #000;
}

.print_table td, .print_table th {
	border-bottom: 1px solid #000;
	border-right: 1px solid #000;
	word-wrap: break-word;
	word-break: break-all;
}

.print_table tr:LAST-CHILD td {
	border: none;
}

.pre {
	background-color: #ffffff;
	border: 1px solid #ffffff;
	margin: 0px 0 0 0px;
	padding: 0px !important;
	white-space: pre-line !important;
	white-space: -moz-pre-wrap;
	white-space: -pre-wrap;
	white-space: -o-pre-wrap;
	word-wrap: break-word;
}

.head_table td {
	vertical-align: text-top;
}
</style>
</head>
<body>
	<div class="print_page">
		<div class="print_head">
			<input type="hidden" name="id" value="${si.id}" /> <input
				type="hidden" name="sjc" value="${si.sjc}" />
			<div style="text-align: center; padding-top: 10px;">
				<div style="font-size: x-large; margin-left: 0px;">
					<b>${invoice.gsywmc}</b>
				</div>
				<div style="font-size: x-large; margin-left: 0px;">
					<b>${invoice.gszwmc}</b>
				</div>
				<div style="margin-left: 0px;">
					<b>${invoice.gsdz}</b>
				</div>
			</div>
			<br>
			<div
				style="text-align: center; font-size: x-large; margin-left: 0px;">COMMERCIAL
				INVOICE</div>
			<br> <br>
			<table class="head_table" cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 12%;" rowspan="3"><strong>Sold to</strong></td>
					<td style="width: 43%">${invoice.khmc}</td>
					<td style="width: 15%"><strong>Invoice No.:</strong></td>
					<td style="width: 30%">${invoice.fph }</td>
				</tr>
				<tr>
					<td>${invoice.khdz}</td>
					<td><strong>Invoice Date: </strong></td>
					<td><fmt:formatDate value="${invoice.fprq}" type="date"
							pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td>${invoice.khdh}</td>
					<td rowspan="5"><strong>JOB NO.:</strong></td>
					<td rowspan="5"><pre class="pre">${invoice.orderno }</pre></td>
				</tr>
				<tr>
					<td rowspan="3"><strong>Consignee</strong></td>
					<td>${invoice.shfmc}</td>
				</tr>
				<tr>
					<td>${invoice.shfdz }</td>
				</tr>
				<tr>
					<td>${invoice.shfdh }</td>
				</tr>
				<tr>
					<td rowspan="3"><strong>Delivery to:</strong></td>
					<td>${invoice.shdmc}</td>
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
					<td><fmt:formatDate value="${invoice.qyrq}" type="date"
							pattern="yyyy-MM-dd" /></td>
					<td><strong>PORT OF DISCHARGE:</strong></td>
					<td>${invoice.mdg}</td>
				</tr>
				<tr>
					<td><strong>ETA ON/ABT</strong></td>
					<td><fmt:formatDate value="${invoice.yjdgq}" type="date"
							pattern="yyyy-MM-dd" /></td>
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
						<th>Job No.</th>
						<th>Description</th>
						<th>Model No.</th>
						<th>Unit</th>
						<th>Qty</th>
						<th>Unit Price</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${invoice.custInvItems}" var="item">
						<tr>
							<td>${item.ddid}</td>
							<td>${item.spmc}</td>
							<td>${item.khxh}</td>
							<td>${item.dw}</td>
							<td align="right"><c:choose>
									<c:when test="${item.sl>0}">
										<fmt:formatNumber value="${item.sl}" pattern="#,##0" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
							<td align="right"><c:choose>
									<c:when test="${item.dj>0}">
										<fmt:formatNumber value="${item.dj}" pattern="#,##0.00" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
							<td align="right"><c:choose>
									<c:when test="${item.je>0}">
										<fmt:formatNumber value="${item.je}" pattern="#,##0.00" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="2" align="right"><b>TOTAL:</b></td>
						<td align="center"><b></b></td>
						<td align="center"><b></b></td>
						<td>&nbsp;</td>
						<td align="center"><b>${invoice.zsl}</b></td>
						<td align="center"><b>${invoice.zje}</b></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="print_head">
			<div style="margin: 10px;">
				<strong>SAY TOTAL U.S.DOLLARS ${invoice.englishAmount}</strong>
			</div>
			<div style="margin: 10px;">
				<pre class="pre">${invoice.footer}</pre>
			</div>
		</div>
	</div>
</body>
</html>