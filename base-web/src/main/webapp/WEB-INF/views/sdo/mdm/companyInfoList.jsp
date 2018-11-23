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
						&nbsp;
						<button id="export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">公司编码&nbsp;&nbsp;</label>
										<input type="text" name="gsbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">公司中文名称&nbsp;&nbsp;</label>
										<input type="text" name="gszwmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">公司英文名称&nbsp;&nbsp;</label>
										<input type="text" name="gsywmc" class="form-control"/>
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
	var form_search = "#form-search";
	var isEdit = false;
	<shiro:hasPermission name="mdm:companyInfo:edit">isEdit=true;</shiro:hasPermission>
	$(function($) {
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/mdm/companyInfo/search'/>",
			editurl: "<c:url value='/mdm/companyInfo/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false/* , frozen : true */},
				{name:'gsbm', index:'gsbm', label:'公司编码', width:80/* , frozen : true */},
				{name:'sapgsdm', index:'sapgsdm', label:'SAP公司代码', width:90/* , frozen : true */},
				{name:'gszwmc', index:'gszwmc', label:'公司中文名称', width:180/* , frozen : true */},
				{name:'gsywmc', index:'gsywmc', label:'公司英文名称', width:280},
				{name:'gszwdz', index:'gszwdz', label:'公司中文地址', width:280},
				{name:'gsywdz', index:'gsywdz', label:'公司英文地址', width:280},
				{name:'bz', index:'bz', label:'备注', width:170}
			],
			sortname: 'gsbm',
			sortorder: 'asc',
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			addfunc:addfunc,
			editfunc:editfunc,
			viewfunc:viewfunc
		})/* .jqGrid('setFrozenColumns') */;
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/companyInfo/export'/>"});
	    			}
	    		});
	        }
		});
	});
	//新增
	function addfunc(){
		location.href ="<c:url value='/mdm/companyInfo/editPage'/>"+"?oper=add";
	}
	 //编辑
	function editfunc(){
		 var id = $(grid_selector).jqGrid('getGridParam', 'selrow');
		 location.href = "<c:url value='/mdm/companyInfo/editPage'/>?id=" + id;
	} 
	//查看
	function viewfunc(){
		var id = $(grid_selector).jqGrid('getGridParam', 'selrow');
		location.href = "<c:url value='/mdm/companyInfo/editPage'/>?id="+ id;
	} 
</script>
</html>