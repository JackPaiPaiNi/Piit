<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<%@page import="com.ey.piit.core.utils.UserUtils"%>  
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
	   String zdrid = UserUtils.getUser().getEmpCode();
	%>
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
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control smaller"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料编号&nbsp;&nbsp;</label>
										<input type="text" name="wlbh" class="form-control"/>
									</div>
								</div>
							</div>
						</form>
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
	var searchurl= "<c:url value='/price/shippingsheet/search'/>";
	var editurl = "<c:url value='/price/shippingsheet/editPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="price:shippingsheet:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			caption: "",
			url: searchurl,
			editurl: editurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			sortname:'zdsj',
			sortorder:'desc',
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'sjc', label:'SJC', hidden: true, width:60, editable:false},
				{name:'zt', index:'zt', label:'状态', hidden:true},
				{name:'drdh', index:'drdh', label:'导入单号', hidden:true},
				{name:'ddid', index:'ddid', label:'订单号', width:140},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:180},
				{name:'bz', index:'bz', label:'币种', width:60},
			    {name:'dj', index:'dj', label:'单价', align:'right', width:100, formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'dw', index:'dw', label:'单位', width:80},
				{name:'ztmc', index:'ztmc', label:'状态', width:80},
				{name:'zdsj', index:'zdsj', label:'导入时间', width:90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zdrmc', index:'zdrmc', label:'操作人', width:80}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:false,
			view:false,
			addfunc:addfunc,
			editfunc: editfunc
		});
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		$("body").keypress(function (e) {
			var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if (keyCode == 13){
				$(grid_selector).trigger("reloadGrid");
			}
		});
	});
	
	//新增
	function addfunc(){
		location.href = editurl;
	}
	
	//编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		location.href = editurl + "?drdh=" + rowData.drdh;
	}
</script>
</html>