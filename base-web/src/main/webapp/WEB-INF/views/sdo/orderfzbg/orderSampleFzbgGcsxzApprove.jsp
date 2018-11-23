<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
</head>

<script type="text/javascript">
$(function($) {
	//加载电子工程师
	$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:"3-yf-dzsjs,1-yx-wxdzsjs"},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.empCode;
			       obj.text = obj.text || obj.userName;	
			       return obj;
			     });
				$("#form-submit [name=dzgcs]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
					if(e.added){
						$("#form-submit [name=dzgcsmc]").val(e.added.userName);
					}
				});
		}, "json");
	//加载电源工程师
	$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:"3-yf-dysjs,1-yx-wxdzsjs"},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.empCode;
			       obj.text = obj.text || obj.userName;	
			       return obj;
			     });
				$("#form-submit [name=dygcs]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
					if(e.added){
						$("#form-submit [name=dygcsmc]").val(e.added.userName);
					}
				});
		}, "json");
	//加载结构工程师
	$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:"3-yf-jgsjs,1-yx-wxdzsjs"},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.empCode;
			       obj.text = obj.text || obj.userName;	
			       return obj;
			     });
				$("#form-submit [name=jggcs]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
					if(e.added){
						$("#form-submit [name=jggcsmc]").val(e.added.userName);
					}
				});
		}, "json");
});
</script>
<body>
<div class="page-content">
	<form id="form-submit">
		<div class="row">
			<div class="input-group">
				<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
				<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
				<input type="hidden" name="token" value="${token}" />
				<label class="input-group-btn">审核意见&nbsp;&nbsp;</label>
				<textarea id="spyj" name="spyj" class="autosize-transition form-control" rows="5"></textarea>
			</div>
		</div>
		<h5 class="header blue" style="margin-top:4px;">工程师选择</h5>
		<div class="space-4"></div>
		<div class="row" style="margin: 0px 8px;">
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">电子工程师&nbsp;&nbsp;</label>
					<input type="hidden" name="dzgcsmc" />
					<input type="text" name="dzgcs" class="form-control"/>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">电源工程师&nbsp;&nbsp;</label>
					<input type="hidden" name="dygcsmc" />
					<input type="text" name="dygcs" class="form-control"/>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">结构工程师&nbsp;&nbsp;</label>
					<input type="hidden" name="jggcsmc" />
					<input type="text" name="jggcs" class="form-control"/>
				</div>
			</div>
		</div>
		<div class="space-4"></div>
		<div class="row" align="center">
			<button id="btn-agree" type="button" class="btn btn-info btn-sm" onclick="javascript:approve(1);">
				<i class="icon-ok icon-on-right bigger-110"></i>
				通过
			</button>
			&nbsp;
			<button id="btn-reject" type="button" class="btn btn-danger btn-sm" onclick="javascript:approve(2);">
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
			<c:import url="/orderfzbg/orderSampleFzbg/viewPage" charEncoding="UTF-8">
				<%-- <c:param name="type">大货订单</c:param> --%>
			</c:import>
		</div>
	</form>
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	//审核
	function approve(type){
		var param = $("#form-submit").getFormData();
		param.approveType = type;
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/orderfzbg/orderSampleFzbg/approve'/>",
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