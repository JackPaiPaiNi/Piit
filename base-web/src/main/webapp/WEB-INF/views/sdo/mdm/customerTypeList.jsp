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
										<label class="input-group-btn">客户编码&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">客户名称&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">客户分类&nbsp;&nbsp;</label>
										<select role="select" name="khfl" size="1" class="form-control skyselect">
											${fns:loadDictOption('KHFL')}
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
	var form_search = "#form-search";
	var isEdit = false;
	<shiro:hasPermission name="mdm:customerType:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/mdm/customerType/search'/>",
			editurl: "<c:url value='/mdm/customerType/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'kh', index:'kh', label:'客户编码', width:80,editoptions : {dataInit : InitKh}},
				{name:'khbm', index:'khbm', label:'客户编码', width:80, hidden: true},
				{name:'khmc', index:'khmc', label:'客户名称', width:150,},
				{name:'khfl', index:'khfl', label:'客户分类', width:100, edittype:"select", formatter:"select",
					editoptions:{value:"${fns:loadDictEditOption('KHFL')}", dataInit:initSelect2}},
				//{name:'khflmc', index:'khflmc', label:'客户分类名称', width:90, editable:false},
				{name:'zt', index:'zt', label:'状态', width:50, edittype:"select",formatter: "select",
					editoptions:{value:"5:启用;1:草稿", dataInit:initSelect2}},
				{name:'zdrid', index:'zdrid', label:'创建人', width:80, editable:false},
				{name:'zdrmc', index:'zdrmc', label:'创建人名称', width:80, editable:false},
				{name:'zdsj', index:'zdsj', label:'创建时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions:{readonly:"true"}},
				{name:'bzxx', index:'bzxx', label:'备注', width:100}
			]
		},{
			add:isEdit,
			edit:isEdit,
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/customerType/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	//客户选择
	function InitKh(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title:"客户选择",
				searchCond:[{"name":"客户","value":"khbm"},
				            {"name":"客户类型","value":"khlx"}],
				colModel:[{name:'id', index:'id', label:'ID',hidden:true}, 
				          {name:'khbm', index:'khbm', label:'客户编码', width:60},
			 	          {name:'khmc', index:'khmc', label:'客户名称', width:80}, 
						  {name:'khlx', index:'khlx', label:'客户类型', width:60},
						  {name:'fktjms', index:'fktjms', label:'付款条件', width:120}],
				url:"<c:url value='/pub/widget/findCust'/> "
			},{
				callback:function(rows){
					if(rows){
						$(elem).closest("form").find("input[name='khbm']").val(rows.khbm);
						$(elem).closest("form").find("input[name='khmc']").val(rows.khmc);
						$(elem).val(rows.khbm);
					}else{
						$(elem).closest("form").find("input[name='khbm']").val("");
						$(elem).closest("form").find("input[name='khmc']").val("");
						$(elem).val("");
					}
				}
			});
		});
	}
	
	function initSelect2(elem){
		$(elem).width(140).select2();
	}
</script>
</html>