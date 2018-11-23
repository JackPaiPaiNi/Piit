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
										<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">合同类型&nbsp;&nbsp;</label>
										<select role="select" name="htlx" size="1" class="form-control skyselect">
											${fns:loadDictOption('HTLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
										<input type="text" name="fqrmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">创建日期&nbsp;&nbsp;</label>
										<input type="text" name="fqrq" class="form-control timeInterval"/>
										<input type="hidden" id="beginFqrq" name="beginFqrq"/>
										<input type="hidden" id="endFqrq" name="endFqrq"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
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
	<shiro:hasPermission name="mdm:contract:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginFqrq"),endElement:$("#endFqrq")});
		$(grid_selector).bindTable({
			url: "<c:url value='/mdm/contract/search'/>",
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
				{name:'htbh', index:'htbh', label:'合同编号', width:160, frozen : true},
				{name:'khbm', index:'khbm', label:'客户编码', width:80, frozen : true},
				{name:'khmc', index:'khmc', label:'客户名称', width:180, frozen : true},
				{name:'khdz', index:'khdz', label:'客户地址', width:220},
				{name:'htlx', index:'htlx', label:'合同类型', width:180, edittype:"select", formatter:"select", 
					editoptions:{value:"${fns:loadDictEditOption('HTLX')}"}},
				{name:'fqrmc', index:'fqrmc', label:'销售员', width:180},
				{name:'fktjmc', index:'fktjmc', label:'付款条件', width:180},
				{name:'fqrq', index:'fqrq', label:'创建日期', width:180, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			],
			sortname: 'htbh',
			sortorder: 'asc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
			addfunc:addfunc,
			editfunc: editfunc,
			delfunc:delfunc,
			viewfunc:viewfunc
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/contract/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	//新增
	function addfunc(){
		location.href ="<c:url value='/mdm/contract/editPage'/>"+"?oper=add";
	}
	 //编辑
	function editfunc(){
		 var id = $(grid_selector).jqGrid('getGridParam', 'selrow');
		 location.href = "<c:url value='/mdm/contract/editPage'/>?id=" + id;
	} 
	//查看
	function viewfunc(){
		var id = $(grid_selector).jqGrid('getGridParam', 'selrow');
		location.href = "<c:url value='/mdm/contract/viewPage'/>?id="+ id;
	}
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			$("body").bindSweetAlert({
    			title:"确定要删除吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$.bindAjax({
    					url:"<c:url value='/mdm/contract/delete'/>",
    					data:{id:rowData.id},
    					action:"edit"
    				},function(response){
    					$(grid_selector).trigger("reloadGrid");
    				}); 
    			}
    		});
		}
	}
</script>
</html>