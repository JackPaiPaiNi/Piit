<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />

<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="bookmark" type="image/x-icon" /> 
<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="icon" type="image/x-icon" /> 
<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="shortcut icon" type="image/x-icon" /> 
	<title>创维海外营销SDO</title>
	<meta name="keywords" content="SDO" />
	<meta name="description" content="SDO" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.ace.css" />
	<!-- fonts -->
	<!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" /> -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/fonts.googleapis.com.css" />  <!-- laill -->
	<!-- ace styles -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/ace.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/ace-skins.min.css" />
	<script src="${pageContext.request.contextPath}/static/js/ace-extra.min.js"></script>
	<!-- basic scripts -->
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
		window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js'>"+"<"+"script>");
	</script>
	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='${pageContext.request.contextPath}/static/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
	</script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/typeahead-bs2.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.sparkline.min.js"></script>
	<!-- ace scripts -->
	<script src="${pageContext.request.contextPath}/static/js/ace-elements.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			// 如果在框架或在对话框中，则弹出提示并跳转到首页
			if(self.frameElement && self.frameElement.tagName == "IFRAME"){
				//alert('未登录或登录超时。请重新登录，谢谢！');
				top.location = location;
			}
			
			$( "#loginSubmit" ).click(function() {
				delCookie("action");
        		delCookie("menuStatus");
				$( "#loginForm" ).submit();
			});
			
			$("#passd").keypress(function (event) {
			    var key = event.which;
			    if (key == 13) {
			    	delCookie("action");
	        		delCookie("menuStatus");
			    	$( "#loginForm" ).submit();
			    }
			});
		})

		function show_box(id) {
			jQuery('.widget-box.visible').removeClass('visible');
			jQuery('#'+id).addClass('visible');
		}
		
		//读取cookies 
        function getCookie(name){ 
            var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
         
            if(arr=document.cookie.match(reg))
         
                return unescape(arr[2]); 
            else 
                return null; 
        } 
		
		//删除cookies 
        function delCookie(name){ 
            var exp = new Date(); 
            exp.setTime(exp.getTime() - 10); 
            var cval=getCookie(name); 
            if(cval!=null) 
                document.cookie= name + "="+cval+ ";Path=/base-web"+";expires="+exp.toGMTString(); 
        } 
	</script>
</head>
<body class="login-layout" style="overflow:hidden;">
<div class="main-container">
	<div class="main-content">
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div class="login-container" style="margin-top:140px;">
					<div class="center">
						<h1>
							<!-- <i class="icon-globe green" style="font-size:33px;"></i> -->
							<img style="width:300px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_local_small.png">
							<br>
							<span class="white">海外营销SDO</span>
						</h1>
						<div class="space-4"></div>
						<!-- <h4 class="blue">&copy;&nbsp;&nbsp;版权所有&nbsp;&nbsp;海航集团</h4> -->
					</div>

					<div class="space-6"></div>

					<div class="position-relative">
						<div id="login-box" class="login-box visible widget-box no-border">
							<div class="widget-body">
								<div class="widget-main">
									<h4 class="header lighter bigger">
										<i class="icon-coffee blue"></i>
										请输入您的登录信息
									</h4>

									<div class="space-6"></div>
									<form id="loginForm" name="loginForm" method="post">
										<c:if test="${! empty error}">
											<div class="alert alert-danger"><strong><i class="icon-remove"></i>登录失败！</strong>${error}</div>
										</c:if>
										<fieldset>
											<label class="block clearfix">
															<span class="block input-icon input-icon-right">
																<input type="text" name="username" class="form-control" placeholder="用户名" />
																<i class="icon-user"></i>
															</span>
											</label>

											<label class="block clearfix">
															<span class="block input-icon input-icon-right">
																<input type="password" id="passd" name="password" class="form-control" placeholder="密码" />
																<i class="icon-lock"></i>
															</span>
											</label>

											<div class="space"></div>

											<div class="clearfix">
												<!-- <label class="inline">
													<input type="checkbox" name="rememberMe" value="true" class="ace" />
													<span class="lbl"> 记住我</span>
												</label>
												<button id="loginSubmit" type="button" class="width-35 pull-right btn btn-sm btn-primary">
													<i class="icon-key"></i>
													登录
												</button> --> 

												<div class="center">
													<button id="loginSubmit" type="button" class="width-35 btn btn-sm btn-primary">
														<i class="icon-key"></i>
														登录
													</button>
												</div>
											</div>

											<div class="space-4"></div>
											<div class="left">
											系统支持浏览器：IE11，Edge，FireFox（建议最新版本），Chrome（建议最新版本）
											</div>
										</fieldset>
									</form>
								</div><!-- /widget-main -->

								<div class="toolbar clearfix">
									<!-- <div>
										<a href="javascript:void(0);" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
											<i class="icon-arrow-left"></i>
											我忘记了密码
										</a>
									</div> -->

									<!-- <div>
										<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
											我要注册
											<i class="icon-arrow-right"></i>
										</a>
									</div> -->
								</div>
							</div><!-- /widget-body -->
						</div><!-- /login-box -->

						<div id="forgot-box" class="forgot-box widget-box no-border">
							<div class="widget-body">
								<div class="widget-main">
									<h4 class="header red lighter bigger">
										<i class="icon-key"></i>
										重置密码
									</h4>

									<div class="space-6"></div>
									<p>
										输入接收新密码的邮件地址
									</p>

									<form>
										<fieldset>
											<label class="block clearfix">
															<span class="block input-icon input-icon-right">
																<input type="email" class="form-control" placeholder="Email" />
																<i class="icon-envelope"></i>
															</span>
											</label>

											<div class="clearfix">
												<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
													<i class="icon-lightbulb"></i>
													请发送给我!
												</button>
											</div>
										</fieldset>
									</form>
								</div><!-- /widget-main -->

								<div class="toolbar center">
									<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
										返回登录
										<i class="icon-arrow-right"></i>
									</a>
								</div>
							</div><!-- /widget-body -->
						</div><!-- /forgot-box -->

						<div id="signup-box" class="signup-box widget-box no-border">
							<div class="widget-body">
								<div class="widget-main">
									<h4 class="header green lighter bigger">
										<i class="icon-group blue"></i>
										新用户注册
									</h4>

									<div class="space-6"></div>
									<p> 输入信息: </p>

									<form>
										<fieldset>
											<label class="block clearfix">
															<span class="block input-icon input-icon-right">
																<input type="email" class="form-control" placeholder="Email" />
																<i class="icon-envelope"></i>
															</span>
											</label>

											<label class="block clearfix">
															<span class="block input-icon input-icon-right">
																<input type="text" class="form-control" placeholder="用户名" />
																<i class="icon-user"></i>
															</span>
											</label>

											<label class="block clearfix">
															<span class="block input-icon input-icon-right">
																<input type="password" class="form-control" placeholder="密码" />
																<i class="icon-lock"></i>
															</span>
											</label>

											<label class="block clearfix">
															<span class="block input-icon input-icon-right">
																<input type="password" class="form-control" placeholder="再次输入密码" />
																<i class="icon-retweet"></i>
															</span>
											</label>

											<label class="block">
												<input type="checkbox" class="ace" />
															<span class="lbl">
																我同意
																<a href="javascript:void(0);">用户协议</a>
															</span>
											</label>

											<div class="space-24"></div>

											<div class="clearfix">
												<button type="reset" class="width-30 pull-left btn btn-sm">
													<i class="icon-refresh"></i>
													重置
												</button>

												<button type="button" class="width-65 pull-right btn btn-sm btn-success">
													注册
													<i class="icon-arrow-right icon-on-right"></i>
												</button>
											</div>
										</fieldset>
									</form>
								</div>

								<div class="toolbar center">
									<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
										<i class="icon-arrow-left"></i>
										返回登录
									</a>
								</div>
							</div><!-- /widget-body -->
						</div><!-- /signup-box -->
					</div><!-- /position-relative -->
				</div>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div>
</div><!-- /.main-container -->
</body>
</html>