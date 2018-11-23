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
										<label class="input-group-addon">公司名称&nbsp;&nbsp;</label>
										<input type="text" name="gsmc" class="form-control"/>
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
	<shiro:hasPermission name="mdm:shippingCompany:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/mdm/shippingCompany/search'/>",
			editurl: "<c:url value='/mdm/shippingCompany/edit'/>",
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
				{name:'gsbm', index:'gsbm', label:'公司编码', width:120, formoptions:{rowpos: 2, colpos: 1}, frozen : true},
				{name:'gsmc', index:'gsmc', label:'公司名称', width:140, formoptions:{rowpos: 2, colpos: 2}, frozen : true},
				{name:'zt',index:'zt',label:'状态',width:60, edittype:"select",formatter: "select",
					editoptions:{value:"1:启用;0:禁用"}, formoptions:{rowpos: 5, colpos: 1}},
				{name:'lxr', index:'lxr', label:'联系人', width:120, formoptions:{rowpos: 2, colpos: 3}},
				{name:'dh', index:'dh', label:'电话', width:120, formoptions:{rowpos: 3, colpos: 1}},
				{name:'cz', index:'cz', label:'传真', width:120, formoptions:{rowpos: 3, colpos: 2}},
				{name:'yb', index:'yb', label:'邮编', width:120, formoptions:{rowpos: 3, colpos: 3}},
				{name:'yx', index:'yx', label:'邮箱', width:120, formoptions:{rowpos: 4, colpos: 1}},
				{name:'dz', index:'dz', label:'地址', width:170, formoptions:{rowpos: 4, colpos: 2}},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:180, formoptions:{rowpos: 4, colpos: 3}}
			],
			sortname: 'gsbm',
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/shippingCompany/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
</script>
</html>