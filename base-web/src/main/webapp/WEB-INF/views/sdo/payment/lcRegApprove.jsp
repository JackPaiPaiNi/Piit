<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
	<%
		String processInstanceId = request.getParameter("processInstanceId");
		pageContext.setAttribute("processId", processInstanceId);
	%>
<style type="text/css">
table {
	width: 100%;
}

table td {
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
				<form id="form-submit">
					<input type="hidden" name="processId" value="<%=request.getParameter("processId")%>" />
					<input type="hidden" name="taskId" value="<%=request.getParameter("taskId")%>" />
					<input type="hidden" name="token" value="${token}" />
					<h5 class="header blue" style="margin-top: 4px;">审核意见</h5>
					<div class="col-xs-12">
						<div class="row">
							<textarea id="spyj" name="spyj"
								class="autosize-transition form-control" rows="5"></textarea>
						</div>
						<div class="space-4"></div>
					</div>
					<div class="row" align="center">
						<button id="btn-agree" type="button" class="btn btn-info btn-sm"
							onclick="javascript:approve(1);">
							<i class="icon-ok icon-on-right bigger-110"></i> 通过
						</button>
						&nbsp;
						<button id="btn-reject" type="button" class="btn btn-danger btn-sm" onclick="javascript:approve(2);">
							<i class="fa-times icon-on-right bigger-110"></i> 驳回
						</button>
						&nbsp;
						<button id="btn-undo" class="btn btn-sm" type="button">
							<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
					</div>
					<div class="row">
						<!-- c:import的url默认接受父页面的参数，如果需要添加参数用c:param -->
						<c:import url="/payment/lcReg/qryPage" charEncoding="UTF-8">
							<%-- <c:param name="type">LC登记</c:param> --%>
						</c:import>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
	<span class="loading-indicator"> <label><i
			class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
	</span>
</body>
<script type="text/javascript">
	$(function($) {
		$("#btn-undo").click(function(){
			location.href = "<c:url value='/base/bpm/taskList'/>";
	    });
		$("#undo").hide();
	});
	
	function approve(type){
		var param = $("#form-submit").getFormData();
		param.approveType = type;
		$("#save").bindSweetAlert({
			title:"确定要审批吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/payment/lcReg/approve'/>",
					data:param,
					action:"save",
					text:"",
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
</script>
</html>