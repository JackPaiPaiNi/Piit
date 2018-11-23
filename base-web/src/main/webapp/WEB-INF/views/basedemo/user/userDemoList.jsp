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
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
													<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">用户账号&nbsp;&nbsp;</label>
										<input type="text" name="loginAcct" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">用户名&nbsp;&nbsp;</label>
										<input type="text" name="userName" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">工号&nbsp;&nbsp;</label>
										<input type="text" name="empCode" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">所属公司&nbsp;&nbsp;</label>
										<input type="text" name="compCode" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">状态&nbsp;&nbsp;</label>
										<select role="select" name="status" size="1" class="form-control">
											${fns:loadDictOption('COMPANY_STATUS')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">类型&nbsp;&nbsp;</label>
										<input type="text" name="type" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-2 col-md-offset-10">
									<button id="btn-search" type="button" class="btn btn-info btn-sm">
										<i class="icon-search icon-on-right bigger-110"></i>
										查询
									</button>
									&nbsp;
									<button id="export" type="button" class="btn btn-success btn-sm">
										<i class="icon-download-alt icon-on-right bigger-110"></i>
										导出
									</button>
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
	var form_search = "#form-search";
	var isEdit = false;
	<shiro:hasPermission name="dict:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			url: "<c:url value='/user/userDemo/search'/>",
			editurl: "<c:url value='/user/userDemo/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'loginAcct', index:'loginAcct', label:'用户账号', width:80},
				{name:'userName', index:'userName', label:'用户名', width:80},
				{name:'password', index:'password', label:'密码', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'empCode', index:'empCode', label:'工号', width:80},
				{name:'compCode', index:'compCode', label:'所属公司', width:80},
				{name:'email', index:'email', label:'邮件地址', width:80},
				{name:'status', index:'status', label:'状态', width:80, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('COMPANY_STATUS')}"}},
				{name:'type', index:'type', label:'类型', width:80},
				{name:'description', index:'description', label:'描述', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'lastUpdater.id', index:'lastUpdater.id', label:'最后修改人', width:80, editoptions:{readonly:"true"}},
				{name:'lastUpdateTime', index:'lastUpdateTime', label:'最后修改时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions:{readonly:"true"}},
				{name:'defautRole', index:'defautRole', label:'默认角色', width:80, hidden: true, editrules:{edithidden:true}}
			]
		},{
			add:isEdit,
			addfunc:addfunc,
			edit:isEdit,
			editfunc:editfunc,
			del:isEdit
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		$("#export").click(function(){
		    var curNum=$(grid_selector).getGridParam("records");
		    if(curNum==0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/user/userDemo/export'/>"});
	    			}
	    		});
	        }
		});
		
		//编辑表点击保存按钮的时候调用的方法
		/*
		var lastSel = $(grid_selector).getGridParam('selrow');
			$(grid_selector).saveRow(lastSel, false, 'clientArray');
		*/
		
		//获得编辑表值
		/*
		var dd = $(grid_selector).getRowData();
		*/
		
	});
	
	//add
	function addfunc(){
		location.href = "<c:url value='/user/userDemo/form'/>";
	}
	
	//edit
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		location.href = "<c:url value='/user/userDemo/form'/>" + "?id=" + selr;
	}
</script>
</html>