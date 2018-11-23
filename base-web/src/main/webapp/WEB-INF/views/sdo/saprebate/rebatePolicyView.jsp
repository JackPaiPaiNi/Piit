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
table {
	width: 100%;
}
table {
	max-width: 200%;
}
table td {
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
		<div id="grid-parent"  class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row" style="margin: 0px 8px;">
				<input type="hidden" name="id" value="${title.id}"/>
				<input type="hidden" name="sjc" value="${title.sjc}"/>
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
						<td style="width: 25%"><b>公司代码：</b>${title.bukrs}</td>
					    <td style="width: 25%"><b>公司名称：</b>${title.gsmc}</td>
						<td style="width: 25%"><b>申请人：</b>${title.userid}</td>
					</tr>
					<tr>
					    <td><b>提交日期：</b><fmt:formatDate value="${title.cpudt}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</table>
			</div>
		
			 <h5 class="header blue" style="margin-top: 4px;">返利政策明细</h5>
			 <div class="row" style="margin: 0px 8px; width: 100%; overflow: scroll;">
				<table class="table table-bordered" style="width: 3600px;">
					<tr>
					    <th>行号</th>
					    <th>审批状态</th>
						<th>返利政策号</th>
						<th>序号</th>
						<th>返利分类编码</th>
						<th>返利分类编码描述</th>
						<th>品牌</th>
						<th>产品系列</th>
						<th>客户</th>
						<th>客户名称</th>
						<th>业务员</th>
						<th>业务员描述</th>
						<th>渠道</th>
						<th>型号</th>
						<th>产品型号描述</th>
						<th>返利依据汇总方式</th>
						<th>返利依据值从</th>
						<th>返利依据值到</th>
						<th>返利价格类型</th>
						<th>返利阶梯基数（描述）</th>
						<th>返利价格</th>	
						<th>乘数（描述）</th>
						<th>有效期从</th>	
						<th>有效期至</th>	
						<th>备注</th>	
					</tr>
					<c:forEach items="${title.rbpPolicyList}" var="item">
						<tr>
							<td>${item.hhao}</td>
						    <td>${item.ztmc}</td>
							<td>${item.zrpnm}</td>
							<td>${item.zitem}</td>
							<td>${item.zrcnm}</td>
							<td>${item.zrcnmms}</td>
							<td>${item.zbran}</td>
						    <td>${item.zprod}</td>
						    <td>${item.kunnr}</td>
						    <td>${item.khmc}</td>
						    <td>${item.zsalm}</td>
						    <td>${item.zsalmms}</td>
						    <td>${item.qdms}</td>
						    <td>${item.zmodl}</td>
						    <td>${item.zpdec}</td>
						    <td>${item.zsway}</td>
						    <td>${item.zbvulF}</td>
						    <td>${item.zbvulU}</td>
						    <td>${item.zptyp}</td>
						    <!-- 返利阶梯基数 -->
						    <td>${item.zrnum}</td>
						    <td>${item.zrbat}</td>
						    <td>${item.zmult}</td>
						    <td><fmt:formatDate value="${item.zvdatF}" pattern="yyyy-MM-dd"/></td>
						    <td><fmt:formatDate value="${item.zvdatU}" pattern="yyyy-MM-dd"/></td>
						    <td>${item.zremk}</td>
						</tr>
					</c:forEach>
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