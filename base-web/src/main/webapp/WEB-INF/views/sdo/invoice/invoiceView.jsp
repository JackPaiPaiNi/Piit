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
	</style>
</head>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row" style="margin: 0px 8px;">
				<input type="hidden" name="id" value="${invoice.id}"/><!-- 订单id -->
				<input type="hidden" name="sjc" value="${invoice.sjc}"/>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">发票号：${invoice.fph}</td>
						<td style="width: 25%"></td>
						<td style="width: 25%"></td>
						<td style="width: 25%">
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
								返回
							</button>
							&nbsp;
							<button id="btn-fpPrint" type="button" class="btn btn-light btn-sm">
								<i class="icon-print icon-on-right bigger-110"></i>
								发票打印
							</button>
							&nbsp;
							<button id="btn-xdPrint" type="button" class="btn btn-light btn-sm">
								<i class="icon-print icon-on-right bigger-110"></i>
								箱单打印
							</button>
						</td>
					</tr>
					<tr>
						<td style="width: 25%">发票类型：${invoice.fplxmc}</td>
						<td style="width: 25%">发票状态：
							<c:choose>
							   <c:when test="${invoice.zt == '1'}">草稿 
							   </c:when>
							   <c:when test="${invoice.zt == '2'}">终稿
							   </c:when>
							</c:choose>
						</td>
						<td style="width: 25%">开票方式：${invoice.kpfsmc}</td>
						<td style="width: 25%">实际发票总金额：${invoice.sjfpzje}</td>
					</tr>
				</table>
			</div>
		
			<h5 class="header blue" style="margin-top:4px;">公司信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">公司名称：${invoice.gsmc}</td>
						<td style="width: 25%">公司联系电话：${invoice.gslxdh}</td>
						<td style="width: 50%">公司地址：${invoice.gsdz}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">Sold to Messrs</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">客户名称：${invoice.khmc}</td>
						<td style="width: 25%">客户联系电话：${invoice.khdh}</td>
						<td style="width: 50%">客户地址：${invoice.khdz}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">Consignee to</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">公司名称：${invoice.shfmc}</td>
						<td style="width: 25%">公司联系电话：${invoice.shfdh}</td>
						<td style="width: 50%">公司地址：${invoice.shfdz}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">基本信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">出运类型：${invoice.cylxmc}</td>
						<td style="width: 25%">币种：${invoice.bz}</td>
						<td style="width: 25%">发票总金额：${invoice.zje}</td>
						<td style="width: 25%">是否需报关：
							<input type="radio" class="skyradio" <c:if test="${invoice.sfBg == 1}">checked="checked"</c:if>>是
							<input type="radio" class="skyradio" <c:if test="${invoice.sfBg == 0}">checked="checked"</c:if>>否
						</td>
					</tr>
					<tr>
						<td>付款条件：${invoice.fktjmc}</td>
						<td>LC编码：${invoice.lcbh}</td>
						<td>贸易条款：${invoice.mytkmc}</td>
						<td>${invoice.gjmytkbz}</td>
					</tr>
					<tr>
						<td>起运港：${invoice.qygmc}</td>
						<td>卸货港：${invoice.xhg}</td>
						<td>目的港：${invoice.mdg}</td>
						<td>船名：${invoice.cm}</td>
					</tr>
					<tr>
						<td>航次：${invoice.hc}</td>
						<td>发票日期：<fmt:formatDate value="${invoice.fprq}" pattern="yyyy-MM-dd"/></td>
						<td>起运日期：<fmt:formatDate value="${invoice.qyrq}" pattern="yyyy-MM-dd"/></td>
						<td>预计到港日期：<fmt:formatDate value="${invoice.yjdgq}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td>提单号：${invoice.tdh}</td>
						<%-- <td>开票方式：${invoice.kpfsmc}</td> --%>
						<td>是否按付款条件拆分价格：
							<input type="radio" class="skyradio" <c:if test="${invoice.sfAfktjcfjg == 1}">checked="checked"</c:if>>是
							<input type="radio" class="skyradio" <c:if test="${invoice.sfAfktjcfjg == 0}">checked="checked"</c:if>>否
						</td>
						<td>拆分比例：${invoice.cfbl1}&nbsp;&nbsp;${invoice.cfbl2}</td>
						<td>发票箱单模板：${invoice.fpmbmc}</td>
					</tr>
					<tr>
						<td>箱单物料描述语言：${invoice.xdwlmsyymc}</td>
						<td>海关商品编码：${invoice.hgspbm}</td>
						<%-- <td colspan="2">海关商品描述：${invoice.hgspms}</td> --%>
					</tr>
					<tr>
						<td colspan="2">发票&箱单附件：${invoice.fj}</td>
						<td colspan="2">发票备注：${invoice.bzxx}</td>
					</tr>
				</table>
			</div>
			
			<div class="space-8"></div>
			<ul class="nav nav-tabs">
				<li class="active"><a href="#fpxx-tab" data-toggle="tab">发票信息</a></li>
				<li><a href="#xdxx-tab" data-toggle="tab">箱单信息</a></li>
				<li><a href="#qtfy-tab" data-toggle="tab">其他费用信息</a></li>
			</ul>
			
			<div class="tab-content">
				<!-- 发票信息TAB -->
				<div class="tab-pane fade active in" id="fpxx-tab">
					<div class="row" style="margin: 0px 8px; overflow-x: auto;">
						<table class="table table-bordered">
							<tr>
								<th>Marks&No.</th>
								<th>Description of Goods</th>
								<th>Unit</th>
								<th>Unit Price</th>
								<th>Total QTY</th>
								<th>Amount</th>
								<th>HS.CODE</th>
								<th>Origin</th>
								<th>Part No.</th>
								<th>English Description</th>
								<th>Other Language Description</th>
								<th>Chinese Description</th>
							</tr>
							<c:forEach items="${invoice.invoiceItemList}" var="item">
								<tr>
									<td>${item.ddid}</td>
									<td>${item.spms}</td>
									<td>${item.dw}</td>
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,#00.00" /></td>
									<td align="right"><fmt:formatNumber value="${item.zsl}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.zje}" pattern="#,#00.00" /></td>
									<td>${item.khhgbm}</td>
									<td>${item.ycgj}</td>
									<td>${item.wlbh}</td>
									<td>${item.wlmsYw}</td>
									<td>${item.wlmsKhyy}</td>
									<td>${item.wlmsZw}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<!-- 箱单信息TAB -->
				<div class="tab-pane fade" id="xdxx-tab">
					<div class="row" style="margin: 0px 8px; overflow-x: auto;">
						<table class="table table-bordered">
							<tr>
								<th>行号</th>
								<th>出货通知书</th>
								<th>Job No.</th>
								<th>Container Type</th>
								<th>Container No.</th>
								<th>Seal No.</th>
								<th>Plts No.</th>
								<th>CTN No.</th>
								<th>CTNS</th>
								<th>Model No.</th>
								<th>Description of Goods</th>
								<th>Part No.</th>
								<th>Client Part No.</th>
								<th>English Description</th>
								<th>Other Language Description</th>
								<th>MOQ</th>
								<th>QTY PER CARTON</th>
								<th>Total QTY</th>
								<th>Order QTY</th>
								<th>FOC QTY</th>
								<th>Unit</th>
								<th>Unit Price</th>
								<th>Order Amount</th>
								<th>FOC Amount</th>
								<th>Weight(kg)per unit</th>
								<th>NET/CARTON(kg)</th>
								<th>GROSS/CARTON（kg)</th>
								<th>TTL NET(kg)</th>
								<th>TTL GROSS（kg)</th>
								<th>L(CARTON)</th>
								<th>W(CARTON)</th>
								<th>H(CARTON)</th>
								<th>Incl. Plt (kg)</th>
								<th>Pallet Dim (L)cm</th>
								<th>Pallet Dim (W)cm</th>
								<th>Pallet Dim (H)cm</th>
								<th>TTL CBM</th>
								<th>Supplier Code</th>
								<th>Supplier Name</th>
								<th>Supplier Address</th>
								<th>HS.CODE</th>
								<th>Origin</th>
							</tr>
							<c:forEach items="${invoice.invoicePackingList}" var="item">
								<tr>
									<td>${item.serino}</td>
									<td>${item.chdh}</td>
									<td>${item.ddid}</td>
									<td>${item.gx}</td>
									<td>${item.gh}</td>
									<td>${item.fth}</td>
									<td>${item.kbh}</td>
									<td>${item.xh}</td>
									<td align="right"><fmt:formatNumber value="${item.xs}" pattern="#,##0"/></td>
									<td>${item.jixing}</td>
									<td>${item.spms}</td>
									<td>${item.wlbh}</td>
									<td>${item.khlh}</td>
									<td>${item.wlmsYw}</td>
									<td>${item.wlmsKhyy}</td>
									<td align="right">${item.moq}</td>
									<td align="right"><fmt:formatNumber value="${item.mxsl}" pattern="#,##0"/></td>
									<td align="right"><fmt:formatNumber value="${item.zsl}" pattern="#,##0"/></td>
									<td align="right"><fmt:formatNumber value="${item.dhsl}" pattern="#,##0"/></td>
									<td align="right"><fmt:formatNumber value="${item.mfsl}" pattern="#,##0"/></td>
									<td>${item.dw}</td>
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,#00.00" /></td>
									<td align="right"><fmt:formatNumber value="${item.dhje}" pattern="#,#00.00" /></td>
									<td align="right"><fmt:formatNumber value="${item.mfje}" pattern="#,#00.00" /></td>
									<td align="right">${item.dgzl}</td>
									<td align="right">${item.djzmx}</td>
									<td align="right">${item.dmzmx}</td>
									<td align="right">${item.zjz}</td>
									<td align="right">${item.zmz}</td>
									<td align="right">${item.zxC}</td>
									<td align="right">${item.zxK}</td>
									<td align="right">${item.zxG}</td>
									<td align="right">${item.mkbmz}</td>
									<td align="right">${item.kbC}</td>
									<td align="right">${item.kbK}</td>
									<td align="right">${item.kbG}</td>
									<td align="right">${item.kbtj}</td>
									<td>${item.gysdm}</td>
									<td>${item.gysmc}</td>
									<td>${item.gysdz}</td>
									<td>${item.khhgbm}</td>
									<td>${item.ycgj}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<!-- 其他费用信息TAB -->
				<div class="tab-pane fade" id="qtfy-tab">
					<div class="row" style="margin: 0px 8px; overflow-x: auto;">
						<table class="table table-bordered">
							<tr>
								<th>类型</th>
								<th>描述</th>
								<th>数量</th>
								<th>单价</th>
								<th>金额</th>
							</tr>
							<c:forEach items="${invoice.invoiceOtherList}" var="item">
								<tr>
									<td>${item.qtxmmc}</td>
									<td>${item.ms}</td>
									<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,#00.00" /></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,#00.00" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
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
		
		// 发票打印type=1发票
		$("#btn-fpPrint").click(function(){
			window.open("<c:url value='/invoice/invoice/reportDown'/>?type=1&fph=${invoice.fph}&fpmb=${invoice.fpmb}");
	    });
		
		// 箱单打印type=2箱单
		$("#btn-xdPrint").click(function(){
			window.open("<c:url value='/invoice/invoice/reportDown'/>?type=2&fph=${invoice.fph}&fpmb=${invoice.fpmb}");
	    });
	});
		
</script>
</html>