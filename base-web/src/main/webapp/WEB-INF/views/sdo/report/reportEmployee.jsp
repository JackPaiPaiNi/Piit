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
				
			<div class="widget-box">
				<div class="widget-header header-color-blue2">
					<h5>查询条件</h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
					<div class="widget-toolbar no-border">
						<button id="btn-search" type="button" class="btn btn-info btn-minier bigger">
							<i class="icon-search icon-on-right"></i>
							查询
						</button>
						&nbsp;
						<button id="export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">工号&nbsp;&nbsp;</label>
										<input type="text" name="empCode" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">姓名&nbsp;&nbsp;</label>
										<input type="text" name="name" class="form-control"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	<%-- <div class="row">
		<!-- c:import的url默认接受父页面的参数，如果需要添加参数用c:param -->
		<c:import url="/report/employeeReport/report" charEncoding="UTF-8">
			<c:param name="type">大货订单</c:param>
		</c:import>
	</div> --%>
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	$(function($) {
		// 查询
		$("#btn-search").click(function(){
			window.open("<c:url value='/report/employeeReport/report'/>?empCode=" + $("input[name='empCode']").val() +
					"&name=" + $("input[name='name']").val());
	    });
		// 导出
		$("#export").click(function(){
		    
		});
		
	});
</script>
</html>