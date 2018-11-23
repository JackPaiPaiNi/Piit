<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %> 
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
		<div id="gcbfjxx" class="row" style="margin: 0px 0px;display:none">
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm" style="width:20px;">
					<label class="input-group-addon">附件&nbsp;&nbsp;</label>
					<div class="form-control" style="text-align:left;">
						<input id="gcbfj" type="file" class="form-control">
					</div>
					<input type="hidden" name="gcbfj" />
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div id="fjxx">
					<ul class="list-unstyled spaced"></ul>
				</div>
				<div id="multiFileQueue"> </div>
			</div>
		</div>
		<div class="row">
			<!-- c:import的url默认接受父页面的参数，如果需要添加参数用c:param -->
			<c:import url="/order/orderSpo/viewPage" charEncoding="UTF-8">
				<%-- <c:param name="type">大货订单</c:param> --%>
			</c:import>
		</div>
	</form>
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
$(function($){
	// 附件控件
	$('#gcbfj').uploadify($.extend($.lfsUploadOptions, {
		width : $('#gcbfj').parent().width(),
		queueID : 'multiFileQueue',// 上传队列容器
		multi : true,
		onUploadSuccess : function(file, data, response) {
			if (response) {
				result = $.parseJSON(data);
				if ("SUCCESS" == result.status) {
					var fjUl = $('#fjxx ul');
					var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
					var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
					fjLi.append(tmpUrl);
					fjUl.append(fjLi);
					$("#form-submit [name=gcbfj]").val($('#fjxx').html());
				} else {// INVALID or ERROR
					alert(result.msg);
				}
			}
		}
	}));
	$('#fjxx').on("click", "li .icon-remove", function(){
		var thisLi = $(this).parent("li");
		$("body").bindSweetAlert({
			title : "确定要删除附件吗?",
			closeOnConfirm: true
		}, {
			callback : function() {
				thisLi.remove();
				$("#form-submit [name=gcbfj]").val($('#fjxx').html());
			}
		});
	}); 
	var id = $("input[name='id']").val();
	$.bindAjax({
		url : "<c:url value='/order/orderSpo/findDqclrById'/>",
		data : {id : id},
		action : "search"
	},function(response){
		if(response != "" && response != null){
			if(response.czzw == "工程科专员" || response.czzw == "工程技术专员"){
				$("#gcbfjxx").show();
			}
		}
	});
});

function approve(type){
	var param = $("#form-submit").getFormData();
	param.approveType = type;
	$("body").bindSweetAlert({
		title:"确定要提交吗?"
	},{
		callback:function(){
			$.bindAjax({
				url:"<c:url value='/order/orderSpo/approve'/>",
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