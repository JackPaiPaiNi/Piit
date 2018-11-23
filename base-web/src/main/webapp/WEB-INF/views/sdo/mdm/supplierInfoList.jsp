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
						<button id="btn-tbgys" type="button" class="btn btn-success btn-minier bigger">
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
										<label class="input-group-addon">供应商编码&nbsp;&nbsp;</label>
										<input type="text" name="gysbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">供应商名称&nbsp;&nbsp;</label>
										<input type="text" name="gysmc" class="form-control"/>
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
	var isEdit = false;
	<shiro:hasPermission name="mdm:supplierInfo:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			url: "<c:url value='/mdm/supplierInfo/search'/>",
			editurl: "<c:url value='/mdm/supplierInfo/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, formoptions:{rowpos: 1, colpos: 1}, frozen : true},
				{name:'gysbm', index:'gysbm', label:'供应商编码', width:80, formoptions:{rowpos: 2, colpos: 1}, frozen : true},
				{name:'gysmc', index:'gysmc', label:'供应商名称', width:200, formoptions:{rowpos: 2, colpos: 2}, frozen : true},
				{name:'gysjc', index:'gysjc', label:'供应商简称', width:100, formoptions:{rowpos: 2, colpos: 3}},
				{name:'gsbm', index:'gsbm', label:'公司编码', width:80, formoptions:{rowpos: 3, colpos: 1}},
				{name:'dz', index:'dz', label:'地址', width:250, formoptions:{rowpos: 3, colpos: 2}},
				{name:'bz', index:'bz', label:'币种', width:80, formoptions:{rowpos: 3, colpos: 3}},
				{name:'dh', index:'dh', label:'电话', width:120, formoptions:{rowpos: 4, colpos: 1}},
				{name:'wz', index:'wz', label:'网址', width:120, formoptions:{rowpos: 4, colpos: 2}},
				{name:'lxr', index:'lxr', label:'联系人', width:80, formoptions:{rowpos: 4, colpos: 3}},
				{name:'sjh', index:'sjh', label:'手机号', width:120, formoptions:{rowpos: 5, colpos: 1}},
				{name:'yx', index:'yx', label:'邮箱', width:120, formoptions:{rowpos: 5, colpos: 2}},
				{name:'bzxx', index:'bzxx', label:'备注', width:180, formoptions:{rowpos: 5, colpos: 3}},
				{name:'zt',index:'zt',label:'状态',width:80, edittype:"select",formatter: "select",
					editoptions:{value:"1:启用;0:禁用"}, formoptions:{rowpos: 6, colpos: 1}}
			],
			sortname: 'gysbm',
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/supplierInfo/export'/>"});
	    			}
	    		});
	        }
		});
		//同步供应商数据
		$("#btn-tbgys").click(function(){
        	$("body").bindSweetAlert({
    			title:"确定要同步吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$.bindAjax({
						url:"<c:url value='/mdm/supplierInfo/tbgys'/>",
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