<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String sfApprove = request.getParameter("sfApprove");
		String processInstanceId = request.getParameter("processId");
		pageContext.setAttribute("sfApprove", sfApprove);
		pageContext.setAttribute("processInstanceId", processInstanceId);
	%>
	<style type="text/css">
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
		.pre{
			background-color:#ffffff;
			border:0px solid #ffffff;
			padding :0px;
			font-size : 14px;
			font-family:"Open Sans","Helvetica Neue",Helvetica,Arial,sans-serif;
			/* float:left; */
		}
		.hh td,.hh th{
			word-wrap : break-word;
			word-break : break-all;
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
				<input type="hidden" name="id" value="${payEdit.id}"/><!-- 订单id -->
			</div>
			<h5 class="header blue" style="margin-top:4px;">信息查看</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>信用额度类型：</b>${payEdit.xyedlxmc}</td>
						<td style="width: 25%"><b>客户编码：</b>${payEdit.khbm}</td>
						<td style="width: 25%"><b>客户名称：</b>${payEdit.khmc}</td>
						<td >
							<b>是否虚拟客户：</b>
							<c:choose>
							   <c:when test="${payEdit.sfXnkh == '0'}">否</c:when>
							   <c:when test="${payEdit.sfXnkh == '1'}">是 </c:when>
							</c:choose> 
						</td>
					</tr>
					<tr>
						<td><b>中信保买方代码：</b>${payEdit.zxbmfdm}</td>
						<td><b>LC开证行：</b>${payEdit.kzh}</td>
						<td><b>LC开证行SWIFT：</b>${payEdit.kzhdm}</td>
						<td><b>所属组织：</b>${payEdit.sszzmc}</td>
					</tr>
					<tr>
						<td><b>国家：</b>${payEdit.gjmc}</td>
						<td><b>中信保额度：</b>${payEdit.zxbed}</td>
						<td><b>内部管理额度：</b>${payEdit.nbgled}</td>
						<td><b>开始有效期：</b><fmt:formatDate value="${payEdit.ksyxq}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>结束有效期：</b><fmt:formatDate value="${payEdit.yxq}" pattern="yyyy-MM-dd"/></td>
						<td><b>限额闲置期：</b>${payEdit.xexzq}</td>
						<td><b>赔付比例：</b>${payEdit.pfbl}</td>
						<td >
							<b>是否循环：</b>
							<c:choose>
							   <c:when test="${payEdit.sfxh == '0'}">否</c:when>
							   <c:when test="${payEdit.sfxh == '1'}">是 </c:when>
							</c:choose> 
						</td>
					</tr>
					<tr>
						<td><b>账期：</b>${payEdit.zq}</td>
						<td><b>赔付比例(拒收风险)：</b>${payEdit.pfblJsfx}</td>
						<td><b>币种：</b>${payEdit.bz}</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><PRE class="pre"><b>备注信息：</b>${payEdit.bzxx}</PRE></td>
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
</html>