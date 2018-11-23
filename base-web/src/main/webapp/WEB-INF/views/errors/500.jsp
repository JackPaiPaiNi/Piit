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
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->

			<div class="error-container">
				<div class="well">
					<h1 class="grey lighter smaller">
						<span class="blue bigger-125">
							<i class="icon-random"></i>
							500
						</span>
						系统异常
					</h1>

					<hr />
					<h3 class="lighter smaller">
						我们正在
						<i class="icon-wrench icon-animated-wrench bigger-125"></i>
						全力处理！
					</h3>

					<div class="space"></div>

					<div>
						<h4 class="lighter smaller">你可以尝试:</h4>

						<ul class="list-unstyled spaced inline bigger-110 margin-15">
							<li>
								<i class="icon-hand-right blue"></i>
								仔细阅读操作手册
							</li>

							<li>
								<i class="icon-hand-right blue"></i>
								告诉我们发生此错误的详细步骤和情况
							</li>
						</ul>
					</div>

					<hr />
					<div class="row">
						<div class="col-xs-12 widget-container-span">
							<div class="widget-box transparent collapsed">
								<div class="widget-header">
									<h4 class="lighter">异常信息</h4>

									<div class="widget-toolbar no-border">
										<a href="#" data-action="collapse">
											<i class="icon-chevron-down"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<%-- ${ex} --%>
										${exTrace}
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>

			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
</div><!-- /.page-content -->
</body>
</html>