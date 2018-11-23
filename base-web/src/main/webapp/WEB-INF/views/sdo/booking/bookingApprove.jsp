<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
</head>
<body>
<div class="page-content">
	<form id="form-submit">
	    <input type="hidden" name="token" value="${token}" />
		<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
		<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
		<h5 class="header blue" style="margin-top: 4px;">审核意见</h5>
		<div class="col-xs-12">
			<div class="row">
				<textarea id="spyj" name="spyj"
					class="autosize-transition form-control" rows="5"></textarea>
			</div>
			<div class="space-4"></div>
		</div>
		<div class="space-4"></div>
		<div class="row" align="center">
			<button type="button" class="btn btn-info btn-sm" onclick="javascript:approve(1);">
				<i class="icon-ok icon-on-right bigger-110"></i>
				通过
			</button>
			&nbsp;
			<button type="button" class="btn btn-danger btn-sm" onclick="javascript:approve(2);">
				<i class="fa-times icon-on-right bigger-110"></i>
				驳回
			</button>
			&nbsp;
			<button type="button" class="btn btn-sm" onclick="javascript:history.back(-1);">
				<i class="icon-undo icon-on-right bigger-110"></i>
				返回
			</button>
		</div>
		<div class="row">
			<!-- c:import的url默认接受父页面的参数，如果需要添加参数用c:param -->
			<c:import url="/booking/booking/viewPageList" charEncoding="UTF-8">
			</c:import>
		</div>
	</form>
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	function approve(type){
		var param = $("#form-submit").getFormData();
		param.approveType = type;
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/booking/booking/approve'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
</script>
</html>