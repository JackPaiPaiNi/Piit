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
										<label class="input-group-addon">总部型号&nbsp;&nbsp;</label>
										<input type="text" name="zbxh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">分公司型号&nbsp;&nbsp;</label>
										<input type="text" name="fgsxh" class="form-control"/>
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
	var editurl = "<c:url value='/fcst/fcstBranchData/editModelChart'/>";
	var isEdit = false;
	<shiro:hasPermission name="fcst:fcstBranchData:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/fcst/fcstBranchData/searchModelChart'/>",
			editurl: "<c:url value='/fcst/fcstBranchData/editModelChart'/>",
			pager: pager_selector,
			gridParent:"#grid-parent",
			formSearch:"#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, formoptions:{rowpos: 1, colpos: 1}},
				{name:'zbxh', index:'zbxh',label:'总部型号', width:120, formoptions:{rowpos: 2, colpos: 1}},
				{name:'fgsxh', index:'fxgxh', label:'分公司型号', width:120, formoptions:{rowpos: 2, colpos: 2}},
				{name:'cc', index:'cc', label:'尺寸', width:60, formoptions:{rowpos: 2, colpos: 3}},
				{name:'zdrmc', index:'zdrmc', label:'创建人', width:120, editable:false},
				{name:'zdsj', index:'zdsj', label:'创建时间', width:120, editable:false},
				{name:'sjc', index:'sjc', label:'时间戳',editoptions : {disabled:true}}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit
		});
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		//新增
		function addfunc(){
			location.href = editurl;
		}
		
		//编辑
		function editfunc(){
			var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			location.href = editurl + "?id=" + selr;
		}
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstBranchData/exportBranchModel'/>"});
	    			}
	    		});
	        }
		});
		
	});
</script>
</html>