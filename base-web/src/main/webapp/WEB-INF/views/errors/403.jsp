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
							<i class="icon-sitemap"></i>
							403
						</span>
						你没有权限访问
					</h1>

					<hr />
					<h3 class="lighter smaller">你需要拥有此路径的访问权限!</h3>

					<div class="space"></div>

					<div>
						<h4 class="lighter smaller">你可以尝试:</h4>

						<ul class="list-unstyled spaced inline bigger-110 margin-15">
							<li>
								<i class="icon-hand-right blue"></i>
								确认你当前拥有的权限
							</li>
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
					<div class="space"></div>
				</div>
			</div>

			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
</div><!-- /.page-content -->
</body>
</html>