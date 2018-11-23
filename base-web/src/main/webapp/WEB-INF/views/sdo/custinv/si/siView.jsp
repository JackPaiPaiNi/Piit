<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<style type="text/css">
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
		th{
			white-space: nowrap;
		}
		.td_top{
			vertical-align:top;
		}
	</style>
</head>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row" style="margin: 0px 8px;">
				<input type="hidden" name="id" value="${si.id}"/><!-- 订单id -->
				<input type="hidden" name="sjc" value="${si.sjc}"/>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">SI号：${si.sino}</td>
						<td style="width: 25%">状态：
							<c:choose>
							   <c:when test="${si.zt == '1'}">草稿 
							   </c:when>
							   <c:when test="${si.zt == '5'}">已生效
							   </c:when>
							   <c:when test="${si.zt == '6'}">已取消
							   </c:when>
							 </c:choose>
						</td>
						<td style="width: 25%"></td>
						<td style="width: 25%">
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
								返回
							</button>
							&nbsp;
							<button id="btn-Print" type="button" class="btn btn-light btn-sm">
								<i class="icon-print icon-on-right bigger-110"></i>
								打印
							</button>
						</td>
					</tr>
					<tr>
						<td style="width: 25%">SKYWORTH-MICHAEL：${si.chrmc}</td>
						<td style="width: 25%">Tel：${si.chrdh}</td>
						<td style="width: 25%">E-mail：${si.chryx}</td>
						<td style="width: 25%">&nbsp;</td>
					</tr>
					<tr>
						<td style="width: 25%">发票号：${si.fph}</td>
						<td style="width: 25%">出货通知书：${si.chdh}</td>
						<td style="width: 25%">制单人：${si.zdrmc}</td>
						<td style="width: 25%">&nbsp;</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;"></h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
				 	<tr>
				 		<td width="10%" class="td_top">SHIPPER：</td>
				 		<td width="90%"><pre>${si.fhrxx}</pre></td>
				 	</tr>
				</table>
			</div>
			<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				 	<tr>
				 		<td width="10%" class="td_top">CONSIGNEE：</td>
				 		<td width="90%"><pre>${si.shrxx}</pre></td>
				 	</tr>
				</table>
			</div>
			<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				 	<tr>
				 		<td width="10%" class="td_top">NOTIFY：</td>
				 		<td width="90%"><pre>${si.tzrxx}</pre></td>
				 	</tr>
				</table>
			</div>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td width="15%" class="td_top">PORT OF LOADING：</td>
						<td width="85%"><pre>${si.qyg}</pre></td>
					</tr>
					<tr>
						<td width="15%" class="td_top">PORT OF RECEIPT：</td>
						<td width="85%"><pre>${si.shd}</pre></td>
					</tr>
					<tr>
						<td width="15%" class="td_top">PORT OF DISCHARGE：</td>
					<td width="85%"><pre>${si.mdg}</pre></td>
					</tr>
					<tr>
						<td width="15%" class="td_top">PLACE OF DELIVERY：</td>
						<td width="85%"><pre>${si.zzmdd}</pre></td>
					</tr>
					<tr>
						<td width="15%" class="td_top">VESSEL ：</td>
						<%-- <td>开票方式：${invoice.kpfsmc}</td> --%>
						<td width="85%"><pre>${si.cmhc}</pre></td>
					</tr>
					<tr>
						<td width="15%" class="td_top">MARKS & NOS.：</td>
						<td width="85%"><pre>${si.marks}</pre></td>
					</tr>
					<tr>
						<td width="15%" class="td_top">DESCRIPTION：</td>
						<td width="85%"><pre>${si.ms}</pre></td>
					</tr>
				</table>
			</div>
			<div class="space-8"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
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
							<td align="right"><fmt:formatNumber value="${item.kbzwet}" pattern="#,##0.000" /></td>
							<td align="right"><fmt:formatNumber value="${item.kbzv}" pattern="#,##0.000" /></td>
							<td align="right"><fmt:formatNumber value="${item.vgm}" pattern="#,##0.000" /></td>
							<td align="right"><fmt:formatNumber value="${item.boxsum}" pattern="#,##0" /></td>
							<td align="right"><fmt:formatNumber value="${item.kbsum}" pattern="#,##0" /></td>
							<td>${item.gxnam}</td>
							<td>${item.dcno}</td>
							<td>${item.tare}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="2" align="right"><b>TOTAL:</b></td>
						<td align="center"><b><fmt:formatNumber value="${si.sumKbzl}" pattern="#,#00.000"/></b></td>
						<td align="center"><b><fmt:formatNumber value="${si.sumKbtj}" pattern="#,#00.000"/></b></td>
						<td align="center"><b><fmt:formatNumber value="${si.sumVgm}" pattern="#,#00.000"/></b></td>
						<td align="center"><b><fmt:formatNumber value="${si.sumZxsl}" pattern="#,#0"/></b></td>
						<td align="center"><b><fmt:formatNumber value="${si.sumKbsl}" pattern="#,#0"/></b></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
</span>
</body>
<script type="text/javascript">
	$(function($){
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		
		$(".skycheckbox").prop("disabled","disabled");
		$(".skyradio").prop("disabled","disabled");
		
		$("#btn-Print").click(function(){
			window.open("<c:url value='/custinv/si/print'/>?id=${si.id}");
	    });
	});
		
</script>
</html>