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
				<input type="hidden" name="id" value="${sapSpecialOrder.id}"/><!-- 订单id -->
				<input type="hidden" name="sjc" value="${sapSpecialOrder.sjc}"/>
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
						<td style="width: 25%"><b>销售订单：</b>${sapSpecialOrder.xsdd}</td>
						<td style="width: 25%"><b>申请人：</b>${sapSpecialOrder.sqr}</td>
						<td><b>申请日期：</b><fmt:formatDate value="${sapSpecialOrder.sqrq}" pattern="yyyy-MM-dd"/></td>
						<td style="width: 25%"><b>单据状态：</b>${sapSpecialOrder.ztmc}</td>
					</tr>
					<tr>
						<td><b>销售组织：</b>${sapSpecialOrder.xszz}</td>
						<td><b>分销渠道：</b>${sapSpecialOrder.fxqd}</td>
					<%-- 	<td><b>销售地区：</b>${sapSpecialOrder.xsdq}</td> --%>
						<td><b>价格清单：</b><fmt:formatDate value="${sapSpecialOrder.jgqd}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>采购订单：</b>${sapSpecialOrder.cgdd}</td>
						<td><b>客户：</b>${sapSpecialOrder.khmc}</td>
						<td><b>销售员：</b>${sapSpecialOrder.xsy}</td>
						<td><b>订单日期：</b><fmt:formatDate value="${sapSpecialOrder.ddrq}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>付款条件：</b>${sapSpecialOrder.fktj}</td>
						<td><b>结算货币：</b>${sapSpecialOrder.jshb}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">项目明细</h5>
			 <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>项目号</th>
						<th>型号</th>
						<th>数量</th>
						<th>销售单价</th>
						<th>销售总额</th>
						<th>折扣金额</th>
						<th>销售毛利率</th>
					</tr>
					<c:forEach items="${sapSpecialOrder.itemList}" var="item">
						<tr>
							<td>${item.xmh}</td>
							<td>${item.xh}</td>
							<td>${item.sl}</td>
							<td>${item.xsdj}</td>
							<td>${item.xsze}</td>
							<td>${item.zkje}</td>
						    <td>${item.xsmll}</td>
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
					<c:forEach items="${sapSpecialOrder.logList}" var="item">
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
				message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
		// 返回
		$("#btn-back").click(function(){
			location.href = "<c:url value='/sapspecial/sapSpecialOrder/list'/>";
	    });
	});
</script>
</html>