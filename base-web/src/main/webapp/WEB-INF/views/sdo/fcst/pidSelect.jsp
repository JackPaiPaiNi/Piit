<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%> 
<style type="text/css">
	html{
		position:static;
	}
</style>
</head>
<body>
	<div class="page-content">
		<div class="row">
				<!-- PAGE CONTENT BEGINS -->
				<div   class="widget-box">
					<div class="widget-header header-color-blue2">
						<h5>查询条件</h5>
						<span class="widget-toolbar"> <a href="#"
							data-action="collapse"> <i class="icon-chevron-up"></i>
						</a>
						</span>
						<div class="widget-toolbar no-border">
							<button id="btn-search" type="button" class="btn btn-info btn-xs">
								<i class="icon-search icon-on-right"></i> 查询
							</button>
						</div>
						<div class="widget-toolbar no-border">
							<button id="btn-confirm" type="button" class="btn btn-danger btn-xs">
								<i class="icon-ok icon-on-right"></i> 确认
							</button>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<form id="form-search" class="form-search">
								<div class="row">
								    <div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">型号&nbsp;&nbsp;</label> <input
												type="text" name="jixing" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">PID&nbsp;&nbsp;</label> 
											<input type="text" name="pid" class="form-control" />
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div id="grid-parent" class="col-xs-12">
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
				</div>
				<div class="space-4"></div>
				<h5 class="header blue" style="margin-top:4px;">订单确认信息</h5>
				<div class="space-4"></div>
				<div id="grid-parent-confirm" class="col-xs-12">
				<table id="grid-table-confirm"></table>
				<div id="grid-pager-confirm"></div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
</body>
<script type="text/javascript">
	
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	
	var grid_selector_confirm = "#grid-table-confirm";
	var pager_selector_confirm = "#grid-pager-confirm";
	
	var isEdit = false;
	<shiro:hasPermission name="pso:view">isEdit = false;</shiro:hasPermission>
	/******************************页面控件加载开始***************************************************/
		$(function($) {
			$(grid_selector).bindTable({
				url: "<c:url value='/mdm/pidInfo/search'/>?zt=5",
				pager: pager_selector,
				gridParent: "#grid-parent",
				formSearch: "#form-search",
				shrinkToFit: false,
				multiselect:true,
				autoScroll: false,
				colModel: [
					{name:'id', label:'ID', hidden: true, width:60, editable:false},
					{name:'pid', index:'pid', label:'PID', width:120},
					{name:'jixin', index:'jixin', label:'机芯', width:120},
					{name:'jixing', index:'jixing', label:'机型', width:120},
					{name:'cc', index:'cc', label:'尺寸', width:120},
					{name:'zhfsmc', index:'zhfsmc', label:'走货方式名称', width:120},
					{name:'zdrmc', index:'zdrmc', label:'创建人名称', width:180},
					{name:'cjsj', index:'cjsj', label:'创建时间', width:180, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'zt',index:'zt',label:'状态',width:180, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('DJZT')}"}},
					{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:120}
				],
				onSelectRow:function(rowid,status){
					 var row = $(grid_selector).jqGrid("getRowData",rowid);
					 //是否已经添加标志
					 var  flag = false ;
					 //如果是选中
					 var datas = $(grid_selector_confirm).jqGrid('getRowData');
					 if(status){
						 $.each(datas,function(index,rowData){
							 if(rowData.jixing == row.jixing){
								 flag = true  ;
								 return false ;
							 }
						 }) ;
						 //如果是新的一行，添加到下表
						 if(!flag){
							 var rowData = $(grid_selector).jqGrid("getRowData",rowid);
							 $(grid_selector_confirm).jqGrid("addRowData",null,rowData,"last");
						 } 
					 }
				}
			},{
				add:false,
				edit:false,
				del:false
			});
			$(grid_selector_confirm).bindTable({
				//url: "<c:url value='/mdm/pidInfo/search'/>?zt=5",
				pager: pager_selector_confirm,
				gridParent: "#grid-parent_confirm",
				shrinkToFit: false,
				autoScroll: false,
				colModel: [
					{name:'id', label:'ID', hidden: true, width:60, editable:false},
					{name:'pid', index:'pid', label:'PID', width:120},
					{name:'jixin', index:'jixin', label:'机芯', width:120},
					{name:'jixing', index:'jixing', label:'机型', width:120},
					{name:'cc', index:'cc', label:'尺寸', width:120},
					{name:'zhfsmc', index:'zhfsmc', label:'走货方式名称', width:120},
					{name:'zdrmc', index:'zdrmc', label:'创建人名称', width:180},
					{name:'cjsj', index:'cjsj', label:'创建时间', width:180, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'zt',index:'zt',label:'状态',width:180, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('DJZT')}"}},
					{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:120}
				]
			},{
				add:false,
				edit:false,
				del:true
			});
			
			// 查询
			$("#btn-search").click(function() {
				$(grid_selector).trigger("reloadGrid");
			});
			//确认按钮
			$('#btn-confirm').click(function(){
				confirm();
		    });
			
		});
	//确认
	function confirm(){
		var data = $(grid_selector_confirm).jqGrid('getRowData');
	    if(data.length ==0){
			swal("", "请选择数据！", "warning");
			return;
		}
	    // 关闭当前窗口
		window.close();
		// 确定后的回调处理
		if(window.showModalDialog){//支持showModalDialog函数
			window.returnValue = data;
		}else{//新版chrome不支持showModalDialog函数
			if(window.openerCallBack && typeof(window.openerCallBack) === "function"){
				// 调用父窗口的方法
				window.openerCallBack(data);
			}
		}
	}
</script>
</html>