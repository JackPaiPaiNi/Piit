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
				<input type="hidden" id="id" name="id" value="${contract.id}"/><!--id -->
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>合同编码：</b>${contract.htbh}</td>
						<td style="width: 25%"><b>合同名称：</b>${contract.htmc}</td>
						<td style="width: 25%"></td>
						<td style="width: 25%">
							<button id="undo" class="btn btn-sm" type="button">
							<i class="icon-undo icon-on-right bigger-110"></i>
								返回
							</button>
						</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">合同信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>合同发起人：</b>${contract.fqrmc}</td>
						<td style="width: 25%"><b>合同发起日期：</b><fmt:formatDate value="${contract.fqrq}" pattern="yyyy-MM-dd"/></td>
						<td style="width: 25%"><b>合同类型：</b>${contract.htlxmc}</td>
						<td style="width: 25%"><b>客户名称：</b>${contract.khmc}</td>
					</tr>
					<tr>
						<td><b>客户编码：</b>${contract.khbm}</td>
						<td><b>客户地址：</b>${contract.khdz}</td>
						<td><b>收/付款：</b>
							<c:choose>
							   <c:when test="${contract.sfk == '1'}">收款
							   </c:when>
							   <c:when test="${contract.sfk == '2'}">付款
							   </c:when>
							   <c:when test="${contract.sfk == '3'}">其他
							   </c:when>
							</c:choose>
						</td>
						<td><b>付款条件：</b>${contract.fktjmc}</td>
					</tr>
					<tr>
						<td><b>签约方：</b>${contract.qyf}</td>
						<td>${contract.qyf2}</td>
						<td>${contract.qyf3}</td>
						<td><b>合同份数：</b>${contract.htfs}</td>
					</tr>
					<tr>
						<td><b>合同金额：</b>${contract.htje}</td>
						<td><b>合同货币：</b>${contract.bz}</td>
						<td><b>有效期：</b><fmt:formatDate value="${contract.yxqks}" pattern="yyyy-MM-dd"/></td>
						<td><b>至：</b><fmt:formatDate value="${contract.yxqjs}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>状态：</b>
							<c:choose>
							   <c:when test="${contract.zt == '1'}">审批中
							   </c:when>
							   <c:when test="${contract.zt == '2'}">正常履行
							   </c:when>
							   <c:when test="${contract.zt == '3'}">失效 
							   </c:when>
							</c:choose>
						</td>
						<td><b>归档状态：</b>${contract.gdztmc}</td>
						<td><b>归档日期：</b><fmt:formatDate value="${contract.yxqks}" pattern="yyyy-MM-dd"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><b>合同简况：</b>${contract.htjk}</td>
						<td colspan="2"><b>备注：</b>${contract.bzxx}</td>
					</tr>
					<shiro:hasPermission name="mdm:contract:fj">
					<tr>
						<c:set var="fj" value="${contract.fj}"/>
						<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
						<td><b>附件：</b></td>
						<td>${fn:replace(fjxx,'red', '')}</td>
						<td >&nbsp;</td>
						<td >&nbsp;</td>
					</tr>
					</shiro:hasPermission>
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
		$(".skyradio").prop("disabled","disabled");
		$("#undo").click(function(){
			window.history.back(-1);
	    });
	});
</script>
</html>