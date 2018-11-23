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
	</style>
</head>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row" style="margin: 0px 8px;">
				<input type="hidden" id="id" name="id" value="${customerApply.id}"/><!--id -->
				<input type="hidden" id="sjc" name="sjc" value="${customerApply.sjc}"/>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 30%"><b>申请单号：</b>${customerApply.sqdh}</td>
						<td style="width: 30%"><b>状态：</b>
							<c:choose>
							   <c:when test="${customerApply.zt == '1'}">草稿 
							   </c:when>
							   <c:when test="${customerApply.zt == '2'}">审批中 
							   </c:when>
							   <c:when test="${customerApply.zt == '3'}">驳回 
							   </c:when>
							   <c:when test="${customerApply.zt == '4'}">审批通过 
							   </c:when>
							   <c:when test="${customerApply.zt == '5'}">已生效 
							   </c:when>
							   <c:when test="${customerApply.zt == '6'}">取消 
							   </c:when>
							</c:choose>
						</td>
						<td style="width: 20%"></td>
						<td style="width: 20%">
							<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
								<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
									<i class="fa-file-image-o icon-on-right bigger-110"></i>
									流程图
								</button>
								&nbsp;
							</c:if>
							<button id="undo" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
								返回
							</button>
						</td>
					</tr>
				</table>
			</div>
			
			<h5 class="header blue" style="margin-top:4px;">客户申请信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="3"><b>客户名称：</b>${customerApply.khmc}</td>
						<td><b>客户简称：</b>${customerApply.khjc}</td>
					</tr>
					<tr>
						<td><b>客户地址：</b>${customerApply.xxdz}</td>
					</tr>
					<tr>
						<td><b>官网网址：</b>${customerApply.gwdz}</td>
					</tr>
					<tr>
						<td style="width: 25%"><b>客户联系人：</b>${customerApply.lxr}</td>
						<td style="width: 25%">${customerApply.lxr2}</td>
						<td style="width: 25%">${customerApply.lxr3}</td>
						<td style="width: 25%"><b>手机号码：</b>${customerApply.sjh}</td>
					</tr>
					<tr>
						<td><b>联系电话：</b>${customerApply.dh}</td>
						<td><b>Email：</b>${customerApply.yx}</td>
						<td><b>Skype：</b>${customerApply.skype}</td>
						<td><b>Whatapp：</b>${customerApply.whatapp}</td>
					</tr>
					<tr>
						<td><b>品牌：</b>${customerApply.pp}</td>
						<td><b>付款条件：</b>${customerApply.fktj}</td>
						<td><b>销售员：</b>${customerApply.xsymc}</td>
						<td><b>关联客户编码：</b>${customerApply.glkhbm}</td>
					</tr>
					<tr>
						<td><b>备注信息：</b>${customerApply.bzxx}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top: 4px;">审批日志</h5>
		   <div class="space-4"></div>
		   <div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>申请单号</th>					
						<th>操作类型</th>
						<th>操作职位</th>
						<th>操作人账号</th>
						<th>操作人名称</th>
						<th>操作时间</th>
						<th>处理意见</th>
					</tr>
					<c:forEach items="${customerApply.logList}" var="item">
						<tr>
							<td>${item.sqdh}</td>
							<td>${item.czlx}</td>
							<td>${item.czzw}</td>
							<td>${item.czr}</td>
							<td>${item.czrmc}</td>
							<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd"/></td>
							<td>${item.nr}</td>
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
		$("#undo").click(function(){
			window.history.back(-1);
	    });
		// 查看流程
		$("#btn-flow").click(function(){
			bootbox.dialog({
				title : "流程图",
				message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
	});
</script>
</html>