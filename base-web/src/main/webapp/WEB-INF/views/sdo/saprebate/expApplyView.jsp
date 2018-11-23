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
		.dialog .modal-dialog{
			width:1100px;
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
				<input type="hidden" name="id" value="${title.id}"/>
				<input type="hidden" name="sjc" value="${title.sjc}"/>
				<input type="hidden" name="zdjlx"  value="${title.zdjlx}">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 50%">
							<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
								<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
									<i class="fa-file-image-o icon-on-right bigger-110"></i>
									流程图
								</button>
								&nbsp;
							</c:if>
							<c:if test="${sfApprove != 1}">
								<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
									返回
								</button>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
		
			<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>审批单流水号：</b>${title.splsh}</td>
						<td style="width: 25%"><b>公司代码：</b>${title.expApply.bukrs}</td>
						<%-- <td style="width: 25%"><b>公司名称：</b>${title.expApply.sqr}</td> --%>
						<td style="width: 25%"><b>申请人：</b>${title.expApply.zappm}</td>
					</tr>
					<tr>
					    <td><b>提交日期：</b><fmt:formatDate value="${title.expApply.cpudt}" pattern="yyyy-MM-dd"/></td>
						<td style="width: 25%"><b>联系电话：</b>${title.expApply.ztele}</td>
						<td><b>业务员代码：</b>${title.expApply.zsalm}</td>
						<td><b>业务员描述：</b>${title.expApply.zsalmms}</td>
					</tr>
					<tr>
						<td><b>申请事由：</b>${title.expApply.zreas}</td>
						<td><b>费用类型：</b>${title.expApply.zetyp}</td>
						<td><b>费用类型描述：</b>${title.expApply.zetypms}</td>
						<td><b>申请金额：</b>${title.expApply.zaamt}</td>
					</tr>
					<tr>
						<td><b>货币：</b>${title.expApply.waers}</td>
						<td><b>支付方：</b>${title.expApply.zrece}</td>
						<td><b>归属方：</b>${title.expApply.zbelo}</td>
						<td><b>归属方描述：</b>${title.expApply.zbeloms}</td>
					</tr>
					<tr>
					    <td><b>人民币金额：</b>${title.expApply.rmbje}</td>
						<td><b>承担部门：</b>${title.expApply.zdepa}</td>
						<td><b>承担部门描述：</b>${title.expApply.zdepams}</td>
					</tr>
					<tr>
					   <td><b>费用描述：</b>${title.expApply.zedes}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
			 <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>单据号</th>
						<th>操作类型</th>
						<th>操作人账号</th>
						<th>操作人名称</th>
						<th>操作时间</th>
						<th>处理意见</th>
					</tr>
					<c:forEach items="${title.logList}" var="item">
						<tr>
							<td>${item.dh}</td>
							<td>${item.czlx}</td>
							<td>${item.czr}</td>
							<td>${item.czrmc}</td>
							<td><fmt:formatDate value="${item.czsj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
		// 查看流程
		$("#btn-flow").click(function(){
			bootbox.dialog({
				title : "流程图",
				message : "<img  style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
		// 返回
		$("#btn-back").click(function(){  
			location.href = "<c:url value='/rebate/rebate/list'/>";
	    });
	});
</script>
</html>