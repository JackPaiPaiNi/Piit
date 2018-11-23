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
			font-size : 12px;
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
				<input type="hidden" name="id" value="${projectBug.id}"/><!-- id -->
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 20%">
							<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
								<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
									<i class="fa-file-image-o icon-on-right bigger-110"></i>
									流程图
								</button>
								&nbsp;
							</c:if>
						</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">详细信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0" >
					<tr>
						<td style="width: 25%"><b>问题单号：</b>${projectBug.wtdh}</td>
						<td style="width: 25%"><b>项目阶段：</b>${projectBug.xmjdmc}</td>
						<td style="width: 25%"><b>提出人：</b>${projectBug.tcrmc}</td>
						<td style="width: 25%"><b>提出部门：</b>${projectBug.tcbmmc}</td>
					</tr>
					<tr>
					    <td><b>提出时间：</b><fmt:formatDate value="${projectBug.tcsj}" pattern="yyyy-MM-dd"/></td>
						<td><b>状态：</b>${projectBug.ztmc}</td>
						<td><b>优先级：</b>${projectBug.yxjmc}</td>
						<td><b>菜单名称：</b>${projectBug.cdmc}</td>
					</tr>
					<tr>
						<td><b>提出时间：</b><fmt:formatDate value="${projectBug.tcsj}" pattern="yyyy-MM-dd"/></td>
						<td><b>要求处理时间：</b><fmt:formatDate value="${projectBug.yqclsj}" pattern="yyyy-MM-dd"/></td>
						<td><b>预计处理时间：</b><fmt:formatDate value="${projectBug.yjclsj}" pattern="yyyy-MM-dd"/></td>
						<td><b>处理时间：</b><fmt:formatDate value="${projectBug.sjclsj}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>关闭时间：</b><fmt:formatDate value="${projectBug.gbsj}" pattern="yyyy-MM-dd"/></td>
						<td><b>问题分类：</b>${projectBug.wtflmc}</td>
						<td><b>处理人：</b>${projectBug.clrmc}</td>
					</tr>
					<tr>
						<td colspan="4"><b>问题描述：</b>${projectBug.wtms}</td>
					</tr>
					<tr>
						<td colspan="4"><b>处理说明：</b>${projectBug.clsm}</td>
					</tr>
				</table>
			</div>
			<!-- 审批日志 -->
			<div class="space-4"></div>
			<h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
			<div class="space-4"></div>
			<c:import url="/pub/showLog/projectBug" charEncoding="UTF-8" />
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
		// 查看流程
		$("#btn-flow").click(function(){
			bootbox.dialog({
				title : "流程图",
				message : "<img src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
		// 返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		
		$.bindAjax({
			url:"<c:url value='/project/projectBug/findById'/>",
			data:{id : "${projectBug.id}" },
			action:"search"
		},function(response){
		});
	});
</script>
</html>