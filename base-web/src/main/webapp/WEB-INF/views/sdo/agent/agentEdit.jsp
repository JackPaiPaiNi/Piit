<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %> 
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>   	
</head>
	 <%
		String id = request.getParameter("id");
	 %>
<body>
<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<div class="row" style="margin: 0px 8px;">
						<input type="hidden" name="id"/>
						<input type="hidden" name="oper"/>
						<input type="hidden" name="token" value="${token}"/>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">委托信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">委托人名称&nbsp;&nbsp;</label> 
								<input type="text" name="wtrmc" value="${wtrmc}" class="form-control" readOnly/>
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">委托人账号&nbsp;&nbsp;</label> 
								<input type="text" name="wtr" value="${wtrid}" class="form-control" readOnly/>
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">被委托人名称&nbsp;&nbsp;</label>
								<input type="text" id="bwtrmc" name="bwtrmc" onfocus="this.blur()" class="form-control  parent-node"/>
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">被委托人账号&nbsp;&nbsp;</label> 
								<input type="text" name="bwtr" class="form-control" readOnly/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-8 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">被委托人角色&nbsp;&nbsp;</label> 
								<input type="text" name="bwtrjs" class="form-control" readOnly/>
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">委托开始时间&nbsp;&nbsp;</label> 
								<input type="text" name="kssj" class="form-control date-picker"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">委托结束时间&nbsp;&nbsp;</label> 
								<input type="text" name="jssj" class="form-control date-picker"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-sm-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">委托备注&nbsp;&nbsp;</label>
								<textarea name="wtbz" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-8"></div>
					<div class="row" style="margin: 0px 8px; text-align: center;">
						<div class="col-xs-6 col-sm-12">
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
						</div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
	<!-- /.page-content -->
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
</span>
</body>
<script type="text/javascript">
	// 变量定义开始
	var id = "<%=id%>";
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	// 不可编辑
	var isEdit = false;
	// 权限判断
	<shiro:hasPermission name="agent:agent:edit">isEdit = true;</shiro:hasPermission>

	$(function($){
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
	  	// 页面id赋值
		$("#form-submit [name=id]").val(id);
		//被委托人选择
	  	$("#bwtrmc").parent().click(function(){
	  		bindBwtr();
		});
	  	//初始化页面数据
		bindFormData(id);
		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
		//返回按钮
		$('#btn-back').click(function(){
			window.history.back(-1);
		});
	});
	/**************************************************function开始区域************************************************/
	// 发起人选择
	function bindBwtr(){
		$.tableDialogPage({
			title:"被委托人选择",
			searchCond:[{"name":"被委托人","value":"bwtr"}],
			colModel:[{name:'id', index:'id', label:'ID',hidden:true}, 
			          {name:'bwtr', index:'bwtr', label:'被委托人账号', width:40},
		 	          {name:'bwtrmc', index:'bwtrmc', label:'被委托人名称', width:40}, 
					  {name:'bwtrjs', index:'bwtrjs', label:'角色', width:100}],
			url:"<c:url value='/pub/widget/findBwtrxx'/>"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=bwtr]").val(rows.bwtr);
					$("input[name=bwtrmc]").val(rows.bwtrmc);
					$("input[name=bwtrjs]").val(rows.bwtrjs);
				}else{
					$("input[name=bwtr]").val("");
					$("input[name=bwtrmc]").val("");
					$("input[name=bwtrjs]").val("");
				}
			}
		});
	}
	//初始化页面数据
	function bindFormData(id){	
		//view or edit
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/agent/agent/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$("#form-submit [name=oper]").val("edit");//编辑权限
			});
		}else{
			//初始化页面参数
			$("#form-submit [name=id]").val("");//ID
			$("#form-submit [name=oper]").val("add");//权限:add
			$("#form-submit [name=zt]").val("1");//PI状态:草稿
		}
	}
	//校验
	$('#form-submit').validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		focusInvalid: false,
		focusCleanup: false,
		ignore: 'input[type=hidden]',
		rules: {
			bwtrmc : 'required',
			kssj : 'required',
			jssj : 'required'
		},
		messages: {
			bwtrmc : '被委托人不能为空！',
			kssj : '委托开始时间不能为空！',
			jssj : '委托结束时间不能为空'
		},
        showErrors: function(errorMap, errorList) {  
        	$('.input-group').removeClass('has-error');
            if(errorList.length != 0){
	            var msg = "";  
	            $.each( errorList, function(i,v){  
	              msg += (v.message+"\r\n"); 
	              $(v.element).closest('.input-group').addClass('has-error');
	            });  
            	swal({title: "校验不通过！",text: msg,type: "error"},	function(){
					return false;
				});
            }
        }
	});
	//提交
	function submit(){
		if(!$('#form-submit').valid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/agent/agent/submit'/>",
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