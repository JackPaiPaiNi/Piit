<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>    

<style type="text/css">
	.modalClearBtn{
		float:left;
	}
</style>
</head>
<body>

<div class="page-content">
	<div class="row">
		<div id="grid-parent" class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
				
			<div id="search-box" class="widget-box">
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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">用户帐号&nbsp;&nbsp;</label>
											<input type="text" name="loginAcct" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">&nbsp;&nbsp;用户名&nbsp;&nbsp;&nbsp;</label>
											<input type="text" name="userName" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">工号&nbsp;&nbsp;</label>
											<input type="text" name="empCode" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">所属公司&nbsp;&nbsp;</label>
											<input type="hidden" name="compCode" class="form-control"/>
											<input type="text" name="compCodeName" onfocus="this.blur()" class="form-control parent-node" style="cursor: pointer!important;"/>
											<span class="input-group-addon">
												<i class="icon-search bigger-110"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态&nbsp;&nbsp;</label>
											<select role="select" id="status" name="status" size="1" class="form-control skyselect">
												<option role="option" value="">--请选择--</option>
												<option role="option" value="1">启用</option>
												<option role="option" value="0">禁用</option>
											</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">用户类型&nbsp;&nbsp;</label>
											<select name="type" class="form-control skyselect">
												<option value="">--请选择--</option>
												<option value="01">内部员工</option>
												<option value="02">外部员工</option>
											</select>
										</div>
									</div>
								</div>
						</form>
						<div class="space-4"></div>
					</div>
				</div>
			</div>
			
			<table id="grid-table"></table>
			
			<div id="grid-pager"></div>

			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>

<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var editurl = "<c:url value='/core/user/editPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="user:edit">isEdit=true;</shiro:hasPermission>
	
	jQuery(function($) {
		$(".skyselect").select2();
		$("input[name=compCodeName]").bindTreeDialog({
			title:"",
			url : "<c:url value='/core/organization/loadTree'/>",
			searchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"}
		},{
			callback:function(node){
				if(node != "" && node != undefined){
					$("input[name=compCode]").val(node.id);
					$("input[name=compCodeName]").val($.trim(node.name));
				}else if(node == ""){
					$("input[name=compCode]").val("");
					$("input[name=compCodeName]").val("");
				}
			}
		});
		
		jQuery(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/core/user/search'/>",
			editurl: "<c:url value='/core/user/edit'/>",
			pager: pager_selector,
			gridParent:"#grid-parent",
			formSearch:"#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			sortname: "loginAcct",
			sortorder: "ASC",
			colModel: [
				{name:'id',index:'id',label:'序号', hidden: true, width:60},
				{name:'loginAcct',index:'loginAcct',label:'用户帐号', width:100},
				{name:'userName',index:'userName',label:'用户名', width:100},
				{name:'empCode',index:'empCode',label:'工号', width:100},
				{name:'email',index:'email',label:'邮箱', width:200},
				{name:'compName',index:'compName',label:'所属组织', width:200},
				{name:'roles',index:'roles',label:'角色', width:200},
				{name:'type',index:'type',label:'用户类型', width:80, edittype:"select",formatter: "select",editoptions: {value:"01:内部员工;02:外部员工"}},
				{name:'status',index:'status',label:'状态', width:80, edittype:"select",formatter: "select",editoptions: {value:"1:启用;0:禁用"}}
			]
		},{
			add:isEdit,
			addfunc:addfunc,
			del:false,
			view:false,
			edit:isEdit,
			editfunc: editfunc
		});
		
		jQuery(grid_selector).jqGrid('navGrid','hideCol',"id");
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		//add
		function addfunc(){
			location.href = editurl;
		}
		
		//edit
		function editfunc(){
			var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			location.href = editurl + "?id=" + selr;
		}
		
	});
</script>
</html>