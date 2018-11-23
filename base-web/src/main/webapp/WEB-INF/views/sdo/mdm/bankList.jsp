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
										<label class="input-group-addon">中文名称&nbsp;&nbsp;</label>
										<input type="text" name="zwmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">英文名称&nbsp;&nbsp;</label>
										<input type="text" name="ywmc" class="form-control"/>
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
	<shiro:hasPermission name="mdm:bank:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/mdm/bank/search'/>",
			editurl: "<c:url value='/mdm/bank/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:80, editable:false, frozen : true},
				{name:'zwmc', index:'zwmc', label:'中文名称', width:120, formoptions:{rowpos: 1, colpos: 1}, frozen : true},
				{name:'ywmc', index:'ywmc', label:'英文名称', width:160, formoptions:{rowpos: 1, colpos: 2}},
				{name:'zwdz', index:'zwdz', label:'中文地址', width:160, formoptions:{rowpos: 1, colpos: 3}},
				{name:'ywdz', index:'ywdz', label:'英文地址', width:200, formoptions:{rowpos: 2, colpos: 1}},
				{name:'swiftdm', index:'swiftdm', label:'SWIFT代码', width:100, formoptions:{rowpos: 2, colpos: 2}},
				{name:'sfKhkzh', index:'sfKhkzh', label:'是否客户开证行', width:100, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('SF')}"}, formoptions:{rowpos: 2, colpos: 3}},
				{name:'bzxx', index:'bzxx', label:'备注', width:120, formoptions:{rowpos: 3, colpos: 1}}
			],
		
			sortorder: 'asc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit
		}).jqGrid('setFrozenColumns');
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/bank/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
</script>
</html>