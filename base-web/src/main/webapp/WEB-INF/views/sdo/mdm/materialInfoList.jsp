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
						&nbsp;
						<button id="btn-tbwlxx" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							同步
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料编号&nbsp;&nbsp;</label>
										<input type="text" name="wlbh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料类型&nbsp;&nbsp;</label>
										<input type="text" name="wllx" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料组&nbsp;&nbsp;</label>
										<input type="text" name="wlz" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料短描述（中文）&nbsp;&nbsp;</label>
										<input type="text" name="wldmszw" class="form-control"/>
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
	<shiro:hasPermission name="mdm:materialInfo:edit">isEdit=true;</shiro:hasPermission>
	$(".skyselect").select2();
	$(function($) {
		$(grid_selector).bindTable({
			url: "<c:url value='/mdm/materialInfo/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen : true},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:150, formoptions:{rowpos: 2, colpos: 1}, frozen : true},
				{name:'wlz', index:'wlz', label:'物料组', width:80, formoptions:{rowpos: 2, colpos: 2}, frozen : true},
				{name:'wllx', index:'wllx', label:'物料类型', width:80, formoptions:{rowpos: 3, colpos: 1}, frozen : true},
				{name:'mpq', index:'mpq', label:'最小包装量MPQ',align:'right', width:100, formoptions:{rowpos: 3, colpos: 2},
					 align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'wldmszw', index:'wldmszw', label:'物料短描述（中文）', width:130, formoptions:{rowpos: 4, colpos: 1}},
				{name:'wldmsyw', index:'wldmsyw', label:'物料短描述（英文）', width:130, formoptions:{rowpos: 4, colpos: 2}},
				{name:'wlms', index:'wlms', label:'物料描述（英文）', width:120, formoptions:{rowpos: 5, colpos: 1}},
				{name:'ggcc', index:'ggcc', label:'规格尺寸', width:80, formoptions:{rowpos: 5, colpos: 2}},
				{name:'cpdl', index:'cpdl', label:'成品大类', width:80, formoptions:{rowpos: 6, colpos: 1}},
				{name:'cpzl', index:'cpzl', label:'成品中类', width:80, formoptions:{rowpos: 6, colpos: 2}},
				{name:'cpxl', index:'cpxl', label:'成品小类', width:80, formoptions:{rowpos: 7, colpos: 1}},
				{name:'wldw', index:'wldw', label:'物料单位', width:80, formoptions:{rowpos: 7, colpos: 2}},
				{name:'wlzt', index:'wlzt', label:'物料状态', width:80, formoptions:{rowpos: 8, colpos: 1}},
				{name:'sjc', index:'sjc', label:'时间戳', width:80,hidden:true}
			],
			sortname: 'wlbh',
			sortorder: 'asc'
		},{
			add:false,
			edit:false,
			del:false
		}).jqGrid('setFrozenColumns');
	
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/materialInfo/export'/>"});
	    			}
	    		});
	        }
		});
		
		$("#btn-tbwlxx").click(function(){
        	$("body").bindSweetAlert({
    			title:"确定要同步吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$.bindAjax({
						url:"<c:url value='/mdm/materialInfo/tbwlxx'/>",
						action:"edit"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
    			}
    		});
		});
		
		
	});
</script>
</html>