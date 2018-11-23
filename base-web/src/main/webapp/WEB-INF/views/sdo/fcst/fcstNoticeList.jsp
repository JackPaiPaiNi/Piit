<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div id="grid-parent" class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div id="search-box" class="widget-box">
				<div class="widget-header header-color-blue2">
					<h5>评审员公告</h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
					<div class="widget-toolbar no-border">
						<button id="btn-save" type="button" class="btn btn-success  btn-minier bigger">
							<i class="icon-save icon-on-right bigger-110"></i>
							保存
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-submit" class="form-search">
							<div class="row">
								<div class="col-xs-12 col-sm-10">
										<input type="hidden" name="id">
										<input type="hidden" name="oper">
										<textarea class="form-control" name="nr" rows="10"> </textarea>
								</div>
							
							</div>
						</form>
						<div class="space-4"></div>
					</div>
				</div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	<shiro:hasPermission name="fcst:fcstNotice:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$.bindAjax({
			url : "<c:url value='/fcst/fcstNotice/search'/>",
			action : "search"
		},function(response){
			$("#form-submit").setFormData(response);
			if(response==null||response.length==0||response[0].id==null || response[0].id==""){
				$("#form-submit [name=oper]").val("add");//权限:add
			}else{
				$("#form-submit [name=nr]").val(response[0].nr);
				$("#form-submit [name=id]").val(response[0].id);
				$("#form-submit [name=oper]").val("edit");//权限:edit
			}
		});
	});
	
	$("#btn-save").click(function(){
		var param = $("#form-submit").serializeObject();
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/fcst/fcstNotice/edit'/>",
					data:param,
					action:"save"
				},function(response){
				});
			}
		});
	});
</script>
</html>