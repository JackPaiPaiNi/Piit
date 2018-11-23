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
	<input type="hidden" name="id" value="${si.id}"/>
	<input type="hidden" name="sjc" value="${si.sjc}"/>
	<div style="text-align: center; padding-top: 10px;">
		<div style="font-size: x-large; margin-left: 0px; text-decoration: underline;"><b>SHIPPING INSTRUCTION</b></div>
	</div>
	<br>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 5%;"><strong>FM</strong></td>
			<td style="width: 35%"></td>
			<td style="width: 40%"></td>
			<td style="width: 20%"><strong>DATE</strong>：<fmt:formatDate value="${si.zdsj}" type="date" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td></td>
			<td><strong>SKYWORTH-MICHAEL</strong>：${si.chrmc}</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><strong>Tel</strong>：${si.chrdh}</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><strong>E-mail</strong>：${si.chryx}</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><strong>发票号</strong>：${si.fph}</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<br>
	<table cellspacing="0" cellpadding="0">
	 	<tr>
	 		<td width="15%" class="td_top"><strong>SHIPPER</strong>：</td>
	 		<td width="88%"><pre class="pre">${si.fhrxx}</pre></td>
	 	</tr>
	</table>
	<br>
	<table cellspacing="0" cellpadding="0">
	 	<tr>
	 		<td width="15%" class="td_top"><strong>CONSIGNEE</strong>：</td>
	 		<td width="88%"><pre class="pre">${si.shrxx}</pre></td>
	 	</tr>
	</table>
	<br>
	<table cellspacing="0" cellpadding="0">
	 	<tr>
	 		<td width="15%" class="td_top"><strong>NOTIFY</strong>：</td>
	 		<td width="85%"><pre class="pre">${si.tzrxx}</pre></td>
	 	</tr>
	</table>
	<br>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td width="15%" class="td_top"><strong>PORT OF LOADING</strong>：</td>
			<td width="85%"><pre class="pre">${si.qyg}</pre></td>
		</tr>
		<tr>
			<td width="15%" class="td_top"><strong>PORT OF RECEIPT</strong>：</td>
			<td width="85%"><pre class="pre">${si.shd}</pre></td>
		</tr>
		<tr>
			<td width="15%" class="td_top"><strong>PORT OF DISCHARGE</strong>：</td>
		<td width="85%"><pre class="pre">${si.mdg}</pre></td>
		</tr>
		<tr>
			<td width="15%" class="td_top"><strong>PLACE OF DELIVERY</strong>：</td>
			<td width="85%"><pre class="pre">${si.zzmdd}</pre></td>
		</tr>
		<tr>
			<td width="15%" class="td_top"><strong>VESSEL</strong> ：</td>
			<%-- <td>开票方式：${invoice.kpfsmc}</td> --%>
			<td width="85%"><pre class="pre">${si.cmhc}</pre></td>
		</tr>
		<tr>
			<td width="15%" class="td_top"><strong>MARKS & NOS.</strong>：</td>
			<td width="85%"><pre class="pre">${si.marks}</pre></td>
			<%--  <td width="90%"><pre class="pre">${si.qyg}</pre></td> --%>
		</tr>
		<tr>
			<td width="15%" class="td_top"><strong>DESCRIPTION</strong>：</td>
			<td width="85%"><pre class="pre">${si.ms}</pre></td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th>CTNR NO.</th>
			<th>SEAL NO.</th>
			<th>TTL G.W.(KGS)</th>
			<th>TTL MEAS.(CBM)</th>
			<th>VGM(KGS)</th>
			<th>QTY OF PKGS(CTNS)</th>
			<th>QTY OF PKGS(PLTS)</th>
			<th>CTNR TYPE</th>
			<th>S/O NO.</th>
			<th>TARE</th>
		</tr>
		<c:forEach items="${si.siItemList}" var="item">
			<tr>
				<td>${item.guino}</td>
				<td>${item.ftno}</td>
				<td align="right"><c:choose>
									<c:when test="${item.kbzwet>0}">
										<fmt:formatNumber value="${item.kbzwet}" pattern="#,##0.000" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
				<td align="right"><c:choose>
									<c:when test="${item.kbzv>0}">
										<fmt:formatNumber value="${item.kbzv}" pattern="#,##0.000" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
				<td align="right"><c:choose>
									<c:when test="${item.vgm>0}">
										<fmt:formatNumber value="${item.vgm}" pattern="#,##0.000" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
				<td align="right"><c:choose>
									<c:when test="${item.boxsum>0}">
										<fmt:formatNumber value="${item.boxsum}" pattern="#,#0" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
				<td align="right"><c:choose>
									<c:when test="${item.kbsum>0}">
										<fmt:formatNumber value="${item.kbsum}" pattern="#,##0" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>
				<td>${item.gxnam}</td>
				<td>${item.dcno}</td>
				<td>${item.tare}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" align="right"><b>TOTAL:</b></td>
			<td align="center"><b><c:choose>
									<c:when test="${si.sumKbzl>0}">
										<fmt:formatNumber value="${si.sumKbzl}" pattern="#,#00.000"/>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></b></td>
			<td align="center"><b><c:choose>
									<c:when test="${si.sumKbtj>0}">
										<fmt:formatNumber value="${si.sumKbtj}" pattern="#,#00.000"/>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></b></td>
			<td align="center"><b><c:choose>
									<c:when test="${si.sumVgm>0}">
										<fmt:formatNumber value="${si.sumVgm}" pattern="#,#00.000"/>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></b></td>
			<td align="center"><b><c:choose>
									<c:when test="${si.sumZxsl>0}">
										<fmt:formatNumber value="${si.sumZxsl}" pattern="#,#0"/>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></b></td>
			<td align="center"><b><c:choose>
									<c:when test="${si.sumKbsl>0}">
										<fmt:formatNumber value="${si.sumKbsl}" pattern="#,#0"/>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></b></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</div>
</body>
</html>