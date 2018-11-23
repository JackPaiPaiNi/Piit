<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<%@include file="/WEB-INF/views/index/lfs.jsp"%>
<script type="text/javascript">
	$(function($) {
		$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:"1-yx-cwzy"},
				function(result){
					var data = $.map(result, function (obj) {
				       obj.id = obj.empCode;
				       obj.text = obj.text || obj.userName;	
				       return obj;
				     });
					$("#form-submit [name=cwzyid]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
						if(e.added){
							$("#form-submit [name=cwzymc]").val(e.added.userName);
						}
					});
			}, "json");
	});
</script>
</head>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form id="form-submit">
					<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
					<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
					<input type="hidden" name="token" value="${token}">
					<div class="row">
						<div class="input-group">
							<label class="input-group-btn">审核意见&nbsp;&nbsp;</label>
							<textarea id="spyj" name="spyj" class="autosize-transition form-control" rows="5"></textarea>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">船务分派</h5>
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">船务专员&nbsp;&nbsp;</label>
								<input type="hidden" name="cwzymc" />
								<input type="text" name="cwzyid" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-8"></div>
					<div class="row" align="center">
						<button id="btn-agree" type="button" class="btn btn-info btn-sm"
							onclick="javascript:approve(1);">
							<i class="icon-ok icon-on-right bigger-110"></i> 通过并保存
						</button>
						&nbsp;
						<button id="btn-reject" type="button"
							class="btn btn-danger btn-sm" onclick="javascript:approve(2);">
							<i class="fa-times icon-on-right bigger-110"></i> 驳回
						</button>
						&nbsp;
						<button type="button" class="btn btn-sm"
							onclick="javascript:history.back(-1);">
							<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
					</div>
					<div class="row">
						<!-- c:import的url默认接受父页面的参数，如果需要添加参数用c:param -->
						<c:import url="/pso/diversityPso/viewPage" charEncoding="UTF-8">
							<%-- <c:param name="type">大货订单</c:param> --%>
						</c:import>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	// 保存方法 
	function approve(type) {
		//拿到表单数据
		var param = $('#form-submit').getFormData();
		param.approveType = type;
		var cwzyid = $("#form-submit [name=cwzyid]").val();
		if(type == 1 && cwzyid.length == 0){
			swal("","请选择船务专员！","warning");
			return;
		}
		//保存
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/pso/tvPso/approve'/>",
					data : param,
					action : "save",
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
</script>
</html>


