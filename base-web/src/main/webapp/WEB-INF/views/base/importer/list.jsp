<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>

	<style type="text/css">
		.btn .btn-app{
			width: 120px!important;
		}
		.inputfile{
			font-size: 100px\9 !important;
			position:absolute\9 !important;
			left:-150px\9 !important;
		}
	</style>
</head>
<body>
<div class="breadcrumbs" id="breadcrumbs">
	<ul class="breadcrumb">
		<li>
			<i class="icon-home home-icon"></i>
			<a href="<c:url value='/' />">首页</a>
		</li>
		<li class="active">系统功能</li>
	</ul>
</div>

<div class="zheZhao"></div>
<div class="page-content">
	 <div class="page-header">
        <h1>
          系统功能
        </h1>
    </div> 
    <!-- /.page-header -->
	
	<div class="row">
		<div class="col-xs-12">	
			<!-- PAGE CONTENT BEGINS -->
			
			<form id="form-submit"  enctype="multipart/form-data">
				<h4 class="header blue">文件导入</h4>
				<div class="row" style="margin: 0px 8px;border-bottom: 1px dotted #e2e2e2;padding-bottom: 10px;">
					<div class="col-xs-6 col-sm-5 col-md-offset-3">
						<div class="form-group">
							<!-- <label class="col-sm-2 control-label no-padding-right"> 文件选择</label> -->
							<div class="col-sm-10">
								<input type="file" name="file" id="id-input-file-2" class="inputfile"/>
							</div>
						</div>
						<!-- <div class="input-group">
							<label class="input-group-btn">文件选择：&nbsp;&nbsp;</label>
							<input type="file" id="id-input-file-2" />
						</div> -->
					</div>
				</div>
			</form>
			
			<div class="widget-body">
				<div class="widget-main padding-8" id="buttons">
					 <!-- <div class="btn-group">
						  <button type="button" class="btn btn-success"><i class="icon-cloud-upload bigger-200"></i>公司数据</button>
						  <button type="button" class="btn btn-default"><i class="icon-cloud-upload bigger-200"></i>地区数据</button>
						  <button type="button" class="btn btn-default"><i class="icon-cloud-upload bigger-200"></i>预算科目数据</button>
						  <button type="button" class="btn btn-default"><i class="icon-cloud-upload bigger-200"></i>HR数据</button>
					 </div> -->
					 
					  <button type="button" id="company" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>公司</span></button>
					  <button type="button" id="businessItem" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>业务事项</span></button>
					  <button type="button" id="area" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>地区</span></button>
					  <button type="button" id="taxAuthority" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>税务机关</span></button>
					  <button type="button" id="operAccount" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>核算科目</span></button>
					  <button type="button" id="supplier" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>供应商</span></button>
					  <button type="button" id="supplierAccount" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>供应商账户</span></button>
					  <button type="button" id="supplierCompany" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>供应商公司</span></button>
					  <button type="button" id="cashFlowAccount" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>现金流科目</span></button>
					  <button type="button" id="bank" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>银行</span></button>
					  <button type="button" id="bankAccount" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>银行账户</span></button>
					  <button type="button" id="budgetAccount" class="btn btn-app btn-default btn-sm" style="width:120px;"><i class="icon-cloud-upload bigger-200"></i><span>预算科目</span></button>
					  <!-- <button type="button" class="btn btn-app btn-success btn-sm"><i class="icon-cloud-upload bigger-200"></i>公司数据</button> --> 
				</div>
			</div>
			
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 上传中... </label>
</span>
</body>
<script type="text/javascript">
var isEdit = false;
<shiro:hasPermission name="importer:edit">isEdit=true;</shiro:hasPermission>

jQuery(function($) {
	(!isEdit) ? $('#id-input-file-2').prop("disabled",true):"";
	$('#id-input-file-2').ace_file_input({
		no_file:'请选择上传文件 ...',
		btn_choose:'选择',
		btn_change:'重选',
		droppable:false,
		onchange:null,
		thumbnail:false, //| true | large
		whitelist:'xls|xlsx|xlsm'
		//blacklist:'xls|xlsx|xlsm'
		//onchange:''
		//
	}).change(function(){
		var name= $.trim($(".file-name").attr("data-title")).split(".")[0];
		$("#buttons button").each(function(){
			var btnName = $.trim($(this).children("span").html());
			if(name.indexOf(btnName)== -1){
				$(this).removeClass("btn-success").addClass("btn-default");
			}else{
				$(this).removeClass("btn-default").addClass("btn-success");
			}
		});
	});
	
	$("#buttons button").bind("click",function(){
		var isUpload = $(this).hasClass("btn-success");
		if(!isUpload){
			swal("","请选择匹配文件上传！","warning");
			return false;
		}else{
			if($("#id-input-file-2").val() == ""){
				swal("","请选择匹配文件上传！","warning");
				$("#buttons button").removeClass("btn-success").addClass("btn-default");
				return false;
			}
		} 
		var typeName = $(this).attr("id");
		//var param = $("#form-submit").serializeObject();
		if(typeName == "company"){
			importerRequest("company");
		}else if(typeName == "businessItem"){
			importerRequest("businessItem");
		}else if(typeName == "area"){
			importerRequest("area");
		}else if(typeName == "taxAuthority"){
			importerRequest("taxAuthority");
		}else if(typeName == "operAccount"){
			importerRequest("operAccount");
		}else if(typeName == "supplier"){
			importerRequest("supplier");
		}else if(typeName == "supplierAccount"){
			importerRequest("supplierAccount");
		}else if(typeName == "supplierCompany"){
			importerRequest("supplierCompany");
		}else if(typeName == "cashFlowAccount"){
			importerRequest("cashFlowAccount");
		}else if(typeName == "bank"){
			importerRequest("bank");
		}else if(typeName == "bankAccount"){
			importerRequest("bankAccount");
		}else if(typeName == "budgetAccount"){
			importerRequest("budgetAccount");
		}
	});
	
});

function importerRequest(type){
	$.loading();
	$.bindAjax({
		cache: false,
		url : "<c:url value='/base/"+type+"/import'/>",
		data : new FormData($('#form-submit')[0]),
		processData: false,
		contentType: false,
		action:"upload"
	},function(response){
		$.hideLoad();
	});
}
</script>
</html>