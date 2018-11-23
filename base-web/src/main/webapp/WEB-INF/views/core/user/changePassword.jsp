<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
</head>
<body>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
				<h4 align="left" class="header blue" >海外SDO系统修改密码<font align="center" style="color:red">（注意:如果您的工号和原域账号一致，本次密码修改会同步更改您的创维邮箱密码！）</font></h4>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">账号&nbsp;&nbsp;</label> 
								<input type="text" name="loginAcct" value="${user.loginAcct}" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">姓名&nbsp;&nbsp;</label> <input
									type="text" name="userName" value="${user.userName}"  class="form-control skydisabled" disabled="disabled"  />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">邮箱&nbsp;&nbsp;</label> <input
									type="text" name="email" value="${user.email}"  class="form-control skydisabled" disabled="disabled"  />
							</div>
						</div>
				     </div>
				     <div class="space-4"></div>
				     <div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">旧密码&nbsp;&nbsp;</label> 
								<input type="password" name="oldPassword" class="form-control"  />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">新密码&nbsp;&nbsp;</label> 
								<input type="password" name="newPassword" class="form-control"  />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">确认密码&nbsp;&nbsp;</label> <input
									type="password" name="password" class="form-control"  />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" align="center">
						<button id="btn-agree" type="button" class="btn btn-info btn-sm" onclick="javascript:save();">
							<i class="icon-save icon-on-right bigger-110"></i> 保存
						</button>
						&nbsp;
						<button id="btn-agree" type="button" class="btn  btn-sm" onclick="javascript:goback();">
							<i class="icon-undo icon-on-right bigger-110"></i> 关闭
						</button>
					</div>
				
				</form>
			</div>
		</div>
	</div>
	<!-- /.page-content -->
</body>
<script type="text/javascript">
//保存
function save(){
	    if(checkPswd()){
	    	var param = $('#form-submit').getFormData();
	 		$("#save").bindSweetAlert({
	 			title:"确定要保存吗?"
	 		},{
	 			callback:function(){
	 				$.bindAjax({
	 					url:"<c:url value='/core/pswd/reset'/>",
	 					data:param,
	 					action:"save",
	 					text:"",
	 				},function(response){		
	 					goback();
	 				});
	 			}
	 		});
	    }; 
}

function goback(){
	window.close();
	window.open("<c:url value='/logout'/>"); 
}
//检查密码是否一致
function  checkPswd(){
	 var strength ;
	 var password0=$("#form-submit [name=oldPassword]").val();
	 var password1=$("#form-submit [name=newPassword]").val();
	 var password2=$("#form-submit [name=password]").val();
	 if(!password0 || password0.length==0 ){
		 swal("","请填写旧密码!","warning");
		 return false; 
	 }
	 if(!password1 || password0.length==0 ){
		 swal("","请填写新密码!","warning");
		 return false; 
	 }
	 if(!password2 || password0.length==0 ){
		 swal("","请确认密码!","warning");
		 return false; 
	 }
	 if(password1 != password2){
		 swal("","新密码和确认密码不一致!","warning");
		 return false; 
	 }
	 var strength = getPasswordStrength(password2);
	 if(!checkpwdlevel(strength)){
		 return false; 
	 }else{
		 return true;
	 }
}

//获取密码强度
function getPasswordStrength(password){
	  if(password.length<8){
		  return 0;
	  }
	  var strength=0;
	  $([/.{6,}/,/[0-9]+/,/[a-z]+/,/[A-Z]+/,/[^0-9a-zA-Z]+/]).each(function(i,o){
	      if(o.test(password)) strength++;
	  });
	  return strength;
	}
	
	
//根据密码强度
function checkpwdlevel(level){
	if(level<4){
		swal("弱密码","注意：密码需包含大小写和数字且长度为8位以上（含8位）","warning");
		return false;
	}else{
		return true;
	}
}



	
</script>
</html>