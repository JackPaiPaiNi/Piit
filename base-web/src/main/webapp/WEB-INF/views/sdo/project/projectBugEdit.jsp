<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<%@include file="/WEB-INF/views/index/lfs.jsp"%>

</head>
<%
	String id = request.getParameter("id");
	String taskId = request.getParameter("taskId");
%>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form id="form-submit">
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-9">
							<div class="input-group input-group-sm"></div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-save" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp;
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: -2px;">问题详细信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<input type="hidden" name="id" />
						<input  type="hidden" name="oper" />
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								 <label class="input-group-addon">问题单号&nbsp;&nbsp;</label>
								 <input type="text" name="wtdh" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">提出人&nbsp;&nbsp;</label> 
								<input type="hidden" name="tcr" />
							    <input type="text" name="tcrmc" readonly class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">提出部门&nbsp;&nbsp;</label> 
								<input type="hidden" name="tcbm" />
								<input type="text" name="tcbmmc"  readonly class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
					   <div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">提出时间&nbsp;&nbsp;</label> 
								<input type="text" name="tcsj" class="form-control date-picker"  readonly/> 
									<span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">状态&nbsp;&nbsp;</label> 
								<select role="select" name="zt" size="1" class="form-control skyselect" >
									${fns:loadDictOption('BUG_ZT')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">模块名称&nbsp;&nbsp;</label> 
							    <input type="text" name="cdmc" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-sm-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">问题描述&nbsp;&nbsp;</label>
								<textarea name="wtms" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<!-- 审批日志 -->
					<div class="space-4"></div>
					<h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
					<div class="space-4"></div>
					<c:import url="/pub/showLog/projectBug" charEncoding="UTF-8" />
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
	<span class="loading-indicator"> <label><i
			class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
	</span>
</body>
<script type="text/javascript">
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	<shiro:hasPermission name="project:projectBug:view">isEdit=true;</shiro:hasPermission>
	$(function($){
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
		//初始化页面数据
		 bindFormData(id) ;
	});
	//页面数据初始化
	function bindFormData(id){
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/project/projectBug/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$('#form-submit [name=zt]').prop('disabled','disabled');
			});
		}else{
			$('#form-submit [name=zt]').select2('val',1);
			$('#form-submit [name=zt]').prop('disabled','disabled');
		}
	}
	//保存
	function save(){
     $('#form-submit [name=zt]').removeProp('disabled').removeAttr('disabled');	
	 var param = $("#form-submit").getFormData();	
	 if(param.id.length == 0){
		 param.oper="add"
	 }else{
		 param.oper="edit"
	 }
	 $("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/project/projectBug/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=tcr]").val(result.tcr);
					$("#form-submit [name=tcrmc]").val(result.tcrmc);
					$("#form-submit [name=tcbm]").val(result.tcbm);
					$("#form-submit [name=tcbmmc]").val(result.tcbmmc);
					$("#form-submit [name=tcsj]").val(result.tcsj);
					$("#form-submit [name=wtdh]").val(result.wtdh);
					$('#form-submit [name=zt]').prop('disabled','disabled');
				});
			} 
		});
	}
	//提交
	function submit(){
		 $('#form-submit [name=zt]').removeProp('disabled').removeAttr('disabled');	
		 var param = $("#form-submit").getFormData();	
		 if(param.id.length == 0){
			 param.oper="add"
		 }else{
			 param.oper="edit"
		 }
		 $("body").bindSweetAlert({
				title:"确定要保存吗?"
			},{
				callback:function(){
					$.bindAjax({
						url:"<c:url value='/project/projectBug/submit'/>",
						data:param,
						action:"save"
					},function(response){
						var result = JSON.parse(response);
						$("#form-submit [name=id]").val(result.id);
						$("#form-submit [name=tcr]").val(result.tcr);
						$("#form-submit [name=tcrmc]").val(result.tcrmc);
						$("#form-submit [name=tcbm]").val(result.tcbm);
						$("#form-submit [name=tcbmmc]").val(result.tcbmmc);
						$("#form-submit [name=tcsj]").val(result.tcsj);
						$("#form-submit [name=wtdh]").val(result.wtdh);
						$('#form-submit [name=zt]').prop('disabled','disabled');
					});
				} 
			});
	}
	// 保存
	$("#btn-save").click(function(){
		save();
    });
	//提交
	$("#btn-submit").click(function(){
		submit();
    });
	//返回
	$("#btn-back").click(function(){
		window.history.back(-1);
    });
	
</script>
</html>