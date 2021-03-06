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
		<div class="space-4"></div>
		<div class="row">
			<div class="input-group">
				<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
				<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
				<input type="hidden" name="token" value="${token}">
				<label class="input-group-btn">审核意见&nbsp;&nbsp;</label>
				<textarea id="spyj" name="spyj" class="autosize-transition form-control" rows="5"></textarea>
			</div>
		</div>
		<h5 class="header blue" style="margin-top: 4px;">计划完成时间</h5>
		<div class="row">
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">计划完成时间&nbsp;&nbsp;</label>
					<input type="text" name="jhwcsj" class="form-control date-picker"/>
					<span class="input-group-addon">
						<i class="icon-calendar bigger-110"></i>
					</span>
				</div>
			</div>
		</div>
		<div class="space-8"></div>
		<div class="row" align="center">
			<button id="btn-agree" type="button" class="btn btn-info btn-sm" onclick="javascript:approve(1);">
				<i class="icon-ok icon-on-right bigger-110"></i>
				通过并保存
			</button>
			&nbsp;
			<button id="btn-reject" type="button" class="btn btn-danger btn-sm" onclick="javascript:approve(2);">
				<i class="fa-times icon-on-right bigger-110"></i>
				驳回
			</button>
		</div>
		<div class="row">
			<!-- c:import的url默认接受父页面的参数，如果需要添加参数用c:param -->
			<c:import url="/mdm/pidInfo/viewPage" charEncoding="UTF-8">
				<%-- <c:param name="type">客户申请</c:param> --%>
			</c:import>
		</div>
	</form>
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	//日期控件绑定
	$(function($){
		$(".date-picker").bindDate();
	});
	function approve(type){
		var param = $("#form-submit").serializeObject();
		param.approveType = type;
		var jhwcsj = $("#form-submit [name=jhwcsj]").val();
		if(type == 1 && jhwcsj.length == 0){
			swal("","请选择计划完成时间！","warning");
			return;
		}
		$("#save").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/mdm/pidInfo/pidJhwcsjSave'/>",
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