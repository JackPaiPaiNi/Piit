<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<div class="row" style="margin: 0px 8px;">
	<table class="table table-bordered hh">
		<tr>
			<th style="width:10%">操作类型</th>
			<th style="width:10%">操作职位</th>
			<th style="width:20%">操作人账号</th>
			<th style="width:20%">操作人名称</th>
			<th style="width:10%">操作时间</th>
			<th style="width:15%">处理意见</th>
		</tr>
		<c:forEach items="${obj.logList}" var="item">
			<tr>
				<td>${item.czlx}</td>
				<td>${item.czzw}</td>
				<td>${item.czr}</td>
				<td>${item.czrmc}</td>
				<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${item.nr}</td>
			</tr>
		</c:forEach>
	</table>
</div>