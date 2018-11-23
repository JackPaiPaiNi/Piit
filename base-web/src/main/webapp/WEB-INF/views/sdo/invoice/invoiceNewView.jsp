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
							<!-- <button id="btn-xdPrint" type="button" class="btn btn-light btn-sm">
								<i class="icon-print icon-on-right bigger-110"></i>
								箱单打印
							</button> -->
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
						<td style="width: 25%">实际发票总金额：<fmt:formatNumber value="${invoice.sjfpzje}" pattern="#,#00.00" /></td>
					</tr>
					<tr>
						<td style="width: 25%">走货方式：${invoice.zhfsmc}</td>
						<td style="width: 25%">&nbsp;</td>
						<td style="width: 25%">&nbsp;</td>
						<td style="width: 25%">&nbsp;</td>
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
				<!-- <li><a href="#xdxx-tab" data-toggle="tab">箱单信息</a></li> -->
				<li><a href="#qtfy-tab" data-toggle="tab">其他费用信息</a></li>
			</ul>
			
			<div class="tab-content">
				<!-- 发票信息TAB -->
				<div class="tab-pane fade active in" id="fpxx-tab">
					<div class="row" style="margin: 0px 8px; overflow-x: auto;">
						<table class="table table-bordered">
							<tr>
								<th>Marks&No.</th>
								<!-- <th>Description of Goods</th> -->
								<th>出货单号</th>
								<th>交货单号</th>
								<th>行项目号</th>
								<th>Unit</th>
								<th>Unit Price</th>
								<th>Total QTY</th>
								<th>Amount</th>
								<!-- <th>HS.CODE</th> -->
								<!-- <th>Origin</th> -->
								<!-- <th>Part No.</th> -->
								<th>物料描述</th>
								<th>项目类别</th>
								<th>型号/物料编号</th>
								<!-- <th>Other Language Description</th>
								<th>Chinese Description</th> -->
							</tr>
							<c:forEach items="${invoice.invoiceDetailList}" var="item">
								<tr>
									<td>${item.ddid}</td>
									<td>${item.chdh}</td>
									<td>${item.jhdh}</td>
									<td>${item.serino}</td>
									<td>${item.wldw}</td>
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,#00.000000" /></td>
									<td align="right"><fmt:formatNumber value="${item.jhsl}" pattern="#,##0.00" /></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,#00.000000" /></td>
									<%-- <td>${item.wlbh}</td> --%>
									<td>${item.wlms}</td>
									<td>${item.xmlb}</td>
									<td>${item.model}</td>
								</tr>
							</c:forEach>
							<tr>
								<th>总计</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th align="right"><fmt:formatNumber value="${invoice.zsl}" pattern="#,#00.00" /></th>
								<th align="right"><fmt:formatNumber value="${invoice.zje}" pattern="#,#00.000000" /></th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
							</tr>
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
			window.open("<c:url value='/invoice/invoicenew/reportDown'/>?type=1&fph=${invoice.fph}&fpmb=${invoice.fpmb}");
	    });
		
		/* // 箱单打印type=2箱单
		$("#btn-xdPrint").click(function(){
			window.open("<c:url value='/invoice/invoicenew/reportDown'/>?type=2&fph=${invoice.fph}&fpmb=${invoice.fpmb}");
	    }); */
	});
		
</script>
</html>