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
		<div class="row" >
			<input type="hidden" name="token" value="${token}"/>
			<input type="hidden" name="gcs" value="${gcs}"/>
			<div class="col-xs-6 col-sm-4 showJgzjh" style="display:none">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">结构组件号&nbsp;&nbsp;</label>
					<input type="text" name="jgzjh" class="form-control"/>
				</div>
			</div>
			<div class="col-xs-6 col-sm-4 showDzzjh" style="display:none">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">主板组件号&nbsp;&nbsp;</label>
					<input type="text" name="dzzjh" class="form-control"/>
				</div>
			</div>
			<div class="col-xs-6 col-sm-4 showDyzjh" style="display:none">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">电源组件号&nbsp;&nbsp;</label>
					<input type="text" name="dyzjh" class="form-control"/>
				</div>
			</div>
		</div>
		<!-- <div class="space-4"></div>
		<div class="row" >
			<div class="col-xs-6 col-sm-4">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">恒流组件号&nbsp;&nbsp;</label>
					<input type="text" name="hlzjh" class="form-control"/>
				</div>
			</div>
			<div class="col-xs-6 col-sm-4">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">建议样机数量&nbsp;&nbsp;</label>
					<input type="text" name="jyyjsl" class="form-control"/>
				</div>
			</div>
		</div> -->
		<div class="space-4"></div>
		<div class="row">
			<div class="input-group">
				<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
				<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
				<label class="input-group-btn">审核意见&nbsp;&nbsp;</label>
				<textarea id="spyj" name="spyj" class="autosize-transition form-control" rows="5"></textarea>
			</div>
		</div>
		<div class="space-4"></div>
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
//初始化
$(function($){
	var gcs = $("#form-submit [name=gcs]").val();
	if(gcs == "jggcs"){
		$('.showJgzjh').show();
	}else if(gcs == "dzgcs"){
		$('.showDzzjh').show();
	}else if(gcs == "dygcs"){
		$('.showDyzjh').show();
	}
});
function approve(type){
	var jgzjh = $("#form-submit [name=jgzjh]").val();
	var dzzjh = $("#form-submit [name=dzzjh]").val();
	var dyzjh = $("#form-submit [name=dyzjh]").val();
	if(jgzjh.length == 0 && dzzjh.length == 0 && dyzjh.length == 0){
		swal('','请填写相关组件号！', "warning");
		return ;
	}
	var param = $("#form-submit").serializeObject();
	param.approveType = type;
	$("#save").bindSweetAlert({
		title:"确定要提交吗?"
	},{
		callback:function(){
			$.bindAjax({
				url:"<c:url value='/mdm/pidInfo/pidAddInfoSave'/>",
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