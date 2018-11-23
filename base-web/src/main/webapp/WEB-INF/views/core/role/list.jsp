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
											<label class="input-group-addon">角色编号&nbsp;&nbsp;</label>
											<input type="text" name="code" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">角色名称&nbsp;&nbsp;</label>
											<input type="text" name="name" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">角色类型&nbsp;&nbsp;</label>
											<select role="select" id="type" name="type" size="1" class="form-control skyselect">
												<option value="">--请选择--</option>
												<option value="01">菜单角色</option>
												<option value="02">流程角色</option>
												<option value="03">预警角色</option>
											</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态&nbsp;&nbsp;</label>
											<select role="select" id="status" name="status" size="1" class="form-control skyselect">
												<option role="option" value="">--请选择--</option>
												<option role="option" value="1">启用</option>
												<option role="option" value="0">禁用</option>
											</select>
										</div>
									</div>
								</div>
								<!-- <div class="space-4"></div>
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-addon">描述&nbsp;&nbsp;</label>
											<input type="text" name="description" class="form-control"/>
										</div>
									</div>
								</div> -->
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
	var editurl = "<c:url value='/core/role/editPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="role:edit">isEdit=true;</shiro:hasPermission>
	
	jQuery(function($) {
		$(".skyselect").select2();
		jQuery(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/core/role/search'/>",
			editurl: "<c:url value='/core/role/edit'/>",
			pager: pager_selector,
			gridParent:"#grid-parent",
			formSearch:"#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id',index:'id',label:'序号',hidden: true,width:60, editable:false, sorttype:"int"},
				{name:'code',index:'code',label:'角色编码', width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'name',index:'name',label:'角色名称', width:250, editoptions:{size:"20",maxlength:"30"}},
				{name:'type',index:'type',label:'角色类型', width:150,edittype:"select",formatter:"select", editoptions:{value:"01:菜单角色;02:流程角色;03:预警角色"}},
				{name:'status',index:'status',label:'状态', width:70, edittype:"select",formatter: "select",editoptions: {value:"1:启用;0:禁用"}},
			],
			sortname: "code",
			sortorder: "asc"
		},{
			add:isEdit,
			addfunc:addfunc,
			view:false,
			del:isEdit,
			edit:isEdit,
			editfunc: editfunc
		});
	
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