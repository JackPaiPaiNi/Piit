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
	</style>
</head>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row" style="margin: 0px 8px;">
				<h4 class="blue" align="center">订单详细信息</h4>
				<div style="text-align: right; margin-right: 100px;">
					<button id="btn-back" class="btn btn-sm" type="button">
						<i class="icon-undo icon-on-right bigger-110"></i>返回
					</button>
				</div>
			</div>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%;"><b>订单号：</b>${order.ddxx[0].ddid}</td>
						<td style="width: 25%;"><b>客户：</b>${order.ddxx[0].khmc}</td>
						<td style="width: 25%;"><b>销售员：</b>${order.ddxx[0].xsymc}</td>
						<td style="width: 25%;"><b>交货日期：</b><fmt:formatDate value="${order.ddxx[0].jhrq}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>走货方式：</b>${order.ddxx[0].zhfsmc}</td>
						<td colspan="3"><b>付款条件：</b>${order.ddxx[0].fktjmc}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">订单审批记录</h5>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>订单号</th>
						<th>版本号</th>
						<th>操作类型</th>
						<th>操作职位</th>
						<th>操作人账号</th>
						<th>操作人名称</th>
						<th>操作时间</th>
						<th>处理意见</th>
					</tr>
					<c:forEach items="${order.spxx}" var="item">
						<tr>
							<td>${item.ddid}</td>
							<td>${item.bbh}</td>
							<td>${item.czlx}</td>
							<td>${item.czzw}</td>
							<td>${item.czr}</td>
							<td>${item.czrmc}</td>
							<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${item.nr}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">付款保障记录（下单/预走货）</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 30%;"><b>付款保障要求是否满足（下单）：</b>
							<c:choose>
							   <c:when test="${order.ddxx[0].fkbzzt == '0'}">未通过</c:when>
							   <c:when test="${order.ddxx[0].fkbzzt == '1'}">已通过</c:when>
							</c:choose>
						</td>
						<td style="width: 70%;"><b>不满足原因：</b>${order.ddxx[0].jbxxbz}</td>
					</tr>
				</table>
				<table class="table table-bordered">
					<tr>
						<th>订单号</th>
						<th>订单类型</th>
						<th>特批单号</th>
						<th>特批节点</th>
						<th>特批类别</th>
						<th>特批时间</th>
						<th>备注信息</th>
					</tr>
					<c:forEach items="${order.fkbzxx}" var="item">
						<tr>
							<td>${item.dh}</td>
							<td>${item.djlxmc}</td>
							<td>${item.tpdh}</td>
							<td>${item.tpjdmc}</td>
							<td>${item.tplbmc}</td>
							<%-- <td>${item.bz}</td> --%>
							<%-- <td align="right"><fmt:formatNumber value="${item.tpje}" pattern="#,##0.00"/></td> --%>
							<td><fmt:formatDate value="${item.tpsj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${item.bzxx}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">生产系统订单下达与排产</h5>
			<div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 33%;"><b>生产计划完成时间：</b>
							<fmt:formatDate value="${order.rjqrxx[0].scjhwcsj}" pattern="yyyy-MM-dd"/></td>
					    <td style="width: 33%;" ><b>生产计划完成确认时间：</b>
							<fmt:formatDate value="${order.rjqrxx[0].scjhwc}" pattern="yyyy-MM-dd"/></td>
						 <td style="width: 33%;"><b>软件确认时间：</b>
							<fmt:formatDate value="${order.rjqrxx[0].rjqrsj}" pattern="yyyy-MM-dd"/>
					    </td>
					</tr>
					<tr>
						<td style="width: 33%;"><b>主要问题点：</b>${order.rjqrxx[0].rjzywtd}</td>
						<td style="width: 67%;" colspan="2"><b>备注信息：</b>${order.rjqrxx[0].bzxx}</td>
					</tr>
				</table>
			</div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>订单号</th>
						<th>美工资料</th>
						<th>美工资料附件</th>
						<th>备注信息</th>
					</tr>
					<c:forEach items="${order.mgqrxx}" var="item">
						<tr>
							<td>${item.ddid}</td>
							<td>${item.mgzl}</td>
							<td>${item.qrfj}</td>
							<td>${item.bzxx}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		    <h5 class="header blue" style="margin: 0; padding: 0;">预走货信息</h5>
		    <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>预走货单号</th>
						<th>订舱单号</th>
						<th>预走货类型</th>
						<th>预走货创建时间</th>
						<th>付款保障要求是否满足（预走货）</th>
						<th>不满足原因</th>
					</tr>
					<c:forEach items="${order.yzhxx}" var="item">
						<tr>
							<td>${item.yzhdh}</td>
							<td>${item.dcdh}</td>
							<td>${item.yzhlxmc}</td>
							<td><fmt:formatDate value="${item.zdsj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>
								<c:choose>
							   		<c:when test="${item.fkbzzt == '0'}">未通过</c:when>
							   		<c:when test="${item.fkbzzt == '1'}">已通过</c:when>
								</c:choose>
							</td>
							<td>${item.bcQt}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<h5 class="header blue" style="margin: 0; padding: 0;">出库信息</h5>
		    <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>出货单号</th>
						<th>出货时间</th>
						<th>出货明细</th>
						<th>备注</th>
					</tr>
					<c:forEach items="${order.chxx}" var="item">
						<tr>
							<td>${item.chdh}</td>
							<td><fmt:formatDate value="${item.zdsj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td></td>
							<td>${item.bzxx}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<h5 class="header blue" style="margin: 0; padding: 0;">开票信息</h5>
		    <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>发票号</th>
						<th>开票时间</th>
						<th>发票币种</th>
						<th>发票金额</th>
					</tr>
					<c:forEach items="${order.kpxx}" var="item">
						<tr>
							<td>${item.fph}</td>
							<td><fmt:formatDate value="${item.fprq}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${item.bz}</td>
							<td align="right"><fmt:formatNumber value="${item.zje}" pattern="#,##0.00"/></td>
						</tr>
					</c:forEach>
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
		// 返回
		$("#btn-back").click(function(){
			location.href = "<c:url value='/track/trackInfo'/>";
	    });
	});
	
</script>
</html>