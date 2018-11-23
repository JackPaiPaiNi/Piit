<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %> 
	<%
		String taskName = request.getParameter("taskName");
	%>
</head>
<body>
<div class="zheZhao"></div>
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
		<div class="space-4"></div>
		<div id="gcjsbxz" class="row" style="display:none;">
			<div class="input-group">
				<label class="input-group-btn">流程选择&nbsp;&nbsp;</label>
				<input type="radio" class="skyradio" name="gcjsb" value="1">转工程技术部1&nbsp;
				<input type="radio" class="skyradio" name="gcjsb" value="2" checked="checked">转工程技术部2&nbsp;
				<input type="radio" class="skyradio" name="gcjsb" value="0">转下一部门&nbsp;
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
			<c:import url="/art/artSkyworth/viewPage" charEncoding="UTF-8">
				<c:param name="sfView">1</c:param>
			</c:import>
		</div>
	</form>
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
var taskName = "<%=taskName%>";

$(function($){
	//查找当前处理人
	var sfBg = $("input[name='sfBg']").val();
	if(sfBg != 1 && taskName == "工程技术部"){
		$('#form-submit [name=gcjsb]').removeProp('disabled').removeAttr('disabled'); 
		$("#gcjsbxz").show();
	}
	//根据当前环节去判断，为工程技术部审批时，屏蔽“驳回”按钮
	  if(taskName == "工程技术部1"){
		$("#btn-reject").hide();
	  }else{
		  $("#btn-reject").show();
	  } 
});

function approve(type){
	 var param = $("#form-submit").getFormData();
	 param.approveType = type; 
	 $("body").bindSweetAlert({
		title:"确定要提交吗?"
	},{
		callback:function(){ 
			 $.bindAjax({
				url:"<c:url value='/art/artSkyworth/approve'/>",
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