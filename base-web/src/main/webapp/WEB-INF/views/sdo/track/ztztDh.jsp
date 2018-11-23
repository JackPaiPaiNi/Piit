<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<style type="text/css">
		html{
			position:static;
		}
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
	</style>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div style="overflow: auto; white-space: nowrap;">
			<table class="table table-bordered">
				<tr>
					<th style="width: 90px;"></th>
					<th style="width: 80px;">下单</th>
					<th style="width: 80px;">订单审批</th>
					<th style="width: 80px;">生产订单下达</th>
					<th style="width: 80px;">一次评审</th>
					<th style="width: 80px;">美工确认</th>
					<th style="width: 80px;">订单转工单</th>
				    <th style="width: 80px;">软件确认</th>
					<th style="width: 80px;">生产计划完成</th>
				    <th style="width: 80px;">预走货创建</th>
					<th style="width: 80px;">预走货完成</th>
					<th style="width: 80px;">入库</th>
					<th style="width: 80px;">出库</th>
				<!-- 	<th style="width: 80px;">报关</th>
					<th style="width: 80px;">出运</th>
					<th style="width: 80px;">散件收货</th>
					<th style="width: 80px;">整机收货</th> -->
				</tr>
				<c:forEach items="${ztzt}" var="item" varStatus="index">
				<c:choose>
					<c:when test="${index.last}">
						<tr style="white-space:pre-wrap; word-wrap: break-word; word-break: normal;">
					</c:when>
					<c:otherwise>
						<tr>
					</c:otherwise>
				</c:choose>
						<td>${item.lx}</td>
						<td>${item.xdzt}</td>
						<td>${item.ddspzt}</td>
						<td>${item.scddxdzt}</td>
						<td>${item.ycpszt}</td>
						<td>${item.mgqrzt}</td>
						<td>${item.ddzgdzt}</td>
						<td>${item.rjqrzt}</td>
						<td>${item.scjhwczt}</td>
						<td>${item.yzhcjzt}</td>
						<td>${item.yzhwczt}</td>
						<td>${item.rkzt}</td>
						<td>${item.ckzt}</td>
						<%-- <td>${item.bgzt}</td>
						<td>${item.cyzt}</td>
						<td>${item.sjshzt}</td>
						<td>${item.zjshzt}</td> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
</body>
</html>